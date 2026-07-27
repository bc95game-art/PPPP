package p004j$.util.stream;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.util.stream.y6 */
/* loaded from: classes2.dex */
public final class EnumC0735y6 extends Enum {
    public static final EnumC0735y6 DOUBLE_VALUE;
    public static final EnumC0735y6 INT_VALUE;
    public static final EnumC0735y6 LONG_VALUE;
    public static final EnumC0735y6 REFERENCE;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0735y6[] f853a;

    public static EnumC0735y6 valueOf(String str) {
        return (EnumC0735y6) Enum.valueOf(EnumC0735y6.class, str);
    }

    public static EnumC0735y6[] values() {
        return (EnumC0735y6[]) f853a.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.util.stream.y6] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.util.stream.y6] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, j$.util.stream.y6] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, j$.util.stream.y6] */
    static {
        ?? r0 = new Enum("REFERENCE", 0);
        REFERENCE = r0;
        ?? r1 = new Enum("INT_VALUE", 1);
        INT_VALUE = r1;
        ?? r3 = new Enum("LONG_VALUE", 2);
        LONG_VALUE = r3;
        ?? r5 = new Enum("DOUBLE_VALUE", 3);
        DOUBLE_VALUE = r5;
        f853a = new EnumC0735y6[]{r0, r1, r3, r5};
    }
}
