package p004j$.util.stream;

import java.util.function.IntFunction;
import java.util.function.Supplier;
import p004j$.time.format.C0328b;
import p004j$.util.C0471n;
import p004j$.util.Objects;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.a */
/* loaded from: classes2.dex */
public abstract class AbstractC0488a extends AbstractC0692u3 implements AbstractC0548g {

    /* renamed from: h */
    public final AbstractC0488a f476h;

    /* renamed from: i */
    public final AbstractC0488a f477i;

    /* renamed from: j */
    public final int f478j;

    /* renamed from: k */
    public final AbstractC0488a f479k;

    /* renamed from: l */
    public int f480l;

    /* renamed from: m */
    public int f481m;

    /* renamed from: n */
    public Spliterator f482n;

    /* renamed from: o */
    public boolean f483o;

    /* renamed from: p */
    public final boolean f484p;

    /* renamed from: q */
    public Runnable f485q;

    /* renamed from: r */
    public boolean f486r;

    /* renamed from: J0 */
    public abstract AbstractC0531e2 mo43J0(AbstractC0488a aVar, Spliterator spliterator, boolean z, IntFunction intFunction);

    /* renamed from: K0 */
    public abstract boolean mo42K0(Spliterator spliterator, AbstractC0594k5 k5Var);

    /* renamed from: L0 */
    public abstract EnumC0735y6 mo41L0();

    /* renamed from: O0 */
    public abstract boolean mo25O0();

    /* renamed from: P0 */
    public abstract AbstractC0594k5 mo24P0(int i, AbstractC0594k5 k5Var);

    /* renamed from: S0 */
    public abstract Spliterator mo40S0(AbstractC0488a aVar, Supplier supplier, boolean z);

    public AbstractC0488a(Spliterator spliterator, int i, boolean z) {
        this.f477i = null;
        this.f482n = spliterator;
        this.f476h = this;
        int i2 = EnumC0725x6.f824g & i;
        this.f478j = i2;
        this.f481m = (~(i2 << 1)) & EnumC0725x6.f829l;
        this.f480l = 0;
        this.f486r = z;
    }

    public AbstractC0488a(AbstractC0488a aVar, int i) {
        if (!aVar.f483o) {
            aVar.f483o = true;
            aVar.f479k = this;
            this.f477i = aVar;
            this.f478j = EnumC0725x6.f825h & i;
            this.f481m = EnumC0725x6.m69i(i, aVar.f481m);
            AbstractC0488a aVar2 = aVar.f476h;
            this.f476h = aVar2;
            if (mo25O0()) {
                aVar2.f484p = true;
            }
            this.f480l = aVar.f480l + 1;
            return;
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    /* renamed from: H0 */
    public final Object m226H0(AbstractC0527d8 d8Var) {
        if (!this.f483o) {
            this.f483o = true;
            if (this.f476h.f486r) {
                return d8Var.mo108j(this, m224Q0(d8Var.mo94w()));
            }
            return d8Var.mo113f(this, m224Q0(d8Var.mo94w()));
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    /* renamed from: I0 */
    public final AbstractC0531e2 m225I0(IntFunction intFunction) {
        if (!this.f483o) {
            this.f483o = true;
            if (!this.f476h.f486r || this.f477i == null || !mo25O0()) {
                return mo106k0(m224Q0(0), true, intFunction);
            }
            this.f480l = 0;
            AbstractC0488a aVar = this.f477i;
            return mo161M0(aVar, aVar.m224Q0(0), intFunction);
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    /* renamed from: R0 */
    public final Spliterator m223R0() {
        AbstractC0488a aVar = this.f476h;
        if (this != aVar) {
            throw new IllegalStateException();
        } else if (!this.f483o) {
            this.f483o = true;
            Spliterator spliterator = aVar.f482n;
            if (spliterator != null) {
                aVar.f482n = null;
                return spliterator;
            }
            throw new IllegalStateException("source already consumed or closed");
        } else {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0548g sequential() {
        this.f476h.f486r = false;
        return this;
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0548g parallel() {
        this.f476h.f486r = true;
        return this;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.f483o = true;
        this.f482n = null;
        AbstractC0488a aVar = this.f476h;
        Runnable runnable = aVar.f485q;
        if (runnable != null) {
            aVar.f485q = null;
            runnable.run();
        }
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final AbstractC0548g onClose(Runnable runnable) {
        if (!this.f483o) {
            Objects.requireNonNull(runnable);
            AbstractC0488a aVar = this.f476h;
            Runnable runnable2 = aVar.f485q;
            if (runnable2 != null) {
                runnable = new RunnableC0517c8(runnable2, runnable);
            }
            aVar.f485q = runnable;
            return this;
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public Spliterator spliterator() {
        if (!this.f483o) {
            this.f483o = true;
            AbstractC0488a aVar = this.f476h;
            if (this != aVar) {
                return mo40S0(this, new C0471n(2, this), aVar.f486r);
            }
            Spliterator spliterator = aVar.f482n;
            if (spliterator != null) {
                aVar.f482n = null;
                return spliterator;
            }
            throw new IllegalStateException("source already consumed or closed");
        }
        throw new IllegalStateException("stream has already been operated upon or closed");
    }

    @Override // p004j$.util.stream.AbstractC0548g
    public final boolean isParallel() {
        return this.f476h.f486r;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: k0 */
    public final AbstractC0531e2 mo106k0(Spliterator spliterator, boolean z, IntFunction intFunction) {
        if (this.f476h.f486r) {
            return mo43J0(this, spliterator, z, intFunction);
        }
        AbstractC0710w1 A0 = mo44A0(mo105l0(spliterator), intFunction);
        mo142E0(spliterator, A0);
        return A0.mo903build();
    }

    /* renamed from: Q0 */
    public final Spliterator m224Q0(int i) {
        int i2;
        int i3;
        AbstractC0488a aVar = this.f476h;
        Spliterator spliterator = aVar.f482n;
        if (spliterator != null) {
            aVar.f482n = null;
            if (aVar.f486r && aVar.f484p) {
                AbstractC0488a aVar2 = aVar.f479k;
                int i4 = 1;
                while (aVar != this) {
                    int i5 = aVar2.f478j;
                    if (aVar2.mo25O0()) {
                        if (EnumC0725x6.SHORT_CIRCUIT.m66l(i5)) {
                            i5 &= ~EnumC0725x6.f838u;
                        }
                        spliterator = aVar2.mo160N0(aVar, spliterator);
                        if (spliterator.hasCharacteristics(64)) {
                            i2 = (~EnumC0725x6.f837t) & i5;
                            i3 = EnumC0725x6.f836s;
                        } else {
                            i2 = (~EnumC0725x6.f836s) & i5;
                            i3 = EnumC0725x6.f837t;
                        }
                        i5 = i2 | i3;
                        i4 = 0;
                    }
                    i4++;
                    aVar2.f480l = i4;
                    aVar2.f481m = EnumC0725x6.m69i(i5, aVar.f481m);
                    aVar = aVar2;
                    aVar2 = aVar2.f479k;
                }
            }
            if (i != 0) {
                this.f481m = EnumC0725x6.m69i(i, this.f481m);
            }
            return spliterator;
        }
        throw new IllegalStateException("source already consumed or closed");
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: l0 */
    public final long mo105l0(Spliterator spliterator) {
        if (EnumC0725x6.SIZED.m66l(this.f481m)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: E0 */
    public final AbstractC0594k5 mo142E0(Spliterator spliterator, AbstractC0594k5 k5Var) {
        mo111g0(spliterator, mo140F0((AbstractC0594k5) Objects.requireNonNull(k5Var)));
        return k5Var;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: g0 */
    public final void mo111g0(Spliterator spliterator, AbstractC0594k5 k5Var) {
        Objects.requireNonNull(k5Var);
        if (!EnumC0725x6.SHORT_CIRCUIT.m66l(this.f481m)) {
            k5Var.mo23c(spliterator.getExactSizeIfKnown());
            spliterator.forEachRemaining(k5Var);
            k5Var.end();
            return;
        }
        mo110h0(spliterator, k5Var);
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: h0 */
    public final boolean mo110h0(Spliterator spliterator, AbstractC0594k5 k5Var) {
        AbstractC0488a aVar = this;
        while (aVar.f480l > 0) {
            aVar = aVar.f477i;
        }
        k5Var.mo23c(spliterator.getExactSizeIfKnown());
        boolean K0 = aVar.mo42K0(spliterator, k5Var);
        k5Var.end();
        return K0;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: F0 */
    public final AbstractC0594k5 mo140F0(AbstractC0594k5 k5Var) {
        Objects.requireNonNull(k5Var);
        for (AbstractC0488a aVar = this; aVar.f480l > 0; aVar = aVar.f477i) {
            k5Var = aVar.mo24P0(aVar.f477i.f481m, k5Var);
        }
        return k5Var;
    }

    @Override // p004j$.util.stream.AbstractC0692u3
    /* renamed from: G0 */
    public final Spliterator mo138G0(Spliterator spliterator) {
        return this.f480l == 0 ? spliterator : mo40S0(this, new C0471n(3, spliterator), this.f476h.f486r);
    }

    /* renamed from: M0 */
    public AbstractC0531e2 mo161M0(AbstractC0692u3 u3Var, Spliterator spliterator, IntFunction intFunction) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    /* renamed from: N0 */
    public Spliterator mo160N0(AbstractC0488a aVar, Spliterator spliterator) {
        return mo161M0(aVar, spliterator, new C0328b(8)).mo904spliterator();
    }
}
