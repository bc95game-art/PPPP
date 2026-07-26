package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import p004j$.time.format.C0328b;
import p004j$.util.AbstractC0441f0;
import p004j$.util.AbstractC0487s0;
import p004j$.util.C0407c0;
import p004j$.util.C0452g1;
import p004j$.util.C0471n;
import p004j$.util.C0748u;
import p004j$.util.C0758z;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.y */
/* loaded from: classes2.dex */
public abstract class AbstractC0728y extends AbstractC0488a implements AbstractC0499b0 {
    @Override // p004j$.util.stream.AbstractC0499b0
    public final C0758z findAny() {
        return (C0758z) m226H0(C0519d0.f531d);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final C0758z findFirst() {
        return (C0758z) m226H0(C0519d0.f530c);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final AbstractC0499b0 sorted() {
        return new C0515c6(this, EnumC0725x6.f834q | EnumC0725x6.f832o, 0);
    }

    /* renamed from: T0 */
    public static AbstractC0487s0 m64T0(Spliterator spliterator) {
        if (spliterator instanceof AbstractC0487s0) {
            return (AbstractC0487s0) spliterator;
        }
        if (AbstractC0547f8.f558a) {
            AbstractC0547f8.m205a(AbstractC0488a.class, "using DoubleStream.adapt(Spliterator<Double> s)");
            throw null;
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    public void forEach(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        m226H0(new C0599l0(doubleConsumer, false));
    }

    public void forEachOrdered(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        m226H0(new C0599l0(doubleConsumer, true));
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: L0 */
    public final EnumC0735y6 mo41L0() {
        return EnumC0735y6.DOUBLE_VALUE;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: J0 */
    public final AbstractC0531e2 mo43J0(AbstractC0488a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return AbstractC0692u3.m116c0(aVar, spliterator, z);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: S0 */
    public final Spliterator mo40S0(AbstractC0488a aVar, Supplier supplier, boolean z) {
        return new AbstractC0744z6(aVar, supplier, z);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: K0 */
    public final boolean mo42K0(Spliterator spliterator, AbstractC0594k5 k5Var) {
        DoubleConsumer doubleConsumer;
        boolean e;
        AbstractC0487s0 T0 = m64T0(spliterator);
        if (k5Var instanceof DoubleConsumer) {
            doubleConsumer = (DoubleConsumer) k5Var;
        } else if (!AbstractC0547f8.f558a) {
            Objects.requireNonNull(k5Var);
            doubleConsumer = new C0407c0(k5Var, 1);
        } else {
            AbstractC0547f8.m205a(AbstractC0488a.class, "using DoubleStream.adapt(Sink<Double> s)");
            throw null;
        }
        do {
            e = k5Var.mo27e();
            if (e) {
                break;
            }
        } while (T0.tryAdvance(doubleConsumer));
        return e;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: A0 */
    public final AbstractC0710w1 mo44A0(long j, IntFunction intFunction) {
        return AbstractC0692u3.m109i0(j);
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0441f0 iterator() {
        AbstractC0487s0 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new C0452g1(spliterator);
    }

    @Override // p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final AbstractC0487s0 spliterator() {
        return m64T0(super.spliterator());
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final Stream boxed() {
        return new C0638p(this, 0, new C0328b(22), 0);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: e */
    public final AbstractC0499b0 mo49e() {
        Objects.requireNonNull(null);
        return new C0648q(this, EnumC0725x6.f833p | EnumC0725x6.f831n, 0);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final Stream mapToObj(DoubleFunction doubleFunction) {
        Objects.requireNonNull(doubleFunction);
        return new C0638p(this, EnumC0725x6.f833p | EnumC0725x6.f831n, doubleFunction, 0);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: A */
    public final IntStream mo55A() {
        Objects.requireNonNull(null);
        return new C0658r(this, EnumC0725x6.f833p | EnumC0725x6.f831n, 0);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: v */
    public final AbstractC0590k1 mo45v() {
        Objects.requireNonNull(null);
        return new C0668s(this, EnumC0725x6.f833p | EnumC0725x6.f831n, 0);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: d */
    public final AbstractC0499b0 mo50d(C0471n nVar) {
        Objects.requireNonNull(nVar);
        return new C0688u(this, EnumC0725x6.f833p | EnumC0725x6.f831n | EnumC0725x6.f837t, nVar, 0);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: b */
    public final AbstractC0499b0 mo52b() {
        Objects.requireNonNull(null);
        return new C0648q(this, EnumC0725x6.f837t, 2);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final AbstractC0499b0 peek(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return new C0688u(this, doubleConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final AbstractC0499b0 limit(long j) {
        if (j >= 0) {
            return AbstractC0692u3.m95v0(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final AbstractC0499b0 skip(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : AbstractC0692u3.m95v0(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: a */
    public final AbstractC0499b0 mo53a() {
        int i = AbstractC0727x8.f846a;
        Objects.requireNonNull(null);
        return new C0515c6(this, AbstractC0727x8.f846a, 1);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: c */
    public final AbstractC0499b0 mo51c() {
        int i = AbstractC0727x8.f846a;
        Objects.requireNonNull(null);
        return new C0515c6(this, AbstractC0727x8.f847b, 2);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final AbstractC0499b0 distinct() {
        return ((AbstractC0514c5) boxed()).distinct().mapToDouble(new C0328b(23));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final double sum() {
        double[] dArr = (double[]) collect(new C0328b(26), new C0328b(27), new C0328b(15));
        int i = AbstractC0578j.f608a;
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        return (!Double.isNaN(d) || !Double.isInfinite(d2)) ? d : d2;
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final C0758z min() {
        return reduce(new C0328b(16));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final C0758z max() {
        return reduce(new C0328b(25));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final C0758z average() {
        double[] dArr = (double[]) collect(new C0328b(17), new C0328b(18), new C0328b(19));
        if (dArr[2] <= 0.0d) {
            return C0758z.f884c;
        }
        int i = AbstractC0578j.f608a;
        double d = dArr[0] + dArr[1];
        double d2 = dArr[dArr.length - 1];
        if (Double.isNaN(d) && Double.isInfinite(d2)) {
            d = d2;
        }
        return new C0758z(d / dArr[2]);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final C0748u summaryStatistics() {
        return (C0748u) collect(new C0328b(9), new C0328b(20), new C0328b(21));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C0618n nVar = new C0618n(biConsumer, 0);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objDoubleConsumer);
        Objects.requireNonNull(nVar);
        return m226H0(new C0741z3(EnumC0735y6.DOUBLE_VALUE, nVar, objDoubleConsumer, supplier, 1));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: p */
    public final boolean mo47p() {
        return ((Boolean) m226H0(AbstractC0692u3.m96u0(EnumC0660r1.ANY))).booleanValue();
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: u */
    public final boolean mo46u() {
        return ((Boolean) m226H0(AbstractC0692u3.m96u0(EnumC0660r1.ALL))).booleanValue();
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: C */
    public final boolean mo54C() {
        return ((Boolean) m226H0(AbstractC0692u3.m96u0(EnumC0660r1.NONE))).booleanValue();
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final double[] toArray() {
        return (double[]) AbstractC0692u3.m102o0((AbstractC0730y1) m225I0(new C0328b(24))).mo79b();
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return ((Double) m226H0(new C0523d4(EnumC0735y6.DOUBLE_VALUE, doubleBinaryOperator, d))).doubleValue();
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final C0758z reduce(DoubleBinaryOperator doubleBinaryOperator) {
        Objects.requireNonNull(doubleBinaryOperator);
        return (C0758z) m226H0(new C0722x3(EnumC0735y6.DOUBLE_VALUE, doubleBinaryOperator, 1));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final long count() {
        return ((Long) m226H0(new C0503b4(1))).longValue();
    }
}
