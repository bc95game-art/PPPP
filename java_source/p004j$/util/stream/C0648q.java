package p004j$.util.stream;
/* renamed from: j$.util.stream.q */
/* loaded from: classes2.dex */
public final class C0648q extends AbstractC0718x {

    /* renamed from: s */
    public final /* synthetic */ int f692s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0648q(AbstractC0488a aVar, int i, int i2) {
        super(aVar, i);
        this.f692s = i2;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        switch (this.f692s) {
            case 0:
                return new C0628o(this, k5Var, 1);
            case 1:
                return k5Var;
            case 2:
                return new C0628o(this, k5Var, 4);
            case 3:
                return new C0689u0(1, k5Var);
            case 4:
                return new C0669s0(this, k5Var, 4);
            case 5:
                return new AbstractC0544f5(k5Var);
            default:
                return new C0490a1(this, k5Var, 3);
        }
    }
}
