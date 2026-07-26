package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzcj$zza {
    public static final zzcj$zza zza;
    public static final zzcj$zza zzb;
    public final boolean zzc;
    public final Throwable zzd;

    static {
        if (zzck.zzc) {
            zzb = null;
            zza = null;
            return;
        }
        zzb = new zzcj$zza(false, null);
        zza = new zzcj$zza(true, null);
    }

    public zzcj$zza(boolean z, Throwable th) {
        this.zzc = z;
        this.zzd = th;
    }
}
