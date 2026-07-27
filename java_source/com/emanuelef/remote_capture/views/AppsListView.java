package com.emanuelef.remote_capture.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SearchView;
import com.emanuelef.remote_capture.adapters.AppsAdapter;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.views.EmptyRecyclerView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class AppsListView extends EmptyRecyclerView implements SearchView.OnQueryTextListener {
    private AppsAdapter mAdapter;
    private List<AppDescriptor> mAllApps;
    private String mLastFilter;
    private boolean mShowSystemApps;

    /* loaded from: classes.dex */
    public interface OnSelectedAppListener {
        void onSelectedApp(AppDescriptor appDescriptor);
    }

    public AppsListView(Context context) {
        super(context);
        initialize(context);
    }

    private List<AppDescriptor> getFilteredApps() {
        String str;
        String str2 = this.mLastFilter;
        if (str2 != null) {
            str = str2.toLowerCase();
        } else {
            str = "";
        }
        if (str.isEmpty() && this.mShowSystemApps) {
            return this.mAllApps;
        }
        ArrayList arrayList = new ArrayList();
        for (AppDescriptor appDescriptor : this.mAllApps) {
            if (this.mShowSystemApps || !appDescriptor.isSystem()) {
                if (str.isEmpty() || appDescriptor.getPackageName().toLowerCase().contains(str) || appDescriptor.getName().toLowerCase().contains(str)) {
                    arrayList.add(appDescriptor);
                }
            }
        }
        return arrayList;
    }

    private void initialize(Context context) {
        this.mAllApps = null;
        setLayoutManager(new EmptyRecyclerView.MyLinearLayoutManager(context));
        setHasFixedSize(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSelectedAppListener$0(OnSelectedAppListener onSelectedAppListener, View view) {
        AppDescriptor item = this.mAdapter.getItem(getChildLayoutPosition(view));
        if (item != null) {
            onSelectedAppListener.onSelectedApp(item);
        }
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        this.mLastFilter = str;
        if (this.mAllApps == null) {
            return true;
        }
        this.mAdapter.setApps(getFilteredApps());
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }

    public void setApps(List<AppDescriptor> list) {
        this.mAllApps = list;
        List<AppDescriptor> filteredApps = getFilteredApps();
        AppsAdapter appsAdapter = this.mAdapter;
        if (appsAdapter == null) {
            AppsAdapter appsAdapter2 = new AppsAdapter(getContext(), filteredApps);
            this.mAdapter = appsAdapter2;
            setAdapter(appsAdapter2);
            return;
        }
        appsAdapter.setApps(filteredApps);
    }

    public void setSelectedAppListener(final OnSelectedAppListener onSelectedAppListener) {
        this.mAdapter.setOnClickListener(new View.OnClickListener() { // from class: com.emanuelef.remote_capture.views.AppsListView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppsListView.this.lambda$setSelectedAppListener$0(onSelectedAppListener, view);
            }
        });
    }

    public void setShowSystemApps(boolean z) {
        this.mShowSystemApps = z;
        if (this.mAllApps != null) {
            this.mAdapter.setApps(getFilteredApps());
        }
    }

    public AppsListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(context);
    }

    public AppsListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize(context);
    }
}
