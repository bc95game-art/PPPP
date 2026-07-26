package p004j$.util.stream;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.f2 */
/* loaded from: classes2.dex */
public final /* synthetic */ class C0541f2 implements IntFunction, LongFunction, BinaryOperator, Consumer {

    /* renamed from: a */
    public final /* synthetic */ int f550a;

    public /* synthetic */ C0541f2(int i) {
        this.f550a = i;
    }

    /* renamed from: accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$$ExternalSyntheticLambda0 */
    private final void m207x10ce6cf0(Object obj) {
    }

    /* renamed from: accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfRef$$ExternalSyntheticLambda1 */
    private final void m206x10ce6cf1(Object obj) {
    }

    @Override // java.util.function.Consumer
    public void accept(Object obj) {
        int i = this.f550a;
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        switch (this.f550a) {
            case 2:
                return AbstractC0279a.m534c(this, function);
            case 3:
            case 5:
            default:
                return AbstractC0279a.m534c(this, function);
            case 4:
                return AbstractC0279a.m534c(this, function);
            case 6:
                return AbstractC0279a.m534c(this, function);
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f550a) {
            case 12:
                return AbstractC0279a.m532d(this, consumer);
            default:
                return AbstractC0279a.m532d(this, consumer);
        }
    }

    @Override // java.util.function.LongFunction
    public Object apply(long j) {
        switch (this.f550a) {
            case 1:
                return AbstractC0692u3.m109i0(j);
            case 2:
            default:
                return AbstractC0692u3.m97t0(j);
            case 3:
                return AbstractC0692u3.m98s0(j);
        }
    }

    @Override // java.util.function.IntFunction
    public Object apply(int i) {
        switch (this.f550a) {
            case 0:
                return new Object[i];
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 12:
            case 13:
            default:
                return new Double[i];
            case 8:
                return new Object[i];
            case 9:
                return new Integer[i];
            case 10:
                return new Long[i];
            case 11:
                return new Double[i];
            case 14:
                return new Integer[i];
            case 15:
                return new Integer[i];
            case 16:
                return new Long[i];
            case 17:
                return new Long[i];
            case 18:
                return new Double[i];
        }
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object obj, Object obj2) {
        switch (this.f550a) {
            case 2:
                return new AbstractC0561h2((AbstractC0730y1) obj, (AbstractC0730y1) obj2);
            case 3:
            case 5:
            default:
                return new AbstractC0561h2((AbstractC0531e2) obj, (AbstractC0531e2) obj2);
            case 4:
                return new AbstractC0561h2((AbstractC0491a2) obj, (AbstractC0491a2) obj2);
            case 6:
                return new AbstractC0561h2((AbstractC0511c2) obj, (AbstractC0511c2) obj2);
        }
    }
}
