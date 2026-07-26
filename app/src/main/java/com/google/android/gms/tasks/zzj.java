package com.google.android.gms.tasks;

import com.android.billingclient.api.zzcl;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class zzj {
    public final Executor zza;
    public final Object zzb = new Object();
    public final zzcl zzc;

    public zzj(Executor executor, zzcl zzclVar) {
        this.zza = executor;
        this.zzc = zzclVar;
    }

    public final void zzd(zzw zzwVar) {
        synchronized (this.zzb) {
        }
        this.zza.execute(new zzi(0, this, zzwVar, false));
    }
}
