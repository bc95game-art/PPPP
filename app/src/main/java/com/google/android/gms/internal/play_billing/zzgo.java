package com.google.android.gms.internal.play_billing;

import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.fragments.LogviewFragment;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.LazyKt__LazyJVMKt;
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
    */
    public static zzgo zzl(zzgu zzguVar, zza zzaVar, zza zzaVar2) {
        int i;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        Object[] objArr;
        int i13;
        int i14;
        Class<?> cls;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int objectFieldOffset;
        int i20;
        Field field;
        char charAt;
        int i21;
        int i22;
        int i23;
        Object obj;
        Field field2;
        Object obj2;
        Field field3;
        int i24;
        int i25;
        char charAt2;
        int i26;
        char charAt3;
        int i27;
        char charAt4;
        int i28;
        char charAt5;
        int i29;
        char charAt6;
        int i30;
        char charAt7;
        int i31;
        char charAt8;
        int i32;
        char charAt9;
        int i33;
        char charAt10;
        int i34;
        char charAt11;
        int i35;
        char charAt12;
        int i36;
        char charAt13;
        if (zzguVar instanceof zzgu) {
            String str = zzguVar.zzb;
            int length = str.length();
            int i37 = 55296;
            if (str.charAt(0) >= 55296) {
                int i38 = 1;
                while (true) {
                    i = i38 + 1;
                    if (str.charAt(i38) < 55296) {
                        break;
                    }
                    i38 = i;
                }
            } else {
                i = 1;
            }
            int i39 = i + 1;
            int charAt14 = str.charAt(i);
            if (charAt14 >= 55296) {
                int i40 = charAt14 & 8191;
                int i41 = 13;
                while (true) {
                    i36 = i39 + 1;
                    charAt13 = str.charAt(i39);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i40 |= (charAt13 & 8191) << i41;
                    i41 += 13;
                    i39 = i36;
                }
                charAt14 = i40 | (charAt13 << i41);
                i39 = i36;
            }
            if (charAt14 == 0) {
                iArr = zza;
                i8 = 0;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                int i42 = i39 + 1;
                int charAt15 = str.charAt(i39);
                if (charAt15 >= 55296) {
                    int i43 = charAt15 & 8191;
                    int i44 = 13;
                    while (true) {
                        i35 = i42 + 1;
                        charAt12 = str.charAt(i42);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i43 |= (charAt12 & 8191) << i44;
                        i44 += 13;
                        i42 = i35;
                    }
                    charAt15 = i43 | (charAt12 << i44);
                    i42 = i35;
                }
                int i45 = i42 + 1;
                int charAt16 = str.charAt(i42);
                if (charAt16 >= 55296) {
                    int i46 = charAt16 & 8191;
                    int i47 = 13;
                    while (true) {
                        i34 = i45 + 1;
                        charAt11 = str.charAt(i45);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i46 |= (charAt11 & 8191) << i47;
                        i47 += 13;
                        i45 = i34;
                    }
                    charAt16 = i46 | (charAt11 << i47);
                    i45 = i34;
                }
                int i48 = i45 + 1;
                int charAt17 = str.charAt(i45);
                if (charAt17 >= 55296) {
                    int i49 = charAt17 & 8191;
                    int i50 = 13;
                    while (true) {
                        i33 = i48 + 1;
                        charAt10 = str.charAt(i48);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i49 |= (charAt10 & 8191) << i50;
                        i50 += 13;
                        i48 = i33;
                    }
                    charAt17 = i49 | (charAt10 << i50);
                    i48 = i33;
                }
                int i51 = i48 + 1;
                int charAt18 = str.charAt(i48);
                if (charAt18 >= 55296) {
                    int i52 = charAt18 & 8191;
                    int i53 = 13;
                    while (true) {
                        i32 = i51 + 1;
                        charAt9 = str.charAt(i51);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i52 |= (charAt9 & 8191) << i53;
                        i53 += 13;
                        i51 = i32;
                    }
                    charAt18 = i52 | (charAt9 << i53);
                    i51 = i32;
                }
                int i54 = i51 + 1;
                i5 = str.charAt(i51);
                if (i5 >= 55296) {
                    int i55 = i5 & 8191;
                    int i56 = 13;
                    while (true) {
                        i31 = i54 + 1;
                        charAt8 = str.charAt(i54);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i55 |= (charAt8 & 8191) << i56;
                        i56 += 13;
                        i54 = i31;
                    }
                    i5 = i55 | (charAt8 << i56);
                    i54 = i31;
                }
                int i57 = i54 + 1;
                int charAt19 = str.charAt(i54);
                if (charAt19 >= 55296) {
                    int i58 = charAt19 & 8191;
                    int i59 = 13;
                    while (true) {
                        i30 = i57 + 1;
                        charAt7 = str.charAt(i57);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i58 |= (charAt7 & 8191) << i59;
                        i59 += 13;
                        i57 = i30;
                    }
                    charAt19 = i58 | (charAt7 << i59);
                    i57 = i30;
                }
                int i60 = i57 + 1;
                int charAt20 = str.charAt(i57);
                if (charAt20 >= 55296) {
                    int i61 = charAt20 & 8191;
                    int i62 = 13;
                    while (true) {
                        i29 = i60 + 1;
                        charAt6 = str.charAt(i60);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i61 |= (charAt6 & 8191) << i62;
                        i62 += 13;
                        i60 = i29;
                    }
                    charAt20 = i61 | (charAt6 << i62);
                    i60 = i29;
                }
                int i63 = i60 + 1;
                int charAt21 = str.charAt(i60);
                if (charAt21 >= 55296) {
                    int i64 = charAt21 & 8191;
                    int i65 = 13;
                    while (true) {
                        i28 = i63 + 1;
                        charAt5 = str.charAt(i63);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i64 |= (charAt5 & 8191) << i65;
                        i65 += 13;
                        i63 = i28;
                    }
                    charAt21 = i64 | (charAt5 << i65);
                    i63 = i28;
                }
                int i66 = charAt15 + charAt15 + charAt16;
                i8 = charAt15;
                i39 = i63;
                iArr = new int[charAt21 + charAt19 + charAt20];
                int i67 = charAt19;
                i4 = charAt17;
                i7 = i67;
                i3 = charAt18;
                i6 = i66;
                i2 = charAt21;
            }
            Unsafe unsafe = zzb;
            Object[] objArr2 = zzguVar.zzc;
            Class<?> cls2 = zzguVar.zza.getClass();
            int i68 = i2 + i7;
            int i69 = i5 + i5;
            int[] iArr2 = new int[i5 * 3];
            Object[] objArr3 = new Object[i69];
            int i70 = i68;
            int i71 = i2;
            int i72 = 0;
            int i73 = 0;
            while (i39 < length) {
                int i74 = i39 + 1;
                int charAt22 = str.charAt(i39);
                if (charAt22 >= i37) {
                    int i75 = charAt22 & 8191;
                    int i76 = i74;
                    int i77 = 13;
                    while (true) {
                        i27 = i76 + 1;
                        charAt4 = str.charAt(i76);
                        i9 = length;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i75 |= (charAt4 & 8191) << i77;
                        i77 += 13;
                        i76 = i27;
                        length = i9;
                    }
                    charAt22 = i75 | (charAt4 << i77);
                    i10 = i27;
                } else {
                    i9 = length;
                    i10 = i74;
                }
                int i78 = i10 + 1;
                int charAt23 = str.charAt(i10);
                Object[] objArr4 = objArr2;
                char c = 55296;
                if (charAt23 >= 55296) {
                    int i79 = charAt23 & 8191;
                    int i80 = 13;
                    while (true) {
                        i26 = i78 + 1;
                        charAt3 = str.charAt(i78);
                        if (charAt3 < c) {
                            break;
                        }
                        i79 |= (charAt3 & 8191) << i80;
                        i80 += 13;
                        i78 = i26;
                        c = 55296;
                    }
                    charAt23 = i79 | (charAt3 << i80);
                    i78 = i26;
                }
                if ((charAt23 & 1024) != 0) {
                    iArr[i72] = i73;
                    i72++;
                }
                int i81 = charAt23 & 255;
                int i82 = charAt22;
                int i83 = charAt23 & 2048;
                if (i81 >= 51) {
                    int i84 = i78 + 1;
                    int charAt24 = str.charAt(i78);
                    char c2 = 55296;
                    if (charAt24 >= 55296) {
                        int i85 = charAt24 & 8191;
                        int i86 = i84;
                        int i87 = 13;
                        while (true) {
                            i25 = i86 + 1;
                            charAt2 = str.charAt(i86);
                            if (charAt2 < c2) {
                                break;
                            }
                            i85 |= (charAt2 & 8191) << i87;
                            i87 += 13;
                            i86 = i25;
                            c2 = 55296;
                        }
                        charAt24 = i85 | (charAt2 << i87);
                        i22 = i25;
                    } else {
                        i22 = i84;
                    }
                    int i88 = i22;
                    int i89 = i81 - 51;
                    int i90 = charAt24;
                    if (i89 == 9 || i89 == 17) {
                        i24 = i6 + 1;
                        int i91 = i73 / 3;
                        objArr3[i91 + i91 + 1] = objArr4[i6];
                    } else {
                        if (i89 == 12) {
                            if (zzguVar.zzc() == 1 || i83 != 0) {
                                i24 = i6 + 1;
                                int i92 = i73 / 3;
                                objArr3[i92 + i92 + 1] = objArr4[i6];
                            } else {
                                i23 = 0;
                                int i93 = i90 + i90;
                                int i94 = i23;
                                obj = objArr4[i93];
                                if (obj instanceof Field) {
                                    field2 = (Field) obj;
                                } else {
                                    field2 = zzz(cls2, (String) obj);
                                    objArr4[i93] = field2;
                                }
                                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(field2);
                                int i95 = i93 + 1;
                                obj2 = objArr4[i95];
                                if (obj2 instanceof Field) {
                                    field3 = (Field) obj2;
                                } else {
                                    field3 = zzz(cls2, (String) obj2);
                                    objArr4[i95] = field3;
                                }
                                int objectFieldOffset3 = (int) unsafe.objectFieldOffset(field3);
                                Class<?> cls3 = cls2;
                                i13 = objectFieldOffset3;
                                i15 = objectFieldOffset2;
                                i11 = i88;
                                objArr = objArr3;
                                cls = cls3;
                                i12 = i8;
                                i16 = i94;
                                i14 = 0;
                            }
                        }
                        i23 = i83;
                        int i932 = i90 + i90;
                        int i942 = i23;
                        obj = objArr4[i932];
                        if (obj instanceof Field) {
                        }
                        int objectFieldOffset22 = (int) unsafe.objectFieldOffset(field2);
                        int i952 = i932 + 1;
                        obj2 = objArr4[i952];
                        if (obj2 instanceof Field) {
                        }
                        int objectFieldOffset32 = (int) unsafe.objectFieldOffset(field3);
                        Class<?> cls32 = cls2;
                        i13 = objectFieldOffset32;
                        i15 = objectFieldOffset22;
                        i11 = i88;
                        objArr = objArr3;
                        cls = cls32;
                        i12 = i8;
                        i16 = i942;
                        i14 = 0;
                    }
                    i6 = i24;
                    i23 = i83;
                    int i9322 = i90 + i90;
                    int i9422 = i23;
                    obj = objArr4[i9322];
                    if (obj instanceof Field) {
                    }
                    int objectFieldOffset222 = (int) unsafe.objectFieldOffset(field2);
                    int i9522 = i9322 + 1;
                    obj2 = objArr4[i9522];
                    if (obj2 instanceof Field) {
                    }
                    int objectFieldOffset322 = (int) unsafe.objectFieldOffset(field3);
                    Class<?> cls322 = cls2;
                    i13 = objectFieldOffset322;
                    i15 = objectFieldOffset222;
                    i11 = i88;
                    objArr = objArr3;
                    cls = cls322;
                    i12 = i8;
                    i16 = i9422;
                    i14 = 0;
                } else {
                    int i96 = i6 + 1;
                    Field zzz = zzz(cls2, (String) objArr4[i6]);
                    objArr = objArr3;
                    if (i81 == 9 || i81 == 17) {
                        i12 = i8;
                        int i97 = i73 / 3;
                        objArr[i97 + i97 + 1] = zzz.getType();
                    } else {
                        if (i81 == 27) {
                            i12 = i8;
                            i21 = 1;
                            i6 += 2;
                        } else if (i81 == 49) {
                            i6 += 2;
                            i12 = i8;
                            i21 = 1;
                        } else {
                            if (i81 == 12 || i81 == 30 || i81 == 44) {
                                i12 = i8;
                                if (zzguVar.zzc() == 1 || i83 != 0) {
                                    i6 += 2;
                                    int i98 = i73 / 3;
                                    objArr[i98 + i98 + 1] = objArr4[i96];
                                    cls = cls2;
                                } else {
                                    cls = cls2;
                                    i6 = i96;
                                    i83 = 0;
                                }
                            } else if (i81 == 50) {
                                int i99 = i6 + 2;
                                int i100 = i71 + 1;
                                iArr[i71] = i73;
                                int i101 = i73 / 3;
                                int i102 = i101 + i101;
                                objArr[i102] = objArr4[i96];
                                if (i83 != 0) {
                                    i6 += 3;
                                    objArr[i102 + 1] = objArr4[i99];
                                    cls = cls2;
                                    i71 = i100;
                                } else {
                                    i6 = i99;
                                    cls = cls2;
                                    i71 = i100;
                                    i83 = 0;
                                }
                                i12 = i8;
                            } else {
                                i12 = i8;
                            }
                            objectFieldOffset = (int) unsafe.objectFieldOffset(zzz);
                            i13 = 1048575;
                            if ((charAt23 & 4096) != 0 || i81 > 17) {
                                i11 = i78;
                                i20 = 0;
                            } else {
                                int i103 = i78 + 1;
                                int charAt25 = str.charAt(i78);
                                if (charAt25 >= 55296) {
                                    int i104 = charAt25 & 8191;
                                    int i105 = 13;
                                    while (true) {
                                        i11 = i103 + 1;
                                        charAt = str.charAt(i103);
                                        if (charAt < 55296) {
                                            break;
                                        }
                                        i104 |= (charAt & 8191) << i105;
                                        i105 += 13;
                                        i103 = i11;
                                    }
                                    charAt25 = i104 | (charAt << i105);
                                } else {
                                    i11 = i103;
                                }
                                int i106 = (charAt25 / 32) + i12 + i12;
                                Object obj3 = objArr4[i106];
                                if (obj3 instanceof Field) {
                                    field = (Field) obj3;
                                } else {
                                    field = zzz(cls, (String) obj3);
                                    objArr4[i106] = field;
                                }
                                i13 = (int) unsafe.objectFieldOffset(field);
                                i20 = charAt25 % 32;
                            }
                            if (i81 >= 18 && i81 <= 49) {
                                iArr[i70] = objectFieldOffset;
                                i70++;
                            }
                            i14 = i20;
                            i15 = objectFieldOffset;
                            i16 = i83;
                        }
                        int i107 = i73 / 3;
                        objArr[i107 + i107 + i21] = objArr4[i96];
                        cls = cls2;
                        objectFieldOffset = (int) unsafe.objectFieldOffset(zzz);
                        i13 = 1048575;
                        if ((charAt23 & 4096) != 0) {
                        }
                        i11 = i78;
                        i20 = 0;
                        if (i81 >= 18) {
                            iArr[i70] = objectFieldOffset;
                            i70++;
                        }
                        i14 = i20;
                        i15 = objectFieldOffset;
                        i16 = i83;
                    }
                    cls = cls2;
                    i6 = i96;
                    objectFieldOffset = (int) unsafe.objectFieldOffset(zzz);
                    i13 = 1048575;
                    if ((charAt23 & 4096) != 0) {
                    }
                    i11 = i78;
                    i20 = 0;
                    if (i81 >= 18) {
                    }
                    i14 = i20;
                    i15 = objectFieldOffset;
                    i16 = i83;
                }
                int i108 = i73 + 1;
                iArr2[i73] = i82;
                int i109 = i73 + 2;
                String str2 = str;
                if ((charAt23 & LogviewFragment.MAX_LINES) != 0) {
                    i17 = 536870912;
                } else {
                    i17 = 0;
                }
                if ((charAt23 & 256) != 0) {
                    i18 = 268435456;
                } else {
                    i18 = 0;
                }
                if (i16 != 0) {
                    i19 = Integer.MIN_VALUE;
                } else {
                    i19 = 0;
                }
                iArr2[i108] = i17 | i18 | i19 | (i81 << 20) | i15;
                i73 += 3;
                iArr2[i109] = (i14 << 20) | i13;
                cls2 = cls;
                objArr2 = objArr4;
                length = i9;
                objArr3 = objArr;
                i8 = i12;
                i39 = i11;
                str = str2;
                i37 = 55296;
            }
            return new zzgo(iArr2, objArr3, i4, i3, zzguVar.zza, iArr, i2, i68, zzaVar, zzaVar2);
        }
        zzguVar.getClass();
        throw new ClassCastException();
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
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 4, i10);
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
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 4, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 1, i10);
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
                            i10 = ViewModelProvider.Factory.CC.m606m(zzd, zzd, zzC6, i10);
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
                        i10 = ViewModelProvider.Factory.CC.m606m(zze2, zze2, zzC7, i10);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        int zzC8 = zzem.zzC(i11 << 3);
                        int zzd2 = ((zzeg) unsafe.getObject(zzdsVar2, j)).zzd();
                        i10 = ViewModelProvider.Factory.CC.m606m(zzd2, zzd2, zzC8, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m607m(unsafe.getInt(zzdsVar2, j), zzem.zzC(i11 << 3), i10);
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
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 4, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (zzgoVar.zzJ(zzdsVar2, i7, i8, i9, i)) {
                        int i16 = unsafe.getInt(zzdsVar2, j);
                        i10 = ViewModelProvider.Factory.CC.m607m((i16 >> 31) ^ (i16 + i16), zzem.zzC(i11 << 3), i10);
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
                                zzC4 = ViewModelProvider.Factory.CC.m607m(zzd3, zzd3, zzC4);
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
                            i4 = ViewModelProvider.Factory.CC.m607m(zze3, zze3, i4);
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
                            zzC4 = ViewModelProvider.Factory.CC.m607m(zzd4, zzd4, zzC4);
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
                        i10 = ViewModelProvider.Factory.CC.m606m(size6, zzem.zzC(i11 << 3), size6, i10);
                        break;
                    } else {
                        break;
                    }
                case 36:
                    zza zzaVar14 = zzgx.zzb;
                    int size7 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 4;
                    if (size7 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(size7, zzem.zzC(i11 << 3), size7, i10);
                        break;
                    } else {
                        break;
                    }
                case 37:
                    int zzg = zzgx.zzg((List) unsafe.getObject(zzdsVar2, j));
                    if (zzg > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(zzg, zzem.zzC(i11 << 3), zzg, i10);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int zzl2 = zzgx.zzl((List) unsafe.getObject(zzdsVar2, j));
                    if (zzl2 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(zzl2, zzem.zzC(i11 << 3), zzl2, i10);
                        break;
                    } else {
                        break;
                    }
                case 39:
                    int zzf = zzgx.zzf((List) unsafe.getObject(zzdsVar2, j));
                    if (zzf > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(zzf, zzem.zzC(i11 << 3), zzf, i10);
                        break;
                    } else {
                        break;
                    }
                case 40:
                    zza zzaVar15 = zzgx.zzb;
                    int size8 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 8;
                    if (size8 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(size8, zzem.zzC(i11 << 3), size8, i10);
                        break;
                    } else {
                        break;
                    }
                case 41:
                    zza zzaVar16 = zzgx.zzb;
                    int size9 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 4;
                    if (size9 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(size9, zzem.zzC(i11 << 3), size9, i10);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    zza zzaVar17 = zzgx.zzb;
                    int size10 = ((List) unsafe.getObject(zzdsVar2, j)).size();
                    if (size10 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(size10, zzem.zzC(i11 << 3), size10, i10);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int zzk = zzgx.zzk((List) unsafe.getObject(zzdsVar2, j));
                    if (zzk > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(zzk, zzem.zzC(i11 << 3), zzk, i10);
                        break;
                    } else {
                        break;
                    }
                case 44:
                    int zza2 = zzgx.zza((List) unsafe.getObject(zzdsVar2, j));
                    if (zza2 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(zza2, zzem.zzC(i11 << 3), zza2, i10);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    zza zzaVar18 = zzgx.zzb;
                    int size11 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 4;
                    if (size11 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(size11, zzem.zzC(i11 << 3), size11, i10);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    zza zzaVar19 = zzgx.zzb;
                    int size12 = ((List) unsafe.getObject(zzdsVar2, j)).size() * 8;
                    if (size12 > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(size12, zzem.zzC(i11 << 3), size12, i10);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int zzi = zzgx.zzi((List) unsafe.getObject(zzdsVar2, j));
                    if (zzi > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(zzi, zzem.zzC(i11 << 3), zzi, i10);
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int zzj = zzgx.zzj((List) unsafe.getObject(zzdsVar2, j));
                    if (zzj > 0) {
                        i10 = ViewModelProvider.Factory.CC.m606m(zzj, zzem.zzC(i11 << 3), zzj, i10);
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
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 4, i10);
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
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 4, i10);
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 1, i10);
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
                            i10 = ViewModelProvider.Factory.CC.m606m(zzd5, zzd5, zzC11, i10);
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
                        i10 = ViewModelProvider.Factory.CC.m606m(zze4, zze4, zzC12, i10);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        int zzC13 = zzem.zzC(i11 << 3);
                        int zzd6 = ((zzeg) unsafe.getObject(zzdsVar2, j)).zzd();
                        i10 = ViewModelProvider.Factory.CC.m606m(zzd6, zzd6, zzC13, i10);
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m607m(zzo(j, zzdsVar2), zzem.zzC(i11 << 3), i10);
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
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 4, i10);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        i10 = ViewModelProvider.Factory.CC.m607m(i11 << 3, 8, i10);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (zzgoVar.zzM(i11, i7, zzdsVar2)) {
                        int zzo = zzo(j, zzdsVar2);
                        i10 = ViewModelProvider.Factory.CC.m607m((zzo >> 31) ^ (zzo + zzo), zzem.zzC(i11 << 3), i10);
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
    */
    public final int zzb(zzfi zzfiVar) {
        int i;
        long doubleToLongBits;
        int i2;
        int floatToIntBits;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i5 < iArr.length) {
                int zzs = zzs(i5);
                int i7 = 1048575 & zzs;
                int zzr = zzr(zzs);
                int i8 = iArr[i5];
                long j = i7;
                int i9 = 1237;
                int i10 = 37;
                switch (zzr) {
                    case 0:
                        i = i6 * 53;
                        doubleToLongBits = Double.doubleToLongBits(zzho.zzf.zza(j, zzfiVar));
                        Charset charset = zzfo.zza;
                        i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 1:
                        i2 = i6 * 53;
                        floatToIntBits = Float.floatToIntBits(zzho.zzf.zzb(j, zzfiVar));
                        i6 = floatToIntBits + i2;
                        break;
                    case 2:
                        i = i6 * 53;
                        doubleToLongBits = zzho.zzd(j, zzfiVar);
                        Charset charset2 = zzfo.zza;
                        i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 3:
                        i = i6 * 53;
                        doubleToLongBits = zzho.zzd(j, zzfiVar);
                        Charset charset3 = zzfo.zza;
                        i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 4:
                        i2 = i6 * 53;
                        floatToIntBits = zzho.zzc(j, zzfiVar);
                        i6 = floatToIntBits + i2;
                        break;
                    case 5:
                        i = i6 * 53;
                        doubleToLongBits = zzho.zzd(j, zzfiVar);
                        Charset charset4 = zzfo.zza;
                        i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 6:
                        i2 = i6 * 53;
                        floatToIntBits = zzho.zzc(j, zzfiVar);
                        i6 = floatToIntBits + i2;
                        break;
                    case 7:
                        i3 = i6 * 53;
                        boolean zzg = zzho.zzf.zzg(j, zzfiVar);
                        Charset charset5 = zzfo.zza;
                        break;
                    case 8:
                        i2 = i6 * 53;
                        floatToIntBits = ((String) zzho.zzf(j, zzfiVar)).hashCode();
                        i6 = floatToIntBits + i2;
                        break;
                    case 9:
                        i4 = i6 * 53;
                        Object zzf = zzho.zzf(j, zzfiVar);
                        if (zzf != null) {
                            i10 = zzf.hashCode();
                        }
                        i6 = i4 + i10;
                        break;
                    case 10:
                        i2 = i6 * 53;
                        floatToIntBits = zzho.zzf(j, zzfiVar).hashCode();
                        i6 = floatToIntBits + i2;
                        break;
                    case 11:
                        i2 = i6 * 53;
                        floatToIntBits = zzho.zzc(j, zzfiVar);
                        i6 = floatToIntBits + i2;
                        break;
                    case 12:
                        i2 = i6 * 53;
                        floatToIntBits = zzho.zzc(j, zzfiVar);
                        i6 = floatToIntBits + i2;
                        break;
                    case 13:
                        i2 = i6 * 53;
                        floatToIntBits = zzho.zzc(j, zzfiVar);
                        i6 = floatToIntBits + i2;
                        break;
                    case 14:
                        i = i6 * 53;
                        doubleToLongBits = zzho.zzd(j, zzfiVar);
                        Charset charset6 = zzfo.zza;
                        i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 15:
                        i2 = i6 * 53;
                        floatToIntBits = zzho.zzc(j, zzfiVar);
                        i6 = floatToIntBits + i2;
                        break;
                    case 16:
                        i = i6 * 53;
                        doubleToLongBits = zzho.zzd(j, zzfiVar);
                        Charset charset7 = zzfo.zza;
                        i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                        break;
                    case 17:
                        i4 = i6 * 53;
                        Object zzf2 = zzho.zzf(j, zzfiVar);
                        if (zzf2 != null) {
                            i10 = zzf2.hashCode();
                        }
                        i6 = i4 + i10;
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
                        i2 = i6 * 53;
                        floatToIntBits = zzho.zzf(j, zzfiVar).hashCode();
                        i6 = floatToIntBits + i2;
                        break;
                    case 50:
                        i2 = i6 * 53;
                        floatToIntBits = zzho.zzf(j, zzfiVar).hashCode();
                        i6 = floatToIntBits + i2;
                        break;
                    case 51:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i = i6 * 53;
                            doubleToLongBits = Double.doubleToLongBits(((Double) zzho.zzf(j, zzfiVar)).doubleValue());
                            Charset charset8 = zzfo.zza;
                            i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 52:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = Float.floatToIntBits(((Float) zzho.zzf(j, zzfiVar)).floatValue());
                            i6 = floatToIntBits + i2;
                            break;
                        }
                    case 53:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i = i6 * 53;
                            doubleToLongBits = zzt(j, zzfiVar);
                            Charset charset9 = zzfo.zza;
                            i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 54:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i = i6 * 53;
                            doubleToLongBits = zzt(j, zzfiVar);
                            Charset charset10 = zzfo.zza;
                            i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 55:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = zzo(j, zzfiVar);
                            i6 = floatToIntBits + i2;
                            break;
                        }
                    case 56:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i = i6 * 53;
                            doubleToLongBits = zzt(j, zzfiVar);
                            Charset charset11 = zzfo.zza;
                            i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 57:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = zzo(j, zzfiVar);
                            i6 = floatToIntBits + i2;
                            break;
                        }
                    case 58:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i3 = i6 * 53;
                            boolean booleanValue = ((Boolean) zzho.zzf(j, zzfiVar)).booleanValue();
                            Charset charset12 = zzfo.zza;
                            break;
                        }
                    case 59:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = ((String) zzho.zzf(j, zzfiVar)).hashCode();
                            i6 = floatToIntBits + i2;
                            break;
                        }
                    case 60:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = zzho.zzf(j, zzfiVar).hashCode();
                            i6 = floatToIntBits + i2;
                            break;
                        }
                    case 61:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = zzho.zzf(j, zzfiVar).hashCode();
                            i6 = floatToIntBits + i2;
                            break;
                        }
                    case 62:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = zzo(j, zzfiVar);
                            i6 = floatToIntBits + i2;
                            break;
                        }
                    case 63:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = zzo(j, zzfiVar);
                            i6 = floatToIntBits + i2;
                            break;
                        }
                    case 64:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = zzo(j, zzfiVar);
                            i6 = floatToIntBits + i2;
                            break;
                        }
                    case 65:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i = i6 * 53;
                            doubleToLongBits = zzt(j, zzfiVar);
                            Charset charset13 = zzfo.zza;
                            i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 66:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = zzo(j, zzfiVar);
                            i6 = floatToIntBits + i2;
                            break;
                        }
                    case 67:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i = i6 * 53;
                            doubleToLongBits = zzt(j, zzfiVar);
                            Charset charset14 = zzfo.zza;
                            i6 = i + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
                            break;
                        }
                    case 68:
                        if (!zzM(i8, i5, zzfiVar)) {
                            break;
                        } else {
                            i2 = i6 * 53;
                            floatToIntBits = zzho.zzf(j, zzfiVar).hashCode();
                            i6 = floatToIntBits + i2;
                            break;
                        }
                }
                i5 += 3;
            } else {
                return zzfiVar.zzc.hashCode() + (i6 * 53);
            }
        }
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
    */
    public final int zzc(Object obj, byte[] bArr, int i, int i2, int i3, zzdw zzdwVar) {
        int i4;
        Unsafe unsafe;
        int[] iArr;
        Object[] objArr;
        Object obj2;
        int i5;
        zzhi zzhiVar;
        zzdw zzdwVar2;
        int i6;
        int i7;
        int i8;
        int i9;
        zzhi zzhiVar2;
        int i10;
        String str;
        byte[] bArr2;
        Unsafe unsafe2;
        int i11;
        int i12;
        int i13;
        int i14;
        zzdw zzdwVar3;
        Object obj3;
        Object obj4;
        byte[] bArr3;
        zzdw zzdwVar4;
        byte[] bArr4;
        zzdw zzdwVar5;
        Object obj5;
        zzdw zzdwVar6;
        int i15;
        int i16;
        int i17;
        Unsafe unsafe3;
        int i18;
        zzhi zzhiVar3;
        zzgf zzgfVar;
        int i19;
        int i20;
        zzdw zzdwVar7;
        Unsafe unsafe4;
        zzhi zzhiVar4;
        Unsafe unsafe5;
        zzhi zzhiVar5;
        zzgo zzgoVar;
        int i21;
        zzdw zzdwVar8;
        int i22;
        zzdw zzdwVar9;
        int i23;
        int i24;
        byte[] bArr5;
        int i25;
        zzdw zzdwVar10;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        zzdw zzdwVar11;
        int i32;
        int i33;
        int zzi;
        zzgo zzgoVar2 = this;
        Object obj6 = obj;
        byte[] bArr6 = bArr;
        int i34 = i2;
        zzdw zzdwVar12 = zzdwVar;
        if (zzL(obj6)) {
            Unsafe unsafe6 = zzb;
            int i35 = i;
            int i36 = -1;
            int i37 = 0;
            int i38 = 1048575;
            int i39 = 0;
            int i40 = 0;
            while (true) {
                int i41 = 1048575;
                while (true) {
                    Object[] objArr2 = zzgoVar2.zzd;
                    int[] iArr2 = zzgoVar2.zzc;
                    if (i35 < i34) {
                        int i42 = i35 + 1;
                        int i43 = bArr6[i35];
                        if (i43 < 0) {
                            i42 = LazyKt__LazyJVMKt.zzj(i43, bArr6, i42, zzdwVar12);
                            i43 = zzdwVar12.zza;
                        }
                        int i44 = i42;
                        i40 = i43;
                        int i45 = i40 >>> 3;
                        int i46 = zzgoVar2.zzf;
                        int i47 = zzgoVar2.zze;
                        if (i45 > i36) {
                            int i48 = i37 / 3;
                            if (i45 >= i47 && i45 <= i46) {
                                i5 = zzgoVar2.zzq(i45, i48);
                                zzhiVar = zzhi.zza;
                                if (i5 != -1) {
                                    bArr6 = bArr;
                                    i4 = i3;
                                    zzdwVar2 = zzdwVar12;
                                    i6 = i38;
                                    i7 = i45;
                                    iArr = iArr2;
                                    objArr = objArr2;
                                    i8 = i40;
                                    i35 = i44;
                                    i9 = 0;
                                    unsafe = unsafe6;
                                    obj2 = obj6;
                                } else {
                                    int i49 = i40 & 7;
                                    int i50 = iArr2[i5 + 1];
                                    int zzr = zzr(i50);
                                    iArr = iArr2;
                                    objArr = objArr2;
                                    long j = i50 & i41;
                                    if (zzr <= 17) {
                                        int i51 = iArr[i5 + 2];
                                        int i52 = 1 << (i51 >>> 20);
                                        int i53 = i51 & i41;
                                        i10 = i45;
                                        if (i53 != i38) {
                                            int i54 = 1048575;
                                            str = "CodedInputStream encountered an embedded string or message which claimed to have negative size.";
                                            if (i38 != 1048575) {
                                                unsafe6.putInt(obj6, i38, i39);
                                                i54 = 1048575;
                                            }
                                            i39 = i53 == i54 ? 0 : unsafe6.getInt(obj6, i53);
                                        } else {
                                            str = "CodedInputStream encountered an embedded string or message which claimed to have negative size.";
                                            i53 = i38;
                                        }
                                        switch (zzr) {
                                            case 0:
                                                bArr2 = bArr;
                                                unsafe2 = unsafe6;
                                                i11 = i5;
                                                i12 = i44;
                                                i13 = i39;
                                                i14 = i40;
                                                zzdwVar3 = zzdwVar;
                                                if (i49 == 1) {
                                                    i35 = i12 + 8;
                                                    i39 = i13 | i52;
                                                    zzho.zzf.zze(obj6, j, Double.longBitsToDouble(LazyKt__LazyJVMKt.zzo(bArr2, i12)));
                                                    i34 = i2;
                                                    break;
                                                }
                                                obj3 = obj6;
                                                i9 = i11;
                                                unsafe = unsafe2;
                                                i8 = i14;
                                                i4 = i3;
                                                i35 = i12;
                                                i6 = i53;
                                                bArr6 = bArr2;
                                                zzdwVar2 = zzdwVar3;
                                                i39 = i13;
                                                i7 = i10;
                                                obj2 = obj3;
                                                break;
                                            case 1:
                                                bArr2 = bArr;
                                                unsafe2 = unsafe6;
                                                i11 = i5;
                                                i12 = i44;
                                                i13 = i39;
                                                i14 = i40;
                                                zzdwVar3 = zzdwVar;
                                                if (i49 == 5) {
                                                    i35 = i12 + 4;
                                                    i39 = i13 | i52;
                                                    zzho.zzf.zzf(obj6, j, Float.intBitsToFloat(LazyKt__LazyJVMKt.zzb(bArr2, i12)));
                                                    i34 = i2;
                                                    break;
                                                }
                                                obj3 = obj6;
                                                i9 = i11;
                                                unsafe = unsafe2;
                                                i8 = i14;
                                                i4 = i3;
                                                i35 = i12;
                                                i6 = i53;
                                                bArr6 = bArr2;
                                                zzdwVar2 = zzdwVar3;
                                                i39 = i13;
                                                i7 = i10;
                                                obj2 = obj3;
                                                break;
                                            case 2:
                                            case 3:
                                                bArr2 = bArr;
                                                i11 = i5;
                                                i12 = i44;
                                                i13 = i39;
                                                i14 = i40;
                                                zzdwVar3 = zzdwVar;
                                                if (i49 == 0) {
                                                    i39 = i13 | i52;
                                                    int zzl = LazyKt__LazyJVMKt.zzl(bArr2, i12, zzdwVar3);
                                                    unsafe6.putLong(obj6, j, zzdwVar3.zzb);
                                                    i34 = i2;
                                                    i35 = zzl;
                                                    break;
                                                }
                                                unsafe2 = unsafe6;
                                                obj3 = obj6;
                                                i9 = i11;
                                                unsafe = unsafe2;
                                                i8 = i14;
                                                i4 = i3;
                                                i35 = i12;
                                                i6 = i53;
                                                bArr6 = bArr2;
                                                zzdwVar2 = zzdwVar3;
                                                i39 = i13;
                                                i7 = i10;
                                                obj2 = obj3;
                                                break;
                                            case 4:
                                            case 11:
                                                bArr2 = bArr;
                                                i11 = i5;
                                                i12 = i44;
                                                i13 = i39;
                                                i14 = i40;
                                                zzdwVar3 = zzdwVar;
                                                if (i49 == 0) {
                                                    i39 = i13 | i52;
                                                    i35 = LazyKt__LazyJVMKt.zzi(bArr2, i12, zzdwVar3);
                                                    unsafe6.putInt(obj6, j, zzdwVar3.zza);
                                                    i34 = i2;
                                                    break;
                                                }
                                                unsafe2 = unsafe6;
                                                obj3 = obj6;
                                                i9 = i11;
                                                unsafe = unsafe2;
                                                i8 = i14;
                                                i4 = i3;
                                                i35 = i12;
                                                i6 = i53;
                                                bArr6 = bArr2;
                                                zzdwVar2 = zzdwVar3;
                                                i39 = i13;
                                                i7 = i10;
                                                obj2 = obj3;
                                                break;
                                            case 5:
                                            case 14:
                                                bArr2 = bArr;
                                                unsafe2 = unsafe6;
                                                obj3 = obj6;
                                                i11 = i5;
                                                i12 = i44;
                                                i14 = i40;
                                                i13 = i39;
                                                if (i49 != 1) {
                                                    zzdwVar3 = zzdwVar;
                                                    i9 = i11;
                                                    unsafe = unsafe2;
                                                    i8 = i14;
                                                    i4 = i3;
                                                    i35 = i12;
                                                    i6 = i53;
                                                    bArr6 = bArr2;
                                                    zzdwVar2 = zzdwVar3;
                                                    i39 = i13;
                                                    i7 = i10;
                                                    obj2 = obj3;
                                                    break;
                                                } else {
                                                    i35 = i12 + 8;
                                                    i39 = i13 | i52;
                                                    obj6 = obj;
                                                    zzdwVar3 = zzdwVar;
                                                    unsafe6 = unsafe2;
                                                    unsafe6.putLong(obj6, j, LazyKt__LazyJVMKt.zzo(bArr2, i12));
                                                    i34 = i2;
                                                    break;
                                                }
                                            case 6:
                                            case 13:
                                                bArr2 = bArr;
                                                unsafe2 = unsafe6;
                                                obj5 = obj6;
                                                i11 = i5;
                                                i12 = i44;
                                                zzdwVar6 = zzdwVar;
                                                i14 = i40;
                                                i13 = i39;
                                                if (i49 != 5) {
                                                    zzdwVar3 = zzdwVar6;
                                                    obj3 = obj5;
                                                    i9 = i11;
                                                    unsafe = unsafe2;
                                                    i8 = i14;
                                                    i4 = i3;
                                                    i35 = i12;
                                                    i6 = i53;
                                                    bArr6 = bArr2;
                                                    zzdwVar2 = zzdwVar3;
                                                    i39 = i13;
                                                    i7 = i10;
                                                    obj2 = obj3;
                                                    break;
                                                } else {
                                                    i35 = i12 + 4;
                                                    i15 = i13 | i52;
                                                    unsafe2.putInt(obj5, j, LazyKt__LazyJVMKt.zzb(bArr2, i12));
                                                    zzdwVar12 = zzdwVar6;
                                                    i39 = i15;
                                                    obj6 = obj5;
                                                    unsafe6 = unsafe2;
                                                    i38 = i53;
                                                    i37 = i11;
                                                    bArr6 = bArr2;
                                                    i40 = i14;
                                                    i36 = i10;
                                                    i41 = 1048575;
                                                    i34 = i2;
                                                }
                                            case 7:
                                                bArr2 = bArr;
                                                unsafe2 = unsafe6;
                                                obj5 = obj6;
                                                i11 = i5;
                                                i12 = i44;
                                                zzdwVar6 = zzdwVar;
                                                i14 = i40;
                                                i13 = i39;
                                                if (i49 != 0) {
                                                    zzdwVar3 = zzdwVar6;
                                                    obj3 = obj5;
                                                    i9 = i11;
                                                    unsafe = unsafe2;
                                                    i8 = i14;
                                                    i4 = i3;
                                                    i35 = i12;
                                                    i6 = i53;
                                                    bArr6 = bArr2;
                                                    zzdwVar2 = zzdwVar3;
                                                    i39 = i13;
                                                    i7 = i10;
                                                    obj2 = obj3;
                                                    break;
                                                } else {
                                                    i15 = i13 | i52;
                                                    i35 = LazyKt__LazyJVMKt.zzl(bArr2, i12, zzdwVar6);
                                                    zzho.zzf.zzc(obj5, j, zzdwVar6.zzb != 0);
                                                    zzdwVar12 = zzdwVar6;
                                                    i39 = i15;
                                                    obj6 = obj5;
                                                    unsafe6 = unsafe2;
                                                    i38 = i53;
                                                    i37 = i11;
                                                    bArr6 = bArr2;
                                                    i40 = i14;
                                                    i36 = i10;
                                                    i41 = 1048575;
                                                    i34 = i2;
                                                }
                                            case 8:
                                                bArr2 = bArr;
                                                unsafe2 = unsafe6;
                                                obj5 = obj6;
                                                i11 = i5;
                                                i12 = i44;
                                                zzdwVar6 = zzdwVar;
                                                i14 = i40;
                                                i13 = i39;
                                                if (i49 != 2) {
                                                    zzdwVar3 = zzdwVar6;
                                                    obj3 = obj5;
                                                    i9 = i11;
                                                    unsafe = unsafe2;
                                                    i8 = i14;
                                                    i4 = i3;
                                                    i35 = i12;
                                                    i6 = i53;
                                                    bArr6 = bArr2;
                                                    zzdwVar2 = zzdwVar3;
                                                    i39 = i13;
                                                    i7 = i10;
                                                    obj2 = obj3;
                                                    break;
                                                } else {
                                                    if ((i50 & 536870912) != 0) {
                                                        int i55 = i13 | i52;
                                                        int zzi2 = LazyKt__LazyJVMKt.zzi(bArr2, i12, zzdwVar6);
                                                        int i56 = zzdwVar6.zza;
                                                        if (i56 >= 0) {
                                                            if (i56 == 0) {
                                                                zzdwVar6.zzc = "";
                                                                i16 = i55;
                                                            } else {
                                                                int i57 = zzhr.$r8$clinit;
                                                                int length = bArr2.length;
                                                                if ((((length - zzi2) - i56) | zzi2 | i56) >= 0) {
                                                                    int i58 = zzi2 + i56;
                                                                    char[] cArr = new char[i56];
                                                                    int i59 = 0;
                                                                    while (zzi2 < i58) {
                                                                        byte b = bArr2[zzi2];
                                                                        if (b >= 0) {
                                                                            zzi2++;
                                                                            i59++;
                                                                            cArr[i59] = (char) b;
                                                                        } else {
                                                                            while (zzi2 < i58) {
                                                                                int i60 = zzi2 + 1;
                                                                                int i61 = i55;
                                                                                byte b2 = bArr2[zzi2];
                                                                                if (b2 >= 0) {
                                                                                    i59++;
                                                                                    cArr[i59] = (char) b2;
                                                                                    zzi2 = i60;
                                                                                    while (zzi2 < i58) {
                                                                                        byte b3 = bArr2[zzi2];
                                                                                        if (b3 >= 0) {
                                                                                            zzi2++;
                                                                                            i59++;
                                                                                            cArr[i59] = (char) b3;
                                                                                        } else {
                                                                                            i55 = i61;
                                                                                        }
                                                                                    }
                                                                                    i55 = i61;
                                                                                } else {
                                                                                    int i62 = zzi2;
                                                                                    if (b2 >= -32) {
                                                                                        if (b2 >= -16) {
                                                                                            i17 = i58;
                                                                                            if (i60 < i17 - 2) {
                                                                                                byte b4 = bArr2[i60];
                                                                                                byte b5 = bArr2[i62 + 2];
                                                                                                zzi2 = i62 + 4;
                                                                                                byte b6 = bArr2[i62 + 3];
                                                                                                if (!LazyKt__LazyJVMKt.zze(b4) && (((b4 + 112) + (b2 << 28)) >> 30) == 0 && !LazyKt__LazyJVMKt.zze(b5) && !LazyKt__LazyJVMKt.zze(b6)) {
                                                                                                    int i63 = ((b2 & 7) << 18) | ((b4 & 63) << 12) | ((b5 & 63) << 6) | (b6 & 63);
                                                                                                    cArr[i59] = (char) ((i63 >>> 10) + 55232);
                                                                                                    cArr[i59 + 1] = (char) ((i63 & 1023) + 56320);
                                                                                                    i59 += 2;
                                                                                                    i55 = i61;
                                                                                                }
                                                                                            } else {
                                                                                                throw new IOException("Protocol message had invalid UTF-8.");
                                                                                            }
                                                                                        } else if (i60 < i58 - 1) {
                                                                                            i59++;
                                                                                            byte b7 = bArr2[i60];
                                                                                            zzi2 = i62 + 3;
                                                                                            byte b8 = bArr2[i62 + 2];
                                                                                            if (LazyKt__LazyJVMKt.zze(b7)) {
                                                                                                break;
                                                                                            } else {
                                                                                                i17 = i58;
                                                                                                if (b2 == -32) {
                                                                                                    if (b7 < -96) {
                                                                                                        break;
                                                                                                    } else {
                                                                                                        b2 = -32;
                                                                                                    }
                                                                                                }
                                                                                                if (b2 == -19) {
                                                                                                    if (b7 >= -96) {
                                                                                                        break;
                                                                                                    } else {
                                                                                                        b2 = -19;
                                                                                                    }
                                                                                                }
                                                                                                if (LazyKt__LazyJVMKt.zze(b8)) {
                                                                                                    break;
                                                                                                } else {
                                                                                                    cArr[i59] = (char) (((b2 & 15) << 12) | ((b7 & 63) << 6) | (b8 & 63));
                                                                                                    i55 = i61;
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            throw new IOException("Protocol message had invalid UTF-8.");
                                                                                        }
                                                                                        i58 = i17;
                                                                                    } else if (i60 < i58) {
                                                                                        i59++;
                                                                                        zzi2 = i62 + 2;
                                                                                        byte b9 = bArr2[i60];
                                                                                        if (b2 >= -62 && !LazyKt__LazyJVMKt.zze(b9)) {
                                                                                            cArr[i59] = (char) (((b2 & 31) << 6) | (b9 & 63));
                                                                                            i55 = i61;
                                                                                        }
                                                                                    } else {
                                                                                        throw new IOException("Protocol message had invalid UTF-8.");
                                                                                    }
                                                                                }
                                                                            }
                                                                            i16 = i55;
                                                                            zzi2 = i58;
                                                                            zzdwVar6.zzc = new String(cArr, 0, i59);
                                                                        }
                                                                    }
                                                                    while (zzi2 < i58) {
                                                                    }
                                                                    i16 = i55;
                                                                    zzi2 = i58;
                                                                    zzdwVar6.zzc = new String(cArr, 0, i59);
                                                                } else {
                                                                    throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(zzi2), Integer.valueOf(i56)));
                                                                }
                                                            }
                                                            i35 = zzi2;
                                                            i15 = i16;
                                                        } else {
                                                            throw new IOException(str);
                                                        }
                                                    } else {
                                                        String str2 = str;
                                                        int zzi3 = LazyKt__LazyJVMKt.zzi(bArr2, i12, zzdwVar6);
                                                        int i64 = zzdwVar6.zza;
                                                        if (i64 >= 0) {
                                                            i15 = i13 | i52;
                                                            if (i64 == 0) {
                                                                zzdwVar6.zzc = "";
                                                            } else {
                                                                zzdwVar6.zzc = new String(bArr2, zzi3, i64, zzfo.zza);
                                                                zzi3 += i64;
                                                            }
                                                            i35 = zzi3;
                                                        } else {
                                                            throw new IOException(str2);
                                                        }
                                                    }
                                                    unsafe2.putObject(obj5, j, zzdwVar6.zzc);
                                                    zzdwVar12 = zzdwVar6;
                                                    i39 = i15;
                                                    obj6 = obj5;
                                                    unsafe6 = unsafe2;
                                                    i38 = i53;
                                                    i37 = i11;
                                                    bArr6 = bArr2;
                                                    i40 = i14;
                                                    i36 = i10;
                                                    i41 = 1048575;
                                                    i34 = i2;
                                                }
                                                break;
                                            case 9:
                                                obj4 = obj6;
                                                i11 = i5;
                                                i12 = i44;
                                                if (i49 != 2) {
                                                    unsafe2 = unsafe6;
                                                    bArr2 = bArr;
                                                    i13 = i39;
                                                    i14 = i40;
                                                    zzdwVar3 = zzdwVar;
                                                    obj3 = obj4;
                                                    i9 = i11;
                                                    unsafe = unsafe2;
                                                    i8 = i14;
                                                    i4 = i3;
                                                    i35 = i12;
                                                    i6 = i53;
                                                    bArr6 = bArr2;
                                                    zzdwVar2 = zzdwVar3;
                                                    i39 = i13;
                                                    i7 = i10;
                                                    obj2 = obj3;
                                                    break;
                                                } else {
                                                    i39 |= i52;
                                                    unsafe6 = unsafe6;
                                                    Object zzx = zzgoVar2.zzx(i11, obj4);
                                                    bArr6 = bArr;
                                                    i34 = i2;
                                                    zzdwVar12 = zzdwVar;
                                                    i35 = LazyKt__LazyJVMKt.zzn(zzx, zzgoVar2.zzv(i11), bArr6, i12, i34, zzdwVar12);
                                                    zzgoVar2.zzF(obj4, i11, zzx);
                                                    i38 = i53;
                                                    i37 = i11;
                                                    break;
                                                }
                                            case 10:
                                                bArr3 = bArr;
                                                zzdwVar4 = zzdwVar;
                                                obj4 = obj6;
                                                i11 = i5;
                                                i12 = i44;
                                                if (i49 == 2) {
                                                    i39 |= i52;
                                                    i35 = LazyKt__LazyJVMKt.zza(bArr3, i12, zzdwVar4);
                                                    unsafe6.putObject(obj4, j, zzdwVar4.zzc);
                                                    break;
                                                }
                                                i13 = i39;
                                                i14 = i40;
                                                zzdwVar3 = zzdwVar4;
                                                bArr2 = bArr3;
                                                unsafe2 = unsafe6;
                                                obj3 = obj4;
                                                i9 = i11;
                                                unsafe = unsafe2;
                                                i8 = i14;
                                                i4 = i3;
                                                i35 = i12;
                                                i6 = i53;
                                                bArr6 = bArr2;
                                                zzdwVar2 = zzdwVar3;
                                                i39 = i13;
                                                i7 = i10;
                                                obj2 = obj3;
                                                break;
                                            case 12:
                                                bArr3 = bArr;
                                                zzdwVar4 = zzdwVar;
                                                obj4 = obj6;
                                                i11 = i5;
                                                i12 = i44;
                                                if (i49 == 0) {
                                                    int zzi4 = LazyKt__LazyJVMKt.zzi(bArr3, i12, zzdwVar4);
                                                    int i65 = zzdwVar4.zza;
                                                    zzfl zzu = zzgoVar2.zzu(i11);
                                                    if ((i50 & Integer.MIN_VALUE) == 0 || zzu == null || zzu.zza(i65)) {
                                                        i39 |= i52;
                                                        unsafe6.putInt(obj4, j, i65);
                                                    } else {
                                                        zzfi zzfiVar = (zzfi) obj4;
                                                        zzhi zzhiVar6 = zzfiVar.zzc;
                                                        if (zzhiVar6 == zzhiVar) {
                                                            zzhiVar6 = zzhi.zzf();
                                                            zzfiVar.zzc = zzhiVar6;
                                                        }
                                                        zzhiVar6.zzj(i40, Long.valueOf(i65));
                                                    }
                                                    i34 = i2;
                                                    i35 = zzi4;
                                                    break;
                                                }
                                                i13 = i39;
                                                i14 = i40;
                                                zzdwVar3 = zzdwVar4;
                                                bArr2 = bArr3;
                                                unsafe2 = unsafe6;
                                                obj3 = obj4;
                                                i9 = i11;
                                                unsafe = unsafe2;
                                                i8 = i14;
                                                i4 = i3;
                                                i35 = i12;
                                                i6 = i53;
                                                bArr6 = bArr2;
                                                zzdwVar2 = zzdwVar3;
                                                i39 = i13;
                                                i7 = i10;
                                                obj2 = obj3;
                                                break;
                                            case 15:
                                                bArr3 = bArr;
                                                zzdwVar4 = zzdwVar;
                                                obj4 = obj6;
                                                i11 = i5;
                                                i12 = i44;
                                                if (i49 == 0) {
                                                    i39 |= i52;
                                                    i35 = LazyKt__LazyJVMKt.zzi(bArr3, i12, zzdwVar4);
                                                    int i66 = zzdwVar4.zza;
                                                    unsafe6.putInt(obj4, j, (i66 >>> 1) ^ (-(i66 & 1)));
                                                    break;
                                                }
                                                i13 = i39;
                                                i14 = i40;
                                                zzdwVar3 = zzdwVar4;
                                                bArr2 = bArr3;
                                                unsafe2 = unsafe6;
                                                obj3 = obj4;
                                                i9 = i11;
                                                unsafe = unsafe2;
                                                i8 = i14;
                                                i4 = i3;
                                                i35 = i12;
                                                i6 = i53;
                                                bArr6 = bArr2;
                                                zzdwVar2 = zzdwVar3;
                                                i39 = i13;
                                                i7 = i10;
                                                obj2 = obj3;
                                                break;
                                            case 16:
                                                bArr4 = bArr;
                                                zzdwVar5 = zzdwVar;
                                                i11 = i5;
                                                i12 = i44;
                                                if (i49 != 0) {
                                                    i13 = i39;
                                                    i14 = i40;
                                                    zzdwVar3 = zzdwVar5;
                                                    bArr2 = bArr4;
                                                    unsafe2 = unsafe6;
                                                    obj3 = obj6;
                                                    i9 = i11;
                                                    unsafe = unsafe2;
                                                    i8 = i14;
                                                    i4 = i3;
                                                    i35 = i12;
                                                    i6 = i53;
                                                    bArr6 = bArr2;
                                                    zzdwVar2 = zzdwVar3;
                                                    i39 = i13;
                                                    i7 = i10;
                                                    obj2 = obj3;
                                                    break;
                                                } else {
                                                    i39 |= i52;
                                                    int zzl2 = LazyKt__LazyJVMKt.zzl(bArr4, i12, zzdwVar5);
                                                    long j2 = zzdwVar5.zzb;
                                                    unsafe6.putLong(obj6, j, (-(j2 & 1)) ^ (j2 >>> 1));
                                                    i34 = i2;
                                                    i35 = zzl2;
                                                    break;
                                                }
                                            default:
                                                if (i49 != 3) {
                                                    i11 = i5;
                                                    bArr2 = bArr;
                                                    unsafe2 = unsafe6;
                                                    obj3 = obj6;
                                                    i13 = i39;
                                                    i12 = i44;
                                                    i14 = i40;
                                                    zzdwVar3 = zzdwVar;
                                                    i9 = i11;
                                                    unsafe = unsafe2;
                                                    i8 = i14;
                                                    i4 = i3;
                                                    i35 = i12;
                                                    i6 = i53;
                                                    bArr6 = bArr2;
                                                    zzdwVar2 = zzdwVar3;
                                                    i39 = i13;
                                                    i7 = i10;
                                                    obj2 = obj3;
                                                    break;
                                                } else {
                                                    i39 |= i52;
                                                    Object zzx2 = zzgoVar2.zzx(i5, obj6);
                                                    i11 = i5;
                                                    i35 = LazyKt__LazyJVMKt.zzm(zzx2, zzgoVar2.zzv(i5), bArr, i44, i2, (i10 << 3) | 4, zzdwVar);
                                                    zzdwVar5 = zzdwVar;
                                                    bArr4 = bArr;
                                                    zzgoVar2.zzF(obj6, i11, zzx2);
                                                    i34 = i2;
                                                    break;
                                                }
                                        }
                                    } else {
                                        Unsafe unsafe7 = unsafe6;
                                        Object obj7 = obj6;
                                        i10 = i45;
                                        int i67 = i39;
                                        int i68 = i5;
                                        i6 = i38;
                                        if (zzr != 27) {
                                            obj2 = obj7;
                                            if (zzr <= 49) {
                                                long j3 = i50;
                                                zzfn zzfnVar = (zzfn) unsafe7.getObject(obj2, j);
                                                if (!((zzdu) zzfnVar).zza) {
                                                    int size = zzfnVar.size();
                                                    zzfnVar = zzfnVar.zzd(size + size);
                                                    unsafe7.putObject(obj2, j, zzfnVar);
                                                }
                                                Object obj8 = null;
                                                switch (zzr) {
                                                    case 18:
                                                    case 35:
                                                        bArr6 = bArr;
                                                        zzdwVar8 = zzdwVar;
                                                        zzfn zzfnVar2 = zzfnVar;
                                                        i21 = i44;
                                                        i8 = i40;
                                                        zzhiVar5 = zzhiVar;
                                                        unsafe5 = unsafe7;
                                                        i7 = i10;
                                                        zzgoVar = zzgoVar2;
                                                        if (i49 != 2) {
                                                            if (i49 == 1) {
                                                                if (zzfnVar2 == null) {
                                                                    Double.longBitsToDouble(LazyKt__LazyJVMKt.zzo(bArr6, i21));
                                                                    throw null;
                                                                }
                                                                throw new ClassCastException();
                                                            }
                                                            i22 = i21;
                                                            break;
                                                        } else if (zzfnVar2 != null) {
                                                            throw new ClassCastException();
                                                        } else if (LazyKt__LazyJVMKt.zzi(bArr6, i21, zzdwVar8) + zzdwVar8.zza > bArr6.length) {
                                                            throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        } else {
                                                            throw null;
                                                        }
                                                    case 19:
                                                    case 36:
                                                        bArr6 = bArr;
                                                        zzdwVar8 = zzdwVar;
                                                        zzfn zzfnVar3 = zzfnVar;
                                                        i21 = i44;
                                                        i8 = i40;
                                                        zzhiVar5 = zzhiVar;
                                                        unsafe5 = unsafe7;
                                                        i7 = i10;
                                                        zzgoVar = zzgoVar2;
                                                        if (i49 != 2) {
                                                            if (i49 == 5) {
                                                                if (zzfnVar3 == null) {
                                                                    Float.intBitsToFloat(LazyKt__LazyJVMKt.zzb(bArr6, i21));
                                                                    throw null;
                                                                }
                                                                throw new ClassCastException();
                                                            }
                                                            i22 = i21;
                                                            break;
                                                        } else if (zzfnVar3 != null) {
                                                            throw new ClassCastException();
                                                        } else if (LazyKt__LazyJVMKt.zzi(bArr6, i21, zzdwVar8) + zzdwVar8.zza > bArr6.length) {
                                                            throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        } else {
                                                            throw null;
                                                        }
                                                    case 20:
                                                    case 21:
                                                    case 37:
                                                    case 38:
                                                        bArr6 = bArr;
                                                        zzdwVar8 = zzdwVar;
                                                        zzfn zzfnVar4 = zzfnVar;
                                                        i21 = i44;
                                                        i8 = i40;
                                                        zzhiVar5 = zzhiVar;
                                                        unsafe5 = unsafe7;
                                                        i7 = i10;
                                                        zzgoVar = zzgoVar2;
                                                        if (i49 != 2) {
                                                            if (i49 == 0) {
                                                                if (zzfnVar4 == null) {
                                                                    LazyKt__LazyJVMKt.zzl(bArr6, i21, zzdwVar8);
                                                                    throw null;
                                                                }
                                                                throw new ClassCastException();
                                                            }
                                                            i22 = i21;
                                                            break;
                                                        } else if (zzfnVar4 == null) {
                                                            i22 = LazyKt__LazyJVMKt.zzi(bArr6, i21, zzdwVar8);
                                                            int i69 = zzdwVar8.zza + i22;
                                                            if (i22 < i69) {
                                                                LazyKt__LazyJVMKt.zzl(bArr6, i22, zzdwVar8);
                                                                throw null;
                                                            } else if (i22 != i69) {
                                                                throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                        } else {
                                                            throw new ClassCastException();
                                                        }
                                                        break;
                                                    case 22:
                                                    case 29:
                                                    case 39:
                                                    case 43:
                                                        zzdwVar9 = zzdwVar;
                                                        zzfn zzfnVar5 = zzfnVar;
                                                        i23 = i44;
                                                        i24 = i40;
                                                        bArr5 = bArr;
                                                        zzhiVar5 = zzhiVar;
                                                        unsafe5 = unsafe7;
                                                        i7 = i10;
                                                        zzgoVar = zzgoVar2;
                                                        if (i49 != 2) {
                                                            if (i49 == 0) {
                                                                i22 = LazyKt__LazyJVMKt.zzk(i24, bArr5, i23, i2, zzfnVar5, zzdwVar9);
                                                                i8 = i24;
                                                                i21 = i23;
                                                                zzdwVar8 = zzdwVar9;
                                                                bArr6 = bArr5;
                                                                break;
                                                            }
                                                            i21 = i23;
                                                            bArr6 = bArr5;
                                                            i8 = i24;
                                                            zzdwVar8 = zzdwVar9;
                                                            i22 = i21;
                                                            break;
                                                        } else {
                                                            i22 = LazyKt__LazyJVMKt.zzf(bArr5, i23, zzfnVar5, zzdwVar9);
                                                            i21 = i23;
                                                            bArr6 = bArr5;
                                                            i8 = i24;
                                                            zzdwVar8 = zzdwVar9;
                                                            break;
                                                        }
                                                    case 23:
                                                    case 32:
                                                    case 40:
                                                    case 46:
                                                        zzdwVar9 = zzdwVar;
                                                        zzfn zzfnVar6 = zzfnVar;
                                                        i23 = i44;
                                                        i24 = i40;
                                                        bArr5 = bArr;
                                                        zzhiVar5 = zzhiVar;
                                                        unsafe5 = unsafe7;
                                                        i7 = i10;
                                                        zzgoVar = zzgoVar2;
                                                        if (i49 != 2) {
                                                            if (i49 == 1) {
                                                                if (zzfnVar6 == null) {
                                                                    LazyKt__LazyJVMKt.zzo(bArr5, i23);
                                                                    throw null;
                                                                }
                                                                throw new ClassCastException();
                                                            }
                                                            i21 = i23;
                                                            bArr6 = bArr5;
                                                            i8 = i24;
                                                            zzdwVar8 = zzdwVar9;
                                                            i22 = i21;
                                                            break;
                                                        } else if (zzfnVar6 != null) {
                                                            throw new ClassCastException();
                                                        } else if (LazyKt__LazyJVMKt.zzi(bArr5, i23, zzdwVar9) + zzdwVar9.zza > bArr5.length) {
                                                            throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        } else {
                                                            throw null;
                                                        }
                                                    case 24:
                                                    case 31:
                                                    case 41:
                                                    case 45:
                                                        zzdwVar9 = zzdwVar;
                                                        zzfn zzfnVar7 = zzfnVar;
                                                        i23 = i44;
                                                        i24 = i40;
                                                        bArr5 = bArr;
                                                        zzhiVar5 = zzhiVar;
                                                        unsafe5 = unsafe7;
                                                        i7 = i10;
                                                        zzgoVar = zzgoVar2;
                                                        if (i49 != 2) {
                                                            if (i49 == 5) {
                                                                i22 = i23 + 4;
                                                                zzfj zzfjVar = (zzfj) zzfnVar7;
                                                                zzfjVar.zzg(LazyKt__LazyJVMKt.zzb(bArr5, i23));
                                                                while (i22 < i2) {
                                                                    int zzi5 = LazyKt__LazyJVMKt.zzi(bArr5, i22, zzdwVar9);
                                                                    if (i24 == zzdwVar9.zza) {
                                                                        zzfjVar.zzg(LazyKt__LazyJVMKt.zzb(bArr5, zzi5));
                                                                        i22 = zzi5 + 4;
                                                                    }
                                                                }
                                                            }
                                                            i21 = i23;
                                                            bArr6 = bArr5;
                                                            i8 = i24;
                                                            zzdwVar8 = zzdwVar9;
                                                            i22 = i21;
                                                            break;
                                                        } else {
                                                            zzfj zzfjVar2 = (zzfj) zzfnVar7;
                                                            int zzi6 = LazyKt__LazyJVMKt.zzi(bArr5, i23, zzdwVar9);
                                                            int i70 = zzdwVar9.zza;
                                                            int i71 = zzi6 + i70;
                                                            if (i71 <= bArr5.length) {
                                                                int i72 = (i70 / 4) + zzfjVar2.zzd;
                                                                int length2 = zzfjVar2.zzc.length;
                                                                if (i72 > length2) {
                                                                    if (length2 != 0) {
                                                                        while (length2 < i72) {
                                                                            length2 = Math.max(((length2 * 3) / 2) + 1, 10);
                                                                        }
                                                                        zzfjVar2.zzc = Arrays.copyOf(zzfjVar2.zzc, length2);
                                                                    } else {
                                                                        zzfjVar2.zzc = new int[Math.max(i72, 10)];
                                                                    }
                                                                }
                                                                while (zzi6 < i71) {
                                                                    zzfjVar2.zzg(LazyKt__LazyJVMKt.zzb(bArr5, zzi6));
                                                                    zzi6 += 4;
                                                                }
                                                                if (zzi6 == i71) {
                                                                    i22 = zzi6;
                                                                } else {
                                                                    throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                }
                                                            } else {
                                                                throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                        }
                                                        i21 = i23;
                                                        bArr6 = bArr5;
                                                        i8 = i24;
                                                        zzdwVar8 = zzdwVar9;
                                                        break;
                                                    case 25:
                                                    case 42:
                                                        zzdwVar9 = zzdwVar;
                                                        zzfn zzfnVar8 = zzfnVar;
                                                        i23 = i44;
                                                        i24 = i40;
                                                        bArr5 = bArr;
                                                        zzhiVar5 = zzhiVar;
                                                        unsafe5 = unsafe7;
                                                        i7 = i10;
                                                        zzgoVar = zzgoVar2;
                                                        if (i49 != 2) {
                                                            if (i49 == 0) {
                                                                if (zzfnVar8 == null) {
                                                                    LazyKt__LazyJVMKt.zzl(bArr5, i23, zzdwVar9);
                                                                    throw null;
                                                                }
                                                                throw new ClassCastException();
                                                            }
                                                            i21 = i23;
                                                            bArr6 = bArr5;
                                                            i8 = i24;
                                                            zzdwVar8 = zzdwVar9;
                                                            i22 = i21;
                                                            break;
                                                        } else if (zzfnVar8 == null) {
                                                            i22 = LazyKt__LazyJVMKt.zzi(bArr5, i23, zzdwVar9);
                                                            int i73 = zzdwVar9.zza + i22;
                                                            if (i22 >= i73) {
                                                                if (i22 != i73) {
                                                                    throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                }
                                                                i21 = i23;
                                                                bArr6 = bArr5;
                                                                i8 = i24;
                                                                zzdwVar8 = zzdwVar9;
                                                                break;
                                                            } else {
                                                                LazyKt__LazyJVMKt.zzl(bArr5, i22, zzdwVar9);
                                                                throw null;
                                                            }
                                                        } else {
                                                            throw new ClassCastException();
                                                        }
                                                    case 26:
                                                        zzfn zzfnVar9 = zzfnVar;
                                                        int i74 = i40;
                                                        zzhiVar5 = zzhiVar;
                                                        unsafe5 = unsafe7;
                                                        i7 = i10;
                                                        zzgoVar = zzgoVar2;
                                                        if (i49 != 2) {
                                                            bArr6 = bArr;
                                                            i21 = i44;
                                                            zzdwVar8 = zzdwVar;
                                                            i8 = i74;
                                                            i22 = i21;
                                                            break;
                                                        } else if ((j3 & 536870912) == 0) {
                                                            i22 = LazyKt__LazyJVMKt.zzi(bArr, i44, zzdwVar);
                                                            int i75 = zzdwVar.zza;
                                                            if (i75 < 0) {
                                                                throw new IOException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            } else if (i75 == 0) {
                                                                zzfnVar9.add("");
                                                                while (i22 < i2) {
                                                                    int zzi7 = LazyKt__LazyJVMKt.zzi(bArr, i22, zzdwVar);
                                                                    if (i74 != zzdwVar.zza) {
                                                                        bArr6 = bArr;
                                                                        i21 = i44;
                                                                        zzdwVar8 = zzdwVar;
                                                                        i8 = i74;
                                                                        break;
                                                                    } else {
                                                                        i22 = LazyKt__LazyJVMKt.zzi(bArr, zzi7, zzdwVar);
                                                                        i75 = zzdwVar.zza;
                                                                        if (i75 < 0) {
                                                                            throw new IOException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        } else if (i75 == 0) {
                                                                            zzfnVar9.add("");
                                                                        } else {
                                                                            zzfnVar9.add(new String(bArr, i22, i75, zzfo.zza));
                                                                            i22 += i75;
                                                                            while (i22 < i2) {
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                bArr6 = bArr;
                                                                i21 = i44;
                                                                zzdwVar8 = zzdwVar;
                                                                i8 = i74;
                                                            } else {
                                                                zzfnVar9.add(new String(bArr, i22, i75, zzfo.zza));
                                                                i22 += i75;
                                                                while (i22 < i2) {
                                                                }
                                                                bArr6 = bArr;
                                                                i21 = i44;
                                                                zzdwVar8 = zzdwVar;
                                                                i8 = i74;
                                                            }
                                                        } else {
                                                            i22 = LazyKt__LazyJVMKt.zzi(bArr, i44, zzdwVar);
                                                            int i76 = zzdwVar.zza;
                                                            if (i76 >= 0) {
                                                                if (i76 == 0) {
                                                                    zzfnVar9.add("");
                                                                    i25 = i44;
                                                                } else {
                                                                    int i77 = i22 + i76;
                                                                    if (zzhr.zzd(bArr, i22, i77)) {
                                                                        i25 = i44;
                                                                        zzfnVar9.add(new String(bArr, i22, i76, zzfo.zza));
                                                                        i22 = i77;
                                                                    } else {
                                                                        throw new IOException("Protocol message had invalid UTF-8.");
                                                                    }
                                                                }
                                                                while (i22 < i2) {
                                                                    int zzi8 = LazyKt__LazyJVMKt.zzi(bArr, i22, zzdwVar);
                                                                    if (i74 != zzdwVar.zza) {
                                                                        i8 = i74;
                                                                        bArr6 = bArr;
                                                                        zzdwVar8 = zzdwVar;
                                                                        i21 = i25;
                                                                        break;
                                                                    } else {
                                                                        i22 = LazyKt__LazyJVMKt.zzi(bArr, zzi8, zzdwVar);
                                                                        int i78 = zzdwVar.zza;
                                                                        if (i78 < 0) {
                                                                            throw new IOException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        } else if (i78 == 0) {
                                                                            zzfnVar9.add("");
                                                                        } else {
                                                                            int i79 = i22 + i78;
                                                                            if (zzhr.zzd(bArr, i22, i79)) {
                                                                                i74 = i74;
                                                                                zzfnVar9.add(new String(bArr, i22, i78, zzfo.zza));
                                                                                i22 = i79;
                                                                            } else {
                                                                                throw new IOException("Protocol message had invalid UTF-8.");
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                i8 = i74;
                                                                bArr6 = bArr;
                                                                zzdwVar8 = zzdwVar;
                                                                i21 = i25;
                                                            } else {
                                                                throw new IOException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                        }
                                                    case 27:
                                                        bArr6 = bArr;
                                                        zzdwVar10 = zzdwVar;
                                                        i26 = i44;
                                                        i27 = i40;
                                                        zzhiVar5 = zzhiVar;
                                                        unsafe5 = unsafe7;
                                                        i7 = i10;
                                                        if (i49 == 2) {
                                                            zzgoVar = this;
                                                            i22 = LazyKt__LazyJVMKt.zze(zzgoVar.zzv(i68), i27, bArr6, i26, i2, zzfnVar, zzdwVar10);
                                                            i8 = i27;
                                                            i21 = i26;
                                                            zzdwVar8 = zzdwVar10;
                                                            break;
                                                        }
                                                        zzgoVar = this;
                                                        i21 = i26;
                                                        zzdwVar8 = zzdwVar10;
                                                        i8 = i27;
                                                        i22 = i21;
                                                        break;
                                                    case 28:
                                                        bArr6 = bArr;
                                                        zzdwVar10 = zzdwVar;
                                                        i26 = i44;
                                                        i27 = i40;
                                                        zzhiVar5 = zzhiVar;
                                                        unsafe5 = unsafe7;
                                                        i7 = i10;
                                                        if (i49 == 2) {
                                                            i22 = LazyKt__LazyJVMKt.zzi(bArr6, i26, zzdwVar10);
                                                            int i80 = zzdwVar10.zza;
                                                            if (i80 < 0) {
                                                                throw new IOException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            } else if (i80 > bArr6.length - i22) {
                                                                throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            } else if (i80 == 0) {
                                                                zzfnVar.add(zzeg.zzb);
                                                                while (i22 < i2) {
                                                                    int zzi9 = LazyKt__LazyJVMKt.zzi(bArr6, i22, zzdwVar10);
                                                                    if (i27 != zzdwVar10.zza) {
                                                                        zzgoVar = this;
                                                                        i21 = i26;
                                                                        zzdwVar8 = zzdwVar10;
                                                                        i8 = i27;
                                                                        break;
                                                                    } else {
                                                                        i22 = LazyKt__LazyJVMKt.zzi(bArr6, zzi9, zzdwVar10);
                                                                        i80 = zzdwVar10.zza;
                                                                        if (i80 < 0) {
                                                                            throw new IOException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                                        } else if (i80 > bArr6.length - i22) {
                                                                            throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                        } else if (i80 == 0) {
                                                                            zzfnVar.add(zzeg.zzb);
                                                                        } else {
                                                                            zzfnVar.add(zzeg.zzj(bArr6, i22, i80));
                                                                            i22 += i80;
                                                                            while (i22 < i2) {
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                zzgoVar = this;
                                                                i21 = i26;
                                                                zzdwVar8 = zzdwVar10;
                                                                i8 = i27;
                                                            } else {
                                                                zzfnVar.add(zzeg.zzj(bArr6, i22, i80));
                                                                i22 += i80;
                                                                while (i22 < i2) {
                                                                }
                                                                zzgoVar = this;
                                                                i21 = i26;
                                                                zzdwVar8 = zzdwVar10;
                                                                i8 = i27;
                                                            }
                                                        }
                                                        zzgoVar = this;
                                                        i21 = i26;
                                                        zzdwVar8 = zzdwVar10;
                                                        i8 = i27;
                                                        i22 = i21;
                                                        break;
                                                    case 30:
                                                    case 44:
                                                        bArr6 = bArr;
                                                        if (i49 != 2) {
                                                            if (i49 != 0) {
                                                                zzhiVar5 = zzhiVar;
                                                                unsafe5 = unsafe7;
                                                                i7 = i10;
                                                                zzgoVar = this;
                                                                zzdwVar8 = zzdwVar;
                                                                i8 = i40;
                                                                i21 = i44;
                                                                i22 = i21;
                                                                break;
                                                            } else {
                                                                int zzk = LazyKt__LazyJVMKt.zzk(i40, bArr6, i44, i2, zzfnVar, zzdwVar);
                                                                i28 = i44;
                                                                bArr6 = bArr6;
                                                                i29 = zzk;
                                                            }
                                                        } else {
                                                            i29 = LazyKt__LazyJVMKt.zzf(bArr6, i44, zzfnVar, zzdwVar);
                                                            i28 = i44;
                                                        }
                                                        zzfl zzu2 = zzgoVar2.zzu(i68);
                                                        zza zzaVar = zzgx.zzb;
                                                        if (zzu2 != null) {
                                                            zza zzaVar2 = zzgoVar2.zzl;
                                                            if (zzfnVar != null) {
                                                                int size2 = zzfnVar.size();
                                                                i30 = i29;
                                                                zzhiVar5 = zzhiVar;
                                                                Object obj9 = null;
                                                                int i81 = 0;
                                                                int i82 = 0;
                                                                while (i82 < size2) {
                                                                    unsafe7 = unsafe7;
                                                                    Integer num = (Integer) zzfnVar.get(i82);
                                                                    int intValue = num.intValue();
                                                                    if (zzu2.zza(intValue)) {
                                                                        if (i82 != i81) {
                                                                            zzfnVar.set(i81, num);
                                                                        }
                                                                        i81++;
                                                                        i31 = i10;
                                                                    } else {
                                                                        i31 = i10;
                                                                        obj9 = zzgx.zzn(obj2, i31, intValue, obj9, zzaVar2);
                                                                    }
                                                                    i82++;
                                                                    i10 = i31;
                                                                }
                                                                unsafe5 = unsafe7;
                                                                i7 = i10;
                                                                if (i81 != size2) {
                                                                    zzfnVar.subList(i81, size2).clear();
                                                                }
                                                            } else {
                                                                i30 = i29;
                                                                zzhiVar5 = zzhiVar;
                                                                unsafe5 = unsafe7;
                                                                i7 = i10;
                                                                Iterator it = zzfnVar.iterator();
                                                                while (it.hasNext()) {
                                                                    int intValue2 = ((Integer) it.next()).intValue();
                                                                    if (!zzu2.zza(intValue2)) {
                                                                        obj8 = zzgx.zzn(obj2, i7, intValue2, obj8, zzaVar2);
                                                                        it.remove();
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            i30 = i29;
                                                            zzhiVar5 = zzhiVar;
                                                            unsafe5 = unsafe7;
                                                            i7 = i10;
                                                        }
                                                        zzgoVar = this;
                                                        i21 = i28;
                                                        zzdwVar8 = zzdwVar;
                                                        i8 = i40;
                                                        i22 = i30;
                                                        break;
                                                    case 33:
                                                    case 47:
                                                        bArr6 = bArr;
                                                        zzdwVar11 = zzdwVar;
                                                        i32 = i44;
                                                        i33 = i40;
                                                        if (i49 != 2) {
                                                            if (i49 == 0) {
                                                                zzfj zzfjVar3 = (zzfj) zzfnVar;
                                                                int zzi10 = LazyKt__LazyJVMKt.zzi(bArr6, i32, zzdwVar11);
                                                                int i83 = zzdwVar11.zza;
                                                                zzfjVar3.zzg((i83 >>> 1) ^ (-(i83 & 1)));
                                                                while (zzi10 < i2) {
                                                                    int zzi11 = LazyKt__LazyJVMKt.zzi(bArr6, zzi10, zzdwVar11);
                                                                    if (i33 != zzdwVar11.zza) {
                                                                        zzdwVar8 = zzdwVar11;
                                                                        zzhiVar5 = zzhiVar;
                                                                        unsafe5 = unsafe7;
                                                                        i8 = i33;
                                                                        i21 = i32;
                                                                        i7 = i10;
                                                                        zzgoVar = zzgoVar2;
                                                                        i22 = zzi10;
                                                                        break;
                                                                    } else {
                                                                        zzi10 = LazyKt__LazyJVMKt.zzi(bArr6, zzi11, zzdwVar11);
                                                                        int i84 = zzdwVar11.zza;
                                                                        zzfjVar3.zzg((i84 >>> 1) ^ (-(i84 & 1)));
                                                                    }
                                                                }
                                                                zzdwVar8 = zzdwVar11;
                                                                zzhiVar5 = zzhiVar;
                                                                unsafe5 = unsafe7;
                                                                i8 = i33;
                                                                i21 = i32;
                                                                i7 = i10;
                                                                zzgoVar = zzgoVar2;
                                                                i22 = zzi10;
                                                            }
                                                            zzdwVar8 = zzdwVar11;
                                                            zzhiVar5 = zzhiVar;
                                                            unsafe5 = unsafe7;
                                                            i8 = i33;
                                                            i21 = i32;
                                                            i7 = i10;
                                                            zzgoVar = zzgoVar2;
                                                            i22 = i21;
                                                            break;
                                                        } else {
                                                            zzfj zzfjVar4 = (zzfj) zzfnVar;
                                                            zzi = LazyKt__LazyJVMKt.zzi(bArr6, i32, zzdwVar11);
                                                            int i85 = zzdwVar11.zza + zzi;
                                                            while (zzi < i85) {
                                                                zzi = LazyKt__LazyJVMKt.zzi(bArr6, zzi, zzdwVar11);
                                                                int i86 = zzdwVar11.zza;
                                                                zzfjVar4.zzg((i86 >>> 1) ^ (-(i86 & 1)));
                                                            }
                                                            if (zzi != i85) {
                                                                throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                            }
                                                            zzdwVar8 = zzdwVar11;
                                                            zzhiVar5 = zzhiVar;
                                                            unsafe5 = unsafe7;
                                                            i8 = i33;
                                                            i21 = i32;
                                                            i7 = i10;
                                                            zzgoVar = zzgoVar2;
                                                            i22 = zzi;
                                                            break;
                                                        }
                                                    case 34:
                                                    case 48:
                                                        bArr6 = bArr;
                                                        zzdwVar11 = zzdwVar;
                                                        i32 = i44;
                                                        i33 = i40;
                                                        if (i49 != 2) {
                                                            if (i49 == 0) {
                                                                if (zzfnVar == null) {
                                                                    LazyKt__LazyJVMKt.zzl(bArr6, i32, zzdwVar11);
                                                                    throw null;
                                                                }
                                                                throw new ClassCastException();
                                                            }
                                                            zzdwVar8 = zzdwVar11;
                                                            zzhiVar5 = zzhiVar;
                                                            unsafe5 = unsafe7;
                                                            i8 = i33;
                                                            i21 = i32;
                                                            i7 = i10;
                                                            zzgoVar = zzgoVar2;
                                                            i22 = i21;
                                                            break;
                                                        } else if (zzfnVar == null) {
                                                            zzi = LazyKt__LazyJVMKt.zzi(bArr6, i32, zzdwVar11);
                                                            int i87 = zzdwVar11.zza + zzi;
                                                            if (zzi >= i87) {
                                                                if (zzi != i87) {
                                                                    throw new IOException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                                }
                                                                zzdwVar8 = zzdwVar11;
                                                                zzhiVar5 = zzhiVar;
                                                                unsafe5 = unsafe7;
                                                                i8 = i33;
                                                                i21 = i32;
                                                                i7 = i10;
                                                                zzgoVar = zzgoVar2;
                                                                i22 = zzi;
                                                                break;
                                                            } else {
                                                                LazyKt__LazyJVMKt.zzl(bArr6, zzi, zzdwVar11);
                                                                throw null;
                                                            }
                                                        } else {
                                                            throw new ClassCastException();
                                                        }
                                                    default:
                                                        if (i49 != 3) {
                                                            bArr6 = bArr;
                                                            zzdwVar8 = zzdwVar;
                                                            i21 = i44;
                                                            i8 = i40;
                                                            zzhiVar5 = zzhiVar;
                                                            unsafe5 = unsafe7;
                                                            i7 = i10;
                                                            zzgoVar = zzgoVar2;
                                                            i22 = i21;
                                                            break;
                                                        } else {
                                                            int i88 = (i40 & (-8)) | 4;
                                                            zzgv zzv = zzgoVar2.zzv(i68);
                                                            zzfi zze = zzv.zze();
                                                            bArr6 = bArr;
                                                            int zzm = LazyKt__LazyJVMKt.zzm(zze, zzv, bArr6, i44, i2, i88, zzdwVar);
                                                            int i89 = i88;
                                                            zzdw zzdwVar13 = zzdwVar;
                                                            zzv.zzf(zze);
                                                            zzdwVar13.zzc = zze;
                                                            zzfnVar.add(zze);
                                                            while (zzm < i2) {
                                                                int zzi12 = LazyKt__LazyJVMKt.zzi(bArr6, zzm, zzdwVar13);
                                                                if (i40 != zzdwVar13.zza) {
                                                                    zzdwVar8 = zzdwVar13;
                                                                    zzhiVar5 = zzhiVar;
                                                                    unsafe5 = unsafe7;
                                                                    i8 = i40;
                                                                    i21 = i44;
                                                                    i7 = i10;
                                                                    zzgoVar = zzgoVar2;
                                                                    i22 = zzm;
                                                                    break;
                                                                } else {
                                                                    int i90 = i89;
                                                                    zzfi zze2 = zzv.zze();
                                                                    zzm = LazyKt__LazyJVMKt.zzm(zze2, zzv, bArr6, zzi12, i2, i90, zzdwVar);
                                                                    i89 = i90;
                                                                    zzdwVar13 = zzdwVar;
                                                                    zzv.zzf(zze2);
                                                                    zzdwVar13.zzc = zze2;
                                                                    zzfnVar.add(zze2);
                                                                }
                                                            }
                                                            zzdwVar8 = zzdwVar13;
                                                            zzhiVar5 = zzhiVar;
                                                            unsafe5 = unsafe7;
                                                            i8 = i40;
                                                            i21 = i44;
                                                            i7 = i10;
                                                            zzgoVar = zzgoVar2;
                                                            i22 = zzm;
                                                        }
                                                }
                                                if (i22 != i21) {
                                                    i34 = i2;
                                                    zzdwVar12 = zzdwVar8;
                                                    i40 = i8;
                                                    i36 = i7;
                                                    obj6 = obj2;
                                                    i39 = i67;
                                                    i38 = i6;
                                                    unsafe6 = unsafe5;
                                                    i41 = 1048575;
                                                    i35 = i22;
                                                    zzgoVar2 = zzgoVar;
                                                    i37 = i68;
                                                } else {
                                                    zzdwVar2 = zzdwVar8;
                                                    i9 = i68;
                                                    i39 = i67;
                                                    zzhiVar = zzhiVar5;
                                                    unsafe = unsafe5;
                                                    i35 = i22;
                                                    i4 = i3;
                                                }
                                            } else {
                                                i8 = i40;
                                                i18 = i44;
                                                zzhiVar3 = zzhiVar;
                                                i7 = i10;
                                                bArr6 = bArr;
                                                zzgo zzgoVar3 = zzgoVar2;
                                                if (zzr != 50) {
                                                    long j4 = iArr[i68 + 2] & 1048575;
                                                    switch (zzr) {
                                                        case 51:
                                                            zzdwVar2 = zzdwVar;
                                                            i19 = i18;
                                                            zzhiVar = zzhiVar3;
                                                            i9 = i68;
                                                            unsafe = unsafe7;
                                                            if (i49 == 1) {
                                                                i20 = i19 + 8;
                                                                unsafe.putObject(obj2, j, Double.valueOf(Double.longBitsToDouble(LazyKt__LazyJVMKt.zzo(bArr6, i19))));
                                                                unsafe.putInt(obj2, j4, i7);
                                                                break;
                                                            }
                                                            i20 = i19;
                                                            break;
                                                        case 52:
                                                            zzdwVar2 = zzdwVar;
                                                            i19 = i18;
                                                            zzhiVar = zzhiVar3;
                                                            i9 = i68;
                                                            unsafe = unsafe7;
                                                            if (i49 == 5) {
                                                                i20 = i19 + 4;
                                                                unsafe.putObject(obj2, j, Float.valueOf(Float.intBitsToFloat(LazyKt__LazyJVMKt.zzb(bArr6, i19))));
                                                                unsafe.putInt(obj2, j4, i7);
                                                                break;
                                                            }
                                                            i20 = i19;
                                                            break;
                                                        case 53:
                                                        case 54:
                                                            zzdwVar2 = zzdwVar;
                                                            i19 = i18;
                                                            zzhiVar = zzhiVar3;
                                                            i9 = i68;
                                                            unsafe = unsafe7;
                                                            if (i49 == 0) {
                                                                i20 = LazyKt__LazyJVMKt.zzl(bArr6, i19, zzdwVar2);
                                                                unsafe.putObject(obj2, j, Long.valueOf(zzdwVar2.zzb));
                                                                unsafe.putInt(obj2, j4, i7);
                                                                break;
                                                            }
                                                            i20 = i19;
                                                            break;
                                                        case 55:
                                                        case 62:
                                                            zzdwVar2 = zzdwVar;
                                                            i19 = i18;
                                                            zzhiVar = zzhiVar3;
                                                            i9 = i68;
                                                            unsafe = unsafe7;
                                                            if (i49 == 0) {
                                                                i20 = LazyKt__LazyJVMKt.zzi(bArr6, i19, zzdwVar2);
                                                                unsafe.putObject(obj2, j, Integer.valueOf(zzdwVar2.zza));
                                                                unsafe.putInt(obj2, j4, i7);
                                                                break;
                                                            }
                                                            i20 = i19;
                                                            break;
                                                        case 56:
                                                        case 65:
                                                            zzdwVar2 = zzdwVar;
                                                            i19 = i18;
                                                            zzhiVar = zzhiVar3;
                                                            i9 = i68;
                                                            unsafe = unsafe7;
                                                            if (i49 == 1) {
                                                                i20 = i19 + 8;
                                                                unsafe.putObject(obj2, j, Long.valueOf(LazyKt__LazyJVMKt.zzo(bArr6, i19)));
                                                                unsafe.putInt(obj2, j4, i7);
                                                                break;
                                                            }
                                                            i20 = i19;
                                                            break;
                                                        case 57:
                                                        case 64:
                                                            zzdwVar2 = zzdwVar;
                                                            i19 = i18;
                                                            zzhiVar = zzhiVar3;
                                                            i9 = i68;
                                                            unsafe = unsafe7;
                                                            if (i49 == 5) {
                                                                i20 = i19 + 4;
                                                                unsafe.putObject(obj2, j, Integer.valueOf(LazyKt__LazyJVMKt.zzb(bArr6, i19)));
                                                                unsafe.putInt(obj2, j4, i7);
                                                                break;
                                                            }
                                                            i20 = i19;
                                                            break;
                                                        case 58:
                                                            zzdwVar2 = zzdwVar;
                                                            i19 = i18;
                                                            zzhiVar = zzhiVar3;
                                                            i9 = i68;
                                                            unsafe = unsafe7;
                                                            if (i49 == 0) {
                                                                i20 = LazyKt__LazyJVMKt.zzl(bArr6, i19, zzdwVar2);
                                                                unsafe.putObject(obj2, j, Boolean.valueOf(zzdwVar2.zzb != 0));
                                                                unsafe.putInt(obj2, j4, i7);
                                                                break;
                                                            }
                                                            i20 = i19;
                                                            break;
                                                        case 59:
                                                            zzdwVar2 = zzdwVar;
                                                            i19 = i18;
                                                            zzhiVar = zzhiVar3;
                                                            i9 = i68;
                                                            unsafe = unsafe7;
                                                            if (i49 == 2) {
                                                                i20 = LazyKt__LazyJVMKt.zzi(bArr6, i19, zzdwVar2);
                                                                int i91 = zzdwVar2.zza;
                                                                if (i91 == 0) {
                                                                    unsafe.putObject(obj2, j, "");
                                                                } else {
                                                                    int i92 = i20 + i91;
                                                                    if ((i50 & 536870912) == 0 || zzhr.zzd(bArr6, i20, i92)) {
                                                                        unsafe.putObject(obj2, j, new String(bArr6, i20, i91, zzfo.zza));
                                                                        i20 = i92;
                                                                    } else {
                                                                        throw new IOException("Protocol message had invalid UTF-8.");
                                                                    }
                                                                }
                                                                unsafe.putInt(obj2, j4, i7);
                                                                break;
                                                            }
                                                            i20 = i19;
                                                            break;
                                                        case 60:
                                                            zzdwVar7 = zzdwVar;
                                                            unsafe4 = unsafe7;
                                                            i19 = i18;
                                                            if (i49 == 2) {
                                                                Object zzy = zzgoVar3.zzy(i7, i68, obj2);
                                                                int zzn = LazyKt__LazyJVMKt.zzn(zzy, zzgoVar3.zzv(i68), bArr6, i19, i2, zzdwVar7);
                                                                zzdwVar2 = zzdwVar7;
                                                                zzgoVar3.zzG(i7, i68, obj2, zzy);
                                                                i20 = zzn;
                                                                i9 = i68;
                                                                unsafe = unsafe4;
                                                                zzhiVar = zzhiVar3;
                                                                break;
                                                            }
                                                            zzdwVar2 = zzdwVar7;
                                                            i9 = i68;
                                                            unsafe = unsafe4;
                                                            zzhiVar = zzhiVar3;
                                                            i20 = i19;
                                                            break;
                                                        case 61:
                                                            zzdwVar7 = zzdwVar;
                                                            unsafe4 = unsafe7;
                                                            i19 = i18;
                                                            if (i49 == 2) {
                                                                i20 = LazyKt__LazyJVMKt.zza(bArr6, i19, zzdwVar7);
                                                                unsafe4.putObject(obj2, j, zzdwVar7.zzc);
                                                                unsafe4.putInt(obj2, j4, i7);
                                                                zzdwVar2 = zzdwVar7;
                                                                i9 = i68;
                                                                unsafe = unsafe4;
                                                                zzhiVar = zzhiVar3;
                                                                break;
                                                            }
                                                            zzdwVar2 = zzdwVar7;
                                                            i9 = i68;
                                                            unsafe = unsafe4;
                                                            zzhiVar = zzhiVar3;
                                                            i20 = i19;
                                                            break;
                                                        case 63:
                                                            zzdwVar7 = zzdwVar;
                                                            unsafe4 = unsafe7;
                                                            i19 = i18;
                                                            if (i49 != 0) {
                                                                zzdwVar2 = zzdwVar7;
                                                                i9 = i68;
                                                                unsafe = unsafe4;
                                                                zzhiVar = zzhiVar3;
                                                                i20 = i19;
                                                                break;
                                                            } else {
                                                                i20 = LazyKt__LazyJVMKt.zzi(bArr6, i19, zzdwVar7);
                                                                int i93 = zzdwVar7.zza;
                                                                zzfl zzu3 = zzu(i68);
                                                                if (zzu3 == null || zzu3.zza(i93)) {
                                                                    zzhiVar4 = zzhiVar3;
                                                                    unsafe4.putObject(obj2, j, Integer.valueOf(i93));
                                                                    unsafe4.putInt(obj2, j4, i7);
                                                                } else {
                                                                    zzfi zzfiVar2 = (zzfi) obj2;
                                                                    zzhi zzhiVar7 = zzfiVar2.zzc;
                                                                    zzhiVar4 = zzhiVar3;
                                                                    if (zzhiVar7 == zzhiVar4) {
                                                                        zzhiVar7 = zzhi.zzf();
                                                                        zzfiVar2.zzc = zzhiVar7;
                                                                    }
                                                                    zzhiVar7.zzj(i8, Long.valueOf(i93));
                                                                }
                                                                zzdwVar2 = zzdwVar7;
                                                                zzhiVar = zzhiVar4;
                                                                i9 = i68;
                                                                unsafe = unsafe4;
                                                                break;
                                                            }
                                                            break;
                                                        case 66:
                                                            zzdwVar7 = zzdwVar;
                                                            unsafe4 = unsafe7;
                                                            i19 = i18;
                                                            if (i49 == 0) {
                                                                i20 = LazyKt__LazyJVMKt.zzi(bArr6, i19, zzdwVar7);
                                                                int i94 = zzdwVar7.zza;
                                                                unsafe4.putObject(obj2, j, Integer.valueOf((i94 >>> 1) ^ (-(i94 & 1))));
                                                                unsafe4.putInt(obj2, j4, i7);
                                                                zzdwVar2 = zzdwVar7;
                                                                i9 = i68;
                                                                unsafe = unsafe4;
                                                                zzhiVar = zzhiVar3;
                                                                break;
                                                            }
                                                            zzdwVar2 = zzdwVar7;
                                                            i9 = i68;
                                                            unsafe = unsafe4;
                                                            zzhiVar = zzhiVar3;
                                                            i20 = i19;
                                                            break;
                                                        case 67:
                                                            zzdwVar7 = zzdwVar;
                                                            unsafe4 = unsafe7;
                                                            i19 = i18;
                                                            if (i49 == 0) {
                                                                i20 = LazyKt__LazyJVMKt.zzl(bArr6, i19, zzdwVar7);
                                                                long j5 = zzdwVar7.zzb;
                                                                unsafe4.putObject(obj2, j, Long.valueOf((j5 >>> 1) ^ (-(j5 & 1))));
                                                                unsafe4.putInt(obj2, j4, i7);
                                                                zzdwVar2 = zzdwVar7;
                                                                i9 = i68;
                                                                unsafe = unsafe4;
                                                                zzhiVar = zzhiVar3;
                                                                break;
                                                            }
                                                            zzdwVar2 = zzdwVar7;
                                                            i9 = i68;
                                                            unsafe = unsafe4;
                                                            zzhiVar = zzhiVar3;
                                                            i20 = i19;
                                                            break;
                                                        case 68:
                                                            if (i49 == 3) {
                                                                Object zzy2 = zzgoVar3.zzy(i7, i68, obj2);
                                                                i19 = i18;
                                                                unsafe4 = unsafe7;
                                                                int zzm2 = LazyKt__LazyJVMKt.zzm(zzy2, zzgoVar3.zzv(i68), bArr6, i19, i2, (i8 & (-8)) | 4, zzdwVar);
                                                                zzdwVar7 = zzdwVar;
                                                                zzgoVar3.zzG(i7, i68, obj2, zzy2);
                                                                i20 = zzm2;
                                                                zzdwVar2 = zzdwVar7;
                                                                i9 = i68;
                                                                unsafe = unsafe4;
                                                                zzhiVar = zzhiVar3;
                                                                break;
                                                            }
                                                        default:
                                                            zzdwVar2 = zzdwVar;
                                                            i19 = i18;
                                                            zzhiVar = zzhiVar3;
                                                            i9 = i68;
                                                            unsafe = unsafe7;
                                                            i20 = i19;
                                                            break;
                                                    }
                                                    if (i20 != i19) {
                                                        zzgoVar2 = this;
                                                        i35 = i20;
                                                        zzdwVar12 = zzdwVar2;
                                                        i40 = i8;
                                                        i36 = i7;
                                                        unsafe6 = unsafe;
                                                        obj6 = obj2;
                                                        i37 = i9;
                                                        i39 = i67;
                                                        i38 = i6;
                                                        i41 = 1048575;
                                                        i34 = i2;
                                                    } else {
                                                        i4 = i3;
                                                        i35 = i20;
                                                        i39 = i67;
                                                    }
                                                } else if (i49 == 2) {
                                                    int i95 = i68 / 3;
                                                    Object obj10 = objArr[i95 + i95];
                                                    Object object = unsafe7.getObject(obj2, j);
                                                    if (!((zzgf) object).zzb) {
                                                        zzgf zzgfVar2 = zzgf.zza;
                                                        if (zzgfVar2.isEmpty()) {
                                                            zzgfVar = new zzgf();
                                                        } else {
                                                            ?? linkedHashMap = new LinkedHashMap(zzgfVar2);
                                                            linkedHashMap.zzb = true;
                                                            zzgfVar = linkedHashMap;
                                                        }
                                                        zza.zza(zzgfVar, object);
                                                        unsafe7.putObject(obj2, j, zzgfVar);
                                                    }
                                                    obj10.getClass();
                                                    throw new ClassCastException();
                                                } else {
                                                    unsafe3 = unsafe7;
                                                }
                                            }
                                        } else if (i49 == 2) {
                                            zzfn zzfnVar10 = (zzfn) unsafe7.getObject(obj7, j);
                                            if (!((zzdu) zzfnVar10).zza) {
                                                int size3 = zzfnVar10.size();
                                                zzfnVar10 = zzfnVar10.zzd(size3 == 0 ? 10 : size3 + size3);
                                                unsafe7.putObject(obj7, j, zzfnVar10);
                                            }
                                            i34 = i2;
                                            i35 = LazyKt__LazyJVMKt.zze(zzgoVar2.zzv(i68), i40, bArr, i44, i34, zzfnVar10, zzdwVar);
                                            bArr6 = bArr;
                                            zzdwVar12 = zzdwVar;
                                            i40 = i40;
                                            unsafe6 = unsafe7;
                                            i37 = i68;
                                            obj6 = obj;
                                            i39 = i67;
                                            i38 = i6;
                                        } else {
                                            obj2 = obj7;
                                            bArr6 = bArr;
                                            unsafe3 = unsafe7;
                                            i8 = i40;
                                            i18 = i44;
                                            i7 = i10;
                                            zzhiVar3 = zzhiVar;
                                        }
                                        i4 = i3;
                                        zzdwVar2 = zzdwVar;
                                        i35 = i18;
                                        i39 = i67;
                                        zzhiVar = zzhiVar3;
                                        i9 = i68;
                                        unsafe = unsafe3;
                                    }
                                }
                                if (i8 == i4 || i4 == 0) {
                                    zzfi zzfiVar3 = (zzfi) obj2;
                                    zzhiVar2 = zzfiVar3.zzc;
                                    if (zzhiVar2 == zzhiVar) {
                                        zzhiVar2 = zzhi.zzf();
                                        zzfiVar3.zzc = zzhiVar2;
                                    }
                                    int i96 = i8;
                                    int zzh = LazyKt__LazyJVMKt.zzh(i96, bArr6, i35, i2, zzhiVar2, zzdwVar2);
                                    zzgoVar2 = this;
                                    zzdwVar12 = zzdwVar;
                                    i40 = i96;
                                    i34 = i2;
                                    i36 = i7;
                                    unsafe6 = unsafe;
                                    obj6 = obj2;
                                    i37 = i9;
                                    i38 = i6;
                                    i41 = 1048575;
                                    i35 = zzh;
                                    bArr6 = bArr;
                                } else {
                                    i34 = i2;
                                    i40 = i8;
                                    i38 = i6;
                                }
                            }
                            i5 = -1;
                            zzhiVar = zzhi.zza;
                            if (i5 != -1) {
                            }
                            if (i8 == i4) {
                            }
                            zzfi zzfiVar32 = (zzfi) obj2;
                            zzhiVar2 = zzfiVar32.zzc;
                            if (zzhiVar2 == zzhiVar) {
                            }
                            int i962 = i8;
                            int zzh2 = LazyKt__LazyJVMKt.zzh(i962, bArr6, i35, i2, zzhiVar2, zzdwVar2);
                            zzgoVar2 = this;
                            zzdwVar12 = zzdwVar;
                            i40 = i962;
                            i34 = i2;
                            i36 = i7;
                            unsafe6 = unsafe;
                            obj6 = obj2;
                            i37 = i9;
                            i38 = i6;
                            i41 = 1048575;
                            i35 = zzh2;
                            bArr6 = bArr;
                        } else {
                            if (i45 >= i47 && i45 <= i46) {
                                i5 = zzgoVar2.zzq(i45, 0);
                                zzhiVar = zzhi.zza;
                                if (i5 != -1) {
                                }
                                if (i8 == i4) {
                                }
                                zzfi zzfiVar322 = (zzfi) obj2;
                                zzhiVar2 = zzfiVar322.zzc;
                                if (zzhiVar2 == zzhiVar) {
                                }
                                int i9622 = i8;
                                int zzh22 = LazyKt__LazyJVMKt.zzh(i9622, bArr6, i35, i2, zzhiVar2, zzdwVar2);
                                zzgoVar2 = this;
                                zzdwVar12 = zzdwVar;
                                i40 = i9622;
                                i34 = i2;
                                i36 = i7;
                                unsafe6 = unsafe;
                                obj6 = obj2;
                                i37 = i9;
                                i38 = i6;
                                i41 = 1048575;
                                i35 = zzh22;
                                bArr6 = bArr;
                            }
                            i5 = -1;
                            zzhiVar = zzhi.zza;
                            if (i5 != -1) {
                            }
                            if (i8 == i4) {
                            }
                            zzfi zzfiVar3222 = (zzfi) obj2;
                            zzhiVar2 = zzfiVar3222.zzc;
                            if (zzhiVar2 == zzhiVar) {
                            }
                            int i96222 = i8;
                            int zzh222 = LazyKt__LazyJVMKt.zzh(i96222, bArr6, i35, i2, zzhiVar2, zzdwVar2);
                            zzgoVar2 = this;
                            zzdwVar12 = zzdwVar;
                            i40 = i96222;
                            i34 = i2;
                            i36 = i7;
                            unsafe6 = unsafe;
                            obj6 = obj2;
                            i37 = i9;
                            i38 = i6;
                            i41 = 1048575;
                            i35 = zzh222;
                            bArr6 = bArr;
                        }
                    } else {
                        i4 = i3;
                        unsafe = unsafe6;
                        iArr = iArr2;
                        objArr = objArr2;
                        obj2 = obj6;
                    }
                }
                i36 = i10;
            }
        } else {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj6)));
        }
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
