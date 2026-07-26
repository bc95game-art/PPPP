package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
/* loaded from: classes.dex */
public final class zzgo implements zzgv {
    public static final int[] zza = new int[0];
    public static final Unsafe zzb = zzho.zzg();
    public final int[] zzc;
    public final Object[] zzd;
    public final int zze;
    public final int zzf;
    public final zzds zzg;
    public final int[] zzi;
    public final int zzj;
    public final int zzk;
    public final zza zzl;

    public zzgo(int[] iArr, Object[] objArr, int i, int i2, zzds zzdsVar, int[] iArr2, int i3, int i4, zza zzaVar, zza zzaVar2) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzaVar;
        this.zzg = zzdsVar;
    }

    public static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzfi) {
            return ((zzfi) obj).zzz();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.play_billing.zzgo zzl(com.google.android.gms.internal.play_billing.zzgu r35, com.google.android.gms.internal.play_billing.zza r36, com.google.android.gms.internal.play_billing.zza r37) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzl(com.google.android.gms.internal.play_billing.zzgu, com.google.android.gms.internal.play_billing.zza, com.google.android.gms.internal.play_billing.zza):com.google.android.gms.internal.play_billing.zzgo");
    }

    public static int zzo(long j, Object obj) {
        return ((Integer) zzho.zzf(j, obj)).intValue();
    }

    public static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    public static long zzt(long j, Object obj) {
        return ((Long) zzho.zzf(j, obj)).longValue();
    }

    public static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    public final void zzB(Object obj, int i, Object obj2) {
        if (zzI(i, obj2)) {
            Unsafe unsafe = zzb;
            long zzs = zzs(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzs);
            if (object != null) {
                zzgv zzv = zzv(i);
                if (!zzI(i, obj)) {
                    if (!zzL(object)) {
                        unsafe.putObject(obj, zzs, object);
                    } else {
                        zzfi zze = zzv.zze();
                        zzv.zzg(zze, object);
                        unsafe.putObject(obj, zzs, zze);
                    }
                    zzD(i, obj);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzs);
                if (!zzL(object2)) {
                    zzfi zze2 = zzv.zze();
                    zzv.zzg(zze2, object2);
                    unsafe.putObject(obj, zzs, zze2);
                    object2 = zze2;
                }
                zzv.zzg(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
        }
    }

    public final void zzC(Object obj, int i, Object obj2) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(i2, i, obj2)) {
            Unsafe unsafe = zzb;
            long zzs = zzs(i) & 1048575;
            Object object = unsafe.getObject(obj2, zzs);
            if (object != null) {
                zzgv zzv = zzv(i);
                if (!zzM(i2, i, obj)) {
                    if (!zzL(object)) {
                        unsafe.putObject(obj, zzs, object);
                    } else {
                        zzfi zze = zzv.zze();
                        zzv.zzg(zze, object);
                        unsafe.putObject(obj, zzs, zze);
                    }
                    zzho.zzq(obj, iArr[i + 2] & 1048575, i2);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzs);
                if (!zzL(object2)) {
                    zzfi zze2 = zzv.zze();
                    zzv.zzg(zze2, object2);
                    unsafe.putObject(obj, zzs, zze2);
                    object2 = zze2;
                }
                zzv.zzg(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
        }
    }

    public final void zzD(int i, Object obj) {
        int i2 = this.zzc[i + 2];
        long j = 1048575 & i2;
        if (j != 1048575) {
            zzho.zzq(obj, j, (1 << (i2 >>> 20)) | zzho.zzc(j, obj));
        }
    }

    public final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(i, obj);
    }

    public final void zzG(int i, int i2, Object obj, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzho.zzq(obj, this.zzc[i2 + 2] & 1048575, i);
    }

    public final boolean zzH(zzfi zzfiVar, zzfi zzfiVar2, int i) {
        if (zzI(i, zzfiVar) == zzI(i, zzfiVar2)) {
            return true;
        }
        return false;
    }

    public final boolean zzI(int i, Object obj) {
        int i2 = this.zzc[i + 2];
        long j = i2 & 1048575;
        if (j == 1048575) {
            int zzs = zzs(i);
            long j2 = zzs & 1048575;
            switch (zzr(zzs)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzho.zzf.zza(j2, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(zzho.zzf.zzb(j2, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (zzho.zzd(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (zzho.zzd(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (zzho.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (zzho.zzd(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (zzho.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return zzho.zzf.zzg(j2, obj);
                case 8:
                    Object zzf = zzho.zzf(j2, obj);
                    if (zzf instanceof String) {
                        if (((String) zzf).isEmpty()) {
                            return false;
                        }
                    } else if (!(zzf instanceof zzeg)) {
                        throw new IllegalArgumentException();
                    } else if (zzeg.zzb.equals(zzf)) {
                        return false;
                    }
                    break;
                case 9:
                    if (zzho.zzf(j2, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (zzeg.zzb.equals(zzho.zzf(j2, obj))) {
                        return false;
                    }
                    break;
                case 11:
                    if (zzho.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (zzho.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (zzho.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (zzho.zzd(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (zzho.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (zzho.zzd(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (zzho.zzf(j2, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i2 >>> 20)) & zzho.zzc(j, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(i, obj);
        }
        if ((i3 & i4) != 0) {
            return true;
        }
        return false;
    }

    public final boolean zzM(int i, int i2, Object obj) {
        if (zzho.zzc(this.zzc[i2 + 2] & 1048575, obj) == i) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final int zza(zzds zzdsVar) {
        int i;
        int zzC;
        int zzD;
        int i2;
        int i3;
        int zze;
        int zzC2;
        int size;
        int zzl;
        int zzC3;
        int zzC4;
        int i4;
        int i5;
        int zzC5;
        int zzD2;
        zzgo zzgoVar = this;
        zzds zzdsVar2 = zzdsVar;
        Unsafe unsafe = zzb;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 1048575;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = zzgoVar.zzc;
            if (i7 >= iArr.length) {
                return ((zzfi) zzdsVar).zzc.zza() + i10;
            }
            int zzs = zzgoVar.zzs(i7);
            int zzr = zzr(zzs);
            int i11 = iArr[i7];
            int i12 = iArr[i7 + 2];
            int i13 = i12 & i6;
            if (zzr <= 17) {
                if (i13 != i8) {
                    if (i13 == i6) {
                        i9 = 0;
                    } else {
                        i9 = unsafe.getInt(zzdsVar2, i13);
                    }
                    i8 = i13;
                }
                i = 1 << (i12 >>> 20);
            } else {
                i = 0;
            }
            int i14 = zzs & i6;
            if (zzr >= zzfa.DOUBLE_LIST_PACKED.zzab) {
                zzfa.SINT64_LIST_PACKED.getClass();
            }
            long j = i14;
            switch (zzr) {
                case 0:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 4, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        long j2 = unsafe.getLong(zzdsVar2, j);
                        zzC = zzem.zzC(i11 << 3);
                        zzD = zzem.zzD(j2);
                        i2 = zzD + zzC;
                        i10 += i2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        long j3 = unsafe.getLong(zzdsVar2, j);
                        zzC = zzem.zzC(i11 << 3);
                        zzD = zzem.zzD(j3);
                        i2 = zzD + zzC;
                        i10 += i2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        zzC = zzem.zzC(i11 << 3);
                        zzD = zzem.zzD(unsafe.getInt(zzdsVar2, j));
                        i2 = zzD + zzC;
                        i10 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 4, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 1, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        int i15 = i11 << 3;
                        Object object = unsafe.getObject(zzdsVar2, j);
                        if (object instanceof zzeg) {
                            int zzC6 = zzem.zzC(i15);
                            int zzd = ((zzeg) object).zzd();
                            i10 = ViewModelProvider.Factory.CC.m(zzd, zzd, zzC6, i10);
                            break;
                        } else {
                            zzC = zzem.zzC(i15);
                            zzD = zzem.zzB((String) object);
                            i2 = zzD + zzC;
                            i10 += i2;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        Object object2 = unsafe.getObject(zzdsVar2, j);
                        zzgv zzv = zzgoVar.zzv(i7);
                        zza zzaVar = zzgx.zzb;
                        int zzC7 = zzem.zzC(i11 << 3);
                        int zze2 = ((zzds) object2).zze(zzv);
                        i10 = ViewModelProvider.Factory.CC.m(zze2, zze2, zzC7, i10);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        int zzC8 = zzem.zzC(i11 << 3);
                        int zzd2 = ((zzeg) unsafe.getObject(zzdsVar2, j)).zzd();
                        i10 = ViewModelProvider.Factory.CC.m(zzd2, zzd2, zzC8, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m(unsafe.getInt(zzdsVar2, j), zzem.zzC(i11 << 3), i10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        zzC = zzem.zzC(i11 << 3);
                        zzD = zzem.zzD(unsafe.getInt(zzdsVar2, j));
                        i2 = zzD + zzC;
                        i10 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 4, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        int i16 = unsafe.getInt(zzdsVar2, j);
                        i10 = ViewModelProvider.Factory.CC.m((i16 >> 31) ^ (i16 + i16), zzem.zzC(i11 << 3), i10);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        long j4 = unsafe.getLong(zzdsVar2, j);
                        zzC = zzem.zzC(i11 << 3);
                        zzD = zzem.zzD((j4 >> 63) ^ (j4 + j4));
                        i2 = zzD + zzC;
                        i10 += i2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        zzgv zzv2 = zzgoVar.zzv(i7);
                        int zzC9 = zzem.zzC(i11 << 3);
                        i3 = zzC9 + zzC9;
                        zze = ((zzds) unsafe.getObject(zzdsVar2, j)).zze(zzv2);
                        i2 = zze + i3;
                        i10 += i2;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    i2 = zzgx.zzd(i11, (List) unsafe.getObject(zzdsVar2, j));
                    i10 += i2;
                    break;
                case 19:
                    i2 = zzgx.zzb(i11, (List) unsafe.getObject(zzdsVar2, j));
                    i10 += i2;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(zzdsVar2, j);
                    zza zzaVar2 = zzgx.zzb;
                    if (list.size() != 0) {
                        zzC2 = (zzem.zzC(i11 << 3) * list.size()) + zzgx.zzg(list);
                        i10 += zzC2;
                        break;
                    }
                    zzC2 = 0;
                    i10 += zzC2;
                case 21:
                    List list2 = (List) unsafe.getObject(zzdsVar2, j);
                    zza zzaVar3 = zzgx.zzb;
                    size = list2.size();
                    if (size != 0) {
                        zzl = zzgx.zzl(list2);
                        zzC3 = zzem.zzC(i11 << 3);
                        zzC4 = (zzC3 * size) + zzl;
                        i10 += zzC4;
                        break;
                    }
                    zzC4 = 0;
                    i10 += zzC4;
                case 22:
                    List list3 = (List) unsafe.getObject(zzdsVar2, j);
                    zza zzaVar4 = zzgx.zzb;
                    size = list3.size();
                    if (size != 0) {
                        zzl = zzgx.zzf(list3);
                        zzC3 = zzem.zzC(i11 << 3);
                        zzC4 = (zzC3 * size) + zzl;
                        i10 += zzC4;
                        break;
                    }
                    zzC4 = 0;
                    i10 += zzC4;
                case 23:
                    i2 = zzgx.zzd(i11, (List) unsafe.getObject(zzdsVar2, j));
                    i10 += i2;
                    break;
                case 24:
                    i2 = zzgx.zzb(i11, (List) unsafe.getObject(zzdsVar2, j));
                    i10 += i2;
                    break;
                case 25:
                    zza zzaVar5 = zzgx.zzb;
                    int size2 = ((List) unsafe.getObject(zzdsVar2, j)).size();
                    if (size2 != 0) {
                        zzC2 = (zzem.zzC(i11 << 3) + 1) * size2;
                        i10 += zzC2;
                        break;
                    }
                    zzC2 = 0;
                    i10 += zzC2;
                case 26:
                    List list4 = (List) unsafe.getObject(zzdsVar2, j);
                    zza zzaVar6 = zzgx.zzb;
                    int size3 = list4.size();
                    if (size3 != 0) {
                        zzC4 = zzem.zzC(i11 << 3) * size3;
                        for (int i17 = 0; i17 < size3; i17++) {
                            Object obj = list4.get(i17);
                            if (obj instanceof zzeg) {
                                int zzd3 = ((zzeg) obj).zzd();
                                zzC4 = ViewModelProvider.Factory.CC.m(zzd3, zzd3, zzC4);
                            } else {
                                zzC4 = zzem.zzB((String) obj) + zzC4;
                            }
                        }
                        i10 += zzC4;
                        break;
                    }
                    zzC4 = 0;
                    i10 += zzC4;
                case 27:
                    List list5 = (List) unsafe.getObject(zzdsVar2, j);
                    zzgv zzv3 = zzgoVar.zzv(i7);
                    zza zzaVar7 = zzgx.zzb;
                    int size4 = list5.size();
                    if (size4 == 0) {
                        i4 = 0;
                    } else {
                        i4 = zzem.zzC(i11 << 3) * size4;
                        for (int i18 = 0; i18 < size4; i18++) {
                            int zze3 = ((zzds) list5.get(i18)).zze(zzv3);
                            i4 = ViewModelProvider.Factory.CC.m(zze3, zze3, i4);
                        }
                    }
                    i10 += i4;
                    break;
                case 28:
                    List list6 = (List) unsafe.getObject(zzdsVar2, j);
                    zza zzaVar8 = zzgx.zzb;
                    int size5 = list6.size();
                    if (size5 != 0) {
                        zzC4 = zzem.zzC(i11 << 3) * size5;
                        for (int i19 = 0; i19 < list6.size(); i19++) {
                            int zzd4 = ((zzeg) list6.get(i19)).zzd();
                            zzC4 = ViewModelProvider.Factory.CC.m(zzd4, zzd4, zzC4);
                        }
                        i10 += zzC4;
                        break;
                    }
                    zzC4 = 0;
                    i10 += zzC4;
                case 29:
                    List list7 = (List) unsafe.getObject(zzdsVar2, j);
                    zza zzaVar9 = zzgx.zzb;
                    size = list7.size();
                    if (size != 0) {
                        zzl = zzgx.zzk(list7);
                        zzC3 = zzem.zzC(i11 << 3);
                        zzC4 = (zzC3 * size) + zzl;
                        i10 += zzC4;
                        break;
                    }
                    zzC4 = 0;
                    i10 += zzC4;
                case 30:
                    List list8 = (List) unsafe.getObject(zzdsVar2, j);
                    zza zzaVar10 = zzgx.zzb;
                    size = list8.size();
                    if (size != 0) {
                        zzl = zzgx.zza(list8);
                        zzC3 = zzem.zzC(i11 << 3);
                        zzC4 = (zzC3 * size) + zzl;
                        i10 += zzC4;
                        break;
                    }
                    zzC4 = 0;
                    i10 += zzC4;
                case 31:
                    i2 = zzgx.zzb(i11, (List) unsafe.getObject(zzdsVar2, j));
                    i10 += i2;
                    break;
                case 32:
                    i2 = zzgx.zzd(i11, (List) unsafe.getObject(zzdsVar2, j));
                    i10 += i2;
                    break;
                case 33:
                    List list9 = (List) unsafe.getObject(zzdsVar2, j);
                    zza zzaVar11 = zzgx.zzb;
                    size = list9.size();
                    if (size != 0) {
                        zzl = zzgx.zzi(list9);
                        zzC3 = zzem.zzC(i11 << 3);
                        zzC4 = (zzC3 * size) + zzl;
                        i10 += zzC4;
                        break;
                    }
                    zzC4 = 0;
                    i10 += zzC4;
                case 34:
                    List list10 = (List) unsafe.getObject(zzdsVar2, j);
                    zza zzaVar12 = zzgx.zzb;
                    size = list10.size();
                    if (size != 0) {
                        zzl = zzgx.zzj(list10);
                        zzC3 = zzem.zzC(i11 << 3);
                        zzC4 = (zzC3 * size) + zzl;
                        i10 += zzC4;
                        break;
                    }
                    zzC4 = 0;
                    i10 += zzC4;
                case 35:
                    zza zzaVar13 = zzgx.zzb;
                    int size6 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 8;
                    if (size6 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(size6, zzem.zzC(i11 << 3), size6, i10);
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zza zzaVar14 = zzgx.zzb;
                    int size7 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 4;
                    if (size7 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(size7, zzem.zzC(i11 << 3), size7, i10);
                        break;
                    } else {
                        break;
                    }
                case 37:
                    int zzg = zzgx.zzg((List) unsafe.getObject(zzdsVar2, j));
                    if (zzg > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(zzg, zzem.zzC(i11 << 3), zzg, i10);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int zzl2 = zzgx.zzl((List) unsafe.getObject(zzdsVar2, j));
                    if (zzl2 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(zzl2, zzem.zzC(i11 << 3), zzl2, i10);
                        break;
                    } else {
                        break;
                    }
                case 39:
                    int zzf = zzgx.zzf((List) unsafe.getObject(zzdsVar2, j));
                    if (zzf > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(zzf, zzem.zzC(i11 << 3), zzf, i10);
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zza zzaVar15 = zzgx.zzb;
                    int size8 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 8;
                    if (size8 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(size8, zzem.zzC(i11 << 3), size8, i10);
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zza zzaVar16 = zzgx.zzb;
                    int size9 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 4;
                    if (size9 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(size9, zzem.zzC(i11 << 3), size9, i10);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zza zzaVar17 = zzgx.zzb;
                    int size10 = ((List) unsafe.getObject(zzdsVar2, j)).size();
                    if (size10 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(size10, zzem.zzC(i11 << 3), size10, i10);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int zzk = zzgx.zzk((List) unsafe.getObject(zzdsVar2, j));
                    if (zzk > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(zzk, zzem.zzC(i11 << 3), zzk, i10);
                        break;
                    } else {
                        break;
                    }
                case 44:
                    int zza2 = zzgx.zza((List) unsafe.getObject(zzdsVar2, j));
                    if (zza2 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(zza2, zzem.zzC(i11 << 3), zza2, i10);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zza zzaVar18 = zzgx.zzb;
                    int size11 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 4;
                    if (size11 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(size11, zzem.zzC(i11 << 3), size11, i10);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zza zzaVar19 = zzgx.zzb;
                    int size12 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 8;
                    if (size12 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(size12, zzem.zzC(i11 << 3), size12, i10);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int zzi = zzgx.zzi((List) unsafe.getObject(zzdsVar2, j));
                    if (zzi > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(zzi, zzem.zzC(i11 << 3), zzi, i10);
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int zzj = zzgx.zzj((List) unsafe.getObject(zzdsVar2, j));
                    if (zzj > 0) {
                        i10 = ViewModelProvider.Factory.CC.m(zzj, zzem.zzC(i11 << 3), zzj, i10);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List list11 = (List) unsafe.getObject(zzdsVar2, j);
                    zzgv zzv4 = zzgoVar.zzv(i7);
                    zza zzaVar20 = zzgx.zzb;
                    int size13 = list11.size();
                    if (size13 == 0) {
                        i5 = 0;
                    } else {
                        i5 = 0;
                        for (int i20 = 0; i20 < size13; i20++) {
                            int zzC10 = zzem.zzC(i11 << 3);
                            i5 += ((zzds) list11.get(i20)).zze(zzv4) + zzC10 + zzC10;
                        }
                    }
                    i10 += i5;
                    break;
                case 50:
                    int i21 = i7 / 3;
                    zzgf zzgfVar = (zzgf) unsafe.getObject(zzdsVar2, j);
                    if (zzgoVar.zzd[i21 + i21] != null) {
                        throw new ClassCastException();
                    } else if (!zzgfVar.isEmpty()) {
                        Iterator it = zzgfVar.entrySet().iterator();
                        if (!it.hasNext()) {
                            break;
                        } else {
                            Map.Entry entry = (Map.Entry) it.next();
                            entry.getKey();
                            entry.getValue();
                            throw null;
                        }
                    } else {
                        continue;
                    }
                case 51:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 4, i10);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        long zzt = zzt(j, zzdsVar2);
                        zzC5 = zzem.zzC(i11 << 3);
                        zzD2 = zzem.zzD(zzt);
                        i10 += zzD2 + zzC5;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        long zzt2 = zzt(j, zzdsVar2);
                        zzC5 = zzem.zzC(i11 << 3);
                        zzD2 = zzem.zzD(zzt2);
                        i10 += zzD2 + zzC5;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        zzC5 = zzem.zzC(i11 << 3);
                        zzD2 = zzem.zzD(zzo(j, zzdsVar2));
                        i10 += zzD2 + zzC5;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 4, i10);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 1, i10);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        int i22 = i11 << 3;
                        Object object3 = unsafe.getObject(zzdsVar2, j);
                        if (object3 instanceof zzeg) {
                            int zzC11 = zzem.zzC(i22);
                            int zzd5 = ((zzeg) object3).zzd();
                            i10 = ViewModelProvider.Factory.CC.m(zzd5, zzd5, zzC11, i10);
                            break;
                        } else {
                            zzC5 = zzem.zzC(i22);
                            zzD2 = zzem.zzB((String) object3);
                            i10 += zzD2 + zzC5;
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        Object object4 = unsafe.getObject(zzdsVar2, j);
                        zzgv zzv5 = zzgoVar.zzv(i7);
                        zza zzaVar21 = zzgx.zzb;
                        int zzC12 = zzem.zzC(i11 << 3);
                        int zze4 = ((zzds) object4).zze(zzv5);
                        i10 = ViewModelProvider.Factory.CC.m(zze4, zze4, zzC12, i10);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        int zzC13 = zzem.zzC(i11 << 3);
                        int zzd6 = ((zzeg) unsafe.getObject(zzdsVar2, j)).zzd();
                        i10 = ViewModelProvider.Factory.CC.m(zzd6, zzd6, zzC13, i10);
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m(zzo(j, zzdsVar2), zzem.zzC(i11 << 3), i10);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        zzC5 = zzem.zzC(i11 << 3);
                        zzD2 = zzem.zzD(zzo(j, zzdsVar2));
                        i10 += zzD2 + zzC5;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 4, i10);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        int zzo = zzo(j, zzdsVar2);
                        i10 = ViewModelProvider.Factory.CC.m((zzo >> 31) ^ (zzo + zzo), zzem.zzC(i11 << 3), i10);
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        long zzt3 = zzt(j, zzdsVar2);
                        zzC5 = zzem.zzC(i11 << 3);
                        zzD2 = zzem.zzD((zzt3 >> 63) ^ (zzt3 + zzt3));
                        i10 += zzD2 + zzC5;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        zzgv zzv6 = zzgoVar.zzv(i7);
                        int zzC14 = zzem.zzC(i11 << 3);
                        i3 = zzC14 + zzC14;
                        zze = ((zzds) unsafe.getObject(zzdsVar2, j)).zze(zzv6);
                        i2 = zze + i3;
                        i10 += i2;
                        break;
                    } else {
                        break;
                    }
            }
            i7 += 3;
            zzgoVar = this;
            zzdsVar2 = zzdsVar;
            i6 = 1048575;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d9, code lost:
        if (r2 != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00db, code lost:
        r6 = 1231;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dd, code lost:
        r1 = r6 + r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01eb, code lost:
        if (r2 != false) goto L43;
     */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzb(com.google.android.gms.internal.play_billing.zzfi r11) {
        /*
            Method dump skipped, instructions count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzb(com.google.android.gms.internal.play_billing.zzfi):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x02ac, code lost:
        throw new java.io.IOException("Protocol message had invalid UTF-8.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0305, code lost:
        throw new java.io.IOException("Protocol message had invalid UTF-8.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x036b, code lost:
        throw new java.io.IOException("Protocol message had invalid UTF-8.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x046c, code lost:
        r9 = r10;
        r8 = r11;
        r3 = r12;
        r6 = r15;
        r15 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x04e6, code lost:
        r1 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f1, code lost:
        r3 = r9;
        r9 = r10;
        r8 = r11;
        r6 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0159, code lost:
        r5 = r41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x015b, code lost:
        r3 = r9;
        r9 = r10;
        r8 = r11;
        r6 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x015f, code lost:
        r2 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:601:0x0e59, code lost:
        if (r9 == 1048575) goto L603;
     */
    /* JADX WARN: Code restructure failed: missing block: B:602:0x0e5b, code lost:
        r11.putInt(r12, r9, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:603:0x0e5f, code lost:
        r1 = r37.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:605:0x0e65, code lost:
        if (r1 >= r37.zzk) goto L772;
     */
    /* JADX WARN: Code restructure failed: missing block: B:606:0x0e67, code lost:
        r2 = r37.zzi[r1];
        r3 = r21[r2];
        r3 = com.google.android.gms.internal.play_billing.zzho.zzf(zzs(r2) & 1048575, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:607:0x0e7b, code lost:
        if (r3 != null) goto L608;
     */
    /* JADX WARN: Code restructure failed: missing block: B:609:0x0e82, code lost:
        if (zzu(r2) != null) goto L771;
     */
    /* JADX WARN: Code restructure failed: missing block: B:610:0x0e84, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:611:0x0e87, code lost:
        r3 = (com.google.android.gms.internal.play_billing.zzgf) r3;
        r2 = r2 / 3;
        r17[r2 + r2].getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:612:0x0e96, code lost:
        throw new java.lang.ClassCastException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:614:0x0e99, code lost:
        if (r0 != 0) goto L618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:615:0x0e9b, code lost:
        if (r4 != r5) goto L616;
     */
    /* JADX WARN: Code restructure failed: missing block: B:617:0x0ea3, code lost:
        throw new java.io.IOException("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:618:0x0ea4, code lost:
        if (r4 > r5) goto L621;
     */
    /* JADX WARN: Code restructure failed: missing block: B:619:0x0ea6, code lost:
        if (r15 != r0) goto L621;
     */
    /* JADX WARN: Code restructure failed: missing block: B:620:0x0ea8, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:622:0x0eae, code lost:
        throw new java.io.IOException("Failed to parse the message.");
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x07e0  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x088a  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x0e14 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0e26  */
    /* JADX WARN: Removed duplicated region for block: B:683:0x005d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x025b  */
    /* JADX WARN: Type inference failed for: r4v55, types: [java.util.LinkedHashMap, com.google.android.gms.internal.play_billing.zzgf] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:302:0x07dd -> B:303:0x07de). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:335:0x0887 -> B:336:0x0888). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzc(java.lang.Object r38, byte[] r39, int r40, int r41, int r42, com.google.android.gms.internal.play_billing.zzdw r43) {
        /*
            Method dump skipped, instructions count: 3922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzdw):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final zzfi zze() {
        return (zzfi) ((zzfi) this.zzg).zzb(4);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzfi) {
                zzfi zzfiVar = (zzfi) obj;
                zzfiVar.zzx();
                zzfiVar.zza = 0;
                zzfiVar.zzv();
            }
            int i = 0;
            while (true) {
                int[] iArr = this.zzc;
                if (i < iArr.length) {
                    int zzs = zzs(i);
                    int i2 = 1048575 & zzs;
                    int zzr = zzr(zzs);
                    long j = i2;
                    if (zzr != 9) {
                        if (zzr != 60 && zzr != 68) {
                            switch (zzr) {
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                case 40:
                                case 41:
                                case 42:
                                case 43:
                                case 44:
                                case 45:
                                case 46:
                                case 47:
                                case 48:
                                case 49:
                                    zzdu zzduVar = (zzdu) ((zzfn) zzho.zzf(j, obj));
                                    if (!zzduVar.zza) {
                                        break;
                                    } else {
                                        zzduVar.zza = false;
                                        break;
                                    }
                                case 50:
                                    Unsafe unsafe = zzb;
                                    Object object = unsafe.getObject(obj, j);
                                    if (object == null) {
                                        break;
                                    } else {
                                        ((zzgf) object).zzb = false;
                                        unsafe.putObject(obj, j, object);
                                        break;
                                    }
                            }
                        } else if (zzM(iArr[i], i, obj)) {
                            zzv(i).zzf(zzb.getObject(obj, j));
                        }
                        i += 3;
                    }
                    if (zzI(i, obj)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                    i += 3;
                } else {
                    this.zzl.getClass();
                    zzhi zzhiVar = ((zzfi) obj).zzc;
                    if (zzhiVar.zzf) {
                        zzhiVar.zzf = false;
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzg(Object obj, Object obj2) {
        Object obj3;
        if (zzL(obj)) {
            obj2.getClass();
            int i = 0;
            while (true) {
                int[] iArr = this.zzc;
                if (i < iArr.length) {
                    int zzs = zzs(i);
                    int i2 = zzs & 1048575;
                    int zzr = zzr(zzs);
                    int i3 = iArr[i];
                    long j = i2;
                    switch (zzr) {
                        case 0:
                            if (zzI(i, obj2)) {
                                zzhn zzhnVar = zzho.zzf;
                                obj3 = obj;
                                zzhnVar.zze(obj3, j, zzhnVar.zza(j, obj2));
                                zzD(i, obj3);
                                continue;
                                i += 3;
                                obj = obj3;
                            }
                            break;
                        case 1:
                            if (zzI(i, obj2)) {
                                zzhn zzhnVar2 = zzho.zzf;
                                zzhnVar2.zzf(obj, j, zzhnVar2.zzb(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 2:
                            if (zzI(i, obj2)) {
                                zzho.zzr(obj, j, zzho.zzd(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 3:
                            if (zzI(i, obj2)) {
                                zzho.zzr(obj, j, zzho.zzd(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 4:
                            if (zzI(i, obj2)) {
                                zzho.zzq(obj, j, zzho.zzc(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 5:
                            if (zzI(i, obj2)) {
                                zzho.zzr(obj, j, zzho.zzd(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 6:
                            if (zzI(i, obj2)) {
                                zzho.zzq(obj, j, zzho.zzc(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 7:
                            if (zzI(i, obj2)) {
                                zzhn zzhnVar3 = zzho.zzf;
                                zzhnVar3.zzc(obj, j, zzhnVar3.zzg(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 8:
                            if (zzI(i, obj2)) {
                                zzho.zzs(j, obj, zzho.zzf(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 9:
                            zzB(obj, i, obj2);
                            break;
                        case 10:
                            if (zzI(i, obj2)) {
                                zzho.zzs(j, obj, zzho.zzf(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 11:
                            if (zzI(i, obj2)) {
                                zzho.zzq(obj, j, zzho.zzc(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 12:
                            if (zzI(i, obj2)) {
                                zzho.zzq(obj, j, zzho.zzc(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 13:
                            if (zzI(i, obj2)) {
                                zzho.zzq(obj, j, zzho.zzc(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 14:
                            if (zzI(i, obj2)) {
                                zzho.zzr(obj, j, zzho.zzd(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 15:
                            if (zzI(i, obj2)) {
                                zzho.zzq(obj, j, zzho.zzc(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 16:
                            if (zzI(i, obj2)) {
                                zzho.zzr(obj, j, zzho.zzd(j, obj2));
                                zzD(i, obj);
                                break;
                            }
                            break;
                        case 17:
                            zzB(obj, i, obj2);
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            zzfn zzfnVar = (zzfn) zzho.zzf(j, obj);
                            zzfn zzfnVar2 = (zzfn) zzho.zzf(j, obj2);
                            int size = zzfnVar.size();
                            int size2 = zzfnVar2.size();
                            if (size > 0 && size2 > 0) {
                                if (!((zzdu) zzfnVar).zza) {
                                    zzfnVar = zzfnVar.zzd(size2 + size);
                                }
                                zzfnVar.addAll(zzfnVar2);
                            }
                            if (size > 0) {
                                zzfnVar2 = zzfnVar;
                            }
                            zzho.zzs(j, obj, zzfnVar2);
                            break;
                        case 50:
                            zza zzaVar = zzgx.zzb;
                            zzho.zzs(j, obj, zza.zza(zzho.zzf(j, obj), zzho.zzf(j, obj2)));
                            break;
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                            if (zzM(i3, i, obj2)) {
                                zzho.zzs(j, obj, zzho.zzf(j, obj2));
                                zzho.zzq(obj, iArr[i + 2] & 1048575, i3);
                                break;
                            }
                            break;
                        case 60:
                            zzC(obj, i, obj2);
                            break;
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                            if (zzM(i3, i, obj2)) {
                                zzho.zzs(j, obj, zzho.zzf(j, obj2));
                                zzho.zzq(obj, iArr[i + 2] & 1048575, i3);
                                break;
                            }
                            break;
                        case 68:
                            zzC(obj, i, obj2);
                            break;
                    }
                    obj3 = obj;
                    i += 3;
                    obj = obj3;
                } else {
                    zzgx.zzp(obj, obj2);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdw zzdwVar) {
        zzc(obj, bArr, i, i2, 0, zzdwVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzi(Object obj, zzgd zzgdVar) {
        int i;
        int i2;
        zzgo zzgoVar = this;
        Unsafe unsafe = zzb;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 1048575;
        int i6 = 0;
        while (true) {
            int[] iArr = zzgoVar.zzc;
            if (i4 < iArr.length) {
                int zzs = zzgoVar.zzs(i4);
                int zzr = zzr(zzs);
                int i7 = iArr[i4];
                if (zzr <= 17) {
                    int i8 = iArr[i4 + 2];
                    int i9 = i8 & i3;
                    if (i9 != i5) {
                        if (i9 == i3) {
                            i6 = 0;
                        } else {
                            i6 = unsafe.getInt(obj, i9);
                        }
                        i5 = i9;
                    }
                    i = 1 << (i8 >>> 20);
                } else {
                    i = 0;
                }
                long j = zzs & i3;
                switch (zzr) {
                    case 0:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzi(i7, Double.doubleToRawLongBits(zzho.zzf.zza(j, obj)));
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzg(i7, Float.floatToRawIntBits(zzho.zzf.zzb(j, obj)));
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzw(i7, unsafe.getLong(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzw(i7, unsafe.getLong(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzk(i7, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzi(i7, unsafe.getLong(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzg(i7, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 7:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            byte zzg = zzho.zzf.zzg(j, obj);
                            zzem zzemVar = (zzem) zzgdVar.zzb;
                            zzemVar.zzv(i7 << 3);
                            int i10 = zzemVar.zze;
                            try {
                                int i11 = i10 + 1;
                                try {
                                    zzemVar.zzc[i10] = zzg;
                                    zzemVar.zze = i11;
                                    break;
                                } catch (IndexOutOfBoundsException e) {
                                    e = e;
                                    i10 = i11;
                                    throw new zzen(i10, zzemVar.zzd, 1, e);
                                }
                            } catch (IndexOutOfBoundsException e2) {
                                e = e2;
                            }
                        } else {
                            continue;
                        }
                    case 8:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            Object object = unsafe.getObject(obj, j);
                            if (object instanceof String) {
                                ((zzem) zzgdVar.zzb).zzr(i7, (String) object);
                                break;
                            } else {
                                ((zzem) zzgdVar.zzb).zze(i7, (zzeg) object);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 9:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            zzgdVar.zzv(i7, unsafe.getObject(obj, j), zzgoVar.zzv(i4));
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zze(i7, (zzeg) unsafe.getObject(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzu(i7, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzk(i7, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzg(i7, unsafe.getInt(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            ((zzem) zzgdVar.zzb).zzi(i7, unsafe.getLong(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            int i12 = unsafe.getInt(obj, j);
                            ((zzem) zzgdVar.zzb).zzu(i7, (i12 >> 31) ^ (i12 + i12));
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            long j2 = unsafe.getLong(obj, j);
                            ((zzem) zzgdVar.zzb).zzw(i7, (j2 >> 63) ^ (j2 + j2));
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (zzgoVar.zzJ(obj, i4, i5, i6, i)) {
                            zzgdVar.zzq(i7, unsafe.getObject(obj, j), zzgoVar.zzv(i4));
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        zzgx.zzr(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 19:
                        zzgx.zzv(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 20:
                        zzgx.zzx(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 21:
                        zzgx.zzD(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 22:
                        zzgx.zzw(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 23:
                        zzgx.zzu(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 24:
                        zzgx.zzt(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 25:
                        zzgx.zzq(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 26:
                        int i13 = iArr[i4];
                        List list = (List) unsafe.getObject(obj, j);
                        zza zzaVar = zzgx.zzb;
                        if (list != null && !list.isEmpty()) {
                            zzgdVar.getClass();
                            for (int i14 = 0; i14 < list.size(); i14++) {
                                ((zzem) zzgdVar.zzb).zzr(i13, (String) list.get(i14));
                            }
                            break;
                        }
                        break;
                    case 27:
                        int i15 = iArr[i4];
                        List list2 = (List) unsafe.getObject(obj, j);
                        zzgv zzv = zzgoVar.zzv(i4);
                        zza zzaVar2 = zzgx.zzb;
                        if (list2 != null && !list2.isEmpty()) {
                            for (int i16 = 0; i16 < list2.size(); i16++) {
                                zzgdVar.zzv(i15, list2.get(i16), zzv);
                            }
                            break;
                        }
                        break;
                    case 28:
                        int i17 = iArr[i4];
                        List list3 = (List) unsafe.getObject(obj, j);
                        zza zzaVar3 = zzgx.zzb;
                        if (list3 != null && !list3.isEmpty()) {
                            zzgdVar.getClass();
                            for (int i18 = 0; i18 < list3.size(); i18++) {
                                ((zzem) zzgdVar.zzb).zze(i17, (zzeg) list3.get(i18));
                            }
                            break;
                        }
                        break;
                    case 29:
                        zzgx.zzC(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 30:
                        zzgx.zzs(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 31:
                        zzgx.zzy(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 32:
                        zzgx.zzz(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 33:
                        zzgx.zzA(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 34:
                        zzgx.zzB(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, false);
                        break;
                    case 35:
                        zzgx.zzr(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 36:
                        zzgx.zzv(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 37:
                        zzgx.zzx(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 38:
                        zzgx.zzD(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 39:
                        zzgx.zzw(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 40:
                        zzgx.zzu(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 41:
                        zzgx.zzt(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 42:
                        zzgx.zzq(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 43:
                        zzgx.zzC(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 44:
                        zzgx.zzs(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 45:
                        zzgx.zzy(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 46:
                        zzgx.zzz(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 47:
                        zzgx.zzA(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 48:
                        zzgx.zzB(iArr[i4], (List) unsafe.getObject(obj, j), zzgdVar, true);
                        break;
                    case 49:
                        int i19 = iArr[i4];
                        List list4 = (List) unsafe.getObject(obj, j);
                        zzgv zzv2 = zzgoVar.zzv(i4);
                        zza zzaVar4 = zzgx.zzb;
                        if (list4 != null && !list4.isEmpty()) {
                            for (int i20 = 0; i20 < list4.size(); i20++) {
                                zzgdVar.zzq(i19, list4.get(i20), zzv2);
                            }
                            break;
                        }
                        break;
                    case 50:
                        if (unsafe.getObject(obj, j) == null) {
                            break;
                        } else {
                            int i21 = i4 / 3;
                            zzgoVar.zzd[i21 + i21].getClass();
                            throw new ClassCastException();
                        }
                    case 51:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzi(i7, Double.doubleToRawLongBits(((Double) zzho.zzf(j, obj)).doubleValue()));
                            break;
                        } else {
                            break;
                        }
                    case 52:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzg(i7, Float.floatToRawIntBits(((Float) zzho.zzf(j, obj)).floatValue()));
                            break;
                        } else {
                            break;
                        }
                    case 53:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzw(i7, zzt(j, obj));
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzw(i7, zzt(j, obj));
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzk(i7, zzo(j, obj));
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzi(i7, zzt(j, obj));
                            break;
                        } else {
                            break;
                        }
                    case 57:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzg(i7, zzo(j, obj));
                            break;
                        } else {
                            break;
                        }
                    case 58:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            byte booleanValue = ((Boolean) zzho.zzf(j, obj)).booleanValue();
                            zzem zzemVar2 = (zzem) zzgdVar.zzb;
                            zzemVar2.zzv(i7 << 3);
                            int i22 = zzemVar2.zze;
                            try {
                                i2 = i22 + 1;
                            } catch (IndexOutOfBoundsException e3) {
                                e = e3;
                            }
                            try {
                                zzemVar2.zzc[i22] = booleanValue;
                                zzemVar2.zze = i2;
                                break;
                            } catch (IndexOutOfBoundsException e4) {
                                e = e4;
                                i22 = i2;
                                throw new zzen(i22, zzemVar2.zzd, 1, e);
                            }
                        } else {
                            continue;
                        }
                    case 59:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            Object object2 = unsafe.getObject(obj, j);
                            if (object2 instanceof String) {
                                ((zzem) zzgdVar.zzb).zzr(i7, (String) object2);
                                break;
                            } else {
                                ((zzem) zzgdVar.zzb).zze(i7, (zzeg) object2);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 60:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            zzgdVar.zzv(i7, unsafe.getObject(obj, j), zzgoVar.zzv(i4));
                            break;
                        } else {
                            break;
                        }
                    case 61:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zze(i7, (zzeg) unsafe.getObject(obj, j));
                            break;
                        } else {
                            break;
                        }
                    case 62:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzu(i7, zzo(j, obj));
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzk(i7, zzo(j, obj));
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzg(i7, zzo(j, obj));
                            break;
                        } else {
                            break;
                        }
                    case 65:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            ((zzem) zzgdVar.zzb).zzi(i7, zzt(j, obj));
                            break;
                        } else {
                            break;
                        }
                    case 66:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            int zzo = zzo(j, obj);
                            ((zzem) zzgdVar.zzb).zzu(i7, (zzo >> 31) ^ (zzo + zzo));
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            long zzt = zzt(j, obj);
                            ((zzem) zzgdVar.zzb).zzw(i7, (zzt >> 63) ^ (zzt + zzt));
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (zzgoVar.zzM(i7, i4, obj)) {
                            zzgdVar.zzq(i7, unsafe.getObject(obj, j), zzgoVar.zzv(i4));
                            break;
                        } else {
                            break;
                        }
                }
                i4 += 3;
                i3 = 1048575;
                zzgoVar = this;
            } else {
                ((zzfi) obj).zzc.zzl(zzgdVar);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzj(zzfi zzfiVar, zzfi zzfiVar2) {
        boolean z;
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i < iArr.length) {
                int zzs = zzs(i);
                long j = zzs & 1048575;
                switch (zzr(zzs)) {
                    case 0:
                        if (!zzH(zzfiVar, zzfiVar2, i)) {
                            break;
                        } else {
                            zzhn zzhnVar = zzho.zzf;
                            if (Double.doubleToLongBits(zzhnVar.zza(j, zzfiVar)) != Double.doubleToLongBits(zzhnVar.zza(j, zzfiVar2))) {
                                break;
                            } else {
                                continue;
                                i += 3;
                            }
                        }
                    case 1:
                        if (!zzH(zzfiVar, zzfiVar2, i)) {
                            break;
                        } else {
                            zzhn zzhnVar2 = zzho.zzf;
                            if (Float.floatToIntBits(zzhnVar2.zzb(j, zzfiVar)) != Float.floatToIntBits(zzhnVar2.zzb(j, zzfiVar2))) {
                                break;
                            } else {
                                continue;
                                i += 3;
                            }
                        }
                    case 2:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzd(j, zzfiVar) == zzho.zzd(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 3:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzd(j, zzfiVar) == zzho.zzd(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 4:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzc(j, zzfiVar) == zzho.zzc(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 5:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzd(j, zzfiVar) == zzho.zzd(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 6:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzc(j, zzfiVar) == zzho.zzc(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 7:
                        if (!zzH(zzfiVar, zzfiVar2, i)) {
                            break;
                        } else {
                            zzhn zzhnVar3 = zzho.zzf;
                            if (zzhnVar3.zzg(j, zzfiVar) != zzhnVar3.zzg(j, zzfiVar2)) {
                                break;
                            } else {
                                continue;
                                i += 3;
                            }
                        }
                    case 8:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzgx.zzE(zzho.zzf(j, zzfiVar), zzho.zzf(j, zzfiVar2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 9:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzgx.zzE(zzho.zzf(j, zzfiVar), zzho.zzf(j, zzfiVar2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 10:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzgx.zzE(zzho.zzf(j, zzfiVar), zzho.zzf(j, zzfiVar2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 11:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzc(j, zzfiVar) == zzho.zzc(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 12:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzc(j, zzfiVar) == zzho.zzc(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 13:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzc(j, zzfiVar) == zzho.zzc(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 14:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzd(j, zzfiVar) == zzho.zzd(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 15:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzc(j, zzfiVar) == zzho.zzc(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 16:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzho.zzd(j, zzfiVar) == zzho.zzd(j, zzfiVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 17:
                        if (zzH(zzfiVar, zzfiVar2, i) && zzgx.zzE(zzho.zzf(j, zzfiVar), zzho.zzf(j, zzfiVar2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        z = zzgx.zzE(zzho.zzf(j, zzfiVar), zzho.zzf(j, zzfiVar2));
                        break;
                    case 50:
                        z = zzgx.zzE(zzho.zzf(j, zzfiVar), zzho.zzf(j, zzfiVar2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j2 = iArr[i + 2] & 1048575;
                        if (zzho.zzc(j2, zzfiVar) == zzho.zzc(j2, zzfiVar2) && zzgx.zzE(zzho.zzf(j, zzfiVar), zzho.zzf(j, zzfiVar2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    default:
                        i += 3;
                }
                if (z) {
                    i += 3;
                }
            } else if (zzfiVar.zzc.equals(zzfiVar2.zzc)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (i6 < this.zzj) {
            int i7 = this.zzi[i6];
            int[] iArr = this.zzc;
            int i8 = iArr[i7];
            int zzs = zzs(i7);
            int i9 = iArr[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                if (i10 != 1048575) {
                    i5 = zzb.getInt(obj, i10);
                }
                i3 = i7;
                i = i5;
                i2 = i10;
            } else {
                int i12 = i5;
                i2 = i4;
                i3 = i7;
                i = i12;
            }
            if ((268435456 & zzs) == 0 || zzJ(obj, i3, i2, i, i11)) {
                int zzr = zzr(zzs);
                if (zzr == 9 || zzr == 17) {
                    if (zzJ(obj, i3, i2, i, i11) && !zzv(i3).zzk(zzho.zzf(zzs & 1048575, obj))) {
                    }
                    i6++;
                    i4 = i2;
                    i5 = i;
                } else {
                    if (zzr != 27) {
                        if (zzr == 60 || zzr == 68) {
                            if (zzM(i8, i3, obj) && !zzv(i3).zzk(zzho.zzf(zzs & 1048575, obj))) {
                            }
                        } else if (zzr != 49) {
                            if (zzr == 50 && !((zzgf) zzho.zzf(zzs & 1048575, obj)).isEmpty()) {
                                int i13 = i3 / 3;
                                this.zzd[i13 + i13].getClass();
                                throw new ClassCastException();
                            }
                        }
                        i6++;
                        i4 = i2;
                        i5 = i;
                    }
                    List list = (List) zzho.zzf(zzs & 1048575, obj);
                    if (!list.isEmpty()) {
                        zzgv zzv = zzv(i3);
                        for (int i14 = 0; i14 < list.size(); i14++) {
                            if (zzv.zzk(list.get(i14))) {
                            }
                        }
                        continue;
                    } else {
                        continue;
                    }
                    i6++;
                    i4 = i2;
                    i5 = i;
                }
            }
            return false;
        }
        return true;
    }

    public final int zzq(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final int zzs(int i) {
        return this.zzc[i + 1];
    }

    public final zzfl zzu(int i) {
        int i2 = i / 3;
        return (zzfl) this.zzd[i2 + i2 + 1];
    }

    public final zzgv zzv(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        Object[] objArr = this.zzd;
        zzgv zzgvVar = (zzgv) objArr[i3];
        if (zzgvVar != null) {
            return zzgvVar;
        }
        zzgv zzb2 = zzgs.zzb.zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzb2;
        return zzb2;
    }

    public final Object zzx(int i, Object obj) {
        zzgv zzv = zzv(i);
        int zzs = zzs(i) & 1048575;
        if (!zzI(i, obj)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs);
        if (zzL(object)) {
            return object;
        }
        zzfi zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }

    public final Object zzy(int i, int i2, Object obj) {
        zzgv zzv = zzv(i2);
        if (!zzM(i, i2, obj)) {
            return zzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        zzfi zze = zzv.zze();
        if (object != null) {
            zzv.zzg(zze, object);
        }
        return zze;
    }
}
