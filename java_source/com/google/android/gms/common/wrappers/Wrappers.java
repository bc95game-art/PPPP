package com.google.android.gms.common.wrappers;

import android.content.Context;
import androidx.navigation.internal.NavContext;
/* loaded from: classes.dex */
public final class Wrappers {
    public static final Wrappers zza;
    public NavContext zzb;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.common.wrappers.Wrappers, java.lang.Object] */
    static {
        ?? obj = new Object();
        obj.zzb = null;
        zza = obj;
    }

    public static NavContext packageManager(Context context) {
        NavContext navContext;
        Wrappers wrappers = zza;
        synchronized (wrappers) {
            try {
                if (wrappers.zzb == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    wrappers.zzb = new NavContext(context, false);
                }
                navContext = wrappers.zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return navContext;
    }
}
