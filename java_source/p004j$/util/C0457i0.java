package p004j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
/* renamed from: j$.util.i0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0457i0 implements PrimitiveIterator.OfInt {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0460j0 f433a;

    public final /* synthetic */ boolean equals(Object obj) {
        AbstractC0460j0 j0Var = this.f433a;
        if (obj instanceof C0457i0) {
            obj = ((C0457i0) obj).f433a;
        }
        return j0Var.equals(obj);
    }

    @Override // java.util.PrimitiveIterator
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f433a.forEachRemaining((Object) intConsumer);
    }

    @Override // java.util.PrimitiveIterator.OfInt, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f433a.forEachRemaining(consumer);
    }

    @Override // java.util.PrimitiveIterator.OfInt
    /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
    public final /* synthetic */ void forEachRemaining2(IntConsumer intConsumer) {
        this.f433a.forEachRemaining(intConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f433a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f433a.hashCode();
    }

    @Override // java.util.PrimitiveIterator.OfInt
    public final /* synthetic */ int nextInt() {
        return this.f433a.nextInt();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f433a.remove();
    }
}
