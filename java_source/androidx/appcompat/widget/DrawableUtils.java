package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.graphics.drawable.WrappedDrawableApi21;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public abstract class DrawableUtils {
    public static final int[] CHECKED_STATE_SET = {16842912};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public static final Rect INSETS_NONE = new Rect();

    /* loaded from: classes.dex */
    public abstract class Api18Impl {
        public static final Field sBottom;
        public static final Method sGetOpticalInsets;
        public static final Field sLeft;
        public static final boolean sReflectionSuccessful;
        public static final Field sRight;
        public static final Field sTop;

        /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
        static {
            boolean z;
            Field field;
            Field field2;
            Field field3;
            Method method;
            Field field4;
            Class<?> cls;
            try {
                cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", null);
                try {
                    field3 = cls.getField("left");
                } catch (ClassNotFoundException unused) {
                    field3 = null;
                    field2 = field3;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (NoSuchFieldException unused2) {
                    field3 = null;
                    field2 = field3;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                } catch (NoSuchMethodException unused3) {
                    field3 = null;
                    field2 = field3;
                    field = field2;
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                }
            } catch (ClassNotFoundException unused4) {
                method = null;
                field3 = null;
            } catch (NoSuchFieldException unused5) {
                method = null;
                field3 = null;
            } catch (NoSuchMethodException unused6) {
                method = null;
                field3 = null;
            }
            try {
                field2 = cls.getField("top");
                try {
                    field = cls.getField("right");
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused7) {
                    field = null;
                }
                try {
                    field4 = cls.getField("bottom");
                    z = true;
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused8) {
                    field4 = null;
                    z = false;
                    if (!z) {
                    }
                }
            } catch (ClassNotFoundException unused9) {
                field2 = null;
                field = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            } catch (NoSuchFieldException unused10) {
                field2 = null;
                field = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            } catch (NoSuchMethodException unused11) {
                field2 = null;
                field = field2;
                field4 = null;
                z = false;
                if (!z) {
                }
            }
            if (!z) {
                sGetOpticalInsets = method;
                sLeft = field3;
                sTop = field2;
                sRight = field;
                sBottom = field4;
                sReflectionSuccessful = true;
                return;
            }
            sGetOpticalInsets = null;
            sLeft = null;
            sTop = null;
            sRight = null;
            sBottom = null;
            sReflectionSuccessful = false;
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api29Impl {
        public static Insets getOpticalInsets(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static void fixDrawable(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i = Build.VERSION.SDK_INT;
        int[] iArr = CHECKED_STATE_SET;
        int[] iArr2 = EMPTY_STATE_SET;
        if (i == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            int[] state = drawable.getState();
            if (state == null || state.length == 0) {
                drawable.setState(iArr);
            } else {
                drawable.setState(iArr2);
            }
            drawable.setState(state);
        } else if (i >= 29 && i < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            int[] state2 = drawable.getState();
            if (state2 == null || state2.length == 0) {
                drawable.setState(iArr);
            } else {
                drawable.setState(iArr2);
            }
            drawable.setState(state2);
        }
    }

    public static Rect getOpticalBounds(Drawable drawable) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 29) {
            Insets opticalInsets = Api29Impl.getOpticalInsets(drawable);
            i = opticalInsets.left;
            i2 = opticalInsets.top;
            i3 = opticalInsets.right;
            i4 = opticalInsets.bottom;
            return new Rect(i, i2, i3, i4);
        }
        if (drawable instanceof WrappedDrawable) {
            drawable = ((WrappedDrawableApi21) ((WrappedDrawable) drawable)).mDrawable;
        }
        if (i5 >= 29) {
            boolean z = Api18Impl.sReflectionSuccessful;
        } else if (Api18Impl.sReflectionSuccessful) {
            try {
                Object invoke = Api18Impl.sGetOpticalInsets.invoke(drawable, null);
                if (invoke != null) {
                    return new Rect(Api18Impl.sLeft.getInt(invoke), Api18Impl.sTop.getInt(invoke), Api18Impl.sRight.getInt(invoke), Api18Impl.sBottom.getInt(invoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return INSETS_NONE;
    }

    public static PorterDuff.Mode parseTintMode(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
