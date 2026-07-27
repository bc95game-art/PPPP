package com.emanuelef.remote_capture.activities;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda3(MainActivity mainActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = mainActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$checkPermissions$6(dialogInterface, i);
                return;
            case 1:
                this.f$0.lambda$checkVpnLockdownNotice$12(dialogInterface, i);
                return;
            case 2:
                this.f$0.lambda$checkDecryptionRulesNotice$9(dialogInterface, i);
                return;
            case 3:
                this.f$0.lambda$startCapture$14(dialogInterface, i);
                return;
            case 4:
                this.f$0.lambda$startCapture$15(dialogInterface, i);
                return;
            case 5:
                this.f$0.lambda$startCapture$16(dialogInterface, i);
                return;
            case 6:
                this.f$0.lambda$showRemoteServerAlert$18(dialogInterface, i);
                return;
            default:
                this.f$0.lambda$checkLoadedPcap$11(dialogInterface, i);
                return;
        }
    }
}
