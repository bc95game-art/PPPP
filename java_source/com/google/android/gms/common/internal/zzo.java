package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class zzo {
    public static final Uri zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
    public final String zzb;
    public final String zzc;
    public final boolean zzf;

    public zzo(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.zzb = str;
            if (!TextUtils.isEmpty("com.google.android.gms")) {
                this.zzc = "com.google.android.gms";
                this.zzf = z;
                return;
            }
            throw new IllegalArgumentException("Given String is empty or null");
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzoVar = (zzo) obj;
        if (!zzah.equal(this.zzb, zzoVar.zzb) || !zzah.equal(this.zzc, zzoVar.zzc) || !zzah.equal(null, null) || this.zzf != zzoVar.zzf) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, this.zzc, null, 4225, Boolean.valueOf(this.zzf)});
    }

    public final String toString() {
        String str = this.zzb;
        if (str != null) {
            return str;
        }
        zzah.checkNotNull(null);
        throw null;
    }

    public final Intent zzb(Context context) {
        Bundle bundle;
        Intent intent = null;
        String str = this.zzb;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.zzf) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", str);
            try {
                bundle = context.getContentResolver().call(zza, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundle = null;
            }
            if (bundle != null) {
                intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
            }
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
            }
        }
        if (intent == null) {
            return new Intent(str).setPackage(this.zzc);
        }
        return intent;
    }
}
