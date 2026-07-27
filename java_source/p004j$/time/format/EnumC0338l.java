package p004j$.time.format;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.time.format.l */
/* loaded from: classes2.dex */
public final class EnumC0338l extends Enum implements AbstractC0333g {
    public static final EnumC0338l INSENSITIVE;
    public static final EnumC0338l LENIENT;
    public static final EnumC0338l SENSITIVE;
    public static final EnumC0338l STRICT;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0338l[] f147a;

    @Override // p004j$.time.format.AbstractC0333g
    /* renamed from: i */
    public final boolean mo423i(C0343q qVar, StringBuilder sb) {
        return true;
    }

    public static EnumC0338l valueOf(String str) {
        return (EnumC0338l) Enum.valueOf(EnumC0338l.class, str);
    }

    public static EnumC0338l[] values() {
        return (EnumC0338l[]) f147a.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.format.l] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.format.l] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, j$.time.format.l] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Enum, j$.time.format.l] */
    static {
        ?? r0 = new Enum("SENSITIVE", 0);
        SENSITIVE = r0;
        ?? r1 = new Enum("INSENSITIVE", 1);
        INSENSITIVE = r1;
        ?? r3 = new Enum("STRICT", 2);
        STRICT = r3;
        ?? r5 = new Enum("LENIENT", 3);
        LENIENT = r5;
        f147a = new EnumC0338l[]{r0, r1, r3, r5};
    }

    @Override // java.lang.Enum
    public final String toString() {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return "ParseCaseSensitive(true)";
        }
        if (ordinal == 1) {
            return "ParseCaseSensitive(false)";
        }
        if (ordinal == 2) {
            return "ParseStrict(true)";
        }
        if (ordinal == 3) {
            return "ParseStrict(false)";
        }
        throw new IllegalStateException("Unreachable");
    }
}
