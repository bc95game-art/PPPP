package p004j$.util.stream;

import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0487s0;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.n7 */
/* loaded from: classes2.dex */
public final class C0626n7 extends AbstractC0656q7 implements AbstractC0487s0 {
    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m524k(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m564A(this, consumer);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.stream.s7, j$.util.Spliterator] */
    @Override // p004j$.util.stream.AbstractC0676s7
    /* renamed from: a */
    public final Spliterator mo156a(Spliterator spliterator, long j, long j2, long j3, long j4) {
        return new AbstractC0676s7((AbstractC0487s0) spliterator, j, j2, j3, j4);
    }

    @Override // p004j$.util.stream.AbstractC0656q7
    /* renamed from: b */
    public final Object mo164b() {
        return new C0720x1(1);
    }
}
