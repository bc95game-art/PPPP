package p004j$.util.stream;

import java.util.function.LongConsumer;
import java.util.function.LongPredicate;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.o1 */
/* loaded from: classes2.dex */
public final class C0630o1 extends AbstractC0650q1 implements AbstractC0584j5 {
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

    @Override // p004j$.util.stream.AbstractC0650q1, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        if (!this.f700a) {
            LongPredicate longPredicate = null;
            longPredicate.test(j);
            throw null;
        }
    }
}
