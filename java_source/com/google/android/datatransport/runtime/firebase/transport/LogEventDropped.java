package com.google.android.datatransport.runtime.firebase.transport;
/* loaded from: classes.dex */
public final class LogEventDropped {
    public final long events_dropped_count_;
    public final Reason reason_;

    /* loaded from: classes.dex */
    public enum Reason {
        REASON_UNKNOWN("REASON_UNKNOWN"),
        MESSAGE_TOO_OLD("MESSAGE_TOO_OLD"),
        CACHE_FULL("CACHE_FULL"),
        PAYLOAD_TOO_BIG("PAYLOAD_TOO_BIG"),
        MAX_RETRIES_REACHED("MAX_RETRIES_REACHED"),
        INVALID_PAYLOD("INVALID_PAYLOD"),
        SERVER_ERROR("SERVER_ERROR");
        
        public final int number_;

        Reason(String str) {
            this.number_ = r2;
        }
    }

    public LogEventDropped(long j, Reason reason) {
        this.events_dropped_count_ = j;
        this.reason_ = reason;
    }
}
