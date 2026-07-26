package p004j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
/* renamed from: j$.util.e0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0438e0 implements PrimitiveIterator.OfDouble {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0441f0 f395a;

    public final /* synthetic */ boolean equals(Object obj) {
        AbstractC0441f0 f0Var = this.f395a;
        if (obj instanceof C0438e0) {
            obj = ((C0438e0) obj).f395a;
        }
        return f0Var.equals(obj);
    }

    @Override // java.util.PrimitiveIterator
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f395a.forEachRemaining((Object) doubleConsumer);
    }

    @Override // java.util.PrimitiveIterator.OfDouble, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f395a.forEachRemaining(consumer);
    }

    @Override // java.util.PrimitiveIterator.OfDouble
    /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
    public final /* synthetic */ void forEachRemaining2(DoubleConsumer doubleConsumer) {
        this.f395a.forEachRemaining(doubleConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f395a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f395a.hashCode();
    }

    @Override // java.util.PrimitiveIterator.OfDouble
    public final /* synthetic */ double nextDouble() {
        return this.f395a.nextDouble();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f395a.remove();
    }
}
