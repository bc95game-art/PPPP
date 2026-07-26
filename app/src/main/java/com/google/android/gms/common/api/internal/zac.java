package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.android.billingclient.api.zzcl;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public abstract class zac {
    public final int zac;

    public zac(int i) {
        this.zac = i;
    }

    public static Status zah(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage(), null, null);
    }

    public abstract boolean zaa(zabq zabqVar);

    public abstract Feature[] zab(zabq zabqVar);

    public abstract void zad(Status status);

    public abstract void zae(Exception exc);

    public abstract void zaf(zabq zabqVar);

    public abstract void zag(zzcl zzclVar, boolean z);
}
