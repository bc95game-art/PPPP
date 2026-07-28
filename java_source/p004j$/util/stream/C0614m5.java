package p004j$.util.stream;

import java.util.function.IntFunction;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.m5 */
/* loaded from: classes2.dex */
public final class C0614m5 extends AbstractC0494a5 {

    /* renamed from: s */
    public final /* synthetic */ long f661s;

    /* renamed from: t */
    public final /* synthetic */ long f662t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0614m5(AbstractC0514c5 c5Var, int i, long j, long j2) {
        super(c5Var, i);
        this.f661s = j;
        this.f662t = j2;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [j$.util.Spliterator, j$.util.stream.z7] */
    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: N0 */
    public final Spliterator mo160N0(AbstractC0488a aVar, Spliterator spliterator) {
        long l0 = aVar.mo105l0(spliterator);
        if (l0 > 0 && spliterator.hasCharacteristics(16384)) {
            Spliterator G0 = aVar.mo138G0(spliterator);
            long j = this.f661s;
            return new C0666r7(G0, j, AbstractC0692u3.m118a0(j, this.f662t));
        } else if (EnumC0725x6.ORDERED.m66l(aVar.f481m)) {
            return ((AbstractC0531e2) new C0694u5(this, aVar, spliterator, new C0541f2(0), this.f661s, this.f662t).invoke()).mo904spliterator();
        } else {
            Spliterator G02 = aVar.mo138G0(spliterator);
            long j2 = this.f661s;
            long j3 = this.f662t;
            if (j2 <= l0) {
                long j4 = l0 - j2;
                if (j3 >= 0) {
                    j4 = Math.min(j3, j4);
                }
                j3 = j4;
                j2 = 0;
            }
            return new AbstractC0745z7(G02, j2, j3);
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
            return AbstractC0692u3.m117b0(u3Var, AbstractC0692u3.m120Y(aVar.mo41L0(), spliterator, this.f661s, this.f662t), true, intFunction);
        } else if (EnumC0725x6.ORDERED.m66l(((AbstractC0488a) u3Var).f481m)) {
            return (AbstractC0531e2) new C0694u5(this, u3Var, spliterator, intFunction, this.f661s, this.f662t).invoke();
        } else {
            Spliterator G0 = u3Var.mo138G0(spliterator);
            long j3 = this.f661s;
            long j4 = this.f662t;
            if (j3 <= l0) {
                long j5 = l0 - j3;
                j = j4 >= 0 ? Math.min(j4, j5) : j5;
                j2 = 0;
            } else {
                j = j4;
                j2 = j3;
            }
            return AbstractC0692u3.m117b0(this, new AbstractC0745z7(G0, j2, j), true, intFunction);
        }
    }

    @Override // p004j$.util.stream.AbstractC0488a
    /* renamed from: P0 */
    public final AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var) {
        return new C0604l5(this, k5Var);
    }
}
