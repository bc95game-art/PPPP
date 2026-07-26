package com.emanuelef.remote_capture.fragments.mitmwizard;

import android.os.Bundle;
import android.view.View;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.MainActivity;
/* loaded from: classes.dex */
public class Intro extends StepFragment {
    @Override // com.emanuelef.remote_capture.fragments.mitmwizard.StepFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mStepIcon.setVisibility(8);
        Utils.setTextUrls(this.mStepLabel, R.string.mitm_setup_wizard_intro, MainActivity.TLS_DECRYPTION_DOCS_URL);
        nextStep(R.id.navto_install_addon);
    }
}
