package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzp {
    public Object zza;
    public zzt zzb;
    public zzv zzc;
    public boolean zzd;

    public final void finalize() {
        zzv zzvVar;
        zzt zztVar = this.zzb;
        if (zztVar != null) {
            zzs zzsVar = zztVar.zzb;
            if (!zzsVar.isDone()) {
                if (zzo.zzb.zzd(zzsVar, null, new zzg(new zzf("The completer object was garbage collected - this future would otherwise never complete. The tag was: ".concat(String.valueOf(this.zza)), 1)))) {
                    zzo.zzc(zzsVar);
                }
            }
        }
        if (!this.zzd && (zzvVar = this.zzc) != null) {
            zzvVar.zzd(null);
        }
    }

    public final void zzb(Object obj) {
        this.zzd = true;
        zzt zztVar = this.zzb;
        if (zztVar != null) {
            zzs zzsVar = zztVar.zzb;
            zzsVar.getClass();
            if (obj == null) {
                obj = zzo.zzh;
            }
            if (zzo.zzb.zzd(zzsVar, null, obj)) {
                zzo.zzc(zzsVar);
                this.zza = null;
                this.zzb = null;
                this.zzc = null;
            }
        }
    }
}
