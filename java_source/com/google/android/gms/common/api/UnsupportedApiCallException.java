package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
/* loaded from: classes.dex */
public final class UnsupportedApiCallException extends UnsupportedOperationException {
    public final Feature zza;

    public UnsupportedApiCallException(Feature feature) {
        this.zza = feature;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.zza));
    }
}
