package com.google.android.material.animation;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
/* loaded from: classes.dex */
public final class MotionTiming {
    public long delay;
    public TimeInterpolator interpolator = null;
    public int repeatCount = 0;
    public int repeatMode = 1;
    public long duration = 150;

    public MotionTiming(long j) {
        this.delay = j;
    }

    public final void apply(ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay(this.delay);
        objectAnimator.setDuration(this.duration);
        objectAnimator.setInterpolator(getInterpolator());
        objectAnimator.setRepeatCount(this.repeatCount);
        objectAnimator.setRepeatMode(this.repeatMode);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionTiming)) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (this.delay == motionTiming.delay && this.duration == motionTiming.duration && this.repeatCount == motionTiming.repeatCount && this.repeatMode == motionTiming.repeatMode) {
            return getInterpolator().getClass().equals(motionTiming.getInterpolator().getClass());
        }
        return false;
    }

    public final TimeInterpolator getInterpolator() {
        TimeInterpolator timeInterpolator = this.interpolator;
        if (timeInterpolator != null) {
            return timeInterpolator;
        }
        return AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    }

    public final int hashCode() {
        long j = this.delay;
        long j2 = this.duration;
        return ((((getInterpolator().getClass().hashCode() + (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31)) * 31) + this.repeatCount) * 31) + this.repeatMode;
    }

    public final String toString() {
        return "\n" + MotionTiming.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.delay + " duration: " + this.duration + " interpolator: " + getInterpolator().getClass() + " repeatCount: " + this.repeatCount + " repeatMode: " + this.repeatMode + "}\n";
    }
}
