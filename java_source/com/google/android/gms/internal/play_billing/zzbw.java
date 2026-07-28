package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import p004j$.util.Map;
/* loaded from: classes.dex */
public abstract class zzbw implements Map, Serializable, p004j$.util.Map {
    public transient zzcc zza;
    public transient zzcd zzb;
    public transient zzce zzc;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // java.util.Map, p004j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // java.util.Map, p004j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        zzce zzceVar = this.zzc;
        if (zzceVar == null) {
            zzcf zzcfVar = (zzcf) this;
            zzce zzceVar2 = new zzce(zzcfVar.zzb, 1, zzcfVar.zzd);
            this.zzc = zzceVar2;
            zzceVar = zzceVar2;
        }
        return zzceVar.contains(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        zzcc zzccVar = this.zza;
        if (zzccVar != null) {
            return zzccVar;
        }
        zzcf zzcfVar = (zzcf) this;
        zzcc zzccVar2 = new zzcc(zzcfVar, zzcfVar.zzb, zzcfVar.zzd);
        this.zza = zzccVar2;
        return zzccVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        return entrySet().equals(((java.util.Map) obj).entrySet());
    }

    @Override // java.util.Map, p004j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map, p004j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        int i;
        zzcc zzccVar = this.zza;
        if (zzccVar == null) {
            zzcf zzcfVar = (zzcf) this;
            zzcc zzccVar2 = new zzcc(zzcfVar, zzcfVar.zzb, zzcfVar.zzd);
            this.zza = zzccVar2;
            zzccVar = zzccVar2;
        }
        int i2 = 0;
        for (Object obj : zzccVar) {
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i2 += i;
        }
        return i2;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return ((zzcf) this).size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        zzcd zzcdVar = this.zzb;
        if (zzcdVar != null) {
            return zzcdVar;
        }
        zzcf zzcfVar = (zzcf) this;
        zzcd zzcdVar2 = new zzcd(zzcfVar, new zzce(zzcfVar.zzb, 0, zzcfVar.zzd));
        this.zzb = zzcdVar2;
        return zzcdVar2;
    }

    @Override // java.util.Map, p004j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return get(obj);
    }

    @Override // java.util.Map, p004j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }

    @Override // java.util.Map, p004j$.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return get(obj);
    }

    @Override // java.util.Map, p004j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public final String toString() {
        int i = ((zzcf) this).zzd;
        if (i >= 0) {
            StringBuilder sb = new StringBuilder((int) Math.min(i * 8, 1073741824L));
            sb.append('{');
            Iterator it = ((zzcc) entrySet()).iterator();
            boolean z = true;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!z) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append('=');
                sb.append(entry.getValue());
                z = false;
            }
            sb.append('}');
            return sb.toString();
        }
        throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(i, "size cannot be negative but was: "));
    }

    @Override // java.util.Map
    public final Collection values() {
        zzce zzceVar = this.zzc;
        if (zzceVar != null) {
            return zzceVar;
        }
        zzcf zzcfVar = (zzcf) this;
        zzce zzceVar2 = new zzce(zzcfVar.zzb, 1, zzcfVar.zzd);
        this.zzc = zzceVar2;
        return zzceVar2;
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, p004j$.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }
}
