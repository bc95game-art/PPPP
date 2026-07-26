package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.e5 */
/* loaded from: classes2.dex */
public abstract class AbstractC0534e5 implements AbstractC0574i5 {

    /* renamed from: a */
    public final AbstractC0594k5 f544a;

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo162d((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return AbstractC0279a.m529f(this, intConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0574i5
    /* renamed from: d */
    public final /* synthetic */ void mo162d(Integer num) {
        AbstractC0692u3.m139G(this, num);
    }

    public AbstractC0534e5(AbstractC0594k5 k5Var) {
        this.f544a = (AbstractC0594k5) Objects.requireNonNull(k5Var);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public void mo23c(long j) {
        this.f544a.mo23c(j);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public void end() {
        this.f544a.end();
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public boolean mo27e() {
        return this.f544a.mo27e();
    }
}
