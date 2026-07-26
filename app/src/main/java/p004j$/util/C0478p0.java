package p004j$.util;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;
/* renamed from: j$.util.p0 */
/* loaded from: classes2.dex */
public final class C0478p0 extends C0476o1 {

    /* renamed from: f */
    public final /* synthetic */ SortedSet f460f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0478p0(SortedSet sortedSet, Collection collection) {
        super(collection, 21);
        this.f460f = sortedSet;
    }

    @Override // p004j$.util.C0476o1, p004j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f460f.comparator();
    }
}
