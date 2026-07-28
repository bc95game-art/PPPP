package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.y3 */
/* loaded from: classes2.dex */
public final class C0732y3 implements AbstractC0643p4, AbstractC0564h5 {

    /* renamed from: a */
    public double f848a;

    /* renamed from: b */
    public final /* synthetic */ double f849b;

    /* renamed from: c */
    public final /* synthetic */ DoubleBinaryOperator f850c;

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

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
    }

    @Override // p004j$.util.stream.AbstractC0564h5
    /* renamed from: n */
    public final /* synthetic */ void mo56n(Double d) {
        AbstractC0692u3.m143E(this, d);
    }

    public C0732y3(double d, DoubleBinaryOperator doubleBinaryOperator) {
        this.f849b = d;
        this.f850c = doubleBinaryOperator;
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        accept(((C0732y3) p4Var).f848a);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f848a = this.f849b;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.f848a = this.f850c.applyAsDouble(this.f848a, d);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Double.valueOf(this.f848a);
    }
}
