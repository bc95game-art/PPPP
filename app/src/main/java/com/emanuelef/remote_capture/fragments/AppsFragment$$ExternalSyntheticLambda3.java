package com.emanuelef.remote_capture.fragments;

import androidx.lifecycle.Observer;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.activities.StatsActivity;
import com.emanuelef.remote_capture.model.CaptureStats;
/* loaded from: classes.dex */
public final /* synthetic */ class AppsFragment$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AppsFragment$$ExternalSyntheticLambda3(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((AppsFragment) this.f$0).lambda$onViewCreated$1((CaptureService.ServiceStatus) obj);
                return;
            case 1:
                ((MainActivity) this.f$0).lambda$onCreate$2((CaptureService.ServiceStatus) obj);
                return;
            case 2:
                StatsActivity.m122$r8$lambda$W9tVy6EFwTdZiRhj17vTe7Y8Z8((StatsActivity) this.f$0, (CaptureStats) obj);
                return;
            case 3:
                BlacklistsFragment.m162$r8$lambda$4KgpzBqpIW5uiMPVk3OzylcTuU((BlacklistsFragment) this.f$0, (CaptureService.ServiceStatus) obj);
                return;
            case 4:
                ((ConnectionsFragment) this.f$0).lambda$onViewCreated$9((CaptureService.ServiceStatus) obj);
                return;
            default:
                ((HttpLogFragment) this.f$0).lambda$onViewCreated$8((CaptureService.ServiceStatus) obj);
                return;
        }
    }
}
