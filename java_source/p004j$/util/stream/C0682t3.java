package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
/* renamed from: j$.util.stream.t3 */
/* loaded from: classes2.dex */
public class C0682t3 extends CountedCompleter {

    /* renamed from: a */
    public final AbstractC0531e2 f761a;

    /* renamed from: b */
    public final int f762b;

    /* renamed from: c */
    public final /* synthetic */ int f763c;

    /* renamed from: d */
    public final Object f764d;

    public C0682t3(AbstractC0531e2 e2Var, Object obj, int i) {
        this.f763c = i;
        this.f761a = e2Var;
        this.f762b = 0;
        this.f764d = obj;
    }

    public C0682t3(C0682t3 t3Var, AbstractC0531e2 e2Var, int i, byte b) {
        super(t3Var);
        this.f761a = e2Var;
        this.f762b = i;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        C0682t3 t3Var = this;
        while (t3Var.f761a.mo58o() != 0) {
            t3Var.setPendingCount(t3Var.f761a.mo58o() - 1);
            int i = 0;
            int i2 = 0;
            while (i < t3Var.f761a.mo58o() - 1) {
                C0682t3 a = t3Var.m155a(i, t3Var.f762b + i2);
                i2 = (int) (a.f761a.count() + i2);
                a.fork();
                i++;
            }
            t3Var = t3Var.m155a(i, t3Var.f762b + i2);
        }
        switch (t3Var.f763c) {
            case 0:
                ((AbstractC0521d2) t3Var.f761a).mo154f(t3Var.f762b, t3Var.f764d);
                break;
            default:
                t3Var.f761a.mo70k((Object[]) t3Var.f764d, t3Var.f762b);
                break;
        }
        t3Var.propagateCompletion();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0682t3(C0682t3 t3Var, AbstractC0531e2 e2Var, int i) {
        this(t3Var, e2Var, i, (byte) 0);
        this.f763c = 1;
        this.f764d = (Object[]) t3Var.f764d;
    }

    /* renamed from: a */
    public final C0682t3 m155a(int i, int i2) {
        switch (this.f763c) {
            case 0:
                return new C0682t3(this, ((AbstractC0521d2) this.f761a).mo63a(i), i2);
            default:
                return new C0682t3(this, this.f761a.mo63a(i), i2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0682t3(C0682t3 t3Var, AbstractC0521d2 d2Var, int i) {
        this(t3Var, d2Var, i, (byte) 0);
        this.f763c = 0;
        this.f764d = t3Var.f764d;
    }
}
