package com.emanuelef.remote_capture.activities;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda7 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda7(MainActivity mainActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = mainActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$startOpenPcap$24(dialogInterface);
                return;
            default:
                this.f$0.lambda$showPcapActionDialog$22(dialogInterface);
                return;
        }
    }
}
