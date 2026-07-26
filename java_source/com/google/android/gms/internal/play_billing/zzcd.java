package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
/* loaded from: classes.dex */
public final class zzcd extends zzbx {
    public final transient zzcf zza;
    public final transient zzce zzb;

    public zzcd(zzcf zzcfVar, zzce zzceVar) {
        this.zza = zzcfVar;
        this.zzb = zzceVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (this.zza.get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final int zza(Object[] objArr) {
        return this.zzb.zza(objArr);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx, com.google.android.gms.internal.play_billing.zzbq
    public final zzbt zzd() {
        return this.zzb;
    }
}
