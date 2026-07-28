package com.google.android.gms.internal.play_billing;

import java.nio.charset.Charset;
import p004j$.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class zzgs {
    public static final zzgs zzb = new zzgs();
    public final ConcurrentHashMap zzd = new ConcurrentHashMap();
    public final zzgd zzc = new zzgd();

    public final zzgv zzb(Class cls) {
        zzgv zzgvVar;
        zza zzaVar;
        Charset charset = zzfo.zza;
        if (cls != null) {
            ConcurrentHashMap concurrentHashMap = this.zzd;
            zzgv zzgvVar2 = (zzgv) concurrentHashMap.get(cls);
            if (zzgvVar2 != null) {
                return zzgvVar2;
            }
            zzgd zzgdVar = this.zzc;
            zzgdVar.getClass();
            zza zzaVar2 = zzgx.zzb;
            zzfi.class.isAssignableFrom(cls);
            zzgu zzb2 = ((zzgd) zzgdVar.zzb).zzb(cls);
            if ((zzb2.zzd & 2) == 2) {
                zza zzaVar3 = zzgx.zzb;
                zza zzaVar4 = zzex.zza;
                zzgvVar = new zzgp(zzaVar3, zzb2.zza);
            } else {
                int i = zzgr.$r8$clinit;
                int i2 = zzfz.$r8$clinit;
                zza zzaVar5 = zzgx.zzb;
                if (zzb2.zzc() - 1 != 1) {
                    zzaVar = zzex.zza;
                } else {
                    zzaVar = null;
                }
                int i3 = zzgh.$r8$clinit;
                zzgvVar = zzgo.zzl(zzb2, zzaVar5, zzaVar);
            }
            zzgv zzgvVar3 = (zzgv) concurrentHashMap.putIfAbsent(cls, zzgvVar);
            if (zzgvVar3 != null) {
                return zzgvVar3;
            }
            return zzgvVar;
        }
        throw new NullPointerException("messageType");
    }
}
