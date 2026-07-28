package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.LongStream;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0404b0;
import p004j$.util.C0471n;
import p004j$.util.C0754x;
import p004j$.util.C0758z;
import p004j$.util.stream.IntStream;
/* renamed from: j$.util.stream.i1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0570i1 implements AbstractC0590k1 {

    /* renamed from: a */
    public final /* synthetic */ LongStream f594a;

    public /* synthetic */ C0570i1(LongStream longStream) {
        this.f594a = longStream;
    }

    /* renamed from: f */
    public static /* synthetic */ AbstractC0590k1 m196f(LongStream longStream) {
        if (longStream == null) {
            return null;
        }
        return longStream instanceof C0580j1 ? ((C0580j1) longStream).f611a : new C0570i1(longStream);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: B */
    public final /* synthetic */ IntStream mo186B() {
        return IntStream.VivifiedWrapper.convert(this.f594a.mapToInt(null));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: a */
    public final /* synthetic */ AbstractC0590k1 mo185a() {
        return m196f(this.f594a.takeWhile(null));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ AbstractC0499b0 asDoubleStream() {
        return C0737z.m48f(this.f594a.asDoubleStream());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ C0758z average() {
        return AbstractC0279a.m560E(this.f594a.average());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: b */
    public final /* synthetic */ AbstractC0590k1 mo184b() {
        return m196f(this.f594a.filter(null));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ Stream boxed() {
        return C0705v6.m84f(this.f594a.boxed());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: c */
    public final /* synthetic */ AbstractC0590k1 mo183c() {
        return m196f(this.f594a.dropWhile(null));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f594a.close();
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.f594a.collect(supplier, objLongConsumer, biConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ long count() {
        return this.f594a.count();
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ AbstractC0590k1 distinct() {
        return m196f(this.f594a.distinct());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: e */
    public final /* synthetic */ AbstractC0590k1 mo181e() {
        return m196f(this.f594a.map(null));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        LongStream longStream = this.f594a;
        if (obj instanceof C0570i1) {
            obj = ((C0570i1) obj).f594a;
        }
        return longStream.equals(obj);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ C0404b0 findAny() {
        return AbstractC0279a.m558G(this.f594a.findAny());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ C0404b0 findFirst() {
        return AbstractC0279a.m558G(this.f594a.findFirst());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.f594a.forEach(longConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.f594a.forEachOrdered(longConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f594a.hashCode();
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ boolean isParallel() {
        return this.f594a.isParallel();
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: k */
    public final /* synthetic */ AbstractC0499b0 mo180k() {
        return C0737z.m48f(this.f594a.mapToDouble(null));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ AbstractC0590k1 limit(long j) {
        return m196f(this.f594a.limit(j));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ Stream mapToObj(LongFunction longFunction) {
        return C0705v6.m84f(this.f594a.mapToObj(longFunction));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ C0404b0 max() {
        return AbstractC0279a.m558G(this.f594a.max());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ C0404b0 min() {
        return AbstractC0279a.m558G(this.f594a.min());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: n */
    public final /* synthetic */ boolean mo179n() {
        return this.f594a.noneMatch(null);
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g onClose(Runnable runnable) {
        return C0528e.m210f(this.f594a.onClose(runnable));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ AbstractC0590k1 peek(LongConsumer longConsumer) {
        return m196f(this.f594a.peek(longConsumer));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: r */
    public final /* synthetic */ boolean mo178r() {
        return this.f594a.anyMatch(null);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ long reduce(long j, LongBinaryOperator longBinaryOperator) {
        return this.f594a.reduce(j, longBinaryOperator);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ C0404b0 reduce(LongBinaryOperator longBinaryOperator) {
        return AbstractC0279a.m558G(this.f594a.reduce(longBinaryOperator));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ AbstractC0590k1 skip(long j) {
        return m196f(this.f594a.skip(j));
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ AbstractC0590k1 sorted() {
        return m196f(this.f594a.sorted());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ long sum() {
        return this.f594a.sum();
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final /* synthetic */ long[] toArray() {
        return this.f594a.toArray();
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g unordered() {
        return C0528e.m210f(this.f594a.unordered());
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: x */
    public final /* synthetic */ boolean mo177x() {
        return this.f594a.allMatch(null);
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    public final C0754x summaryStatistics() {
        this.f594a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.LongSummaryStatistics");
    }

    @Override // p004j$.util.stream.AbstractC0590k1
    /* renamed from: d */
    public final AbstractC0590k1 mo182d(C0471n nVar) {
        LongStream longStream = this.f594a;
        C0471n nVar2 = new C0471n(6);
        nVar2.f448b = nVar;
        return m196f(longStream.flatMap(nVar2));
    }
}
