package p004j$.util.stream;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.j2 */
/* loaded from: classes2.dex */
public final class C0581j2 implements AbstractC0531e2 {

    /* renamed from: a */
    public final Collection f612a;

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: j */
    public final /* synthetic */ AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction) {
        return AbstractC0692u3.m122W(this, j, j2, intFunction);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: o */
    public final /* synthetic */ int mo58o() {
        return 0;
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: a */
    public final AbstractC0531e2 mo63a(int i) {
        throw new IndexOutOfBoundsException();
    }

    public C0581j2(Collection collection) {
        this.f612a = collection;
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator */
    public final Spliterator mo904spliterator() {
        return AbstractC0279a.m533c0(this.f612a).spliterator();
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: k */
    public final void mo70k(Object[] objArr, int i) {
        for (Object obj : this.f612a) {
            i++;
            objArr[i] = obj;
        }
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: m */
    public final Object[] mo59m(IntFunction intFunction) {
        Collection collection = this.f612a;
        return collection.toArray((Object[]) intFunction.apply(collection.size()));
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    public final long count() {
        return this.f612a.size();
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    public final void forEach(Consumer consumer) {
        AbstractC0279a.m553L(this.f612a, consumer);
    }

    public final String toString() {
        return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.f612a.size()), this.f612a);
    }
}
