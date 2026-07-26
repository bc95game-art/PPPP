package com.emanuelef.remote_capture.pcap_dump;

import android.content.Context;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.interfaces.PcapDumper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
/* loaded from: classes.dex */
public class HTTPServer implements PcapDumper, Runnable {
    public static final int MAX_CLIENTS = 8;
    private static final String PCAPNG_MIME = "application/x-pcapng";
    private static final String PCAP_MIME = "application/vnd.tcpdump.pcap";
    private static final String TAG = "HTTPServer";
    private final ArrayList<ClientHandler> mClients = new ArrayList<>();
    private final Context mContext;
    private final String mMimeType;
    private final boolean mPcapngFormat;
    private final int mPort;
    private boolean mRunning;
    private ServerSocket mSocket;
    private Thread mThread;

    /* loaded from: classes.dex */
    public static class ChunkedOutputStream extends FilterOutputStream {
        public ChunkedOutputStream(OutputStream outputStream) {
            super(outputStream);
        }

        public void finish() {
            ((FilterOutputStream) this).out.write("0\r\n\r\n".getBytes());
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) {
            ((FilterOutputStream) this).out.write(String.format("%x\r\n", Integer.valueOf(bArr.length)).getBytes());
            ((FilterOutputStream) this).out.write(bArr);
            ((FilterOutputStream) this).out.write("\r\n".getBytes());
            ((FilterOutputStream) this).out.flush();
        }
    }

    /* loaded from: classes.dex */
    public static class ClientHandler implements Runnable {
        static final int INPUT_BUFSIZE = 1024;
        ChunkedOutputStream mChunkedOutputStream;
        final String mFname;
        boolean mHasError;
        boolean mHeaderSent;
        final InputStream mInputStream;
        boolean mIsClosed;
        final String mMimeType;
        final OutputStream mOutputStream;
        boolean mReadyForData;
        Socket mSocket;

        public ClientHandler(Socket socket, String str, String str2) {
            this.mSocket = socket;
            this.mFname = str2;
            this.mInputStream = socket.getInputStream();
            this.mOutputStream = this.mSocket.getOutputStream();
            this.mMimeType = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void close(String str) {
            if (!isClosed()) {
                if (str != null) {
                    Log.i(HTTPServer.TAG, "Client error: ".concat(str));
                    this.mHasError = true;
                } else if (this.mReadyForData) {
                    try {
                        this.mChunkedOutputStream.finish();
                    } catch (IOException unused) {
                    }
                }
                Utils.safeClose(this.mChunkedOutputStream);
                Utils.safeClose(this.mOutputStream);
                Utils.safeClose(this.mInputStream);
                Utils.safeClose(this.mSocket);
                this.mIsClosed = true;
            }
        }

        private void redirectToPcap() {
            Log.d(HTTPServer.TAG, "Redirecting to PCAP: " + this.mFname);
            OutputStream outputStream = this.mOutputStream;
            outputStream.write(("HTTP/1.1 302 Found\r\nLocation: /" + this.mFname + "\r\n\r\n").getBytes());
        }

        public boolean isClosed() {
            return this.mIsClosed;
        }

        public boolean isReadyForData() {
            return this.mReadyForData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable e;
            byte[] bArr = new byte[INPUT_BUFSIZE];
            int i = 0;
            int i2 = 0;
            while (i <= 0) {
                try {
                    i2 += this.mInputStream.read(bArr, i2, 1024 - i2);
                    i = Utils.getEndOfHTTPHeaders(bArr);
                } catch (IOException e2) {
                    e = e2;
                    close(e.getLocalizedMessage());
                    return;
                } catch (NoSuchElementException e3) {
                    e = e3;
                    close(e.getLocalizedMessage());
                    return;
                }
            }
            Log.d(HTTPServer.TAG, "Request headers end at " + i);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, i)));
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                close("Bad request");
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                String nextToken = stringTokenizer.nextToken();
                String nextToken2 = stringTokenizer.nextToken();
                if (!nextToken.equals("GET")) {
                    close("Bad request method");
                } else if (nextToken2.equals("/")) {
                    redirectToPcap();
                    close(null);
                } else {
                    Log.d(HTTPServer.TAG, "URL: " + nextToken2);
                    OutputStream outputStream = this.mOutputStream;
                    outputStream.write(("HTTP/1.1 200 OK\r\nContent-Type: " + this.mMimeType + "\r\nConnection: close\r\nTransfer-Encoding: chunked\r\n\r\n").getBytes());
                    this.mOutputStream.flush();
                    Log.d(HTTPServer.TAG, "Ready for data");
                    this.mChunkedOutputStream = new ChunkedOutputStream(this.mOutputStream);
                    this.mReadyForData = true;
                }
            }
            bufferedReader.close();
        }

        public void sendChunk(byte[] bArr) {
            try {
                if (!this.mHeaderSent) {
                    this.mChunkedOutputStream.write(CaptureService.getPcapHeader());
                    this.mHeaderSent = true;
                }
                this.mChunkedOutputStream.write(bArr);
            } catch (IOException e) {
                close(e.getLocalizedMessage());
            }
        }

        public void stop() {
            Utils.safeClose(this.mSocket);
        }
    }

    public HTTPServer(Context context, int i, boolean z) {
        String str;
        this.mPort = i;
        this.mContext = context;
        this.mPcapngFormat = z;
        if (z) {
            str = PCAPNG_MIME;
        } else {
            str = PCAP_MIME;
        }
        this.mMimeType = str;
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void dumpData(byte[] bArr) {
        synchronized (this) {
            try {
                Iterator<ClientHandler> it = this.mClients.iterator();
                while (it.hasNext()) {
                    ClientHandler next = it.next();
                    if (next.isReadyForData()) {
                        next.sendChunk(bArr);
                    }
                    if (next.isClosed()) {
                        it.remove();
                        Log.d(TAG, "Client closed, active clients: " + this.mClients.size());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public String getBpf() {
        return "not (host " + Utils.getLocalIPAddress(this.mContext) + " and tcp port " + this.mPort + ")";
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c1 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.pcap_dump.HTTPServer.run():void");
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void startDumper() {
        ServerSocket serverSocket = new ServerSocket();
        this.mSocket = serverSocket;
        serverSocket.setReuseAddress(true);
        this.mSocket.bind(new InetSocketAddress(this.mPort));
        this.mRunning = true;
        Thread thread = new Thread(this);
        this.mThread = thread;
        thread.start();
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void stopDumper() {
        this.mRunning = false;
        this.mSocket.close();
        while (true) {
            Thread thread = this.mThread;
            if (thread != null && thread.isAlive()) {
                try {
                    Log.d(TAG, "Joining HTTP thread...");
                    this.mThread.join();
                } catch (InterruptedException unused) {
                }
            } else {
                return;
            }
        }
    }
}
