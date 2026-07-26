package kotlin.sequences;

import androidx.core.view.TreeIterator;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
/* loaded from: classes.dex */
public final class TakeWhileSequence implements Sequence {
    public final /* synthetic */ int $r8$classId;
    public final Function1 predicate;
    public final Object sequence;

    public /* synthetic */ TakeWhileSequence(Object obj, Function1 function1, int i) {
        this.$r8$classId = i;
        this.sequence = obj;
        this.predicate = function1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new TakeWhileSequence$iterator$1(this);
            case 1:
                return new TreeIterator(this);
            default:
                return new FilteringSequence$iterator$1(this);
        }
    }
}
