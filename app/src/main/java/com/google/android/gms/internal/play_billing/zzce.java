package com.google.android.gms.internal.play_billing;

import androidx.navigation.Navigation;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public final class zzce extends zzbt {
    public final transient Object[] zza;
    public final transient int zzb;
    public final transient int zzc;

    public zzce(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Navigation.zza(i, this.zzc);
        Object obj = this.zza[i + i + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzf() {
        return true;
    }
}
