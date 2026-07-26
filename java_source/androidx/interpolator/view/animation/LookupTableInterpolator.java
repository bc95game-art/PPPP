package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;
/* loaded from: classes.dex */
public abstract class LookupTableInterpolator implements Interpolator {
    public final float mStepSize;
    public final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int min = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.mStepSize;
        float f3 = fArr[min];
        return ((fArr[min + 1] - f3) * ((f - (min * f2)) / f2)) + f3;
    }
}
