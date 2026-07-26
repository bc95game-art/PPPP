package p004j$.util.stream;

import java.util.function.LongBinaryOperator;
/* renamed from: j$.util.stream.v3 */
/* loaded from: classes2.dex */
public final class C0702v3 extends AbstractC0692u3 {

    /* renamed from: h */
    public final /* synthetic */ LongBinaryOperator f795h;

    /* renamed from: i */
    public final /* synthetic */ long f796i;

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: D0 */
    public final AbstractC0643p4 mo26D0() {
        return new C0623n4(this.f796i, this.f795h);
    }

    public C0702v3(EnumC0735y6 y6Var, LongBinaryOperator longBinaryOperator, long j) {
        this.f795h = longBinaryOperator;
        this.f796i = j;
    }
}
