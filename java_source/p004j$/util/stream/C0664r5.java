package p004j$.util.stream;
/* renamed from: j$.util.stream.r5 */
/* loaded from: classes2.dex */
public final class C0664r5 extends AbstractC0524d5 {

    /* renamed from: b */
    public long f728b;

    /* renamed from: c */
    public long f729c;

    /* renamed from: d */
    public final /* synthetic */ C0674s5 f730d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0664r5(C0674s5 s5Var, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f730d = s5Var;
        this.f728b = s5Var.f741s;
        long j = s5Var.f742t;
        this.f729c = j < 0 ? Long.MAX_VALUE : j;
    }

    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f536a.mo23c(AbstractC0692u3.m121X(j, this.f730d.f741s, this.f729c));
    }

    @Override // p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        long j = this.f728b;
        if (j == 0) {
            long j2 = this.f729c;
            if (j2 > 0) {
                this.f729c = j2 - 1;
                this.f536a.accept(d);
                return;
            }
            return;
        }
        this.f728b = j - 1;
    }

    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        return this.f729c == 0 || this.f536a.mo27e();
    }
}
