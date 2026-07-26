package p004j$.util.stream;
/* renamed from: j$.util.stream.u4 */
/* loaded from: classes2.dex */
public final class C0693u4 extends AbstractC0703v4 {
    @Override // p004j$.util.stream.AbstractC0653q4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.f797b);
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        this.f797b += ((AbstractC0703v4) p4Var).f797b;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f797b++;
    }
}
