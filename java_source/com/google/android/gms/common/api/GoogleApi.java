package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import androidx.transition.ViewUtilsApi21;
import com.android.billingclient.api.zzcl;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.base.zau;
/* loaded from: classes.dex */
public abstract class GoogleApi {
    public final GoogleApiManager zaa;
    public final Context zab;
    public final String zac;
    public final zzcl zad;
    public final TelemetryLoggingOptions zae;
    public final ApiKey zaf;
    public final int zah;
    public final ViewUtilsApi21 zaj;

    /* loaded from: classes.dex */
    public final class Settings {
        public static final Settings DEFAULT_SETTINGS = new Settings(new Object(), Looper.getMainLooper());
        public final ViewUtilsApi21 zaa;

        public Settings(ViewUtilsApi21 viewUtilsApi21, Looper looper) {
            this.zaa = viewUtilsApi21;
        }
    }

    public GoogleApi(Context context, zzcl zzclVar, Settings settings) {
        String str;
        zzah.checkNotNull(context, "Null context is not permitted.");
        zzah.checkNotNull(zzclVar, "Api must not be null.");
        zzah.checkNotNull(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        zzah.checkNotNull(applicationContext, "The provided context did not have an application context.");
        this.zab = applicationContext;
        if (Build.VERSION.SDK_INT >= 30) {
            str = context.getAttributionTag();
        } else {
            str = null;
        }
        this.zac = str;
        this.zad = zzclVar;
        this.zae = TelemetryLoggingOptions.zaa;
        this.zaf = new ApiKey(zzclVar, str);
        GoogleApiManager zak = GoogleApiManager.zak(applicationContext);
        this.zaa = zak;
        this.zah = zak.zal.getAndIncrement();
        this.zaj = settings.zaa;
        zau zauVar = zak.zar;
        zauVar.sendMessage(zauVar.obtainMessage(7, this));
    }
}
