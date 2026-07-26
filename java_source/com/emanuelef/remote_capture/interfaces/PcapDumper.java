package com.emanuelef.remote_capture.interfaces;
/* loaded from: classes.dex */
public interface PcapDumper {
    void dumpData(byte[] bArr);

    String getBpf();

    void startDumper();

    void stopDumper();
}
