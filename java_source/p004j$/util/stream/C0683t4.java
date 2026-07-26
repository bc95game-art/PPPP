package p004j$.util.stream;

import java.util.function.LongConsumer;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.t4 */
/* loaded from: classes2.dex */
public final class C0683t4 extends AbstractC0703v4 implements AbstractC0584j5 {
    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo78l((Long) obj);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0584j5
    /* renamed from: l */
    public final /* synthetic */ void mo78l(Long l) {
        AbstractC0692u3.m136I(this, l);
    }

    @Override // p004j$.util.stream.AbstractC0653q4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.f797b);
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        this.f797b += ((AbstractC0703v4) p4Var).f797b;
    }

    @Override // p004j$.util.stream.AbstractC0703v4, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        this.f797b++;
    }
}
