package com.google.android.material.shape;

import com.google.android.material.navigation.NavigationView;
/* loaded from: classes.dex */
public final class ShapeableDelegateV14 extends ShapeableDelegate {
    @Override // com.google.android.material.shape.ShapeableDelegate
    public final void invalidateClippingMethod(NavigationView navigationView) {
        if (this.shapeAppearanceModel != null && !this.maskBounds.isEmpty()) {
            navigationView.invalidate();
        }
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public final boolean shouldUseCompatClipping() {
        return true;
    }
}
