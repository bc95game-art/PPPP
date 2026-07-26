package p004j$.util.stream;

import java.util.function.DoublePredicate;
/* renamed from: j$.util.stream.m8 */
/* loaded from: classes2.dex */
public final class C0617m8 extends AbstractC0524d5 {

    /* renamed from: b */
    public final boolean f664b = true;

    public C0617m8(C0515c6 c6Var, AbstractC0594k5 k5Var) {
        super(k5Var);
    }

    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f536a.mo23c(-1L);
    }

    @Override // p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        if (this.f664b) {
            DoublePredicate doublePredicate = null;
            doublePredicate.test(d);
            throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        return !this.f664b || this.f536a.mo27e();
    }
}
