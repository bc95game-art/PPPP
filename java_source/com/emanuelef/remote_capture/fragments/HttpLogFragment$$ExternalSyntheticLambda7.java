package com.emanuelef.remote_capture.fragments;

import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final /* synthetic */ class HttpLogFragment$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ HttpLogFragment f$0;
    public final /* synthetic */ Uri f$1;
    public final /* synthetic */ ArrayList f$2;
    public final /* synthetic */ boolean[] f$3;
    public final /* synthetic */ Handler f$4;

    public /* synthetic */ HttpLogFragment$$ExternalSyntheticLambda7(HttpLogFragment httpLogFragment, Uri uri, ArrayList arrayList, boolean[] zArr, Handler handler, int i) {
        this.$r8$classId = i;
        this.f$0 = httpLogFragment;
        this.f$1 = uri;
        this.f$2 = arrayList;
        this.f$3 = zArr;
        this.f$4 = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$exportHttpLogHar$21(this.f$1, this.f$2, this.f$3, this.f$4);
                return;
            default:
                this.f$0.lambda$dumpHttpLog$16(this.f$1, this.f$2, this.f$3, this.f$4);
                return;
        }
    }
}
