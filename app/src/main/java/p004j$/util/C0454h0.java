package p004j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
/* renamed from: j$.util.h0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0454h0 implements AbstractC0460j0, AbstractC0752w {

    /* renamed from: a */
    public final /* synthetic */ PrimitiveIterator.OfInt f428a;

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfInt ofInt = this.f428a;
        if (obj instanceof C0454h0) {
            obj = ((C0454h0) obj).f428a;
        }
        return ofInt.equals(obj);
    }

    @Override // p004j$.util.AbstractC0475o0
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f428a.forEachRemaining((PrimitiveIterator.OfInt) obj);
    }

    @Override // p004j$.util.AbstractC0460j0, java.util.Iterator, p004j$.util.AbstractC0752w
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f428a.forEachRemaining((Consumer<? super Integer>) consumer);
    }

    @Override // p004j$.util.AbstractC0460j0
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f428a.forEachRemaining(intConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f428a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f428a.hashCode();
    }

    @Override // p004j$.util.AbstractC0460j0
    public final /* synthetic */ int nextInt() {
        return this.f428a.nextInt();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f428a.remove();
    }
}
