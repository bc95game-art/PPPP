package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class ArraysKt extends LazyKt__LazyJVMKt {
    public static boolean contentDeepEquals(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr == null || objArr2 == null || objArr.length != objArr2.length) {
            return false;
        }
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            Object obj2 = objArr2[i];
            if (obj != obj2) {
                if (obj == null || obj2 == null) {
                    return false;
                }
                if (!(obj instanceof Object[]) || !(obj2 instanceof Object[])) {
                    if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
                        if (!(obj instanceof short[]) || !(obj2 instanceof short[])) {
                            if (!(obj instanceof int[]) || !(obj2 instanceof int[])) {
                                if (!(obj instanceof long[]) || !(obj2 instanceof long[])) {
                                    if (!(obj instanceof float[]) || !(obj2 instanceof float[])) {
                                        if (!(obj instanceof double[]) || !(obj2 instanceof double[])) {
                                            if (!(obj instanceof char[]) || !(obj2 instanceof char[])) {
                                                if (!(obj instanceof boolean[]) || !(obj2 instanceof boolean[])) {
                                                    if (!obj.equals(obj2)) {
                                                        return false;
                                                    }
                                                } else if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                                                    return false;
                                                }
                                            } else if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                                                return false;
                                            }
                                        } else if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                                            return false;
                                        }
                                    } else if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                                        return false;
                                    }
                                } else if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                                    return false;
                                }
                            } else if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                                return false;
                            }
                        } else if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                            return false;
                        }
                    } else if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                        return false;
                    }
                } else if (!contentDeepEquals((Object[]) obj, (Object[]) obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void copyInto(Object[] objArr, Object[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(objArr, i2, destination, i, i3 - i2);
    }

    public static /* synthetic */ void copyInto$default(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        copyInto(objArr, objArr2, 0, i, i2);
    }

    public static List toList(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return EmptyList.INSTANCE;
        }
        if (length != 1) {
            return new ArrayList(new ArrayAsCollection(objArr, false));
        }
        return LazyKt__LazyJVMKt.listOf(objArr[0]);
    }

    public static void copyInto(int i, int i2, int[] iArr, int[] destination, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        System.arraycopy(iArr, i2, destination, i, i3 - i2);
    }
}
