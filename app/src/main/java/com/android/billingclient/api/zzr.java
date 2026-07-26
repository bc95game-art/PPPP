package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzeu;
import com.google.android.gms.internal.play_billing.zzgs;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzil;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r19, android.content.Intent r20) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzr.onReceive(android.content.Context, android.content.Intent):void");
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
