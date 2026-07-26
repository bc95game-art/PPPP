package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.core.p002os.BundleKt;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzbr;
import com.google.android.gms.internal.play_billing.zzbt;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
import com.google.android.gms.internal.play_billing.zzeu;
import com.google.android.gms.internal.play_billing.zzgs;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzil;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zzja;
import com.google.android.gms.internal.play_billing.zzjf;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzr extends BroadcastReceiver {
    public final /* synthetic */ zzs zza;
    public boolean zzb;
    public final boolean zzc;

    public zzr(zzs zzsVar, boolean z) {
        this.zza = zzsVar;
        this.zzc = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0236  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        zzil zzilVar;
        int i;
        BillingResult billingResult;
        long j;
        ArrayList arrayList;
        BillingResult billingResult2;
        zzis zzisVar;
        int i2;
        String action = intent.getAction();
        int hashCode = action.hashCode();
        zzil zzilVar2 = zzil.zzc;
        zzil zzilVar3 = zzil.zzb;
        zzil zzilVar4 = zzil.zzd;
        if (hashCode == -1484087650) {
            if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
                zzilVar = zzilVar3;
            }
            zzilVar = zzil.zza;
        } else if (hashCode != -337612916) {
            if (hashCode == 345207161 && action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                zzilVar = zzilVar4;
            }
            zzilVar = zzil.zza;
        } else {
            if (action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
                zzilVar = zzilVar2;
            }
            zzilVar = zzil.zza;
        }
        if (zzilVar.equals(zzilVar2) || zzilVar.equals(zzilVar4)) {
            i = 2;
        } else if (zzilVar.equals(zzilVar3)) {
            i = 32;
        } else {
            i = 1;
        }
        Bundle extras = intent.getExtras();
        zzs zzsVar = this.zza;
        if (extras == null) {
            zzc.zzn("BillingBroadcastManager", "Bundle is null.");
            BillingResult billingResult3 = zzcj.zzh;
            ((zzcl) ((zzch) zzsVar.zze)).zza(zzcg.zzb(11, i, billingResult3, null, zzilVar));
            PurchasesUpdatedListener purchasesUpdatedListener = (PurchasesUpdatedListener) zzsVar.zzb;
            if (purchasesUpdatedListener != null) {
                purchasesUpdatedListener.onPurchasesUpdated(billingResult3, null);
                return;
            }
            return;
        }
        if (i == 2) {
            int i3 = zzc.zza;
            BillingResult.Builder newBuilder = BillingResult.newBuilder();
            newBuilder.zza = zzc.zzb(intent.getExtras(), "BillingBroadcastManager");
            Bundle extras2 = intent.getExtras();
            if (extras2 == null) {
                zzc.zzn("BillingBroadcastManager", "Unexpected null bundle received!");
            } else {
                Object obj = extras2.get("SUB_RESPONSE_CODE");
                if (obj == null) {
                    zzc.zzm("BillingBroadcastManager", "getLaunchBillingFlowSubResponseCodeFromBundle() got null response code, assuming OK");
                } else if (obj instanceof Integer) {
                    i2 = ((Integer) obj).intValue();
                    newBuilder.zzb = i2;
                    newBuilder.zzc = zzc.zzj(intent.getExtras(), "BillingBroadcastManager");
                    billingResult = newBuilder.build();
                } else {
                    zzc.zzn("BillingBroadcastManager", "Unexpected type for bundle sub response code: ".concat(obj.getClass().getName()));
                }
            }
            i2 = 0;
            newBuilder.zzb = i2;
            newBuilder.zzc = zzc.zzj(intent.getExtras(), "BillingBroadcastManager");
            billingResult = newBuilder.build();
        } else {
            billingResult = zzc.zzh(intent, "BillingBroadcastManager");
        }
        long j2 = extras.getLong("billingClientTransactionId", 0L);
        boolean z = extras.getBoolean("wasServiceAutoReconnected", false);
        if (zzilVar.equals(zzilVar3) || zzilVar.equals(zzilVar2)) {
            ArrayList<String> stringArrayList = extras.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
            ArrayList<String> stringArrayList2 = extras.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
            ArrayList arrayList2 = new ArrayList();
            if (stringArrayList == null || stringArrayList2 == null) {
                j = 0;
                Purchase zzq = zzc.zzq(extras.getString("INAPP_PURCHASE_DATA"), extras.getString("INAPP_DATA_SIGNATURE"));
                if (zzq == null) {
                    zzc.zzm("BillingHelper", "Couldn't find single purchase data as well.");
                    arrayList = null;
                    if (billingResult.zza != 0) {
                        zzib zzc = zzcg.zzc(i, zzilVar);
                        zzcl zzclVar = (zzcl) ((zzch) zzsVar.zze);
                        zzclVar.getClass();
                        try {
                            zzhz zzhzVar = (zzhz) zzc.zzm();
                            zzja zzjaVar = (zzja) zzc.zzA().zzm();
                            zzjaVar.zzi();
                            zzjf.zzA((zzjf) zzjaVar.zza, z);
                            zzhzVar.zzi();
                            zzib.zzD((zzib) zzhzVar.zza, (zzjf) zzjaVar.zze());
                            zzib zzibVar = (zzib) zzhzVar.zze();
                            if (j2 == j) {
                                zzisVar = (zzis) zzclVar.zzb;
                            } else {
                                zziq zziqVar = (zziq) ((zzis) zzclVar.zzb).zzm();
                                zziqVar.zzi();
                                zzis.zzE((zzis) zziqVar.zza, j2);
                                zzisVar = (zzis) zziqVar.zze();
                            }
                            zzclVar.zzm(zzibVar, zzisVar);
                        } catch (Throwable th) {
                            zzc.zzo("BillingLogger", "Unable to log.", th);
                        }
                        billingResult2 = billingResult;
                    } else {
                        billingResult2 = billingResult;
                        zzd(extras, billingResult2, i, zzilVar, j2, z);
                    }
                    ((PurchasesUpdatedListener) zzsVar.zzb).onPurchasesUpdated(billingResult2, arrayList);
                }
                arrayList2.add(zzq);
            } else {
                j = 0;
                zzc.zzm("BillingHelper", "Found purchase list of " + stringArrayList.size() + " items");
                for (int i4 = 0; i4 < stringArrayList.size() && i4 < stringArrayList2.size(); i4++) {
                    Purchase zzq2 = zzc.zzq(stringArrayList.get(i4), stringArrayList2.get(i4));
                    if (zzq2 != null) {
                        arrayList2.add(zzq2);
                    }
                }
            }
            arrayList = arrayList2;
            if (billingResult.zza != 0) {
            }
            ((PurchasesUpdatedListener) zzsVar.zzb).onPurchasesUpdated(billingResult2, arrayList);
        } else if (zzilVar.equals(zzilVar4)) {
            if (billingResult.zza != 0) {
                zzd(extras, billingResult, i, zzilVar, j2, z);
                zzbr zzbrVar = zzbt.zza;
                ((PurchasesUpdatedListener) zzsVar.zzb).onPurchasesUpdated(billingResult, zzca.zza);
                return;
            }
            zzsVar.getClass();
            zzc.zzn("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
            BillingResult billingResult4 = zzcj.zzh;
            ((zzcl) ((zzch) zzsVar.zze)).zzd(zzcg.zzb(77, i, billingResult4, null, zzilVar), j2, z);
            zzbr zzbrVar2 = zzbt.zza;
            ((PurchasesUpdatedListener) zzsVar.zzb).onPurchasesUpdated(billingResult4, zzca.zza);
        }
    }

    public final synchronized void zza(Context context, IntentFilter intentFilter) {
        int i;
        try {
            if (!this.zzb) {
                if (Build.VERSION.SDK_INT >= 33) {
                    if (true != this.zzc) {
                        i = 4;
                    } else {
                        i = 2;
                    }
                    context.registerReceiver(this, intentFilter, i);
                } else {
                    context.registerReceiver(this, intentFilter);
                }
                this.zzb = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzb(Context context, IntentFilter intentFilter) {
        zzr zzrVar;
        int i;
        try {
            try {
                if (!this.zzb) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        if (true != this.zzc) {
                            i = 4;
                        } else {
                            i = 2;
                        }
                        zzrVar = this;
                        context.registerReceiver(zzrVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, i);
                    } else {
                        zzrVar = this;
                        context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                    }
                    zzrVar.zzb = true;
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized void zzc(Context context) {
        if (this.zzb) {
            context.unregisterReceiver(this);
            this.zzb = false;
            return;
        }
        zzc.zzn("BillingBroadcastManager", "Receiver is not registered.");
    }

    public final void zzd(Bundle bundle, BillingResult billingResult, int i, zzil zzilVar, long j, boolean z) {
        zzeu zzb;
        try {
            if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
                zzch zzchVar = (zzch) this.zza.zze;
                byte[] byteArray = bundle.getByteArray("FAILURE_LOGGING_PAYLOAD");
                int i2 = zzeu.$r8$clinit;
                synchronized (zzeu.class) {
                    int i3 = zzeu.$r8$clinit;
                    zzgs zzgsVar = zzgs.zzb;
                    zzb = BundleKt.zzb();
                    int i4 = zzeu.$r8$clinit;
                }
                ((zzcl) zzchVar).zzd(zzhx.zzA(byteArray, zzb), j, z);
                return;
            }
            ((zzcl) ((zzch) this.zza.zze)).zzd(zzcg.zzb(23, i, billingResult, null, zzilVar), j, z);
        } catch (Throwable unused) {
            zzc.zzn("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }
}
