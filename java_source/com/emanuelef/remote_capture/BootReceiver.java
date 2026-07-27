package com.emanuelef.remote_capture;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.VpnService;
import android.os.Build;
import androidx.core.content.ContextCompat$Api26Impl;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.model.CaptureSettings;
import com.emanuelef.remote_capture.model.Prefs;
/* loaded from: classes.dex */
public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = "BootReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String action = intent.getAction();
        Log.m587d(TAG, "onReceive: " + action);
        if (!action.equals("android.intent.action.BOOT_COMPLETED") && !action.equals("android.intent.action.QUICKBOOT_POWERON")) {
            Log.m581w(TAG, "Unexpected action: ".concat(action));
        } else if (Prefs.startAtBoot(defaultSharedPreferences)) {
            if (CaptureService.isServiceActive()) {
                Log.m583i(TAG, "Service already active, nothing to do");
                return;
            }
            CaptureSettings captureSettings = new CaptureSettings(context, defaultSharedPreferences);
            if (captureSettings.root_capture || VpnService.prepare(context) == null) {
                Log.m583i(TAG, "Starting capture service");
                Intent intent2 = new Intent(context, CaptureService.class);
                intent2.putExtra("settings", captureSettings);
                if (Build.VERSION.SDK_INT >= 26) {
                    ContextCompat$Api26Impl.startForegroundService(context, intent2);
                } else {
                    context.startService(intent2);
                }
            } else {
                Utils.showToastLong(context, C0130R.string.vpn_setup_failed, new Object[0]);
            }
        }
    }
}
