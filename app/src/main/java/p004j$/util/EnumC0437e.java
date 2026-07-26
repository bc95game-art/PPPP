package p004j$.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import p004j$.com.android.tools.p005r8.AbstractC0279a;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.util.e */
/* loaded from: classes2.dex */
public final class EnumC0437e extends Enum implements Comparator {
    public static final EnumC0437e INSTANCE;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0437e[] f394a;

    public static EnumC0437e valueOf(String str) {
        return (EnumC0437e) Enum.valueOf(EnumC0437e.class, str);
    }

    public static EnumC0437e[] values() {
        return (EnumC0437e[]) f394a.clone();
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo((Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.util.e] */
    static {
        ?? r0 = new Enum("INSTANCE", 0);
        INSTANCE = r0;
        f394a = new EnumC0437e[]{r0};
    }

    @Override // java.util.Comparator
    public final Comparator thenComparing(Comparator comparator) {
        Objects.requireNonNull(comparator);
        return new C0434d(this, comparator);
    }

    @Override // java.util.Comparator
    public final Comparator reversed() {
        return Collections.reverseOrder();
    }

    @Override // java.util.Comparator
    public final Comparator thenComparing(Function function, Comparator comparator) {
        Objects.requireNonNull(function);
        Objects.requireNonNull(comparator);
        return AbstractC0279a.m531d0(this, new C0434d(function, comparator));
    }

    @Override // java.util.Comparator
    public final Comparator thenComparing(Function function) {
        Objects.requireNonNull(function);
        return AbstractC0279a.m531d0(this, new C0406c(2, function));
    }

    @Override // java.util.Comparator
    public final Comparator thenComparingInt(ToIntFunction toIntFunction) {
        Objects.requireNonNull(toIntFunction);
        return AbstractC0279a.m531d0(this, new C0406c(0, toIntFunction));
    }

    @Override // java.util.Comparator
    public final Comparator thenComparingLong(ToLongFunction toLongFunction) {
        Objects.requireNonNull(toLongFunction);
        return AbstractC0279a.m531d0(this, new C0406c(3, toLongFunction));
    }

    @Override // java.util.Comparator
    public final Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        Objects.requireNonNull(toDoubleFunction);
        return AbstractC0279a.m531d0(this, new C0406c(1, toDoubleFunction));
    }
}
