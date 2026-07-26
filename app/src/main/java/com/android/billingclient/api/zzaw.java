package com.android.billingclient.api;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.text.TextUtils;
import com.android.billingclient.api.BillingResult;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda4;
import com.google.android.gms.internal.play_billing.zzak;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zzbr;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONException;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public final class zzaw implements Callable {
    public final /* synthetic */ PlayBilling$$ExternalSyntheticLambda4 zza;
    public final /* synthetic */ BillingClientImpl zzc;

    public zzaw(BillingClientImpl billingClientImpl, PlayBilling$$ExternalSyntheticLambda4 playBilling$$ExternalSyntheticLambda4) {
        this.zza = playBilling$$ExternalSyntheticLambda4;
        Objects.requireNonNull(billingClientImpl);
        this.zzc = billingClientImpl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
        r0 = r2.zzba(com.android.billingclient.api.zzcj.zzj, 107, "Service has been reset to null", r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x015e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0235  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object call() {
        Exception exc;
        zzcl zzclVar;
        List list;
        DeadObjectException e;
        Exception e2;
        zzam zzamVar;
        Bundle bundle;
        BillingResult billingResult;
        int i;
        int i2;
        BillingClientImpl billingClientImpl = this.zzc;
        Exception exc2 = null;
        if (!billingClientImpl.zzaX()) {
            BillingResult billingResult2 = zzcj.zzj;
            billingClientImpl.zzbd(2, 9, billingResult2);
            PlayBilling$$ExternalSyntheticLambda4 playBilling$$ExternalSyntheticLambda4 = this.zza;
            zzbr zzbrVar = zzbt.zza;
            playBilling$$ExternalSyntheticLambda4.onQueryPurchasesResponse(billingResult2, zzca.zza);
            return null;
        } else if (TextUtils.isEmpty("inapp")) {
            zzc.zzn("BillingClient", "Please provide a valid product type.");
            BillingResult billingResult3 = zzcj.zze;
            billingClientImpl.zzbd(50, 9, billingResult3);
            PlayBilling$$ExternalSyntheticLambda4 playBilling$$ExternalSyntheticLambda42 = this.zza;
            zzbr zzbrVar2 = zzbt.zza;
            playBilling$$ExternalSyntheticLambda42.onQueryPurchasesResponse(billingResult3, zzca.zza);
            return null;
        } else {
            zzc.zzm("BillingClient", "Querying owned items, item type: ".concat("inapp"));
            ArrayList arrayList = new ArrayList();
            boolean z = billingClientImpl.zzp;
            billingClientImpl.zzD.getClass();
            billingClientImpl.zzD.getClass();
            long longValue = billingClientImpl.zzI.longValue();
            Bundle bundle2 = new Bundle();
            zzc.zzc(bundle2, billingClientImpl.zzc, billingClientImpl.zzd, longValue);
            if (z) {
                bundle2.putBoolean("enablePendingPurchases", true);
            }
            String str = null;
            while (true) {
                try {
                    synchronized (billingClientImpl.zza) {
                        try {
                            zzamVar = billingClientImpl.zzi;
                        } catch (Throwable th) {
                            th = th;
                            exc = exc2;
                            while (true) {
                                try {
                                    try {
                                        break;
                                    } catch (DeadObjectException e3) {
                                        e = e3;
                                        zzclVar = billingClientImpl.zzba(zzcj.zzj, 52, "Got exception trying to get purchases try to reconnect", e);
                                        list = (List) zzclVar.zzb;
                                        if (list != null) {
                                        }
                                        return exc;
                                    } catch (Exception e4) {
                                        e2 = e4;
                                        zzclVar = billingClientImpl.zzba(zzcj.zzh, 52, "Got exception trying to get purchases try to reconnect", e2);
                                        list = (List) zzclVar.zzb;
                                        if (list != null) {
                                        }
                                        return exc;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            throw th;
                        }
                    }
                    if (zzamVar == null) {
                        break;
                    }
                    if (!billingClientImpl.zzp) {
                        bundle = ((zzak) zzamVar).zzh(billingClientImpl.zzg.getPackageName(), str);
                    } else {
                        if (billingClientImpl.zzC) {
                            i2 = 26;
                        } else if (billingClientImpl.zzB) {
                            i2 = 24;
                        } else if (billingClientImpl.zzw) {
                            i2 = 19;
                        } else {
                            i2 = 9;
                        }
                        bundle = ((zzak) zzamVar).zzi(i2, billingClientImpl.zzg.getPackageName(), str, bundle2);
                    }
                    BillingResult billingResult4 = zzcj.zzh;
                    if (bundle == null) {
                        zzc.zzn("BillingClient", "getPurchase() got null owned items list");
                        i = 54;
                    } else {
                        int zzb = zzc.zzb(bundle, "BillingClient");
                        String zzj = zzc.zzj(bundle, "BillingClient");
                        BillingResult.Builder newBuilder = BillingResult.newBuilder();
                        newBuilder.zza = zzb;
                        newBuilder.zzc = zzj;
                        billingResult = newBuilder.build();
                        if (zzb != 0) {
                            zzc.zzn("BillingClient", "getPurchase() failed. Response code: " + zzb);
                            i = 23;
                        } else if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                            zzc.zzn("BillingClient", "Bundle returned from getPurchase() doesn't contain required fields.");
                            i = 55;
                        } else {
                            ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                            ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                            ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                            if (stringArrayList == null) {
                                zzc.zzn("BillingClient", "Bundle returned from getPurchase() contains null SKUs list.");
                                i = 56;
                            } else if (stringArrayList2 == null) {
                                zzc.zzn("BillingClient", "Bundle returned from getPurchase() contains null purchases list.");
                                i = 57;
                            } else if (stringArrayList3 == null) {
                                zzc.zzn("BillingClient", "Bundle returned from getPurchase() contains null signatures list.");
                                i = 58;
                            } else {
                                billingResult = zzcj.zzi;
                                i = 1;
                            }
                        }
                        if (billingResult == zzcj.zzi) {
                            zzclVar = billingClientImpl.zzba(billingResult, i, "Purchase bundle invalid", exc2);
                            break;
                        }
                        ArrayList<String> stringArrayList4 = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> stringArrayList5 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> stringArrayList6 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        exc = exc2;
                        boolean z2 = false;
                        for (int i3 = 0; i3 < stringArrayList5.size(); i3++) {
                            String str2 = stringArrayList5.get(i3);
                            String str3 = stringArrayList6.get(i3);
                            zzc.zzm("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList4.get(i3))));
                            try {
                                Purchase purchase = new Purchase(str2, str3);
                                if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                                    zzc.zzn("BillingClient", "BUG: empty/null token!");
                                    z2 = true;
                                }
                                arrayList.add(purchase);
                            } catch (JSONException e5) {
                                zzclVar = billingClientImpl.zzba(zzcj.zzh, 51, "Got an exception trying to decode the purchase!", e5);
                            }
                        }
                        if (z2) {
                            billingClientImpl.zzbd(26, 9, billingResult4);
                        }
                        str = bundle.getString("INAPP_CONTINUATION_TOKEN");
                        zzc.zzm("BillingClient", "Continuation token: ".concat(String.valueOf(str)));
                        if (TextUtils.isEmpty(str)) {
                            zzclVar = new zzcl(18, zzcj.zzi, arrayList, false);
                            break;
                        }
                        exc2 = exc;
                    }
                    billingResult = billingResult4;
                    if (billingResult == zzcj.zzi) {
                    }
                } catch (DeadObjectException e6) {
                    e = e6;
                    exc = exc2;
                } catch (Exception e7) {
                    e2 = e7;
                    exc = exc2;
                }
            }
            exc = exc2;
            list = (List) zzclVar.zzb;
            if (list != null) {
                this.zza.onQueryPurchasesResponse((BillingResult) zzclVar.zzc, list);
            } else {
                zzbr zzbrVar3 = zzbt.zza;
                this.zza.onQueryPurchasesResponse((BillingResult) zzclVar.zzc, zzca.zza);
            }
            return exc;
        }
    }
}
