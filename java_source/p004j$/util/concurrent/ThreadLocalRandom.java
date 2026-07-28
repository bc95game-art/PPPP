package p004j$.util.concurrent;

import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import p004j$.util.C0482q1;
import p004j$.util.stream.AbstractC0488a;
import p004j$.util.stream.C0489a0;
import p004j$.util.stream.C0580j1;
import p004j$.util.stream.EnumC0725x6;
import p004j$.util.stream.IntStream;
/* renamed from: j$.util.concurrent.ThreadLocalRandom */
/* loaded from: classes2.dex */
public class ThreadLocalRandom extends Random {
    private static final long serialVersionUID = -5851777807851030925L;

    /* renamed from: a */
    public long f331a;

    /* renamed from: b */
    public int f332b;

    /* renamed from: c */
    public final boolean f333c;
    private static final ObjectStreamField[] serialPersistentFields = {new ObjectStreamField("rnd", Long.TYPE), new ObjectStreamField("initialized", Boolean.TYPE)};

    /* renamed from: d */
    public static final ThreadLocal f327d = new ThreadLocal();

    /* renamed from: e */
    public static final AtomicInteger f328e = new AtomicInteger();

    /* renamed from: f */
    public static final C0430v f329f = new ThreadLocal();

    /* renamed from: g */
    public static final AtomicLong f330g = new AtomicLong(m251f(System.currentTimeMillis()) ^ m251f(System.nanoTime()));

    public /* synthetic */ ThreadLocalRandom(int i) {
        this();
    }

    /* renamed from: e */
    public static int m252e(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        return (int) (((j2 ^ (j2 >>> 33)) * (-4265267296055464877L)) >>> 32);
    }

    /* renamed from: f */
    public static long m251f(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    private ThreadLocalRandom() {
        this.f333c = true;
    }

    /* renamed from: d */
    public static final void m253d() {
        int addAndGet = f328e.addAndGet(-1640531527);
        if (addAndGet == 0) {
            addAndGet = 1;
        }
        long f = m251f(f330g.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f329f.get();
        threadLocalRandom.f331a = f;
        threadLocalRandom.f332b = addAndGet;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f329f.get();
        if (threadLocalRandom.f332b == 0) {
            m253d();
        }
        return threadLocalRandom;
    }

    @Override // java.util.Random
    public final void setSeed(long j) {
        if (this.f333c) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: g */
    public final long m250g() {
        long j = this.f331a - 7046029254386353131L;
        this.f331a = j;
        return j;
    }

    @Override // java.util.Random
    public final int next(int i) {
        return nextInt() >>> (32 - i);
    }

    /* renamed from: c */
    public final long m254c(long j, long j2) {
        long f = m251f(m250g());
        if (j >= j2) {
            return f;
        }
        long j3 = j2 - j;
        long j4 = j3 - 1;
        if ((j3 & j4) == 0) {
            return (f & j4) + j;
        }
        if (j3 > 0) {
            while (true) {
                long j5 = f >>> 1;
                long j6 = j5 + j4;
                long j7 = j5 % j3;
                if (j6 - j7 >= 0) {
                    return j7 + j;
                }
                f = m251f(m250g());
            }
        } else {
            while (true) {
                if (f >= j && f < j2) {
                    return f;
                }
                f = m251f(m250g());
            }
        }
    }

    /* renamed from: b */
    public final int m255b(int i, int i2) {
        int e = m252e(m250g());
        if (i >= i2) {
            return e;
        }
        int i3 = i2 - i;
        int i4 = i3 - 1;
        if ((i3 & i4) == 0) {
            return (e & i4) + i;
        }
        if (i3 > 0) {
            int i5 = e >>> 1;
            while (true) {
                int i6 = i5 + i4;
                int i7 = i5 % i3;
                if (i6 - i7 >= 0) {
                    return i7 + i;
                }
                i5 = m252e(m250g()) >>> 1;
            }
        } else {
            while (true) {
                if (e >= i && e < i2) {
                    return e;
                }
                e = m252e(m250g());
            }
        }
    }

    /* renamed from: a */
    public final double m256a(double d, double d2) {
        double nextLong = (nextLong() >>> 11) * 1.1102230246251565E-16d;
        if (d >= d2) {
            return nextLong;
        }
        double d3 = ((d2 - d) * nextLong) + d;
        return d3 >= d2 ? Double.longBitsToDouble(Double.doubleToLongBits(d2) - 1) : d3;
    }

    @Override // java.util.Random
    public final int nextInt() {
        return m252e(m250g());
    }

    @Override // java.util.Random
    public final int nextInt(int i) {
        if (i > 0) {
            int e = m252e(m250g());
            int i2 = i - 1;
            if ((i & i2) == 0) {
                return e & i2;
            }
            while (true) {
                int i3 = e >>> 1;
                int i4 = i3 + i2;
                int i5 = i3 % i;
                if (i4 - i5 >= 0) {
                    return i5;
                }
                e = m252e(m250g());
            }
        } else {
            throw new IllegalArgumentException("bound must be positive");
        }
    }

    public final int nextInt(int i, int i2) {
        if (i < i2) {
            return m255b(i, i2);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final long nextLong() {
        return m251f(m250g());
    }

    public final long nextLong(long j) {
        if (j > 0) {
            long f = m251f(m250g());
            long j2 = j - 1;
            if ((j & j2) == 0) {
                return f & j2;
            }
            while (true) {
                long j3 = f >>> 1;
                long j4 = j3 + j2;
                long j5 = j3 % j;
                if (j4 - j5 >= 0) {
                    return j5;
                }
                f = m251f(m250g());
            }
        } else {
            throw new IllegalArgumentException("bound must be positive");
        }
    }

    public final long nextLong(long j, long j2) {
        if (j < j2) {
            return m254c(j, j2);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final double nextDouble() {
        return (m251f(m250g()) >>> 11) * 1.1102230246251565E-16d;
    }

    public final double nextDouble(double d) {
        if (d > 0.0d) {
            double f = (m251f(m250g()) >>> 11) * 1.1102230246251565E-16d * d;
            return f < d ? f : Double.longBitsToDouble(Double.doubleToLongBits(d) - 1);
        }
        throw new IllegalArgumentException("bound must be positive");
    }

    public final double nextDouble(double d, double d2) {
        if (d < d2) {
            return m256a(d, d2);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final boolean nextBoolean() {
        return m252e(m250g()) < 0;
    }

    @Override // java.util.Random
    public final float nextFloat() {
        return (m252e(m250g()) >>> 8) * 5.9604645E-8f;
    }

    @Override // java.util.Random
    public final double nextGaussian() {
        ThreadLocal threadLocal = f327d;
        Double d = (Double) threadLocal.get();
        if (d != null) {
            threadLocal.set(null);
            return d.doubleValue();
        }
        while (true) {
            double nextDouble = (nextDouble() * 2.0d) - 1.0d;
            double nextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d2 = (nextDouble2 * nextDouble2) + (nextDouble * nextDouble);
            if (d2 < 1.0d && d2 != 0.0d) {
                double sqrt = StrictMath.sqrt((StrictMath.log(d2) * (-2.0d)) / d2);
                f327d.set(Double.valueOf(nextDouble2 * sqrt));
                return nextDouble * sqrt;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    @Override // java.util.Random
    public final IntStream ints(long j) {
        if (j >= 0) {
            C0432x xVar = new C0432x(0L, j, Integer.MAX_VALUE, 0);
            return IntStream.Wrapper.convert(new AbstractC0488a(xVar, EnumC0725x6.m67k(xVar), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    @Override // java.util.Random
    public final java.util.stream.IntStream ints() {
        C0432x xVar = new C0432x(0L, Long.MAX_VALUE, Integer.MAX_VALUE, 0);
        return IntStream.Wrapper.convert(new AbstractC0488a(xVar, EnumC0725x6.m67k(xVar), false));
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    @Override // java.util.Random
    public final java.util.stream.IntStream ints(long j, int i, int i2) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (i < i2) {
            C0432x xVar = new C0432x(0L, j, i, i2);
            return IntStream.Wrapper.convert(new AbstractC0488a(xVar, EnumC0725x6.m67k(xVar), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [j$.util.stream.IntStream, j$.util.stream.a] */
    @Override // java.util.Random
    public final java.util.stream.IntStream ints(int i, int i2) {
        if (i < i2) {
            C0432x xVar = new C0432x(0L, Long.MAX_VALUE, i, i2);
            return IntStream.Wrapper.convert(new AbstractC0488a(xVar, EnumC0725x6.m67k(xVar), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [j$.util.stream.k1, j$.util.stream.a] */
    @Override // java.util.Random
    public final LongStream longs(long j) {
        if (j >= 0) {
            C0433y yVar = new C0433y(0L, j, Long.MAX_VALUE, 0L);
            return C0580j1.m191f(new AbstractC0488a(yVar, EnumC0725x6.m67k(yVar), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [j$.util.stream.k1, j$.util.stream.a] */
    @Override // java.util.Random
    public final LongStream longs() {
        C0433y yVar = new C0433y(0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L);
        return C0580j1.m191f(new AbstractC0488a(yVar, EnumC0725x6.m67k(yVar), false));
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [j$.util.stream.k1, j$.util.stream.a] */
    @Override // java.util.Random
    public final LongStream longs(long j, long j2, long j3) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (j2 < j3) {
            C0433y yVar = new C0433y(0L, j, j2, j3);
            return C0580j1.m191f(new AbstractC0488a(yVar, EnumC0725x6.m67k(yVar), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [j$.util.stream.k1, j$.util.stream.a] */
    @Override // java.util.Random
    public final LongStream longs(long j, long j2) {
        if (j < j2) {
            C0433y yVar = new C0433y(0L, Long.MAX_VALUE, j, j2);
            return C0580j1.m191f(new AbstractC0488a(yVar, EnumC0725x6.m67k(yVar), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    /* JADX WARN: Type inference failed for: r13v2, types: [j$.util.stream.b0, j$.util.stream.a] */
    @Override // java.util.Random
    public final DoubleStream doubles(long j) {
        if (j >= 0) {
            C0431w wVar = new C0431w(0L, j, Double.MAX_VALUE, 0.0d);
            return C0489a0.m222f(new AbstractC0488a(wVar, EnumC0725x6.m67k(wVar), false));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [j$.util.stream.b0, j$.util.stream.a] */
    @Override // java.util.Random
    public final DoubleStream doubles() {
        C0431w wVar = new C0431w(0L, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d);
        return C0489a0.m222f(new AbstractC0488a(wVar, EnumC0725x6.m67k(wVar), false));
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [j$.util.stream.b0, j$.util.stream.a] */
    @Override // java.util.Random
    public final DoubleStream doubles(long j, double d, double d2) {
        if (j < 0) {
            throw new IllegalArgumentException("size must be non-negative");
        } else if (d < d2) {
            C0431w wVar = new C0431w(0L, j, d, d2);
            return C0489a0.m222f(new AbstractC0488a(wVar, EnumC0725x6.m67k(wVar), false));
        } else {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [j$.util.stream.b0, j$.util.stream.a] */
    @Override // java.util.Random
    public final DoubleStream doubles(double d, double d2) {
        if (d < d2) {
            C0431w wVar = new C0431w(0L, Long.MAX_VALUE, d, d2);
            return C0489a0.m222f(new AbstractC0488a(wVar, EnumC0725x6.m67k(wVar), false));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.ThreadLocal, j$.util.concurrent.v] */
    static {
        if (((Boolean) AccessController.doPrivileged(new C0482q1(1))).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            long j = seed[0] & 255;
            for (int i = 1; i < 8; i++) {
                j = (j << 8) | (seed[i] & 255);
            }
            f330g.set(j);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("rnd", this.f331a);
        putFields.put("initialized", true);
        objectOutputStream.writeFields();
    }

    private Object readResolve() {
        return current();
    }
}
