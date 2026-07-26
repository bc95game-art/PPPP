package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.Sequence;
import kotlin.sequences.TakeWhileSequence;
/* loaded from: classes.dex */
public final class TreeIterator implements Iterator, KMappedMarker {
    public final /* synthetic */ int $r8$classId;
    public Iterator iterator;
    public final Object stack;

    public TreeIterator(ArrayIterator arrayIterator) {
        this.$r8$classId = 0;
        this.stack = new ArrayList();
        this.iterator = arrayIterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.$r8$classId) {
            case 0:
                return this.iterator.hasNext();
            default:
                return this.iterator.hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        ViewGroup viewGroup;
        switch (this.$r8$classId) {
            case 0:
                Object next = this.iterator.next();
                ArrayList arrayList = (ArrayList) this.stack;
                View view = (View) next;
                ArrayIterator arrayIterator = null;
                if (view instanceof ViewGroup) {
                    viewGroup = (ViewGroup) view;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    arrayIterator = new ArrayIterator(2, viewGroup);
                }
                if (arrayIterator == null || !arrayIterator.hasNext()) {
                    while (!this.iterator.hasNext() && !arrayList.isEmpty()) {
                        this.iterator = (Iterator) CollectionsKt.last(arrayList);
                        CollectionsKt__MutableCollectionsKt.removeLast(arrayList);
                    }
                } else {
                    arrayList.add(this.iterator);
                    this.iterator = arrayIterator;
                }
                return next;
            default:
                return ((TakeWhileSequence) this.stack).predicate.invoke(this.iterator.next());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.$r8$classId) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public TreeIterator(TakeWhileSequence takeWhileSequence) {
        this.$r8$classId = 1;
        this.stack = takeWhileSequence;
        this.iterator = ((Sequence) takeWhileSequence.sequence).iterator();
    }
}
