package com.emanuelef.remote_capture.activities;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.CaptureHelper;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.ConnectionsRegister;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.MitmAddon;
import com.emanuelef.remote_capture.MitmReceiver;
import com.emanuelef.remote_capture.PCAPdroid;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.VpnReconnectService;
import com.emanuelef.remote_capture.activities.prefs.SettingsActivity;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda2;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda3;
import com.emanuelef.remote_capture.fragments.DataViewContainerFragment;
import com.emanuelef.remote_capture.fragments.StatusFragment;
import com.emanuelef.remote_capture.interfaces.AppStateListener;
import com.emanuelef.remote_capture.model.AppState;
import com.emanuelef.remote_capture.model.Blocklist;
import com.emanuelef.remote_capture.model.Blocklist$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.model.CaptureSettings;
import com.emanuelef.remote_capture.model.CaptureStats;
import com.emanuelef.remote_capture.model.ListInfo;
import com.emanuelef.remote_capture.model.Prefs;
import com.emanuelef.remote_capture.views.AppSelectDialog$$ExternalSyntheticLambda2;
import com.google.android.gms.tasks.zzw;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static final String API_DOCS_URL = "https://github.com/emanuele-f/PCAPdroid/blob/master/docs/app_api.md";
    public static final String DOCS_URL = "https://emanuele-f.github.io/PCAPdroid";
    public static final String DONATE_URL = "https://emanuele-f.github.io/PCAPdroid/donate";
    public static final String FIREWALL_DOCS_URL = "https://emanuele-f.github.io/PCAPdroid/paid_features#51-firewall";
    public static final String GITHUB_PROJECT_URL = "https://github.com/emanuele-f/PCAPdroid";
    public static final String MALWARE_DETECTION_DOCS_URL = "https://emanuele-f.github.io/PCAPdroid/paid_features#52-malware-detection";
    public static final String PAID_FEATURES_URL = "https://emanuele-f.github.io/PCAPdroid/paid_features";
    public static final String PCAPNG_DOCS_URL = "https://emanuele-f.github.io/PCAPdroid/paid_features#53-pcapng-format";
    private static final int POS_CONNECTIONS = 1;
    private static final int POS_STATUS = 0;
    public static final String PRIVACY_POLICY_URL = "https://emanuele-f.github.io/PCAPdroid/privacy";
    private static final String TAG = "Main";
    public static final String TELEGRAM_GROUP_NAME = "PCAPdroid";
    public static final String TLS_DECRYPTION_DOCS_URL = "https://emanuele-f.github.io/PCAPdroid/tls_decryption";
    private static final int TOTAL_COUNT = 2;
    private CaptureHelper mCapHelper;
    private DrawerLayout mDrawer;
    private PlayBilling mIab;
    private File mKeylogFile;
    private AppStateListener mListener;
    private NavigationView mNavView;
    private ViewPager2 mPager;
    private ExecutorService mPcapExecutor;
    private AlertDialog mPcapLoadDialog;
    private Uri mPcapUri;
    private SharedPreferences mPrefs;
    private AppState mState;
    private boolean mWasStarted = false;
    private boolean mStartPressed = false;
    private boolean mDecEmptyRulesNoticeShown = false;
    private boolean mExtensionsNoticeShown = false;
    private boolean mOpenPcapDecrypt = false;
    private boolean mDecryptPcap = false;
    private final ActivityResultLauncher sslkeyfileExportLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new MainActivity$$ExternalSyntheticLambda1(this, 1));
    private final ActivityResultLauncher requestPermissionLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(2), new BaseActivity$$ExternalSyntheticLambda0(24));
    private final ActivityResultLauncher peerInfoLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new MainActivity$$ExternalSyntheticLambda1(this, 2));
    private final ActivityResultLauncher pcapFileOpenLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new MainActivity$$ExternalSyntheticLambda1(this, 3));
    private final ActivityResultLauncher keylogFileOpenLauncher = registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new MainActivity$$ExternalSyntheticLambda1(this, 4));

    /* loaded from: classes.dex */
    public static class MainStateAdapter extends FragmentStateAdapter {
        public MainStateAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i) {
            Log.d(MainActivity.TAG, "createFragment");
            if (i != 1) {
                return new StatusFragment();
            }
            return new DataViewContainerFragment();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 2;
        }

        public int getPageTitle(int i) {
            return i != 1 ? R.string.status : R.string.connections_view;
        }
    }

    private void checkDecryptionRulesNotice() {
        if (!this.mDecEmptyRulesNoticeShown && PCAPdroid.getInstance().getDecryptionList().isEmpty()) {
            zzbv zzbvVar = new zzbv(this);
            zzbvVar.setMessage(R.string.tls_decryption_no_rules_notice);
            zzbvVar.setPositiveButton(R.string.yes, new MainActivity$$ExternalSyntheticLambda3(this, 2));
            zzbvVar.setNegativeButton(R.string.no, new Blocklist$$ExternalSyntheticLambda0(6));
            zzbvVar.show();
            this.mDecEmptyRulesNoticeShown = true;
        }
    }

    private void checkLoadedPcap() {
        dismissPcapLoadDialog();
        if (!CaptureService.hasError()) {
            ConnectionsRegister connsRegister = CaptureService.getConnsRegister();
            if (connsRegister == null || connsRegister.getConnCount() <= 0 || CaptureService.hasSeenDumpExtensions() || this.mExtensionsNoticeShown) {
                Utils.showToastLong(this, R.string.pcap_load_success, new Object[0]);
            } else {
                zzbv zzbvVar = new zzbv(this);
                ((AlertController.AlertParams) zzbvVar.zza).mMessage = getString(R.string.pcapdroid_trailer_notice, getString(R.string.unknown_app), getString(R.string.dump_extensions));
                zzbvVar.setPositiveButton(R.string.ok, new MainActivity$$ExternalSyntheticLambda3(this, 7));
                zzbvVar.show();
            }
            this.mPager.setCurrentItem(1);
        }
    }

    public void checkPaidDrawerEntries() {
        NavigationView navigationView = this.mNavView;
        if (navigationView != null) {
            Menu menu = navigationView.getMenu();
            menu.findItem(R.id.malware_detection).setVisible(Prefs.isMalwareDetectionEnabled(this, this.mPrefs));
            menu.findItem(R.id.firewall).setVisible(this.mIab.isFirewallVisible());
        }
    }

    private void checkPermissions() {
        int i = Build.VERSION.SDK_INT;
        if (i < 29 && i >= 23 && checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            try {
                this.requestPermissionLauncher.launch("android.permission.WRITE_EXTERNAL_STORAGE");
            } catch (ActivityNotFoundException unused) {
                Utils.showToastLong(this, R.string.no_intent_handler_found, new Object[0]);
            }
        }
        if (Build.VERSION.SDK_INT >= 33 && checkSelfPermission("android.permission.POST_NOTIFICATIONS") != 0) {
            if (shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                zzbv zzbvVar = new zzbv(this);
                zzbvVar.setMessage(R.string.notifications_notice);
                zzbvVar.setPositiveButton(R.string.ok, new MainActivity$$ExternalSyntheticLambda3(this, 0));
                zzbvVar.show().setCanceledOnTouchOutside(false);
                return;
            }
            requestNotificationPermission();
        }
    }

    public void checkPurchasesAvailable() {
        if (this.mIab.isAvailable("malware_detection")) {
            ((NavigationView) findViewById(R.id.nav_view)).getMenu().findItem(R.id.paid_features).setVisible(true);
        }
    }

    private void checkVpnLockdownNotice() {
        if (!Prefs.lockdownVpnNoticeShown(this.mPrefs) && Prefs.isFirewallEnabled(this, this.mPrefs) && !CaptureService.isLockdownVPN()) {
            zzbv zzbvVar = new zzbv(this);
            zzbvVar.setMessage(R.string.vpn_lockdown_notice);
            zzbvVar.setPositiveButton(R.string.yes, new MainActivity$$ExternalSyntheticLambda3(this, 1));
            zzbvVar.setNegativeButton(R.string.no, new Blocklist$$ExternalSyntheticLambda0(4));
            zzbvVar.show().setCanceledOnTouchOutside(false);
            Prefs.setLockdownVpnNoticeShown(this.mPrefs);
        }
    }

    /* renamed from: continueOpenPcap */
    public void lambda$startOpenPcap$26(String str, Uri uri) {
        getKeylogPath().delete();
        if (this.mOpenPcapDecrypt) {
            loadKeylogfile(str, uri);
        } else {
            doStartCaptureService(str);
        }
    }

    private void deletePcapFile(Uri uri) {
        boolean z;
        String uriToFilePath = Utils.uriToFilePath(this, uri);
        if (uriToFilePath != null) {
            Log.d(TAG, "deletePcapFile: path=".concat(uriToFilePath));
            try {
                z = new File(uriToFilePath).delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.d(TAG, "deletePcapFile: uri=" + uri);
            try {
                if (getContentResolver().delete(uri, null, null) == 1) {
                    z = true;
                }
            } catch (SecurityException | UnsupportedOperationException e2) {
                e2.printStackTrace();
            }
            z = false;
        }
        if (!z) {
            Utils.showToast(this, R.string.delete_error, new Object[0]);
        }
    }

    private void dismissPcapLoadDialog() {
        AlertDialog alertDialog = this.mPcapLoadDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.mPcapLoadDialog = null;
        }
        this.mPcapExecutor = null;
        this.mPcapUri = null;
    }

    private void doStartCaptureService(String str) {
        if (this.mCapHelper == null) {
            Log.e(TAG, "Activity destroyed, capture cannot start");
            return;
        }
        appStateStarting();
        if (str == null) {
            PCAPdroid.getInstance().setLoadedPcapBasename(null);
        }
        PCAPdroid.getInstance().setIsDecryptingPcap(this.mDecryptPcap);
        this.mDecryptPcap = false;
        CaptureSettings captureSettings = new CaptureSettings(this, this.mPrefs);
        captureSettings.input_pcap_path = str;
        if (PCAPdroid.getInstance().isDecryptingPcap()) {
            captureSettings.full_payload = true;
        }
        this.mCapHelper.startCapture(captureSettings);
    }

    private File getKeylogPath() {
        return new File(getCacheDir() + "/sslkeylog.txt");
    }

    private File getTmpPcapPath() {
        return new File(getCacheDir() + "/tmp.pcap");
    }

    private void initAppState() {
        if (!CaptureService.isServiceActive()) {
            appStateReady();
            File keylogFilePath = MitmReceiver.getKeylogFilePath(this);
            this.mKeylogFile = keylogFilePath;
            if (keylogFilePath.exists()) {
                startExportSslkeylogfile();
                return;
            }
            return;
        }
        appStateRunning();
    }

    private void initPeerAppInfo() {
    }

    public void keylogFileOpenResult(ActivityResult activityResult) {
        Intent intent;
        Uri data;
        if (activityResult.mResultCode == -1 && (intent = activityResult.mData) != null && (data = intent.getData()) != null) {
            Log.d(TAG, "keylogFileOpenResult: " + data);
            startOpenPcap(this.mPcapUri, data);
        }
    }

    public static /* synthetic */ void lambda$checkDecryptionRulesNotice$10(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$checkDecryptionRulesNotice$9(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this, EditListActivity.class);
        intent.putExtra(EditListActivity.LIST_TYPE_EXTRA, ListInfo.Type.DECRYPTION_LIST);
        startActivity(intent);
    }

    public /* synthetic */ void lambda$checkLoadedPcap$11(DialogInterface dialogInterface, int i) {
        this.mExtensionsNoticeShown = true;
    }

    public /* synthetic */ void lambda$checkPermissions$6(DialogInterface dialogInterface, int i) {
        requestNotificationPermission();
    }

    public /* synthetic */ void lambda$checkVpnLockdownNotice$12(DialogInterface dialogInterface, int i) {
        Utils.startActivity(this, new Intent("android.net.vpn.SETTINGS"));
    }

    public static /* synthetic */ void lambda$checkVpnLockdownNotice$13(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$loadKeylogfile$28() {
        Utils.showToastLong(this, R.string.keylog_read_error, new Object[0]);
        dismissPcapLoadDialog();
    }

    public /* synthetic */ void lambda$loadKeylogfile$29(String str) {
        this.mDecryptPcap = true;
        doStartCaptureService(str);
    }

    public /* synthetic */ void lambda$loadKeylogfile$30(boolean z, File file, String str) {
        if (!z || !file.exists()) {
            Utils.showToastLong(this, R.string.keylog_read_error, new Object[0]);
            dismissPcapLoadDialog();
            return;
        }
        this.mDecryptPcap = true;
        doStartCaptureService(str);
    }

    public /* synthetic */ void lambda$loadKeylogfile$31(Uri uri, final String str) {
        final File keylogPath = getKeylogPath();
        keylogPath.deleteOnExit();
        if (uri != null) {
            try {
                InputStream openInputStream = getContentResolver().openInputStream(uri);
                Utils.copy(openInputStream, keylogPath);
                if (openInputStream != null) {
                    openInputStream.close();
                }
                runOnUiThread(new AboutActivity$$ExternalSyntheticLambda0(this, str, 3));
            } catch (IOException | RuntimeException e) {
                e.printStackTrace();
                runOnUiThread(new MainActivity$$ExternalSyntheticLambda0(this, 2));
            }
        } else {
            final boolean extractKeylogFromPcapng = CaptureService.extractKeylogFromPcapng(str, keylogPath.getAbsolutePath());
            runOnUiThread(new Runnable() { // from class: com.emanuelef.remote_capture.activities.MainActivity$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.lambda$loadKeylogfile$30(extractKeylogFromPcapng, keylogPath, str);
                }
            });
        }
    }

    public static /* synthetic */ void lambda$new$0(Boolean bool) {
        String str;
        if (bool.booleanValue()) {
            str = "granted";
        } else {
            str = "denied";
        }
        Log.d(TAG, "Write permission ".concat(str));
    }

    public /* synthetic */ void lambda$onCreate$1(boolean z) {
        if (!z) {
            Log.w(TAG, "Capture start failed");
            appStateReady();
        }
    }

    public /* synthetic */ void lambda$onCreate$2(CaptureService.ServiceStatus serviceStatus) {
        Log.d(TAG, "Service status: " + serviceStatus.name());
        boolean z = true;
        if (serviceStatus == CaptureService.ServiceStatus.STARTED) {
            appStateRunning();
            this.mWasStarted = true;
        } else if (this.mWasStarted) {
            if (CaptureService.isServiceActive()) {
                CaptureService.stopService();
            }
            File keylogFilePath = MitmReceiver.getKeylogFilePath(this);
            this.mKeylogFile = keylogFilePath;
            if (!keylogFilePath.exists() || !CaptureService.isDecryptingTLS()) {
                this.mKeylogFile = null;
            }
            StringBuilder sb = new StringBuilder("sslkeylog? ");
            if (this.mKeylogFile == null) {
                z = false;
            }
            sb.append(z);
            Log.d(TAG, sb.toString());
            CaptureSettings captureSettings = CaptureService.getCaptureSettings();
            if (captureSettings != null && captureSettings.api_capture) {
                if (this.mKeylogFile != null) {
                    String str = captureSettings.sslkeylog_name;
                    int length = str.length();
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        int codePointAt = str.codePointAt(i);
                        if (!Character.isWhitespace(codePointAt)) {
                            Uri downloadsUri = Utils.getDownloadsUri(this, captureSettings.sslkeylog_name);
                            if (downloadsUri != null) {
                                try {
                                    OutputStream openOutputStream = getContentResolver().openOutputStream(downloadsUri, "rwt");
                                    Utils.copy(this.mKeylogFile, openOutputStream);
                                    Utils.showToast(this, R.string.save_ok, new Object[0]);
                                    if (openOutputStream != null) {
                                        openOutputStream.close();
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    Utils.showToastLong(this, R.string.export_failed, new Object[0]);
                                }
                            } else {
                                Log.e(TAG, "Cannot export keylog to " + captureSettings.sslkeylog_name);
                            }
                        } else {
                            i += Character.charCount(codePointAt);
                        }
                    }
                    this.mKeylogFile.delete();
                    this.mKeylogFile = null;
                }
                String str2 = captureSettings.decryption_rules_json;
                int length2 = str2.length();
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        break;
                    }
                    int codePointAt2 = str2.codePointAt(i2);
                    if (!Character.isWhitespace(codePointAt2)) {
                        PCAPdroid.getInstance().getDecryptionList().reload();
                        break;
                    }
                    i2 += Character.charCount(codePointAt2);
                }
            } else if (Prefs.getDumpMode(this.mPrefs) == Prefs.DumpMode.PCAP_FILE) {
                showPcapActionDialog();
            } else if (this.mKeylogFile != null) {
                startExportSslkeylogfile();
            }
            appStateReady();
            this.mWasStarted = false;
            this.mStartPressed = false;
        } else {
            appStateReady();
        }
    }

    public static WindowInsetsCompat lambda$setupNavigationDrawer$3(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.mImpl.getInsets(135);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i = insets.left;
        marginLayoutParams.leftMargin = i;
        int i2 = insets.right;
        marginLayoutParams.rightMargin = i2;
        return windowInsetsCompat.mImpl.inset(i, 0, i2, 0);
    }

    public /* synthetic */ void lambda$setupNavigationDrawer$4(String str, View view) {
        int indexOf = str.indexOf(45);
        if (indexOf != -1) {
            str = str.substring(indexOf + 1);
        }
        Utils.startActivity(this, new Intent("android.intent.action.VIEW", Uri.parse("https://github.com/emanuele-f/PCAPdroid/tree/" + str)));
    }

    public /* synthetic */ void lambda$setupTabs$7(MainStateAdapter mainStateAdapter, TabLayout.Tab tab, int i) {
        tab.setText(getString(mainStateAdapter.getPageTitle(i)));
    }

    public /* synthetic */ void lambda$setupTabs$8(View view) {
        if (this.mPager.getCurrentItem() != 1) {
            this.mPager.setCurrentItem(1);
            this.mPager.post(new MainActivity$$ExternalSyntheticLambda0(this, 0));
            return;
        }
        toggleDataView();
    }

    public /* synthetic */ void lambda$showPcapActionDialog$19(Uri uri, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/cap");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setClipData(ClipData.newRawUri("", uri));
        intent.setFlags(1);
        Utils.startActivity(this, Intent.createChooser(intent, getResources().getString(R.string.share)));
    }

    public /* synthetic */ void lambda$showPcapActionDialog$20(Uri uri, DialogInterface dialogInterface, int i) {
        deletePcapFile(uri);
    }

    public static /* synthetic */ void lambda$showPcapActionDialog$21(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$showPcapActionDialog$22(DialogInterface dialogInterface) {
        if (this.mKeylogFile != null) {
            startExportSslkeylogfile();
        }
    }

    public /* synthetic */ void lambda$showRemoteServerAlert$18(DialogInterface dialogInterface, int i) {
        this.mPrefs.edit().putBoolean(Prefs.PREF_REMOTE_COLLECTOR_ACK, true).apply();
    }

    public static /* synthetic */ void lambda$showWhatsNew$5(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$startCapture$14(DialogInterface dialogInterface, int i) {
        startActivity(new Intent(this, MitmSetupWizard.class));
    }

    public /* synthetic */ void lambda$startCapture$15(DialogInterface dialogInterface, int i) {
        MitmAddon.ignoreNewVersion(this);
        startCapture();
    }

    public /* synthetic */ void lambda$startCapture$16(DialogInterface dialogInterface, int i) {
        doStartCaptureService(null);
    }

    public static /* synthetic */ void lambda$startCapture$17(DialogInterface dialogInterface, int i) {
    }

    public /* synthetic */ void lambda$startOpenPcap$23(DialogInterface dialogInterface) {
        Log.i(TAG, "Abort PCAP loading");
        ExecutorService executorService = this.mPcapExecutor;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mPcapExecutor = null;
        }
        if (CaptureService.isServiceActive()) {
            CaptureService.stopService();
        }
        Utils.showToastLong(this, R.string.pcap_file_load_aborted, new Object[0]);
    }

    public /* synthetic */ void lambda$startOpenPcap$24(DialogInterface dialogInterface) {
        this.mPcapLoadDialog = null;
    }

    public /* synthetic */ void lambda$startOpenPcap$25() {
        Utils.showToastLong(this, R.string.copy_error, new Object[0]);
        dismissPcapLoadDialog();
    }

    public /* synthetic */ void lambda$startOpenPcap$27(Uri uri, File file, String str, Uri uri2) {
        try {
            InputStream openInputStream = getContentResolver().openInputStream(uri);
            Utils.copy(openInputStream, file);
            if (openInputStream != null) {
                openInputStream.close();
            }
            runOnUiThread(new MainActivity$$ExternalSyntheticLambda16(this, str, uri2));
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
            runOnUiThread(new MainActivity$$ExternalSyntheticLambda0(this, 1));
        }
    }

    private void loadKeylogfile(String str, Uri uri) {
        this.mPcapExecutor.execute(new MainActivity$$ExternalSyntheticLambda16(this, uri, str));
    }

    private void notifyAppState() {
        AppStateListener appStateListener = this.mListener;
        if (appStateListener != null) {
            appStateListener.appStateChanged(this.mState);
        }
    }

    private void openTelegram() {
        Intent intent;
        try {
            Utils.getPackageInfo(getPackageManager(), "org.telegram.messenger", 0);
            intent = new Intent("android.intent.action.VIEW", Uri.parse("tg://resolve?domain=PCAPdroid"));
        } catch (Exception unused) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("http://t.me/PCAPdroid"));
        }
        Utils.startActivity(this, intent);
    }

    public void pcapFileOpenResult(ActivityResult activityResult) {
        Intent intent;
        Uri data;
        if (activityResult.mResultCode == -1 && (intent = activityResult.mData) != null && (data = intent.getData()) != null) {
            Log.d(TAG, "pcapFileOpenResult: " + data);
            if (!this.mOpenPcapDecrypt || Utils.isPcapng(this, data)) {
                startOpenPcap(data, null);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.addCategory("android.intent.category.OPENABLE");
            intent2.setType("*/*");
            Log.i(TAG, "separate keylog file needed, launching dialog");
            this.mPcapUri = data;
            Utils.showToast(this, R.string.select_the_keylog_file, new Object[0]);
            Utils.launchFileDialog(this, intent2, this.keylogFileOpenLauncher);
        }
    }

    public void peerInfoResult(ActivityResult activityResult) {
        Intent intent;
        if (activityResult.mResultCode == -1 && (intent = activityResult.mData) != null) {
            try {
                HashSet hashSet = (HashSet) Utils.getSerializableExtra(intent, "skus", HashSet.class);
                if (hashSet != null) {
                    Log.d(TAG, "Found peer app info");
                    this.mIab.handlePeerSkus(hashSet);
                    return;
                }
            } catch (ClassCastException unused) {
            }
        }
        Log.d(TAG, "Invalid peer app result");
        this.mIab.clearPeerSkus();
    }

    private void requestNotificationPermission() {
        try {
            this.requestPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
        } catch (ActivityNotFoundException unused) {
            Utils.showToastLong(this, R.string.no_intent_handler_found, new Object[0]);
        }
    }

    private void selectOpenPcapFile(boolean z) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        Log.d(TAG, "selectOpenPcapFile: launching dialog");
        this.mOpenPcapDecrypt = z;
        if (z) {
            Utils.showToast(this, R.string.select_the_pcap_file, new Object[0]);
        }
        Utils.launchFileDialog(this, intent, this.pcapFileOpenLauncher);
    }

    private void setupNavigationDrawer() {
        boolean z;
        boolean z2;
        int i;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.mDrawer = drawerLayout;
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar);
        this.mDrawer.addDrawerListener(actionBarDrawerToggle);
        DrawerLayout drawerLayout2 = actionBarDrawerToggle.mDrawerLayout;
        View findDrawerWithGravity = drawerLayout2.findDrawerWithGravity(8388611);
        if (findDrawerWithGravity != null) {
            z = DrawerLayout.isDrawerOpen(findDrawerWithGravity);
        } else {
            z = false;
        }
        if (z) {
            actionBarDrawerToggle.setPosition(1.0f);
        } else {
            actionBarDrawerToggle.setPosition(0.0f);
        }
        View findDrawerWithGravity2 = drawerLayout2.findDrawerWithGravity(8388611);
        if (findDrawerWithGravity2 != null) {
            z2 = DrawerLayout.isDrawerOpen(findDrawerWithGravity2);
        } else {
            z2 = false;
        }
        if (z2) {
            i = actionBarDrawerToggle.mCloseDrawerContentDescRes;
        } else {
            i = actionBarDrawerToggle.mOpenDrawerContentDescRes;
        }
        boolean z3 = actionBarDrawerToggle.mWarnedForDisplayHomeAsUp;
        ActionBarDrawerToggle.Delegate delegate = actionBarDrawerToggle.mActivityImpl;
        if (!z3 && !delegate.isNavigationVisible()) {
            android.util.Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
            actionBarDrawerToggle.mWarnedForDisplayHomeAsUp = true;
        }
        delegate.setActionBarUpIndicator(actionBarDrawerToggle.mSlider, i);
        DrawerLayout drawerLayout3 = this.mDrawer;
        BaseActivity$$ExternalSyntheticLambda0 baseActivity$$ExternalSyntheticLambda0 = new BaseActivity$$ExternalSyntheticLambda0(25);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(drawerLayout3, baseActivity$$ExternalSyntheticLambda0);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        this.mNavView = navigationView;
        navigationView.setNavigationItemSelectedListener(this);
        TextView textView = (TextView) this.mNavView.presenter.headerLayout.getChildAt(0).findViewById(R.id.app_version);
        String appVersion = Utils.getAppVersion(this);
        textView.setText(appVersion);
        textView.setOnClickListener(new MainActivity$$ExternalSyntheticLambda5(this, appVersion, 0));
        this.mNavView.getMenu().findItem(R.id.action_donate).setVisible(false);
        checkPurchasesAvailable();
    }

    private void setupTabs() {
        MainStateAdapter mainStateAdapter = new MainStateAdapter(this);
        this.mPager.setAdapter(mainStateAdapter);
        new zzw((TabLayout) findViewById(R.id.tablayout), this.mPager, new CaptureCtrl$$ExternalSyntheticLambda0(this, mainStateAdapter, 2)).attach();
        View findViewById = findViewById(R.id.tab_switch_button);
        if (findViewById != null) {
            findViewById.setOnClickListener(new AppsFragment$$ExternalSyntheticLambda2(2, this));
        }
    }

    private boolean showRemoteServerAlert() {
        if (this.mPrefs.getBoolean(Prefs.PREF_REMOTE_COLLECTOR_ACK, false) || (((Prefs.getDumpMode(this.mPrefs) != Prefs.DumpMode.UDP_EXPORTER && Prefs.getDumpMode(this.mPrefs) != Prefs.DumpMode.TCP_EXPORTER) || Utils.isLocalNetworkAddress(Prefs.getCollectorIp(this.mPrefs))) && (!Prefs.getSocks5Enabled(this.mPrefs) || Utils.isLocalNetworkAddress(Prefs.getSocks5ProxyHost(this.mPrefs))))) {
            return false;
        }
        Log.i(TAG, "Showing possible scan notice");
        zzbv zzbvVar = new zzbv(this);
        zzbvVar.setTitle(R.string.warning);
        zzbvVar.setMessage(R.string.remote_collector_notice);
        zzbvVar.setPositiveButton(R.string.ok, new MainActivity$$ExternalSyntheticLambda3(this, 6));
        zzbvVar.show().setCanceledOnTouchOutside(false);
        return true;
    }

    private void showWhatsNew() {
        zzbv zzbvVar = new zzbv(this);
        zzbvVar.setTitle(R.string.whats_new);
        ((AlertController.AlertParams) zzbvVar.zza).mMessage = "- New HTTP requests view\n- Export HTTP data in the HAR format\n- Add Portuguese (BR) translation\n- Support the zstd compression\n- Pretty-print JSON in HTTP data\n- Fix HTTP/2 and WebSocket handling\n";
        zzbvVar.setNeutralButton(R.string.ok, new Blocklist$$ExternalSyntheticLambda0(5));
        zzbvVar.show();
    }

    public void sslkeyfileExportResult(ActivityResult activityResult) {
        int i = activityResult.mResultCode;
        Intent intent = activityResult.mData;
        if (!(i != -1 || intent == null || this.mKeylogFile == null)) {
            try {
                OutputStream openOutputStream = getContentResolver().openOutputStream(intent.getData(), "rwt");
                Utils.copy(this.mKeylogFile, openOutputStream);
                Utils.showToast(this, R.string.save_ok, new Object[0]);
                if (openOutputStream != null) {
                    openOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Utils.showToastLong(this, R.string.export_failed, new Object[0]);
            }
        }
        File file = this.mKeylogFile;
        if (file != null) {
            file.delete();
            this.mKeylogFile = null;
        }
    }

    private void startExportSslkeylogfile() {
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.TITLE", "sslkeylogfile.txt");
        Log.d(TAG, "startExportSslkeylogfile: launching dialog");
        Utils.launchFileDialog(this, intent, this.sslkeyfileExportLauncher);
    }

    private void startOpenPcap(Uri uri, Uri uri2) {
        String str;
        Utils.UriStat uriStat = Utils.getUriStat(this, uri);
        if (uriStat == null || (str = uriStat.name) == null) {
            PCAPdroid.getInstance().setLoadedPcapBasename(null);
        } else {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf > 0) {
                str = str.substring(0, lastIndexOf);
            }
            PCAPdroid.getInstance().setLoadedPcapBasename(str);
        }
        this.mPcapExecutor = Executors.newSingleThreadExecutor();
        zzbv zzbvVar = new zzbv(this);
        zzbvVar.setTitle(R.string.loading);
        zzbvVar.setMessage(R.string.pcap_load_in_progress);
        AlertDialog create = zzbvVar.create();
        this.mPcapLoadDialog = create;
        create.setCanceledOnTouchOutside(false);
        this.mPcapLoadDialog.setOnCancelListener(new AppSelectDialog$$ExternalSyntheticLambda2(1, this));
        this.mPcapLoadDialog.setOnDismissListener(new MainActivity$$ExternalSyntheticLambda7(this, 0));
        this.mPcapLoadDialog.show();
        String uriToFilePath = Utils.uriToFilePath(this, uri);
        if (uriToFilePath == null || !Utils.isReadable(uriToFilePath)) {
            File tmpPcapPath = getTmpPcapPath();
            tmpPcapPath.deleteOnExit();
            this.mPcapExecutor.execute(new MainActivity$$ExternalSyntheticLambda8(this, uri, tmpPcapPath, tmpPcapPath.getAbsolutePath(), uri2));
            return;
        }
        Log.d(TAG, "pcapFileOpenResult: path: ".concat(uriToFilePath));
        lambda$startOpenPcap$26(uriToFilePath, uri2);
    }

    public void toggleDataView() {
        Fragment fragmentAtPos = getFragmentAtPos(1);
        if (fragmentAtPos instanceof DataViewContainerFragment) {
            ((DataViewContainerFragment) fragmentAtPos).toggleView();
        }
    }

    private void updateTabSwitchButton() {
        int i;
        View findViewById = findViewById(R.id.tab_switch_button);
        if (findViewById != null) {
            if (CaptureService.getHttpLog() != null) {
                i = 0;
            } else {
                i = 8;
            }
            findViewById.setVisibility(i);
        }
    }

    public void appStateReady() {
        this.mState = AppState.ready;
        notifyAppState();
        updateTabSwitchButton();
        if (this.mPcapLoadDialog != null) {
            checkLoadedPcap();
        }
    }

    public void appStateRunning() {
        this.mState = AppState.running;
        notifyAppState();
        updateTabSwitchButton();
        if (Build.VERSION.SDK_INT >= 29) {
            checkVpnLockdownNotice();
        } else if (this.mStartPressed && CaptureService.isDecryptingTLS() && !CaptureService.isCapturingAsRoot()) {
            checkDecryptionRulesNotice();
        }
        if (this.mIab.isFirewallVisible()) {
            Blocklist blocklist = PCAPdroid.getInstance().getBlocklist();
            if (blocklist.hasCountryRules()) {
                blocklist.showNoticeIfGeoMissing(this);
            }
        }
    }

    public void appStateStarting() {
        this.mState = AppState.starting;
        notifyAppState();
    }

    public void appStateStopping() {
        this.mState = AppState.stopping;
        notifyAppState();
    }

    public AppState getState() {
        return this.mState;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean z;
        Fragment fragmentAtPos;
        View findDrawerWithGravity = this.mDrawer.findDrawerWithGravity(8388611);
        if (findDrawerWithGravity != null) {
            z = DrawerLayout.isDrawerOpen(findDrawerWithGravity);
        } else {
            z = false;
        }
        if (z) {
            this.mDrawer.closeDrawer$2();
        } else if (this.mPager.getCurrentItem() != 1 || (fragmentAtPos = getFragmentAtPos(1)) == null || !(fragmentAtPos instanceof DataViewContainerFragment) || !((DataViewContainerFragment) fragmentAtPos).onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(bundle);
        setContentView(R.layout.main_activity);
        setTitle(TELEGRAM_GROUP_NAME);
        SharedPreferences sharedPreferences = getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0);
        this.mPrefs = sharedPreferences;
        int appVersion = Prefs.getAppVersion(sharedPreferences);
        if (appVersion <= 0) {
            startActivity(new Intent(this, OnBoardingActivity.class));
            finish();
            return;
        }
        if (appVersion < 90) {
            showWhatsNew();
        }
        Prefs.refreshAppVersion(this.mPrefs);
        PlayBilling playBilling = new PlayBilling(this);
        this.mIab = playBilling;
        playBilling.setPurchaseReadyListener(new PlayBilling.PurchaseReadyListener() { // from class: com.emanuelef.remote_capture.activities.MainActivity.1
            {
                MainActivity.this = this;
            }

            @Override // com.emanuelef.remote_capture.PlayBilling.PurchaseReadyListener
            public final /* synthetic */ void onPurchasesError() {
                PlayBilling.PurchaseReadyListener.CC.$default$onPurchasesError(this);
            }

            @Override // com.emanuelef.remote_capture.PlayBilling.PurchaseReadyListener
            public void onPurchasesReady() {
                MainActivity.this.checkPurchasesAvailable();
                MainActivity.this.checkPaidDrawerEntries();
            }

            @Override // com.emanuelef.remote_capture.PlayBilling.PurchaseReadyListener
            public final /* synthetic */ void onSKUStateUpdate(String str, int i) {
                PlayBilling.PurchaseReadyListener.CC.$default$onSKUStateUpdate(this, str, i);
            }
        });
        initPeerAppInfo();
        initAppState();
        checkPermissions();
        CaptureHelper captureHelper = new CaptureHelper((ComponentActivity) this);
        this.mCapHelper = captureHelper;
        captureHelper.setListener(new MainActivity$$ExternalSyntheticLambda1(this, 0));
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.pager);
        this.mPager = viewPager2;
        Utils.fixViewPager2Insets(viewPager2);
        setupTabs();
        CaptureService.observeStatus(this, new AppsFragment$$ExternalSyntheticLambda3(1, this));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (!CaptureService.isServiceActive()) {
            getTmpPcapPath().delete();
        }
        this.mCapHelper = null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        View view;
        if (i == 20) {
            View currentFocus = getCurrentFocus();
            Log.d(TAG, "onKeyDown focus ".concat(currentFocus.getClass().getName()));
            if (currentFocus instanceof TabLayout.TabView) {
                int currentItem = this.mPager.getCurrentItem();
                Log.d(TAG, "TabLayout.TabView focus pos " + currentItem);
                if (currentItem == 0) {
                    view = findViewById(R.id.main_screen);
                } else if (currentItem == 1) {
                    view = findViewById(R.id.connections_view);
                } else {
                    view = null;
                }
                if (view != null) {
                    view.requestFocus();
                    return true;
                }
            }
        } else if (i == 22 && this.mPager.getCurrentItem() == 1) {
            RecyclerView recyclerView = (RecyclerView) findViewById(R.id.connections_view);
            if (recyclerView.getFocusedChild() != null) {
                Log.d(TAG, "onKeyDown (right) focus " + recyclerView.getFocusedChild());
                View findViewById = findViewById(R.id.fabDown);
                if (findViewById != null) {
                    findViewById.requestFocus();
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.item_apps) {
            if (CaptureService.getConnsRegister() != null) {
                startActivity(new Intent(this, AppsActivity.class));
            } else {
                Utils.showToast(this, R.string.start_capture_first, new Object[0]);
            }
        } else if (itemId == R.id.malware_detection) {
            startActivity(new Intent(this, MalwareDetection.class));
        } else if (itemId == R.id.tls_decryption) {
            Intent intent = new Intent(this, EditListActivity.class);
            intent.putExtra(EditListActivity.LIST_TYPE_EXTRA, ListInfo.Type.DECRYPTION_LIST);
            startActivity(intent);
        } else if (itemId == R.id.firewall) {
            startActivity(new Intent(this, FirewallActivity.class));
        } else if (itemId == R.id.open_log) {
            startActivity(new Intent(this, LogviewActivity.class));
        } else if (itemId == R.id.action_donate) {
            Utils.startActivity(this, new Intent("android.intent.action.VIEW", Uri.parse(DONATE_URL)));
        } else if (itemId == R.id.paid_features) {
            startActivity(new Intent(this, IABActivity.class));
        } else if (itemId == R.id.action_open_telegram) {
            openTelegram();
        } else if (itemId == R.id.action_open_user_guide) {
            Utils.startActivity(this, new Intent("android.intent.action.VIEW", Uri.parse(DOCS_URL)));
        } else if (itemId == R.id.action_stats) {
            if (this.mState == AppState.running) {
                startActivity(new Intent(this, StatsActivity.class));
            } else {
                Utils.showToast(this, R.string.start_capture_first, new Object[0]);
            }
        } else if (itemId == R.id.action_about) {
            startActivity(new Intent(this, AboutActivity.class));
        } else if (itemId == R.id.action_share_app) {
            String string = getString(R.string.about_text);
            String string2 = getString(R.string.get_app);
            Intent intent2 = new Intent("android.intent.action.SEND");
            intent2.setType("text/plain");
            intent2.putExtra("android.intent.extra.TEXT", string + "\n" + string2 + "\nhttps://play.google.com/store/apps/details?id=com.emanuelef.remote_capture");
            Utils.startActivity(this, Intent.createChooser(intent2, getResources().getString(R.string.share)));
        }
        return false;
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_start) {
            this.mStartPressed = true;
            startCapture();
            return true;
        } else if (itemId == R.id.action_stop) {
            stopCapture();
            return true;
        } else if (itemId == R.id.open_pcap) {
            selectOpenPcapFile(false);
            return true;
        } else if (itemId == R.id.decrypt_pcap) {
            selectOpenPcapFile(true);
            return true;
        } else if (itemId != R.id.action_settings) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIab.disconnectBilling();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        setupNavigationDrawer();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        boolean z;
        super.onResume();
        this.mIab.connectBilling();
        NavigationView navigationView = this.mNavView;
        if (navigationView != null) {
            MenuItem findItem = navigationView.getMenu().findItem(R.id.tls_decryption);
            if (!Prefs.getTlsDecryptionEnabled(this.mPrefs) || Prefs.isRootCaptureEnabled(this.mPrefs)) {
                z = false;
            } else {
                z = true;
            }
            findItem.setVisible(z);
        }
        checkPaidDrawerEntries();
    }

    public void setAppStateListener(AppStateListener appStateListener) {
        this.mListener = appStateListener;
    }

    public void showPcapActionDialog() {
        final Uri pcapUri;
        Log.d(TAG, "showPcapActionDialog called");
        if (!CaptureService.isUserDefinedPcapUri() && (pcapUri = CaptureService.getPcapUri()) != null) {
            CaptureStats stats = CaptureService.getStats();
            Log.d(TAG, "Pcap dump size is " + stats.pcap_dump_size);
            if (stats.pcap_dump_size <= 0) {
                deletePcapFile(pcapUri);
                return;
            }
            String pcapFname = CaptureService.getPcapFname();
            if (pcapFname == null) {
                pcapFname = "unknown";
            }
            String format = String.format(getResources().getString(R.string.pcap_file_action), pcapFname, Utils.formatBytes(stats.pcap_dump_size));
            zzbv zzbvVar = new zzbv(this);
            AlertController.AlertParams alertParams = (AlertController.AlertParams) zzbvVar.zza;
            alertParams.mMessage = format;
            zzbvVar.setPositiveButton(R.string.share, new DialogInterface.OnClickListener(this) { // from class: com.emanuelef.remote_capture.activities.MainActivity$$ExternalSyntheticLambda9
                public final /* synthetic */ MainActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    switch (r3) {
                        case 0:
                            this.f$0.lambda$showPcapActionDialog$19(pcapUri, dialogInterface, i);
                            return;
                        default:
                            this.f$0.lambda$showPcapActionDialog$20(pcapUri, dialogInterface, i);
                            return;
                    }
                }
            });
            zzbvVar.setNegativeButton(R.string.delete, new DialogInterface.OnClickListener(this) { // from class: com.emanuelef.remote_capture.activities.MainActivity$$ExternalSyntheticLambda9
                public final /* synthetic */ MainActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    switch (r3) {
                        case 0:
                            this.f$0.lambda$showPcapActionDialog$19(pcapUri, dialogInterface, i);
                            return;
                        default:
                            this.f$0.lambda$showPcapActionDialog$20(pcapUri, dialogInterface, i);
                            return;
                    }
                }
            });
            zzbvVar.setNeutralButton(R.string.ok, new Blocklist$$ExternalSyntheticLambda0(3));
            alertParams.mOnDismissListener = new MainActivity$$ExternalSyntheticLambda7(this, 1);
            AlertDialog create = zzbvVar.create();
            create.setCanceledOnTouchOutside(false);
            create.show();
        }
    }

    public void startCapture() {
        if (VpnReconnectService.isAvailable()) {
            VpnReconnectService.stopService();
        }
        if (!showRemoteServerAlert()) {
            if (Prefs.getTlsDecryptionEnabled(this.mPrefs)) {
                if (MitmAddon.needsSetup(this)) {
                    startActivity(new Intent(this, MitmSetupWizard.class));
                    return;
                } else if (!MitmAddon.getNewVersionAvailable(this).isEmpty()) {
                    zzbv zzbvVar = new zzbv(this);
                    zzbvVar.setTitle(R.string.update_available);
                    zzbvVar.setMessage(R.string.mitm_addon_update_available);
                    ((AlertController.AlertParams) zzbvVar.zza).mCancelable = false;
                    zzbvVar.setPositiveButton(R.string.update_action, new MainActivity$$ExternalSyntheticLambda3(this, 3));
                    zzbvVar.setNegativeButton(R.string.cancel_action, new MainActivity$$ExternalSyntheticLambda3(this, 4));
                    zzbvVar.show();
                    return;
                }
            }
            if (Prefs.isRootCaptureEnabled(this.mPrefs) || Utils.getRunningVpn(this) == null) {
                doStartCaptureService(null);
                return;
            }
            zzbv zzbvVar2 = new zzbv(this);
            zzbvVar2.setTitle(R.string.active_vpn_detected);
            zzbvVar2.setMessage(R.string.disconnect_vpn_confirm);
            zzbvVar2.setPositiveButton(R.string.ok, new MainActivity$$ExternalSyntheticLambda3(this, 5));
            zzbvVar2.setNegativeButton(R.string.cancel_action, new Blocklist$$ExternalSyntheticLambda0(7));
            zzbvVar2.show();
        }
    }

    public void stopCapture() {
        appStateStopping();
        CaptureService.stopService();
    }
}
