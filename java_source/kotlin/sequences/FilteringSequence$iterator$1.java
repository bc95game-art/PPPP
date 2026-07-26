package kotlin.sequences;

import androidx.activity.OnBackPressedDispatcher;
import androidx.core.view.TreeIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* loaded from: classes.dex */
public final class FilteringSequence$iterator$1 implements Iterator, KMappedMarker {
    public final Object iterator;
    public Object nextItem;
    public final /* synthetic */ int $r8$classId = 0;
    public int nextState = -1;

    public FilteringSequence$iterator$1(FilteringSequence filteringSequence) {
        this.iterator = new TreeIterator((TakeWhileSequence) filteringSequence.sequence);
    }

    public void calcNext() {
        boolean z;
        Object next;
        Iterator it = (Iterator) this.iterator;
        do {
            z = false;
            if (it.hasNext()) {
                next = it.next();
                if (next == null) {
                    z = true;
                    continue;
                }
            } else {
                this.nextState = 0;
                return;
            }
        } while (z);
        this.nextItem = next;
        this.nextState = 1;
    }

    public void calcNext$1() {
        Object obj;
        int i;
        TakeWhileSequence takeWhileSequence = (TakeWhileSequence) this.iterator;
        if (this.nextState == -2) {
            obj = ((OnBackPressedDispatcher.C00033) takeWhileSequence.sequence).this$0;
        } else {
            Function1 function1 = takeWhileSequence.predicate;
            Object obj2 = this.nextItem;
            Intrinsics.checkNotNull(obj2);
            obj = function1.invoke(obj2);
        }
        this.nextItem = obj;
        if (obj == null) {
            i = 0;
        } else {
            i = 1;
        }
        this.nextState = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.$r8$classId) {
            case 0:
                if (this.nextState == -1) {
                    calcNext();
                }
                if (this.nextState == 1) {
                    return true;
                }
                return false;
            default:
                if (this.nextState < 0) {
                    calcNext$1();
                }
                if (this.nextState == 1) {
                    return true;
                }
                return false;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.$r8$classId) {
            case 0:
                if (this.nextState == -1) {
                    calcNext();
                }
                if (this.nextState != 0) {
                    Object obj = this.nextItem;
                    this.nextItem = null;
                    this.nextState = -1;
                    return obj;
                }
                throw new NoSuchElementException();
            default:
                if (this.nextState < 0) {
                    calcNext$1();
                }
                if (this.nextState != 0) {
                    Object obj2 = this.nextItem;
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
                    this.nextState = -1;
                    return obj2;
                }
                throw new NoSuchElementException();
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

    public FilteringSequence$iterator$1(TakeWhileSequence takeWhileSequence) {
        this.iterator = takeWhileSequence;
    }
}
