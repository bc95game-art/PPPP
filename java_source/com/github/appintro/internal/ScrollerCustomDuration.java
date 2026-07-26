package com.github.appintro.internal;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class ScrollerCustomDuration extends Scroller {
    private double scrollDurationFactor = 6.0d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollerCustomDuration(Context context, Interpolator interpolator) {
        super(context, interpolator);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
    }

    public final double getScrollDurationFactor() {
        return this.scrollDurationFactor;
    }

    public final void setScrollDurationFactor(double d) {
        this.scrollDurationFactor = d;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, (int) (i5 * this.scrollDurationFactor));
    }
}
