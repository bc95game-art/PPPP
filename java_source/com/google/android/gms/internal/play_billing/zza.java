package com.google.android.gms.internal.play_billing;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class zza implements zzgj {
    public static final zza zza = new zza(1);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zza(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.LinkedHashMap, com.google.android.gms.internal.play_billing.zzgf] */
    public static final zzgf zza(Object obj, Object obj2) {
        zzgf zzgfVar = (zzgf) obj;
        zzgf zzgfVar2 = (zzgf) obj2;
        if (!zzgfVar2.isEmpty()) {
            if (!zzgfVar.zzb) {
                if (zzgfVar.isEmpty()) {
                    zzgfVar = new zzgf();
                } else {
                    ?? linkedHashMap = new LinkedHashMap(zzgfVar);
                    linkedHashMap.zzb = true;
                    zzgfVar = linkedHashMap;
                }
            }
            zzgfVar.zzg();
            if (!zzgfVar2.isEmpty()) {
                zzgfVar.putAll(zzgfVar2);
            }
        }
        return zzgfVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgj
    public zzgu zzb(Class cls) {
        switch (this.$r8$classId) {
            case 1:
                if (zzfi.class.isAssignableFrom(cls)) {
                    try {
                        return (zzgu) zzfi.zzn(cls.asSubclass(zzfi.class)).zzb(3);
                    } catch (Exception e) {
                        throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                    }
                } else {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgj
    public boolean zzc(Class cls) {
        switch (this.$r8$classId) {
            case 1:
                return zzfi.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
