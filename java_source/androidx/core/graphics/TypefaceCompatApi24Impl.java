package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.p002os.BundleKt;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
/* loaded from: classes.dex */
public final class TypefaceCompatApi24Impl extends BundleKt {
    public static final Method sAddFontWeightStyle;
    public static final Method sCreateFromFamiliesWithDefault;
    public static final Class sFontFamily;
    public static final Constructor sFontFamilyCtor;

    static {
        Method method;
        Method method2;
        Class<?> cls;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            Class<?> cls2 = Integer.TYPE;
            method = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method2 = null;
            method = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontWeightStyle = method;
        sCreateFromFamiliesWithDefault = method2;
    }

    public static boolean addFontWeightStyle(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) sAddFontWeightStyle.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface createFromFamiliesWithDefault$1(Object obj) {
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // androidx.core.p002os.BundleKt
    public final Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int i) {
        Object obj;
        FontResourcesParserCompat$FontFileResourceEntry[] fontResourcesParserCompat$FontFileResourceEntryArr;
        MappedByteBuffer mappedByteBuffer;
        FileInputStream fileInputStream;
        try {
            obj = sFontFamilyCtor.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            for (FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry : fontResourcesParserCompat$FontFamilyFilesResourceEntry.mEntries) {
                int i2 = fontResourcesParserCompat$FontFileResourceEntry.mResourceId;
                File tempFile = BundleKt.getTempFile(context);
                if (tempFile != null) {
                    try {
                        if (BundleKt.copyToFile(tempFile, resources, i2)) {
                            try {
                                fileInputStream = new FileInputStream(tempFile);
                            } catch (IOException unused2) {
                                mappedByteBuffer = null;
                            }
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                                if (mappedByteBuffer != null && addFontWeightStyle(obj, mappedByteBuffer, fontResourcesParserCompat$FontFileResourceEntry.mTtcIndex, fontResourcesParserCompat$FontFileResourceEntry.mWeight, fontResourcesParserCompat$FontFileResourceEntry.mItalic)) {
                                }
                            } finally {
                                break;
                            }
                        }
                    } finally {
                        tempFile.delete();
                    }
                }
                mappedByteBuffer = null;
                if (mappedByteBuffer != null) {
                }
            }
            return createFromFamiliesWithDefault$1(obj);
        }
        return null;
    }

    @Override // androidx.core.p002os.BundleKt
    public final Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i) {
        Object obj;
        try {
            obj = sFontFamilyCtor.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj != null) {
            int i2 = 0;
            SimpleArrayMap simpleArrayMap = new SimpleArrayMap(0);
            int length = fontsContractCompat$FontInfoArr.length;
            while (true) {
                if (i2 < length) {
                    FontsContractCompat$FontInfo fontsContractCompat$FontInfo = fontsContractCompat$FontInfoArr[i2];
                    Uri uri = fontsContractCompat$FontInfo.mUri;
                    ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(uri);
                    if (byteBuffer == null) {
                        byteBuffer = BundleKt.mmap(context, uri);
                        simpleArrayMap.put(uri, byteBuffer);
                    }
                    if (byteBuffer == null || !addFontWeightStyle(obj, byteBuffer, fontsContractCompat$FontInfo.mTtcIndex, fontsContractCompat$FontInfo.mWeight, fontsContractCompat$FontInfo.mItalic)) {
                        break;
                    }
                    i2++;
                } else {
                    Typeface createFromFamiliesWithDefault$1 = createFromFamiliesWithDefault$1(obj);
                    if (createFromFamiliesWithDefault$1 != null) {
                        return Typeface.create(createFromFamiliesWithDefault$1, i);
                    }
                }
            }
        }
        return null;
    }
}
