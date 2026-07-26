package com.google.android.datatransport.runtime.backends;

import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
/* loaded from: classes.dex */
public final class AutoValue_BackendResponse {
    public final long nextRequestWaitMillis;
    public final int status;

    public AutoValue_BackendResponse(int i, long j) {
        if (i != 0) {
            this.status = i;
            this.nextRequestWaitMillis = j;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AutoValue_BackendResponse)) {
            return false;
        }
        AutoValue_BackendResponse autoValue_BackendResponse = (AutoValue_BackendResponse) obj;
        if (!SolverVariable$Type$EnumUnboxingSharedUtility.equals(this.status, autoValue_BackendResponse.status) || this.nextRequestWaitMillis != autoValue_BackendResponse.nextRequestWaitMillis) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j = this.nextRequestWaitMillis;
        return ((SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(this.status) ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i = this.status;
        if (i == 1) {
            str = "OK";
        } else if (i == 2) {
            str = "TRANSIENT_ERROR";
        } else if (i == 3) {
            str = "FATAL_ERROR";
        } else if (i != 4) {
            str = "null";
        } else {
            str = "INVALID_PAYLOAD";
        }
        sb.append(str);
        sb.append(", nextRequestWaitMillis=");
        sb.append(this.nextRequestWaitMillis);
        sb.append("}");
        return sb.toString();
    }
}
