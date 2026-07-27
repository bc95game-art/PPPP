package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public final class zzcc extends zzbx {
    public final transient zzbw zza;
    public final transient Object[] zzb;
    public final transient int zzc;

    public zzcc(zzbw zzbwVar, Object[] objArr, int i) {
        this.zza = zzbwVar;
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public final int zza(Object[] objArr) {
        return zzd().zza(objArr);
    }

    @Override // com.google.android.gms.internal.play_billing.zzbx
    public final zzbt zzh() {
        return new zzcb(this);
    }
}
