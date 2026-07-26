package p004j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
/* renamed from: j$.util.q0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0481q0 implements AbstractC0487s0 {

    /* renamed from: a */
    public final /* synthetic */ Spliterator.OfDouble f465a;

    public /* synthetic */ C0481q0(Spliterator.OfDouble ofDouble) {
        this.f465a = ofDouble;
    }

    /* renamed from: a */
    public static /* synthetic */ AbstractC0487s0 m229a(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof C0484r0 ? ((C0484r0) ofDouble).f471a : new C0481q0(ofDouble);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f465a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfDouble ofDouble = this.f465a;
        if (obj instanceof C0481q0) {
            obj = ((C0481q0) obj).f465a;
        }
        return ofDouble.equals(obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f465a.estimateSize();
    }

    @Override // p004j$.util.AbstractC0405b1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f465a.forEachRemaining((Spliterator.OfDouble) obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f465a.forEachRemaining((Consumer<? super Double>) consumer);
    }

    @Override // p004j$.util.AbstractC0487s0
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f465a.forEachRemaining(doubleConsumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f465a.getComparator();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f465a.getExactSizeIfKnown();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f465a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f465a.hashCode();
    }

    @Override // p004j$.util.AbstractC0405b1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f465a.tryAdvance((Spliterator.OfDouble) obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f465a.tryAdvance((Consumer<? super Double>) consumer);
    }

    @Override // p004j$.util.AbstractC0487s0
    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.f465a.tryAdvance(doubleConsumer);
    }
}
