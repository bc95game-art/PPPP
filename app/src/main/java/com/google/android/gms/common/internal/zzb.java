package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.FakeDrag;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.base.zau;
/* loaded from: classes.dex */
public final class zzb extends zau {
    public final /* synthetic */ GmsClient zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzb(GmsClient gmsClient, Looper looper) {
        super(looper, 2);
        this.zza = gmsClient;
    }

    @Override // com.google.android.gms.internal.base.zau, android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        if (this.zza.zzd.get() != message.arg1) {
            int i = message.what;
            if (i == 2 || i == 1 || i == 7) {
                zza zzaVar = (zza) message.obj;
                zzaVar.getClass();
                zzaVar.zzg();
                return;
            }
            return;
        }
        int i2 = message.what;
        if ((i2 == 1 || i2 == 7 || i2 == 4 || i2 == 5) && !this.zza.isConnecting()) {
            zza zzaVar2 = (zza) message.obj;
            zzaVar2.getClass();
            zzaVar2.zzg();
            return;
        }
        int i3 = message.what;
        PendingIntent pendingIntent = null;
        if (i3 == 4) {
            GmsClient gmsClient = this.zza;
            gmsClient.zzB = new ConnectionResult(message.arg2);
            if (!gmsClient.zzC && !TextUtils.isEmpty(gmsClient.getServiceDescriptor()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(gmsClient.getServiceDescriptor());
                    GmsClient gmsClient2 = this.zza;
                    if (!gmsClient2.zzC) {
                        gmsClient2.zzp(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            GmsClient gmsClient3 = this.zza;
            ConnectionResult connectionResult = gmsClient3.zzB;
            if (connectionResult == null) {
                connectionResult = new ConnectionResult(8);
            }
            gmsClient3.zzc.onReportServiceBinding(connectionResult);
            System.currentTimeMillis();
        } else if (i3 == 5) {
            GmsClient gmsClient4 = this.zza;
            ConnectionResult connectionResult2 = gmsClient4.zzB;
            if (connectionResult2 == null) {
                connectionResult2 = new ConnectionResult(8);
            }
            gmsClient4.zzc.onReportServiceBinding(connectionResult2);
            System.currentTimeMillis();
        } else if (i3 == 3) {
            Object obj = message.obj;
            if (obj instanceof PendingIntent) {
                pendingIntent = (PendingIntent) obj;
            }
            this.zza.zzc.onReportServiceBinding(new ConnectionResult(message.arg2, pendingIntent));
            System.currentTimeMillis();
        } else if (i3 == 6) {
            this.zza.zzp(5, null);
            FakeDrag fakeDrag = this.zza.zzw;
            if (fakeDrag != null) {
                ((GoogleApiClient.ConnectionCallbacks) fakeDrag.mScrollEventAdapter).onConnectionSuspended(message.arg2);
            }
            System.currentTimeMillis();
            GmsClient.zzn(this.zza, 5, 1, null);
        } else if (i3 != 2 || this.zza.isConnected()) {
            int i4 = message.what;
            if (i4 == 2 || i4 == 1 || i4 == 7) {
                zza zzaVar3 = (zza) message.obj;
                synchronized (zzaVar3) {
                    try {
                        bool = zzaVar3.zza$1;
                        if (zzaVar3.zzb$1) {
                            String obj2 = zzaVar3.toString();
                            Log.w("GmsClient", "Callback proxy " + obj2 + " being reused. This is not safe.");
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (bool != null) {
                    GmsClient gmsClient5 = zzaVar3.zzc;
                    int i5 = zzaVar3.zza;
                    if (i5 != 0) {
                        gmsClient5.zzp(1, null);
                        Bundle bundle = zzaVar3.zzb;
                        if (bundle != null) {
                            pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
                        }
                        zzaVar3.zzb(new ConnectionResult(i5, pendingIntent));
                    } else if (!zzaVar3.zzd()) {
                        gmsClient5.zzp(1, null);
                        zzaVar3.zzb(new ConnectionResult(8, null));
                    }
                }
                synchronized (zzaVar3) {
                    zzaVar3.zzb$1 = true;
                }
                zzaVar3.zzg();
                return;
            }
            Log.wtf("GmsClient", ViewModelProvider.Factory.CC.m(i4, "Don't know how to handle message: "), new Exception());
        } else {
            zza zzaVar4 = (zza) message.obj;
            zzaVar4.getClass();
            zzaVar4.zzg();
        }
    }
}
