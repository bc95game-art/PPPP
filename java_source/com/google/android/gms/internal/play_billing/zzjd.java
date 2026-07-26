package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzjd extends zzfi {
    private static final zzjd zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzjd zzjdVar = new zzjd();
        zzb = zzjdVar;
        zzfi.zzw(zzjd.class, zzjdVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzgu(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzdp.zza$6, "zzf"});
        }
        if (i2 == 3) {
            return new zzjd();
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
