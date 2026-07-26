package kotlin.coroutines.intrinsics;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public final class CoroutineSingletons extends Enum {
    public static final /* synthetic */ CoroutineSingletons[] $VALUES;
    public static final CoroutineSingletons COROUTINE_SUSPENDED;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, kotlin.coroutines.intrinsics.CoroutineSingletons] */
    static {
        ?? r0 = new Enum("COROUTINE_SUSPENDED", 0);
        COROUTINE_SUSPENDED = r0;
        $VALUES = new CoroutineSingletons[]{r0, new Enum("UNDECIDED", 1), new Enum("RESUMED", 2)};
    }

    public static CoroutineSingletons valueOf(String str) {
        return (CoroutineSingletons) Enum.valueOf(CoroutineSingletons.class, str);
    }

    public static CoroutineSingletons[] values() {
        return (CoroutineSingletons[]) $VALUES.clone();
    }
}
