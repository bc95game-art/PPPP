package androidx.startup;

import android.os.Parcel;
/* loaded from: classes.dex */
public final class StartupException extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public StartupException(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + r0 + " size=" + r4);
        int dataPosition = parcel.dataPosition();
        int dataSize = parcel.dataSize();
    }
}
