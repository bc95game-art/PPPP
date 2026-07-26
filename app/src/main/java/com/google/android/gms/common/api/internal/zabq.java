package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.collection.ArraySet;
import androidx.collection.SimpleArrayMap;
import androidx.core.provider.CallbackWithHandler$2;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.FakeDrag;
import com.android.billingclient.api.zzab;
import com.android.billingclient.api.zzcl;
import com.android.billingclient.api.zzs;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.service.zan;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class zabq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public final /* synthetic */ GoogleApiManager zaa;
    public final Api$Client zac;
    public final ApiKey zad;
    public final zzcl zae;
    public final int zah;
    public boolean zaj;
    public final LinkedList zab = new LinkedList();
    public final HashSet zaf = new HashSet();
    public final HashMap zag = new HashMap();
    public final ArrayList zak = new ArrayList();
    public ConnectionResult zal = null;

    public zabq(GoogleApiManager googleApiManager, GoogleApi googleApi) {
        this.zaa = googleApiManager;
        Looper looper = googleApiManager.zar.getLooper();
        Context context = googleApi.zab;
        MatcherMatchResult matcherMatchResult = new MatcherMatchResult(18);
        Set set = Collections.EMPTY_SET;
        if (((ArraySet) matcherMatchResult.matcher) == null) {
            matcherMatchResult.matcher = new ArraySet(0);
        }
        ((ArraySet) matcherMatchResult.matcher).addAll(set);
        matcherMatchResult.groups = context.getClass().getName();
        matcherMatchResult.input = context.getPackageName();
        MatcherMatchResult matcherMatchResult2 = new MatcherMatchResult((ArraySet) matcherMatchResult.matcher, (String) matcherMatchResult.input, (String) matcherMatchResult.groups);
        zan zanVar = (zan) googleApi.zad.zzb;
        zzah.checkNotNull(zanVar);
        TelemetryLoggingOptions telemetryLoggingOptions = googleApi.zae;
        Context context2 = googleApi.zab;
        zanVar.getClass();
        zap zapVar = new zap(context2, looper, matcherMatchResult2, telemetryLoggingOptions, this, this);
        String str = googleApi.zac;
        if (str != null) {
            zapVar.zzA = str;
        }
        this.zac = zapVar;
        this.zad = googleApi.zaf;
        this.zae = new zzcl(24);
        this.zah = googleApi.zah;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected() {
        Looper myLooper = Looper.myLooper();
        zau zauVar = this.zaa.zar;
        if (myLooper == zauVar.getLooper()) {
            zaH();
        } else {
            zauVar.post(new zzab(11, this));
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zar(connectionResult, null);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        Looper myLooper = Looper.myLooper();
        zau zauVar = this.zaa.zar;
        if (myLooper == zauVar.getLooper()) {
            zaI(i);
        } else {
            zauVar.post(new CallbackWithHandler$2(i, 3, this));
        }
    }

    public final void zaD(ConnectionResult connectionResult) {
        HashSet hashSet = this.zaf;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else if (it.next() == null) {
            if (zzah.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                this.zac.getEndpointPackageName();
            }
            throw null;
        } else {
            throw new ClassCastException();
        }
    }

    public final void zaE(Status status) {
        zzah.checkHandlerThread(this.zaa.zar);
        zaF(status, null, false);
    }

    public final void zaF(Status status, Exception exc, boolean z) {
        boolean z2;
        zzah.checkHandlerThread(this.zaa.zar);
        boolean z3 = true;
        if (status != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (exc != null) {
            z3 = false;
        }
        if (z2 != z3) {
            Iterator it = this.zab.iterator();
            while (it.hasNext()) {
                zac zacVar = (zac) it.next();
                if (!z || zacVar.zac == 2) {
                    if (status != null) {
                        zacVar.zad(status);
                    } else {
                        zacVar.zae(exc);
                    }
                    it.remove();
                }
            }
            return;
        }
        throw new IllegalArgumentException("Status XOR exception should be null");
    }

    public final void zaG() {
        LinkedList linkedList = this.zab;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zac zacVar = (zac) arrayList.get(i);
            if (this.zac.isConnected()) {
                if (zaM(zacVar)) {
                    linkedList.remove(zacVar);
                }
            } else {
                return;
            }
        }
    }

    public final void zaH() {
        GoogleApiManager googleApiManager = this.zaa;
        zzah.checkHandlerThread(googleApiManager.zar);
        this.zal = null;
        zaD(ConnectionResult.RESULT_SUCCESS);
        zau zauVar = googleApiManager.zar;
        if (this.zaj) {
            ApiKey apiKey = this.zad;
            zauVar.removeMessages(11, apiKey);
            zauVar.removeMessages(9, apiKey);
            this.zaj = false;
        }
        Iterator it = this.zag.values().iterator();
        if (!it.hasNext()) {
            zaG();
            zaJ();
            return;
        }
        throw ViewModelProvider.Factory.CC.m(it);
    }

    public final void zaI(int i) {
        GoogleApiManager googleApiManager = this.zaa;
        zau zauVar = googleApiManager.zar;
        zzah.checkHandlerThread(googleApiManager.zar);
        this.zal = null;
        this.zaj = true;
        String lastDisconnectMessage = this.zac.getLastDisconnectMessage();
        zzcl zzclVar = this.zae;
        zzclVar.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (lastDisconnectMessage != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(lastDisconnectMessage);
        }
        zzclVar.zah(true, new Status(20, sb.toString(), null, null));
        ApiKey apiKey = this.zad;
        zauVar.sendMessageDelayed(Message.obtain(zauVar, 9, apiKey), 5000L);
        zauVar.sendMessageDelayed(Message.obtain(zauVar, 11, apiKey), 120000L);
        ((SparseIntArray) googleApiManager.zak.zzb).clear();
        Iterator it = this.zag.values().iterator();
        if (it.hasNext()) {
            throw ViewModelProvider.Factory.CC.m(it);
        }
    }

    public final void zaJ() {
        GoogleApiManager googleApiManager = this.zaa;
        zau zauVar = googleApiManager.zar;
        ApiKey apiKey = this.zad;
        zauVar.removeMessages(12, apiKey);
        zauVar.sendMessageDelayed(zauVar.obtainMessage(12, apiKey), googleApiManager.zae);
    }

    public final boolean zaM(zac zacVar) {
        Feature feature;
        if (zacVar != null) {
            Feature[] zab = zacVar.zab(this);
            if (!(zab == null || zab.length == 0)) {
                Feature[] availableFeatures = this.zac.getAvailableFeatures();
                if (availableFeatures == null) {
                    availableFeatures = new Feature[0];
                }
                SimpleArrayMap simpleArrayMap = new SimpleArrayMap(availableFeatures.length);
                for (Feature feature2 : availableFeatures) {
                    simpleArrayMap.put(feature2.zza, Long.valueOf(feature2.getVersion()));
                }
                int length = zab.length;
                for (int i = 0; i < length; i++) {
                    feature = zab[i];
                    Long l = (Long) simpleArrayMap.get(feature.zza);
                    if (l == null || l.longValue() < feature.getVersion()) {
                        break;
                    }
                }
            }
            feature = null;
            if (feature == null) {
                zzcl zzclVar = this.zae;
                Api$Client api$Client = this.zac;
                zacVar.zag(zzclVar, api$Client.requiresSignIn());
                try {
                    zacVar.zaf(this);
                    return true;
                } catch (DeadObjectException unused) {
                    onConnectionSuspended(1);
                    api$Client.disconnect("DeadObjectException thrown while running ApiCallRunner.");
                    return true;
                }
            } else {
                Log.w("GoogleApiManager", this.zac.getClass().getName() + " could not execute call because it requires feature (" + feature.zza + ", " + feature.getVersion() + ").");
                if (!this.zaa.zas || !zacVar.zaa(this)) {
                    zacVar.zae(new UnsupportedApiCallException(feature));
                    return true;
                }
                zabs zabsVar = new zabs(this.zad, feature);
                int indexOf = this.zak.indexOf(zabsVar);
                if (indexOf >= 0) {
                    zabs zabsVar2 = (zabs) this.zak.get(indexOf);
                    this.zaa.zar.removeMessages(15, zabsVar2);
                    zau zauVar = this.zaa.zar;
                    zauVar.sendMessageDelayed(Message.obtain(zauVar, 15, zabsVar2), 5000L);
                } else {
                    this.zak.add(zabsVar);
                    zau zauVar2 = this.zaa.zar;
                    zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 15, zabsVar), 5000L);
                    zau zauVar3 = this.zaa.zar;
                    zauVar3.sendMessageDelayed(Message.obtain(zauVar3, 16, zabsVar), 120000L);
                    ConnectionResult connectionResult = new ConnectionResult(2, null);
                    if (!zaN(connectionResult)) {
                        this.zaa.zaE(connectionResult, this.zah);
                    }
                }
                return false;
            }
        } else {
            zzcl zzclVar2 = this.zae;
            Api$Client api$Client2 = this.zac;
            zacVar.zag(zzclVar2, api$Client2.requiresSignIn());
            try {
                zacVar.zaf(this);
                return true;
            } catch (DeadObjectException unused2) {
                onConnectionSuspended(1);
                api$Client2.disconnect("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
    }

    public final boolean zaN(ConnectionResult connectionResult) {
        synchronized (GoogleApiManager.zac) {
        }
        return false;
    }

    public final void zao() {
        GoogleApiManager googleApiManager = this.zaa;
        zzah.checkHandlerThread(googleApiManager.zar);
        Api$Client api$Client = this.zac;
        if (!api$Client.isConnected() && !api$Client.isConnecting()) {
            try {
                zzcl zzclVar = googleApiManager.zak;
                Context context = googleApiManager.zai;
                SparseIntArray sparseIntArray = (SparseIntArray) zzclVar.zzb;
                zzah.checkNotNull(context);
                int minApkVersion = api$Client.getMinApkVersion();
                int i = ((SparseIntArray) zzclVar.zzb).get(minApkVersion, -1);
                if (i == -1) {
                    i = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= sparseIntArray.size()) {
                            i = -1;
                            break;
                        }
                        int keyAt = sparseIntArray.keyAt(i2);
                        if (keyAt > minApkVersion && sparseIntArray.get(keyAt) == 0) {
                            break;
                        }
                        i2++;
                    }
                    if (i == -1) {
                        i = ((GoogleApiAvailability) zzclVar.zzc).isGooglePlayServicesAvailable(context, minApkVersion);
                    }
                    sparseIntArray.put(minApkVersion, i);
                }
                if (i != 0) {
                    ConnectionResult connectionResult = new ConnectionResult(i, null);
                    String name = api$Client.getClass().getName();
                    String connectionResult2 = connectionResult.toString();
                    Log.w("GoogleApiManager", "The service for " + name + " is not available: " + connectionResult2);
                    zar(connectionResult, null);
                    return;
                }
                zzs zzsVar = new zzs(googleApiManager, api$Client, this.zad);
                if (!api$Client.requiresSignIn()) {
                    try {
                        api$Client.connect(zzsVar);
                    } catch (SecurityException e) {
                        zar(new ConnectionResult(10), e);
                    }
                } else {
                    zzah.checkNotNull(null);
                    throw null;
                }
            } catch (IllegalStateException e2) {
                zar(new ConnectionResult(10), e2);
            }
        }
    }

    public final void zap(zac zacVar) {
        zzah.checkHandlerThread(this.zaa.zar);
        boolean isConnected = this.zac.isConnected();
        LinkedList linkedList = this.zab;
        if (!isConnected) {
            linkedList.add(zacVar);
            ConnectionResult connectionResult = this.zal;
            if (connectionResult == null || connectionResult.zzb == 0 || connectionResult.zzc == null) {
                zao();
            } else {
                zar(connectionResult, null);
            }
        } else if (zaM(zacVar)) {
            zaJ();
        } else {
            linkedList.add(zacVar);
        }
    }

    public final void zar(ConnectionResult connectionResult, RuntimeException runtimeException) {
        zzah.checkHandlerThread(this.zaa.zar);
        zzah.checkHandlerThread(this.zaa.zar);
        this.zal = null;
        ((SparseIntArray) this.zaa.zak.zzb).clear();
        zaD(connectionResult);
        if ((this.zac instanceof zap) && connectionResult.zzb != 24) {
            GoogleApiManager googleApiManager = this.zaa;
            googleApiManager.zaf = true;
            zau zauVar = googleApiManager.zar;
            zauVar.sendMessageDelayed(zauVar.obtainMessage(19), 300000L);
        }
        if (connectionResult.zzb == 4) {
            zaE(GoogleApiManager.zab);
        } else if (this.zab.isEmpty()) {
            this.zal = connectionResult;
        } else if (runtimeException != null) {
            zzah.checkHandlerThread(this.zaa.zar);
            zaF(null, runtimeException, false);
        } else if (this.zaa.zas) {
            zaF(GoogleApiManager.zaF(this.zad, connectionResult), null, true);
            if (!this.zab.isEmpty() && !zaN(connectionResult) && !this.zaa.zaE(connectionResult, this.zah)) {
                if (connectionResult.zzb == 18) {
                    this.zaj = true;
                }
                if (this.zaj) {
                    GoogleApiManager googleApiManager2 = this.zaa;
                    ApiKey apiKey = this.zad;
                    zau zauVar2 = googleApiManager2.zar;
                    zauVar2.sendMessageDelayed(Message.obtain(zauVar2, 9, apiKey), 5000L);
                    return;
                }
                zaE(GoogleApiManager.zaF(this.zad, connectionResult));
            }
        } else {
            zaE(GoogleApiManager.zaF(this.zad, connectionResult));
        }
    }

    public final void zav() {
        ListenerHolder$ListenerKey[] listenerHolder$ListenerKeyArr;
        zzah.checkHandlerThread(this.zaa.zar);
        Status status = GoogleApiManager.zaa;
        zaE(status);
        this.zae.zah(false, status);
        for (ListenerHolder$ListenerKey listenerHolder$ListenerKey : (ListenerHolder$ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder$ListenerKey[0])) {
            zap(new zah(new TaskCompletionSource()));
        }
        zaD(new ConnectionResult(4));
        Api$Client api$Client = this.zac;
        if (api$Client.isConnected()) {
            api$Client.onUserSignOut(new FakeDrag(22, this));
        }
    }
}
