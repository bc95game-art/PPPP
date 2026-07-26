package com.emanuelef.remote_capture.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.collection.ArraySet;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.fragments.AppsToggles;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.Prefs;
import java.util.Set;
/* loaded from: classes.dex */
public class AppFilterActivity extends BaseActivity implements MenuProvider {
    private static final String TAG = "AppFilterActivity";
    private AppFilterFragment mFragment;

    /* loaded from: classes.dex */
    public static class AppFilterFragment extends AppsToggles {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private SharedPreferences mPrefs;
        private final Set<String> mSelectedApps = new ArraySet(0);

        @Override // com.emanuelef.remote_capture.fragments.AppsToggles
        public Set<String> getCheckedApps() {
            return this.mSelectedApps;
        }

        @Override // com.emanuelef.remote_capture.adapters.AppsTogglesAdapter.AppToggleListener
        public void onAppToggled(AppDescriptor appDescriptor, boolean z) {
            String packageName = appDescriptor.getPackageName();
            if (this.mSelectedApps.contains(packageName) != z) {
                if (z) {
                    this.mSelectedApps.add(packageName);
                } else {
                    this.mSelectedApps.remove(packageName);
                }
                Log.m587d(AppFilterActivity.TAG, "Saving " + this.mSelectedApps.size() + " target apps");
                SharedPreferences sharedPreferences = this.mPrefs;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putStringSet(Prefs.PREF_APP_FILTER, this.mSelectedApps).apply();
                }
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onAttach(Context context) {
            super.onAttach(context);
            this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
            this.mSelectedApps.clear();
            Set<String> stringSet = Prefs.getStringSet(this.mPrefs, Prefs.PREF_APP_FILTER);
            if (!stringSet.isEmpty()) {
                Log.m587d(AppFilterActivity.TAG, "Loading " + stringSet.size() + " target apps");
                this.mSelectedApps.addAll(stringSet);
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
            if (Build.VERSION.SDK_INT >= 34) {
                overrideActivityTransition(1, 0, 0);
            } else {
                overridePendingTransition(0, 0);
            }
        }
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(C0130R.string.target_apps);
        setContentView(C0130R.layout.fragment_activity);
        addMenuProvider(this);
        displayBackAction();
        if (bundle != null) {
            this.mFragment = (AppFilterFragment) getSupportFragmentManager().getFragment(bundle, "fragment");
        }
        if (this.mFragment == null) {
            this.mFragment = new AppFilterFragment();
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.replace(C0130R.C0132id.fragment, this.mFragment, null);
        backStackRecord.commit();
        if (Build.VERSION.SDK_INT >= 34) {
            overrideActivityTransition(0, 0, 0);
        } else {
            overridePendingTransition(0, 0);
        }
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C0130R.C0134menu.hint_menu, menu);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C0130R.C0132id.show_hint) {
            return false;
        }
        Utils.showHelpDialog(this, (int) C0130R.string.target_apps_help);
        return true;
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getSupportFragmentManager().putFragment(bundle, "fragment", this.mFragment);
    }
}
