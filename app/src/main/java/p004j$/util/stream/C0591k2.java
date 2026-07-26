package p004j$.util.stream;

import java.util.function.BinaryOperator;
import java.util.function.LongFunction;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.k2 */
/* loaded from: classes2.dex */
public final class C0591k2 extends C0601l2 {

    /* renamed from: k */
    public final /* synthetic */ int f626k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0591k2(AbstractC0692u3 u3Var, Spliterator spliterator, LongFunction longFunction, BinaryOperator binaryOperator, int i) {
        super(u3Var, spliterator, longFunction, binaryOperator);
        this.f626k = i;
    }

    @Override // p004j$.util.stream.C0601l2, p004j$.util.stream.AbstractC0518d
    /* renamed from: c */
    public final AbstractC0518d mo76c(Spliterator spliterator) {
        switch (this.f626k) {
            case 0:
                return new C0601l2(this, spliterator);
            case 1:
                return new C0601l2(this, spliterator);
            case 2:
                return new C0601l2(this, spliterator);
            default:
                return new C0601l2(this, spliterator);
        }
    }

    @Override // p004j$.util.stream.C0601l2, p004j$.util.stream.AbstractC0518d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo77a() {
        switch (this.f626k) {
            case 0:
                return mo77a();
            case 1:
                return mo77a();
            case 2:
                return mo77a();
            default:
                return mo77a();
        }
    }
}
