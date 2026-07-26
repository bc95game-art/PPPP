package p004j$.util.stream;
/* renamed from: j$.util.stream.h2 */
/* loaded from: classes2.dex */
public abstract class AbstractC0561h2 implements AbstractC0531e2 {

    /* renamed from: a */
    public final AbstractC0531e2 f577a;

    /* renamed from: b */
    public final AbstractC0531e2 f578b;

    /* renamed from: c */
    public final long f579c;

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: o */
    public final int mo58o() {
        return 2;
    }

    public AbstractC0561h2(AbstractC0531e2 e2Var, AbstractC0531e2 e2Var2) {
        this.f577a = e2Var;
        this.f578b = e2Var2;
        this.f579c = e2Var2.count() + e2Var.count();
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    /* renamed from: a */
    public final AbstractC0531e2 mo63a(int i) {
        if (i == 0) {
            return this.f577a;
        }
        if (i == 1) {
            return this.f578b;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // p004j$.util.stream.AbstractC0531e2
    public final long count() {
        return this.f579c;
    }
}
