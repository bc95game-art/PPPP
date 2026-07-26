package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.m4 */
/* loaded from: classes2.dex */
public final class C0613m4 extends AbstractC0653q4 implements AbstractC0643p4, AbstractC0574i5 {

    /* renamed from: b */
    public final /* synthetic */ Supplier f658b;

    /* renamed from: c */
    public final /* synthetic */ ObjIntConsumer f659c;

    /* renamed from: d */
    public final /* synthetic */ C0618n f660d;

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

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        this.f709a = this.f660d.apply(this.f709a, ((C0613m4) p4Var).f709a);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f709a = this.f658b.get();
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        this.f659c.accept(this.f709a, i);
    }

    public C0613m4(Supplier supplier, ObjIntConsumer objIntConsumer, C0618n nVar) {
        this.f658b = supplier;
        this.f659c = objIntConsumer;
        this.f660d = nVar;
    }
}
