package com.google.android.material.internal;

import android.widget.ImageButton;
/* loaded from: classes.dex */
public abstract class VisibilityAwareImageButton extends ImageButton {
    public int userSetVisibility;

    public final int getUserSetVisibility() {
        return this.userSetVisibility;
    }

    public final void internalSetVisibility(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.userSetVisibility = i;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        internalSetVisibility(i, true);
    }
}
