package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.PointerIcon;
/* loaded from: classes.dex */
public abstract class PointerIconCompat$Api24Impl {
    public static PointerIcon create(Bitmap bitmap, float f, float f2) {
        return PointerIcon.create(bitmap, f, f2);
    }

    public static PointerIcon getSystemIcon(Context context, int i) {
        return PointerIcon.getSystemIcon(context, i);
    }

    public static PointerIcon load(Resources resources, int i) {
        return PointerIcon.load(resources, i);
    }
}
