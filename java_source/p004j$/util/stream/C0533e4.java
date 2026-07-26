package p004j$.util.stream;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.e4 */
/* loaded from: classes2.dex */
public final class C0533e4 extends AbstractC0653q4 implements AbstractC0643p4 {

    /* renamed from: b */
    public final /* synthetic */ Object f541b;

    /* renamed from: c */
    public final /* synthetic */ BiFunction f542c;

    /* renamed from: d */
    public final /* synthetic */ BinaryOperator f543d;

    @Override // p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final /* synthetic */ void accept(double d) {
        AbstractC0692u3.m144D();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void accept(int i) {
        AbstractC0692u3.m134K();
        throw null;
    }

    @Override // p004j$.util.stream.AbstractC0594k5, java.util.function.LongConsumer
    public final /* synthetic */ void accept(long j) {
        AbstractC0692u3.m133L();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return AbstractC0279a.m532d(this, consumer);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: e */
    public final /* synthetic */ boolean mo27e() {
        return false;
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    public final /* synthetic */ void end() {
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        this.f709a = this.f543d.apply(this.f709a, ((C0533e4) p4Var).f709a);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f709a = this.f541b;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f709a = this.f542c.apply(this.f709a, obj);
    }

    public C0533e4(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        this.f541b = obj;
        this.f542c = biFunction;
        this.f543d = binaryOperator;
    }
}
