package com.google.android.datatransport.cct.internal;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class AutoValue_LogRequest extends LogRequest {
    public final AutoValue_ClientInfo clientInfo;
    public final ArrayList logEvents;
    public final Integer logSource;
    public final String logSourceName;
    public final long requestTimeMs;
    public final long requestUptimeMs;

    public AutoValue_LogRequest(long j, long j2, AutoValue_ClientInfo autoValue_ClientInfo, Integer num, String str, ArrayList arrayList) {
        QosTier qosTier = QosTier.DEFAULT;
        this.requestTimeMs = j;
        this.requestUptimeMs = j2;
        this.clientInfo = autoValue_ClientInfo;
        this.logSource = num;
        this.logSourceName = str;
        this.logEvents = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        AutoValue_LogRequest autoValue_LogRequest = (AutoValue_LogRequest) ((LogRequest) obj);
        Object obj2 = QosTier.DEFAULT;
        ArrayList arrayList = autoValue_LogRequest.logEvents;
        String str = autoValue_LogRequest.logSourceName;
        Integer num = autoValue_LogRequest.logSource;
        AutoValue_ClientInfo autoValue_ClientInfo = autoValue_LogRequest.clientInfo;
        if (this.requestTimeMs != autoValue_LogRequest.requestTimeMs || this.requestUptimeMs != autoValue_LogRequest.requestUptimeMs || !this.clientInfo.equals(autoValue_ClientInfo)) {
            return false;
        }
        Integer num2 = this.logSource;
        if (num2 == null) {
            if (num != null) {
                return false;
            }
        } else if (!num2.equals(num)) {
            return false;
        }
        String str2 = this.logSourceName;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        if (!this.logEvents.equals(arrayList) || !obj2.equals(obj2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i;
        long j = this.requestTimeMs;
        long j2 = this.requestUptimeMs;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.clientInfo.hashCode()) * 1000003;
        int i2 = 0;
        Integer num = this.logSource;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        int i3 = (hashCode ^ i) * 1000003;
        String str = this.logSourceName;
        if (str != null) {
            i2 = str.hashCode();
        }
        return QosTier.DEFAULT.hashCode() ^ ((((i3 ^ i2) * 1000003) ^ this.logEvents.hashCode()) * 1000003);
    }

    public final String toString() {
        return "LogRequest{requestTimeMs=" + this.requestTimeMs + ", requestUptimeMs=" + this.requestUptimeMs + ", clientInfo=" + this.clientInfo + ", logSource=" + this.logSource + ", logSourceName=" + this.logSourceName + ", logEvents=" + this.logEvents + ", qosTier=" + QosTier.DEFAULT + "}";
    }
}
