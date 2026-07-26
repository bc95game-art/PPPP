package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.play_billing.zzap;
import com.google.android.gms.internal.play_billing.zzat;
import com.google.android.gms.internal.play_billing.zzau;
import com.google.android.gms.internal.play_billing.zzc;
/* loaded from: classes.dex */
public final class zzcc implements ServiceConnection {
    public final /* synthetic */ zzce zza;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.gms.internal.play_billing.zzap] */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzau zzauVar;
        zzc.zzm("BillingClientTesting", "Billing Override Service connected.");
        zzce zzceVar = this.zza;
        int i = zzat.$r8$clinit;
        if (iBinder == null) {
            zzauVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
            if (queryLocalInterface instanceof zzau) {
                zzauVar = (zzau) queryLocalInterface;
            } else {
                zzauVar = new zzap(iBinder, "com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
            }
        }
        zzceVar.zzc = zzauVar;
        zzceVar.zzb = 2;
        zzceVar.zzaG(26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzc.zzn("BillingClientTesting", "Billing Override Service disconnected.");
        zzce zzceVar = this.zza;
        zzceVar.zzc = null;
        zzceVar.zzb = 0;
    }
}
