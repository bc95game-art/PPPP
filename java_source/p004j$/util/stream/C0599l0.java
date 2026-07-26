package p004j$.util.stream;

import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.l0 */
/* loaded from: classes2.dex */
public final class C0599l0 extends AbstractC0639p0 implements AbstractC0564h5 {

    /* renamed from: b */
    public final DoubleConsumer f634b;

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo56n((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return AbstractC0279a.m530e(this, doubleConsumer);
    }

    @Override // java.util.function.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // p004j$.util.stream.AbstractC0564h5
    /* renamed from: n */
    public final /* synthetic */ void mo56n(Double d) {
        AbstractC0692u3.m143E(this, d);
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

    public C0599l0(DoubleConsumer doubleConsumer, boolean z) {
        super(z);
        this.f634b = doubleConsumer;
    }

    @Override // p004j$.util.stream.AbstractC0639p0, p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.f634b.accept(d);
    }
}
