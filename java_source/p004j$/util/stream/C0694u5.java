package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.u5 */
/* loaded from: classes2.dex */
public final class C0694u5 extends AbstractC0498b {

    /* renamed from: j */
    public final AbstractC0488a f781j;

    /* renamed from: k */
    public final IntFunction f782k;

    /* renamed from: l */
    public final long f783l;

    /* renamed from: m */
    public final long f784m;

    /* renamed from: n */
    public long f785n;

    /* renamed from: o */
    public volatile boolean f786o;

    @Override // p004j$.util.stream.AbstractC0498b
    /* renamed from: f */
    public final void mo89f() {
        this.f500i = true;
        if (this.f786o) {
            mo213d(AbstractC0692u3.m107j0(this.f781j.mo41L0()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e7, code lost:
        if (r2 >= r0) goto L46;
     */
    @Override // p004j$.util.stream.AbstractC0518d, java.util.concurrent.CountedCompleter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onCompletion(CountedCompleter countedCompleter) {
        C0694u5 u5Var;
        AbstractC0531e2 j0;
        AbstractC0518d dVar = this.f527d;
        if (dVar != null) {
            this.f785n = ((C0694u5) dVar).f785n + ((C0694u5) this.f528e).f785n;
            if (this.f500i) {
                this.f785n = 0L;
                j0 = AbstractC0692u3.m107j0(this.f781j.mo41L0());
            } else {
                j0 = this.f785n == 0 ? AbstractC0692u3.m107j0(this.f781j.mo41L0()) : ((C0694u5) this.f527d).f785n == 0 ? (AbstractC0531e2) ((C0694u5) this.f528e).m216i() : AbstractC0692u3.m112f0(this.f781j.mo41L0(), (AbstractC0531e2) ((C0694u5) this.f527d).m216i(), (AbstractC0531e2) ((C0694u5) this.f528e).m216i());
            }
            AbstractC0531e2 e2Var = j0;
            if (m214b()) {
                e2Var = e2Var.mo60j(this.f783l, this.f784m >= 0 ? Math.min(e2Var.count(), this.f783l + this.f784m) : this.f785n, this.f782k);
            }
            mo213d(e2Var);
            this.f786o = true;
        }
        if (this.f784m >= 0 && !m214b()) {
            long j = this.f783l + this.f784m;
            long j2 = this.f786o ? this.f785n : m87j(j);
            if (j2 < j) {
                C0694u5 u5Var2 = (C0694u5) ((AbstractC0518d) getCompleter());
                C0694u5 u5Var3 = this;
                while (true) {
                    if (u5Var2 != null) {
                        if (u5Var3 == u5Var2.f528e && (u5Var = (C0694u5) u5Var2.f527d) != null) {
                            long j3 = u5Var.m87j(j) + j2;
                            if (j3 >= j) {
                                break;
                            }
                            j2 = j3;
                        }
                        u5Var3 = u5Var2;
                        u5Var2 = (C0694u5) ((AbstractC0518d) u5Var2.getCompleter());
                    }
                }
            }
            m217g();
        }
        super.onCompletion(countedCompleter);
    }

    public C0694u5(AbstractC0488a aVar, AbstractC0692u3 u3Var, Spliterator spliterator, IntFunction intFunction, long j, long j2) {
        super(u3Var, spliterator);
        this.f781j = aVar;
        this.f782k = intFunction;
        this.f783l = j;
        this.f784m = j2;
    }

    public C0694u5(C0694u5 u5Var, Spliterator spliterator) {
        super(u5Var, spliterator);
        this.f781j = u5Var.f781j;
        this.f782k = u5Var.f782k;
        this.f783l = u5Var.f783l;
        this.f784m = u5Var.f784m;
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: c */
    public final AbstractC0518d mo76c(Spliterator spliterator) {
        return new C0694u5(this, spliterator);
    }

    @Override // p004j$.util.stream.AbstractC0498b
    /* renamed from: h */
    public final Object mo88h() {
        return AbstractC0692u3.m107j0(this.f781j.mo41L0());
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: a */
    public final Object mo77a() {
        long j = -1;
        if (m214b()) {
            EnumC0725x6 x6Var = EnumC0725x6.SIZED;
            AbstractC0488a aVar = this.f781j;
            int i = aVar.f478j;
            int i2 = x6Var.f844e;
            if ((i & i2) == i2) {
                j = aVar.mo105l0(this.f525b);
            }
            AbstractC0710w1 A0 = this.f781j.mo44A0(j, this.f782k);
            AbstractC0594k5 P0 = this.f781j.mo24P0(((AbstractC0488a) this.f524a).f481m, A0);
            AbstractC0692u3 u3Var = this.f524a;
            u3Var.mo110h0(this.f525b, u3Var.mo140F0(P0));
            return A0.mo903build();
        }
        AbstractC0710w1 A02 = this.f781j.mo44A0(-1L, this.f782k);
        if (this.f783l == 0) {
            AbstractC0594k5 P02 = this.f781j.mo24P0(((AbstractC0488a) this.f524a).f481m, A02);
            AbstractC0692u3 u3Var2 = this.f524a;
            u3Var2.mo110h0(this.f525b, u3Var2.mo140F0(P02));
        } else {
            this.f524a.mo142E0(this.f525b, A02);
        }
        AbstractC0531e2 build = A02.mo903build();
        this.f785n = build.count();
        this.f786o = true;
        this.f525b = null;
        return build;
    }

    /* renamed from: j */
    public final long m87j(long j) {
        if (this.f786o) {
            return this.f785n;
        }
        C0694u5 u5Var = (C0694u5) this.f527d;
        C0694u5 u5Var2 = (C0694u5) this.f528e;
        if (u5Var == null || u5Var2 == null) {
            return this.f785n;
        }
        long j2 = u5Var.m87j(j);
        return j2 >= j ? j2 : u5Var2.m87j(j) + j2;
    }
}
