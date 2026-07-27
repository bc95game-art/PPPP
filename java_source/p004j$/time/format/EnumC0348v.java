package p004j$.time.format;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.time.format.v */
/* loaded from: classes2.dex */
public final class EnumC0348v extends Enum {
    public static final EnumC0348v ALWAYS;
    public static final EnumC0348v EXCEEDS_PAD;
    public static final EnumC0348v NEVER;
    public static final EnumC0348v NORMAL;
    public static final EnumC0348v NOT_NEGATIVE;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0348v[] f169a;

    public static EnumC0348v valueOf(String str) {
        return (EnumC0348v) Enum.valueOf(EnumC0348v.class, str);
    }

    public static EnumC0348v[] values() {
        return (EnumC0348v[]) f169a.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.format.v, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [j$.time.format.v, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v1, types: [j$.time.format.v, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r5v1, types: [j$.time.format.v, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r7v1, types: [j$.time.format.v, java.lang.Enum] */
    static {
        ?? r0 = new Enum("NORMAL", 0);
        NORMAL = r0;
        ?? r1 = new Enum("ALWAYS", 1);
        ALWAYS = r1;
        ?? r3 = new Enum("NEVER", 2);
        NEVER = r3;
        ?? r5 = new Enum("NOT_NEGATIVE", 3);
        NOT_NEGATIVE = r5;
        ?? r7 = new Enum("EXCEEDS_PAD", 4);
        EXCEEDS_PAD = r7;
        f169a = new EnumC0348v[]{r0, r1, r3, r5, r7};
    }
}
