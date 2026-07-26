package androidx.appcompat.app;

import android.content.Context;
/* loaded from: classes.dex */
public final /* synthetic */ class AppCompatDelegate$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ AppCompatDelegate$$ExternalSyntheticLambda0(Context context, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.util.concurrent.Executor, java.lang.Object] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            int r0 = r11.$r8$classId
            switch(r0) {
                case 0: goto L2f;
                case 1: goto L13;
                default: goto L5;
            }
        L5:
            androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0 r0 = new androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0
            r0.<init>()
            androidx.transition.ViewUtilsApi21 r1 = androidx.profileinstaller.Encoding.EMPTY_DIAGNOSTICS
            r2 = 0
            android.content.Context r3 = r11.f$0
            androidx.profileinstaller.Encoding.writeProfile(r3, r0, r1, r2)
            return
        L13:
            java.util.concurrent.ThreadPoolExecutor r4 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            r5 = 0
            r6 = 1
            r7 = 0
            r4.<init>(r5, r6, r7, r9, r10)
            androidx.appcompat.app.AppCompatDelegate$$ExternalSyntheticLambda0 r0 = new androidx.appcompat.app.AppCompatDelegate$$ExternalSyntheticLambda0
            r1 = 2
            android.content.Context r2 = r11.f$0
            r0.<init>(r2, r1)
            r4.execute(r0)
            return
        L2f:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 33
            if (r0 < r2) goto Laf
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r4 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            android.content.Context r5 = r11.f$0
            r3.<init>(r5, r4)
            android.content.pm.PackageManager r4 = r5.getPackageManager()
            int r4 = r4.getComponentEnabledSetting(r3)
            if (r4 == r1) goto Laf
            java.lang.String r4 = "locale"
            if (r0 < r2) goto L88
            androidx.collection.ArraySet r0 = androidx.appcompat.app.AppCompatDelegate.sActivityDelegates
            r0.getClass()
            androidx.collection.ArrayMap$KeyIterator r2 = new androidx.collection.ArrayMap$KeyIterator
            r2.<init>(r0)
        L57:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L76
            java.lang.Object r0 = r2.next()
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r0 = r0.get()
            androidx.appcompat.app.AppCompatDelegate r0 = (androidx.appcompat.app.AppCompatDelegate) r0
            if (r0 == 0) goto L57
            androidx.appcompat.app.AppCompatDelegateImpl r0 = (androidx.appcompat.app.AppCompatDelegateImpl) r0
            android.content.Context r0 = r0.mContext
            if (r0 == 0) goto L57
            java.lang.Object r0 = r0.getSystemService(r4)
            goto L77
        L76:
            r0 = 0
        L77:
            if (r0 == 0) goto L8d
            android.os.LocaleList r0 = androidx.appcompat.app.AppCompatDelegate.Api33Impl.localeManagerGetApplicationLocales(r0)
            androidx.core.os.LocaleListCompat r2 = new androidx.core.os.LocaleListCompat
            androidx.core.os.LocaleListPlatformWrapper r6 = new androidx.core.os.LocaleListPlatformWrapper
            r6.<init>(r0)
            r2.<init>(r6)
            goto L8f
        L88:
            androidx.core.os.LocaleListCompat r2 = androidx.appcompat.app.AppCompatDelegate.sRequestedAppLocales
            if (r2 == 0) goto L8d
            goto L8f
        L8d:
            androidx.core.os.LocaleListCompat r2 = androidx.core.os.LocaleListCompat.sEmptyLocaleList
        L8f:
            androidx.core.os.LocaleListInterface r0 = r2.mImpl
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto La8
            java.lang.String r0 = androidx.core.app.NavUtils.readLocales(r5)
            java.lang.Object r2 = r5.getSystemService(r4)
            if (r2 == 0) goto La8
            android.os.LocaleList r0 = androidx.appcompat.app.AppCompatDelegate.Api24Impl.localeListForLanguageTags(r0)
            androidx.appcompat.app.AppCompatDelegate.Api33Impl.localeManagerSetApplicationLocales(r2, r0)
        La8:
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            r0.setComponentEnabledSetting(r3, r1, r1)
        Laf:
            androidx.appcompat.app.AppCompatDelegate.sIsFrameworkSyncChecked = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegate$$ExternalSyntheticLambda0.run():void");
    }
}
