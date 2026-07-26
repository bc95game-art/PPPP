package com.google.android.material.shape;

import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.ShapeAppearancePathProvider;
/* loaded from: classes.dex */
public abstract class ShapeableDelegate {
    public ShapeAppearanceModel shapeAppearanceModel;
    public boolean forceCompatClippingEnabled = false;
    public boolean offsetZeroCornerEdgeBoundsEnabled = false;
    public RectF maskBounds = new RectF();
    public final Path shapePath = new Path();

    public abstract void invalidateClippingMethod(NavigationView navigationView);

    public abstract boolean shouldUseCompatClipping();

    public final void updateShapePath() {
        ShapeAppearanceModel shapeAppearanceModel;
        RectF rectF = this.maskBounds;
        if (rectF.left <= rectF.right && rectF.top <= rectF.bottom && (shapeAppearanceModel = this.shapeAppearanceModel) != null) {
            ShapeAppearancePathProvider.Lazy.INSTANCE.calculatePath(shapeAppearanceModel, null, 1.0f, rectF, null, this.shapePath);
        }
    }
}
