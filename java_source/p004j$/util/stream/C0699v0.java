package p004j$.util.stream;

import java.util.function.IntConsumer;
import p004j$.util.AbstractC0751v0;
import p004j$.util.C0451g0;
import p004j$.util.Objects;
/* renamed from: j$.util.stream.v0 */
/* loaded from: classes2.dex */
public final class C0699v0 extends AbstractC0534e5 {

    /* renamed from: b */
    public boolean f792b;

    /* renamed from: c */
    public final C0451g0 f793c;

    /* renamed from: d */
    public final /* synthetic */ C0679t0 f794d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0699v0(C0679t0 t0Var, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f794d = t0Var;
        AbstractC0594k5 k5Var2 = this.f544a;
        Objects.requireNonNull(k5Var2);
        this.f793c = new C0451g0(k5Var2, 1);
    }

    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f544a.mo23c(-1L);
    }

    @Override // p004j$.util.stream.AbstractC0574i5, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        IntStream intStream = (IntStream) ((C0589k0) this.f794d.f760t).apply(i);
        if (intStream != null) {
            try {
                boolean z = this.f792b;
                C0451g0 g0Var = this.f793c;
                if (!z) {
                    intStream.sequential().forEach(g0Var);
                } else {
                    AbstractC0751v0 spliterator = intStream.sequential().spliterator();
                    while (!this.f544a.mo27e() && spliterator.tryAdvance((IntConsumer) g0Var)) {
                    }
                }
            } catch (Throwable th) {
                try {
                    intStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (intStream != null) {
            intStream.close();
        }
    }

    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        this.f792b = true;
        return this.f544a.mo27e();
    }
}
