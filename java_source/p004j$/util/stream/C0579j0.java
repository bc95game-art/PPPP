package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.j0 */
/* loaded from: classes2.dex */
public final class C0579j0 extends AbstractC0498b {

    /* renamed from: j */
    public final C0509c0 f609j;

    /* renamed from: k */
    public final boolean f610k;

    public C0579j0(C0509c0 c0Var, boolean z, AbstractC0488a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.f610k = z;
        this.f609j = c0Var;
    }

    public C0579j0(C0579j0 j0Var, Spliterator spliterator) {
        super(j0Var, spliterator);
        this.f610k = j0Var.f610k;
        this.f609j = j0Var.f609j;
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: c */
    public final AbstractC0518d mo76c(Spliterator spliterator) {
        return new C0579j0(this, spliterator);
    }

    @Override // p004j$.util.stream.AbstractC0498b
    /* renamed from: h */
    public final Object mo88h() {
        return this.f609j.f510b;
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: a */
    public final Object mo77a() {
        AbstractC0692u3 u3Var = this.f524a;
        AbstractC0537e8 e8Var = (AbstractC0537e8) this.f609j.f512d.get();
        u3Var.mo142E0(this.f525b, e8Var);
        Object obj = e8Var.get();
        if (!this.f610k) {
            if (obj != null) {
                AtomicReference atomicReference = this.f499h;
                while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
                }
            }
        } else if (obj != null) {
            AbstractC0518d dVar = this;
            while (dVar != null) {
                AbstractC0518d dVar2 = (AbstractC0518d) dVar.getCompleter();
                if (dVar2 == null || dVar2.f527d == dVar) {
                    dVar = dVar2;
                } else {
                    m217g();
                    return obj;
                }
            }
            AtomicReference atomicReference2 = this.f499h;
            while (!atomicReference2.compareAndSet(null, obj) && atomicReference2.get() == null) {
            }
            return obj;
        }
        return null;
    }

    @Override // p004j$.util.stream.AbstractC0518d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        if (this.f610k) {
            C0579j0 j0Var = (C0579j0) this.f527d;
            C0579j0 j0Var2 = null;
            while (true) {
                if (j0Var != j0Var2) {
                    Object i = j0Var.m216i();
                    if (i != null && this.f609j.f511c.test(i)) {
                        mo213d(i);
                        AbstractC0518d dVar = this;
                        while (true) {
                            if (dVar != null) {
                                AbstractC0518d dVar2 = (AbstractC0518d) dVar.getCompleter();
                                if (dVar2 != null && dVar2.f527d != dVar) {
                                    m217g();
                                    break;
                                }
                                dVar = dVar2;
                            } else {
                                AtomicReference atomicReference = this.f499h;
                                while (!atomicReference.compareAndSet(null, i) && atomicReference.get() == null) {
                                }
                            }
                        }
                    } else {
                        j0Var = (C0579j0) this.f528e;
                        j0Var2 = j0Var;
                    }
                } else {
                    break;
                }
            }
        }
        super.onCompletion(countedCompleter);
    }
}
