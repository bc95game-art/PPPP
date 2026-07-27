package kotlin.sequences;

import androidx.core.view.ViewKt$allViews$1;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result$Failure;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
/* loaded from: classes.dex */
public final class SequenceBuilderIterator implements Iterator, Continuation, KMappedMarker {
    public Iterator nextIterator;
    public ViewKt$allViews$1 nextStep;
    public Object nextValue;
    public int state;

    public final RuntimeException exceptionalState() {
        int i = this.state;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.state);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.state;
            if (i != 0) {
                if (i == 1) {
                    Iterator it = this.nextIterator;
                    Intrinsics.checkNotNull(it);
                    if (it.hasNext()) {
                        this.state = 2;
                        return true;
                    }
                    this.nextIterator = null;
                } else if (i == 2 || i == 3) {
                    return true;
                } else {
                    if (i == 4) {
                        return false;
                    }
                    throw exceptionalState();
                }
            }
            this.state = 5;
            ViewKt$allViews$1 viewKt$allViews$1 = this.nextStep;
            Intrinsics.checkNotNull(viewKt$allViews$1);
            this.nextStep = null;
            viewKt$allViews$1.resumeWith(Unit.INSTANCE);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.state;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        } else if (i == 2) {
            this.state = 1;
            Iterator it = this.nextIterator;
            Intrinsics.checkNotNull(it);
            return it.next();
        } else if (i == 3) {
            this.state = 0;
            Object obj = this.nextValue;
            this.nextValue = null;
            return obj;
        } else {
            throw exceptionalState();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        if (!(obj instanceof Result$Failure)) {
            this.state = 4;
            return;
        }
        throw ((Result$Failure) obj).exception;
    }
}
