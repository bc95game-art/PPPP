package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.p002os.BundleKt;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.emanuelef.remote_capture.C0130R;
import com.github.appintro.AppIntroBaseFragmentKt;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes.dex */
public final class ResourceManagerInternal {
    public static ResourceManagerInternal INSTANCE;
    public SimpleArrayMap mDelegates;
    public final WeakHashMap mDrawableCaches = new WeakHashMap(0);
    public boolean mHasCheckedVectorDrawableSetup;
    public AppCompatDrawableManager.C00231 mHooks;
    public SparseArrayCompat mKnownDrawableIdTags;
    public WeakHashMap mTintLists;
    public TypedValue mTypedValue;
    public static final PorterDuff.Mode DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
    public static final ColorFilterLruCache COLOR_FILTER_CACHE = new LruCache(6);

    /* loaded from: classes.dex */
    public final class ColorFilterLruCache extends LruCache {
    }

    /* loaded from: classes.dex */
    public final class DrawableDelegate {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ DrawableDelegate(int i) {
            this.$r8$classId = i;
        }

        public final Drawable createFromXmlInner(Context context, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Resources.Theme theme) {
            switch (this.$r8$classId) {
                case 0:
                    String classAttribute = attributeSet.getClassAttribute();
                    if (classAttribute == null) {
                        return null;
                    }
                    try {
                        Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                        Compatibility$Api21Impl.inflate(drawable, context.getResources(), xmlResourceParser, attributeSet, theme);
                        return drawable;
                    } catch (Exception e) {
                        Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
                        return null;
                    }
                case 1:
                    try {
                        return AnimatedStateListDrawableCompat.createFromXmlInner(context, context.getResources(), xmlResourceParser, attributeSet, theme);
                    } catch (Exception e2) {
                        Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                        return null;
                    }
                case 2:
                    try {
                        Resources resources = context.getResources();
                        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context, 0);
                        animatedVectorDrawableCompat.inflate(resources, xmlResourceParser, attributeSet, theme);
                        return animatedVectorDrawableCompat;
                    } catch (Exception e3) {
                        Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e3);
                        return null;
                    }
                default:
                    try {
                        Resources resources2 = context.getResources();
                        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
                        vectorDrawableCompat.inflate(resources2, xmlResourceParser, attributeSet, theme);
                        return vectorDrawableCompat;
                    } catch (Exception e4) {
                        Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e4);
                        return null;
                    }
            }
        }
    }

    public static synchronized ResourceManagerInternal get() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            try {
                if (INSTANCE == null) {
                    ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                    INSTANCE = resourceManagerInternal2;
                    installDefaultInflateDelegates(resourceManagerInternal2);
                }
                resourceManagerInternal = INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        return resourceManagerInternal;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = COLOR_FILTER_CACHE;
            colorFilterLruCache.getClass();
            int i2 = (31 + i) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) colorFilterLruCache.get(Integer.valueOf(mode.hashCode() + i2));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
                PorterDuffColorFilter porterDuffColorFilter2 = (PorterDuffColorFilter) colorFilterLruCache.put(Integer.valueOf(mode.hashCode() + i2), porterDuffColorFilter);
            }
        }
        return porterDuffColorFilter;
    }

    public static void installDefaultInflateDelegates(ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.addDelegate("vector", new DrawableDelegate(3));
            resourceManagerInternal.addDelegate("animated-vector", new DrawableDelegate(2));
            resourceManagerInternal.addDelegate("animated-selector", new DrawableDelegate(1));
            resourceManagerInternal.addDelegate(AppIntroBaseFragmentKt.ARG_DRAWABLE, new DrawableDelegate(0));
        }
    }

    public final void addDelegate(String str, DrawableDelegate drawableDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new SimpleArrayMap(0);
        }
        this.mDelegates.put(str, drawableDelegate);
    }

    public final synchronized void addDrawableToCache(Context context, long j, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                LongSparseArray longSparseArray = (LongSparseArray) this.mDrawableCaches.get(context);
                if (longSparseArray == null) {
                    longSparseArray = new LongSparseArray();
                    this.mDrawableCaches.put(context, longSparseArray);
                }
                longSparseArray.put(j, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Drawable createDrawableIfNeeded(Context context, int i) {
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        context.getResources().getValue(i, typedValue, true);
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable cachedDrawable = getCachedDrawable(context, j);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        LayerDrawable layerDrawable = null;
        if (this.mHooks != null) {
            if (i == C0130R.C0131drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{getDrawable(context, C0130R.C0131drawable.abc_cab_background_internal_bg), getDrawable(context, 2131230777)});
            } else if (i == C0130R.C0131drawable.abc_ratingbar_material) {
                layerDrawable = AppCompatDrawableManager.C00231.getRatingBarLayerDrawable(this, context, C0130R.dimen.abc_star_big);
            } else if (i == C0130R.C0131drawable.abc_ratingbar_indicator_material) {
                layerDrawable = AppCompatDrawableManager.C00231.getRatingBarLayerDrawable(this, context, C0130R.dimen.abc_star_medium);
            } else if (i == C0130R.C0131drawable.abc_ratingbar_small_material) {
                layerDrawable = AppCompatDrawableManager.C00231.getRatingBarLayerDrawable(this, context, C0130R.dimen.abc_star_small);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            addDrawableToCache(context, j, layerDrawable);
        }
        return layerDrawable;
    }

    public final synchronized Drawable getCachedDrawable(Context context, long j) {
        LongSparseArray longSparseArray = (LongSparseArray) this.mDrawableCaches.get(context);
        if (longSparseArray == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) longSparseArray.get(j);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            longSparseArray.remove(j);
        }
        return null;
    }

    public final synchronized Drawable getDrawable(Context context, int i) {
        return getDrawable(context, i, false);
    }

    public final synchronized ColorStateList getTintList(Context context, int i) {
        ColorStateList colorStateList;
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap weakHashMap = this.mTintLists;
        ColorStateList colorStateList2 = null;
        if (weakHashMap == null || (sparseArrayCompat = (SparseArrayCompat) weakHashMap.get(context)) == null) {
            colorStateList = null;
        } else {
            colorStateList = (ColorStateList) sparseArrayCompat.get(i);
        }
        if (colorStateList == null) {
            AppCompatDrawableManager.C00231 r0 = this.mHooks;
            if (r0 != null) {
                colorStateList2 = r0.getTintListForDrawableRes(context, i);
            }
            if (colorStateList2 != null) {
                if (this.mTintLists == null) {
                    this.mTintLists = new WeakHashMap();
                }
                SparseArrayCompat sparseArrayCompat2 = (SparseArrayCompat) this.mTintLists.get(context);
                if (sparseArrayCompat2 == null) {
                    sparseArrayCompat2 = new SparseArrayCompat(0);
                    this.mTintLists.put(context, sparseArrayCompat2);
                }
                sparseArrayCompat2.append(i, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    public final Drawable loadDrawableFromDelegates(Context context, int i) {
        int next;
        SimpleArrayMap simpleArrayMap = this.mDelegates;
        if (simpleArrayMap == null || simpleArrayMap.isEmpty()) {
            return null;
        }
        SparseArrayCompat sparseArrayCompat = this.mKnownDrawableIdTags;
        if (sparseArrayCompat != null) {
            String str = (String) sparseArrayCompat.get(i);
            if ("appcompat_skip_skip".equals(str)) {
                return null;
            }
            if (str != null && this.mDelegates.get(str) == null) {
                return null;
            }
        } else {
            this.mKnownDrawableIdTags = new SparseArrayCompat(0);
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new TypedValue();
        }
        TypedValue typedValue = this.mTypedValue;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable cachedDrawable = getCachedDrawable(context, j);
        if (cachedDrawable != null) {
            return cachedDrawable;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.mKnownDrawableIdTags.append(i, name);
                    DrawableDelegate drawableDelegate = (DrawableDelegate) this.mDelegates.get(name);
                    if (drawableDelegate != null) {
                        cachedDrawable = drawableDelegate.createFromXmlInner(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (cachedDrawable != null) {
                        cachedDrawable.setChangingConfigurations(typedValue.changingConfigurations);
                        addDrawableToCache(context, j, cachedDrawable);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (cachedDrawable == null) {
            this.mKnownDrawableIdTags.append(i, "appcompat_skip_skip");
        }
        return cachedDrawable;
    }

    public final synchronized void onConfigurationChanged(Context context) {
        LongSparseArray longSparseArray = (LongSparseArray) this.mDrawableCaches.get(context);
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public final synchronized void setHooks(AppCompatDrawableManager.C00231 r1) {
        this.mHooks = r1;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Drawable tintDrawable(Context context, int i, boolean z, Drawable drawable) {
        int i2;
        boolean z2;
        int i3;
        ColorStateList tintList = getTintList(context, i);
        PorterDuff.Mode mode = null;
        if (tintList != null) {
            Drawable wrap = BundleKt.wrap(drawable.mutate());
            DrawableCompat$Api21Impl.setTintList(wrap, tintList);
            if (this.mHooks != null && i == C0130R.C0131drawable.abc_switch_thumb_material) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (mode != null) {
                DrawableCompat$Api21Impl.setTintMode(wrap, mode);
            }
            return wrap;
        }
        if (this.mHooks != null) {
            if (i == C0130R.C0131drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908288);
                int themeAttrColor = ThemeUtils.getThemeAttrColor(context, C0130R.attr.colorControlNormal);
                PorterDuff.Mode mode2 = AppCompatDrawableManager.DEFAULT_MODE;
                AppCompatDrawableManager.C00231.setPorterDuffColorFilter(findDrawableByLayerId, themeAttrColor, mode2);
                AppCompatDrawableManager.C00231.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, C0130R.attr.colorControlNormal), mode2);
                AppCompatDrawableManager.C00231.setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, C0130R.attr.colorControlActivated), mode2);
                return drawable;
            } else if (i == C0130R.C0131drawable.abc_ratingbar_material || i == C0130R.C0131drawable.abc_ratingbar_indicator_material || i == C0130R.C0131drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(16908288);
                int disabledThemeAttrColor = ThemeUtils.getDisabledThemeAttrColor(context, C0130R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = AppCompatDrawableManager.DEFAULT_MODE;
                AppCompatDrawableManager.C00231.setPorterDuffColorFilter(findDrawableByLayerId2, disabledThemeAttrColor, mode3);
                AppCompatDrawableManager.C00231.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, C0130R.attr.colorControlActivated), mode3);
                AppCompatDrawableManager.C00231.setPorterDuffColorFilter(layerDrawable2.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, C0130R.attr.colorControlActivated), mode3);
                return drawable;
            }
        }
        AppCompatDrawableManager.C00231 r0 = this.mHooks;
        boolean z3 = false;
        if (r0 != null) {
            PorterDuff.Mode mode4 = AppCompatDrawableManager.DEFAULT_MODE;
            if (AppCompatDrawableManager.C00231.arrayContains((int[]) r0.COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
                i2 = C0130R.attr.colorControlNormal;
            } else if (AppCompatDrawableManager.C00231.arrayContains((int[]) r0.COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
                i2 = C0130R.attr.colorControlActivated;
            } else {
                if (AppCompatDrawableManager.C00231.arrayContains((int[]) r0.COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
                    mode4 = PorterDuff.Mode.MULTIPLY;
                } else if (i == 2131230797) {
                    i3 = Math.round(40.8f);
                    i2 = 16842800;
                    z2 = true;
                    if (z2) {
                        Drawable mutate = drawable.mutate();
                        mutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i2), mode4));
                        if (i3 != -1) {
                            mutate.setAlpha(i3);
                        }
                        z3 = true;
                    }
                } else if (i != C0130R.C0131drawable.abc_dialog_material_background) {
                    i2 = 0;
                    i3 = -1;
                    z2 = false;
                    if (z2) {
                    }
                }
                i2 = 16842801;
            }
            i3 = -1;
            z2 = true;
            if (z2) {
            }
        }
        if (z3 || !z) {
            return drawable;
        }
        return null;
    }

    public final synchronized Drawable getDrawable(Context context, int i, boolean z) {
        Drawable loadDrawableFromDelegates;
        try {
            if (!this.mHasCheckedVectorDrawableSetup) {
                this.mHasCheckedVectorDrawableSetup = true;
                Drawable drawable = getDrawable(context, C0130R.C0131drawable.abc_vector_test);
                if (drawable == null || (!(drawable instanceof VectorDrawableCompat) && !"android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName()))) {
                    this.mHasCheckedVectorDrawableSetup = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            loadDrawableFromDelegates = loadDrawableFromDelegates(context, i);
            if (loadDrawableFromDelegates == null) {
                loadDrawableFromDelegates = createDrawableIfNeeded(context, i);
            }
            if (loadDrawableFromDelegates == null) {
                loadDrawableFromDelegates = ContextCompat$Api21Impl.getDrawable(context, i);
            }
            if (loadDrawableFromDelegates != null) {
                loadDrawableFromDelegates = tintDrawable(context, i, z, loadDrawableFromDelegates);
            }
            if (loadDrawableFromDelegates != null) {
                DrawableUtils.fixDrawable(loadDrawableFromDelegates);
            }
        } catch (Throwable th) {
            throw th;
        }
        return loadDrawableFromDelegates;
    }
}
