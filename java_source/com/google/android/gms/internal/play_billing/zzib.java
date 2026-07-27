package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzib extends zzfi {
    private static final zzib zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private int zzh;

    static {
        zzib zzibVar = new zzib();
        zzb = zzibVar;
        zzfi.zzw(zzib.class, zzibVar);
    }

    public static void zzB(zzib zzibVar, zzil zzilVar) {
        zzibVar.zzh = zzilVar.zzf;
        zzibVar.zzd |= 2;
    }

    public static /* synthetic */ void zzD(zzib zzibVar, zzjf zzjfVar) {
        zzibVar.zzf = zzjfVar;
        zzibVar.zze = 4;
    }

    public static /* synthetic */ void zzE(zzib zzibVar, zzjv zzjvVar) {
        zzibVar.zzf = zzjvVar;
        zzibVar.zze = 3;
    }

    public static /* synthetic */ void zzF(zzib zzibVar, int i) {
        zzibVar.zzg = i - 1;
        zzibVar.zzd |= 1;
    }

    public static zzhz zzc() {
        return (zzhz) zzb.zzl();
    }

    public final zzjf zzA() {
        if (this.zze == 4) {
            return (zzjf) this.zzf;
        }
        return zzjf.zzd();
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzgu(zzb, "\u0004\u0005\u0001\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005᠌\u0001", new Object[]{"zzf", "zze", "zzd", "zzg", zzdp.zza$1, zziz.class, zzjv.class, zzjf.class, "zzh", zzdp.zza$3});
        }
        if (i2 == 3) {
            return new zzib();
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
