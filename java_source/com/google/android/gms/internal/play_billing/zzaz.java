package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public abstract class zzaz {
    public static final LazyKt__LazyJVMKt zza;

    static {
        zzax zzaxVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            zzaxVar = new zzax(0);
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            zzaxVar = new zzax(1);
        }
        zza = zzaxVar;
    }
}
