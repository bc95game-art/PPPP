package com.emanuelef.remote_capture.model;

import android.content.DialogInterface;
import com.emanuelef.remote_capture.activities.AboutActivity;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.activities.prefs.EditCtrlPermissions;
import com.emanuelef.remote_capture.adapters.PayloadAdapter;
import com.emanuelef.remote_capture.fragments.AppsFragment;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment;
import com.emanuelef.remote_capture.fragments.EditListFragment;
import com.emanuelef.remote_capture.fragments.FirewallStatus;
import com.emanuelef.remote_capture.fragments.mitmwizard.InstallCertificate;
import com.emanuelef.remote_capture.fragments.prefs.PortMapFragment;
import com.emanuelef.remote_capture.views.RuleAddDialog;
/* loaded from: classes.dex */
public final /* synthetic */ class Blocklist$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Blocklist$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                Blocklist.$r8$lambda$G6Lh71b9_ZBPRABECxwtDTRwABg(dialogInterface, i);
                return;
            case 1:
                AboutActivity.lambda$showLicenseDialog$8(dialogInterface, i);
                return;
            case 2:
                AboutActivity.lambda$onMenuItemSelected$1(dialogInterface, i);
                return;
            case 3:
                MainActivity.lambda$showPcapActionDialog$21(dialogInterface, i);
                return;
            case 4:
                MainActivity.lambda$checkVpnLockdownNotice$13(dialogInterface, i);
                return;
            case 5:
                MainActivity.lambda$showWhatsNew$5(dialogInterface, i);
                return;
            case 6:
                MainActivity.lambda$checkDecryptionRulesNotice$10(dialogInterface, i);
                return;
            case 7:
                MainActivity.lambda$startCapture$17(dialogInterface, i);
                return;
            case 8:
                EditCtrlPermissions.lambda$showApiKey$2(dialogInterface, i);
                return;
            case 9:
                EditCtrlPermissions.lambda$generateApiKey$1(dialogInterface, i);
                return;
            case 10:
                PayloadAdapter.m782$r8$lambda$PT0FHf8FgbttixgXKaDLHJic2E(dialogInterface, i);
                return;
            case 11:
                PayloadAdapter.m781$r8$lambda$BqwgkR6qyjppnHynKUOou6XJQI(dialogInterface, i);
                return;
            case 12:
                PayloadAdapter.m780$r8$lambda$76p8Dx_kFpzCWboUzJlRFUu7xc(dialogInterface, i);
                return;
            case 13:
                PayloadAdapter.$r8$lambda$rcsfvlWpjych1jb4p0lOwt1GJAY(dialogInterface, i);
                return;
            case 14:
                AppsFragment.$r8$lambda$d0Nm3wcs0n7pYSLrniNE7bw2eGE(dialogInterface, i);
                return;
            case 15:
                ConnectionsFragment.lambda$showFirewallPurchaseDialog$11(dialogInterface, i);
                return;
            case 16:
                ConnectionsFragment.lambda$onViewCreated$8(dialogInterface, i);
                return;
            case 17:
                EditListFragment.lambda$confirmLoadManyRules$7(dialogInterface, i);
                return;
            case 18:
                EditListFragment.lambda$confirmDelete$1(dialogInterface, i);
                return;
            case 19:
                FirewallStatus.lambda$onMenuItemSelected$3(dialogInterface, i);
                return;
            case 20:
                InstallCertificate.lambda$onViewCreated$0(dialogInterface, i);
                return;
            case 21:
                PortMapFragment.lambda$openAddDialog$1(dialogInterface, i);
                return;
            case 22:
                PortMapFragment.lambda$openAddDialog$2(dialogInterface, i);
                return;
            case 23:
                PortMapFragment.lambda$confirmDelete$5(dialogInterface, i);
                return;
            case 24:
                RuleAddDialog.m873$r8$lambda$LUAEUbD2ITqRsNQAS4nIq76lLs(dialogInterface, i);
                return;
            default:
                RuleAddDialog.$r8$lambda$eEpwEpDB_sWABJ8moDKYTQ1gcZg(dialogInterface, i);
                return;
        }
    }
}
