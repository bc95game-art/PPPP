package p004j$.time.format;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.time.format.w */
/* loaded from: classes2.dex */
public final class EnumC0349w extends Enum {
    public static final EnumC0349w FULL;
    public static final EnumC0349w FULL_STANDALONE;
    public static final EnumC0349w NARROW;
    public static final EnumC0349w NARROW_STANDALONE;
    public static final EnumC0349w SHORT;
    public static final EnumC0349w SHORT_STANDALONE;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0349w[] f170a;

    public static EnumC0349w valueOf(String str) {
        return (EnumC0349w) Enum.valueOf(EnumC0349w.class, str);
    }

    public static EnumC0349w[] values() {
        return (EnumC0349w[]) f170a.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [j$.time.format.w, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [j$.time.format.w, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v1, types: [j$.time.format.w, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r5v1, types: [j$.time.format.w, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r7v1, types: [j$.time.format.w, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r9v1, types: [j$.time.format.w, java.lang.Enum] */
    static {
        ?? r0 = new Enum("FULL", 0);
        FULL = r0;
        ?? r1 = new Enum("FULL_STANDALONE", 1);
        FULL_STANDALONE = r1;
        ?? r3 = new Enum("SHORT", 2);
        SHORT = r3;
        ?? r5 = new Enum("SHORT_STANDALONE", 3);
        SHORT_STANDALONE = r5;
        ?? r7 = new Enum("NARROW", 4);
        NARROW = r7;
        ?? r9 = new Enum("NARROW_STANDALONE", 5);
        NARROW_STANDALONE = r9;
        f170a = new EnumC0349w[]{r0, r1, r3, r5, r7, r9};
    }
}
