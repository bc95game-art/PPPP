package p004j$.util;

import java.util.function.Consumer;
import java.util.function.LongConsumer;
/* renamed from: j$.util.n0 */
/* loaded from: classes2.dex */
public interface AbstractC0472n0 extends AbstractC0475o0 {
    @Override // java.util.Iterator, p004j$.util.AbstractC0752w
    void forEachRemaining(Consumer consumer);

    void forEachRemaining(LongConsumer longConsumer);

    @Override // java.util.Iterator
    Long next();

    long nextLong();
}
