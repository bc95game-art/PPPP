package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.core.os.BundleKt;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class ClampedCornerSize implements CornerSize {
    public final float target;

    public ClampedCornerSize(float f) {
        this.target = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof ClampedCornerSize) && this.target == ((ClampedCornerSize) obj).target) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.shape.CornerSize
    public final float getCornerSize(RectF rectF) {
        return BundleKt.clamp(this.target, 0.0f, Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.target)});
    }
}
