package com.google.android.material.textfield;

import com.google.android.material.internal.CheckableImageButton;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class NoEndIconDelegate extends EndIconDelegate {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoEndIconDelegate(EndCompoundLayout endCompoundLayout, int i) {
        super(endCompoundLayout);
        this.$r8$classId = i;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public void setUp() {
        switch (this.$r8$classId) {
            case 1:
                EndCompoundLayout endCompoundLayout = this.endLayout;
                endCompoundLayout.endIconOnLongClickListener = null;
                CheckableImageButton checkableImageButton = endCompoundLayout.endIconView;
                checkableImageButton.setOnLongClickListener(null);
                LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, null);
                return;
            default:
                return;
        }
    }
}
