package com.emanuelef.remote_capture.fragments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda0;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Cidr;
import com.emanuelef.remote_capture.ConnectionsRegister;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.AppDetailsActivity;
import com.emanuelef.remote_capture.activities.ConnectionDetailsActivity;
import com.emanuelef.remote_capture.activities.EditFilterActivity;
import com.emanuelef.remote_capture.activities.IABActivity;
import com.emanuelef.remote_capture.activities.MainActivity$$ExternalSyntheticLambda8;
import com.emanuelef.remote_capture.adapters.ConnectionsAdapter;
import com.emanuelef.remote_capture.adapters.HttpLogAdapter$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.interfaces.ConnectionsListener;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.Blocklist;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.FilterDescriptor;
import com.emanuelef.remote_capture.model.MatchList;
import com.emanuelef.remote_capture.model.Prefs;
import com.emanuelef.remote_capture.views.AppSelectDialog$$ExternalSyntheticLambda3;
import com.emanuelef.remote_capture.views.EmptyRecyclerView;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.Slider;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class ConnectionsFragment extends Fragment implements ConnectionsListener, MenuProvider, SearchView.OnQueryTextListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String FILTER_EXTRA = "filter";
    public static final String QUERY_EXTRA = "query";
    private static final String TAG = "ConnectionsFragment";
    private static boolean maliciousWarningShown = false;
    private boolean autoScroll;
    private boolean listenerSet;
    private ActionMode mActionMode;
    private ChipGroup mActiveFilter;
    private ConnectionsAdapter mAdapter;
    private AlertDialog mAlertDialog;
    private AppsResolver mApps;
    private Uri mCsvFname;
    private String mDecRemoveCidr;
    private TextView mEmptyText;
    private FloatingActionButton mFabDown;
    private Handler mHandler;
    private MenuItem mMenuFilter;
    private MenuItem mMenuItemSearch;
    private TextView mOldConnectionsText;
    private String mQueryToApply;
    private EmptyRecyclerView mRecyclerView;
    private MenuItem mSave;
    private SearchView mSearchView;
    private Slider mSizeSlider;
    private String mUnblockCidr;
    private int mFabDownMargin = 0;
    private boolean mSizeSliderActive = false;
    private final ActivityResultLauncher csvFileLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new ConnectionsFragment$$ExternalSyntheticLambda3(this, 0));
    private final ActivityResultLauncher filterLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new ConnectionsFragment$$ExternalSyntheticLambda3(this, 3));
    private final ActionMode.Callback mActionModeCallback = new ActionMode.Callback() { // from class: com.emanuelef.remote_capture.fragments.ConnectionsFragment.3
        {
            ConnectionsFragment.this = this;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == C0130R.C0132id.select_all) {
                if (ConnectionsFragment.this.mAdapter.getSelectedCount() == ConnectionsFragment.this.mAdapter.getItemCount()) {
                    actionMode.finish();
                    return true;
                }
                ConnectionsFragment.this.mAdapter.selectAll();
                ConnectionsFragment.this.updateActionModeTitle();
                return true;
            } else if (itemId != C0130R.C0132id.save) {
                return false;
            } else {
                ConnectionsFragment.this.openFileSelector();
                return true;
            }
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(C0130R.C0134menu.connections_cab, menu);
            return true;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            ConnectionsFragment.this.mAdapter.clearSelection();
            ConnectionsFragment.this.mActionMode = null;
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }
    };

    public void csvFileResult(ActivityResult activityResult) {
        Intent intent;
        if (activityResult.mResultCode != -1 || (intent = activityResult.mData) == null) {
            this.mCsvFname = null;
            return;
        }
        this.mCsvFname = intent.getData();
        dumpCsv();
    }

    private void dumpCsv() {
        boolean z;
        if (this.mCsvFname != null) {
            Log.m587d(TAG, "Writing CSV file: " + this.mCsvFname);
            ConnectionsAdapter connectionsAdapter = this.mAdapter;
            if (this.mActionMode != null) {
                z = true;
            } else {
                z = false;
            }
            String dumpConnectionsCsv = connectionsAdapter.dumpConnectionsCsv(z);
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            boolean[] zArr = {false};
            zzbv zzbvVar = new zzbv(requireContext());
            zzbvVar.setTitle(C0130R.string.exporting);
            zzbvVar.setMessage(C0130R.string.export_in_progress);
            zzbvVar.setNegativeButton(17039360, new HttpLogFragment$$ExternalSyntheticLambda4(zArr, newSingleThreadExecutor, 1));
            AlertDialog create = zzbvVar.create();
            this.mAlertDialog = create;
            create.setCanceledOnTouchOutside(false);
            this.mAlertDialog.show();
            this.mAlertDialog.setOnCancelListener(new HttpLogFragment$$ExternalSyntheticLambda5(zArr, newSingleThreadExecutor, 1));
            this.mAlertDialog.setOnDismissListener(new AppSelectDialog$$ExternalSyntheticLambda3(3, this));
            Uri uri = this.mCsvFname;
            this.mCsvFname = null;
            newSingleThreadExecutor.execute(new MainActivity$$ExternalSyntheticLambda8(this, uri, dumpConnectionsCsv, zArr, handler));
        }
    }

    public void filterResult(ActivityResult activityResult) {
        Intent intent;
        FilterDescriptor filterDescriptor;
        if (activityResult.mResultCode == -1 && (intent = activityResult.mData) != null && (filterDescriptor = (FilterDescriptor) Utils.getSerializableExtra(intent, "filter", FilterDescriptor.class)) != null) {
            ConnectionsAdapter connectionsAdapter = this.mAdapter;
            connectionsAdapter.mFilter = filterDescriptor;
            connectionsAdapter.refreshFilteredConnections();
            refreshActiveFilter();
        }
    }

    public /* synthetic */ void lambda$connectionsAdded$13(ConnectionDescriptor[] connectionDescriptorArr, int i) {
        Log.m587d(TAG, "Add " + connectionDescriptorArr.length + " connections at " + i);
        this.mAdapter.connectionsAdded(i, connectionDescriptorArr);
        if (this.autoScroll) {
            scrollToBottom();
        }
        recheckUntrackedConnections();
        recheckMaxConnectionSize();
    }

    public /* synthetic */ void lambda$connectionsChanges$12(int i) {
        Log.m587d(TAG, "New connections size: " + i);
        this.mAdapter.connectionsChanges(i);
        recheckScroll();
        if (this.autoScroll) {
            scrollToBottom();
        }
        recheckUntrackedConnections();
    }

    public /* synthetic */ void lambda$connectionsRemoved$14(ConnectionDescriptor[] connectionDescriptorArr, int i) {
        Log.m587d(TAG, "Remove " + connectionDescriptorArr.length + " connections at " + i);
        this.mAdapter.connectionsRemoved(i, connectionDescriptorArr);
    }

    public /* synthetic */ void lambda$connectionsUpdated$15(int[] iArr) {
        this.mAdapter.connectionsUpdated(iArr);
        recheckMaxConnectionSize();
    }

    public static /* synthetic */ void lambda$dumpCsv$16(boolean[] zArr, ExecutorService executorService, DialogInterface dialogInterface, int i) {
        Log.m583i(TAG, "Abort CSV export");
        zArr[0] = true;
        executorService.shutdownNow();
    }

    public static /* synthetic */ void lambda$dumpCsv$17(boolean[] zArr, ExecutorService executorService, DialogInterface dialogInterface) {
        Log.m583i(TAG, "Abort CSV export (back button)");
        zArr[0] = true;
        executorService.shutdownNow();
    }

    public /* synthetic */ void lambda$dumpCsv$18(DialogInterface dialogInterface) {
        this.mAlertDialog = null;
    }

    public /* synthetic */ void lambda$dumpCsv$19(boolean z, Utils.UriStat uriStat) {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (!z) {
            Utils.showToast(requireContext(), C0130R.string.cannot_write_file, new Object[0]);
        } else if (uriStat != null) {
            Toast.makeText(requireContext(), String.format(getString(C0130R.string.file_saved_with_name), uriStat.name), 0).show();
        } else {
            Utils.showToast(requireContext(), C0130R.string.save_ok, new Object[0]);
        }
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void lambda$dumpCsv$20(Uri uri, String str, boolean[] zArr, Handler handler) {
        boolean z;
        Utils.UriStat uriStat;
        OutputStream openOutputStream;
        try {
            openOutputStream = requireActivity().getContentResolver().openOutputStream(uri, "rwt");
        } catch (IOException e) {
            if (!zArr[0]) {
                e.printStackTrace();
            }
        }
        if (openOutputStream != null) {
            openOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            openOutputStream.close();
            z = true;
            if (zArr[0]) {
                if (z) {
                    uriStat = Utils.getUriStat(requireContext(), uri);
                } else {
                    uriStat = null;
                }
                handler.post(new ConnectionsFragment$$ExternalSyntheticLambda6(0, this, uriStat, z));
                return;
            }
            return;
        }
        z = false;
        if (zArr[0]) {
        }
    }

    public static /* synthetic */ String lambda$onViewCreated$0(float f) {
        return Utils.formatBytes(f * 1024);
    }

    public /* synthetic */ void lambda$onViewCreated$1(Slider slider, float f, boolean z) {
        ConnectionsAdapter connectionsAdapter = this.mAdapter;
        if (connectionsAdapter != null) {
            connectionsAdapter.mFilter.minSize = f * 1024;
            refreshFilteredConnections();
        }
    }

    public /* synthetic */ void lambda$onViewCreated$2(ChipGroup chipGroup, List list) {
        if (this.mAdapter != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.mAdapter.mFilter.clear(((Integer) it.next()).intValue());
            }
            refreshFilteredConnections();
        }
    }

    public /* synthetic */ void lambda$onViewCreated$3(View view) {
        ArrayList<Integer> filteredConnectionIds;
        int childLayoutPosition = this.mRecyclerView.getChildLayoutPosition(view);
        if (this.mActionMode != null) {
            toggleSelection(childLayoutPosition);
            return;
        }
        ConnectionDescriptor item = this.mAdapter.getItem(childLayoutPosition);
        if (item != null) {
            Intent intent = new Intent(requireContext(), ConnectionDetailsActivity.class);
            intent.putExtra(ConnectionDetailsActivity.CONN_ID_KEY, item.incr_id);
            if (this.mAdapter.hasFilter() && (filteredConnectionIds = this.mAdapter.getFilteredConnectionIds()) != null) {
                intent.putIntegerArrayListExtra(ConnectionDetailsActivity.FILTERED_IDS_KEY, filteredConnectionIds);
            }
            startActivity(intent);
        }
    }

    public /* synthetic */ boolean lambda$onViewCreated$4(View view) {
        if (this.mActionMode == null) {
            return false;
        }
        toggleSelection(this.mRecyclerView.getChildLayoutPosition(view));
        return true;
    }

    public static WindowInsetsCompat lambda$onViewCreated$5(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.mImpl.getInsets(135);
        int i = insets.left;
        int i2 = insets.top;
        int i3 = insets.right;
        view.setPadding(i, i2, i3, 0);
        return windowInsetsCompat.mImpl.inset(insets.left, i2, i3, 0);
    }

    public /* synthetic */ void lambda$onViewCreated$6(View view) {
        scrollToBottom();
    }

    public WindowInsetsCompat lambda$onViewCreated$7(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.mImpl.getInsets(143);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (this.mFabDownMargin == 0) {
            this.mFabDownMargin = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.bottomMargin = this.mFabDownMargin + insets.bottom;
        view.setLayoutParams(marginLayoutParams);
        return WindowInsetsCompat.CONSUMED;
    }

    public static /* synthetic */ void lambda$onViewCreated$8(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$onViewCreated$9(CaptureService.ServiceStatus serviceStatus) {
        if (serviceStatus == CaptureService.ServiceStatus.STARTED) {
            if (this.listenerSet) {
                unregisterConnsListener();
                registerConnsListener();
            }
            this.autoScroll = true;
            showFabDown(false);
            this.mOldConnectionsText.setVisibility(8);
            this.mEmptyText.setText(C0130R.string.no_connections);
            this.mApps.clear();
        }
        refreshMenuIcons();
    }

    public /* synthetic */ void lambda$showFirewallPurchaseDialog$10(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(requireContext(), IABActivity.class));
    }

    public static /* synthetic */ void lambda$showFirewallPurchaseDialog$11(DialogInterface dialogInterface, int i) {
    }

    public void recheckMaxConnectionSize() {
        ConnectionsRegister connsRegister;
        if (this.mSizeSlider.getVisibility() == 0 && !this.mSizeSliderActive && (connsRegister = CaptureService.getConnsRegister()) != null) {
            float maxBytes = (float) (connsRegister.getMaxBytes() / 1024);
            if (maxBytes > this.mSizeSlider.getValueTo()) {
                this.mSizeSlider.setValueTo(maxBytes);
            }
        }
    }

    public void recheckScroll() {
        boolean z;
        EmptyRecyclerView.MyLinearLayoutManager myLinearLayoutManager = (EmptyRecyclerView.MyLinearLayoutManager) this.mRecyclerView.getLayoutManager();
        int findFirstCompletelyVisibleItemPosition = myLinearLayoutManager.findFirstCompletelyVisibleItemPosition();
        if (myLinearLayoutManager.findLastCompletelyVisibleItemPosition() >= this.mAdapter.getItemCount() - 1) {
            z = true;
        } else {
            z = false;
        }
        if (findFirstCompletelyVisibleItemPosition == 0 && z) {
            showFabDown(false);
        } else if (z) {
            this.autoScroll = true;
            showFabDown(false);
        } else {
            this.autoScroll = false;
            showFabDown(true);
        }
    }

    private void recheckUntrackedConnections() {
        ConnectionsRegister requireConnsRegister = CaptureService.requireConnsRegister();
        if (requireConnsRegister.getUntrackedConnCount() > 0) {
            this.mOldConnectionsText.setText(String.format(getString(C0130R.string.older_connections_notice), Integer.valueOf(requireConnsRegister.getUntrackedConnCount())));
            this.mOldConnectionsText.setVisibility(0);
            return;
        }
        this.mOldConnectionsText.setVisibility(8);
    }

    private void refreshActiveFilter() {
        if (this.mAdapter != null) {
            this.mActiveFilter.removeAllViews();
            this.mAdapter.mFilter.toChips(getLayoutInflater(), this.mActiveFilter);
            long j = this.mAdapter.mFilter.minSize / 1024;
            ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
            if (connsRegister != null && j > 0) {
                long max = Math.max(connsRegister.getMaxBytes() / 1024, j);
                if (max >= 2) {
                    this.mSizeSlider.setValueTo((float) max);
                    this.mSizeSlider.setValue((float) j);
                    if (this.mSizeSlider.getVisibility() != 0) {
                        this.mSizeSlider.setVisibility(0);
                        this.mSizeSlider.setLabelBehavior(3);
                    }
                }
            }
        }
    }

    private void refreshEmptyText() {
        int i;
        if (CaptureService.getConnsRegister() != null || CaptureService.isServiceActive()) {
            TextView textView = this.mEmptyText;
            if (this.mAdapter.hasFilter()) {
                i = C0130R.string.no_matches_found;
            } else {
                i = C0130R.string.no_connections;
            }
            textView.setText(i);
            return;
        }
        this.mEmptyText.setText(C0130R.string.capture_not_running_status);
    }

    private void refreshFilteredConnections() {
        this.mAdapter.refreshFilteredConnections();
        refreshMenuIcons();
        refreshActiveFilter();
        recheckScroll();
    }

    private void refreshMenuIcons() {
        boolean z;
        if (this.mSave != null) {
            if (CaptureService.getConnsRegister() != null) {
                z = true;
            } else {
                z = false;
            }
            this.mMenuItemSearch.setVisible(z);
            this.mSave.setEnabled(z);
        }
    }

    private void registerConnsListener() {
        ConnectionsRegister connsRegister;
        if (!this.listenerSet && (connsRegister = CaptureService.getConnsRegister()) != null) {
            connsRegister.addListener(this);
            this.listenerSet = true;
        }
    }

    private void scrollToBottom() {
        this.mRecyclerView.scrollToPosition(this.mAdapter.getItemCount() - 1);
        showFabDown(false);
    }

    private void setQuery(String str) {
        Utils.setSearchQuery(this.mSearchView, this.mMenuItemSearch, str);
    }

    private void showFabDown(boolean z) {
        if (z) {
            this.mFabDown.show(true);
        } else {
            this.mFabDown.hide(true);
        }
    }

    private void showFirewallPurchaseDialog() {
        zzbv zzbvVar = new zzbv(requireContext());
        zzbvVar.setTitle(C0130R.string.paid_feature);
        ((AlertController.AlertParams) zzbvVar.zza).mMessage = Utils.getText(requireContext(), C0130R.string.firewall_purchase_msg, getString(C0130R.string.no_root_firewall));
        zzbvVar.setPositiveButton(C0130R.string.show_me, new AppsFragment$$ExternalSyntheticLambda0(5, this));
        zzbvVar.setNegativeButton(C0130R.string.cancel_action, new Blocklist$$ExternalSyntheticLambda0(15));
        zzbvVar.show();
    }

    private void startSelectionMode(ConnectionDescriptor connectionDescriptor) {
        if (this.mActionMode == null) {
            this.mActionMode = ((AppCompatActivity) requireActivity()).startSupportActionMode(this.mActionModeCallback);
            int i = 0;
            while (true) {
                if (i < this.mAdapter.getItemCount()) {
                    ConnectionDescriptor item = this.mAdapter.getItem(i);
                    if (item != null && item.incr_id == connectionDescriptor.incr_id) {
                        this.mAdapter.selectItem(i);
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            updateActionModeTitle();
        }
    }

    private void toggleSelection(int i) {
        this.mAdapter.toggleSelection(i);
        if (this.mAdapter.getSelectedCount() == 0) {
            ActionMode actionMode = this.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
                return;
            }
            return;
        }
        updateActionModeTitle();
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

    public void updateActionModeTitle() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.setTitle(getString(C0130R.string.n_selected, Integer.valueOf(this.mAdapter.getSelectedCount())));
        }
    }

    public void clearFilters() {
        ConnectionsAdapter connectionsAdapter = this.mAdapter;
        if (connectionsAdapter != null) {
            connectionsAdapter.mFilter = new FilterDescriptor();
            this.mAdapter.refreshFilteredConnections();
            refreshActiveFilter();
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsAdded(int i, ConnectionDescriptor[] connectionDescriptorArr) {
        this.mHandler.post(new ConnectionsFragment$$ExternalSyntheticLambda2(this, connectionDescriptorArr, i, 1));
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsChanges(int i) {
        Utils.runOnUi(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(i, 1, this), this.mHandler);
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsRemoved(int i, ConnectionDescriptor[] connectionDescriptorArr) {
        this.mHandler.post(new ConnectionsFragment$$ExternalSyntheticLambda2(this, connectionDescriptorArr, i, 0));
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsUpdated(int[] iArr) {
        this.mHandler.post(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda0(this, 2, iArr));
    }

    public boolean onBackPressed() {
        ActionMode actionMode = this.mActionMode;
        if (actionMode == null) {
            return Utils.backHandleSearchview(this.mSearchView);
        }
        actionMode.finish();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:161:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x02b7  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onContextItemSelected(MenuItem menuItem) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Context requireContext = requireContext();
        ConnectionDescriptor selectedItem = this.mAdapter.getSelectedItem();
        MatchList malwareWhitelist = PCAPdroid.getInstance().getMalwareWhitelist();
        MatchList firewallWhitelist = PCAPdroid.getInstance().getFirewallWhitelist();
        MatchList decryptionList = PCAPdroid.getInstance().getDecryptionList();
        Blocklist blocklist = PCAPdroid.getInstance().getBlocklist();
        boolean isPurchased = Billing.newInstance(requireContext).isPurchased(Billing.FIREWALL_SKU);
        if (selectedItem == null) {
            return super.onContextItemSelected(menuItem);
        }
        int itemId = menuItem.getItemId();
        if (itemId == C0130R.C0132id.select_connection) {
            startSelectionMode(selectedItem);
            return true;
        }
        if (itemId == C0130R.C0132id.hide_app) {
            this.mAdapter.mMask.addApp(selectedItem.uid);
        } else if (itemId == C0130R.C0132id.hide_host) {
            this.mAdapter.mMask.addHost(selectedItem.info);
        } else if (itemId == C0130R.C0132id.hide_ip) {
            this.mAdapter.mMask.addIp(selectedItem.dst_ip);
        } else if (itemId == C0130R.C0132id.hide_proto) {
            this.mAdapter.mMask.addProto(selectedItem.l7proto);
        } else if (itemId == C0130R.C0132id.hide_domain) {
            this.mAdapter.mMask.addHost(Utils.getSecondLevelDomain(selectedItem.info));
        } else if (itemId == C0130R.C0132id.hide_country) {
            this.mAdapter.mMask.addCountry(selectedItem.country);
        } else {
            if (itemId == C0130R.C0132id.search_app) {
                AppDescriptor appByUid = this.mApps.getAppByUid(selectedItem.uid, 0);
                if (appByUid == null) {
                    return super.onContextItemSelected(menuItem);
                }
                setQuery(appByUid.getPackageName());
            } else if (itemId == C0130R.C0132id.search_host) {
                setQuery(selectedItem.info);
            } else if (itemId == C0130R.C0132id.search_ip) {
                setQuery(selectedItem.dst_ip);
            } else if (itemId == C0130R.C0132id.search_proto) {
                setQuery(selectedItem.l7proto);
            } else {
                if (itemId == C0130R.C0132id.mw_whitelist_app) {
                    malwareWhitelist.addApp(selectedItem.uid);
                } else if (itemId == C0130R.C0132id.mw_whitelist_ip) {
                    malwareWhitelist.addIp(selectedItem.dst_ip);
                } else if (itemId == C0130R.C0132id.mw_whitelist_host) {
                    malwareWhitelist.addHost(selectedItem.info);
                } else {
                    if (itemId == C0130R.C0132id.dec_add_app) {
                        decryptionList.addApp(selectedItem.uid);
                    } else if (itemId == C0130R.C0132id.dec_add_ip) {
                        decryptionList.addIp(selectedItem.dst_ip);
                    } else if (itemId == C0130R.C0132id.dec_add_host) {
                        decryptionList.addHost(selectedItem.info);
                    } else if (itemId == C0130R.C0132id.dec_rem_app) {
                        decryptionList.removeApp(selectedItem.uid);
                    } else if (itemId == C0130R.C0132id.dec_rem_ip) {
                        String str = this.mDecRemoveCidr;
                        if (str == null) {
                            str = selectedItem.dst_ip;
                        }
                        decryptionList.removeIp(str);
                    } else if (itemId == C0130R.C0132id.dec_rem_host) {
                        decryptionList.removeHost(selectedItem.info);
                    } else {
                        if (itemId == C0130R.C0132id.block_app) {
                            if (isPurchased) {
                                blocklist.addApp(selectedItem.uid);
                                z = true;
                            } else {
                                showFirewallPurchaseDialog();
                            }
                        } else if (itemId == C0130R.C0132id.block_ip) {
                            if (isPurchased) {
                                blocklist.addIp(selectedItem.dst_ip);
                                z = true;
                            } else {
                                showFirewallPurchaseDialog();
                            }
                        } else if (itemId == C0130R.C0132id.block_host) {
                            if (isPurchased) {
                                blocklist.addHost(selectedItem.info);
                                z = true;
                            } else {
                                showFirewallPurchaseDialog();
                            }
                        } else if (itemId == C0130R.C0132id.block_domain) {
                            if (isPurchased) {
                                blocklist.addHost(Utils.getSecondLevelDomain(selectedItem.info));
                                z = true;
                            } else {
                                showFirewallPurchaseDialog();
                            }
                        } else if (itemId != C0130R.C0132id.block_country) {
                            if (itemId == C0130R.C0132id.unblock_app_permanently) {
                                blocklist.removeApp(selectedItem.uid);
                            } else if (itemId == C0130R.C0132id.unblock_app_10m) {
                                z = blocklist.unblockAppForMinutes(selectedItem.uid, 10);
                            } else if (itemId == C0130R.C0132id.unblock_app_1h) {
                                z = blocklist.unblockAppForMinutes(selectedItem.uid, 60);
                            } else if (itemId == C0130R.C0132id.unblock_app_8h) {
                                z = blocklist.unblockAppForMinutes(selectedItem.uid, 480);
                            } else if (itemId == C0130R.C0132id.unblock_ip) {
                                String str2 = this.mUnblockCidr;
                                if (str2 == null) {
                                    str2 = selectedItem.dst_ip;
                                }
                                blocklist.removeIp(str2);
                            } else if (itemId == C0130R.C0132id.unblock_host) {
                                blocklist.removeHost(selectedItem.info);
                            } else if (itemId == C0130R.C0132id.unblock_domain) {
                                blocklist.removeHost(Utils.getSecondLevelDomain(selectedItem.info));
                            } else if (itemId == C0130R.C0132id.unblock_country) {
                                blocklist.removeCountry(selectedItem.country);
                            } else {
                                if (itemId == C0130R.C0132id.add_to_fw_whitelist) {
                                    firewallWhitelist.addApp(selectedItem.uid);
                                } else if (itemId == C0130R.C0132id.remove_from_fw_whitelist) {
                                    firewallWhitelist.removeApp(selectedItem.uid);
                                } else if (itemId == C0130R.C0132id.open_app_details) {
                                    Intent intent = new Intent(requireContext(), AppDetailsActivity.class);
                                    intent.putExtra(AppDetailsActivity.APP_UID_EXTRA, selectedItem.uid);
                                    startActivity(intent);
                                } else if (itemId == C0130R.C0132id.copy_ip) {
                                    Utils.copyToClipboard(requireContext, selectedItem.dst_ip);
                                } else if (itemId == C0130R.C0132id.copy_host) {
                                    Utils.copyToClipboard(requireContext, selectedItem.info);
                                } else if (itemId == C0130R.C0132id.copy_url) {
                                    Utils.copyToClipboard(requireContext, selectedItem.url);
                                } else if (itemId == C0130R.C0132id.copy_http_request) {
                                    Utils.copyToClipboard(requireContext, selectedItem.getHttpRequest());
                                } else if (itemId != C0130R.C0132id.copy_http_response) {
                                    return super.onContextItemSelected(menuItem);
                                } else {
                                    Utils.copyToClipboard(requireContext, selectedItem.getHttpResponse());
                                }
                                z = false;
                                z5 = false;
                                z4 = false;
                                z3 = true;
                                z2 = false;
                                if (!z5) {
                                    this.mAdapter.mMask.save();
                                    this.mAdapter.mFilter.showMasked = false;
                                    refreshFilteredConnections();
                                } else if (z4) {
                                    malwareWhitelist.save();
                                    CaptureService.reloadMalwareWhitelist();
                                } else if (z3) {
                                    firewallWhitelist.save();
                                    if (CaptureService.isServiceActive()) {
                                        CaptureService.requireInstance().reloadFirewallWhitelist();
                                    }
                                } else if (z2) {
                                    decryptionList.save();
                                    CaptureService.reloadDecryptionList();
                                } else if (z) {
                                    blocklist.saveAndReload();
                                }
                                return true;
                            }
                            z = true;
                        } else if (isPurchased) {
                            blocklist.addCountry(selectedItem.country);
                            z = true;
                        } else {
                            showFirewallPurchaseDialog();
                        }
                        z5 = false;
                        z4 = false;
                        z3 = false;
                        z2 = false;
                        if (!z5) {
                        }
                        return true;
                    }
                    z = false;
                    z5 = false;
                    z4 = false;
                    z3 = false;
                    z2 = true;
                    if (!z5) {
                    }
                    return true;
                }
                z = false;
                z5 = false;
                z4 = true;
                z3 = false;
                z2 = false;
                if (!z5) {
                }
                return true;
            }
            z = false;
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = false;
            if (!z5) {
            }
            return true;
        }
        z = false;
        z5 = true;
        z4 = false;
        z3 = false;
        z2 = false;
        if (!z5) {
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        boolean z;
        char c;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str;
        boolean z7;
        String str2;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        Cidr matchesCidr;
        Cidr matchesCidr2;
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        requireActivity().getMenuInflater().inflate(C0130R.C0134menu.connection_context_menu, contextMenu);
        ConnectionDescriptor selectedItem = this.mAdapter.getSelectedItem();
        if (selectedItem != null) {
            AppDescriptor appByUid = this.mApps.getAppByUid(selectedItem.uid, 0);
            Context requireContext = requireContext();
            PlayBilling newInstance = Billing.newInstance(requireContext);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext);
            boolean isFirewallVisible = newInstance.isFirewallVisible();
            boolean isFirewallWhitelistMode = Prefs.isFirewallWhitelistMode(defaultSharedPreferences);
            if (newInstance.isPurchased(Billing.FIREWALL_SKU) || !newInstance.isAvailable(Billing.FIREWALL_SKU) || CaptureService.isCapturingAsRoot()) {
                z = false;
            } else {
                z = true;
            }
            Blocklist blocklist = PCAPdroid.getInstance().getBlocklist();
            MatchList firewallWhitelist = PCAPdroid.getInstance().getFirewallWhitelist();
            MatchList decryptionList = PCAPdroid.getInstance().getDecryptionList();
            if (appByUid != null) {
                z5 = blocklist.matchesApp(appByUid.getUid());
                z4 = !z5;
                c = 0;
                boolean matchesApp = decryptionList.matchesApp(appByUid.getUid());
                z3 = !matchesApp;
                MenuItem findItem = contextMenu.findItem(C0130R.C0132id.hide_app);
                String shorten = Utils.shorten(MatchList.getRuleLabel(requireContext, MatchList.RuleType.APP, appByUid.getPackageName()), 32);
                findItem.setTitle(shorten);
                findItem.setVisible(true);
                MenuItem findItem2 = contextMenu.findItem(C0130R.C0132id.search_app);
                findItem2.setTitle(shorten);
                findItem2.setVisible(true);
                MenuItem findItem3 = contextMenu.findItem(C0130R.C0132id.block_app);
                findItem3.setTitle(shorten);
                findItem3.setVisible(!z5);
                MenuItem findItem4 = contextMenu.findItem(C0130R.C0132id.unblock_app);
                findItem4.setTitle(shorten);
                findItem4.setVisible(z5);
                MenuItem findItem5 = contextMenu.findItem(C0130R.C0132id.dec_add_app);
                findItem5.setTitle(shorten);
                findItem5.setVisible(!matchesApp);
                MenuItem findItem6 = contextMenu.findItem(C0130R.C0132id.dec_rem_app);
                findItem6.setTitle(shorten);
                findItem6.setVisible(matchesApp);
                z2 = z;
                contextMenu.findItem(C0130R.C0132id.unblock_app_10m).setTitle(getString(C0130R.string.unblock_for_n_minutes, 10));
                contextMenu.findItem(C0130R.C0132id.unblock_app_1h).setTitle(getString(C0130R.string.unblock_for_n_hours, 1));
                contextMenu.findItem(C0130R.C0132id.unblock_app_8h).setTitle(getString(C0130R.string.unblock_for_n_hours, 8));
                if (selectedItem.isBlacklisted()) {
                    MenuItem findItem7 = contextMenu.findItem(C0130R.C0132id.mw_whitelist_app);
                    findItem7.setTitle(shorten);
                    findItem7.setVisible(true);
                }
                if (isFirewallVisible && isFirewallWhitelistMode) {
                    boolean matchesApp2 = firewallWhitelist.matchesApp(appByUid.getUid());
                    contextMenu.findItem(C0130R.C0132id.add_to_fw_whitelist).setVisible(!matchesApp2);
                    contextMenu.findItem(C0130R.C0132id.remove_from_fw_whitelist).setVisible(matchesApp2);
                }
                z6 = matchesApp;
            } else {
                z2 = z;
                c = 0;
                z6 = false;
                z5 = false;
                z4 = false;
                z3 = false;
            }
            String str3 = selectedItem.info;
            if (str3 != null && !str3.isEmpty()) {
                boolean matchesExactHost = blocklist.matchesExactHost(selectedItem.info);
                MatchList.RuleType ruleType = MatchList.RuleType.HOST;
                String shorten2 = Utils.shorten(MatchList.getRuleLabel(requireContext, ruleType, selectedItem.info), 32);
                boolean z14 = (!matchesExactHost) | z4;
                boolean z15 = z5 | matchesExactHost;
                boolean matchesExactHost2 = decryptionList.matchesExactHost(selectedItem.info);
                z3 |= !matchesExactHost2;
                z6 |= matchesExactHost2;
                MenuItem findItem8 = contextMenu.findItem(C0130R.C0132id.hide_host);
                findItem8.setTitle(shorten2);
                findItem8.setVisible(true);
                MenuItem findItem9 = contextMenu.findItem(C0130R.C0132id.block_host);
                findItem9.setTitle(shorten2);
                findItem9.setVisible(!matchesExactHost);
                MenuItem findItem10 = contextMenu.findItem(C0130R.C0132id.unblock_host);
                findItem10.setTitle(shorten2);
                findItem10.setVisible(matchesExactHost);
                MenuItem findItem11 = contextMenu.findItem(C0130R.C0132id.search_host);
                findItem11.setTitle(shorten2);
                findItem11.setVisible(true);
                MenuItem findItem12 = contextMenu.findItem(C0130R.C0132id.copy_host);
                findItem12.setTitle(shorten2);
                findItem12.setVisible(true);
                MenuItem findItem13 = contextMenu.findItem(C0130R.C0132id.dec_add_host);
                findItem13.setTitle(shorten2);
                findItem13.setVisible(!matchesExactHost2);
                MenuItem findItem14 = contextMenu.findItem(C0130R.C0132id.dec_rem_host);
                findItem14.setTitle(shorten2);
                findItem14.setVisible(matchesExactHost2);
                String cleanDomain = Utils.cleanDomain(selectedItem.info);
                String secondLevelDomain = Utils.getSecondLevelDomain(cleanDomain);
                if (!secondLevelDomain.equals(cleanDomain)) {
                    boolean matchesExactHost3 = blocklist.matchesExactHost(secondLevelDomain);
                    shorten2 = Utils.shorten(MatchList.getRuleLabel(requireContext, ruleType, secondLevelDomain), 32);
                    boolean z16 = (!matchesExactHost3) | z14;
                    boolean z17 = z15 | matchesExactHost3;
                    MenuItem findItem15 = contextMenu.findItem(C0130R.C0132id.hide_domain);
                    findItem15.setTitle(shorten2);
                    findItem15.setVisible(true);
                    MenuItem findItem16 = contextMenu.findItem(C0130R.C0132id.block_domain);
                    findItem16.setTitle(shorten2);
                    findItem16.setVisible(!matchesExactHost3);
                    MenuItem findItem17 = contextMenu.findItem(C0130R.C0132id.unblock_domain);
                    findItem17.setTitle(shorten2);
                    findItem17.setVisible(matchesExactHost3);
                    z4 = z16;
                    z5 = z17;
                } else {
                    z4 = z14;
                    z5 = z15;
                }
                if (selectedItem.isBlacklistedHost()) {
                    MenuItem findItem18 = contextMenu.findItem(C0130R.C0132id.mw_whitelist_host);
                    findItem18.setTitle(shorten2);
                    findItem18.setVisible(true);
                }
            }
            String str4 = selectedItem.url;
            if (str4 != null && !str4.isEmpty()) {
                MenuItem findItem19 = contextMenu.findItem(C0130R.C0132id.copy_url);
                String string = getString(C0130R.string.url_val);
                Object[] objArr = new Object[1];
                objArr[c] = selectedItem.url;
                findItem19.setTitle(Utils.shorten(String.format(string, objArr), 32));
                findItem19.setVisible(true);
            }
            if (!selectedItem.country.isEmpty()) {
                boolean matchesCountry = blocklist.matchesCountry(selectedItem.country);
                String string2 = getString(C0130R.string.country_val);
                Object[] objArr2 = new Object[1];
                objArr2[c] = Utils.getCountryName(requireContext, selectedItem.country);
                String shorten3 = Utils.shorten(String.format(string2, objArr2), 32);
                z4 |= !matchesCountry;
                z5 |= matchesCountry;
                MenuItem findItem20 = contextMenu.findItem(C0130R.C0132id.block_country);
                findItem20.setTitle(shorten3);
                findItem20.setVisible(!matchesCountry);
                MenuItem findItem21 = contextMenu.findItem(C0130R.C0132id.unblock_country);
                findItem21.setTitle(shorten3);
                findItem21.setVisible(matchesCountry);
                MenuItem findItem22 = contextMenu.findItem(C0130R.C0132id.hide_country);
                findItem22.setTitle(shorten3);
                findItem22.setVisible(true);
            }
            String ruleLabel = MatchList.getRuleLabel(requireContext, MatchList.RuleType.IP, selectedItem.dst_ip);
            contextMenu.findItem(C0130R.C0132id.hide_ip).setTitle(ruleLabel);
            contextMenu.findItem(C0130R.C0132id.copy_ip).setTitle(ruleLabel);
            contextMenu.findItem(C0130R.C0132id.search_ip).setTitle(ruleLabel);
            this.mUnblockCidr = null;
            this.mDecRemoveCidr = null;
            boolean matchesExactIP = blocklist.matchesExactIP(selectedItem.dst_ip);
            if (matchesExactIP || (matchesCidr2 = blocklist.matchesCidr(selectedItem.dst_ip)) == null) {
                str = ruleLabel;
            } else {
                this.mUnblockCidr = matchesCidr2.toString();
                str = MatchList.getCidrLabel(requireContext, matchesCidr2);
                matchesExactIP = true;
            }
            boolean z18 = (!matchesExactIP) | z4;
            boolean z19 = z5 | matchesExactIP;
            boolean matchesExactIP2 = decryptionList.matchesExactIP(selectedItem.dst_ip);
            if (matchesExactIP2 || (matchesCidr = decryptionList.matchesCidr(selectedItem.dst_ip)) == null) {
                z7 = matchesExactIP2;
                str2 = ruleLabel;
            } else {
                this.mDecRemoveCidr = matchesCidr.toString();
                str2 = MatchList.getCidrLabel(requireContext, matchesCidr);
                z7 = true;
            }
            boolean z20 = z3 | (!z7);
            boolean z21 = z6 | z7;
            contextMenu.findItem(C0130R.C0132id.block_ip).setTitle(ruleLabel).setVisible(!matchesExactIP);
            contextMenu.findItem(C0130R.C0132id.unblock_ip).setTitle(str).setVisible(matchesExactIP);
            contextMenu.findItem(C0130R.C0132id.dec_add_ip).setTitle(ruleLabel).setVisible(!z7);
            contextMenu.findItem(C0130R.C0132id.dec_rem_ip).setTitle(str2).setVisible(z7);
            if (selectedItem.isBlacklistedIp()) {
                z8 = true;
                contextMenu.findItem(C0130R.C0132id.mw_whitelist_ip).setTitle(ruleLabel).setVisible(true);
            } else {
                z8 = true;
            }
            if (selectedItem.hasHttpRequest()) {
                contextMenu.findItem(C0130R.C0132id.copy_http_request).setVisible(z8);
            }
            if (selectedItem.hasHttpResponse()) {
                contextMenu.findItem(C0130R.C0132id.copy_http_response).setVisible(z8);
            }
            String ruleLabel2 = MatchList.getRuleLabel(requireContext, MatchList.RuleType.PROTOCOL, selectedItem.l7proto);
            contextMenu.findItem(C0130R.C0132id.hide_proto).setTitle(ruleLabel2);
            contextMenu.findItem(C0130R.C0132id.search_proto).setTitle(ruleLabel2);
            MenuItem findItem23 = contextMenu.findItem(C0130R.C0132id.block_menu);
            if ((isFirewallVisible || z2) && z18) {
                z9 = true;
            } else {
                z9 = false;
            }
            findItem23.setVisible(z9);
            MenuItem findItem24 = contextMenu.findItem(C0130R.C0132id.unblock_menu);
            if (!isFirewallVisible || !z19) {
                z10 = false;
            } else {
                z10 = true;
            }
            findItem24.setVisible(z10);
            if (!selectedItem.isBlacklisted()) {
                contextMenu.findItem(C0130R.C0132id.mw_whitelist_menu).setVisible(false);
            }
            boolean isDecryptionListEnabled = CaptureService.isDecryptionListEnabled();
            if (selectedItem.isNotDecryptable() || selectedItem.isCleartext()) {
                z11 = false;
            } else {
                z11 = true;
            }
            MenuItem findItem25 = contextMenu.findItem(C0130R.C0132id.decrypt_menu);
            if (!isDecryptionListEnabled || !z11 || !z20) {
                z12 = false;
            } else {
                z12 = true;
            }
            findItem25.setVisible(z12);
            MenuItem findItem26 = contextMenu.findItem(C0130R.C0132id.dont_decrypt_menu);
            if (!isDecryptionListEnabled || !z11 || !z21) {
                z13 = false;
            } else {
                z13 = true;
            }
            findItem26.setVisible(z13);
        }
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C0130R.C0134menu.connections_menu, menu);
        this.mSave = menu.findItem(C0130R.C0132id.save);
        this.mMenuFilter = menu.findItem(C0130R.C0132id.edit_filter);
        MenuItem findItem = menu.findItem(C0130R.C0132id.search);
        this.mMenuItemSearch = findItem;
        SearchView searchView = (SearchView) findItem.getActionView();
        this.mSearchView = searchView;
        searchView.setOnQueryTextListener(this);
        String str = this.mQueryToApply;
        if (str != null && !str.isEmpty()) {
            String str2 = this.mQueryToApply;
            this.mQueryToApply = null;
            setQuery(str2);
        }
        refreshMenuIcons();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!(getParentFragment() instanceof DataViewContainerFragment)) {
            requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        }
        return layoutInflater.inflate(C0130R.layout.connections, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            ActionMode actionMode = this.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
            }
            clearFilters();
            return;
        }
        EmptyRecyclerView emptyRecyclerView = this.mRecyclerView;
        if (emptyRecyclerView != null) {
            emptyRecyclerView.scrollToPosition(0);
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C0130R.C0132id.save) {
            openFileSelector();
            return true;
        } else if (itemId != C0130R.C0132id.edit_filter) {
            return false;
        } else {
            Intent intent = new Intent(requireContext(), EditFilterActivity.class);
            intent.putExtra("filter", this.mAdapter.mFilter);
            this.filterLauncher.launch(intent);
            return true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unregisterConnsListener();
        this.mRecyclerView.setEmptyView(null);
        SearchView searchView = this.mSearchView;
        if (searchView != null) {
            this.mQueryToApply = searchView.getQuery().toString();
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        this.mAdapter.setSearch(str);
        recheckScroll();
        refreshEmptyText();
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        boolean z;
        int i;
        super.onResume();
        refreshEmptyText();
        registerConnsListener();
        this.mRecyclerView.setEmptyView(this.mEmptyText);
        refreshMenuIcons();
        ConnectionsAdapter connectionsAdapter = this.mAdapter;
        if (connectionsAdapter != null) {
            int i2 = 0;
            if (connectionsAdapter.mFilter.minSize >= 1024) {
                z = true;
            } else {
                z = false;
            }
            Slider slider = this.mSizeSlider;
            if (!z) {
                i2 = 8;
            }
            slider.setVisibility(i2);
            Slider slider2 = this.mSizeSlider;
            if (z) {
                i = 3;
            } else {
                i = 2;
            }
            slider2.setLabelBehavior(i);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        SearchView searchView = this.mSearchView;
        if (searchView != null) {
            bundle.putString("search", searchView.getQuery().toString());
        }
        ConnectionsAdapter connectionsAdapter = this.mAdapter;
        if (connectionsAdapter != null) {
            bundle.putSerializable("filter_desc", connectionsAdapter.mFilter);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String str;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mFabDown = (FloatingActionButton) view.findViewById(C0130R.C0132id.fabDown);
        this.mRecyclerView = (EmptyRecyclerView) view.findViewById(C0130R.C0132id.connections_view);
        this.mOldConnectionsText = (TextView) view.findViewById(C0130R.C0132id.old_connections_notice);
        EmptyRecyclerView.MyLinearLayoutManager myLinearLayoutManager = new EmptyRecyclerView.MyLinearLayoutManager(requireContext());
        this.mRecyclerView.setLayoutManager(myLinearLayoutManager);
        this.mApps = new AppsResolver(requireContext());
        this.mEmptyText = (TextView) view.findViewById(C0130R.C0132id.no_connections);
        Slider slider = (Slider) view.findViewById(C0130R.C0132id.size_slider);
        this.mSizeSlider = slider;
        slider.setLabelFormatter(new TransportImpl$$ExternalSyntheticLambda0(6));
        Slider slider2 = this.mSizeSlider;
        boolean z = true;
        slider2.changeListeners.add(new HttpLogFragment$$ExternalSyntheticLambda14(this, 1));
        Slider slider3 = this.mSizeSlider;
        slider3.touchListeners.add(new BaseOnSliderTouchListener() { // from class: com.emanuelef.remote_capture.fragments.ConnectionsFragment.1
            {
                ConnectionsFragment.this = this;
            }

            public void onStartTrackingTouch(Slider slider4) {
                ConnectionsFragment.this.mSizeSliderActive = true;
            }

            public void onStopTrackingTouch(Slider slider4) {
                if (slider4.getValue() == 0.0f) {
                    slider4.setVisibility(8);
                    slider4.setLabelBehavior(2);
                }
                ConnectionsFragment.this.mSizeSliderActive = false;
                ConnectionsFragment.this.recheckMaxConnectionSize();
            }
        });
        ChipGroup chipGroup = (ChipGroup) view.findViewById(C0130R.C0132id.active_filter);
        this.mActiveFilter = chipGroup;
        chipGroup.setOnCheckedStateChangeListener(new ConnectionsFragment$$ExternalSyntheticLambda3(this, 1));
        ConnectionsAdapter connectionsAdapter = new ConnectionsAdapter(requireContext(), this.mApps);
        this.mAdapter = connectionsAdapter;
        this.mRecyclerView.setAdapter(connectionsAdapter);
        boolean z2 = false;
        this.listenerSet = false;
        registerForContextMenu(this.mRecyclerView);
        this.mRecyclerView.addItemDecoration(new DividerItemDecoration(this.mRecyclerView.getContext(), myLinearLayoutManager.getOrientation()));
        this.mAdapter.setClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.fragments.ConnectionsFragment$$ExternalSyntheticLambda16
            public final /* synthetic */ ConnectionsFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (r2) {
                    case 0:
                        this.f$0.lambda$onViewCreated$3(view2);
                        return;
                    default:
                        this.f$0.lambda$onViewCreated$6(view2);
                        return;
                }
            }
        });
        this.mAdapter.setSelectionLongClickListener(new HttpLogAdapter$$ExternalSyntheticLambda0(1, this));
        this.autoScroll = true;
        showFabDown(false);
        View findViewById = view.findViewById(C0130R.C0132id.linearlayout);
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(7);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(findViewById, transportImpl$$ExternalSyntheticLambda0);
        this.mFabDown.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.fragments.ConnectionsFragment$$ExternalSyntheticLambda16
            public final /* synthetic */ ConnectionsFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (r2) {
                    case 0:
                        this.f$0.lambda$onViewCreated$3(view2);
                        return;
                    default:
                        this.f$0.lambda$onViewCreated$6(view2);
                        return;
                }
            }
        });
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this.mFabDown, new ConnectionsFragment$$ExternalSyntheticLambda3(this, 2));
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.emanuelef.remote_capture.fragments.ConnectionsFragment.2
            {
                ConnectionsFragment.this = this;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                ConnectionsFragment.this.recheckScroll();
            }
        });
        refreshMenuIcons();
        Intent intent = requireActivity().getIntent();
        if (intent != null) {
            FilterDescriptor filterDescriptor = (FilterDescriptor) Utils.getSerializableExtra(intent, "filter", FilterDescriptor.class);
            if (filterDescriptor != null) {
                this.mAdapter.mFilter = filterDescriptor;
                if (filterDescriptor.onlyBlacklisted && !maliciousWarningShown) {
                    zzbv zzbvVar = new zzbv(requireContext());
                    zzbvVar.setTitle(C0130R.string.malicious_connections);
                    zzbvVar.setMessage(C0130R.string.malicious_connections_notice);
                    zzbvVar.setPositiveButton(C0130R.string.ok, new Blocklist$$ExternalSyntheticLambda0(16));
                    zzbvVar.show();
                    maliciousWarningShown = true;
                }
                z2 = true;
            }
            str = intent.getStringExtra(QUERY_EXTRA);
            if (str == null || str.isEmpty()) {
                z = z2;
            } else {
                this.mAdapter.mFilter.showMasked = true;
            }
        } else {
            str = "";
            z = false;
        }
        if (bundle != null) {
            if (str == null || str.isEmpty()) {
                str = bundle.getString("search");
            }
            if (!z && bundle.containsKey("filter_desc")) {
                this.mAdapter.mFilter = (FilterDescriptor) Utils.getSerializable(bundle, "filter_desc", FilterDescriptor.class);
            }
        }
        refreshActiveFilter();
        if (str != null && !str.isEmpty()) {
            this.mQueryToApply = str;
        }
        CaptureService.observeStatus(this, new AppsFragment$$ExternalSyntheticLambda3(4, this));
    }

    public void openFileSelector() {
        String exportFileName = Utils.getExportFileName(requireContext(), "csv");
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.TITLE", exportFileName);
        if (Utils.supportsFileDialog(requireContext(), intent)) {
            try {
                this.csvFileLauncher.launch(intent);
                return;
            } catch (ActivityNotFoundException unused) {
            }
        }
        Log.m581w(TAG, "No app found to handle file selection");
        Uri downloadsUri = Utils.getDownloadsUri(requireContext(), exportFileName);
        if (downloadsUri != null) {
            this.mCsvFname = downloadsUri;
            dumpCsv();
            return;
        }
        Utils.showToastLong(requireContext(), C0130R.string.no_activity_file_selection, new Object[0]);
    }
}
