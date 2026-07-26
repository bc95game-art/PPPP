package com.emanuelef.remote_capture.activities;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.fragments.EditListFragment;
import com.emanuelef.remote_capture.fragments.FirewallStatus;
import com.emanuelef.remote_capture.model.ListInfo;
import com.emanuelef.remote_capture.model.Prefs;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.tabs.TabLayout;
/* loaded from: classes.dex */
public class FirewallActivity extends BaseActivity {
    private static final int POS_BLOCKLIST = 1;
    private static final int POS_STATUS = 0;
    private static final int POS_WHITELIST = 2;
    private static final String TAG = "Firewall";
    private static final int TOTAL_COUNT = 3;
    private boolean mHasWhitelist = false;
    private ViewPager2 mPager;
    private StateAdapter mPagerAdapter;
    private SharedPreferences mPrefs;

    /* loaded from: classes.dex */
    public class StateAdapter extends FragmentStateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StateAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            FirewallActivity.this = r1;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            Log.m587d(FirewallActivity.TAG, "createFragment");
            if (i == 1) {
                return EditListFragment.newInstance(ListInfo.Type.BLOCKLIST);
            }
            if (i != 2) {
                return new FirewallStatus();
            }
            return EditListFragment.newInstance(ListInfo.Type.FIREWALL_WHITELIST);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (FirewallActivity.this.mHasWhitelist) {
                return 3;
            }
            return 2;
        }

        public int getPageTitle(int i) {
            return i != 1 ? i != 2 ? C0130R.string.status : C0130R.string.whitelist : C0130R.string.blocklist;
        }
    }

    public /* synthetic */ void lambda$setupTabs$0(TabLayout.Tab tab, int i) {
        tab.setText(getString(this.mPagerAdapter.getPageTitle(i)));
    }

    private void setupTabs() {
        StateAdapter stateAdapter = new StateAdapter(this);
        this.mPagerAdapter = stateAdapter;
        this.mPager.setAdapter(stateAdapter);
        new zzw((TabLayout) findViewById(C0130R.C0132id.tablayout), this.mPager, new InputConnectionCompat$$ExternalSyntheticLambda0(3, this)).attach();
        recheckTabs();
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(C0130R.string.firewall);
        setContentView(C0130R.layout.tabs_activity);
        this.mPrefs = getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(C0130R.C0132id.pager);
        this.mPager = viewPager2;
        Utils.fixViewPager2Insets(viewPager2);
        setupTabs();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        View view;
        if (i == 20) {
            View currentFocus = getCurrentFocus();
            Log.m587d(TAG, "onKeyDown focus ".concat(currentFocus.getClass().getName()));
            if (currentFocus instanceof TabLayout.TabView) {
                int currentItem = this.mPager.getCurrentItem();
                Log.m587d(TAG, "TabLayout.TabView focus pos " + currentItem);
                if (currentItem == 0) {
                    view = findViewById(C0130R.C0132id.firewall_status);
                } else if (currentItem == 1 || currentItem == 2) {
                    view = findViewById(C0130R.C0132id.listview);
                } else {
                    view = null;
                }
                if (view != null) {
                    view.requestFocus();
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void recheckTabs() {
        boolean isFirewallWhitelistMode = Prefs.isFirewallWhitelistMode(this.mPrefs);
        if (this.mHasWhitelist != isFirewallWhitelistMode) {
            this.mHasWhitelist = isFirewallWhitelistMode;
            this.mPagerAdapter.notifyDataSetChanged();
        }
    }
}
