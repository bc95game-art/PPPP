package com.google.android.material.shape;

import android.graphics.RectF;
import android.view.View;
import com.google.android.material.chip.Chip;
import com.google.android.material.navigation.NavigationView;
/* loaded from: classes.dex */
public final class ShapeableDelegateV22 extends ShapeableDelegate {
    public boolean canUseViewOutline = false;
    public float cornerRadius = 0.0f;

    public ShapeableDelegateV22(NavigationView navigationView) {
        initMaskOutlineProvider(navigationView);
    }

    private void initMaskOutlineProvider(View view) {
        view.setOutlineProvider(new Chip.C01752(1, this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f9, code lost:
        if (r0 == false) goto L63;
     */
    @Override // com.google.android.material.shape.ShapeableDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void invalidateClippingMethod(NavigationView navigationView) {
        float f;
        boolean z;
        boolean z2;
        ShapeAppearanceModel shapeAppearanceModel;
        ShapeAppearanceModel shapeAppearanceModel2;
        RectF rectF;
        ShapeAppearanceModel shapeAppearanceModel3 = this.shapeAppearanceModel;
        if (shapeAppearanceModel3 == null || (rectF = this.maskBounds) == null) {
            f = 0.0f;
        } else {
            f = shapeAppearanceModel3.topRightCornerSize.getCornerSize(rectF);
        }
        this.cornerRadius = f;
        boolean z3 = false;
        if (this.maskBounds.isEmpty() || (shapeAppearanceModel2 = this.shapeAppearanceModel) == null) {
            z = false;
        } else {
            z = shapeAppearanceModel2.isRoundRect(this.maskBounds);
        }
        if (!z) {
            if (!this.maskBounds.isEmpty() && (shapeAppearanceModel = this.shapeAppearanceModel) != null && this.offsetZeroCornerEdgeBoundsEnabled && !shapeAppearanceModel.isRoundRect(this.maskBounds)) {
                ShapeAppearanceModel shapeAppearanceModel4 = this.shapeAppearanceModel;
                if ((shapeAppearanceModel4.topLeftCorner instanceof RoundedCornerTreatment) && (shapeAppearanceModel4.topRightCorner instanceof RoundedCornerTreatment) && (shapeAppearanceModel4.bottomLeftCorner instanceof RoundedCornerTreatment) && (shapeAppearanceModel4.bottomRightCorner instanceof RoundedCornerTreatment)) {
                    float cornerSize = shapeAppearanceModel4.topLeftCornerSize.getCornerSize(this.maskBounds);
                    float cornerSize2 = this.shapeAppearanceModel.topRightCornerSize.getCornerSize(this.maskBounds);
                    float cornerSize3 = this.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(this.maskBounds);
                    float cornerSize4 = this.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(this.maskBounds);
                    int i = (cornerSize > 0.0f ? 1 : (cornerSize == 0.0f ? 0 : -1));
                    if (i == 0 && cornerSize3 == 0.0f && cornerSize2 == cornerSize4) {
                        RectF rectF2 = this.maskBounds;
                        rectF2.set(rectF2.left - cornerSize2, rectF2.top, rectF2.right, rectF2.bottom);
                        this.cornerRadius = cornerSize2;
                    } else if (i == 0 && cornerSize2 == 0.0f && cornerSize3 == cornerSize4) {
                        RectF rectF3 = this.maskBounds;
                        rectF3.set(rectF3.left, rectF3.top - cornerSize3, rectF3.right, rectF3.bottom);
                        this.cornerRadius = cornerSize3;
                    } else if (cornerSize2 == 0.0f && cornerSize4 == 0.0f && cornerSize == cornerSize3) {
                        RectF rectF4 = this.maskBounds;
                        rectF4.set(rectF4.left, rectF4.top, rectF4.right + cornerSize, rectF4.bottom);
                        this.cornerRadius = cornerSize;
                    } else if (cornerSize3 == 0.0f && cornerSize4 == 0.0f && cornerSize == cornerSize2) {
                        RectF rectF5 = this.maskBounds;
                        rectF5.set(rectF5.left, rectF5.top, rectF5.right, rectF5.bottom + cornerSize);
                        this.cornerRadius = cornerSize;
                    }
                    z2 = true;
                }
            }
            z2 = false;
        }
        z3 = true;
        this.canUseViewOutline = z3;
        navigationView.setClipToOutline(!shouldUseCompatClipping());
        if (shouldUseCompatClipping()) {
            navigationView.invalidate();
        } else {
            navigationView.invalidateOutline();
        }
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public final boolean shouldUseCompatClipping() {
        if (!this.canUseViewOutline || this.forceCompatClippingEnabled) {
            return true;
        }
        return false;
    }
}
