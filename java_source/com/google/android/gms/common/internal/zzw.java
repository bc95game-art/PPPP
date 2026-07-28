package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.common.zzc;
/* loaded from: classes.dex */
public final class zzw implements IAccountAccessor, IInterface {
    public final IBinder zza;

    public zzw(IBinder iBinder) {
        this.zza = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    public final Account zzb() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
        obtain = Parcel.obtain();
        try {
            this.zza.transact(2, obtain, obtain, 0);
            obtain.readException();
            obtain.recycle();
            return (Account) zzc.zza(obtain, Account.CREATOR);
        } catch (RuntimeException e) {
            throw e;
        } finally {
            obtain.recycle();
        }
    }
}
