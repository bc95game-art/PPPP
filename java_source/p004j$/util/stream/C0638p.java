package p004j$.util.stream;

import java.util.function.Consumer;
/* renamed from: j$.util.stream.p */
/* loaded from: classes2.dex */
public final class C0638p extends AbstractC0504b5 {

    /* renamed from: s */
    public final /* synthetic */ int f685s;

    /* renamed from: t */
    public final /* synthetic */ Object f686t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0638p(AbstractC0488a aVar, int i, Object obj, int i2) {
        super(aVar, i);
        this.f685s = i2;
        this.f686t = obj;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        switch (this.f685s) {
            case 0:
                return new C0628o(this, k5Var, 0);
            case 1:
                return new C0669s0(this, k5Var, 0);
            case 2:
                return new C0490a1(this, k5Var, 0);
            case 3:
                return new C0598l(this, k5Var, 1);
            case 4:
                return new C0598l(this, k5Var, 2);
            case 5:
                return new C0598l(this, k5Var, 3);
            default:
                return new C0588k(this, k5Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0638p(AbstractC0514c5 c5Var, Consumer consumer) {
        super(c5Var, 0);
        this.f685s = 3;
        this.f686t = consumer;
    }
}
