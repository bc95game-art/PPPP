package androidx.transition;

import android.graphics.Bitmap;
import android.graphics.Picture;
import android.os.Build;
/* loaded from: classes.dex */
public abstract class TransitionUtils {
    public static final boolean HAS_PICTURE_BITMAP;

    /* loaded from: classes.dex */
    public abstract class Api28Impl {
        public static Bitmap createBitmap(Picture picture) {
            return Bitmap.createBitmap(picture);
        }
    }

    static {
        boolean z;
        if (Build.VERSION.SDK_INT >= 28) {
            z = true;
        } else {
            z = false;
        }
        HAS_PICTURE_BITMAP = z;
    }
}
