package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.transition.ViewUtilsApi21;
import com.android.billingclient.api.zzcl;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzj;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzw;
import java.util.ArrayDeque;
import java.util.Map;
/* loaded from: classes.dex */
public final class zag extends zac {
    public final zzr zaa;
    public final TaskCompletionSource zab;
    public final ViewUtilsApi21 zad;

    public zag(zzr zzrVar, TaskCompletionSource taskCompletionSource, ViewUtilsApi21 viewUtilsApi21) {
        super(2);
        this.zab = taskCompletionSource;
        this.zaa = zzrVar;
        this.zad = viewUtilsApi21;
        if (zzrVar.zzc) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq zabqVar) {
        return this.zaa.zzc;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabq zabqVar) {
        return (Feature[]) this.zaa.zza;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zad(Status status) {
        ApiException apiException;
        this.zad.getClass();
        if (status.zzd != null) {
            apiException = new ApiException(status);
        } else {
            apiException = new ApiException(status);
        }
        this.zab.trySetException(apiException);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zae(Exception exc) {
        this.zab.trySetException(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zaf(zabq zabqVar) {
        TaskCompletionSource taskCompletionSource = this.zab;
        try {
            this.zaa.doExecute(zabqVar.zac, taskCompletionSource);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zad(zac.zah(e2));
        } catch (RuntimeException e3) {
            taskCompletionSource.trySetException(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final void zag(zzcl zzclVar, boolean z) {
        TaskCompletionSource taskCompletionSource = this.zab;
        ((Map) zzclVar.zzc).put(taskCompletionSource, Boolean.valueOf(z));
        zzw zzwVar = taskCompletionSource.zza;
        zzcl zzclVar2 = new zzcl(23, zzclVar, taskCompletionSource, false);
        zzwVar.getClass();
        zzj zzjVar = new zzj(TaskExecutors.MAIN_THREAD, zzclVar2);
        zzr zzrVar = (zzr) zzwVar.zzb;
        synchronized (zzrVar.zza) {
            try {
                if (((ArrayDeque) zzrVar.zzb) == null) {
                    zzrVar.zzb = new ArrayDeque();
                }
                ((ArrayDeque) zzrVar.zzb).add(zzjVar);
            } catch (Throwable th) {
                throw th;
            }
        }
        zzwVar.zzi();
    }
}
