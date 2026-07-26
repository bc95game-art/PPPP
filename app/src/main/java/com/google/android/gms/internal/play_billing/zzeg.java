package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public class zzeg implements Iterable, Serializable {
    public static final zzeg zzb = new zzeg(zzfo.zzb);
    public final byte[] zza;
    public int zza$1 = 0;

    static {
        int i = zzdv.$r8$clinit;
    }

    public zzeg(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    public static int zzh(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(ViewModelProvider.Factory.CC.m(i, i2, "Beginning index larger than ending index: ", ", "));
        } else {
            throw new IndexOutOfBoundsException(ViewModelProvider.Factory.CC.m(i2, i3, "End index: ", " >= "));
        }
    }

    public static zzeg zzj(byte[] bArr, int i, int i2) {
        zzh(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzeg(bArr2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzeg) && zzd() == ((zzeg) obj).zzd()) {
            if (zzd() == 0) {
                return true;
            }
            if (!(obj instanceof zzeg)) {
                return obj.equals(this);
            }
            zzeg zzegVar = (zzeg) obj;
            int i = this.zza$1;
            int i2 = zzegVar.zza$1;
            if (i == 0 || i2 == 0 || i == i2) {
                int zzd = zzd();
                if (zzd > zzegVar.zzd()) {
                    int zzd2 = zzd();
                    throw new IllegalArgumentException("Length too large: " + zzd + zzd2);
                } else if (zzd <= zzegVar.zzd()) {
                    byte[] bArr = zzegVar.zza;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < zzd) {
                        if (this.zza[i3] == bArr[i4]) {
                            i3++;
                            i4++;
                        }
                    }
                    return true;
                } else {
                    throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(zzd, zzegVar.zzd(), "Ran off end of other: 0, ", ", "));
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza$1;
        if (i != 0) {
            return i;
        }
        int zzd = zzd();
        int i2 = zzd;
        for (int i3 = 0; i3 < zzd; i3++) {
            i2 = (i2 * 31) + this.zza[i3];
        }
        if (i2 == 0) {
            i2 = 1;
        }
        this.zza$1 = i2;
        return i2;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzea(this);
    }

    public final String toString() {
        String str;
        zzeg zzegVar;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int zzd = zzd();
        if (zzd() <= 50) {
            str = LazyKt__LazyJVMKt.zza(this);
        } else {
            int zzh = zzh(0, 47, zzd());
            if (zzh == 0) {
                zzegVar = zzb;
            } else {
                zzegVar = new zzec(this.zza, zzh);
            }
            str = LazyKt__LazyJVMKt.zza(zzegVar).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(zzd);
        sb.append(" contents=\"");
        return ViewModelProvider.Factory.CC.m(sb, str, "\">");
    }

    public byte zza(int i) {
        return this.zza[i];
    }

    public byte zzb(int i) {
        return this.zza[i];
    }

    public int zzd() {
        return this.zza.length;
    }
}
