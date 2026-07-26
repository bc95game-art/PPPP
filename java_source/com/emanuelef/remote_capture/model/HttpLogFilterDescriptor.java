package com.emanuelef.remote_capture.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.HttpLog;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import java.io.Serializable;
/* loaded from: classes.dex */
public class HttpLogFilterDescriptor implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String method = null;
    public String contentType = null;
    public Integer httpStatus = null;
    public long minPayloadSize = 0;
    public Boolean decryptionError = null;

    public HttpLogFilterDescriptor() {
        clear();
    }

    private void addChip(LayoutInflater layoutInflater, ChipGroup chipGroup, int i, String str) {
        Chip chip = (Chip) layoutInflater.inflate(C0130R.layout.active_filter_chip, (ViewGroup) chipGroup, false);
        chip.setId(i);
        chip.setText(str.toLowerCase());
        chipGroup.addView(chip);
    }

    public void clear(int i) {
        if (i == C0130R.C0132id.http_method_filter) {
            this.method = null;
        } else if (i == C0130R.C0132id.http_content_type_filter) {
            this.contentType = null;
        } else if (i == C0130R.C0132id.http_status_filter) {
            this.httpStatus = null;
        } else if (i == C0130R.C0132id.decryption_status) {
            this.decryptionError = null;
        }
    }

    public boolean isSet() {
        if (this.method == null && this.contentType == null && this.httpStatus == null && this.minPayloadSize <= 0 && this.decryptionError == null) {
            return false;
        }
        return true;
    }

    public boolean matches(HttpLog.HttpRequest httpRequest) {
        HttpLog.HttpReply httpReply;
        HttpLog.HttpReply httpReply2;
        String str;
        String str2 = this.method;
        if (str2 != null && !httpRequest.method.equalsIgnoreCase(str2)) {
            return false;
        }
        String str3 = this.contentType;
        if (str3 != null && ((httpReply2 = httpRequest.reply) == null || (str = httpReply2.contentType) == null || !str.equals(str3))) {
            return false;
        }
        Integer num = this.httpStatus;
        if (num != null && ((httpReply = httpRequest.reply) == null || httpReply.responseCode != num.intValue())) {
            return false;
        }
        long j = this.minPayloadSize;
        if (j > 0) {
            HttpLog.HttpReply httpReply3 = httpRequest.reply;
            int i = httpRequest.bodyLength;
            if (httpReply3 != null) {
                i += httpReply3.bodyLength;
            }
            if (i < j) {
                return false;
            }
        }
        if (this.decryptionError == null) {
            return true;
        }
        boolean isEmpty = httpRequest.decryptionError.isEmpty();
        if (this.decryptionError.booleanValue() && isEmpty) {
            return false;
        }
        if (this.decryptionError.booleanValue() || isEmpty) {
            return true;
        }
        return false;
    }

    public void toChips(LayoutInflater layoutInflater, ChipGroup chipGroup) {
        int i;
        Context context = layoutInflater.getContext();
        int i2 = 0;
        if (this.method != null) {
            addChip(layoutInflater, chipGroup, C0130R.C0132id.http_method_filter, String.format(context.getString(C0130R.string.method_filter), this.method));
        }
        if (this.contentType != null) {
            addChip(layoutInflater, chipGroup, C0130R.C0132id.http_content_type_filter, String.format(context.getString(C0130R.string.content_type_filter), this.contentType));
        }
        if (this.httpStatus != null) {
            addChip(layoutInflater, chipGroup, C0130R.C0132id.http_status_filter, String.format(context.getString(C0130R.string.status_filter), this.httpStatus.toString()));
        }
        Boolean bool = this.decryptionError;
        if (bool != null) {
            if (bool.booleanValue()) {
                i = C0130R.string.decryption_error;
            } else {
                i = C0130R.string.ok;
            }
            addChip(layoutInflater, chipGroup, C0130R.C0132id.decryption_status, String.format(context.getString(C0130R.string.decryption_filter), context.getString(i)));
        }
        if (chipGroup.getChildCount() <= 0) {
            i2 = 8;
        }
        chipGroup.setVisibility(i2);
    }

    public void clear() {
        this.method = null;
        this.contentType = null;
        this.httpStatus = null;
        this.minPayloadSize = 0L;
        this.decryptionError = null;
    }
}
