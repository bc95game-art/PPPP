package p004j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
/* renamed from: j$.util.t0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0747t0 implements AbstractC0751v0 {

    /* renamed from: a */
    public final /* synthetic */ Spliterator.OfInt f876a;

    public /* synthetic */ C0747t0(Spliterator.OfInt ofInt) {
        this.f876a = ofInt;
    }

    /* renamed from: a */
    public static /* synthetic */ AbstractC0751v0 m14a(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof C0749u0 ? ((C0749u0) ofInt).f879a : new C0747t0(ofInt);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f876a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfInt ofInt = this.f876a;
        if (obj instanceof C0747t0) {
            obj = ((C0747t0) obj).f876a;
        }
        return ofInt.equals(obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f876a.estimateSize();
    }

    @Override // p004j$.util.AbstractC0405b1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f876a.forEachRemaining((Spliterator.OfInt) obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f876a.forEachRemaining((Consumer<? super Integer>) consumer);
    }

    @Override // p004j$.util.AbstractC0751v0
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f876a.forEachRemaining(intConsumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f876a.getComparator();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f876a.getExactSizeIfKnown();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f876a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f876a.hashCode();
    }

    @Override // p004j$.util.AbstractC0405b1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f876a.tryAdvance((Spliterator.OfInt) obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f876a.tryAdvance((Consumer<? super Integer>) consumer);
    }

    @Override // p004j$.util.AbstractC0751v0
    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f876a.tryAdvance(intConsumer);
    }
}
