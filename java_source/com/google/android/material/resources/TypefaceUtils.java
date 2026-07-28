package com.google.android.material.resources;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import androidx.core.p002os.BundleKt;
/* loaded from: classes.dex */
public abstract class TypefaceUtils {
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
        r0 = r2.fontWeightAdjustment;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface maybeCopyWithFontWeightAdjustment(Configuration configuration, Typeface typeface) {
        int i;
        int i2;
        if (Build.VERSION.SDK_INT < 31 || i == Integer.MAX_VALUE || i == 0 || typeface == null) {
            return null;
        }
        int weight = typeface.getWeight();
        i2 = configuration.fontWeightAdjustment;
        return Typeface.create(typeface, BundleKt.clamp(weight + i2, 1, 1000), typeface.isItalic());
    }
}
