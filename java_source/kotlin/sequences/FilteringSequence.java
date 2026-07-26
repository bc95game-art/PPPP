package kotlin.sequences;

import java.util.Iterator;
/* loaded from: classes.dex */
public final class FilteringSequence implements Sequence {
    public final /* synthetic */ int $r8$classId;
    public final Object sequence;

    public /* synthetic */ FilteringSequence(int i, Object obj) {
        this.$r8$classId = i;
        this.sequence = obj;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Iterator, java.lang.Object] */
    /* renamed from: iterator$kotlin$sequences$SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 */
    private final Iterator m0xfa47dc7f() {
        return this.sequence;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new FilteringSequence$iterator$1(this);
            case 1:
                return ((Iterable) this.sequence).iterator();
            default:
                return m0xfa47dc7f();
        }
    }
}
