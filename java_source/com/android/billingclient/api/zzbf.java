package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.play_billing.zzal;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zzap;
import com.google.android.gms.internal.play_billing.zzbi;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzig;
import com.google.android.gms.internal.play_billing.zzij;
import com.google.android.gms.internal.play_billing.zzjm;
import com.google.android.gms.internal.play_billing.zzjo;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import java.util.concurrent.TimeUnit;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class zzbf implements ServiceConnection {
    public final /* synthetic */ BillingClientImpl zza;
    public final BillingClientStateListener zzb;
    public final zzbi zzc;
    public final zzbi zzd;

    public zzbf(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener) {
        this.zza = billingClientImpl;
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt = billingClientImpl.zzJ;
        this.zzc = new zzbi(lazyKt__LazyJVMKt);
        this.zzd = new zzbi(lazyKt__LazyJVMKt);
        this.zzb = billingClientStateListener;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        zzc.zzn("BillingClient", "Billing service died.");
        try {
            BillingClientImpl billingClientImpl = this.zza;
            if (BillingClientImpl.zzai(billingClientImpl)) {
                zzcl zzclVar = billingClientImpl.zzh;
                zzhv zzc = zzhx.zzc();
                zzc.zzi();
                zzhx.zzH((zzhx) zzc.zza, 6);
                zzic zzc2 = zzig.zzc();
                zzc2.zzi();
                zzig.zzD((zzig) zzc2.zza, 110);
                zzc.zzl(zzc2);
                zzjt zzc3 = zzjv.zzc();
                zzc3.zza$1(false);
                zzc3.zzl();
                zzc.zzo(zzc3);
                zzclVar.zza((zzhx) zzc.zze());
            } else {
                billingClientImpl.zzh.zzi(zzij.zzd());
            }
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
        BillingClientImpl billingClientImpl2 = this.zza;
        synchronized (billingClientImpl2.zza) {
            if (!(billingClientImpl2.zzb == 3 || billingClientImpl2.zzb == 0)) {
                billingClientImpl2.zzaS(0);
                billingClientImpl2.zzaV();
                try {
                    this.zzb.onBillingServiceDisconnected();
                } catch (Throwable th2) {
                    zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.android.gms.internal.play_billing.zzap] */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzam zzamVar;
        zzc.zzm("BillingClient", "Billing service connected.");
        BillingClientImpl billingClientImpl = this.zza;
        synchronized (billingClientImpl.zza) {
            try {
                if (billingClientImpl.zzb != 3) {
                    int i = zzal.$r8$clinit;
                    if (iBinder == null) {
                        zzamVar = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
                        if (queryLocalInterface instanceof zzam) {
                            zzamVar = (zzam) queryLocalInterface;
                        } else {
                            zzamVar = new zzap(iBinder, "com.android.vending.billing.IInAppBillingService");
                        }
                    }
                    billingClientImpl.zzi = zzamVar;
                    if (BillingClientImpl.zzG(new zzbd(0, this), 30000L, new zzab(9, this), billingClientImpl.zzan(), billingClientImpl.zzF()) == null) {
                        BillingResult zzaq = billingClientImpl.zzaq();
                        billingClientImpl.zzaR(25, zzaq);
                        zzg(zzaq);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzc.zzn("BillingClient", "Billing service disconnected.");
        try {
            BillingClientImpl billingClientImpl = this.zza;
            if (BillingClientImpl.zzai(billingClientImpl)) {
                zzcl zzclVar = billingClientImpl.zzh;
                zzhv zzc = zzhx.zzc();
                zzc.zzi();
                zzhx.zzH((zzhx) zzc.zza, 6);
                zzic zzc2 = zzig.zzc();
                zzc2.zzi();
                zzig.zzD((zzig) zzc2.zza, 109);
                zzc.zzl(zzc2);
                zzjt zzc3 = zzjv.zzc();
                zzc3.zza$1(false);
                zzc3.zzl();
                zzc.zzo(zzc3);
                zzclVar.zza((zzhx) zzc.zze());
            } else {
                billingClientImpl.zzh.zzk(zzjs.zzd());
            }
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
        zzbi zzbiVar = this.zzd;
        zzbiVar.zzc = 0L;
        zzbiVar.zzb = false;
        zzbiVar.zze();
        BillingClientImpl billingClientImpl2 = this.zza;
        synchronized (billingClientImpl2.zza) {
            try {
                if (billingClientImpl2.zzb != 3) {
                    billingClientImpl2.zzaS(0);
                    try {
                        this.zzb.onBillingServiceDisconnected();
                    } catch (Throwable th2) {
                        zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final Long zze(boolean z) {
        if (z) {
            zzbi zzbiVar = this.zzc;
            if (!zzbiVar.zzb) {
                return null;
            }
            long zza = zzbiVar.zza.zza();
            if (zzbiVar.zzb) {
                zzbiVar.zzb = false;
                long j = (zza - zzbiVar.zzd) + zzbiVar.zzc;
                zzbiVar.zzc = j;
                return Long.valueOf(TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS));
            }
            throw new IllegalStateException("This stopwatch is already stopped.");
        }
        zzbi zzbiVar2 = this.zzd;
        if (!zzbiVar2.zzb) {
            return null;
        }
        long zza2 = zzbiVar2.zza.zza();
        if (zzbiVar2.zzb) {
            zzbiVar2.zzb = false;
            long j2 = (zza2 - zzbiVar2.zzd) + zzbiVar2.zzc;
            zzbiVar2.zzc = j2;
            return Long.valueOf(TimeUnit.MILLISECONDS.convert(j2, TimeUnit.NANOSECONDS));
        }
        throw new IllegalStateException("This stopwatch is already stopped.");
    }

    public final void zzf(BillingResult billingResult, int i, String str, boolean z) {
        try {
            zzic zzc = zzig.zzc();
            int i2 = billingResult.zza;
            zzc.zzi();
            zzig.zzE((zzig) zzc.zza, i2);
            String str2 = billingResult.zzc;
            zzc.zzi();
            zzig.zzB((zzig) zzc.zza, str2);
            zzc.zzi();
            zzig.zzD((zzig) zzc.zza, i);
            if (str != null) {
                zzc.zzi();
                zzig.zzA((zzig) zzc.zza, str);
            }
            Long zze = zze(z);
            BillingClientImpl billingClientImpl = this.zza;
            if (z) {
                zzjt zzc2 = zzjv.zzc();
                zzc2.zza$1(false);
                zzc2.zzl();
                if (zze != null) {
                    long longValue = zze.longValue();
                    zzc2.zzi();
                    zzjv.zzC((zzjv) zzc2.zza, longValue);
                }
                zzhv zzc3 = zzhx.zzc();
                zzc3.zzl(zzc);
                zzc3.zzi();
                zzhx.zzH((zzhx) zzc3.zza, 6);
                zzc3.zzo(zzc2);
                billingClientImpl.zzaO((zzhx) zzc3.zze());
                return;
            }
            zzjm zzc4 = zzjo.zzc();
            zzc4.zzi();
            zzjo.zzA((zzjo) zzc4.zza, (zzig) zzc.zze());
            if (zze != null) {
                long longValue2 = zze.longValue();
                zzc4.zzi();
                zzjo.zzB((zzjo) zzc4.zza, longValue2);
            }
            billingClientImpl.zzh.zzj((zzjo) zzc4.zze());
        } catch (Throwable th) {
            zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    public final void zzg(BillingResult billingResult) {
        BillingClientImpl billingClientImpl = this.zza;
        synchronized (billingClientImpl.zza) {
            try {
                if (billingClientImpl.zzb != 3) {
                    try {
                        this.zzb.onBillingSetupFinished(billingResult);
                    } catch (Throwable th) {
                        zzc.zzo("BillingClient", "Exception while calling onBillingSetupFinished.", th);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
