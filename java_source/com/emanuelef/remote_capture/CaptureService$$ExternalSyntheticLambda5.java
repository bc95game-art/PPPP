package com.emanuelef.remote_capture;
/* loaded from: classes.dex */
public final /* synthetic */ class CaptureService$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CaptureService f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ CaptureService$$ExternalSyntheticLambda5(CaptureService captureService, String str, int i) {
        this.$r8$classId = i;
        this.f$0 = captureService;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$reportError$6(this.f$1);
                return;
            default:
                this.f$0.lambda$resolveHosts$3(this.f$1);
                return;
        }
    }
}
