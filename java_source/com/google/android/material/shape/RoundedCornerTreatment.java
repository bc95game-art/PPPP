package com.google.android.material.shape;

import com.google.android.material.shape.ShapePath;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class RoundedCornerTreatment extends LazyKt__LazyJVMKt {
    @Override // kotlin.LazyKt__LazyJVMKt
    public final void getCornerPath(ShapePath shapePath, float f, float f2) {
        float f3 = f2 * f;
        shapePath.reset(0.0f, f3, 180.0f, 90.0f);
        float f4 = f3 * 2.0f;
        ShapePath.PathArcOperation pathArcOperation = new ShapePath.PathArcOperation(0.0f, 0.0f, f4, f4);
        pathArcOperation.startAngle = 180.0f;
        pathArcOperation.sweepAngle = 90.0f;
        shapePath.operations.add(pathArcOperation);
        ShapePath.ArcShadowOperation arcShadowOperation = new ShapePath.ArcShadowOperation(pathArcOperation);
        shapePath.addConnectingShadowIfNecessary(180.0f);
        shapePath.shadowCompatOperations.add(arcShadowOperation);
        shapePath.currentShadowAngle = 270.0f;
        float f5 = (0.0f + f4) * 0.5f;
        float f6 = (f4 - 0.0f) / 2.0f;
        double d = 270.0f;
        shapePath.endX = (((float) Math.cos(Math.toRadians(d))) * f6) + f5;
        shapePath.endY = (f6 * ((float) Math.sin(Math.toRadians(d)))) + f5;
    }
}
