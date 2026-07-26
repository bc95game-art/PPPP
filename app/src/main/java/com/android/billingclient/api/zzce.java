package com.android.billingclient.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.core.util.Consumer;
import androidx.emoji2.text.EmojiCompat;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda15;
import com.google.android.gms.internal.play_billing.zzau;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzcp;
import com.google.android.gms.internal.play_billing.zzct;
import com.google.android.gms.internal.play_billing.zzcx;
import com.google.android.gms.internal.play_billing.zzcz;
import com.google.android.gms.internal.play_billing.zzg;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzil;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zzo;
import com.google.android.gms.internal.play_billing.zzs;
import com.google.android.gms.internal.play_billing.zzt;
import j$.util.Objects;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class zzce extends BillingClientImpl {
    public final Context zza;
    public volatile int zzb = 0;
    public volatile zzau zzc;
    public volatile zzcc zzd;
    public volatile ScheduledExecutorService zze;

    public zzce(Transition.AnonymousClass1 r1, Context context, EmojiCompat.CompatInternal19 compatInternal19) {
        super(r1, context, compatInternal19);
        this.zza = context;
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void acknowledgePurchase(ConsumeParams consumeParams, PlayBilling$$ExternalSyntheticLambda15 playBilling$$ExternalSyntheticLambda15) {
        zzaH(3, new zzbr(3, playBilling$$ExternalSyntheticLambda15), new zzam(this, consumeParams, playBilling$$ExternalSyntheticLambda15, 5));
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        zzaH(4, new Consumer() { // from class: com.android.billingclient.api.zzbt
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                String str = consumeParams.zza;
                consumeResponseListener.onConsumeResponse((BillingResult) obj, str);
            }
        }, new zzam(this, consumeParams, consumeResponseListener));
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void endConnection() {
        synchronized (this) {
            zzaG(27);
            try {
                if (!(this.zzd == null || this.zzc == null)) {
                    zzc.zzm("BillingClientTesting", "Unbinding from Billing Override Service.");
                    this.zza.unbindService(this.zzd);
                    this.zzd = new zzcc(this);
                }
                this.zzc = null;
                if (this.zze != null) {
                    this.zze.shutdownNow();
                    this.zze = null;
                }
            } catch (RuntimeException e) {
                zzc.zzo("BillingClientTesting", "There was an exception while ending Billing Override Service connection!", e);
            }
            this.zzb = 3;
        }
        super.endConnection();
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        int i = 0;
        try {
            i = ((Integer) zzaE(2).get(28500L, TimeUnit.MILLISECONDS)).intValue();
        } catch (TimeoutException e) {
            zzaF(102, 28, zzcj.zzF);
            zzc.zzo("BillingClientTesting", "Asynchronous call to Billing Override Service timed out.", e);
        } catch (Exception e2) {
            if (e2 instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            zzaF(95, 28, zzcj.zzF);
            zzc.zzo("BillingClientTesting", "An error occurred while retrieving billing override.", e2);
        }
        if (i > 0) {
            BillingResult zza = zzcj.zza(i, "Billing override value was set by a license tester.");
            zzaF(93, 2, zza);
            zzm(zza);
            return zza;
        }
        try {
            return super.launchBillingFlow(activity, billingFlowParams);
        } catch (Exception e3) {
            BillingResult billingResult = zzcj.zzh;
            zzaF(103, 2, billingResult);
            zzc.zzo("BillingClientTesting", "An internal error occurred.", e3);
            return billingResult;
        }
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void queryProductDetailsAsync(QueryProductDetailsParams queryProductDetailsParams, PlayBilling playBilling) {
        zzaH(7, new zzbr(0, playBilling), new zzam(this, queryProductDetailsParams, playBilling, 3));
    }

    @Override // com.android.billingclient.api.BillingClientImpl, com.android.billingclient.api.BillingClient
    public final void startConnection(PlayBilling playBilling) {
        synchronized (this) {
            if (zzat()) {
                zzc.zzm("BillingClientTesting", "Billing Override Service connection is valid. No need to re-initialize.");
                zzaG(26);
            } else {
                int i = 1;
                if (this.zzb == 1) {
                    zzc.zzn("BillingClientTesting", "Client is already in the process of connecting to Billing Override Service.");
                } else if (this.zzb == 3) {
                    zzc.zzn("BillingClientTesting", "Billing Override Service Client was already closed and can't be reused. Please create another instance.");
                    zzaF(38, 26, zzcj.zza(-1, "Billing Override Service connection is disconnected."));
                } else {
                    this.zzb = 1;
                    zzc.zzm("BillingClientTesting", "Starting Billing Override Service setup.");
                    this.zzd = new zzcc(this);
                    Intent intent = new Intent("com.google.android.apps.play.billingtestcompanion.BillingOverrideService.BIND");
                    intent.setPackage("com.google.android.apps.play.billingtestcompanion");
                    Context context = this.zza;
                    List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
                    if (queryIntentServices == null || queryIntentServices.isEmpty()) {
                        i = 41;
                    } else {
                        ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                        if (serviceInfo != null) {
                            String str = serviceInfo.packageName;
                            String str2 = serviceInfo.name;
                            if (!Objects.equals(str, "com.google.android.apps.play.billingtestcompanion") || str2 == null) {
                                zzc.zzn("BillingClientTesting", "The device doesn't have valid Play Billing Lab.");
                            } else {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                if (context.bindService(intent2, this.zzd, 1)) {
                                    zzc.zzm("BillingClientTesting", "Billing Override Service was bonded successfully.");
                                } else {
                                    zzc.zzn("BillingClientTesting", "Connection to Billing Override Service is blocked.");
                                }
                            }
                            i = 39;
                        }
                    }
                    this.zzb = 0;
                    zzc.zzm("BillingClientTesting", "Billing Override Service unavailable on device.");
                    zzaF(i, 26, zzcj.zza(2, "Billing Override Service unavailable on device."));
                }
            }
        }
        zzaU(playBilling);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.internal.play_billing.zzv, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, com.google.android.gms.internal.play_billing.zzp] */
    public final zzcz zzaE(int i) {
        if (!zzat()) {
            zzc.zzn("BillingClientTesting", "Billing Override Service is not ready.");
            zzaF(94, 28, zzcj.zza(-1, "Billing Override Service connection is disconnected."));
            return new zzcx(0);
        }
        zzbv zzbvVar = new zzbv(i, this);
        ?? obj = new Object();
        obj.zzc = new Object();
        zzt zztVar = new zzt(obj);
        obj.zzb = zztVar;
        obj.zza = zzbv.class;
        try {
            zzbvVar.zza(obj);
            obj.zza = "billingOverrideService.getBillingOverride";
            return zztVar;
        } catch (Exception e) {
            zzg zzgVar = new zzg(e);
            LazyKt__LazyJVMKt lazyKt__LazyJVMKt = zzo.zzb;
            zzs zzsVar = zztVar.zzb;
            if (lazyKt__LazyJVMKt.zzd(zzsVar, null, zzgVar)) {
                zzo.zzc(zzsVar);
            }
            return zztVar;
        }
    }

    public final void zzaF(int i, int i2, BillingResult billingResult) {
        int i3 = zzcg.$r8$clinit;
        zzhx zzb = zzcg.zzb(i, i2, billingResult, null, zzil.zza);
        Objects.requireNonNull(zzb, "ApiFailure should not be null");
        this.zzh.zza(zzb);
    }

    public final void zzaG(int i) {
        int i2 = zzcg.$r8$clinit;
        zzib zzc = zzcg.zzc(i, zzil.zza);
        Objects.requireNonNull(zzc, "ApiSuccess should not be null");
        zzcl zzclVar = this.zzh;
        zzclVar.getClass();
        try {
            zzclVar.zzm(zzc, (zzis) zzclVar.zzb);
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to log.", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.android.gms.internal.play_billing.zzde, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, com.google.android.gms.internal.play_billing.zzdb, java.lang.Runnable] */
    public final void zzaH(int i, Consumer consumer, Runnable runnable) {
        ScheduledExecutorService scheduledExecutorService;
        zzcz zzaE = zzaE(i);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        synchronized (this) {
            try {
                if (this.zze == null) {
                    this.zze = Executors.newSingleThreadScheduledExecutor();
                }
                scheduledExecutorService = this.zze;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!zzaE.isDone()) {
            ?? obj = new Object();
            obj.zzd = zzaE;
            ?? obj2 = new Object();
            obj2.zza = obj;
            obj.zze = scheduledExecutorService.schedule((Runnable) obj2, 28500L, timeUnit);
            zzaE.zzb(obj2, zzcp.zza);
            zzaE = obj;
        }
        zzca zzcaVar = new zzca(this, i, consumer, runnable);
        zzaE.zzb(new zzct(zzaE, zzcaVar), zzF());
    }

    public final synchronized boolean zzat() {
        if (this.zzb == 2 && this.zzc != null) {
            if (this.zzd != null) {
                return true;
            }
        }
        return false;
    }

    public zzce(Transition.AnonymousClass1 r1, Context context, PurchasesUpdatedListener purchasesUpdatedListener, EmojiCompat.CompatInternal19 compatInternal19) {
        super(r1, context, purchasesUpdatedListener, compatInternal19);
        this.zza = context;
    }
}
