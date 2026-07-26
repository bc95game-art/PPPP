package com.emanuelef.remote_capture.interfaces;
/* loaded from: classes.dex */
public interface MitmListener {
    void onMitmGetCaCertificateResult(String str);

    void onMitmServiceConnect();

    void onMitmServiceDisconnect();
}
