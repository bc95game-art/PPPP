package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.d5 */
/* loaded from: classes2.dex */
public abstract class AbstractC0524d5 implements AbstractC0564h5 {

    /* renamed from: a */
    public final AbstractC0594k5 f536a;

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo56n((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return AbstractC0279a.m530e(this, doubleConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0564h5
    /* renamed from: n */
    public final /* synthetic */ void mo56n(Double d) {
        AbstractC0692u3.m143E(this, d);
    }

    public AbstractC0524d5(AbstractC0594k5 k5Var) {
        this.f536a = (AbstractC0594k5) Objects.requireNonNull(k5Var);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public void mo23c(long j) {
        this.f536a.mo23c(j);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public void end() {
        this.f536a.end();
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public boolean mo27e() {
        return this.f536a.mo27e();
    }
}
