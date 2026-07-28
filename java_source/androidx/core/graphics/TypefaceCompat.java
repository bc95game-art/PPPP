package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$ProviderResourceEntry;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.p002os.BundleKt;
import androidx.core.provider.CallbackWithHandler$2;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontRequestWorker;
import androidx.viewpager2.widget.FakeDrag;
import com.android.billingclient.api.zzam;
import com.android.billingclient.api.zzbr;
import com.android.billingclient.api.zzcl;
import com.google.android.gms.tasks.zzi;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public abstract class TypefaceCompat {
    public static final LruCache sTypefaceCache;
    public static final BundleKt sTypefaceCompatImpl;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            sTypefaceCompatImpl = new BundleKt();
        } else if (i >= 28) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else if (i >= 26) {
            sTypefaceCompatImpl = new TypefaceCompatApi26Impl();
        } else {
            if (i >= 24) {
                Method method = TypefaceCompatApi24Impl.sAddFontWeightStyle;
                if (method == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (method != null) {
                    sTypefaceCompatImpl = new BundleKt();
                }
            }
            sTypefaceCompatImpl = new BundleKt();
        }
        sTypefaceCache = new LruCache(16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        if (r1.equals(r2) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface createFromResourcesFamilyXml(Context context, FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry, Resources resources, int i, String str, int i2, int i3, ResourcesCompat.FontCallback fontCallback, boolean z) {
        Typeface typeface;
        boolean z2;
        int i4;
        Typeface typeface2;
        Handler handler;
        Typeface typeface3 = null;
        if (fontResourcesParserCompat$FamilyResourceEntry instanceof FontResourcesParserCompat$ProviderResourceEntry) {
            FontResourcesParserCompat$ProviderResourceEntry fontResourcesParserCompat$ProviderResourceEntry = (FontResourcesParserCompat$ProviderResourceEntry) fontResourcesParserCompat$FamilyResourceEntry;
            String str2 = fontResourcesParserCompat$ProviderResourceEntry.mSystemFontFamilyName;
            if (str2 != null && !str2.isEmpty()) {
                typeface = Typeface.create(str2, 0);
                Typeface create = Typeface.create(Typeface.DEFAULT, 0);
                if (typeface != null) {
                }
            }
            typeface = null;
            if (typeface != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(typeface, null);
                }
                return typeface;
            }
            if (!z ? fontCallback != null : fontResourcesParserCompat$ProviderResourceEntry.mStrategy != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z) {
                i4 = fontResourcesParserCompat$ProviderResourceEntry.mTimeoutMs;
            } else {
                i4 = -1;
            }
            Handler handler2 = ResourcesCompat.FontCallback.getHandler(null);
            FakeDrag fakeDrag = new FakeDrag(9);
            fakeDrag.mScrollEventAdapter = fontCallback;
            FontRequest fontRequest = fontResourcesParserCompat$ProviderResourceEntry.mRequest;
            zzcl zzclVar = new zzcl(fakeDrag, 8, handler2);
            if (z2) {
                LruCache lruCache = FontRequestWorker.sTypefaceCache;
                String str3 = ((String) fontRequest.mIdentifier) + "-" + i3;
                typeface2 = (Typeface) FontRequestWorker.sTypefaceCache.get(str3);
                if (typeface2 != null) {
                    handler2.post(new zzi(fakeDrag, 4, typeface2));
                } else if (i4 == -1) {
                    FontRequestWorker.TypefaceResult fontSync = FontRequestWorker.getFontSync(str3, context, fontRequest, i3);
                    zzclVar.onTypefaceResult(fontSync);
                    typeface3 = fontSync.mTypeface;
                } else {
                    try {
                        try {
                            try {
                                try {
                                    FontRequestWorker.TypefaceResult typefaceResult = (FontRequestWorker.TypefaceResult) FontRequestWorker.DEFAULT_EXECUTOR_SERVICE.submit(new FontRequestWorker.CallableC00441(str3, context, fontRequest, i3, 0)).get(i4, TimeUnit.MILLISECONDS);
                                    zzclVar.onTypefaceResult(typefaceResult);
                                    typeface3 = typefaceResult.mTypeface;
                                } catch (TimeoutException unused) {
                                    throw new InterruptedException("timeout");
                                }
                            } catch (InterruptedException e) {
                                throw e;
                            }
                        } catch (ExecutionException e2) {
                            throw new RuntimeException(e2);
                        }
                    } catch (InterruptedException unused2) {
                        ((Handler) zzclVar.zzc).post(new CallbackWithHandler$2(-3, 0, (FakeDrag) zzclVar.zzb));
                    }
                }
            } else {
                LruCache lruCache2 = FontRequestWorker.sTypefaceCache;
                String str4 = ((String) fontRequest.mIdentifier) + "-" + i3;
                typeface2 = (Typeface) FontRequestWorker.sTypefaceCache.get(str4);
                if (typeface2 != null) {
                    handler2.post(new zzi(fakeDrag, 4, typeface2));
                } else {
                    zzbr zzbrVar = new zzbr(1, zzclVar);
                    synchronized (FontRequestWorker.LOCK) {
                        try {
                            SimpleArrayMap simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
                            ArrayList arrayList = (ArrayList) simpleArrayMap.get(str4);
                            if (arrayList != null) {
                                arrayList.add(zzbrVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzbrVar);
                                simpleArrayMap.put(str4, arrayList2);
                                FontRequestWorker.CallableC00441 r0 = new FontRequestWorker.CallableC00441(str4, context, fontRequest, i3, 1);
                                ThreadPoolExecutor threadPoolExecutor = FontRequestWorker.DEFAULT_EXECUTOR_SERVICE;
                                zzbr zzbrVar2 = new zzbr(2, str4);
                                if (Looper.myLooper() == null) {
                                    handler = new Handler(Looper.getMainLooper());
                                } else {
                                    handler = new Handler();
                                }
                                zzam zzamVar = new zzam();
                                zzamVar.zza = r0;
                                zzamVar.zzb = zzbrVar2;
                                zzamVar.zzc = handler;
                                threadPoolExecutor.execute(zzamVar);
                            }
                        } finally {
                        }
                    }
                }
            }
            typeface3 = typeface2;
        } else {
            Typeface createFromFontFamilyFilesResourceEntry = sTypefaceCompatImpl.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat$FontFamilyFilesResourceEntry) fontResourcesParserCompat$FamilyResourceEntry, resources, i3);
            if (fontCallback != null) {
                if (createFromFontFamilyFilesResourceEntry != null) {
                    fontCallback.callbackSuccessAsync(createFromFontFamilyFilesResourceEntry, null);
                } else {
                    fontCallback.callbackFailAsync(-3, null);
                }
            }
            typeface3 = createFromFontFamilyFilesResourceEntry;
        }
        if (typeface3 != null) {
            sTypefaceCache.put(createResourceUid(resources, i, str, i2, i3), typeface3);
        }
        return typeface3;
    }

    public static String createResourceUid(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }
}
