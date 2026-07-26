package com.google.android.datatransport.runtime.scheduling.persistence;
/* loaded from: classes.dex */
public final class AutoValue_EventStoreConfig {
    public static final AutoValue_EventStoreConfig DEFAULT = new AutoValue_EventStoreConfig(10485760, 200, 10000, 604800000, 81920);
    public final int criticalSectionEnterTimeoutMs;
    public final long eventCleanUpAge;
    public final int loadBatchSize;
    public final int maxBlobByteSizePerRow;
    public final long maxStorageSizeInBytes;

    public AutoValue_EventStoreConfig(long j, int i, int i2, long j2, int i3) {
        this.maxStorageSizeInBytes = j;
        this.loadBatchSize = i;
        this.criticalSectionEnterTimeoutMs = i2;
        this.eventCleanUpAge = j2;
        this.maxBlobByteSizePerRow = i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_EventStoreConfig) {
            AutoValue_EventStoreConfig autoValue_EventStoreConfig = (AutoValue_EventStoreConfig) obj;
            if (this.maxStorageSizeInBytes == autoValue_EventStoreConfig.maxStorageSizeInBytes && this.loadBatchSize == autoValue_EventStoreConfig.loadBatchSize && this.criticalSectionEnterTimeoutMs == autoValue_EventStoreConfig.criticalSectionEnterTimeoutMs && this.eventCleanUpAge == autoValue_EventStoreConfig.eventCleanUpAge && this.maxBlobByteSizePerRow == autoValue_EventStoreConfig.maxBlobByteSizePerRow) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.maxStorageSizeInBytes;
        long j2 = this.eventCleanUpAge;
        return this.maxBlobByteSizePerRow ^ ((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.loadBatchSize) * 1000003) ^ this.criticalSectionEnterTimeoutMs) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public final String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.maxStorageSizeInBytes + ", loadBatchSize=" + this.loadBatchSize + ", criticalSectionEnterTimeoutMs=" + this.criticalSectionEnterTimeoutMs + ", eventCleanUpAge=" + this.eventCleanUpAge + ", maxBlobByteSizePerRow=" + this.maxBlobByteSizePerRow + "}";
    }
}
