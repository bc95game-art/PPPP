package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import p004j$.time.format.C0328b;
import p004j$.util.AbstractC0472n0;
import p004j$.util.AbstractC0757y0;
import p004j$.util.C0404b0;
import p004j$.util.C0442f1;
import p004j$.util.C0463k0;
import p004j$.util.C0471n;
import p004j$.util.C0754x;
import p004j$.util.C0758z;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.h1 */
/* loaded from: classes2.dex */
public abstract class AbstractC0560h1 extends AbstractC0488a implements AbstractC0590k1 {
    @Override // p004j$.util.stream.AbstractC0590k1
    public final C0404b0 findAny() {
        return (C0404b0) m226H0(C0549g0.f560d);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final C0404b0 findFirst() {
        return (C0404b0) m226H0(C0549g0.f559c);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final AbstractC0590k1 sorted() {
        return new C0535e6(this, EnumC0725x6.f834q | EnumC0725x6.f832o, 0);
    }

    public void forEach(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        m226H0(new C0619n0(longConsumer, false));
    }

    public void forEachOrdered(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        m226H0(new C0619n0(longConsumer, true));
    }

    /* renamed from: T0 */
    public static AbstractC0757y0 m204T0(Spliterator spliterator) {
        if (spliterator instanceof AbstractC0757y0) {
            return (AbstractC0757y0) spliterator;
        }
        if (AbstractC0547f8.f558a) {
            AbstractC0547f8.m205a(AbstractC0488a.class, "using LongStream.adapt(Spliterator<Long> s)");
            throw null;
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: L0 */
    public final EnumC0735y6 mo41L0() {
        return EnumC0735y6.LONG_VALUE;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: J0 */
    public final AbstractC0531e2 mo43J0(AbstractC0488a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return AbstractC0692u3.m114e0(aVar, spliterator, z);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: S0 */
    public final Spliterator mo40S0(AbstractC0488a aVar, Supplier supplier, boolean z) {
        return new AbstractC0744z6(aVar, supplier, z);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: K0 */
    public final boolean mo42K0(Spliterator spliterator, AbstractC0594k5 k5Var) {
        LongConsumer longConsumer;
        boolean e;
        AbstractC0757y0 T0 = m204T0(spliterator);
        if (k5Var instanceof LongConsumer) {
            longConsumer = (LongConsumer) k5Var;
        } else if (!AbstractC0547f8.f558a) {
            Objects.requireNonNull(k5Var);
            longConsumer = new C0463k0(k5Var, 1);
        } else {
            AbstractC0547f8.m205a(AbstractC0488a.class, "using LongStream.adapt(Sink<Long> s)");
            throw null;
        }
        do {
            e = k5Var.mo27e();
            if (e) {
                break;
            }
        } while (T0.tryAdvance(longConsumer));
        return e;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: A0 */
    public final AbstractC0710w1 mo44A0(long j, IntFunction intFunction) {
        return AbstractC0692u3.m97t0(j);
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0472n0 iterator() {
        AbstractC0757y0 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new C0442f1(spliterator);
    }

    @Override // p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final AbstractC0757y0 spliterator() {
        return m204T0(super.spliterator());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final AbstractC0499b0 asDoubleStream() {
        return new C0648q(this, EnumC0725x6.f831n, 5);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final Stream boxed() {
        return new C0638p(this, 0, new C0529e0(23), 2);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: e */
    public final AbstractC0590k1 mo181e() {
        Objects.requireNonNull(null);
        return new C0668s(this, EnumC0725x6.f833p | EnumC0725x6.f831n, 3);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final Stream mapToObj(LongFunction longFunction) {
        Objects.requireNonNull(longFunction);
        return new C0638p(this, EnumC0725x6.f833p | EnumC0725x6.f831n, longFunction, 2);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: B */
    public final IntStream mo186B() {
        Objects.requireNonNull(null);
        return new C0658r(this, EnumC0725x6.f833p | EnumC0725x6.f831n, 4);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: k */
    public final AbstractC0499b0 mo180k() {
        Objects.requireNonNull(null);
        return new C0648q(this, EnumC0725x6.f833p | EnumC0725x6.f831n, 6);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: d */
    public final AbstractC0590k1 mo182d(C0471n nVar) {
        Objects.requireNonNull(nVar);
        return new C0520d1(this, EnumC0725x6.f833p | EnumC0725x6.f831n | EnumC0725x6.f837t, nVar, 0);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: b */
    public final AbstractC0590k1 mo184b() {
        Objects.requireNonNull(null);
        return new C0668s(this, EnumC0725x6.f837t, 5);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final AbstractC0590k1 peek(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return new C0520d1(this, longConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final AbstractC0590k1 limit(long j) {
        if (j >= 0) {
            return AbstractC0692u3.m90z0(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final AbstractC0590k1 skip(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : AbstractC0692u3.m90z0(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: a */
    public final AbstractC0590k1 mo185a() {
        int i = AbstractC0727x8.f846a;
        Objects.requireNonNull(null);
        return new C0535e6(this, AbstractC0727x8.f846a, 1);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: c */
    public final AbstractC0590k1 mo183c() {
        int i = AbstractC0727x8.f846a;
        Objects.requireNonNull(null);
        return new C0535e6(this, AbstractC0727x8.f847b, 2);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final AbstractC0590k1 distinct() {
        return ((AbstractC0514c5) boxed()).distinct().mapToLong(new C0529e0(20));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final long sum() {
        return reduce(0L, new C0529e0(28));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final C0404b0 min() {
        return reduce(new C0529e0(19));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final C0404b0 max() {
        return reduce(new C0529e0(27));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final C0758z average() {
        long[] jArr = (long[]) collect(new C0529e0(24), new C0529e0(25), new C0529e0(26));
        long j = jArr[0];
        if (j > 0) {
            return new C0758z(jArr[1] / j);
        }
        return C0758z.f884c;
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final long reduce(long j, LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return ((Long) m226H0(new C0702v3(EnumC0735y6.LONG_VALUE, longBinaryOperator, j))).longValue();
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final C0754x summaryStatistics() {
        return (C0754x) collect(new C0328b(11), new C0529e0(18), new C0529e0(21));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C0618n nVar = new C0618n(biConsumer, 2);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objLongConsumer);
        Objects.requireNonNull(nVar);
        return m226H0(new C0741z3(EnumC0735y6.LONG_VALUE, nVar, objLongConsumer, supplier, 0));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: r */
    public final boolean mo178r() {
        return ((Boolean) m226H0(AbstractC0692u3.m91y0(EnumC0660r1.ANY))).booleanValue();
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final C0404b0 reduce(LongBinaryOperator longBinaryOperator) {
        Objects.requireNonNull(longBinaryOperator);
        return (C0404b0) m226H0(new C0722x3(EnumC0735y6.LONG_VALUE, longBinaryOperator, 0));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: x */
    public final boolean mo177x() {
        return ((Boolean) m226H0(AbstractC0692u3.m91y0(EnumC0660r1.ALL))).booleanValue();
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: n */
    public final boolean mo179n() {
        return ((Boolean) m226H0(AbstractC0692u3.m91y0(EnumC0660r1.NONE))).booleanValue();
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final long[] toArray() {
        return (long[]) AbstractC0692u3.m100q0((AbstractC0511c2) m225I0(new C0529e0(22))).mo79b();
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final long count() {
        return ((Long) m226H0(new C0503b4(0))).longValue();
    }
}
