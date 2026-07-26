package com.emanuelef.remote_capture.activities.prefs;

import android.os.Bundle;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.FragmentManager;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.activities.BaseActivity;
import com.emanuelef.remote_capture.fragments.prefs.PortMapFragment;
/* loaded from: classes.dex */
public class PortMapActivity extends BaseActivity {
    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.port_mapping);
        setContentView(R.layout.fragment_activity);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.replace(R.id.fragment, new PortMapFragment(), null);
        backStackRecord.commit();
    }
}
