package com.google.android.gms.internal.base;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.lifecycle.ViewModelProvider;
import com.android.billingclient.api.zzcb;
import com.google.android.gms.internal.play_billing.zzar;
/* loaded from: classes.dex */
public abstract class zab extends Binder implements IInterface {
    public final /* synthetic */ int $r8$classId = 2;

    public /* synthetic */ zab() {
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        int i = this.$r8$classId;
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (this.$r8$classId) {
            case 1:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i2)) {
                    return true;
                }
                return zza(i, parcel, parcel2);
            case 2:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i2)) {
                    return true;
                }
                zzcb zzcbVar = (zzcb) this;
                if (i != 1) {
                    return false;
                }
                int readInt = parcel.readInt();
                int i3 = zzar.$r8$clinit;
                int dataAvail = parcel.dataAvail();
                if (dataAvail <= 0) {
                    zzcbVar.zza.zzb(Integer.valueOf(readInt));
                    return true;
                }
                throw new BadParcelableException(ViewModelProvider.Factory.CC.m(dataAvail, "Parcel data not fully consumed, unread size: "));
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    public boolean zza(int i, Parcel parcel, Parcel parcel2) {
        return false;
    }

    public zab(String str) {
        attachInterface(this, str);
    }
}
