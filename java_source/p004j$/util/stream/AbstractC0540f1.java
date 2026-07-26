package p004j$.util.stream;

import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.f1 */
/* loaded from: classes2.dex */
public abstract class AbstractC0540f1 extends AbstractC0560h1 {
    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: O0 */
    public final boolean mo25O0() {
        return true;
    }

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

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0548g unordered() {
        return !EnumC0725x6.ORDERED.m66l(this.f481m) ? this : new C0668s(this, EnumC0725x6.f835r, 4);
    }

    @Override // p004j$.util.stream.AbstractC0560h1, p004j$.util.stream.AbstractC0488a, p004j$.util.stream.AbstractC0548g
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
