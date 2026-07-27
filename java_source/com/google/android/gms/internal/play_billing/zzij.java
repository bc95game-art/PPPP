package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzij extends zzfi {
    private static final zzij zzb;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.play_billing.zzfi, com.google.android.gms.internal.play_billing.zzij] */
    static {
        ?? zzfiVar = new zzfi();
        zzb = zzfiVar;
        zzfi.zzw(zzij.class, zzfiVar);
    }

    public static zzij zzd() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfi
    public final Object zzb(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzgu(zzb, "\u0004\u0000", null);
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
