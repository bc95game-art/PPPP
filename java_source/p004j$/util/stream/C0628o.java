package p004j$.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
/* renamed from: j$.util.stream.o */
/* loaded from: classes2.dex */
public final class C0628o extends AbstractC0524d5 {

    /* renamed from: b */
    public final /* synthetic */ int f675b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC0488a f676c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0628o(AbstractC0488a aVar, AbstractC0594k5 k5Var, int i) {
        super(k5Var);
        this.f675b = i;
        this.f676c = aVar;
    }

    @Override // p004j$.util.stream.AbstractC0524d5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public void mo23c(long j) {
        switch (this.f675b) {
            case 4:
                this.f536a.mo23c(-1L);
                return;
            default:
                super.mo23c(j);
                return;
        }
    }

    @Override // p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        switch (this.f675b) {
            case 0:
                this.f536a.accept((AbstractC0594k5) ((DoubleFunction) ((C0638p) this.f676c).f686t).apply(d));
                return;
            case 1:
                ((C0648q) this.f676c).getClass();
                DoubleUnaryOperator doubleUnaryOperator = null;
                doubleUnaryOperator.applyAsDouble(d);
                throw null;
            case 2:
                ((C0658r) this.f676c).getClass();
                DoubleToIntFunction doubleToIntFunction = null;
                doubleToIntFunction.applyAsInt(d);
                throw null;
            case 3:
                ((C0668s) this.f676c).getClass();
                DoubleToLongFunction doubleToLongFunction = null;
                doubleToLongFunction.applyAsLong(d);
                throw null;
            case 4:
                ((C0648q) this.f676c).getClass();
                DoublePredicate doublePredicate = null;
                doublePredicate.test(d);
                throw null;
            default:
                ((DoubleConsumer) ((C0688u) this.f676c).f772t).accept(d);
                this.f536a.accept(d);
                return;
        }
    }
}
