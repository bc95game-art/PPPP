package p004j$.util.stream;

import java.util.function.DoubleConsumer;
import p004j$.util.AbstractC0487s0;
import p004j$.util.C0407c0;
import p004j$.util.C0471n;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.t */
/* loaded from: classes2.dex */
public final class C0678t extends AbstractC0524d5 {

    /* renamed from: b */
    public boolean f756b;

    /* renamed from: c */
    public final C0407c0 f757c;

    /* renamed from: d */
    public final /* synthetic */ C0688u f758d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0678t(C0688u uVar, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f758d = uVar;
        AbstractC0594k5 k5Var2 = this.f536a;
        Objects.requireNonNull(k5Var2);
        this.f757c = new C0407c0(k5Var2, 1);
    }

    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f536a.mo23c(-1L);
    }

    @Override // p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        AbstractC0499b0 b0Var = (AbstractC0499b0) ((C0471n) this.f758d.f772t).apply(d);
        if (b0Var != null) {
            try {
                boolean z = this.f756b;
                C0407c0 c0Var = this.f757c;
                if (!z) {
                    b0Var.sequential().forEach(c0Var);
                } else {
                    AbstractC0487s0 spliterator = b0Var.sequential().spliterator();
                    while (!this.f536a.mo27e() && spliterator.tryAdvance((DoubleConsumer) c0Var)) {
                    }
                }
            } catch (Throwable th) {
                try {
                    b0Var.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (b0Var != null) {
            b0Var.close();
        }
    }

    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        this.f756b = true;
        return this.f536a.mo27e();
    }
}
