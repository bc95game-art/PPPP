package com.emanuelef.remote_capture.pcap_dump;

import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.interfaces.PcapDumper;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Iterator;
/* loaded from: classes.dex */
public class TCPDumper implements PcapDumper {
    private static final String TAG = "TCPDumper";
    private DataOutputStream mDataOut;
    private final boolean mPcapngFormat;
    private boolean mSendHeader = true;
    private final InetSocketAddress mServer;
    private Socket mSocket;

    public TCPDumper(InetSocketAddress inetSocketAddress, boolean z) {
        this.mServer = inetSocketAddress;
        this.mPcapngFormat = z;
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void dumpData(byte[] bArr) {
        int i = 0;
        if (this.mSendHeader) {
            this.mSendHeader = false;
            this.mDataOut.write(CaptureService.getPcapHeader());
        }
        Iterator<Integer> iterPcapRecords = Utils.iterPcapRecords(bArr, this.mPcapngFormat);
        while (iterPcapRecords.hasNext()) {
            int intValue = iterPcapRecords.next().intValue();
            this.mDataOut.write(bArr, i, intValue);
            i += intValue;
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public String getBpf() {
        return "not (host " + this.mServer.getAddress().getHostAddress() + " and tcp port " + this.mServer.getPort() + ")";
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void startDumper() {
        Socket socket = new Socket();
        this.mSocket = socket;
        try {
            socket.connect(this.mServer, 1000);
            this.mDataOut = new DataOutputStream(this.mSocket.getOutputStream());
            CaptureService.requireInstance().protect(this.mSocket);
        } catch (Throwable th) {
            this.mSocket.close();
            throw th;
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void stopDumper() {
        try {
            this.mDataOut.close();
        } finally {
            this.mSocket.close();
        }
    }
}
