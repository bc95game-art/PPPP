package p004j$.util.stream;

import java.util.function.IntFunction;
/* renamed from: j$.util.stream.y2 */
/* loaded from: classes2.dex */
public abstract class AbstractC0731y2 implements AbstractC0531e2 {
    @Override // p004j$.util.stream.AbstractC0531e2
    public final long count() {
        return 0L;
    }

    /* renamed from: g */
    public final void m61g(Object obj) {
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: j */
    public /* synthetic */ AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction) {
        return AbstractC0692u3.m122W(this, j, j2, intFunction);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: o */
    public final /* synthetic */ int mo58o() {
        return 0;
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: a */
    public AbstractC0531e2 mo63a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: m */
    public final Object[] mo59m(IntFunction intFunction) {
        return (Object[]) intFunction.apply(0);
    }

    /* renamed from: f */
    public final void m62f(int i, Object obj) {
    }
}
