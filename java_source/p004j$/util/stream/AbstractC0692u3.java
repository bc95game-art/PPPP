package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import p004j$.util.AbstractC0487s0;
import p004j$.util.AbstractC0751v0;
import p004j$.util.AbstractC0757y0;
import p004j$.util.C0471n;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
import p004j$.util.concurrent.C0428t;
/* renamed from: j$.util.stream.u3 */
/* loaded from: classes2.dex */
public abstract class AbstractC0692u3 implements AbstractC0527d8 {

    /* renamed from: a */
    public static final C0721x2 f774a = new Object();

    /* renamed from: b */
    public static final C0701v2 f775b = new Object();

    /* renamed from: c */
    public static final C0711w2 f776c = new Object();

    /* renamed from: d */
    public static final C0691u2 f777d = new Object();

    /* renamed from: e */
    public static final int[] f778e = new int[0];

    /* renamed from: f */
    public static final long[] f779f = new long[0];

    /* renamed from: g */
    public static final double[] f780g = new double[0];

    /* renamed from: A0 */
    public abstract AbstractC0710w1 mo44A0(long j, IntFunction intFunction);

    /* renamed from: D0 */
    public abstract AbstractC0643p4 mo26D0();

    /* renamed from: E0 */
    public abstract AbstractC0594k5 mo142E0(Spliterator spliterator, AbstractC0594k5 k5Var);

    /* renamed from: F0 */
    public abstract AbstractC0594k5 mo140F0(AbstractC0594k5 k5Var);

    /* renamed from: G0 */
    public abstract Spliterator mo138G0(Spliterator spliterator);

    /* renamed from: g0 */
    public abstract void mo111g0(Spliterator spliterator, AbstractC0594k5 k5Var);

    /* renamed from: h0 */
    public abstract boolean mo110h0(Spliterator spliterator, AbstractC0594k5 k5Var);

    /* renamed from: k0 */
    public abstract AbstractC0531e2 mo106k0(Spliterator spliterator, boolean z, IntFunction intFunction);

    /* renamed from: l0 */
    public abstract long mo105l0(Spliterator spliterator);

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: w */
    public /* synthetic */ int mo94w() {
        return 0;
    }

    /* renamed from: r0 */
    public static C0471n m99r0(Function function) {
        C0471n nVar = new C0471n(5);
        nVar.f448b = function;
        return nVar;
    }

    /* renamed from: X */
    public static long m121X(long j, long j2, long j3) {
        if (j >= 0) {
            return Math.max(-1L, Math.min(j - j2, j3));
        }
        return -1L;
    }

    /* renamed from: a0 */
    public static long m118a0(long j, long j2) {
        long j3 = j2 >= 0 ? j + j2 : Long.MAX_VALUE;
        if (j3 >= 0) {
            return j3;
        }
        return Long.MAX_VALUE;
    }

    /* renamed from: Y */
    public static Spliterator m120Y(EnumC0735y6 y6Var, Spliterator spliterator, long j, long j2) {
        long a0 = m118a0(j, j2);
        int i = AbstractC0684t5.f765a[y6Var.ordinal()];
        if (i == 1) {
            return new C0666r7(spliterator, j, a0);
        }
        if (i == 2) {
            return new AbstractC0656q7((AbstractC0751v0) spliterator, j, a0);
        }
        if (i == 3) {
            return new AbstractC0656q7((AbstractC0757y0) spliterator, j, a0);
        }
        if (i == 4) {
            return new AbstractC0656q7((AbstractC0487s0) spliterator, j, a0);
        }
        throw new IllegalStateException("Unknown shape " + y6Var);
    }

    /* renamed from: B0 */
    public static C0428t m146B0(EnumC0660r1 r1Var, Predicate predicate) {
        Objects.requireNonNull(predicate);
        Objects.requireNonNull(r1Var);
        return new C0428t(EnumC0735y6.REFERENCE, r1Var, new C0428t(5, r1Var, predicate));
    }

    /* renamed from: j0 */
    public static AbstractC0731y2 m107j0(EnumC0735y6 y6Var) {
        int i = AbstractC0551g2.f561a[y6Var.ordinal()];
        if (i == 1) {
            return f774a;
        }
        if (i == 2) {
            return f775b;
        }
        if (i == 3) {
            return f776c;
        }
        if (i == 4) {
            return f777d;
        }
        throw new IllegalStateException("Unknown shape " + y6Var);
    }

    /* renamed from: w0 */
    public static C0428t m93w0(EnumC0660r1 r1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(r1Var);
        return new C0428t(EnumC0735y6.INT_VALUE, r1Var, new C0600l1(r1Var, 1));
    }

    /* renamed from: C0 */
    public static C0614m5 m145C0(AbstractC0514c5 c5Var, long j, long j2) {
        if (j >= 0) {
            return new C0614m5(c5Var, m104m0(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    /* renamed from: W */
    public static AbstractC0531e2 m122W(AbstractC0531e2 e2Var, long j, long j2, IntFunction intFunction) {
        if (j == 0 && j2 == e2Var.count()) {
            return e2Var;
        }
        Spliterator spliterator = e2Var.mo904spliterator();
        long j3 = j2 - j;
        AbstractC0710w1 Z = m119Z(j3, intFunction);
        Z.mo23c(j3);
        for (int i = 0; i < j && spliterator.tryAdvance(new C0529e0(29)); i++) {
        }
        if (j2 == e2Var.count()) {
            spliterator.forEachRemaining(Z);
        } else {
            for (int i2 = 0; i2 < j3 && spliterator.tryAdvance(Z); i2++) {
            }
        }
        Z.end();
        return Z.mo903build();
    }

    /* renamed from: f0 */
    public static AbstractC0561h2 m112f0(EnumC0735y6 y6Var, AbstractC0531e2 e2Var, AbstractC0531e2 e2Var2) {
        int i = AbstractC0551g2.f561a[y6Var.ordinal()];
        if (i == 1) {
            return new AbstractC0561h2(e2Var, e2Var2);
        }
        if (i == 2) {
            return new AbstractC0561h2((AbstractC0491a2) e2Var, (AbstractC0491a2) e2Var2);
        }
        if (i == 3) {
            return new AbstractC0561h2((AbstractC0511c2) e2Var, (AbstractC0511c2) e2Var2);
        }
        if (i == 4) {
            return new AbstractC0561h2((AbstractC0730y1) e2Var, (AbstractC0730y1) e2Var2);
        }
        throw new IllegalStateException("Unknown shape " + y6Var);
    }

    /* renamed from: y0 */
    public static C0428t m91y0(EnumC0660r1 r1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(r1Var);
        return new C0428t(EnumC0735y6.LONG_VALUE, r1Var, new C0600l1(r1Var, 0));
    }

    /* renamed from: K */
    public static void m134K() {
        throw new IllegalStateException("called wrong accept method");
    }

    /* renamed from: u0 */
    public static C0428t m96u0(EnumC0660r1 r1Var) {
        Objects.requireNonNull(null);
        Objects.requireNonNull(r1Var);
        return new C0428t(EnumC0735y6.DOUBLE_VALUE, r1Var, new C0600l1(r1Var, 2));
    }

    /* renamed from: L */
    public static void m133L() {
        throw new IllegalStateException("called wrong accept method");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.stream.i2, j$.util.stream.w1] */
    /* JADX WARN: Type inference failed for: r3v1, types: [j$.util.stream.u6, j$.util.stream.w1] */
    /* renamed from: Z */
    public static AbstractC0710w1 m119Z(long j, IntFunction intFunction) {
        if (j < 0 || j >= 2147483639) {
            return new C0695u6();
        }
        return new C0571i2(j, intFunction);
    }

    /* renamed from: D */
    public static void m144D() {
        throw new IllegalStateException("called wrong accept method");
    }

    /* renamed from: G */
    public static void m139G(AbstractC0574i5 i5Var, Integer num) {
        if (!AbstractC0547f8.f558a) {
            i5Var.accept(num.intValue());
        } else {
            AbstractC0547f8.m205a(i5Var.getClass(), "{0} calling Sink.OfInt.accept(Integer)");
            throw null;
        }
    }

    /* renamed from: I */
    public static void m136I(AbstractC0584j5 j5Var, Long l) {
        if (!AbstractC0547f8.f558a) {
            j5Var.accept(l.longValue());
        } else {
            AbstractC0547f8.m205a(j5Var.getClass(), "{0} calling Sink.OfLong.accept(Long)");
            throw null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.stream.a3, j$.util.stream.u1] */
    /* JADX WARN: Type inference failed for: r3v1, types: [j$.util.stream.t6, j$.util.stream.u1] */
    /* renamed from: s0 */
    public static AbstractC0690u1 m98s0(long j) {
        if (j < 0 || j >= 2147483639) {
            return new AbstractC0685t6();
        }
        return new C0492a3(j);
    }

    /* renamed from: E */
    public static void m143E(AbstractC0564h5 h5Var, Double d) {
        if (!AbstractC0547f8.f558a) {
            h5Var.accept(d.doubleValue());
        } else {
            AbstractC0547f8.m205a(h5Var.getClass(), "{0} calling Sink.OfDouble.accept(Double)");
            throw null;
        }
    }

    /* renamed from: x0 */
    public static C0634o5 m92x0(AbstractC0738z0 z0Var, long j, long j2) {
        if (j >= 0) {
            return new C0634o5(z0Var, m104m0(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.stream.j3, j$.util.stream.v1] */
    /* JADX WARN: Type inference failed for: r3v1, types: [j$.util.stream.t6, j$.util.stream.v1] */
    /* renamed from: t0 */
    public static AbstractC0700v1 m97t0(long j) {
        if (j < 0 || j >= 2147483639) {
            return new AbstractC0685t6();
        }
        return new C0582j3(j);
    }

    /* renamed from: M */
    public static Object[] m132M(AbstractC0521d2 d2Var, IntFunction intFunction) {
        if (AbstractC0547f8.f558a) {
            AbstractC0547f8.m205a(d2Var.getClass(), "{0} calling Node.OfPrimitive.asArray");
            throw null;
        } else if (d2Var.count() < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) d2Var.count());
            d2Var.mo70k(objArr, 0);
            return objArr;
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [j$.util.stream.r2, j$.util.stream.t1] */
    /* JADX WARN: Type inference failed for: r3v1, types: [j$.util.stream.t6, j$.util.stream.t1] */
    /* renamed from: i0 */
    public static AbstractC0680t1 m109i0(long j) {
        if (j < 0 || j >= 2147483639) {
            return new AbstractC0685t6();
        }
        return new C0661r2(j);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.function.LongFunction, j$.util.stream.k0, java.lang.Object] */
    /* renamed from: b0 */
    public static AbstractC0531e2 m117b0(AbstractC0692u3 u3Var, Spliterator spliterator, boolean z, IntFunction intFunction) {
        long l0 = u3Var.mo105l0(spliterator);
        if (l0 < 0 || !spliterator.hasCharacteristics(16384)) {
            ?? obj = new Object();
            obj.f625a = intFunction;
            AbstractC0531e2 e2Var = (AbstractC0531e2) new C0591k2(u3Var, spliterator, obj, new C0541f2(7), 3).invoke();
            return z ? m103n0(e2Var, intFunction) : e2Var;
        } else if (l0 < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) l0);
            new C0642p3(spliterator, u3Var, objArr).invoke();
            return new C0571i2(objArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    /* renamed from: R */
    public static void m127R(AbstractC0491a2 a2Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            a2Var.mo153g((IntConsumer) consumer);
        } else if (!AbstractC0547f8.f558a) {
            ((AbstractC0751v0) a2Var.mo904spliterator()).forEachRemaining(consumer);
        } else {
            AbstractC0547f8.m205a(a2Var.getClass(), "{0} calling Node.OfInt.forEachRemaining(Consumer)");
            throw null;
        }
    }

    /* renamed from: z0 */
    public static C0654q5 m90z0(AbstractC0560h1 h1Var, long j, long j2) {
        if (j >= 0) {
            return new C0654q5(h1Var, m104m0(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    /* renamed from: O */
    public static void m130O(AbstractC0491a2 a2Var, Integer[] numArr, int i) {
        if (!AbstractC0547f8.f558a) {
            int[] iArr = (int[]) a2Var.mo79b();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                numArr[i + i2] = Integer.valueOf(iArr[i2]);
            }
            return;
        }
        AbstractC0547f8.m205a(a2Var.getClass(), "{0} calling Node.OfInt.copyInto(Integer[], int)");
        throw null;
    }

    /* renamed from: U */
    public static AbstractC0491a2 m124U(AbstractC0491a2 a2Var, long j, long j2) {
        if (j == 0 && j2 == a2Var.count()) {
            return a2Var;
        }
        long j3 = j2 - j;
        AbstractC0751v0 v0Var = (AbstractC0751v0) a2Var.mo904spliterator();
        AbstractC0690u1 s0 = m98s0(j3);
        s0.mo23c(j3);
        for (int i = 0; i < j && v0Var.tryAdvance((IntConsumer) new C0739z1(0)); i++) {
        }
        if (j2 == a2Var.count()) {
            v0Var.forEachRemaining((IntConsumer) s0);
        } else {
            for (int i2 = 0; i2 < j3 && v0Var.tryAdvance((IntConsumer) s0); i2++) {
            }
        }
        s0.end();
        return s0.mo903build();
    }

    /* renamed from: d0 */
    public static AbstractC0491a2 m115d0(AbstractC0692u3 u3Var, Spliterator spliterator, boolean z) {
        long l0 = u3Var.mo105l0(spliterator);
        if (l0 < 0 || !spliterator.hasCharacteristics(16384)) {
            AbstractC0491a2 a2Var = (AbstractC0491a2) new C0591k2(u3Var, spliterator, new C0541f2(3), new C0541f2(4), 1).invoke();
            return z ? m101p0(a2Var) : a2Var;
        } else if (l0 < 2147483639) {
            int[] iArr = new int[(int) l0];
            new C0622n3(spliterator, u3Var, iArr).invoke();
            return new C0492a3(iArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    /* renamed from: e0 */
    public static AbstractC0511c2 m114e0(AbstractC0692u3 u3Var, Spliterator spliterator, boolean z) {
        long l0 = u3Var.mo105l0(spliterator);
        if (l0 < 0 || !spliterator.hasCharacteristics(16384)) {
            AbstractC0511c2 c2Var = (AbstractC0511c2) new C0591k2(u3Var, spliterator, new C0541f2(5), new C0541f2(6), 2).invoke();
            return z ? m100q0(c2Var) : c2Var;
        } else if (l0 < 2147483639) {
            long[] jArr = new long[(int) l0];
            new C0632o3(spliterator, u3Var, jArr).invoke();
            return new C0582j3(jArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    /* renamed from: S */
    public static void m126S(AbstractC0511c2 c2Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            c2Var.mo153g((LongConsumer) consumer);
        } else if (!AbstractC0547f8.f558a) {
            ((AbstractC0757y0) c2Var.mo904spliterator()).forEachRemaining(consumer);
        } else {
            AbstractC0547f8.m205a(c2Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        }
    }

    /* renamed from: P */
    public static void m129P(AbstractC0511c2 c2Var, Long[] lArr, int i) {
        if (!AbstractC0547f8.f558a) {
            long[] jArr = (long[]) c2Var.mo79b();
            for (int i2 = 0; i2 < jArr.length; i2++) {
                lArr[i + i2] = Long.valueOf(jArr[i2]);
            }
            return;
        }
        AbstractC0547f8.m205a(c2Var.getClass(), "{0} calling Node.OfInt.copyInto(Long[], int)");
        throw null;
    }

    /* renamed from: V */
    public static AbstractC0511c2 m123V(AbstractC0511c2 c2Var, long j, long j2) {
        if (j == 0 && j2 == c2Var.count()) {
            return c2Var;
        }
        long j3 = j2 - j;
        AbstractC0757y0 y0Var = (AbstractC0757y0) c2Var.mo904spliterator();
        AbstractC0700v1 t0 = m97t0(j3);
        t0.mo23c(j3);
        for (int i = 0; i < j && y0Var.tryAdvance((LongConsumer) new C0501b2(0)); i++) {
        }
        if (j2 == c2Var.count()) {
            y0Var.forEachRemaining((LongConsumer) t0);
        } else {
            for (int i2 = 0; i2 < j3 && y0Var.tryAdvance((LongConsumer) t0); i2++) {
            }
        }
        t0.end();
        return t0.mo903build();
    }

    /* renamed from: c0 */
    public static AbstractC0730y1 m116c0(AbstractC0692u3 u3Var, Spliterator spliterator, boolean z) {
        long l0 = u3Var.mo105l0(spliterator);
        if (l0 < 0 || !spliterator.hasCharacteristics(16384)) {
            AbstractC0730y1 y1Var = (AbstractC0730y1) new C0591k2(u3Var, spliterator, new C0541f2(1), new C0541f2(2), 0).invoke();
            return z ? m102o0(y1Var) : y1Var;
        } else if (l0 < 2147483639) {
            double[] dArr = new double[(int) l0];
            new C0612m3(spliterator, u3Var, dArr).invoke();
            return new C0661r2(dArr);
        } else {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
    }

    /* renamed from: v0 */
    public static C0674s5 m95v0(AbstractC0728y yVar, long j, long j2) {
        if (j >= 0) {
            return new C0674s5(yVar, m104m0(j2), j, j2);
        }
        throw new IllegalArgumentException("Skip must be non-negative: " + j);
    }

    /* renamed from: n0 */
    public static AbstractC0531e2 m103n0(AbstractC0531e2 e2Var, IntFunction intFunction) {
        if (e2Var.mo58o() <= 0) {
            return e2Var;
        }
        long count = e2Var.count();
        if (count < 2147483639) {
            Object[] objArr = (Object[]) intFunction.apply((int) count);
            new C0682t3(e2Var, objArr, 1).invoke();
            return new C0571i2(objArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    /* renamed from: Q */
    public static void m128Q(AbstractC0730y1 y1Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            y1Var.mo153g((DoubleConsumer) consumer);
        } else if (!AbstractC0547f8.f558a) {
            ((AbstractC0487s0) y1Var.mo904spliterator()).forEachRemaining(consumer);
        } else {
            AbstractC0547f8.m205a(y1Var.getClass(), "{0} calling Node.OfLong.forEachRemaining(Consumer)");
            throw null;
        }
    }

    /* renamed from: p0 */
    public static AbstractC0491a2 m101p0(AbstractC0491a2 a2Var) {
        if (a2Var.mo58o() <= 0) {
            return a2Var;
        }
        long count = a2Var.count();
        if (count < 2147483639) {
            int[] iArr = new int[(int) count];
            new C0682t3(a2Var, iArr, 0).invoke();
            return new C0492a3(iArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    /* renamed from: N */
    public static void m131N(AbstractC0730y1 y1Var, Double[] dArr, int i) {
        if (!AbstractC0547f8.f558a) {
            double[] dArr2 = (double[]) y1Var.mo79b();
            for (int i2 = 0; i2 < dArr2.length; i2++) {
                dArr[i + i2] = Double.valueOf(dArr2[i2]);
            }
            return;
        }
        AbstractC0547f8.m205a(y1Var.getClass(), "{0} calling Node.OfDouble.copyInto(Double[], int)");
        throw null;
    }

    /* renamed from: T */
    public static AbstractC0730y1 m125T(AbstractC0730y1 y1Var, long j, long j2) {
        if (j == 0 && j2 == y1Var.count()) {
            return y1Var;
        }
        long j3 = j2 - j;
        AbstractC0487s0 s0Var = (AbstractC0487s0) y1Var.mo904spliterator();
        AbstractC0680t1 i0 = m109i0(j3);
        i0.mo23c(j3);
        for (int i = 0; i < j && s0Var.tryAdvance((DoubleConsumer) new C0720x1(0)); i++) {
        }
        if (j2 == y1Var.count()) {
            s0Var.forEachRemaining((DoubleConsumer) i0);
        } else {
            for (int i2 = 0; i2 < j3 && s0Var.tryAdvance((DoubleConsumer) i0); i2++) {
            }
        }
        i0.end();
        return i0.mo903build();
    }

    /* renamed from: q0 */
    public static AbstractC0511c2 m100q0(AbstractC0511c2 c2Var) {
        if (c2Var.mo58o() <= 0) {
            return c2Var;
        }
        long count = c2Var.count();
        if (count < 2147483639) {
            long[] jArr = new long[(int) count];
            new C0682t3(c2Var, jArr, 0).invoke();
            return new C0582j3(jArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    /* renamed from: m0 */
    public static int m104m0(long j) {
        return (j != -1 ? EnumC0725x6.f838u : 0) | EnumC0725x6.f837t;
    }

    /* renamed from: o0 */
    public static AbstractC0730y1 m102o0(AbstractC0730y1 y1Var) {
        if (y1Var.mo58o() <= 0) {
            return y1Var;
        }
        long count = y1Var.count();
        if (count < 2147483639) {
            double[] dArr = new double[(int) count];
            new C0682t3(y1Var, dArr, 0).invoke();
            return new C0661r2(dArr);
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: f */
    public Object mo113f(AbstractC0488a aVar, Spliterator spliterator) {
        AbstractC0643p4 D0 = mo26D0();
        aVar.mo142E0(spliterator, D0);
        return D0.get();
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: j */
    public Object mo108j(AbstractC0692u3 u3Var, Spliterator spliterator) {
        return ((AbstractC0643p4) new C0713w4(this, u3Var, spliterator).invoke()).get();
    }
}
