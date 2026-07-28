package p004j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* renamed from: j$.util.l1 */
/* loaded from: classes2.dex */
public final class C0467l1 extends AbstractC0279a implements AbstractC0757y0 {
    @Override // p004j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        AbstractC0279a.m522m(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return AbstractC0279a.m519p(this);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return AbstractC0279a.m517r(this, i);
    }

    @Override // p004j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return AbstractC0279a.m562C(this, consumer);
    }

    @Override // p004j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // p004j$.util.AbstractC0757y0
    public final boolean tryAdvance(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return false;
    }

    @Override // p004j$.util.AbstractC0757y0
    public final void forEachRemaining(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
    }
}
