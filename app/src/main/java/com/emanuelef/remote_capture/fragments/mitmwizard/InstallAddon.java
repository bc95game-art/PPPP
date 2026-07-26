package com.emanuelef.remote_capture.fragments.mitmwizard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.emanuelef.remote_capture.MitmAddon;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.fragments.AppOverview$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda2;
/* loaded from: classes.dex */
public class InstallAddon extends StepFragment {
    private void addonOk() {
        nextStep(R.id.navto_install_cert);
    }

    private void installAddon(String str) {
        String installedVersionName = MitmAddon.getInstalledVersionName(requireContext());
        if (installedVersionName.isEmpty()) {
            this.mStepLabel.setText(R.string.install_the_mitm_addon);
            this.mStepButton.setText(R.string.install_action);
        } else if (Utils.isSemanticVersionCompatible(installedVersionName, str)) {
            this.mStepLabel.setText(R.string.mitm_addon_update_available);
            this.mStepButton.setText(R.string.update_action);
            showSkipButton(new AppsFragment$$ExternalSyntheticLambda2(7, this));
        } else if (MitmAddon.getInstalledVersion(requireContext()) < 21) {
            this.mStepLabel.setText(R.string.mitm_addon_new_version);
            this.mStepButton.setText(R.string.update_action);
        } else {
            this.mStepLabel.setText(getString(R.string.mitm_addon_bad_version, MitmAddon.PACKAGE_VERSION_NAME));
            this.mStepIcon.setColorFilter(this.mDangerColor);
            this.mStepButton.setText(R.string.install_action);
            this.mStepButton.setEnabled(false);
            return;
        }
        this.mStepButton.setOnClickListener(new AppOverview$$ExternalSyntheticLambda0(this, 3, str));
    }

    public /* synthetic */ void lambda$installAddon$0(View view) {
        gotoStep(R.id.navto_install_cert);
    }

    public /* synthetic */ void lambda$installAddon$1(String str, View view) {
        if (str.isEmpty()) {
            str = MitmAddon.PACKAGE_VERSION_NAME;
        }
        Utils.startActivity(requireContext(), new Intent("android.intent.action.VIEW", Uri.parse(MitmAddon.getGithubReleaseUrl(str))));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (MitmAddon.getNewVersionAvailable(requireContext()).isEmpty() && MitmAddon.isInstalled(requireContext())) {
            addonOk();
        }
    }

    @Override // com.emanuelef.remote_capture.fragments.mitmwizard.StepFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Utils.setTextUrls(this.mStepLabel, R.string.install_the_mitm_addon, MitmAddon.REPOSITORY);
        String newVersionAvailable = MitmAddon.getNewVersionAvailable(requireContext());
        if (!newVersionAvailable.isEmpty() || !MitmAddon.isInstalled(requireContext())) {
            installAddon(newVersionAvailable);
        } else {
            addonOk();
        }
    }
}
