package com.emanuelef.remote_capture;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import android.net.Uri;
import android.net.VpnService;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.Toast;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat$Api26Impl;
import androidx.core.p002os.BundleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.preference.PreferenceManager;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.Blacklists;
import com.emanuelef.remote_capture.MitmReceiver;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.CaptureCtrl;
import com.emanuelef.remote_capture.activities.ConnectionsActivity;
import com.emanuelef.remote_capture.activities.FirewallActivity;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment;
import com.emanuelef.remote_capture.interfaces.PcapDumper;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.BlacklistDescriptor;
import com.emanuelef.remote_capture.model.Blocklist;
import com.emanuelef.remote_capture.model.CaptureSettings;
import com.emanuelef.remote_capture.model.CaptureStats;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.ConnectionUpdate;
import com.emanuelef.remote_capture.model.FilterDescriptor;
import com.emanuelef.remote_capture.model.MatchList;
import com.emanuelef.remote_capture.model.PortMapping;
import com.emanuelef.remote_capture.model.Prefs;
import com.emanuelef.remote_capture.pcap_dump.FileDumper;
import com.emanuelef.remote_capture.pcap_dump.HTTPServer;
import com.emanuelef.remote_capture.pcap_dump.TCPDumper;
import com.emanuelef.remote_capture.pcap_dump.UDPDumper;
import com.pcapdroid.mitm.MitmAPI;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class CaptureService extends VpnService implements Runnable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CONNECTIONS_LOG_SIZE = 8192;
    private static boolean HAS_ERROR = false;
    private static CaptureService INSTANCE = null;
    private static final String NOTIFY_CHAN_MALWARE_DETECTION = "Malware detection";
    private static final String NOTIFY_CHAN_OTHER = "Other";
    private static final String NOTIFY_CHAN_VPNSERVICE = "VPNService";
    public static final int NOTIFY_ID_APP_BLOCKED = 3;
    public static final int NOTIFY_ID_LOW_MEMORY = 2;
    public static final int NOTIFY_ID_VPNSERVICE = 1;
    private static final String TAG = "CaptureService";
    public static final String VPN_IP6_ADDRESS = "fd00:2:fd00:1:fd00:1:fd00:1";
    public static final String VPN_IP_ADDRESS = "10.215.173.1";
    private static final int VPN_MTU = 10000;
    public static final String VPN_VIRTUAL_DNS_SERVER = "10.215.173.2";
    private static final String VpnSessionName = "PCAPdroid VPN";
    private static boolean alwaysOnVpnErrorLogged;
    private static final MutableLiveData lastStats = new LiveData();
    private static final MutableLiveData serviceStatus = new LiveData();
    private ConnectionsRegister conn_reg;
    private String dns_server;
    private long last_bytes;
    private int last_connections;
    private int[] mAppFilterUids;
    private Billing mBilling;
    private Blacklists mBlacklists;
    private boolean mBlacklistsUpdateRequested;
    private Thread mBlacklistsUpdateThread;
    private boolean mBlockPrivateDns;
    private Blocklist mBlocklist;
    final Condition mCaptureStopped;
    private Thread mCaptureThread;
    private Thread mConnUpdateThread;
    private MatchList mDecryptionList;
    private boolean mDnsEncrypted;
    private LinkedBlockingDeque<byte[]> mDumpQueue;
    private PcapDumper mDumper;
    private Thread mDumperThread;
    private boolean mFirewallEnabled;
    private MatchList mFirewallWhitelist;
    private Handler mHandler;
    private HttpLog mHttpLog;
    private SparseArray<String> mIfIndexToName;
    private boolean mIsAlwaysOnVPN;
    final ReentrantLock mLock;
    private boolean mLowMemory;
    private NotificationCompat$Builder mMalwareBuilder;
    private boolean mMalwareDetectionEnabled;
    private MatchList mMalwareWhitelist;
    private MitmReceiver mMitmReceiver;
    private long mMonitoredNetwork;
    private AppsResolver mNativeAppsResolver;
    private Geolocation mNativeGeolocation;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private BroadcastReceiver mNewAppsInstallReceiver;
    private ParcelFileDescriptor mParcelFileDescriptor;
    private String mPcapFname;
    private Uri mPcapUri;
    private SharedPreferences mPrefs;
    private Utils.PrivateDnsMode mPrivateDnsMode;
    private boolean mQueueFull;
    private boolean mRevoked;
    private CaptureSettings mSettings;
    private String mSocks5Address;
    private String mSocks5Auth;
    private boolean mSocks5Enabled;
    private int mSocks5Port;
    private NotificationCompat$Builder mStatusBuilder;
    private boolean mStopping;
    private boolean mStrictDnsNoticeShown;
    private Network mUnderlyingNetwork;
    private String vpn_dns;
    private String vpn_ipv4;
    private final LinkedBlockingDeque<Pair<ConnectionDescriptor[], ConnectionUpdate[]>> mPendingUpdates = new LinkedBlockingDeque<>(32);
    private AtomicInteger mNumUpdatesInProgress = new AtomicInteger();

    /* loaded from: classes.dex */
    public enum ServiceStatus {
        STOPPED,
        STARTED
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData] */
    static {
        try {
            System.loadLibrary("capture");
            initPlatformInfo(Utils.getAppVersionString(), Utils.getDeviceModel(), Utils.getOsVersion());
        } catch (UnsatisfiedLinkError unused) {
        }
        alwaysOnVpnErrorLogged = false;
    }

    public CaptureService() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mCaptureStopped = reentrantLock.newCondition();
    }

    private int abortStart() {
        stopService();
        updateServiceStatus(ServiceStatus.STOPPED);
        return 2;
    }

    private static native void addPortMapping(int i, int i2, int i3, String str);

    public static native void askStatsDump();

    public static boolean checkAlwaysOnVpnActivated() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || captureService.mIsAlwaysOnVPN || !captureService.isAlwaysOnVpnDetected()) {
            return false;
        }
        Log.m583i(TAG, "Always-on VPN was activated");
        captureService.mIsAlwaysOnVPN = true;
        return true;
    }

    private void checkAvailableHeap() {
        long availableHeap = Utils.getAvailableHeap();
        if (availableHeap <= 10485760) {
            Log.m581w(TAG, "Detected low HEAP memory: " + Utils.formatBytes(availableHeap));
            handleLowMemory();
        }
    }

    private void checkBlacklistsUpdates(boolean z) {
        if (this.mMalwareDetectionEnabled && this.mBlacklistsUpdateThread == null) {
            if (this.mBlacklistsUpdateRequested || this.mBlacklists.needsUpdate(z)) {
                Thread thread = new Thread(new CaptureService$$ExternalSyntheticLambda0(0, this), "Blacklists Update");
                this.mBlacklistsUpdateThread = thread;
                thread.start();
            }
        }
    }

    public void connUpdateWork() {
        Pair<ConnectionDescriptor[], ConnectionUpdate[]> take;
        Object obj;
        HttpLog httpLog;
        while (true) {
            try {
                take = this.mPendingUpdates.take();
                obj = take.first;
            } catch (InterruptedException unused) {
            }
            if (obj == null) {
                Log.m583i(TAG, "Connection update thread exit requested");
                return;
            }
            ConnectionDescriptor[] connectionDescriptorArr = (ConnectionDescriptor[]) obj;
            ConnectionUpdate[] connectionUpdateArr = (ConnectionUpdate[]) take.second;
            checkBlacklistsUpdates(false);
            if (this.mBlocklist.checkGracePeriods()) {
                this.mHandler.post(new CaptureService$$ExternalSyntheticLambda0(3, this));
            }
            if (!this.mLowMemory) {
                checkAvailableHeap();
            }
            synchronized (this.conn_reg) {
                try {
                    if (connectionDescriptorArr.length > 0) {
                        this.conn_reg.newConnections(connectionDescriptorArr);
                    }
                    if (connectionUpdateArr.length > 0) {
                        this.conn_reg.connectionsUpdates(connectionUpdateArr);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.mNumUpdatesInProgress.decrementAndGet() == 0 && (httpLog = this.mHttpLog) != null) {
                httpLog.stopConnectionsUpdates();
            }
        }
    }

    public static native void dumpMasterSecret(byte[] bArr);

    public void dumpWork() {
        byte[] take;
        Log.m587d(TAG, "Starting the dumper");
        try {
            this.mDumper.startDumper();
            Log.m587d(TAG, "Dumper running");
            while (true) {
                try {
                    take = this.mDumpQueue.take();
                } catch (InterruptedException unused) {
                }
                if (take.length != 0) {
                    try {
                        this.mDumper.dumpData(take);
                    } catch (IOException e) {
                        e.printStackTrace();
                        reportError(e.getLocalizedMessage());
                        this.mHandler.post(new CaptureService$$ExternalSyntheticLambda1(0));
                    }
                }
                try {
                    this.mDumper.stopDumper();
                    return;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        } catch (IOException | SecurityException e3) {
            e3.printStackTrace();
            reportError(e3.getLocalizedMessage());
            this.mHandler.post(new CaptureService$$ExternalSyntheticLambda1(0));
        }
    }

    public static native boolean extractKeylogFromPcapng(String str, String str2);

    public static Set<String> getAppFilter() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.mSettings.app_filter;
        }
        return null;
    }

    public static long getBytes() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.last_bytes;
        }
        return 0L;
    }

    public static CaptureSettings getCaptureSettings() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.mSettings;
        }
        return null;
    }

    public static String getCollectorAddress() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.mSettings.collector_address;
        }
        return "";
    }

    public static int getCollectorPort() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.mSettings.collector_port;
        }
        return 0;
    }

    public static ConnectionsRegister getConnsRegister() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.conn_reg;
        }
        return null;
    }

    public static Prefs.PayloadMode getCurPayloadMode() {
        CaptureService captureService = INSTANCE;
        if (captureService == null) {
            return Prefs.PayloadMode.MINIMAL;
        }
        if (captureService.mSettings.full_payload) {
            return Prefs.PayloadMode.FULL;
        }
        return Prefs.PayloadMode.MINIMAL;
    }

    public static String getDNSServer() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.getDnsServer();
        }
        return "";
    }

    public static Prefs.DumpMode getDumpMode() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.mSettings.dump_mode;
        }
        return Prefs.DumpMode.NONE;
    }

    private static native int getFdSetSize();

    public static int getHTTPServerPort() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.mSettings.http_server_port;
        }
        return 0;
    }

    public static HttpLog getHttpLog() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.mHttpLog;
        }
        return null;
    }

    private String getIfname(int i) {
        NetworkInterface networkInterface;
        String str = "";
        if (i <= 0) {
            return str;
        }
        String str2 = this.mIfIndexToName.get(i);
        if (str2 != null) {
            return str2;
        }
        try {
            networkInterface = NetworkInterface.getByIndex(i);
        } catch (SocketException unused) {
            networkInterface = null;
        }
        if (networkInterface != null) {
            str = networkInterface.getName();
        }
        this.mIfIndexToName.put(i, str);
        return str;
    }

    public static String getInterfaceName(int i) {
        String str;
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            str = captureService.getIfname(i);
        } else {
            str = null;
        }
        if (str != null) {
            return str;
        }
        return "";
    }

    public static native List<String> getL7Protocols();

    public static MitmReceiver.Status getMitmProxyStatus() {
        MitmReceiver mitmReceiver;
        CaptureService captureService = INSTANCE;
        if (captureService == null || (mitmReceiver = captureService.mMitmReceiver) == null) {
            return MitmReceiver.Status.NOT_STARTED;
        }
        return mitmReceiver.getProxyStatus();
    }

    public static native int getNumCheckedFirewallConnections();

    public static native int getNumCheckedMalwareConnections();

    public static String getPcapFname() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.mPcapFname;
        }
        return null;
    }

    public static native byte[] getPcapHeader();

    public static Uri getPcapUri() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            return captureService.mPcapUri;
        }
        return null;
    }

    public static Utils.PrivateDnsMode getPrivateDnsMode() {
        if (isServiceActive()) {
            return INSTANCE.mPrivateDnsMode;
        }
        return null;
    }

    public static CaptureStats getStats() {
        Object obj = lastStats.mData;
        if (obj == LiveData.NOT_SET) {
            obj = null;
        }
        CaptureStats captureStats = (CaptureStats) obj;
        if (captureStats != null) {
            return captureStats;
        }
        return new CaptureStats();
    }

    private Notification getStatusNotification() {
        String format = String.format(getString(C0130R.string.notification_msg), Utils.formatBytes(this.last_bytes), Utils.formatNumber(this, this.last_connections));
        NotificationCompat$Builder notificationCompat$Builder = this.mStatusBuilder;
        notificationCompat$Builder.getClass();
        notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(format);
        return this.mStatusBuilder.build();
    }

    public void handleLinkProperties(LinkProperties linkProperties) {
        if (linkProperties != null && Build.VERSION.SDK_INT >= 28) {
            this.mPrivateDnsMode = Utils.getPrivateDnsMode(linkProperties);
            Log.m583i(TAG, "Private DNS: " + this.mPrivateDnsMode);
            if (this.mSettings.readFromPcap()) {
                this.mDnsEncrypted = false;
                setPrivateDnsBlocked(false);
            } else {
                CaptureSettings captureSettings = this.mSettings;
                if (captureSettings.root_capture || !captureSettings.auto_block_private_dns) {
                    this.mDnsEncrypted = !this.mPrivateDnsMode.equals(Utils.PrivateDnsMode.DISABLED);
                    setPrivateDnsBlocked(false);
                } else {
                    this.mDnsEncrypted = this.mPrivateDnsMode.equals(Utils.PrivateDnsMode.STRICT);
                    boolean equals = this.mPrivateDnsMode.equals(Utils.PrivateDnsMode.OPPORTUNISTIC);
                    if (this.mBlockPrivateDns != equals) {
                        this.mBlockPrivateDns = equals;
                        setPrivateDnsBlocked(equals);
                    }
                }
            }
            if (this.mDnsEncrypted && !this.mStrictDnsNoticeShown) {
                this.mStrictDnsNoticeShown = true;
                Utils.showToastLong(this, C0130R.string.private_dns_message_notice, new Object[0]);
            }
        }
    }

    private void handleLowMemory() {
        Log.m581w(TAG, "handleLowMemory called");
        this.mLowMemory = true;
        if (getCurPayloadMode() == Prefs.PayloadMode.FULL) {
            Log.m581w(TAG, "Disabling full payload");
            this.mSettings.full_payload = false;
            setPayloadMode(Prefs.PayloadMode.NONE.ordinal());
            if (this.mSettings.tls_decryption) {
                stopService();
                notifyLowMemory(getString(C0130R.string.capture_stopped_low_memory));
                return;
            }
            ConnectionsRegister connectionsRegister = this.conn_reg;
            if (connectionsRegister != null) {
                connectionsRegister.releasePayloadMemory();
                System.gc();
                Log.m583i(TAG, "Memory stats full payload release:\n" + Utils.getMemoryStats(this));
            }
            notifyLowMemory(getString(C0130R.string.full_payload_disabled));
            return;
        }
        Log.m581w(TAG, "low memory detected, expect crashes");
        notifyLowMemory(getString(C0130R.string.low_memory_info));
    }

    public static boolean hasError() {
        return HAS_ERROR;
    }

    public static native boolean hasSeenDumpExtensions();

    public static native int initLogger(String str, int i);

    private static native void initPlatformInfo(String str, String str2, String str3);

    public static boolean isAlwaysOnVPN() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || !captureService.mIsAlwaysOnVPN) {
            return false;
        }
        return true;
    }

    private boolean isAlwaysOnVpnDetected() {
        if (Build.VERSION.SDK_INT >= 29) {
            return isAlwaysOn();
        }
        try {
            return Settings.Secure.getString(getContentResolver(), "always_on_vpn_app").equals(getPackageName());
        } catch (Exception e) {
            if (alwaysOnVpnErrorLogged) {
                return false;
            }
            Log.m581w(TAG, "Querying the always-on VPN state failed: " + e);
            alwaysOnVpnErrorLogged = true;
            return false;
        }
    }

    public static boolean isCapturingAsRoot() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || captureService.isRootCapture() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isDNSEncrypted() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || !captureService.mDnsEncrypted) {
            return false;
        }
        return true;
    }

    public static boolean isDecryptingTLS() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || captureService.isTlsDecryptionEnabled() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isDecryptionListEnabled() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || captureService.mDecryptionList == null) {
            return false;
        }
        return true;
    }

    public static boolean isIPv6Enabled() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || captureService.getIPv6Enabled() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isLockdownVPN() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || !captureService.isLockdownEnabled()) {
            return false;
        }
        return true;
    }

    public static boolean isLowMemory() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || !captureService.mLowMemory) {
            return false;
        }
        return true;
    }

    public static boolean isReadingFromPcapFile() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || captureService.isPcapFileCapture() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isServiceActive() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || captureService.mCaptureThread == null) {
            return false;
        }
        return true;
    }

    public static boolean isUserDefinedPcapUri() {
        CaptureService captureService = INSTANCE;
        if (captureService == null || !captureService.mSettings.pcap_uri.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isUsharkAvailable(Context context) {
        return new File(getLibprogPath(context, "ushark")).exists();
    }

    public /* synthetic */ void lambda$notifyBlacklistedConnection$0(int i, Notification notification) {
        Utils.sendImportantNotification(this, i, notification);
    }

    public /* synthetic */ void lambda$notifyBlacklistsLoaded$7(Blacklists.NativeBlacklistStatus[] nativeBlacklistStatusArr) {
        this.mBlacklists.onNativeLoaded(nativeBlacklistStatusArr);
    }

    public /* synthetic */ void lambda$notifyLowMemory$1(Notification notification) {
        Utils.sendImportantNotification(this, 2, notification);
    }

    public /* synthetic */ void lambda$reportError$6(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1957914090:
                if (str.equals("PCAP/Pcapng read error")) {
                    c = 0;
                    break;
                }
                break;
            case -1284797106:
                if (str.equals("pcapd daemon start failure")) {
                    c = 1;
                    break;
                }
                break;
            case -1233193456:
                if (str.equals("The specified PCAP/Pcapng file does not exist")) {
                    c = 2;
                    break;
                }
                break;
            case -989594010:
                if (str.equals("Could not open the capture interface")) {
                    c = 3;
                    break;
                }
                break;
            case -838447809:
                if (str.equals("Unsupported PCAP/Pcapng file")) {
                    c = 4;
                    break;
                }
                break;
            case -779040323:
                if (str.equals("Invalid PCAP/Pcapng file")) {
                    c = 5;
                    break;
                }
                break;
            case -278865137:
                if (str.equals("pcapd daemon did not spawn")) {
                    c = 6;
                    break;
                }
                break;
            case 857036879:
                if (str.equals("Unsupported datalink")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                str = getString(C0130R.string.pcap_read_error);
                break;
            case 1:
                if (this.mSettings.root_capture) {
                    str = getString(C0130R.string.root_capture_pcapd_start_failure);
                    break;
                }
                break;
            case 2:
                str = getString(C0130R.string.pcap_file_not_exists);
                break;
            case 3:
                str = getString(C0130R.string.capture_interface_open_error);
                break;
            case 4:
                str = getString(C0130R.string.unsupported_pcap_file);
                break;
            case 5:
                str = getString(C0130R.string.invalid_pcap_file);
                break;
            case 6:
                if (this.mSettings.root_capture) {
                    str = getString(C0130R.string.root_capture_start_failed);
                    break;
                }
                break;
            case 7:
                str = getString(C0130R.string.unsupported_pcap_datalink);
                break;
        }
        Toast.makeText(this, str, 1).show();
    }

    public /* synthetic */ void lambda$resolveHosts$2() {
        Utils.showToastLong(this, C0130R.string.host_resolution_failed, this.mSocks5Address);
    }

    public /* synthetic */ void lambda$resolveHosts$3(String str) {
        Utils.showToastLong(this, C0130R.string.host_resolution_failed, str);
    }

    public /* synthetic */ void lambda$run$4(boolean z) {
        int i;
        if (z) {
            i = C0130R.string.permission_granted;
        } else {
            i = C0130R.string.permission_grant_fail;
        }
        Utils.showToast(this, i, "INTERACT_ACROSS_USERS");
    }

    public /* synthetic */ void lambda$run$5() {
        updateServiceStatus(ServiceStatus.STOPPED);
        CaptureCtrl.notifyCaptureStopped(this, getStats());
    }

    public static native void nativeSetFirewallEnabled(boolean z);

    public static void observeStats(LifecycleOwner lifecycleOwner, Observer observer) {
        lastStats.observe(lifecycleOwner, observer);
    }

    public static void observeStatus(LifecycleOwner lifecycleOwner, Observer observer) {
        serviceStatus.observe(lifecycleOwner, observer);
    }

    private void registerNetworkCallbacks() {
        if (this.mNetworkCallback == null) {
            final String dnsServerV4 = Prefs.getDnsServerV4(this.mPrefs);
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            this.mNetworkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.emanuelef.remote_capture.CaptureService.2
                {
                    CaptureService.this = this;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                    Log.m587d(CaptureService.TAG, "onLinkPropertiesChanged " + network);
                    if (network.getNetworkHandle() == CaptureService.this.mMonitoredNetwork) {
                        CaptureService.this.handleLinkProperties(linkProperties);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    Log.m587d(CaptureService.TAG, "onLost " + network);
                    if (network.getNetworkHandle() == CaptureService.this.mMonitoredNetwork) {
                        Log.m583i(CaptureService.TAG, "Main network " + network + " lost, using fallback DNS " + dnsServerV4);
                        CaptureService.this.dns_server = dnsServerV4;
                        CaptureService.this.mMonitoredNetwork = 0L;
                        CaptureService.this.unregisterNetworkCallbacks();
                        CaptureService.setDnsServer(CaptureService.this.dns_server);
                    }
                }
            };
            try {
                Log.m587d(TAG, "registerNetworkCallback");
                connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), this.mNetworkCallback);
            } catch (SecurityException e) {
                e.printStackTrace();
                Log.m581w(TAG, "registerNetworkCallback failed, DNS server detection disabled");
                this.dns_server = dnsServerV4;
                this.mNetworkCallback = null;
            }
        }
    }

    private static native void reloadBlacklists();

    private static native boolean reloadBlocklist(MatchList.ListDescriptor listDescriptor);

    public static void reloadDecryptionList() {
        CaptureService captureService = INSTANCE;
        if (captureService != null && captureService.mDecryptionList != null) {
            Log.m583i(TAG, "reloading TLS decryption whitelist");
            reloadDecryptionList(INSTANCE.mDecryptionList.toListDescriptor());
        }
    }

    private static native boolean reloadDecryptionList(MatchList.ListDescriptor listDescriptor);

    private static native boolean reloadFirewallWhitelist(MatchList.ListDescriptor listDescriptor);

    public static void reloadMalwareWhitelist() {
        CaptureService captureService = INSTANCE;
        if (captureService != null && captureService.mMalwareDetectionEnabled) {
            Log.m583i(TAG, "reloading malware whitelist");
            reloadMalwareWhitelist(INSTANCE.mMalwareWhitelist.toListDescriptor());
        }
    }

    private static native boolean reloadMalwareWhitelist(MatchList.ListDescriptor listDescriptor);

    public static void requestBlacklistsUpdate() {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            captureService.mBlacklistsUpdateRequested = true;
            captureService.mPendingUpdates.offer(new Pair<>(new ConnectionDescriptor[0], new ConnectionUpdate[0]));
        }
    }

    public static ConnectionsRegister requireConnsRegister() {
        return getConnsRegister();
    }

    public static CaptureService requireInstance() {
        return INSTANCE;
    }

    private String resolveHost(String str) {
        Network network;
        if (Build.VERSION.SDK_INT >= 23 && (network = this.mUnderlyingNetwork) != null) {
            try {
                return network.getByName(str).getHostAddress();
            } catch (UnknownHostException unused) {
            }
        }
        return null;
    }

    private boolean resolveHosts() {
        if (this.mSocks5Enabled && !this.mSettings.tls_decryption && !this.mSocks5Address.isEmpty() && !Utils.validateIpAddress(this.mSocks5Address)) {
            String resolveHost = resolveHost(this.mSocks5Address);
            if (resolveHost == null) {
                Log.m585e(TAG, "Could not resolve SOCKS5 proxy: " + this.mSocks5Address);
                this.mHandler.post(new CaptureService$$ExternalSyntheticLambda0(2, this));
                return false;
            }
            Log.m583i(TAG, "Resolved SOCKS5 proxy: " + this.mSocks5Address + " -> " + resolveHost);
            this.mSocks5Address = resolveHost;
        }
        if (!Prefs.isPortMappingEnabled(this.mPrefs)) {
            return true;
        }
        Iterator<PortMapping.PortMap> iter = new PortMapping(this).iter();
        while (iter.hasNext()) {
            PortMapping.PortMap next = iter.next();
            String str = next.redirect_host;
            if (!Utils.validateIpAddress(str)) {
                String resolveHost2 = resolveHost(str);
                if (resolveHost2 == null) {
                    Log.m585e(TAG, "Could not resolve port mapping host: " + str);
                    this.mHandler.post(new CaptureService$$ExternalSyntheticLambda5(this, str, 1));
                    return false;
                }
                Log.m583i(TAG, "Resolved port mapping host: " + str + " -> " + resolveHost2);
                str = resolveHost2;
            }
            addPortMapping(next.ipproto, next.orig_port, next.redirect_port, str);
        }
        return true;
    }

    public static native int rootCmd(String str, String str2);

    private static native void runPacketLoop(int i, CaptureService captureService, int i2);

    private void sendServiceStatus(String str) {
        ServiceStatus serviceStatus2;
        if (str.equals("started")) {
            serviceStatus2 = ServiceStatus.STARTED;
        } else {
            serviceStatus2 = ServiceStatus.STOPPED;
        }
        updateServiceStatus(serviceStatus2);
    }

    public static native void setDnsServer(String str);

    public static void setFirewallEnabled(boolean z) {
        CaptureService captureService = INSTANCE;
        if (captureService != null) {
            captureService.mFirewallEnabled = z;
            nativeSetFirewallEnabled(z);
        }
    }

    public static native void setPayloadMode(int i);

    private static native void setPrivateDnsBlocked(boolean z);

    private void setupNotifications() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFY_CHAN_VPNSERVICE, NOTIFY_CHAN_VPNSERVICE, 2);
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.createNotificationChannel(new NotificationChannel(NOTIFY_CHAN_MALWARE_DETECTION, getString(C0130R.string.malware_detection), 4));
            notificationManager.createNotificationChannel(new NotificationChannel(NOTIFY_CHAN_OTHER, getString(C0130R.string.other_prefs), 3));
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), Utils.getIntentFlags(134217728));
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, NOTIFY_CHAN_VPNSERVICE);
        notificationCompat$Builder.mNotification.icon = C0130R.C0131drawable.ic_logo;
        notificationCompat$Builder.mColor = BundleKt.getColor(this, C0130R.color.colorPrimary);
        notificationCompat$Builder.mContentIntent = activity;
        notificationCompat$Builder.setFlag(2, true);
        notificationCompat$Builder.setFlag(16, false);
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(getResources().getString(C0130R.string.capture_running));
        notificationCompat$Builder.mVisibility = 1;
        notificationCompat$Builder.mCategory = "status";
        notificationCompat$Builder.mPriority = -1;
        this.mStatusBuilder = notificationCompat$Builder;
        NotificationCompat$Builder notificationCompat$Builder2 = new NotificationCompat$Builder(this, NOTIFY_CHAN_MALWARE_DETECTION);
        notificationCompat$Builder2.mNotification.icon = C0130R.C0131drawable.ic_skull;
        notificationCompat$Builder2.setFlag(16, true);
        notificationCompat$Builder2.mVisibility = 1;
        notificationCompat$Builder2.mCategory = "status";
        notificationCompat$Builder2.mPriority = 1;
        this.mMalwareBuilder = notificationCompat$Builder2;
    }

    private void signalServicesTermination() {
        this.mPendingUpdates.offer(new Pair<>(null, null));
        stopPcapDump();
    }

    private void stopAndJoinThreads() {
        signalServicesTermination();
        Log.m587d(TAG, "Joining threads...");
        while (true) {
            Thread thread = this.mConnUpdateThread;
            if (thread == null || !thread.isAlive()) {
                break;
            }
            try {
                Log.m587d(TAG, "Joining conn update thread...");
                this.mConnUpdateThread.join();
            } catch (InterruptedException unused) {
                this.mPendingUpdates.offer(new Pair<>(null, null));
            }
        }
        this.mConnUpdateThread = null;
        while (true) {
            Thread thread2 = this.mDumperThread;
            if (thread2 == null || !thread2.isAlive()) {
                break;
            }
            try {
                Log.m587d(TAG, "Joining dumper thread...");
                this.mDumperThread.join();
            } catch (InterruptedException unused2) {
                stopPcapDump();
            }
        }
        this.mDumperThread = null;
        this.mDumper = null;
        MitmReceiver mitmReceiver = this.mMitmReceiver;
        if (mitmReceiver != null) {
            try {
                mitmReceiver.stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mMitmReceiver = null;
        }
    }

    public static native void stopPacketLoop();

    public static void stopService() {
        boolean z;
        CaptureService captureService = INSTANCE;
        StringBuilder sb = new StringBuilder("stopService called (instance? ");
        if (captureService != null) {
            z = true;
        } else {
            z = false;
        }
        sb.append(z);
        sb.append(")");
        Log.m587d(TAG, sb.toString());
        if (captureService != null) {
            captureService.mStopping = true;
            stopPacketLoop();
            if (Build.VERSION.SDK_INT >= 24) {
                captureService.stopForeground(1);
            } else {
                captureService.stopForeground(true);
            }
            captureService.stopSelf();
        }
    }

    public void unregisterNetworkCallbacks() {
        if (this.mNetworkCallback != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            try {
                Log.m587d(TAG, "unregisterNetworkCallback");
                connectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
            } catch (IllegalArgumentException e) {
                Log.m581w(TAG, "unregisterNetworkCallback failed: " + e);
            }
            this.mNetworkCallback = null;
        }
    }

    public void updateBlacklistsWork() {
        this.mBlacklistsUpdateRequested = false;
        this.mBlacklists.update();
        reloadBlacklists();
        this.mBlacklistsUpdateThread = null;
    }

    public void updateNotification() {
        if (!this.mStopping) {
            new NotificationManagerCompat(this).notify(1, getStatusNotification());
        }
    }

    private void updateServiceStatus(ServiceStatus serviceStatus2) {
        int i;
        serviceStatus.postValue(serviceStatus2);
        if (serviceStatus2 == ServiceStatus.STARTED) {
            if (this.mMalwareDetectionEnabled) {
                reloadMalwareWhitelist();
            }
            if (this.mDecryptionList != null) {
                reloadDecryptionList();
            }
            reloadBlocklist();
            reloadFirewallWhitelist();
        } else if (serviceStatus2 == ServiceStatus.STOPPED && this.mRevoked && Prefs.restartOnDisconnect(this.mPrefs) && !this.mIsAlwaysOnVPN && isVpnCapture() == 1 && (i = Build.VERSION.SDK_INT) >= 23) {
            Log.m583i(TAG, "VPN disconnected, starting reconnect service");
            Intent intent = new Intent(this, VpnReconnectService.class);
            if (i >= 26) {
                ContextCompat$Api26Impl.startForegroundService(this, intent);
            } else {
                startService(intent);
            }
        }
    }

    public static void waitForCaptureStop() {
        if (INSTANCE != null) {
            Log.m587d(TAG, "waitForCaptureStop " + Thread.currentThread().getName());
            INSTANCE.mLock.lock();
            while (true) {
                try {
                    CaptureService captureService = INSTANCE;
                    if (captureService.mCaptureThread != null) {
                        try {
                            captureService.mCaptureStopped.await();
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        captureService.mLock.unlock();
                        Log.m587d(TAG, "waitForCaptureStop done " + Thread.currentThread().getName());
                        return;
                    }
                } catch (Throwable th) {
                    INSTANCE.mLock.unlock();
                    throw th;
                }
            }
        }
    }

    public static native int writeLog(int i, int i2, String str);

    @Override // android.app.Service, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context.createConfigurationContext(Utils.getLocalizedConfig(context)));
    }

    public int dumpExtensionsEnabled() {
        return this.mSettings.dump_extensions ? 1 : 0;
    }

    public void dumpPcapData(byte[] bArr) {
        if (this.mDumper != null && bArr.length > 0) {
            while (true) {
                try {
                    this.mDumpQueue.put(bArr);
                    return;
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public int firewallEnabled() {
        return this.mFirewallEnabled ? 1 : 0;
    }

    public int[] getAppFilterUids() {
        return this.mAppFilterUids;
    }

    public String getApplicationByUid(int i) {
        AppDescriptor appByUid = this.mNativeAppsResolver.getAppByUid(i, 0);
        if (appByUid == null) {
            return "";
        }
        return appByUid.getName();
    }

    public BlacklistDescriptor[] getBlacklistsInfo() {
        BlacklistDescriptor[] blacklistDescriptorArr = new BlacklistDescriptor[this.mBlacklists.getNumBlacklists()];
        Iterator<BlacklistDescriptor> iter = this.mBlacklists.iter();
        int i = 0;
        while (iter.hasNext()) {
            blacklistDescriptorArr[i] = iter.next();
            i++;
        }
        return blacklistDescriptorArr;
    }

    public int getBlockQuickMode() {
        return this.mSettings.block_quic_mode.ordinal();
    }

    public String getCaptureInterface() {
        return this.mSettings.capture_interface;
    }

    public String getCountryCode(String str) {
        if (!this.mNativeGeolocation.isAvailable()) {
            return "";
        }
        try {
            return this.mNativeGeolocation.getCountryCode(InetAddress.getByName(str));
        } catch (UnknownHostException unused) {
            return "";
        }
    }

    public String getDnsServer() {
        return this.dns_server;
    }

    public int getIPv4Enabled() {
        if (this.mSettings.ip_mode != Prefs.IpMode.IPV6_ONLY) {
            return 1;
        }
        return 0;
    }

    public int getIPv6Enabled() {
        if (this.mSettings.ip_mode != Prefs.IpMode.IPV4_ONLY) {
            return 1;
        }
        return 0;
    }

    public String getIpv6DnsServer() {
        return Prefs.getDnsServerV6(this.mPrefs);
    }

    public String getLibprogPath(String str) {
        return getLibprogPath(this, str);
    }

    public int getMaxDumpSize() {
        return this.mSettings.max_dump_size;
    }

    public int getMaxPktsPerFlow() {
        return this.mSettings.max_pkts_per_flow;
    }

    public int getMitmAddonUid() {
        return MitmAddon.getUid(this);
    }

    public String getPackageNameByUid(int i) {
        AppDescriptor appByUid = this.mNativeAppsResolver.getAppByUid(i, 0);
        if (appByUid == null) {
            return "";
        }
        return appByUid.getPackageName();
    }

    public int getPayloadMode() {
        return getCurPayloadMode().ordinal();
    }

    public String getPcapDumperBpf() {
        PcapDumper pcapDumper = this.mDumper;
        if (pcapDumper != null) {
            return pcapDumper.getBpf();
        }
        return "";
    }

    public String getPersistentDir() {
        return getFilesDir().getAbsolutePath();
    }

    public int getSnaplen() {
        return this.mSettings.snaplen;
    }

    public int getSocks5Enabled() {
        return this.mSocks5Enabled ? 1 : 0;
    }

    public String getSocks5ProxyAddress() {
        return this.mSocks5Address;
    }

    public String getSocks5ProxyAuth() {
        return this.mSocks5Auth;
    }

    public int getSocks5ProxyPort() {
        return this.mSocks5Port;
    }

    @TargetApi(29)
    public int getUidQ(int i, String str, int i2, String str2, int i3) {
        ConnectivityManager connectivityManager;
        if ((i != 6 && i != 17) || (connectivityManager = (ConnectivityManager) getSystemService("connectivity")) == null) {
            return -1;
        }
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i2);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress(str2, i3);
        Log.m587d(TAG, "Get uid local=" + inetSocketAddress + " remote=" + inetSocketAddress2);
        return connectivityManager.getConnectionOwnerUid(i, inetSocketAddress, inetSocketAddress2);
    }

    public String getVpnDns() {
        return this.vpn_dns;
    }

    public String getVpnIPv4() {
        return this.vpn_ipv4;
    }

    public int getVpnMTU() {
        return VPN_MTU;
    }

    public String getWorkingDir() {
        return getCacheDir().getAbsolutePath();
    }

    public int isPcapFileCapture() {
        return this.mSettings.readFromPcap() ? 1 : 0;
    }

    public int isPcapngEnabled() {
        return this.mSettings.pcapng_format ? 1 : 0;
    }

    public int isRootCapture() {
        return this.mSettings.root_capture ? 1 : 0;
    }

    public int isTlsDecryptionEnabled() {
        return this.mSettings.tls_decryption ? 1 : 0;
    }

    public int isVpnCapture() {
        if ((isRootCapture() | isPcapFileCapture()) == 1) {
            return 0;
        }
        return 1;
    }

    public void loadUidMapping(int i, String str, String str2) {
        if (i >= 0) {
            AppDescriptor appByUid = this.mNativeAppsResolver.getAppByUid(i, 0);
            if (appByUid == null || !appByUid.getPackageName().equals(str)) {
                AppsResolver.addMappedApp(i, str, str2);
            }
        }
    }

    public int malwareDetectionEnabled() {
        return this.mMalwareDetectionEnabled ? 1 : 0;
    }

    public void notifyBlacklistedConnection(ConnectionDescriptor connectionDescriptor) {
        String str;
        int i = connectionDescriptor.uid;
        AppDescriptor appByUid = new AppsResolver(this).getAppByUid(connectionDescriptor.uid, 0);
        if (appByUid != null) {
            FilterDescriptor filterDescriptor = new FilterDescriptor();
            filterDescriptor.onlyBlacklisted = true;
            PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, ConnectionsActivity.class).putExtra("filter", filterDescriptor).putExtra(ConnectionsFragment.QUERY_EXTRA, appByUid.getPackageName()), Utils.getIntentFlags(134217728));
            if (connectionDescriptor.isBlacklistedHost()) {
                str = MatchList.getRuleLabel(this, MatchList.RuleType.HOST, connectionDescriptor.info);
            } else {
                str = MatchList.getRuleLabel(this, MatchList.RuleType.IP, connectionDescriptor.dst_ip);
            }
            String format = String.format(getResources().getString(C0130R.string.malicious_connection_description), appByUid.getName(), str);
            NotificationCompat$Builder notificationCompat$Builder = this.mMalwareBuilder;
            notificationCompat$Builder.mContentIntent = activity;
            notificationCompat$Builder.mNotification.when = System.currentTimeMillis();
            notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(getResources().getString(C0130R.string.malware_detection));
            zzcl zzclVar = new zzcl(6, false);
            zzclVar.zzc = NotificationCompat$Builder.limitCharSequenceLength(format);
            notificationCompat$Builder.setStyle(zzclVar);
            notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(format);
            this.mHandler.post(new CaptureService$$ExternalSyntheticLambda8(i, 0, this, this.mMalwareBuilder.build()));
        }
    }

    public void notifyBlacklistsLoaded(Blacklists.NativeBlacklistStatus[] nativeBlacklistStatusArr) {
        this.mHandler.post(new Utils$$ExternalSyntheticLambda3(this, 3, nativeBlacklistStatusArr));
    }

    public void notifyLowMemory(CharSequence charSequence) {
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, NOTIFY_CHAN_OTHER);
        notificationCompat$Builder.setFlag(16, true);
        notificationCompat$Builder.mNotification.icon = C0130R.C0131drawable.ic_logo;
        notificationCompat$Builder.mColor = BundleKt.getColor(this, C0130R.color.colorPrimary);
        notificationCompat$Builder.mVisibility = 1;
        notificationCompat$Builder.mCategory = "status";
        notificationCompat$Builder.mNotification.when = System.currentTimeMillis();
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(getString(C0130R.string.low_memory));
        notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(charSequence);
        this.mHandler.post(new Utils$$ExternalSyntheticLambda3(this, 2, notificationCompat$Builder.build()));
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.m587d(TAG, "onCreate");
        AppsResolver.clearMappedApps();
        this.mNativeAppsResolver = new AppsResolver(this);
        this.mNativeGeolocation = new Geolocation(this);
        SharedPreferences sharedPreferences = getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0);
        this.mPrefs = sharedPreferences;
        this.mSettings = new CaptureSettings(this, sharedPreferences);
        INSTANCE = this;
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.m587d(TAG, "onDestroy");
        unregisterNetworkCallbacks();
        Blacklists blacklists = this.mBlacklists;
        if (blacklists != null) {
            blacklists.abortUpdate();
        }
        Thread thread = this.mCaptureThread;
        if (thread != null) {
            thread.interrupt();
        }
        Thread thread2 = this.mBlacklistsUpdateThread;
        if (thread2 != null) {
            thread2.interrupt();
        }
        BroadcastReceiver broadcastReceiver = this.mNewAppsInstallReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.mNewAppsInstallReceiver = null;
        }
        super.onDestroy();
    }

    @Override // android.net.VpnService
    public void onRevoke() {
        Log.m587d(TAG, "onRevoke");
        this.mRevoked = true;
        stopService();
        super.onRevoke();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        CaptureSettings captureSettings;
        HttpLog httpLog;
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        boolean z4;
        this.mStopping = false;
        setupNotifications();
        if (Build.VERSION.SDK_INT >= 34) {
            startForeground(1, getStatusNotification(), 1073741824);
        } else {
            startForeground(1, getStatusNotification());
        }
        if (this.mCaptureThread != null) {
            Log.m585e(TAG, "Restarting the capture is not supported");
            return abortStart();
        }
        if (VpnReconnectService.isAvailable()) {
            VpnReconnectService.stopService();
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mBilling = Billing.newInstance(this);
        Log.m587d(TAG, "onStartCommand");
        if (intent == null) {
            captureSettings = null;
        } else {
            captureSettings = (CaptureSettings) Utils.getSerializableExtra(intent, "settings", CaptureSettings.class);
        }
        if (captureSettings != null) {
            this.mSettings = captureSettings;
            this.mIsAlwaysOnVPN = false;
            String str2 = captureSettings.decryption_rules_json;
            int length = str2.length();
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                int codePointAt = str2.codePointAt(i3);
                if (!Character.isWhitespace(codePointAt)) {
                    PCAPdroid.getInstance().getDecryptionList().fromJson(captureSettings.decryption_rules_json);
                    break;
                }
                i3 += Character.charCount(codePointAt);
            }
        } else {
            if (intent != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.mIsAlwaysOnVPN = z4;
            Log.m583i(TAG, "Missing capture settings, using SharedPrefs");
        }
        this.mIsAlwaysOnVPN |= isAlwaysOnVpnDetected();
        Log.m587d(TAG, "alwaysOn? " + this.mIsAlwaysOnVPN);
        if (this.mIsAlwaysOnVPN) {
            CaptureSettings captureSettings2 = this.mSettings;
            captureSettings2.root_capture = false;
            captureSettings2.input_pcap_path = null;
        }
        if (this.mSettings.readFromPcap()) {
            CaptureSettings captureSettings3 = this.mSettings;
            captureSettings3.dump_mode = Prefs.DumpMode.NONE;
            captureSettings3.app_filter.clear();
            CaptureSettings captureSettings4 = this.mSettings;
            captureSettings4.socks5_enabled = false;
            captureSettings4.tls_decryption = false;
            captureSettings4.root_capture = false;
            captureSettings4.auto_block_private_dns = false;
            captureSettings4.capture_interface = captureSettings4.input_pcap_path;
        }
        String dnsServerV4 = Prefs.getDnsServerV4(this.mPrefs);
        this.dns_server = dnsServerV4;
        this.mBlockPrivateDns = false;
        this.mStrictDnsNoticeShown = false;
        this.mDnsEncrypted = false;
        setPrivateDnsBlocked(false);
        this.mIfIndexToName = new SparseArray<>();
        Enumeration<NetworkInterface> networkInterfaces = Utils.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface nextElement = networkInterfaces.nextElement();
            Log.m587d(TAG, "ifidx " + nextElement.getIndex() + " -> " + nextElement.getName());
            this.mIfIndexToName.put(nextElement.getIndex(), nextElement.getName());
        }
        if (Build.VERSION.SDK_INT >= 23) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            Network activeNetwork = connectivityManager.getActiveNetwork();
            this.mUnderlyingNetwork = activeNetwork;
            if (activeNetwork != null) {
                handleLinkProperties(connectivityManager.getLinkProperties(activeNetwork));
                if (Prefs.useSystemDns(this.mPrefs) || this.mSettings.root_capture) {
                    String dnsServer = Utils.getDnsServer(connectivityManager, activeNetwork);
                    this.dns_server = dnsServer;
                    if (dnsServer == null) {
                        this.dns_server = dnsServerV4;
                    } else {
                        this.mMonitoredNetwork = activeNetwork.getNetworkHandle();
                        registerNetworkCallbacks();
                    }
                } else {
                    this.dns_server = dnsServerV4;
                }
            }
        }
        this.vpn_dns = VPN_VIRTUAL_DNS_SERVER;
        this.vpn_ipv4 = VPN_IP_ADDRESS;
        this.last_bytes = 0L;
        this.last_connections = 0;
        this.mLowMemory = false;
        this.conn_reg = new ConnectionsRegister(this, CONNECTIONS_LOG_SIZE);
        if (this.mSettings.full_payload) {
            httpLog = new HttpLog();
        } else {
            httpLog = null;
        }
        this.mHttpLog = httpLog;
        this.mDumper = null;
        this.mDumpQueue = null;
        this.mPendingUpdates.clear();
        this.mPcapFname = null;
        HAS_ERROR = false;
        CaptureSettings captureSettings5 = this.mSettings;
        Prefs.DumpMode dumpMode = captureSettings5.dump_mode;
        if (dumpMode == Prefs.DumpMode.HTTP_SERVER) {
            this.mDumper = new HTTPServer(this, captureSettings5.http_server_port, captureSettings5.pcapng_format);
        } else if (dumpMode == Prefs.DumpMode.PCAP_FILE) {
            if (!captureSettings5.pcap_name.isEmpty()) {
                str = this.mSettings.pcap_name;
            } else {
                str = Utils.getUniquePcapFileName(this, this.mSettings.pcapng_format);
            }
            this.mPcapFname = str;
            if (!this.mSettings.pcap_uri.isEmpty()) {
                this.mPcapUri = Uri.parse(this.mSettings.pcap_uri);
            } else {
                this.mPcapUri = Utils.getDownloadsUri(this, this.mPcapFname);
            }
            Uri uri = this.mPcapUri;
            if (uri == null) {
                return abortStart();
            }
            this.mDumper = new FileDumper(this, uri);
        } else if (dumpMode == Prefs.DumpMode.UDP_EXPORTER) {
            try {
                this.mDumper = new UDPDumper(new InetSocketAddress(InetAddress.getByName(captureSettings5.collector_address), this.mSettings.collector_port), this.mSettings.pcapng_format);
            } catch (UnknownHostException e) {
                reportError(e.getLocalizedMessage());
                e.printStackTrace();
                return abortStart();
            }
        } else if (dumpMode == Prefs.DumpMode.TCP_EXPORTER) {
            try {
                this.mDumper = new TCPDumper(new InetSocketAddress(InetAddress.getByName(captureSettings5.collector_address), this.mSettings.collector_port), this.mSettings.pcapng_format);
            } catch (UnknownHostException e2) {
                reportError(e2.getLocalizedMessage());
                e2.printStackTrace();
                return abortStart();
            }
        }
        if (this.mDumper != null) {
            this.mDumpQueue = new LinkedBlockingDeque<>(64);
        }
        this.mSocks5Address = "";
        CaptureSettings captureSettings6 = this.mSettings;
        if (captureSettings6.socks5_enabled || captureSettings6.tls_decryption) {
            z = true;
        } else {
            z = false;
        }
        this.mSocks5Enabled = z;
        if (z) {
            if (captureSettings6.tls_decryption) {
                this.mSocks5Address = "127.0.0.1";
                this.mSocks5Port = MitmReceiver.TLS_DECRYPTION_PROXY_PORT;
                this.mSocks5Auth = Utils.genRandomString(8) + ":" + Utils.genRandomString(8);
                MitmReceiver mitmReceiver = new MitmReceiver(this, this.mSettings, this.mSocks5Auth);
                this.mMitmReceiver = mitmReceiver;
                try {
                    if (!mitmReceiver.start()) {
                        return abortStart();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return abortStart();
                }
            } else {
                this.mSocks5Address = captureSettings6.socks5_proxy_address;
                this.mSocks5Port = captureSettings6.socks5_proxy_port;
                if (captureSettings6.socks5_username.isEmpty() || this.mSettings.socks5_password.isEmpty()) {
                    this.mSocks5Auth = null;
                } else {
                    this.mSocks5Auth = this.mSettings.socks5_username + ":" + this.mSettings.socks5_password;
                }
            }
        }
        CaptureSettings captureSettings7 = this.mSettings;
        if (!captureSettings7.tls_decryption || captureSettings7.root_capture || captureSettings7.readFromPcap()) {
            this.mDecryptionList = null;
        } else {
            this.mDecryptionList = PCAPdroid.getInstance().getDecryptionList();
        }
        HashSet<String> hashSet = this.mSettings.app_filter;
        if (hashSet == null || hashSet.isEmpty()) {
            this.mAppFilterUids = new int[0];
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = this.mSettings.app_filter.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add(Integer.valueOf(Utils.getPackageUid(getPackageManager(), it.next(), 0)));
                } catch (PackageManager.NameNotFoundException e4) {
                    e4.printStackTrace();
                }
            }
            this.mAppFilterUids = new int[arrayList.size()];
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                this.mAppFilterUids[i4] = ((Integer) obj).intValue();
                i4++;
            }
        }
        if (this.mSettings.readFromPcap() || !Prefs.isMalwareDetectionEnabled(this, this.mPrefs)) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.mMalwareDetectionEnabled = z2;
        if (this.mSettings.readFromPcap() || !Prefs.isFirewallEnabled(this, this.mPrefs)) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.mFirewallEnabled = z3;
        CaptureSettings captureSettings8 = this.mSettings;
        if (!captureSettings8.root_capture && !captureSettings8.readFromPcap()) {
            Log.m583i(TAG, "Using DNS server " + this.dns_server);
            VpnService.Builder mtu = new VpnService.Builder(this).setMtu(VPN_MTU);
            if (Build.VERSION.SDK_INT >= 29) {
                mtu.setMetered(false);
            }
            if (getIPv4Enabled() == 1) {
                mtu.addAddress(this.vpn_ipv4, 30).addRoute("0.0.0.0", 1).addRoute("128.0.0.0", 1).addDnsServer(this.vpn_dns);
            }
            if (getIPv6Enabled() == 1) {
                mtu.addAddress(VPN_IP6_ADDRESS, 128);
                mtu.addRoute("2000::", 3);
                mtu.addRoute("fc00::", 7);
                try {
                    mtu.addDnsServer(InetAddress.getByName(Prefs.getDnsServerV6(this.mPrefs)));
                } catch (IllegalArgumentException | UnknownHostException unused) {
                    Log.m581w(TAG, "Could not set IPv6 DNS server");
                }
            }
            HashSet<String> hashSet2 = this.mSettings.app_filter;
            if (hashSet2 == null || hashSet2.isEmpty()) {
                for (String str3 : this.mPrefs.getStringSet(Prefs.PREF_VPN_EXCEPTIONS, new HashSet())) {
                    try {
                        mtu.addDisallowedApplication(str3);
                    } catch (PackageManager.NameNotFoundException e5) {
                        e5.printStackTrace();
                    }
                }
                if (this.mSettings.tls_decryption) {
                    try {
                        mtu.addDisallowedApplication(MitmAPI.PACKAGE_NAME);
                    } catch (PackageManager.NameNotFoundException e6) {
                        e6.printStackTrace();
                    }
                }
            } else {
                Log.m587d(TAG, "Setting app filter: " + this.mSettings.app_filter);
                try {
                    Iterator<String> it2 = this.mSettings.app_filter.iterator();
                    while (it2.hasNext()) {
                        mtu.addAllowedApplication(it2.next());
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    Toast.makeText(this, String.format(getResources().getString(C0130R.string.app_not_found), this.mSettings.app_filter), 0).show();
                    return abortStart();
                }
            }
            try {
                this.mParcelFileDescriptor = mtu.setSession(VpnSessionName).establish();
            } catch (IllegalArgumentException | IllegalStateException | SecurityException e7) {
                e7.printStackTrace();
                Utils.showToast(this, C0130R.string.vpn_setup_failed, new Object[0]);
                return abortStart();
            }
        }
        this.mMalwareWhitelist = PCAPdroid.getInstance().getMalwareWhitelist();
        Blacklists blacklists = PCAPdroid.getInstance().getBlacklists();
        this.mBlacklists = blacklists;
        if (this.mMalwareDetectionEnabled && !blacklists.needsUpdate(true)) {
            reloadBlacklists();
        }
        checkBlacklistsUpdates(true);
        this.mBlocklist = PCAPdroid.getInstance().getBlocklist();
        this.mFirewallWhitelist = PCAPdroid.getInstance().getFirewallWhitelist();
        this.mNumUpdatesInProgress.set(0);
        Thread thread = new Thread(new CaptureService$$ExternalSyntheticLambda0(5, this), "UpdateListener");
        this.mConnUpdateThread = thread;
        thread.start();
        if (this.mDumper != null) {
            Thread thread2 = new Thread(new CaptureService$$ExternalSyntheticLambda0(6, this), "DumperThread");
            this.mDumperThread = thread2;
            thread2.start();
        }
        if (this.mFirewallEnabled) {
            this.mNewAppsInstallReceiver = new BroadcastReceiver() { // from class: com.emanuelef.remote_capture.CaptureService.1
                {
                    CaptureService.this = this;
                }

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent2) {
                    String str4;
                    String str5;
                    if ("android.intent.action.PACKAGE_ADDED".equals(intent2.getAction())) {
                        boolean booleanExtra = intent2.getBooleanExtra("android.intent.extra.REPLACING", false);
                        String schemeSpecificPart = intent2.getData().getSchemeSpecificPart();
                        if (!booleanExtra && Prefs.blockNewApps(CaptureService.this.mPrefs) && CaptureService.this.mBlocklist.addApp(schemeSpecificPart)) {
                            CaptureService.this.mBlocklist.save();
                            CaptureService.this.reloadBlocklist();
                            AppDescriptor resolveInstalledApp = AppsResolver.resolveInstalledApp(CaptureService.this.getPackageManager(), schemeSpecificPart, 0);
                            if (resolveInstalledApp != null) {
                                str4 = resolveInstalledApp.getName();
                            } else {
                                str4 = schemeSpecificPart;
                            }
                            StringBuilder sb = new StringBuilder("Blocking newly installed app: ");
                            sb.append(schemeSpecificPart);
                            if (resolveInstalledApp != null) {
                                str5 = " - " + resolveInstalledApp.getUid();
                            } else {
                                str5 = "";
                            }
                            sb.append(str5);
                            Log.m583i(CaptureService.TAG, sb.toString());
                            PendingIntent activity = PendingIntent.getActivity(CaptureService.this, 0, new Intent(CaptureService.this, FirewallActivity.class), Utils.getIntentFlags(0));
                            PendingIntent broadcast = PendingIntent.getBroadcast(CaptureService.this, 0, new Intent(CaptureService.this, ActionReceiver.class).putExtra(ActionReceiver.EXTRA_UNBLOCK_APP, schemeSpecificPart), Utils.getIntentFlags(134217728));
                            NotificationManagerCompat notificationManagerCompat = new NotificationManagerCompat(context);
                            if (notificationManagerCompat.areNotificationsEnabled()) {
                                NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(CaptureService.this, CaptureService.NOTIFY_CHAN_OTHER);
                                notificationCompat$Builder.mContentIntent = activity;
                                notificationCompat$Builder.mNotification.icon = C0130R.C0131drawable.ic_logo;
                                notificationCompat$Builder.mColor = BundleKt.getColor(CaptureService.this, C0130R.color.colorPrimary);
                                notificationCompat$Builder.mVisibility = 1;
                                notificationCompat$Builder.mCategory = "status";
                                notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(CaptureService.this.getString(C0130R.string.app_blocked));
                                notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(CaptureService.this.getString(C0130R.string.app_blocked_info, str4));
                                notificationCompat$Builder.setFlag(16, true);
                                notificationCompat$Builder.mActions.add(new NotificationCompat$Action(C0130R.C0131drawable.ic_check_solid, CaptureService.this.getString(C0130R.string.action_unblock), broadcast));
                                notificationManagerCompat.notify(3, notificationCompat$Builder.build());
                            }
                        }
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            registerReceiver(this.mNewAppsInstallReceiver, intentFilter);
        }
        this.mQueueFull = false;
        Thread thread3 = new Thread(this, "PacketCapture");
        this.mCaptureThread = thread3;
        thread3.start();
        return 1;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        boolean z;
        String trimlvl2str = Utils.trimlvl2str(i);
        boolean z2 = false;
        if (i == 20 || i < 10) {
            z = false;
        } else {
            z = true;
        }
        if (z && i >= 80) {
            z2 = true;
        }
        Log.m587d(TAG, "onTrimMemory: " + trimlvl2str + " - low=" + z + ", critical=" + z2);
        if (z2 && !this.mLowMemory) {
            handleLowMemory();
        }
    }

    public int pcapDumpEnabled() {
        if (this.mSettings.dump_mode != Prefs.DumpMode.NONE) {
            return 1;
        }
        return 0;
    }

    @Override // android.net.VpnService
    public boolean protect(int i) {
        if (this.mSettings.root_capture) {
            return true;
        }
        return super.protect(i);
    }

    public void reloadBlocklist() {
        if (this.mBilling.isFirewallVisible()) {
            Log.m583i(TAG, "reloading firewall blocklist");
            reloadBlocklist(this.mBlocklist.toListDescriptor());
        }
    }

    public void reloadFirewallWhitelist() {
        if (this.mBilling.isFirewallVisible()) {
            Log.m583i(TAG, "reloading firewall whitelist");
            reloadFirewallWhitelist(Prefs.isFirewallWhitelistMode(this.mPrefs) ? this.mFirewallWhitelist.toListDescriptor() : null);
        }
    }

    public void reportError(String str) {
        HAS_ERROR = true;
        this.mHandler.post(new CaptureService$$ExternalSyntheticLambda5(this, str, 0));
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean resolveHosts = resolveHosts();
        this.mUnderlyingNetwork = null;
        if (resolveHosts) {
            CaptureSettings captureSettings = this.mSettings;
            if (captureSettings.root_capture || captureSettings.readFromPcap()) {
                if (this.mSettings.root_capture && checkCallingOrSelfPermission(Utils.INTERACT_ACROSS_USERS) != 0) {
                    final boolean rootGrantPermission = Utils.rootGrantPermission(this, Utils.INTERACT_ACROSS_USERS);
                    this.mHandler.post(new Runnable() { // from class: com.emanuelef.remote_capture.CaptureService$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            CaptureService.this.lambda$run$4(rootGrantPermission);
                        }
                    });
                }
                runPacketLoop(-1, this, Build.VERSION.SDK_INT);
            } else {
                ParcelFileDescriptor parcelFileDescriptor = this.mParcelFileDescriptor;
                if (parcelFileDescriptor != null) {
                    int fd = parcelFileDescriptor.getFd();
                    int fdSetSize = getFdSetSize();
                    if (fd <= 0 || fd >= fdSetSize) {
                        Log.m585e(TAG, "Invalid VPN fd: " + fd);
                    } else {
                        Log.m587d(TAG, "VPN fd: " + fd + " - FD_SETSIZE: " + fdSetSize);
                        runPacketLoop(fd, this, Build.VERSION.SDK_INT);
                        this.mIsAlwaysOnVPN = false;
                    }
                }
            }
        }
        if (this.mMalwareDetectionEnabled) {
            this.mBlacklists.save();
        }
        ParcelFileDescriptor parcelFileDescriptor2 = this.mParcelFileDescriptor;
        if (parcelFileDescriptor2 != null) {
            try {
                parcelFileDescriptor2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.mParcelFileDescriptor = null;
        }
        stopAndJoinThreads();
        stopService();
        this.mLock.lock();
        this.mCaptureThread = null;
        this.mCaptureStopped.signalAll();
        this.mLock.unlock();
        this.mHandler.post(new CaptureService$$ExternalSyntheticLambda0(4, this));
    }

    public void sendStatsDump(CaptureStats captureStats) {
        this.last_bytes = captureStats.bytes_sent + captureStats.bytes_rcvd;
        this.last_connections = captureStats.tot_conns;
        this.mHandler.post(new CaptureService$$ExternalSyntheticLambda0(1, this));
        lastStats.postValue(captureStats);
    }

    public void startConnectionsUpdate() {
        HttpLog httpLog;
        if (this.mNumUpdatesInProgress.incrementAndGet() == 1 && (httpLog = this.mHttpLog) != null) {
            httpLog.startConnectionsUpdates();
        }
    }

    public void stopPcapDump() {
        Thread thread;
        if (this.mDumpQueue != null && (thread = this.mDumperThread) != null && thread.isAlive()) {
            this.mDumpQueue.offer(new byte[0]);
        }
    }

    public void updateConnections(ConnectionDescriptor[] connectionDescriptorArr, ConnectionUpdate[] connectionUpdateArr) {
        if (!this.mQueueFull && !this.mPendingUpdates.offer(new Pair<>(connectionDescriptorArr, connectionUpdateArr))) {
            Log.m585e(TAG, "The updates queue is full, this should never happen!");
            this.mQueueFull = true;
            this.mHandler.post(new CaptureService$$ExternalSyntheticLambda1(0));
        }
    }

    public static String getLibprogPath(Context context, String str) {
        String str2 = context.getApplicationInfo().nativeLibraryDir;
        return str2 + "/lib" + str + ".so";
    }
}
