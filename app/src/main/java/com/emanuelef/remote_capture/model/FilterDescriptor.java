package com.emanuelef.remote_capture.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.R;
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
        Chip chip = (Chip) layoutInflater.inflate(R.layout.active_filter_chip, (ViewGroup) chipGroup, false);
        chip.setId(i);
        chip.setText(str.toLowerCase());
        chipGroup.addView(chip);
    }

    public void clear(int i) {
        if (i == R.id.not_hidden) {
            this.showMasked = true;
        } else if (i == R.id.blacklisted) {
            this.onlyBlacklisted = false;
        } else if (i == R.id.only_cleartext) {
            this.onlyCleartext = false;
        } else if (i == R.id.status_ind) {
            this.status = ConnectionDescriptor.Status.STATUS_INVALID;
        } else if (i == R.id.decryption_status) {
            this.decStatus = ConnectionDescriptor.DecryptionStatus.INVALID;
        } else if (i == R.id.firewall) {
            this.filteringStatus = ConnectionDescriptor.FilteringStatus.INVALID;
        } else if (i == R.id.capture_interface) {
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
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean matches(com.emanuelef.remote_capture.model.ConnectionDescriptor r11) {
        /*
            r10 = this;
            boolean r0 = r10.showMasked
            r1 = 0
            if (r0 != 0) goto L13
            com.emanuelef.remote_capture.PCAPdroid r0 = com.emanuelef.remote_capture.PCAPdroid.getInstance()
            com.emanuelef.remote_capture.model.MatchList r0 = r0.getVisualizationMask()
            boolean r0 = r0.matches(r11)
            if (r0 != 0) goto L86
        L13:
            boolean r0 = r10.onlyBlacklisted
            if (r0 == 0) goto L1d
            boolean r0 = r11.isBlacklisted()
            if (r0 == 0) goto L86
        L1d:
            boolean r0 = r10.onlyCleartext
            if (r0 == 0) goto L27
            boolean r0 = r11.isCleartext()
            if (r0 == 0) goto L86
        L27:
            com.emanuelef.remote_capture.model.ConnectionDescriptor$Status r0 = r10.status
            com.emanuelef.remote_capture.model.ConnectionDescriptor$Status r2 = com.emanuelef.remote_capture.model.ConnectionDescriptor.Status.STATUS_INVALID
            if (r0 == r2) goto L39
            com.emanuelef.remote_capture.model.ConnectionDescriptor$Status r0 = r11.getStatus()
            com.emanuelef.remote_capture.model.ConnectionDescriptor$Status r2 = r10.status
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L86
        L39:
            com.emanuelef.remote_capture.model.ConnectionDescriptor$DecryptionStatus r0 = r10.decStatus
            com.emanuelef.remote_capture.model.ConnectionDescriptor$DecryptionStatus r2 = com.emanuelef.remote_capture.model.ConnectionDescriptor.DecryptionStatus.INVALID
            if (r0 == r2) goto L47
            com.emanuelef.remote_capture.model.ConnectionDescriptor$DecryptionStatus r0 = r11.getDecryptionStatus()
            com.emanuelef.remote_capture.model.ConnectionDescriptor$DecryptionStatus r2 = r10.decStatus
            if (r0 != r2) goto L86
        L47:
            com.emanuelef.remote_capture.model.ConnectionDescriptor$FilteringStatus r0 = r10.filteringStatus
            com.emanuelef.remote_capture.model.ConnectionDescriptor$FilteringStatus r2 = com.emanuelef.remote_capture.model.ConnectionDescriptor.FilteringStatus.INVALID
            r3 = 1
            if (r0 == r2) goto L59
            com.emanuelef.remote_capture.model.ConnectionDescriptor$FilteringStatus r2 = com.emanuelef.remote_capture.model.ConnectionDescriptor.FilteringStatus.BLOCKED
            if (r0 != r2) goto L54
            r0 = 1
            goto L55
        L54:
            r0 = 0
        L55:
            boolean r2 = r11.is_blocked
            if (r0 != r2) goto L86
        L59:
            java.lang.String r0 = r10.iface
            if (r0 == 0) goto L6b
            int r0 = r11.ifidx
            java.lang.String r0 = com.emanuelef.remote_capture.CaptureService.getInterfaceName(r0)
            java.lang.String r2 = r10.iface
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L86
        L6b:
            int r0 = r10.uid
            r2 = -2
            if (r0 == r2) goto L74
            int r2 = r11.uid
            if (r0 != r2) goto L86
        L74:
            long r4 = r10.minSize
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 == 0) goto L87
            long r6 = r11.sent_bytes
            long r8 = r11.rcvd_bytes
            long r6 = r6 + r8
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 < 0) goto L86
            goto L87
        L86:
            return r1
        L87:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.emanuelef.remote_capture.model.FilterDescriptor.matches(com.emanuelef.remote_capture.model.ConnectionDescriptor):boolean");
    }

    public void toChips(LayoutInflater layoutInflater, ChipGroup chipGroup) {
        int i;
        Context context = layoutInflater.getContext();
        if (!this.showMasked) {
            addChip(layoutInflater, chipGroup, R.id.not_hidden, context.getString(R.string.not_hidden_filter));
        }
        if (this.onlyBlacklisted) {
            addChip(layoutInflater, chipGroup, R.id.blacklisted, context.getString(R.string.malicious_connection_filter));
        }
        if (this.onlyCleartext) {
            addChip(layoutInflater, chipGroup, R.id.only_cleartext, context.getString(R.string.cleartext_connection));
        }
        int i2 = 0;
        if (this.status != ConnectionDescriptor.Status.STATUS_INVALID) {
            addChip(layoutInflater, chipGroup, R.id.status_ind, String.format(context.getString(R.string.status_filter), ConnectionDescriptor.getStatusLabel(this.status, context)));
        }
        if (this.decStatus != ConnectionDescriptor.DecryptionStatus.INVALID) {
            addChip(layoutInflater, chipGroup, R.id.decryption_status, String.format(context.getString(R.string.decryption_filter), ConnectionDescriptor.getDecryptionStatusLabel(this.decStatus, context)));
        }
        ConnectionDescriptor.FilteringStatus filteringStatus = this.filteringStatus;
        if (filteringStatus != ConnectionDescriptor.FilteringStatus.INVALID) {
            if (filteringStatus == ConnectionDescriptor.FilteringStatus.BLOCKED) {
                i = R.string.blocked_connection_filter;
            } else {
                i = R.string.allowed_connection_filter;
            }
            addChip(layoutInflater, chipGroup, R.id.firewall, context.getString(R.string.firewall_filter, context.getString(i)));
        }
        if (this.iface != null) {
            addChip(layoutInflater, chipGroup, R.id.capture_interface, String.format(context.getString(R.string.interface_filter), this.iface));
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
