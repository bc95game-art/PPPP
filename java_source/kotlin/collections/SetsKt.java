package kotlin.collections;

import androidx.navigation.NavBackStackEntry;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* loaded from: classes.dex */
public abstract class SetsKt extends RangesKt {
    public static LinkedHashSet plus(Set set, NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(navBackStackEntry);
        return linkedHashSet;
    }
}
