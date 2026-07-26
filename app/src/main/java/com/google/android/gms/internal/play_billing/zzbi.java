package com.google.android.gms.internal.play_billing;

import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class zzbi {
    public final LazyKt__LazyJVMKt zza;
    public boolean zzb;
    public long zzc;
    public long zzd;

    public zzbi(LazyKt__LazyJVMKt lazyKt__LazyJVMKt) {
        if (lazyKt__LazyJVMKt != null) {
            this.zza = lazyKt__LazyJVMKt;
            return;
        }
        throw new NullPointerException("ticker");
    }

    public final String toString() {
        long j;
        String str;
        if (this.zzb) {
            j = (this.zza.zza() - this.zzd) + this.zzc;
        } else {
            j = this.zzc;
        }
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j, timeUnit2) <= 0) {
            timeUnit = TimeUnit.HOURS;
            if (timeUnit.convert(j, timeUnit2) <= 0) {
                timeUnit = TimeUnit.MINUTES;
                if (timeUnit.convert(j, timeUnit2) <= 0) {
                    timeUnit = TimeUnit.SECONDS;
                    if (timeUnit.convert(j, timeUnit2) <= 0) {
                        timeUnit = TimeUnit.MILLISECONDS;
                        if (timeUnit.convert(j, timeUnit2) <= 0) {
                            timeUnit = TimeUnit.MICROSECONDS;
                            if (timeUnit.convert(j, timeUnit2) <= 0) {
                                timeUnit = timeUnit2;
                            }
                        }
                    }
                }
            }
        }
        String format = String.format(Locale.ROOT, "%.4g", Double.valueOf(j / timeUnit2.convert(1L, timeUnit)));
        switch (zzbh.zza[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        return format + " " + str;
    }

    public final void zze() {
        if (!this.zzb) {
            this.zzb = true;
            this.zzd = this.zza.zza();
            return;
        }
        throw new IllegalStateException("This stopwatch is already running.");
    }
}
