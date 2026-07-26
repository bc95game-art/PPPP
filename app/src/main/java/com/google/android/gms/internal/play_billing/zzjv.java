package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzjv extends zzfi {
    private static final zzjv zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private long zzg;
    private boolean zzh;
    private int zzi;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.play_billing.zzfi, com.google.android.gms.internal.play_billing.zzjv] */
    static {
        ?? zzfiVar = new zzfi();
        zzb = zzfiVar;
        zzfi.zzw(zzjv.class, zzfiVar);
    }

    public static /* synthetic */ void zzA(zzjv zzjvVar, boolean z) {
        zzjvVar.zzd |= 8;
        zzjvVar.zzh = z;
    }

    public static /* synthetic */ void zzB(zzjv zzjvVar) {
        zzjvVar.zzd |= 16;
        zzjvVar.zzi = 0;
    }

    public static /* synthetic */ void zzC(zzjv zzjvVar, long j) {
        zzjvVar.zzd |= 4;
        zzjvVar.zzg = j;
    }

    public static /* synthetic */ void zzD(zzjv zzjvVar) {
        zzjvVar.zzd |= 2;
        zzjvVar.zzf = true;
    }

    public static zzjt zzc() {
        return (zzjt) zzb.zzl();
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzgu(zzb, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0004ဇ\u0003\u0005င\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzfi();
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
