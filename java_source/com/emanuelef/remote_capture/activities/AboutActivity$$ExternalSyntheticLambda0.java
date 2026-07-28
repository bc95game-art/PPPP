package com.emanuelef.remote_capture.activities;

import android.view.View;
/* loaded from: classes.dex */
public final /* synthetic */ class AboutActivity$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BaseActivity f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AboutActivity$$ExternalSyntheticLambda0(BaseActivity baseActivity, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = baseActivity;
        this.f$1 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((AboutActivity) this.f$0).lambda$updateQrProgress$17((View) this.f$1);
                return;
            case 1:
                ((AboutActivity) this.f$0).lambda$showQrCode$11((View) this.f$1);
                return;
            case 2:
                ((AboutActivity) this.f$0).lambda$showQrCode$13((View) this.f$1);
                return;
            default:
                ((MainActivity) this.f$0).lambda$loadKeylogfile$29((String) this.f$1);
                return;
        }
    }
}
