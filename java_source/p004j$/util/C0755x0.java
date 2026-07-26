package p004j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
/* renamed from: j$.util.x0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0755x0 implements Spliterator.OfLong {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0757y0 f881a;

    public /* synthetic */ C0755x0(AbstractC0757y0 y0Var) {
        this.f881a = y0Var;
    }

    /* renamed from: a */
    public static /* synthetic */ Spliterator.OfLong m7a(AbstractC0757y0 y0Var) {
        if (y0Var == null) {
            return null;
        }
        return y0Var instanceof C0753w0 ? ((C0753w0) y0Var).f880a : new C0755x0(y0Var);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f881a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        AbstractC0757y0 y0Var = this.f881a;
        if (obj instanceof C0755x0) {
            obj = ((C0755x0) obj).f881a;
        }
        return y0Var.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f881a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f881a.forEachRemaining((Object) longConsumer);
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f881a.forEachRemaining(consumer);
    }

    @Override // java.util.Spliterator.OfLong
    /* renamed from: forEachRemaining */
    public final /* synthetic */ void forEachRemaining2(LongConsumer longConsumer) {
        this.f881a.forEachRemaining(longConsumer);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f881a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f881a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f881a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f881a.hashCode();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.f881a.tryAdvance((Object) longConsumer);
    }

    @Override // java.util.Spliterator.OfLong, java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f881a.tryAdvance(consumer);
    }

    @Override // java.util.Spliterator.OfLong
    /* renamed from: tryAdvance */
    public final /* synthetic */ boolean tryAdvance2(LongConsumer longConsumer) {
        return this.f881a.tryAdvance(longConsumer);
    }
}
