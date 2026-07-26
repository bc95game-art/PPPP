package com.emanuelef.remote_capture.activities;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.emanuelef.remote_capture.fragments.prefs.PortMapFragment;
/* loaded from: classes.dex */
public final /* synthetic */ class AboutActivity$$ExternalSyntheticLambda10 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ View f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ AboutActivity$$ExternalSyntheticLambda10(Object obj, View view, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = view;
        this.f$2 = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.$r8$classId) {
            case 0:
                ((AboutActivity) this.f$0).lambda$showLicenseDialog$3(this.f$1, (String) this.f$2, view);
                return;
            default:
                ((PortMapFragment) this.f$0).lambda$openAddDialog$3(this.f$1, (AlertDialog) this.f$2, view);
                return;
        }
    }
}
