package p004j$.util.stream;

import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.r4 */
/* loaded from: classes2.dex */
public final class C0663r4 extends AbstractC0703v4 implements AbstractC0564h5 {
    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo56n((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return AbstractC0279a.m530e(this, doubleConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0564h5
    /* renamed from: n */
    public final /* synthetic */ void mo56n(Double d) {
        AbstractC0692u3.m143E(this, d);
    }

    @Override // p004j$.util.stream.AbstractC0653q4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.f797b);
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        this.f797b += ((AbstractC0703v4) p4Var).f797b;
    }

    @Override // p004j$.util.stream.AbstractC0703v4, p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.f797b++;
    }
}
