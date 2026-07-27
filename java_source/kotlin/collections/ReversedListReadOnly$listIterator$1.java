package kotlin.collections;

import androidx.lifecycle.ViewModelProvider;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
/* loaded from: classes.dex */
public final class ReversedListReadOnly$listIterator$1 implements ListIterator, KMappedMarker {
    public final ListIterator delegateIterator;
    public final /* synthetic */ ReversedListReadOnly this$0;

    public ReversedListReadOnly$listIterator$1(ReversedListReadOnly reversedListReadOnly, int i) {
        this.this$0 = reversedListReadOnly;
        List list = reversedListReadOnly.delegate;
        if (i < 0 || i > reversedListReadOnly.getSize()) {
            StringBuilder m = ViewModelProvider.Factory.CC.m598m("Position index ", i, " must be in range [");
            m.append(new IntProgression(0, reversedListReadOnly.getSize(), 1));
            m.append("].");
            throw new IndexOutOfBoundsException(m.toString());
        }
        this.delegateIterator = list.listIterator(reversedListReadOnly.getSize() - i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.delegateIterator.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.delegateIterator.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.delegateIterator.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return CollectionsKt__CollectionsKt.getLastIndex(this.this$0) - this.delegateIterator.previousIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return this.delegateIterator.next();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return CollectionsKt__CollectionsKt.getLastIndex(this.this$0) - this.delegateIterator.nextIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
