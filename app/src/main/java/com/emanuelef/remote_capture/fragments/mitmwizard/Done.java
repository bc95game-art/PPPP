package com.emanuelef.remote_capture.fragments.mitmwizard;

import android.os.Bundle;
import android.view.View;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.MitmAddon;
/* loaded from: classes.dex */
public class Done extends StepFragment {
    @Override // com.emanuelef.remote_capture.fragments.mitmwizard.StepFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mStepLabel.setText(C0130R.string.mitm_setup_wizard_done);
        MitmAddon.setDecryptionSetupDone(requireContext(), true);
        nextStep(0);
    }
}
