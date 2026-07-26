package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import androidx.core.graphics.ColorUtils;
import androidx.core.os.BundleKt;
import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.R;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EncodedPayload;
import java.io.Serializable;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class AppCompatDrawableManager {
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    public static AppCompatDrawableManager INSTANCE;
    public ResourceManagerInternal mResourceManager;

    /* renamed from: androidx.appcompat.widget.AppCompatDrawableManager$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 {
        public Serializable COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
        public Object COLORFILTER_COLOR_CONTROL_ACTIVATED;
        public Serializable COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
        public Object TINT_CHECKABLE_BUTTON_LIST;
        public Serializable TINT_COLOR_CONTROL_NORMAL;
        public Serializable TINT_COLOR_CONTROL_STATE_LIST;

        public static boolean arrayContains(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public static ColorStateList createButtonColorStateList(Context context, int i) {
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
        }

        public static LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable drawable = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
            Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
            if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable2 = (BitmapDrawable) drawable;
                bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable.draw(canvas);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawable2;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        public static void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
            Drawable mutate = drawable.mutate();
            if (mode == null) {
                mode = AppCompatDrawableManager.DEFAULT_MODE;
            }
            mutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
        }

        public void addMetadata(String str, String str2) {
            HashMap hashMap = (HashMap) this.TINT_CHECKABLE_BUTTON_LIST;
            if (hashMap != null) {
                hashMap.put(str, str2);
                return;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        public AutoValue_EventInternal build() {
            String str;
            if (((String) this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL) == null) {
                str = " transportName";
            } else {
                str = "";
            }
            if (((EncodedPayload) this.COLORFILTER_COLOR_CONTROL_ACTIVATED) == null) {
                str = str.concat(" encodedPayload");
            }
            if (((Long) this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY) == null) {
                str = ViewModelProvider.Factory.CC.m(str, " eventMillis");
            }
            if (((Long) this.TINT_COLOR_CONTROL_STATE_LIST) == null) {
                str = ViewModelProvider.Factory.CC.m(str, " uptimeMillis");
            }
            if (((HashMap) this.TINT_CHECKABLE_BUTTON_LIST) == null) {
                str = ViewModelProvider.Factory.CC.m(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                return new AutoValue_EventInternal((String) this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, (Integer) this.TINT_COLOR_CONTROL_NORMAL, (EncodedPayload) this.COLORFILTER_COLOR_CONTROL_ACTIVATED, ((Long) this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY).longValue(), ((Long) this.TINT_COLOR_CONTROL_STATE_LIST).longValue(), (HashMap) this.TINT_CHECKABLE_BUTTON_LIST);
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }

        public ColorStateList getTintListForDrawableRes(Context context, int i) {
            if (i == R.drawable.abc_edit_text_material) {
                return BundleKt.getColorStateList(context, R.color.abc_tint_edittext);
            }
            if (i == 2131230826) {
                return BundleKt.getColorStateList(context, R.color.abc_tint_switch_track);
            }
            if (i == R.drawable.abc_switch_thumb_material) {
                int[][] iArr = new int[3];
                int[] iArr2 = new int[3];
                ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorSwitchThumbNormal);
                if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                    iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                    iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
                    iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                    iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                    iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                    iArr2[2] = ThemeUtils.getThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
                } else {
                    int[] iArr3 = ThemeUtils.DISABLED_STATE_SET;
                    iArr[0] = iArr3;
                    iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
                    iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                    iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                    iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                    iArr2[2] = themeAttrColorStateList.getDefaultColor();
                }
                return new ColorStateList(iArr, iArr2);
            } else if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
            } else {
                if (i == R.drawable.abc_btn_borderless_material) {
                    return createButtonColorStateList(context, 0);
                }
                if (i == R.drawable.abc_btn_colored_material) {
                    return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
                }
                if (i == 2131230821 || i == R.drawable.abc_spinner_textfield_background_material) {
                    return BundleKt.getColorStateList(context, R.color.abc_tint_spinner);
                }
                if (arrayContains((int[]) this.TINT_COLOR_CONTROL_NORMAL, i)) {
                    return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
                }
                if (arrayContains((int[]) this.TINT_COLOR_CONTROL_STATE_LIST, i)) {
                    return BundleKt.getColorStateList(context, R.color.abc_tint_default);
                }
                if (arrayContains((int[]) this.TINT_CHECKABLE_BUTTON_LIST, i)) {
                    return BundleKt.getColorStateList(context, R.color.abc_tint_btn_checkable);
                }
                if (i == R.drawable.abc_seekbar_thumb_material) {
                    return BundleKt.getColorStateList(context, R.color.abc_tint_seek_thumb);
                }
                return null;
            }
        }
    }

    public static synchronized AppCompatDrawableManager get() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            try {
                if (INSTANCE == null) {
                    preload();
                }
                appCompatDrawableManager = INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
        }
        return porterDuffColorFilter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.appcompat.widget.AppCompatDrawableManager, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, androidx.appcompat.widget.AppCompatDrawableManager$1] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r3v5, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r3v7, types: [int[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r4v1, types: [int[], java.io.Serializable] */
    public static synchronized void preload() {
        synchronized (AppCompatDrawableManager.class) {
            if (INSTANCE == null) {
                ?? obj = new Object();
                INSTANCE = obj;
                obj.mResourceManager = ResourceManagerInternal.get();
                ResourceManagerInternal resourceManagerInternal = INSTANCE.mResourceManager;
                ?? obj2 = new Object();
                obj2.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{2131230836, 2131230834, 2131230760};
                obj2.TINT_COLOR_CONTROL_NORMAL = new int[]{2131230784, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                obj2.COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{2131230833, 2131230835, 2131230777, R.drawable.abc_text_cursor_material, 2131230830, 2131230831, 2131230832};
                obj2.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{2131230809, R.drawable.abc_cab_background_internal_bg, 2131230808};
                obj2.TINT_COLOR_CONTROL_STATE_LIST = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                obj2.TINT_CHECKABLE_BUTTON_LIST = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                resourceManagerInternal.setHooks(obj2);
            }
        }
    }

    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        PorterDuff.Mode mode2 = ResourceManagerInternal.DEFAULT_MODE;
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z = tintInfo.mHasTintList;
            if (z || tintInfo.mHasTintMode) {
                PorterDuffColorFilter porterDuffColorFilter = null;
                if (z) {
                    colorStateList = tintInfo.mTintList;
                } else {
                    colorStateList = null;
                }
                if (tintInfo.mHasTintMode) {
                    mode = tintInfo.mTintMode;
                } else {
                    mode = ResourceManagerInternal.DEFAULT_MODE;
                }
                if (!(colorStateList == null || mode == null)) {
                    porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(porterDuffColorFilter);
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    public final synchronized Drawable getDrawable(Context context, int i) {
        return this.mResourceManager.getDrawable(context, i);
    }
}
