package com.emanuelef.remote_capture.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.collection.ArraySet;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.p002os.BundleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.ConnectionsRegister;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.interfaces.ConnectionsListener;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.ConnectionDescriptor;
import com.emanuelef.remote_capture.model.FilterDescriptor;
import com.emanuelef.remote_capture.model.MatchList;
import com.emanuelef.remote_capture.model.Prefs;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes.dex */
public class ConnectionsAdapter extends RecyclerView.Adapter implements ConnectionsListener {
    private static final String TAG = "ConnectionsAdapter";
    private final AppsResolver mAppsResolver;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final int mSelectableBackground;
    private final int mSelectedColor;
    private ConnectionDescriptor mSelectedItem;
    private View.OnLongClickListener mSelectionLongClickListener;
    private final Drawable mUnknownIcon;
    private final ArraySet mSelectedItems = new ArraySet(0);
    public FilterDescriptor mFilter = new FilterDescriptor();
    private View.OnClickListener mListener = null;
    private ArrayList<ConnectionDescriptor> mFilteredConn = null;
    private int mUnfilteredItemsCount = 0;
    private int mNumRemovedItems = 0;
    private final SparseIntArray mIdToFilteredPos = new SparseIntArray();
    public final MatchList mMask = PCAPdroid.getInstance().getVisualizationMask();
    private String mSearch = null;

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView appName;
        ImageView blacklistedInd;
        ImageView blockedInd;
        ImageView decryptionInd;
        ImageView icon;
        ImageView jsInjectorInd;
        TextView l7proto;
        TextView lastSeen;
        final String mProtoAndPort;
        ImageView redirectedInd;
        TextView remote;
        TextView statusInd;
        TextView traffic;

        public ViewHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(C0130R.C0132id.icon);
            this.remote = (TextView) view.findViewById(C0130R.C0132id.remote);
            this.l7proto = (TextView) view.findViewById(C0130R.C0132id.l7proto);
            this.traffic = (TextView) view.findViewById(C0130R.C0132id.traffic);
            this.statusInd = (TextView) view.findViewById(C0130R.C0132id.status_ind);
            this.decryptionInd = (ImageView) view.findViewById(C0130R.C0132id.decryption_status);
            this.appName = (TextView) view.findViewById(C0130R.C0132id.app_name);
            this.lastSeen = (TextView) view.findViewById(C0130R.C0132id.last_seen);
            this.jsInjectorInd = (ImageView) view.findViewById(C0130R.C0132id.js_injector);
            this.blacklistedInd = (ImageView) view.findViewById(C0130R.C0132id.blacklisted);
            this.blockedInd = (ImageView) view.findViewById(C0130R.C0132id.blocked);
            this.redirectedInd = (ImageView) view.findViewById(C0130R.C0132id.redirected);
            this.mProtoAndPort = view.getContext().getString(C0130R.string.proto_and_port);
        }

        public void bindConn(Context context, ConnectionDescriptor connectionDescriptor, AppsResolver appsResolver, Drawable drawable) {
            String str;
            String str2;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            AppDescriptor appByUid = appsResolver.getAppByUid(connectionDescriptor.uid, 0);
            if (!(appByUid == null || appByUid.getIcon() == null)) {
                drawable = appByUid.getIcon();
            }
            this.icon.setImageDrawable(drawable);
            String str3 = connectionDescriptor.info;
            if (str3 == null || str3.length() <= 0) {
                this.remote.setText(connectionDescriptor.dst_ip);
            } else {
                this.remote.setText(connectionDescriptor.info);
            }
            int i6 = connectionDescriptor.dst_port;
            if (i6 != 0) {
                str = String.format(this.mProtoAndPort, connectionDescriptor.l7proto, Integer.valueOf(i6));
            } else {
                str = connectionDescriptor.l7proto;
            }
            if (connectionDescriptor.ipver == 6) {
                str = ViewModelProvider.Factory.CC.m596m(str, ", IPv6");
            }
            this.l7proto.setText(str);
            if (appByUid != null) {
                str2 = appByUid.getName();
            } else {
                str2 = Integer.toString(connectionDescriptor.uid);
            }
            this.appName.setText(str2);
            this.traffic.setText(Utils.formatBytes(connectionDescriptor.sent_bytes + connectionDescriptor.rcvd_bytes));
            this.lastSeen.setText(Utils.formatEpochShort(context, connectionDescriptor.last_seen / 1000));
            this.statusInd.setText(connectionDescriptor.getStatusLabel(context));
            int i7 = connectionDescriptor.status;
            if (i7 < 3) {
                i = C0130R.color.statusOpen;
            } else if (i7 == 3 || i7 == 7) {
                i = C0130R.color.statusClosed;
            } else if (i7 == 4 || i7 == 5 || i7 == 8) {
                i = C0130R.color.warning;
            } else {
                i = C0130R.color.statusError;
            }
            this.statusInd.setTextColor(BundleKt.getColor(context, i));
            ImageView imageView = this.jsInjectorInd;
            String str4 = connectionDescriptor.js_injected_scripts;
            if (str4 == null || str4.isEmpty()) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            ImageView imageView2 = this.blacklistedInd;
            if (connectionDescriptor.isBlacklisted()) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView2.setVisibility(i3);
            ImageView imageView3 = this.blockedInd;
            if (connectionDescriptor.is_blocked) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            imageView3.setVisibility(i4);
            ImageView imageView4 = this.redirectedInd;
            if (!connectionDescriptor.isPortMappingApplied() || connectionDescriptor.is_blocked) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            imageView4.setVisibility(i5);
            if (CaptureService.isDecryptingTLS() || PCAPdroid.getInstance().isDecryptingPcap()) {
                this.decryptionInd.setVisibility(0);
                Utils.setDecryptionIcon(this.decryptionInd, connectionDescriptor);
                return;
            }
            this.decryptionInd.setVisibility(8);
        }
    }

    public ConnectionsAdapter(Context context, AppsResolver appsResolver) {
        this.mContext = context;
        this.mAppsResolver = appsResolver;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mUnknownIcon = ContextCompat$Api21Impl.getDrawable(context, C0130R.C0131drawable.ic_image);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{16843820});
        this.mSelectedColor = obtainStyledAttributes.getColor(0, 1082163328);
        obtainStyledAttributes.recycle();
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843534, typedValue, true);
        this.mSelectableBackground = typedValue.resourceId;
        setHasStableIds(true);
    }

    private void fixFilteredPositions(int i) {
        while (i < this.mFilteredConn.size()) {
            this.mIdToFilteredPos.put(this.mFilteredConn.get(i).incr_id, this.mNumRemovedItems + i);
            i++;
        }
    }

    private int getFilteredItemPos(int i) {
        int i2 = this.mIdToFilteredPos.get(i, -1);
        if (i2 == -1) {
            return -1;
        }
        return i2 - this.mNumRemovedItems;
    }

    public /* synthetic */ boolean lambda$onCreateViewHolder$0(ViewHolder viewHolder, View view) {
        View.OnLongClickListener onLongClickListener = this.mSelectionLongClickListener;
        if (onLongClickListener != null && onLongClickListener.onLongClick(view)) {
            return true;
        }
        this.mSelectedItem = getItem(viewHolder.getAbsoluteAdapterPosition());
        return false;
    }

    private boolean matches(ConnectionDescriptor connectionDescriptor) {
        if (connectionDescriptor == null || !this.mFilter.matches(connectionDescriptor)) {
            return false;
        }
        String str = this.mSearch;
        if (str == null || connectionDescriptor.matches(this.mAppsResolver, str)) {
            return true;
        }
        return false;
    }

    private void removeFilteredItemAt(int i) {
        ConnectionDescriptor item = getItem(i);
        if (item != null) {
            this.mFilteredConn.remove(i);
            this.mIdToFilteredPos.delete(item.incr_id);
            notifyItemRemoved(i);
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void clearSelection() {
        this.mSelectedItems.clear();
        notifyDataSetChanged();
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsAdded(int i, ConnectionDescriptor[] connectionDescriptorArr) {
        this.mUnfilteredItemsCount += connectionDescriptorArr.length;
        ArrayList<ConnectionDescriptor> arrayList = this.mFilteredConn;
        if (arrayList == null) {
            notifyItemRangeInserted(i, connectionDescriptorArr.length);
            return;
        }
        int size = arrayList.size() + this.mNumRemovedItems;
        int i2 = 0;
        for (ConnectionDescriptor connectionDescriptor : connectionDescriptorArr) {
            if (matches(connectionDescriptor)) {
                this.mIdToFilteredPos.put(connectionDescriptor.incr_id, size);
                this.mFilteredConn.add(connectionDescriptor);
                i2++;
                size++;
            }
        }
        if (i2 > 0) {
            notifyItemRangeInserted(this.mFilteredConn.size() - i2, i2);
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsChanges(int i) {
        this.mUnfilteredItemsCount = i;
        refreshFilteredConnections();
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsRemoved(int i, ConnectionDescriptor[] connectionDescriptorArr) {
        this.mUnfilteredItemsCount -= connectionDescriptorArr.length;
        if (this.mFilteredConn == null) {
            notifyItemRangeRemoved(i, connectionDescriptorArr.length);
            return;
        }
        for (ConnectionDescriptor connectionDescriptor : connectionDescriptorArr) {
            if (connectionDescriptor != null) {
                this.mSelectedItems.remove(Integer.valueOf(connectionDescriptor.incr_id));
                if (getFilteredItemPos(connectionDescriptor.incr_id) != -1) {
                    removeFilteredItemAt(0);
                    this.mNumRemovedItems++;
                }
            }
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.ConnectionsListener
    public void connectionsUpdated(int[] iArr) {
        int filteredItemPos;
        int i = 0;
        if (this.mFilteredConn == null) {
            int length = iArr.length;
            while (i < length) {
                notifyItemChanged(iArr[i]);
                i++;
            }
            return;
        }
        ConnectionsRegister requireConnsRegister = CaptureService.requireConnsRegister();
        Arrays.sort(iArr);
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = -1;
        while (i < length2) {
            ConnectionDescriptor conn = requireConnsRegister.getConn(iArr[i]);
            if (!(conn == null || (filteredItemPos = getFilteredItemPos(conn.incr_id)) == -1)) {
                int i4 = filteredItemPos - i2;
                if (matches(conn)) {
                    StringBuilder m = ViewModelProvider.Factory.CC.m598m("Changed item ", i4, ", dataset size: ");
                    m.append(getItemCount());
                    Log.m587d(TAG, m.toString());
                    notifyItemChanged(i4);
                } else {
                    StringBuilder m2 = ViewModelProvider.Factory.CC.m598m("Unmatch item ", i4, ": ");
                    m2.append(conn.toString());
                    Log.m587d(TAG, m2.toString());
                    removeFilteredItemAt(i4);
                    i2++;
                    if (i3 == -1) {
                        i3 = i4;
                    }
                }
            }
            i++;
        }
        if (i3 != -1) {
            fixFilteredPositions(i3);
        }
    }

    public String dumpConnectionsCsv(boolean z) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        AppsResolver appsResolver = new AppsResolver(this.mContext);
        Context context = this.mContext;
        boolean isMalwareDetectionEnabled = Prefs.isMalwareDetectionEnabled(context, PreferenceManager.getDefaultSharedPreferences(context));
        sb.append(this.mContext.getString(C0130R.string.connections_csv_fields));
        if (isMalwareDetectionEnabled) {
            sb.append(",Malicious");
        }
        sb.append("\n");
        for (int i = 0; i < getItemCount(); i++) {
            ConnectionDescriptor item = getItem(i);
            if (item != null && (!z || this.mSelectedItems.contains(Integer.valueOf(item.incr_id)))) {
                AppDescriptor appByUid = appsResolver.getAppByUid(item.uid, 0);
                sb.append(item.ipproto);
                sb.append(",");
                sb.append(item.src_ip);
                sb.append(",");
                sb.append(item.src_port);
                sb.append(",");
                sb.append(item.dst_ip);
                sb.append(",");
                sb.append(item.dst_port);
                sb.append(",");
                sb.append(item.uid);
                sb.append(",");
                String str3 = "";
                if (appByUid != null) {
                    str = appByUid.getName();
                } else {
                    str = str3;
                }
                sb.append(str);
                sb.append(",");
                if (appByUid != null) {
                    str2 = appByUid.getPackageName();
                } else {
                    str2 = str3;
                }
                sb.append(str2);
                sb.append(",");
                sb.append(item.l7proto);
                sb.append(",");
                sb.append(item.getStatusLabel(this.mContext));
                sb.append(",");
                String str4 = item.info;
                if (str4 != null) {
                    str3 = str4;
                }
                sb.append(str3);
                sb.append(",");
                sb.append(item.sent_bytes);
                sb.append(",");
                sb.append(item.rcvd_bytes);
                sb.append(",");
                sb.append(item.sent_pkts);
                sb.append(",");
                sb.append(item.rcvd_pkts);
                sb.append(",");
                sb.append(Utils.formatMillisIso8601(this.mContext, item.first_seen));
                sb.append(",");
                sb.append(Utils.formatMillisIso8601(this.mContext, item.last_seen));
                if (isMalwareDetectionEnabled) {
                    sb.append(",");
                    if (item.isBlacklisted()) {
                        sb.append("yes");
                    }
                }
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public ArrayList<Integer> getFilteredConnectionIds() {
        if (this.mFilteredConn == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>(this.mFilteredConn.size());
        ArrayList<ConnectionDescriptor> arrayList2 = this.mFilteredConn;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            ConnectionDescriptor connectionDescriptor = arrayList2.get(i);
            i++;
            arrayList.add(Integer.valueOf(connectionDescriptor.incr_id));
        }
        return arrayList;
    }

    public ConnectionDescriptor getItem(int i) {
        ArrayList<ConnectionDescriptor> arrayList = this.mFilteredConn;
        if (arrayList == null) {
            ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
            if (i >= 0 && i < this.mUnfilteredItemsCount && connsRegister != null) {
                return connsRegister.getConn(i);
            }
            Log.m581w(TAG, "getItem: bad position: " + i);
            return null;
        } else if (i >= 0 && i < arrayList.size()) {
            return this.mFilteredConn.get(i);
        } else {
            Log.m581w(TAG, "getItem(filtered): bad position: " + i);
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<ConnectionDescriptor> arrayList = this.mFilteredConn;
        if (arrayList != null) {
            return arrayList.size();
        }
        return this.mUnfilteredItemsCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        ConnectionDescriptor item = getItem(i);
        if (item != null) {
            i2 = item.incr_id;
        } else {
            i2 = -1;
        }
        return i2;
    }

    public int getSelectedCount() {
        return this.mSelectedItems._size;
    }

    public ConnectionDescriptor getSelectedItem() {
        return this.mSelectedItem;
    }

    public boolean hasFilter() {
        if (this.mSearch != null || this.mFilter.isSet()) {
            return true;
        }
        return false;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void refreshFilteredConnections() {
        ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
        if (connsRegister != null) {
            Log.m587d(TAG, "refreshFilteredConn (" + this.mUnfilteredItemsCount + ") unfiltered");
            this.mIdToFilteredPos.clear();
            this.mNumRemovedItems = 0;
            if (hasFilter()) {
                this.mFilteredConn = new ArrayList<>();
                synchronized (connsRegister) {
                    int i = 0;
                    for (int i2 = 0; i2 < this.mUnfilteredItemsCount; i2++) {
                        try {
                            ConnectionDescriptor conn = connsRegister.getConn(i2);
                            if (matches(conn)) {
                                this.mFilteredConn.add(conn);
                                this.mIdToFilteredPos.put(conn.incr_id, i);
                                i++;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                Log.m587d(TAG, "refreshFilteredConn: " + this.mFilteredConn.size() + " connections matched");
            } else {
                this.mFilteredConn = null;
            }
            notifyDataSetChanged();
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void selectAll() {
        for (int i = 0; i < getItemCount(); i++) {
            ConnectionDescriptor item = getItem(i);
            if (item != null) {
                this.mSelectedItems.add(Integer.valueOf(item.incr_id));
            }
        }
        notifyDataSetChanged();
    }

    public void selectItem(int i) {
        ConnectionDescriptor item = getItem(i);
        if (item != null) {
            this.mSelectedItems.add(Integer.valueOf(item.incr_id));
            notifyItemChanged(i);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public void setSearch(String str) {
        this.mSearch = str;
        refreshFilteredConnections();
    }

    public void setSelectionLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mSelectionLongClickListener = onLongClickListener;
    }

    public void toggleSelection(int i) {
        ConnectionDescriptor item = getItem(i);
        if (item != null) {
            if (!this.mSelectedItems.remove(Integer.valueOf(item.incr_id))) {
                this.mSelectedItems.add(Integer.valueOf(item.incr_id));
            }
            notifyItemChanged(i);
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ConnectionDescriptor item = getItem(i);
        if (item == null) {
            Log.m581w(TAG, "bad position: " + i);
            return;
        }
        viewHolder.bindConn(this.mContext, item, this.mAppsResolver, this.mUnknownIcon);
        if (this.mSelectedItems.contains(Integer.valueOf(item.incr_id))) {
            viewHolder.itemView.setBackgroundColor(this.mSelectedColor);
        } else {
            viewHolder.itemView.setBackgroundResource(this.mSelectableBackground);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(C0130R.layout.connection_item, viewGroup, false);
        inflate.setLongClickable(true);
        View.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            inflate.setOnClickListener(onClickListener);
        }
        ViewHolder viewHolder = new ViewHolder(inflate);
        inflate.setOnLongClickListener(new AppsStatsAdapter$$ExternalSyntheticLambda1(this, viewHolder, 1));
        return viewHolder;
    }
}
