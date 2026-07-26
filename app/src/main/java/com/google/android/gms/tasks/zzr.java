package com.google.android.gms.tasks;

import android.os.Parcel;
import androidx.viewpager2.widget.FakeDrag;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.internal.base.zac;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class zzr {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;
    public Object zzb;
    public boolean zzc;

    public zzr() {
        this.$r8$classId = 0;
        this.zza = new Object();
    }

    public static String checkInstantiable(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("r8-abstract-class");
    }

    /* JADX WARN: Finally extract failed */
    public void doExecute(Api$Client api$Client, TaskCompletionSource taskCompletionSource) {
        FakeDrag fakeDrag = (FakeDrag) ((FakeDrag) this.zzb).mScrollEventAdapter;
        fakeDrag.getClass();
        zai zaiVar = (zai) ((zap) api$Client).getService();
        TelemetryData telemetryData = (TelemetryData) fakeDrag.mScrollEventAdapter;
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(zaiVar.zab);
        int i = zac.$r8$clinit;
        if (telemetryData == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            telemetryData.writeToParcel(obtain, 0);
        }
        try {
            zaiVar.zaa.transact(1, obtain, null, 1);
            obtain.recycle();
            zzw zzwVar = taskCompletionSource.zza;
            synchronized (zzwVar.zza) {
                zzwVar.zzh();
                zzwVar.zzc = true;
                zzwVar.zze = null;
            }
            ((zzr) zzwVar.zzb).zzb(zzwVar);
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0101, code lost:
        if (com.google.gson.internal.Streams.getRawType(r0[0]) != java.lang.String.class) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.gson.internal.ObjectConstructor get(com.google.gson.reflect.TypeToken r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.zzr.get(com.google.gson.reflect.TypeToken, boolean):com.google.gson.internal.ObjectConstructor");
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                return ((Map) this.zza).toString();
            default:
                return super.toString();
        }
    }

    public void zzb(zzw zzwVar) {
        zzj zzjVar;
        synchronized (this.zza) {
            if (((ArrayDeque) this.zzb) != null && !this.zzc) {
                this.zzc = true;
                while (true) {
                    synchronized (this.zza) {
                        try {
                            zzjVar = (zzj) ((ArrayDeque) this.zzb).poll();
                            if (zzjVar == null) {
                                this.zzc = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    zzjVar.zzd(zzwVar);
                }
            }
        }
    }

    public zzr(FakeDrag fakeDrag, Feature[] featureArr) {
        this.$r8$classId = 1;
        this.zzb = fakeDrag;
        this.zza = featureArr;
        this.zzc = false;
    }

    public zzr(Map map, boolean z, List list) {
        this.$r8$classId = 2;
        this.zza = map;
        this.zzc = z;
        this.zzb = list;
    }
}
