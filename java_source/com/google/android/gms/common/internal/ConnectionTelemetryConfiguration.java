package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.navigation.Navigation;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.zzb;
/* loaded from: classes.dex */
public final class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new zzb(28);
    public final RootTelemetryConfiguration zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int[] zzd;
    public final int zze;
    public final int[] zzf;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = iArr;
        this.zze = i;
        this.zzf = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zza = Navigation.zza(parcel, 20293);
        Navigation.writeParcelable(parcel, 1, this.zza, i);
        Navigation.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        Navigation.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        int[] iArr = this.zzd;
        if (iArr != null) {
            int zza2 = Navigation.zza(parcel, 4);
            parcel.writeIntArray(iArr);
            Navigation.zzb(parcel, zza2);
        }
        Navigation.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze);
        int[] iArr2 = this.zzf;
        if (iArr2 != null) {
            int zza3 = Navigation.zza(parcel, 6);
            parcel.writeIntArray(iArr2);
            Navigation.zzb(parcel, zza3);
        }
        Navigation.zzb(parcel, zza);
    }
}
