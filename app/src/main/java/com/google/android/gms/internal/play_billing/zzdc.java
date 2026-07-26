package com.google.android.gms.internal.play_billing;

import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public final class zzdc extends TimeoutException {
    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
