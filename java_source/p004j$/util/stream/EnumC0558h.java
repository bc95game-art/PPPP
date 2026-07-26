package p004j$.util.stream;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.util.stream.h */
/* loaded from: classes2.dex */
public final class EnumC0558h extends Enum {
    public static final EnumC0558h CONCURRENT;
    public static final EnumC0558h IDENTITY_FINISH;
    public static final EnumC0558h UNORDERED;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0558h[] f574a;

    public static EnumC0558h valueOf(String str) {
        return (EnumC0558h) Enum.valueOf(EnumC0558h.class, str);
    }

    public static EnumC0558h[] values() {
        return (EnumC0558h[]) f574a.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [j$.util.stream.h, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r1v1, types: [j$.util.stream.h, java.lang.Enum] */
    /* JADX WARN: Type inference failed for: r3v1, types: [j$.util.stream.h, java.lang.Enum] */
    static {
        ?? r0 = new Enum("CONCURRENT", 0);
        CONCURRENT = r0;
        ?? r1 = new Enum("UNORDERED", 1);
        UNORDERED = r1;
        ?? r3 = new Enum("IDENTITY_FINISH", 2);
        IDENTITY_FINISH = r3;
        f574a = new EnumC0558h[]{r0, r1, r3};
    }
}
