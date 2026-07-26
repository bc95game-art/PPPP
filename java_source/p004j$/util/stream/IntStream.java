package p004j$.util.stream;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0460j0;
import p004j$.util.AbstractC0751v0;
import p004j$.util.C0401a0;
import p004j$.util.C0750v;
import p004j$.util.C0758z;
import p004j$.util.stream.Stream;
/* renamed from: j$.util.stream.IntStream */
/* loaded from: classes2.dex */
public interface IntStream extends AbstractC0548g {
    /* renamed from: a */
    IntStream mo38a();

    AbstractC0499b0 asDoubleStream();

    AbstractC0590k1 asLongStream();

    C0758z average();

    /* renamed from: b */
    IntStream mo37b();

    Stream boxed();

    /* renamed from: c */
    IntStream mo36c();

    Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer);

    long count();

    IntStream distinct();

    /* renamed from: e */
    IntStream mo35e();

    C0401a0 findAny();

    C0401a0 findFirst();

    void forEach(IntConsumer intConsumer);

    void forEachOrdered(IntConsumer intConsumer);

    /* renamed from: g */
    AbstractC0499b0 mo34g();

    @Override // p004j$.util.stream.AbstractC0548g
    AbstractC0460j0 iterator();

    /* renamed from: l */
    AbstractC0590k1 mo33l();

    IntStream limit(long j);

    Stream mapToObj(IntFunction intFunction);

    C0401a0 max();

    C0401a0 min();

    @Override // p004j$.util.stream.AbstractC0548g
    IntStream parallel();

    IntStream peek(IntConsumer intConsumer);

    /* renamed from: q */
    boolean mo32q();

    int reduce(int i, IntBinaryOperator intBinaryOperator);

    C0401a0 reduce(IntBinaryOperator intBinaryOperator);

    /* renamed from: s */
    IntStream mo31s(C0589k0 k0Var);

    @Override // p004j$.util.stream.AbstractC0548g
    IntStream sequential();

    IntStream skip(long j);

    IntStream sorted();

    @Override // p004j$.util.stream.AbstractC0548g
    AbstractC0751v0 spliterator();

    int sum();

    C0750v summaryStatistics();

    /* renamed from: t */
    boolean mo30t();

    int[] toArray();

    /* renamed from: y */
    boolean mo29y();

    /* renamed from: j$.util.stream.IntStream$Wrapper */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class Wrapper implements java.util.stream.IntStream {
        public /* synthetic */ Wrapper() {
            IntStream.this = r1;
        }

        public static /* synthetic */ java.util.stream.IntStream convert(IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof VivifiedWrapper ? ((VivifiedWrapper) intStream).f473a : new Wrapper();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
            return IntStream.this.mo32q();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
            return IntStream.this.mo29y();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ DoubleStream asDoubleStream() {
            return C0489a0.m222f(IntStream.this.asDoubleStream());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ LongStream asLongStream() {
            return C0580j1.m191f(IntStream.this.asLongStream());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalDouble average() {
            return AbstractC0279a.m556I(IntStream.this.average());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ Stream boxed() {
            return Stream.Wrapper.convert(IntStream.this.boxed());
        }

        @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            IntStream.this.close();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return IntStream.this.collect(supplier, objIntConsumer, biConsumer);
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ long count() {
            return IntStream.this.count();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream distinct() {
            return convert(IntStream.this.distinct());
        }

        public final /* synthetic */ java.util.stream.IntStream dropWhile(IntPredicate intPredicate) {
            return convert(IntStream.this.mo36c());
        }

        public final /* synthetic */ boolean equals(Object obj) {
            IntStream intStream = IntStream.this;
            if (obj instanceof Wrapper) {
                obj = IntStream.this;
            }
            return intStream.equals(obj);
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream filter(IntPredicate intPredicate) {
            return convert(IntStream.this.mo37b());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalInt findAny() {
            return AbstractC0279a.m555J(IntStream.this.findAny());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalInt findFirst() {
            return AbstractC0279a.m555J(IntStream.this.findFirst());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ void forEach(IntConsumer intConsumer) {
            IntStream.this.forEach(intConsumer);
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            IntStream.this.forEachOrdered(intConsumer);
        }

        public final /* synthetic */ int hashCode() {
            return IntStream.this.hashCode();
        }

        @Override // java.util.stream.BaseStream
        public final /* synthetic */ boolean isParallel() {
            return IntStream.this.isParallel();
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream limit(long j) {
            return convert(IntStream.this.limit(j));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream map(IntUnaryOperator intUnaryOperator) {
            return convert(IntStream.this.mo35e());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
            return C0489a0.m222f(IntStream.this.mo34g());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ LongStream mapToLong(IntToLongFunction intToLongFunction) {
            return C0580j1.m191f(IntStream.this.mo33l());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.Stream mapToObj(IntFunction intFunction) {
            return Stream.Wrapper.convert(IntStream.this.mapToObj(intFunction));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalInt max() {
            return AbstractC0279a.m555J(IntStream.this.max());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalInt min() {
            return AbstractC0279a.m555J(IntStream.this.min());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ boolean noneMatch(IntPredicate intPredicate) {
            return IntStream.this.mo30t();
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.IntStream onClose(Runnable runnable) {
            return C0538f.m208f(IntStream.this.onClose(runnable));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream peek(IntConsumer intConsumer) {
            return convert(IntStream.this.peek(intConsumer));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
            return IntStream.this.reduce(i, intBinaryOperator);
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
            return AbstractC0279a.m555J(IntStream.this.reduce(intBinaryOperator));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream skip(long j) {
            return convert(IntStream.this.skip(j));
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ java.util.stream.IntStream sorted() {
            return convert(IntStream.this.sorted());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ int sum() {
            return IntStream.this.sum();
        }

        public final /* synthetic */ java.util.stream.IntStream takeWhile(IntPredicate intPredicate) {
            return convert(IntStream.this.mo38a());
        }

        @Override // java.util.stream.IntStream
        public final /* synthetic */ int[] toArray() {
            return IntStream.this.toArray();
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.util.stream.IntStream, java.util.stream.BaseStream] */
        @Override // java.util.stream.BaseStream
        public final /* synthetic */ java.util.stream.IntStream unordered() {
            return C0538f.m208f(IntStream.this.unordered());
        }

        @Override // java.util.stream.IntStream
        public final IntSummaryStatistics summaryStatistics() {
            IntStream.this.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.IntSummaryStatistics");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [j$.util.stream.k0, java.lang.Object] */
        @Override // java.util.stream.IntStream
        public final java.util.stream.IntStream flatMap(IntFunction intFunction) {
            IntStream intStream = IntStream.this;
            ?? obj = new Object();
            obj.f625a = intFunction;
            return convert(intStream.mo31s(obj));
        }
    }

    /* renamed from: j$.util.stream.IntStream$VivifiedWrapper */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class VivifiedWrapper implements IntStream {

        /* renamed from: a */
        public final /* synthetic */ java.util.stream.IntStream f473a;

        public /* synthetic */ VivifiedWrapper(java.util.stream.IntStream intStream) {
            this.f473a = intStream;
        }

        public static /* synthetic */ IntStream convert(java.util.stream.IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof Wrapper ? IntStream.this : new VivifiedWrapper(intStream);
        }

        @Override // p004j$.util.stream.IntStream
        /* renamed from: a */
        public final /* synthetic */ IntStream mo38a() {
            return convert(this.f473a.takeWhile(null));
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ AbstractC0499b0 asDoubleStream() {
            return C0737z.m48f(this.f473a.asDoubleStream());
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ AbstractC0590k1 asLongStream() {
            return C0570i1.m196f(this.f473a.asLongStream());
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ C0758z average() {
            return AbstractC0279a.m560E(this.f473a.average());
        }

        @Override // p004j$.util.stream.IntStream
        /* renamed from: b */
        public final /* synthetic */ IntStream mo37b() {
            return convert(this.f473a.filter(null));
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ Stream boxed() {
            return C0705v6.m84f(this.f473a.boxed());
        }

        @Override // p004j$.util.stream.IntStream
        /* renamed from: c */
        public final /* synthetic */ IntStream mo36c() {
            return convert(this.f473a.dropWhile(null));
        }

        @Override // java.lang.AutoCloseable
        public final /* synthetic */ void close() {
            this.f473a.close();
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return this.f473a.collect(supplier, objIntConsumer, biConsumer);
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ long count() {
            return this.f473a.count();
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ IntStream distinct() {
            return convert(this.f473a.distinct());
        }

        @Override // p004j$.util.stream.IntStream
        /* renamed from: e */
        public final /* synthetic */ IntStream mo35e() {
            return convert(this.f473a.map(null));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            java.util.stream.IntStream intStream = this.f473a;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).f473a;
            }
            return intStream.equals(obj);
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ C0401a0 findAny() {
            return AbstractC0279a.m559F(this.f473a.findAny());
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ C0401a0 findFirst() {
            return AbstractC0279a.m559F(this.f473a.findFirst());
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ void forEach(IntConsumer intConsumer) {
            this.f473a.forEach(intConsumer);
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            this.f473a.forEachOrdered(intConsumer);
        }

        @Override // p004j$.util.stream.IntStream
        /* renamed from: g */
        public final /* synthetic */ AbstractC0499b0 mo34g() {
            return C0737z.m48f(this.f473a.mapToDouble(null));
        }

        public final /* synthetic */ int hashCode() {
            return this.f473a.hashCode();
        }

        @Override // p004j$.util.stream.AbstractC0548g
        public final /* synthetic */ boolean isParallel() {
            return this.f473a.isParallel();
        }

        @Override // p004j$.util.stream.IntStream
        /* renamed from: l */
        public final /* synthetic */ AbstractC0590k1 mo33l() {
            return C0570i1.m196f(this.f473a.mapToLong(null));
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ IntStream limit(long j) {
            return convert(this.f473a.limit(j));
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ Stream mapToObj(IntFunction intFunction) {
            return C0705v6.m84f(this.f473a.mapToObj(intFunction));
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ C0401a0 max() {
            return AbstractC0279a.m559F(this.f473a.max());
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ C0401a0 min() {
            return AbstractC0279a.m559F(this.f473a.min());
        }

        @Override // p004j$.util.stream.AbstractC0548g
        public final /* synthetic */ AbstractC0548g onClose(Runnable runnable) {
            return C0528e.m210f(this.f473a.onClose(runnable));
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ IntStream peek(IntConsumer intConsumer) {
            return convert(this.f473a.peek(intConsumer));
        }

        @Override // p004j$.util.stream.IntStream
        /* renamed from: q */
        public final /* synthetic */ boolean mo32q() {
            return this.f473a.allMatch(null);
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
            return this.f473a.reduce(i, intBinaryOperator);
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ C0401a0 reduce(IntBinaryOperator intBinaryOperator) {
            return AbstractC0279a.m559F(this.f473a.reduce(intBinaryOperator));
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ IntStream skip(long j) {
            return convert(this.f473a.skip(j));
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ IntStream sorted() {
            return convert(this.f473a.sorted());
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ int sum() {
            return this.f473a.sum();
        }

        @Override // p004j$.util.stream.IntStream
        /* renamed from: t */
        public final /* synthetic */ boolean mo30t() {
            return this.f473a.noneMatch(null);
        }

        @Override // p004j$.util.stream.IntStream
        public final /* synthetic */ int[] toArray() {
            return this.f473a.toArray();
        }

        @Override // p004j$.util.stream.AbstractC0548g
        public final /* synthetic */ AbstractC0548g unordered() {
            return C0528e.m210f(this.f473a.unordered());
        }

        @Override // p004j$.util.stream.IntStream
        /* renamed from: y */
        public final /* synthetic */ boolean mo29y() {
            return this.f473a.anyMatch(null);
        }

        @Override // p004j$.util.stream.IntStream
        public final C0750v summaryStatistics() {
            this.f473a.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [j$.util.stream.k0, java.lang.Object, java.util.function.IntFunction] */
        @Override // p004j$.util.stream.IntStream
        /* renamed from: s */
        public final IntStream mo31s(C0589k0 k0Var) {
            java.util.stream.IntStream intStream = this.f473a;
            ?? obj = new Object();
            obj.f625a = k0Var;
            return convert(intStream.flatMap(obj));
        }
    }
}
