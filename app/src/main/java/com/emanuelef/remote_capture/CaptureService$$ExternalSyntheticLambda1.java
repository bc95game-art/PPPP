package com.emanuelef.remote_capture;
/* loaded from: classes.dex */
public final /* synthetic */ class CaptureService$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ CaptureService$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                CaptureService.stopPacketLoop();
                return;
            default:
                VpnReconnectService.$r8$lambda$f9fKmzI4JxapiF2h0Nv2wbEaUkI();
                return;
        }
    }
}
