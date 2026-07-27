package com.emanuelef.remote_capture;
/* loaded from: classes.dex */
public class ZstdDecoder {
    static {
        System.loadLibrary("zstd_dec");
    }

    public static native byte[] decompress(byte[] bArr);
}
