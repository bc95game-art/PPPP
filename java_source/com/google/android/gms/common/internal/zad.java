package com.google.android.gms.common.internal;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;
/* loaded from: classes.dex */
public final class zad implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Intent zaa;
    public final /* synthetic */ Object zab;

    public /* synthetic */ zad(Intent intent, Object obj, int i) {
        this.$r8$classId = i;
        this.zaa = intent;
        this.zab = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            try {
                zaa();
            } catch (ActivityNotFoundException e) {
                String str = "Failed to start resolution intent.";
                if (true == Build.FINGERPRINT.contains("generic")) {
                    str = "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.";
                }
                Log.e("DialogRedirect", str, e);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, com.google.android.gms.common.api.internal.LifecycleFragment] */
    public final void zaa() {
        switch (this.$r8$classId) {
            case 0:
                Intent intent = this.zaa;
                if (intent != null) {
                    ((GoogleApiActivity) this.zab).startActivityForResult(intent, 2);
                    return;
                }
                return;
            default:
                Intent intent2 = this.zaa;
                if (intent2 != null) {
                    this.zab.startActivityForResult(intent2, 2);
                    return;
                }
                return;
        }
    }
}
