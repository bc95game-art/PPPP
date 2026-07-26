package p004j$.util.stream;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
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
import java.util.stream.Stream;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0408c1;
import p004j$.util.C0471n;
import p004j$.util.C0756y;
import p004j$.util.Spliterator;
import p004j$.util.stream.IntStream;
import p004j$.util.stream.Stream;
/* renamed from: j$.util.stream.v6 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0705v6 implements Stream {

    /* renamed from: a */
    public final /* synthetic */ Stream f799a;

    public /* synthetic */ C0705v6(Stream stream) {
        this.f799a = stream;
    }

    /* renamed from: f */
    public static /* synthetic */ Stream m84f(Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof Stream.Wrapper ? Stream.this : new C0705v6(stream);
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ boolean allMatch(Predicate predicate) {
        return this.f799a.allMatch(predicate);
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ boolean anyMatch(Predicate predicate) {
        return this.f799a.anyMatch(predicate);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f799a.close();
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.f799a.collect(supplier, biConsumer, biConsumer2);
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ long count() {
        return this.f799a.count();
    }

    @Override // p004j$.util.stream.Stream
    /* renamed from: d */
    public final /* synthetic */ Stream mo85d(C0471n nVar) {
        return m84f(this.f799a.flatMap(AbstractC0692u3.m99r0(nVar)));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Stream distinct() {
        return m84f(this.f799a.distinct());
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Stream dropWhile(Predicate predicate) {
        return m84f(this.f799a.dropWhile(predicate));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.Stream stream = this.f799a;
        if (obj instanceof C0705v6) {
            obj = ((C0705v6) obj).f799a;
        }
        return stream.equals(obj);
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Stream filter(Predicate predicate) {
        return m84f(this.f799a.filter(predicate));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ C0756y findAny() {
        return AbstractC0279a.m561D(this.f799a.findAny());
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ C0756y findFirst() {
        return AbstractC0279a.m561D(this.f799a.findFirst());
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ void forEach(Consumer consumer) {
        this.f799a.forEach(consumer);
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ void forEachOrdered(Consumer consumer) {
        this.f799a.forEachOrdered(consumer);
    }

    @Override // p004j$.util.stream.Stream
    /* renamed from: h */
    public final /* synthetic */ Object mo83h(C0568i iVar) {
        return this.f799a.collect(iVar == null ? null : iVar.f591a);
    }

    public final /* synthetic */ int hashCode() {
        return this.f799a.hashCode();
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ boolean isParallel() {
        return this.f799a.isParallel();
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ Iterator iterator() {
        return this.f799a.iterator();
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Stream limit(long j) {
        return m84f(this.f799a.limit(j));
    }

    @Override // p004j$.util.stream.Stream
    /* renamed from: m */
    public final /* synthetic */ AbstractC0590k1 mo82m(C0471n nVar) {
        return C0570i1.m196f(this.f799a.flatMapToLong(AbstractC0692u3.m99r0(nVar)));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Stream map(Function function) {
        return m84f(this.f799a.map(function));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ AbstractC0499b0 mapToDouble(ToDoubleFunction toDoubleFunction) {
        return C0737z.m48f(this.f799a.mapToDouble(toDoubleFunction));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ IntStream mapToInt(ToIntFunction toIntFunction) {
        return IntStream.VivifiedWrapper.convert(this.f799a.mapToInt(toIntFunction));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ AbstractC0590k1 mapToLong(ToLongFunction toLongFunction) {
        return C0570i1.m196f(this.f799a.mapToLong(toLongFunction));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ C0756y max(Comparator comparator) {
        return AbstractC0279a.m561D(this.f799a.max(comparator));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ C0756y min(Comparator comparator) {
        return AbstractC0279a.m561D(this.f799a.min(comparator));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ boolean noneMatch(Predicate predicate) {
        return this.f799a.noneMatch(predicate);
    }

    @Override // p004j$.util.stream.Stream
    /* renamed from: o */
    public final /* synthetic */ IntStream mo81o(C0471n nVar) {
        return IntStream.VivifiedWrapper.convert(this.f799a.flatMapToInt(AbstractC0692u3.m99r0(nVar)));
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g onClose(Runnable runnable) {
        return C0528e.m210f(this.f799a.onClose(runnable));
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g parallel() {
        return C0528e.m210f(this.f799a.parallel());
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Stream peek(Consumer consumer) {
        return m84f(this.f799a.peek(consumer));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ C0756y reduce(BinaryOperator binaryOperator) {
        return AbstractC0279a.m561D(this.f799a.reduce(binaryOperator));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return this.f799a.reduce(obj, biFunction, binaryOperator);
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
        return this.f799a.reduce(obj, binaryOperator);
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g sequential() {
        return C0528e.m210f(this.f799a.sequential());
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Stream skip(long j) {
        return m84f(this.f799a.skip(j));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Stream sorted() {
        return m84f(this.f799a.sorted());
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Stream sorted(Comparator comparator) {
        return m84f(this.f799a.sorted(comparator));
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ Spliterator spliterator() {
        return C0408c1.m273a(this.f799a.spliterator());
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Stream takeWhile(Predicate predicate) {
        return m84f(this.f799a.takeWhile(predicate));
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Object[] toArray() {
        return this.f799a.toArray();
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return this.f799a.toArray(intFunction);
    }

    @Override // p004j$.util.stream.Stream
    public final /* synthetic */ List toList() {
        return this.f799a.toList();
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g unordered() {
        return C0528e.m210f(this.f799a.unordered());
    }

    @Override // p004j$.util.stream.Stream
    /* renamed from: z */
    public final /* synthetic */ AbstractC0499b0 mo80z(C0471n nVar) {
        return C0737z.m48f(this.f799a.flatMapToDouble(AbstractC0692u3.m99r0(nVar)));
    }
}
