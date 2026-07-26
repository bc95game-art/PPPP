package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
/* loaded from: classes.dex */
public final class zzgp implements zzgv {
    public final zzds zza;
    public final zza zzb;

    public zzgp(zza zzaVar, zzds zzdsVar) {
        zza zzaVar2 = zzex.zza;
        this.zzb = zzaVar;
        this.zza = zzdsVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final int zza(zzds zzdsVar) {
        zzhi zzhiVar = ((zzfi) zzdsVar).zzc;
        int i = zzhiVar.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < zzhiVar.zzb; i3++) {
            int zzC = zzem.zzC(8);
            int zzC2 = zzem.zzC(zzhiVar.zzc[i3] >>> 3) + zzem.zzC(16);
            int zzC3 = zzem.zzC(24);
            int zzd = ((zzeg) zzhiVar.zzd[i3]).zzd();
            i2 += zzC + zzC + zzC2 + ViewModelProvider.Factory.CC.m(zzd, zzd, zzC3);
        }
        zzhiVar.zze = i2;
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final int zzb(zzfi zzfiVar) {
        return zzfiVar.zzc.hashCode();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final zzfi zze() {
        zzds zzdsVar = this.zza;
        if (zzdsVar instanceof zzfi) {
            return (zzfi) ((zzfi) zzdsVar).zzb(4);
        }
        return ((zzfe) ((zzfi) zzdsVar).zzb(5)).zzf();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzf(Object obj) {
        this.zzb.getClass();
        zzhi zzhiVar = ((zzfi) obj).zzc;
        if (zzhiVar.zzf) {
            zzhiVar.zzf = false;
        }
        zza zzaVar = zzex.zza;
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzg(Object obj, Object obj2) {
        zzgx.zzp(obj, obj2);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdw zzdwVar) {
        zzfi zzfiVar = (zzfi) obj;
        if (zzfiVar.zzc == zzhi.zza) {
            zzfiVar.zzc = zzhi.zzf();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzi(Object obj, zzgd zzgdVar) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzj(zzfi zzfiVar, zzfi zzfiVar2) {
        if (!zzfiVar.zzc.equals(zzfiVar2.zzc)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzk(Object obj) {
        obj.getClass();
        throw new ClassCastException();
    }
}
