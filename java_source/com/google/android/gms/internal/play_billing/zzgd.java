package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class zzgd implements zzgj {
    public static final zza zza = new zza(4);
    public final Object zzb;

    public zzgd(zzgj... zzgjVarArr) {
        this.zzb = zzgjVarArr;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgj
    public zzgu zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzgj zzgjVar = ((zzgj[]) this.zzb)[i];
            if (zzgjVar.zzc(cls)) {
                return zzgjVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.play_billing.zzgj
    public boolean zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (((zzgj[]) this.zzb)[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }

    public void zzq(int i, Object obj, zzgv zzgvVar) {
        zzem zzemVar = (zzem) this.zzb;
        zzemVar.zzt(i, 3);
        zzgvVar.zzi((zzds) obj, zzemVar.zza);
        zzemVar.zzt(i, 4);
    }

    public void zzv(int i, Object obj, zzgv zzgvVar) {
        zzds zzdsVar = (zzds) obj;
        zzem zzemVar = (zzem) this.zzb;
        zzemVar.zzv((i << 3) | 2);
        zzemVar.zzv(zzdsVar.zze(zzgvVar));
        zzgvVar.zzi(zzdsVar, zzemVar.zza);
    }

    public zzgd() {
        zzgs zzgsVar = zzgs.zzb;
        zzgd zzgdVar = new zzgd(zza.zza, zza);
        Charset charset = zzfo.zza;
        this.zzb = zzgdVar;
    }

    public zzgd(zzem zzemVar) {
        Charset charset = zzfo.zza;
        this.zzb = zzemVar;
        zzemVar.zza = this;
    }
}
