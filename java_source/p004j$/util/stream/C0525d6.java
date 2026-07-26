package p004j$.util.stream;

import java.util.Arrays;
import java.util.function.IntFunction;
import p004j$.util.AbstractC0751v0;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.d6 */
/* loaded from: classes2.dex */
public final class C0525d6 extends AbstractC0719x0 implements AbstractC0637o8 {

    /* renamed from: s */
    public final /* synthetic */ int f537s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0525d6(AbstractC0488a aVar, int i, int i2) {
        super(aVar, i);
        this.f537s = i2;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: N0 */
    public Spliterator mo160N0(AbstractC0488a aVar, Spliterator spliterator) {
        switch (this.f537s) {
            case 1:
                if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
                    return mo161M0(aVar, spliterator, new C0541f2(14)).mo904spliterator();
                }
                return new C0687t8((AbstractC0751v0) aVar.mo138G0(spliterator), 1);
            case 2:
                if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
                    return mo161M0(aVar, spliterator, new C0541f2(15)).mo904spliterator();
                }
                return new C0687t8((AbstractC0751v0) aVar.mo138G0(spliterator), 0);
            default:
                return super.mo160N0(aVar, spliterator);
        }
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: M0 */
    public final AbstractC0531e2 mo161M0(AbstractC0692u3 u3Var, Spliterator spliterator, IntFunction intFunction) {
        switch (this.f537s) {
            case 0:
                if (EnumC0725x6.SORTED.m66l(((AbstractC0488a) u3Var).f481m)) {
                    return u3Var.mo106k0(spliterator, false, intFunction);
                }
                int[] iArr = (int[]) ((AbstractC0491a2) u3Var.mo106k0(spliterator, true, intFunction)).mo79b();
                Arrays.sort(iArr);
                return new C0492a3(iArr);
            case 1:
                return (AbstractC0531e2) new C0667r8(this, u3Var, spliterator, intFunction).invoke();
            default:
                return (AbstractC0531e2) new C0657q8(this, u3Var, spliterator, intFunction).invoke();
        }
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        switch (this.f537s) {
            case 0:
                Objects.requireNonNull(k5Var);
                if (EnumC0725x6.SORTED.m66l(i)) {
                    return k5Var;
                }
                return EnumC0725x6.SIZED.m66l(i) ? new AbstractC0534e5(k5Var) : new AbstractC0534e5(k5Var);
            case 1:
                return new C0577i8(this, k5Var);
            default:
                return new C0587j8(this, k5Var, false);
        }
    }

    @Override // p004j$.util.stream.AbstractC0637o8
    /* renamed from: i */
    public AbstractC0647p8 mo169i(AbstractC0710w1 w1Var, boolean z) {
        return new C0587j8(this, w1Var, z);
    }
}
