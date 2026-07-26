package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0751v0;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.u7 */
/* loaded from: classes2.dex */
public final class C0696u7 extends AbstractC0716w7 implements AbstractC0751v0, IntConsumer {

    /* renamed from: f */
    public int f789f;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return AbstractC0279a.m529f(this, intConsumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m523l(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m563B(this, consumer);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.Spliterator, j$.util.stream.z7] */
    @Override // p004j$.util.stream.AbstractC0745z7
    /* renamed from: b */
    public final Spliterator mo16b(Spliterator spliterator) {
        return new AbstractC0745z7((AbstractC0751v0) spliterator, this);
    }

    @Override // p004j$.util.stream.AbstractC0716w7
    /* renamed from: g */
    public final void mo75g(Object obj) {
        ((IntConsumer) obj).accept(this.f789f);
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        this.f789f = i;
    }

    @Override // p004j$.util.stream.AbstractC0716w7
    /* renamed from: j */
    public final AbstractC0526d7 mo74j(int i) {
        return new C0506b7(i);
    }
}
