package kotlin.collections.builders;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
/* loaded from: classes.dex */
public final class MapBuilderKeys extends AbstractSet implements Set, KMutableCollection {
    public final /* synthetic */ int $r8$classId;
    public final MapBuilder backing;

    public /* synthetic */ MapBuilderKeys(MapBuilder mapBuilder, int i) {
        this.$r8$classId = i;
        this.backing = mapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Map.Entry element = (Map.Entry) obj;
                Intrinsics.checkNotNullParameter(element, "element");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection elements) {
        switch (this.$r8$classId) {
            case 0:
                Intrinsics.checkNotNullParameter(elements, "elements");
                throw new UnsupportedOperationException();
            default:
                Intrinsics.checkNotNullParameter(elements, "elements");
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.$r8$classId) {
            case 0:
                this.backing.clear();
                return;
            default:
                this.backing.clear();
                return;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return this.backing.containsKey(obj);
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                return this.backing.containsEntry$kotlin_stdlib((Map.Entry) obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        switch (this.$r8$classId) {
            case 1:
                Intrinsics.checkNotNullParameter(elements, "elements");
                return this.backing.containsAllEntries$kotlin_stdlib(elements);
            default:
                return super.containsAll(elements);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.$r8$classId) {
            case 0:
                return this.backing.isEmpty();
            default:
                return this.backing.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                MapBuilder mapBuilder = this.backing;
                mapBuilder.getClass();
                return new MapBuilder.KeysItr(mapBuilder, 0);
            default:
                MapBuilder mapBuilder2 = this.backing;
                mapBuilder2.getClass();
                return new MapBuilder.KeysItr(mapBuilder2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                MapBuilder mapBuilder = this.backing;
                mapBuilder.checkIsMutable$kotlin_stdlib();
                int findKey = mapBuilder.findKey(obj);
                if (findKey < 0) {
                    return false;
                }
                mapBuilder.removeEntryAt(findKey);
                return true;
            default:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                MapBuilder mapBuilder2 = this.backing;
                mapBuilder2.getClass();
                mapBuilder2.checkIsMutable$kotlin_stdlib();
                int findKey2 = mapBuilder2.findKey(entry.getKey());
                if (findKey2 < 0) {
                    return false;
                }
                Object[] objArr = mapBuilder2.valuesArray;
                Intrinsics.checkNotNull(objArr);
                if (!Intrinsics.areEqual(objArr[findKey2], entry.getValue())) {
                    return false;
                }
                mapBuilder2.removeEntryAt(findKey2);
                return true;
        }
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection elements) {
        switch (this.$r8$classId) {
            case 0:
                Intrinsics.checkNotNullParameter(elements, "elements");
                this.backing.checkIsMutable$kotlin_stdlib();
                return super.removeAll(elements);
            default:
                Intrinsics.checkNotNullParameter(elements, "elements");
                this.backing.checkIsMutable$kotlin_stdlib();
                return super.removeAll(elements);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection elements) {
        switch (this.$r8$classId) {
            case 0:
                Intrinsics.checkNotNullParameter(elements, "elements");
                this.backing.checkIsMutable$kotlin_stdlib();
                return super.retainAll(elements);
            default:
                Intrinsics.checkNotNullParameter(elements, "elements");
                this.backing.checkIsMutable$kotlin_stdlib();
                return super.retainAll(elements);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.$r8$classId) {
            case 0:
                return this.backing.size;
            default:
                return this.backing.size;
        }
    }
}
