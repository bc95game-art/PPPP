package com.emanuelef.remote_capture.views;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.preference.PreferenceManager;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.AppsLoader;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.interfaces.AppsLoadListener;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.Prefs;
import com.emanuelef.remote_capture.views.AppsListView;
import com.google.android.material.chip.Chip$$ExternalSyntheticLambda0;
import com.pcapdroid.mitm.MitmAPI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class AppSelectDialog implements AppsLoadListener {
    private static final String TAG = "AppSelectDialog";
    private static boolean sShowSystemApps;
    private AppCompatActivity mActivity;
    private Dialog mDialog;
    private TextView mEmptyAppsView;
    private AppSelectListener mListener;
    private AppsLoader mLoader;
    private AppsListView mOpenAppsList;
    private final SharedPreferences mPrefs;
    private final int mTitleRes;

    /* loaded from: classes.dex */
    public interface AppSelectListener {
        void onAppSelectionAborted();

        void onSelectedApp(AppDescriptor appDescriptor);
    }

    public AppSelectDialog(AppCompatActivity appCompatActivity, int i, AppSelectListener appSelectListener) {
        this.mActivity = appCompatActivity;
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(appCompatActivity);
        this.mListener = appSelectListener;
        this.mTitleRes = i;
        show();
    }

    private Dialog getDialog() {
        View inflate = this.mActivity.getLayoutInflater().inflate(R.layout.apps_selector, (ViewGroup) null);
        AppsListView appsListView = (AppsListView) inflate.findViewById(R.id.apps_list);
        appsListView.setApps(new ArrayList());
        appsListView.setEmptyView((TextView) inflate.findViewById(R.id.no_apps));
        ((SearchView) inflate.findViewById(R.id.apps_search)).setOnQueryTextListener(appsListView);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.show_system_apps);
        checkBox.setChecked(sShowSystemApps);
        appsListView.setShowSystemApps(sShowSystemApps);
        checkBox.setOnCheckedChangeListener(new Chip$$ExternalSyntheticLambda0(3, appsListView));
        zzbv zzbvVar = new zzbv(this.mActivity);
        zzbvVar.setTitle(this.mTitleRes);
        ((AlertController.AlertParams) zzbvVar.zza).mView = inflate;
        final AlertDialog create = zzbvVar.create();
        create.setCanceledOnTouchOutside(true);
        appsListView.setSelectedAppListener(new AppsListView.OnSelectedAppListener() { // from class: com.emanuelef.remote_capture.views.AppSelectDialog$$ExternalSyntheticLambda1
            @Override // com.emanuelef.remote_capture.views.AppsListView.OnSelectedAppListener
            public final void onSelectedApp(AppDescriptor appDescriptor) {
                AppSelectDialog.this.lambda$getDialog$3(create, appDescriptor);
            }
        });
        return create;
    }

    public static /* synthetic */ void lambda$getDialog$2(AppsListView appsListView, CompoundButton compoundButton, boolean z) {
        sShowSystemApps = z;
        appsListView.setShowSystemApps(z);
    }

    public /* synthetic */ void lambda$getDialog$3(AlertDialog alertDialog, AppDescriptor appDescriptor) {
        AppSelectListener appSelectListener = this.mListener;
        if (appSelectListener != null) {
            appSelectListener.onSelectedApp(appDescriptor);
        }
        alertDialog.dismiss();
    }

    public /* synthetic */ void lambda$show$0(DialogInterface dialogInterface) {
        AppSelectListener appSelectListener = this.mListener;
        if (appSelectListener != null) {
            appSelectListener.onAppSelectionAborted();
        }
    }

    public /* synthetic */ void lambda$show$1(DialogInterface dialogInterface) {
        this.mOpenAppsList = null;
    }

    private void show() {
        Dialog dialog = getDialog();
        this.mDialog = dialog;
        dialog.setOnCancelListener(new AppSelectDialog$$ExternalSyntheticLambda2(0, this));
        this.mDialog.setOnDismissListener(new AppSelectDialog$$ExternalSyntheticLambda3(0, this));
        this.mDialog.show();
        this.mOpenAppsList = (AppsListView) this.mDialog.findViewById(R.id.apps_list);
        TextView textView = (TextView) this.mDialog.findViewById(R.id.no_apps);
        this.mEmptyAppsView = textView;
        textView.setText(R.string.loading_apps);
        this.mLoader = new AppsLoader(this.mActivity).setAppsLoadListener(this).loadAllApps();
    }

    public void abort() {
        this.mDialog.dismiss();
        this.mLoader.abort();
        this.mOpenAppsList = null;
        this.mActivity = null;
        this.mListener = null;
    }

    @Override // com.emanuelef.remote_capture.interfaces.AppsLoadListener
    public void onAppsInfoLoaded(List<AppDescriptor> list) {
        AppDescriptor appDescriptor;
        if (this.mOpenAppsList != null) {
            this.mEmptyAppsView.setText(R.string.no_apps);
            if (Prefs.isTLSDecryptionSetupDone(this.mPrefs)) {
                Iterator<AppDescriptor> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        appDescriptor = null;
                        break;
                    }
                    appDescriptor = it.next();
                    if (appDescriptor.getPackageName().equals(MitmAPI.PACKAGE_NAME)) {
                        break;
                    }
                }
                if (appDescriptor != null) {
                    list.remove(appDescriptor);
                }
            }
            Log.d(TAG, "loading " + list.size() + " apps in dialog, icons=" + list);
            this.mOpenAppsList.setApps(list);
        }
    }
}
