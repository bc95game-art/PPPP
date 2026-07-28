package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Set;
/* loaded from: classes.dex */
public final class AutoValue_SchedulerConfig_ConfigValue {
    public final long delta;
    public final Set flags;
    public final long maxAllowedDelay;

    public AutoValue_SchedulerConfig_ConfigValue(long j, long j2, Set set) {
        this.delta = j;
        this.maxAllowedDelay = j2;
        this.flags = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_SchedulerConfig_ConfigValue) {
            AutoValue_SchedulerConfig_ConfigValue autoValue_SchedulerConfig_ConfigValue = (AutoValue_SchedulerConfig_ConfigValue) obj;
            if (this.delta == autoValue_SchedulerConfig_ConfigValue.delta && this.maxAllowedDelay == autoValue_SchedulerConfig_ConfigValue.maxAllowedDelay && this.flags.equals(autoValue_SchedulerConfig_ConfigValue.flags)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.delta;
        long j2 = this.maxAllowedDelay;
        return this.flags.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.delta + ", maxAllowedDelay=" + this.maxAllowedDelay + ", flags=" + this.flags + "}";
    }
}
