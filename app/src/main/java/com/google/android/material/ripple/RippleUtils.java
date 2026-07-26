package com.google.android.material.ripple;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.graphics.ColorUtils;
import androidx.core.os.BundleKt;
import com.emanuelef.remote_capture.R;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public abstract class RippleUtils {
    public static final int[] PRESSED_STATE_SET = {16842919};
    public static final int[] FOCUSED_STATE_SET = {16842908};
    public static final int[] SELECTED_PRESSED_STATE_SET = {16842913, 16842919};
    public static final int[] SELECTED_STATE_SET = {16842913};
    public static final int[] ENABLED_PRESSED_STATE_SET = {16842910, 16842919};

    /* loaded from: classes.dex */
    public abstract class RippleUtilsLollipop {
        public static Drawable createOvalRipple(Context context, int i) {
            ColorStateList colorStateList;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) gradientDrawable, i, i, i, i);
            ColorStateList valueOf = ColorStateList.valueOf(0);
            TypedValue resolve = LazyKt__LazyJVMKt.resolve(context, R.attr.colorControlHighlight);
            if (resolve != null) {
                int i2 = resolve.resourceId;
                if (i2 != 0) {
                    colorStateList = BundleKt.getColorStateList(context, i2);
                } else {
                    colorStateList = ColorStateList.valueOf(resolve.data);
                }
            } else {
                colorStateList = null;
            }
            if (colorStateList != null) {
                valueOf = colorStateList;
            }
            return new RippleDrawable(valueOf, null, insetDrawable);
        }
    }

    public static int getColorForState(ColorStateList colorStateList, int[] iArr) {
        int i;
        if (colorStateList != null) {
            i = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i = 0;
        }
        return ColorUtils.setAlphaComponent(i, Math.min(Color.alpha(i) * 2, 255));
    }

    public static ColorStateList sanitizeRippleDrawableColor(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 22 && i <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(ENABLED_PRESSED_STATE_SET, 0)) != 0) {
            Log.w("RippleUtils", "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }
}
