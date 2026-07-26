package p004j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
/* renamed from: j$.util.d0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0435d0 implements AbstractC0441f0, AbstractC0752w {

    /* renamed from: a */
    public final /* synthetic */ PrimitiveIterator.OfDouble f390a;

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfDouble ofDouble = this.f390a;
        if (obj instanceof C0435d0) {
            obj = ((C0435d0) obj).f390a;
        }
        return ofDouble.equals(obj);
    }

    @Override // p004j$.util.AbstractC0475o0
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f390a.forEachRemaining((PrimitiveIterator.OfDouble) obj);
    }

    @Override // p004j$.util.AbstractC0441f0, java.util.Iterator, p004j$.util.AbstractC0752w
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f390a.forEachRemaining((Consumer<? super Double>) consumer);
    }

    @Override // p004j$.util.AbstractC0441f0
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f390a.forEachRemaining(doubleConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f390a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f390a.hashCode();
    }

    @Override // p004j$.util.AbstractC0441f0
    public final /* synthetic */ double nextDouble() {
        return this.f390a.nextDouble();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f390a.remove();
    }
}
