package kotlin.sequences;

import androidx.activity.OnBackPressedDispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
/* loaded from: classes.dex */
public abstract class SequencesKt extends SequencesKt__SequencesJVMKt {
    public static Sequence asSequence(Iterator it) {
        return new ConstrainedOnceSequence(new FilteringSequence(2, it));
    }

    public static Sequence generateSequence(Object obj, Function1 function1) {
        if (obj == null) {
            return EmptySequence.INSTANCE;
        }
        return new TakeWhileSequence(new OnBackPressedDispatcher.C00033(3, obj), function1, 2);
    }

    public static List toList(Sequence sequence) {
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return EmptyList.INSTANCE;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return LazyKt__LazyJVMKt.listOf(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
