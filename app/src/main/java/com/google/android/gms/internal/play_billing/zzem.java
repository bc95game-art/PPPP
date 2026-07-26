package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class zzem extends LazyKt__LazyJVMKt {
    public static final Logger zzc$1 = Logger.getLogger(zzem.class.getName());
    public static final boolean zzd$1 = zzho.zzh;
    public zzgd zza;
    public final byte[] zzc;
    public final int zzd;
    public int zze;

    public zzem(byte[] bArr, int i) {
        int length = bArr.length;
        if (((length - i) | i) >= 0) {
            this.zzc = bArr;
            this.zze = 0;
            this.zzd = i;
            return;
        }
        Locale locale = Locale.US;
        throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(length, i, "Array range is invalid. Buffer.length=", ", offset=0, length="));
    }

    public static int zzB(String str) {
        int i;
        try {
            i = zzhr.zzc(str);
        } catch (zzhq unused) {
            i = str.getBytes(zzfo.zza).length;
        }
        return zzC(i) + i;
    }

    public static int zzC(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzD(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public final void zzc(byte[] bArr, int i) {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i);
            this.zze += i;
        } catch (IndexOutOfBoundsException e) {
            throw new zzen(this.zze, this.zzd, i, e);
        }
    }

    public final void zze(int i, zzeg zzegVar) {
        zzv((i << 3) | 2);
        zzv(zzegVar.zzd());
        zzc(zzegVar.zza, zzegVar.zzd());
    }

    public final void zzg(int i, int i2) {
        zzv((i << 3) | 5);
        zzh(i2);
    }

    public final void zzh(int i) {
        int i2 = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.zze = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzen(i2, this.zzd, 4, e);
        }
    }

    public final void zzi(int i, long j) {
        zzv((i << 3) | 1);
        zzj(j);
    }

    public final void zzj(long j) {
        int i = this.zze;
        try {
            byte[] bArr = this.zzc;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.zze = i + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzen(i, this.zzd, 8, e);
        }
    }

    public final void zzk(int i, int i2) {
        zzv(i << 3);
        zzl(i2);
    }

    public final void zzl(int i) {
        if (i >= 0) {
            zzv(i);
        } else {
            zzx(i);
        }
    }

    public final void zzr(int i, String str) {
        zzv((i << 3) | 2);
        int i2 = this.zze;
        try {
            int zzC = zzC(str.length() * 3);
            int zzC2 = zzC(str.length());
            int i3 = this.zzd;
            byte[] bArr = this.zzc;
            if (zzC2 == zzC) {
                int i4 = i2 + zzC2;
                this.zze = i4;
                int zzb = zzhr.zzb(str, bArr, i4, i3 - i4);
                this.zze = i2;
                zzv((zzb - i2) - zzC2);
                this.zze = zzb;
                return;
            }
            zzv(zzhr.zzc(str));
            int i5 = this.zze;
            this.zze = zzhr.zzb(str, bArr, i5, i3 - i5);
        } catch (zzhq e) {
            this.zze = i2;
            zzc$1.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e);
            byte[] bytes = str.getBytes(zzfo.zza);
            try {
                int length = bytes.length;
                zzv(length);
                zzc(bytes, length);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzen(e2);
            }
        } catch (IndexOutOfBoundsException e3) {
            throw new zzen(e3);
        }
    }

    public final void zzt(int i, int i2) {
        zzv((i << 3) | i2);
    }

    public final void zzu(int i, int i2) {
        zzv(i << 3);
        zzv(i2);
    }

    public final void zzv(int i) {
        int i2;
        int i3 = this.zze;
        while (true) {
            int i4 = i & (-128);
            byte[] bArr = this.zzc;
            if (i4 == 0) {
                i2 = i3 + 1;
                bArr[i3] = (byte) i;
                this.zze = i2;
                return;
            }
            i2 = i3 + 1;
            try {
                bArr[i3] = (byte) (i | 128);
                i >>>= 7;
                i3 = i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzen(i2, this.zzd, 1, e);
            }
            throw new zzen(i2, this.zzd, 1, e);
        }
    }

    public final void zzw(int i, long j) {
        zzv(i << 3);
        zzx(j);
    }

    public final void zzx(long j) {
        int i;
        int i2 = this.zze;
        boolean z = zzd$1;
        int i3 = this.zzd;
        byte[] bArr = this.zzc;
        if (!z || i3 - i2 < 10) {
            long j2 = j;
            while ((j2 & (-128)) != 0) {
                i = i2 + 1;
                try {
                    bArr[i2] = (byte) (((int) j2) | 128);
                    j2 >>>= 7;
                    i2 = i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzen(i, i3, 1, e);
                }
            }
            i = i2 + 1;
            bArr[i2] = (byte) j2;
        } else {
            long j3 = j;
            while ((j3 & (-128)) != 0) {
                zzho.zzf.zzd(bArr, zzho.zza + i2, (byte) (((int) j3) | 128));
                j3 >>>= 7;
                i2++;
            }
            i = i2 + 1;
            zzho.zzf.zzd(bArr, zzho.zza + i2, (byte) j3);
        }
        this.zze = i;
    }
}
