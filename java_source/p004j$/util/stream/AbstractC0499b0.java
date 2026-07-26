package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import p004j$.util.AbstractC0441f0;
import p004j$.util.AbstractC0487s0;
import p004j$.util.C0471n;
import p004j$.util.C0748u;
import p004j$.util.C0758z;
/* renamed from: j$.util.stream.b0 */
/* loaded from: classes2.dex */
public interface AbstractC0499b0 extends AbstractC0548g {
    /* renamed from: A */
    IntStream mo55A();

    /* renamed from: C */
    boolean mo54C();

    /* renamed from: a */
    AbstractC0499b0 mo53a();

    C0758z average();

    /* renamed from: b */
    AbstractC0499b0 mo52b();

    Stream boxed();

    /* renamed from: c */
    AbstractC0499b0 mo51c();

    Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer);

    long count();

    /* renamed from: d */
    AbstractC0499b0 mo50d(C0471n nVar);

    AbstractC0499b0 distinct();

    /* renamed from: e */
    AbstractC0499b0 mo49e();

    C0758z findAny();

    C0758z findFirst();

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    @Override // p004j$.util.stream.AbstractC0548g
    AbstractC0441f0 iterator();

    AbstractC0499b0 limit(long j);

    Stream mapToObj(DoubleFunction doubleFunction);

    C0758z max();

    C0758z min();

    /* renamed from: p */
    boolean mo47p();

    @Override // p004j$.util.stream.AbstractC0548g
    AbstractC0499b0 parallel();

    AbstractC0499b0 peek(DoubleConsumer doubleConsumer);

    double reduce(double d, DoubleBinaryOperator doubleBinaryOperator);

    C0758z reduce(DoubleBinaryOperator doubleBinaryOperator);

    @Override // p004j$.util.stream.AbstractC0548g
    AbstractC0499b0 sequential();

    AbstractC0499b0 skip(long j);

    AbstractC0499b0 sorted();

    @Override // p004j$.util.stream.AbstractC0548g
    AbstractC0487s0 spliterator();

    double sum();

    C0748u summaryStatistics();

    double[] toArray();

    /* renamed from: u */
    boolean mo46u();

    /* renamed from: v */
    AbstractC0590k1 mo45v();
}
