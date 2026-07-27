package com.emanuelef.remote_capture.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.AppsResolver;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.BuildConfig;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureHelper;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.PersistableUriPermission;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.AppDescriptor;
import com.emanuelef.remote_capture.model.CaptureSettings;
import com.emanuelef.remote_capture.model.CaptureStats;
import com.emanuelef.remote_capture.model.CtrlPermissions;
import com.emanuelef.remote_capture.model.Prefs;
import java.util.HashSet;
/* loaded from: classes.dex */
public class CaptureCtrl extends AppCompatActivity {
    public static final String ACTION_NOTIFY_STATUS = "com.emanuelef.remote_capture.CaptureStatus";
    public static final String ACTION_PEER_INFO = "get_peer_info";
    public static final String ACTION_START = "start";
    public static final String ACTION_STATUS = "get_status";
    public static final String ACTION_STOP = "stop";
    private static final String TAG = "CaptureCtrl";
    private static String mReceiverClass;
    private static AppDescriptor mStarterApp;
    private CaptureHelper mCapHelper;
    private CtrlPermissions mPermissions;
    private PersistableUriPermission persistableUriPermission;

    private void abort(boolean z) {
        if (z) {
            Utils.showToast(this, C0130R.string.ctrl_consent_denied, new Object[0]);
        }
        setResult(0, null);
        finish();
    }

    private String checkRemoteServerNotAllowed(CaptureSettings captureSettings) {
        SharedPreferences sharedPreferences = getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0);
        Prefs.DumpMode dumpMode = captureSettings.dump_mode;
        if ((dumpMode == Prefs.DumpMode.UDP_EXPORTER || dumpMode == Prefs.DumpMode.TCP_EXPORTER) && !Utils.isLocalNetworkAddress(captureSettings.collector_address) && !Prefs.getCollectorIp(sharedPreferences).equals(captureSettings.collector_address)) {
            return captureSettings.collector_address;
        }
        if (!captureSettings.socks5_enabled || Utils.isLocalNetworkAddress(captureSettings.socks5_proxy_address) || Prefs.getSocks5ProxyHost(sharedPreferences).equals(captureSettings.socks5_proxy_address)) {
            return null;
        }
        return captureSettings.socks5_proxy_address;
    }

    private void controlAction(Intent intent, String str, boolean z) {
        String str2;
        CtrlPermissions.ConsentType consentType;
        AppDescriptor callingApp = getCallingApp();
        if (callingApp != null && ((RadioButton) findViewById(C0130R.C0132id.choice_forever)).isChecked()) {
            StringBuilder sb = new StringBuilder();
            if (z) {
                str2 = "Grant";
            } else {
                str2 = "Deny";
            }
            sb.append(str2);
            sb.append(" forever to ");
            sb.append(callingApp.getPackageName());
            Log.m587d(TAG, sb.toString());
            CtrlPermissions ctrlPermissions = this.mPermissions;
            String packageName = callingApp.getPackageName();
            if (z) {
                consentType = CtrlPermissions.ConsentType.ALLOW;
            } else {
                consentType = CtrlPermissions.ConsentType.DENY;
            }
            ctrlPermissions.add(packageName, consentType);
        }
        if (!z) {
            abort();
        } else {
            processRequest(intent, str);
        }
    }

    private AppDescriptor getCallingApp() {
        String callingPackage = getCallingPackage();
        if (callingPackage != null) {
            return AppsResolver.resolveInstalledApp(getPackageManager(), callingPackage, 0);
        }
        return null;
    }

    private void getPeerInfo() {
        String callingPackage = getCallingPackage();
        if (callingPackage == null || !callingPackage.equals("com.emanuelef.remote_capture.debug")) {
            Log.m581w(TAG, "getPeerInfo: package name mismatch");
            abort(false);
            return;
        }
        PlayBilling newInstance = Billing.newInstance(this);
        newInstance.setLicense(newInstance.getLicense());
        Intent intent = new Intent();
        HashSet hashSet = new HashSet();
        for (String str : Billing.ALL_SKUS) {
            if (newInstance.isPurchased(str)) {
                hashSet.add(str);
            }
        }
        intent.putExtra("skus", hashSet);
        setResult(-1, intent);
        finish();
    }

    private boolean isControlApp(String str) {
        AppDescriptor appDescriptor;
        if (str.equals(ACTION_START) || (appDescriptor = mStarterApp) == null || !appDescriptor.getPackageName().equals(getCallingPackage())) {
            return false;
        }
        return true;
    }

    public /* synthetic */ void lambda$onCreate$0(boolean z) {
        int i;
        if (z) {
            i = -1;
        } else {
            i = 0;
        }
        setResult(i, null);
        finish();
    }

    public /* synthetic */ void lambda$onCreate$1(Intent intent, String str, View view) {
        controlAction(intent, str, true);
    }

    public /* synthetic */ void lambda$onCreate$2(Intent intent, String str, View view) {
        controlAction(intent, str, false);
    }

    public /* synthetic */ void lambda$onCreate$3() {
        Button button = (Button) findViewById(C0130R.C0132id.allow_btn);
        button.setTextColor(-16737844);
        button.setEnabled(true);
    }

    public /* synthetic */ void lambda$processRequest$4(CaptureSettings captureSettings, Uri uri) {
        Log.m587d(TAG, "persistable uri granted? " + uri);
        if (uri != null) {
            captureSettings.pcap_uri = uri.toString();
            this.mCapHelper.startCapture(captureSettings);
            return;
        }
        abort();
    }

    public static void notifyCaptureStopped(Context context, CaptureStats captureStats) {
        if (captureStats != null) {
            Log.m587d(TAG, "notifyCaptureStopped: " + (captureStats.pkts_sent + captureStats.pkts_rcvd) + " pkts");
        }
        if (!(mStarterApp == null || mReceiverClass == null)) {
            Log.m587d(TAG, "Notifying receiver");
            Intent intent = new Intent(ACTION_NOTIFY_STATUS);
            intent.putExtra("running", false);
            if (captureStats != null) {
                putStats(intent, captureStats);
            }
            intent.setComponent(new ComponentName(mStarterApp.getPackageName(), mReceiverClass));
            try {
                context.sendBroadcast(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mStarterApp = null;
        mReceiverClass = null;
    }

    private void processRequest(Intent intent, String str) {
        Intent intent2 = new Intent();
        Utils.showToast(this, C0130R.string.ctrl_consent_allowed, new Object[0]);
        if (str.equals(ACTION_START)) {
            mStarterApp = getCallingApp();
            mReceiverClass = intent.getStringExtra("broadcast_receiver");
            Log.m587d(TAG, "Starting capture, caller=" + mStarterApp);
            CaptureSettings captureSettings = new CaptureSettings(this, intent);
            String checkRemoteServerNotAllowed = checkRemoteServerNotAllowed(captureSettings);
            if (checkRemoteServerNotAllowed != null) {
                Utils.showToastLong(this, C0130R.string.remote_server_warning, checkRemoteServerNotAllowed);
                abort();
                return;
            }
            PCAPdroid.getInstance().setIsDecryptingPcap(false);
            if (!captureSettings.pcap_uri.isEmpty()) {
                this.persistableUriPermission.checkPermission(captureSettings.pcap_uri, captureSettings.pcapng_format, new CaptureCtrl$$ExternalSyntheticLambda0(this, captureSettings, 0));
            } else {
                this.mCapHelper.startCapture(captureSettings);
            }
        } else {
            if (str.equals(ACTION_STOP)) {
                Log.m587d(TAG, "Stopping capture");
                CaptureService.stopService();
                mStarterApp = null;
                CaptureService.waitForCaptureStop();
                putStats(intent2, CaptureService.getStats());
            } else if (str.equals(ACTION_STATUS)) {
                Log.m587d(TAG, "Returning status");
                intent2.putExtra("running", CaptureService.isServiceActive());
                intent2.putExtra("version_name", BuildConfig.VERSION_NAME);
                intent2.putExtra("version_code", 91);
                putStats(intent2, CaptureService.getStats());
            } else {
                Log.m585e(TAG, "unknown action: ".concat(str));
                abort();
                return;
            }
            setResult(-1, intent2);
            finish();
        }
    }

    private static void putStats(Intent intent, CaptureStats captureStats) {
        intent.putExtra("bytes_sent", captureStats.bytes_sent);
        intent.putExtra("bytes_rcvd", captureStats.bytes_rcvd);
        intent.putExtra("ipv6_bytes_sent", captureStats.ipv6_bytes_sent);
        intent.putExtra("ipv6_bytes_rcvd", captureStats.ipv6_bytes_rcvd);
        intent.putExtra("bytes_dumped", captureStats.pcap_dump_size);
        intent.putExtra("pkts_sent", captureStats.pkts_sent);
        intent.putExtra("pkts_rcvd", captureStats.pkts_rcvd);
        intent.putExtra("pkts_dropped", captureStats.pkts_dropped);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        abort();
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        setContentView(C0130R.layout.ctrl_consent);
        this.persistableUriPermission = new PersistableUriPermission(this);
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.statusBars());
            }
        } else {
            getWindow().setFlags(1024, 1024);
        }
        getWindow().addFlags(3);
        super.onCreate(bundle);
        CaptureHelper captureHelper = new CaptureHelper((ComponentActivity) this);
        this.mCapHelper = captureHelper;
        captureHelper.setListener(new InputConnectionCompat$$ExternalSyntheticLambda0(1, this));
        final Intent intent = getIntent();
        final String stringExtra = intent.getStringExtra("action");
        String stringExtra2 = intent.getStringExtra(Prefs.PREF_API_KEY);
        if (stringExtra == null) {
            Log.m585e(TAG, "no action provided");
            abort();
        } else if (stringExtra.equals(ACTION_PEER_INFO)) {
            getPeerInfo();
        } else {
            if (stringExtra2 != null) {
                String apiKey = Prefs.getApiKey(getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0));
                if (!apiKey.isEmpty() && apiKey.equals(stringExtra2)) {
                    processRequest(intent, stringExtra);
                    return;
                }
            }
            this.mPermissions = PCAPdroid.getInstance().getCtrlPermissions();
            AppDescriptor callingApp = getCallingApp();
            if (callingApp != null) {
                CtrlPermissions.ConsentType consent = this.mPermissions.getConsent(callingApp.getPackageName());
                if (consent == CtrlPermissions.ConsentType.ALLOW) {
                    processRequest(intent, stringExtra);
                    return;
                } else if (consent == CtrlPermissions.ConsentType.DENY) {
                    abort();
                    return;
                }
            }
            if (isControlApp(stringExtra)) {
                processRequest(intent, stringExtra);
                return;
            }
            findViewById(C0130R.C0132id.allow_btn).setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.activities.CaptureCtrl$$ExternalSyntheticLambda2
                public final /* synthetic */ CaptureCtrl f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (r4) {
                        case 0:
                            this.f$0.lambda$onCreate$1(intent, stringExtra, view);
                            return;
                        default:
                            this.f$0.lambda$onCreate$2(intent, stringExtra, view);
                            return;
                    }
                }
            });
            findViewById(C0130R.C0132id.deny_btn).setOnClickListener(new View.OnClickListener(this) { // from class: com.emanuelef.remote_capture.activities.CaptureCtrl$$ExternalSyntheticLambda2
                public final /* synthetic */ CaptureCtrl f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (r4) {
                        case 0:
                            this.f$0.lambda$onCreate$1(intent, stringExtra, view);
                            return;
                        default:
                            this.f$0.lambda$onCreate$2(intent, stringExtra, view);
                            return;
                    }
                }
            });
            if (callingApp != null) {
                ((TextView) findViewById(C0130R.C0132id.app_name)).setText(callingApp.getName());
                ((TextView) findViewById(C0130R.C0132id.app_package)).setText(callingApp.getPackageName());
                ((ImageView) findViewById(C0130R.C0132id.app_icon)).setImageDrawable(callingApp.getIcon());
            } else {
                findViewById(C0130R.C0132id.caller_app).setVisibility(8);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new ActivityCompat$$ExternalSyntheticLambda0(7, this), 1500L);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mCapHelper = null;
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getWindow().setLayout(-1, -2);
    }

    private void abort() {
        abort(true);
    }
}
