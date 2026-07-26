package p004j$.util.stream;
/* renamed from: j$.util.stream.p5 */
/* loaded from: classes2.dex */
public final class C0644p5 extends AbstractC0544f5 {

    /* renamed from: b */
    public long f689b;

    /* renamed from: c */
    public long f690c;

    /* renamed from: d */
    public final /* synthetic */ C0654q5 f691d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0644p5(C0654q5 q5Var, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f691d = q5Var;
        this.f689b = q5Var.f710s;
        long j = q5Var.f711t;
        this.f690c = j < 0 ? Long.MAX_VALUE : j;
    }

    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f554a.mo23c(AbstractC0692u3.m121X(j, this.f691d.f710s, this.f690c));
    }

    @Override // p004j$.util.stream.AbstractC0584j5, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        long j2 = this.f689b;
        if (j2 == 0) {
            long j3 = this.f690c;
            if (j3 > 0) {
                this.f690c = j3 - 1;
                this.f554a.accept(j);
                return;
            }
            return;
        }
        this.f689b = j2 - 1;
    }

    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        return this.f690c == 0 || this.f554a.mo27e();
    }
}
