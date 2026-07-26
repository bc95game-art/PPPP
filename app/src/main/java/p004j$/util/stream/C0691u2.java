package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntFunction;
/* renamed from: j$.util.stream.u2 */
/* loaded from: classes2.dex */
public final class C0691u2 extends AbstractC0731y2 implements AbstractC0730y1 {
    @Override // p004j$.util.stream.AbstractC0531e2
    public final /* synthetic */ void forEach(Consumer consumer) {
        AbstractC0692u3.m128Q(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0731y2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: j */
    public final /* synthetic */ AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction) {
        return AbstractC0692u3.m125T(this, j, j2);
    }

    @Override // p004j$.util.stream.AbstractC0731y2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: a */
    public final AbstractC0521d2 mo63a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: k */
    public final /* synthetic */ void mo70k(Object[] objArr, int i) {
        AbstractC0692u3.m131N(this, (Double[]) objArr, i);
    }

    @Override // p004j$.util.stream.AbstractC0521d2
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ Object mo79b() {
        return AbstractC0692u3.f780g;
    }
}
