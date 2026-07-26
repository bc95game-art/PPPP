package com.google.android.gms.tasks;

import android.os.Looper;
import com.android.billingclient.api.zzab;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final class zzu implements Executor {
    public final /* synthetic */ int $r8$classId = 0;
    public final Object zza;

    public zzu() {
        zau zauVar = new zau(Looper.getMainLooper(), 3, false);
        Looper.getMainLooper();
        this.zza = zauVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.$r8$classId) {
            case 0:
                ((zau) this.zza).post(runnable);
                return;
            default:
                ((Executor) this.zza).execute(new zzab(10, runnable));
                return;
        }
    }

    public zzu(ExecutorService executorService) {
        this.zza = executorService;
    }
}
