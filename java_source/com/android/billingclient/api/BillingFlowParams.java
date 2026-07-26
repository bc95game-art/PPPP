package com.android.billingclient.api;

import androidx.collection.internal.Lock;
import com.google.android.gms.internal.play_billing.zzbt;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BillingFlowParams {
    public boolean zza;
    public Lock zzd;
    public zzbt zze;
    public ArrayList zzf;

    /* loaded from: classes.dex */
    public final class ProductDetailsParams {
        public final ProductDetails zza;
        public final String zzb;

        public /* synthetic */ ProductDetailsParams(zzcl zzclVar) {
            this.zza = (ProductDetails) zzclVar.zzb;
            this.zzb = (String) zzclVar.zzc;
        }
    }
}
