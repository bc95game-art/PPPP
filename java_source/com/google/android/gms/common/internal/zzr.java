package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.material.snackbar.SnackbarManager;
/* loaded from: classes.dex */
public final class zzr implements Handler.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;

    public /* synthetic */ zzr(int i, Object obj) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    private final boolean handleMessage$com$google$android$gms$common$internal$zzr(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (((zzs) this.zza).zzb) {
                try {
                    zzo zzoVar = (zzo) message.obj;
                    zzp zzpVar = (zzp) ((zzs) this.zza).zzb.get(zzoVar);
                    if (zzpVar != null && zzpVar.zzb.isEmpty()) {
                        if (zzpVar.zzd) {
                            zzpVar.zza.zzd.removeMessages(1, zzpVar.zzf);
                            zzs zzsVar = zzpVar.zza;
                            zzsVar.zzf.unbindService(zzsVar.zzc, zzpVar);
                            zzpVar.zzd = false;
                            zzpVar.zzc = 2;
                        }
                        ((zzs) this.zza).zzb.remove(zzoVar);
                    }
                } finally {
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (((zzs) this.zza).zzb) {
                try {
                    zzo zzoVar2 = (zzo) message.obj;
                    zzp zzpVar2 = (zzp) ((zzs) this.zza).zzb.get(zzoVar2);
                    if (zzpVar2 != null && zzpVar2.zzc == 3) {
                        Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(zzoVar2)), new Exception());
                        ComponentName componentName = zzpVar2.zzg;
                        if (componentName == null) {
                            zzoVar2.getClass();
                            componentName = null;
                        }
                        if (componentName == null) {
                            String str = zzoVar2.zzc;
                            zzah.checkNotNull(str);
                            componentName = new ComponentName(str, "unknown");
                        }
                        zzpVar2.onServiceDisconnected(componentName);
                    }
                } finally {
                }
            }
            return true;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.$r8$classId) {
            case 0:
                return handleMessage$com$google$android$gms$common$internal$zzr(message);
            default:
                if (message.what != 0) {
                    return false;
                }
                SnackbarManager snackbarManager = (SnackbarManager) this.zza;
                if (message.obj == null) {
                    synchronized (snackbarManager.lock) {
                        throw null;
                    }
                }
                throw new ClassCastException();
        }
    }
}
