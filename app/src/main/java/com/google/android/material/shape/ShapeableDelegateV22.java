package com.google.android.material.shape;

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
        view.setOutlineProvider(new Chip.AnonymousClass2(1, this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00f9, code lost:
        if (r0 == false) goto L63;
     */
    @Override // com.google.android.material.shape.ShapeableDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void invalidateClippingMethod(com.google.android.material.navigation.NavigationView r10) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.shape.ShapeableDelegateV22.invalidateClippingMethod(com.google.android.material.navigation.NavigationView):void");
    }

    @Override // com.google.android.material.shape.ShapeableDelegate
    public final boolean shouldUseCompatClipping() {
        if (!this.canUseViewOutline || this.forceCompatClippingEnabled) {
            return true;
        }
        return false;
    }
}
