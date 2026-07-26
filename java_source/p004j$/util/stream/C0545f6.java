package p004j$.util.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;
import p004j$.util.EnumC0437e;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.f6 */
/* loaded from: classes2.dex */
public final class C0545f6 extends AbstractC0494a5 {

    /* renamed from: s */
    public final boolean f555s;

    /* renamed from: t */
    public final Comparator f556t;

    public C0545f6(AbstractC0514c5 c5Var) {
        super(c5Var, EnumC0725x6.f834q | EnumC0725x6.f832o);
        this.f555s = true;
        this.f556t = EnumC0437e.INSTANCE;
    }

    public C0545f6(AbstractC0514c5 c5Var, Comparator comparator) {
        super(c5Var, EnumC0725x6.f834q | EnumC0725x6.f833p);
        this.f555s = false;
        this.f556t = (Comparator) Objects.requireNonNull(comparator);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        Objects.requireNonNull(k5Var);
        if (EnumC0725x6.SORTED.m66l(i) && this.f555s) {
            return k5Var;
        }
        if (EnumC0725x6.SIZED.m66l(i)) {
            return new AbstractC0734y5(k5Var, this.f556t);
        }
        return new AbstractC0734y5(k5Var, this.f556t);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: M0 */
    public final AbstractC0531e2 mo161M0(AbstractC0692u3 u3Var, Spliterator spliterator, IntFunction intFunction) {
        if (EnumC0725x6.SORTED.m66l(((AbstractC0488a) u3Var).f481m) && this.f555s) {
            return u3Var.mo106k0(spliterator, false, intFunction);
        }
        Object[] m = u3Var.mo106k0(spliterator, true, intFunction).mo59m(intFunction);
        Arrays.sort(m, this.f556t);
        return new C0571i2(m);
    }
}
