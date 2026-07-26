package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.q8 */
/* loaded from: classes2.dex */
public final class C0657q8 extends AbstractC0518d {

    /* renamed from: h */
    public final AbstractC0488a f713h;

    /* renamed from: i */
    public final IntFunction f714i;

    /* renamed from: j */
    public final boolean f715j;

    /* renamed from: k */
    public long f716k;

    /* renamed from: l */
    public long f717l;

    @Override // p004j$.util.stream.AbstractC0518d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        AbstractC0531e2 f0;
        AbstractC0518d dVar = this.f527d;
        if (dVar != null) {
            if (this.f715j) {
                C0657q8 q8Var = (C0657q8) dVar;
                long j = q8Var.f717l;
                this.f717l = j;
                if (j == q8Var.f716k) {
                    this.f717l = j + ((C0657q8) this.f528e).f717l;
                }
            }
            C0657q8 q8Var2 = (C0657q8) dVar;
            long j2 = q8Var2.f716k;
            C0657q8 q8Var3 = (C0657q8) this.f528e;
            this.f716k = j2 + q8Var3.f716k;
            if (q8Var2.f716k == 0) {
                f0 = (AbstractC0531e2) q8Var3.f529f;
            } else if (q8Var3.f716k == 0) {
                f0 = (AbstractC0531e2) q8Var2.f529f;
            } else {
                f0 = AbstractC0692u3.m112f0(this.f713h.mo41L0(), (AbstractC0531e2) ((C0657q8) this.f527d).f529f, (AbstractC0531e2) ((C0657q8) this.f528e).f529f);
            }
            AbstractC0531e2 e2Var = f0;
            if (m214b() && this.f715j) {
                e2Var = e2Var.mo60j(this.f717l, e2Var.count(), this.f714i);
            }
            this.f529f = e2Var;
        }
        super.onCompletion(countedCompleter);
    }

    public C0657q8(AbstractC0488a aVar, AbstractC0692u3 u3Var, Spliterator spliterator, IntFunction intFunction) {
        super(u3Var, spliterator);
        this.f713h = aVar;
        this.f714i = intFunction;
        this.f715j = EnumC0725x6.ORDERED.m66l(((AbstractC0488a) u3Var).f481m);
    }

    public C0657q8(C0657q8 q8Var, Spliterator spliterator) {
        super(q8Var, spliterator);
        this.f713h = q8Var.f713h;
        this.f714i = q8Var.f714i;
        this.f715j = q8Var.f715j;
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: c */
    public final AbstractC0518d mo76c(Spliterator spliterator) {
        return new C0657q8(this, spliterator);
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: a */
    public final Object mo77a() {
        long j;
        boolean b = m214b();
        if (!b && this.f715j) {
            EnumC0725x6 x6Var = EnumC0725x6.SIZED;
            AbstractC0488a aVar = this.f713h;
            int i = aVar.f478j;
            int i2 = x6Var.f844e;
            if ((i & i2) == i2) {
                j = aVar.mo105l0(this.f525b);
                AbstractC0710w1 A0 = this.f524a.mo44A0(j, this.f714i);
                AbstractC0647p8 i3 = ((AbstractC0637o8) this.f713h).mo169i(A0, !this.f715j && !b);
                this.f524a.mo142E0(this.f525b, i3);
                AbstractC0531e2 build = A0.mo903build();
                this.f716k = build.count();
                this.f717l = i3.mo166h();
                return build;
            }
        }
        j = -1;
        AbstractC0710w1 A02 = this.f524a.mo44A0(j, this.f714i);
        AbstractC0647p8 i32 = ((AbstractC0637o8) this.f713h).mo169i(A02, !this.f715j && !b);
        this.f524a.mo142E0(this.f525b, i32);
        AbstractC0531e2 build2 = A02.mo903build();
        this.f716k = build2.count();
        this.f717l = i32.mo166h();
        return build2;
    }
}
