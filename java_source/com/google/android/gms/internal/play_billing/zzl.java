package com.google.android.gms.internal.play_billing;

import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class zzl extends LazyKt__LazyJVMKt {
    @Override // kotlin.LazyKt__LazyJVMKt
    public final void zza(zzm zzmVar, zzm zzmVar2) {
        zzmVar.zzc = zzmVar2;
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final void zzb(zzm zzmVar, Thread thread) {
        zzmVar.zzb = thread;
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final boolean zzc(zzo zzoVar, zzh zzhVar, zzh zzhVar2) {
        synchronized (zzoVar) {
            try {
                if (zzoVar.zzd != zzhVar) {
                    return false;
                }
                zzoVar.zzd = zzhVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final boolean zzd(zzo zzoVar, Object obj, Object obj2) {
        synchronized (zzoVar) {
            try {
                if (zzoVar.zzc != obj) {
                    return false;
                }
                zzoVar.zzc = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final boolean zze(zzo zzoVar, zzm zzmVar, zzm zzmVar2) {
        synchronized (zzoVar) {
            try {
                if (zzoVar.zze != zzmVar) {
                    return false;
                }
                zzoVar.zze = zzmVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
