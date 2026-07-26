package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import p004j$.time.format.C0328b;
import p004j$.util.AbstractC0460j0;
import p004j$.util.AbstractC0751v0;
import p004j$.util.C0401a0;
import p004j$.util.C0439e1;
import p004j$.util.C0451g0;
import p004j$.util.C0750v;
import p004j$.util.C0758z;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.z0 */
/* loaded from: classes2.dex */
public abstract class AbstractC0738z0 extends AbstractC0488a implements IntStream {
    @Override // p004j$.util.stream.IntStream
    public final C0401a0 findAny() {
        return (C0401a0) m226H0(C0539f0.f549d);
    }

    @Override // p004j$.util.stream.IntStream
    public final C0401a0 findFirst() {
        return (C0401a0) m226H0(C0539f0.f548c);
    }

    @Override // p004j$.util.stream.IntStream
    public final IntStream sorted() {
        return new C0525d6(this, EnumC0725x6.f834q | EnumC0725x6.f832o, 0);
    }

    public void forEach(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        m226H0(new C0609m0(intConsumer, false));
    }

    public void forEachOrdered(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        m226H0(new C0609m0(intConsumer, true));
    }

    /* renamed from: T0 */
    public static AbstractC0751v0 m39T0(Spliterator spliterator) {
        if (spliterator instanceof AbstractC0751v0) {
            return (AbstractC0751v0) spliterator;
        }
        if (AbstractC0547f8.f558a) {
            AbstractC0547f8.m205a(AbstractC0488a.class, "using IntStream.adapt(Spliterator<Integer> s)");
            throw null;
        }
        throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: L0 */
    public final EnumC0735y6 mo41L0() {
        return EnumC0735y6.INT_VALUE;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: J0 */
    public final AbstractC0531e2 mo43J0(AbstractC0488a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return AbstractC0692u3.m115d0(aVar, spliterator, z);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: S0 */
    public final Spliterator mo40S0(AbstractC0488a aVar, Supplier supplier, boolean z) {
        return new AbstractC0744z6(aVar, supplier, z);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: K0 */
    public final boolean mo42K0(Spliterator spliterator, AbstractC0594k5 k5Var) {
        IntConsumer intConsumer;
        boolean e;
        AbstractC0751v0 T0 = m39T0(spliterator);
        if (k5Var instanceof IntConsumer) {
            intConsumer = (IntConsumer) k5Var;
        } else if (!AbstractC0547f8.f558a) {
            Objects.requireNonNull(k5Var);
            intConsumer = new C0451g0(k5Var, 1);
        } else {
            AbstractC0547f8.m205a(AbstractC0488a.class, "using IntStream.adapt(Sink<Integer> s)");
            throw null;
        }
        do {
            e = k5Var.mo27e();
            if (e) {
                break;
            }
        } while (T0.tryAdvance(intConsumer));
        return e;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: A0 */
    public final AbstractC0710w1 mo44A0(long j, IntFunction intFunction) {
        return AbstractC0692u3.m98s0(j);
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0460j0 iterator() {
        AbstractC0751v0 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new C0439e1(spliterator);
    }

    @Override // p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final AbstractC0751v0 spliterator() {
        return m39T0(super.spliterator());
    }

    @Override // p004j$.util.stream.IntStream
    public final AbstractC0590k1 asLongStream() {
        return new C0668s(this, 0, 1);
    }

    @Override // p004j$.util.stream.IntStream
    public final AbstractC0499b0 asDoubleStream() {
        return new C0648q(this, 0, 3);
    }

    @Override // p004j$.util.stream.IntStream
    public final Stream boxed() {
        return new C0638p(this, 0, new C0529e0(9), 1);
    }

    @Override // p004j$.util.stream.IntStream
    /* renamed from: e */
    public final IntStream mo35e() {
        Objects.requireNonNull(null);
        return new C0658r(this, EnumC0725x6.f833p | EnumC0725x6.f831n, 1);
    }

    @Override // p004j$.util.stream.IntStream
    public final Stream mapToObj(IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new C0638p(this, EnumC0725x6.f833p | EnumC0725x6.f831n, intFunction, 1);
    }

    @Override // p004j$.util.stream.IntStream
    /* renamed from: l */
    public final AbstractC0590k1 mo33l() {
        Objects.requireNonNull(null);
        return new C0668s(this, EnumC0725x6.f833p | EnumC0725x6.f831n, 2);
    }

    @Override // p004j$.util.stream.IntStream
    /* renamed from: g */
    public final AbstractC0499b0 mo34g() {
        Objects.requireNonNull(null);
        return new C0648q(this, EnumC0725x6.f833p | EnumC0725x6.f831n, 4);
    }

    @Override // p004j$.util.stream.IntStream
    public final int reduce(int i, IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return ((Integer) m226H0(new C0593k4(EnumC0735y6.INT_VALUE, intBinaryOperator, i))).intValue();
    }

    @Override // p004j$.util.stream.IntStream
    /* renamed from: s */
    public final IntStream mo31s(C0589k0 k0Var) {
        Objects.requireNonNull(k0Var);
        return new C0679t0(this, EnumC0725x6.f833p | EnumC0725x6.f831n | EnumC0725x6.f837t, k0Var, 1);
    }

    @Override // p004j$.util.stream.IntStream
    public final C0401a0 reduce(IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return (C0401a0) m226H0(new C0722x3(EnumC0735y6.INT_VALUE, intBinaryOperator, 3));
    }

    @Override // p004j$.util.stream.IntStream
    /* renamed from: b */
    public final IntStream mo37b() {
        Objects.requireNonNull(null);
        return new C0658r(this, EnumC0725x6.f837t, 3);
    }

    @Override // p004j$.util.stream.IntStream
    public final IntStream peek(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return new C0679t0(this, intConsumer);
    }

    @Override // p004j$.util.stream.IntStream
    public final IntStream limit(long j) {
        if (j >= 0) {
            return AbstractC0692u3.m92x0(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // p004j$.util.stream.IntStream
    public final IntStream skip(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : AbstractC0692u3.m92x0(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // p004j$.util.stream.IntStream
    /* renamed from: a */
    public final IntStream mo38a() {
        int i = AbstractC0727x8.f846a;
        Objects.requireNonNull(null);
        return new C0525d6(this, AbstractC0727x8.f846a, 1);
    }

    @Override // p004j$.util.stream.IntStream
    /* renamed from: c */
    public final IntStream mo36c() {
        int i = AbstractC0727x8.f846a;
        Objects.requireNonNull(null);
        return new C0525d6(this, AbstractC0727x8.f847b, 2);
    }

    @Override // p004j$.util.stream.IntStream
    public final long count() {
        return ((Long) m226H0(new C0503b4(3))).longValue();
    }

    @Override // p004j$.util.stream.IntStream
    public final IntStream distinct() {
        return ((AbstractC0514c5) boxed()).distinct().mapToInt(new C0529e0(8));
    }

    @Override // p004j$.util.stream.IntStream
    public final int sum() {
        return reduce(0, new C0529e0(13));
    }

    @Override // p004j$.util.stream.IntStream
    public final C0401a0 min() {
        return reduce(new C0529e0(10));
    }

    @Override // p004j$.util.stream.IntStream
    public final C0401a0 max() {
        return reduce(new C0529e0(14));
    }

    @Override // p004j$.util.stream.IntStream
    public final C0758z average() {
        long[] jArr = (long[]) collect(new C0529e0(15), new C0529e0(16), new C0529e0(17));
        long j = jArr[0];
        if (j > 0) {
            return new C0758z(jArr[1] / j);
        }
        return C0758z.f884c;
    }

    @Override // p004j$.util.stream.IntStream
    public final C0750v summaryStatistics() {
        return (C0750v) collect(new C0328b(10), new C0529e0(11), new C0529e0(12));
    }

    @Override // p004j$.util.stream.IntStream
    public final Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        C0618n nVar = new C0618n(biConsumer, 1);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objIntConsumer);
        Objects.requireNonNull(nVar);
        return m226H0(new C0741z3(EnumC0735y6.INT_VALUE, nVar, objIntConsumer, supplier, 4));
    }

    @Override // p004j$.util.stream.IntStream
    /* renamed from: y */
    public final boolean mo29y() {
        return ((Boolean) m226H0(AbstractC0692u3.m93w0(EnumC0660r1.ANY))).booleanValue();
    }

    @Override // p004j$.util.stream.IntStream
    /* renamed from: q */
    public final boolean mo32q() {
        return ((Boolean) m226H0(AbstractC0692u3.m93w0(EnumC0660r1.ALL))).booleanValue();
    }

    @Override // p004j$.util.stream.IntStream
    /* renamed from: t */
    public final boolean mo30t() {
        return ((Boolean) m226H0(AbstractC0692u3.m93w0(EnumC0660r1.NONE))).booleanValue();
    }

    @Override // p004j$.util.stream.IntStream
    public final int[] toArray() {
        return (int[]) AbstractC0692u3.m101p0((AbstractC0491a2) m225I0(new C0529e0(7))).mo79b();
    }
}
