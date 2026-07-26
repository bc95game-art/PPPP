package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
/* loaded from: classes.dex */
public final class zzs extends zzo {
    public final /* synthetic */ zzt zzg;

    public zzs(zzt zztVar) {
        this.zzg = zztVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzo
    public final String zza() {
        zzp zzpVar = (zzp) this.zzg.zza.get();
        if (zzpVar == null) {
            return "Completer object has been garbage collected, future will fail soon";
        }
        return ViewModelProvider.Factory.CC.m("tag=[", String.valueOf(zzpVar.zza), "]");
    }
}
