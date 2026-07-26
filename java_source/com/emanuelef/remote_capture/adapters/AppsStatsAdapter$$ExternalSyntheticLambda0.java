package com.emanuelef.remote_capture.adapters;

import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.AppStats;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.Comparator;
/* loaded from: classes.dex */
public final /* synthetic */ class AppsStatsAdapter$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AppsStatsAdapter$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return AppsStatsAdapter.$r8$lambda$OM70x6gm8s6_s5Qt11M6fxBge_U((AppsStatsAdapter) this.f$0, (AppStats) obj, (AppStats) obj2);
            case 1:
                return AppsTogglesAdapter.$r8$lambda$HhOcOiE6NsYzRf1HJQJOJpCwoZU((AppsTogglesAdapter) this.f$0, (AppDescriptor) obj, (AppDescriptor) obj2);
            default:
                MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f$0;
                MaterialButton materialButton = (MaterialButton) obj;
                MaterialButton materialButton2 = (MaterialButton) obj2;
                int compareTo = Boolean.valueOf(materialButton.checked).compareTo(Boolean.valueOf(materialButton2.checked));
                if (compareTo != 0) {
                    return compareTo;
                }
                int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                return Integer.compare(materialButtonToggleGroup.indexOfChild(materialButton), materialButtonToggleGroup.indexOfChild(materialButton2));
        }
    }
}
