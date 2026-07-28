package p004j$.util.stream;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0757y0;
import p004j$.util.Spliterator;
import p004j$.util.function.AbstractC0449g;
/* renamed from: j$.util.stream.v7 */
/* loaded from: classes2.dex */
public final class C0706v7 extends AbstractC0716w7 implements AbstractC0757y0, LongConsumer {

    /* renamed from: f */
    public long f800f;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return AbstractC0449g.m232b(this, longConsumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m522m(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m562C(this, consumer);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.Spliterator, j$.util.stream.z7] */
    @Override // p004j$.util.stream.AbstractC0745z7
    /* renamed from: b */
    public final Spliterator mo16b(Spliterator spliterator) {
        return new AbstractC0745z7((AbstractC0757y0) spliterator, this);
    }

    @Override // p004j$.util.stream.AbstractC0716w7
    /* renamed from: g */
    public final void mo75g(Object obj) {
        ((LongConsumer) obj).accept(this.f800f);
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        this.f800f = j;
    }

    @Override // p004j$.util.stream.AbstractC0716w7
    /* renamed from: j */
    public final AbstractC0526d7 mo74j(int i) {
        return new C0516c7(i);
    }
}
