package com.emanuelef.remote_capture.fragments;

import android.content.DialogInterface;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final /* synthetic */ class HttpLogFragment$$ExternalSyntheticLambda4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ boolean[] f$0;
    public final /* synthetic */ ExecutorService f$1;

    public /* synthetic */ HttpLogFragment$$ExternalSyntheticLambda4(boolean[] zArr, ExecutorService executorService, int i) {
        this.$r8$classId = i;
        this.f$0 = zArr;
        this.f$1 = executorService;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                HttpLogFragment.lambda$exportHttpLogHar$17(this.f$0, this.f$1, dialogInterface, i);
                return;
            case 1:
                ConnectionsFragment.lambda$dumpCsv$16(this.f$0, this.f$1, dialogInterface, i);
                return;
            default:
                HttpLogFragment.lambda$dumpHttpLog$12(this.f$0, this.f$1, dialogInterface, i);
                return;
        }
    }
}
