package com.google.android.gms.internal.play_billing;

import java.util.concurrent.CancellationException;
/* loaded from: classes.dex */
public final class zze {
    public static final zze zza;
    public static final zze zzb;
    public final Throwable zzc;

    static {
        if (zzo.zza) {
            zzb = null;
            zza = null;
            return;
        }
        zzb = new zze(null);
        zza = new zze(null);
    }

    public zze(CancellationException cancellationException) {
        this.zzc = cancellationException;
    }
}
