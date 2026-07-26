package com.emanuelef.remote_capture;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import androidx.preference.PreferenceManager;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.config.CaocConfig;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.activities.ErrorActivity;
import com.emanuelef.remote_capture.model.Blocklist;
import com.emanuelef.remote_capture.model.CtrlPermissions;
import com.emanuelef.remote_capture.model.MatchList;
import com.emanuelef.remote_capture.model.Prefs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public class PCAPdroid extends Application {
    private static final String TAG = "PCAPdroid";
    protected static boolean isUnderTest = false;
    private static WeakReference<PCAPdroid> mInstance;
    private Blacklists mBlacklists;
    private Blocklist mBlocklist;
    private CtrlPermissions mCtrlPermissions;
    private MatchList mDecryptionList;
    private MatchList mFirewallWhitelist;
    private boolean mIsDecryptingPcap = false;
    private boolean mIsUsharkAvailable = false;
    private String mLoadedPcapBasename = null;
    private Context mLocalizedContext;
    private MatchList mMalwareWhitelist;
    private MatchList mVisMask;

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUidMapping(String str) {
        MatchList matchList = this.mVisMask;
        if (matchList != null) {
            matchList.uidMappingChanged(str);
        }
        MatchList matchList2 = this.mMalwareWhitelist;
        if (matchList2 != null && matchList2.uidMappingChanged(str)) {
            CaptureService.reloadMalwareWhitelist();
        }
        MatchList matchList3 = this.mFirewallWhitelist;
        if (matchList3 != null && matchList3.uidMappingChanged(str) && CaptureService.isServiceActive()) {
            CaptureService.requireInstance().reloadFirewallWhitelist();
        }
        MatchList matchList4 = this.mDecryptionList;
        if (matchList4 != null && matchList4.uidMappingChanged(str)) {
            CaptureService.reloadDecryptionList();
        }
        Blocklist blocklist = this.mBlocklist;
        if (blocklist != null && blocklist.uidMappingChanged(str) && CaptureService.isServiceActive()) {
            CaptureService.requireInstance().reloadBlocklist();
        }
    }

    public static PCAPdroid getInstance() {
        return mInstance.get();
    }

    private void initFirewallWhitelist() {
        this.mFirewallWhitelist.addApp(0);
        this.mFirewallWhitelist.addApp(1000);
        this.mFirewallWhitelist.addApp(getPackageName());
        this.mFirewallWhitelist.addApp("com.google.android.gms");
        this.mFirewallWhitelist.addApp("com.google.android.gsf");
        this.mFirewallWhitelist.addApp("com.google.android.ims");
        this.mFirewallWhitelist.addApp("com.sec.spp.push");
        this.mFirewallWhitelist.save();
    }

    public static boolean isUnderTest() {
        return isUnderTest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeUninstalledAppsFromAppFilter() {
        SharedPreferences sharedPreferences = getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0);
        Set<String> appFilter = Prefs.getAppFilter(sharedPreferences);
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = getPackageManager();
        for (String str : appFilter) {
            try {
                Utils.getPackageInfo(packageManager, str, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.m583i("PCAPdroid", "Package " + str + " uninstalled, removing from app filter");
                arrayList.add(str);
            }
        }
        if (!arrayList.isEmpty()) {
            appFilter.removeAll(arrayList);
            sharedPreferences.edit().putStringSet(Prefs.PREF_APP_FILTER, appFilter).apply();
        }
    }

    public Blacklists getBlacklists() {
        if (this.mBlacklists == null) {
            this.mBlacklists = new Blacklists(this.mLocalizedContext);
        }
        return this.mBlacklists;
    }

    public Blocklist getBlocklist() {
        if (this.mBlocklist == null) {
            this.mBlocklist = new Blocklist(this.mLocalizedContext);
        }
        return this.mBlocklist;
    }

    public CtrlPermissions getCtrlPermissions() {
        if (this.mCtrlPermissions == null) {
            this.mCtrlPermissions = new CtrlPermissions(this);
        }
        return this.mCtrlPermissions;
    }

    public MatchList getDecryptionList() {
        if (this.mDecryptionList == null) {
            this.mDecryptionList = new MatchList(this.mLocalizedContext, Prefs.PREF_DECRYPTION_LIST);
        }
        return this.mDecryptionList;
    }

    public MatchList getFirewallWhitelist() {
        if (this.mFirewallWhitelist == null) {
            SharedPreferences sharedPreferences = getSharedPreferences(PreferenceManager.getDefaultSharedPreferencesName(this), 0);
            this.mFirewallWhitelist = new MatchList(this.mLocalizedContext, Prefs.PREF_FIREWALL_WHITELIST);
            if (!Prefs.isFirewallWhitelistInitialized(sharedPreferences)) {
                initFirewallWhitelist();
                Prefs.setFirewallWhitelistInitialized(sharedPreferences);
            }
        }
        return this.mFirewallWhitelist;
    }

    public String getLoadedPcapBasename() {
        return this.mLoadedPcapBasename;
    }

    public MatchList getMalwareWhitelist() {
        if (this.mMalwareWhitelist == null) {
            this.mMalwareWhitelist = new MatchList(this.mLocalizedContext, Prefs.PREF_MALWARE_WHITELIST);
        }
        return this.mMalwareWhitelist;
    }

    public MatchList getVisualizationMask() {
        if (this.mVisMask == null) {
            this.mVisMask = new MatchList(this.mLocalizedContext, Prefs.PREF_VISUALIZATION_MASK);
        }
        return this.mVisMask;
    }

    public boolean isDecryptingPcap() {
        return this.mIsDecryptingPcap;
    }

    public boolean isUsharkAvailable() {
        return this.mIsUsharkAvailable;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        if (!isUnderTest()) {
            Log.init(getCacheDir().getAbsolutePath());
        }
        Utils.BuildType verifiedBuild = Utils.getVerifiedBuild(this);
        Log.m583i("PCAPdroid", "Build type: " + verifiedBuild);
        CaocConfig caocConfig = CustomActivityOnCrash.config;
        CaocConfig caocConfig2 = new CaocConfig();
        caocConfig2.enabled = caocConfig.enabled;
        caocConfig2.errorDrawable = caocConfig.errorDrawable;
        caocConfig2.errorActivityClass = caocConfig.errorActivityClass;
        caocConfig2.restartActivityClass = caocConfig.restartActivityClass;
        if (verifiedBuild == Utils.BuildType.PLAYSTORE || verifiedBuild == Utils.BuildType.UNKNOWN) {
            caocConfig2.enabled = false;
        } else {
            caocConfig2.errorDrawable = Integer.valueOf((int) C0130R.C0131drawable.ic_app_crash);
            caocConfig2.errorActivityClass = ErrorActivity.class;
        }
        CustomActivityOnCrash.config = caocConfig2;
        mInstance = new WeakReference<>(this);
        this.mLocalizedContext = createConfigurationContext(Utils.getLocalizedConfig(this));
        this.mIsUsharkAvailable = CaptureService.isUsharkAvailable(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        registerReceiver(new BroadcastReceiver() { // from class: com.emanuelef.remote_capture.PCAPdroid.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                    boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                    String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    StringBuilder sb = new StringBuilder("ACTION_PACKAGE_ADDED [new=");
                    sb.append(!booleanExtra);
                    sb.append("]: ");
                    sb.append(schemeSpecificPart);
                    Log.m587d("PCAPdroid", sb.toString());
                    if (!booleanExtra) {
                        PCAPdroid.this.checkUidMapping(schemeSpecificPart);
                    }
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
                    boolean booleanExtra2 = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
                    String schemeSpecificPart2 = intent.getData().getSchemeSpecificPart();
                    Log.m587d("PCAPdroid", "ACTION_PACKAGE_REMOVED [update=" + booleanExtra2 + "]: " + schemeSpecificPart2);
                    if (!booleanExtra2) {
                        PCAPdroid.this.checkUidMapping(schemeSpecificPart2);
                        PCAPdroid.this.removeUninstalledAppsFromAppFilter();
                    }
                }
            }
        }, intentFilter);
        removeUninstalledAppsFromAppFilter();
    }

    public void setIsDecryptingPcap(boolean z) {
        this.mIsDecryptingPcap = z;
    }

    public void setLoadedPcapBasename(String str) {
        this.mLoadedPcapBasename = str;
    }
}
