package p004j$.util.stream;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;
/* renamed from: j$.util.stream.x3 */
/* loaded from: classes2.dex */
public final class C0722x3 extends AbstractC0692u3 {

    /* renamed from: h */
    public final /* synthetic */ int f816h;

    /* renamed from: i */
    public final /* synthetic */ Object f817i;

    public /* synthetic */ C0722x3(EnumC0735y6 y6Var, Object obj, int i) {
        this.f816h = i;
        this.f817i = obj;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: D0 */
    public final AbstractC0643p4 mo26D0() {
        switch (this.f816h) {
            case 0:
                return new C0633o4((LongBinaryOperator) this.f817i);
            case 1:
                return new C0493a4((DoubleBinaryOperator) this.f817i);
            case 2:
                return new C0543f4((BinaryOperator) this.f817i);
            default:
                return new C0603l4((IntBinaryOperator) this.f817i);
        }
    }
}
