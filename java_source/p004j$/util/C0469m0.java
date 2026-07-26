package p004j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
/* renamed from: j$.util.m0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0469m0 implements PrimitiveIterator.OfLong {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0472n0 f446a;

    public final /* synthetic */ boolean equals(Object obj) {
        AbstractC0472n0 n0Var = this.f446a;
        if (obj instanceof C0469m0) {
            obj = ((C0469m0) obj).f446a;
        }
        return n0Var.equals(obj);
    }

    @Override // java.util.PrimitiveIterator
    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f446a.forEachRemaining((Object) longConsumer);
    }

    @Override // java.util.PrimitiveIterator.OfLong, java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f446a.forEachRemaining(consumer);
    }

    @Override // java.util.PrimitiveIterator.OfLong
    /* renamed from: forEachRemaining  reason: avoid collision after fix types in other method */
    public final /* synthetic */ void forEachRemaining2(LongConsumer longConsumer) {
        this.f446a.forEachRemaining(longConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f446a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f446a.hashCode();
    }

    @Override // java.util.PrimitiveIterator.OfLong
    public final /* synthetic */ long nextLong() {
        return this.f446a.nextLong();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f446a.remove();
    }
}
