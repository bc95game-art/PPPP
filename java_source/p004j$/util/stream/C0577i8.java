package p004j$.util.stream;

import java.util.function.IntPredicate;
/* renamed from: j$.util.stream.i8 */
/* loaded from: classes2.dex */
public final class C0577i8 extends AbstractC0534e5 {

    /* renamed from: b */
    public final boolean f607b = true;

    public C0577i8(C0525d6 d6Var, AbstractC0594k5 k5Var) {
        super(k5Var);
    }

    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f544a.mo23c(-1L);
    }

    @Override // p004j$.util.stream.AbstractC0574i5, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        if (this.f607b) {
            IntPredicate intPredicate = null;
            intPredicate.test(i);
            throw null;
        }
    }

    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        return !this.f607b || this.f544a.mo27e();
    }
}
