package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzgu {
    public final zzds zza;
    public final String zzb;
    public final Object[] zzc;
    public final int zzd;

    public zzgu(zzds zzdsVar, String str, Object[] objArr) {
        this.zza = zzdsVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                i |= (charAt2 & 8191) << i3;
                i3 += 13;
                i2 = i4;
            } else {
                this.zzd = i | (charAt2 << i3);
                return;
            }
        }
    }

    public final int zzc() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }
}
