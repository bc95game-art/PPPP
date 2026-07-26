package com.google.android.datatransport;

import com.google.android.gms.internal.play_billing.zzji;
/* loaded from: classes.dex */
public final class AutoValue_Event {
    public final zzji payload;

    public AutoValue_Event(zzji zzjiVar) {
        this.payload = zzjiVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_Event) || !this.payload.equals(((AutoValue_Event) obj).payload)) {
            return false;
        }
        Object obj2 = Priority.DEFAULT;
        if (obj2.equals(obj2)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Priority.DEFAULT.hashCode() ^ (((1000003 * 1000003) ^ this.payload.hashCode()) * 1000003);
    }

    public final String toString() {
        return "Event{code=null, payload=" + this.payload + ", priority=" + Priority.DEFAULT + "}";
    }
}
