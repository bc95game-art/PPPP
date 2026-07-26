package com.emanuelef.remote_capture.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.adapters.ListEditAdapter;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.Blocklist;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.model.ListInfo;
import com.emanuelef.remote_capture.model.MatchList;
import com.emanuelef.remote_capture.views.AppSelectDialog;
import com.emanuelef.remote_capture.views.RuleAddDialog;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
/* loaded from: classes.dex */
public class EditListFragment extends Fragment implements MatchList.ListChangeListener, MenuProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String LIST_TYPE_ARG = "list_type";
    private static final int MAX_RULES_BEFORE_WARNING = 5000;
    private static final String TAG = "EditListFragment";
    private ActionMode mActionMode;
    private ListEditAdapter mAdapter;
    private AppSelectDialog mAppSelDialog;
    private TextView mEmptyText;
    private boolean mIsOwnUpdate;
    private MatchList mList;
    private ListInfo mListInfo;
    private ListView mListView;
    private ArrayList<MatchList.Rule> mSelected = new ArrayList<>();
    private final ActivityResultLauncher exportLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new EditListFragment$$ExternalSyntheticLambda0(this, 4));
    private final ActivityResultLauncher importLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new EditListFragment$$ExternalSyntheticLambda0(this, 1));

    public void abortAppSelection() {
        AppSelectDialog appSelectDialog = this.mAppSelDialog;
        if (appSelectDialog != null) {
            appSelectDialog.abort();
            this.mAppSelDialog = null;
        }
    }

    public void confirmDelete(ActionMode actionMode) {
        zzbv zzbvVar = new zzbv(requireContext());
        zzbvVar.setMessage(R.string.rules_delete_confirm);
        ((AlertController.AlertParams) zzbvVar.zza).mCancelable = true;
        zzbvVar.setPositiveButton(R.string.yes, new FirewallStatus$$ExternalSyntheticLambda2(this, 4, actionMode));
        zzbvVar.setNegativeButton(R.string.no, new Blocklist$$ExternalSyntheticLambda0(18));
        AlertDialog create = zzbvVar.create();
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    private void confirmImport(final MatchList matchList) {
        zzbv zzbvVar = new zzbv(requireContext());
        zzbvVar.setTitle(R.string.import_action);
        zzbvVar.setMessage(R.string.rules_merge_msg);
        ((AlertController.AlertParams) zzbvVar.zza).mCancelable = true;
        zzbvVar.setPositiveButton(R.string.keep_action, new DialogInterface.OnClickListener(this) { // from class: com.emanuelef.remote_capture.fragments.EditListFragment$$ExternalSyntheticLambda7
            public final /* synthetic */ EditListFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$confirmImport$8(matchList, dialogInterface, i);
                        return;
                    default:
                        this.f$0.lambda$confirmImport$9(matchList, dialogInterface, i);
                        return;
                }
            }
        });
        zzbvVar.setNegativeButton(R.string.discard_action, new DialogInterface.OnClickListener(this) { // from class: com.emanuelef.remote_capture.fragments.EditListFragment$$ExternalSyntheticLambda7
            public final /* synthetic */ EditListFragment f$0;

            {
                this.f$0 = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                switch (r3) {
                    case 0:
                        this.f$0.lambda$confirmImport$8(matchList, dialogInterface, i);
                        return;
                    default:
                        this.f$0.lambda$confirmImport$9(matchList, dialogInterface, i);
                        return;
                }
            }
        });
        AlertDialog create = zzbvVar.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    private void confirmLoadManyRules(String str) {
        zzbv zzbvVar = new zzbv(requireContext());
        zzbvVar.setTitle(R.string.warning);
        zzbvVar.setMessage(R.string.many_rules_warning);
        ((AlertController.AlertParams) zzbvVar.zza).mCancelable = true;
        zzbvVar.setPositiveButton(R.string.import_action, new FirewallStatus$$ExternalSyntheticLambda2(this, 3, str));
        zzbvVar.setNegativeButton(R.string.cancel_action, new Blocklist$$ExternalSyntheticLambda0(17));
        AlertDialog create = zzbvVar.create();
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    public void exportResult(ActivityResult activityResult) {
        int i = activityResult.mResultCode;
        Intent intent = activityResult.mData;
        if (i == -1 && intent != null) {
            Context requireContext = requireContext();
            String json = this.mList.toJson(true);
            try {
                OutputStream openOutputStream = requireContext.getContentResolver().openOutputStream(intent.getData(), "rwt");
                PrintWriter printWriter = new PrintWriter(openOutputStream);
                printWriter.print(json);
                Utils.showToast(requireContext, R.string.save_ok, new Object[0]);
                printWriter.close();
                if (openOutputStream != null) {
                    openOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Utils.showToastLong(requireContext, R.string.export_failed, new Object[0]);
            }
        }
    }

    private String getExportName() {
        return ViewModelProvider.Factory.CC.m("PCAPdroid_", getString(this.mListInfo.getTitle()).toLowerCase().replaceAll(" ", "_"), ".json");
    }

    public void importResult(ActivityResult activityResult) {
        String str;
        int i = activityResult.mResultCode;
        Intent intent = activityResult.mData;
        if (i == -1 && intent != null) {
            Context requireContext = requireContext();
            try {
                InputStream openInputStream = requireContext.getContentResolver().openInputStream(intent.getData());
                try {
                    Scanner useDelimiter = new Scanner(openInputStream).useDelimiter("\\A");
                    if (useDelimiter.hasNext()) {
                        str = useDelimiter.next();
                    } else {
                        str = "";
                    }
                    importRulesData(str, true);
                    useDelimiter.close();
                    if (openInputStream != null) {
                        openInputStream.close();
                    }
                } catch (Throwable th) {
                    if (openInputStream != null) {
                        try {
                            openInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
                Utils.showToastLong(requireContext, R.string.import_failed, new Object[0]);
            }
        }
    }

    private void importRules(MatchList matchList) {
        Context requireContext = requireContext();
        int addRules = this.mList.addRules(matchList);
        saveAndReload();
        Toast.makeText(requireContext, String.format(requireContext.getResources().getString(R.string.rules_import_success), Integer.valueOf(addRules)), 0).show();
        if (this.mList instanceof Blocklist) {
            Blocklist blocklist = PCAPdroid.getInstance().getBlocklist();
            if (blocklist.hasCountryRules()) {
                blocklist.showNoticeIfGeoMissing(requireContext);
            }
        }
    }

    private void importRulesData(String str, boolean z) {
        int i;
        Context requireContext = requireContext();
        MatchList matchList = new MatchList(requireContext, "");
        if (z) {
            i = MAX_RULES_BEFORE_WARNING;
        } else {
            i = -1;
        }
        int fromJson = matchList.fromJson(str, i);
        if (fromJson <= 0 || matchList.isEmpty()) {
            Utils.showToastLong(requireContext, R.string.invalid_backup, new Object[0]);
        } else if (z && fromJson >= MAX_RULES_BEFORE_WARNING) {
            confirmLoadManyRules(str);
        } else if (!this.mList.isEmpty()) {
            confirmImport(matchList);
        } else {
            importRules(matchList);
        }
    }

    public /* synthetic */ void lambda$confirmDelete$0(ActionMode actionMode, DialogInterface dialogInterface, int i) {
        if (this.mSelected.size() >= this.mAdapter.getCount()) {
            this.mAdapter.clear();
            this.mList.clear();
            this.mList.save();
        } else {
            ArrayList<MatchList.Rule> arrayList = this.mSelected;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                MatchList.Rule rule = arrayList.get(i2);
                i2++;
                this.mAdapter.remove(rule);
            }
            updateListFromAdapter();
        }
        actionMode.finish();
        this.mListInfo.reloadRules();
        recheckListSize();
    }

    public static /* synthetic */ void lambda$confirmDelete$1(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$confirmImport$8(MatchList matchList, DialogInterface dialogInterface, int i) {
        importRules(matchList);
    }

    public /* synthetic */ void lambda$confirmImport$9(MatchList matchList, DialogInterface dialogInterface, int i) {
        this.mList.clear(false);
        importRules(matchList);
    }

    public /* synthetic */ void lambda$confirmLoadManyRules$6(String str, DialogInterface dialogInterface, int i) {
        importRulesData(str, false);
    }

    public static /* synthetic */ void lambda$confirmLoadManyRules$7(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ boolean lambda$showAddCountryRule$4(String[] strArr, String[] strArr2, Context context, String str, TextView textView) {
        String str2;
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                str2 = null;
                break;
            } else if (strArr[i].equals(str)) {
                str2 = strArr2[i];
                break;
            } else {
                i++;
            }
        }
        if (str2 == null) {
            textView.setError(getString(R.string.invalid));
            return false;
        }
        if (!this.mList.addCountry(str2)) {
            Utils.showToastLong(context, R.string.rule_exists, new Object[0]);
        } else {
            saveAndReload();
        }
        PCAPdroid.getInstance().getBlocklist().showNoticeIfGeoMissing(context);
        return true;
    }

    public /* synthetic */ boolean lambda$showAddHostRule$5(String str, TextView textView) {
        if (!Utils.validateHost(str)) {
            textView.setError(getString(R.string.invalid));
            return false;
        } else if (!this.mList.addHost(str)) {
            Utils.showToastLong(requireContext(), R.string.rule_exists, new Object[0]);
            return true;
        } else {
            saveAndReload();
            return true;
        }
    }

    public /* synthetic */ boolean lambda$showAddIpRule$2(String str, TextView textView) {
        if (!Utils.validateCidr(str)) {
            textView.setError(getString(R.string.invalid));
            return false;
        } else if (!this.mList.addIp(str)) {
            Utils.showToastLong(requireContext(), R.string.rule_exists, new Object[0]);
            return true;
        } else {
            saveAndReload();
            return true;
        }
    }

    public /* synthetic */ boolean lambda$showAddProtoRule$3(String str, TextView textView) {
        if (!this.mList.addProto(str)) {
            Utils.showToastLong(requireContext(), R.string.rule_exists, new Object[0]);
            return true;
        }
        saveAndReload();
        return true;
    }

    public static EditListFragment newInstance(ListInfo.Type type) {
        EditListFragment editListFragment = new EditListFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("list_type", type);
        editListFragment.setArguments(bundle);
        return editListFragment;
    }

    private void recheckListSize() {
        int i;
        TextView textView = this.mEmptyText;
        if (this.mAdapter.getCount() == 0) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public void saveAndReload() {
        Log.d(TAG, "saveAndReload");
        this.mList.save();
        this.mListInfo.reloadRules();
    }

    private void showAddAppRule() {
        this.mAppSelDialog = new AppSelectDialog((AppCompatActivity) requireActivity(), R.string.app, new AppSelectDialog.AppSelectListener() { // from class: com.emanuelef.remote_capture.fragments.EditListFragment.2
            {
                EditListFragment.this = this;
            }

            @Override // com.emanuelef.remote_capture.views.AppSelectDialog.AppSelectListener
            public void onAppSelectionAborted() {
                EditListFragment.this.abortAppSelection();
            }

            @Override // com.emanuelef.remote_capture.views.AppSelectDialog.AppSelectListener
            public void onSelectedApp(AppDescriptor appDescriptor) {
                EditListFragment.this.abortAppSelection();
                if (!EditListFragment.this.mList.addApp(appDescriptor.getPackageName())) {
                    Utils.showToastLong(EditListFragment.this.requireContext(), R.string.rule_exists, new Object[0]);
                } else {
                    EditListFragment.this.saveAndReload();
                }
            }
        });
    }

    private void showAddCountryRule() {
        final String[] iSOCountries = Locale.getISOCountries();
        final String[] strArr = new String[iSOCountries.length];
        final Context requireContext = requireContext();
        for (int i = 0; i < iSOCountries.length; i++) {
            strArr[i] = Utils.getCountryName(requireContext, iSOCountries[i]);
        }
        RuleAddDialog.showCombo(requireContext(), R.string.country, strArr, new RuleAddDialog.RuleAddListener() { // from class: com.emanuelef.remote_capture.fragments.EditListFragment$$ExternalSyntheticLambda11
            @Override // com.emanuelef.remote_capture.views.RuleAddDialog.RuleAddListener
            public final boolean addRule(String str, TextView textView) {
                boolean lambda$showAddCountryRule$4;
                lambda$showAddCountryRule$4 = EditListFragment.this.lambda$showAddCountryRule$4(strArr, iSOCountries, requireContext, str, textView);
                return lambda$showAddCountryRule$4;
            }
        });
    }

    private void showAddHostRule() {
        RuleAddDialog.showText(requireContext(), R.string.host, new EditListFragment$$ExternalSyntheticLambda0(this, 3));
    }

    private void showAddIpRule() {
        RuleAddDialog.showText(requireContext(), R.string.ip_address_or_cidr, new EditListFragment$$ExternalSyntheticLambda0(this, 2));
    }

    private void showAddProtoRule() {
        RuleAddDialog.showCombo(requireContext(), R.string.protocol, Utils.getL7Protocols(), new EditListFragment$$ExternalSyntheticLambda0(this, 0));
    }

    private void startExport() {
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.TITLE", getExportName());
        Utils.launchFileDialog(requireContext(), intent, this.exportLauncher);
    }

    private void startImport() {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.TITLE", getExportName());
        Utils.launchFileDialog(requireContext(), intent, this.importLauncher);
    }

    private void updateListFromAdapter() {
        ArrayList arrayList = new ArrayList();
        Iterator<MatchList.Rule> iterRules = this.mList.iterRules();
        while (iterRules.hasNext()) {
            MatchList.Rule next = iterRules.next();
            if (this.mAdapter.getPosition(next) < 0) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            this.mIsOwnUpdate = true;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                this.mList.removeRule((MatchList.Rule) obj);
            }
            this.mList.save();
        }
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.list_edit_menu, menu);
        if (!Utils.supportsFileDialog(requireContext())) {
            menu.findItem(R.id.action_import).setVisible(false);
            menu.findItem(R.id.action_export).setVisible(false);
        }
        Set<MatchList.RuleType> supportedRules = this.mListInfo.getSupportedRules();
        if (supportedRules.contains(MatchList.RuleType.APP)) {
            menu.findItem(R.id.add_app).setVisible(true);
        }
        if (supportedRules.contains(MatchList.RuleType.HOST)) {
            menu.findItem(R.id.add_host).setVisible(true);
        }
        if (supportedRules.contains(MatchList.RuleType.IP)) {
            menu.findItem(R.id.add_ip).setVisible(true);
        }
        if (supportedRules.contains(MatchList.RuleType.PROTOCOL)) {
            menu.findItem(R.id.add_proto).setVisible(true);
        }
        if (supportedRules.contains(MatchList.RuleType.COUNTRY)) {
            menu.findItem(R.id.add_country).setVisible(true);
        }
        if (this.mListInfo.getHelpString() <= 0) {
            menu.findItem(R.id.show_hint).setVisible(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return layoutInflater.inflate(R.layout.simple_list, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mList.removeListChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        abortAppSelection();
    }

    @Override // com.emanuelef.remote_capture.model.MatchList.ListChangeListener
    public void onListChanged() {
        if (this.mIsOwnUpdate) {
            Log.d(TAG, "onListChanged: own update");
            this.mIsOwnUpdate = false;
            return;
        }
        Log.d(TAG, "onListChanged");
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            actionMode.finish();
            this.mActionMode = null;
        }
        this.mAdapter.reload(this.mList.iterRules());
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        recheckListSize();
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        ListView listView = (ListView) requireActivity().findViewById(R.id.listview);
        if (listView == null) {
            return false;
        }
        if (itemId == R.id.action_export) {
            if (this.mList.isEmpty()) {
                Utils.showToastLong(requireContext(), R.string.no_rules_to_export, new Object[0]);
            } else {
                startExport();
            }
            return true;
        } else if (itemId == R.id.action_import) {
            startImport();
            return true;
        } else if (itemId == R.id.copy_to_clipboard) {
            Utils.copyToClipboard(requireContext(), Utils.adapter2Text((ListEditAdapter) listView.getAdapter()));
            return true;
        } else if (itemId == R.id.share) {
            Utils.shareText(requireContext(), getString(this.mListInfo.getTitle()), Utils.adapter2Text((ListEditAdapter) listView.getAdapter()));
            return true;
        } else if (itemId == R.id.show_hint) {
            Utils.showHelpDialog(requireContext(), this.mListInfo.getHelpString());
            return true;
        } else if (itemId == R.id.add_ip) {
            showAddIpRule();
            return true;
        } else if (itemId == R.id.add_proto) {
            showAddProtoRule();
            return true;
        } else if (itemId == R.id.add_host) {
            showAddHostRule();
            return true;
        } else if (itemId == R.id.add_app) {
            showAddAppRule();
            return true;
        } else if (itemId != R.id.add_country) {
            return false;
        } else {
            showAddCountryRule();
            return true;
        }
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.mListView = (ListView) view.findViewById(R.id.listview);
        this.mEmptyText = (TextView) view.findViewById(R.id.list_empty);
        view.findViewById(R.id.simple_list).setFitsSystemWindows(true);
        ListInfo listInfo = new ListInfo((ListInfo.Type) Utils.getSerializable(getArguments(), "list_type", ListInfo.Type.class));
        this.mListInfo = listInfo;
        MatchList list = listInfo.getList();
        this.mList = list;
        list.addListChangeListener(this);
        ListEditAdapter listEditAdapter = new ListEditAdapter(requireContext());
        this.mAdapter = listEditAdapter;
        this.mListView.setAdapter((ListAdapter) listEditAdapter);
        this.mListView.setChoiceMode(3);
        this.mListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() { // from class: com.emanuelef.remote_capture.fragments.EditListFragment.1
            {
                EditListFragment.this = this;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.delete_entry) {
                    EditListFragment.this.confirmDelete(actionMode);
                    return true;
                }
                if (itemId != R.id.select_all) {
                    return false;
                }
                if (EditListFragment.this.mSelected.size() >= EditListFragment.this.mAdapter.getCount()) {
                    actionMode.finish();
                    return true;
                }
                for (int i = 0; i < EditListFragment.this.mAdapter.getCount(); i++) {
                    if (!EditListFragment.this.mListView.isItemChecked(i)) {
                        EditListFragment.this.mListView.setItemChecked(i, true);
                    }
                }
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                EditListFragment.this.requireActivity().getMenuInflater().inflate(R.menu.list_edit_cab, menu);
                EditListFragment.this.mActionMode = actionMode;
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
                EditListFragment.this.mSelected = new ArrayList();
                EditListFragment.this.mActionMode = null;
            }

            @Override // android.widget.AbsListView.MultiChoiceModeListener
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
                MatchList.Rule rule = (MatchList.Rule) EditListFragment.this.mAdapter.getItem(i);
                if (z) {
                    EditListFragment.this.mSelected.add(rule);
                } else {
                    EditListFragment.this.mSelected.remove(rule);
                }
                EditListFragment editListFragment = EditListFragment.this;
                actionMode.setTitle(editListFragment.getString(R.string.n_selected, Integer.valueOf(editListFragment.mSelected.size())));
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.mAdapter.reload(this.mList.iterRules());
        recheckListSize();
    }
}
