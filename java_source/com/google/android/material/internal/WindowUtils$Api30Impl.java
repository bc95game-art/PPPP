package com.google.android.material.internal;

import android.graphics.Rect;
import android.view.WindowManager;
/* loaded from: classes.dex */
public abstract class WindowUtils$Api30Impl {
    public static Rect getCurrentWindowBounds(WindowManager windowManager) {
        return windowManager.getCurrentWindowMetrics().getBounds();
    }
}
