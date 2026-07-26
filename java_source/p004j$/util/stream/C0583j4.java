package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.j4 */
/* loaded from: classes2.dex */
public final class C0583j4 implements AbstractC0643p4, AbstractC0574i5 {

    /* renamed from: a */
    public int f615a;

    /* renamed from: b */
    public final /* synthetic */ int f616b;

    /* renamed from: c */
    public final /* synthetic */ IntBinaryOperator f617c;

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

    public C0583j4(int i, IntBinaryOperator intBinaryOperator) {
        this.f616b = i;
        this.f617c = intBinaryOperator;
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        accept(((C0583j4) p4Var).f615a);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f615a = this.f616b;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        this.f615a = this.f617c.applyAsInt(this.f615a, i);
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return Integer.valueOf(this.f615a);
    }
}
