package com.emanuelef.remote_capture.views;

import android.content.DialogInterface;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.fragments.ConnectionPayload;
import com.emanuelef.remote_capture.fragments.HttpPayloadFragment;
import com.emanuelef.remote_capture.fragments.prefs.GeoipSettings;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final /* synthetic */ class AppSelectDialog$$ExternalSyntheticLambda2 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AppSelectDialog$$ExternalSyntheticLambda2(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        switch (this.$r8$classId) {
            case 0:
                AppSelectDialog.$r8$lambda$7RWGHfD_JVOYvz6VfehKxvofHIM((AppSelectDialog) this.f$0, dialogInterface);
                return;
            case 1:
                ((MainActivity) this.f$0).lambda$startOpenPcap$23(dialogInterface);
                return;
            case 2:
                ((ConnectionPayload) this.f$0).lambda$setMenuVisibility$2(dialogInterface);
                return;
            case 3:
                ((HttpPayloadFragment) this.f$0).lambda$setMenuVisibility$2(dialogInterface);
                return;
            default:
                GeoipSettings.m852$r8$lambda$aCWhBkC6hLpHGRwZYSCCJYhLGQ((ExecutorService) this.f$0, dialogInterface);
                return;
        }
    }
}
