package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
/* loaded from: classes.dex */
public final class zze implements ServiceConnection {
    public final /* synthetic */ GmsClient zza;
    public final int zzb;

    public zze(GmsClient gmsClient, int i) {
        this.zza = gmsClient;
        this.zzb = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzad zzadVar;
        GmsClient gmsClient = this.zza;
        if (iBinder == null) {
            GmsClient.zzk(gmsClient);
            return;
        }
        synchronized (gmsClient.zzq) {
            try {
                GmsClient gmsClient2 = this.zza;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof zzad)) {
                    zzadVar = new zzad(iBinder);
                } else {
                    zzadVar = (zzad) queryLocalInterface;
                }
                gmsClient2.zzr = zzadVar;
            } catch (Throwable th) {
                throw th;
            }
        }
        GmsClient gmsClient3 = this.zza;
        int i = this.zzb;
        zzg zzgVar = new zzg(gmsClient3, 0);
        zzb zzbVar = gmsClient3.zzb;
        zzbVar.sendMessage(zzbVar.obtainMessage(7, i, -1, zzgVar));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        GmsClient gmsClient;
        synchronized (this.zza.zzq) {
            gmsClient = this.zza;
            gmsClient.zzr = null;
        }
        int i = this.zzb;
        zzb zzbVar = gmsClient.zzb;
        zzbVar.sendMessage(zzbVar.obtainMessage(6, i, 1));
    }
}
