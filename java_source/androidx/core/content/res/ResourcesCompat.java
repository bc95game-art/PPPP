package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.collection.LruCache;
import androidx.core.graphics.TypefaceCompat;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public abstract class ResourcesCompat {
    public static final ThreadLocal sTempTypedValue = new ThreadLocal();
    public static final WeakHashMap sColorStateCaches = new WeakHashMap(0);
    public static final Object sColorStateCacheLock = new Object();

    /* loaded from: classes.dex */
    public abstract class Api21Impl {
        public static Drawable getDrawable(Resources resources, int i, Resources.Theme theme) {
            return resources.getDrawable(i, theme);
        }

        public static Drawable getDrawableForDensity(Resources resources, int i, int i2, Resources.Theme theme) {
            return resources.getDrawableForDensity(i, i2, theme);
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api23Impl {
        public static int getColor(Resources resources, int i, Resources.Theme theme) {
            return resources.getColor(i, theme);
        }

        public static ColorStateList getColorStateList(Resources resources, int i, Resources.Theme theme) {
            return resources.getColorStateList(i, theme);
        }
    }

    /* loaded from: classes.dex */
    public final class ColorStateListCacheEntry {
        public final Configuration mConfiguration;
        public final int mThemeHash;
        public final ColorStateList mValue;

        public ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            int i;
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
            if (theme == null) {
                i = 0;
            } else {
                i = theme.hashCode();
            }
            this.mThemeHash = i;
        }
    }

    /* loaded from: classes.dex */
    public final class ColorStateListCacheKey {
        public final Resources mResources;
        public final Resources.Theme mTheme;

        public ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ColorStateListCacheKey.class == obj.getClass()) {
                ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
                if (this.mResources.equals(colorStateListCacheKey.mResources) && Objects.equals(this.mTheme, colorStateListCacheKey.mTheme)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(this.mResources, this.mTheme);
        }
    }

    /* loaded from: classes.dex */
    public abstract class FontCallback {
        public static Handler getHandler(Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        public final void callbackFailAsync(int i, Handler handler) {
            getHandler(handler).post(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(i, 0, this));
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            getHandler(handler).post(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda0(this, 0, typeface));
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    public static void addColorStateListToCache(ColorStateListCacheKey colorStateListCacheKey, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                WeakHashMap weakHashMap = sColorStateCaches;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(colorStateListCacheKey);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(colorStateListCacheKey, sparseArray);
                }
                sparseArray.append(i, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00af A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface loadFont(Context context, int i, TypedValue typedValue, int i2, FontCallback fontCallback, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            Typeface typeface = null;
            if (charSequence2.startsWith("res/")) {
                int i3 = typedValue.assetCookie;
                LruCache lruCache = TypefaceCompat.sTypefaceCache;
                Typeface typeface2 = (Typeface) lruCache.get(TypefaceCompat.createResourceUid(resources, i, charSequence2, i3, i2));
                if (typeface2 != null) {
                    if (fontCallback != null) {
                        fontCallback.callbackSuccessAsync(typeface2, null);
                    }
                    typeface = typeface2;
                } else if (!z2) {
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            FontResourcesParserCompat$FamilyResourceEntry parse = CamUtils.parse(resources.getXml(i), resources);
                            if (parse == null) {
                                Log.e("ResourcesCompat", "Failed to find font-family tag");
                                if (fontCallback != null) {
                                    fontCallback.callbackFailAsync(-3, null);
                                }
                            } else {
                                typeface = TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i, charSequence2, typedValue.assetCookie, i2, fontCallback, z);
                            }
                        } else {
                            int i4 = typedValue.assetCookie;
                            Typeface createFromResourcesFontFile = TypefaceCompat.sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i, charSequence2, i2);
                            if (createFromResourcesFontFile != null) {
                                lruCache.put(TypefaceCompat.createResourceUid(resources, i, charSequence2, i4, i2), createFromResourcesFontFile);
                            }
                            if (fontCallback != null) {
                                if (createFromResourcesFontFile != null) {
                                    fontCallback.callbackSuccessAsync(createFromResourcesFontFile, null);
                                } else {
                                    fontCallback.callbackFailAsync(-3, null);
                                }
                            }
                            typeface = createFromResourcesFontFile;
                        }
                    } catch (IOException e) {
                        Log.e("ResourcesCompat", "Failed to read xml resource ".concat(charSequence2), e);
                        if (fontCallback != null) {
                            fontCallback.callbackFailAsync(-3, null);
                        }
                        if (typeface == null) {
                        }
                        return typeface;
                    } catch (XmlPullParserException e2) {
                        Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(charSequence2), e2);
                        if (fontCallback != null) {
                        }
                        if (typeface == null) {
                        }
                        return typeface;
                    }
                }
            } else if (fontCallback != null) {
                fontCallback.callbackFailAsync(-3, null);
            }
            if (typeface == null || fontCallback != null || z2) {
                return typeface;
            }
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
    }
}
