package com.emanuelef.remote_capture.activities.prefs;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.core.view.MenuProvider;
import androidx.preference.PreferenceManager;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.BaseActivity;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.adapters.CtrlPermissionsAdapter;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.fragments.FirewallStatus$$ExternalSyntheticLambda2;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.model.CtrlPermissions;
import com.emanuelef.remote_capture.model.Prefs;
import java.security.SecureRandom;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class EditCtrlPermissions extends BaseActivity implements MenuProvider {
    private static final String TAG = "EditCtrlPermissions";
    private CtrlPermissionsAdapter mAdapter;
    private TextView mEmptyText;
    private ListView mListView;
    private CtrlPermissions mPermissions;
    private final ArrayList<CtrlPermissions.Rule> mSelected = new ArrayList<>();
    private MenuItem mShowApiKey;

    private void generateApiKey(boolean z) {
        SharedPreferences sharedPreferences = getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0);
        if (z || Prefs.getApiKey(sharedPreferences).isEmpty()) {
            SecureRandom secureRandom = new SecureRandom();
            StringBuilder sb = new StringBuilder(32);
            for (int i = 0; i < 32; i++) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".charAt(secureRandom.nextInt(62)));
            }
            sharedPreferences.edit().putString(Prefs.PREF_API_KEY, sb.toString()).apply();
            MenuItem menuItem = this.mShowApiKey;
            if (menuItem != null) {
                menuItem.setVisible(true);
            }
            showApiKey();
            return;
        }
        zzbv zzbvVar = new zzbv(this);
        zzbvVar.setTitle(R.string.warning);
        zzbvVar.setMessage(R.string.api_key_discard_confirm);
        zzbvVar.setPositiveButton(R.string.ok, new AppsFragment$$ExternalSyntheticLambda0(2, this));
        zzbvVar.setNegativeButton(R.string.cancel_action, new Blocklist$$ExternalSyntheticLambda0(9));
        zzbvVar.show();
    }

    public /* synthetic */ void lambda$generateApiKey$0(DialogInterface dialogInterface, int i) {
        generateApiKey(true);
    }

    public static /* synthetic */ void lambda$generateApiKey$1(DialogInterface dialogInterface, int i) {
    }

    public static /* synthetic */ void lambda$showApiKey$2(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$showApiKey$3(String str, DialogInterface dialogInterface, int i) {
        Utils.copyToClipboard(this, str);
    }

    public void recheckListSize() {
        int i;
        TextView textView = this.mEmptyText;
        if (this.mAdapter.getCount() == 0) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
    }

    private void showApiKey() {
        String apiKey = Prefs.getApiKey(getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0));
        if (!apiKey.isEmpty()) {
            zzbv zzbvVar = new zzbv(this);
            zzbvVar.setTitle(R.string.api_key);
            ((AlertController.AlertParams) zzbvVar.zza).mMessage = apiKey;
            zzbvVar.setPositiveButton(R.string.ok, new Blocklist$$ExternalSyntheticLambda0(8));
            zzbvVar.setNeutralButton(R.string.copy_to_clipboard, new FirewallStatus$$ExternalSyntheticLambda2(this, 1, apiKey));
            zzbvVar.show();
        }
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.control_permissions);
        setContentView(R.layout.simple_list_activity);
        addMenuProvider(this);
        findViewById(R.id.simple_list).setFitsSystemWindows(true);
        TextView textView = (TextView) findViewById(R.id.list_empty);
        this.mEmptyText = textView;
        textView.setText(R.string.no_permissions_set_info);
        this.mListView = (ListView) findViewById(R.id.listview);
        this.mPermissions = PCAPdroid.getInstance().getCtrlPermissions();
        CtrlPermissionsAdapter ctrlPermissionsAdapter = new CtrlPermissionsAdapter(this, this.mPermissions);
        this.mAdapter = ctrlPermissionsAdapter;
        this.mListView.setAdapter((ListAdapter) ctrlPermissionsAdapter);
        this.mListView.setChoiceMode(3);
        this.mListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() { // from class: com.emanuelef.remote_capture.activities.prefs.EditCtrlPermissions.1
            {
                EditCtrlPermissions.this = this;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                int i = 0;
                if (itemId == R.id.delete_entry) {
                    if (EditCtrlPermissions.this.mSelected.size() >= EditCtrlPermissions.this.mAdapter.getCount()) {
                        EditCtrlPermissions.this.mAdapter.clear();
                        EditCtrlPermissions.this.mPermissions.removeAll();
                    } else {
                        ArrayList arrayList = EditCtrlPermissions.this.mSelected;
                        int size = arrayList.size();
                        while (i < size) {
                            Object obj = arrayList.get(i);
                            i++;
                            CtrlPermissions.Rule rule = (CtrlPermissions.Rule) obj;
                            EditCtrlPermissions.this.mAdapter.remove(rule);
                            EditCtrlPermissions.this.mPermissions.remove(rule.package_name);
                        }
                    }
                    actionMode.finish();
                    EditCtrlPermissions.this.recheckListSize();
                    return true;
                }
                if (itemId == R.id.select_all) {
                    if (EditCtrlPermissions.this.mSelected.size() >= EditCtrlPermissions.this.mAdapter.getCount()) {
                        actionMode.finish();
                        return false;
                    }
                    for (int i2 = 0; i2 < EditCtrlPermissions.this.mAdapter.getCount(); i2++) {
                        if (!EditCtrlPermissions.this.mListView.isItemChecked(i2)) {
                            EditCtrlPermissions.this.mListView.setItemChecked(i2, true);
                        }
                    }
                }
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                EditCtrlPermissions.this.getMenuInflater().inflate(R.menu.list_edit_cab, menu);
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
                EditCtrlPermissions.this.mSelected.clear();
            }

            @Override // android.widget.AbsListView.MultiChoiceModeListener
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
                CtrlPermissions.Rule rule = (CtrlPermissions.Rule) EditCtrlPermissions.this.mAdapter.getItem(i);
                if (z) {
                    EditCtrlPermissions.this.mSelected.add(rule);
                } else {
                    EditCtrlPermissions.this.mSelected.remove(rule);
                }
                EditCtrlPermissions editCtrlPermissions = EditCtrlPermissions.this;
                actionMode.setTitle(editCtrlPermissions.getString(R.string.n_selected, Integer.valueOf(editCtrlPermissions.mSelected.size())));
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        Utils.fixListviewInsetsBottom(this.mListView);
        recheckListSize();
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.ctrl_permissions_menu, menu);
        SharedPreferences sharedPreferences = getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0);
        this.mShowApiKey = menu.findItem(R.id.show_api_key);
        if (Prefs.getApiKey(sharedPreferences).isEmpty()) {
            this.mShowApiKey.setVisible(false);
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.user_guide) {
            Utils.startActivity(this, new Intent("android.intent.action.VIEW", Uri.parse(MainActivity.API_DOCS_URL)));
            return true;
        } else if (itemId == R.id.generate_api_key) {
            generateApiKey(false);
            return true;
        } else if (itemId != R.id.show_api_key) {
            return false;
        } else {
            showApiKey();
            return true;
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }
}
