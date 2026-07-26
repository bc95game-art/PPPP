package p004j$.util.stream;

import java.util.function.LongConsumer;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.e1 */
/* loaded from: classes2.dex */
public final class C0530e1 extends AbstractC0560h1 {
    @Override // p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final AbstractC0590k1 sequential() {
        this.f476h.f486r = false;
        return this;
    }

    @Override // p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final AbstractC0590k1 parallel() {
        this.f476h.f486r = true;
        return this;
    }

    @Override // p004j$.util.stream.AbstractC0560h1, p004j$.util.stream.AbstractC0590k1
    public final void forEach(LongConsumer longConsumer) {
        if (!this.f476h.f486r) {
            AbstractC0560h1.m204T0(m223R0()).forEachRemaining(longConsumer);
        } else {
            super.forEach(longConsumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0560h1, p004j$.util.stream.AbstractC0590k1
    public final void forEachOrdered(LongConsumer longConsumer) {
        if (!this.f476h.f486r) {
            AbstractC0560h1.m204T0(m223R0()).forEachRemaining(longConsumer);
        } else {
            super.forEachOrdered(longConsumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0548g unordered() {
        return !EnumC0725x6.ORDERED.m66l(this.f481m) ? this : new C0668s(this, EnumC0725x6.f835r, 4);
    }

    @Override // p004j$.util.stream.AbstractC0560h1, p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
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
