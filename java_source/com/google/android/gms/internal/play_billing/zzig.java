package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
/* loaded from: classes.dex */
public final class zzig extends zzfi {
    private static final zzig zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private int zzi;
    private String zzf = "";
    private String zzh = "";

    static {
        zzig zzigVar = new zzig();
        zzb = zzigVar;
        zzfi.zzw(zzig.class, zzigVar);
    }

    public static /* synthetic */ void zzA(zzig zzigVar, String str) {
        zzigVar.zzd |= 8;
        zzigVar.zzh = str;
    }

    public static /* synthetic */ void zzB(zzig zzigVar, String str) {
        str.getClass();
        zzigVar.zzd |= 2;
        zzigVar.zzf = str;
    }

    public static /* synthetic */ void zzC(zzig zzigVar, int i) {
        zzigVar.zzd |= 16;
        zzigVar.zzi = i;
    }

    public static void zzD(zzig zzigVar, int i) {
        zzigVar.zzg = ViewModelProvider.Factory.CC.getZzbJ(i);
        zzigVar.zzd |= 4;
    }

    public static /* synthetic */ void zzE(zzig zzigVar, int i) {
        zzigVar.zzd |= 1;
        zzigVar.zze = i;
    }

    public static zzic zzc() {
        return (zzic) zzb.zzl();
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzgu(zzb, "\u0004\u0005\u0000\u0001\u0001\u0007\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003\u0007င\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", zzdp.zza$2, "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzig();
        }
        if (i2 == 4) {
            return new zzfe(zzb);
        }
        if (i2 == 5) {
            return zzb;
        }
        throw null;
    }
}
