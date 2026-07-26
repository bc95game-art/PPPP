package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.viewpager2.widget.FakeDrag;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
/* loaded from: classes.dex */
public final class zzf extends zza {
    public final IBinder zze;
    public final /* synthetic */ GmsClient zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(GmsClient gmsClient, int i, IBinder iBinder, Bundle bundle) {
        super(gmsClient, i, bundle);
        this.zzf = gmsClient;
        this.zze = iBinder;
    }

    @Override // com.google.android.gms.common.internal.zza
    public final void zzb(ConnectionResult connectionResult) {
        FakeDrag fakeDrag = this.zzf.zzx;
        if (fakeDrag != null) {
            ((GoogleApiClient.OnConnectionFailedListener) fakeDrag.mScrollEventAdapter).onConnectionFailed(connectionResult);
        }
        System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.internal.zza
    public final boolean zzd() {
        IBinder iBinder = this.zze;
        try {
            zzah.checkNotNull(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            GmsClient gmsClient = this.zzf;
            if (!gmsClient.getServiceDescriptor().equals(interfaceDescriptor)) {
                String serviceDescriptor = gmsClient.getServiceDescriptor();
                Log.w("GmsClient", "service descriptor mismatch: " + serviceDescriptor + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface createServiceInterface = gmsClient.createServiceInterface(iBinder);
            if (createServiceInterface == null || (!GmsClient.zzn(gmsClient, 2, 4, createServiceInterface) && !GmsClient.zzn(gmsClient, 3, 4, createServiceInterface))) {
                return false;
            }
            gmsClient.zzB = null;
            FakeDrag fakeDrag = gmsClient.zzw;
            if (fakeDrag == null) {
                return true;
            }
            ((GoogleApiClient.ConnectionCallbacks) fakeDrag.mScrollEventAdapter).onConnected();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
