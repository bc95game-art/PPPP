package com.emanuelef.remote_capture.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.collection.ArraySet;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.model.AppDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class AppsTogglesAdapter extends RecyclerView.Adapter {
    private static final String TAG = "AppToggleAdapter";
    private final Set<String> mCheckedItems;
    private final LayoutInflater mLayoutInflater;
    private RecyclerView mRecyclerView;
    private String mFilter = "";
    private boolean mShowSystemApps = false;
    private List<AppDescriptor> mApps = new ArrayList();
    private final List<AppDescriptor> mFilteredApps = new ArrayList();
    private AppToggleListener mListener = null;

    /* loaded from: classes.dex */
    public interface AppToggleListener {
        void onAppToggled(AppDescriptor appDescriptor, boolean z);
    }

    /* loaded from: classes.dex */
    public static class AppViewHolder extends RecyclerView.ViewHolder {
        TextView appName;
        ImageView icon;
        TextView packageName;
        SwitchCompat toggle;

        public AppViewHolder(View view) {
            super(view);
            this.appName = (TextView) view.findViewById(R.id.app_name);
            this.icon = (ImageView) view.findViewById(R.id.icon);
            this.packageName = (TextView) view.findViewById(R.id.app_package);
            this.toggle = (SwitchCompat) view.findViewById(R.id.toggle_btn);
        }
    }

    public AppsTogglesAdapter(Context context, Set<String> set) {
        this.mLayoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.mCheckedItems = new ArraySet(set);
    }

    public int compareCheckedFirst(AppDescriptor appDescriptor, AppDescriptor appDescriptor2) {
        boolean contains = this.mCheckedItems.contains(appDescriptor.getPackageName());
        boolean contains2 = this.mCheckedItems.contains(appDescriptor2.getPackageName());
        if (contains && !contains2) {
            return -1;
        }
        if (contains || !contains2) {
            return appDescriptor.compareTo(appDescriptor2);
        }
        return 1;
    }

    private List<AppDescriptor> getApps() {
        if (isFiltering()) {
            return this.mFilteredApps;
        }
        return this.mApps;
    }

    private void handleToggle(int i, boolean z) {
        String str;
        AppDescriptor item = getItem(i);
        String packageName = item.getPackageName();
        if (z != this.mCheckedItems.contains(packageName)) {
            if (z) {
                this.mCheckedItems.add(packageName);
            } else {
                this.mCheckedItems.remove(packageName);
            }
            AppToggleListener appToggleListener = this.mListener;
            if (appToggleListener != null) {
                appToggleListener.onAppToggled(item, z);
            }
            if (z || this.mShowSystemApps || !item.isSystem()) {
                List<AppDescriptor> apps = getApps();
                int i2 = 0;
                while (true) {
                    if (i2 >= apps.size()) {
                        i2 = i;
                        break;
                    }
                    AppDescriptor appDescriptor = apps.get(i2);
                    if (i2 != i && compareCheckedFirst(item, appDescriptor) <= 0) {
                        break;
                    }
                    i2++;
                }
                if (i2 > i) {
                    i2--;
                }
                StringBuilder m = ViewModelProvider.Factory.CC.m("Item @", i, ": ");
                if (z) {
                    str = "checked";
                } else {
                    str = "unchecked";
                }
                m.append(str);
                m.append(" -> ");
                m.append(i2);
                Log.d(TAG, m.toString());
                notifyItemChanged(i);
                if (i2 != i) {
                    apps.remove(i);
                    apps.add(i2, item);
                    notifyItemMoved(i, i2);
                    RecyclerView recyclerView = this.mRecyclerView;
                    if (recyclerView == null) {
                        return;
                    }
                    if (z) {
                        recyclerView.scrollToPosition(i2);
                    } else {
                        recyclerView.scrollToPosition(i);
                    }
                }
            } else {
                getApps().remove(i);
                notifyItemRemoved(i);
            }
        }
    }

    private boolean isFiltering() {
        if (!this.mFilter.isEmpty() || !this.mShowSystemApps) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0(AppViewHolder appViewHolder, View view) {
        int absoluteAdapterPosition;
        AppDescriptor item;
        if (this.mRecyclerView != null && (item = getItem((absoluteAdapterPosition = appViewHolder.getAbsoluteAdapterPosition()))) != null) {
            handleToggle(absoluteAdapterPosition, !this.mCheckedItems.contains(item.getPackageName()));
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1(AppViewHolder appViewHolder, View view) {
        if (this.mRecyclerView != null) {
            handleToggle(appViewHolder.getAbsoluteAdapterPosition(), ((SwitchCompat) view).isChecked());
        }
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private void refreshedFiteredApps() {
        this.mFilteredApps.clear();
        if (isFiltering()) {
            for (AppDescriptor appDescriptor : this.mApps) {
                if (this.mFilter.isEmpty() || appDescriptor.matches(this.mFilter, false)) {
                    if (this.mShowSystemApps || !appDescriptor.isSystem() || this.mCheckedItems.contains(appDescriptor.getPackageName())) {
                        this.mFilteredApps.add(appDescriptor);
                    }
                }
            }
        }
        Collections.sort(getApps(), new AppsStatsAdapter$$ExternalSyntheticLambda0(1, this));
        notifyDataSetChanged();
    }

    public AppDescriptor getItem(int i) {
        if (i < 0 || i > getItemCount()) {
            return null;
        }
        return getApps().get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return getApps().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.mRecyclerView = null;
    }

    public void setAppToggleListener(AppToggleListener appToggleListener) {
        this.mListener = appToggleListener;
    }

    public void setApps(List<AppDescriptor> list) {
        this.mApps = list;
        refreshedFiteredApps();
    }

    public void setFilter(String str) {
        this.mFilter = str;
        refreshedFiteredApps();
    }

    public void setShowSystemApps(boolean z) {
        this.mShowSystemApps = z;
        refreshedFiteredApps();
    }

    public void onBindViewHolder(AppViewHolder appViewHolder, int i) {
        AppDescriptor item = getItem(i);
        appViewHolder.appName.setText(item.getName());
        appViewHolder.packageName.setText(item.getPackageName());
        appViewHolder.toggle.setChecked(this.mCheckedItems.contains(item.getPackageName()));
        if (item.getIcon() != null) {
            appViewHolder.icon.setImageDrawable(item.getIcon());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AppViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.mLayoutInflater.inflate(R.layout.app_selection_item, viewGroup, false);
        final AppViewHolder appViewHolder = new AppViewHolder(inflate);
        inflate.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.adapters.AppsTogglesAdapter$$ExternalSyntheticLambda1
            public final /* synthetic */ AppsTogglesAdapter f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$onCreateViewHolder$0(appViewHolder, view);
                        return;
                    default:
                        this.f$0.lambda$onCreateViewHolder$1(appViewHolder, view);
                        return;
                }
            }
        });
        appViewHolder.toggle.setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.adapters.AppsTogglesAdapter$$ExternalSyntheticLambda1
            public final /* synthetic */ AppsTogglesAdapter f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$onCreateViewHolder$0(appViewHolder, view);
                        return;
                    default:
                        this.f$0.lambda$onCreateViewHolder$1(appViewHolder, view);
                        return;
                }
            }
        });
        return appViewHolder;
    }
}
