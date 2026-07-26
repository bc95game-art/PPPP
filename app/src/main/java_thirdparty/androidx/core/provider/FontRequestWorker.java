package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
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

    /* renamed from: androidx.core.provider.FontRequestWorker$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements Callable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$id;
        public final /* synthetic */ FontRequest val$request;
        public final /* synthetic */ int val$style;

        public /* synthetic */ AnonymousClass1(String str, Context context, FontRequest fontRequest, int i, int i2) {
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.core.provider.FontRequestWorker.TypefaceResult getFontSync(java.lang.String r6, android.content.Context r7, androidx.core.provider.FontRequest r8, int r9) {
        /*
            androidx.collection.LruCache r0 = androidx.core.provider.FontRequestWorker.sTypefaceCache
            java.lang.Object r1 = r0.get(r6)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L10
            androidx.core.provider.FontRequestWorker$TypefaceResult r6 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r6.<init>(r1)
            return r6
        L10:
            com.android.billingclient.api.zzbv r8 = androidx.core.provider.FontProvider.getFontFamilyResult(r7, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L5c
            java.lang.Object r1 = r8.zza
            androidx.core.provider.FontsContractCompat$FontInfo[] r1 = (androidx.core.provider.FontsContractCompat$FontInfo[]) r1
            int r8 = r8.zzb
            r2 = -3
            r3 = 1
            if (r8 == 0) goto L24
            if (r8 == r3) goto L22
        L20:
            r3 = -3
            goto L3d
        L22:
            r3 = -2
            goto L3d
        L24:
            if (r1 == 0) goto L3d
            int r8 = r1.length
            if (r8 != 0) goto L2a
            goto L3d
        L2a:
            int r8 = r1.length
            r3 = 0
            r4 = 0
        L2d:
            if (r4 >= r8) goto L3d
            r5 = r1[r4]
            int r5 = r5.mResultCode
            if (r5 == 0) goto L3a
            if (r5 >= 0) goto L38
            goto L20
        L38:
            r3 = r5
            goto L3d
        L3a:
            int r4 = r4 + 1
            goto L2d
        L3d:
            if (r3 == 0) goto L45
            androidx.core.provider.FontRequestWorker$TypefaceResult r6 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r6.<init>(r3)
            return r6
        L45:
            androidx.core.os.BundleKt r8 = androidx.core.graphics.TypefaceCompat.sTypefaceCompatImpl
            android.graphics.Typeface r7 = r8.createFromFontInfo(r7, r1, r9)
            if (r7 == 0) goto L56
            r0.put(r6, r7)
            androidx.core.provider.FontRequestWorker$TypefaceResult r6 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r6.<init>(r7)
            return r6
        L56:
            androidx.core.provider.FontRequestWorker$TypefaceResult r6 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r6.<init>(r2)
            return r6
        L5c:
            androidx.core.provider.FontRequestWorker$TypefaceResult r6 = new androidx.core.provider.FontRequestWorker$TypefaceResult
            r7 = -1
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontRequestWorker.getFontSync(java.lang.String, android.content.Context, androidx.core.provider.FontRequest, int):androidx.core.provider.FontRequestWorker$TypefaceResult");
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
