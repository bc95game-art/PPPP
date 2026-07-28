package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.C0471n;
import p004j$.util.C0748u;
import p004j$.util.C0758z;
import p004j$.util.stream.IntStream;
/* renamed from: j$.util.stream.z */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0737z implements AbstractC0499b0 {

    /* renamed from: a */
    public final /* synthetic */ DoubleStream f855a;

    public /* synthetic */ C0737z(DoubleStream doubleStream) {
        this.f855a = doubleStream;
    }

    /* renamed from: f */
    public static /* synthetic */ AbstractC0499b0 m48f(DoubleStream doubleStream) {
        if (doubleStream == null) {
            return null;
        }
        return doubleStream instanceof C0489a0 ? ((C0489a0) doubleStream).f487a : new C0737z(doubleStream);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: A */
    public final /* synthetic */ IntStream mo55A() {
        return IntStream.VivifiedWrapper.convert(this.f855a.mapToInt(null));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: C */
    public final /* synthetic */ boolean mo54C() {
        return this.f855a.noneMatch(null);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: a */
    public final /* synthetic */ AbstractC0499b0 mo53a() {
        return m48f(this.f855a.takeWhile(null));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ C0758z average() {
        return AbstractC0279a.m560E(this.f855a.average());
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: b */
    public final /* synthetic */ AbstractC0499b0 mo52b() {
        return m48f(this.f855a.filter(null));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ Stream boxed() {
        return C0705v6.m84f(this.f855a.boxed());
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: c */
    public final /* synthetic */ AbstractC0499b0 mo51c() {
        return m48f(this.f855a.dropWhile(null));
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f855a.close();
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.f855a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ long count() {
        return this.f855a.count();
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ AbstractC0499b0 distinct() {
        return m48f(this.f855a.distinct());
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: e */
    public final /* synthetic */ AbstractC0499b0 mo49e() {
        return m48f(this.f855a.map(null));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        DoubleStream doubleStream = this.f855a;
        if (obj instanceof C0737z) {
            obj = ((C0737z) obj).f855a;
        }
        return doubleStream.equals(obj);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ C0758z findAny() {
        return AbstractC0279a.m560E(this.f855a.findAny());
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ C0758z findFirst() {
        return AbstractC0279a.m560E(this.f855a.findFirst());
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.f855a.forEach(doubleConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.f855a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.f855a.hashCode();
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ boolean isParallel() {
        return this.f855a.isParallel();
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ AbstractC0499b0 limit(long j) {
        return m48f(this.f855a.limit(j));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ Stream mapToObj(DoubleFunction doubleFunction) {
        return C0705v6.m84f(this.f855a.mapToObj(doubleFunction));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ C0758z max() {
        return AbstractC0279a.m560E(this.f855a.max());
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ C0758z min() {
        return AbstractC0279a.m560E(this.f855a.min());
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g onClose(Runnable runnable) {
        return C0528e.m210f(this.f855a.onClose(runnable));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: p */
    public final /* synthetic */ boolean mo47p() {
        return this.f855a.anyMatch(null);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ AbstractC0499b0 peek(DoubleConsumer doubleConsumer) {
        return m48f(this.f855a.peek(doubleConsumer));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        return this.f855a.reduce(d, doubleBinaryOperator);
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ C0758z reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return AbstractC0279a.m560E(this.f855a.reduce(doubleBinaryOperator));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ AbstractC0499b0 skip(long j) {
        return m48f(this.f855a.skip(j));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ AbstractC0499b0 sorted() {
        return m48f(this.f855a.sorted());
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ double sum() {
        return this.f855a.sum();
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final /* synthetic */ double[] toArray() {
        return this.f855a.toArray();
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: u */
    public final /* synthetic */ boolean mo46u() {
        return this.f855a.allMatch(null);
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g unordered() {
        return C0528e.m210f(this.f855a.unordered());
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: v */
    public final /* synthetic */ AbstractC0590k1 mo45v() {
        return C0570i1.m196f(this.f855a.mapToLong(null));
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    public final C0748u summaryStatistics() {
        this.f855a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.DoubleSummaryStatistics");
    }

    @Override // p004j$.util.stream.AbstractC0499b0
    /* renamed from: d */
    public final AbstractC0499b0 mo50d(C0471n nVar) {
        DoubleStream doubleStream = this.f855a;
        C0471n nVar2 = new C0471n(4);
        nVar2.f448b = nVar;
        return m48f(doubleStream.flatMap(nVar2));
    }
}
