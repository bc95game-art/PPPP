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
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.HttpLog;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.HttpLogFilterDescriptor;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class HttpLogAdapter extends RecyclerView.Adapter implements HttpLog.Listener {
    private static final String TAG = "HttpLogAdapter";
    private final AppsResolver mAppsResolver;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private View.OnLongClickListener mLongClickListener;
    private final int mSelectableBackground;
    private final int mSelectedColor;
    private HttpLog.HttpRequest mSelectedItem;
    private final Drawable mUnknownIcon;
    private final ArraySet mSelectedItems = new ArraySet(0);
    private final SparseIntArray mIdToFilteredPos = new SparseIntArray();
    private View.OnClickListener mListener = null;
    private ArrayList<HttpLog.HttpRequest> mFilteredReqs = null;
    private String mSearch = null;
    public HttpLogFilterDescriptor mFilter = new HttpLogFilterDescriptor();

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView appName;
        TextView contentType;
        TextView httpStatus;
        ImageView icon;
        TextView methodAndPath;
        TextView payloadSize;
        TextView protoAndHost;
        TextView reqTime;

        public ViewHolder(View view) {
            super(view);
            this.icon = (ImageView) view.findViewById(C0130R.C0132id.icon);
            this.appName = (TextView) view.findViewById(C0130R.C0132id.app_name);
            this.methodAndPath = (TextView) view.findViewById(C0130R.C0132id.method_and_path);
            this.protoAndHost = (TextView) view.findViewById(C0130R.C0132id.proto_and_host);
            this.contentType = (TextView) view.findViewById(C0130R.C0132id.content_type);
            this.reqTime = (TextView) view.findViewById(C0130R.C0132id.req_time);
            this.httpStatus = (TextView) view.findViewById(C0130R.C0132id.http_status);
            this.payloadSize = (TextView) view.findViewById(C0130R.C0132id.payload_size);
        }

        public void bindItem(HttpLog.HttpRequest httpRequest, Context context, AppsResolver appsResolver, Drawable drawable) {
            String str;
            String str2;
            String str3;
            int i;
            AppDescriptor appByUid = appsResolver.getAppByUid(httpRequest.conn.uid, 0);
            if (!(appByUid == null || appByUid.getIcon() == null)) {
                drawable = appByUid.getIcon();
            }
            this.icon.setImageDrawable(drawable);
            if (appByUid != null) {
                str = appByUid.getName();
            } else {
                str = Integer.toString(httpRequest.conn.uid);
            }
            this.appName.setText(str);
            TextView textView = this.methodAndPath;
            String str4 = httpRequest.method;
            String str5 = httpRequest.path;
            textView.setText(str4 + " " + str5);
            this.protoAndHost.setText(httpRequest.getProtoAndHost());
            TextView textView2 = this.contentType;
            HttpLog.HttpReply httpReply = httpRequest.reply;
            if (httpReply != null) {
                str2 = httpReply.contentType;
            } else {
                str2 = "";
            }
            textView2.setText(str2);
            this.reqTime.setText(Utils.formatEpochShort(context, httpRequest.timestamp / 1000));
            TextView textView3 = this.httpStatus;
            if (httpRequest.decryptionError.isEmpty()) {
                str3 = HttpLogAdapter.getResponseCodeText(context, httpRequest);
            } else {
                str3 = context.getString(C0130R.string.decryption_error);
            }
            textView3.setText(str3);
            HttpLog.HttpReply httpReply2 = httpRequest.reply;
            int i2 = httpRequest.bodyLength;
            if (httpReply2 != null) {
                i2 += httpReply2.bodyLength;
            }
            this.payloadSize.setText(Utils.formatBytes(i2));
            TextView textView4 = this.httpStatus;
            if (httpRequest.decryptionError.isEmpty()) {
                i = HttpLogAdapter.getResponseCodeColor(httpRequest);
            } else {
                i = C0130R.color.statusError;
            }
            textView4.setTextColor(BundleKt.getColor(context, i));
        }
    }

    public HttpLogAdapter(Context context, AppsResolver appsResolver) {
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
        refreshFilteredItems();
    }

    public static int getResponseCodeColor(HttpLog.HttpRequest httpRequest) {
        HttpLog.HttpReply httpReply = httpRequest.reply;
        if (httpReply != null) {
            int i = httpReply.responseCode;
            if (i >= 200 && i <= 299) {
                return C0130R.color.statusOpen;
            }
            if (i >= 300 && i <= 399) {
                return C0130R.color.lightGray;
            }
            if (i < 400 || i > 599) {
                return C0130R.color.colorTabText;
            }
            return C0130R.color.statusError;
        } else if (httpRequest.httpRst) {
            return C0130R.color.statusError;
        } else {
            return C0130R.color.colorTabText;
        }
    }

    public static String getResponseCodeText(Context context, HttpLog.HttpRequest httpRequest) {
        HttpLog.HttpReply httpReply = httpRequest.reply;
        if (httpReply != null && httpReply.responseCode > 0) {
            return String.format(Utils.getPrimaryLocale(context), "%d %s", Integer.valueOf(httpRequest.reply.responseCode), httpRequest.reply.responseStatus);
        }
        if (httpRequest.httpRst) {
            return "RST_STREAM";
        }
        return "—";
    }

    public /* synthetic */ boolean lambda$onCreateViewHolder$0(View view) {
        View.OnLongClickListener onLongClickListener = this.mLongClickListener;
        if (onLongClickListener != null) {
            return onLongClickListener.onLongClick(view);
        }
        return false;
    }

    private boolean matches(HttpLog.HttpRequest httpRequest) {
        boolean z;
        boolean z2;
        String str = this.mSearch;
        if (str == null || httpRequest.matches(str)) {
            z = true;
        } else {
            z = false;
        }
        if (!this.mFilter.isSet() || this.mFilter.matches(httpRequest)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void clearSelection() {
        this.mSelectedItems.clear();
        notifyDataSetChanged();
    }

    public ArrayList<Integer> getFilteredPositions() {
        if (this.mFilteredReqs == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>(this.mFilteredReqs.size());
        ArrayList<HttpLog.HttpRequest> arrayList2 = this.mFilteredReqs;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            HttpLog.HttpRequest httpRequest = arrayList2.get(i);
            i++;
            arrayList.add(Integer.valueOf(httpRequest.getPosition()));
        }
        return arrayList;
    }

    public HttpLog.HttpRequest getItem(int i) {
        ArrayList<HttpLog.HttpRequest> arrayList = this.mFilteredReqs;
        if (arrayList == null) {
            HttpLog httpLog = CaptureService.getHttpLog();
            if (httpLog != null && i >= 0 && i < httpLog.getSize()) {
                return httpLog.getRequest(i);
            }
            Log.m581w(TAG, "getItem: bad position: " + i);
            return null;
        } else if (i >= 0 && i < arrayList.size()) {
            return this.mFilteredReqs.get(i);
        } else {
            Log.m581w(TAG, "getItem(filtered): bad position: " + i);
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<HttpLog.HttpRequest> arrayList = this.mFilteredReqs;
        if (arrayList != null) {
            return arrayList.size();
        }
        HttpLog httpLog = CaptureService.getHttpLog();
        if (httpLog != null) {
            return httpLog.getSize();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        int i2;
        HttpLog.HttpRequest item = getItem(i);
        if (item != null) {
            i2 = item.getPosition();
        } else {
            i2 = -1;
        }
        return i2;
    }

    public int getSelectedCount() {
        return this.mSelectedItems._size;
    }

    public HttpLog.HttpRequest getSelectedItem() {
        return this.mSelectedItem;
    }

    public boolean hasFilter() {
        if (this.mSearch != null || this.mFilter.isSet()) {
            return true;
        }
        return false;
    }

    public boolean isSelected(HttpLog.HttpRequest httpRequest) {
        return this.mSelectedItems.contains(Integer.valueOf(httpRequest.getPosition()));
    }

    @Override // com.emanuelef.remote_capture.HttpLog.Listener
    public void onHttpRequestAdded(int i) {
        HttpLog.HttpRequest request;
        Log.m587d(TAG, "onHttpRequestAdded " + i);
        HttpLog httpLog = CaptureService.getHttpLog();
        if (httpLog != null && (request = httpLog.getRequest(i)) != null) {
            if (this.mFilteredReqs == null) {
                notifyItemInserted(i);
            } else if (matches(request)) {
                int size = this.mFilteredReqs.size();
                this.mIdToFilteredPos.put(i, size);
                this.mFilteredReqs.add(request);
                notifyItemInserted(size);
            }
        }
    }

    @Override // com.emanuelef.remote_capture.HttpLog.Listener
    public void onHttpRequestUpdated(int i) {
        HttpLog.HttpRequest request;
        if (this.mFilteredReqs != null) {
            int i2 = this.mIdToFilteredPos.get(i, -1);
            if (i2 != -1) {
                notifyItemChanged(i2);
                return;
            }
            HttpLog httpLog = CaptureService.getHttpLog();
            if (httpLog != null && (request = httpLog.getRequest(i)) != null && matches(request)) {
                int size = this.mFilteredReqs.size();
                this.mIdToFilteredPos.put(i, size);
                this.mFilteredReqs.add(request);
                notifyItemInserted(size);
            }
        } else if (i >= 0 && i < getItemCount()) {
            notifyItemChanged(i);
        }
    }

    @Override // com.emanuelef.remote_capture.HttpLog.Listener
    public void onHttpRequestsClear() {
        this.mSelectedItem = null;
        this.mSelectedItems.clear();
        refreshFilteredItems();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void refreshFilteredItems() {
        this.mIdToFilteredPos.clear();
        this.mFilteredReqs = null;
        HttpLog httpLog = CaptureService.getHttpLog();
        if (httpLog != null) {
            Log.m587d(TAG, "refreshFilteredConn (" + httpLog.getSize() + ") unfiltered");
            if (hasFilter()) {
                this.mFilteredReqs = new ArrayList<>();
                synchronized (httpLog) {
                    int i = 0;
                    for (int i2 = 0; i2 < httpLog.getSize(); i2++) {
                        try {
                            HttpLog.HttpRequest request = httpLog.getRequest(i2);
                            if (request != null && matches(request)) {
                                this.mFilteredReqs.add(request);
                                this.mIdToFilteredPos.put(i2, i);
                                i++;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                Log.m587d(TAG, "refreshFilteredItems: " + this.mFilteredReqs.size() + " items matched");
            }
        }
        notifyDataSetChanged();
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void selectAll() {
        for (int i = 0; i < getItemCount(); i++) {
            HttpLog.HttpRequest item = getItem(i);
            if (item != null) {
                this.mSelectedItems.add(Integer.valueOf(item.getPosition()));
            }
        }
        notifyDataSetChanged();
    }

    public void selectItem(int i) {
        HttpLog.HttpRequest item = getItem(i);
        if (item != null) {
            this.mSelectedItems.add(Integer.valueOf(item.getPosition()));
            notifyItemChanged(i);
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public void setLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mLongClickListener = onLongClickListener;
    }

    public void setSearch(String str) {
        this.mSearch = str;
        refreshFilteredItems();
    }

    public void toggleSelection(int i) {
        HttpLog.HttpRequest item = getItem(i);
        if (item != null) {
            if (!this.mSelectedItems.remove(Integer.valueOf(item.getPosition()))) {
                this.mSelectedItems.add(Integer.valueOf(item.getPosition()));
            }
            notifyItemChanged(i);
        }
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        HttpLog.HttpRequest item = getItem(i);
        if (item == null) {
            Log.m581w(TAG, "bad position: " + i);
            return;
        }
        viewHolder.bindItem(item, this.mContext, this.mAppsResolver, this.mUnknownIcon);
        if (this.mSelectedItems.contains(Integer.valueOf(item.getPosition()))) {
            viewHolder.itemView.setBackgroundColor(this.mSelectedColor);
        } else {
            viewHolder.itemView.setBackgroundResource(this.mSelectableBackground);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(C0130R.layout.http_req_item, viewGroup, false);
        inflate.setLongClickable(true);
        View.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            inflate.setOnClickListener(onClickListener);
        }
        inflate.setOnLongClickListener(new HttpLogAdapter$$ExternalSyntheticLambda0(0, this));
        return new ViewHolder(inflate);
    }
}
