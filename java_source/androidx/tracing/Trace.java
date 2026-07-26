package androidx.tracing;

import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.core.p002os.BundleKt;
import com.google.android.material.drawable.DrawableUtils$OutlineCompatL;
import com.google.android.material.drawable.DrawableUtils$OutlineCompatR;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class Trace {
    public static Method sIsTagEnabledMethod;
    public static long sTraceTagApp;

    public static Drawable compositeTwoLayeredDrawable(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        if (intrinsicWidth == -1) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        if (intrinsicHeight == -1) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        if (intrinsicWidth > drawable.getIntrinsicWidth() || intrinsicHeight > drawable.getIntrinsicHeight()) {
            float f = intrinsicWidth / intrinsicHeight;
            if (f >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth2 = drawable.getIntrinsicWidth();
                intrinsicHeight = (int) (intrinsicWidth2 / f);
                intrinsicWidth = intrinsicWidth2;
            } else {
                intrinsicHeight = drawable.getIntrinsicHeight();
                intrinsicWidth = (int) (f * intrinsicHeight);
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
            return layerDrawable;
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawable, drawable2});
        int max = Math.max((drawable.getIntrinsicWidth() - intrinsicWidth) / 2, 0);
        int max2 = Math.max((drawable.getIntrinsicHeight() - intrinsicHeight) / 2, 0);
        layerDrawable2.setLayerInset(1, max, max2, max, max2);
        return layerDrawable2;
    }

    public static Drawable createTintableMutatedDrawableIfNeeded(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        boolean z;
        if (Build.VERSION.SDK_INT < 23) {
            z = true;
        } else {
            z = false;
        }
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            Drawable mutate = BundleKt.wrap(drawable).mutate();
            if (mode != null) {
                mutate.setTintMode(mode);
            }
            return mutate;
        }
        if (z) {
            drawable.mutate();
        }
        return drawable;
    }

    public static ColorStateList getColorStateListOrNull(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !(drawable instanceof ColorStateListDrawable)) {
            return null;
        }
        return ((ColorStateListDrawable) drawable).getColorStateList();
    }

    public static boolean isEnabled() {
        try {
            if (sIsTagEnabledMethod == null) {
                return android.os.Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (sIsTagEnabledMethod == null) {
                sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) sIsTagEnabledMethod.invoke(null, Long.valueOf(sTraceTagApp))).booleanValue();
        } catch (Exception e) {
            if (e instanceof InvocationTargetException) {
                Throwable cause = e.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new RuntimeException(cause);
            }
            Log.v("Trace", "Unable to call isTagEnabled via reflection", e);
            return false;
        }
    }

    public static void setOutlineToPath(Outline outline, Path path) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            DrawableUtils$OutlineCompatR.setPath(outline, path);
        } else if (i >= 29) {
            try {
                DrawableUtils$OutlineCompatL.setConvexPath(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            DrawableUtils$OutlineCompatL.setConvexPath(outline, path);
        }
    }

    public static void setRippleDrawableRadius(RippleDrawable rippleDrawable, int i) {
        Throwable e;
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i);
            return;
        }
        try {
            try {
                RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE).invoke(rippleDrawable, Integer.valueOf(i));
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                e = e2;
                throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
            }
        } catch (InvocationTargetException e3) {
            e = e3;
            throw new IllegalStateException("Couldn't set RippleDrawable radius", e);
        }
    }

    public static void setTint(Drawable drawable, int i) {
        boolean z;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        if (Build.VERSION.SDK_INT == 21) {
            if (z) {
                drawable.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.setColorFilter(null);
            }
        } else if (z) {
            drawable.setTint(i);
        } else {
            drawable.setTintList(null);
        }
    }
}
