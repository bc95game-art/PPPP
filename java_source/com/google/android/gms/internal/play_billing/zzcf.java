package com.google.android.gms.internal.play_billing;

import androidx.navigation.Navigation;
import java.util.Arrays;
import kotlin.LazyKt__LazyJVMKt;
import org.brotli.dec.HuffmanTreeGroup;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public final class zzcf extends zzbw {
    public static final zzcf zza = new zzcf(null, new Object[0], 0);
    public final transient Object[] zzb;
    public final transient Object zzc;
    public final transient int zzd;

    public zzcf(Object obj, Object[] objArr, int i) {
        this.zzc = obj;
        this.zzb = objArr;
        this.zzd = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b3  */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzcf zzg(int i, Object[] objArr, HuffmanTreeGroup huffmanTreeGroup) {
        int i2;
        char c;
        char c2;
        char c3;
        int[] iArr;
        short[] sArr;
        int i3 = i;
        Object[] objArr2 = objArr;
        if (i3 == 0) {
            return zza;
        }
        Object obj = null;
        int i4 = 1;
        if (i3 == 1) {
            Objects.requireNonNull(objArr2[0]);
            Objects.requireNonNull(objArr2[1]);
            return new zzcf(null, objArr2, 1);
        }
        Navigation.zzb(i3, objArr2.length >> 1);
        int max = Math.max(i3, 2);
        if (max < 751619276) {
            i2 = Integer.highestOneBit(max - 1);
            do {
                i2 += i2;
            } while (i2 * 0.7d < max);
        } else {
            i2 = 1073741824;
            if (max >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i3 == 1) {
            Objects.requireNonNull(objArr2[0]);
            Objects.requireNonNull(objArr2[1]);
            i3 = 1;
            c3 = 0;
            c2 = 1;
        } else {
            int i5 = i2 - 1;
            if (i2 <= 128) {
                byte[] bArr = new byte[i2];
                Arrays.fill(bArr, (byte) -1);
                int i6 = 0;
                int i7 = 0;
                while (i6 < i3) {
                    int i8 = i7 + i7;
                    int i9 = i6 + i6;
                    Object obj2 = objArr2[i9];
                    Objects.requireNonNull(obj2);
                    Object obj3 = objArr2[i9 ^ i4];
                    Objects.requireNonNull(obj3);
                    int zza2 = LazyKt__LazyJVMKt.zza(obj2.hashCode());
                    while (true) {
                        int i10 = zza2 & i5;
                        int i11 = bArr[i10] & 255;
                        if (i11 == 255) {
                            bArr[i10] = (byte) i8;
                            if (i7 < i6) {
                                objArr2[i8] = obj2;
                                objArr2[i8 ^ 1] = obj3;
                            }
                            i7++;
                        } else if (obj2.equals(objArr2[i11])) {
                            int i12 = i11 ^ 1;
                            Object obj4 = objArr2[i12];
                            Objects.requireNonNull(obj4);
                            zzbu zzbuVar = new zzbu(obj2, obj3, obj4);
                            objArr2[i12] = obj3;
                            obj = zzbuVar;
                            break;
                        } else {
                            zza2 = i10 + 1;
                        }
                    }
                    i6++;
                    i4 = 1;
                }
                c3 = 0;
                c2 = 1;
                if (i7 == i3) {
                    obj = bArr;
                } else {
                    sArr = new Object[]{bArr, Integer.valueOf(i7), obj};
                    obj = sArr;
                }
            } else {
                c3 = 0;
                c2 = 1;
                if (i2 <= 32768) {
                    sArr = new short[i2];
                    Arrays.fill(sArr, (short) -1);
                    int i13 = 0;
                    for (int i14 = 0; i14 < i3; i14++) {
                        int i15 = i13 + i13;
                        int i16 = i14 + i14;
                        Object obj5 = objArr2[i16];
                        Objects.requireNonNull(obj5);
                        Object obj6 = objArr2[i16 ^ 1];
                        Objects.requireNonNull(obj6);
                        int zza3 = LazyKt__LazyJVMKt.zza(obj5.hashCode());
                        while (true) {
                            int i17 = zza3 & i5;
                            char c4 = (char) sArr[i17];
                            if (c4 == 65535) {
                                sArr[i17] = (short) i15;
                                if (i13 < i14) {
                                    objArr2[i15] = obj5;
                                    objArr2[i15 ^ 1] = obj6;
                                }
                                i13++;
                            } else if (obj5.equals(objArr2[c4])) {
                                int i18 = c4 ^ 1;
                                Object obj7 = objArr2[i18];
                                Objects.requireNonNull(obj7);
                                zzbu zzbuVar2 = new zzbu(obj5, obj6, obj7);
                                objArr2[i18] = obj6;
                                obj = zzbuVar2;
                                break;
                            } else {
                                zza3 = i17 + 1;
                            }
                        }
                    }
                    if (i13 != i3) {
                        obj = new Object[]{sArr, Integer.valueOf(i13), obj};
                    }
                    obj = sArr;
                } else {
                    int[] iArr2 = new int[i2];
                    Arrays.fill(iArr2, -1);
                    int i19 = 0;
                    for (int i20 = 0; i20 < i3; i20++) {
                        int i21 = i19 + i19;
                        int i22 = i20 + i20;
                        Object obj8 = objArr2[i22];
                        Objects.requireNonNull(obj8);
                        Object obj9 = objArr2[i22 ^ 1];
                        Objects.requireNonNull(obj9);
                        int zza4 = LazyKt__LazyJVMKt.zza(obj8.hashCode());
                        while (true) {
                            int i23 = zza4 & i5;
                            int i24 = iArr2[i23];
                            if (i24 == -1) {
                                iArr2[i23] = i21;
                                if (i19 < i20) {
                                    objArr2[i21] = obj8;
                                    objArr2[i21 ^ 1] = obj9;
                                }
                                i19++;
                            } else if (obj8.equals(objArr2[i24])) {
                                int i25 = i24 ^ 1;
                                Object obj10 = objArr2[i25];
                                Objects.requireNonNull(obj10);
                                zzbu zzbuVar3 = new zzbu(obj8, obj9, obj10);
                                objArr2[i25] = obj9;
                                obj = zzbuVar3;
                                break;
                            } else {
                                zza4 = i23 + 1;
                            }
                        }
                    }
                    c = 2;
                    if (i19 == i3) {
                        iArr = iArr2;
                    } else {
                        iArr = new Object[]{iArr2, Integer.valueOf(i19), obj};
                    }
                    if (iArr instanceof Object[]) {
                        Object[] objArr3 = (Object[]) iArr;
                        zzbu zzbuVar4 = (zzbu) objArr3[c];
                        if (huffmanTreeGroup != null) {
                            huffmanTreeGroup.trees = zzbuVar4;
                            Object obj11 = objArr3[c3];
                            int intValue = ((Integer) objArr3[c2]).intValue();
                            objArr2 = Arrays.copyOf(objArr2, intValue + intValue);
                            iArr = obj11;
                            i3 = intValue;
                        } else {
                            throw zzbuVar4.zza();
                        }
                    }
                    return new zzcf(iArr, objArr2, i3);
                }
            }
        }
        c = 2;
        iArr = obj;
        if (iArr instanceof Object[]) {
        }
        return new zzcf(iArr, objArr2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f A[RETURN] */
    @Override // com.google.android.gms.internal.play_billing.zzbw, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Object obj) {
        Object obj2;
        if (obj != null) {
            int i = this.zzd;
            Object[] objArr = this.zzb;
            if (i == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                }
            } else {
                Object obj4 = this.zzc;
                if (obj4 != null) {
                    if (obj4 instanceof byte[]) {
                        byte[] bArr = (byte[]) obj4;
                        int length = bArr.length - 1;
                        int zza2 = LazyKt__LazyJVMKt.zza(obj.hashCode());
                        while (true) {
                            int i2 = zza2 & length;
                            int i3 = bArr[i2] & 255;
                            if (i3 == 255) {
                                break;
                            } else if (obj.equals(objArr[i3])) {
                                obj2 = objArr[i3 ^ 1];
                                break;
                            } else {
                                zza2 = i2 + 1;
                            }
                        }
                    } else if (obj4 instanceof short[]) {
                        short[] sArr = (short[]) obj4;
                        int length2 = sArr.length - 1;
                        int zza3 = LazyKt__LazyJVMKt.zza(obj.hashCode());
                        while (true) {
                            int i4 = zza3 & length2;
                            char c = (char) sArr[i4];
                            if (c == 65535) {
                                break;
                            } else if (obj.equals(objArr[c])) {
                                obj2 = objArr[c ^ 1];
                                break;
                            } else {
                                zza3 = i4 + 1;
                            }
                        }
                    } else {
                        int[] iArr = (int[]) obj4;
                        int length3 = iArr.length - 1;
                        int zza4 = LazyKt__LazyJVMKt.zza(obj.hashCode());
                        while (true) {
                            int i5 = zza4 & length3;
                            int i6 = iArr[i5];
                            if (i6 == -1) {
                                break;
                            } else if (obj.equals(objArr[i6])) {
                                obj2 = objArr[i6 ^ 1];
                                break;
                            } else {
                                zza4 = i5 + 1;
                            }
                        }
                    }
                }
            }
            if (obj2 != null) {
                return null;
            }
            return obj2;
        }
        obj2 = null;
        if (obj2 != null) {
        }
    }

    @Override // java.util.Map
    public final int size() {
        return this.zzd;
    }
}
