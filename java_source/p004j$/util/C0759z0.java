package p004j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
/* renamed from: j$.util.z0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0759z0 implements AbstractC0405b1 {

    /* renamed from: a */
    public final /* synthetic */ Spliterator.OfPrimitive f887a;

    public /* synthetic */ C0759z0(Spliterator.OfPrimitive ofPrimitive) {
        this.f887a = ofPrimitive;
    }

    /* renamed from: a */
    public static /* synthetic */ AbstractC0405b1 m6a(Spliterator.OfPrimitive ofPrimitive) {
        if (ofPrimitive == null) {
            return null;
        }
        return ofPrimitive instanceof C0402a1 ? ((C0402a1) ofPrimitive).f303a : ofPrimitive instanceof Spliterator.OfDouble ? C0481q0.m229a((Spliterator.OfDouble) ofPrimitive) : ofPrimitive instanceof Spliterator.OfInt ? C0747t0.m14a((Spliterator.OfInt) ofPrimitive) : ofPrimitive instanceof Spliterator.OfLong ? C0753w0.m9a((Spliterator.OfLong) ofPrimitive) : new C0759z0(ofPrimitive);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f887a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfPrimitive ofPrimitive = this.f887a;
        if (obj instanceof C0759z0) {
            obj = ((C0759z0) obj).f887a;
        }
        return ofPrimitive.equals(obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f887a.estimateSize();
    }

    @Override // p004j$.util.AbstractC0405b1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f887a.forEachRemaining((Spliterator.OfPrimitive) obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f887a.forEachRemaining(consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f887a.getComparator();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f887a.getExactSizeIfKnown();
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f887a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f887a.hashCode();
    }

    @Override // p004j$.util.AbstractC0405b1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f887a.tryAdvance((Spliterator.OfPrimitive) obj);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f887a.tryAdvance(consumer);
    }
}
