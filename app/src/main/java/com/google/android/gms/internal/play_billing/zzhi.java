package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class zzhi {
    public static final zzhi zza = new zzhi(0, new int[0], new Object[0], false);
    public int zzb;
    public int[] zzc;
    public Object[] zzd;
    public int zze = -1;
    public boolean zzf;

    public zzhi(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhi zzf() {
        return new zzhi(0, new int[8], new Object[8], true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhi)) {
            return false;
        }
        zzhi zzhiVar = (zzhi) obj;
        int i = this.zzb;
        if (i == zzhiVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhiVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhiVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int zzC;
        int zzD;
        int zzC2;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.zzd[i3]).getClass();
                    zzC2 = zzem.zzC(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int zzC3 = zzem.zzC(i5 << 3);
                    int zzd = ((zzeg) this.zzd[i3]).zzd();
                    i2 = ViewModelProvider.Factory.CC.m606m(zzd, zzd, zzC3, i2);
                } else if (i6 == 3) {
                    int zzC4 = zzem.zzC(i5 << 3);
                    zzC = zzC4 + zzC4;
                    zzD = ((zzhi) this.zzd[i3]).zza();
                } else if (i6 == 5) {
                    ((Integer) this.zzd[i3]).getClass();
                    zzC2 = zzem.zzC(i5 << 3) + 4;
                } else {
                    throw new IllegalStateException(new zzfp());
                }
                i2 = zzC2 + i2;
            } else {
                int i7 = i5 << 3;
                long longValue = ((Long) this.zzd[i3]).longValue();
                zzC = zzem.zzC(i7);
                zzD = zzem.zzD(longValue);
            }
            i2 = zzD + zzC + i2;
        }
        this.zze = i2;
        return i2;
    }

    public final void zzj(int i, Object obj) {
        if (this.zzf) {
            zzm(this.zzb + 1);
            int[] iArr = this.zzc;
            int i2 = this.zzb;
            iArr[i2] = i;
            this.zzd[i2] = obj;
            this.zzb = i2 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void zzl(zzgd zzgdVar) {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    ((zzem) zzgdVar.zzb).zzw(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    ((zzem) zzgdVar.zzb).zzi(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    ((zzem) zzgdVar.zzb).zze(i4, (zzeg) obj);
                } else if (i3 == 3) {
                    ((zzem) zzgdVar.zzb).zzt(i4, 3);
                    ((zzhi) obj).zzl(zzgdVar);
                    ((zzem) zzgdVar.zzb).zzt(i4, 4);
                } else if (i3 == 5) {
                    ((zzem) zzgdVar.zzb).zzg(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(new zzfp());
                }
            }
        }
    }

    public final void zzm(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }
}
