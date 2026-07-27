package p004j$.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
/* renamed from: j$.util.stream.s0 */
/* loaded from: classes2.dex */
public final class C0669s0 extends AbstractC0534e5 {

    /* renamed from: b */
    public final /* synthetic */ int f738b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC0488a f739c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0669s0(AbstractC0488a aVar, AbstractC0594k5 k5Var, int i) {
        super(k5Var);
        this.f738b = i;
        this.f739c = aVar;
    }

    @Override // p004j$.util.stream.AbstractC0534e5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public void mo23c(long j) {
        switch (this.f738b) {
            case 5:
                this.f544a.mo23c(-1L);
                return;
            default:
                super.mo23c(j);
                return;
        }
    }

    @Override // p004j$.util.stream.AbstractC0574i5, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        switch (this.f738b) {
            case 0:
                this.f544a.accept((AbstractC0594k5) ((IntFunction) ((C0638p) this.f739c).f686t).apply(i));
                return;
            case 1:
                ((IntConsumer) ((C0679t0) this.f739c).f760t).accept(i);
                this.f544a.accept(i);
                return;
            case 2:
                ((C0658r) this.f739c).getClass();
                IntUnaryOperator intUnaryOperator = null;
                intUnaryOperator.applyAsInt(i);
                throw null;
            case 3:
                ((C0668s) this.f739c).getClass();
                IntToLongFunction intToLongFunction = null;
                intToLongFunction.applyAsLong(i);
                throw null;
            case 4:
                ((C0648q) this.f739c).getClass();
                IntToDoubleFunction intToDoubleFunction = null;
                intToDoubleFunction.applyAsDouble(i);
                throw null;
            default:
                ((C0658r) this.f739c).getClass();
                IntPredicate intPredicate = null;
                intPredicate.test(i);
                throw null;
        }
    }
}
