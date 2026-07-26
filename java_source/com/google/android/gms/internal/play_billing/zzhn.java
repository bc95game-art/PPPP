package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;
/* loaded from: classes.dex */
public abstract class zzhn {
    public final Unsafe zza;

    public zzhn(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(long j, Object obj);

    public abstract float zzb(long j, Object obj);

    public abstract void zzc(Object obj, long j, boolean z);

    public abstract void zzd(Object obj, long j, byte b);

    public abstract void zze(Object obj, long j, double d);

    public abstract void zzf(Object obj, long j, float f);

    public abstract boolean zzg(long j, Object obj);
}
