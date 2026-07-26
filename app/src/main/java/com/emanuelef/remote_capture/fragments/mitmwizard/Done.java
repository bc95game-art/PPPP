package com.emanuelef.remote_capture.fragments.mitmwizard;

import android.os.Bundle;
import android.view.View;
import com.emanuelef.remote_capture.MitmAddon;
import com.emanuelef.remote_capture.R;
/* loaded from: classes.dex */
public class Done extends StepFragment {
    @Override // com.emanuelef.remote_capture.fragments.mitmwizard.StepFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mStepLabel.setText(R.string.mitm_setup_wizard_done);
        MitmAddon.setDecryptionSetupDone(requireContext(), true);
        nextStep(0);
    }
}
