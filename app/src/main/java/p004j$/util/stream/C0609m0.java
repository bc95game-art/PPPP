package p004j$.util.stream;

import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.m0 */
/* loaded from: classes2.dex */
public final class C0609m0 extends AbstractC0639p0 implements AbstractC0574i5 {

    /* renamed from: b */
    public final IntConsumer f654b;

    @Override // java.util.function.Consumer
    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        mo162d((Integer) obj);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return AbstractC0279a.m529f(this, intConsumer);
    }

    @Override // p004j$.util.stream.AbstractC0574i5
    /* renamed from: d */
    public final /* synthetic */ void mo162d(Integer num) {
        AbstractC0692u3.m139G(this, num);
    }

    @Override // java.util.function.Supplier
    public final /* bridge */ /* synthetic */ Object get() {
        return null;
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: f */
    public final Object mo113f(AbstractC0488a aVar, Spliterator spliterator) {
        aVar.mo142E0(spliterator, this);
        return null;
    }

    @Override // p004j$.util.stream.AbstractC0527d8
    /* renamed from: j */
    public final /* bridge */ /* synthetic */ Object mo108j(AbstractC0692u3 u3Var, Spliterator spliterator) {
        m168a(u3Var, spliterator);
        return null;
    }

    public C0609m0(IntConsumer intConsumer, boolean z) {
        super(z);
        this.f654b = intConsumer;
    }

    @Override // p004j$.util.stream.AbstractC0639p0, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        this.f654b.accept(i);
    }
}
