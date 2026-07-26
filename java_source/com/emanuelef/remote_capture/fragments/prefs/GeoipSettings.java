package com.emanuelef.remote_capture.fragments.prefs;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.preference.Preference;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.Geolocation;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.PlayBilling$$ExternalSyntheticLambda23;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.fragments.ConnectionsFragment$$ExternalSyntheticLambda6;
import com.emanuelef.remote_capture.views.AppSelectDialog$$ExternalSyntheticLambda2;
import com.emanuelef.remote_capture.views.AppSelectDialog$$ExternalSyntheticLambda3;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class GeoipSettings extends SettingsSubFragment {
    private static final String TAG = "GeoipSettings";
    private AlertDialog mAlertDialog;
    private Preference mDelete;
    private Preference mStatus;

    private void downloadDatabases() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        zzbv zzbvVar = new zzbv(requireContext());
        zzbvVar.setTitle(C0130R.string.downloading);
        zzbvVar.setMessage(C0130R.string.download_in_progress);
        AlertDialog create = zzbvVar.create();
        this.mAlertDialog = create;
        create.setCanceledOnTouchOutside(false);
        this.mAlertDialog.show();
        this.mAlertDialog.setOnCancelListener(new AppSelectDialog$$ExternalSyntheticLambda2(4, newSingleThreadExecutor));
        this.mAlertDialog.setOnDismissListener(new AppSelectDialog$$ExternalSyntheticLambda3(4, this));
        newSingleThreadExecutor.execute(new PlayBilling$$ExternalSyntheticLambda23(this, requireContext(), handler, 6));
    }

    public static /* synthetic */ void lambda$downloadDatabases$2(ExecutorService executorService, DialogInterface dialogInterface) {
        Log.m583i(TAG, "Abort download");
        executorService.shutdownNow();
    }

    public /* synthetic */ void lambda$downloadDatabases$3(DialogInterface dialogInterface) {
        this.mAlertDialog = null;
    }

    public /* synthetic */ void lambda$downloadDatabases$4(boolean z, Context context) {
        if (!z) {
            Utils.showToastLong(context, C0130R.string.download_failed, new Object[0]);
        }
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        refreshStatus(context);
    }

    public /* synthetic */ void lambda$downloadDatabases$5(Context context, Handler handler) {
        handler.post(new ConnectionsFragment$$ExternalSyntheticLambda6(2, this, context, Geolocation.downloadDb(context)));
    }

    public /* synthetic */ boolean lambda$onCreatePreferences$0(Context context, Preference preference) {
        Geolocation.deleteDb(context);
        refreshStatus(context);
        return true;
    }

    public /* synthetic */ boolean lambda$onCreatePreferences$1(Preference preference) {
        downloadDatabases();
        return true;
    }

    private void refreshStatus(Context context) {
        Date dbDate = Geolocation.getDbDate(context);
        boolean z = false;
        if (dbDate != null) {
            String formatEpochFull = Utils.formatEpochFull(context, dbDate.getTime() / 1000);
            Preference preference = this.mStatus;
            preference.setSummary("DB-IP Lite free\n" + String.format(context.getString(C0130R.string.built_on), formatEpochFull) + "\n" + String.format(context.getString(C0130R.string.size_x), Utils.formatBytes(Geolocation.getDbSize(context))));
            Preference preference2 = this.mStatus;
            if (!preference2.mEnabled) {
                preference2.mEnabled = true;
                preference2.notifyDependencyChange(preference2.shouldDisableDependents());
                preference2.notifyChanged();
            }
        } else {
            Preference preference3 = this.mStatus;
            preference3.setSummary(preference3.mContext.getString(C0130R.string.geo_db_not_found));
            Preference preference4 = this.mStatus;
            if (preference4.mEnabled) {
                preference4.mEnabled = false;
                preference4.notifyDependencyChange(preference4.shouldDisableDependents());
                preference4.notifyChanged();
            }
        }
        Preference preference5 = this.mDelete;
        if (dbDate != null) {
            z = true;
        }
        preference5.setVisible(z);
    }

    private <T extends Preference> T requirePreference(String str) {
        T t = (T) findPreference(str);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(C0130R.xml.geoip_preferences, str);
        Context requireContext = requireContext();
        this.mStatus = requirePreference("status");
        this.mDelete = requirePreference("delete");
        refreshStatus(requireContext);
        this.mDelete.mOnClickListener = new GeoipSettings$$ExternalSyntheticLambda3(this, 0, requireContext);
        requirePreference("download").mOnClickListener = new InputConnectionCompat$$ExternalSyntheticLambda0(8, this);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        AlertDialog alertDialog = this.mAlertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        super.onDestroyView();
    }
}
