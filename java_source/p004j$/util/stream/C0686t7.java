package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0487s0;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.t7 */
/* loaded from: classes2.dex */
public final class C0686t7 extends AbstractC0716w7 implements AbstractC0487s0, DoubleConsumer {

    /* renamed from: f */
    public double f768f;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return AbstractC0279a.m530e(this, doubleConsumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m524k(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m564A(this, consumer);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.Spliterator, j$.util.stream.z7] */
    @Override // p004j$.util.stream.AbstractC0745z7
    /* renamed from: b */
    public final Spliterator mo16b(Spliterator spliterator) {
        return new AbstractC0745z7((AbstractC0487s0) spliterator, this);
    }

    @Override // p004j$.util.stream.AbstractC0716w7
    /* renamed from: g */
    public final void mo75g(Object obj) {
        ((DoubleConsumer) obj).accept(this.f768f);
    }

    @Override // java.util.function.DoubleConsumer
    public final void accept(double d) {
        this.f768f = d;
    }

    @Override // p004j$.util.stream.AbstractC0716w7
    /* renamed from: j */
    public final AbstractC0526d7 mo74j(int i) {
        return new C0496a7(i);
    }
}
