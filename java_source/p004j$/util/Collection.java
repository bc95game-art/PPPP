package p004j$.util;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
import p004j$.util.stream.AbstractC0488a;
import p004j$.util.stream.EnumC0725x6;
import p004j$.util.stream.Stream;
/* renamed from: j$.util.Collection */
/* loaded from: classes2.dex */
public interface Collection<E> {
    void forEach(Consumer<? super E> consumer);

    /* renamed from: parallelStream */
    Stream<E> mo887parallelStream();

    boolean removeIf(Predicate<? super E> predicate);

    /* renamed from: spliterator */
    Spliterator<E> mo888spliterator();

    /* renamed from: stream */
    Stream<E> mo889stream();

    <T> T[] toArray(IntFunction<T[]> intFunction);

    /* renamed from: j$.util.Collection$-CC  reason: invalid class name */
    /* loaded from: classes2.dex */
    public final /* synthetic */ class CC {
        public static Object[] $default$toArray(java.util.Collection collection, IntFunction intFunction) {
            return collection.toArray((Object[]) intFunction.apply(0));
        }

        public static boolean $default$removeIf(java.util.Collection collection, Predicate predicate) {
            Objects.requireNonNull(predicate);
            Iterator<E> it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (predicate.test(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.stream.Stream, j$.util.stream.a] */
        public static Stream $default$stream(java.util.Collection collection) {
            Spliterator b0 = AbstractC0279a.m535b0(collection);
            Objects.requireNonNull(b0);
            return new AbstractC0488a(b0, EnumC0725x6.m67k(b0), false);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.stream.Stream, j$.util.stream.a] */
        public static Stream $default$parallelStream(java.util.Collection collection) {
            Spliterator b0 = AbstractC0279a.m535b0(collection);
            Objects.requireNonNull(b0);
            return new AbstractC0488a(b0, EnumC0725x6.m67k(b0), true);
        }
    }
}
