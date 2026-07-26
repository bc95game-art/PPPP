package p004j$.util.stream;

import java.util.Iterator;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import p004j$.util.C0408c1;
import p004j$.util.Spliterator;
import p004j$.util.stream.IntStream;
/* renamed from: j$.util.stream.e */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0528e implements AbstractC0548g {

    /* renamed from: a */
    public final /* synthetic */ BaseStream f539a;

    public /* synthetic */ C0528e(BaseStream baseStream) {
        this.f539a = baseStream;
    }

    /* renamed from: f */
    public static /* synthetic */ AbstractC0548g m210f(BaseStream baseStream) {
        if (baseStream == null) {
            return null;
        }
        return baseStream instanceof C0538f ? ((C0538f) baseStream).f547a : baseStream instanceof DoubleStream ? C0737z.m48f((DoubleStream) baseStream) : baseStream instanceof IntStream ? IntStream.VivifiedWrapper.convert((java.util.stream.IntStream) baseStream) : baseStream instanceof LongStream ? C0570i1.m196f((LongStream) baseStream) : baseStream instanceof Stream ? C0705v6.m84f((Stream) baseStream) : new C0528e(baseStream);
    }

    @Override // java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f539a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        BaseStream baseStream = this.f539a;
        if (obj instanceof C0528e) {
            obj = ((C0528e) obj).f539a;
        }
        return baseStream.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f539a.hashCode();
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ boolean isParallel() {
        return this.f539a.isParallel();
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ Iterator iterator() {
        return this.f539a.iterator();
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g onClose(Runnable runnable) {
        return m210f(this.f539a.onClose(runnable));
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g parallel() {
        return m210f(this.f539a.parallel());
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g sequential() {
        return m210f(this.f539a.sequential());
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ Spliterator spliterator() {
        return C0408c1.m273a(this.f539a.spliterator());
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final /* synthetic */ AbstractC0548g unordered() {
        return m210f(this.f539a.unordered());
    }
}
