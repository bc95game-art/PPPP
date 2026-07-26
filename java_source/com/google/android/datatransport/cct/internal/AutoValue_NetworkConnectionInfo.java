package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
/* loaded from: classes.dex */
public final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {
    public final NetworkConnectionInfo.MobileSubtype mobileSubtype;
    public final NetworkConnectionInfo.NetworkType networkType;

    public AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.networkType = networkType;
        this.mobileSubtype = mobileSubtype;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NetworkConnectionInfo) {
            NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
            NetworkConnectionInfo.NetworkType networkType = this.networkType;
            if (networkType != null ? networkType.equals(((AutoValue_NetworkConnectionInfo) networkConnectionInfo).networkType) : ((AutoValue_NetworkConnectionInfo) networkConnectionInfo).networkType == null) {
                NetworkConnectionInfo.MobileSubtype mobileSubtype = this.mobileSubtype;
                if (mobileSubtype != null ? mobileSubtype.equals(((AutoValue_NetworkConnectionInfo) networkConnectionInfo).mobileSubtype) : ((AutoValue_NetworkConnectionInfo) networkConnectionInfo).mobileSubtype == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2 = 0;
        NetworkConnectionInfo.NetworkType networkType = this.networkType;
        if (networkType == null) {
            i = 0;
        } else {
            i = networkType.hashCode();
        }
        int i3 = (i ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.mobileSubtype;
        if (mobileSubtype != null) {
            i2 = mobileSubtype.hashCode();
        }
        return i2 ^ i3;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.networkType + ", mobileSubtype=" + this.mobileSubtype + "}";
    }
}
