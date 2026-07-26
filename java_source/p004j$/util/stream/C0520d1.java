package p004j$.util.stream;

import java.util.function.LongConsumer;
/* renamed from: j$.util.stream.d1 */
/* loaded from: classes2.dex */
public final class C0520d1 extends AbstractC0550g1 {

    /* renamed from: s */
    public final /* synthetic */ int f532s;

    /* renamed from: t */
    public final /* synthetic */ Object f533t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0520d1(AbstractC0488a aVar, int i, Object obj, int i2) {
        super(aVar, i);
        this.f532s = i2;
        this.f533t = obj;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        switch (this.f532s) {
            case 0:
                return new C0510c1(this, k5Var);
            case 1:
                return new C0490a1(this, k5Var, 5);
            case 2:
                return new C0723x4(this, k5Var);
            default:
                return new C0598l(this, k5Var, 5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0520d1(AbstractC0560h1 h1Var, LongConsumer longConsumer) {
        super(h1Var, 0);
        this.f532s = 1;
        this.f533t = longConsumer;
    }
}
