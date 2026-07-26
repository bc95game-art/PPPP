package com.emanuelef.remote_capture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationManagerCompat;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.Blocklist;
/* loaded from: classes.dex */
public class ActionReceiver extends BroadcastReceiver {
    public static final String EXTRA_UNBLOCK_APP = "unblock_app";
    private static final String TAG = "TAG";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_UNBLOCK_APP);
        if (stringExtra != null && !stringExtra.isEmpty()) {
            Log.d(TAG, "unblock_app: ".concat(stringExtra));
            Blocklist blocklist = PCAPdroid.getInstance().getBlocklist();
            blocklist.removeApp(stringExtra);
            blocklist.saveAndReload();
            new NotificationManagerCompat(context).mNotificationManager.cancel(null, 3);
            AppDescriptor resolveInstalledApp = AppsResolver.resolveInstalledApp(context.getPackageManager(), stringExtra, 0);
            if (resolveInstalledApp != null) {
                stringExtra = resolveInstalledApp.getName();
            }
            Utils.showToastLong(context, R.string.app_unblocked, stringExtra);
        }
    }
}
