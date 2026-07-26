package com.emanuelef.remote_capture.fragments;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.widget.Toast;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.activity.DefaultErrorActivity;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.activities.prefs.EditCtrlPermissions;
import com.emanuelef.remote_capture.activities.prefs.SettingsActivity;
/* loaded from: classes.dex */
public final /* synthetic */ class AppsFragment$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AppsFragment$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.$r8$classId;
        Object obj = this.f$0;
        switch (i2) {
            case 0:
                ((AppsFragment) obj).lambda$onMenuItemSelected$2(dialogInterface, i);
                return;
            case 1:
                DefaultErrorActivity defaultErrorActivity = (DefaultErrorActivity) obj;
                int i3 = DefaultErrorActivity.$r8$clinit;
                String allErrorDetailsFromIntent = CustomActivityOnCrash.getAllErrorDetailsFromIntent(defaultErrorActivity, defaultErrorActivity.getIntent());
                ClipboardManager clipboardManager = (ClipboardManager) defaultErrorActivity.getSystemService("clipboard");
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(ClipData.newPlainText(defaultErrorActivity.getString(C0130R.string.customactivityoncrash_error_activity_error_details_clipboard_label), allErrorDetailsFromIntent));
                    Toast.makeText(defaultErrorActivity, (int) C0130R.string.customactivityoncrash_error_activity_error_details_copied, 0).show();
                    return;
                }
                return;
            case 2:
                ((EditCtrlPermissions) obj).lambda$generateApiKey$0(dialogInterface, i);
                return;
            case 3:
                ((SettingsActivity.SettingsFragment) obj).lambda$checkDecrpytionWithRoot$15(dialogInterface, i);
                return;
            case 4:
                ((ConnectionPayload) obj).lambda$setMenuVisibility$3(dialogInterface, i);
                return;
            case 5:
                ((ConnectionsFragment) obj).lambda$showFirewallPurchaseDialog$10(dialogInterface, i);
                return;
            default:
                ((HttpPayloadFragment) obj).lambda$setMenuVisibility$3(dialogInterface, i);
                return;
        }
    }
}
