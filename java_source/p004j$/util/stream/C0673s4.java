package p004j$.util.stream;

import java.util.function.IntConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.s4 */
/* loaded from: classes2.dex */
public final class C0673s4 extends AbstractC0703v4 implements AbstractC0574i5 {
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

    @Override // p004j$.util.stream.AbstractC0653q4, java.util.function.Supplier
    public final Object get() {
        return Long.valueOf(this.f797b);
    }

    @Override // p004j$.util.stream.AbstractC0643p4
    /* renamed from: i */
    public final void mo57i(AbstractC0643p4 p4Var) {
        this.f797b += ((AbstractC0703v4) p4Var).f797b;
    }

    @Override // p004j$.util.stream.AbstractC0703v4, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        this.f797b++;
    }
}
