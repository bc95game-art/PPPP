package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class zzds {
    protected int zza;

    public final byte[] zzM() {
        try {
            zzfi zzfiVar = (zzfi) this;
            int zzj = zzfiVar.zzj();
            byte[] bArr = new byte[zzj];
            zzem zzemVar = new zzem(bArr, zzj);
            zzgv zzb = zzgs.zzb.zzb(zzfiVar.getClass());
            zzgd zzgdVar = zzemVar.zza;
            if (zzgdVar == null) {
                zzgdVar = new zzgd(zzemVar);
            }
            zzb.zzi(zzfiVar, zzgdVar);
            if (zzj - zzemVar.zze == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(ViewModelProvider.Factory.CC.m("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }

    public abstract int zze(zzgv zzgvVar);
}
