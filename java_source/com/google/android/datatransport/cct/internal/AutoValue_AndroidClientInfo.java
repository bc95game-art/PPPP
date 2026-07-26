package com.google.android.datatransport.cct.internal;

import androidx.lifecycle.ViewModelProvider;
/* loaded from: classes.dex */
public final class AutoValue_AndroidClientInfo extends AndroidClientInfo {
    public final String applicationBuild;
    public final String country;
    public final String device;
    public final String fingerprint;
    public final String hardware;
    public final String locale;
    public final String manufacturer;
    public final String mccMnc;
    public final String model;
    public final String osBuild;
    public final String product;
    public final Integer sdkVersion;

    public AutoValue_AndroidClientInfo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.sdkVersion = num;
        this.model = str;
        this.hardware = str2;
        this.device = str3;
        this.product = str4;
        this.osBuild = str5;
        this.manufacturer = str6;
        this.fingerprint = str7;
        this.locale = str8;
        this.country = str9;
        this.mccMnc = str10;
        this.applicationBuild = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AndroidClientInfo) {
            AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
            Integer num = this.sdkVersion;
            if (num != null ? num.equals(((AutoValue_AndroidClientInfo) androidClientInfo).sdkVersion) : ((AutoValue_AndroidClientInfo) androidClientInfo).sdkVersion == null) {
                String str = this.model;
                if (str != null ? str.equals(((AutoValue_AndroidClientInfo) androidClientInfo).model) : ((AutoValue_AndroidClientInfo) androidClientInfo).model == null) {
                    String str2 = this.hardware;
                    if (str2 != null ? str2.equals(((AutoValue_AndroidClientInfo) androidClientInfo).hardware) : ((AutoValue_AndroidClientInfo) androidClientInfo).hardware == null) {
                        String str3 = this.device;
                        if (str3 != null ? str3.equals(((AutoValue_AndroidClientInfo) androidClientInfo).device) : ((AutoValue_AndroidClientInfo) androidClientInfo).device == null) {
                            String str4 = this.product;
                            if (str4 != null ? str4.equals(((AutoValue_AndroidClientInfo) androidClientInfo).product) : ((AutoValue_AndroidClientInfo) androidClientInfo).product == null) {
                                String str5 = this.osBuild;
                                if (str5 != null ? str5.equals(((AutoValue_AndroidClientInfo) androidClientInfo).osBuild) : ((AutoValue_AndroidClientInfo) androidClientInfo).osBuild == null) {
                                    String str6 = this.manufacturer;
                                    if (str6 != null ? str6.equals(((AutoValue_AndroidClientInfo) androidClientInfo).manufacturer) : ((AutoValue_AndroidClientInfo) androidClientInfo).manufacturer == null) {
                                        String str7 = this.fingerprint;
                                        if (str7 != null ? str7.equals(((AutoValue_AndroidClientInfo) androidClientInfo).fingerprint) : ((AutoValue_AndroidClientInfo) androidClientInfo).fingerprint == null) {
                                            String str8 = this.locale;
                                            if (str8 != null ? str8.equals(((AutoValue_AndroidClientInfo) androidClientInfo).locale) : ((AutoValue_AndroidClientInfo) androidClientInfo).locale == null) {
                                                String str9 = this.country;
                                                if (str9 != null ? str9.equals(((AutoValue_AndroidClientInfo) androidClientInfo).country) : ((AutoValue_AndroidClientInfo) androidClientInfo).country == null) {
                                                    String str10 = this.mccMnc;
                                                    if (str10 != null ? str10.equals(((AutoValue_AndroidClientInfo) androidClientInfo).mccMnc) : ((AutoValue_AndroidClientInfo) androidClientInfo).mccMnc == null) {
                                                        String str11 = this.applicationBuild;
                                                        if (str11 != null ? str11.equals(((AutoValue_AndroidClientInfo) androidClientInfo).applicationBuild) : ((AutoValue_AndroidClientInfo) androidClientInfo).applicationBuild == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12 = 0;
        Integer num = this.sdkVersion;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        int i13 = (i ^ 1000003) * 1000003;
        String str = this.model;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int i14 = (i13 ^ i2) * 1000003;
        String str2 = this.hardware;
        if (str2 == null) {
            i3 = 0;
        } else {
            i3 = str2.hashCode();
        }
        int i15 = (i14 ^ i3) * 1000003;
        String str3 = this.device;
        if (str3 == null) {
            i4 = 0;
        } else {
            i4 = str3.hashCode();
        }
        int i16 = (i15 ^ i4) * 1000003;
        String str4 = this.product;
        if (str4 == null) {
            i5 = 0;
        } else {
            i5 = str4.hashCode();
        }
        int i17 = (i16 ^ i5) * 1000003;
        String str5 = this.osBuild;
        if (str5 == null) {
            i6 = 0;
        } else {
            i6 = str5.hashCode();
        }
        int i18 = (i17 ^ i6) * 1000003;
        String str6 = this.manufacturer;
        if (str6 == null) {
            i7 = 0;
        } else {
            i7 = str6.hashCode();
        }
        int i19 = (i18 ^ i7) * 1000003;
        String str7 = this.fingerprint;
        if (str7 == null) {
            i8 = 0;
        } else {
            i8 = str7.hashCode();
        }
        int i20 = (i19 ^ i8) * 1000003;
        String str8 = this.locale;
        if (str8 == null) {
            i9 = 0;
        } else {
            i9 = str8.hashCode();
        }
        int i21 = (i20 ^ i9) * 1000003;
        String str9 = this.country;
        if (str9 == null) {
            i10 = 0;
        } else {
            i10 = str9.hashCode();
        }
        int i22 = (i21 ^ i10) * 1000003;
        String str10 = this.mccMnc;
        if (str10 == null) {
            i11 = 0;
        } else {
            i11 = str10.hashCode();
        }
        int i23 = (i22 ^ i11) * 1000003;
        String str11 = this.applicationBuild;
        if (str11 != null) {
            i12 = str11.hashCode();
        }
        return i12 ^ i23;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.sdkVersion);
        sb.append(", model=");
        sb.append(this.model);
        sb.append(", hardware=");
        sb.append(this.hardware);
        sb.append(", device=");
        sb.append(this.device);
        sb.append(", product=");
        sb.append(this.product);
        sb.append(", osBuild=");
        sb.append(this.osBuild);
        sb.append(", manufacturer=");
        sb.append(this.manufacturer);
        sb.append(", fingerprint=");
        sb.append(this.fingerprint);
        sb.append(", locale=");
        sb.append(this.locale);
        sb.append(", country=");
        sb.append(this.country);
        sb.append(", mccMnc=");
        sb.append(this.mccMnc);
        sb.append(", applicationBuild=");
        return ViewModelProvider.Factory.CC.m593m(sb, this.applicationBuild, "}");
    }
}
