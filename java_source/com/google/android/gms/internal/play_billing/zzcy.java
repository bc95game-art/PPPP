package com.google.android.gms.internal.play_billing;

import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class zzcy {
    public final zzbm zza = new Object();
    public final String zzb;
    public volatile Logger zzc;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.gms.internal.play_billing.zzbm] */
    public zzcy(Class cls) {
        this.zzb = cls.getName();
    }

    public final Logger zza() {
        Logger logger = this.zzc;
        if (logger != null) {
            return logger;
        }
        synchronized (this.zza) {
            try {
                Logger logger2 = this.zzc;
                if (logger2 != null) {
                    return logger2;
                }
                Logger logger3 = Logger.getLogger(this.zzb);
                this.zzc = logger3;
                return logger3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
