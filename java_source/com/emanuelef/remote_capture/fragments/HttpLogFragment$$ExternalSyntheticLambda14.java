package com.emanuelef.remote_capture.fragments;

import androidx.fragment.app.Fragment;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.Slider;
/* loaded from: classes.dex */
public final /* synthetic */ class HttpLogFragment$$ExternalSyntheticLambda14 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Fragment f$0;

    public /* synthetic */ HttpLogFragment$$ExternalSyntheticLambda14(Fragment fragment, int i) {
        this.$r8$classId = i;
        this.f$0 = fragment;
    }

    public final void onValueChange(Slider slider, float f, boolean z) {
        switch (this.$r8$classId) {
            case 0:
                ((HttpLogFragment) this.f$0).lambda$onViewCreated$1(slider, f, z);
                return;
            default:
                ((ConnectionsFragment) this.f$0).lambda$onViewCreated$1(slider, f, z);
                return;
        }
    }

    public final /* bridge */ void onValueChange(BaseSlider baseSlider, float f, boolean z) {
        switch (this.$r8$classId) {
            case 0:
            default:
                onValueChange((Slider) baseSlider, f, z);
                return;
        }
    }
}
