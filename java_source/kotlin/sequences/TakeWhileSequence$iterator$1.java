package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
/* loaded from: classes.dex */
public final class TakeWhileSequence$iterator$1 implements Iterator, KMappedMarker {
    public final Iterator iterator;
    public Object nextItem;
    public int nextState = -1;
    public final /* synthetic */ TakeWhileSequence this$0;

    public TakeWhileSequence$iterator$1(TakeWhileSequence takeWhileSequence) {
        this.this$0 = takeWhileSequence;
        this.iterator = ((Sequence) takeWhileSequence.sequence).iterator();
    }

    public final void calcNext$2() {
        Iterator it = this.iterator;
        if (it.hasNext()) {
            Object next = it.next();
            if (((Boolean) this.this$0.predicate.invoke(next)).booleanValue()) {
                this.nextState = 1;
                this.nextItem = next;
                return;
            }
        }
        this.nextState = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextState == -1) {
            calcNext$2();
        }
        if (this.nextState == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.nextState == -1) {
            calcNext$2();
        }
        if (this.nextState != 0) {
            Object obj = this.nextItem;
            this.nextItem = null;
            this.nextState = -1;
            return obj;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
