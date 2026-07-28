package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
/* loaded from: classes.dex */
public final class AutoValue_PersistedEvent {
    public final AutoValue_EventInternal event;

    /* renamed from: id */
    public final long f34id;
    public final AutoValue_TransportContext transportContext;

    public AutoValue_PersistedEvent(long j, AutoValue_TransportContext autoValue_TransportContext, AutoValue_EventInternal autoValue_EventInternal) {
        this.f34id = j;
        this.transportContext = autoValue_TransportContext;
        this.event = autoValue_EventInternal;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutoValue_PersistedEvent) {
            AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) obj;
            if (this.f34id == autoValue_PersistedEvent.f34id && this.transportContext.equals(autoValue_PersistedEvent.transportContext) && this.event.equals(autoValue_PersistedEvent.event)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f34id;
        return ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.transportContext.hashCode()) * 1000003) ^ this.event.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f34id + ", transportContext=" + this.transportContext + ", event=" + this.event + "}";
    }
}
