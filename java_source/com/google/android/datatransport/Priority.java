package com.google.android.datatransport;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public final class Priority extends Enum {
    public static final /* synthetic */ Priority[] $VALUES;
    public static final Priority DEFAULT;
    public static final Priority HIGHEST;
    public static final Priority VERY_LOW;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, com.google.android.datatransport.Priority] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, com.google.android.datatransport.Priority] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, com.google.android.datatransport.Priority] */
    static {
        ?? r0 = new Enum("DEFAULT", 0);
        DEFAULT = r0;
        ?? r1 = new Enum("VERY_LOW", 1);
        VERY_LOW = r1;
        ?? r3 = new Enum("HIGHEST", 2);
        HIGHEST = r3;
        $VALUES = new Priority[]{r0, r1, r3};
    }

    public static Priority valueOf(String str) {
        return (Priority) Enum.valueOf(Priority.class, str);
    }

    public static Priority[] values() {
        return (Priority[]) $VALUES.clone();
    }
}
