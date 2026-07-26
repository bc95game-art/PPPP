package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzbu {
    public final Object zza;
    public final Object zzb;
    public final Object zzc;

    public zzbu(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    public final IllegalArgumentException zza() {
        Object obj = this.zza;
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(this.zzb);
        String valueOf3 = String.valueOf(obj);
        String valueOf4 = String.valueOf(this.zzc);
        return new IllegalArgumentException("Multiple entries with same key: " + valueOf + "=" + valueOf2 + " and " + valueOf3 + "=" + valueOf4);
    }
}
