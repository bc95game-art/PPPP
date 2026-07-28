package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class zzax extends LazyKt__LazyJVMKt {
    public final /* synthetic */ int $r8$classId;

    @Override // kotlin.LazyKt__LazyJVMKt
    public final long zza() {
        switch (this.$r8$classId) {
            case 0:
                return SystemClock.elapsedRealtimeNanos();
            default:
                return SystemClock.elapsedRealtime() * 1000000;
        }
    }
}
