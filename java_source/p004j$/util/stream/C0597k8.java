package p004j$.util.stream;

import java.util.function.LongPredicate;
/* renamed from: j$.util.stream.k8 */
/* loaded from: classes2.dex */
public final class C0597k8 extends AbstractC0544f5 {

    /* renamed from: b */
    public final boolean f631b = true;

    public C0597k8(C0535e6 e6Var, AbstractC0594k5 k5Var) {
        super(k5Var);
    }

    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f554a.mo23c(-1L);
    }

    @Override // p004j$.util.stream.AbstractC0584j5, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        if (this.f631b) {
            LongPredicate longPredicate = null;
            longPredicate.test(j);
            throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        return !this.f631b || this.f554a.mo27e();
    }
}
