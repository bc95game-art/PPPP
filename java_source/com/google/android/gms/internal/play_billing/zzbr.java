package com.google.android.gms.internal.play_billing;

import androidx.navigation.Navigation;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class zzbr implements ListIterator, Iterator {
    public final zzbt zza;
    public final int zza$1;
    public int zzb;

    public zzbr(zzbt zzbtVar, int i) {
        int size = zzbtVar.size();
        Navigation.zzb(i, size);
        this.zza$1 = size;
        this.zzb = i;
        this.zza = zzbtVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        if (this.zzb < this.zza$1) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        if (this.zzb > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            int i = this.zzb;
            this.zzb = i + 1;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzb;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (hasPrevious()) {
            int i = this.zzb - 1;
            this.zzb = i;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzb - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
