package com.google.android.gms.signin;

import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class SignInOptions {
    public static final SignInOptions zaa = new Object();

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof SignInOptions) && zzah.equal(null, null) && zzah.equal(null, null) && zzah.equal(null, null) && zzah.equal(null, null) && zzah.equal(null, null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = Boolean.FALSE;
        return Arrays.hashCode(new Object[]{bool, bool, null, bool, bool, null, null, null, null});
    }
}
