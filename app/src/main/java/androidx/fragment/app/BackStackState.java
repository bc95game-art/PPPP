package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new zzb(7);
    public final ArrayList mFragments;
    public final ArrayList mTransactions;

    public BackStackState(ArrayList arrayList, ArrayList arrayList2) {
        this.mFragments = arrayList;
        this.mTransactions = arrayList2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(this.mFragments);
        parcel.writeTypedList(this.mTransactions);
    }

    public BackStackState(Parcel parcel) {
        this.mFragments = parcel.createStringArrayList();
        this.mTransactions = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }
}
