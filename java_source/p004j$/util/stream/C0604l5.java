package p004j$.util.stream;
/* renamed from: j$.util.stream.l5 */
/* loaded from: classes2.dex */
public final class C0604l5 extends AbstractC0554g5 {

    /* renamed from: b */
    public long f643b;

    /* renamed from: c */
    public long f644c;

    /* renamed from: d */
    public final /* synthetic */ C0614m5 f645d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0604l5(C0614m5 m5Var, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f645d = m5Var;
        this.f643b = m5Var.f661s;
        long j = m5Var.f662t;
        this.f644c = j < 0 ? Long.MAX_VALUE : j;
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f566a.mo23c(AbstractC0692u3.m121X(j, this.f645d.f661s, this.f644c));
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        long j = this.f643b;
        if (j == 0) {
            long j2 = this.f644c;
            if (j2 > 0) {
                this.f644c = j2 - 1;
                this.f566a.accept((AbstractC0594k5) obj);
                return;
            }
            return;
        }
        this.f643b = j - 1;
    }

    @Override // p004j$.util.stream.AbstractC0554g5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        return this.f644c == 0 || this.f566a.mo27e();
    }
}
