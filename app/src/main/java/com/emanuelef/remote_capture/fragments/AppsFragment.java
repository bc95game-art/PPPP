package com.emanuelef.remote_capture.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.preference.PreferenceManager;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.ConnectionsRegister;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.activities.AppDetailsActivity;
import com.emanuelef.remote_capture.adapters.AppsStatsAdapter;
import com.emanuelef.remote_capture.interfaces.ConnectionsListener;
import com.emanuelef.remote_capture.model.AppStats;
import com.emanuelef.remote_capture.model.Blocklist;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.MatchList;
import com.emanuelef.remote_capture.model.Prefs;
import com.emanuelef.remote_capture.views.EmptyRecyclerView;
/* loaded from: classes.dex */
public class AppsFragment extends Fragment implements ConnectionsListener, MenuProvider {
    private static final String TAG = "AppsFragment";
    private boolean listenerSet;
    private AppsStatsAdapter mAdapter;
    private Handler mHandler;
    private Menu mMenu;
    private EmptyRecyclerView mRecyclerView;
    private boolean mRefreshApps;

    public void doRefreshApps() {
        this.mRefreshApps = false;
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        if (connsRegister != null) {
            this.mAdapter.setStats(connsRegister.getAppsStats());
        }
    }

    public /* synthetic */ void lambda$onMenuItemSelected$2(DialogInterface dialogInterface, int i) {
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        if (connsRegister != null) {
            connsRegister.resetAppsStats();
            doRefreshApps();
        }
    }

    public static /* synthetic */ void lambda$onMenuItemSelected$3(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$onViewCreated$0(View view) {
        int itemId = (int) this.mAdapter.getItemId(this.mRecyclerView.getChildLayoutPosition(view));
        Intent intent = new Intent(getActivity(), AppDetailsActivity.class);
        intent.putExtra(AppDetailsActivity.APP_UID_EXTRA, itemId);
        startActivity(intent);
    }

    public /* synthetic */ void lambda$onViewCreated$1(CaptureService.ServiceStatus serviceStatus) {
        if (serviceStatus == CaptureService.ServiceStatus.STARTED && this.listenerSet) {
            unregisterConnsListener();
            registerConnsListener();
        }
    }

    private void refreshAppsAsync() {
        if (!this.mRefreshApps) {
            this.mRefreshApps = true;
            this.mHandler.postDelayed(new ActivityCompat$$ExternalSyntheticLambda0(10, this), 100L);
        }
    }

    private void refreshSortField() {
        AppsStatsAdapter appsStatsAdapter;
        if (this.mMenu != null && (appsStatsAdapter = this.mAdapter) != null) {
            AppsStatsAdapter.SortField sortField = appsStatsAdapter.getSortField();
            Log.d(TAG, "Sort field:" + sortField);
            MenuItem findItem = this.mMenu.findItem(R.id.sort_by_name);
            MenuItem findItem2 = this.mMenu.findItem(R.id.sort_by_total_bytes);
            MenuItem findItem3 = this.mMenu.findItem(R.id.sort_by_bytes_sent);
            MenuItem findItem4 = this.mMenu.findItem(R.id.sort_by_bytes_rcvd);
            findItem.setChecked(false);
            findItem2.setChecked(false);
            findItem3.setChecked(false);
            findItem4.setChecked(false);
            if (sortField.equals(AppsStatsAdapter.SortField.NAME)) {
                findItem.setChecked(true);
            } else if (sortField.equals(AppsStatsAdapter.SortField.TOTAL_BYTES)) {
                findItem2.setChecked(true);
            } else if (sortField.equals(AppsStatsAdapter.SortField.BYTES_SENT)) {
                findItem3.setChecked(true);
            } else if (sortField.equals(AppsStatsAdapter.SortField.BYTES_RCVD)) {
                findItem4.setChecked(true);
            }
        }
    }

    private void registerConnsListener() {
        ConnectionsRegister connsRegister;
        if (!this.listenerSet && (connsRegister = CaptureService.getConnsRegister()) != null) {
            connsRegister.addListener(this);
            this.listenerSet = true;
        }
    }

    private void unregisterConnsListener() {
        if (this.listenerSet) {
            ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
            if (connsRegister != null) {
                connsRegister.removeListener(this);
            }
            this.listenerSet = false;
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsAdded(int i, ConnectionDescriptor[] connectionDescriptorArr) {
        refreshAppsAsync();
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsChanges(int i) {
        refreshAppsAsync();
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsRemoved(int i, ConnectionDescriptor[] connectionDescriptorArr) {
        refreshAppsAsync();
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsUpdated(int[] iArr) {
        refreshAppsAsync();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        Blocklist blocklist = PCAPdroid.getInstance().getBlocklist();
        MatchList firewallWhitelist = PCAPdroid.getInstance().getFirewallWhitelist();
        AppStats selectedItem = this.mAdapter.getSelectedItem();
        if (selectedItem == null) {
            return super.onContextItemSelected(menuItem);
        }
        if (itemId == R.id.block_app) {
            blocklist.addApp(selectedItem.getUid());
        } else if (itemId == R.id.unblock_app_permanently) {
            blocklist.removeApp(selectedItem.getUid());
        } else if (itemId == R.id.unblock_app_10m) {
            blocklist.unblockAppForMinutes(selectedItem.getUid(), 10);
        } else if (itemId == R.id.unblock_app_1h) {
            blocklist.unblockAppForMinutes(selectedItem.getUid(), 60);
        } else if (itemId == R.id.unblock_app_8h) {
            blocklist.unblockAppForMinutes(selectedItem.getUid(), 480);
        } else {
            if (itemId == R.id.add_to_fw_whitelist) {
                firewallWhitelist.addApp(selectedItem.getUid());
            } else if (itemId != R.id.remove_from_fw_whitelist) {
                return super.onContextItemSelected(menuItem);
            } else {
                firewallWhitelist.removeApp(selectedItem.getUid());
            }
            firewallWhitelist.save();
            if (CaptureService.isServiceActive()) {
                CaptureService.requireInstance().reloadFirewallWhitelist();
            }
            this.mAdapter.notifyItemChanged(selectedItem);
            return true;
        }
        blocklist.saveAndReload();
        this.mAdapter.notifyItemChanged(selectedItem);
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        Log.d(TAG, "onCreateContextMenu");
        requireActivity().getMenuInflater().inflate(R.menu.app_context_menu, contextMenu);
        AppStats selectedItem = this.mAdapter.getSelectedItem();
        if (selectedItem != null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
            boolean matchesApp = PCAPdroid.getInstance().getBlocklist().matchesApp(selectedItem.getUid());
            contextMenu.findItem(R.id.block_app).setVisible(!matchesApp);
            if (Prefs.isFirewallWhitelistMode(defaultSharedPreferences)) {
                boolean matchesApp2 = PCAPdroid.getInstance().getFirewallWhitelist().matchesApp(selectedItem.getUid());
                contextMenu.findItem(R.id.add_to_fw_whitelist).setVisible(!matchesApp2);
                contextMenu.findItem(R.id.remove_from_fw_whitelist).setVisible(matchesApp2);
            }
            contextMenu.findItem(R.id.unblock_app_permanently).setVisible(matchesApp);
            contextMenu.findItem(R.id.unblock_app_10m).setVisible(matchesApp).setTitle(getString(R.string.unblock_for_n_minutes, 10));
            contextMenu.findItem(R.id.unblock_app_1h).setVisible(matchesApp).setTitle(getString(R.string.unblock_for_n_hours, 1));
            contextMenu.findItem(R.id.unblock_app_8h).setVisible(matchesApp).setTitle(getString(R.string.unblock_for_n_hours, 8));
        }
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.apps_menu, menu);
        this.mMenu = menu;
        refreshSortField();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return layoutInflater.inflate(R.layout.apps_stats, viewGroup, false);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.reset) {
            zzbv zzbvVar = new zzbv(requireContext());
            zzbvVar.setMessage(R.string.reset_stats_confirm);
            zzbvVar.setPositiveButton(R.string.yes, new AppsFragment$$ExternalSyntheticLambda0(0, this));
            zzbvVar.setNegativeButton(R.string.no, new Blocklist$$ExternalSyntheticLambda0(14));
            zzbvVar.show();
            return true;
        } else if (itemId == R.id.sort_by_name) {
            this.mAdapter.setSortField(AppsStatsAdapter.SortField.NAME);
            refreshSortField();
            return true;
        } else if (itemId == R.id.sort_by_total_bytes) {
            this.mAdapter.setSortField(AppsStatsAdapter.SortField.TOTAL_BYTES);
            refreshSortField();
            return true;
        } else if (itemId == R.id.sort_by_bytes_sent) {
            this.mAdapter.setSortField(AppsStatsAdapter.SortField.BYTES_SENT);
            refreshSortField();
            return true;
        } else if (itemId != R.id.sort_by_bytes_rcvd) {
            return false;
        } else {
            this.mAdapter.setSortField(AppsStatsAdapter.SortField.BYTES_RCVD);
            refreshSortField();
            return true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterConnsListener();
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        registerConnsListener();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        EmptyRecyclerView emptyRecyclerView = (EmptyRecyclerView) view.findViewById(R.id.recycler_view);
        this.mRecyclerView = emptyRecyclerView;
        emptyRecyclerView.setLayoutManager(new EmptyRecyclerView.MyLinearLayoutManager(getContext()));
        registerForContextMenu(this.mRecyclerView);
        this.mAdapter = new AppsStatsAdapter(getContext());
        doRefreshApps();
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mRecyclerView.setEmptyView((TextView) view.findViewById(R.id.no_apps));
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRefreshApps = false;
        this.mAdapter.setClickListener(new AppsFragment$$ExternalSyntheticLambda2(0, this));
        CaptureService.observeStatus(this, new AppsFragment$$ExternalSyntheticLambda3(0, this));
    }
}
