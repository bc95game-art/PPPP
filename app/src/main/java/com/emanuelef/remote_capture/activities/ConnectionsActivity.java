package com.emanuelef.remote_capture.activities;

import android.os.Bundle;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.FragmentManager;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment;
/* loaded from: classes.dex */
public class ConnectionsActivity extends BaseActivity {
    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(C0130R.string.connections_view);
        displayBackAction();
        setContentView(C0130R.layout.fragment_activity);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.replace(C0130R.C0132id.fragment, new ConnectionsFragment(), null);
        backStackRecord.commit();
    }
}
