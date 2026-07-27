package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.r8 */
/* loaded from: classes2.dex */
public final class C0667r8 extends AbstractC0498b {

    /* renamed from: j */
    public final AbstractC0488a f731j;

    /* renamed from: k */
    public final IntFunction f732k;

    /* renamed from: l */
    public final boolean f733l;

    /* renamed from: m */
    public long f734m;

    /* renamed from: n */
    public boolean f735n;

    /* renamed from: o */
    public volatile boolean f736o;

    @Override // p004j$.util.stream.AbstractC0498b
    /* renamed from: f */
    public final void mo89f() {
        this.f500i = true;
        if (this.f733l && this.f736o) {
            mo213d(AbstractC0692u3.m107j0(this.f731j.mo41L0()));
        }
    }

    @Override // p004j$.util.stream.AbstractC0518d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        Object obj;
        AbstractC0518d dVar = this.f527d;
        if (dVar != null) {
            this.f735n = ((C0667r8) dVar).f735n | ((C0667r8) this.f528e).f735n;
            if (!this.f733l || !this.f500i) {
                if (this.f733l) {
                    C0667r8 r8Var = (C0667r8) this.f527d;
                    if (r8Var.f735n) {
                        this.f734m = r8Var.f734m;
                        obj = (AbstractC0531e2) r8Var.m216i();
                    }
                }
                C0667r8 r8Var2 = (C0667r8) this.f527d;
                long j = r8Var2.f734m;
                C0667r8 r8Var3 = (C0667r8) this.f528e;
                this.f734m = j + r8Var3.f734m;
                if (r8Var2.f734m == 0) {
                    obj = (AbstractC0531e2) r8Var3.m216i();
                } else if (r8Var3.f734m == 0) {
                    obj = (AbstractC0531e2) r8Var2.m216i();
                } else {
                    obj = AbstractC0692u3.m112f0(this.f731j.mo41L0(), (AbstractC0531e2) ((C0667r8) this.f527d).m216i(), (AbstractC0531e2) ((C0667r8) this.f528e).m216i());
                }
            } else {
                this.f734m = 0L;
                obj = AbstractC0692u3.m107j0(this.f731j.mo41L0());
            }
            mo213d(obj);
        }
        this.f736o = true;
        super.onCompletion(countedCompleter);
    }

    public C0667r8(AbstractC0488a aVar, AbstractC0692u3 u3Var, Spliterator spliterator, IntFunction intFunction) {
        super(u3Var, spliterator);
        this.f731j = aVar;
        this.f732k = intFunction;
        this.f733l = EnumC0725x6.ORDERED.m66l(((AbstractC0488a) u3Var).f481m);
    }

    public C0667r8(C0667r8 r8Var, Spliterator spliterator) {
        super(r8Var, spliterator);
        this.f731j = r8Var.f731j;
        this.f732k = r8Var.f732k;
        this.f733l = r8Var.f733l;
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: c */
    public final AbstractC0518d mo76c(Spliterator spliterator) {
        return new C0667r8(this, spliterator);
    }

    @Override // p004j$.util.stream.AbstractC0498b
    /* renamed from: h */
    public final Object mo88h() {
        return AbstractC0692u3.m107j0(this.f731j.mo41L0());
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: a */
    public final Object mo77a() {
        AbstractC0710w1 A0 = this.f524a.mo44A0(-1L, this.f732k);
        AbstractC0594k5 P0 = this.f731j.mo24P0(((AbstractC0488a) this.f524a).f481m, A0);
        AbstractC0692u3 u3Var = this.f524a;
        boolean h0 = u3Var.mo110h0(this.f525b, u3Var.mo140F0(P0));
        this.f735n = h0;
        if (h0) {
            m217g();
        }
        AbstractC0531e2 build = A0.mo903build();
        this.f734m = build.count();
        return build;
    }
}
