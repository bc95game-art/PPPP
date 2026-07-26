package com.google.android.gms.internal.play_billing;

import java.util.Set;
/* loaded from: classes.dex */
public abstract class zzbx extends zzbq implements Set, p004j$.util.Set {
    public transient zzbt zza;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (!containsAll(set)) {
                        return false;
                    }
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int i;
        int i2 = 0;
        for (Object obj : this) {
            if (obj != null) {
                i = obj.hashCode();
            } else {
                i = 0;
            }
            i2 += i;
        }
        return i2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    public zzbt zzd() {
        zzbt zzbtVar = this.zza;
        if (zzbtVar != null) {
            return zzbtVar;
        }
        zzbt zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    public zzbt zzh() {
        Object[] array = toArray(zzbq.zza);
        zzbr zzbrVar = zzbt.zza;
        return zzbt.zzi(array.length, array);
    }
}
