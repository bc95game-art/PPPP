package com.emanuelef.remote_capture.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.emanuelef.remote_capture.R;
import com.google.android.material.tabs.TabLayout;
/* loaded from: classes.dex */
public class DataViewContainerFragment extends Fragment implements MenuProvider {
    private static final String STATE_CURRENT_VIEW = "current_view";
    private static final int TAB_POSITION = 1;
    private static final String TAG = "DataViewContainer";
    private static final int VIEW_CONNECTIONS = 0;
    private static final int VIEW_HTTP_LOG = 1;
    private Fragment mConnectionsFragment;
    private int mCurrentView = 0;
    private Fragment mHttpLogFragment;

    private void switchToView(int i) {
        if (this.mCurrentView != i) {
            this.mCurrentView = i;
            FragmentManager childFragmentManager = getChildFragmentManager();
            childFragmentManager.getClass();
            BackStackRecord backStackRecord = new BackStackRecord(childFragmentManager);
            if (this.mCurrentView == 0) {
                backStackRecord.hide(this.mHttpLogFragment);
                backStackRecord.show(this.mConnectionsFragment);
            } else {
                backStackRecord.hide(this.mConnectionsFragment);
                backStackRecord.show(this.mHttpLogFragment);
            }
            backStackRecord.commit();
            updateTabTitle();
            requireActivity().invalidateMenu();
        }
    }

    private void updateTabTitle() {
        int i;
        TabLayout.Tab tabAt;
        int i2;
        FragmentActivity requireActivity = requireActivity();
        TabLayout tabLayout = (TabLayout) requireActivity.findViewById(R.id.tablayout);
        if (!(tabLayout == null || (tabAt = tabLayout.getTabAt(1)) == null)) {
            if (this.mCurrentView == 0) {
                i2 = R.string.connections_view;
            } else {
                i2 = R.string.http_requests;
            }
            tabAt.setText(getString(i2));
        }
        View findViewById = requireActivity.findViewById(R.id.tab_switch_button);
        if (findViewById != null) {
            if (this.mCurrentView == 0) {
                i = R.string.switch_to_http;
            } else {
                i = R.string.switch_to_connections;
            }
            String string = getString(i);
            findViewById.setContentDescription(string);
            BundleKt.setTooltipText(findViewById, string);
        }
    }

    public boolean onBackPressed() {
        Fragment fragment;
        Fragment fragment2;
        int i = this.mCurrentView;
        if (i != 0 || (fragment2 = this.mConnectionsFragment) == null) {
            if (i != 1 || (fragment = this.mHttpLogFragment) == null || !(fragment instanceof HttpLogFragment)) {
                return false;
            }
            return ((HttpLogFragment) fragment).onBackPressed();
        } else if (fragment2 instanceof ConnectionsFragment) {
            return ((ConnectionsFragment) fragment2).onBackPressed();
        } else {
            return false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.mCurrentView = bundle.getInt(STATE_CURRENT_VIEW, 0);
        }
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        Fragment fragment;
        Fragment fragment2;
        int i = this.mCurrentView;
        if (i != 0 || (fragment2 = this.mConnectionsFragment) == null) {
            if (i == 1 && (fragment = this.mHttpLogFragment) != null && (fragment instanceof HttpLogFragment)) {
                ((HttpLogFragment) fragment).onCreateMenu(menu, menuInflater);
            }
        } else if (fragment2 instanceof ConnectionsFragment) {
            ((ConnectionsFragment) fragment2).onCreateMenu(menu, menuInflater);
        }
        updateTabTitle();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return layoutInflater.inflate(R.layout.data_view_container, viewGroup, false);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        Fragment fragment;
        Fragment fragment2;
        int i = this.mCurrentView;
        if (i != 0 || (fragment2 = this.mConnectionsFragment) == null) {
            if (i != 1 || (fragment = this.mHttpLogFragment) == null || !(fragment instanceof HttpLogFragment) || !((HttpLogFragment) fragment).onMenuItemSelected(menuItem)) {
                return false;
            }
            return true;
        } else if (!(fragment2 instanceof ConnectionsFragment) || !((ConnectionsFragment) fragment2).onMenuItemSelected(menuItem)) {
            return false;
        } else {
            return true;
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(STATE_CURRENT_VIEW, this.mCurrentView);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onViewCreated(android.view.View r8, android.os.Bundle r9) {
        /*
            r7 = this;
            super.onViewCreated(r8, r9)
            androidx.fragment.app.FragmentManager r8 = r7.getChildFragmentManager()
            java.lang.String r9 = "connections"
            androidx.fragment.app.Fragment r0 = r8.findFragmentByTag(r9)
            r7.mConnectionsFragment = r0
            java.lang.String r0 = "http_log"
            androidx.fragment.app.Fragment r1 = r8.findFragmentByTag(r0)
            r7.mHttpLogFragment = r1
            androidx.fragment.app.FragmentActivity r1 = r7.requireActivity()
            android.content.Intent r1 = r1.getIntent()
            if (r1 == 0) goto L5a
            java.lang.Class<com.emanuelef.remote_capture.model.FilterDescriptor> r2 = com.emanuelef.remote_capture.model.FilterDescriptor.class
            java.lang.String r3 = "filter"
            java.io.Serializable r2 = com.emanuelef.remote_capture.Utils.getSerializableExtra(r1, r3, r2)
            com.emanuelef.remote_capture.model.FilterDescriptor r2 = (com.emanuelef.remote_capture.model.FilterDescriptor) r2
            java.lang.String r4 = "query"
            java.lang.String r5 = r1.getStringExtra(r4)
            if (r2 != 0) goto L3b
            if (r5 == 0) goto L5a
            boolean r6 = r5.isEmpty()
            if (r6 != 0) goto L5a
        L3b:
            r6 = 0
            r7.mCurrentView = r6
            android.os.Bundle r6 = new android.os.Bundle
            r6.<init>()
            if (r2 == 0) goto L48
            r6.putSerializable(r3, r2)
        L48:
            if (r5 == 0) goto L53
            boolean r2 = r5.isEmpty()
            if (r2 != 0) goto L53
            r6.putString(r4, r5)
        L53:
            r1.removeExtra(r3)
            r1.removeExtra(r4)
            goto L5b
        L5a:
            r6 = 0
        L5b:
            androidx.fragment.app.BackStackRecord r1 = new androidx.fragment.app.BackStackRecord
            r1.<init>(r8)
            androidx.fragment.app.Fragment r8 = r7.mConnectionsFragment
            r2 = 1
            r3 = 2131361979(0x7f0a00bb, float:1.8343726E38)
            if (r8 != 0) goto L79
            com.emanuelef.remote_capture.fragments.ConnectionsFragment r8 = new com.emanuelef.remote_capture.fragments.ConnectionsFragment
            r8.<init>()
            r7.mConnectionsFragment = r8
            if (r6 == 0) goto L74
            r8.setArguments(r6)
        L74:
            androidx.fragment.app.Fragment r8 = r7.mConnectionsFragment
            r1.doAddOp(r3, r8, r9, r2)
        L79:
            androidx.fragment.app.Fragment r8 = r7.mHttpLogFragment
            if (r8 != 0) goto L87
            com.emanuelef.remote_capture.fragments.HttpLogFragment r8 = new com.emanuelef.remote_capture.fragments.HttpLogFragment
            r8.<init>()
            r7.mHttpLogFragment = r8
            r1.doAddOp(r3, r8, r0, r2)
        L87:
            int r8 = r7.mCurrentView
            if (r8 != 0) goto L96
            androidx.fragment.app.Fragment r8 = r7.mConnectionsFragment
            r1.show(r8)
            androidx.fragment.app.Fragment r8 = r7.mHttpLogFragment
            r1.hide(r8)
            goto La0
        L96:
            androidx.fragment.app.Fragment r8 = r7.mHttpLogFragment
            r1.show(r8)
            androidx.fragment.app.Fragment r8 = r7.mConnectionsFragment
            r1.hide(r8)
        La0:
            r1.commit()
            r7.updateTabTitle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.fragments.DataViewContainerFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public void toggleView() {
        int i;
        if (this.mCurrentView == 0) {
            i = 1;
        } else {
            i = 0;
        }
        switchToView(i);
    }
}
