package p004j$.util.stream;

import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
/* renamed from: j$.util.stream.a1 */
/* loaded from: classes2.dex */
public final class C0490a1 extends AbstractC0544f5 {

    /* renamed from: b */
    public final /* synthetic */ int f488b;

    /* renamed from: c */
    public final /* synthetic */ AbstractC0488a f489c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0490a1(AbstractC0488a aVar, AbstractC0594k5 k5Var, int i) {
        super(k5Var);
        this.f488b = i;
        this.f489c = aVar;
    }

    @Override // p004j$.util.stream.AbstractC0544f5, p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public void mo23c(long j) {
        switch (this.f488b) {
            case 4:
                this.f554a.mo23c(-1L);
                return;
            default:
                super.mo23c(j);
                return;
        }
    }

    @Override // p004j$.util.stream.AbstractC0584j5, p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final void accept(long j) {
        switch (this.f488b) {
            case 0:
                this.f554a.accept((AbstractC0594k5) ((LongFunction) ((C0638p) this.f489c).f686t).apply(j));
                return;
            case 1:
                ((C0668s) this.f489c).getClass();
                LongUnaryOperator longUnaryOperator = null;
                longUnaryOperator.applyAsLong(j);
                throw null;
            case 2:
                ((C0658r) this.f489c).getClass();
                LongToIntFunction longToIntFunction = null;
                longToIntFunction.applyAsInt(j);
                throw null;
            case 3:
                ((C0648q) this.f489c).getClass();
                LongToDoubleFunction longToDoubleFunction = null;
                longToDoubleFunction.applyAsDouble(j);
                throw null;
            case 4:
                ((C0668s) this.f489c).getClass();
                LongPredicate longPredicate = null;
                longPredicate.test(j);
                throw null;
            default:
                ((LongConsumer) ((C0520d1) this.f489c).f533t).accept(j);
                this.f554a.accept(j);
                return;
        }
    }
}
