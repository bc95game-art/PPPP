package com.emanuelef.remote_capture.fragments;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.ActionMode;
import android.view.MenuItem;
import com.emanuelef.remote_capture.activities.prefs.EditCtrlPermissions;
import com.emanuelef.remote_capture.fragments.prefs.PortMapFragment;
/* loaded from: classes.dex */
public final /* synthetic */ class FirewallStatus$$ExternalSyntheticLambda2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ FirewallStatus$$ExternalSyntheticLambda2(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                FirewallStatus.m823$r8$lambda$2DYPzqRsLZXWDwgb1FRTrNJqlw((FirewallStatus) this.f$0, (MenuItem) this.f$1, dialogInterface, i);
                return;
            case 1:
                EditCtrlPermissions.m753$r8$lambda$HrYrgNtxbzyo9Sv_KNxSBy7INs((EditCtrlPermissions) this.f$0, (String) this.f$1, dialogInterface, i);
                return;
            case 2:
                ConnectionPayload.$r8$lambda$QHvExettGGJNvFI9t6fS0VcsXhg((ConnectionPayload) this.f$0, (SharedPreferences) this.f$1, dialogInterface, i);
                return;
            case 3:
                EditListFragment.$r8$lambda$wMFTPY4qbVWVwNbC1A05Hcu61RM((EditListFragment) this.f$0, (String) this.f$1, dialogInterface, i);
                return;
            case 4:
                EditListFragment.$r8$lambda$7_dlqGjgobWvYYPGh5gabHMf0UM((EditListFragment) this.f$0, (ActionMode) this.f$1, dialogInterface, i);
                return;
            case 5:
                HttpPayloadFragment.$r8$lambda$nidoN_jkwUUZFCT5zeVDqNNoaKY((HttpPayloadFragment) this.f$0, (SharedPreferences) this.f$1, dialogInterface, i);
                return;
            default:
                PortMapFragment.m856$r8$lambda$zX4SySFKr0E1Y1OS_i0IpquZ38((PortMapFragment) this.f$0, (ActionMode) this.f$1, dialogInterface, i);
                return;
        }
    }
}
