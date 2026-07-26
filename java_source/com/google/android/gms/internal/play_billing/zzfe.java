package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public abstract class zzfe implements Cloneable {
    public zzfi zza;
    public final zzfi zzb;

    public zzfe(zzfi zzfiVar) {
        this.zzb = zzfiVar;
        if (!zzfiVar.zzz()) {
            this.zza = (zzfi) zzfiVar.zzb(4);
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    public final Object clone() {
        zzfe zzfeVar = (zzfe) this.zzb.zzb(5);
        zzfeVar.zza = zzf();
        return zzfeVar;
    }

    public final zzfi zze() {
        zzfi zzf = zzf();
        zzf.getClass();
        if (zzfi.zzA(zzf, true)) {
            return zzf;
        }
        throw new zzhg();
    }

    public final zzfi zzf() {
        if (!this.zza.zzz()) {
            return this.zza;
        }
        zzfi zzfiVar = this.zza;
        zzfiVar.getClass();
        zzgs.zzb.zzb(zzfiVar.getClass()).zzf(zzfiVar);
        zzfiVar.zzv();
        return this.zza;
    }

    public final void zzi() {
        if (!this.zza.zzz()) {
            zzfi zzfiVar = (zzfi) this.zzb.zzb(4);
            zzgs.zzb.zzb(zzfiVar.getClass()).zzg(zzfiVar, this.zza);
            this.zza = zzfiVar;
        }
    }
}
