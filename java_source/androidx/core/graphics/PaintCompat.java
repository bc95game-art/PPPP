package androidx.core.graphics;

import android.graphics.Paint;
/* loaded from: classes.dex */
public abstract class PaintCompat {
    public static final ThreadLocal sRectThreadLocal = new ThreadLocal();

    /* loaded from: classes.dex */
    public abstract class Api23Impl {
        public static boolean hasGlyph(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }
}
