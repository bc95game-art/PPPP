package com.google.android.material.radiobutton;

import android.content.res.ColorStateList;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat$Api21Impl;
import com.emanuelef.remote_capture.C0130R;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class MaterialRadioButton extends AppCompatRadioButton {
    public static final int[][] ENABLED_CHECKED_STATES = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};
    public ColorStateList materialThemeColorsTintList;
    public boolean useMaterialThemeColors;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList == null) {
            int color = LazyKt__LazyJVMKt.getColor(C0130R.attr.colorControlActivated, this);
            int color2 = LazyKt__LazyJVMKt.getColor(C0130R.attr.colorOnSurface, this);
            int color3 = LazyKt__LazyJVMKt.getColor(C0130R.attr.colorSurface, this);
            this.materialThemeColorsTintList = new ColorStateList(ENABLED_CHECKED_STATES, new int[]{LazyKt__LazyJVMKt.layer(color3, 1.0f, color), LazyKt__LazyJVMKt.layer(color3, 0.54f, color2), LazyKt__LazyJVMKt.layer(color3, 0.38f, color2), LazyKt__LazyJVMKt.layer(color3, 0.38f, color2)});
        }
        return this.materialThemeColorsTintList;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors && CompoundButtonCompat$Api21Impl.getButtonTintList(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.useMaterialThemeColors = z;
        if (z) {
            CompoundButtonCompat$Api21Impl.setButtonTintList(this, getMaterialThemeColorsTintList());
        } else {
            CompoundButtonCompat$Api21Impl.setButtonTintList(this, null);
        }
    }
}
