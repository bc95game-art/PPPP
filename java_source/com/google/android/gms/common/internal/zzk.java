package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.navigation.Navigation;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.zzb;
/* loaded from: classes.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzb(27);
    public Bundle zza;
    public Feature[] zzb;
    public int zzc;
    public ConnectionTelemetryConfiguration zzd;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zza = Navigation.zza(parcel, 20293);
        Bundle bundle = this.zza;
        if (bundle != null) {
            int zza2 = Navigation.zza(parcel, 1);
            parcel.writeBundle(bundle);
            Navigation.zzb(parcel, zza2);
        }
        Navigation.writeTypedArray(parcel, 2, this.zzb, i);
        int i2 = this.zzc;
        Navigation.zzc(parcel, 3, 4);
        parcel.writeInt(i2);
        Navigation.writeParcelable(parcel, 4, this.zzd, i);
        Navigation.zzb(parcel, zza);
    }
}
