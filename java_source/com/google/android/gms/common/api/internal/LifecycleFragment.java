package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
/* loaded from: classes.dex */
public interface LifecycleFragment {
    Activity getLifecycleActivity();

    void startActivityForResult(Intent intent, int i);
}
