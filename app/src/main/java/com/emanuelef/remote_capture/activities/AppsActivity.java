package com.emanuelef.remote_capture.activities;

import android.os.Bundle;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.FragmentManager;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.fragments.AppsFragment;
/* loaded from: classes.dex */
public class AppsActivity extends BaseActivity {
    private static final String TAG = "AppsActivity";

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.apps);
        setContentView(R.layout.fragment_activity);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.replace(R.id.fragment, new AppsFragment(), null);
        backStackRecord.commit();
    }
}
