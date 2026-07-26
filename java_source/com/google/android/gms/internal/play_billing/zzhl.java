package com.google.android.gms.internal.play_billing;
/* loaded from: classes.dex */
public final class zzhl extends zzhn {
    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final double zza(long j, Object obj) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final float zzb(long j, Object obj) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final void zzc(Object obj, long j, boolean z) {
        if (zzho.zzb) {
            zzho.zzD(obj, j, z);
        } else {
            zzho.zzE(obj, j, z ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final void zzd(Object obj, long j, byte b) {
        if (zzho.zzb) {
            zzho.zzD(obj, j, b);
        } else {
            zzho.zzE(obj, j, b);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.play_billing.zzhn
    public final boolean zzg(long j, Object obj) {
        if (zzho.zzb) {
            return zzho.zzt(j, obj);
        }
        return zzho.zzu(j, obj);
    }
}
