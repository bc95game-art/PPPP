package p004j$.util;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
/* renamed from: j$.util.j0 */
/* loaded from: classes2.dex */
public interface AbstractC0460j0 extends AbstractC0475o0 {
    @Override // java.util.Iterator, p004j$.util.AbstractC0752w
    void forEachRemaining(Consumer consumer);

    void forEachRemaining(IntConsumer intConsumer);

    @Override // java.util.Iterator
    Integer next();

    int nextInt();
}
