package com.emanuelef.remote_capture.fragments;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public final /* synthetic */ class HttpLogFragment$$ExternalSyntheticLambda6 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ HttpLogFragment f$0;

    public /* synthetic */ HttpLogFragment$$ExternalSyntheticLambda6(HttpLogFragment httpLogFragment, int i) {
        this.$r8$classId = i;
        this.f$0 = httpLogFragment;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$exportHttpLogHar$19(dialogInterface);
                return;
            default:
                this.f$0.lambda$dumpHttpLog$14(dialogInterface);
                return;
        }
    }
}
