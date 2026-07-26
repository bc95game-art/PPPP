package p004j$.util.stream;

import java.util.function.IntFunction;
import p004j$.util.AbstractC0751v0;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.o5 */
/* loaded from: classes2.dex */
public final class C0634o5 extends AbstractC0719x0 {

    /* renamed from: s */
    public final /* synthetic */ long f682s;

    /* renamed from: t */
    public final /* synthetic */ long f683t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0634o5(AbstractC0738z0 z0Var, int i, long j, long j2) {
        super(z0Var, i);
        this.f682s = j;
        this.f683t = j2;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [j$.util.Spliterator, j$.util.stream.z7] */
    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: N0 */
    public final Spliterator mo160N0(AbstractC0488a aVar, Spliterator spliterator) {
        long l0 = aVar.mo105l0(spliterator);
        if (l0 > 0 && spliterator.hasCharacteristics(16384)) {
            long j = this.f682s;
            return new AbstractC0656q7((AbstractC0751v0) aVar.mo138G0(spliterator), j, AbstractC0692u3.m118a0(j, this.f683t));
        } else if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
            return ((AbstractC0531e2) new C0694u5(this, aVar, spliterator, new C0541f2(9), this.f682s, this.f683t).invoke()).mo904spliterator();
        } else {
            AbstractC0751v0 v0Var = (AbstractC0751v0) aVar.mo138G0(spliterator);
            long j2 = this.f682s;
            long j3 = this.f683t;
            if (j2 <= l0) {
                long j4 = l0 - j2;
                if (j3 >= 0) {
                    j4 = Math.min(j3, j4);
                }
                j3 = j4;
                j2 = 0;
            }
            return new AbstractC0745z7(v0Var, j2, j3);
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [j$.util.Spliterator, j$.util.stream.z7] */
    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: M0 */
    public final AbstractC0531e2 mo161M0(AbstractC0692u3 u3Var, Spliterator spliterator, IntFunction intFunction) {
        long j;
        long j2;
        long l0 = u3Var.mo105l0(spliterator);
        if (l0 > 0 && spliterator.hasCharacteristics(16384)) {
            AbstractC0488a aVar = (AbstractC0488a) u3Var;
            while (aVar.f480l > 0) {
                aVar = aVar.f477i;
            }
            return AbstractC0692u3.m115d0(u3Var, AbstractC0692u3.m120Y(aVar.mo41L0(), spliterator, this.f682s, this.f683t), true);
        } else if (EnumC0725x6.ORDERED.m66l(((AbstractC0488a) u3Var).f481m)) {
            return (AbstractC0531e2) new C0694u5(this, u3Var, spliterator, intFunction, this.f682s, this.f683t).invoke();
        } else {
            AbstractC0751v0 v0Var = (AbstractC0751v0) u3Var.mo138G0(spliterator);
            long j3 = this.f682s;
            long j4 = this.f683t;
            if (j3 <= l0) {
                long j5 = l0 - j3;
                j = j4 >= 0 ? Math.min(j4, j5) : j5;
                j2 = 0;
            } else {
                j = j4;
                j2 = j3;
            }
            return AbstractC0692u3.m115d0(this, new AbstractC0745z7(v0Var, j2, j), true);
        }
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        return new C0624n5(this, k5Var);
    }
}
