package p004j$.time.zone;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* renamed from: j$.time.zone.d */
/* loaded from: classes2.dex */
public final class EnumC0394d extends Enum {
    public static final EnumC0394d STANDARD;
    public static final EnumC0394d UTC;
    public static final EnumC0394d WALL;

    /* renamed from: a */
    public static final /* synthetic */ EnumC0394d[] f266a;

    public static EnumC0394d valueOf(String str) {
        return (EnumC0394d) Enum.valueOf(EnumC0394d.class, str);
    }

    public static EnumC0394d[] values() {
        return (EnumC0394d[]) f266a.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, j$.time.zone.d] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, j$.time.zone.d] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, j$.time.zone.d] */
    static {
        ?? r0 = new Enum("UTC", 0);
        UTC = r0;
        ?? r1 = new Enum("WALL", 1);
        WALL = r1;
        ?? r3 = new Enum("STANDARD", 2);
        STANDARD = r3;
        f266a = new EnumC0394d[]{r0, r1, r3};
    }
}
