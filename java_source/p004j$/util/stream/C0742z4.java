package p004j$.util.stream;

import java.util.function.Consumer;
/* renamed from: j$.util.stream.z4 */
/* loaded from: classes2.dex */
public final class C0742z4 extends AbstractC0514c5 {
    @Override // p004j$.util.stream.AbstractC0514c5, p004j$.util.stream.Stream
    public final void forEach(Consumer consumer) {
        if (!this.f476h.f486r) {
            m223R0().forEachRemaining(consumer);
        } else {
            super.forEach(consumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0514c5, p004j$.util.stream.Stream
    public final void forEachOrdered(Consumer consumer) {
        if (!this.f476h.f486r) {
            m223R0().forEachRemaining(consumer);
        } else {
            super.forEachOrdered(consumer);
        }
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0548g unordered() {
        return !EnumC0725x6.ORDERED.m66l(this.f481m) ? this : new AbstractC0488a(this, EnumC0725x6.f835r);
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
