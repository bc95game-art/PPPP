package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class IntListNavType extends NavType {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntListNavType(int i, boolean z) {
        super(z);
        this.$r8$classId = i;
    }

    @Override // androidx.navigation.NavType
    public final Object get(Bundle bundle, String str) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        switch (this.$r8$classId) {
            case 0:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                int[] intArray = bundle.getIntArray(str);
                if (intArray != null) {
                    Intrinsics.checkNotNullParameter(intArray, "<this>");
                    int length = intArray.length;
                    if (length != 0) {
                        if (length != 1) {
                            ArrayList arrayList = new ArrayList(intArray.length);
                            for (int i : intArray) {
                                arrayList.add(Integer.valueOf(i));
                            }
                            return arrayList;
                        }
                        obj = LazyKt__LazyJVMKt.listOf(Integer.valueOf(intArray[0]));
                    } else {
                        obj = EmptyList.INSTANCE;
                    }
                    return obj;
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 1:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                boolean[] booleanArray = bundle.getBooleanArray(str);
                if (booleanArray != null) {
                    return booleanArray;
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 2:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                boolean[] booleanArray2 = bundle.getBooleanArray(str);
                if (booleanArray2 != null) {
                    Intrinsics.checkNotNullParameter(booleanArray2, "<this>");
                    int length2 = booleanArray2.length;
                    if (length2 != 0) {
                        if (length2 != 1) {
                            ArrayList arrayList2 = new ArrayList(booleanArray2.length);
                            for (boolean z : booleanArray2) {
                                arrayList2.add(Boolean.valueOf(z));
                            }
                            return arrayList2;
                        }
                        obj2 = LazyKt__LazyJVMKt.listOf(Boolean.valueOf(booleanArray2[0]));
                    } else {
                        obj2 = EmptyList.INSTANCE;
                    }
                    return obj2;
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 3:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                float[] floatArray = bundle.getFloatArray(str);
                if (floatArray != null) {
                    return floatArray;
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 4:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                float[] floatArray2 = bundle.getFloatArray(str);
                if (floatArray2 != null) {
                    Intrinsics.checkNotNullParameter(floatArray2, "<this>");
                    int length3 = floatArray2.length;
                    if (length3 != 0) {
                        if (length3 != 1) {
                            ArrayList arrayList3 = new ArrayList(floatArray2.length);
                            for (float f : floatArray2) {
                                arrayList3.add(Float.valueOf(f));
                            }
                            return arrayList3;
                        }
                        obj3 = LazyKt__LazyJVMKt.listOf(Float.valueOf(floatArray2[0]));
                    } else {
                        obj3 = EmptyList.INSTANCE;
                    }
                    return obj3;
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 5:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                int[] intArray2 = bundle.getIntArray(str);
                if (intArray2 != null) {
                    return intArray2;
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 6:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                long[] longArray = bundle.getLongArray(str);
                if (longArray != null) {
                    return longArray;
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 7:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                long[] longArray2 = bundle.getLongArray(str);
                if (longArray2 != null) {
                    Intrinsics.checkNotNullParameter(longArray2, "<this>");
                    int length4 = longArray2.length;
                    if (length4 != 0) {
                        if (length4 != 1) {
                            ArrayList arrayList4 = new ArrayList(longArray2.length);
                            for (long j : longArray2) {
                                arrayList4.add(Long.valueOf(j));
                            }
                            return arrayList4;
                        }
                        obj4 = LazyKt__LazyJVMKt.listOf(Long.valueOf(longArray2[0]));
                    } else {
                        obj4 = EmptyList.INSTANCE;
                    }
                    return obj4;
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            case 8:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                String[] stringArray = bundle.getStringArray(str);
                if (stringArray != null) {
                    return stringArray;
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
            default:
                Intrinsics.checkNotNullParameter(bundle, "bundle");
                if (!bundle.containsKey(str) || Navigation.m22isNullimpl(bundle, str)) {
                    return null;
                }
                String[] stringArray2 = bundle.getStringArray(str);
                if (stringArray2 != null) {
                    return ArraysKt.toList(stringArray2);
                }
                Navigation.keyOrValueNotFoundError(str);
                throw null;
        }
    }

    @Override // androidx.navigation.NavType
    public final String getName() {
        switch (this.$r8$classId) {
            case 0:
                return "List<Int>";
            case 1:
                return "boolean[]";
            case 2:
                return "List<Boolean>";
            case 3:
                return "float[]";
            case 4:
                return "List<Float>";
            case 5:
                return "integer[]";
            case 6:
                return "long[]";
            case 7:
                return "List<Long>";
            case 8:
                return "string[]";
            default:
                return "List<String>";
        }
    }

    @Override // androidx.navigation.NavType
    /* renamed from: parseValue  reason: collision with other method in class */
    public final Object mo19parseValue(String value) {
        switch (this.$r8$classId) {
            case 0:
                Intrinsics.checkNotNullParameter(value, "value");
                return LazyKt__LazyJVMKt.listOf(NavType.IntType.mo19parseValue(value));
            case 1:
                return m18parseValue(value);
            case 2:
                Intrinsics.checkNotNullParameter(value, "value");
                return LazyKt__LazyJVMKt.listOf(NavType.BoolType.mo19parseValue(value));
            case 3:
                return parseValue(value);
            case 4:
                Intrinsics.checkNotNullParameter(value, "value");
                return LazyKt__LazyJVMKt.listOf(NavType.FloatType.mo19parseValue(value));
            case 5:
                return m16parseValue(value);
            case 6:
                return m17parseValue(value);
            case 7:
                Intrinsics.checkNotNullParameter(value, "value");
                return LazyKt__LazyJVMKt.listOf(NavType.LongType.mo19parseValue(value));
            case 8:
                Intrinsics.checkNotNullParameter(value, "value");
                return new String[]{value};
            default:
                Intrinsics.checkNotNullParameter(value, "value");
                return LazyKt__LazyJVMKt.listOf(value);
        }
    }

    @Override // androidx.navigation.NavType
    public final void put(Bundle bundle, String key, Object obj) {
        switch (this.$r8$classId) {
            case 0:
                List list = (List) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (list != null) {
                    bundle.putIntArray(key, CollectionsKt.toIntArray(list));
                    return;
                }
                return;
            case 1:
                boolean[] zArr = (boolean[]) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (zArr != null) {
                    bundle.putBooleanArray(key, zArr);
                    return;
                } else {
                    Navigation.m23putNullimpl(bundle, key);
                    return;
                }
            case 2:
                List<Boolean> list2 = (List) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (list2 != null) {
                    Intrinsics.checkNotNullParameter(list2, "<this>");
                    boolean[] zArr2 = new boolean[list2.size()];
                    int i = 0;
                    for (Boolean bool : list2) {
                        zArr2[i] = bool.booleanValue();
                        i++;
                    }
                    bundle.putBooleanArray(key, zArr2);
                    return;
                }
                Navigation.m23putNullimpl(bundle, key);
                return;
            case 3:
                float[] fArr = (float[]) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (fArr != null) {
                    bundle.putFloatArray(key, fArr);
                    return;
                } else {
                    Navigation.m23putNullimpl(bundle, key);
                    return;
                }
            case 4:
                List<Number> list3 = (List) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (list3 != null) {
                    float[] fArr2 = new float[list3.size()];
                    int i2 = 0;
                    for (Number number : list3) {
                        fArr2[i2] = number.floatValue();
                        i2++;
                    }
                    bundle.putFloatArray(key, fArr2);
                    return;
                }
                Navigation.m23putNullimpl(bundle, key);
                return;
            case 5:
                int[] iArr = (int[]) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (iArr != null) {
                    bundle.putIntArray(key, iArr);
                    return;
                } else {
                    Navigation.m23putNullimpl(bundle, key);
                    return;
                }
            case 6:
                long[] jArr = (long[]) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (jArr != null) {
                    bundle.putLongArray(key, jArr);
                    return;
                } else {
                    Navigation.m23putNullimpl(bundle, key);
                    return;
                }
            case 7:
                List<Number> list4 = (List) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (list4 != null) {
                    long[] jArr2 = new long[list4.size()];
                    int i3 = 0;
                    for (Number number2 : list4) {
                        jArr2[i3] = number2.longValue();
                        i3++;
                    }
                    bundle.putLongArray(key, jArr2);
                    return;
                }
                Navigation.m23putNullimpl(bundle, key);
                return;
            case 8:
                String[] strArr = (String[]) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (strArr != null) {
                    bundle.putStringArray(key, strArr);
                    return;
                } else {
                    Navigation.m23putNullimpl(bundle, key);
                    return;
                }
            default:
                List list5 = (List) obj;
                Intrinsics.checkNotNullParameter(key, "key");
                if (list5 != null) {
                    String[] value = (String[]) list5.toArray(new String[0]);
                    Intrinsics.checkNotNullParameter(value, "value");
                    bundle.putStringArray(key, value);
                    return;
                }
                Navigation.m23putNullimpl(bundle, key);
                return;
        }
    }

    /* renamed from: parseValue  reason: collision with other method in class */
    public static int[] m16parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new int[]{((Number) NavType.IntType.mo19parseValue(value)).intValue()};
    }

    /* renamed from: parseValue  reason: collision with other method in class */
    public static long[] m17parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new long[]{((Number) NavType.LongType.mo19parseValue(value)).longValue()};
    }

    public static float[] parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new float[]{((Number) NavType.FloatType.mo19parseValue(value)).floatValue()};
    }

    /* renamed from: parseValue  reason: collision with other method in class */
    public static boolean[] m18parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new boolean[]{((Boolean) NavType.BoolType.mo19parseValue(value)).booleanValue()};
    }

    @Override // androidx.navigation.NavType
    public final Object parseValue(Object obj, String str) {
        switch (this.$r8$classId) {
            case 0:
                List list = (List) obj;
                IntNavType intNavType = NavType.IntType;
                if (list != null) {
                    return CollectionsKt.plus(list, LazyKt__LazyJVMKt.listOf(intNavType.mo19parseValue(str)));
                }
                return LazyKt__LazyJVMKt.listOf(intNavType.mo19parseValue(str));
            case 1:
                boolean[] zArr = (boolean[]) obj;
                if (zArr == null) {
                    return m18parseValue(str);
                }
                boolean[] parseValue = m18parseValue(str);
                int length = zArr.length;
                boolean[] copyOf = Arrays.copyOf(zArr, length + 1);
                System.arraycopy(parseValue, 0, copyOf, length, 1);
                Intrinsics.checkNotNull(copyOf);
                return copyOf;
            case 2:
                List list2 = (List) obj;
                IntNavType intNavType2 = NavType.BoolType;
                if (list2 != null) {
                    return CollectionsKt.plus(list2, LazyKt__LazyJVMKt.listOf(intNavType2.mo19parseValue(str)));
                }
                return LazyKt__LazyJVMKt.listOf(intNavType2.mo19parseValue(str));
            case 3:
                float[] fArr = (float[]) obj;
                if (fArr == null) {
                    return parseValue(str);
                }
                float[] parseValue2 = parseValue(str);
                int length2 = fArr.length;
                float[] copyOf2 = Arrays.copyOf(fArr, length2 + 1);
                System.arraycopy(parseValue2, 0, copyOf2, length2, 1);
                Intrinsics.checkNotNull(copyOf2);
                return copyOf2;
            case 4:
                List list3 = (List) obj;
                IntNavType intNavType3 = NavType.FloatType;
                if (list3 != null) {
                    return CollectionsKt.plus(list3, LazyKt__LazyJVMKt.listOf(intNavType3.mo19parseValue(str)));
                }
                return LazyKt__LazyJVMKt.listOf(intNavType3.mo19parseValue(str));
            case 5:
                int[] iArr = (int[]) obj;
                if (iArr == null) {
                    return m16parseValue(str);
                }
                int[] parseValue3 = m16parseValue(str);
                int length3 = iArr.length;
                int[] copyOf3 = Arrays.copyOf(iArr, length3 + 1);
                System.arraycopy(parseValue3, 0, copyOf3, length3, 1);
                Intrinsics.checkNotNull(copyOf3);
                return copyOf3;
            case 6:
                long[] jArr = (long[]) obj;
                if (jArr == null) {
                    return m17parseValue(str);
                }
                long[] parseValue4 = m17parseValue(str);
                int length4 = jArr.length;
                long[] copyOf4 = Arrays.copyOf(jArr, length4 + 1);
                System.arraycopy(parseValue4, 0, copyOf4, length4, 1);
                Intrinsics.checkNotNull(copyOf4);
                return copyOf4;
            case 7:
                List list4 = (List) obj;
                IntNavType intNavType4 = NavType.LongType;
                if (list4 != null) {
                    return CollectionsKt.plus(list4, LazyKt__LazyJVMKt.listOf(intNavType4.mo19parseValue(str)));
                }
                return LazyKt__LazyJVMKt.listOf(intNavType4.mo19parseValue(str));
            case 8:
                String[] strArr = (String[]) obj;
                if (strArr == null) {
                    return new String[]{str};
                }
                int length5 = strArr.length;
                Object[] copyOf5 = Arrays.copyOf(strArr, length5 + 1);
                System.arraycopy(new String[]{str}, 0, copyOf5, length5, 1);
                Intrinsics.checkNotNull(copyOf5);
                return (String[]) copyOf5;
            default:
                List list5 = (List) obj;
                if (list5 != null) {
                    return CollectionsKt.plus(list5, LazyKt__LazyJVMKt.listOf(str));
                }
                return LazyKt__LazyJVMKt.listOf(str);
        }
    }
}
