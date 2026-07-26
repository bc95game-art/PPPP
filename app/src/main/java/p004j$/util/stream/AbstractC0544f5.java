package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Objects;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.f5 */
/* loaded from: classes2.dex */
public abstract class AbstractC0544f5 implements AbstractC0584j5 {

    /* renamed from: a */
    public final AbstractC0594k5 f554a;

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo78l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0584j5
    /* renamed from: l */
    public final /* synthetic */ void mo78l(Long l) {
        AbstractC0692u3.m136I(this, l);
    }

    public AbstractC0544f5(AbstractC0594k5 k5Var) {
        this.f554a = (AbstractC0594k5) Objects.requireNonNull(k5Var);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public void mo23c(long j) {
        this.f554a.mo23c(j);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public void end() {
        this.f554a.end();
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public boolean mo27e() {
        return this.f554a.mo27e();
    }
}
