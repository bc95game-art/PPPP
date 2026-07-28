package p004j$.util.stream;

import java.util.Iterator;
import p004j$.util.Spliterator;
/* renamed from: j$.util.stream.g */
/* loaded from: classes2.dex */
public interface AbstractC0548g extends AutoCloseable {
    boolean isParallel();

    Iterator iterator();

    AbstractC0548g onClose(Runnable runnable);

    AbstractC0548g parallel();

    AbstractC0548g sequential();

    Spliterator spliterator();

    AbstractC0548g unordered();
}
