package com.android.billingclient.api;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.tasks.zzi;
/* loaded from: classes.dex */
public final class zzs {
    public final Object zza;
    public final Object zzb;
    public final Object zze;
    public final Object zzf;
    public final Object zzg;
    public boolean zzh;

    public zzs(GoogleApiManager googleApiManager, Api$Client api$Client, ApiKey apiKey) {
        this.zzg = googleApiManager;
        this.zze = null;
        this.zzf = null;
        this.zzh = false;
        this.zza = api$Client;
        this.zzb = apiKey;
    }

    public void onReportServiceBinding(ConnectionResult connectionResult) {
        ((GoogleApiManager) this.zzg).zar.post(new zzi(10, this, connectionResult, false));
    }

    public void zae(ConnectionResult connectionResult) {
        zabq zabqVar = (zabq) ((GoogleApiManager) this.zzg).zan.get((ApiKey) this.zzb);
        if (zabqVar != null) {
            zzah.checkHandlerThread(zabqVar.zaa.zar);
            Api$Client api$Client = zabqVar.zac;
            String name = api$Client.getClass().getName();
            String valueOf = String.valueOf(connectionResult);
            api$Client.disconnect("onSignInFailed for " + name + " with " + valueOf);
            zabqVar.zar(connectionResult, null);
        }
    }

    public zzs(Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzcl zzclVar) {
        this.zza = context;
        this.zzb = purchasesUpdatedListener;
        this.zze = zzclVar;
        this.zzf = new zzr(this, true);
        this.zzg = new zzr(this, false);
    }
}
