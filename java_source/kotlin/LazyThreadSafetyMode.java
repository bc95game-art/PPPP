package kotlin;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public final class LazyThreadSafetyMode extends Enum {
    public static final /* synthetic */ LazyThreadSafetyMode[] $VALUES;
    public static final LazyThreadSafetyMode NONE;
    /* JADX INFO: Fake field, exist only in values array */
    LazyThreadSafetyMode EF0;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.LazyThreadSafetyMode, java.lang.Enum] */
    static {
        Enum r0 = new Enum("SYNCHRONIZED", 0);
        Enum r1 = new Enum("PUBLICATION", 1);
        ?? r3 = new Enum("NONE", 2);
        NONE = r3;
        $VALUES = new LazyThreadSafetyMode[]{r0, r1, r3};
    }

    public static LazyThreadSafetyMode valueOf(String str) {
        return (LazyThreadSafetyMode) Enum.valueOf(LazyThreadSafetyMode.class, str);
    }

    public static LazyThreadSafetyMode[] values() {
        return (LazyThreadSafetyMode[]) $VALUES.clone();
    }
}
