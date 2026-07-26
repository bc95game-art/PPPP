package p004j$.util;

import java.util.function.DoubleConsumer;
/* renamed from: j$.util.s0 */
/* loaded from: classes2.dex */
public interface AbstractC0487s0 extends AbstractC0405b1 {
    void forEachRemaining(DoubleConsumer doubleConsumer);

    boolean tryAdvance(DoubleConsumer doubleConsumer);

    @Override // p004j$.util.AbstractC0405b1, p004j$.util.Spliterator
    /* renamed from: trySplit */
    AbstractC0487s0 mo899trySplit();
}
