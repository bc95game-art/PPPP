package p004j$.util.stream;
/* renamed from: j$.util.stream.r */
/* loaded from: classes2.dex */
public final class C0658r extends AbstractC0729y0 {

    /* renamed from: s */
    public final /* synthetic */ int f718s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0658r(AbstractC0488a aVar, int i, int i2) {
        super(aVar, i);
        this.f718s = i2;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        switch (this.f718s) {
            case 0:
                return new C0628o(this, k5Var, 2);
            case 1:
                return new C0669s0(this, k5Var, 2);
            case 2:
                return k5Var;
            case 3:
                return new C0669s0(this, k5Var, 5);
            default:
                return new C0490a1(this, k5Var, 2);
        }
    }
}
