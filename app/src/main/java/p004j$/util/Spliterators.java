package p004j$.util;

import java.util.Collection;
/* renamed from: j$.util.Spliterators */
/* loaded from: classes2.dex */
public final class Spliterators {

    /* renamed from: a */
    public static final C0470m1 f293a = new Object();

    /* renamed from: b */
    public static final C0464k1 f294b = new Object();

    /* renamed from: c */
    public static final C0467l1 f295c = new Object();

    /* renamed from: d */
    public static final C0461j1 f296d = new Object();

    /* renamed from: a */
    public static void m276a(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new ArrayIndexOutOfBoundsException("origin(" + i2 + ") > fence(" + i3 + ")");
        } else if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(i2);
        } else if (i3 > i) {
            throw new ArrayIndexOutOfBoundsException(i3);
        }
    }

    public static <T> Spliterator<T> spliterator(Collection<? extends T> collection, int i) {
        return new C0476o1((Collection) Objects.requireNonNull(collection), i);
    }
}
