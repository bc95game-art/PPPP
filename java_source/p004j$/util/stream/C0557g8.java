package p004j$.util.stream;

import java.util.function.IntFunction;
import java.util.function.Predicate;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.g8 */
/* loaded from: classes2.dex */
public final class C0557g8 extends AbstractC0494a5 implements AbstractC0637o8 {

    /* renamed from: s */
    public final /* synthetic */ int f572s;

    /* renamed from: t */
    public final /* synthetic */ Predicate f573t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0557g8(AbstractC0514c5 c5Var, int i, Predicate predicate, int i2) {
        super(c5Var, i);
        this.f572s = i2;
        this.f573t = predicate;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: N0 */
    public final Spliterator mo160N0(AbstractC0488a aVar, Spliterator spliterator) {
        switch (this.f572s) {
            case 0:
                if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
                    return mo161M0(aVar, spliterator, new C0541f2(0)).mo904spliterator();
                }
                return new C0707v8(aVar.mo138G0(spliterator), this.f573t, 1);
            default:
                if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
                    return mo161M0(aVar, spliterator, new C0541f2(0)).mo904spliterator();
                }
                return new C0707v8(aVar.mo138G0(spliterator), this.f573t, 0);
        }
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: M0 */
    public final AbstractC0531e2 mo161M0(AbstractC0692u3 u3Var, Spliterator spliterator, IntFunction intFunction) {
        switch (this.f572s) {
            case 0:
                return (AbstractC0531e2) new C0667r8(this, u3Var, spliterator, intFunction).invoke();
            default:
                return (AbstractC0531e2) new C0657q8(this, u3Var, spliterator, intFunction).invoke();
        }
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        switch (this.f572s) {
            case 0:
                return new C0588k(this, k5Var);
            default:
                return new C0567h8(this, k5Var, false);
        }
    }

    @Override // p004j$.util.stream.AbstractC0637o8
    /* renamed from: i */
    public AbstractC0647p8 mo169i(AbstractC0710w1 w1Var, boolean z) {
        return new C0567h8(this, w1Var, z);
    }
}
