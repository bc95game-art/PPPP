package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.emoji2.text.EmojiCompat;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda15;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zzaz;
import com.google.android.gms.internal.play_billing.zzbi;
import com.google.android.gms.internal.play_billing.zzbr;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
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
import j$.util.Objects;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.LazyKt__LazyJVMKt;
import org.brotli.dec.HuffmanTreeGroup;
/* loaded from: classes.dex */
public class BillingClientImpl extends BillingClient {
    public boolean zzB;
    public boolean zzC;
    public final Transition.AnonymousClass1 zzD;
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

    public BillingClientImpl(Transition.AnonymousClass1 r6, Context context, PurchasesUpdatedListener purchasesUpdatedListener, EmojiCompat.CompatInternal19 compatInternal19) {
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
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.billingclient.api.BillingResult launchBillingFlow(android.app.Activity r30, final com.android.billingclient.api.BillingFlowParams r31) {
        /*
            Method dump skipped, instructions count: 1906
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.launchBillingFlow(android.app.Activity, com.android.billingclient.api.BillingFlowParams):com.android.billingclient.api.BillingResult");
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

    public BillingClientImpl(Transition.AnonymousClass1 r6, Context context, EmojiCompat.CompatInternal19 compatInternal19) {
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
