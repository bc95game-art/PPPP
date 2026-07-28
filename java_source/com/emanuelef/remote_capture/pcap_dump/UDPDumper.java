package com.emanuelef.remote_capture.pcap_dump;

import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.interfaces.PcapDumper;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Iterator;
/* loaded from: classes.dex */
public class UDPDumper implements PcapDumper {
    private static final String TAG = "UDPDumper";
    private final boolean mPcapngFormat;
    private boolean mSendHeader = true;
    private final InetSocketAddress mServer;
    private DatagramSocket mSocket;

    public UDPDumper(InetSocketAddress inetSocketAddress, boolean z) {
        this.mServer = inetSocketAddress;
        this.mPcapngFormat = z;
    }

    private void sendDatagram(byte[] bArr, int i, int i2) {
        this.mSocket.send(new DatagramPacket(bArr, i, i2, this.mServer));
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void dumpData(byte[] bArr) {
        int i = 0;
        if (this.mSendHeader) {
            this.mSendHeader = false;
            byte[] pcapHeader = CaptureService.getPcapHeader();
            sendDatagram(pcapHeader, 0, pcapHeader.length);
        }
        Iterator<Integer> iterPcapRecords = Utils.iterPcapRecords(bArr, this.mPcapngFormat);
        while (iterPcapRecords.hasNext()) {
            int intValue = iterPcapRecords.next().intValue();
            sendDatagram(bArr, i, intValue);
            i += intValue;
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public String getBpf() {
        return "not (host " + this.mServer.getAddress().getHostAddress() + " and udp port " + this.mServer.getPort() + ")";
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void startDumper() {
        this.mSocket = new DatagramSocket();
        CaptureService.requireInstance().protect(this.mSocket);
    }

    @Override // com.emanuelef.remote_capture.interfaces.PcapDumper
    public void stopDumper() {
        this.mSocket.close();
    }
}
