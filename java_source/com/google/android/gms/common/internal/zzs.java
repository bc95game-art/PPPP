package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.base.zau;
import java.util.HashMap;
import p004j$.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class zzs {
    public static HandlerThread zza;
    public static final Object zzb$1 = new Object();
    public static zzs zzc$1;
    public final HashMap zzb = new HashMap();
    public final Context zzc;
    public volatile zau zzd;
    public final ConnectionTracker zzf;
    public final long zzg;
    public final long zzh;

    /* JADX WARN: Type inference failed for: r4v3, types: [com.google.android.gms.common.stats.ConnectionTracker, java.lang.Object] */
    public zzs(Context context, Looper looper) {
        zzr zzrVar = new zzr(0, this);
        this.zzc = context.getApplicationContext();
        zau zauVar = new zau(looper, zzrVar, 2);
        Looper.getMainLooper();
        this.zzd = zauVar;
        if (ConnectionTracker.zzc == null) {
            synchronized (ConnectionTracker.zzb) {
                try {
                    if (ConnectionTracker.zzc == null) {
                        ?? obj = new Object();
                        new ConcurrentHashMap();
                        ConnectionTracker.zzc = obj;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        ConnectionTracker connectionTracker = ConnectionTracker.zzc;
        zzah.checkNotNull(connectionTracker);
        this.zzf = connectionTracker;
        this.zzg = 5000L;
        this.zzh = 300000L;
    }

    public static HandlerThread getOrStartHandlerThread() {
        synchronized (zzb$1) {
            try {
                HandlerThread handlerThread = zza;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                zza = handlerThread2;
                handlerThread2.start();
                return zza;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb(String str, ServiceConnection serviceConnection, boolean z) {
        zzo zzoVar = new zzo(str, z);
        zzah.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zzb) {
            try {
                zzp zzpVar = (zzp) this.zzb.get(zzoVar);
                if (zzpVar == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(zzoVar.toString()));
                } else if (zzpVar.zzb.containsKey(serviceConnection)) {
                    zzpVar.zzb.remove(serviceConnection);
                    if (zzpVar.zzb.isEmpty()) {
                        this.zzd.sendMessageDelayed(this.zzd.obtainMessage(0, zzoVar), this.zzg);
                    }
                } else {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(zzoVar.toString()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzc(zzo zzoVar, zze zzeVar, String str) {
        boolean z;
        synchronized (this.zzb) {
            try {
                zzp zzpVar = (zzp) this.zzb.get(zzoVar);
                if (zzpVar == null) {
                    zzpVar = new zzp(this, zzoVar);
                    zzpVar.zzb.put(zzeVar, zzeVar);
                    zzpVar.zze(str, null);
                    this.zzb.put(zzoVar, zzpVar);
                } else {
                    this.zzd.removeMessages(0, zzoVar);
                    if (!zzpVar.zzb.containsKey(zzeVar)) {
                        zzpVar.zzb.put(zzeVar, zzeVar);
                        int i = zzpVar.zzc;
                        if (i == 1) {
                            zzeVar.onServiceConnected(zzpVar.zzg, zzpVar.zze);
                        } else if (i == 2) {
                            zzpVar.zze(str, null);
                        }
                    } else {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(zzoVar.toString()));
                    }
                }
                z = zzpVar.zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
