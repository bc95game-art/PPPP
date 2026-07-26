package p004j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
/* renamed from: j$.util.l0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0466l0 implements AbstractC0472n0, AbstractC0752w {

    /* renamed from: a */
    public final /* synthetic */ PrimitiveIterator.OfLong f444a;

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfLong ofLong = this.f444a;
        if (obj instanceof C0466l0) {
            obj = ((C0466l0) obj).f444a;
        }
        return ofLong.equals(obj);
    }

    @Override // p004j$.util.AbstractC0475o0
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f444a.forEachRemaining((PrimitiveIterator.OfLong) obj);
    }

    @Override // p004j$.util.AbstractC0472n0, java.util.Iterator, p004j$.util.AbstractC0752w
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f444a.forEachRemaining((Consumer<? super Long>) consumer);
    }

    @Override // p004j$.util.AbstractC0472n0
    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f444a.forEachRemaining(longConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f444a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f444a.hashCode();
    }

    @Override // p004j$.util.AbstractC0472n0
    public final /* synthetic */ long nextLong() {
        return this.f444a.nextLong();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f444a.remove();
    }
}
