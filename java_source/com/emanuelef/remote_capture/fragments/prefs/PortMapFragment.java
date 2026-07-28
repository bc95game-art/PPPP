package com.emanuelef.remote_capture.fragments.prefs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.preference.PreferenceManager;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.AboutActivity$$ExternalSyntheticLambda10;
import com.emanuelef.remote_capture.adapters.PortMappingAdapter;
import com.emanuelef.remote_capture.fragments.FirewallStatus$$ExternalSyntheticLambda2;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.model.PortMapping;
import com.emanuelef.remote_capture.model.Prefs;
import com.google.android.material.chip.Chip$$ExternalSyntheticLambda0;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.Iterator;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class PortMapFragment extends Fragment implements MenuProvider {
    private static final String TAG = "PortMapFragment";
    private PortMappingAdapter mAdapter;
    private TextView mEmptyText;
    private ListView mListView;
    private PortMapping mPortMap;
    private ArrayList<PortMapping.PortMap> mSelected = new ArrayList<>();

    public void confirmDelete(ActionMode actionMode) {
        zzbv zzbvVar = new zzbv(requireContext());
        zzbvVar.setMessage(C0130R.string.items_delete_confirm);
        ((AlertController.AlertParams) zzbvVar.zza).mCancelable = true;
        zzbvVar.setPositiveButton(C0130R.string.yes, new FirewallStatus$$ExternalSyntheticLambda2(this, 6, actionMode));
        zzbvVar.setNegativeButton(C0130R.string.no, new Blocklist$$ExternalSyntheticLambda0(23));
        AlertDialog create = zzbvVar.create();
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    public /* synthetic */ void lambda$confirmDelete$4(ActionMode actionMode, DialogInterface dialogInterface, int i) {
        if (this.mSelected.size() >= this.mAdapter.getCount()) {
            this.mAdapter.clear();
            this.mPortMap.clear();
            this.mPortMap.save();
        } else {
            ArrayList<PortMapping.PortMap> arrayList = this.mSelected;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                PortMapping.PortMap portMap = arrayList.get(i2);
                i2++;
                this.mAdapter.remove(portMap);
            }
            updateMappingsFromAdapter();
        }
        actionMode.finish();
        recheckListSize();
    }

    public static /* synthetic */ void lambda$confirmDelete$5(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$onCreateMenu$0(CompoundButton compoundButton, boolean z) {
        String str;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        if (z != Prefs.isPortMappingEnabled(defaultSharedPreferences)) {
            if (z) {
                str = "enabled";
            } else {
                str = "disabled";
            }
            Log.m587d(TAG, "Port mapping is now ".concat(str));
            Prefs.setPortMappingEnabled(defaultSharedPreferences, z);
        }
    }

    public static /* synthetic */ void lambda$openAddDialog$1(DialogInterface dialogInterface, int i) {
    }

    public static /* synthetic */ void lambda$openAddDialog$2(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$openAddDialog$3(View view, AlertDialog alertDialog, View view2) {
        PortMapping.PortMap validateAddDialog = validateAddDialog(view);
        if (validateAddDialog != null) {
            if (!this.mPortMap.add(validateAddDialog)) {
                Utils.showToastLong(requireContext(), C0130R.string.port_mapping_exists, new Object[0]);
            } else {
                this.mPortMap.save();
                this.mAdapter.add(validateAddDialog);
                recheckListSize();
            }
            alertDialog.dismiss();
        }
    }

    private void openAddDialog() {
        Context requireContext = requireContext();
        View inflate = LayoutInflater.from(requireContext).inflate(C0130R.layout.add_port_mapping_dialog, (ViewGroup) null);
        String[] strArr = {"TCP", "UDP"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext, (int) C0130R.layout.dropdown_item, strArr);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) inflate.findViewById(C0130R.C0132id.proto);
        autoCompleteTextView.setText(strArr[0]);
        autoCompleteTextView.setAdapter(arrayAdapter);
        ((TextInputEditText) inflate.findViewById(C0130R.C0132id.redirect_host)).setText("127.0.0.1");
        zzbv zzbvVar = new zzbv(requireContext);
        ((AlertController.AlertParams) zzbvVar.zza).mView = inflate;
        zzbvVar.setTitle(C0130R.string.port_mapping);
        zzbvVar.setPositiveButton(C0130R.string.add_action, new Blocklist$$ExternalSyntheticLambda0(21));
        zzbvVar.setNegativeButton(C0130R.string.cancel_action, new Blocklist$$ExternalSyntheticLambda0(22));
        AlertDialog show = zzbvVar.show();
        show.setCanceledOnTouchOutside(false);
        show.getButton(-1).setOnClickListener(new AboutActivity$$ExternalSyntheticLambda10(this, inflate, show, 1));
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

    private void updateMappingsFromAdapter() {
        ArrayList arrayList = new ArrayList();
        Iterator<PortMapping.PortMap> iter = this.mPortMap.iter();
        while (iter.hasNext()) {
            PortMapping.PortMap next = iter.next();
            if (this.mAdapter.getPosition(next) < 0) {
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                this.mPortMap.remove((PortMapping.PortMap) obj);
            }
            this.mPortMap.save();
        }
    }

    private PortMapping.PortMap validateAddDialog(View view) {
        int i;
        TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C0130R.C0132id.orig_port);
        TextInputEditText textInputEditText2 = (TextInputEditText) view.findViewById(C0130R.C0132id.redirect_host);
        TextInputEditText textInputEditText3 = (TextInputEditText) view.findViewById(C0130R.C0132id.redirect_port);
        Editable text = textInputEditText.getText();
        Objects.requireNonNull(text);
        String obj = text.toString();
        Editable text2 = textInputEditText2.getText();
        Objects.requireNonNull(text2);
        String obj2 = text2.toString();
        Editable text3 = textInputEditText3.getText();
        Objects.requireNonNull(text3);
        String obj3 = text3.toString();
        String obj4 = ((AutoCompleteTextView) view.findViewById(C0130R.C0132id.proto)).getText().toString();
        if (obj.isEmpty()) {
            textInputEditText.setError(getString(C0130R.string.required));
            return null;
        } else if (!Utils.validatePort(obj)) {
            textInputEditText.setError(getString(C0130R.string.invalid));
            return null;
        } else if (obj2.isEmpty()) {
            textInputEditText2.setError(getString(C0130R.string.required));
            return null;
        } else if (!Utils.validateIpAddress(obj2) && !Utils.validateHost(obj2)) {
            textInputEditText2.setError(getString(C0130R.string.invalid));
            return null;
        } else if (obj3.isEmpty()) {
            textInputEditText3.setError(getString(C0130R.string.required));
            return null;
        } else if (!Utils.validatePort(obj3)) {
            textInputEditText3.setError(getString(C0130R.string.invalid));
            return null;
        } else {
            if (obj4.equals("TCP")) {
                i = 6;
            } else {
                i = 17;
            }
            return new PortMapping.PortMap(i, Integer.parseInt(obj), Integer.parseInt(obj3), obj2);
        }
    }

    @Override // androidx.core.view.MenuProvider
    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(C0130R.C0134menu.port_mapping_menu, menu);
        SwitchCompat switchCompat = (SwitchCompat) menu.findItem(C0130R.C0132id.toggle_btn).getActionView();
        switchCompat.setChecked(Prefs.isPortMappingEnabled(PreferenceManager.getDefaultSharedPreferences(requireContext())));
        switchCompat.setOnCheckedChangeListener(new Chip$$ExternalSyntheticLambda0(2, this));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        requireActivity().addMenuProvider(this, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        return layoutInflater.inflate(C0130R.layout.simple_list, viewGroup, false);
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onMenuClosed(Menu menu) {
    }

    @Override // androidx.core.view.MenuProvider
    public boolean onMenuItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != C0130R.C0132id.add_mapping) {
            return false;
        }
        openAddDialog();
        return true;
    }

    @Override // androidx.core.view.MenuProvider
    public /* bridge */ /* synthetic */ void onPrepareMenu(Menu menu) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.setFitsSystemWindows(true);
        this.mListView = (ListView) view.findViewById(C0130R.C0132id.listview);
        this.mEmptyText = (TextView) view.findViewById(C0130R.C0132id.list_empty);
        this.mPortMap = new PortMapping(requireContext());
        PortMappingAdapter portMappingAdapter = new PortMappingAdapter(requireContext(), this.mPortMap);
        this.mAdapter = portMappingAdapter;
        this.mListView.setAdapter((ListAdapter) portMappingAdapter);
        this.mListView.setChoiceMode(3);
        this.mListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() { // from class: com.emanuelef.remote_capture.fragments.prefs.PortMapFragment.1
            {
                PortMapFragment.this = this;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == C0130R.C0132id.delete_entry) {
                    PortMapFragment.this.confirmDelete(actionMode);
                    return true;
                }
                if (itemId != C0130R.C0132id.select_all) {
                    return false;
                }
                if (PortMapFragment.this.mSelected.size() >= PortMapFragment.this.mAdapter.getCount()) {
                    actionMode.finish();
                    return true;
                }
                for (int i = 0; i < PortMapFragment.this.mAdapter.getCount(); i++) {
                    if (!PortMapFragment.this.mListView.isItemChecked(i)) {
                        PortMapFragment.this.mListView.setItemChecked(i, true);
                    }
                }
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                PortMapFragment.this.requireActivity().getMenuInflater().inflate(C0130R.C0134menu.list_edit_cab, menu);
                return true;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode actionMode) {
                PortMapFragment.this.mSelected = new ArrayList();
            }

            @Override // android.widget.AbsListView.MultiChoiceModeListener
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
                PortMapping.PortMap portMap = (PortMapping.PortMap) PortMapFragment.this.mAdapter.getItem(i);
                if (z) {
                    PortMapFragment.this.mSelected.add(portMap);
                } else {
                    PortMapFragment.this.mSelected.remove(portMap);
                }
                PortMapFragment portMapFragment = PortMapFragment.this;
                actionMode.setTitle(portMapFragment.getString(C0130R.string.n_selected, Integer.valueOf(portMapFragment.mSelected.size())));
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        Utils.fixListviewInsetsBottom(this.mListView);
        recheckListSize();
    }
}
