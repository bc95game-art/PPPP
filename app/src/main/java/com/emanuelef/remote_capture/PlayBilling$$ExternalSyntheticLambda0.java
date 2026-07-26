package com.emanuelef.remote_capture;

import android.content.DialogInterface;
import android.content.Intent;
/* loaded from: classes.dex */
public final /* synthetic */ class PlayBilling$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ PlayBilling$$ExternalSyntheticLambda0(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                PlayBilling.m64$r8$lambda$_Bsc8vwuZUK6cOr1L2t4xv5PM((PlayBilling) this.f$0, (String) this.f$1, dialogInterface, i);
                return;
            case 1:
                PlayBilling.m56$r8$lambda$4a9pBJXr2gC0P8YPmNIsHXFfhw((PlayBilling) this.f$0, (String) this.f$1, dialogInterface, i);
                return;
            case 2:
                PlayBilling.m70$r8$lambda$vM4PV2QqI0Cvw4XpWDnfiRyWK8((PlayBilling) this.f$0, (String) this.f$1, dialogInterface, i);
                return;
            default:
                CaptureHelper.$r8$lambda$tvZLgmnwIFZqrGCB3UIM3WaeUrA((CaptureHelper) this.f$0, (Intent) this.f$1, dialogInterface, i);
                return;
        }
    }
}
