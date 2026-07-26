package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0758z;
/* renamed from: j$.util.stream.a4 */
/* loaded from: classes2.dex */
public final class C0493a4 implements AbstractC0643p4, AbstractC0564h5 {

    /* renamed from: a */
    public boolean f492a;

    /* renamed from: b */
    public double f493b;

    /* renamed from: c */
    public final /* synthetic */ DoubleBinaryOperator f494c;

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

    public C0493a4(DoubleBinaryOperator doubleBinaryOperator) {
        this.f494c = doubleBinaryOperator;
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        C0493a4 a4Var = (C0493a4) p4Var;
        if (!a4Var.f492a) {
            accept(a4Var.f493b);
        }
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f492a = true;
        this.f493b = 0.0d;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        if (this.f492a) {
            this.f492a = false;
            this.f493b = d;
            return;
        }
        this.f493b = this.f494c.applyAsDouble(this.f493b, d);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f492a ? C0758z.f884c : new C0758z(this.f493b);
    }
}
