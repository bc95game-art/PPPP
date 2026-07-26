package p004j$.util.stream;

import java.util.function.IntFunction;
import p004j$.util.AbstractC0487s0;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.s5 */
/* loaded from: classes2.dex */
public final class C0674s5 extends AbstractC0708w {

    /* renamed from: s */
    public final /* synthetic */ long f741s;

    /* renamed from: t */
    public final /* synthetic */ long f742t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0674s5(AbstractC0728y yVar, int i, long j, long j2) {
        super(yVar, i);
        this.f741s = j;
        this.f742t = j2;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [j$.util.Spliterator, j$.util.stream.z7] */
    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: N0 */
    public final Spliterator mo160N0(AbstractC0488a aVar, Spliterator spliterator) {
        long l0 = aVar.mo105l0(spliterator);
        if (l0 > 0 && spliterator.hasCharacteristics(16384)) {
            long j = this.f741s;
            return new AbstractC0656q7((AbstractC0487s0) aVar.mo138G0(spliterator), j, AbstractC0692u3.m118a0(j, this.f742t));
        } else if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
            return ((AbstractC0531e2) new C0694u5(this, aVar, spliterator, new C0541f2(11), this.f741s, this.f742t).invoke()).mo904spliterator();
        } else {
            AbstractC0487s0 s0Var = (AbstractC0487s0) aVar.mo138G0(spliterator);
            long j2 = this.f741s;
            long j3 = this.f742t;
            if (j2 <= l0) {
                long j4 = l0 - j2;
                if (j3 >= 0) {
                    j4 = Math.min(j3, j4);
                }
                j3 = j4;
                j2 = 0;
            }
            return new AbstractC0745z7(s0Var, j2, j3);
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
            return AbstractC0692u3.m116c0(u3Var, AbstractC0692u3.m120Y(aVar.mo41L0(), spliterator, this.f741s, this.f742t), true);
        } else if (EnumC0725x6.ORDERED.m66l(((AbstractC0488a) u3Var).f481m)) {
            return (AbstractC0531e2) new C0694u5(this, u3Var, spliterator, intFunction, this.f741s, this.f742t).invoke();
        } else {
            AbstractC0487s0 s0Var = (AbstractC0487s0) u3Var.mo138G0(spliterator);
            long j3 = this.f741s;
            long j4 = this.f742t;
            if (j3 <= l0) {
                long j5 = l0 - j3;
                j = j4 >= 0 ? Math.min(j4, j5) : j5;
                j2 = 0;
            } else {
                j = j4;
                j2 = j3;
            }
            return AbstractC0692u3.m116c0(this, new AbstractC0745z7(s0Var, j2, j), true);
        }
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        return new C0664r5(this, k5Var);
    }
}
