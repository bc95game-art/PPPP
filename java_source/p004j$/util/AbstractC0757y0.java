package p004j$.util;

import java.util.function.LongConsumer;
/* renamed from: j$.util.y0 */
/* loaded from: classes2.dex */
public interface AbstractC0757y0 extends AbstractC0405b1 {
    void forEachRemaining(LongConsumer longConsumer);

    boolean tryAdvance(LongConsumer longConsumer);

    @Override // p004j$.util.AbstractC0405b1, p004j$.util.Spliterator
    /* renamed from: trySplit */
    AbstractC0757y0 mo899trySplit();
}
