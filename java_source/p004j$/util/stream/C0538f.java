package p004j$.util.stream;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.BaseStream;
import p004j$.util.Spliterator;
import p004j$.util.stream.IntStream;
import p004j$.util.stream.Stream;
/* renamed from: j$.util.stream.f */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0538f implements BaseStream {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0548g f547a;

    public /* synthetic */ C0538f(AbstractC0548g gVar) {
        this.f547a = gVar;
    }

    /* renamed from: f */
    public static /* synthetic */ BaseStream m208f(AbstractC0548g gVar) {
        if (gVar == null) {
            return null;
        }
        return gVar instanceof C0528e ? ((C0528e) gVar).f539a : gVar instanceof AbstractC0499b0 ? C0489a0.m222f((AbstractC0499b0) gVar) : gVar instanceof IntStream ? IntStream.Wrapper.convert((IntStream) gVar) : gVar instanceof AbstractC0590k1 ? C0580j1.m191f((AbstractC0590k1) gVar) : gVar instanceof Stream ? Stream.Wrapper.convert((Stream) gVar) : new C0538f(gVar);
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        this.f547a.close();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        AbstractC0548g gVar = this.f547a;
        if (obj instanceof C0538f) {
            obj = ((C0538f) obj).f547a;
        }
        return gVar.equals(obj);
    }

    public final /* synthetic */ int hashCode() {
        return this.f547a.hashCode();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ boolean isParallel() {
        return this.f547a.isParallel();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ Iterator iterator() {
        return this.f547a.iterator();
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return m208f(this.f547a.onClose(runnable));
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream parallel() {
        return m208f(this.f547a.parallel());
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream sequential() {
        return m208f(this.f547a.sequential());
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(this.f547a.spliterator());
    }

    @Override // java.util.stream.BaseStream
    public final /* synthetic */ BaseStream unordered() {
        return m208f(this.f547a.unordered());
    }
}
