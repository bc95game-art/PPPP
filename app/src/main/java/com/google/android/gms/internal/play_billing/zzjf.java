package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzjf extends zzfi {
    private static final zzjf zzb;
    private int zzd;
    private zzfn zze = zzgt.zzb;
    private String zzf = "";
    private boolean zzg;

    static {
        zzjf zzjfVar = new zzjf();
        zzb = zzjfVar;
        zzfi.zzw(zzjf.class, zzjfVar);
    }

    public static /* synthetic */ void zzA(zzjf zzjfVar, boolean z) {
        zzjfVar.zzd |= 2;
        zzjfVar.zzg = z;
    }

    public static zzjf zzd() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzgu(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဇ\u0001", new Object[]{"zzd", "zze", zzjd.class, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzjf();
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
