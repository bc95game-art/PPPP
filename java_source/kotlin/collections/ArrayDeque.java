package kotlin.collections;

import androidx.lifecycle.ViewModelProvider;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
/* loaded from: classes.dex */
public final class ArrayDeque extends AbstractList implements List, KMutableCollection {
    public static final Object[] emptyElementData = new Object[0];
    public Object[] elementData;
    public int head;
    public int size;

    public ArrayDeque() {
        this.elementData = emptyElementData;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i2;
        int i3 = this.size;
        if (i < 0 || i > i3) {
            throw new IndexOutOfBoundsException(ViewModelProvider.Factory.CC.m605m(i, i3, "index: ", ", size: "));
        } else if (i == i3) {
            addLast(obj);
        } else if (i == 0) {
            addFirst(obj);
        } else {
            registerModification();
            ensureCapacity$1(this.size + 1);
            int positiveMod = positiveMod(this.head + i);
            int i4 = this.size;
            if (i < ((i4 + 1) >> 1)) {
                if (positiveMod == 0) {
                    Object[] objArr = this.elementData;
                    Intrinsics.checkNotNullParameter(objArr, "<this>");
                    positiveMod = objArr.length;
                }
                int i5 = positiveMod - 1;
                int i6 = this.head;
                if (i6 == 0) {
                    Object[] objArr2 = this.elementData;
                    Intrinsics.checkNotNullParameter(objArr2, "<this>");
                    i2 = objArr2.length - 1;
                } else {
                    i2 = i6 - 1;
                }
                int i7 = this.head;
                if (i5 >= i7) {
                    Object[] objArr3 = this.elementData;
                    objArr3[i2] = objArr3[i7];
                    ArraysKt.copyInto(objArr3, objArr3, i7, i7 + 1, i5 + 1);
                } else {
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto(objArr4, objArr4, i7 - 1, i7, objArr4.length);
                    Object[] objArr5 = this.elementData;
                    objArr5[objArr5.length - 1] = objArr5[0];
                    ArraysKt.copyInto(objArr5, objArr5, 0, 1, i5 + 1);
                }
                this.elementData[i5] = obj;
                this.head = i2;
            } else {
                int positiveMod2 = positiveMod(this.head + i4);
                if (positiveMod < positiveMod2) {
                    Object[] objArr6 = this.elementData;
                    ArraysKt.copyInto(objArr6, objArr6, positiveMod + 1, positiveMod, positiveMod2);
                } else {
                    Object[] objArr7 = this.elementData;
                    ArraysKt.copyInto(objArr7, objArr7, 1, 0, positiveMod2);
                    Object[] objArr8 = this.elementData;
                    objArr8[0] = objArr8[objArr8.length - 1];
                    ArraysKt.copyInto(objArr8, objArr8, positiveMod + 1, positiveMod, objArr8.length - 1);
                }
                this.elementData[positiveMod] = obj;
            }
            this.size++;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i2 = this.size;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(ViewModelProvider.Factory.CC.m605m(i, i2, "index: ", ", size: "));
        } else if (elements.isEmpty()) {
            return false;
        } else {
            if (i == this.size) {
                return addAll(elements);
            }
            registerModification();
            ensureCapacity$1(elements.size() + this.size);
            int positiveMod = positiveMod(this.head + this.size);
            int positiveMod2 = positiveMod(this.head + i);
            int size = elements.size();
            if (i < ((this.size + 1) >> 1)) {
                int i3 = this.head;
                int i4 = i3 - size;
                if (positiveMod2 < i3) {
                    Object[] objArr = this.elementData;
                    ArraysKt.copyInto(objArr, objArr, i4, i3, objArr.length);
                    if (size >= positiveMod2) {
                        Object[] objArr2 = this.elementData;
                        ArraysKt.copyInto(objArr2, objArr2, objArr2.length - size, 0, positiveMod2);
                    } else {
                        Object[] objArr3 = this.elementData;
                        ArraysKt.copyInto(objArr3, objArr3, objArr3.length - size, 0, size);
                        Object[] objArr4 = this.elementData;
                        ArraysKt.copyInto(objArr4, objArr4, 0, size, positiveMod2);
                    }
                } else if (i4 >= 0) {
                    Object[] objArr5 = this.elementData;
                    ArraysKt.copyInto(objArr5, objArr5, i4, i3, positiveMod2);
                } else {
                    Object[] objArr6 = this.elementData;
                    i4 += objArr6.length;
                    int i5 = positiveMod2 - i3;
                    int length = objArr6.length - i4;
                    if (length >= i5) {
                        ArraysKt.copyInto(objArr6, objArr6, i4, i3, positiveMod2);
                    } else {
                        ArraysKt.copyInto(objArr6, objArr6, i4, i3, i3 + length);
                        Object[] objArr7 = this.elementData;
                        ArraysKt.copyInto(objArr7, objArr7, 0, this.head + length, positiveMod2);
                    }
                }
                this.head = i4;
                copyCollectionElements(negativeMod(positiveMod2 - size), elements);
                return true;
            }
            int i6 = positiveMod2 + size;
            if (positiveMod2 < positiveMod) {
                int i7 = size + positiveMod;
                Object[] objArr8 = this.elementData;
                if (i7 <= objArr8.length) {
                    ArraysKt.copyInto(objArr8, objArr8, i6, positiveMod2, positiveMod);
                } else if (i6 >= objArr8.length) {
                    ArraysKt.copyInto(objArr8, objArr8, i6 - objArr8.length, positiveMod2, positiveMod);
                } else {
                    int length2 = positiveMod - (i7 - objArr8.length);
                    ArraysKt.copyInto(objArr8, objArr8, 0, length2, positiveMod);
                    Object[] objArr9 = this.elementData;
                    ArraysKt.copyInto(objArr9, objArr9, i6, positiveMod2, length2);
                }
            } else {
                Object[] objArr10 = this.elementData;
                ArraysKt.copyInto(objArr10, objArr10, size, 0, positiveMod);
                Object[] objArr11 = this.elementData;
                if (i6 >= objArr11.length) {
                    ArraysKt.copyInto(objArr11, objArr11, i6 - objArr11.length, positiveMod2, objArr11.length);
                } else {
                    ArraysKt.copyInto(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.elementData;
                    ArraysKt.copyInto(objArr12, objArr12, i6, positiveMod2, objArr12.length - size);
                }
            }
            copyCollectionElements(positiveMod2, elements);
            return true;
        }
    }

    public final void addFirst(Object obj) {
        registerModification();
        ensureCapacity$1(this.size + 1);
        int i = this.head;
        if (i == 0) {
            Object[] objArr = this.elementData;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            i = objArr.length;
        }
        int i2 = i - 1;
        this.head = i2;
        this.elementData[i2] = obj;
        this.size++;
    }

    public final void addLast(Object obj) {
        registerModification();
        ensureCapacity$1(this.size + 1);
        this.elementData[positiveMod(this.head + this.size)] = obj;
        this.size++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            registerModification();
            nullifyNonEmpty(this.head, positiveMod(this.head + this.size));
        }
        this.head = 0;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final void copyCollectionElements(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.elementData.length;
        while (i < length && it.hasNext()) {
            this.elementData[i] = it.next();
            i++;
        }
        int i2 = this.head;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.elementData[i3] = it.next();
        }
        this.size = collection.size() + this.size;
    }

    public final void ensureCapacity$1(int i) {
        if (i >= 0) {
            Object[] objArr = this.elementData;
            if (i > objArr.length) {
                if (objArr == emptyElementData) {
                    if (i < 10) {
                        i = 10;
                    }
                    this.elementData = new Object[i];
                    return;
                }
                int length = objArr.length;
                int i2 = length + (length >> 1);
                if (i2 - i < 0) {
                    i2 = i;
                }
                if (i2 - 2147483639 > 0) {
                    if (i > 2147483639) {
                        i2 = Integer.MAX_VALUE;
                    } else {
                        i2 = 2147483639;
                    }
                }
                Object[] objArr2 = new Object[i2];
                ArraysKt.copyInto(objArr, objArr2, 0, this.head, objArr.length);
                Object[] objArr3 = this.elementData;
                int length2 = objArr3.length;
                int i3 = this.head;
                ArraysKt.copyInto(objArr3, objArr2, length2 - i3, 0, i3);
                this.head = 0;
                this.elementData = objArr2;
                return;
            }
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final Object first() {
        if (!isEmpty()) {
            return this.elementData[this.head];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        int i2 = this.size;
        if (i >= 0 && i < i2) {
            return this.elementData[positiveMod(this.head + i)];
        }
        throw new IndexOutOfBoundsException(ViewModelProvider.Factory.CC.m605m(i, i2, "index: ", ", size: "));
    }

    public final int incremented(int i) {
        Object[] objArr = this.elementData;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        if (i == objArr.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int positiveMod = positiveMod(this.head + this.size);
        int i2 = this.head;
        if (i2 < positiveMod) {
            while (i2 < positiveMod) {
                if (Intrinsics.areEqual(obj, this.elementData[i2])) {
                    i = this.head;
                } else {
                    i2++;
                }
            }
            return -1;
        } else if (i2 < positiveMod) {
            return -1;
        } else {
            int length = this.elementData.length;
            while (true) {
                if (i2 >= length) {
                    for (int i3 = 0; i3 < positiveMod; i3++) {
                        if (Intrinsics.areEqual(obj, this.elementData[i3])) {
                            i2 = i3 + this.elementData.length;
                            i = this.head;
                        }
                    }
                    return -1;
                } else if (Intrinsics.areEqual(obj, this.elementData[i2])) {
                    i = this.head;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i2 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public final Object last() {
        if (!isEmpty()) {
            return this.elementData[positiveMod(CollectionsKt__CollectionsKt.getLastIndex(this) + this.head)];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int positiveMod = positiveMod(this.head + this.size);
        int i2 = this.head;
        if (i2 < positiveMod) {
            length = positiveMod - 1;
            if (i2 <= length) {
                while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                    if (length != i2) {
                        length--;
                    }
                }
                i = this.head;
                return length - i;
            }
            return -1;
        }
        if (i2 > positiveMod) {
            int i3 = positiveMod - 1;
            while (true) {
                if (-1 >= i3) {
                    Object[] objArr = this.elementData;
                    Intrinsics.checkNotNullParameter(objArr, "<this>");
                    length = objArr.length - 1;
                    int i4 = this.head;
                    if (i4 <= length) {
                        while (!Intrinsics.areEqual(obj, this.elementData[length])) {
                            if (length != i4) {
                                length--;
                            }
                        }
                        i = this.head;
                    }
                } else if (Intrinsics.areEqual(obj, this.elementData[i3])) {
                    length = i3 + this.elementData.length;
                    i = this.head;
                    break;
                } else {
                    i3--;
                }
            }
        }
        return -1;
    }

    public final Object lastOrNull() {
        if (isEmpty()) {
            return null;
        }
        return this.elementData[positiveMod(CollectionsKt__CollectionsKt.getLastIndex(this) + this.head)];
    }

    public final int negativeMod(int i) {
        if (i < 0) {
            return i + this.elementData.length;
        }
        return i;
    }

    public final void nullifyNonEmpty(int i, int i2) {
        if (i < i2) {
            Object[] objArr = this.elementData;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            Arrays.fill(objArr, i, i2, (Object) null);
            return;
        }
        Object[] objArr2 = this.elementData;
        Arrays.fill(objArr2, i, objArr2.length, (Object) null);
        Object[] objArr3 = this.elementData;
        Intrinsics.checkNotNullParameter(objArr3, "<this>");
        Arrays.fill(objArr3, 0, i2, (Object) null);
    }

    public final int positiveMod(int i) {
        Object[] objArr = this.elementData;
        if (i >= objArr.length) {
            return i - objArr.length;
        }
        return i;
    }

    public final void registerModification() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(ViewModelProvider.Factory.CC.m605m(i, i2, "index: ", ", size: "));
        } else if (i == CollectionsKt__CollectionsKt.getLastIndex(this)) {
            return removeLast();
        } else {
            if (i == 0) {
                return removeFirst();
            }
            registerModification();
            int positiveMod = positiveMod(this.head + i);
            Object[] objArr = this.elementData;
            Object obj = objArr[positiveMod];
            if (i < (this.size >> 1)) {
                int i3 = this.head;
                if (positiveMod >= i3) {
                    ArraysKt.copyInto(objArr, objArr, i3 + 1, i3, positiveMod);
                } else {
                    ArraysKt.copyInto(objArr, objArr, 1, 0, positiveMod);
                    Object[] objArr2 = this.elementData;
                    objArr2[0] = objArr2[objArr2.length - 1];
                    int i4 = this.head;
                    ArraysKt.copyInto(objArr2, objArr2, i4 + 1, i4, objArr2.length - 1);
                }
                Object[] objArr3 = this.elementData;
                int i5 = this.head;
                objArr3[i5] = null;
                this.head = incremented(i5);
            } else {
                int positiveMod2 = positiveMod(CollectionsKt__CollectionsKt.getLastIndex(this) + this.head);
                if (positiveMod <= positiveMod2) {
                    Object[] objArr4 = this.elementData;
                    ArraysKt.copyInto(objArr4, objArr4, positiveMod, positiveMod + 1, positiveMod2 + 1);
                } else {
                    Object[] objArr5 = this.elementData;
                    ArraysKt.copyInto(objArr5, objArr5, positiveMod, positiveMod + 1, objArr5.length);
                    Object[] objArr6 = this.elementData;
                    objArr6[objArr6.length - 1] = objArr6[0];
                    ArraysKt.copyInto(objArr6, objArr6, 0, 1, positiveMod2 + 1);
                }
                this.elementData[positiveMod2] = null;
            }
            this.size--;
            return obj;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int positiveMod = positiveMod(this.head + this.size);
            int i2 = this.head;
            if (i2 < positiveMod) {
                i = i2;
                while (i2 < positiveMod) {
                    Object obj = this.elementData[i2];
                    if (!elements.contains(obj)) {
                        this.elementData[i] = obj;
                        i++;
                    } else {
                        z = true;
                    }
                    i2++;
                }
                Object[] objArr = this.elementData;
                Intrinsics.checkNotNullParameter(objArr, "<this>");
                Arrays.fill(objArr, i, positiveMod, (Object) null);
            } else {
                int length = this.elementData.length;
                int i3 = i2;
                boolean z2 = false;
                while (i2 < length) {
                    Object[] objArr2 = this.elementData;
                    Object obj2 = objArr2[i2];
                    objArr2[i2] = null;
                    if (!elements.contains(obj2)) {
                        this.elementData[i3] = obj2;
                        i3++;
                    } else {
                        z2 = true;
                    }
                    i2++;
                }
                i = positiveMod(i3);
                for (int i4 = 0; i4 < positiveMod; i4++) {
                    Object[] objArr3 = this.elementData;
                    Object obj3 = objArr3[i4];
                    objArr3[i4] = null;
                    if (!elements.contains(obj3)) {
                        this.elementData[i] = obj3;
                        i = incremented(i);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = negativeMod(i - this.head);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (!isEmpty()) {
            registerModification();
            Object[] objArr = this.elementData;
            int i = this.head;
            Object obj = objArr[i];
            objArr[i] = null;
            this.head = incremented(i);
            this.size--;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object removeLast() {
        if (!isEmpty()) {
            registerModification();
            int positiveMod = positiveMod(CollectionsKt__CollectionsKt.getLastIndex(this) + this.head);
            Object[] objArr = this.elementData;
            Object obj = objArr[positiveMod];
            objArr[positiveMod] = null;
            this.size--;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i2) {
        LazyKt__LazyJVMKt.checkRangeIndexes$kotlin_stdlib(i, i2, this.size);
        int i3 = i2 - i;
        if (i3 != 0) {
            if (i3 == this.size) {
                clear();
            } else if (i3 == 1) {
                remove(i);
            } else {
                registerModification();
                if (i < this.size - i2) {
                    int positiveMod = positiveMod((i - 1) + this.head);
                    int positiveMod2 = positiveMod((i2 - 1) + this.head);
                    while (i > 0) {
                        int i4 = positiveMod + 1;
                        int min = Math.min(i, Math.min(i4, positiveMod2 + 1));
                        Object[] objArr = this.elementData;
                        int i5 = positiveMod2 - min;
                        int i6 = positiveMod - min;
                        ArraysKt.copyInto(objArr, objArr, i5 + 1, i6 + 1, i4);
                        positiveMod = negativeMod(i6);
                        positiveMod2 = negativeMod(i5);
                        i -= min;
                    }
                    int positiveMod3 = positiveMod(this.head + i3);
                    nullifyNonEmpty(this.head, positiveMod3);
                    this.head = positiveMod3;
                } else {
                    int positiveMod4 = positiveMod(this.head + i2);
                    int positiveMod5 = positiveMod(this.head + i);
                    int i7 = this.size;
                    while (true) {
                        i7 -= i2;
                        if (i7 <= 0) {
                            break;
                        }
                        Object[] objArr2 = this.elementData;
                        i2 = Math.min(i7, Math.min(objArr2.length - positiveMod4, objArr2.length - positiveMod5));
                        Object[] objArr3 = this.elementData;
                        int i8 = positiveMod4 + i2;
                        ArraysKt.copyInto(objArr3, objArr3, positiveMod5, positiveMod4, i8);
                        positiveMod4 = positiveMod(i8);
                        positiveMod5 = positiveMod(positiveMod5 + i2);
                    }
                    int positiveMod6 = positiveMod(this.head + this.size);
                    nullifyNonEmpty(negativeMod(positiveMod6 - i3), positiveMod6);
                }
                this.size -= i3;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection elements) {
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.elementData.length != 0) {
            int positiveMod = positiveMod(this.head + this.size);
            int i2 = this.head;
            if (i2 < positiveMod) {
                i = i2;
                while (i2 < positiveMod) {
                    Object obj = this.elementData[i2];
                    if (elements.contains(obj)) {
                        this.elementData[i] = obj;
                        i++;
                    } else {
                        z = true;
                    }
                    i2++;
                }
                Object[] objArr = this.elementData;
                Intrinsics.checkNotNullParameter(objArr, "<this>");
                Arrays.fill(objArr, i, positiveMod, (Object) null);
            } else {
                int length = this.elementData.length;
                int i3 = i2;
                boolean z2 = false;
                while (i2 < length) {
                    Object[] objArr2 = this.elementData;
                    Object obj2 = objArr2[i2];
                    objArr2[i2] = null;
                    if (elements.contains(obj2)) {
                        this.elementData[i3] = obj2;
                        i3++;
                    } else {
                        z2 = true;
                    }
                    i2++;
                }
                i = positiveMod(i3);
                for (int i4 = 0; i4 < positiveMod; i4++) {
                    Object[] objArr3 = this.elementData;
                    Object obj3 = objArr3[i4];
                    objArr3[i4] = null;
                    if (elements.contains(obj3)) {
                        this.elementData[i] = obj3;
                        i = incremented(i);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                registerModification();
                this.size = negativeMod(i - this.head);
            }
        }
        return z;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        int i2 = this.size;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(ViewModelProvider.Factory.CC.m605m(i, i2, "index: ", ", size: "));
        }
        int positiveMod = positiveMod(this.head + i);
        Object[] objArr = this.elementData;
        Object obj2 = objArr[positiveMod];
        objArr[positiveMod] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[this.size]);
    }

    public ArrayDeque(int i) {
        Object[] objArr;
        if (i == 0) {
            objArr = emptyElementData;
        } else if (i > 0) {
            objArr = new Object[i];
        } else {
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(i, "Illegal Capacity: "));
        }
        this.elementData = objArr;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        int length = array.length;
        int i = this.size;
        if (length < i) {
            Object newInstance = Array.newInstance(array.getClass().getComponentType(), i);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            array = (Object[]) newInstance;
        }
        int positiveMod = positiveMod(this.head + this.size);
        int i2 = this.head;
        if (i2 < positiveMod) {
            ArraysKt.copyInto$default(this.elementData, array, i2, positiveMod, 2);
        } else if (!isEmpty()) {
            Object[] objArr = this.elementData;
            ArraysKt.copyInto(objArr, array, 0, this.head, objArr.length);
            Object[] objArr2 = this.elementData;
            ArraysKt.copyInto(objArr2, array, objArr2.length - this.head, 0, positiveMod);
        }
        int i3 = this.size;
        if (i3 < array.length) {
            array[i3] = null;
        }
        return array;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        registerModification();
        ensureCapacity$1(elements.size() + this.size);
        copyCollectionElements(positiveMod(this.head + this.size), elements);
        return true;
    }
}
