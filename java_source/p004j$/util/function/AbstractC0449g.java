package p004j$.util.function;

import java.util.function.LongConsumer;
import java.util.function.Predicate;
import p004j$.util.Objects;
/* renamed from: j$.util.function.g */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC0449g {
    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.function.e] */
    /* renamed from: b */
    public static C0447e m232b(final LongConsumer longConsumer, final LongConsumer longConsumer2) {
        Objects.requireNonNull(longConsumer2);
        return new LongConsumer() { // from class: j$.util.function.e
            public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer3) {
                return AbstractC0449g.m232b(this, longConsumer3);
            }

            @Override // java.util.function.LongConsumer
            public final void accept(long j) {
                LongConsumer.this.accept(j);
                longConsumer2.accept(j);
            }
        };
    }

    /* renamed from: a */
    public static C0448f m233a(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new C0448f(predicate, predicate2, 0);
    }

    /* renamed from: c */
    public static C0448f m231c(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new C0448f(predicate, predicate2, 1);
    }
}
