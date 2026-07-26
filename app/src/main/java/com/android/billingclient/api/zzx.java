package com.android.billingclient.api;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.lifecycle.ViewModelProvider;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda15;
import com.google.android.gms.internal.play_billing.zza;
import com.google.android.gms.internal.play_billing.zzak;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zzbr;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.brotli.dec.HuffmanTreeGroup;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final /* synthetic */ class zzx implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ BillingClientImpl zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ Object zzc;

    public /* synthetic */ zzx(BillingClientImpl billingClientImpl, Object obj, Object obj2, int i) {
        this.$r8$classId = i;
        this.zza = billingClientImpl;
        this.zzb = obj;
        this.zzc = obj2;
    }

    private final Object call$com$android$billingclient$api$zzaa() {
        zzam zzamVar;
        BillingClientImpl billingClientImpl = this.zza;
        PlayBilling$$ExternalSyntheticLambda15 playBilling$$ExternalSyntheticLambda15 = (PlayBilling$$ExternalSyntheticLambda15) this.zzb;
        ConsumeParams consumeParams = (ConsumeParams) this.zzc;
        try {
            if (!billingClientImpl.zzaX()) {
                BillingResult billingResult = zzcj.zzj;
                billingClientImpl.zzbd(2, 3, billingResult);
                PlayBilling.lambda$processPurchases$6(billingResult);
                return null;
            } else if (TextUtils.isEmpty(consumeParams.zza)) {
                zzc.zzn("BillingClient", "Please provide a valid purchase token.");
                BillingResult billingResult2 = zzcj.zzg;
                billingClientImpl.zzbd(26, 3, billingResult2);
                PlayBilling.lambda$processPurchases$6(billingResult2);
                return null;
            } else if (!billingClientImpl.zzp) {
                BillingResult billingResult3 = zzcj.zza;
                billingClientImpl.zzbd(27, 3, billingResult3);
                PlayBilling.lambda$processPurchases$6(billingResult3);
                return null;
            } else {
                synchronized (billingClientImpl.zza) {
                    zzamVar = billingClientImpl.zzi;
                }
                if (zzamVar == null) {
                    billingClientImpl.zzaE(playBilling$$ExternalSyntheticLambda15, zzcj.zzj, 107, null);
                    return null;
                }
                String packageName = billingClientImpl.zzg.getPackageName();
                String str = consumeParams.zza;
                String str2 = billingClientImpl.zzc;
                String str3 = billingClientImpl.zzd;
                long longValue = billingClientImpl.zzI.longValue();
                int i = zzc.zza;
                Bundle bundle = new Bundle();
                zzc.zzc(bundle, str2, str3, longValue);
                Bundle zzd = ((zzak) zzamVar).zzd(bundle, packageName, str);
                PlayBilling.lambda$processPurchases$6(zzcj.zza(zzc.zzb(zzd, "BillingClient"), zzc.zzj(zzd, "BillingClient")));
                return null;
            }
        } catch (DeadObjectException e) {
            billingClientImpl.zzaE(playBilling$$ExternalSyntheticLambda15, zzcj.zzj, 28, e);
            return null;
        } catch (Exception e2) {
            billingClientImpl.zzaE(playBilling$$ExternalSyntheticLambda15, zzcj.zzh, 28, e2);
            return null;
        }
    }

    private final Object call$com$android$billingclient$api$zzak() {
        DeadObjectException deadObjectException;
        Exception exc;
        zzam zzamVar;
        String str;
        int i;
        String zzj;
        BillingClientImpl billingClientImpl = this.zza;
        ConsumeResponseListener consumeResponseListener = (ConsumeResponseListener) this.zzb;
        ConsumeParams consumeParams = (ConsumeParams) this.zzc;
        if (!billingClientImpl.zzaX()) {
            BillingResult billingResult = zzcj.zzj;
            billingClientImpl.zzbd(2, 4, billingResult);
            consumeResponseListener.onConsumeResponse(billingResult, consumeParams.zza);
            return null;
        }
        String str2 = "Error consuming purchase with token. Response code: ";
        String str3 = consumeParams.zza;
        try {
            zzc.zzm("BillingClient", "Consuming purchase with token: " + str3);
            try {
                synchronized (billingClientImpl.zza) {
                    try {
                        zzamVar = billingClientImpl.zzi;
                    } catch (Throwable th) {
                        th = th;
                        while (true) {
                            try {
                                break;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        throw th;
                    }
                }
                if (zzamVar == null) {
                    try {
                        str2 = str3;
                    } catch (DeadObjectException e) {
                        e = e;
                        str = str3;
                        deadObjectException = e;
                        str2 = str;
                        billingClientImpl.zzaG(consumeResponseListener, str2, zzcj.zzj, 29, "Error consuming purchase!", deadObjectException);
                        return null;
                    } catch (Exception e2) {
                        e = e2;
                        str = str3;
                        exc = e;
                        str2 = str;
                        billingClientImpl.zzaG(consumeResponseListener, str2, zzcj.zzh, 29, "Error consuming purchase!", exc);
                        return null;
                    }
                    try {
                        billingClientImpl.zzaG(consumeResponseListener, str2, zzcj.zzj, 107, "Service has been reset to null.", null);
                        return null;
                    } catch (DeadObjectException e3) {
                        e = e3;
                        deadObjectException = e;
                        billingClientImpl.zzaG(consumeResponseListener, str2, zzcj.zzj, 29, "Error consuming purchase!", deadObjectException);
                        return null;
                    } catch (Exception e4) {
                        e = e4;
                        exc = e;
                        billingClientImpl.zzaG(consumeResponseListener, str2, zzcj.zzh, 29, "Error consuming purchase!", exc);
                        return null;
                    }
                } else {
                    str = str3;
                    try {
                        if (billingClientImpl.zzp) {
                            try {
                                String packageName = billingClientImpl.zzg.getPackageName();
                                boolean z = billingClientImpl.zzp;
                                String str4 = billingClientImpl.zzc;
                                String str5 = billingClientImpl.zzd;
                                long longValue = billingClientImpl.zzI.longValue();
                                Bundle bundle = new Bundle();
                                if (z) {
                                    zzc.zzc(bundle, str4, str5, longValue);
                                }
                                Bundle zze = ((zzak) zzamVar).zze(bundle, packageName, str);
                                i = zze.getInt("RESPONSE_CODE");
                                zzj = zzc.zzj(zze, "BillingClient");
                            } catch (DeadObjectException e5) {
                                e = e5;
                                deadObjectException = e;
                                str2 = str;
                                billingClientImpl.zzaG(consumeResponseListener, str2, zzcj.zzj, 29, "Error consuming purchase!", deadObjectException);
                                return null;
                            } catch (Exception e6) {
                                e = e6;
                                exc = e;
                                str2 = str;
                                billingClientImpl.zzaG(consumeResponseListener, str2, zzcj.zzh, 29, "Error consuming purchase!", exc);
                                return null;
                            }
                        } else {
                            String packageName2 = billingClientImpl.zzg.getPackageName();
                            zzak zzakVar = (zzak) zzamVar;
                            Parcel zzs = zzakVar.zzs();
                            zzs.writeInt(3);
                            zzs.writeString(packageName2);
                            zzs.writeString(str);
                            Parcel zzt = zzakVar.zzt(zzs, 5);
                            i = zzt.readInt();
                            zzt.recycle();
                            zzj = "";
                        }
                        BillingResult zza = zzcj.zza(i, zzj);
                        if (i == 0) {
                            zzc.zzm("BillingClient", "Successfully consumed purchase.");
                            consumeResponseListener.onConsumeResponse(zza, str);
                            return null;
                        }
                        billingClientImpl.zzaG(consumeResponseListener, str, zza, 23, str2 + i, null);
                        return null;
                    } catch (DeadObjectException e7) {
                        e = e7;
                        str2 = str;
                        deadObjectException = e;
                        billingClientImpl.zzaG(consumeResponseListener, str2, zzcj.zzj, 29, "Error consuming purchase!", deadObjectException);
                        return null;
                    } catch (Exception e8) {
                        e = e8;
                        str2 = str;
                        exc = e;
                        billingClientImpl.zzaG(consumeResponseListener, str2, zzcj.zzh, 29, "Error consuming purchase!", exc);
                        return null;
                    }
                }
            } catch (DeadObjectException e9) {
                e = e9;
            } catch (Exception e10) {
                e = e10;
            }
        } catch (DeadObjectException e11) {
            e = e11;
            str2 = str3;
        } catch (Exception e12) {
            e = e12;
            str2 = str3;
        }
    }

    private final Object call$com$android$billingclient$api$zzx() {
        Bundle bundle;
        zzam zzamVar;
        BillingClientImpl billingClientImpl = this.zza;
        String str = (String) this.zzb;
        String str2 = (String) this.zzc;
        try {
            synchronized (billingClientImpl.zza) {
                zzamVar = billingClientImpl.zzi;
            }
            if (zzamVar == null) {
                return zzc.zzd(107, zzcj.zzj);
            }
            return ((zzak) zzamVar).zzf(billingClientImpl.zzg.getPackageName(), str, str2);
        } catch (DeadObjectException e) {
            BillingResult billingResult = zzcj.zzj;
            String zza = zzcg.zza(e);
            bundle = zzc.zzd(5, billingResult);
            if (zza != null) {
                bundle.putString("ADDITIONAL_LOG_DETAILS", zza);
            }
            return bundle;
        } catch (Exception e2) {
            BillingResult billingResult2 = zzcj.zzh;
            String zza2 = zzcg.zza(e2);
            bundle = zzc.zzd(5, billingResult2);
            if (zza2 != null) {
                bundle.putString("ADDITIONAL_LOG_DETAILS", zza2);
            }
            return bundle;
        }
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        HuffmanTreeGroup huffmanTreeGroup;
        int i;
        int i2;
        DeadObjectException e;
        Exception e2;
        zzam zzamVar;
        int i3;
        int i4;
        int i5;
        switch (this.$r8$classId) {
            case 0:
                return call$com$android$billingclient$api$zzx();
            case 1:
                return call$com$android$billingclient$api$zzaa();
            case 2:
                return call$com$android$billingclient$api$zzak();
            default:
                BillingClientImpl billingClientImpl = this.zza;
                PlayBilling playBilling = (PlayBilling) this.zzb;
                QueryProductDetailsParams queryProductDetailsParams = (QueryProductDetailsParams) this.zzc;
                Exception exc = null;
                if (!billingClientImpl.zzaX()) {
                    BillingResult billingResult = zzcj.zzj;
                    billingClientImpl.zzbd(2, 7, billingResult);
                    zzbr zzbrVar = zzbt.zza;
                    playBilling.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(zzca.zza));
                } else if (!billingClientImpl.zzu) {
                    zzc.zzn("BillingClient", "Querying product details is not supported.");
                    BillingResult billingResult2 = zzcj.zzr;
                    billingClientImpl.zzbd(20, 7, billingResult2);
                    zzbr zzbrVar2 = zzbt.zza;
                    playBilling.onProductDetailsResponse(billingResult2, new QueryProductDetailsResult(zzca.zza));
                } else {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    int i6 = 0;
                    ((QueryProductDetailsParams.Product) queryProductDetailsParams.zza.get(0)).getClass();
                    zzbt zzbtVar = queryProductDetailsParams.zza;
                    int size = zzbtVar.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= size) {
                            huffmanTreeGroup = new HuffmanTreeGroup(0, "", arrayList, arrayList2);
                        } else {
                            int i8 = i7 + 20;
                            if (i8 > size) {
                                i = size;
                            } else {
                                i = i8;
                            }
                            ArrayList arrayList3 = new ArrayList(zzbtVar.subList(i7, i));
                            ArrayList<String> arrayList4 = new ArrayList<>();
                            int size2 = arrayList3.size();
                            for (int i9 = 0; i9 < size2; i9++) {
                                arrayList4.add(((QueryProductDetailsParams.Product) arrayList3.get(i9)).zza);
                            }
                            Bundle bundle = new Bundle();
                            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
                            String str = billingClientImpl.zzc;
                            bundle.putString("playBillingLibraryVersion", str);
                            try {
                                synchronized (billingClientImpl.zza) {
                                    try {
                                        zzamVar = billingClientImpl.zzi;
                                    } catch (Throwable th) {
                                        th = th;
                                        i2 = 43;
                                        while (true) {
                                            try {
                                                throw th;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                    }
                                }
                                if (zzamVar == null) {
                                    huffmanTreeGroup = billingClientImpl.zzao(zzcj.zzj, 107, "Service has been reset to null.", exc);
                                } else {
                                    if (billingClientImpl.zzw) {
                                        billingClientImpl.zzD.getClass();
                                    }
                                    billingClientImpl.zzav();
                                    billingClientImpl.zzav();
                                    billingClientImpl.zzav();
                                    billingClientImpl.zzav();
                                    zza zzaVar = new zza(i6);
                                    if (true != billingClientImpl.zzx) {
                                        i3 = 17;
                                    } else {
                                        i3 = 20;
                                    }
                                    int i10 = i8;
                                    int i11 = i3;
                                    i2 = 43;
                                    try {
                                        Bundle zzj = ((zzak) zzamVar).zzj(i11, billingClientImpl.zzg.getPackageName(), "inapp", bundle, zzc.zzf(str, billingClientImpl.zzd, arrayList3, zzaVar, billingClientImpl.zzI.longValue()));
                                        if (zzj == null) {
                                            huffmanTreeGroup = billingClientImpl.zzao(zzcj.zzB, 44, "queryProductDetailsAsync got empty product details response.", null);
                                        } else if (!zzj.containsKey("DETAILS_LIST")) {
                                            int zzb = zzc.zzb(zzj, "BillingClient");
                                            String zzj2 = zzc.zzj(zzj, "BillingClient");
                                            if (zzb != 0) {
                                                huffmanTreeGroup = billingClientImpl.zzao(zzcj.zza(zzb, zzj2), 23, ViewModelProvider.Factory.CC.m(zzb, "getSkuDetails() failed for queryProductDetailsAsync. Response code: "), null);
                                            } else {
                                                huffmanTreeGroup = billingClientImpl.zzao(zzcj.zza(6, zzj2), 45, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                                            }
                                        } else {
                                            ArrayList<String> stringArrayList = zzj.getStringArrayList("DETAILS_LIST");
                                            if (stringArrayList == null) {
                                                huffmanTreeGroup = billingClientImpl.zzao(zzcj.zzB, 46, "queryProductDetailsAsync got null response list", null);
                                            } else {
                                                ArrayList arrayList5 = new ArrayList();
                                                int size3 = stringArrayList.size();
                                                int i12 = 0;
                                                while (i12 < size3) {
                                                    zzbt zzbtVar2 = zzbtVar;
                                                    try {
                                                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i12));
                                                        zzc.zzm("BillingClient", "Got product details: ".concat(productDetails.toString()));
                                                        arrayList5.add(productDetails);
                                                        i12++;
                                                        zzbtVar = zzbtVar2;
                                                    } catch (JSONException e3) {
                                                        huffmanTreeGroup = billingClientImpl.zzao(zzcj.zza(6, "Error trying to decode SkuDetails."), 47, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e3);
                                                    }
                                                }
                                                zzbt zzbtVar3 = zzbtVar;
                                                ArrayList<String> stringArrayList2 = zzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                                                new ArrayList();
                                                try {
                                                    ArrayList arrayList6 = new ArrayList();
                                                    if (stringArrayList2 != null) {
                                                        int size4 = stringArrayList2.size();
                                                        int i13 = 0;
                                                        while (i13 < size4) {
                                                            String str2 = stringArrayList2.get(i13);
                                                            i13++;
                                                            UnfetchedProduct unfetchedProduct = new UnfetchedProduct(str2);
                                                            zzc.zzm("BillingClient", "Got unfetchedProduct: ".concat(unfetchedProduct.toString()));
                                                            arrayList6.add(unfetchedProduct);
                                                        }
                                                    } else {
                                                        int size5 = arrayList3.size();
                                                        int i14 = 0;
                                                        while (i14 < size5) {
                                                            Object obj = arrayList3.get(i14);
                                                            i14++;
                                                            QueryProductDetailsParams.Product product = (QueryProductDetailsParams.Product) obj;
                                                            int size6 = arrayList5.size();
                                                            int i15 = 0;
                                                            while (true) {
                                                                if (i15 < size6) {
                                                                    Object obj2 = arrayList5.get(i15);
                                                                    i15++;
                                                                    ProductDetails productDetails2 = (ProductDetails) obj2;
                                                                    i4 = size5;
                                                                    i5 = i10;
                                                                    if (!product.zza.equals(productDetails2.zzc) || !"inapp".equals(productDetails2.zzd)) {
                                                                        size5 = i4;
                                                                        i10 = i5;
                                                                    }
                                                                } else {
                                                                    i4 = size5;
                                                                    i5 = i10;
                                                                    arrayList6.add(new UnfetchedProduct(new JSONObject().put("productId", product.zza).put("type", "inapp").put("statusCode", 0).toString()));
                                                                }
                                                            }
                                                            size5 = i4;
                                                            i10 = i5;
                                                        }
                                                    }
                                                    int i16 = i10;
                                                    arrayList.addAll(arrayList5);
                                                    arrayList2.addAll(arrayList6);
                                                    zzbtVar = zzbtVar3;
                                                    i7 = i16;
                                                    exc = null;
                                                    i6 = 0;
                                                } catch (JSONException e4) {
                                                    huffmanTreeGroup = billingClientImpl.zzao(zzcj.zza(6, "Error trying to decode SkuDetails."), 47, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e4);
                                                }
                                            }
                                        }
                                    } catch (DeadObjectException e5) {
                                        e = e5;
                                        huffmanTreeGroup = billingClientImpl.zzao(zzcj.zzj, i2, "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                                        playBilling.onProductDetailsResponse(zzcj.zza(huffmanTreeGroup.alphabetSize, (String) huffmanTreeGroup.trees), new QueryProductDetailsResult((ArrayList) huffmanTreeGroup.codes));
                                        return null;
                                    } catch (Exception e6) {
                                        e2 = e6;
                                        huffmanTreeGroup = billingClientImpl.zzao(zzcj.zzh, i2, "queryProductDetailsAsync got a remote exception (try to reconnect).", e2);
                                        playBilling.onProductDetailsResponse(zzcj.zza(huffmanTreeGroup.alphabetSize, (String) huffmanTreeGroup.trees), new QueryProductDetailsResult((ArrayList) huffmanTreeGroup.codes));
                                        return null;
                                    }
                                }
                            } catch (DeadObjectException e7) {
                                e = e7;
                                i2 = 43;
                            } catch (Exception e8) {
                                e2 = e8;
                                i2 = 43;
                            }
                        }
                    }
                    playBilling.onProductDetailsResponse(zzcj.zza(huffmanTreeGroup.alphabetSize, (String) huffmanTreeGroup.trees), new QueryProductDetailsResult((ArrayList) huffmanTreeGroup.codes));
                    return null;
                }
                return null;
        }
    }
}
