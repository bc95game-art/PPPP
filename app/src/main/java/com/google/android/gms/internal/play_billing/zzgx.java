package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public abstract class zzgx {
    public static final zza zzb = new zza(7);

    static {
        zzgs zzgsVar = zzgs.zzb;
    }

    public static void zzA(int i, List list, zzgd zzgdVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (list instanceof zzfj) {
                zzfj zzfjVar = (zzfj) list;
                if (z) {
                    zzemVar.zzt(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < zzfjVar.zzd; i4++) {
                        int zze = zzfjVar.zze(i4);
                        i3 += zzem.zzC((zze >> 31) ^ (zze + zze));
                    }
                    zzemVar.zzv(i3);
                    while (i2 < zzfjVar.zzd) {
                        int zze2 = zzfjVar.zze(i2);
                        zzemVar.zzv((zze2 >> 31) ^ (zze2 + zze2));
                        i2++;
                    }
                    return;
                }
                while (i2 < zzfjVar.zzd) {
                    int zze3 = zzfjVar.zze(i2);
                    zzemVar.zzu(i, (zze3 >> 31) ^ (zze3 + zze3));
                    i2++;
                }
            } else if (z) {
                zzemVar.zzt(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    int intValue = ((Integer) list.get(i6)).intValue();
                    i5 += zzem.zzC((intValue >> 31) ^ (intValue + intValue));
                }
                zzemVar.zzv(i5);
                while (i2 < list.size()) {
                    int intValue2 = ((Integer) list.get(i2)).intValue();
                    zzemVar.zzv((intValue2 >> 31) ^ (intValue2 + intValue2));
                    i2++;
                }
            } else {
                while (i2 < list.size()) {
                    int intValue3 = ((Integer) list.get(i2)).intValue();
                    zzemVar.zzu(i, (intValue3 >> 31) ^ (intValue3 + intValue3));
                    i2++;
                }
            }
        }
    }

    public static void zzB(int i, List list, zzgd zzgdVar, boolean z) {
        if (!(list == null || list.isEmpty())) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (z) {
                zzemVar.zzt(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    long longValue = ((Long) list.get(i4)).longValue();
                    i3 += zzem.zzD((longValue >> 63) ^ (longValue + longValue));
                }
                zzemVar.zzv(i3);
                while (i2 < list.size()) {
                    long longValue2 = ((Long) list.get(i2)).longValue();
                    zzemVar.zzx((longValue2 >> 63) ^ (longValue2 + longValue2));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                long longValue3 = ((Long) list.get(i2)).longValue();
                zzemVar.zzw(i, (longValue3 >> 63) ^ (longValue3 + longValue3));
                i2++;
            }
        }
    }

    public static void zzC(int i, List list, zzgd zzgdVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (list instanceof zzfj) {
                zzfj zzfjVar = (zzfj) list;
                if (z) {
                    zzemVar.zzt(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < zzfjVar.zzd; i4++) {
                        i3 += zzem.zzC(zzfjVar.zze(i4));
                    }
                    zzemVar.zzv(i3);
                    while (i2 < zzfjVar.zzd) {
                        zzemVar.zzv(zzfjVar.zze(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < zzfjVar.zzd) {
                    zzemVar.zzu(i, zzfjVar.zze(i2));
                    i2++;
                }
            } else if (z) {
                zzemVar.zzt(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    i5 += zzem.zzC(((Integer) list.get(i6)).intValue());
                }
                zzemVar.zzv(i5);
                while (i2 < list.size()) {
                    zzemVar.zzv(((Integer) list.get(i2)).intValue());
                    i2++;
                }
            } else {
                while (i2 < list.size()) {
                    zzemVar.zzu(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
            }
        }
    }

    public static void zzD(int i, List list, zzgd zzgdVar, boolean z) {
        if (!(list == null || list.isEmpty())) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (z) {
                zzemVar.zzt(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzem.zzD(((Long) list.get(i4)).longValue());
                }
                zzemVar.zzv(i3);
                while (i2 < list.size()) {
                    zzemVar.zzx(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzemVar.zzw(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public static boolean zzE(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfj) {
            zzfj zzfjVar = (zzfj) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzem.zzD(zzfjVar.zze(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzem.zzD(((Integer) list.get(i)).intValue());
            i++;
        }
        return i3;
    }

    public static int zzb(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzem.zzC(i << 3) + 4) * size;
    }

    public static int zzd(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzem.zzC(i << 3) + 8) * size;
    }

    public static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfj) {
            zzfj zzfjVar = (zzfj) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzem.zzD(zzfjVar.zze(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzem.zzD(((Integer) list.get(i)).intValue());
            i++;
        }
        return i3;
    }

    public static int zzg(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += zzem.zzD(((Long) list.get(i2)).longValue());
        }
        return i;
    }

    public static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfj) {
            zzfj zzfjVar = (zzfj) list;
            int i2 = 0;
            while (i < size) {
                int zze = zzfjVar.zze(i);
                i2 += zzem.zzC((zze >> 31) ^ (zze + zze));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            int intValue = ((Integer) list.get(i)).intValue();
            i3 += zzem.zzC((intValue >> 31) ^ (intValue + intValue));
            i++;
        }
        return i3;
    }

    public static int zzj(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            long longValue = ((Long) list.get(i2)).longValue();
            i += zzem.zzD((longValue >> 63) ^ (longValue + longValue));
        }
        return i;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfj) {
            zzfj zzfjVar = (zzfj) list;
            int i2 = 0;
            while (i < size) {
                i2 += zzem.zzC(zzfjVar.zze(i));
                i++;
            }
            return i2;
        }
        int i3 = 0;
        while (i < size) {
            i3 += zzem.zzC(((Integer) list.get(i)).intValue());
            i++;
        }
        return i3;
    }

    public static int zzl(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += zzem.zzD(((Long) list.get(i2)).longValue());
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r5 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object zzn(Object obj, int i, int i2, Object obj2, zza zzaVar) {
        zzhi zzhiVar;
        if (obj2 == null) {
            zzaVar.getClass();
            zzfi zzfiVar = (zzfi) obj;
            zzhi zzhiVar2 = zzfiVar.zzc;
            zzhiVar = zzhiVar2;
            if (zzhiVar2 == zzhi.zza) {
                zzhi zzf = zzhi.zzf();
                zzfiVar.zzc = zzf;
                zzhiVar = zzf;
            }
        }
        ((zzhi) zzhiVar).zzj(i << 3, Long.valueOf(i2));
        return zzhiVar;
    }

    public static void zzp(Object obj, Object obj2) {
        zzfi zzfiVar = (zzfi) obj;
        zzhi zzhiVar = zzfiVar.zzc;
        zzhi zzhiVar2 = ((zzfi) obj2).zzc;
        zzhi zzhiVar3 = zzhi.zza;
        if (!zzhiVar3.equals(zzhiVar2)) {
            if (zzhiVar3.equals(zzhiVar)) {
                int i = zzhiVar.zzb + zzhiVar2.zzb;
                int[] copyOf = Arrays.copyOf(zzhiVar.zzc, i);
                System.arraycopy(zzhiVar2.zzc, 0, copyOf, zzhiVar.zzb, zzhiVar2.zzb);
                Object[] copyOf2 = Arrays.copyOf(zzhiVar.zzd, i);
                System.arraycopy(zzhiVar2.zzd, 0, copyOf2, zzhiVar.zzb, zzhiVar2.zzb);
                zzhiVar = new zzhi(i, copyOf, copyOf2, true);
            } else {
                zzhiVar.getClass();
                if (!zzhiVar2.equals(zzhiVar3)) {
                    if (zzhiVar.zzf) {
                        int i2 = zzhiVar.zzb + zzhiVar2.zzb;
                        zzhiVar.zzm(i2);
                        System.arraycopy(zzhiVar2.zzc, 0, zzhiVar.zzc, zzhiVar.zzb, zzhiVar2.zzb);
                        System.arraycopy(zzhiVar2.zzd, 0, zzhiVar.zzd, zzhiVar.zzb, zzhiVar2.zzb);
                        zzhiVar.zzb = i2;
                    } else {
                        throw new UnsupportedOperationException();
                    }
                }
            }
        }
        zzfiVar.zzc = zzhiVar;
    }

    public static void zzq(int i, List list, zzgd zzgdVar, boolean z) {
        if (!(list == null || list.isEmpty())) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (z) {
                zzemVar.zzt(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Boolean) list.get(i4)).getClass();
                    i3++;
                }
                zzemVar.zzv(i3);
                while (i2 < list.size()) {
                    byte booleanValue = ((Boolean) list.get(i2)).booleanValue();
                    int i5 = zzemVar.zze;
                    try {
                        int i6 = i5 + 1;
                        try {
                            zzemVar.zzc[i5] = booleanValue;
                            zzemVar.zze = i6;
                            i2++;
                        } catch (IndexOutOfBoundsException e) {
                            e = e;
                            i5 = i6;
                            throw new zzen(i5, zzemVar.zzd, 1, e);
                        }
                    } catch (IndexOutOfBoundsException e2) {
                        e = e2;
                    }
                }
                return;
            }
            while (i2 < list.size()) {
                byte booleanValue2 = ((Boolean) list.get(i2)).booleanValue();
                zzemVar.zzv(i << 3);
                int i7 = zzemVar.zze;
                try {
                    int i8 = i7 + 1;
                    try {
                        zzemVar.zzc[i7] = booleanValue2;
                        zzemVar.zze = i8;
                        i2++;
                    } catch (IndexOutOfBoundsException e3) {
                        e = e3;
                        i7 = i8;
                        throw new zzen(i7, zzemVar.zzd, 1, e);
                    }
                } catch (IndexOutOfBoundsException e4) {
                    e = e4;
                }
            }
        }
    }

    public static void zzr(int i, List list, zzgd zzgdVar, boolean z) {
        if (!(list == null || list.isEmpty())) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (z) {
                zzemVar.zzt(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Double) list.get(i4)).getClass();
                    i3 += 8;
                }
                zzemVar.zzv(i3);
                while (i2 < list.size()) {
                    zzemVar.zzj(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzemVar.zzi(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
        }
    }

    public static void zzs(int i, List list, zzgd zzgdVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (list instanceof zzfj) {
                zzfj zzfjVar = (zzfj) list;
                if (z) {
                    zzemVar.zzt(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < zzfjVar.zzd; i4++) {
                        i3 += zzem.zzD(zzfjVar.zze(i4));
                    }
                    zzemVar.zzv(i3);
                    while (i2 < zzfjVar.zzd) {
                        zzemVar.zzl(zzfjVar.zze(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < zzfjVar.zzd) {
                    zzemVar.zzk(i, zzfjVar.zze(i2));
                    i2++;
                }
            } else if (z) {
                zzemVar.zzt(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    i5 += zzem.zzD(((Integer) list.get(i6)).intValue());
                }
                zzemVar.zzv(i5);
                while (i2 < list.size()) {
                    zzemVar.zzl(((Integer) list.get(i2)).intValue());
                    i2++;
                }
            } else {
                while (i2 < list.size()) {
                    zzemVar.zzk(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
            }
        }
    }

    public static void zzt(int i, List list, zzgd zzgdVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (list instanceof zzfj) {
                zzfj zzfjVar = (zzfj) list;
                if (z) {
                    zzemVar.zzt(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < zzfjVar.zzd; i4++) {
                        zzfjVar.zze(i4);
                        i3 += 4;
                    }
                    zzemVar.zzv(i3);
                    while (i2 < zzfjVar.zzd) {
                        zzemVar.zzh(zzfjVar.zze(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < zzfjVar.zzd) {
                    zzemVar.zzg(i, zzfjVar.zze(i2));
                    i2++;
                }
            } else if (z) {
                zzemVar.zzt(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    ((Integer) list.get(i6)).getClass();
                    i5 += 4;
                }
                zzemVar.zzv(i5);
                while (i2 < list.size()) {
                    zzemVar.zzh(((Integer) list.get(i2)).intValue());
                    i2++;
                }
            } else {
                while (i2 < list.size()) {
                    zzemVar.zzg(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
            }
        }
    }

    public static void zzu(int i, List list, zzgd zzgdVar, boolean z) {
        if (!(list == null || list.isEmpty())) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (z) {
                zzemVar.zzt(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Long) list.get(i4)).getClass();
                    i3 += 8;
                }
                zzemVar.zzv(i3);
                while (i2 < list.size()) {
                    zzemVar.zzj(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzemVar.zzi(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public static void zzv(int i, List list, zzgd zzgdVar, boolean z) {
        if (!(list == null || list.isEmpty())) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (z) {
                zzemVar.zzt(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Float) list.get(i4)).getClass();
                    i3 += 4;
                }
                zzemVar.zzv(i3);
                while (i2 < list.size()) {
                    zzemVar.zzh(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzemVar.zzg(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
        }
    }

    public static void zzw(int i, List list, zzgd zzgdVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (list instanceof zzfj) {
                zzfj zzfjVar = (zzfj) list;
                if (z) {
                    zzemVar.zzt(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < zzfjVar.zzd; i4++) {
                        i3 += zzem.zzD(zzfjVar.zze(i4));
                    }
                    zzemVar.zzv(i3);
                    while (i2 < zzfjVar.zzd) {
                        zzemVar.zzl(zzfjVar.zze(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < zzfjVar.zzd) {
                    zzemVar.zzk(i, zzfjVar.zze(i2));
                    i2++;
                }
            } else if (z) {
                zzemVar.zzt(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    i5 += zzem.zzD(((Integer) list.get(i6)).intValue());
                }
                zzemVar.zzv(i5);
                while (i2 < list.size()) {
                    zzemVar.zzl(((Integer) list.get(i2)).intValue());
                    i2++;
                }
            } else {
                while (i2 < list.size()) {
                    zzemVar.zzk(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
            }
        }
    }

    public static void zzx(int i, List list, zzgd zzgdVar, boolean z) {
        if (!(list == null || list.isEmpty())) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (z) {
                zzemVar.zzt(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += zzem.zzD(((Long) list.get(i4)).longValue());
                }
                zzemVar.zzv(i3);
                while (i2 < list.size()) {
                    zzemVar.zzx(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzemVar.zzw(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }

    public static void zzy(int i, List list, zzgd zzgdVar, boolean z) {
        if (list != null && !list.isEmpty()) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (list instanceof zzfj) {
                zzfj zzfjVar = (zzfj) list;
                if (z) {
                    zzemVar.zzt(i, 2);
                    int i3 = 0;
                    for (int i4 = 0; i4 < zzfjVar.zzd; i4++) {
                        zzfjVar.zze(i4);
                        i3 += 4;
                    }
                    zzemVar.zzv(i3);
                    while (i2 < zzfjVar.zzd) {
                        zzemVar.zzh(zzfjVar.zze(i2));
                        i2++;
                    }
                    return;
                }
                while (i2 < zzfjVar.zzd) {
                    zzemVar.zzg(i, zzfjVar.zze(i2));
                    i2++;
                }
            } else if (z) {
                zzemVar.zzt(i, 2);
                int i5 = 0;
                for (int i6 = 0; i6 < list.size(); i6++) {
                    ((Integer) list.get(i6)).getClass();
                    i5 += 4;
                }
                zzemVar.zzv(i5);
                while (i2 < list.size()) {
                    zzemVar.zzh(((Integer) list.get(i2)).intValue());
                    i2++;
                }
            } else {
                while (i2 < list.size()) {
                    zzemVar.zzg(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
            }
        }
    }

    public static void zzz(int i, List list, zzgd zzgdVar, boolean z) {
        if (!(list == null || list.isEmpty())) {
            zzem zzemVar = (zzem) zzgdVar.zzb;
            int i2 = 0;
            if (z) {
                zzemVar.zzt(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ((Long) list.get(i4)).getClass();
                    i3 += 8;
                }
                zzemVar.zzv(i3);
                while (i2 < list.size()) {
                    zzemVar.zzj(((Long) list.get(i2)).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                zzemVar.zzi(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
        }
    }
}
