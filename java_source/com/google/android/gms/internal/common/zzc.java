package com.google.android.gms.internal.common;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.ViewModelProvider;
/* loaded from: classes.dex */
public abstract class zzc {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        zzc.class.getClassLoader();
    }

    public static Parcelable zza(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void zzb(Parcel parcel) {
        int dataAvail = parcel.dataAvail();
        if (dataAvail > 0) {
            throw new BadParcelableException(ViewModelProvider.Factory.CC.m604m(dataAvail, "Parcel data not fully consumed, unread size: "));
        }
    }
}
