package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzcj$zzb implements Runnable {
    public final zzde zza;
    public final zzcz zzb;

    public zzcj$zzb(zzde zzdeVar, zzcz zzczVar) {
        this.zza = zzdeVar;
        this.zzb = zzczVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza.valueField == this) {
            zzcz zzczVar = this.zzb;
            if (zzck.zzd.zzf(this.zza, this, zzde.zzr(zzczVar))) {
                zzde.zzu(this.zza);
            }
        }
    }
}
