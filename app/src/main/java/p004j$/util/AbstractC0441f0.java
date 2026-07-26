package p004j$.util;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
/* renamed from: j$.util.f0 */
/* loaded from: classes2.dex */
public interface AbstractC0441f0 extends AbstractC0475o0 {
    @Override // java.util.Iterator, p004j$.util.AbstractC0752w
    void forEachRemaining(Consumer consumer);

    void forEachRemaining(DoubleConsumer doubleConsumer);

    @Override // java.util.Iterator
    Double next();

    double nextDouble();
}
