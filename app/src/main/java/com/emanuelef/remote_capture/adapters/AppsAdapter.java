package com.emanuelef.remote_capture.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.model.AppDescriptor;
import java.util.List;
/* loaded from: classes.dex */
public class AppsAdapter extends RecyclerView.Adapter {
    private List<AppDescriptor> listStorage;
    private final LayoutInflater mLayoutInflater;
    private View.OnClickListener mListener = null;

    /* loaded from: classes.dex */
    public static class AppViewHolder extends RecyclerView.ViewHolder {
        ImageView imageInListView;
        TextView packageInListView;
        TextView textInListView;

        public AppViewHolder(View view) {
            super(view);
            this.textInListView = (TextView) view.findViewById(R.id.app_name);
            this.imageInListView = (ImageView) view.findViewById(R.id.app_icon);
            this.packageInListView = (TextView) view.findViewById(R.id.app_package);
        }
    }

    public AppsAdapter(Context context, List<AppDescriptor> list) {
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.listStorage = list;
    }

    public AppDescriptor getItem(int i) {
        if (i < 0 || i > this.listStorage.size()) {
            return null;
        }
        return this.listStorage.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.listStorage.size();
    }

    public void setApps(List<AppDescriptor> list) {
        this.listStorage = list;
        notifyDataSetChanged();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public void onBindViewHolder(AppViewHolder appViewHolder, int i) {
        AppDescriptor item = getItem(i);
        appViewHolder.textInListView.setText(item.getName());
        appViewHolder.packageInListView.setText(item.getPackageName());
        if (item.getIcon() != null) {
            appViewHolder.imageInListView.setImageDrawable(item.getIcon());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(R.layout.app_installed_item, viewGroup, false);
        AppViewHolder appViewHolder = new AppViewHolder(inflate);
        View.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            inflate.setOnClickListener(onClickListener);
        }
        return appViewHolder;
    }
}
