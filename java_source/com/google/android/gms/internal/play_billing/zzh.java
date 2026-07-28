package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class zzh {
    public static final zzh zza = new zzh(null, null);
    public final Runnable zzb;
    public final Executor zzc;
    public zzh zzd;

    public zzh(Runnable runnable, Executor executor) {
        this.zzb = runnable;
        this.zzc = executor;
    }
}
