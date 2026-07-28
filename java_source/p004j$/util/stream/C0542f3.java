package p004j$.util.stream;

import java.util.function.Consumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.AbstractC0757y0;
/* renamed from: j$.util.stream.f3 */
/* loaded from: classes2.dex */
public final class C0542f3 extends AbstractC0552g3 implements AbstractC0757y0 {
    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m522m(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m562C(this, consumer);
    }
}
