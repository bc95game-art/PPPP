package com.emanuelef.remote_capture.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.io.Serializable;
/* loaded from: classes.dex */
public class FilterDescriptor implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public ConnectionDescriptor.DecryptionStatus decStatus;
    public ConnectionDescriptor.FilteringStatus filteringStatus;
    public String iface;
    public boolean onlyBlacklisted;
    public boolean onlyCleartext;
    public boolean showMasked;
    public ConnectionDescriptor.Status status;
    public int uid = -2;
    public long minSize = 0;

    public FilterDescriptor() {
        clear();
    }

    private void addChip(LayoutInflater layoutInflater, ChipGroup chipGroup, int i, String str) {
        Chip chip = (Chip) layoutInflater.inflate(C0130R.layout.active_filter_chip, (ViewGroup) chipGroup, false);
        chip.setId(i);
        chip.setText(str.toLowerCase());
        chipGroup.addView(chip);
    }

    public void clear(int i) {
        if (i == C0130R.C0132id.not_hidden) {
            this.showMasked = true;
        } else if (i == C0130R.C0132id.blacklisted) {
            this.onlyBlacklisted = false;
        } else if (i == C0130R.C0132id.only_cleartext) {
            this.onlyCleartext = false;
        } else if (i == C0130R.C0132id.status_ind) {
            this.status = ConnectionDescriptor.Status.STATUS_INVALID;
        } else if (i == C0130R.C0132id.decryption_status) {
            this.decStatus = ConnectionDescriptor.DecryptionStatus.INVALID;
        } else if (i == C0130R.C0132id.firewall) {
            this.filteringStatus = ConnectionDescriptor.FilteringStatus.INVALID;
        } else if (i == C0130R.C0132id.capture_interface) {
            this.iface = null;
        }
    }

    public boolean isSet() {
        if (this.status != ConnectionDescriptor.Status.STATUS_INVALID || this.decStatus != ConnectionDescriptor.DecryptionStatus.INVALID || this.filteringStatus != ConnectionDescriptor.FilteringStatus.INVALID || this.iface != null || this.onlyBlacklisted || this.onlyCleartext || this.uid != -2 || this.minSize > 0) {
            return true;
        }
        if (this.showMasked || PCAPdroid.getInstance().getVisualizationMask().isEmpty()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
        if (r0 == r11.is_blocked) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean matches(ConnectionDescriptor connectionDescriptor) {
        int i;
        boolean z;
        if ((this.showMasked || !PCAPdroid.getInstance().getVisualizationMask().matches(connectionDescriptor)) && ((!this.onlyBlacklisted || connectionDescriptor.isBlacklisted()) && ((!this.onlyCleartext || connectionDescriptor.isCleartext()) && ((this.status == ConnectionDescriptor.Status.STATUS_INVALID || connectionDescriptor.getStatus().equals(this.status)) && (this.decStatus == ConnectionDescriptor.DecryptionStatus.INVALID || connectionDescriptor.getDecryptionStatus() == this.decStatus))))) {
            ConnectionDescriptor.FilteringStatus filteringStatus = this.filteringStatus;
            if (filteringStatus != ConnectionDescriptor.FilteringStatus.INVALID) {
                if (filteringStatus == ConnectionDescriptor.FilteringStatus.BLOCKED) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if ((this.iface == null || CaptureService.getInterfaceName(connectionDescriptor.ifidx).equals(this.iface)) && ((i = this.uid) == -2 || i == connectionDescriptor.uid)) {
                long j = this.minSize;
                if (j == 0 || connectionDescriptor.sent_bytes + connectionDescriptor.rcvd_bytes >= j) {
                    return true;
                }
            }
        }
        return false;
    }

    public void toChips(LayoutInflater layoutInflater, ChipGroup chipGroup) {
        int i;
        Context context = layoutInflater.getContext();
        if (!this.showMasked) {
            addChip(layoutInflater, chipGroup, C0130R.C0132id.not_hidden, context.getString(C0130R.string.not_hidden_filter));
        }
        if (this.onlyBlacklisted) {
            addChip(layoutInflater, chipGroup, C0130R.C0132id.blacklisted, context.getString(C0130R.string.malicious_connection_filter));
        }
        if (this.onlyCleartext) {
            addChip(layoutInflater, chipGroup, C0130R.C0132id.only_cleartext, context.getString(C0130R.string.cleartext_connection));
        }
        int i2 = 0;
        if (this.status != ConnectionDescriptor.Status.STATUS_INVALID) {
            addChip(layoutInflater, chipGroup, C0130R.C0132id.status_ind, String.format(context.getString(C0130R.string.status_filter), ConnectionDescriptor.getStatusLabel(this.status, context)));
        }
        if (this.decStatus != ConnectionDescriptor.DecryptionStatus.INVALID) {
            addChip(layoutInflater, chipGroup, C0130R.C0132id.decryption_status, String.format(context.getString(C0130R.string.decryption_filter), ConnectionDescriptor.getDecryptionStatusLabel(this.decStatus, context)));
        }
        ConnectionDescriptor.FilteringStatus filteringStatus = this.filteringStatus;
        if (filteringStatus != ConnectionDescriptor.FilteringStatus.INVALID) {
            if (filteringStatus == ConnectionDescriptor.FilteringStatus.BLOCKED) {
                i = C0130R.string.blocked_connection_filter;
            } else {
                i = C0130R.string.allowed_connection_filter;
            }
            addChip(layoutInflater, chipGroup, C0130R.C0132id.firewall, context.getString(C0130R.string.firewall_filter, context.getString(i)));
        }
        if (this.iface != null) {
            addChip(layoutInflater, chipGroup, C0130R.C0132id.capture_interface, String.format(context.getString(C0130R.string.interface_filter), this.iface));
        }
        if (chipGroup.getChildCount() <= 0) {
            i2 = 8;
        }
        chipGroup.setVisibility(i2);
    }

    public void clear() {
        this.showMasked = true;
        this.onlyBlacklisted = false;
        this.onlyCleartext = false;
        this.status = ConnectionDescriptor.Status.STATUS_INVALID;
        this.decStatus = ConnectionDescriptor.DecryptionStatus.INVALID;
        this.filteringStatus = ConnectionDescriptor.FilteringStatus.INVALID;
        this.iface = null;
        this.minSize = 0L;
    }
}
