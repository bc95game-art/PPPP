package com.google.android.gms.internal.play_billing;

import java.util.concurrent.Executor;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public final class zzcp extends Enum implements Executor {
    public static final zzcp zza;
    public static final /* synthetic */ zzcp[] zzb;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, com.google.android.gms.internal.play_billing.zzcp] */
    static {
        ?? r0 = new Enum("INSTANCE", 0);
        zza = r0;
        zzb = new zzcp[]{r0};
    }

    public static zzcp[] values() {
        return (zzcp[]) zzb.clone();
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
