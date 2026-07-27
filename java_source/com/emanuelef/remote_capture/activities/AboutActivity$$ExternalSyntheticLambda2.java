package com.emanuelef.remote_capture.activities;

import android.content.DialogInterface;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final /* synthetic */ class AboutActivity$$ExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AboutActivity$$ExternalSyntheticLambda2(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                ((AboutActivity) this.f$0).lambda$onMenuItemSelected$2((String) this.f$1, dialogInterface, i);
                return;
            default:
                HttpDetailsActivity.$r8$lambda$O_xILvFjyTT6TITAVjO9MKTzczM((boolean[]) this.f$0, (ExecutorService) this.f$1, dialogInterface, i);
                return;
        }
    }
}
