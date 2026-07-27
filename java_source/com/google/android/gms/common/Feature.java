package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.navigation.Navigation;
import com.android.billingclient.api.zzcl;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzc(0);
    public final String zza;
    public final int zzb;
    public final long zzc;

    public Feature() {
        this.zza = "CLIENT_TELEMETRY";
        this.zzc = 1L;
        this.zzb = -1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = feature.zza;
            String str2 = this.zza;
            if (((str2 != null && str2.equals(str)) || (str2 == null && str == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    public final long getVersion() {
        long j = this.zzc;
        return j == -1 ? this.zzb : j;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(getVersion())});
    }

    public final String toString() {
        zzcl zzclVar = new zzcl(this);
        zzclVar.add(this.zza, "name");
        zzclVar.add(Long.valueOf(getVersion()), "version");
        return zzclVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zza = Navigation.zza(parcel, 20293);
        Navigation.writeString(parcel, 1, this.zza);
        Navigation.zzc(parcel, 2, 4);
        parcel.writeInt(this.zzb);
        long version = getVersion();
        Navigation.zzc(parcel, 3, 8);
        parcel.writeLong(version);
        Navigation.zzb(parcel, zza);
    }

    public Feature(String str, int i, long j) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }
}
