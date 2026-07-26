package com.google.android.datatransport.runtime.scheduling.jobscheduling;
/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes.dex */
public final class SchedulerConfig$Flag extends Enum {
    public static final /* synthetic */ SchedulerConfig$Flag[] $VALUES;
    public static final SchedulerConfig$Flag DEVICE_CHARGING;
    public static final SchedulerConfig$Flag DEVICE_IDLE;
    public static final SchedulerConfig$Flag NETWORK_UNMETERED;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Enum, com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Enum, com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Enum, com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag] */
    static {
        ?? r0 = new Enum("NETWORK_UNMETERED", 0);
        NETWORK_UNMETERED = r0;
        ?? r1 = new Enum("DEVICE_IDLE", 1);
        DEVICE_IDLE = r1;
        ?? r3 = new Enum("DEVICE_CHARGING", 2);
        DEVICE_CHARGING = r3;
        $VALUES = new SchedulerConfig$Flag[]{r0, r1, r3};
    }

    public static SchedulerConfig$Flag valueOf(String str) {
        return (SchedulerConfig$Flag) Enum.valueOf(SchedulerConfig$Flag.class, str);
    }

    public static SchedulerConfig$Flag[] values() {
        return (SchedulerConfig$Flag[]) $VALUES.clone();
    }
}
