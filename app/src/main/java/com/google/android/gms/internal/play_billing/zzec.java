package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
/* loaded from: classes.dex */
public final class zzec extends zzeg {
    public final int zzc;

    public zzec(byte[] bArr, int i) {
        super(bArr);
        zzeg.zzh(0, i, bArr.length);
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeg
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(ViewModelProvider.Factory.CC.m(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(ViewModelProvider.Factory.CC.m(i, i2, "Index > length: ", ", "));
    }

    @Override // com.google.android.gms.internal.play_billing.zzeg
    public final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.gms.internal.play_billing.zzeg
    public final int zzd() {
        return this.zzc;
    }
}
