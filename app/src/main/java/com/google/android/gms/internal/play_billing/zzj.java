package com.google.android.gms.internal.play_billing;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class zzj extends LazyKt__LazyJVMKt {
    public final AtomicReferenceFieldUpdater zza;
    public final AtomicReferenceFieldUpdater zzb;
    public final AtomicReferenceFieldUpdater zzc;
    public final AtomicReferenceFieldUpdater zzd;
    public final AtomicReferenceFieldUpdater zze;

    public zzj(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicReferenceFieldUpdater2;
        this.zzc = atomicReferenceFieldUpdater3;
        this.zzd = atomicReferenceFieldUpdater4;
        this.zze = atomicReferenceFieldUpdater5;
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final void zza(zzm zzmVar, zzm zzmVar2) {
        this.zzb.lazySet(zzmVar, zzmVar2);
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final void zzb(zzm zzmVar, Thread thread) {
        this.zza.lazySet(zzmVar, thread);
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final boolean zzc(zzo zzoVar, zzh zzhVar, zzh zzhVar2) {
        return LazyKt__LazyJVMKt.zza(this.zzd, zzoVar, zzhVar, zzhVar2);
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final boolean zzd(zzo zzoVar, Object obj, Object obj2) {
        return LazyKt__LazyJVMKt.zza(this.zze, zzoVar, obj, obj2);
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final boolean zze(zzo zzoVar, zzm zzmVar, zzm zzmVar2) {
        return LazyKt__LazyJVMKt.zza(this.zzc, zzoVar, zzmVar, zzmVar2);
    }
}
