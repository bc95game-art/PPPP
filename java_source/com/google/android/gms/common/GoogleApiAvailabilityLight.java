package com.google.android.gms.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.internal.Lock;
import androidx.navigation.Navigation;
import androidx.navigation.internal.NavContext;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class GoogleApiAvailabilityLight {
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;

    static {
        AtomicBoolean atomicBoolean = GooglePlayServicesUtil.sCanceledAvailabilityNotification;
    }

    public Intent getErrorResolutionIntent(int i, Context context, String str) {
        if (i == 1 || i == 2) {
            if (context == null || !Navigation.isWearableWithoutPlayStore(context)) {
                StringBuilder sb = new StringBuilder("gcore_");
                sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
                sb.append("-");
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                }
                sb.append("-");
                if (context != null) {
                    sb.append(context.getPackageName());
                }
                sb.append("-");
                if (context != null) {
                    try {
                        NavContext packageManager = Wrappers.packageManager(context);
                        sb.append(packageManager.context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                String sb2 = sb.toString();
                Intent intent = new Intent("android.intent.action.VIEW");
                Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
                if (!TextUtils.isEmpty(sb2)) {
                    appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
                }
                intent.setData(appendQueryParameter.build());
                intent.setPackage("com.android.vending");
                intent.addFlags(524288);
                return intent;
            }
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        } else if (i != 3) {
            return null;
        } else {
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(fromParts);
            return intent3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x020b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x020c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int isGooglePlayServicesAvailable(Context context, int i) {
        boolean z;
        PackageInfo packageInfo;
        int i2;
        boolean z2;
        Bundle bundle;
        AtomicBoolean atomicBoolean = GooglePlayServicesUtil.sCanceledAvailabilityNotification;
        try {
            context.getResources().getString(C0130R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        boolean z3 = true;
        if (!"com.google.android.gms".equals(context.getPackageName()) && !GooglePlayServicesUtil.zzc.get()) {
            synchronized (zzah.zza) {
                try {
                    if (!zzah.zzb) {
                        zzah.zzb = true;
                        try {
                            bundle = Wrappers.packageManager(context).context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        } catch (PackageManager.NameNotFoundException e) {
                            Log.wtf("MetadataValueReader", "This should never happen.", e);
                        }
                        if (bundle != null) {
                            bundle.getString("com.google.app.id");
                            zzah.zzd = bundle.getInt("com.google.android.gms.version");
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i3 = zzah.zzd;
            if (i3 == 0) {
                throw new GooglePlayServicesMissingManifestValueException();
            } else if (i3 != 12451000) {
                int i4 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + i4 + " but found " + i3 + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        if (!Navigation.isWearableWithoutPlayStore(context)) {
            if (Navigation.zzh == null) {
                if (context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Navigation.zzh = Boolean.valueOf(z2);
            }
            if (!Navigation.zzh.booleanValue()) {
                z = true;
                if (i < 0) {
                    String packageName = context.getPackageName();
                    PackageManager packageManager = context.getPackageManager();
                    int i5 = 9;
                    if (z) {
                        try {
                            packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
                        } catch (PackageManager.NameNotFoundException unused2) {
                            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
                        }
                    } else {
                        packageInfo = null;
                    }
                    try {
                        PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
                        Lock.getInstance(context);
                        if (!Lock.zzb(packageInfo2)) {
                            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
                        } else {
                            if (z) {
                                zzah.checkNotNull(packageInfo);
                                if (!Lock.zzb(packageInfo)) {
                                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                                }
                            }
                            if (!z || packageInfo == null || packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                                int i6 = packageInfo2.versionCode;
                                int i7 = -1;
                                if (i6 == -1) {
                                    i2 = -1;
                                } else {
                                    i2 = i6 / 1000;
                                }
                                if (i != -1) {
                                    i7 = i / 1000;
                                }
                                if (i2 < i7) {
                                    Log.w("GooglePlayServicesUtil", "Google Play services out of date for " + packageName + ".  Requires " + i + " but found " + i6);
                                    i5 = 2;
                                } else {
                                    ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                                    if (applicationInfo == null) {
                                        try {
                                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                                        } catch (PackageManager.NameNotFoundException e2) {
                                            Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e2);
                                            i5 = 1;
                                            if (i5 != 18) {
                                            }
                                            if (!z3) {
                                            }
                                        }
                                    }
                                    i5 = !applicationInfo.enabled ? 3 : 0;
                                }
                            } else {
                                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                            }
                        }
                    } catch (PackageManager.NameNotFoundException unused3) {
                        Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
                    }
                    if (i5 != 18) {
                        if (i5 == 1) {
                            try {
                                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if ("com.google.android.gms".equals(it.next().getAppPackageName())) {
                                            break;
                                        }
                                    } else {
                                        z3 = context.getPackageManager().getApplicationInfo("com.google.android.gms", CaptureService.CONNECTIONS_LOG_SIZE).enabled;
                                        break;
                                    }
                                }
                            } catch (PackageManager.NameNotFoundException | Exception unused4) {
                            }
                        }
                        z3 = false;
                    }
                    if (!z3) {
                        return 18;
                    }
                    return i5;
                }
                throw new IllegalArgumentException();
            }
        }
        z = false;
        if (i < 0) {
        }
    }
}
