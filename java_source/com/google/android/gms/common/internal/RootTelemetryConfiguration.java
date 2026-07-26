package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.navigation.Navigation;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.zzb;
/* loaded from: classes.dex */
public final class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzb(26);
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd;
    public final int zze;

    public RootTelemetryConfiguration(int i, boolean z, boolean z2, int i2, int i3) {
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = i2;
        this.zze = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zza = Navigation.zza(parcel, 20293);
        Navigation.zzc(parcel, 1, 4);
        parcel.writeInt(this.zza);
        Navigation.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb ? 1 : 0);
        Navigation.zzc(parcel, 3, 4);
        parcel.writeInt(this.zzc ? 1 : 0);
        Navigation.zzc(parcel, 4, 4);
        parcel.writeInt(this.zzd);
        Navigation.zzc(parcel, 5, 4);
        parcel.writeInt(this.zze);
        Navigation.zzb(parcel, zza);
    }
}
