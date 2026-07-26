package p004j$.util.stream;

import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.a7 */
/* loaded from: classes2.dex */
public final class C0496a7 extends AbstractC0526d7 implements DoubleConsumer {

    /* renamed from: c */
    public final double[] f496c;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return AbstractC0279a.m530e(this, doubleConsumer);
    }

    public C0496a7(int i) {
        this.f496c = new double[i];
    }

    @Override // p004j$.util.stream.AbstractC0526d7
    /* renamed from: a */
    public final void mo211a(Object obj, long j) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i = 0; i < j; i++) {
            doubleConsumer.accept(this.f496c[i]);
        }
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        int i = this.f538b;
        this.f538b = i + 1;
        this.f496c[i] = d;
    }
}
