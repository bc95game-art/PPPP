package com.google.android.gms.internal.play_billing;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class zzt implements zzcz {
    public final WeakReference zza;
    public final zzs zzb = new zzs(this);

    public zzt(zzp zzpVar) {
        this.zza = new WeakReference(zzpVar);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        zzp zzpVar = (zzp) this.zza.get();
        boolean cancel = this.zzb.cancel(z);
        if (!cancel || zzpVar == null) {
            return cancel;
        }
        zzpVar.zza = null;
        zzpVar.zzb = null;
        zzpVar.zzc.zzd(null);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.zzb.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzb.zzc instanceof zze;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzb.isDone();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.play_billing.zzcz
    public final void zzb(Runnable runnable, Executor executor) {
        this.zzb.zzb(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.zzb.get(j, timeUnit);
    }
}
