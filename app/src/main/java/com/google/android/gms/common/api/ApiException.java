package com.google.android.gms.common.api;
/* loaded from: classes.dex */
public class ApiException extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApiException(Status status) {
        super(r0 + ": " + r3);
        int i = status.zzb;
        String str = status.zzc;
        str = str == null ? "" : str;
    }
}
