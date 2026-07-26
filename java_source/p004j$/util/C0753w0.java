package p004j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
/* renamed from: j$.util.w0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0753w0 implements AbstractC0757y0 {

    /* renamed from: a */
    public final /* synthetic */ Spliterator.OfLong f880a;

    public /* synthetic */ C0753w0(Spliterator.OfLong ofLong) {
        this.f880a = ofLong;
    }

    /* renamed from: a */
    public static /* synthetic */ AbstractC0757y0 m9a(Spliterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof C0755x0 ? ((C0755x0) ofLong).f881a : new C0753w0(ofLong);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f880a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfLong ofLong = this.f880a;
        if (obj instanceof C0753w0) {
            obj = ((C0753w0) obj).f880a;
        }
        return ofLong.equals(obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f880a.estimateSize();
    }

    @Override // p004j$.util.AbstractC0405b1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f880a.forEachRemaining((Spliterator.OfLong) obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f880a.forEachRemaining((Consumer<? super Long>) consumer);
    }

    @Override // p004j$.util.AbstractC0757y0
    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f880a.forEachRemaining(longConsumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f880a.getComparator();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f880a.getExactSizeIfKnown();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f880a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f880a.hashCode();
    }

    @Override // p004j$.util.AbstractC0405b1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f880a.tryAdvance((Spliterator.OfLong) obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f880a.tryAdvance((Consumer<? super Long>) consumer);
    }

    @Override // p004j$.util.AbstractC0757y0
    public final /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.f880a.tryAdvance(longConsumer);
    }
}
