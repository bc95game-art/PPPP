package androidx.collection;

import androidx.collection.ArrayMap;
import androidx.collection.internal.ContainerHelpersKt;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
/* loaded from: classes.dex */
public final class ArraySet implements Collection, Set, KMutableCollection {
    public int _size;
    public Object[] array;
    public int[] hashes;

    public ArraySet(int i) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i > 0) {
            ArraySetKt.allocArrays(this, i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        int i;
        int i2;
        int i3 = this._size;
        if (obj == null) {
            i2 = ArraySetKt.indexOf(this, null, 0);
            i = 0;
        } else {
            int hashCode = obj.hashCode();
            i = hashCode;
            i2 = ArraySetKt.indexOf(this, obj, hashCode);
        }
        if (i2 >= 0) {
            return false;
        }
        int i4 = ~i2;
        int[] iArr = this.hashes;
        if (i3 >= iArr.length) {
            int i5 = 8;
            if (i3 >= 8) {
                i5 = (i3 >> 1) + i3;
            } else if (i3 < 4) {
                i5 = 4;
            }
            Object[] objArr = this.array;
            int[] iArr2 = new int[i5];
            this.hashes = iArr2;
            this.array = new Object[i5];
            if (i3 != this._size) {
                throw new ConcurrentModificationException();
            } else if (iArr2.length != 0) {
                ArraysKt.copyInto(0, 0, iArr, iArr2, iArr.length);
                ArraysKt.copyInto$default(objArr, this.array, 0, objArr.length, 6);
            }
        }
        if (i4 < i3) {
            int[] iArr3 = this.hashes;
            int i6 = i4 + 1;
            ArraysKt.copyInto(i6, i4, iArr3, iArr3, i3);
            Object[] objArr2 = this.array;
            ArraysKt.copyInto(objArr2, objArr2, i6, i4, i3);
        }
        int i7 = this._size;
        if (i3 == i7) {
            int[] iArr4 = this.hashes;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                this.array[i4] = obj;
                this._size = i7 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int size = elements.size() + this._size;
        int i = this._size;
        int[] iArr = this.hashes;
        boolean z = false;
        if (iArr.length < size) {
            Object[] objArr = this.array;
            int[] iArr2 = new int[size];
            this.hashes = iArr2;
            this.array = new Object[size];
            if (i > 0) {
                ArraysKt.copyInto(0, 0, iArr, iArr2, i);
                ArraysKt.copyInto$default(objArr, this.array, 0, this._size, 6);
            }
        }
        if (this._size == i) {
            for (Object obj : elements) {
                z |= add(obj);
            }
            return z;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final void clear() {
        if (this._size != 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this._size = 0;
        }
        if (this._size != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        int i;
        if (obj == null) {
            i = ArraySetKt.indexOf(this, null, 0);
        } else {
            i = ArraySetKt.indexOf(this, obj, obj.hashCode());
        }
        if (i >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (Object obj : elements) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || this._size != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = this._size;
            for (int i2 = 0; i2 < i; i2++) {
                if (!((Set) obj).contains(this.array[i2])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int[] iArr = this.hashes;
        int i = this._size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        if (this._size <= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new ArrayMap.KeyIterator(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int i;
        if (obj == null) {
            i = ArraySetKt.indexOf(this, null, 0);
        } else {
            i = ArraySetKt.indexOf(this, obj, obj.hashCode());
        }
        if (i < 0) {
            return false;
        }
        removeAt(i);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        for (Object obj : elements) {
            z |= remove(obj);
        }
        return z;
    }

    public final Object removeAt(int i) {
        int i2 = this._size;
        Object[] objArr = this.array;
        Object obj = objArr[i];
        if (i2 <= 1) {
            clear();
            return obj;
        }
        int i3 = i2 - 1;
        int[] iArr = this.hashes;
        int i4 = 8;
        if (iArr.length <= 8 || i2 >= iArr.length / 3) {
            if (i < i3) {
                int i5 = i + 1;
                ArraysKt.copyInto(i, i5, iArr, iArr, i2);
                Object[] objArr2 = this.array;
                ArraysKt.copyInto(objArr2, objArr2, i, i5, i2);
            }
            this.array[i3] = null;
        } else {
            if (i2 > 8) {
                i4 = i2 + (i2 >> 1);
            }
            int[] iArr2 = new int[i4];
            this.hashes = iArr2;
            this.array = new Object[i4];
            if (i > 0) {
                ArraysKt.copyInto(0, 0, iArr, iArr2, i);
                ArraysKt.copyInto$default(objArr, this.array, 0, i, 6);
            }
            if (i < i3) {
                int i6 = i + 1;
                ArraysKt.copyInto(i, i6, iArr, this.hashes, i2);
                ArraysKt.copyInto(objArr, this.array, i, i6, i2);
            }
        }
        if (i2 == this._size) {
            this._size = i3;
            return obj;
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        for (int i = this._size - 1; -1 < i; i--) {
            if (!CollectionsKt.contains(elements, this.array[i])) {
                removeAt(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public final int size() {
        return this._size;
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        Object[] objArr = this.array;
        int i = this._size;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        int length = objArr.length;
        if (i <= length) {
            Object[] copyOfRange = Arrays.copyOfRange(objArr, 0, i);
            Intrinsics.checkNotNullExpressionValue(copyOfRange, "copyOfRange(...)");
            return copyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + length + ").");
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this._size * 14);
        sb.append('{');
        int i = this._size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object obj = this.array[i2];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public ArraySet(Collection collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int i = this._size;
        if (array.length < i) {
            array = (Object[]) Array.newInstance(array.getClass().getComponentType(), i);
        } else if (array.length > i) {
            array[i] = null;
        }
        ArraysKt.copyInto(this.array, array, 0, 0, this._size);
        return array;
    }
}
