package androidx.core.graphics;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.core.os.BundleKt;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class TypefaceCompat {
    public static final LruCache sTypefaceCache;
    public static final BundleKt sTypefaceCompatImpl;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            sTypefaceCompatImpl = new BundleKt();
        } else if (i >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else if (i >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else {
            if (i >= 24) {
                Method method = TypefaceCompatApi24Impl.sAddFontWeightStyle;
                if (method == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (method != null) {
                    sTypefaceCompatImpl = new BundleKt();
                }
            }
            sTypefaceCompatImpl = new BundleKt();
        }
        sTypefaceCache = new LruCache(16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r1.equals(r2) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface createFromResourcesFamilyXml(android.content.Context r12, androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r13, android.content.res.Resources r14, int r15, java.lang.String r16, int r17, int r18, androidx.core.content.res.ResourcesCompat.FontCallback r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompat.createFromResourcesFamilyXml(android.content.Context, androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry, android.content.res.Resources, int, java.lang.String, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, boolean):android.graphics.Typeface");
    }

    public static String createResourceUid(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }
}
