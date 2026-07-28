package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class zzak extends zzap implements zzam {
    public final int zzc(int i, String str, String str2, Bundle bundle) {
        Parcel zzs = zzs();
        zzs.writeInt(i);
        zzs.writeString(str);
        zzs.writeString(str2);
        int i2 = zzar.$r8$clinit;
        zzs.writeInt(1);
        bundle.writeToParcel(zzs, 0);
        Parcel zzt = zzt(zzs, 10);
        int readInt = zzt.readInt();
        zzt.recycle();
        return readInt;
    }

    public final Bundle zzd(Bundle bundle, String str, String str2) {
        Parcel zzs = zzs();
        zzs.writeInt(9);
        zzs.writeString(str);
        zzs.writeString(str2);
        int i = zzar.$r8$clinit;
        zzs.writeInt(1);
        bundle.writeToParcel(zzs, 0);
        Parcel zzt = zzt(zzs, 902);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) zzar.zza(zzt);
        zzt.recycle();
        return bundle2;
    }

    public final Bundle zze(Bundle bundle, String str, String str2) {
        Parcel zzs = zzs();
        zzs.writeInt(9);
        zzs.writeString(str);
        zzs.writeString(str2);
        int i = zzar.$r8$clinit;
        zzs.writeInt(1);
        bundle.writeToParcel(zzs, 0);
        Parcel zzt = zzt(zzs, 12);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) zzar.zza(zzt);
        zzt.recycle();
        return bundle2;
    }

    public final Bundle zzf(String str, String str2, String str3) {
        Parcel zzs = zzs();
        zzs.writeInt(3);
        zzs.writeString(str);
        zzs.writeString(str2);
        zzs.writeString(str3);
        zzs.writeString(null);
        Parcel zzt = zzt(zzs, 3);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle = (Bundle) zzar.zza(zzt);
        zzt.recycle();
        return bundle;
    }

    public final Bundle zzg(int i, String str, String str2, String str3, Bundle bundle) {
        Parcel zzs = zzs();
        zzs.writeInt(i);
        zzs.writeString(str);
        zzs.writeString(str2);
        zzs.writeString(str3);
        zzs.writeString(null);
        int i2 = zzar.$r8$clinit;
        zzs.writeInt(1);
        bundle.writeToParcel(zzs, 0);
        Parcel zzt = zzt(zzs, 8);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) zzar.zza(zzt);
        zzt.recycle();
        return bundle2;
    }

    public final Bundle zzh(String str, String str2) {
        Parcel zzs = zzs();
        zzs.writeInt(3);
        zzs.writeString(str);
        zzs.writeString("inapp");
        zzs.writeString(str2);
        Parcel zzt = zzt(zzs, 4);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle = (Bundle) zzar.zza(zzt);
        zzt.recycle();
        return bundle;
    }

    public final Bundle zzi(int i, String str, String str2, Bundle bundle) {
        Parcel zzs = zzs();
        zzs.writeInt(i);
        zzs.writeString(str);
        zzs.writeString("inapp");
        zzs.writeString(str2);
        int i2 = zzar.$r8$clinit;
        zzs.writeInt(1);
        bundle.writeToParcel(zzs, 0);
        Parcel zzt = zzt(zzs, 11);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) zzar.zza(zzt);
        zzt.recycle();
        return bundle2;
    }

    public final Bundle zzj(int i, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel zzs = zzs();
        zzs.writeInt(i);
        zzs.writeString(str);
        zzs.writeString(str2);
        int i2 = zzar.$r8$clinit;
        zzs.writeInt(1);
        bundle.writeToParcel(zzs, 0);
        zzs.writeInt(1);
        bundle2.writeToParcel(zzs, 0);
        Parcel zzt = zzt(zzs, 901);
        Parcelable.Creator creator = Bundle.CREATOR;
        Bundle bundle3 = (Bundle) zzar.zza(zzt);
        zzt.recycle();
        return bundle3;
    }
}
