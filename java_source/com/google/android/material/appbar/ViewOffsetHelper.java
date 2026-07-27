package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;
/* loaded from: classes.dex */
public final class ViewOffsetHelper {
    public int layoutLeft;
    public int layoutTop;
    public int offsetTop;
    public final View view;

    public ViewOffsetHelper(View view) {
        this.view = view;
    }

    public final void applyOffsets() {
        int i = this.offsetTop;
        View view = this.view;
        ViewCompat.offsetTopAndBottom(i - (view.getTop() - this.layoutTop), view);
        ViewCompat.offsetLeftAndRight(0 - (view.getLeft() - this.layoutLeft), view);
    }
}
