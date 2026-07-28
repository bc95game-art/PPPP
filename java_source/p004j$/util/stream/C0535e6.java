package p004j$.util.stream;

import java.util.Arrays;
import java.util.function.IntFunction;
import p004j$.util.AbstractC0757y0;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.e6 */
/* loaded from: classes2.dex */
public final class C0535e6 extends AbstractC0540f1 implements AbstractC0637o8 {

    /* renamed from: s */
    public final /* synthetic */ int f545s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0535e6(AbstractC0488a aVar, int i, int i2) {
        super(aVar, i);
        this.f545s = i2;
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: N0 */
    public Spliterator mo160N0(AbstractC0488a aVar, Spliterator spliterator) {
        switch (this.f545s) {
            case 1:
                if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
                    return mo161M0(aVar, spliterator, new C0541f2(16)).mo904spliterator();
                }
                return new C0697u8((AbstractC0757y0) aVar.mo138G0(spliterator), 1);
            case 2:
                if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
                    return mo161M0(aVar, spliterator, new C0541f2(17)).mo904spliterator();
                }
                return new C0697u8((AbstractC0757y0) aVar.mo138G0(spliterator), 0);
            default:
                return super.mo160N0(aVar, spliterator);
        }
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: M0 */
    public final AbstractC0531e2 mo161M0(AbstractC0692u3 u3Var, Spliterator spliterator, IntFunction intFunction) {
        switch (this.f545s) {
            case 0:
                if (EnumC0725x6.SORTED.m66l(((AbstractC0488a) u3Var).f481m)) {
                    return u3Var.mo106k0(spliterator, false, intFunction);
                }
                long[] jArr = (long[]) ((AbstractC0511c2) u3Var.mo106k0(spliterator, true, intFunction)).mo79b();
                Arrays.sort(jArr);
                return new C0582j3(jArr);
            case 1:
                return (AbstractC0531e2) new C0667r8(this, u3Var, spliterator, intFunction).invoke();
            default:
                return (AbstractC0531e2) new C0657q8(this, u3Var, spliterator, intFunction).invoke();
        }
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        switch (this.f545s) {
            case 0:
                Objects.requireNonNull(k5Var);
                if (EnumC0725x6.SORTED.m66l(i)) {
                    return k5Var;
                }
                return EnumC0725x6.SIZED.m66l(i) ? new AbstractC0544f5(k5Var) : new AbstractC0544f5(k5Var);
            case 1:
                return new C0597k8(this, k5Var);
            default:
                return new C0607l8(this, k5Var, false);
        }
    }

    @Override // p004j$.util.stream.AbstractC0637o8
    /* renamed from: i */
    public AbstractC0647p8 mo169i(AbstractC0710w1 w1Var, boolean z) {
        return new C0607l8(this, w1Var, z);
    }
}
