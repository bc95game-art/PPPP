package com.emanuelef.remote_capture.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.ConnectionsRegister;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.AppStats;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class AppOverview extends Fragment implements MenuProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String UID_ARG = "UID";
    private TextView mBlockedConnections;
    private View mBlockedConnsRow;
    private TextView mBytes;
    private TextView mConnections;
    private boolean mCreateError;
    private Handler mHandler;
    private TextView mPermissions;
    private PackageInfo mPinfo;
    private TableLayout mTable;
    private int mUid;

    private String asString() {
        if (this.mPermissions.getVisibility() == 8) {
            return Utils.table2Text(this.mTable);
        }
        return Utils.table2Text(this.mTable) + "\n" + getString(R.string.permissions) + ":\n" + ((Object) this.mPermissions.getText());
    }

    public /* synthetic */ void lambda$onViewCreated$0(Context context, View view) {
        Utils.shareText(context, getString(R.string.permissions), this.mPermissions.getText().toString());
    }

    public static WindowInsetsCompat lambda$onViewCreated$1(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.mImpl.getInsets(135);
        view.setPadding(insets.left, 0, insets.right, insets.bottom);
        return windowInsetsCompat;
    }

    public static AppOverview newInstance(int i) {
        AppOverview appOverview = new AppOverview();
        Bundle bundle = new Bundle();
        bundle.putInt(UID_ARG, i);
        appOverview.setArguments(bundle);
        return appOverview;
    }

    private void updateStatus() {
        Context requireContext = requireContext();
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        if (connsRegister != null) {
            AppStats appStats = connsRegister.getAppStats(this.mUid);
            if (appStats == null) {
                appStats = new AppStats(this.mUid);
            }
            int i = 0;
            this.mBytes.setText(getString(R.string.rcvd_and_sent, Utils.formatBytes(appStats.rcvdBytes), Utils.formatBytes(appStats.sentBytes)));
            this.mConnections.setText(Utils.formatInteger(requireContext, appStats.numConnections));
            View view = this.mBlockedConnsRow;
            if (appStats.numBlockedConnections <= 0) {
                i = 8;
            }
            view.setVisibility(i);
            this.mBlockedConnections.setText(Utils.formatInteger(requireContext, appStats.numBlockedConnections));
        }
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.app_overview_menu, menu);
        if (this.mPinfo == null) {
            menu.findItem(R.id.app_info).setVisible(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return layoutInflater.inflate(R.layout.app_overview, viewGroup, false);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.app_info) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.mPinfo.packageName, null));
            Utils.startActivity(requireContext(), intent);
            return true;
        } else if (itemId == R.id.copy_to_clipboard) {
            Utils.copyToClipboard(requireContext(), asString());
            return true;
        } else if (itemId != R.id.share) {
            return false;
        } else {
            Utils.shareText(requireContext(), getString(R.string.app_details), asString());
            return true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (!this.mCreateError) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.mCreateError) {
            updateStatus();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String[] strArr;
        this.mUid = getArguments().getInt(UID_ARG);
        Context requireContext = requireContext();
        AppDescriptor appByUid = new AppsResolver(requireContext).getAppByUid(this.mUid, 4096);
        boolean z = true;
        if (appByUid == null) {
            this.mCreateError = true;
            Utils.showToast(requireContext, R.string.app_not_found, Integer.valueOf(this.mUid));
            requireActivity().finish();
            return;
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mBytes = (TextView) view.findViewById(R.id.detail_bytes);
        this.mConnections = (TextView) view.findViewById(R.id.connections);
        this.mBlockedConnections = (TextView) view.findViewById(R.id.conns_blocked);
        this.mBlockedConnsRow = view.findViewById(R.id.conns_blocked_row);
        this.mPermissions = (TextView) view.findViewById(R.id.permissions);
        if (Utils.isTv(requireContext)) {
            ((ViewGroup) view.findViewById(R.id.layout)).setDescendantFocusability(393216);
        }
        ((TextView) view.findViewById(R.id.uid)).setText(Utils.formatInteger(requireContext, appByUid.getUid()));
        ((TextView) view.findViewById(R.id.name)).setText(appByUid.getName());
        Drawable icon = appByUid.getIcon();
        if (icon == null) {
            icon = ContextCompat$Api21Impl.getDrawable(requireContext, R.drawable.ic_image);
        }
        ((ImageView) view.findViewById(R.id.app_icon)).setImageDrawable(icon);
        PackageInfo packageInfo = appByUid.getPackageInfo();
        this.mPinfo = packageInfo;
        if (packageInfo != null) {
            ((TextView) view.findViewById(R.id.package_name)).setText(appByUid.getPackageName());
            ((TextView) view.findViewById(R.id.version)).setText(this.mPinfo.versionName);
            ((TextView) view.findViewById(R.id.target_sdk)).setText(Utils.formatInteger(requireContext, this.mPinfo.applicationInfo.targetSdkVersion));
            ((TextView) view.findViewById(R.id.install_date)).setText(Utils.formatEpochFull(requireContext, this.mPinfo.firstInstallTime / 1000));
            ((TextView) view.findViewById(R.id.last_update)).setText(Utils.formatEpochFull(requireContext, this.mPinfo.lastUpdateTime / 1000));
            String[] strArr2 = this.mPinfo.requestedPermissions;
            if (strArr2 == null || strArr2.length == 0) {
                view.findViewById(R.id.permissions_label).setVisibility(8);
                view.findViewById(R.id.permissions).setVisibility(8);
            } else {
                StringBuilder sb = new StringBuilder();
                for (String str : this.mPinfo.requestedPermissions) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("\n");
                    }
                    sb.append(str);
                }
                this.mPermissions.setText(sb.toString());
                if (Utils.isTv(requireContext)) {
                    this.mPermissions.setOnClickListener(new AppOverview$$ExternalSyntheticLambda0(this, 0, requireContext));
                }
            }
        } else {
            if (!appByUid.getDescription().isEmpty()) {
                ((TextView) view.findViewById(R.id.vapp_info)).setText(appByUid.getDescription());
                view.findViewById(R.id.vapp_info).setVisibility(0);
            }
            view.findViewById(R.id.package_name_row).setVisibility(8);
            view.findViewById(R.id.version_row).setVisibility(8);
            view.findViewById(R.id.target_sdk_row).setVisibility(8);
            view.findViewById(R.id.install_date_row).setVisibility(8);
            view.findViewById(R.id.last_update_row).setVisibility(8);
            view.findViewById(R.id.permissions_label).setVisibility(8);
            view.findViewById(R.id.permissions).setVisibility(8);
        }
        this.mTable = (TableLayout) view.findViewById(R.id.table);
        ScrollView scrollView = (ScrollView) view.findViewById(R.id.app_overview);
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(4);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(scrollView, transportImpl$$ExternalSyntheticLambda0);
        scrollView.setClipToPadding(false);
    }
}
