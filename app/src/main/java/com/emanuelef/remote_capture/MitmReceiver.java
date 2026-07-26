package com.emanuelef.remote_capture;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.LruCache;
import android.util.SparseArray;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.emanuelef.remote_capture.interfaces.ConnectionsListener;
import com.emanuelef.remote_capture.interfaces.MitmListener;
import com.emanuelef.remote_capture.model.CaptureSettings;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.PayloadChunk;
import com.emanuelef.remote_capture.model.Prefs;
import com.pcapdroid.mitm.MitmAPI;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
/* loaded from: classes.dex */
public class MitmReceiver implements Runnable, ConnectionsListener, MitmListener {
    private static final String TAG = "MitmReceiver";
    public static final int TLS_DECRYPTION_PROXY_PORT = 7780;
    private static final MutableLiveData proxyStatus = new LiveData(Status.NOT_STARTED);
    private final MitmAddon mAddon;
    private final MitmAPI.MitmConfig mConfig;
    private final Context mContext;
    private BufferedOutputStream mKeylog;
    private final boolean mPcapngFormat;
    private final boolean mRootCapture;
    private ParcelFileDescriptor mSocketFd;
    private Thread mThread;
    private final LruCache<Integer, Integer> mPortToConnId = new LruCache<>(64);
    private final SparseArray<ArrayList<PendingMessage>> mPendingMessages = new SparseArray<>();
    private final ConnectionsRegister mReg = CaptureService.requireConnsRegister();

    /* loaded from: classes.dex */
    public enum MsgType {
        UNKNOWN,
        RUNNING,
        TLS_ERROR,
        HTTP_ERROR,
        HTTP_REQUEST,
        HTTP_REPLY,
        TCP_CLIENT_MSG,
        TCP_SERVER_MSG,
        TCP_ERROR,
        WEBSOCKET_CLIENT_MSG,
        WEBSOCKET_SERVER_MSG,
        DATA_TRUNCATED,
        MASTER_SECRET,
        LOG,
        JS_INJECTED
    }

    /* loaded from: classes.dex */
    public static class PendingMessage {
        byte[] msg;
        long pendingSince = SystemClock.elapsedRealtime();
        int port;
        MsgType type;
        long when;

        public PendingMessage(MsgType msgType, byte[] bArr, int i, long j) {
            this.type = msgType;
            this.msg = bArr;
            this.port = i;
            this.when = j;
        }
    }

    /* loaded from: classes.dex */
    public enum Status {
        NOT_STARTED,
        STARTING,
        START_ERROR,
        RUNNING
    }

    public MitmReceiver(Context context, CaptureSettings captureSettings, String str) {
        boolean z;
        this.mContext = context;
        this.mAddon = new MitmAddon(context, this);
        this.mPcapngFormat = captureSettings.pcapng_format;
        this.mRootCapture = captureSettings.root_capture;
        MitmAPI.MitmConfig mitmConfig = new MitmAPI.MitmConfig();
        this.mConfig = mitmConfig;
        mitmConfig.proxyPort = TLS_DECRYPTION_PROXY_PORT;
        mitmConfig.proxyAuth = str;
        if (CaptureService.getDumpMode() != Prefs.DumpMode.NONE) {
            z = true;
        } else {
            z = false;
        }
        mitmConfig.dumpMasterSecrets = z;
        mitmConfig.additionalOptions = captureSettings.mitmproxy_opts;
        mitmConfig.shortPayload = !captureSettings.full_payload;
        mitmConfig.sslInsecure = true;
        mitmConfig.transparentMode = captureSettings.root_capture;
        getKeylogFilePath(context).delete();
    }

    private synchronized void addPendingMessage(PendingMessage pendingMessage) {
        ArrayList<PendingMessage> arrayList;
        ArrayList<PendingMessage> valueAt;
        try {
            if (this.mPendingMessages.size() > 32) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                for (int size = this.mPendingMessages.size() - 1; size >= 0; size--) {
                    if (elapsedRealtime - this.mPendingMessages.valueAt(size).get(0).pendingSince > 5000) {
                        Log.m581w(TAG, "Dropping " + valueAt.size() + " old messages");
                        SparseArray<ArrayList<PendingMessage>> sparseArray = this.mPendingMessages;
                        sparseArray.remove(sparseArray.keyAt(size));
                    }
                }
            }
            int indexOfKey = this.mPendingMessages.indexOfKey(pendingMessage.port);
            if (indexOfKey < 0) {
                arrayList = new ArrayList<>();
                this.mPendingMessages.put(pendingMessage.port, arrayList);
            } else {
                arrayList = this.mPendingMessages.valueAt(indexOfKey);
            }
            arrayList.add(pendingMessage);
        } catch (Throwable th) {
            throw th;
        }
    }

    private PayloadChunk.ChunkType getChunkType(MsgType msgType) {
        int ordinal = msgType.ordinal();
        if (ordinal == 4 || ordinal == 5) {
            return PayloadChunk.ChunkType.HTTP;
        }
        if (ordinal == 9 || ordinal == 10) {
            return PayloadChunk.ChunkType.WEBSOCKET;
        }
        return PayloadChunk.ChunkType.RAW;
    }

    public static File getKeylogFilePath(Context context) {
        return new File(context.getCacheDir(), "SSLKEYLOG.txt");
    }

    private void handleLog(byte[] bArr) {
        try {
            String str = new String(bArr, StandardCharsets.US_ASCII);
            if (str.length() >= 3) {
                Log.level(Log.MITMADDON_LOGGER, Integer.parseInt(str.substring(0, 1)), str.substring(2));
            }
        } catch (NumberFormatException unused) {
        }
    }

    private void handleMessage(ConnectionDescriptor connectionDescriptor, MsgType msgType, byte[] bArr, long j) {
        if (msgType == MsgType.TLS_ERROR || msgType == MsgType.HTTP_ERROR || msgType == MsgType.TCP_ERROR) {
            connectionDescriptor.decryption_error = new String(bArr, StandardCharsets.US_ASCII);
            if (connectionDescriptor.status == 3) {
                connectionDescriptor.status = 6;
            }
            HttpLog httpLog = CaptureService.getHttpLog();
            if (httpLog != null) {
                httpLog.addDecryptionError(connectionDescriptor, j, connectionDescriptor.decryption_error);
            }
        } else if (msgType == MsgType.DATA_TRUNCATED) {
            connectionDescriptor.setPayloadTruncatedByAddon();
        } else if (msgType == MsgType.JS_INJECTED) {
            connectionDescriptor.js_injected_scripts = new String(bArr, StandardCharsets.US_ASCII);
        } else {
            connectionDescriptor.addPayloadChunkMitm(new PayloadChunk(bArr, getChunkType(msgType), isSent(msgType), j, 0));
        }
    }

    private boolean isSent(MsgType msgType) {
        int ordinal = msgType.ordinal();
        if (ordinal == 4 || ordinal == 6 || ordinal == 9) {
            return true;
        }
        return false;
    }

    private void logMasterSecret(byte[] bArr) {
        if (!this.mRootCapture) {
            if (this.mPcapngFormat) {
                CaptureService.dumpMasterSecret(bArr);
                return;
            }
            if (this.mKeylog == null) {
                this.mKeylog = new BufferedOutputStream(this.mContext.getContentResolver().openOutputStream(Uri.fromFile(getKeylogFilePath(this.mContext)), "rwt"));
            }
            this.mKeylog.write(bArr);
            this.mKeylog.write(10);
        }
    }

    public static void observeStatus(LifecycleOwner lifecycleOwner, Observer observer) {
        proxyStatus.observe(lifecycleOwner, observer);
    }

    private static MsgType parseMsgType(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1483104249:
                if (str.equals("tcp_err")) {
                    c = 0;
                    break;
                }
                break;
            case -1222671327:
                if (str.equals("tls_err")) {
                    c = 1;
                    break;
                }
                break;
            case -906277200:
                if (str.equals("secret")) {
                    c = 2;
                    break;
                }
                break;
            case -893067137:
                if (str.equals("tcp_climsg")) {
                    c = 3;
                    break;
                }
                break;
            case -429072312:
                if (str.equals("tcp_srvmsg")) {
                    c = 4;
                    break;
                }
                break;
            case -428224220:
                if (str.equals("ws_climsg")) {
                    c = 5;
                    break;
                }
                break;
            case -132760274:
                if (str.equals("http_err")) {
                    c = 6;
                    break;
                }
                break;
            case -132748186:
                if (str.equals("http_rep")) {
                    c = 7;
                    break;
                }
                break;
            case -132748185:
                if (str.equals("http_req")) {
                    c = '\b';
                    break;
                }
                break;
            case 107332:
                if (str.equals("log")) {
                    c = '\t';
                    break;
                }
                break;
            case 35770605:
                if (str.equals("ws_srvmsg")) {
                    c = '\n';
                    break;
                }
                break;
            case 110640556:
                if (str.equals("trunc")) {
                    c = 11;
                    break;
                }
                break;
            case 1550783935:
                if (str.equals("running")) {
                    c = '\f';
                    break;
                }
                break;
            case 1767490887:
                if (str.equals("js_inject")) {
                    c = '\r';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return MsgType.TCP_ERROR;
            case 1:
                return MsgType.TLS_ERROR;
            case 2:
                return MsgType.MASTER_SECRET;
            case 3:
                return MsgType.TCP_CLIENT_MSG;
            case 4:
                return MsgType.TCP_SERVER_MSG;
            case 5:
                return MsgType.WEBSOCKET_CLIENT_MSG;
            case 6:
                return MsgType.HTTP_ERROR;
            case 7:
                return MsgType.HTTP_REPLY;
            case '\b':
                return MsgType.HTTP_REQUEST;
            case '\t':
                return MsgType.LOG;
            case '\n':
                return MsgType.WEBSOCKET_SERVER_MSG;
            case 11:
                return MsgType.DATA_TRUNCATED;
            case '\f':
                return MsgType.RUNNING;
            case '\r':
                return MsgType.JS_INJECTED;
            default:
                return MsgType.UNKNOWN;
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsAdded(int i, ConnectionDescriptor[] connectionDescriptorArr) {
        synchronized (this) {
            try {
                for (ConnectionDescriptor connectionDescriptor : connectionDescriptorArr) {
                    this.mPortToConnId.put(Integer.valueOf(connectionDescriptor.local_port), Integer.valueOf(connectionDescriptor.incr_id));
                    int indexOfKey = this.mPendingMessages.indexOfKey(connectionDescriptor.local_port);
                    if (indexOfKey >= 0) {
                        ArrayList<PendingMessage> valueAt = this.mPendingMessages.valueAt(indexOfKey);
                        this.mPendingMessages.removeAt(indexOfKey);
                        int size = valueAt.size();
                        int i2 = 0;
                        while (i2 < size) {
                            int i3 = i2 + 1;
                            PendingMessage pendingMessage = valueAt.get(i2);
                            try {
                                handleMessage(connectionDescriptor, pendingMessage.type, pendingMessage.msg, pendingMessage.when);
                                i2 = i3;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsChanges(int i) {
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsRemoved(int i, ConnectionDescriptor[] connectionDescriptorArr) {
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsUpdated(int[] iArr) {
    }

    public ConnectionDescriptor getConnByLocalPort(int i) {
        Integer num;
        ConnectionDescriptor connById;
        synchronized (this) {
            num = this.mPortToConnId.get(Integer.valueOf(i));
        }
        if (num == null || (connById = this.mReg.getConnById(num.intValue())) == null || connById.local_port != i) {
            return null;
        }
        return connById;
    }

    public Status getProxyStatus() {
        Object obj = proxyStatus.mData;
        if (obj == LiveData.NOT_SET) {
            obj = null;
        }
        return (Status) obj;
    }

    @Override // com.emanuelef.remote_capture.interfaces.MitmListener
    public void onMitmGetCaCertificateResult(String str) {
        if (MitmAddon.isCAInstallationSkipped(this.mContext) || Utils.isCAInstalled(str)) {
            ParcelFileDescriptor startProxy = this.mAddon.startProxy(this.mConfig);
            this.mSocketFd = startProxy;
            if (startProxy == null) {
                this.mAddon.disconnect();
                return;
            }
            if (MitmAddon.isDozeEnabled(this.mContext)) {
                Utils.showToastLong(this.mContext, C0130R.string.mitm_doze_notice, new Object[0]);
                this.mAddon.disableDoze();
            }
            Thread thread = this.mThread;
            if (thread != null) {
                thread.interrupt();
            }
            Thread thread2 = new Thread(this);
            this.mThread = thread2;
            thread2.start();
            return;
        }
        Utils.showToastLong(this.mContext, C0130R.string.cert_reinstall_required, new Object[0]);
        MitmAddon.setDecryptionSetupDone(this.mContext, false);
        CaptureService.stopService();
    }

    @Override // com.emanuelef.remote_capture.interfaces.MitmListener
    public void onMitmServiceConnect() {
        this.mAddon.stopProxy();
        if (!this.mAddon.requestCaCertificate()) {
            this.mAddon.disconnect();
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.MitmListener
    public void onMitmServiceDisconnect() {
        CaptureService.stopService();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
        com.emanuelef.remote_capture.CaptureService.stopService();
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0133  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Throwable th;
        MitmReceiver mitmReceiver;
        IOException e;
        Object obj;
        Throwable th2;
        if (this.mSocketFd == null) {
            Log.m585e(TAG, "Null socket, abort");
            proxyStatus.postValue(Status.NOT_STARTED);
            return;
        }
        Log.m583i(TAG, "Receiving data...");
        Status status = null;
        try {
            try {
                DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.mSocketFd));
                while (true) {
                    try {
                        try {
                            if (!this.mAddon.isConnected()) {
                                break;
                            }
                            String readLine = dataInputStream.readLine();
                            if (readLine == null) {
                                break;
                            }
                            StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                            try {
                                String nextToken = stringTokenizer.nextToken(":");
                                String nextToken2 = stringTokenizer.nextToken();
                                String nextToken3 = stringTokenizer.nextToken();
                                String nextToken4 = stringTokenizer.nextToken();
                                long parseLong = Long.parseLong(nextToken);
                                int parseInt = Integer.parseInt(nextToken2);
                                int parseInt2 = Integer.parseInt(nextToken4);
                                if (parseInt2 < 0 || parseInt2 > 67108864) {
                                    mitmReceiver = this;
                                    Log.m581w(TAG, "Ignoring bad message length: " + parseInt2);
                                    dataInputStream.skipBytes(parseInt2);
                                } else {
                                    MsgType parseMsgType = parseMsgType(nextToken3);
                                    try {
                                        byte[] bArr = new byte[parseInt2];
                                        dataInputStream.readFully(bArr);
                                        if (parseMsgType == MsgType.MASTER_SECRET) {
                                            logMasterSecret(bArr);
                                        } else if (parseMsgType == MsgType.LOG) {
                                            handleLog(bArr);
                                        } else if (parseMsgType == MsgType.RUNNING) {
                                            Log.m583i(TAG, "MITM proxy is running");
                                            proxyStatus.postValue(Status.RUNNING);
                                        } else {
                                            ConnectionDescriptor connByLocalPort = getConnByLocalPort(parseInt);
                                            if (connByLocalPort != null) {
                                                try {
                                                    handleMessage(connByLocalPort, parseMsgType, bArr, parseLong);
                                                    mitmReceiver = this;
                                                } catch (Throwable th3) {
                                                    th2 = th3;
                                                    Throwable th4 = th2;
                                                    try {
                                                        dataInputStream.close();
                                                    } catch (Throwable th5) {
                                                        th4.addSuppressed(th5);
                                                    }
                                                    throw th4;
                                                }
                                            } else {
                                                mitmReceiver = this;
                                                try {
                                                    addPendingMessage(new PendingMessage(parseMsgType, bArr, parseInt, parseLong));
                                                } catch (Throwable th6) {
                                                    th2 = th6;
                                                }
                                            }
                                        }
                                        mitmReceiver = this;
                                    } catch (OutOfMemoryError unused) {
                                        mitmReceiver = this;
                                        Log.m581w(TAG, "Ignoring message causing OOM (length: " + parseInt2 + ")");
                                        dataInputStream.skipBytes(parseInt2);
                                    }
                                }
                            } catch (NumberFormatException | NoSuchElementException unused2) {
                                mitmReceiver = this;
                                CaptureService.requireInstance().reportError("[BUG] Invalid header received from the mitm plugin");
                                CaptureService.stopService();
                            }
                        } catch (IOException e2) {
                            e = e2;
                            if (mitmReceiver.mSocketFd != null) {
                                e.printStackTrace();
                            }
                            Utils.safeClose(mitmReceiver.mKeylog);
                            mitmReceiver.mKeylog = null;
                            MutableLiveData mutableLiveData = proxyStatus;
                            obj = mutableLiveData.mData;
                            if (obj != LiveData.NOT_SET) {
                            }
                            if (status != Status.STARTING) {
                            }
                            Log.m583i(TAG, "End receiving data");
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                    }
                }
                mitmReceiver = this;
                dataInputStream.close();
            } catch (Throwable th8) {
                th = th8;
                Utils.safeClose(this.mKeylog);
                this.mKeylog = null;
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            mitmReceiver = this;
        } catch (Throwable th9) {
            th = th9;
            Utils.safeClose(this.mKeylog);
            this.mKeylog = null;
            throw th;
        }
        Utils.safeClose(mitmReceiver.mKeylog);
        mitmReceiver.mKeylog = null;
        MutableLiveData mutableLiveData2 = proxyStatus;
        obj = mutableLiveData2.mData;
        if (obj != LiveData.NOT_SET) {
            status = obj;
        }
        if (status != Status.STARTING) {
            mutableLiveData2.postValue(Status.START_ERROR);
        } else {
            mutableLiveData2.postValue(Status.NOT_STARTED);
        }
        Log.m583i(TAG, "End receiving data");
    }

    public boolean start() {
        Log.m587d(TAG, "starting");
        proxyStatus.postValue(Status.STARTING);
        if (!this.mAddon.connect(64)) {
            Utils.showToastLong(this.mContext, C0130R.string.mitm_start_failed, new Object[0]);
            return false;
        }
        this.mReg.addListener(this);
        return true;
    }

    public void stop() {
        Log.m587d(TAG, "stopping");
        this.mReg.removeListener(this);
        ParcelFileDescriptor parcelFileDescriptor = this.mSocketFd;
        this.mSocketFd = null;
        Utils.safeClose(parcelFileDescriptor);
        this.mAddon.stopProxy();
        this.mAddon.disconnect();
        while (true) {
            Thread thread = this.mThread;
            if (thread == null || !thread.isAlive()) {
                break;
            }
            try {
                Log.m587d(TAG, "Joining receiver thread...");
                this.mThread.join();
            } catch (InterruptedException unused) {
            }
        }
        this.mThread = null;
        Log.m587d(TAG, "stop done");
    }
}
