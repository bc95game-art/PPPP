package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.p002os.BundleKt;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    public final Method mAbortCreation;
    public final Method mAddFontFromAssetManager;
    public final Method mAddFontFromBuffer;
    public final Method mCreateFromFamiliesWithDefault;
    public final Class mFontFamily;
    public final Constructor mFontFamilyCtor;
    public final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            method4 = obtainAddFontFromAssetManagerMethod(cls2);
            Class<?> cls3 = Integer.TYPE;
            method3 = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method = cls2.getMethod("abortCreation", null);
            method5 = obtainCreateFromFamiliesWithDefaultMethod(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.mFontFamily = cls;
        this.mFontFamilyCtor = constructor;
        this.mAddFontFromAssetManager = method4;
        this.mAddFontFromBuffer = method3;
        this.mFreeze = method2;
        this.mAbortCreation = method;
        this.mCreateFromFamiliesWithDefault = method5;
    }

    public static Method obtainAddFontFromAssetManagerMethod(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public final boolean addFontFromAssetManager(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.mAddFontFromAssetManager.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.mFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.p002os.BundleKt
    public final Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int i) {
        Object obj;
        Method method = this.mAddFontFromAssetManager;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontResourcesParserCompat$FontFamilyFilesResourceEntry, resources, i);
        }
        try {
            obj = this.mFontFamilyCtor.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            FontResourcesParserCompat$FontFileResourceEntry[] fontResourcesParserCompat$FontFileResourceEntryArr = fontResourcesParserCompat$FontFamilyFilesResourceEntry.mEntries;
            int length = fontResourcesParserCompat$FontFileResourceEntryArr.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry = fontResourcesParserCompat$FontFileResourceEntryArr[i2];
                    Context context2 = context;
                    if (!addFontFromAssetManager(context2, obj, fontResourcesParserCompat$FontFileResourceEntry.mFileName, fontResourcesParserCompat$FontFileResourceEntry.mTtcIndex, fontResourcesParserCompat$FontFileResourceEntry.mWeight, fontResourcesParserCompat$FontFileResourceEntry.mItalic ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontResourcesParserCompat$FontFileResourceEntry.mVariationSettings))) {
                        try {
                            this.mAbortCreation.invoke(obj, null);
                            break;
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                        }
                    } else {
                        i2++;
                        context = context2;
                    }
                } else if (freeze(obj)) {
                    return createFromFamiliesWithDefault(obj);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[SYNTHETIC] */
    @Override // androidx.core.graphics.TypefaceCompatApi21Impl, androidx.core.p002os.BundleKt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i) {
        Object obj;
        Typeface createFromFamiliesWithDefault;
        boolean z;
        if (fontsContractCompat$FontInfoArr.length >= 1) {
            Method method = this.mAddFontFromAssetManager;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            try {
                if (method != null) {
                    HashMap hashMap = new HashMap();
                    for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArr) {
                        if (fontsContractCompat$FontInfo.mResultCode == 0) {
                            Uri uri = fontsContractCompat$FontInfo.mUri;
                            if (!hashMap.containsKey(uri)) {
                                hashMap.put(uri, BundleKt.mmap(context, uri));
                            }
                        }
                    }
                    Map unmodifiableMap = DesugarCollections.unmodifiableMap(hashMap);
                    try {
                        obj = this.mFontFamilyCtor.newInstance(null);
                    } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
                        obj = null;
                    }
                    if (obj != null) {
                        int length = fontsContractCompat$FontInfoArr.length;
                        int i2 = 0;
                        boolean z2 = false;
                        while (true) {
                            Method method2 = this.mAbortCreation;
                            if (i2 < length) {
                                FontsContractCompat$FontInfo fontsContractCompat$FontInfo2 = fontsContractCompat$FontInfoArr[i2];
                                ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(fontsContractCompat$FontInfo2.mUri);
                                if (byteBuffer != null) {
                                    try {
                                        z = ((Boolean) this.mAddFontFromBuffer.invoke(obj, byteBuffer, Integer.valueOf(fontsContractCompat$FontInfo2.mTtcIndex), null, Integer.valueOf(fontsContractCompat$FontInfo2.mWeight), Integer.valueOf(fontsContractCompat$FontInfo2.mItalic ? 1 : 0))).booleanValue();
                                    } catch (IllegalAccessException | InvocationTargetException unused2) {
                                        z = false;
                                        if (z) {
                                        }
                                    }
                                    if (z) {
                                        method2.invoke(obj, null);
                                        break;
                                    }
                                    z2 = true;
                                }
                                i2++;
                            } else if (!z2) {
                                method2.invoke(obj, null);
                            } else if (freeze(obj) && (createFromFamiliesWithDefault = createFromFamiliesWithDefault(obj)) != null) {
                                return Typeface.create(createFromFamiliesWithDefault, i);
                            }
                        }
                    }
                } else {
                    FontsContractCompat$FontInfo findBestInfo = findBestInfo(i, fontsContractCompat$FontInfoArr);
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo.mUri, "r", null);
                    if (openFileDescriptor != null) {
                        Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(findBestInfo.mWeight).setItalic(findBestInfo.mItalic).build();
                        openFileDescriptor.close();
                        return build;
                    } else if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                        return null;
                    }
                }
            } catch (IOException | IllegalAccessException | InvocationTargetException unused3) {
            }
        }
        return null;
    }

    @Override // androidx.core.p002os.BundleKt
    public final Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        Object obj;
        Method method = this.mAddFontFromAssetManager;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        try {
            obj = this.mFontFamilyCtor.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            if (!addFontFromAssetManager(context, obj, str, 0, -1, -1, null)) {
                try {
                    this.mAbortCreation.invoke(obj, null);
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                }
            } else if (freeze(obj)) {
                return createFromFamiliesWithDefault(obj);
            }
        }
        return null;
    }

    public final boolean freeze(Object obj) {
        try {
            return ((Boolean) this.mFreeze.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
