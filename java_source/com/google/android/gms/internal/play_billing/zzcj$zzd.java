package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class zzcj$zzd {
    public static final zzcj$zzd zza = new zzcj$zzd();
    public zzcj$zzd next;
    public final Runnable zzb;
    public final Executor zzc;

    public zzcj$zzd() {
        this.zzb = null;
        this.zzc = null;
    }

    public zzcj$zzd(Runnable runnable, Executor executor) {
        this.zzb = runnable;
        this.zzc = executor;
    }
}
