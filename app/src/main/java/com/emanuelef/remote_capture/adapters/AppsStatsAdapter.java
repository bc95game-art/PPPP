package com.emanuelef.remote_capture.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.AppStats;
import com.emanuelef.remote_capture.model.Blocklist;
import com.emanuelef.remote_capture.model.MatchList;
import com.emanuelef.remote_capture.model.Prefs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class AppsStatsAdapter extends RecyclerView.Adapter {
    private static final String TAG = "AppsStatsAdapter";
    private final AppsResolver mApps;
    private final Context mContext;
    private final boolean mFirewallAvailable;
    private final LayoutInflater mLayoutInflater;
    private final SharedPreferences mPrefs;
    private AppStats mSelectedItem;
    private final Drawable mUnknownIcon;
    private final Blocklist mBlocklist = PCAPdroid.getInstance().getBlocklist();
    private final MatchList mWhitelist = PCAPdroid.getInstance().getFirewallWhitelist();
    private View.OnClickListener mListener = null;
    private List<AppStats> mStats = new ArrayList();
    private SortField mSortField = SortField.NAME;

    /* loaded from: classes.dex */
    public enum SortField {
        NAME,
        TOTAL_BYTES,
        BYTES_SENT,
        BYTES_RCVD
    }

    /* loaded from: classes.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView blockedFlag;
        ImageView icon;
        TextView info;
        TextView sent_rcvd;
        ImageView tempUnblocked;
        TextView traffic;
        ImageView whitelistedFlag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            AppsStatsAdapter.this = r1;
            this.icon = (ImageView) view.findViewById(R.id.icon);
            this.blockedFlag = (ImageView) view.findViewById(R.id.blocked);
            this.whitelistedFlag = (ImageView) view.findViewById(R.id.whitelisted);
            this.tempUnblocked = (ImageView) view.findViewById(R.id.temp_unblocked);
            this.info = (TextView) view.findViewById(R.id.app_info);
            this.sent_rcvd = (TextView) view.findViewById(R.id.sent_rcvd);
            this.traffic = (TextView) view.findViewById(R.id.traffic);
        }

        public void bindAppStats(AppStats appStats) {
            AppDescriptor appDescriptor;
            Drawable drawable;
            String str;
            boolean z;
            int i;
            int i2;
            int i3 = 0;
            if (AppsStatsAdapter.this.mApps != null) {
                appDescriptor = AppsStatsAdapter.this.mApps.getAppByUid(appStats.getUid(), 0);
            } else {
                appDescriptor = null;
            }
            if (appDescriptor == null || appDescriptor.getIcon() == null) {
                drawable = AppsStatsAdapter.this.mUnknownIcon;
            } else {
                drawable = appDescriptor.getIcon();
            }
            this.icon.setImageDrawable(drawable);
            if (appDescriptor != null) {
                str = appDescriptor.getName();
            } else {
                str = Integer.toString(appStats.getUid());
            }
            if (appStats.numConnections > 1) {
                str = str + " (" + Utils.formatNumber(AppsStatsAdapter.this.mContext, appStats.numConnections) + ")";
            }
            this.info.setText(str);
            boolean isExemptedApp = AppsStatsAdapter.this.mBlocklist.isExemptedApp(appStats.getUid());
            boolean matchesApp = AppsStatsAdapter.this.mBlocklist.matchesApp(appStats.getUid());
            boolean matchesApp2 = AppsStatsAdapter.this.mWhitelist.matchesApp(appStats.getUid());
            if (!Prefs.isFirewallEnabled(AppsStatsAdapter.this.mContext, AppsStatsAdapter.this.mPrefs) || !Prefs.isFirewallWhitelistMode(AppsStatsAdapter.this.mPrefs)) {
                z = false;
            } else {
                z = true;
            }
            this.sent_rcvd.setText(AppsStatsAdapter.this.mContext.getString(R.string.rcvd_and_sent, Utils.formatBytes(appStats.rcvdBytes), Utils.formatBytes(appStats.sentBytes)));
            this.traffic.setText(Utils.formatBytes(appStats.sentBytes + appStats.rcvdBytes));
            ImageView imageView = this.blockedFlag;
            if (matchesApp) {
                i = 0;
            } else {
                i = 8;
            }
            imageView.setVisibility(i);
            ImageView imageView2 = this.whitelistedFlag;
            if (!z || !matchesApp2) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView2.setVisibility(i2);
            ImageView imageView3 = this.tempUnblocked;
            if (!isExemptedApp) {
                i3 = 8;
            }
            imageView3.setVisibility(i3);
        }
    }

    public AppsStatsAdapter(Context context) {
        this.mContext = context;
        this.mApps = new AppsResolver(context);
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mUnknownIcon = ContextCompat$Api21Impl.getDrawable(context, R.drawable.ic_image);
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        this.mFirewallAvailable = Billing.newInstance(context).isFirewallVisible();
        setHasStableIds(true);
    }

    public /* synthetic */ boolean lambda$onCreateViewHolder$0(ViewHolder viewHolder, View view) {
        this.mSelectedItem = getItem(viewHolder.getAbsoluteAdapterPosition());
        return false;
    }

    public /* synthetic */ int lambda$setStats$1(AppStats appStats, AppStats appStats2) {
        int compare;
        AppDescriptor appByUid = this.mApps.getAppByUid(appStats.getUid(), 0);
        AppDescriptor appByUid2 = this.mApps.getAppByUid(appStats2.getUid(), 0);
        if (appByUid == null && appByUid2 == null) {
            return 0;
        }
        if (appByUid == null) {
            return -1;
        }
        if (appByUid2 == null) {
            return 1;
        }
        int ordinal = this.mSortField.ordinal();
        if (ordinal == 1) {
            compare = Long.compare(appStats.rcvdBytes + appStats.sentBytes, appStats2.rcvdBytes + appStats2.sentBytes);
        } else if (ordinal == 2) {
            compare = Long.compare(appStats.sentBytes, appStats2.sentBytes);
        } else if (ordinal != 3) {
            return appByUid.compareTo(appByUid2);
        } else {
            compare = Long.compare(appStats.rcvdBytes, appStats2.rcvdBytes);
        }
        return -compare;
    }

    public AppStats getItem(int i) {
        return this.mStats.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mStats.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        AppStats item = getItem(i);
        if (item != null) {
            i2 = item.getUid();
        } else {
            i2 = -1;
        }
        return i2;
    }

    public String getItemPackage(int i) {
        AppDescriptor appByUid;
        AppStats item = getItem(i);
        if (item == null || (appByUid = this.mApps.getAppByUid(item.getUid(), 0)) == null) {
            return null;
        }
        return appByUid.getPackageName();
    }

    public AppStats getSelectedItem() {
        return this.mSelectedItem;
    }

    public SortField getSortField() {
        return this.mSortField;
    }

    public void notifyItemChanged(AppStats appStats) {
        int indexOf = this.mStats.indexOf(appStats);
        if (indexOf >= 0) {
            notifyItemChanged(indexOf);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setSortField(SortField sortField) {
        this.mSortField = sortField;
        setStats(this.mStats);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void setStats(List<AppStats> list) {
        Collections.sort(list, new AppsStatsAdapter$$ExternalSyntheticLambda0(0, this));
        this.mStats = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        AppStats item = getItem(i);
        if (item != null) {
            viewHolder.bindAppStats(item);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(R.layout.app_item, viewGroup, false);
        View.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            inflate.setOnClickListener(onClickListener);
        }
        ViewHolder viewHolder = new ViewHolder(inflate);
        if (this.mFirewallAvailable) {
            inflate.setLongClickable(true);
            inflate.setOnLongClickListener(new AppsStatsAdapter$$ExternalSyntheticLambda1(this, viewHolder, 0));
        }
        return viewHolder;
    }
}
