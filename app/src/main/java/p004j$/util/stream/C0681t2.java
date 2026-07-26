package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0405b1;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.t2 */
/* loaded from: classes2.dex */
public final class C0681t2 extends C0625n6 implements AbstractC0730y1, AbstractC0680t1 {
    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo56n((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0680t1, p004j$.util.stream.AbstractC0710w1
    /* renamed from: build */
    public final AbstractC0531e2 mo903build() {
        return this;
    }

    @Override // p004j$.util.stream.AbstractC0680t1, p004j$.util.stream.AbstractC0710w1
    /* renamed from: build  reason: collision with other method in class */
    public final AbstractC0730y1 mo903build() {
        return this;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final void end() {
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: j */
    public final /* synthetic */ AbstractC0531e2 mo60j(long j, long j2, IntFunction intFunction) {
        return AbstractC0692u3.m125T(this, j, j2);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: m */
    public final /* synthetic */ Object[] mo59m(IntFunction intFunction) {
        return AbstractC0692u3.m132M(this, intFunction);
    }

    @Override // p004j$.util.stream.AbstractC0564h5
    /* renamed from: n */
    public final /* synthetic */ void mo56n(Double d) {
        AbstractC0692u3.m143E(this, d);
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: o */
    public final /* synthetic */ int mo58o() {
        return 0;
    }

    @Override // p004j$.util.stream.AbstractC0521d2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: a */
    public final AbstractC0521d2 mo63a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: k */
    public final /* synthetic */ void mo70k(Object[] objArr, int i) {
        AbstractC0692u3.m131N(this, (Double[]) objArr, i);
    }

    @Override // p004j$.util.stream.AbstractC0685t6, p004j$.util.stream.AbstractC0521d2
    /* renamed from: f */
    public final void mo154f(int i, Object obj) {
        super.mo154f(i, (double[]) obj);
    }

    @Override // p004j$.util.stream.AbstractC0685t6, p004j$.util.stream.AbstractC0521d2
    /* renamed from: g */
    public final void mo153g(Object obj) {
        super.mo153g((DoubleConsumer) obj);
    }

    @Override // p004j$.util.stream.C0625n6, p004j$.util.stream.AbstractC0685t6, java.lang.Iterable, p004j$.util.stream.AbstractC0521d2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator */
    public final Spliterator mo904spliterator() {
        return super.mo904spliterator();
    }

    @Override // p004j$.util.stream.C0625n6, p004j$.util.stream.AbstractC0685t6, java.lang.Iterable, p004j$.util.stream.AbstractC0521d2, p004j$.util.stream.AbstractC0531e2
    /* renamed from: spliterator  reason: collision with other method in class */
    public final AbstractC0405b1 mo904spliterator() {
        return super.mo904spliterator();
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        clear();
        m149s(j);
    }

    @Override // p004j$.util.stream.AbstractC0685t6, p004j$.util.stream.AbstractC0521d2
    /* renamed from: b */
    public final Object mo79b() {
        return (double[]) super.mo79b();
    }
}
