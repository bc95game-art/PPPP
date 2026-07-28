package com.emanuelef.remote_capture.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.p002os.BundleKt;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.FilterDescriptor;
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
        TabLayout tabLayout = (TabLayout) requireActivity.findViewById(C0130R.C0132id.tablayout);
        if (!(tabLayout == null || (tabAt = tabLayout.getTabAt(1)) == null)) {
            if (this.mCurrentView == 0) {
                i2 = C0130R.string.connections_view;
            } else {
                i2 = C0130R.string.http_requests;
            }
            tabAt.setText(getString(i2));
        }
        View findViewById = requireActivity.findViewById(C0130R.C0132id.tab_switch_button);
        if (findViewById != null) {
            if (this.mCurrentView == 0) {
                i = C0130R.string.switch_to_http;
            } else {
                i = C0130R.string.switch_to_connections;
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
        return layoutInflater.inflate(C0130R.layout.data_view_container, viewGroup, false);
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
    */
    public void onViewCreated(View view, Bundle bundle) {
        Bundle bundle2;
        super.onViewCreated(view, bundle);
        FragmentManager childFragmentManager = getChildFragmentManager();
        this.mConnectionsFragment = childFragmentManager.findFragmentByTag("connections");
        this.mHttpLogFragment = childFragmentManager.findFragmentByTag("http_log");
        Intent intent = requireActivity().getIntent();
        if (intent != null) {
            FilterDescriptor filterDescriptor = (FilterDescriptor) Utils.getSerializableExtra(intent, "filter", FilterDescriptor.class);
            String stringExtra = intent.getStringExtra(ConnectionsFragment.QUERY_EXTRA);
            if (filterDescriptor != null || (stringExtra != null && !stringExtra.isEmpty())) {
                this.mCurrentView = 0;
                bundle2 = new Bundle();
                if (filterDescriptor != null) {
                    bundle2.putSerializable("filter", filterDescriptor);
                }
                if (stringExtra != null && !stringExtra.isEmpty()) {
                    bundle2.putString(ConnectionsFragment.QUERY_EXTRA, stringExtra);
                }
                intent.removeExtra("filter");
                intent.removeExtra(ConnectionsFragment.QUERY_EXTRA);
                BackStackRecord backStackRecord = new BackStackRecord(childFragmentManager);
                if (this.mConnectionsFragment == null) {
                    ConnectionsFragment connectionsFragment = new ConnectionsFragment();
                    this.mConnectionsFragment = connectionsFragment;
                    if (bundle2 != null) {
                        connectionsFragment.setArguments(bundle2);
                    }
                    backStackRecord.doAddOp(C0130R.C0132id.child_fragment_container, this.mConnectionsFragment, "connections", 1);
                }
                if (this.mHttpLogFragment == null) {
                    HttpLogFragment httpLogFragment = new HttpLogFragment();
                    this.mHttpLogFragment = httpLogFragment;
                    backStackRecord.doAddOp(C0130R.C0132id.child_fragment_container, httpLogFragment, "http_log", 1);
                }
                if (this.mCurrentView != 0) {
                    backStackRecord.show(this.mConnectionsFragment);
                    backStackRecord.hide(this.mHttpLogFragment);
                } else {
                    backStackRecord.show(this.mHttpLogFragment);
                    backStackRecord.hide(this.mConnectionsFragment);
                }
                backStackRecord.commit();
                updateTabTitle();
            }
        }
        bundle2 = null;
        BackStackRecord backStackRecord2 = new BackStackRecord(childFragmentManager);
        if (this.mConnectionsFragment == null) {
        }
        if (this.mHttpLogFragment == null) {
        }
        if (this.mCurrentView != 0) {
        }
        backStackRecord2.commit();
        updateTabTitle();
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
