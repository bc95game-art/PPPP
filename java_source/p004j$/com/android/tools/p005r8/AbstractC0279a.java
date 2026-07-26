package p004j$.com.android.tools.p005r8;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.RandomAccess;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.time.AbstractC0283b;
import p004j$.time.C0390z;
import p004j$.time.chrono.AbstractC0287a;
import p004j$.time.chrono.AbstractC0289b;
import p004j$.time.chrono.AbstractC0295e;
import p004j$.time.chrono.AbstractC0303i;
import p004j$.time.chrono.AbstractC0305j;
import p004j$.time.chrono.AbstractC0310m;
import p004j$.time.chrono.AbstractC0311n;
import p004j$.time.chrono.C0290b0;
import p004j$.time.chrono.C0302h0;
import p004j$.time.chrono.C0313p;
import p004j$.time.chrono.C0317t;
import p004j$.time.chrono.C0320w;
import p004j$.time.format.C0328b;
import p004j$.time.temporal.AbstractC0376m;
import p004j$.time.temporal.AbstractC0377n;
import p004j$.time.temporal.AbstractC0380q;
import p004j$.time.temporal.AbstractC0381r;
import p004j$.time.temporal.EnumC0364a;
import p004j$.time.temporal.EnumC0365b;
import p004j$.util.AbstractC0485r1;
import p004j$.util.AbstractC0487s0;
import p004j$.util.AbstractC0751v0;
import p004j$.util.AbstractC0752w;
import p004j$.util.AbstractC0757y0;
import p004j$.util.C0400a;
import p004j$.util.C0401a0;
import p004j$.util.C0404b0;
import p004j$.util.C0407c0;
import p004j$.util.C0434d;
import p004j$.util.C0451g0;
import p004j$.util.C0463k0;
import p004j$.util.C0478p0;
import p004j$.util.C0756y;
import p004j$.util.C0758z;
import p004j$.util.Collection;
import p004j$.util.EnumC0437e;
import p004j$.util.Map;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
import p004j$.util.Spliterators;
import p004j$.util.concurrent.C0420l;
import p004j$.util.concurrent.C0428t;
import p004j$.util.concurrent.ConcurrentHashMap;
import p004j$.util.function.C0444b;
import p004j$.util.function.C0446d;
import p004j$.util.stream.Stream;
import sun.misc.Unsafe;
/* renamed from: j$.com.android.tools.r8.a */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0279a {
    /* renamed from: M */
    public static /* synthetic */ void m552M(Map map, BiConsumer biConsumer) {
        if (map instanceof p004j$.util.Map) {
            ((p004j$.util.Map) map).forEach(biConsumer);
        } else if (map instanceof ConcurrentMap) {
            m525j((ConcurrentMap) map, biConsumer);
        } else {
            Map.CC.$default$forEach(map, biConsumer);
        }
    }

    /* renamed from: Q */
    public static /* synthetic */ long m548Q(long j, int i) {
        long j2 = i;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        if (numberOfLeadingZeros >= 64) {
            boolean z = false;
            int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            boolean z2 = i2 >= 0;
            if (j2 != Long.MIN_VALUE) {
                z = true;
            }
            if (z || z2) {
                long j3 = j * j2;
                if (i2 == 0 || j3 / j == j2) {
                    return j3;
                }
            }
        }
        throw new ArithmeticException();
    }

    /* renamed from: R */
    public static /* synthetic */ long m547R(long j, long j2) {
        long j3 = j + j2;
        boolean z = false;
        boolean z2 = (j2 ^ j) < 0;
        if ((j ^ j3) >= 0) {
            z = true;
        }
        if (z2 || z) {
            return j3;
        }
        throw new ArithmeticException();
    }

    /* renamed from: S */
    public static /* synthetic */ Map.Entry m546S(Object obj, Object obj2) {
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(obj), Objects.requireNonNull(obj2));
    }

    /* renamed from: T */
    public static /* synthetic */ boolean m545T(Unsafe unsafe, Object obj, long j, C0420l lVar) {
        while (true) {
            Unsafe unsafe2 = unsafe;
            Object obj2 = obj;
            long j2 = j;
            C0420l lVar2 = lVar;
            if (unsafe2.compareAndSwapObject(obj2, j2, (Object) null, lVar2)) {
                return true;
            }
            if (unsafe2.getObject(obj2, j2) != null) {
                return false;
            }
            unsafe = unsafe2;
            obj = obj2;
            j = j2;
            lVar = lVar2;
        }
    }

    /* renamed from: U */
    public static /* synthetic */ long m544U(long j, long j2) {
        long j3 = j % j2;
        if (j3 == 0) {
            return 0L;
        }
        return (((j ^ j2) >> 63) | 1) > 0 ? j3 : j3 + j2;
    }

    /* renamed from: V */
    public static /* synthetic */ long m543V(long j, long j2) {
        long j3 = j / j2;
        return (j - (j2 * j3) != 0 && (((j ^ j2) >> 63) | 1) < 0) ? j3 - 1 : j3;
    }

    /* renamed from: W */
    public static /* synthetic */ long m542W(long j, long j2) {
        long j3 = j - j2;
        boolean z = false;
        boolean z2 = (j2 ^ j) >= 0;
        if ((j ^ j3) >= 0) {
            z = true;
        }
        if (z2 || z) {
            return j3;
        }
        throw new ArithmeticException();
    }

    /* renamed from: Z */
    public static /* synthetic */ Stream m539Z(Collection collection) {
        return collection instanceof p004j$.util.Collection ? ((p004j$.util.Collection) collection).mo887parallelStream() : Collection.CC.$default$parallelStream(collection);
    }

    /* renamed from: a0 */
    public static /* synthetic */ Object m537a0(java.util.Map map, Object obj, Object obj2) {
        return map instanceof p004j$.util.Map ? ((p004j$.util.Map) map).putIfAbsent(obj, obj2) : Map.CC.$default$putIfAbsent(map, obj, obj2);
    }

    /* renamed from: c0 */
    public static /* synthetic */ Stream m533c0(java.util.Collection collection) {
        return collection instanceof p004j$.util.Collection ? ((p004j$.util.Collection) collection).mo889stream() : Collection.CC.$default$stream(collection);
    }

    /* renamed from: D */
    public static C0756y m561D(Optional optional) {
        if (optional == null) {
            return null;
        }
        if (optional.isPresent()) {
            return new C0756y(optional.get());
        }
        return C0756y.f882b;
    }

    /* renamed from: E */
    public static C0758z m560E(OptionalDouble optionalDouble) {
        if (optionalDouble == null) {
            return null;
        }
        if (optionalDouble.isPresent()) {
            return new C0758z(optionalDouble.getAsDouble());
        }
        return C0758z.f884c;
    }

    /* renamed from: d */
    public static C0428t m532d(Consumer consumer, Consumer consumer2) {
        Objects.requireNonNull(consumer2);
        return new C0428t(3, consumer, consumer2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.function.b] */
    /* renamed from: e */
    public static C0444b m530e(final DoubleConsumer doubleConsumer, final DoubleConsumer doubleConsumer2) {
        Objects.requireNonNull(doubleConsumer2);
        return new DoubleConsumer() { // from class: j$.util.function.b
            public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer3) {
                return AbstractC0279a.m530e(this, doubleConsumer3);
            }

            @Override // java.util.function.DoubleConsumer
            public final void accept(double d) {
                DoubleConsumer.this.accept(d);
                doubleConsumer2.accept(d);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.function.d] */
    /* renamed from: f */
    public static C0446d m529f(final IntConsumer intConsumer, final IntConsumer intConsumer2) {
        Objects.requireNonNull(intConsumer2);
        return new IntConsumer() { // from class: j$.util.function.d
            public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer3) {
                return AbstractC0279a.m529f(this, intConsumer3);
            }

            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                IntConsumer.this.accept(i);
                intConsumer2.accept(i);
            }
        };
    }

    /* renamed from: G */
    public static C0404b0 m558G(OptionalLong optionalLong) {
        if (optionalLong == null) {
            return null;
        }
        if (optionalLong.isPresent()) {
            return new C0404b0(optionalLong.getAsLong());
        }
        return C0404b0.f304c;
    }

    /* renamed from: b */
    public static C0428t m536b(BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(biConsumer2);
        return new C0428t(1, biConsumer, biConsumer2);
    }

    /* renamed from: c */
    public static C0428t m534c(BiFunction biFunction, Function function) {
        Objects.requireNonNull(function);
        return new C0428t(biFunction, function);
    }

    /* renamed from: F */
    public static C0401a0 m559F(OptionalInt optionalInt) {
        if (optionalInt == null) {
            return null;
        }
        if (optionalInt.isPresent()) {
            return new C0401a0(optionalInt.getAsInt());
        }
        return C0401a0.f300c;
    }

    /* renamed from: P */
    public static Object m549P(java.util.Map map, Object obj, Object obj2) {
        if (map instanceof p004j$.util.Map) {
            return ((p004j$.util.Map) map).getOrDefault(obj, obj2);
        }
        if (map instanceof ConcurrentMap) {
            Object obj3 = ((ConcurrentMap) map).get(obj);
            if (obj3 != null) {
                return obj3;
            }
        } else {
            Object obj4 = map.get(obj);
            if (obj4 != null || map.containsKey(obj)) {
                return obj4;
            }
        }
        return obj2;
    }

    /* renamed from: j */
    public static void m525j(ConcurrentMap concurrentMap, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        for (Map.Entry entry : concurrentMap.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException unused) {
            }
        }
    }

    /* renamed from: X */
    public static String m541X(Object obj, Object obj2) {
        String str;
        String obj3;
        String str2 = "null";
        if (obj == null || (str = obj.toString()) == null) {
            str = str2;
        }
        int length = str.length();
        if (!(obj2 == null || (obj3 = obj2.toString()) == null)) {
            str2 = obj3;
        }
        int length2 = str2.length();
        char[] cArr = new char[length + length2 + 1];
        str.getChars(0, length, cArr, 0);
        cArr[length] = '=';
        str2.getChars(0, length2, cArr, length + 1);
        return new String(cArr);
    }

    /* renamed from: N */
    public static void m551N(Iterator it, Consumer consumer) {
        if (it instanceof AbstractC0752w) {
            ((AbstractC0752w) it).forEachRemaining(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    /* renamed from: I */
    public static OptionalDouble m556I(C0758z zVar) {
        if (zVar == null) {
            return null;
        }
        boolean z = zVar.f885a;
        if (!z) {
            return OptionalDouble.empty();
        }
        if (z) {
            return OptionalDouble.of(zVar.f886b);
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: J */
    public static OptionalInt m555J(C0401a0 a0Var) {
        if (a0Var == null) {
            return null;
        }
        boolean z = a0Var.f301a;
        if (!z) {
            return OptionalInt.empty();
        }
        if (z) {
            return OptionalInt.of(a0Var.f302b);
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: K */
    public static OptionalLong m554K(C0404b0 b0Var) {
        if (b0Var == null) {
            return null;
        }
        boolean z = b0Var.f305a;
        if (!z) {
            return OptionalLong.empty();
        }
        if (z) {
            return OptionalLong.of(b0Var.f306b);
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: t */
    public static boolean m515t(AbstractC0311n nVar, AbstractC0380q qVar) {
        return qVar instanceof EnumC0364a ? qVar == EnumC0364a.ERA : qVar != null && qVar.mo339i(nVar);
    }

    /* renamed from: H */
    public static Optional m557H(C0756y yVar) {
        if (yVar == null) {
            return null;
        }
        Object obj = yVar.f883a;
        if (obj == null) {
            return Optional.empty();
        }
        if (obj != null) {
            return Optional.of(obj);
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: O */
    public static AbstractC0310m m550O(AbstractC0377n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        return (AbstractC0310m) Objects.requireNonNullElse((AbstractC0310m) nVar.mo295l(AbstractC0381r.f232b), C0317t.f100c);
    }

    /* renamed from: b0 */
    public static Spliterator m535b0(java.util.Collection collection) {
        if (collection instanceof p004j$.util.Collection) {
            return ((p004j$.util.Collection) collection).mo888spliterator();
        }
        if (collection instanceof LinkedHashSet) {
            return Spliterators.spliterator((LinkedHashSet) collection, 17);
        }
        if (collection instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) collection;
            return new C0478p0(sortedSet, sortedSet);
        } else if (collection instanceof Set) {
            return Spliterators.spliterator((Set) collection, 1);
        } else {
            if (!(collection instanceof List)) {
                return Spliterators.spliterator(collection, 0);
            }
            List list = (List) collection;
            if (list instanceof RandomAccess) {
                return new C0400a(list);
            }
            return Spliterators.spliterator(list, 16);
        }
    }

    /* renamed from: n */
    public static int m521n(AbstractC0305j jVar, AbstractC0380q qVar) {
        if (!(qVar instanceof EnumC0364a)) {
            return AbstractC0381r.m334a(jVar, qVar);
        }
        int i = AbstractC0303i.f73a[((EnumC0364a) qVar).ordinal()];
        if (i == 1) {
            throw new RuntimeException("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
        } else if (i != 2) {
            return jVar.mo466p().mo297i(qVar);
        } else {
            return jVar.mo468g().f256a;
        }
    }

    /* renamed from: o */
    public static int m520o(AbstractC0311n nVar, AbstractC0380q qVar) {
        if (qVar == EnumC0364a.ERA) {
            return nVar.getValue();
        }
        return AbstractC0381r.m334a(nVar, qVar);
    }

    /* renamed from: d0 */
    public static C0434d m531d0(EnumC0437e eVar, Comparator comparator) {
        Objects.requireNonNull(comparator);
        return new C0434d(eVar, comparator);
    }

    /* renamed from: q */
    public static long m518q(AbstractC0311n nVar, AbstractC0380q qVar) {
        if (qVar == EnumC0364a.ERA) {
            return nVar.getValue();
        }
        if (!(qVar instanceof EnumC0364a)) {
            return qVar.mo336l(nVar);
        }
        throw new RuntimeException(AbstractC0283b.m495a("Unsupported field: ", qVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* renamed from: Y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AbstractC0310m m540Y(String str) {
        ConcurrentHashMap concurrentHashMap = AbstractC0287a.f53a;
        Objects.requireNonNull(str, "id");
        while (true) {
            ConcurrentHashMap concurrentHashMap2 = AbstractC0287a.f53a;
            AbstractC0310m mVar = (AbstractC0310m) concurrentHashMap2.get(str);
            if (mVar == null) {
                mVar = (AbstractC0310m) AbstractC0287a.f54b.get(str);
            }
            if (mVar != null) {
                return mVar;
            }
            if (concurrentHashMap2.get("ISO") == null) {
                C0313p pVar = C0313p.f83l;
                pVar.getClass();
                AbstractC0287a.m489i(pVar, "Hijrah-umalqura");
                C0320w wVar = C0320w.f104c;
                wVar.getClass();
                AbstractC0287a.m489i(wVar, "Japanese");
                C0290b0 b0Var = C0290b0.f56c;
                b0Var.getClass();
                AbstractC0287a.m489i(b0Var, "Minguo");
                C0302h0 h0Var = C0302h0.f72c;
                h0Var.getClass();
                AbstractC0287a.m489i(h0Var, "ThaiBuddhist");
                try {
                    for (AbstractC0287a aVar : Arrays.asList(new AbstractC0287a[0])) {
                        if (!aVar.mo449h().equals("ISO")) {
                            AbstractC0287a.m489i(aVar, aVar.mo449h());
                        }
                    }
                    C0317t tVar = C0317t.f100c;
                    tVar.getClass();
                    AbstractC0287a.m489i(tVar, "ISO");
                } catch (Throwable th) {
                    throw new ServiceConfigurationError(th.getMessage(), th);
                }
            } else {
                Iterator it = ServiceLoader.load(AbstractC0310m.class).iterator();
                while (it.hasNext()) {
                    AbstractC0310m mVar2 = (AbstractC0310m) it.next();
                    if (str.equals(mVar2.mo449h()) || str.equals(mVar2.mo447n())) {
                        return mVar2;
                    }
                    while (it.hasNext()) {
                    }
                }
                throw new RuntimeException("Unknown chronology: " + str);
            }
        }
    }

    /* renamed from: x */
    public static Object m511x(AbstractC0311n nVar, C0328b bVar) {
        if (bVar == AbstractC0381r.f233c) {
            return EnumC0365b.ERAS;
        }
        return AbstractC0381r.m332c(nVar, bVar);
    }

    /* renamed from: v */
    public static Object m513v(AbstractC0295e eVar, C0328b bVar) {
        if (bVar == AbstractC0381r.f231a || bVar == AbstractC0381r.f235e || bVar == AbstractC0381r.f234d) {
            return null;
        }
        if (bVar == AbstractC0381r.f237g) {
            return eVar.mo373b();
        }
        if (bVar == AbstractC0381r.f232b) {
            return eVar.mo374a();
        }
        if (bVar == AbstractC0381r.f233c) {
            return EnumC0365b.NANOS;
        }
        return bVar.m428a(eVar);
    }

    /* renamed from: s */
    public static boolean m516s(AbstractC0289b bVar, AbstractC0380q qVar) {
        if (qVar instanceof EnumC0364a) {
            return ((EnumC0364a) qVar).isDateBased();
        }
        return qVar != null && qVar.mo339i(bVar);
    }

    /* renamed from: p */
    public static long m519p(Spliterator spliterator) {
        if ((spliterator.characteristics() & 64) == 0) {
            return -1L;
        }
        return spliterator.estimateSize();
    }

    /* renamed from: r */
    public static boolean m517r(Spliterator spliterator, int i) {
        return (spliterator.characteristics() & i) == i;
    }

    /* renamed from: y */
    public static long m510y(AbstractC0295e eVar, C0390z zVar) {
        Objects.requireNonNull(zVar, "offset");
        return ((eVar.mo372f().mo386x() * 86400) + eVar.mo373b().m357O()) - zVar.f256a;
    }

    /* renamed from: w */
    public static Object m512w(AbstractC0305j jVar, C0328b bVar) {
        if (bVar == AbstractC0381r.f235e || bVar == AbstractC0381r.f231a) {
            return jVar.mo464v();
        }
        if (bVar == AbstractC0381r.f234d) {
            return jVar.mo468g();
        }
        if (bVar == AbstractC0381r.f237g) {
            return jVar.mo470b();
        }
        if (bVar == AbstractC0381r.f232b) {
            return jVar.mo471a();
        }
        if (bVar == AbstractC0381r.f233c) {
            return EnumC0365b.NANOS;
        }
        return bVar.m428a(jVar);
    }

    /* renamed from: h */
    public static int m527h(AbstractC0295e eVar, AbstractC0295e eVar2) {
        int A = eVar.mo372f().mo407A(eVar2.mo372f());
        return (A == 0 && (A = eVar.mo373b().compareTo(eVar2.mo373b())) == 0) ? ((AbstractC0287a) eVar.mo374a()).mo449h().compareTo(eVar2.mo374a().mo449h()) : A;
    }

    /* renamed from: u */
    public static Object m514u(AbstractC0289b bVar, C0328b bVar2) {
        if (bVar2 == AbstractC0381r.f231a || bVar2 == AbstractC0381r.f235e || bVar2 == AbstractC0381r.f234d || bVar2 == AbstractC0381r.f237g) {
            return null;
        }
        if (bVar2 == AbstractC0381r.f232b) {
            return bVar.mo387a();
        }
        if (bVar2 == AbstractC0381r.f233c) {
            return EnumC0365b.DAYS;
        }
        return bVar2.m428a(bVar);
    }

    /* renamed from: a */
    public static AbstractC0376m m538a(AbstractC0289b bVar, AbstractC0376m mVar) {
        return mVar.mo313c(bVar.mo386x(), EnumC0364a.EPOCH_DAY);
    }

    /* renamed from: z */
    public static long m509z(AbstractC0305j jVar) {
        return ((jVar.mo469f().mo386x() * 86400) + jVar.mo470b().m357O()) - jVar.mo468g().f256a;
    }

    /* renamed from: i */
    public static int m526i(AbstractC0305j jVar, AbstractC0305j jVar2) {
        int compare = Long.compare(jVar.mo474B(), jVar2.mo474B());
        return (compare == 0 && (compare = jVar.mo470b().f190d - jVar2.mo470b().f190d) == 0 && (compare = jVar.mo466p().mo370z(jVar2.mo466p())) == 0 && (compare = jVar.mo464v().mo298h().compareTo(jVar2.mo464v().mo298h())) == 0) ? ((AbstractC0287a) jVar.mo471a()).mo449h().compareTo(jVar2.mo471a().mo449h()) : compare;
    }

    /* renamed from: L */
    public static void m553L(java.util.Collection collection, Consumer consumer) {
        if (collection instanceof p004j$.util.Collection) {
            ((p004j$.util.Collection) collection).forEach(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        for (Object obj : collection) {
            consumer.accept(obj);
        }
    }

    /* renamed from: B */
    public static boolean m563B(AbstractC0751v0 v0Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            return v0Var.tryAdvance((IntConsumer) consumer);
        }
        if (!AbstractC0485r1.f472a) {
            Objects.requireNonNull(consumer);
            return v0Var.tryAdvance((IntConsumer) new C0451g0(consumer, 0));
        }
        AbstractC0485r1.m227a(v0Var.getClass(), "{0} calling Spliterator.OfInt.tryAdvance((IntConsumer) action::accept)");
        throw null;
    }

    /* renamed from: l */
    public static void m523l(AbstractC0751v0 v0Var, Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            v0Var.forEachRemaining((IntConsumer) consumer);
        } else if (!AbstractC0485r1.f472a) {
            Objects.requireNonNull(consumer);
            v0Var.forEachRemaining((IntConsumer) new C0451g0(consumer, 0));
        } else {
            AbstractC0485r1.m227a(v0Var.getClass(), "{0} calling Spliterator.OfInt.forEachRemaining((IntConsumer) action::accept)");
            throw null;
        }
    }

    /* renamed from: g */
    public static int m528g(AbstractC0289b bVar, AbstractC0289b bVar2) {
        int compare = Long.compare(bVar.mo386x(), bVar2.mo386x());
        if (compare != 0) {
            return compare;
        }
        return ((AbstractC0287a) bVar.mo387a()).mo449h().compareTo(bVar2.mo387a().mo449h());
    }

    /* renamed from: C */
    public static boolean m562C(AbstractC0757y0 y0Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            return y0Var.tryAdvance((LongConsumer) consumer);
        }
        if (!AbstractC0485r1.f472a) {
            Objects.requireNonNull(consumer);
            return y0Var.tryAdvance((LongConsumer) new C0463k0(consumer, 0));
        }
        AbstractC0485r1.m227a(y0Var.getClass(), "{0} calling Spliterator.OfLong.tryAdvance((LongConsumer) action::accept)");
        throw null;
    }

    /* renamed from: m */
    public static void m522m(AbstractC0757y0 y0Var, Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            y0Var.forEachRemaining((LongConsumer) consumer);
        } else if (!AbstractC0485r1.f472a) {
            Objects.requireNonNull(consumer);
            y0Var.forEachRemaining((LongConsumer) new C0463k0(consumer, 0));
        } else {
            AbstractC0485r1.m227a(y0Var.getClass(), "{0} calling Spliterator.OfLong.forEachRemaining((LongConsumer) action::accept)");
            throw null;
        }
    }

    /* renamed from: A */
    public static boolean m564A(AbstractC0487s0 s0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            return s0Var.tryAdvance((DoubleConsumer) consumer);
        }
        if (!AbstractC0485r1.f472a) {
            Objects.requireNonNull(consumer);
            return s0Var.tryAdvance((DoubleConsumer) new C0407c0(consumer, 0));
        }
        AbstractC0485r1.m227a(s0Var.getClass(), "{0} calling Spliterator.OfDouble.tryAdvance((DoubleConsumer) action::accept)");
        throw null;
    }

    /* renamed from: k */
    public static void m524k(AbstractC0487s0 s0Var, Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            s0Var.forEachRemaining((DoubleConsumer) consumer);
        } else if (!AbstractC0485r1.f472a) {
            Objects.requireNonNull(consumer);
            s0Var.forEachRemaining((DoubleConsumer) new C0407c0(consumer, 0));
        } else {
            AbstractC0485r1.m227a(s0Var.getClass(), "{0} calling Spliterator.OfDouble.forEachRemaining((DoubleConsumer) action::accept)");
            throw null;
        }
    }

    /* renamed from: trySplit */
    public Spliterator mo899trySplit() {
        return null;
    }

    public boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        return false;
    }

    public void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
    }

    public long estimateSize() {
        return 0L;
    }

    public int characteristics() {
        return 16448;
    }
}
