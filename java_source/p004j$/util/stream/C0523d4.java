package p004j$.util.stream;

import java.util.function.DoubleBinaryOperator;
/* renamed from: j$.util.stream.d4 */
/* loaded from: classes2.dex */
public final class C0523d4 extends AbstractC0692u3 {

    /* renamed from: h */
    public final /* synthetic */ DoubleBinaryOperator f534h;

    /* renamed from: i */
    public final /* synthetic */ double f535i;

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: D0 */
    public final AbstractC0643p4 mo26D0() {
        return new C0732y3(this.f535i, this.f534h);
    }

    public C0523d4(EnumC0735y6 y6Var, DoubleBinaryOperator doubleBinaryOperator, double d) {
        this.f534h = doubleBinaryOperator;
        this.f535i = d;
    }
}
