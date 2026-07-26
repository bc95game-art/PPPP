package com.emanuelef.remote_capture.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.emanuelef.remote_capture.AppsLoader;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.adapters.AppsTogglesAdapter;
import com.emanuelef.remote_capture.interfaces.AppsLoadListener;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.views.EmptyRecyclerView;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class AppsToggles extends Fragment implements AppsLoadListener, AppsTogglesAdapter.AppToggleListener, MenuProvider, SearchView.OnQueryTextListener {
    private static final String TAG = "AppsToggles";
    private static boolean sShowSystemApps;
    private AppsTogglesAdapter mAdapter;
    private TextView mEmptyText;
    private String mQueryToApply;
    private SearchView mSearchView;

    public Set<String> getCheckedApps() {
        throw new Error("An operation is not implemented.");
    }

    @Override // com.emanuelef.remote_capture.interfaces.AppsLoadListener
    public void onAppsInfoLoaded(List<AppDescriptor> list) {
        this.mAdapter.setApps(list);
        this.mEmptyText.setText(C0130R.string.no_matches_found);
    }

    public boolean onBackPressed() {
        Log.m587d(TAG, "onBackPressed");
        return Utils.backHandleSearchview(this.mSearchView);
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C0130R.C0134menu.search_menu, menu);
        MenuItem findItem = menu.findItem(C0130R.C0132id.search);
        SearchView searchView = (SearchView) findItem.getActionView();
        this.mSearchView = searchView;
        searchView.setOnQueryTextListener(this);
        String str = this.mQueryToApply;
        if (str != null && !str.isEmpty()) {
            Log.m587d(TAG, "Initial filter: " + this.mQueryToApply);
            Utils.setSearchQuery(this.mSearchView, findItem, this.mQueryToApply);
        }
        MenuItem findItem2 = menu.findItem(C0130R.C0132id.show_system_apps);
        if (findItem2 != null) {
            findItem2.setChecked(sShowSystemApps);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return layoutInflater.inflate(C0130R.layout.apps_stats, viewGroup, false);
    }

    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C0130R.C0132id.show_system_apps) {
            return false;
        }
        boolean z = !sShowSystemApps;
        sShowSystemApps = z;
        menuItem.setChecked(z);
        this.mAdapter.setShowSystemApps(sShowSystemApps);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SearchView searchView = this.mSearchView;
        if (searchView != null) {
            this.mQueryToApply = searchView.getQuery().toString();
        }
    }

    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        this.mAdapter.setFilter(str);
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        SearchView searchView = this.mSearchView;
        if (searchView != null) {
            String charSequence = searchView.getQuery().toString();
            Log.m587d(TAG, "Saving filter: " + charSequence);
            bundle.putString("filter", charSequence);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String string;
        EmptyRecyclerView emptyRecyclerView = (EmptyRecyclerView) view.findViewById(C0130R.C0132id.recycler_view);
        emptyRecyclerView.setLayoutManager(new EmptyRecyclerView.MyLinearLayoutManager(getContext()));
        AppsTogglesAdapter appsTogglesAdapter = new AppsTogglesAdapter(requireContext(), getCheckedApps());
        this.mAdapter = appsTogglesAdapter;
        emptyRecyclerView.setAdapter(appsTogglesAdapter);
        this.mAdapter.setAppToggleListener(this);
        TextView textView = (TextView) view.findViewById(C0130R.C0132id.no_apps);
        this.mEmptyText = textView;
        textView.setText(C0130R.string.loading_apps);
        emptyRecyclerView.setEmptyView(this.mEmptyText);
        if (!(bundle == null || (string = bundle.getString("filter")) == null || string.isEmpty())) {
            this.mQueryToApply = string;
        }
        this.mAdapter.setShowSystemApps(sShowSystemApps);
        Log.m587d(TAG, "mQueryToApply: " + this.mQueryToApply);
        new AppsLoader((AppCompatActivity) requireActivity()).setAppsLoadListener(this).loadAllApps();
    }
}
