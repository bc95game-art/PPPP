package p004j$.util;

import java.util.function.IntConsumer;
/* renamed from: j$.util.v0 */
/* loaded from: classes2.dex */
public interface AbstractC0751v0 extends AbstractC0405b1 {
    void forEachRemaining(IntConsumer intConsumer);

    boolean tryAdvance(IntConsumer intConsumer);

    @Override // p004j$.util.AbstractC0405b1, p004j$.util.Spliterator
    /* renamed from: trySplit */
    AbstractC0751v0 mo899trySplit();
}
