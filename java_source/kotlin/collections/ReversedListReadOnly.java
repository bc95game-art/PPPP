package kotlin.collections;

import androidx.lifecycle.ViewModelProvider;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.ranges.IntProgression;
/* loaded from: classes.dex */
public final class ReversedListReadOnly extends AbstractList {
    public final List delegate;

    public ReversedListReadOnly(List list) {
        this.delegate = list;
    }

    @Override // java.util.List
    public final Object get(int i) {
        if (i < 0 || i > CollectionsKt__CollectionsKt.getLastIndex(this)) {
            StringBuilder m = ViewModelProvider.Factory.CC.m598m("Element index ", i, " must be in range [");
            m.append(new IntProgression(0, CollectionsKt__CollectionsKt.getLastIndex(this), 1));
            m.append("].");
            throw new IndexOutOfBoundsException(m.toString());
        }
        return this.delegate.get(CollectionsKt__CollectionsKt.getLastIndex(this) - i);
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.delegate.size();
    }

    @Override // kotlin.collections.AbstractList, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new ReversedListReadOnly$listIterator$1(this, 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new ReversedListReadOnly$listIterator$1(this, 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        return new ReversedListReadOnly$listIterator$1(this, i);
    }
}
