package com.google.android.material.resources;
/* loaded from: classes.dex */
public abstract class TypefaceUtils {
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
        r0 = r2.fontWeightAdjustment;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface maybeCopyWithFontWeightAdjustment(android.content.res.Configuration r2, android.graphics.Typeface r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 < r1) goto L2c
            int r0 = com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0.m(r2)
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L2c
            if (r0 == 0) goto L2c
            if (r3 == 0) goto L2c
            int r0 = r3.getWeight()
            int r2 = com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0.m(r2)
            int r0 = r0 + r2
            r2 = 1
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = androidx.core.os.BundleKt.clamp(r0, r2, r1)
            boolean r0 = r3.isItalic()
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r3, r2, r0)
            return r2
        L2c:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.resources.TypefaceUtils.maybeCopyWithFontWeightAdjustment(android.content.res.Configuration, android.graphics.Typeface):android.graphics.Typeface");
    }
}
