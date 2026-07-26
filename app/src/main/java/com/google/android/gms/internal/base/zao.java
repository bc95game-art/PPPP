package com.google.android.gms.internal.base;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.p002os.BundleKt;
import com.google.android.gms.common.api.internal.zabx;
/* loaded from: classes.dex */
public abstract class zao extends BundleKt {
    public static void zaa(Context context, zabx zabxVar, IntentFilter intentFilter) {
        int i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            if (i2 >= 33) {
                i = 2;
            } else {
                i = 0;
            }
            context.registerReceiver(zabxVar, intentFilter, i);
            return;
        }
        context.registerReceiver(zabxVar, intentFilter);
    }
}
