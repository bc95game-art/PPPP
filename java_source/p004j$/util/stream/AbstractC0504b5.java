package p004j$.util.stream;
/* renamed from: j$.util.stream.b5 */
/* loaded from: classes2.dex */
public abstract class AbstractC0504b5 extends AbstractC0514c5 {
    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: O0 */
    public final boolean mo25O0() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0548g unordered() {
        return !EnumC0725x6.ORDERED.m66l(this.f481m) ? this : new AbstractC0488a(this, EnumC0725x6.f835r);
    }
}
