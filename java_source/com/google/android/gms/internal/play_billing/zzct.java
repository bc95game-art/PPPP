package com.google.android.gms.internal.play_billing;

import androidx.core.util.Consumer;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.zzca;
import com.android.billingclient.api.zzce;
import com.android.billingclient.api.zzcj;
import java.util.concurrent.ExecutionException;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class zzct implements Runnable {
    public final zzcz zza;
    public final zzca zzb;

    public zzct(zzcz zzczVar, zzca zzcaVar) {
        this.zza = zzczVar;
        this.zzb = zzcaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable zze;
        zzcz zzczVar = this.zza;
        boolean z = zzczVar instanceof zzdf;
        zzca zzcaVar = this.zzb;
        if (!z || (zze = ((zzdf) zzczVar).zze()) == null) {
            try {
                boolean z2 = false;
                if (zzczVar.isDone()) {
                    while (true) {
                        try {
                            obj = zzczVar.get();
                            break;
                        } catch (InterruptedException unused) {
                            z2 = true;
                        } catch (Throwable th) {
                            if (z2) {
                                Thread.currentThread().interrupt();
                            }
                            throw th;
                        }
                    }
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    Integer num = (Integer) obj;
                    int intValue = num.intValue();
                    zzce zzceVar = (zzce) zzcaVar.zzc;
                    if (intValue > 0) {
                        int i = zzcaVar.zzd;
                        int intValue2 = num.intValue();
                        zzceVar.getClass();
                        BillingResult zza = zzcj.zza(intValue2, "Billing override value was set by a license tester.");
                        zzceVar.zzaF(93, i, zza);
                        ((Consumer) zzcaVar.zza).accept(zza);
                        return;
                    }
                    ((Runnable) zzcaVar.zzb).run();
                    return;
                }
                throw new IllegalStateException(LazyKt__LazyJVMKt.zza("Future was expected to be done: %s", zzczVar));
            } catch (ExecutionException e) {
                zzcaVar.zza(e.getCause());
            } catch (Throwable th2) {
                zzcaVar.zza(th2);
            }
        } else {
            zzcaVar.zza(zze);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, com.google.android.gms.internal.play_billing.zzbb] */
    public final String toString() {
        MatcherMatchResult matcherMatchResult = new MatcherMatchResult("zzct");
        ?? obj = new Object();
        ((zzbb) matcherMatchResult.groups).zzb = obj;
        matcherMatchResult.groups = obj;
        obj.zza = this.zzb;
        return matcherMatchResult.toString();
    }
}
