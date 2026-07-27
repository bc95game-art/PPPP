package com.emanuelef.remote_capture.adapters;

import android.view.View;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment;
import com.emanuelef.remote_capture.fragments.HttpLogFragment;
/* loaded from: classes.dex */
public final /* synthetic */ class HttpLogAdapter$$ExternalSyntheticLambda0 implements View.OnLongClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ HttpLogAdapter$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        boolean lambda$onViewCreated$4;
        switch (this.$r8$classId) {
            case 0:
                return HttpLogAdapter.$r8$lambda$6vs4mG4A046uy7479GTJJ9mhxOM((HttpLogAdapter) this.f$0, view);
            case 1:
                lambda$onViewCreated$4 = ((ConnectionsFragment) this.f$0).lambda$onViewCreated$4(view);
                return lambda$onViewCreated$4;
            default:
                return HttpLogFragment.$r8$lambda$C0Z4Wx4jCPQjjfsZOstGdnm7AAM((HttpLogFragment) this.f$0, view);
        }
    }
}
