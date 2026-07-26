package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.w4 */
/* loaded from: classes2.dex */
public final class C0713w4 extends AbstractC0518d {

    /* renamed from: h */
    public final AbstractC0692u3 f807h;

    @Override // p004j$.util.stream.AbstractC0518d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        AbstractC0518d dVar = this.f527d;
        if (dVar != null) {
            AbstractC0643p4 p4Var = (AbstractC0643p4) ((C0713w4) dVar).f529f;
            p4Var.mo57i((AbstractC0643p4) ((C0713w4) this.f528e).f529f);
            this.f529f = p4Var;
        }
        super.onCompletion(countedCompleter);
    }

    public C0713w4(AbstractC0692u3 u3Var, AbstractC0692u3 u3Var2, Spliterator spliterator) {
        super(u3Var2, spliterator);
        this.f807h = u3Var;
    }

    public C0713w4(C0713w4 w4Var, Spliterator spliterator) {
        super(w4Var, spliterator);
        this.f807h = w4Var.f807h;
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: c */
    public final AbstractC0518d mo76c(Spliterator spliterator) {
        return new C0713w4(this, spliterator);
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: a */
    public final Object mo77a() {
        AbstractC0692u3 u3Var = this.f524a;
        AbstractC0643p4 D0 = this.f807h.mo26D0();
        u3Var.mo142E0(this.f525b, D0);
        return D0;
    }
}
