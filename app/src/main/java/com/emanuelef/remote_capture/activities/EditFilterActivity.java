package com.emanuelef.remote_capture.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.MenuProvider;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.ConnectionsRegister;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda2;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.FilterDescriptor;
import com.emanuelef.remote_capture.model.ListInfo;
import com.emanuelef.remote_capture.model.Prefs;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.slider.Slider;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public class EditFilterActivity extends BaseActivity implements MenuProvider {
    public static final String FILTER_DESCRIPTOR = "filter";
    private static final String TAG = "EditFilterActivity";
    private ArrayList<Pair<ConnectionDescriptor.DecryptionStatus, Chip>> mDecChips;
    private FilterDescriptor mFilter;
    private ArrayList<Pair<ConnectionDescriptor.FilteringStatus, Chip>> mFirewallChips;
    private CheckBox mHideMasked;
    private ChipGroup mInterfaceGroup;
    private CheckBox mOnlyBlacklisted;
    private CheckBox mOnlyCleartext;
    private Slider mSizeSider;
    private ArrayList<Pair<ConnectionDescriptor.Status, Chip>> mStatusChips;

    private void finishOk() {
        view2model();
        Intent intent = new Intent();
        intent.putExtra("filter", this.mFilter);
        setResult(-1, intent);
        finish();
    }

    private <T> T getCheckedChip(ArrayList<Pair<T, Chip>> arrayList, T t) {
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Pair<T, Chip> pair = arrayList.get(i);
            i++;
            Pair<T, Chip> pair2 = pair;
            if (((Chip) pair2.second).isChecked()) {
                return (T) pair2.first;
            }
        }
        return t;
    }

    public /* synthetic */ void lambda$onCreate$0(View view) {
        Intent intent = new Intent(this, EditListActivity.class);
        intent.putExtra(EditListActivity.LIST_TYPE_EXTRA, ListInfo.Type.VISUALIZATION_MASK);
        startActivity(intent);
    }

    public static /* synthetic */ String lambda$onCreate$1(float f) {
        return Utils.formatBytes(f * 1024);
    }

    private void model2view() {
        this.mHideMasked.setChecked(!this.mFilter.showMasked);
        this.mOnlyBlacklisted.setChecked(this.mFilter.onlyBlacklisted);
        this.mOnlyCleartext.setChecked(this.mFilter.onlyCleartext);
        long j = this.mFilter.minSize / 1024;
        if (j > 0) {
            this.mSizeSider.setValue((float) j);
        }
        setCheckedChip(this.mStatusChips, this.mFilter.status);
        setCheckedChip(this.mDecChips, this.mFilter.decStatus);
        setCheckedChip(this.mFirewallChips, this.mFilter.filteringStatus);
        if (this.mFilter.iface != null) {
            int childCount = this.mInterfaceGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                Chip chip = (Chip) this.mInterfaceGroup.getChildAt(i);
                if (chip.getText().equals(this.mFilter.iface)) {
                    chip.setChecked(true);
                    return;
                }
            }
        }
    }

    private <T> void setCheckedChip(ArrayList<Pair<T, Chip>> arrayList, T t) {
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Pair<T, Chip> pair = arrayList.get(i);
            i++;
            Pair<T, Chip> pair2 = pair;
            ((Chip) pair2.second).setChecked(pair2.first.equals(t));
        }
    }

    private void view2model() {
        this.mFilter.showMasked = !this.mHideMasked.isChecked();
        this.mFilter.onlyBlacklisted = this.mOnlyBlacklisted.isChecked();
        this.mFilter.onlyCleartext = this.mOnlyCleartext.isChecked();
        this.mFilter.status = (ConnectionDescriptor.Status) getCheckedChip(this.mStatusChips, ConnectionDescriptor.Status.STATUS_INVALID);
        this.mFilter.decStatus = (ConnectionDescriptor.DecryptionStatus) getCheckedChip(this.mDecChips, ConnectionDescriptor.DecryptionStatus.INVALID);
        this.mFilter.filteringStatus = (ConnectionDescriptor.FilteringStatus) getCheckedChip(this.mFirewallChips, ConnectionDescriptor.FilteringStatus.INVALID);
        this.mFilter.minSize = this.mSizeSider.getValue() * 1024;
        int childCount = this.mInterfaceGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            Chip chip = (Chip) this.mInterfaceGroup.getChildAt(i);
            if (chip.isChecked()) {
                this.mFilter.iface = chip.getText().toString();
                return;
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finishOk();
        super.onBackPressed();
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FilterDescriptor filterDescriptor;
        super.onCreate(bundle);
        setContentView(R.layout.edit_filter_activity);
        setTitle(R.string.edit_filter);
        addMenuProvider(this);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setHomeAsUpIndicator();
        }
        Intent intent = getIntent();
        if (!(intent == null || (filterDescriptor = (FilterDescriptor) Utils.getSerializableExtra(intent, "filter", FilterDescriptor.class)) == null)) {
            this.mFilter = filterDescriptor;
        }
        if (this.mFilter == null) {
            this.mFilter = new FilterDescriptor();
        }
        this.mHideMasked = (CheckBox) findViewById(R.id.not_hidden);
        this.mOnlyBlacklisted = (CheckBox) findViewById(R.id.only_blacklisted);
        this.mOnlyCleartext = (CheckBox) findViewById(R.id.only_cleartext);
        this.mInterfaceGroup = (ChipGroup) findViewById(R.id.interfaces);
        this.mSizeSider = (Slider) findViewById(R.id.size_slider);
        findViewById(R.id.edit_mask).setOnClickListener(new AppsFragment$$ExternalSyntheticLambda2(1, this));
        this.mFirewallChips = new ArrayList<>(Arrays.asList(new Pair(ConnectionDescriptor.FilteringStatus.BLOCKED, (Chip) findViewById(R.id.status_blocked)), new Pair(ConnectionDescriptor.FilteringStatus.ALLOWED, (Chip) findViewById(R.id.status_allowed))));
        this.mStatusChips = new ArrayList<>(Arrays.asList(new Pair(ConnectionDescriptor.Status.STATUS_ACTIVE, (Chip) findViewById(R.id.status_active)), new Pair(ConnectionDescriptor.Status.STATUS_CLOSED, (Chip) findViewById(R.id.status_closed)), new Pair(ConnectionDescriptor.Status.STATUS_UNREACHABLE, (Chip) findViewById(R.id.status_unreachable)), new Pair(ConnectionDescriptor.Status.STATUS_ERROR, (Chip) findViewById(R.id.status_error))));
        this.mDecChips = new ArrayList<>(Arrays.asList(new Pair(ConnectionDescriptor.DecryptionStatus.DECRYPTED, (Chip) findViewById(R.id.dec_status_decrypted)), new Pair(ConnectionDescriptor.DecryptionStatus.NOT_DECRYPTABLE, (Chip) findViewById(R.id.dec_status_not_decryptable)), new Pair(ConnectionDescriptor.DecryptionStatus.ERROR, (Chip) findViewById(R.id.dec_status_error))));
        if (PCAPdroid.getInstance().isDecryptingPcap()) {
            findViewById(R.id.dec_status_not_decryptable).setVisibility(8);
            findViewById(R.id.dec_status_error).setVisibility(8);
        }
        if (CaptureService.isDecryptingTLS() || PCAPdroid.getInstance().isDecryptingPcap()) {
            findViewById(R.id.decryption_status_label).setVisibility(0);
            findViewById(R.id.decryption_status_group).setVisibility(0);
            this.mOnlyCleartext.setVisibility(8);
        }
        PlayBilling newInstance = Billing.newInstance(this);
        if (!Prefs.isMalwareDetectionEnabled(this, getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0))) {
            this.mOnlyBlacklisted.setVisibility(8);
        }
        if (newInstance.isFirewallVisible()) {
            findViewById(R.id.firewall_label).setVisibility(0);
            findViewById(R.id.firewall_group).setVisibility(0);
        }
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        if (connsRegister != null && connsRegister.hasSeenMultipleInterfaces()) {
            LayoutInflater layoutInflater = getLayoutInflater();
            for (String str : connsRegister.getSeenInterfaces()) {
                Chip chip = (Chip) layoutInflater.inflate(R.layout.choice_chip, (ViewGroup) this.mInterfaceGroup, false);
                chip.setText(str);
                this.mInterfaceGroup.addView(chip);
            }
            this.mInterfaceGroup.setVisibility(0);
            findViewById(R.id.interfaces_label).setVisibility(0);
        }
        if (connsRegister != null) {
            long max = Math.max(connsRegister.getMaxBytes() / 1024, this.mFilter.minSize / 1024);
            if (max >= 2) {
                this.mSizeSider.setValueTo((float) max);
                this.mSizeSider.setLabelFormatter(new BaseActivity$$ExternalSyntheticLambda0(21));
                this.mSizeSider.setVisibility(0);
                findViewById(R.id.size_slider_label).setVisibility(0);
            }
        }
        model2view();
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.edit_filter_menu, menu);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.reset_changes) {
            return false;
        }
        this.mFilter.clear();
        model2view();
        return true;
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        finishOk();
        return true;
    }
}
