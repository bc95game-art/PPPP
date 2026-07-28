package p004j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
/* renamed from: j$.util.u0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0749u0 implements Spliterator.OfInt {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0751v0 f879a;

    public /* synthetic */ C0749u0(AbstractC0751v0 v0Var) {
        this.f879a = v0Var;
    }

    /* renamed from: a */
    public static /* synthetic */ Spliterator.OfInt m11a(AbstractC0751v0 v0Var) {
        if (v0Var == null) {
            return null;
        }
        return v0Var instanceof C0747t0 ? ((C0747t0) v0Var).f876a : new C0749u0(v0Var);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f879a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        AbstractC0751v0 v0Var = this.f879a;
        if (obj instanceof C0749u0) {
            obj = ((C0749u0) obj).f879a;
        }
        return v0Var.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f879a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f879a.forEachRemaining((Object) intConsumer);
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f879a.forEachRemaining(consumer);
    }

    @Override // java.util.Spliterator.OfInt
    /* renamed from: forEachRemaining */
    public final /* synthetic */ void forEachRemaining2(IntConsumer intConsumer) {
        this.f879a.forEachRemaining(intConsumer);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f879a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f879a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f879a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f879a.hashCode();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f879a.tryAdvance((Object) intConsumer);
    }

    @Override // java.util.Spliterator.OfInt, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f879a.tryAdvance(consumer);
    }

    @Override // java.util.Spliterator.OfInt
    /* renamed from: tryAdvance */
    public final /* synthetic */ boolean tryAdvance2(IntConsumer intConsumer) {
        return this.f879a.tryAdvance(intConsumer);
    }
}
