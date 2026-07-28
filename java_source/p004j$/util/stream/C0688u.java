package p004j$.util.stream;

import java.util.function.DoubleConsumer;
/* renamed from: j$.util.stream.u */
/* loaded from: classes2.dex */
public final class C0688u extends AbstractC0718x {

    /* renamed from: s */
    public final /* synthetic */ int f771s;

    /* renamed from: t */
    public final /* synthetic */ Object f772t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0688u(AbstractC0488a aVar, int i, Object obj, int i2) {
        super(aVar, i);
        this.f771s = i2;
        this.f772t = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0688u(AbstractC0728y yVar, DoubleConsumer doubleConsumer) {
        super(yVar, 0);
        this.f771s = 1;
        this.f772t = doubleConsumer;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        switch (this.f771s) {
            case 0:
                return new C0678t(this, k5Var);
            case 1:
                return new C0628o(this, k5Var, 5);
            case 2:
                return new C0598l(this, k5Var, 6);
            default:
                return new C0723x4(this, k5Var);
        }
    }
}
