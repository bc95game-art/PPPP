package p004j$.util.stream;

import java.util.function.LongConsumer;
import p004j$.util.AbstractC0757y0;
import p004j$.util.C0463k0;
import p004j$.util.C0471n;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.c1 */
/* loaded from: classes2.dex */
public final class C0510c1 extends AbstractC0544f5 {

    /* renamed from: b */
    public boolean f513b;

    /* renamed from: c */
    public final C0463k0 f514c;

    /* renamed from: d */
    public final /* synthetic */ C0520d1 f515d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0510c1(C0520d1 d1Var, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f515d = d1Var;
        AbstractC0594k5 k5Var2 = this.f554a;
        Objects.requireNonNull(k5Var2);
        this.f514c = new C0463k0(k5Var2, 1);
    }

    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f554a.mo23c(-1L);
    }

    @Override // p004j$.util.stream.AbstractC0584j5, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        AbstractC0590k1 k1Var = (AbstractC0590k1) ((C0471n) this.f515d.f533t).apply(j);
        if (k1Var != null) {
            try {
                boolean z = this.f513b;
                C0463k0 k0Var = this.f514c;
                if (!z) {
                    k1Var.sequential().forEach(k0Var);
                } else {
                    AbstractC0757y0 spliterator = k1Var.sequential().spliterator();
                    while (!this.f554a.mo27e() && spliterator.tryAdvance((LongConsumer) k0Var)) {
                    }
                }
            } catch (Throwable th) {
                try {
                    k1Var.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (k1Var != null) {
            k1Var.close();
        }
    }

    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        this.f513b = true;
        return this.f554a.mo27e();
    }
}
