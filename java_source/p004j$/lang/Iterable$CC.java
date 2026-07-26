package p004j$.lang;

import java.util.function.Consumer;
import p004j$.util.Objects;
/* renamed from: j$.lang.Iterable$-CC  reason: invalid class name */
/* loaded from: classes2.dex */
public final /* synthetic */ class Iterable$CC {
    public static void $default$forEach(Iterable iterable, Consumer consumer) {
        Objects.requireNonNull(consumer);
        for (Object obj : iterable) {
            consumer.accept(obj);
        }
    }
}
