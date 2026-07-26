package p004j$.util.stream;

import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.m3 */
/* loaded from: classes2.dex */
public final class C0612m3 extends AbstractC0652q3 implements AbstractC0564h5 {

    /* renamed from: h */
    public final double[] f657h;

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

    public C0612m3(Spliterator spliterator, AbstractC0692u3 u3Var, double[] dArr) {
        super(spliterator, u3Var, dArr.length);
        this.f657h = dArr;
    }

    public C0612m3(C0612m3 m3Var, Spliterator spliterator, long j, long j2) {
        super(m3Var, spliterator, j, j2, m3Var.f657h.length);
        this.f657h = m3Var.f657h;
    }

    @Override // p004j$.util.stream.AbstractC0652q3
    /* renamed from: a */
    public final AbstractC0652q3 mo165a(Spliterator spliterator, long j, long j2) {
        return new C0612m3(this, spliterator, j, j2);
    }

    @Override // p004j$.util.stream.AbstractC0652q3, p004j$.util.stream.AbstractC0594k5, p004j$.util.stream.AbstractC0564h5, java.util.function.DoubleConsumer
    public final void accept(double d) {
        int i = this.f707f;
        if (i < this.f708g) {
            double[] dArr = this.f657h;
            this.f707f = i + 1;
            dArr[i] = d;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f707f));
    }
}
