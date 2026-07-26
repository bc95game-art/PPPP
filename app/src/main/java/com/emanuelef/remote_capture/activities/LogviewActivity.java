package com.emanuelef.remote_capture.activities;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.core.view.MenuProvider;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.fragments.LogviewFragment;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.tabs.TabLayout;
/* loaded from: classes.dex */
public class LogviewActivity extends BaseActivity implements MenuProvider {
    private static final int NUM_POS = 3;
    private static final int POS_APP_LOG = 0;
    private static final int POS_MITM_LOG = 2;
    private static final int POS_ROOT_LOG = 1;
    private static final String TAG = "LogviewActivity";
    private ViewPager2 mPager;
    private StateAdapter mPagerAdapter;

    /* loaded from: classes.dex */
    public static class StateAdapter extends FragmentStateAdapter {
        final String mCacheDir;

        public StateAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            this.mCacheDir = fragmentActivity.getCacheDir().getAbsolutePath();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            if (i == 0) {
                return LogviewFragment.newInstance(this.mCacheDir + "/pcapdroid.log");
            } else if (i != 1) {
                return LogviewFragment.newInstance(this.mCacheDir + "/mitmaddon.log");
            } else {
                return LogviewFragment.newInstance(this.mCacheDir + "/pcapd.log");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 3;
        }

        public int getPageTitle(int i) {
            return i != 0 ? i != 1 ? C0130R.string.mitm_addon : C0130R.string.root : C0130R.string.app;
        }
    }

    public /* synthetic */ void lambda$setupTabs$0(TabLayout.Tab tab, int i) {
        tab.setText(getString(this.mPagerAdapter.getPageTitle(i)));
    }

    private void setupTabs() {
        StateAdapter stateAdapter = new StateAdapter(this);
        this.mPagerAdapter = stateAdapter;
        this.mPager.setAdapter(stateAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(C0130R.C0132id.tablayout);
        Utils.fixScrollableTabLayoutInsets(tabLayout);
        new zzw(tabLayout, this.mPager, new InputConnectionCompat$$ExternalSyntheticLambda0(4, this)).attach();
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(C0130R.string.app_log);
        setContentView(C0130R.layout.tabs_activity_fixed);
        addMenuProvider(this);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(C0130R.C0132id.pager);
        this.mPager = viewPager2;
        Utils.fixViewPager2Insets(viewPager2);
        setupTabs();
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C0130R.C0134menu.log_menu, menu);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 20) {
            View currentFocus = getCurrentFocus();
            Log.m587d(TAG, "onKeyDown focus ".concat(currentFocus.getClass().getName()));
            if (currentFocus instanceof TabLayout.TabView) {
                int currentItem = this.mPager.getCurrentItem();
                Log.m587d(TAG, "TabLayout.TabView focus pos " + currentItem);
                View findViewById = findViewById(C0130R.C0132id.scrollView);
                if (findViewById != null) {
                    findViewById.requestFocus();
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        LogviewFragment logviewFragment = (LogviewFragment) getFragmentAtPos(this.mPager.getCurrentItem());
        if (logviewFragment == null) {
            return false;
        }
        String log = logviewFragment.getLog();
        if (itemId == C0130R.C0132id.reload) {
            logviewFragment.reloadLog();
            return true;
        } else if (itemId == C0130R.C0132id.copy_to_clipboard) {
            Utils.copyToClipboard(this, log);
            return true;
        } else if (itemId != C0130R.C0132id.share) {
            return false;
        } else {
            Utils.shareText(this, getString(C0130R.string.app_log), log);
            return true;
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }
}
