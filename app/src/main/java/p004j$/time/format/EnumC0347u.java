package p004j$.time.format;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.time.format.u */
/* loaded from: classes2.dex */
public final class EnumC0347u extends Enum {
    public static final EnumC0347u LENIENT;
    public static final EnumC0347u SMART;
    public static final EnumC0347u STRICT;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0347u[] f168a;

    public static EnumC0347u valueOf(String str) {
        return (EnumC0347u) Enum.valueOf(EnumC0347u.class, str);
    }

    public static EnumC0347u[] values() {
        return (EnumC0347u[]) f168a.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.format.u] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.format.u] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, j$.time.format.u] */
    static {
        ?? r0 = new Enum("STRICT", 0);
        STRICT = r0;
        ?? r1 = new Enum("SMART", 1);
        SMART = r1;
        ?? r3 = new Enum("LENIENT", 2);
        LENIENT = r3;
        f168a = new EnumC0347u[]{r0, r1, r3};
    }
}
