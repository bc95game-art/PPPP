package p004j$.util.stream;

import java.util.function.DoubleConsumer;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.v */
/* loaded from: classes2.dex */
public final class C0698v extends AbstractC0728y {
    @Override // p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final AbstractC0499b0 sequential() {
        this.f476h.f486r = false;
        return this;
    }

    @Override // p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final AbstractC0499b0 parallel() {
        this.f476h.f486r = true;
        return this;
    }

    @Override // p004j$.util.stream.AbstractC0728y, p004j$.util.stream.AbstractC0499b0
    public final void forEach(DoubleConsumer doubleConsumer) {
        if (!this.f476h.f486r) {
            AbstractC0728y.m64T0(m223R0()).forEachRemaining(doubleConsumer);
        } else {
            super.forEach(doubleConsumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0728y, p004j$.util.stream.AbstractC0499b0
    public final void forEachOrdered(DoubleConsumer doubleConsumer) {
        if (!this.f476h.f486r) {
            AbstractC0728y.m64T0(m223R0()).forEachRemaining(doubleConsumer);
        } else {
            super.forEachOrdered(doubleConsumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0548g unordered() {
        return !EnumC0725x6.ORDERED.m66l(this.f481m) ? this : new C0648q(this, EnumC0725x6.f835r, 1);
    }

    @Override // p004j$.util.stream.AbstractC0728y, p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: O0 */
    public final boolean mo25O0() {
        throw new UnsupportedOperationException();
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        throw new UnsupportedOperationException();
    }
}
