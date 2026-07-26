package com.google.android.material.animation;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LookupTableInterpolator;
/* loaded from: classes.dex */
public abstract class AnimationUtils {
    public static final LinearInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final FastOutSlowInInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator(0);
    public static final FastOutSlowInInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutSlowInInterpolator(1);
    public static final FastOutSlowInInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LookupTableInterpolator(FastOutSlowInInterpolator.VALUES$2);
    public static final DecelerateInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();

    public static float lerp(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static int lerp(int i, float f, int i2) {
        return Math.round(f * (i2 - i)) + i;
    }

    public static float lerp(float f, float f2, float f3, float f4, float f5) {
        return f5 <= f3 ? f : f5 >= f4 ? f2 : lerp(f, f2, (f5 - f3) / (f4 - f3));
    }
}
