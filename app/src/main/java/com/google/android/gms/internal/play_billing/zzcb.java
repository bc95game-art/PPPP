package com.google.android.gms.internal.play_billing;

import androidx.navigation.Navigation;
import j$.util.Objects;
import java.util.AbstractMap;
/* loaded from: classes.dex */
public final class zzcb extends zzbt {
    public final /* synthetic */ zzcc zza;

    public zzcb(zzcc zzccVar) {
        this.zza = zzccVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        zzcc zzccVar = this.zza;
        Navigation.zza(i, zzccVar.zzc);
        Object[] objArr = zzccVar.zzb;
        int i2 = i + i;
        Object obj = objArr[i2];
        Objects.requireNonNull(obj);
        Object obj2 = objArr[i2 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final boolean zzf() {
        return true;
    }
}
