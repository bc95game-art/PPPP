package p004j$.util.stream;

import java.util.function.IntConsumer;
/* renamed from: j$.util.stream.t0 */
/* loaded from: classes2.dex */
public final class C0679t0 extends AbstractC0729y0 {

    /* renamed from: s */
    public final /* synthetic */ int f759s;

    /* renamed from: t */
    public final /* synthetic */ Object f760t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0679t0(AbstractC0488a aVar, int i, Object obj, int i2) {
        super(aVar, i);
        this.f759s = i2;
        this.f760t = obj;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        switch (this.f759s) {
            case 0:
                return new C0669s0(this, k5Var, 1);
            case 1:
                return new C0699v0(this, k5Var);
            case 2:
                return new C0598l(this, k5Var, 4);
            default:
                return new C0723x4(this, k5Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0679t0(AbstractC0738z0 z0Var, IntConsumer intConsumer) {
        super(z0Var, 0);
        this.f759s = 0;
        this.f760t = intConsumer;
    }
}
