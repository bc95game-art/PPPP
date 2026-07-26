package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class ArraySetKt {
    public static final Object DELETED = new Object();
    public static final Object DELETED$1 = new Object();

    public static final void access$gc(SparseArrayCompat sparseArrayCompat) {
        int i = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != DELETED$1) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i2;
    }

    public static final void allocArrays(ArraySet arraySet, int i) {
        arraySet.hashes = new int[i];
        arraySet.array = new Object[i];
    }

    public static final int indexOf(ArraySet arraySet, Object obj, int i) {
        int i2 = arraySet._size;
        if (i2 == 0) {
            return -1;
        }
        try {
            int binarySearch = ContainerHelpersKt.binarySearch(i2, i, arraySet.hashes);
            if (binarySearch < 0 || Intrinsics.areEqual(obj, arraySet.array[binarySearch])) {
                return binarySearch;
            }
            int i3 = binarySearch + 1;
            while (i3 < i2 && arraySet.hashes[i3] == i) {
                if (Intrinsics.areEqual(obj, arraySet.array[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = binarySearch - 1; i4 >= 0 && arraySet.hashes[i4] == i; i4--) {
                if (Intrinsics.areEqual(obj, arraySet.array[i4])) {
                    return i4;
                }
            }
            return ~i3;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
