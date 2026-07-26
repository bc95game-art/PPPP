package com.emanuelef.remote_capture.fragments;

import android.content.Context;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.HttpDetailsActivity;
import com.emanuelef.remote_capture.fragments.prefs.GeoipSettings;
/* loaded from: classes.dex */
public final /* synthetic */ class ConnectionsFragment$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ConnectionsFragment$$ExternalSyntheticLambda6(int i, Object obj, Object obj2, boolean z) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = z;
        this.f$2 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((ConnectionsFragment) this.f$0).lambda$dumpCsv$19(this.f$1, (Utils.UriStat) this.f$2);
                return;
            case 1:
                ((HttpDetailsActivity) this.f$0).lambda$exportHar$4(this.f$1, (Utils.UriStat) this.f$2);
                return;
            default:
                ((GeoipSettings) this.f$0).lambda$downloadDatabases$4(this.f$1, (Context) this.f$2);
                return;
        }
    }
}
