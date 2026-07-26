package com.emanuelef.remote_capture.model;

import android.content.Context;
import androidx.core.os.BundleKt;
import com.emanuelef.remote_capture.R;
/* loaded from: classes.dex */
public class BlacklistDescriptor {
    public final String fname;
    public final String label;
    public final Type type;
    public final String url;
    long mLastUpdate = 0;
    boolean mUpToDate = false;
    boolean mUpdating = false;
    public boolean loaded = false;
    public int num_rules = 0;

    /* loaded from: classes.dex */
    public enum Status {
        NOT_LOADED,
        OUTDATED,
        UPDATING,
        UP_TO_DATE
    }

    /* loaded from: classes.dex */
    public enum Type {
        IP_BLACKLIST,
        DOMAIN_BLACKLIST
    }

    public BlacklistDescriptor(String str, Type type, String str2, String str3) {
        this.label = str;
        this.type = type;
        this.fname = str2;
        this.url = str3;
    }

    public long getLastUpdate() {
        return this.mLastUpdate;
    }

    public Status getStatus() {
        if (this.mUpdating) {
            return Status.UPDATING;
        }
        if (!this.loaded) {
            return Status.NOT_LOADED;
        }
        if (!this.mUpToDate) {
            return Status.OUTDATED;
        }
        return Status.UP_TO_DATE;
    }

    public int getStatusColor(Context context) {
        int i;
        int ordinal = getStatus().ordinal();
        if (ordinal == 0) {
            i = R.color.danger;
        } else if (ordinal == 1) {
            i = R.color.warning;
        } else if (ordinal == 2) {
            i = R.color.in_progress;
        } else if (ordinal != 3) {
            i = -1;
        } else {
            i = R.color.ok;
        }
        return BundleKt.getColor(context, i);
    }

    public String getStatusLabel(Context context) {
        int i;
        int ordinal = getStatus().ordinal();
        if (ordinal == 0) {
            i = R.string.status_not_loaded;
        } else if (ordinal == 1) {
            i = R.string.status_outdated;
        } else if (ordinal == 2) {
            i = R.string.status_updating;
        } else if (ordinal != 3) {
            i = -1;
        } else {
            i = R.string.status_uptodate;
        }
        return context.getString(i);
    }

    public String getTypeLabel(Context context) {
        int i;
        if (this.type == Type.IP_BLACKLIST) {
            i = R.string.blacklist_type_ip;
        } else {
            i = R.string.blacklist_type_domain;
        }
        return context.getString(i);
    }

    public boolean isUpToDate() {
        return this.mUpToDate;
    }

    public void setOutdated() {
        this.mUpdating = false;
        this.mUpToDate = false;
    }

    public void setUpdated(long j) {
        boolean z = false;
        this.mUpdating = false;
        this.mLastUpdate = j;
        if (j != 0) {
            z = true;
        }
        this.mUpToDate = z;
    }

    public void setUpdating() {
        this.mUpdating = true;
        this.mUpToDate = false;
    }
}
