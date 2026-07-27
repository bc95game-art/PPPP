package com.google.android.material.shape;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.navigation.NavigationView;
/* loaded from: classes.dex */
public final class ShapeableDelegateV33 extends ShapeableDelegate {
    public ShapeableDelegateV33(NavigationView navigationView) {
        initMaskOutlineProvider(navigationView);
    }

    private void initMaskOutlineProvider(View view) {
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.shape.ShapeableDelegateV33.1
            @Override // android.view.ViewOutlineProvider
            public final void getOutline(View view2, Outline outline) {
                ShapeableDelegateV33 shapeableDelegateV33 = ShapeableDelegateV33.this;
                if (!shapeableDelegateV33.shapePath.isEmpty()) {
                    outline.setPath(shapeableDelegateV33.shapePath);
                }
            }
        });
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public final void invalidateClippingMethod(NavigationView navigationView) {
        navigationView.setClipToOutline(!this.forceCompatClippingEnabled);
        if (this.forceCompatClippingEnabled) {
            navigationView.invalidate();
        } else {
            navigationView.invalidateOutline();
        }
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public final boolean shouldUseCompatClipping() {
        return this.forceCompatClippingEnabled;
    }
}
