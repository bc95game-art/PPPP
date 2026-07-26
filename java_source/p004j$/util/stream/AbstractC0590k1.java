package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import p004j$.util.AbstractC0472n0;
import p004j$.util.AbstractC0757y0;
import p004j$.util.C0404b0;
import p004j$.util.C0471n;
import p004j$.util.C0754x;
import p004j$.util.C0758z;
/* renamed from: j$.util.stream.k1 */
/* loaded from: classes2.dex */
public interface AbstractC0590k1 extends AbstractC0548g {
    /* renamed from: B */
    IntStream mo186B();

    /* renamed from: a */
    AbstractC0590k1 mo185a();

    AbstractC0499b0 asDoubleStream();

    C0758z average();

    /* renamed from: b */
    AbstractC0590k1 mo184b();

    Stream boxed();

    /* renamed from: c */
    AbstractC0590k1 mo183c();

    Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer);

    long count();

    /* renamed from: d */
    AbstractC0590k1 mo182d(C0471n nVar);

    AbstractC0590k1 distinct();

    /* renamed from: e */
    AbstractC0590k1 mo181e();

    C0404b0 findAny();

    C0404b0 findFirst();

    void forEach(LongConsumer longConsumer);

    void forEachOrdered(LongConsumer longConsumer);

    @Override // p004j$.util.stream.AbstractC0548g
    AbstractC0472n0 iterator();

    /* renamed from: k */
    AbstractC0499b0 mo180k();

    AbstractC0590k1 limit(long j);

    Stream mapToObj(LongFunction longFunction);

    C0404b0 max();

    C0404b0 min();

    /* renamed from: n */
    boolean mo179n();

    @Override // p004j$.util.stream.AbstractC0548g
    AbstractC0590k1 parallel();

    AbstractC0590k1 peek(LongConsumer longConsumer);

    /* renamed from: r */
    boolean mo178r();

    long reduce(long j, LongBinaryOperator longBinaryOperator);

    C0404b0 reduce(LongBinaryOperator longBinaryOperator);

    @Override // p004j$.util.stream.AbstractC0548g
    AbstractC0590k1 sequential();

    AbstractC0590k1 skip(long j);

    AbstractC0590k1 sorted();

    @Override // p004j$.util.stream.AbstractC0548g
    AbstractC0757y0 spliterator();

    long sum();

    C0754x summaryStatistics();

    long[] toArray();

    /* renamed from: x */
    boolean mo177x();
}
