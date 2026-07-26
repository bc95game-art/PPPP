package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class zzdb implements Runnable {
    public zzde zza;

    @Override // java.lang.Runnable
    public final void run() {
        zzcz zzczVar;
        boolean z;
        zzcj$zzc zzcj_zzc;
        zzde zzdeVar = this.zza;
        if (zzdeVar != null && (zzczVar = zzdeVar.zzd) != null) {
            this.zza = null;
            if (zzczVar.isDone()) {
                Object obj = zzdeVar.valueField;
                if (obj == null) {
                    if (!zzczVar.isDone()) {
                        zzcj$zzb zzcj_zzb = new zzcj$zzb(zzdeVar, zzczVar);
                        if (zzck.zzd.zzf(zzdeVar, null, zzcj_zzb)) {
                            try {
                                zzczVar.zzb(zzcj_zzb, zzcp.zza);
                                return;
                            } catch (Throwable th) {
                                try {
                                    zzcj_zzc = new zzcj$zzc(th);
                                } catch (Error | Exception unused) {
                                    zzcj_zzc = zzcj$zzc.zza;
                                }
                                zzck.zzd.zzf(zzdeVar, zzcj_zzb, zzcj_zzc);
                                return;
                            }
                        } else {
                            obj = zzdeVar.valueField;
                        }
                    } else if (zzck.zzd.zzf(zzdeVar, null, zzde.zzr(zzczVar))) {
                        zzde.zzu(zzdeVar);
                        return;
                    } else {
                        return;
                    }
                }
                if (obj instanceof zzcj$zza) {
                    z = ((zzcj$zza) obj).zzc;
                    return;
                }
                return;
            }
            z = true;
            try {
                ScheduledFuture scheduledFuture = zzdeVar.zze;
                zzdeVar.zze = null;
                String str = "Timed out";
                if (scheduledFuture != null) {
                    long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        str = "Timed out (timeout delayed by " + abs + " ms after scheduled time)";
                    }
                }
                if (zzck.zzd.zzf(zzdeVar, null, new zzcj$zzc(new TimeoutException(str + ": " + zzczVar.toString())))) {
                    zzde.zzu(zzdeVar);
                }
            } finally {
                zzczVar.cancel(z);
            }
        }
    }
}
