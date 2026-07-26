package p004j$.util.stream;

import java.util.function.IntConsumer;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.w0 */
/* loaded from: classes2.dex */
public final class C0709w0 extends AbstractC0738z0 {
    @Override // p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final IntStream sequential() {
        this.f476h.f486r = false;
        return this;
    }

    @Override // p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final IntStream parallel() {
        this.f476h.f486r = true;
        return this;
    }

    @Override // p004j$.util.stream.AbstractC0738z0, p004j$.util.stream.IntStream
    public final void forEach(IntConsumer intConsumer) {
        if (!this.f476h.f486r) {
            AbstractC0738z0.m39T0(m223R0()).forEachRemaining(intConsumer);
        } else {
            super.forEach(intConsumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0738z0, p004j$.util.stream.IntStream
    public final void forEachOrdered(IntConsumer intConsumer) {
        if (!this.f476h.f486r) {
            AbstractC0738z0.m39T0(m223R0()).forEachRemaining(intConsumer);
        } else {
            super.forEachOrdered(intConsumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0548g unordered() {
        return !EnumC0725x6.ORDERED.m66l(this.f481m) ? this : new C0658r(this, EnumC0725x6.f835r, 2);
    }

    @Override // p004j$.util.stream.AbstractC0738z0, p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
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
