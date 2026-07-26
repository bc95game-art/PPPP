package androidx.collection;

import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.LinkedTreeMap$KeySet$1;
import j$.util.Map;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* loaded from: classes.dex */
public final class ArrayMap extends SimpleArrayMap implements Map, j$.util.Map {
    public EntrySet mEntrySet;
    public KeySet mKeySet;
    public ValueCollection mValues;

    /* loaded from: classes.dex */
    public final class EntrySet extends AbstractSet {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Map this$0;

        public /* synthetic */ EntrySet(Map map, int i) {
            this.$r8$classId = i;
            this.this$0 = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            switch (this.$r8$classId) {
                case 1:
                    ((LinkedTreeMap) this.this$0).clear();
                    return;
                case 2:
                    ((LinkedTreeMap) this.this$0).clear();
                    return;
                default:
                    super.clear();
                    return;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x003d A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean contains(java.lang.Object r5) {
            /*
                r4 = this;
                int r0 = r4.$r8$classId
                switch(r0) {
                    case 1: goto L13;
                    case 2: goto La;
                    default: goto L5;
                }
            L5:
                boolean r5 = super.contains(r5)
                return r5
            La:
                java.util.Map r0 = r4.this$0
                com.google.gson.internal.LinkedTreeMap r0 = (com.google.gson.internal.LinkedTreeMap) r0
                boolean r5 = r0.containsKey(r5)
                return r5
            L13:
                boolean r0 = r5 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L3e
                java.util.Map r0 = r4.this$0
                com.google.gson.internal.LinkedTreeMap r0 = (com.google.gson.internal.LinkedTreeMap) r0
                java.util.Map$Entry r5 = (java.util.Map.Entry) r5
                java.lang.Object r2 = r5.getKey()
                r3 = 0
                if (r2 == 0) goto L2b
                com.google.gson.internal.LinkedTreeMap$Node r0 = r0.find(r2, r1)     // Catch: java.lang.ClassCastException -> L2a
                goto L2c
            L2a:
            L2b:
                r0 = r3
            L2c:
                if (r0 == 0) goto L3b
                java.lang.Object r2 = r0.value
                java.lang.Object r5 = r5.getValue()
                boolean r5 = j$.util.Objects.equals(r2, r5)
                if (r5 == 0) goto L3b
                r3 = r0
            L3b:
                if (r3 == 0) goto L3e
                r1 = 1
            L3e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ArrayMap.EntrySet.contains(java.lang.Object):boolean");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            switch (this.$r8$classId) {
                case 0:
                    return new MapIterator();
                case 1:
                    return new LinkedTreeMap$KeySet$1((LinkedTreeMap) this.this$0, 1);
                default:
                    return new LinkedTreeMap$KeySet$1((LinkedTreeMap) this.this$0, 0);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean remove(java.lang.Object r6) {
            /*
                r5 = this;
                int r0 = r5.$r8$classId
                switch(r0) {
                    case 1: goto L22;
                    case 2: goto La;
                    default: goto L5;
                }
            L5:
                boolean r6 = super.remove(r6)
                return r6
            La:
                java.util.Map r0 = r5.this$0
                com.google.gson.internal.LinkedTreeMap r0 = (com.google.gson.internal.LinkedTreeMap) r0
                r1 = 0
                r2 = 0
                if (r6 == 0) goto L18
                com.google.gson.internal.LinkedTreeMap$Node r2 = r0.find(r6, r1)     // Catch: java.lang.ClassCastException -> L17
                goto L18
            L17:
            L18:
                r6 = 1
                if (r2 == 0) goto L1e
                r0.removeInternal(r2, r6)
            L1e:
                if (r2 == 0) goto L21
                r1 = 1
            L21:
                return r1
            L22:
                java.util.Map r0 = r5.this$0
                com.google.gson.internal.LinkedTreeMap r0 = (com.google.gson.internal.LinkedTreeMap) r0
                boolean r1 = r6 instanceof java.util.Map.Entry
                r2 = 0
                if (r1 != 0) goto L2c
                goto L52
            L2c:
                java.util.Map$Entry r6 = (java.util.Map.Entry) r6
                java.lang.Object r1 = r6.getKey()
                r3 = 0
                if (r1 == 0) goto L3b
                com.google.gson.internal.LinkedTreeMap$Node r1 = r0.find(r1, r2)     // Catch: java.lang.ClassCastException -> L3a
                goto L3c
            L3a:
            L3b:
                r1 = r3
            L3c:
                if (r1 == 0) goto L4b
                java.lang.Object r4 = r1.value
                java.lang.Object r6 = r6.getValue()
                boolean r6 = j$.util.Objects.equals(r4, r6)
                if (r6 == 0) goto L4b
                r3 = r1
            L4b:
                if (r3 != 0) goto L4e
                goto L52
            L4e:
                r2 = 1
                r0.removeInternal(r3, r2)
            L52:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ArrayMap.EntrySet.remove(java.lang.Object):boolean");
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            switch (this.$r8$classId) {
                case 0:
                    return ((ArrayMap) this.this$0).size;
                case 1:
                    return ((LinkedTreeMap) this.this$0).size;
                default:
                    return ((LinkedTreeMap) this.this$0).size;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class MapIterator implements Iterator, Map.Entry {
        public int mEnd;
        public boolean mEntryValid;
        public int mIndex = -1;

        public MapIterator() {
            this.mEnd = ArrayMap.this.size - 1;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.mEntryValid) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                int i = this.mIndex;
                ArrayMap arrayMap = ArrayMap.this;
                if (!Intrinsics.areEqual(key, arrayMap.keyAt(i)) || !Intrinsics.areEqual(entry.getValue(), arrayMap.valueAt(this.mIndex))) {
                    return false;
                }
                return true;
            }
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            if (this.mEntryValid) {
                return ArrayMap.this.keyAt(this.mIndex);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            if (this.mEntryValid) {
                return ArrayMap.this.valueAt(this.mIndex);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.mIndex < this.mEnd) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int i;
            if (this.mEntryValid) {
                int i2 = this.mIndex;
                ArrayMap arrayMap = ArrayMap.this;
                Object keyAt = arrayMap.keyAt(i2);
                Object valueAt = arrayMap.valueAt(this.mIndex);
                int i3 = 0;
                if (keyAt == null) {
                    i = 0;
                } else {
                    i = keyAt.hashCode();
                }
                if (valueAt != null) {
                    i3 = valueAt.hashCode();
                }
                return i ^ i3;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (hasNext()) {
                this.mIndex++;
                this.mEntryValid = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.mEntryValid) {
                ArrayMap.this.removeAt(this.mIndex);
                this.mIndex--;
                this.mEnd--;
                this.mEntryValid = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (this.mEntryValid) {
                return ArrayMap.this.setValueAt(this.mIndex, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArrayMap(SimpleArrayMap simpleArrayMap) {
        super(0);
        int i = simpleArrayMap.size;
        ensureCapacity(this.size + i);
        if (this.size != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        } else if (i > 0) {
            ArraysKt.copyInto(0, 0, simpleArrayMap.hashes, this.hashes, i);
            ArraysKt.copyInto(simpleArrayMap.array, this.array, 0, 0, i << 1);
            this.size = i;
        }
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    public final boolean containsAll(Collection collection) {
        for (Object obj : collection) {
            if (!super.containsKey(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        EntrySet entrySet = this.mEntrySet;
        if (entrySet != null) {
            return entrySet;
        }
        EntrySet entrySet2 = new EntrySet(this, 0);
        this.mEntrySet = entrySet2;
        return entrySet2;
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map
    public final Set keySet() {
        KeySet keySet = this.mKeySet;
        if (keySet != null) {
            return keySet;
        }
        KeySet keySet2 = new KeySet();
        this.mKeySet = keySet2;
        return keySet2;
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map
    public final void putAll(java.util.Map map) {
        ensureCapacity(map.size() + this.size);
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public final boolean removeAll(Collection collection) {
        int i = this.size;
        for (Object obj : collection) {
            super.remove(obj);
        }
        if (i != this.size) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public final boolean retainAll(Collection collection) {
        int i = this.size;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (!collection.contains(keyAt(i2))) {
                removeAt(i2);
            }
        }
        if (i != this.size) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final Collection values() {
        ValueCollection valueCollection = this.mValues;
        if (valueCollection != null) {
            return valueCollection;
        }
        ValueCollection valueCollection2 = new ValueCollection();
        this.mValues = valueCollection2;
        return valueCollection2;
    }

    /* loaded from: classes.dex */
    public final class KeyIterator implements Iterator, KMappedMarker {
        public final /* synthetic */ int $r8$classId;
        public boolean canRemove;
        public int index;
        public int size;
        public final /* synthetic */ Object this$0;

        public KeyIterator(int i) {
            this.size = i;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.index < this.size) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            Object obj;
            if (hasNext()) {
                int i = this.index;
                switch (this.$r8$classId) {
                    case 0:
                        obj = ((ArrayMap) this.this$0).keyAt(i);
                        break;
                    case 1:
                        obj = ((ArrayMap) this.this$0).valueAt(i);
                        break;
                    default:
                        obj = ((ArraySet) this.this$0).array[i];
                        break;
                }
                this.index++;
                this.canRemove = true;
                return obj;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.canRemove) {
                int i = this.index - 1;
                this.index = i;
                switch (this.$r8$classId) {
                    case 0:
                        ((ArrayMap) this.this$0).removeAt(i);
                        break;
                    case 1:
                        ((ArrayMap) this.this$0).removeAt(i);
                        break;
                    default:
                        ((ArraySet) this.this$0).removeAt(i);
                        break;
                }
                this.size--;
                this.canRemove = false;
                return;
            }
            throw new IllegalStateException("Call next() before removing an element.");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public KeyIterator(ArraySet arraySet) {
            this(arraySet._size);
            this.$r8$classId = 2;
            this.this$0 = arraySet;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public KeyIterator(ArrayMap arrayMap, int i) {
            this(arrayMap.size);
            this.$r8$classId = i;
            switch (i) {
                case 1:
                    this.this$0 = arrayMap;
                    this(arrayMap.size);
                    return;
                default:
                    this.this$0 = arrayMap;
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class KeySet implements Set {
        public KeySet() {
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public final void clear() {
            ArrayMap.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean contains(Object obj) {
            return ArrayMap.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean containsAll(Collection collection) {
            return ArrayMap.this.containsAll(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean equals(Object obj) {
            ArrayMap arrayMap = ArrayMap.this;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            try {
                if (arrayMap.size != set.size()) {
                    return false;
                }
                if (arrayMap.containsAll(set)) {
                    return true;
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // java.util.Set, java.util.Collection
        public final int hashCode() {
            int i;
            ArrayMap arrayMap = ArrayMap.this;
            int i2 = 0;
            for (int i3 = arrayMap.size - 1; i3 >= 0; i3--) {
                Object keyAt = arrayMap.keyAt(i3);
                if (keyAt == null) {
                    i = 0;
                } else {
                    i = keyAt.hashCode();
                }
                i2 += i;
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new KeyIterator(ArrayMap.this, 0);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean remove(Object obj) {
            ArrayMap arrayMap = ArrayMap.this;
            int indexOfKey = arrayMap.indexOfKey(obj);
            if (indexOfKey < 0) {
                return false;
            }
            arrayMap.removeAt(indexOfKey);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean removeAll(Collection collection) {
            return ArrayMap.this.removeAll(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final boolean retainAll(Collection collection) {
            return ArrayMap.this.retainAll(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public final int size() {
            return ArrayMap.this.size;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray() {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = arrayMap.keyAt(i2);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            if (objArr.length < i) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
            }
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = arrayMap.keyAt(i2);
            }
            if (objArr.length > i) {
                objArr[i] = null;
            }
            return objArr;
        }
    }

    /* loaded from: classes.dex */
    public final class ValueCollection implements Collection {
        public ValueCollection() {
        }

        @Override // java.util.Collection
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final void clear() {
            ArrayMap.this.clear();
        }

        @Override // java.util.Collection
        public final boolean contains(Object obj) {
            if (ArrayMap.this.__restricted$indexOfValue(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection collection) {
            for (Object obj : collection) {
                if (!contains(obj)) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return ArrayMap.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new KeyIterator(ArrayMap.this, 1);
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            ArrayMap arrayMap = ArrayMap.this;
            int __restricted$indexOfValue = arrayMap.__restricted$indexOfValue(obj);
            if (__restricted$indexOfValue < 0) {
                return false;
            }
            arrayMap.removeAt(__restricted$indexOfValue);
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection collection) {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            int i2 = 0;
            boolean z = false;
            while (i2 < i) {
                if (collection.contains(arrayMap.valueAt(i2))) {
                    arrayMap.removeAt(i2);
                    i2--;
                    i--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection collection) {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            int i2 = 0;
            boolean z = false;
            while (i2 < i) {
                if (!collection.contains(arrayMap.valueAt(i2))) {
                    arrayMap.removeAt(i2);
                    i2--;
                    i--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final int size() {
            return ArrayMap.this.size;
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            Object[] objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = arrayMap.valueAt(i2);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            ArrayMap arrayMap = ArrayMap.this;
            int i = arrayMap.size;
            if (objArr.length < i) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
            }
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = arrayMap.valueAt(i2);
            }
            if (objArr.length > i) {
                objArr[i] = null;
            }
            return objArr;
        }
    }
}
