package p004j$.util.stream;
/* renamed from: j$.util.stream.n5 */
/* loaded from: classes2.dex */
public final class C0624n5 extends AbstractC0534e5 {

    /* renamed from: b */
    public long f672b;

    /* renamed from: c */
    public long f673c;

    /* renamed from: d */
    public final /* synthetic */ C0634o5 f674d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0624n5(C0634o5 o5Var, AbstractC0594k5 k5Var) {
        super(k5Var);
        this.f674d = o5Var;
        this.f672b = o5Var.f682s;
        long j = o5Var.f683t;
        this.f673c = j < 0 ? Long.MAX_VALUE : j;
    }

    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f544a.mo23c(AbstractC0692u3.m121X(j, this.f674d.f682s, this.f673c));
    }

    @Override // p004j$.util.stream.AbstractC0574i5, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        long j = this.f672b;
        if (j == 0) {
            long j2 = this.f673c;
            if (j2 > 0) {
                this.f673c = j2 - 1;
                this.f544a.accept(i);
                return;
            }
            return;
        }
        this.f672b = j - 1;
    }

    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final boolean mo27e() {
        return this.f673c == 0 || this.f544a.mo27e();
    }
}
