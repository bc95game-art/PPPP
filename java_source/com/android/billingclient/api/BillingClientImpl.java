package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.Transition;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.ProductDetails;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda15;
import com.google.android.gms.internal.play_billing.zzak;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zzaz;
import com.google.android.gms.internal.play_billing.zzbi;
import com.google.android.gms.internal.play_billing.zzbr;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
import com.google.android.gms.internal.play_billing.zzdj;
import com.google.android.gms.internal.play_billing.zzdk;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzil;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import com.google.android.gms.tasks.zzi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.LazyKt__LazyJVMKt;
import org.brotli.dec.HuffmanTreeGroup;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class BillingClientImpl extends BillingClient {
    public boolean zzB;
    public boolean zzC;
    public final Transition.C01101 zzD;
    public final boolean zzF;
    public ExecutorService zzH;
    public final Long zzI;
    public final String zzd;
    public volatile zzs zzf;
    public final Context zzg;
    public final zzcl zzh;
    public volatile zzam zzi;
    public volatile zzbf zzj;
    public boolean zzk;
    public boolean zzn;
    public boolean zzp;
    public boolean zzr;
    public boolean zzs;
    public boolean zzt;
    public boolean zzu;
    public boolean zzw;
    public boolean zzx;
    public boolean zzy;
    public final Object zza = new Object();
    public volatile int zzb = 0;
    public final Handler zze = new Handler(Looper.getMainLooper());
    public int zzm = 0;
    public final LazyKt__LazyJVMKt zzJ = zzaz.zza;
    public final String zzc = "8.0.0";

    public BillingClientImpl(Transition.C01101 r6, Context context, PurchasesUpdatedListener purchasesUpdatedListener, EmojiCompat.CompatInternal19 compatInternal19) {
        long nextLong = new Random().nextLong();
        this.zzI = Long.valueOf(nextLong);
        String zzaw = zzaw();
        this.zzd = zzaw;
        this.zzg = context.getApplicationContext();
        zziq zzc = zzis.zzc();
        zzc.zzi();
        zzis.zzI((zzis) zzc.zza);
        if (zzaw != null) {
            zzc.zzi();
            zzis.zzJ((zzis) zzc.zza, zzaw);
        }
        String packageName = this.zzg.getPackageName();
        zzc.zzi();
        zzis.zzG((zzis) zzc.zza, packageName);
        zzc.zzi();
        zzis.zzD((zzis) zzc.zza, nextLong);
        zzc.zzi();
        zzis.zzH((zzis) zzc.zza);
        int i = Build.VERSION.SDK_INT;
        zzc.zzi();
        zzis.zzA((zzis) zzc.zza, i);
        zzc.zzp();
        try {
            int i2 = this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode;
            zzc.zzi();
            zzis.zzB((zzis) zzc.zza, i2);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzcl(this.zzg, (zzis) zzc.zze());
        if (purchasesUpdatedListener == null) {
            zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzs(this.zzg, purchasesUpdatedListener, this.zzh);
        this.zzD = r6;
        this.zzF = false;
        this.zzg.getPackageName();
    }

    public static Future zzG(Callable callable, long j, Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            Future submit = executorService.submit(callable);
            handler.postDelayed(new zzi(submit, 7, runnable), (long) (j * 0.95d));
            return submit;
        } catch (Exception e) {
            zzc.zzo("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public static void zzae(BillingClientImpl billingClientImpl, int i) {
        zzs zzsVar;
        if (i == 0) {
            synchronized (billingClientImpl.zza) {
                try {
                    if (billingClientImpl.zzb != 3) {
                        billingClientImpl.zzaS(2);
                        if (billingClientImpl.zzf != null) {
                            zzsVar = billingClientImpl.zzf;
                        } else {
                            zzsVar = null;
                        }
                        if (zzsVar != null) {
                            boolean z = billingClientImpl.zzy;
                            zzr zzrVar = (zzr) zzsVar.zzf;
                            IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
                            IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
                            intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
                            zzsVar.zzh = z;
                            Context context = (Context) zzsVar.zza;
                            ((zzr) zzsVar.zzg).zza(context, intentFilter2);
                            if (zzsVar.zzh) {
                                zzrVar.zzb(context, intentFilter);
                            } else {
                                zzrVar.zza(context, intentFilter);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else {
            billingClientImpl.zzaS(0);
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzai(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    public static String zzaw() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(ConsumeParams consumeParams, PlayBilling$$ExternalSyntheticLambda15 playBilling$$ExternalSyntheticLambda15) {
        if (zzG(new zzx(this, playBilling$$ExternalSyntheticLambda15, consumeParams, 1), 30000L, new zzab(this, playBilling$$ExternalSyntheticLambda15), zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(25, 3, zzaq);
            PlayBilling.lambda$processPurchases$6(zzaq);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(ConsumeParams consumeParams, ConsumeResponseListener consumeResponseListener) {
        if (zzG(new zzx(this, consumeResponseListener, consumeParams, 2), 30000L, new zzam(this, consumeResponseListener, consumeParams, 0), zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(25, 4, zzaq);
            consumeResponseListener.onConsumeResponse(zzaq, consumeParams.zza);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        try {
            int i = zzcg.$r8$clinit;
            zzaQ(zzcg.zzc(12, zzil.zza));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
        synchronized (this.zza) {
            try {
                if (this.zzf != null) {
                    zzs zzsVar = this.zzf;
                    Context context = (Context) zzsVar.zza;
                    ((zzr) zzsVar.zzf).zzc(context);
                    ((zzr) zzsVar.zzg).zzc(context);
                }
                zzc.zzm("BillingClient", "Unbinding from service.");
                zzaV();
                zzaT();
                zzaS(3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:283:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x06cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.android.billingclient.api.BillingClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BillingResult launchBillingFlow(Activity activity, final BillingFlowParams billingFlowParams) {
        Object obj;
        Object obj2;
        String str;
        long j;
        String str2;
        String str3;
        BillingResult billingResult;
        long j2;
        String str4;
        String str5;
        Future future;
        long j3;
        Exception e;
        long j4;
        Exception e2;
        long j5;
        long j6;
        Object obj3;
        int _zzb;
        int i;
        String str6;
        boolean z;
        long j7;
        boolean z2;
        final int i2;
        long j8;
        String str7;
        String str8;
        BillingResult billingResult2;
        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails;
        long nextLong = new Random().nextLong();
        if (this.zzf == null || ((PurchasesUpdatedListener) this.zzf.zzb) == null) {
            BillingResult billingResult3 = zzcj.zzE;
            zzbe(12, billingResult3, nextLong);
            return billingResult3;
        }
        try {
            zzc.zzm("BillingClient", "Already connected or not opted into auto reconnection.");
            BillingResult billingResult4 = zzcj.zzi;
            TimeUnit.MILLISECONDS.getClass();
            int i3 = billingResult4.zza;
            if (i3 == 0) {
                zzc.zzm("BillingClient", "Reconnection succeeded with result: " + i3);
            } else {
                zzc.zzn("BillingClient", "Reconnection failed with result: " + i3);
            }
        } catch (Exception e3) {
            if (e3 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            zzc.zzo("BillingClient", "Error during reconnection attempt: ", e3);
        }
        if (!zzaY()) {
            BillingResult billingResult5 = zzcj.zzj;
            zzbe(2, billingResult5, nextLong);
            zzm(billingResult5);
            return billingResult5;
        }
        synchronized (this.zza) {
            try {
                if (this.zzj != null) {
                    this.zzj.getClass();
                }
            } finally {
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(billingFlowParams.zzf);
        zzbt zzbtVar = billingFlowParams.zze;
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            obj = it.next();
        } else {
            obj = null;
        }
        if (obj == null) {
            zzbr zzbrVar = (zzbr) zzbtVar.iterator();
            if (zzbrVar.hasNext()) {
                obj2 = zzbrVar.next();
            } else {
                obj2 = null;
            }
            BillingFlowParams.ProductDetailsParams productDetailsParams = (BillingFlowParams.ProductDetailsParams) obj2;
            ProductDetails productDetails = productDetailsParams.zza;
            String str9 = productDetails.zzc;
            String str10 = productDetails.zzd;
            if (!str10.equals("subs") || this.zzk) {
                billingFlowParams.zzd.getClass();
                if (!billingFlowParams.zza) {
                    zzbt zzbtVar2 = billingFlowParams.zze;
                    if (zzbtVar2 != null) {
                        int size = zzbtVar2.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            BillingFlowParams.ProductDetailsParams productDetailsParams2 = (BillingFlowParams.ProductDetailsParams) zzbtVar2.get(i4);
                        }
                    }
                } else if (!this.zzn) {
                    zzc.zzn("BillingClient", "Current client doesn't support extra params for buy intent.");
                    BillingResult billingResult6 = zzcj.zzf;
                    zzbg(18, billingResult6, nextLong, false);
                    zzm(billingResult6);
                    return billingResult6;
                }
                if (arrayList.size() > 1 && !this.zzt) {
                    zzc.zzn("BillingClient", "Current client doesn't support multi-item purchases.");
                    BillingResult billingResult7 = zzcj.zzp;
                    zzbg(19, billingResult7, nextLong, false);
                    zzm(billingResult7);
                    return billingResult7;
                } else if (zzbtVar.isEmpty() || this.zzu) {
                    if (billingFlowParams.zze.isEmpty()) {
                        str2 = str9;
                        j = nextLong;
                        billingResult = zzcj.zzi;
                        str = str10;
                        str3 = null;
                    } else {
                        BillingFlowParams.ProductDetailsParams productDetailsParams3 = (BillingFlowParams.ProductDetailsParams) billingFlowParams.zze.get(0);
                        int i5 = 1;
                        str3 = null;
                        while (true) {
                            if (i5 < billingFlowParams.zze.size()) {
                                BillingFlowParams.ProductDetailsParams productDetailsParams4 = (BillingFlowParams.ProductDetailsParams) billingFlowParams.zze.get(i5);
                                str2 = str9;
                                if (!(productDetailsParams4.zza.zzd.equals(productDetailsParams3.zza.zzd) || productDetailsParams4.zza.zzd.equals("play_pass_subs"))) {
                                    j = nextLong;
                                    billingResult = zzcj.zza(5, "All products should have same ProductType.");
                                    str = str10;
                                    break;
                                }
                                i5++;
                                str9 = str2;
                            } else {
                                str2 = str9;
                                ProductDetails productDetails2 = productDetailsParams3.zza;
                                String optString = productDetails2.zzb.optString("packageName");
                                HashMap hashMap = new HashMap();
                                HashSet hashSet = new HashSet();
                                j = nextLong;
                                zzbt zzbtVar3 = billingFlowParams.zze;
                                int size2 = zzbtVar3.size();
                                str = str10;
                                int i6 = 0;
                                while (true) {
                                    if (i6 < size2) {
                                        zzbt zzbtVar4 = zzbtVar3;
                                        BillingFlowParams.ProductDetailsParams productDetailsParams5 = (BillingFlowParams.ProductDetailsParams) zzbtVar3.get(i6);
                                        int i7 = size2;
                                        ProductDetails productDetails3 = productDetailsParams5.zza;
                                        int i8 = i6;
                                        String str11 = productDetails3.zzc;
                                        HashSet hashSet2 = hashSet;
                                        String str12 = productDetails3.zzc;
                                        if (productDetails3.zzj == null || productDetailsParams5.zzb != null) {
                                            if (hashMap.containsKey(str11)) {
                                                billingResult2 = zzcj.zza(5, "ProductId can not be duplicated. Invalid product id: " + str12 + ".");
                                                break;
                                            }
                                            hashMap.put(str12, productDetailsParams5);
                                            if (!(productDetails2.zzd.equals("play_pass_subs") || productDetails3.zzd.equals("play_pass_subs") || optString.equals(productDetails3.zzb.optString("packageName")))) {
                                                billingResult2 = zzcj.zza(5, "All products must have the same package name.");
                                                break;
                                            }
                                            i6 = i8 + 1;
                                            size2 = i7;
                                            zzbtVar3 = zzbtVar4;
                                            hashSet = hashSet2;
                                        } else {
                                            billingResult2 = zzcj.zza(5, "offerToken is required for constructing ProductDetailsParams for subscriptions. Missing value for product id: " + str11);
                                            break;
                                        }
                                    } else {
                                        Iterator it2 = hashSet.iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                String str13 = (String) it2.next();
                                                if (hashMap.containsKey(str13)) {
                                                    BillingFlowParams.ProductDetailsParams productDetailsParams6 = (BillingFlowParams.ProductDetailsParams) hashMap.get(str13);
                                                    billingResult2 = zzcj.zza(5, "OldProductId must not be one of the products to be purchased. Invalid old product id: " + str13 + ".");
                                                    break;
                                                }
                                            } else {
                                                ArrayList arrayList2 = productDetails2.zzk;
                                                String str14 = productDetailsParams3.zzb;
                                                if (!(str14 == null || arrayList2 == null)) {
                                                    int size3 = arrayList2.size();
                                                    int i9 = 0;
                                                    while (true) {
                                                        if (i9 >= size3) {
                                                            oneTimePurchaseOfferDetails = null;
                                                            break;
                                                        }
                                                        Object obj4 = arrayList2.get(i9);
                                                        i9++;
                                                        oneTimePurchaseOfferDetails = (ProductDetails.OneTimePurchaseOfferDetails) obj4;
                                                        if (str14.equals(oneTimePurchaseOfferDetails.zzd)) {
                                                            break;
                                                        }
                                                    }
                                                    if (!(oneTimePurchaseOfferDetails == null || oneTimePurchaseOfferDetails.zzn == null)) {
                                                        billingResult2 = zzcj.zza(5, "Both autoPayDetails and autoPayBalanceThreshold is required for constructing ProductDetailsParams for autopay.");
                                                    }
                                                }
                                                billingResult2 = zzcj.zzi;
                                            }
                                        }
                                    }
                                }
                                billingResult = billingResult2;
                            }
                        }
                    }
                    if (billingResult != zzcj.zzi) {
                        zzbg(108, billingResult, j, false);
                        zzm(billingResult);
                        return billingResult;
                    }
                    long j9 = j;
                    if (this.zzn) {
                        boolean z3 = this.zzp;
                        this.zzD.getClass();
                        this.zzD.getClass();
                        boolean z4 = this.zzF;
                        String str15 = this.zzc;
                        String str16 = this.zzd;
                        long longValue = this.zzI.longValue();
                        this.zzg.getPackageName();
                        int i10 = zzc.zza;
                        final Bundle bundle = new Bundle();
                        zzc.zzc(bundle, str15, str16, longValue);
                        bundle.putLong("billingClientTransactionId", j9);
                        billingFlowParams.zzd.getClass();
                        if (!TextUtils.isEmpty(str3)) {
                            str6 = str3;
                            bundle.putString("accountId", str6);
                        } else {
                            str6 = str3;
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            bundle.putString("obfuscatedProfileId", str6);
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(str6)));
                        }
                        billingFlowParams.zzd.getClass();
                        if (!TextUtils.isEmpty(str6)) {
                            billingFlowParams.zzd.getClass();
                            bundle.putString("oldSkuPurchaseToken", str6);
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            bundle.putString("oldSkuPurchaseId", str6);
                        }
                        billingFlowParams.zzd.getClass();
                        if (!TextUtils.isEmpty(str6)) {
                            billingFlowParams.zzd.getClass();
                            bundle.putString("originalExternalTransactionId", str6);
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            bundle.putString("paymentsPurchaseParams", str6);
                        }
                        if (z3) {
                            z = true;
                            bundle.putBoolean("enablePendingPurchases", true);
                        } else {
                            z = true;
                        }
                        if (z4) {
                            bundle.putBoolean("enableAlternativeBilling", z);
                        }
                        ArrayList arrayList3 = new ArrayList();
                        zzbr zzn = billingFlowParams.zze.listIterator(0);
                        while (zzn.hasNext()) {
                            BillingFlowParams.ProductDetailsParams productDetailsParams7 = (BillingFlowParams.ProductDetailsParams) zzn.next();
                        }
                        if (!arrayList3.isEmpty()) {
                            zzdj zza$1 = zzdk.zza$1();
                            zza$1.zzi();
                            zzdk.zzd((zzdk) zza$1.zza, arrayList3);
                            bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzdk) zza$1.zze()).zzM());
                        }
                        if (!arrayList.isEmpty()) {
                            ArrayList<String> arrayList4 = new ArrayList<>();
                            new ArrayList();
                            new ArrayList();
                            new ArrayList();
                            new ArrayList();
                            Iterator it3 = arrayList.iterator();
                            if (!it3.hasNext()) {
                                if (!arrayList4.isEmpty()) {
                                    bundle.putStringArrayList("skuDetailsTokens", arrayList4);
                                }
                                if (arrayList.size() > 1) {
                                    ArrayList<String> arrayList5 = new ArrayList<>(arrayList.size() - 1);
                                    ArrayList<String> arrayList6 = new ArrayList<>(arrayList.size() - 1);
                                    if (1 >= arrayList.size()) {
                                        bundle.putStringArrayList("additionalSkus", arrayList5);
                                        bundle.putStringArrayList("additionalSkuTypes", arrayList6);
                                    } else {
                                        arrayList.get(1).getClass();
                                        throw new ClassCastException();
                                    }
                                }
                                j7 = j9;
                            } else {
                                throw ViewModelProvider.Factory.CC.m592m(it3);
                            }
                        } else {
                            ArrayList<String> arrayList7 = new ArrayList<>(zzbtVar.size() - 1);
                            ArrayList<String> arrayList8 = new ArrayList<>(zzbtVar.size() - 1);
                            ArrayList<String> arrayList9 = new ArrayList<>();
                            ArrayList<String> arrayList10 = new ArrayList<>();
                            ArrayList<String> arrayList11 = new ArrayList<>();
                            ArrayList<Integer> arrayList12 = new ArrayList<>();
                            int i11 = 0;
                            while (i11 < zzbtVar.size()) {
                                BillingFlowParams.ProductDetailsParams productDetailsParams8 = (BillingFlowParams.ProductDetailsParams) zzbtVar.get(i11);
                                ProductDetails productDetails4 = productDetailsParams8.zza;
                                if (!productDetails4.zzh.isEmpty()) {
                                    arrayList9.add(productDetails4.zzh);
                                }
                                arrayList10.add(productDetailsParams8.zzb);
                                String str17 = productDetails4.zzi;
                                ArrayList arrayList13 = productDetails4.zzk;
                                if (arrayList13 == null || arrayList13.isEmpty()) {
                                    str8 = str17;
                                } else {
                                    ArrayList arrayList14 = productDetails4.zzk;
                                    int size4 = arrayList14.size();
                                    str8 = str17;
                                    int i12 = 0;
                                    while (i12 < size4) {
                                        Object obj5 = arrayList14.get(i12);
                                        int i13 = i12 + 1;
                                        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails2 = (ProductDetails.OneTimePurchaseOfferDetails) obj5;
                                        j8 = j9;
                                        if (!TextUtils.isEmpty(oneTimePurchaseOfferDetails2.zzl)) {
                                            str7 = oneTimePurchaseOfferDetails2.zzl;
                                            break;
                                        }
                                        i12 = i13;
                                        j9 = j8;
                                    }
                                }
                                j8 = j9;
                                str7 = str8;
                                if (!TextUtils.isEmpty(str7)) {
                                    arrayList11.add(str7);
                                }
                                if (i11 > 0) {
                                    arrayList7.add(((BillingFlowParams.ProductDetailsParams) zzbtVar.get(i11)).zza.zzc);
                                    arrayList8.add(((BillingFlowParams.ProductDetailsParams) zzbtVar.get(i11)).zza.zzd);
                                }
                                i11++;
                                j9 = j8;
                            }
                            j7 = j9;
                            bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList10);
                            if (!arrayList12.isEmpty()) {
                                bundle.putIntegerArrayList("autoPayBalanceThresholdList", arrayList12);
                            }
                            if (!arrayList9.isEmpty()) {
                                bundle.putStringArrayList("skuDetailsTokens", arrayList9);
                            }
                            if (!arrayList11.isEmpty()) {
                                bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList11);
                            }
                            if (!arrayList7.isEmpty()) {
                                bundle.putStringArrayList("additionalSkus", arrayList7);
                                bundle.putStringArrayList("additionalSkuTypes", arrayList8);
                            }
                        }
                        if (!bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") || this.zzr) {
                            j2 = j7;
                            if (!TextUtils.isEmpty(productDetailsParams.zza.zzb.optString("packageName"))) {
                                bundle.putString("skuPackageName", productDetailsParams.zza.zzb.optString("packageName"));
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            str4 = null;
                            if (!TextUtils.isEmpty(null)) {
                                bundle.putString("accountName", null);
                            }
                            Intent intent = activity.getIntent();
                            if (intent == null) {
                                zzc.zzn("BillingClient", "Activity's intent is null.");
                            } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                                String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                                bundle.putString("proxyPackage", stringExtra);
                                try {
                                    bundle.putString("proxyPackageVersion", this.zzg.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                                } catch (PackageManager.NameNotFoundException unused) {
                                    bundle.putString("proxyPackageVersion", "package not found");
                                }
                            }
                            if (this.zzu && !zzbtVar.isEmpty()) {
                                i2 = 17;
                            } else if (this.zzs && z2) {
                                i2 = 15;
                            } else if (this.zzp) {
                                i2 = 9;
                            } else {
                                i2 = 6;
                            }
                            final String str18 = str2;
                            final String str19 = str;
                            future = zzG(new Callable(i2, str18, str19, billingFlowParams, bundle) { // from class: com.android.billingclient.api.zzw
                                public final /* synthetic */ int zzb;
                                public final /* synthetic */ String zzc;
                                public final /* synthetic */ String zzd;
                                public final /* synthetic */ Bundle zzf;

                                {
                                    this.zzf = bundle;
                                }

                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    Bundle bundle2;
                                    zzam zzamVar;
                                    BillingClientImpl billingClientImpl = BillingClientImpl.this;
                                    int i14 = this.zzb;
                                    String str20 = this.zzc;
                                    String str21 = this.zzd;
                                    Bundle bundle3 = this.zzf;
                                    try {
                                        synchronized (billingClientImpl.zza) {
                                            zzamVar = billingClientImpl.zzi;
                                        }
                                        if (zzamVar == null) {
                                            return zzc.zzd(107, zzcj.zzj);
                                        }
                                        return ((zzak) zzamVar).zzg(i14, billingClientImpl.zzg.getPackageName(), str20, str21, bundle3);
                                    } catch (DeadObjectException e4) {
                                        BillingResult billingResult8 = zzcj.zzj;
                                        String zza = zzcg.zza(e4);
                                        bundle2 = zzc.zzd(5, billingResult8);
                                        if (zza != null) {
                                            bundle2.putString("ADDITIONAL_LOG_DETAILS", zza);
                                        }
                                        return bundle2;
                                    } catch (Exception e5) {
                                        BillingResult billingResult9 = zzcj.zzh;
                                        String zza2 = zzcg.zza(e5);
                                        bundle2 = zzc.zzd(5, billingResult9);
                                        if (zza2 != null) {
                                            bundle2.putString("ADDITIONAL_LOG_DETAILS", zza2);
                                        }
                                        return bundle2;
                                    }
                                }
                            }, 5000L, null, this.zze, zzF());
                            str5 = str19;
                        } else {
                            BillingResult billingResult8 = zzcj.zzq;
                            zzbg(21, billingResult8, j7, false);
                            zzm(billingResult8);
                            return billingResult8;
                        }
                    } else {
                        j2 = j9;
                        str4 = str3;
                        String str20 = str;
                        future = zzG(new zzx(this, str2, str20, 0), 5000L, null, this.zze, zzF());
                        str5 = str20;
                    }
                    try {
                        if (future == null) {
                            try {
                                BillingResult billingResult9 = zzcj.zzc;
                                zzbg(25, billingResult9, j2, false);
                                zzm(billingResult9);
                                return billingResult9;
                            } catch (CancellationException e4) {
                                e = e4;
                                j5 = j2;
                                j3 = j5;
                                zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                                BillingResult billingResult10 = zzcj.zzk;
                                zzbh(4, billingResult10, zzcg.zza(e), j3, false);
                                zzm(billingResult10);
                                return billingResult10;
                            } catch (TimeoutException e5) {
                                e = e5;
                                j5 = j2;
                                j3 = j5;
                                zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                                BillingResult billingResult102 = zzcj.zzk;
                                zzbh(4, billingResult102, zzcg.zza(e), j3, false);
                                zzm(billingResult102);
                                return billingResult102;
                            } catch (Exception e6) {
                                e2 = e6;
                                j6 = j2;
                                j4 = j6;
                                zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e2);
                                BillingResult billingResult11 = zzcj.zzj;
                                zzbh(5, billingResult11, zzcg.zza(e2), j4, false);
                                zzm(billingResult11);
                                return billingResult11;
                            }
                        } else {
                            long j10 = j2;
                            Bundle bundle2 = (Bundle) future.get(5000L, TimeUnit.MILLISECONDS);
                            int zzb = zzc.zzb(bundle2, "BillingClient");
                            String zzj = zzc.zzj(bundle2, "BillingClient");
                            if (zzb != 0) {
                                zzc.zzn("BillingClient", "Unable to buy item, Error response code: " + zzb);
                                BillingResult zza = zzcj.zza(zzb, zzj);
                                try {
                                    if (bundle2 != null) {
                                        try {
                                            obj3 = bundle2.get("LOG_REASON");
                                        } catch (Throwable th) {
                                            zzc.zzn("BillingClient", "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                                        }
                                        if (obj3 != null) {
                                            if (obj3 instanceof Integer) {
                                                _zzb = ViewModelProvider.Factory.CC._zzb(((Integer) obj3).intValue());
                                                i = 1;
                                                if (_zzb == i) {
                                                    _zzb = 23;
                                                }
                                                if (bundle2 != null) {
                                                    try {
                                                        str4 = bundle2.getString("ADDITIONAL_LOG_DETAILS");
                                                    } catch (Throwable th2) {
                                                        zzc.zzn("BillingClient", "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                                                    }
                                                }
                                                zzbh(_zzb, zza, str4, j10, false);
                                                zzm(zza);
                                                return zza;
                                            }
                                            zzc.zzn("BillingClient", "Unexpected type for bundle log reason: " + obj3.getClass().getName());
                                        }
                                    }
                                    zzbh(_zzb, zza, str4, j10, false);
                                    zzm(zza);
                                    return zza;
                                } catch (CancellationException e7) {
                                    e = e7;
                                    j5 = j10;
                                    j3 = j5;
                                    zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                                    BillingResult billingResult1022 = zzcj.zzk;
                                    zzbh(4, billingResult1022, zzcg.zza(e), j3, false);
                                    zzm(billingResult1022);
                                    return billingResult1022;
                                } catch (TimeoutException e8) {
                                    e = e8;
                                    j5 = j10;
                                    j3 = j5;
                                    zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                                    BillingResult billingResult10222 = zzcj.zzk;
                                    zzbh(4, billingResult10222, zzcg.zza(e), j3, false);
                                    zzm(billingResult10222);
                                    return billingResult10222;
                                } catch (Exception e9) {
                                    e2 = e9;
                                    j6 = j10;
                                    j4 = j6;
                                    zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e2);
                                    BillingResult billingResult112 = zzcj.zzj;
                                    zzbh(5, billingResult112, zzcg.zza(e2), j4, false);
                                    zzm(billingResult112);
                                    return billingResult112;
                                }
                                i = 1;
                                _zzb = 1;
                                if (_zzb == i) {
                                }
                                if (bundle2 != null) {
                                }
                            } else {
                                Intent intent2 = new Intent(activity, ProxyBillingActivity.class);
                                intent2.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                                intent2.putExtra("billingClientTransactionId", j10);
                                intent2.putExtra("wasServiceAutoReconnected", false);
                                activity.startActivity(intent2);
                                return zzcj.zzi;
                            }
                        }
                        j3 = j5;
                    } catch (CancellationException e10) {
                        e = e10;
                        j3 = str5;
                    } catch (TimeoutException e11) {
                        e = e11;
                        j3 = str5;
                    } catch (Exception e12) {
                        e2 = e12;
                        j4 = str5;
                    }
                    zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    BillingResult billingResult102222 = zzcj.zzk;
                    zzbh(4, billingResult102222, zzcg.zza(e), j3, false);
                    zzm(billingResult102222);
                    return billingResult102222;
                } else {
                    zzc.zzn("BillingClient", "Current client doesn't support purchases with ProductDetails.");
                    BillingResult billingResult12 = zzcj.zzr;
                    zzbg(20, billingResult12, nextLong, false);
                    zzm(billingResult12);
                    return billingResult12;
                }
            } else {
                zzc.zzn("BillingClient", "Current client doesn't support subscriptions.");
                BillingResult billingResult13 = zzcj.zzl;
                zzbg(9, billingResult13, nextLong, false);
                zzm(billingResult13);
                return billingResult13;
            }
        } else {
            throw new ClassCastException();
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(QueryProductDetailsParams queryProductDetailsParams, PlayBilling playBilling) {
        if (zzG(new zzx(this, playBilling, queryProductDetailsParams, 3), 30000L, new zzi(this, 8, playBilling), zzan(), zzF()) == null) {
            BillingResult zzaq = zzaq();
            zzbd(25, 7, zzaq);
            zzbr zzbrVar = zzbt.zza;
            playBilling.onProductDetailsResponse(zzaq, new QueryProductDetailsResult(zzca.zza));
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(PlayBilling playBilling) {
        zzaU(playBilling);
    }

    public final synchronized ExecutorService zzF() {
        try {
            if (this.zzH == null) {
                this.zzH = Executors.newFixedThreadPool(zzc.zza, new zzav(this));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzH;
    }

    public final void zzaE(PlayBilling$$ExternalSyntheticLambda15 playBilling$$ExternalSyntheticLambda15, BillingResult billingResult, int i, Exception exc) {
        zzc.zzo("BillingClient", "Error in acknowledge purchase!", exc);
        zzbf(i, 3, billingResult, zzcg.zza(exc));
        PlayBilling.lambda$processPurchases$6(billingResult);
    }

    public final void zzaG(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, int i, String str2, Exception exc) {
        zzc.zzo("BillingClient", str2, exc);
        zzbf(i, 4, billingResult, zzcg.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    public final void zzaO(zzhx zzhxVar) {
        try {
            zzcl zzclVar = this.zzh;
            int i = this.zzm;
            zzclVar.getClass();
            zziq zziqVar = (zziq) ((zzis) zzclVar.zzb).zzm();
            zziqVar.zzi();
            zzis.zzC((zzis) zziqVar.zza, i);
            zzclVar.zzb = (zzis) zziqVar.zze();
            zzclVar.zza(zzhxVar);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void zzaQ(zzib zzibVar) {
        try {
            zzcl zzclVar = this.zzh;
            int i = this.zzm;
            zzclVar.getClass();
            zziq zziqVar = (zziq) ((zzis) zzclVar.zzb).zzm();
            zziqVar.zzi();
            zzis.zzC((zzis) zziqVar.zza, i);
            zzis zzisVar = (zzis) zziqVar.zze();
            zzclVar.zzb = zzisVar;
            zzclVar.zzm(zzibVar, zzisVar);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void zzaR(int i, BillingResult billingResult) {
        try {
            int i2 = zzcg.$r8$clinit;
            zzhv zzhvVar = (zzhv) zzcg.zzb(i, 6, billingResult, null, zzil.zza).zzm();
            zzjt zzc = zzjv.zzc();
            zzc.zza$1(false);
            zzc.zzl();
            zzhvVar.zzo(zzc);
            zzaO((zzhx) zzhvVar.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void zzaS(int i) {
        String str;
        String str2;
        synchronized (this.zza) {
            try {
                if (this.zzb != 3) {
                    int i2 = this.zzb;
                    if (i2 == 0) {
                        str = "DISCONNECTED";
                    } else if (i2 == 1) {
                        str = "CONNECTING";
                    } else if (i2 != 2) {
                        str = "CLOSED";
                    } else {
                        str = "CONNECTED";
                    }
                    if (i == 0) {
                        str2 = "DISCONNECTED";
                    } else if (i == 1) {
                        str2 = "CONNECTING";
                    } else if (i != 2) {
                        str2 = "CLOSED";
                    } else {
                        str2 = "CONNECTED";
                    }
                    zzc.zzm("BillingClient", "Setting clientState from " + str + " to " + str2);
                    this.zzb = i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void zzaT() {
        ExecutorService executorService = this.zzH;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzH = null;
        }
    }

    public final void zzaU(BillingClientStateListener billingClientStateListener) {
        BillingResult billingResult;
        int i;
        synchronized (this.zza) {
            try {
                if (zzaY()) {
                    billingResult = zzap();
                } else if (this.zzb == 1) {
                    zzc.zzn("BillingClient", "Client is already in the process of connecting to billing service.");
                    billingResult = zzcj.zzd;
                    zzaR(37, billingResult);
                } else if (this.zzb == 3) {
                    zzc.zzn("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                    billingResult = zzcj.zzj;
                    zzaR(38, billingResult);
                } else {
                    zzaS(1);
                    zzaV();
                    zzc.zzm("BillingClient", "Starting in-app billing setup.");
                    this.zzj = new zzbf(this, billingClientStateListener);
                    zzbi zzbiVar = this.zzj.zzc;
                    zzbiVar.zzc = 0L;
                    zzbiVar.zzb = false;
                    zzbiVar.zze();
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    List<ResolveInfo> queryIntentServices = this.zzg.getPackageManager().queryIntentServices(intent, 0);
                    if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                        i = 41;
                    } else {
                        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                        i = 40;
                        if (serviceInfo != null) {
                            String str = serviceInfo.packageName;
                            String str2 = serviceInfo.name;
                            if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                            } else {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                intent2.putExtra("playBillingLibraryVersion", this.zzc);
                                synchronized (this.zza) {
                                    try {
                                        if (this.zzb == 2) {
                                            billingResult = zzap();
                                        } else if (this.zzb != 1) {
                                            zzc.zzn("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                            billingResult = zzcj.zzj;
                                            zzaR(105, billingResult);
                                        } else {
                                            zzbf zzbfVar = this.zzj;
                                            if (this.zzg.bindService(intent2, zzbfVar, 1)) {
                                                zzc.zzm("BillingClient", "Service was bonded successfully.");
                                                billingResult = null;
                                            } else {
                                                zzc.zzn("BillingClient", "Connection to Billing service is blocked.");
                                                i = 39;
                                            }
                                        }
                                    } finally {
                                    }
                                }
                            }
                        } else {
                            zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                        }
                    }
                    zzaS(0);
                    zzc.zzm("BillingClient", "Billing service unavailable on device.");
                    billingResult = zzcj.zzb;
                    zzaR(i, billingResult);
                }
            } finally {
            }
        }
        if (billingResult != null) {
            billingClientStateListener.onBillingSetupFinished(billingResult);
        }
    }

    public final void zzaV() {
        synchronized (this.zza) {
            if (this.zzj != null) {
                this.zzg.unbindService(this.zzj);
                this.zzi = null;
                this.zzj = null;
            }
        }
    }

    public final boolean zzaX() {
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt = this.zzJ;
        if (lazyKt__LazyJVMKt != null) {
            long zza = lazyKt__LazyJVMKt.zza();
            long j = 30000;
            long j2 = 30000;
            int i = 1;
            while (i <= 3) {
                try {
                } catch (Exception e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    zzc.zzo("BillingClient", "Error during reconnection attempt: ", e);
                }
                if (Math.max(0L, j2) <= 0) {
                    zzc.zzn("BillingClient", "No time remaining for reconnection attempt.");
                    return zzaY();
                }
                zzc.zzm("BillingClient", "Already connected or not opted into auto reconnection.");
                BillingResult billingResult = zzcj.zzi;
                TimeUnit.MILLISECONDS.getClass();
                int i2 = billingResult.zza;
                if (i2 == 0) {
                    zzc.zzm("BillingClient", "Reconnection succeeded with result: " + i2);
                    return zzaY();
                }
                zzc.zzn("BillingClient", "Reconnection failed with result: " + i2);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                j2 = j - timeUnit.convert((lazyKt__LazyJVMKt.zza() - zza) + 0, timeUnit2);
                long j3 = j;
                long pow = ((long) Math.pow(2.0d, i - 1)) * 1000;
                if (j2 < pow) {
                    zzc.zzn("BillingClient", "Reconnection failed due to timeout limit reached.");
                    return zzaY();
                }
                if (i < 3 && pow > 0) {
                    try {
                        Thread.sleep(pow);
                        j2 = j3 - timeUnit.convert((lazyKt__LazyJVMKt.zza() - zza) + 0, timeUnit2);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        zzc.zzo("BillingClient", "Error sleeping during reconnection attempt: ", e2);
                    }
                }
                i++;
                j = j3;
            }
            zzc.zzn("BillingClient", "Max retries reached.");
            return zzaY();
        }
        throw new NullPointerException("ticker");
    }

    public final boolean zzaY() {
        boolean z;
        synchronized (this.zza) {
            try {
                z = false;
                if (!(this.zzb != 2 || this.zzi == null || this.zzj == null)) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    public final Handler zzan() {
        if (Looper.myLooper() == null) {
            return this.zze;
        }
        return new Handler(Looper.myLooper());
    }

    public final HuffmanTreeGroup zzao(BillingResult billingResult, int i, String str, Exception exc) {
        zzc.zzo("BillingClient", str, exc);
        zzbf(i, 7, billingResult, zzcg.zza(exc));
        return new HuffmanTreeGroup(billingResult.zza, billingResult.zzc, new ArrayList(), new ArrayList());
    }

    public final BillingResult zzap() {
        zzc.zzm("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzhz zzc = zzib.zzc();
        zzc.zzi();
        zzib.zzF((zzib) zzc.zza, 6);
        zzjt zzc2 = zzjv.zzc();
        zzc2.zzi();
        zzjv.zzD((zzjv) zzc2.zza);
        zzc2.zza$1(false);
        zzc2.zzl();
        zzc.zzi();
        zzib.zzE((zzib) zzc.zza, (zzjv) zzc2.zze());
        zzaQ((zzib) zzc.zze());
        return zzcj.zzi;
    }

    public final BillingResult zzaq() {
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            for (int i = 0; i < 2; i++) {
                if (this.zzb == iArr[i]) {
                    return zzcj.zzj;
                }
            }
            return zzcj.zzh;
        }
    }

    public final void zzav() {
        if (TextUtils.isEmpty(null)) {
            this.zzg.getPackageName();
        }
    }

    public final zzcl zzba(BillingResult billingResult, int i, String str, Exception exc) {
        zzbf(i, 9, billingResult, zzcg.zza(exc));
        zzc.zzo("BillingClient", str, exc);
        return new zzcl(18, billingResult, null, false);
    }

    public final void zzbd(int i, int i2, BillingResult billingResult) {
        try {
            int i3 = zzcg.$r8$clinit;
            zzaO(zzcg.zzb(i, i2, billingResult, null, zzil.zza));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void zzbe(int i, BillingResult billingResult, long j) {
        try {
            int i2 = zzcg.$r8$clinit;
            this.zzh.zzc(zzcg.zzb(i, 2, billingResult, null, zzil.zza), this.zzm, j);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void zzbf(int i, int i2, BillingResult billingResult, String str) {
        try {
            int i3 = zzcg.$r8$clinit;
            zzaO(zzcg.zzb(i, i2, billingResult, str, zzil.zza));
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void zzbg(int i, BillingResult billingResult, long j, boolean z) {
        try {
            int i2 = zzcg.$r8$clinit;
            this.zzh.zze(zzcg.zzb(i, 2, billingResult, null, zzil.zza), this.zzm, j, z);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void zzbh(int i, BillingResult billingResult, String str, long j, boolean z) {
        try {
            int i2 = zzcg.$r8$clinit;
            this.zzh.zze(zzcg.zzb(i, 2, billingResult, str, zzil.zza), this.zzm, j, z);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void zzm(BillingResult billingResult) {
        if (!Thread.interrupted()) {
            this.zze.post(new zzi(this, 6, billingResult));
        }
    }

    public BillingClientImpl(Transition.C01101 r6, Context context, EmojiCompat.CompatInternal19 compatInternal19) {
        long nextLong = new Random().nextLong();
        this.zzI = Long.valueOf(nextLong);
        String zzaw = zzaw();
        this.zzd = zzaw;
        this.zzg = context.getApplicationContext();
        zziq zzc = zzis.zzc();
        zzc.zzi();
        zzis.zzI((zzis) zzc.zza);
        if (zzaw != null) {
            zzc.zzi();
            zzis.zzJ((zzis) zzc.zza, zzaw);
        }
        String packageName = this.zzg.getPackageName();
        zzc.zzi();
        zzis.zzG((zzis) zzc.zza, packageName);
        zzc.zzi();
        zzis.zzD((zzis) zzc.zza, nextLong);
        zzc.zzi();
        zzis.zzH((zzis) zzc.zza);
        int i = Build.VERSION.SDK_INT;
        zzc.zzi();
        zzis.zzA((zzis) zzc.zza, i);
        zzc.zzp();
        try {
            int i2 = this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode;
            zzc.zzi();
            zzis.zzB((zzis) zzc.zza, i2);
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzcl(this.zzg, (zzis) zzc.zze());
        zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzf = new zzs(this.zzg, (PurchasesUpdatedListener) null, this.zzh);
        this.zzD = r6;
        this.zzg.getPackageName();
    }
}
