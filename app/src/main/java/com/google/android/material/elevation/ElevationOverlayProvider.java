package com.google.android.material.elevation;

import android.content.Context;
import com.emanuelef.remote_capture.C0130R;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class ElevationOverlayProvider {
    public static final int OVERLAY_ACCENT_COLOR_ALPHA = (int) Math.round(5.1000000000000005d);
    public final int colorSurface;
    public final float displayDensity;
    public final int elevationOverlayAccentColor;
    public final int elevationOverlayColor;
    public final boolean elevationOverlayEnabled;

    public ElevationOverlayProvider(Context context) {
        boolean resolveBoolean = LazyKt__LazyJVMKt.resolveBoolean(context, C0130R.attr.elevationOverlayEnabled, false);
        int color = LazyKt__LazyJVMKt.getColor(context, C0130R.attr.elevationOverlayColor, 0);
        int color2 = LazyKt__LazyJVMKt.getColor(context, C0130R.attr.elevationOverlayAccentColor, 0);
        int color3 = LazyKt__LazyJVMKt.getColor(context, C0130R.attr.colorSurface, 0);
        float f = context.getResources().getDisplayMetrics().density;
        this.elevationOverlayEnabled = resolveBoolean;
        this.elevationOverlayColor = color;
        this.elevationOverlayAccentColor = color2;
        this.colorSurface = color3;
        this.displayDensity = f;
    }
}
