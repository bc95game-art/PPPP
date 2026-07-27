package p004j$.util.stream;

import java.util.function.Consumer;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.o0 */
/* loaded from: classes2.dex */
public final class C0629o0 extends AbstractC0639p0 {

    /* renamed from: b */
    public final Consumer f677b;

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

    public C0629o0(Consumer consumer, boolean z) {
        super(z);
        this.f677b = consumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f677b.accept(obj);
    }
}
