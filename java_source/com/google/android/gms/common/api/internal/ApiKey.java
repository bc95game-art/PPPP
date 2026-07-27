package com.google.android.gms.common.api.internal;

import com.android.billingclient.api.zzcl;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class ApiKey {
    public final int zaa;
    public final zzcl zab;
    public final String zad;

    public ApiKey(zzcl zzclVar, String str) {
        this.zab = zzclVar;
        this.zad = str;
        this.zaa = Arrays.hashCode(new Object[]{zzclVar, TelemetryLoggingOptions.zaa, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApiKey)) {
            return false;
        }
        ApiKey apiKey = (ApiKey) obj;
        if (!zzah.equal(this.zab, apiKey.zab)) {
            return false;
        }
        TelemetryLoggingOptions telemetryLoggingOptions = TelemetryLoggingOptions.zaa;
        if (!zzah.equal(telemetryLoggingOptions, telemetryLoggingOptions) || !zzah.equal(this.zad, apiKey.zad)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zaa;
    }
}
