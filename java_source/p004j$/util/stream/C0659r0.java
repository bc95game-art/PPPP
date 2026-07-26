package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.r0 */
/* loaded from: classes2.dex */
public final class C0659r0 extends CountedCompleter {

    /* renamed from: a */
    public Spliterator f719a;

    /* renamed from: b */
    public final AbstractC0594k5 f720b;

    /* renamed from: c */
    public final AbstractC0692u3 f721c;

    /* renamed from: d */
    public long f722d;

    public C0659r0(AbstractC0692u3 u3Var, Spliterator spliterator, AbstractC0594k5 k5Var) {
        super(null);
        this.f720b = k5Var;
        this.f721c = u3Var;
        this.f719a = spliterator;
        this.f722d = 0L;
    }

    public C0659r0(C0659r0 r0Var, Spliterator spliterator) {
        super(r0Var);
        this.f719a = spliterator;
        this.f720b = r0Var.f720b;
        this.f722d = r0Var.f722d;
        this.f721c = r0Var.f721c;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f719a;
        long estimateSize = spliterator.estimateSize();
        long j = this.f722d;
        if (j == 0) {
            j = AbstractC0518d.m212e(estimateSize);
            this.f722d = j;
        }
        boolean l = EnumC0725x6.SHORT_CIRCUIT.m66l(((AbstractC0488a) this.f721c).f481m);
        AbstractC0594k5 k5Var = this.f720b;
        boolean z = false;
        C0659r0 r0Var = this;
        while (true) {
            if (l && k5Var.mo27e()) {
                break;
            } else if (estimateSize <= j || (trySplit = spliterator.mo899trySplit()) == null) {
                break;
            } else {
                C0659r0 r0Var2 = new C0659r0(r0Var, trySplit);
                r0Var.addToPendingCount(1);
                if (z) {
                    spliterator = trySplit;
                } else {
                    r0Var2 = r0Var;
                    r0Var = r0Var2;
                }
                z = !z;
                r0Var.fork();
                r0Var = r0Var2;
                estimateSize = spliterator.estimateSize();
            }
        }
        r0Var.f721c.mo111g0(spliterator, k5Var);
        r0Var.f719a = null;
        r0Var.propagateCompletion();
    }
}
