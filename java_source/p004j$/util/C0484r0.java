package p004j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
/* renamed from: j$.util.r0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0484r0 implements Spliterator.OfDouble {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0487s0 f471a;

    public /* synthetic */ C0484r0(AbstractC0487s0 s0Var) {
        this.f471a = s0Var;
    }

    /* renamed from: a */
    public static /* synthetic */ Spliterator.OfDouble m228a(AbstractC0487s0 s0Var) {
        if (s0Var == null) {
            return null;
        }
        return s0Var instanceof C0481q0 ? ((C0481q0) s0Var).f465a : new C0484r0(s0Var);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f471a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        AbstractC0487s0 s0Var = this.f471a;
        if (obj instanceof C0484r0) {
            obj = ((C0484r0) obj).f471a;
        }
        return s0Var.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f471a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f471a.forEachRemaining((Object) doubleConsumer);
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f471a.forEachRemaining(consumer);
    }

    @Override // java.util.Spliterator.OfDouble
    /* renamed from: forEachRemaining */
    public final /* synthetic */ void forEachRemaining2(DoubleConsumer doubleConsumer) {
        this.f471a.forEachRemaining(doubleConsumer);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f471a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f471a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f471a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f471a.hashCode();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.f471a.tryAdvance((Object) doubleConsumer);
    }

    @Override // java.util.Spliterator.OfDouble, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f471a.tryAdvance(consumer);
    }

    @Override // java.util.Spliterator.OfDouble
    /* renamed from: tryAdvance */
    public final /* synthetic */ boolean tryAdvance2(DoubleConsumer doubleConsumer) {
        return this.f471a.tryAdvance(doubleConsumer);
    }
}
