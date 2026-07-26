package p004j$.util.stream;

import java.util.function.LongConsumer;
import p004j$.util.Spliterator;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.n0 */
/* loaded from: classes2.dex */
public final class C0619n0 extends AbstractC0639p0 implements AbstractC0584j5 {

    /* renamed from: b */
    public final LongConsumer f667b;

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo78l((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    @Override // java.util.function.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // p004j$.util.stream.AbstractC0584j5
    /* renamed from: l */
    public final /* synthetic */ void mo78l(Long l) {
        AbstractC0692u3.m136I(this, l);
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: f */
    public final Object mo113f(AbstractC0488a aVar, Spliterator spliterator) {
        aVar.mo142E0(spliterator, this);
        return null;
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: j */
    public final /* bridge */ /* synthetic */ Object mo108j(AbstractC0692u3 u3Var, Spliterator spliterator) {
        m168a(u3Var, spliterator);
        return null;
    }

    public C0619n0(LongConsumer longConsumer, boolean z) {
        super(z);
        this.f667b = longConsumer;
    }

    @Override // p004j$.util.stream.AbstractC0639p0, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        this.f667b.accept(j);
    }
}
