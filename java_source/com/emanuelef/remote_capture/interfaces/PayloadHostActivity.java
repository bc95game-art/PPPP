package com.emanuelef.remote_capture.interfaces;

import com.emanuelef.remote_capture.adapters.PayloadAdapter;
/* loaded from: classes.dex */
public interface PayloadHostActivity extends PayloadAdapter.ExportPayloadHandler {

    /* loaded from: classes.dex */
    public interface ConnUpdateListener {
        void connectionUpdated();
    }

    void addConnUpdateListener(ConnUpdateListener connUpdateListener);

    void removeConnUpdateListener(ConnUpdateListener connUpdateListener);

    void updateMenuVisibility();

    /* renamed from: com.emanuelef.remote_capture.interfaces.PayloadHostActivity$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static void $default$addConnUpdateListener(PayloadHostActivity payloadHostActivity, ConnUpdateListener connUpdateListener) {
        }

        public static void $default$removeConnUpdateListener(PayloadHostActivity payloadHostActivity, ConnUpdateListener connUpdateListener) {
        }
    }
}
