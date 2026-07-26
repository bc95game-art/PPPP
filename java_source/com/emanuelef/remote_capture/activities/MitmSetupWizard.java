package com.emanuelef.remote_capture.activities;

import android.os.Bundle;
import com.emanuelef.remote_capture.C0130R;
/* loaded from: classes.dex */
public class MitmSetupWizard extends BaseActivity {
    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0130R.layout.mitm_wizard_activity);
        setTitle(C0130R.string.mitm_setup_wizard);
    }
}
