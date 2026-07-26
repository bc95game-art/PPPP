package com.emanuelef.remote_capture.activities.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import androidx.collection.ArraySet;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.activities.BaseActivity;
import com.emanuelef.remote_capture.fragments.AppsToggles;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.Prefs;
import java.util.Set;
/* loaded from: classes.dex */
public class VpnExemptionsActivity extends BaseActivity {
    private VpnExceptionsFragment mFragment;

    /* loaded from: classes.dex */
    public static class VpnExceptionsFragment extends AppsToggles {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final String TAG = "VpnExceptions";
        private final Set<String> mExcludedApps = new ArraySet(0);
        private SharedPreferences mPrefs;

        @Override // com.emanuelef.remote_capture.fragments.AppsToggles
        public Set<String> getCheckedApps() {
            return this.mExcludedApps;
        }

        @Override // com.emanuelef.remote_capture.adapters.AppsTogglesAdapter.AppToggleListener
        public void onAppToggled(AppDescriptor appDescriptor, boolean z) {
            String packageName = appDescriptor.getPackageName();
            if (this.mExcludedApps.contains(packageName) != z) {
                if (z) {
                    this.mExcludedApps.add(packageName);
                } else {
                    this.mExcludedApps.remove(packageName);
                }
                Log.d(TAG, "Saving " + this.mExcludedApps.size() + " exceptions");
                SharedPreferences sharedPreferences = this.mPrefs;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putStringSet(Prefs.PREF_VPN_EXCEPTIONS, this.mExcludedApps).apply();
                }
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onAttach(Context context) {
            super.onAttach(context);
            this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
            this.mExcludedApps.clear();
            Set<String> stringSet = this.mPrefs.getStringSet(Prefs.PREF_VPN_EXCEPTIONS, null);
            if (stringSet != null) {
                Log.d(TAG, "Loading " + stringSet.size() + " exceptions");
                this.mExcludedApps.addAll(stringSet);
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onDetach() {
            super.onDetach();
            this.mPrefs = null;
        }

        @Override // com.emanuelef.remote_capture.fragments.AppsToggles, androidx.core.view.MenuProvider
        public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
        }

        @Override // com.emanuelef.remote_capture.fragments.AppsToggles, androidx.core.view.MenuProvider
        public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.mFragment.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.vpn_exemptions);
        setContentView(R.layout.fragment_activity);
        displayBackAction();
        if (bundle != null) {
            this.mFragment = (VpnExceptionsFragment) getSupportFragmentManager().getFragment(bundle, "fragment");
        }
        if (this.mFragment == null) {
            this.mFragment = new VpnExceptionsFragment();
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.replace(R.id.fragment, this.mFragment, null);
        backStackRecord.commit();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getSupportFragmentManager().putFragment(bundle, "fragment", this.mFragment);
    }
}
