package com.emanuelef.remote_capture.fragments;

import com.emanuelef.remote_capture.Utils;
/* loaded from: classes.dex */
public final /* synthetic */ class HttpLogFragment$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ HttpLogFragment f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Utils.UriStat f$2;

    public /* synthetic */ HttpLogFragment$$ExternalSyntheticLambda1(HttpLogFragment httpLogFragment, boolean z, Utils.UriStat uriStat, int i) {
        this.$r8$classId = i;
        this.f$0 = httpLogFragment;
        this.f$1 = z;
        this.f$2 = uriStat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$exportHttpLogHar$20(this.f$1, this.f$2);
                return;
            default:
                this.f$0.lambda$dumpHttpLog$15(this.f$1, this.f$2);
                return;
        }
    }
}
