package com.emanuelef.remote_capture;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.ArrayMap;
import android.util.SparseArray;
import androidx.core.content.ContextCompat$Api21Impl;
import com.emanuelef.remote_capture.interfaces.DrawableLoader;
import com.emanuelef.remote_capture.model.AppDescriptor;
import java.lang.reflect.InvocationTargetException;
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
        this.mApps.put(-1, new AppDescriptor(this.mContext.getString(C0130R.string.unknown_app), new DrawableLoader(this) { // from class: com.emanuelef.remote_capture.AppsResolver$$ExternalSyntheticLambda0
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
        }, "unknown", -1, true).setDescription(this.mContext.getString(C0130R.string.unknown_app_info)));
        this.mApps.put(0, new AppDescriptor("Root", appsResolver$$ExternalSyntheticLambda0, "root", 0, true).setDescription(this.mContext.getString(C0130R.string.root_app_info)));
        this.mApps.put(1000, new AppDescriptor("Android", appsResolver$$ExternalSyntheticLambda0, "android", 1000, true).setDescription(this.mContext.getString(C0130R.string.android_app_info)));
        this.mApps.put(1001, new AppDescriptor(this.mContext.getString(C0130R.string.phone_app), appsResolver$$ExternalSyntheticLambda0, "phone", 1001, true).setDescription(this.mContext.getString(C0130R.string.phone_app_info)));
        this.mApps.put(1013, new AppDescriptor("MediaServer", appsResolver$$ExternalSyntheticLambda0, "mediaserver", 1013, true));
        this.mApps.put(1020, new AppDescriptor("MulticastDNSResponder", appsResolver$$ExternalSyntheticLambda0, "multicastdnsresponder", 1020, true));
        this.mApps.put(1021, new AppDescriptor("GPS", appsResolver$$ExternalSyntheticLambda0, "gps", 1021, true));
        this.mApps.put(1051, new AppDescriptor("netd", appsResolver$$ExternalSyntheticLambda0, "netd", 1051, true).setDescription(this.mContext.getString(C0130R.string.netd_app_info)));
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
            Log.m581w(TAG, "could not retrieve package: " + str);
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
    @SuppressLint({"DiscouragedPrivateApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppDescriptor getAppByUid(int i, int i2) {
        String[] strArr;
        Throwable e;
        AppDescriptor mappedApp = getMappedApp(i);
        if (mappedApp != null) {
            return mappedApp;
        }
        AppDescriptor appDescriptor = this.mApps.get(i);
        if (appDescriptor != null) {
            return appDescriptor;
        }
        try {
            strArr = this.mPm.getPackagesForUid(i);
        } catch (SecurityException e2) {
            e2.printStackTrace();
            strArr = null;
        }
        if (strArr == null || strArr.length < 1) {
            Log.m581w(TAG, "could not retrieve package: uid=" + i);
            return null;
        }
        String str = strArr[0];
        for (String str2 : strArr) {
            if (str2.compareTo(str) < 0) {
                str = str2;
            }
        }
        if (!this.mFallbackToGlobalResolution && CaptureService.isCapturingAsRoot()) {
            try {
                if (this.getPackageInfoAsUser == null) {
                    Class cls = Integer.TYPE;
                    this.getPackageInfoAsUser = PackageManager.class.getDeclaredMethod("getPackageInfoAsUser", String.class, cls, cls);
                }
                PackageInfo packageInfo = (PackageInfo) this.getPackageInfoAsUser.invoke(this.mPm, str, Integer.valueOf(i2), Integer.valueOf(Utils.getUserId(i)));
                if (packageInfo != null) {
                    appDescriptor = new AppDescriptor(this.mPm, packageInfo);
                }
            } catch (IllegalAccessException e3) {
                e = e3;
                Log.m581w(TAG, "getPackageInfoAsUser call fails, falling back to standard resolution");
                e.printStackTrace();
                this.mFallbackToGlobalResolution = true;
                if (appDescriptor == null) {
                }
                if (appDescriptor != null) {
                }
                return appDescriptor;
            } catch (NoSuchMethodException e4) {
                e = e4;
                Log.m581w(TAG, "getPackageInfoAsUser call fails, falling back to standard resolution");
                e.printStackTrace();
                this.mFallbackToGlobalResolution = true;
                if (appDescriptor == null) {
                }
                if (appDescriptor != null) {
                }
                return appDescriptor;
            } catch (InvocationTargetException e5) {
                e = e5;
                Log.m581w(TAG, "getPackageInfoAsUser call fails, falling back to standard resolution");
                e.printStackTrace();
                this.mFallbackToGlobalResolution = true;
                if (appDescriptor == null) {
                }
                if (appDescriptor != null) {
                }
                return appDescriptor;
            }
        }
        if (appDescriptor == null) {
            appDescriptor = resolveInstalledApp(this.mPm, str, i2);
        }
        if (appDescriptor != null) {
            this.mApps.put(i, appDescriptor);
        }
        return appDescriptor;
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
            Log.m581w(TAG, "Could not retrieve package ".concat(str));
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
