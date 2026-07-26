package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public enum zzil {
    zza("BROADCAST_ACTION_UNSPECIFIED"),
    zzb("PURCHASES_UPDATED_ACTION"),
    zzc("LOCAL_PURCHASES_UPDATED_ACTION"),
    zzd("ALTERNATIVE_BILLING_ACTION");
    
    public final int zzf;

    zzil(String str) {
        this.zzf = r2;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzf);
    }
}
