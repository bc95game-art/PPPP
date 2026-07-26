package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class zzea implements Iterator {
    public final /* synthetic */ zzeg zza;
    public int zzb = 0;
    public final int zzc;

    public zzea(zzeg zzegVar) {
        this.zza = zzegVar;
        this.zzc = zzegVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return Byte.valueOf(this.zza.zzb(i));
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
