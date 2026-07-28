package com.google.android.material.shape;

import androidx.transition.ViewUtilsApi21;
/* loaded from: classes.dex */
public final class OffsetEdgeTreatment extends ViewUtilsApi21 {
    public final float offset;
    public final MarkerEdgeTreatment other;

    public OffsetEdgeTreatment(MarkerEdgeTreatment markerEdgeTreatment, float f) {
        this.other = markerEdgeTreatment;
        this.offset = f;
    }

    @Override // androidx.transition.ViewUtilsApi21
    public final boolean forceIntersection() {
        return true;
    }

    @Override // androidx.transition.ViewUtilsApi21
    public final void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        this.other.getEdgePath(f, f2 - this.offset, f3, shapePath);
    }
}
