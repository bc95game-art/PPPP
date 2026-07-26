package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import com.android.billingclient.api.zzbv;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public abstract class FontRequestWorker {
    public static final ThreadPoolExecutor DEFAULT_EXECUTOR_SERVICE;
    public static final LruCache sTypefaceCache = new LruCache(16);
    public static final Object LOCK = new Object();
    public static final SimpleArrayMap PENDING_REPLIES = new SimpleArrayMap(0);

    /* renamed from: androidx.core.provider.FontRequestWorker$1 */
    /* loaded from: classes.dex */
    public final class CallableC00441 implements Callable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$id;
        public final /* synthetic */ FontRequest val$request;
        public final /* synthetic */ int val$style;

        public /* synthetic */ CallableC00441(String str, Context context, FontRequest fontRequest, int i, int i2) {
            this.$r8$classId = i2;
            this.val$id = str;
            this.val$context = context;
            this.val$request = fontRequest;
            this.val$style = i;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            switch (this.$r8$classId) {
                case 0:
                    return FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
                default:
                    try {
                        return FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$request, this.val$style);
                    } catch (Throwable unused) {
                        return new TypefaceResult(-3);
                    }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object, java.util.concurrent.ThreadFactory] */
    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), (ThreadFactory) new Object());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        DEFAULT_EXECUTOR_SERVICE = threadPoolExecutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TypefaceResult getFontSync(String str, Context context, FontRequest fontRequest, int i) {
        LruCache lruCache = sTypefaceCache;
        Typeface typeface = (Typeface) lruCache.get(str);
        if (typeface != null) {
            return new TypefaceResult(typeface);
        }
        try {
            zzbv fontFamilyResult = FontProvider.getFontFamilyResult(context, fontRequest);
            FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = (FontsContractCompat$FontInfo[]) fontFamilyResult.zza;
            int i2 = fontFamilyResult.zzb;
            int i3 = 1;
            if (i2 != 0) {
                if (i2 == 1) {
                    i3 = -2;
                    if (i3 != 0) {
                        return new TypefaceResult(i3);
                    }
                    Typeface createFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, fontsContractCompat$FontInfoArr, i);
                    if (createFromFontInfo == null) {
                        return new TypefaceResult(-3);
                    }
                    lruCache.put(str, createFromFontInfo);
                    return new TypefaceResult(createFromFontInfo);
                }
                i3 = -3;
                if (i3 != 0) {
                }
            } else {
                if (fontsContractCompat$FontInfoArr != null && fontsContractCompat$FontInfoArr.length != 0) {
                    int length = fontsContractCompat$FontInfoArr.length;
                    i3 = 0;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        }
                        int i5 = fontsContractCompat$FontInfoArr[i4].mResultCode;
                        if (i5 == 0) {
                            i4++;
                        } else if (i5 >= 0) {
                            i3 = i5;
                        }
                    }
                }
                if (i3 != 0) {
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
            return new TypefaceResult(-1);
        }
    }

    /* loaded from: classes.dex */
    public final class TypefaceResult {
        public final int mResult;
        public final Typeface mTypeface;

        public TypefaceResult(int i) {
            this.mTypeface = null;
            this.mResult = i;
        }

        public TypefaceResult(Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }
    }
}
