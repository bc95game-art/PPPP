package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.common.zzc;
/* loaded from: classes.dex */
public final class zzd extends zab {
    public GmsClient zza;
    public final int zzb;

    public zzd(GmsClient gmsClient, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.zza = gmsClient;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zza(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            zzc.zzb(parcel);
            zzah.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            GmsClient gmsClient = this.zza;
            int i2 = this.zzb;
            gmsClient.getClass();
            zzf zzfVar = new zzf(gmsClient, parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
            zzb zzbVar = gmsClient.zzb;
            zzbVar.sendMessage(zzbVar.obtainMessage(1, i2, -1, zzfVar));
            this.zza = null;
        } else if (i == 2) {
            parcel.readInt();
            Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
            zzc.zzb(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else if (i != 3) {
            return false;
        } else {
            int readInt = parcel.readInt();
            IBinder readStrongBinder = parcel.readStrongBinder();
            zzk zzkVar = (zzk) zzc.zza(parcel, zzk.CREATOR);
            zzc.zzb(parcel);
            GmsClient gmsClient2 = this.zza;
            zzah.checkNotNull(gmsClient2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            zzah.checkNotNull(zzkVar);
            gmsClient2.zzD = zzkVar;
            Bundle bundle2 = zzkVar.zza;
            zzah.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            GmsClient gmsClient3 = this.zza;
            int i3 = this.zzb;
            gmsClient3.getClass();
            zzf zzfVar2 = new zzf(gmsClient3, readInt, readStrongBinder, bundle2);
            zzb zzbVar2 = gmsClient3.zzb;
            zzbVar2.sendMessage(zzbVar2.obtainMessage(1, i3, -1, zzfVar2));
            this.zza = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
