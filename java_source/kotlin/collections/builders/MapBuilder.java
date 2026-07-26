package kotlin.collections.builders;

import androidx.emoji2.text.flatbuffer.Table;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
/* loaded from: classes.dex */
public final class MapBuilder implements Map, Serializable, KMutableMap {
    public static final MapBuilder Empty;
    public MapBuilderKeys entriesView;
    public int[] hashArray;
    public int hashShift;
    public boolean isReadOnly;
    public Object[] keysArray;
    public MapBuilderKeys keysView;
    public int length;
    public int maxProbeDistance;
    public int modCount;
    public int[] presenceArray;
    public int size;
    public Object[] valuesArray;
    public MapBuilderValues valuesView;

    /* loaded from: classes.dex */
    public final class EntryRef implements Map.Entry, KMappedMarker {
        public final int index;
        public final MapBuilder map;

        public EntryRef(MapBuilder map, int i) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
            this.index = i;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!Intrinsics.areEqual(entry.getKey(), getKey()) || !Intrinsics.areEqual(entry.getValue(), getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.map.keysArray[this.index];
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            Object[] objArr = this.map.valuesArray;
            Intrinsics.checkNotNull(objArr);
            return objArr[this.index];
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int i;
            Object key = getKey();
            int i2 = 0;
            if (key != null) {
                i = key.hashCode();
            } else {
                i = 0;
            }
            Object value = getValue();
            if (value != null) {
                i2 = value.hashCode();
            }
            return i ^ i2;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            MapBuilder mapBuilder = this.map;
            mapBuilder.checkIsMutable$kotlin_stdlib();
            Object[] objArr = mapBuilder.valuesArray;
            if (objArr == null) {
                int length = mapBuilder.keysArray.length;
                if (length >= 0) {
                    objArr = new Object[length];
                    mapBuilder.valuesArray = objArr;
                } else {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
            }
            int i = this.index;
            Object obj2 = objArr[i];
            objArr[i] = obj;
            return obj2;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* loaded from: classes.dex */
    public final class KeysItr extends Table implements Iterator, KMappedMarker {
        public final /* synthetic */ int $r8$classId;

        public KeysItr(MapBuilder map, int i) {
            this.$r8$classId = i;
            Intrinsics.checkNotNullParameter(map, "map");
            this.f9bb = map;
            this.vtable_start = -1;
            this.vtable_size = map.modCount;
            initNext$kotlin_stdlib();
        }

        @Override // java.util.Iterator
        public final Object next() {
            switch (this.$r8$classId) {
                case 0:
                    checkForComodification$kotlin_stdlib();
                    int i = this.bb_pos;
                    MapBuilder mapBuilder = (MapBuilder) this.f9bb;
                    if (i < mapBuilder.length) {
                        this.bb_pos = i + 1;
                        this.vtable_start = i;
                        Object obj = mapBuilder.keysArray[i];
                        initNext$kotlin_stdlib();
                        return obj;
                    }
                    throw new NoSuchElementException();
                case 1:
                    checkForComodification$kotlin_stdlib();
                    int i2 = this.bb_pos;
                    MapBuilder mapBuilder2 = (MapBuilder) this.f9bb;
                    if (i2 < mapBuilder2.length) {
                        this.bb_pos = i2 + 1;
                        this.vtable_start = i2;
                        EntryRef entryRef = new EntryRef(mapBuilder2, i2);
                        initNext$kotlin_stdlib();
                        return entryRef;
                    }
                    throw new NoSuchElementException();
                default:
                    checkForComodification$kotlin_stdlib();
                    int i3 = this.bb_pos;
                    MapBuilder mapBuilder3 = (MapBuilder) this.f9bb;
                    if (i3 < mapBuilder3.length) {
                        this.bb_pos = i3 + 1;
                        this.vtable_start = i3;
                        Object[] objArr = mapBuilder3.valuesArray;
                        Intrinsics.checkNotNull(objArr);
                        Object obj2 = objArr[this.vtable_start];
                        initNext$kotlin_stdlib();
                        return obj2;
                    }
                    throw new NoSuchElementException();
            }
        }
    }

    static {
        MapBuilder mapBuilder = new MapBuilder(0);
        mapBuilder.isReadOnly = true;
        Empty = mapBuilder;
    }

    public MapBuilder(int i) {
        if (i >= 0) {
            Object[] objArr = new Object[i];
            int[] iArr = new int[i];
            int highestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
            this.keysArray = objArr;
            this.valuesArray = null;
            this.presenceArray = iArr;
            this.hashArray = new int[highestOneBit];
            this.maxProbeDistance = 2;
            this.length = 0;
            this.hashShift = Integer.numberOfLeadingZeros(highestOneBit) + 1;
            return;
        }
        throw new IllegalArgumentException("capacity must be non-negative.");
    }

    public final int addKey$kotlin_stdlib(Object obj) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int hash = hash(obj);
            int i = this.maxProbeDistance * 2;
            int length = this.hashArray.length / 2;
            if (i > length) {
                i = length;
            }
            int i2 = 0;
            while (true) {
                int[] iArr = this.hashArray;
                int i3 = iArr[hash];
                if (i3 <= 0) {
                    int i4 = this.length;
                    Object[] objArr = this.keysArray;
                    if (i4 >= objArr.length) {
                        ensureExtraCapacity(1);
                    } else {
                        int i5 = i4 + 1;
                        this.length = i5;
                        objArr[i4] = obj;
                        this.presenceArray[i4] = hash;
                        iArr[hash] = i5;
                        this.size++;
                        this.modCount++;
                        if (i2 > this.maxProbeDistance) {
                            this.maxProbeDistance = i2;
                        }
                        return i4;
                    }
                } else if (Intrinsics.areEqual(this.keysArray[i3 - 1], obj)) {
                    return -i3;
                } else {
                    i2++;
                    if (i2 > i) {
                        rehash(this.hashArray.length * 2);
                        break;
                    }
                    int i6 = hash - 1;
                    if (hash == 0) {
                        hash = this.hashArray.length - 1;
                    } else {
                        hash = i6;
                    }
                }
            }
        }
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.isReadOnly) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        checkIsMutable$kotlin_stdlib();
        int i = this.length - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.presenceArray;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.hashArray[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        RangesKt.resetRange(this.keysArray, 0, this.length);
        Object[] objArr = this.valuesArray;
        if (objArr != null) {
            RangesKt.resetRange(objArr, 0, this.length);
        }
        this.size = 0;
        this.length = 0;
        this.modCount++;
    }

    public final void compact(boolean z) {
        int i;
        Object[] objArr = this.valuesArray;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.length;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.presenceArray;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.keysArray;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.hashArray[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        RangesKt.resetRange(this.keysArray, i3, i);
        if (objArr != null) {
            RangesKt.resetRange(objArr, i3, this.length);
        }
        this.length = i3;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection m) {
        Intrinsics.checkNotNullParameter(m, "m");
        for (Object obj : m) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        int findKey = findKey(entry.getKey());
        if (findKey < 0) {
            return false;
        }
        Object[] objArr = this.valuesArray;
        Intrinsics.checkNotNull(objArr);
        return Intrinsics.areEqual(objArr[findKey], entry.getValue());
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (findKey(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (findValue(obj) >= 0) {
            return true;
        }
        return false;
    }

    public final void ensureExtraCapacity(int i) {
        Object[] objArr;
        Object[] objArr2 = this.keysArray;
        int length = objArr2.length;
        int i2 = this.length;
        int i3 = length - i2;
        int i4 = i2 - this.size;
        int i5 = 1;
        if (i3 >= i || i3 + i4 < i || i4 < objArr2.length / 4) {
            int i6 = i2 + i;
            if (i6 < 0) {
                throw new OutOfMemoryError();
            } else if (i6 > objArr2.length) {
                int length2 = objArr2.length;
                int i7 = length2 + (length2 >> 1);
                if (i7 - i6 < 0) {
                    i7 = i6;
                }
                if (i7 - 2147483639 > 0) {
                    if (i6 > 2147483639) {
                        i7 = Integer.MAX_VALUE;
                    } else {
                        i7 = 2147483639;
                    }
                }
                Object[] copyOf = Arrays.copyOf(objArr2, i7);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
                this.keysArray = copyOf;
                Object[] objArr3 = this.valuesArray;
                if (objArr3 != null) {
                    objArr = Arrays.copyOf(objArr3, i7);
                    Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(...)");
                } else {
                    objArr = null;
                }
                this.valuesArray = objArr;
                int[] copyOf2 = Arrays.copyOf(this.presenceArray, i7);
                Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(...)");
                this.presenceArray = copyOf2;
                if (i7 >= 1) {
                    i5 = i7;
                }
                int highestOneBit = Integer.highestOneBit(i5 * 3);
                if (highestOneBit > this.hashArray.length) {
                    rehash(highestOneBit);
                }
            }
        } else {
            compact(true);
        }
    }

    @Override // java.util.Map
    public final Set entrySet() {
        MapBuilderKeys mapBuilderKeys = this.entriesView;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys mapBuilderKeys2 = new MapBuilderKeys(this, 1);
        this.entriesView = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this.size != map.size() || !containsAllEntries$kotlin_stdlib(map.entrySet())) {
            return false;
        }
        return true;
    }

    public final int findKey(Object obj) {
        int hash = hash(obj);
        int i = this.maxProbeDistance;
        while (true) {
            int i2 = this.hashArray[hash];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (Intrinsics.areEqual(this.keysArray[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            int i4 = hash - 1;
            if (hash == 0) {
                hash = this.hashArray.length - 1;
            } else {
                hash = i4;
            }
        }
    }

    public final int findValue(Object obj) {
        int i = this.length;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.presenceArray[i] >= 0) {
                Object[] objArr = this.valuesArray;
                Intrinsics.checkNotNull(objArr);
                if (Intrinsics.areEqual(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        Object[] objArr = this.valuesArray;
        Intrinsics.checkNotNull(objArr);
        return objArr[findKey];
    }

    public final int hash(Object obj) {
        int i;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        return (i * (-1640531527)) >>> this.hashShift;
    }

    @Override // java.util.Map
    public final int hashCode() {
        int i;
        int i2;
        KeysItr keysItr = new KeysItr(this, 1);
        int i3 = 0;
        while (keysItr.hasNext()) {
            int i4 = keysItr.bb_pos;
            MapBuilder mapBuilder = (MapBuilder) keysItr.f9bb;
            if (i4 < mapBuilder.length) {
                keysItr.bb_pos = i4 + 1;
                keysItr.vtable_start = i4;
                Object obj = mapBuilder.keysArray[i4];
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                Object[] objArr = mapBuilder.valuesArray;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[keysItr.vtable_start];
                if (obj2 != null) {
                    i2 = obj2.hashCode();
                } else {
                    i2 = 0;
                }
                keysItr.initNext$kotlin_stdlib();
                i3 += i ^ i2;
            } else {
                throw new NoSuchElementException();
            }
        }
        return i3;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public final Set keySet() {
        MapBuilderKeys mapBuilderKeys = this.keysView;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys mapBuilderKeys2 = new MapBuilderKeys(this, 0);
        this.keysView = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(obj);
        Object[] objArr = this.valuesArray;
        if (objArr == null) {
            int length = this.keysArray.length;
            if (length >= 0) {
                objArr = new Object[length];
                this.valuesArray = objArr;
            } else {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
        }
        if (addKey$kotlin_stdlib < 0) {
            int i = (-addKey$kotlin_stdlib) - 1;
            Object obj3 = objArr[i];
            objArr[i] = obj2;
            return obj3;
        }
        objArr[addKey$kotlin_stdlib] = obj2;
        return null;
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        Intrinsics.checkNotNullParameter(from, "from");
        checkIsMutable$kotlin_stdlib();
        Set<Map.Entry> entrySet = from.entrySet();
        if (!entrySet.isEmpty()) {
            ensureExtraCapacity(entrySet.size());
            for (Map.Entry entry : entrySet) {
                int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
                Object[] objArr = this.valuesArray;
                if (objArr == null) {
                    int length = this.keysArray.length;
                    if (length >= 0) {
                        objArr = new Object[length];
                        this.valuesArray = objArr;
                    } else {
                        throw new IllegalArgumentException("capacity must be non-negative.");
                    }
                }
                if (addKey$kotlin_stdlib >= 0) {
                    objArr[addKey$kotlin_stdlib] = entry.getValue();
                } else {
                    int i = (-addKey$kotlin_stdlib) - 1;
                    if (!Intrinsics.areEqual(entry.getValue(), objArr[i])) {
                        objArr[i] = entry.getValue();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
        r3[r0] = r6;
        r5.presenceArray[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void rehash(int i) {
        this.modCount++;
        int i2 = 0;
        if (this.length > this.size) {
            compact(false);
        }
        this.hashArray = new int[i];
        this.hashShift = Integer.numberOfLeadingZeros(i) + 1;
        while (i2 < this.length) {
            int i3 = i2 + 1;
            int hash = hash(this.keysArray[i2]);
            int i4 = this.maxProbeDistance;
            while (true) {
                int[] iArr = this.hashArray;
                if (iArr[hash] == 0) {
                    break;
                }
                i4--;
                if (i4 >= 0) {
                    int i5 = hash - 1;
                    if (hash == 0) {
                        hash = iArr.length - 1;
                    } else {
                        hash = i5;
                    }
                } else {
                    throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        checkIsMutable$kotlin_stdlib();
        int findKey = findKey(obj);
        if (findKey < 0) {
            return null;
        }
        Object[] objArr = this.valuesArray;
        Intrinsics.checkNotNull(objArr);
        Object obj2 = objArr[findKey];
        removeEntryAt(findKey);
        return obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0068 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void removeEntryAt(int i) {
        Object[] objArr = this.keysArray;
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        objArr[i] = null;
        Object[] objArr2 = this.valuesArray;
        if (objArr2 != null) {
            objArr2[i] = null;
        }
        int i2 = this.presenceArray[i];
        int i3 = this.maxProbeDistance * 2;
        int length = this.hashArray.length / 2;
        if (i3 > length) {
            i3 = length;
        }
        int i4 = i3;
        int i5 = 0;
        int i6 = i2;
        while (true) {
            int i7 = i2 - 1;
            if (i2 == 0) {
                i2 = this.hashArray.length - 1;
            } else {
                i2 = i7;
            }
            i5++;
            if (i5 > this.maxProbeDistance) {
                this.hashArray[i6] = 0;
                break;
            }
            int[] iArr = this.hashArray;
            int i8 = iArr[i2];
            if (i8 == 0) {
                iArr[i6] = 0;
                break;
            }
            if (i8 >= 0) {
                int i9 = i8 - 1;
                int[] iArr2 = this.hashArray;
                if (((hash(this.keysArray[i9]) - i2) & (iArr2.length - 1)) >= i5) {
                    iArr2[i6] = i8;
                    this.presenceArray[i9] = i6;
                }
                i4--;
                if (i4 < 0) {
                    this.hashArray[i6] = -1;
                    break;
                }
            } else {
                iArr[i6] = -1;
            }
            i6 = i2;
            i5 = 0;
            i4--;
            if (i4 < 0) {
            }
        }
        this.presenceArray[i] = -1;
        this.size--;
        this.modCount++;
    }

    @Override // java.util.Map
    public final int size() {
        return this.size;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.size * 3) + 2);
        sb.append("{");
        KeysItr keysItr = new KeysItr(this, 1);
        int i = 0;
        while (keysItr.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = keysItr.bb_pos;
            MapBuilder mapBuilder = (MapBuilder) keysItr.f9bb;
            if (i2 < mapBuilder.length) {
                keysItr.bb_pos = i2 + 1;
                keysItr.vtable_start = i2;
                Object obj = mapBuilder.keysArray[i2];
                if (obj == mapBuilder) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] objArr = mapBuilder.valuesArray;
                Intrinsics.checkNotNull(objArr);
                Object obj2 = objArr[keysItr.vtable_start];
                if (obj2 == mapBuilder) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                keysItr.initNext$kotlin_stdlib();
                i++;
            } else {
                throw new NoSuchElementException();
            }
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    @Override // java.util.Map
    public final Collection values() {
        MapBuilderValues mapBuilderValues = this.valuesView;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues mapBuilderValues2 = new MapBuilderValues(this);
        this.valuesView = mapBuilderValues2;
        return mapBuilderValues2;
    }
}
