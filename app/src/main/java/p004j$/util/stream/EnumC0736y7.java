package p004j$.util.stream;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.util.stream.y7 */
/* loaded from: classes2.dex */
public final class EnumC0736y7 extends Enum {
    public static final EnumC0736y7 MAYBE_MORE;
    public static final EnumC0736y7 NO_MORE;
    public static final EnumC0736y7 UNLIMITED;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0736y7[] f854a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.util.stream.y7] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.util.stream.y7] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, j$.util.stream.y7] */
    static {
        ?? r0 = new Enum("NO_MORE", 0);
        NO_MORE = r0;
        ?? r1 = new Enum("MAYBE_MORE", 1);
        MAYBE_MORE = r1;
        ?? r3 = new Enum("UNLIMITED", 2);
        UNLIMITED = r3;
        f854a = new EnumC0736y7[]{r0, r1, r3};
    }

    public static EnumC0736y7 valueOf(String str) {
        return (EnumC0736y7) Enum.valueOf(EnumC0736y7.class, str);
    }

    public static EnumC0736y7[] values() {
        return (EnumC0736y7[]) f854a.clone();
    }
}
