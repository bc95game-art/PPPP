package com.google.android.material.chip;

import android.widget.CompoundButton;
import com.emanuelef.remote_capture.fragments.FirewallStatus;
import com.emanuelef.remote_capture.fragments.prefs.PortMapFragment;
import com.emanuelef.remote_capture.views.AppSelectDialog;
import com.emanuelef.remote_capture.views.AppsListView;
import com.google.android.material.internal.CheckableGroup;
import com.google.android.material.internal.MaterialCheckable;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
/* loaded from: classes.dex */
public final /* synthetic */ class Chip$$ExternalSyntheticLambda0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Chip$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (this.$r8$classId) {
            case 0:
                Chip chip = (Chip) this.f$0;
                MaterialCheckable.OnCheckedChangeListener onCheckedChangeListener = chip.onCheckedChangeListenerInternal;
                if (onCheckedChangeListener != null) {
                    CheckableGroup checkableGroup = (CheckableGroup) ((ReadonlyStateFlow) onCheckedChangeListener).$$delegate_0;
                    if (!z ? checkableGroup.uncheckInternal(chip, checkableGroup.selectionRequired) : checkableGroup.checkInternal(chip)) {
                        checkableGroup.onCheckedStateChanged();
                    }
                }
                CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = chip.onCheckedChangeListener;
                if (onCheckedChangeListener2 != null) {
                    onCheckedChangeListener2.onCheckedChanged(compoundButton, z);
                    return;
                }
                return;
            case 1:
                ((FirewallStatus) this.f$0).lambda$onCreateMenu$1(compoundButton, z);
                return;
            case 2:
                ((PortMapFragment) this.f$0).lambda$onCreateMenu$0(compoundButton, z);
                return;
            default:
                AppSelectDialog.lambda$getDialog$2((AppsListView) this.f$0, compoundButton, z);
                return;
        }
    }
}
