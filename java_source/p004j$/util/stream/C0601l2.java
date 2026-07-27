package p004j$.util.stream;

import java.util.concurrent.CountedCompleter;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.l2 */
/* loaded from: classes2.dex */
public class C0601l2 extends AbstractC0518d {

    /* renamed from: h */
    public final AbstractC0692u3 f637h;

    /* renamed from: i */
    public final LongFunction f638i;

    /* renamed from: j */
    public final BinaryOperator f639j;

    @Override // p004j$.util.stream.AbstractC0518d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        AbstractC0518d dVar = this.f527d;
        if (dVar != null) {
            this.f529f = (AbstractC0531e2) this.f639j.apply((AbstractC0531e2) ((C0601l2) dVar).f529f, (AbstractC0531e2) ((C0601l2) this.f528e).f529f);
        }
        super.onCompletion(countedCompleter);
    }

    public C0601l2(AbstractC0692u3 u3Var, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator) {
        super(u3Var, spliterator);
        this.f637h = u3Var;
        this.f638i = longFunction;
        this.f639j = binaryOperator;
    }

    public C0601l2(C0601l2 l2Var, Spliterator spliterator) {
        super(l2Var, spliterator);
        this.f637h = l2Var.f637h;
        this.f638i = l2Var.f638i;
        this.f639j = l2Var.f639j;
    }

    @Override // p004j$.util.stream.AbstractC0518d
    /* renamed from: c */
    public AbstractC0518d mo76c(Spliterator spliterator) {
        return new C0601l2(this, spliterator);
    }

    /* renamed from: f */
    public final AbstractC0531e2 mo77a() {
        AbstractC0710w1 w1Var = (AbstractC0710w1) this.f638i.apply(this.f637h.mo105l0(this.f525b));
        this.f637h.mo142E0(this.f525b, w1Var);
        return w1Var.mo903build();
    }
}
