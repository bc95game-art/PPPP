package p004j$.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import p004j$.util.AbstractC0487s0;
import p004j$.util.AbstractC0751v0;
import p004j$.util.AbstractC0757y0;
import p004j$.util.C0407c0;
import p004j$.util.C0451g0;
import p004j$.util.C0463k0;
import p004j$.util.C0471n;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.x4 */
/* loaded from: classes2.dex */
public final class C0723x4 extends AbstractC0554g5 {

    /* renamed from: b */
    public final /* synthetic */ int f818b = 0;

    /* renamed from: c */
    public boolean f819c;

    /* renamed from: d */
    public final Object f820d;

    /* renamed from: e */
    public final /* synthetic */ AbstractC0488a f821e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0723x4(C0679t0 t0Var, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f821e = t0Var;
        AbstractC0594k5 k5Var2 = this.f566a;
        Objects.requireNonNull(k5Var2);
        this.f820d = new C0451g0(k5Var2, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0723x4(C0688u uVar, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f821e = uVar;
        AbstractC0594k5 k5Var2 = this.f566a;
        Objects.requireNonNull(k5Var2);
        this.f820d = new C0407c0(k5Var2, 1);
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        switch (this.f818b) {
            case 0:
                this.f566a.mo23c(-1L);
                return;
            case 1:
                this.f566a.mo23c(-1L);
                return;
            default:
                this.f566a.mo23c(-1L);
                return;
        }
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        AbstractC0499b0 b0Var;
        switch (this.f818b) {
            case 0:
                C0463k0 k0Var = (C0463k0) this.f820d;
                b0Var = (AbstractC0590k1) ((C0471n) ((C0520d1) this.f821e).f533t).apply((C0471n) obj);
                if (b0Var != null) {
                    try {
                        if (!this.f819c) {
                            b0Var.sequential().forEach(k0Var);
                        } else {
                            AbstractC0757y0 spliterator = b0Var.sequential().spliterator();
                            while (!this.f566a.mo27e() && spliterator.tryAdvance((LongConsumer) k0Var)) {
                            }
                        }
                    } finally {
                        try {
                            b0Var.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                    }
                }
                if (b0Var != null) {
                    b0Var.close();
                    return;
                }
                return;
            case 1:
                C0451g0 g0Var = (C0451g0) this.f820d;
                b0Var = (IntStream) ((C0471n) ((C0679t0) this.f821e).f760t).apply((C0471n) obj);
                if (b0Var != null) {
                    try {
                        if (!this.f819c) {
                            b0Var.sequential().forEach(g0Var);
                        } else {
                            AbstractC0751v0 spliterator2 = b0Var.sequential().spliterator();
                            while (!this.f566a.mo27e() && spliterator2.tryAdvance((IntConsumer) g0Var)) {
                            }
                        }
                    } finally {
                    }
                }
                if (b0Var != null) {
                    b0Var.close();
                    return;
                }
                return;
            default:
                C0407c0 c0Var = (C0407c0) this.f820d;
                b0Var = (AbstractC0499b0) ((C0471n) ((C0688u) this.f821e).f772t).apply((C0471n) obj);
                if (b0Var != null) {
                    try {
                        if (!this.f819c) {
                            b0Var.sequential().forEach(c0Var);
                        } else {
                            AbstractC0487s0 spliterator3 = b0Var.sequential().spliterator();
                            while (!this.f566a.mo27e() && spliterator3.tryAdvance((DoubleConsumer) c0Var)) {
                            }
                        }
                    } finally {
                    }
                }
                if (b0Var != null) {
                    b0Var.close();
                    return;
                }
                return;
        }
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        switch (this.f818b) {
            case 0:
                this.f819c = true;
                return this.f566a.mo27e();
            case 1:
                this.f819c = true;
                return this.f566a.mo27e();
            default:
                this.f819c = true;
                return this.f566a.mo27e();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0723x4(C0520d1 d1Var, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f821e = d1Var;
        AbstractC0594k5 k5Var2 = this.f566a;
        Objects.requireNonNull(k5Var2);
        this.f820d = new C0463k0(k5Var2, 1);
    }
}
