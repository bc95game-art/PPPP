package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzah;
/* loaded from: classes.dex */
public final class TaskCompletionSource {
    public final zzw zza = new zzw();

    public final void trySetException(Exception exc) {
        zzw zzwVar = this.zza;
        zzwVar.getClass();
        zzah.checkNotNull(exc, "Exception must not be null");
        synchronized (zzwVar.zza) {
            try {
                if (!zzwVar.zzc) {
                    zzwVar.zzc = true;
                    zzwVar.zzf = exc;
                    ((zzr) zzwVar.zzb).zzb(zzwVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
