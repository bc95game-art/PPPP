package kotlin.collections;

import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class CollectionsKt__CollectionsKt extends LazyKt__LazyJVMKt {
    public static int getLastIndex(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.size() - 1;
    }

    public static final List optimizeReadOnlyList(List list) {
        int size = list.size();
        if (size == 0) {
            return EmptyList.INSTANCE;
        }
        if (size != 1) {
            return list;
        }
        return LazyKt__LazyJVMKt.listOf(list.get(0));
    }

    public static void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
