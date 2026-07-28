package com.emanuelef.remote_capture.fragments;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.emanuelef.remote_capture.fragments.mitmwizard.StepFragment;
/* loaded from: classes.dex */
public final /* synthetic */ class ConnectionOverview$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Fragment f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ ConnectionOverview$$ExternalSyntheticLambda0(int i, int i2, Fragment fragment) {
        this.$r8$classId = i2;
        this.f$0 = fragment;
        this.f$1 = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.$r8$classId) {
            case 0:
                ((ConnectionOverview) this.f$0).lambda$connectionUpdated$2(this.f$1, view);
                return;
            default:
                StepFragment.$r8$lambda$BH6aI_544mlIrPbj7ctUS9kbNzU((StepFragment) this.f$0, this.f$1, view);
                return;
        }
    }
}
