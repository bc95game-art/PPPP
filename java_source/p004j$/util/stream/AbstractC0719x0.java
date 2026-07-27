package p004j$.util.stream;

import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.x0 */
/* loaded from: classes2.dex */
public abstract class AbstractC0719x0 extends AbstractC0738z0 {
    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: O0 */
    public final boolean mo25O0() {
        return true;
    }

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

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0548g unordered() {
        return !EnumC0725x6.ORDERED.m66l(this.f481m) ? this : new C0658r(this, EnumC0725x6.f835r, 2);
    }

    @Override // p004j$.util.stream.AbstractC0738z0, p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
