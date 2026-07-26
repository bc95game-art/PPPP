package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.android.billingclient.api.zzcl;
/* loaded from: classes.dex */
public final class zabx extends BroadcastReceiver {
    public Context zaa;
    public final zzcl zab;

    public zabx(zzcl zzclVar) {
        this.zab = zzclVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String str;
        Uri data = intent.getData();
        if (data != null) {
            str = data.getSchemeSpecificPart();
        } else {
            str = null;
        }
        if ("com.google.android.gms".equals(str)) {
            Object obj = this.zab.zzc;
            throw null;
        }
    }
}
