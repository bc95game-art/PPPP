package com.android.billingclient.api;

import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Parcel;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.loader.content.AsyncTaskLoader;
import com.google.android.gms.internal.play_billing.zzak;
import com.google.android.gms.internal.play_billing.zzam;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzig;
import com.google.android.gms.internal.play_billing.zzjm;
import com.google.android.gms.internal.play_billing.zzjo;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public final /* synthetic */ class zzbd implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;

    public /* synthetic */ zzbd(int i, Object obj) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        boolean z;
        Bundle bundle;
        zzam zzamVar;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        int i2;
        String str;
        BillingResult billingResult;
        BillingResult billingResult2;
        switch (this.$r8$classId) {
            case 0:
                zzbf zzbfVar = (zzbf) this.zza;
                BillingClientImpl billingClientImpl = zzbfVar.zza;
                synchronized (billingClientImpl.zza) {
                    try {
                        if (billingClientImpl.zzb != 3) {
                            boolean z13 = true;
                            if (billingClientImpl.zzb == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!TextUtils.isEmpty(null)) {
                                bundle = new Bundle();
                                bundle.putString("accountName", null);
                                zzc.zzc(bundle, billingClientImpl.zzc, billingClientImpl.zzd, billingClientImpl.zzI.longValue());
                            } else {
                                bundle = null;
                            }
                            synchronized (billingClientImpl.zza) {
                                zzamVar = billingClientImpl.zzi;
                            }
                            if (zzamVar == null) {
                                BillingClientImpl billingClientImpl2 = zzbfVar.zza;
                                billingClientImpl2.zzaS(0);
                                BillingResult billingResult3 = zzcj.zzj;
                                billingClientImpl2.zzaR(107, billingResult3);
                                zzbfVar.zzg(billingResult3);
                            } else {
                                BillingClientImpl billingClientImpl3 = zzbfVar.zza;
                                String packageName = billingClientImpl3.zzg.getPackageName();
                                int i3 = 25;
                                int i4 = 3;
                                while (true) {
                                    if (i3 >= 3) {
                                        if (bundle == null) {
                                            try {
                                                zzak zzakVar = (zzak) zzamVar;
                                                Parcel zzs = zzakVar.zzs();
                                                zzs.writeInt(i3);
                                                zzs.writeString(packageName);
                                                zzs.writeString("subs");
                                                Parcel zzt = zzakVar.zzt(zzs, 1);
                                                int readInt = zzt.readInt();
                                                zzt.recycle();
                                                i4 = readInt;
                                            } catch (Exception e) {
                                                zzc.zzo("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                                                boolean z14 = e instanceof DeadObjectException;
                                                if (z14) {
                                                    i2 = 91;
                                                } else if (e instanceof RemoteException) {
                                                    i2 = 90;
                                                } else if (e instanceof SecurityException) {
                                                    i2 = 92;
                                                } else {
                                                    i2 = 42;
                                                }
                                                if (SolverVariable$Type$EnumUnboxingSharedUtility.equals(i2, 42)) {
                                                    str = zzcg.zza(e);
                                                } else {
                                                    str = null;
                                                }
                                                zzbfVar.zza.zzaS(0);
                                                if (z14) {
                                                    billingResult = zzcj.zzj;
                                                } else {
                                                    billingResult = zzcj.zzh;
                                                }
                                                zzbfVar.zzf(billingResult, i2, str, z);
                                                if (z14) {
                                                    billingResult2 = zzcj.zzj;
                                                } else {
                                                    billingResult2 = zzcj.zzh;
                                                }
                                                zzbfVar.zzg(billingResult2);
                                            }
                                        } else {
                                            i4 = ((zzak) zzamVar).zzc(i3, packageName, "subs", bundle);
                                        }
                                        if (i4 == 0) {
                                            zzc.zzm("BillingClient", "highestLevelSupportedForSubs: " + i3);
                                        } else {
                                            i3--;
                                        }
                                    } else {
                                        i3 = 0;
                                    }
                                }
                                if (i3 >= 3) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                billingClientImpl3.zzk = z2;
                                if (i3 < 3) {
                                    zzc.zzm("BillingClient", "In-app billing API does not support subscription on this device.");
                                    i = 9;
                                } else {
                                    i = 1;
                                }
                                int i5 = i4;
                                int i6 = 25;
                                while (true) {
                                    if (i6 >= 3) {
                                        if (bundle == null) {
                                            zzak zzakVar2 = (zzak) zzamVar;
                                            Parcel zzs2 = zzakVar2.zzs();
                                            zzs2.writeInt(i6);
                                            zzs2.writeString(packageName);
                                            zzs2.writeString("inapp");
                                            Parcel zzt2 = zzakVar2.zzt(zzs2, 1);
                                            i5 = zzt2.readInt();
                                            zzt2.recycle();
                                        } else {
                                            i5 = ((zzak) zzamVar).zzc(i6, packageName, "inapp", bundle);
                                        }
                                        if (i5 == 0) {
                                            billingClientImpl3.zzm = i6;
                                            zzc.zzm("BillingClient", "mHighestLevelSupportedForInApp: " + i6);
                                        } else {
                                            i6--;
                                        }
                                    }
                                }
                                int i7 = billingClientImpl3.zzm;
                                billingClientImpl3.zzm = i7;
                                if (i7 >= 26) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                billingClientImpl3.zzC = z3;
                                if (i7 >= 24) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                billingClientImpl3.zzB = z4;
                                if (i7 >= 21) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                billingClientImpl3.zzy = z5;
                                if (i7 >= 20) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                billingClientImpl3.zzx = z6;
                                if (i7 >= 19) {
                                    z7 = true;
                                } else {
                                    z7 = false;
                                }
                                billingClientImpl3.zzw = z7;
                                if (i7 >= 17) {
                                    z8 = true;
                                } else {
                                    z8 = false;
                                }
                                billingClientImpl3.zzu = z8;
                                if (i7 >= 16) {
                                    z9 = true;
                                } else {
                                    z9 = false;
                                }
                                billingClientImpl3.zzt = z9;
                                if (i7 >= 15) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                billingClientImpl3.zzs = z10;
                                if (i7 >= 14) {
                                    z11 = true;
                                } else {
                                    z11 = false;
                                }
                                billingClientImpl3.zzr = z11;
                                if (i7 >= 9) {
                                    z12 = true;
                                } else {
                                    z12 = false;
                                }
                                billingClientImpl3.zzp = z12;
                                if (i7 < 6) {
                                    z13 = false;
                                }
                                billingClientImpl3.zzn = z13;
                                if (i7 < 3) {
                                    zzc.zzn("BillingClient", "In-app billing API version 3 is not supported on this device.");
                                    i = 36;
                                }
                                BillingClientImpl.zzae(billingClientImpl3, i5);
                                if (i5 != 0) {
                                    BillingResult billingResult4 = zzcj.zzb;
                                    zzbfVar.zzf(billingResult4, i, null, z);
                                    zzbfVar.zzg(billingResult4);
                                } else {
                                    try {
                                        Long zze = zzbfVar.zze(z);
                                        if (z) {
                                            zzhz zzc = zzib.zzc();
                                            zzc.zzi();
                                            zzib.zzF((zzib) zzc.zza, 6);
                                            zzjt zzc2 = zzjv.zzc();
                                            zzc2.zza$1(false);
                                            zzc2.zzl();
                                            if (zze != null) {
                                                long longValue = zze.longValue();
                                                zzc2.zzi();
                                                zzjv.zzC((zzjv) zzc2.zza, longValue);
                                            }
                                            BillingClientImpl billingClientImpl4 = zzbfVar.zza;
                                            zzc.zzi();
                                            zzib.zzE((zzib) zzc.zza, (zzjv) zzc2.zze());
                                            billingClientImpl4.zzaQ((zzib) zzc.zze());
                                        } else {
                                            zzjm zzc3 = zzjo.zzc();
                                            zzic zzc4 = zzig.zzc();
                                            zzc4.zzi();
                                            zzig.zzE((zzig) zzc4.zza, 0);
                                            zzc3.zzi();
                                            zzjo.zzA((zzjo) zzc3.zza, (zzig) zzc4.zze());
                                            if (zze != null) {
                                                long longValue2 = zze.longValue();
                                                zzc3.zzi();
                                                zzjo.zzB((zzjo) zzc3.zza, longValue2);
                                            }
                                            zzbfVar.zza.zzh.zzj((zzjo) zzc3.zze());
                                        }
                                    } catch (Throwable th) {
                                        zzc.zzo("BillingClient", "Unable to log.", th);
                                    }
                                    zzbfVar.zzg(zzcj.zzi);
                                }
                            }
                        }
                    } finally {
                    }
                }
                return null;
            default:
                AsyncTaskLoader.LoadTask loadTask = (AsyncTaskLoader.LoadTask) this.zza;
                loadTask.mTaskInvoked.set(true);
                Object obj = null;
                try {
                    Process.setThreadPriority(10);
                    obj = AsyncTaskLoader.this.onLoadInBackground();
                    Binder.flushPendingCommands();
                    return obj;
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
        }
    }
}
