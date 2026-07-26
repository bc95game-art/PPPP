package com.google.android.material.shape;

import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class CutCornerTreatment extends LazyKt__LazyJVMKt {
    @Override // kotlin.LazyKt__LazyJVMKt
    public final void getCornerPath(ShapePath shapePath, float f, float f2) {
        float f3 = f2 * f;
        shapePath.reset(0.0f, f3, 180.0f, 90.0f);
        double d = f3;
        shapePath.lineTo((float) (Math.sin(Math.toRadians(90.0f)) * d), (float) (Math.sin(Math.toRadians(0.0f)) * d));
    }
}
