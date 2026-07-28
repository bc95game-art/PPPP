package p004j$.util.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import p004j$.util.C0436d1;
import p004j$.util.C0440f;
import p004j$.util.C0471n;
import p004j$.util.C0756y;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
import p004j$.util.concurrent.C0428t;
import p004j$.util.function.C0443a;
/* renamed from: j$.util.stream.c5 */
/* loaded from: classes2.dex */
public abstract class AbstractC0514c5 extends AbstractC0488a implements Stream {
    @Override // p004j$.util.stream.Stream
    public final Stream sorted() {
        return new C0545f6(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.stream.Stream, j$.util.stream.a] */
    @Override // p004j$.util.stream.Stream
    public final Stream distinct() {
        return new AbstractC0488a(this, EnumC0725x6.f830m | EnumC0725x6.f837t);
    }

    @Override // p004j$.util.stream.Stream
    public final C0756y min(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new C0443a(comparator, 1));
    }

    @Override // p004j$.util.stream.Stream
    public final C0756y findAny() {
        return (C0756y) m226H0(C0559h0.f576d);
    }

    @Override // p004j$.util.stream.Stream
    public final C0756y findFirst() {
        return (C0756y) m226H0(C0559h0.f575c);
    }

    @Override // p004j$.util.stream.Stream
    public final Stream sorted(Comparator comparator) {
        return new C0545f6(this, comparator);
    }

    @Override // p004j$.util.stream.Stream
    public final Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(binaryOperator);
        return m226H0(new C0741z3(EnumC0735y6.REFERENCE, binaryOperator, biFunction, obj, 2));
    }

    @Override // p004j$.util.stream.Stream
    public final Object reduce(Object obj, BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        Objects.requireNonNull(binaryOperator);
        return m226H0(new C0741z3(EnumC0735y6.REFERENCE, binaryOperator, binaryOperator, obj, 2));
    }

    @Override // p004j$.util.stream.Stream
    public void forEach(Consumer consumer) {
        Objects.requireNonNull(consumer);
        m226H0(new C0629o0(consumer, false));
    }

    @Override // p004j$.util.stream.Stream
    public void forEachOrdered(Consumer consumer) {
        Objects.requireNonNull(consumer);
        m226H0(new C0629o0(consumer, true));
    }

    @Override // p004j$.util.stream.Stream
    public final C0756y max(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return reduce(new C0443a(comparator, 0));
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: L0 */
    public final EnumC0735y6 mo41L0() {
        return EnumC0735y6.REFERENCE;
    }

    @Override // p004j$.util.stream.Stream
    public final C0756y reduce(BinaryOperator binaryOperator) {
        Objects.requireNonNull(binaryOperator);
        return (C0756y) m226H0(new C0722x3(EnumC0735y6.REFERENCE, binaryOperator, 2));
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: J0 */
    public final AbstractC0531e2 mo43J0(AbstractC0488a aVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return AbstractC0692u3.m117b0(aVar, spliterator, z, intFunction);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: S0 */
    public final Spliterator mo40S0(AbstractC0488a aVar, Supplier supplier, boolean z) {
        return new AbstractC0744z6(aVar, supplier, z);
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: K0 */
    public final boolean mo42K0(Spliterator spliterator, AbstractC0594k5 k5Var) {
        boolean e;
        do {
            e = k5Var.mo27e();
            if (e) {
                break;
            }
        } while (spliterator.tryAdvance(k5Var));
        return e;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: A0 */
    public final AbstractC0710w1 mo44A0(long j, IntFunction intFunction) {
        return AbstractC0692u3.m119Z(j, intFunction);
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final Iterator iterator() {
        Spliterator spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new C0436d1(spliterator);
    }

    @Override // p004j$.util.stream.Stream
    public final Stream filter(Predicate predicate) {
        Objects.requireNonNull(predicate);
        return new C0638p(this, EnumC0725x6.f837t, predicate, 4);
    }

    @Override // p004j$.util.stream.Stream
    public final Stream map(Function function) {
        Objects.requireNonNull(function);
        return new C0638p(this, EnumC0725x6.f833p | EnumC0725x6.f831n, function, 5);
    }

    @Override // p004j$.util.stream.Stream
    public final IntStream mapToInt(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return new C0679t0(this, EnumC0725x6.f833p | EnumC0725x6.f831n, toIntFunction, 2);
    }

    @Override // p004j$.util.stream.Stream
    public final Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(biConsumer);
        Objects.requireNonNull(biConsumer2);
        return m226H0(new C0741z3(EnumC0735y6.REFERENCE, biConsumer2, biConsumer, supplier, 3));
    }

    @Override // p004j$.util.stream.Stream
    public final AbstractC0590k1 mapToLong(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return new C0520d1(this, EnumC0725x6.f833p | EnumC0725x6.f831n, toLongFunction, 3);
    }

    @Override // p004j$.util.stream.Stream
    public final AbstractC0499b0 mapToDouble(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return new C0688u(this, EnumC0725x6.f833p | EnumC0725x6.f831n, toDoubleFunction, 2);
    }

    @Override // p004j$.util.stream.Stream
    public final long count() {
        return ((Long) m226H0(new C0503b4(2))).longValue();
    }

    @Override // p004j$.util.stream.Stream
    /* renamed from: d */
    public final Stream mo85d(C0471n nVar) {
        Objects.requireNonNull(nVar);
        return new C0638p(this, EnumC0725x6.f833p | EnumC0725x6.f831n | EnumC0725x6.f837t, nVar, 6);
    }

    @Override // p004j$.util.stream.Stream
    /* renamed from: o */
    public final IntStream mo81o(C0471n nVar) {
        Objects.requireNonNull(nVar);
        return new C0679t0(this, EnumC0725x6.f833p | EnumC0725x6.f831n | EnumC0725x6.f837t, nVar, 3);
    }

    @Override // p004j$.util.stream.Stream
    /* renamed from: z */
    public final AbstractC0499b0 mo80z(C0471n nVar) {
        Objects.requireNonNull(nVar);
        return new C0688u(this, EnumC0725x6.f833p | EnumC0725x6.f831n | EnumC0725x6.f837t, nVar, 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0137, code lost:
        if (r0.contains(p004j$.util.stream.EnumC0558h.UNORDERED) != false) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x020b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x020c  */
    @Override // p004j$.util.stream.Stream
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo83h(C0568i iVar) {
        C0568i iVar2;
        Object obj;
        Set<Collector.Characteristics> characteristics;
        Collector.Characteristics next;
        if (this.f476h.f486r) {
            Set<Collector.Characteristics> characteristics2 = iVar.f591a.characteristics();
            if (characteristics2 != null && !characteristics2.isEmpty()) {
                HashSet hashSet = new HashSet();
                Collector.Characteristics next2 = characteristics2.iterator().next();
                if (next2 instanceof EnumC0558h) {
                    Iterator<Collector.Characteristics> it = characteristics2.iterator();
                    while (it.hasNext()) {
                        try {
                            EnumC0558h hVar = (EnumC0558h) it.next();
                            hashSet.add(hVar == null ? null : hVar == EnumC0558h.CONCURRENT ? Collector.Characteristics.CONCURRENT : hVar == EnumC0558h.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH);
                        } catch (ClassCastException e) {
                            C0440f.m235a(e, "java.util.stream.Collector.Characteristics");
                            throw null;
                        }
                    }
                } else if (next2 instanceof Collector.Characteristics) {
                    Iterator<Collector.Characteristics> it2 = characteristics2.iterator();
                    while (it2.hasNext()) {
                        try {
                            Collector.Characteristics next3 = it2.next();
                            hashSet.add(next3 == null ? null : next3 == Collector.Characteristics.CONCURRENT ? EnumC0558h.CONCURRENT : next3 == Collector.Characteristics.UNORDERED ? EnumC0558h.UNORDERED : EnumC0558h.IDENTITY_FINISH);
                        } catch (ClassCastException e2) {
                            C0440f.m235a(e2, "java.util.stream.Collector.Characteristics");
                            throw null;
                        }
                    }
                } else {
                    C0440f.m235a(next2.getClass(), "java.util.stream.Collector.Characteristics");
                    throw null;
                }
                characteristics2 = hashSet;
            }
            if (characteristics2.contains(EnumC0558h.CONCURRENT)) {
                if (EnumC0725x6.ORDERED.m66l(this.f481m)) {
                    Set<Collector.Characteristics> characteristics3 = iVar.f591a.characteristics();
                    if (characteristics3 != null && !characteristics3.isEmpty()) {
                        HashSet hashSet2 = new HashSet();
                        Collector.Characteristics next4 = characteristics3.iterator().next();
                        if (next4 instanceof EnumC0558h) {
                            Iterator<Collector.Characteristics> it3 = characteristics3.iterator();
                            while (it3.hasNext()) {
                                try {
                                    EnumC0558h hVar2 = (EnumC0558h) it3.next();
                                    hashSet2.add(hVar2 == null ? null : hVar2 == EnumC0558h.CONCURRENT ? Collector.Characteristics.CONCURRENT : hVar2 == EnumC0558h.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH);
                                } catch (ClassCastException e3) {
                                    C0440f.m235a(e3, "java.util.stream.Collector.Characteristics");
                                    throw null;
                                }
                            }
                        } else if (next4 instanceof Collector.Characteristics) {
                            Iterator<Collector.Characteristics> it4 = characteristics3.iterator();
                            while (it4.hasNext()) {
                                try {
                                    Collector.Characteristics next5 = it4.next();
                                    hashSet2.add(next5 == null ? null : next5 == Collector.Characteristics.CONCURRENT ? EnumC0558h.CONCURRENT : next5 == Collector.Characteristics.UNORDERED ? EnumC0558h.UNORDERED : EnumC0558h.IDENTITY_FINISH);
                                } catch (ClassCastException e4) {
                                    C0440f.m235a(e4, "java.util.stream.Collector.Characteristics");
                                    throw null;
                                }
                            }
                        } else {
                            C0440f.m235a(next4.getClass(), "java.util.stream.Collector.Characteristics");
                            throw null;
                        }
                        characteristics3 = hashSet2;
                    }
                }
                obj = iVar.f591a.supplier().get();
                forEach(new C0428t(7, iVar.f591a.accumulator(), obj));
                iVar2 = iVar;
                characteristics = iVar2.f591a.characteristics();
                if (characteristics != null && !characteristics.isEmpty()) {
                    HashSet hashSet3 = new HashSet();
                    next = characteristics.iterator().next();
                    if (!(next instanceof EnumC0558h)) {
                        Iterator<Collector.Characteristics> it5 = characteristics.iterator();
                        while (it5.hasNext()) {
                            try {
                                EnumC0558h hVar3 = (EnumC0558h) it5.next();
                                hashSet3.add(hVar3 == null ? null : hVar3 == EnumC0558h.CONCURRENT ? Collector.Characteristics.CONCURRENT : hVar3 == EnumC0558h.UNORDERED ? Collector.Characteristics.UNORDERED : Collector.Characteristics.IDENTITY_FINISH);
                            } catch (ClassCastException e5) {
                                C0440f.m235a(e5, "java.util.stream.Collector.Characteristics");
                                throw null;
                            }
                        }
                    } else if (next instanceof Collector.Characteristics) {
                        Iterator<Collector.Characteristics> it6 = characteristics.iterator();
                        while (it6.hasNext()) {
                            try {
                                Collector.Characteristics next6 = it6.next();
                                hashSet3.add(next6 == null ? null : next6 == Collector.Characteristics.CONCURRENT ? EnumC0558h.CONCURRENT : next6 == Collector.Characteristics.UNORDERED ? EnumC0558h.UNORDERED : EnumC0558h.IDENTITY_FINISH);
                            } catch (ClassCastException e6) {
                                C0440f.m235a(e6, "java.util.stream.Collector.Characteristics");
                                throw null;
                            }
                        }
                    } else {
                        C0440f.m235a(next.getClass(), "java.util.stream.Collector.Characteristics");
                        throw null;
                    }
                    characteristics = hashSet3;
                }
                return !characteristics.contains(EnumC0558h.IDENTITY_FINISH) ? obj : iVar2.f591a.finisher().apply(obj);
            }
        }
        iVar2 = iVar;
        obj = m226H0(new C0553g4(EnumC0735y6.REFERENCE, iVar.f591a.combiner(), iVar.f591a.accumulator(), ((C0568i) Objects.requireNonNull(iVar)).f591a.supplier(), iVar2));
        characteristics = iVar2.f591a.characteristics();
        if (characteristics != null) {
            HashSet hashSet32 = new HashSet();
            next = characteristics.iterator().next();
            if (!(next instanceof EnumC0558h)) {
            }
            characteristics = hashSet32;
        }
        if (!characteristics.contains(EnumC0558h.IDENTITY_FINISH)) {
        }
    }

    @Override // p004j$.util.stream.Stream
    /* renamed from: m */
    public final AbstractC0590k1 mo82m(C0471n nVar) {
        Objects.requireNonNull(nVar);
        return new C0520d1(this, EnumC0725x6.f833p | EnumC0725x6.f831n | EnumC0725x6.f837t, nVar, 2);
    }

    @Override // p004j$.util.stream.Stream
    public final Stream peek(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return new C0638p(this, consumer);
    }

    @Override // p004j$.util.stream.Stream
    public final Stream limit(long j) {
        if (j >= 0) {
            return AbstractC0692u3.m145C0(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // p004j$.util.stream.Stream
    public final Stream skip(long j) {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i >= 0) {
            return i == 0 ? this : AbstractC0692u3.m145C0(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    @Override // p004j$.util.stream.Stream
    public final Stream takeWhile(Predicate predicate) {
        int i = AbstractC0727x8.f846a;
        Objects.requireNonNull(predicate);
        return new C0557g8(this, AbstractC0727x8.f846a, predicate, 0);
    }

    @Override // p004j$.util.stream.Stream
    public final Stream dropWhile(Predicate predicate) {
        int i = AbstractC0727x8.f846a;
        Objects.requireNonNull(predicate);
        return new C0557g8(this, AbstractC0727x8.f847b, predicate, 1);
    }

    @Override // p004j$.util.stream.Stream
    public final Object[] toArray(IntFunction intFunction) {
        return AbstractC0692u3.m103n0(m225I0(intFunction), intFunction).mo59m(intFunction);
    }

    @Override // p004j$.util.stream.Stream
    public final Object[] toArray() {
        return toArray(new C0541f2(8));
    }

    @Override // p004j$.util.stream.Stream
    public final boolean anyMatch(Predicate predicate) {
        return ((Boolean) m226H0(AbstractC0692u3.m146B0(EnumC0660r1.ANY, predicate))).booleanValue();
    }

    @Override // p004j$.util.stream.Stream
    public final boolean allMatch(Predicate predicate) {
        return ((Boolean) m226H0(AbstractC0692u3.m146B0(EnumC0660r1.ALL, predicate))).booleanValue();
    }

    @Override // p004j$.util.stream.Stream
    public final boolean noneMatch(Predicate predicate) {
        return ((Boolean) m226H0(AbstractC0692u3.m146B0(EnumC0660r1.NONE, predicate))).booleanValue();
    }

    @Override // p004j$.util.stream.Stream
    public final List toList() {
        return Collections.unmodifiableList(new ArrayList(Arrays.asList(toArray())));
    }
}
