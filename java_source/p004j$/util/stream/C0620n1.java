package p004j$.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.stream.n1 */
/* loaded from: classes2.dex */
public final class C0620n1 extends AbstractC0650q1 implements AbstractC0574i5 {
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

    @Override // p004j$.util.stream.AbstractC0650q1, p004j$.util.stream.AbstractC0594k5
    public final void accept(int i) {
        if (!this.f700a) {
            IntPredicate intPredicate = null;
            intPredicate.test(i);
            throw null;
        }
    }
}
