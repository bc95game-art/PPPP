package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class zzcx implements zzcz {
    public static final zzcy zza = new zzcy(zzcx.class);
    public final Object zzb;

    public zzcx(Object obj) {
        this.zzb = obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.zzb;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        String obj = super.toString();
        String obj2 = this.zzb.toString();
        return obj + "[status=SUCCESS, result=[" + obj2 + "]]";
    }

    @Override // com.google.android.gms.internal.play_billing.zzcz
    public final void zzb(Runnable runnable, Executor executor) {
        if (executor != null) {
            try {
                executor.execute(runnable);
            } catch (Exception e) {
                Logger zza2 = zza.zza();
                Level level = Level.SEVERE;
                String obj = runnable.toString();
                String valueOf = String.valueOf(executor);
                zza2.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", "RuntimeException while executing runnable " + obj + " with executor " + valueOf, (Throwable) e);
            }
        } else {
            throw new NullPointerException("Executor was null.");
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        timeUnit.getClass();
        return this.zzb;
    }
}
