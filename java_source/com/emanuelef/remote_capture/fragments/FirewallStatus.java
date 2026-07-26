package com.emanuelef.remote_capture.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.p002os.BundleKt;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.preference.PreferenceManager;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.ConnectionsRegister;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.ConnectionsActivity;
import com.emanuelef.remote_capture.activities.FirewallActivity;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.model.Blocklist;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.FilterDescriptor;
import com.emanuelef.remote_capture.model.MatchList;
import com.emanuelef.remote_capture.model.Prefs;
import com.google.android.material.chip.Chip$$ExternalSyntheticLambda0;
/* loaded from: classes.dex */
public class FirewallStatus extends Fragment implements MenuProvider {
    private static final String TAG = "FirewallStatus";
    private static boolean whitelistWarningAck = false;
    private Blocklist mBlocklist;
    private int mGrayColor;
    private Handler mHandler;
    private TextView mLastBlock;
    private Menu mMenu;
    private TextView mNumBlocked;
    private TextView mNumChecked;
    private TextView mNumRules;
    private int mOkColor;
    private SharedPreferences mPrefs;
    private TextView mStatus;
    private ImageView mStatusIcon;
    private SwitchCompat mToggle;
    private int mWarnColor;
    private MatchList mWhitelist;

    public /* synthetic */ void lambda$onCreateMenu$1(CompoundButton compoundButton, boolean z) {
        String str;
        if (z != Prefs.isFirewallEnabled(requireContext(), this.mPrefs)) {
            if (z) {
                str = "enabled";
            } else {
                str = "disabled";
            }
            Log.m587d(TAG, "Firwall is now ".concat(str));
            CaptureService.setFirewallEnabled(z);
            this.mPrefs.edit().putBoolean(Prefs.PREF_FIREWALL, z).apply();
            updateStatus();
        }
    }

    public /* synthetic */ void lambda$onMenuItemSelected$2(MenuItem menuItem, DialogInterface dialogInterface, int i) {
        whitelistWarningAck = true;
        menuItem.setChecked(true);
        this.mPrefs.edit().putBoolean(Prefs.PREF_FIREWALL_WHITELIST_MODE, true).apply();
        reloadMode(true);
    }

    public static /* synthetic */ void lambda$onMenuItemSelected$3(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$onViewCreated$0(View view) {
        FilterDescriptor filterDescriptor = new FilterDescriptor();
        filterDescriptor.filteringStatus = ConnectionDescriptor.FilteringStatus.BLOCKED;
        startActivity(new Intent(requireContext(), ConnectionsActivity.class).putExtra("filter", filterDescriptor));
    }

    private void reloadMode(boolean z) {
        if (z && CaptureService.isServiceActive()) {
            CaptureService.requireInstance().reloadFirewallWhitelist();
        }
        ((FirewallActivity) requireActivity()).recheckTabs();
        updateStatus();
    }

    public void updateStatus() {
        int i;
        long j;
        Context requireContext = requireContext();
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        boolean isServiceActive = CaptureService.isServiceActive();
        boolean isFirewallEnabled = Prefs.isFirewallEnabled(requireContext, this.mPrefs);
        boolean isFirewallWhitelistMode = Prefs.isFirewallWhitelistMode(this.mPrefs);
        if (!isServiceActive) {
            this.mStatusIcon.setImageResource(C0130R.C0131drawable.ic_shield);
            this.mStatusIcon.setColorFilter(this.mGrayColor);
            this.mStatus.setText(C0130R.string.capture_not_running_status);
        } else if (CaptureService.isDNSEncrypted()) {
            this.mStatusIcon.setImageResource(C0130R.C0131drawable.ic_exclamation_triangle_solid);
            this.mStatusIcon.setColorFilter(this.mWarnColor);
            this.mStatus.setText(C0130R.string.private_dns_hinders_detection);
        } else {
            this.mStatusIcon.setImageResource(C0130R.C0131drawable.ic_shield);
            if (isFirewallEnabled) {
                this.mStatusIcon.setColorFilter(this.mOkColor);
                this.mStatus.setText(C0130R.string.firewall_is_enabled);
            } else {
                this.mStatusIcon.setColorFilter(this.mWarnColor);
                this.mStatus.setText(C0130R.string.firewall_is_disabled);
            }
        }
        SwitchCompat switchCompat = this.mToggle;
        if (switchCompat != null) {
            switchCompat.setChecked(isFirewallEnabled);
        }
        TextView textView = this.mNumBlocked;
        int i2 = 0;
        if (connsRegister != null) {
            i = connsRegister.getNumBlockedConnections();
        } else {
            i = 0;
        }
        textView.setText(Utils.formatIntShort(i));
        this.mNumChecked.setText(Utils.formatIntShort(CaptureService.getNumCheckedFirewallConnections()));
        TextView textView2 = this.mLastBlock;
        if (connsRegister != null) {
            j = connsRegister.getLastFirewallBlock() / 1000;
        } else {
            j = 0;
        }
        textView2.setText(Utils.formatEpochMin(requireContext, j));
        TextView textView3 = this.mNumRules;
        int size = this.mBlocklist.getSize();
        if (isFirewallWhitelistMode) {
            i2 = this.mWhitelist.getSize();
        }
        textView3.setText(Utils.formatIntShort(size + i2));
        this.mHandler.postDelayed(new ActivityCompat$$ExternalSyntheticLambda0(12, this), 1000L);
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C0130R.C0134menu.firewall_menu, menu);
        this.mMenu = menu;
        SwitchCompat switchCompat = (SwitchCompat) menu.findItem(C0130R.C0132id.toggle_btn).getActionView();
        this.mToggle = switchCompat;
        switchCompat.setOnCheckedChangeListener(new Chip$$ExternalSyntheticLambda0(1, this));
        menu.findItem(C0130R.C0132id.whitelist_mode).setChecked(Prefs.isFirewallWhitelistMode(this.mPrefs));
        menu.findItem(C0130R.C0132id.block_new_apps).setChecked(Prefs.blockNewApps(this.mPrefs));
        reloadMode(false);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return layoutInflater.inflate(C0130R.layout.firewall_status, viewGroup, false);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C0130R.C0132id.user_guide) {
            Utils.startActivity(requireContext(), new Intent("android.intent.action.VIEW", Uri.parse(MainActivity.FIREWALL_DOCS_URL)));
            return true;
        } else if (itemId == C0130R.C0132id.block_new_apps) {
            boolean z = !menuItem.isChecked();
            menuItem.setChecked(z);
            this.mPrefs.edit().putBoolean(Prefs.PREF_BLOCK_NEW_APPS, z).apply();
            return true;
        } else if (itemId != C0130R.C0132id.whitelist_mode) {
            return false;
        } else {
            boolean isChecked = menuItem.isChecked();
            boolean z2 = !isChecked;
            if (isChecked || whitelistWarningAck) {
                menuItem.setChecked(z2);
                this.mPrefs.edit().putBoolean(Prefs.PREF_FIREWALL_WHITELIST_MODE, z2).apply();
                reloadMode(true);
                return true;
            }
            zzbv zzbvVar = new zzbv(requireContext());
            zzbvVar.setTitle(C0130R.string.whitelist_mode);
            zzbvVar.setMessage(C0130R.string.firewall_whitelist_notice);
            zzbvVar.setPositiveButton(C0130R.string.ok, new FirewallStatus$$ExternalSyntheticLambda2(this, 0, menuItem));
            zzbvVar.setNegativeButton(C0130R.string.cancel_action, new Blocklist$$ExternalSyntheticLambda0(19));
            zzbvVar.show().setCanceledOnTouchOutside(false);
            return true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        updateStatus();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Context context = view.getContext();
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.mBlocklist = PCAPdroid.getInstance().getBlocklist();
        this.mWhitelist = PCAPdroid.getInstance().getFirewallWhitelist();
        this.mStatus = (TextView) view.findViewById(C0130R.C0132id.status);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mStatusIcon = (ImageView) view.findViewById(C0130R.C0132id.status_icon);
        this.mNumBlocked = (TextView) view.findViewById(C0130R.C0132id.num_blocked);
        this.mNumChecked = (TextView) view.findViewById(C0130R.C0132id.num_checked);
        this.mNumRules = (TextView) view.findViewById(C0130R.C0132id.num_rules);
        this.mLastBlock = (TextView) view.findViewById(C0130R.C0132id.last_block);
        this.mOkColor = BundleKt.getColor(context, C0130R.color.ok);
        this.mWarnColor = BundleKt.getColor(context, C0130R.color.warning);
        this.mGrayColor = BundleKt.getColor(context, C0130R.color.lightGray);
        view.findViewById(C0130R.C0132id.show_connections).setOnClickListener(new AppsFragment$$ExternalSyntheticLambda2(4, this));
    }
}
