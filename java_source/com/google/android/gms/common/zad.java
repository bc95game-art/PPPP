package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.internal.common.zzd;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class zad extends zau {
    public final /* synthetic */ GoogleApiAvailability zaa;
    public final Context zab;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zad(GoogleApiAvailability googleApiAvailability, Context context) {
        super(r2, 0);
        Looper looper;
        this.zaa = googleApiAvailability;
        if (Looper.myLooper() == null) {
            looper = Looper.getMainLooper();
        } else {
            looper = Looper.myLooper();
        }
        this.zab = context.getApplicationContext();
    }

    @Override // com.google.android.gms.internal.base.zau, android.os.Handler
    public final void handleMessage(Message message) {
        PendingIntent pendingIntent;
        int i = message.what;
        if (i != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i);
            return;
        }
        int i2 = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        GoogleApiAvailability googleApiAvailability = this.zaa;
        Context context = this.zab;
        int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context, i2);
        AtomicBoolean atomicBoolean = GooglePlayServicesUtil.sCanceledAvailabilityNotification;
        if (isGooglePlayServicesAvailable == 1 || isGooglePlayServicesAvailable == 2 || isGooglePlayServicesAvailable == 3 || isGooglePlayServicesAvailable == 9) {
            Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(isGooglePlayServicesAvailable, context, "n");
            if (errorResolutionIntent == null) {
                pendingIntent = null;
            } else {
                pendingIntent = PendingIntent.getActivity(context, 0, errorResolutionIntent, zzd.zza | 134217728);
            }
            googleApiAvailability.zae(context, isGooglePlayServicesAvailable, pendingIntent);
        }
    }
}
