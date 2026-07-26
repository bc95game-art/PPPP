package com.emanuelef.remote_capture.fragments;
/* loaded from: classes.dex */
public final /* synthetic */ class HttpLogFragment$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ HttpLogFragment f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ HttpLogFragment$$ExternalSyntheticLambda0(HttpLogFragment httpLogFragment, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = httpLogFragment;
        this.f$1 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$onHttpRequestUpdated$10(this.f$1);
                return;
            default:
                this.f$0.lambda$onHttpRequestAdded$9(this.f$1);
                return;
        }
    }
}
