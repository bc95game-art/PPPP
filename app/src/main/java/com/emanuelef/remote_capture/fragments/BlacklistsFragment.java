package com.emanuelef.remote_capture.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.emanuelef.remote_capture.Blacklists;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.adapters.BlacklistsAdapter;
import com.emanuelef.remote_capture.interfaces.BlacklistsStateListener;
import com.emanuelef.remote_capture.model.BlacklistDescriptor;
/* loaded from: classes.dex */
public class BlacklistsFragment extends Fragment implements BlacklistsStateListener, MenuProvider {
    private static final String TAG = "BlacklistsFragment";
    private BlacklistsAdapter mAdapter;
    private Blacklists mBlacklists;
    private Handler mHandler;
    private MenuItem mUpdateItem;

    public /* synthetic */ void lambda$onViewCreated$0(AdapterView adapterView, View view, int i, long j) {
        BlacklistDescriptor blacklistDescriptor = (BlacklistDescriptor) this.mAdapter.getItem(i);
        if (blacklistDescriptor != null) {
            openUrl(view.getContext(), blacklistDescriptor.url);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$1(CaptureService.ServiceStatus serviceStatus) {
        refreshStatus();
    }

    private void openUrl(Context context, String str) {
        Utils.startActivity(context, new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public void refreshStatus() {
        BlacklistsAdapter blacklistsAdapter = this.mAdapter;
        if (blacklistsAdapter != null) {
            blacklistsAdapter.notifyDataSetChanged();
        }
        MenuItem menuItem = this.mUpdateItem;
        if (menuItem != null) {
            menuItem.setVisible(CaptureService.isServiceActive());
            this.mUpdateItem.setEnabled(!this.mBlacklists.isUpdateInProgress());
        }
    }

    @Override // com.emanuelef.remote_capture.interfaces.BlacklistsStateListener
    public void onBlacklistsStateChanged() {
        Log.d(TAG, "onBlacklistsStateChanged");
        this.mHandler.post(new ActivityCompat$$ExternalSyntheticLambda0(11, this));
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.blacklists_menu, menu);
        this.mUpdateItem = menu.findItem(R.id.update);
        refreshStatus();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return layoutInflater.inflate(R.layout.malware_detection_blacklists, viewGroup, false);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.update) {
            return false;
        }
        CaptureService.requestBlacklistsUpdate();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mBlacklists.removeOnChangeListener(this);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mBlacklists.addOnChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mBlacklists = PCAPdroid.getInstance().getBlacklists();
        this.mAdapter = new BlacklistsAdapter(view.getContext(), PCAPdroid.getInstance().getBlacklists().iter());
        ListView listView = (ListView) view.findViewById(R.id.listview);
        listView.setAdapter((ListAdapter) this.mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.emanuelef.remote_capture.fragments.BlacklistsFragment$$ExternalSyntheticLambda1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                BlacklistsFragment.this.lambda$onViewCreated$0(adapterView, view2, i, j);
            }
        });
        this.mHandler = new Handler(Looper.getMainLooper());
        CaptureService.observeStatus(this, new AppsFragment$$ExternalSyntheticLambda3(3, this));
    }
}
