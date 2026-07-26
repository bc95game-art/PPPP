package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.c4 */
/* loaded from: classes2.dex */
public final class C0513c4 extends AbstractC0653q4 implements AbstractC0643p4, AbstractC0564h5 {

    /* renamed from: b */
    public final /* synthetic */ Supplier f516b;

    /* renamed from: c */
    public final /* synthetic */ ObjDoubleConsumer f517c;

    /* renamed from: d */
    public final /* synthetic */ C0618n f518d;

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

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        this.f709a = this.f518d.apply(this.f709a, ((C0513c4) p4Var).f709a);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f709a = this.f516b.get();
    }

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.f517c.accept(this.f709a, d);
    }

    public C0513c4(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, C0618n nVar) {
        this.f516b = supplier;
        this.f517c = objDoubleConsumer;
        this.f518d = nVar;
    }
}
