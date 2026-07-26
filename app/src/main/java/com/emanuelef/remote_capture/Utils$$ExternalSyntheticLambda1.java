package com.emanuelef.remote_capture;

import android.content.DialogInterface;
/* loaded from: classes.dex */
public final /* synthetic */ class Utils$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Utils$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                Utils.$r8$lambda$YpmBfldm5Nj_5FuxxDpe_T6xBjQ(dialogInterface, i);
                return;
            case 1:
                PlayBilling.lambda$showUnlockToken$33(dialogInterface, i);
                return;
            case 2:
                PlayBilling.lambda$requestQrLicenseCode$24(dialogInterface, i);
                return;
            case 3:
                PlayBilling.lambda$performQrActivation$30(dialogInterface, i);
                return;
            case 4:
                PlayBilling.lambda$performQrActivation$32(dialogInterface, i);
                return;
            default:
                PlayBilling.lambda$requestUnlockToken$18(dialogInterface, i);
                return;
        }
    }
}
