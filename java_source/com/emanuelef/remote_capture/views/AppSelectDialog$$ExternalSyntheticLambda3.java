package com.emanuelef.remote_capture.views;

import android.content.DialogInterface;
import com.emanuelef.remote_capture.activities.AboutActivity;
import com.emanuelef.remote_capture.activities.HttpDetailsActivity;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment;
import com.emanuelef.remote_capture.fragments.prefs.GeoipSettings;
/* loaded from: classes.dex */
public final /* synthetic */ class AppSelectDialog$$ExternalSyntheticLambda3 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AppSelectDialog$$ExternalSyntheticLambda3(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.$r8$classId) {
            case 0:
                ((AppSelectDialog) this.f$0).lambda$show$1(dialogInterface);
                return;
            case 1:
                ((AboutActivity) this.f$0).lambda$showLicenseDialog$7(dialogInterface);
                return;
            case 2:
                ((HttpDetailsActivity) this.f$0).lambda$exportHar$3(dialogInterface);
                return;
            case 3:
                ((ConnectionsFragment) this.f$0).lambda$dumpCsv$18(dialogInterface);
                return;
            default:
                ((GeoipSettings) this.f$0).lambda$downloadDatabases$3(dialogInterface);
                return;
        }
    }
}
