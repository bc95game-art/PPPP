package com.google.android.gms.common.internal.service;

import androidx.transition.Transition;
import androidx.viewpager2.widget.FakeDrag;
import com.android.billingclient.api.zzcl;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zach;
import com.google.android.gms.common.api.internal.zag;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.internal.base.zau;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.zzr;
import com.google.android.gms.tasks.zzw;
/* loaded from: classes.dex */
public final class zao extends GoogleApi {
    public static final zzcl zae = new zzcl((zan) new Object(), new Transition.AnonymousClass1(17));

    public final zzw log(TelemetryData telemetryData) {
        FakeDrag fakeDrag = new FakeDrag(21);
        Feature[] featureArr = {zaf.zaa};
        fakeDrag.mScrollEventAdapter = new FakeDrag(23, telemetryData);
        zzr zzrVar = new zzr(fakeDrag, featureArr);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.getClass();
        zach zachVar = new zach(new zag(zzrVar, taskCompletionSource, this.zaj), googleApiManager.zam.get(), this);
        zau zauVar = googleApiManager.zar;
        zauVar.sendMessage(zauVar.obtainMessage(4, zachVar));
        return taskCompletionSource.zza;
    }
}
