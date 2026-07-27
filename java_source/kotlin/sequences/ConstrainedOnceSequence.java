package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class ConstrainedOnceSequence implements Sequence {
    public final AtomicReference sequenceRef;

    public ConstrainedOnceSequence(FilteringSequence filteringSequence) {
        this.sequenceRef = new AtomicReference(filteringSequence);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        Sequence sequence = (Sequence) this.sequenceRef.getAndSet(null);
        if (sequence != null) {
            return sequence.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
