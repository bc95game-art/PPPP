package com.google.android.gms.common.api.internal;

import com.android.billingclient.api.zzcl;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.zzah;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class zabs {
    public final ApiKey zaa;
    public final Feature zab;

    public /* synthetic */ zabs(ApiKey apiKey, Feature feature) {
        this.zaa = apiKey;
        this.zab = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabsVar = (zabs) obj;
            if (zzah.equal(this.zaa, zabsVar.zaa) && zzah.equal(this.zab, zabsVar.zab)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zaa, this.zab});
    }

    public final String toString() {
        zzcl zzclVar = new zzcl(this);
        zzclVar.add(this.zaa, "key");
        zzclVar.add(this.zab, "feature");
        return zzclVar.toString();
    }
}
