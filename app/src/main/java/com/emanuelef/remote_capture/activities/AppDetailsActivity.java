package com.emanuelef.remote_capture.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.fragments.AppOverview;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment;
import com.emanuelef.remote_capture.model.FilterDescriptor;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.tabs.TabLayout;
/* loaded from: classes.dex */
public class AppDetailsActivity extends BaseActivity {
    public static final String APP_UID_EXTRA = "app_uid";
    private static final int POS_CONNECTIONS = 1;
    private static final int POS_OVERVIEW = 0;
    private static final int POS_TOTAL = 2;
    private static final String TAG = "AppDetailsActivity";
    private ViewPager2 mPager;
    private int mUid;

    /* loaded from: classes.dex */
    public class StateAdapter extends FragmentStateAdapter {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StateAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            AppDetailsActivity.this = r1;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            if (i != 1) {
                return AppOverview.newInstance(AppDetailsActivity.this.mUid);
            }
            return new ConnectionsFragment();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 2;
        }

        public int getPageTitle(int i) {
            return i != 1 ? R.string.overview : R.string.connections_view;
        }
    }

    public /* synthetic */ void lambda$setupTabs$0(StateAdapter stateAdapter, TabLayout.Tab tab, int i) {
        tab.setText(getString(stateAdapter.getPageTitle(i)));
    }

    private void setupTabs() {
        StateAdapter stateAdapter = new StateAdapter(this);
        this.mPager.setAdapter(stateAdapter);
        new zzw((TabLayout) findViewById(R.id.tablayout), this.mPager, new CaptureCtrl$$ExternalSyntheticLambda0(this, stateAdapter, 1)).attach();
    }

    private void setupUidFilter() {
        Intent intent = getIntent();
        if (intent == null) {
            intent = new Intent();
            setIntent(intent);
        }
        FilterDescriptor filterDescriptor = new FilterDescriptor();
        filterDescriptor.uid = this.mUid;
        intent.putExtra("filter", filterDescriptor);
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.app_details);
        displayBackAction();
        setContentView(R.layout.tabs_activity);
        this.mUid = getIntent().getIntExtra(APP_UID_EXTRA, -1);
        setupUidFilter();
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.pager);
        this.mPager = viewPager2;
        Utils.fixViewPager2Insets(viewPager2);
        setupTabs();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        View view;
        if (i == 20) {
            View currentFocus = getCurrentFocus();
            Log.d(TAG, "onKeyDown focus ".concat(currentFocus.getClass().getName()));
            if (currentFocus instanceof TabLayout.TabView) {
                int currentItem = this.mPager.getCurrentItem();
                Log.d(TAG, "TabLayout.TabView focus pos " + currentItem);
                if (currentItem == 0) {
                    view = findViewById(R.id.app_overview);
                } else if (currentItem == 1) {
                    view = findViewById(R.id.connections);
                } else {
                    view = null;
                }
                if (view != null) {
                    view.requestFocus();
                    return true;
                }
            }
        } else if (i == 22 && this.mPager.getCurrentItem() == 1) {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.connections_view);
            if (recyclerView.getFocusedChild() != null) {
                Log.d(TAG, "onKeyDown (right) focus " + recyclerView.getFocusedChild());
                View findViewById = findViewById(R.id.fabDown);
                if (findViewById != null) {
                    findViewById.requestFocus();
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }
}
