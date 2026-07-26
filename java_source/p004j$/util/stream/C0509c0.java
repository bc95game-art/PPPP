package p004j$.util.stream;

import java.util.function.Predicate;
import java.util.function.Supplier;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.c0 */
/* loaded from: classes2.dex */
public final class C0509c0 implements AbstractC0527d8 {

    /* renamed from: a */
    public final int f509a;

    /* renamed from: b */
    public final Object f510b;

    /* renamed from: c */
    public final Predicate f511c;

    /* renamed from: d */
    public final Supplier f512d;

    public C0509c0(boolean z, EnumC0735y6 y6Var, Object obj, Predicate predicate, Supplier supplier) {
        this.f509a = (z ? 0 : EnumC0725x6.f835r) | EnumC0725x6.f838u;
        this.f510b = obj;
        this.f511c = predicate;
        this.f512d = supplier;
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: w */
    public final int mo94w() {
        return this.f509a;
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: f */
    public final Object mo113f(AbstractC0488a aVar, Spliterator spliterator) {
        AbstractC0537e8 e8Var = (AbstractC0537e8) this.f512d.get();
        aVar.mo142E0(spliterator, e8Var);
        Object obj = e8Var.get();
        return obj != null ? obj : this.f510b;
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: j */
    public final Object mo108j(AbstractC0692u3 u3Var, Spliterator spliterator) {
        AbstractC0488a aVar = (AbstractC0488a) u3Var;
        return new C0579j0(this, EnumC0725x6.ORDERED.m66l(aVar.f481m), aVar, spliterator).invoke();
    }
}
