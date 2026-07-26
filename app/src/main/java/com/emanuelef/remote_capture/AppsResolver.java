package com.emanuelef.remote_capture;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.ArrayMap;
import android.util.SparseArray;
import androidx.core.content.ContextCompat$Api21Impl;
import com.emanuelef.remote_capture.interfaces.DrawableLoader;
import com.emanuelef.remote_capture.model.AppDescriptor;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class AppsResolver {
    private static final String TAG = "AppsResolver";
    private Method getPackageInfoAsUser;
    private final SparseArray<AppDescriptor> mApps = new SparseArray<>();
    private final Context mContext;
    private boolean mFallbackToGlobalResolution;
    private final PackageManager mPm;
    private Drawable mVirtualAppIcon;
    private static final SparseArray<AppDescriptor> mMappedUids = new SparseArray<>();
    private static final ArrayMap<String, AppDescriptor> mMappedPackages = new ArrayMap<>();

    public AppsResolver(Context context) {
        this.mContext = context;
        this.mPm = context.getPackageManager();
        initVirtualApps();
    }

    public static synchronized void addMappedApp(int i, String str, String str2) {
        synchronized (AppsResolver.class) {
            AppDescriptor appDescriptor = new AppDescriptor(str2, null, str, i, false);
            mMappedUids.put(i, appDescriptor);
            mMappedPackages.put(str, appDescriptor);
        }
    }

    public static synchronized void clearMappedApps() {
        synchronized (AppsResolver.class) {
            mMappedUids.clear();
            mMappedPackages.clear();
        }
    }

    private static synchronized AppDescriptor getMappedApp(int i) {
        AppDescriptor appDescriptor;
        synchronized (AppsResolver.class) {
            appDescriptor = mMappedUids.get(i);
        }
        return appDescriptor;
    }

    private void initVirtualApps() {
        DrawableLoader appsResolver$$ExternalSyntheticLambda0 = new DrawableLoader(this) { // from class: com.emanuelef.remote_capture.AppsResolver$$ExternalSyntheticLambda0
            public final /* synthetic */ AppsResolver f$0;

            {
                this.f$0 = this;
            }

            @Override // com.emanuelef.remote_capture.interfaces.DrawableLoader
            public final Drawable getDrawable() {
                Drawable lambda$initVirtualApps$0;
                Drawable lambda$initVirtualApps$1;
                switch (r2) {
                    case 0:
                        lambda$initVirtualApps$0 = this.f$0.lambda$initVirtualApps$0();
                        return lambda$initVirtualApps$0;
                    default:
                        lambda$initVirtualApps$1 = this.f$0.lambda$initVirtualApps$1();
                        return lambda$initVirtualApps$1;
                }
            }
        };
        this.mApps.put(-1, new AppDescriptor(this.mContext.getString(R.string.unknown_app), new DrawableLoader(this) { // from class: com.emanuelef.remote_capture.AppsResolver$$ExternalSyntheticLambda0
            public final /* synthetic */ AppsResolver f$0;

            {
                this.f$0 = this;
            }

            @Override // com.emanuelef.remote_capture.interfaces.DrawableLoader
            public final Drawable getDrawable() {
                Drawable lambda$initVirtualApps$0;
                Drawable lambda$initVirtualApps$1;
                switch (r2) {
                    case 0:
                        lambda$initVirtualApps$0 = this.f$0.lambda$initVirtualApps$0();
                        return lambda$initVirtualApps$0;
                    default:
                        lambda$initVirtualApps$1 = this.f$0.lambda$initVirtualApps$1();
                        return lambda$initVirtualApps$1;
                }
            }
        }, "unknown", -1, true).setDescription(this.mContext.getString(R.string.unknown_app_info)));
        this.mApps.put(0, new AppDescriptor("Root", appsResolver$$ExternalSyntheticLambda0, "root", 0, true).setDescription(this.mContext.getString(R.string.root_app_info)));
        this.mApps.put(1000, new AppDescriptor("Android", appsResolver$$ExternalSyntheticLambda0, "android", 1000, true).setDescription(this.mContext.getString(R.string.android_app_info)));
        this.mApps.put(1001, new AppDescriptor(this.mContext.getString(R.string.phone_app), appsResolver$$ExternalSyntheticLambda0, "phone", 1001, true).setDescription(this.mContext.getString(R.string.phone_app_info)));
        this.mApps.put(1013, new AppDescriptor("MediaServer", appsResolver$$ExternalSyntheticLambda0, "mediaserver", 1013, true));
        this.mApps.put(1020, new AppDescriptor("MulticastDNSResponder", appsResolver$$ExternalSyntheticLambda0, "multicastdnsresponder", 1020, true));
        this.mApps.put(1021, new AppDescriptor("GPS", appsResolver$$ExternalSyntheticLambda0, "gps", 1021, true));
        this.mApps.put(1051, new AppDescriptor("netd", appsResolver$$ExternalSyntheticLambda0, "netd", 1051, true).setDescription(this.mContext.getString(R.string.netd_app_info)));
        this.mApps.put(9999, new AppDescriptor("Nobody", appsResolver$$ExternalSyntheticLambda0, "nobody", 9999, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable lambda$initVirtualApps$0() {
        if (this.mVirtualAppIcon == null) {
            this.mVirtualAppIcon = ContextCompat$Api21Impl.getDrawable(this.mContext, 17301651);
        }
        return this.mVirtualAppIcon;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable lambda$initVirtualApps$1() {
        return ContextCompat$Api21Impl.getDrawable(this.mContext, 17301568);
    }

    public static AppDescriptor resolveInstalledApp(PackageManager packageManager, String str, int i, boolean z) {
        AppDescriptor mappedApp = getMappedApp(str);
        if (mappedApp != null) {
            return mappedApp;
        }
        try {
            return new AppDescriptor(packageManager, Utils.getPackageInfo(packageManager, str, i));
        } catch (PackageManager.NameNotFoundException unused) {
            if (!z) {
                return null;
            }
            Log.w(TAG, "could not retrieve package: " + str);
            return null;
        }
    }

    public void clear() {
        this.mApps.clear();
        initVirtualApps();
    }

    public AppDescriptor getAppByPackage(String str, int i) {
        int uid = getUid(str);
        if (uid == -2) {
            return null;
        }
        return getAppByUid(uid, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6  */
    @android.annotation.SuppressLint({"DiscouragedPrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.emanuelef.remote_capture.model.AppDescriptor getAppByUid(int r12, int r13) {
        /*
            r11 = this;
            com.emanuelef.remote_capture.model.AppDescriptor r0 = getMappedApp(r12)
            if (r0 == 0) goto L7
            return r0
        L7:
            android.util.SparseArray<com.emanuelef.remote_capture.model.AppDescriptor> r0 = r11.mApps
            java.lang.Object r0 = r0.get(r12)
            com.emanuelef.remote_capture.model.AppDescriptor r0 = (com.emanuelef.remote_capture.model.AppDescriptor) r0
            if (r0 == 0) goto L12
            return r0
        L12:
            r1 = 0
            android.content.pm.PackageManager r2 = r11.mPm     // Catch: java.lang.SecurityException -> L1a
            java.lang.String[] r2 = r2.getPackagesForUid(r12)     // Catch: java.lang.SecurityException -> L1a
            goto L1f
        L1a:
            r2 = move-exception
            r2.printStackTrace()
            r2 = r1
        L1f:
            java.lang.String r3 = "AppsResolver"
            if (r2 == 0) goto Lac
            int r4 = r2.length
            r5 = 1
            if (r4 >= r5) goto L29
            goto Lac
        L29:
            r1 = 0
            r4 = r2[r1]
            int r6 = r2.length
            r7 = 0
        L2e:
            if (r7 >= r6) goto L3c
            r8 = r2[r7]
            int r9 = r8.compareTo(r4)
            if (r9 >= 0) goto L39
            r4 = r8
        L39:
            int r7 = r7 + 1
            goto L2e
        L3c:
            boolean r2 = r11.mFallbackToGlobalResolution
            if (r2 != 0) goto L9c
            boolean r2 = com.emanuelef.remote_capture.CaptureService.isCapturingAsRoot()
            if (r2 == 0) goto L9c
            java.lang.reflect.Method r2 = r11.getPackageInfoAsUser     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            r6 = 2
            r7 = 3
            if (r2 != 0) goto L69
            java.lang.Class<android.content.pm.PackageManager> r2 = android.content.pm.PackageManager.class
            java.lang.String r8 = "getPackageInfoAsUser"
            java.lang.Class[] r9 = new java.lang.Class[r7]     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            r9[r1] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            r9[r5] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            r9[r6] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r8, r9)     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            r11.getPackageInfoAsUser = r2     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            goto L69
        L63:
            r1 = move-exception
            goto L92
        L65:
            r1 = move-exception
            goto L92
        L67:
            r1 = move-exception
            goto L92
        L69:
            java.lang.reflect.Method r2 = r11.getPackageInfoAsUser     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            android.content.pm.PackageManager r8 = r11.mPm     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            java.lang.Integer r9 = java.lang.Integer.valueOf(r13)     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            int r10 = com.emanuelef.remote_capture.Utils.getUserId(r12)     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            r7[r1] = r4     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            r7[r5] = r9     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            r7[r6] = r10     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            java.lang.Object r1 = r2.invoke(r8, r7)     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            android.content.pm.PackageInfo r1 = (android.content.pm.PackageInfo) r1     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            if (r1 == 0) goto L9c
            com.emanuelef.remote_capture.model.AppDescriptor r2 = new com.emanuelef.remote_capture.model.AppDescriptor     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            android.content.pm.PackageManager r6 = r11.mPm     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            r2.<init>(r6, r1)     // Catch: java.lang.reflect.InvocationTargetException -> L63 java.lang.IllegalAccessException -> L65 java.lang.NoSuchMethodException -> L67
            r0 = r2
            goto L9c
        L92:
            java.lang.String r2 = "getPackageInfoAsUser call fails, falling back to standard resolution"
            com.emanuelef.remote_capture.Log.w(r3, r2)
            r1.printStackTrace()
            r11.mFallbackToGlobalResolution = r5
        L9c:
            if (r0 != 0) goto La4
            android.content.pm.PackageManager r0 = r11.mPm
            com.emanuelef.remote_capture.model.AppDescriptor r0 = resolveInstalledApp(r0, r4, r13)
        La4:
            if (r0 == 0) goto Lab
            android.util.SparseArray<com.emanuelef.remote_capture.model.AppDescriptor> r13 = r11.mApps
            r13.put(r12, r0)
        Lab:
            return r0
        Lac:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "could not retrieve package: uid="
            r13.<init>(r0)
            r13.append(r12)
            java.lang.String r12 = r13.toString()
            com.emanuelef.remote_capture.Log.w(r3, r12)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.AppsResolver.getAppByUid(int, int):com.emanuelef.remote_capture.model.AppDescriptor");
    }

    public int getUid(String str) {
        AppDescriptor mappedApp = getMappedApp(str);
        if (mappedApp != null) {
            return mappedApp.getUid();
        }
        if (!str.contains(".")) {
            for (int i = 0; i < this.mApps.size(); i++) {
                AppDescriptor valueAt = this.mApps.valueAt(i);
                if (valueAt.getPackageName().equals(str)) {
                    return valueAt.getUid();
                }
            }
            return -2;
        }
        try {
            return Utils.getPackageUid(this.mPm, str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w(TAG, "Could not retrieve package ".concat(str));
            return -2;
        }
    }

    private static synchronized AppDescriptor getMappedApp(String str) {
        AppDescriptor appDescriptor;
        synchronized (AppsResolver.class) {
            appDescriptor = mMappedPackages.get(str);
        }
        return appDescriptor;
    }

    public static AppDescriptor resolveInstalledApp(PackageManager packageManager, String str, int i) {
        return resolveInstalledApp(packageManager, str, i, true);
    }
}
