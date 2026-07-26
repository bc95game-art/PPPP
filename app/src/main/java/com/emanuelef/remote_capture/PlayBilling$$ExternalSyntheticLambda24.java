package com.emanuelef.remote_capture;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.EditText;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.activities.AboutActivity;
/* loaded from: classes.dex */
public final /* synthetic */ class PlayBilling$$ExternalSyntheticLambda24 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ PlayBilling f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda24(PlayBilling playBilling, PlayBilling.QrActivationRequest qrActivationRequest, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = playBilling;
        this.f$1 = qrActivationRequest;
        this.f$2 = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.lambda$performQrActivation$29((PlayBilling.QrActivationRequest) this.f$1, (String) this.f$2, dialogInterface, i);
                return;
            case 1:
                this.f$0.lambda$performQrActivation$31((PlayBilling.QrActivationRequest) this.f$1, (Activity) this.f$2, dialogInterface, i);
                return;
            default:
                AboutActivity.m90$r8$lambda$f21u9Ah6RxqJyya9mLvjPPKrOA((AboutActivity) this.f$1, this.f$0, (EditText) this.f$2, dialogInterface, i);
                return;
        }
    }

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda24(AboutActivity aboutActivity, PlayBilling playBilling, EditText editText) {
        this.$r8$classId = 2;
        this.f$1 = aboutActivity;
        this.f$0 = playBilling;
        this.f$2 = editText;
    }
}
