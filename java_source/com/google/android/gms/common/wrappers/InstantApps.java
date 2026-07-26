package com.google.android.gms.common.wrappers;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
/* loaded from: classes.dex */
public abstract class InstantApps {
    public static Context zza;
    public static Boolean zzb;

    public static void generateConfigDelta_colorMode(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        i = configuration.colorMode;
        int i7 = i & 3;
        i2 = configuration2.colorMode;
        int i8 = i2 & 3;
        if (i7 != i8) {
            i6 = configuration3.colorMode;
            configuration3.colorMode = i6 | i8;
        }
        i3 = configuration.colorMode;
        int i9 = i3 & 12;
        i4 = configuration2.colorMode;
        int i10 = i4 & 12;
        if (i9 != i10) {
            i5 = configuration3.colorMode;
            configuration3.colorMode = i5 | i10;
        }
    }

    public static synchronized boolean isInstantApp(Context context) {
        boolean z;
        Boolean bool;
        synchronized (InstantApps.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = zza;
            if (!(context2 == null || (bool = zzb) == null || context2 != applicationContext)) {
                return bool.booleanValue();
            }
            zzb = null;
            if (Build.VERSION.SDK_INT >= 26) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                zzb = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    zzb = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    zzb = Boolean.FALSE;
                }
            }
            zza = applicationContext;
            return zzb.booleanValue();
        }
    }
}
