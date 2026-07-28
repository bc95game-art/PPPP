package com.emanuelef.remote_capture.activities;

import android.os.Bundle;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.FragmentManager;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.ListInfo;
import com.emanuelef.remote_capture.model.MatchList;
/* loaded from: classes.dex */
public class EditListActivity extends BaseActivity {
    private static final String FITS_SYSTEM_WINDOWS_ARG = "fits_system_windows";
    public static final String LIST_TYPE_EXTRA = "list_type";
    private static final String TAG = "EditListActivity";
    private ListInfo mListInfo;

    public MatchList getList() {
        return this.mListInfo.getList();
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            Log.m585e(TAG, "null intent");
            finish();
            return;
        }
        ListInfo.Type type = (ListInfo.Type) Utils.getSerializableExtra(getIntent(), LIST_TYPE_EXTRA, ListInfo.Type.class);
        if (type == null) {
            Log.m585e(TAG, "null list info");
            finish();
            return;
        }
        ListInfo listInfo = new ListInfo(type);
        this.mListInfo = listInfo;
        setTitle(listInfo.getTitle());
        setContentView(C0130R.layout.fragment_activity);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.replace(C0130R.C0132id.fragment, this.mListInfo.newFragment(), null);
        backStackRecord.commit();
    }
}
