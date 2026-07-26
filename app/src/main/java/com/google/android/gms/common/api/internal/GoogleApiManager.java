package com.google.android.gms.common.api.internal;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.navigation.Navigation;
import androidx.transition.Transition;
import com.android.billingclient.api.zzcl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zao;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.internal.common.zzd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p004j$.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class GoogleApiManager implements Handler.Callback {
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);
    public static final Status zab = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object zac = new Object();
    public static GoogleApiManager zad;
    public TelemetryData zag;
    public zao zah;
    public final Context zai;
    public final GoogleApiAvailability zaj;
    public final zau zar;
    public volatile boolean zas;
    public long zae = 10000;
    public boolean zaf = false;
    public final AtomicInteger zal = new AtomicInteger(1);
    public final AtomicInteger zam = new AtomicInteger(0);
    public final ConcurrentHashMap zan = new ConcurrentHashMap(5, 0.75f, 1);
    public final ArraySet zap = new ArraySet(0);
    public final ArraySet zaq = new ArraySet(0);
    public final zzcl zak = new zzcl(27);

    public GoogleApiManager(Context context, Looper looper) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
        boolean z = true;
        this.zas = true;
        this.zai = context;
        zau zauVar = new zau(looper, this, 0);
        Looper.getMainLooper();
        this.zar = zauVar;
        this.zaj = googleApiAvailability;
        PackageManager packageManager = context.getPackageManager();
        if (Navigation.zzj == null) {
            Navigation.zzj = Boolean.valueOf((Build.VERSION.SDK_INT < 26 || !packageManager.hasSystemFeature("android.hardware.type.automotive")) ? false : z);
        }
        if (Navigation.zzj.booleanValue()) {
            this.zas = false;
        }
        zauVar.sendMessage(zauVar.obtainMessage(6));
    }

    public static Status zaF(ApiKey apiKey, ConnectionResult connectionResult) {
        String valueOf = String.valueOf(connectionResult);
        return new Status(17, "API: " + ((String) apiKey.zab.zzc) + " is not available on this device. Connection failed with: " + valueOf, connectionResult.zzc, connectionResult);
    }

    public static GoogleApiManager zak(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zac) {
            try {
                if (zad == null) {
                    Looper looper = zzs.getOrStartHandlerThread().getLooper();
                    Context applicationContext = context.getApplicationContext();
                    Object obj = GoogleApiAvailability.zaa;
                    zad = new GoogleApiManager(applicationContext, looper);
                }
                googleApiManager = zad;
            } catch (Throwable th) {
                throw th;
            }
        }
        return googleApiManager;
    }

    /* JADX WARN: Type inference failed for: r1v55, types: [com.google.android.gms.common.internal.service.zao, com.google.android.gms.common.api.GoogleApi] */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zabq zabqVar;
        Status status;
        Feature[] zab2;
        int i = message.what;
        long j = 300000;
        switch (i) {
            case 1:
                if (true == ((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.zae = j;
                this.zar.removeMessages(12);
                for (ApiKey apiKey : this.zan.keySet()) {
                    zau zauVar = this.zar;
                    zauVar.sendMessageDelayed(zauVar.obtainMessage(12, apiKey), this.zae);
                }
                break;
            case 2:
                message.obj.getClass();
                throw new ClassCastException();
            case 3:
                for (zabq zabqVar2 : this.zan.values()) {
                    zzah.checkHandlerThread(zabqVar2.zaa.zar);
                    zabqVar2.zal = null;
                    zabqVar2.zao();
                }
                break;
            case 4:
            case 8:
            case 13:
                zach zachVar = (zach) message.obj;
                zabq zabqVar3 = (zabq) this.zan.get(zachVar.zac.zaf);
                if (zabqVar3 == null) {
                    zabqVar3 = zaG(zachVar.zac);
                }
                if (!zabqVar3.zac.requiresSignIn() || this.zam.get() == zachVar.zab) {
                    zabqVar3.zap(zachVar.zaa);
                    return true;
                }
                zachVar.zaa.zad(zaa);
                zabqVar3.zav();
                return true;
            case 5:
                int i2 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator it = this.zan.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        zabqVar = (zabq) it.next();
                        if (zabqVar.zah == i2) {
                        }
                    } else {
                        zabqVar = null;
                    }
                }
                if (zabqVar != null) {
                    int i3 = connectionResult.zzb;
                    if (i3 == 13) {
                        this.zaj.getClass();
                        AtomicBoolean atomicBoolean = GooglePlayServicesUtil.sCanceledAvailabilityNotification;
                        zabqVar.zaE(new Status(17, "Error resolution was canceled by the user, original error message: " + ConnectionResult.zza(i3) + ": " + connectionResult.zzd, null, null));
                        return true;
                    }
                    zabqVar.zaE(zaF(zabqVar.zad, connectionResult));
                    return true;
                }
                Log.wtf("GoogleApiManager", "Could not find API instance " + i2 + " while trying to fail enqueued calls.", new Exception());
                return true;
            case 6:
                if (this.zai.getApplicationContext() instanceof Application) {
                    Application application = (Application) this.zai.getApplicationContext();
                    BackgroundDetector backgroundDetector = BackgroundDetector.zza;
                    synchronized (backgroundDetector) {
                        try {
                            if (!backgroundDetector.zze) {
                                application.registerActivityLifecycleCallbacks(backgroundDetector);
                                application.registerComponentCallbacks(backgroundDetector);
                                backgroundDetector.zze = true;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    backgroundDetector.addListener(new zabl(this));
                    AtomicBoolean atomicBoolean2 = backgroundDetector.zzb;
                    AtomicBoolean atomicBoolean3 = backgroundDetector.zzc;
                    if (!atomicBoolean3.get()) {
                        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                        ActivityManager.getMyMemoryState(runningAppProcessInfo);
                        if (!atomicBoolean3.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                            atomicBoolean2.set(true);
                        }
                    }
                    if (!atomicBoolean2.get()) {
                        this.zae = 300000L;
                        return true;
                    }
                }
                break;
            case 7:
                zaG((GoogleApi) message.obj);
                return true;
            case 9:
                if (this.zan.containsKey(message.obj)) {
                    zabq zabqVar4 = (zabq) this.zan.get(message.obj);
                    zzah.checkHandlerThread(zabqVar4.zaa.zar);
                    if (zabqVar4.zaj) {
                        zabqVar4.zao();
                        return true;
                    }
                }
                break;
            case 10:
                ArraySet arraySet = this.zaq;
                arraySet.getClass();
                ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(arraySet);
                while (keyIterator.hasNext()) {
                    zabq zabqVar5 = (zabq) this.zan.remove((ApiKey) keyIterator.next());
                    if (zabqVar5 != null) {
                        zabqVar5.zav();
                    }
                }
                this.zaq.clear();
                return true;
            case 11:
                if (this.zan.containsKey(message.obj)) {
                    zabq zabqVar6 = (zabq) this.zan.get(message.obj);
                    GoogleApiManager googleApiManager = zabqVar6.zaa;
                    zzah.checkHandlerThread(googleApiManager.zar);
                    boolean z = zabqVar6.zaj;
                    if (z) {
                        ApiKey apiKey2 = zabqVar6.zad;
                        zau zauVar2 = zabqVar6.zaa.zar;
                        if (z) {
                            zauVar2.removeMessages(11, apiKey2);
                            zauVar2.removeMessages(9, apiKey2);
                            zabqVar6.zaj = false;
                        }
                        if (googleApiManager.zaj.isGooglePlayServicesAvailable(googleApiManager.zai, GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) == 18) {
                            status = new Status(21, "Connection timed out waiting for Google Play services update to complete.", null, null);
                        } else {
                            status = new Status(22, "API failed to connect while resuming due to an unknown error.", null, null);
                        }
                        zabqVar6.zaE(status);
                        zabqVar6.zac.disconnect("Timing out connection while resuming.");
                        return true;
                    }
                }
                break;
            case 12:
                if (this.zan.containsKey(message.obj)) {
                    zabq zabqVar7 = (zabq) this.zan.get(message.obj);
                    zzah.checkHandlerThread(zabqVar7.zaa.zar);
                    Api$Client api$Client = zabqVar7.zac;
                    if (api$Client.isConnected() && zabqVar7.zag.isEmpty()) {
                        zzcl zzclVar = zabqVar7.zae;
                        if (!((Map) zzclVar.zzb).isEmpty() || !((Map) zzclVar.zzc).isEmpty()) {
                            zabqVar7.zaJ();
                        } else {
                            api$Client.disconnect("Timing out service connection.");
                            return true;
                        }
                    }
                    return true;
                }
                break;
            case 14:
                message.obj.getClass();
                throw new ClassCastException();
            case 15:
                zabs zabsVar = (zabs) message.obj;
                if (this.zan.containsKey(zabsVar.zaa)) {
                    zabq zabqVar8 = (zabq) this.zan.get(zabsVar.zaa);
                    if (zabqVar8.zak.contains(zabsVar) && !zabqVar8.zaj) {
                        if (!zabqVar8.zac.isConnected()) {
                            zabqVar8.zao();
                            return true;
                        }
                        zabqVar8.zaG();
                        return true;
                    }
                }
                break;
            case 16:
                zabs zabsVar2 = (zabs) message.obj;
                if (this.zan.containsKey(zabsVar2.zaa)) {
                    zabq zabqVar9 = (zabq) this.zan.get(zabsVar2.zaa);
                    ArrayList arrayList = zabqVar9.zak;
                    GoogleApiManager googleApiManager2 = zabqVar9.zaa;
                    LinkedList<zac> linkedList = zabqVar9.zab;
                    if (arrayList.remove(zabsVar2)) {
                        googleApiManager2.zar.removeMessages(15, zabsVar2);
                        googleApiManager2.zar.removeMessages(16, zabsVar2);
                        Feature feature = zabsVar2.zab;
                        ArrayList arrayList2 = new ArrayList(linkedList.size());
                        for (zac zacVar : linkedList) {
                            if (!(zacVar == null || (zab2 = zacVar.zab(zabqVar9)) == null)) {
                                int length = zab2.length;
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= length) {
                                        break;
                                    } else if (!zzah.equal(zab2[i4], feature)) {
                                        i4++;
                                    } else if (i4 >= 0) {
                                        arrayList2.add(zacVar);
                                    }
                                }
                            }
                        }
                        int size = arrayList2.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            zac zacVar2 = (zac) arrayList2.get(i5);
                            linkedList.remove(zacVar2);
                            zacVar2.zae(new UnsupportedApiCallException(feature));
                        }
                        break;
                    }
                }
                break;
            case 17:
                zaI();
                return true;
            case 18:
                ((zace) message.obj).getClass();
                if (0 == 0) {
                    TelemetryData telemetryData = new TelemetryData(0, Arrays.asList(null));
                    if (this.zah == null) {
                        this.zah = new GoogleApi(this.zai, zao.zae, GoogleApi.Settings.DEFAULT_SETTINGS);
                    }
                    this.zah.log(telemetryData);
                    return true;
                }
                TelemetryData telemetryData2 = this.zag;
                if (telemetryData2 != null) {
                    List list = telemetryData2.zab;
                    if (telemetryData2.zaa != 0 || (list != null && list.size() >= 0)) {
                        this.zar.removeMessages(17);
                        zaI();
                    } else {
                        TelemetryData telemetryData3 = this.zag;
                        if (telemetryData3.zab == null) {
                            telemetryData3.zab = new ArrayList();
                        }
                        telemetryData3.zab.add(null);
                    }
                }
                if (this.zag == null) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(null);
                    this.zag = new TelemetryData(0, arrayList3);
                    zau zauVar3 = this.zar;
                    zauVar3.sendMessageDelayed(zauVar3.obtainMessage(17), 0L);
                    return true;
                }
                break;
            case 19:
                this.zaf = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i);
                return false;
        }
        return true;
    }

    public final boolean zaE(ConnectionResult connectionResult, int i) {
        boolean z;
        GoogleApiAvailability googleApiAvailability = this.zaj;
        googleApiAvailability.getClass();
        Context context = this.zai;
        if (!InstantApps.isInstantApp(context)) {
            int i2 = connectionResult.zzb;
            PendingIntent pendingIntent = connectionResult.zzc;
            if (i2 == 0 || pendingIntent == null) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                pendingIntent = null;
                Intent errorResolutionIntent = googleApiAvailability.getErrorResolutionIntent(i2, context, null);
                if (errorResolutionIntent != null) {
                    pendingIntent = PendingIntent.getActivity(context, 0, errorResolutionIntent, zzd.zza | 134217728);
                }
            }
            if (pendingIntent != null) {
                int i3 = GoogleApiActivity.$r8$clinit;
                Intent intent = new Intent(context, GoogleApiActivity.class);
                intent.putExtra("pending_intent", pendingIntent);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                googleApiAvailability.zae(context, i2, PendingIntent.getActivity(context, 0, intent, zap.zaa | 134217728));
                return true;
            }
        }
        return false;
    }

    public final zabq zaG(GoogleApi googleApi) {
        ApiKey apiKey = googleApi.zaf;
        ConcurrentHashMap concurrentHashMap = this.zan;
        zabq zabqVar = (zabq) concurrentHashMap.get(apiKey);
        if (zabqVar == null) {
            zabqVar = new zabq(this, googleApi);
            concurrentHashMap.put(apiKey, zabqVar);
        }
        if (zabqVar.zac.requiresSignIn()) {
            this.zaq.add(apiKey);
        }
        zabqVar.zao();
        return zabqVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
        if (r1 != 0) goto L26;
     */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.common.internal.service.zao, com.google.android.gms.common.api.GoogleApi] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zaI() {
        Transition.C01101 r2;
        TelemetryData telemetryData = this.zag;
        if (telemetryData != null) {
            if (telemetryData.zaa <= 0) {
                if (!this.zaf) {
                    synchronized (Transition.C01101.class) {
                        try {
                            if (Transition.C01101.zza == null) {
                                Transition.C01101.zza = new Transition.C01101(1);
                            }
                            r2 = Transition.C01101.zza;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    r2.getClass();
                    int i = ((SparseIntArray) this.zak.zzb).get(203400000, -1);
                    if (i != -1) {
                    }
                }
                this.zag = null;
            }
            if (this.zah == null) {
                this.zah = new GoogleApi(this.zai, zao.zae, GoogleApi.Settings.DEFAULT_SETTINGS);
            }
            this.zah.log(telemetryData);
            this.zag = null;
        }
    }

    public final void zax(ConnectionResult connectionResult, int i) {
        if (!zaE(connectionResult, i)) {
            zau zauVar = this.zar;
            zauVar.sendMessage(zauVar.obtainMessage(5, i, 0, connectionResult));
        }
    }
}
