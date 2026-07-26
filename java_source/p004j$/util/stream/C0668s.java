package p004j$.util.stream;
/* renamed from: j$.util.stream.s */
/* loaded from: classes2.dex */
public final class C0668s extends AbstractC0550g1 {

    /* renamed from: s */
    public final /* synthetic */ int f737s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0668s(AbstractC0488a aVar, int i, int i2) {
        super(aVar, i);
        this.f737s = i2;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        switch (this.f737s) {
            case 0:
                return new C0628o(this, k5Var, 3);
            case 1:
                return new C0689u0(0, k5Var);
            case 2:
                return new C0669s0(this, k5Var, 3);
            case 3:
                return new C0490a1(this, k5Var, 1);
            case 4:
                return k5Var;
            default:
                return new C0490a1(this, k5Var, 4);
        }
    }
}
