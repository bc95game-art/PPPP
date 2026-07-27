package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.gms.common.internal.zzr;
/* loaded from: classes.dex */
public final class SnackbarManager implements Factory {
    public static SnackbarManager snackbarManager;
    public final Object lock;

    public /* synthetic */ SnackbarManager(Object obj) {
        this.lock = obj;
    }

    public static SnackbarManager obtain(int i, int i2, int i3, boolean z) {
        return new SnackbarManager(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
    }

    @Override // javax.inject.Provider
    public Object get() {
        return this.lock;
    }

    public void pauseTimeout() {
        synchronized (this.lock) {
        }
    }

    public SnackbarManager() {
        this.lock = new Object();
        new Handler(Looper.getMainLooper(), new zzr(1, this));
    }
}
