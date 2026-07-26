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
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.ConnectionsRegister;
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
        return Utils.table2Text(this.mTable) + "\n" + getString(C0130R.string.permissions) + ":\n" + ((Object) this.mPermissions.getText());
    }

    public /* synthetic */ void lambda$onViewCreated$0(Context context, View view) {
        Utils.shareText(context, getString(C0130R.string.permissions), this.mPermissions.getText().toString());
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
            this.mBytes.setText(getString(C0130R.string.rcvd_and_sent, Utils.formatBytes(appStats.rcvdBytes), Utils.formatBytes(appStats.sentBytes)));
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
        menuInflater.inflate(C0130R.C0134menu.app_overview_menu, menu);
        if (this.mPinfo == null) {
            menu.findItem(C0130R.C0132id.app_info).setVisible(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return layoutInflater.inflate(C0130R.layout.app_overview, viewGroup, false);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C0130R.C0132id.app_info) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", this.mPinfo.packageName, null));
            Utils.startActivity(requireContext(), intent);
            return true;
        } else if (itemId == C0130R.C0132id.copy_to_clipboard) {
            Utils.copyToClipboard(requireContext(), asString());
            return true;
        } else if (itemId != C0130R.C0132id.share) {
            return false;
        } else {
            Utils.shareText(requireContext(), getString(C0130R.string.app_details), asString());
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
            Utils.showToast(requireContext, C0130R.string.app_not_found, Integer.valueOf(this.mUid));
            requireActivity().finish();
            return;
        }
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mBytes = (TextView) view.findViewById(C0130R.C0132id.detail_bytes);
        this.mConnections = (TextView) view.findViewById(C0130R.C0132id.connections);
        this.mBlockedConnections = (TextView) view.findViewById(C0130R.C0132id.conns_blocked);
        this.mBlockedConnsRow = view.findViewById(C0130R.C0132id.conns_blocked_row);
        this.mPermissions = (TextView) view.findViewById(C0130R.C0132id.permissions);
        if (Utils.isTv(requireContext)) {
            ((ViewGroup) view.findViewById(C0130R.C0132id.layout)).setDescendantFocusability(393216);
        }
        ((TextView) view.findViewById(C0130R.C0132id.uid)).setText(Utils.formatInteger(requireContext, appByUid.getUid()));
        ((TextView) view.findViewById(C0130R.C0132id.name)).setText(appByUid.getName());
        Drawable icon = appByUid.getIcon();
        if (icon == null) {
            icon = ContextCompat$Api21Impl.getDrawable(requireContext, C0130R.C0131drawable.ic_image);
        }
        ((ImageView) view.findViewById(C0130R.C0132id.app_icon)).setImageDrawable(icon);
        PackageInfo packageInfo = appByUid.getPackageInfo();
        this.mPinfo = packageInfo;
        if (packageInfo != null) {
            ((TextView) view.findViewById(C0130R.C0132id.package_name)).setText(appByUid.getPackageName());
            ((TextView) view.findViewById(C0130R.C0132id.version)).setText(this.mPinfo.versionName);
            ((TextView) view.findViewById(C0130R.C0132id.target_sdk)).setText(Utils.formatInteger(requireContext, this.mPinfo.applicationInfo.targetSdkVersion));
            ((TextView) view.findViewById(C0130R.C0132id.install_date)).setText(Utils.formatEpochFull(requireContext, this.mPinfo.firstInstallTime / 1000));
            ((TextView) view.findViewById(C0130R.C0132id.last_update)).setText(Utils.formatEpochFull(requireContext, this.mPinfo.lastUpdateTime / 1000));
            String[] strArr2 = this.mPinfo.requestedPermissions;
            if (strArr2 == null || strArr2.length == 0) {
                view.findViewById(C0130R.C0132id.permissions_label).setVisibility(8);
                view.findViewById(C0130R.C0132id.permissions).setVisibility(8);
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
                ((TextView) view.findViewById(C0130R.C0132id.vapp_info)).setText(appByUid.getDescription());
                view.findViewById(C0130R.C0132id.vapp_info).setVisibility(0);
            }
            view.findViewById(C0130R.C0132id.package_name_row).setVisibility(8);
            view.findViewById(C0130R.C0132id.version_row).setVisibility(8);
            view.findViewById(C0130R.C0132id.target_sdk_row).setVisibility(8);
            view.findViewById(C0130R.C0132id.install_date_row).setVisibility(8);
            view.findViewById(C0130R.C0132id.last_update_row).setVisibility(8);
            view.findViewById(C0130R.C0132id.permissions_label).setVisibility(8);
            view.findViewById(C0130R.C0132id.permissions).setVisibility(8);
        }
        this.mTable = (TableLayout) view.findViewById(C0130R.C0132id.table);
        ScrollView scrollView = (ScrollView) view.findViewById(C0130R.C0132id.app_overview);
        TransportImpl$$ExternalSyntheticLambda0 transportImpl$$ExternalSyntheticLambda0 = new TransportImpl$$ExternalSyntheticLambda0(4);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(scrollView, transportImpl$$ExternalSyntheticLambda0);
        scrollView.setClipToPadding(false);
    }
}
