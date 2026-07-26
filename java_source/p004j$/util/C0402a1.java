package p004j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
/* renamed from: j$.util.a1 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0402a1 implements Spliterator.OfPrimitive {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0405b1 f303a;

    public /* synthetic */ C0402a1(AbstractC0405b1 b1Var) {
        this.f303a = b1Var;
    }

    /* renamed from: a */
    public static /* synthetic */ Spliterator.OfPrimitive m274a(AbstractC0405b1 b1Var) {
        if (b1Var == null) {
            return null;
        }
        return b1Var instanceof C0759z0 ? ((C0759z0) b1Var).f887a : b1Var instanceof AbstractC0487s0 ? C0484r0.m228a((AbstractC0487s0) b1Var) : b1Var instanceof AbstractC0751v0 ? C0749u0.m11a((AbstractC0751v0) b1Var) : b1Var instanceof AbstractC0757y0 ? C0755x0.m7a((AbstractC0757y0) b1Var) : new C0402a1(b1Var);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f303a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        AbstractC0405b1 b1Var = this.f303a;
        if (obj instanceof C0402a1) {
            obj = ((C0402a1) obj).f303a;
        }
        return b1Var.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f303a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f303a.forEachRemaining(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f303a.forEachRemaining(consumer);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f303a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f303a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f303a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f303a.hashCode();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f303a.tryAdvance(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f303a.tryAdvance(consumer);
    }
}
