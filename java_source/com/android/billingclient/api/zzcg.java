package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzig;
import com.google.android.gms.internal.play_billing.zzil;
/* loaded from: classes.dex */
public abstract /* synthetic */ class zzcg {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        int i = zzch.$r8$clinit;
    }

    public static String zza(Exception exc) {
        if (exc == null) {
            return null;
        }
        try {
            String simpleName = exc.getClass().getSimpleName();
            String message = exc.getMessage();
            if (message == null) {
                message = "";
            }
            String str = simpleName + ":" + message;
            int i = zzc.zza;
            if (str.length() > 40) {
                return str.substring(0, 40);
            }
            return str;
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to get truncated exception info", th);
            return null;
        }
    }

    public static zzhx zzb(int i, int i2, BillingResult billingResult, String str, zzil zzilVar) {
        try {
            zzic zzc = zzig.zzc();
            int i3 = billingResult.zza;
            zzc.zzi();
            zzig.zzE((zzig) zzc.zza, i3);
            String str2 = billingResult.zzc;
            zzc.zzi();
            zzig.zzB((zzig) zzc.zza, str2);
            int i4 = billingResult.zzb;
            if (i4 != 0) {
                zzc.zzi();
                zzig.zzC((zzig) zzc.zza, i4);
            }
            if (i != 0) {
                zzc.zzi();
                zzig.zzD((zzig) zzc.zza, i);
            }
            if (str != null) {
                zzc.zzi();
                zzig.zzA((zzig) zzc.zza, str);
            }
            zzhv zzc2 = zzhx.zzc();
            zzc2.zzl(zzc);
            zzc2.zzi();
            zzhx.zzH((zzhx) zzc2.zza, i2);
            if (!zzilVar.equals(zzil.zza)) {
                zzc2.zzi();
                zzhx.zzC((zzhx) zzc2.zza, zzilVar);
            }
            return (zzhx) zzc2.zze();
        } catch (Throwable th) {
            zzc.zzo("BillingLogger", "Unable to create logging payload", th);
            return null;
        }
    }

    public static zzib zzc(int i, zzil zzilVar) {
        try {
            zzhz zzc = zzib.zzc();
            zzc.zzi();
            zzib.zzF((zzib) zzc.zza, i);
            if (!zzilVar.equals(zzil.zza)) {
                zzc.zzi();
                zzib.zzB((zzib) zzc.zza, zzilVar);
            }
            return (zzib) zzc.zze();
        } catch (Exception e) {
            zzc.zzo("BillingLogger", "Unable to create logging payload", e);
            return null;
        }
    }
}
