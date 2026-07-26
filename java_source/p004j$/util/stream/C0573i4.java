package p004j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.i4 */
/* loaded from: classes2.dex */
public final class C0573i4 extends AbstractC0653q4 implements AbstractC0643p4 {

    /* renamed from: b */
    public final /* synthetic */ Supplier f602b;

    /* renamed from: c */
    public final /* synthetic */ BiConsumer f603c;

    /* renamed from: d */
    public final /* synthetic */ BiConsumer f604d;

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
        this.f604d.accept(this.f709a, ((C0573i4) p4Var).f709a);
    }

    @Override // p004j$.util.stream.AbstractC0594k5
    /* renamed from: c */
    public final void mo23c(long j) {
        this.f709a = this.f602b.get();
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f603c.accept(this.f709a, obj);
    }

    public C0573i4(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        this.f602b = supplier;
        this.f603c = biConsumer;
        this.f604d = biConsumer2;
    }
}
