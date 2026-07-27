package p004j$.util.stream;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.util.stream.w6 */
/* loaded from: classes2.dex */
public final class EnumC0715w6 extends Enum {

    /* renamed from: OP */
    public static final EnumC0715w6 f809OP;
    public static final EnumC0715w6 SPLITERATOR;
    public static final EnumC0715w6 STREAM;
    public static final EnumC0715w6 TERMINAL_OP;
    public static final EnumC0715w6 UPSTREAM_TERMINAL_OP;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0715w6[] f810a;

    public static EnumC0715w6 valueOf(String str) {
        return (EnumC0715w6) Enum.valueOf(EnumC0715w6.class, str);
    }

    public static EnumC0715w6[] values() {
        return (EnumC0715w6[]) f810a.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.util.stream.w6] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.util.stream.w6] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, j$.util.stream.w6] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, j$.util.stream.w6] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Enum, j$.util.stream.w6] */
    static {
        ?? r0 = new Enum("SPLITERATOR", 0);
        SPLITERATOR = r0;
        ?? r1 = new Enum("STREAM", 1);
        STREAM = r1;
        ?? r3 = new Enum("OP", 2);
        f809OP = r3;
        ?? r5 = new Enum("TERMINAL_OP", 3);
        TERMINAL_OP = r5;
        ?? r7 = new Enum("UPSTREAM_TERMINAL_OP", 4);
        UPSTREAM_TERMINAL_OP = r7;
        f810a = new EnumC0715w6[]{r0, r1, r3, r5, r7};
    }
}
