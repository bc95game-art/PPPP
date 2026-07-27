package com.emanuelef.remote_capture.fragments;
/* loaded from: classes.dex */
public final /* synthetic */ class HttpLogFragment$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ HttpLogFragment f$0;

    public /* synthetic */ HttpLogFragment$$ExternalSyntheticLambda2(HttpLogFragment httpLogFragment, int i) {
        this.$r8$classId = i;
        this.f$0 = httpLogFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$onHttpRequestsClear$11();
                return;
            default:
                this.f$0.recheckScroll();
                return;
        }
    }
}
