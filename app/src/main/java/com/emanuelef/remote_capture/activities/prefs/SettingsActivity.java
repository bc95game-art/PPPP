package com.emanuelef.remote_capture.activities.prefs;

import android.app.LocaleManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.system.Os;
import android.system.OsConstants;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import androidx.activity.BackEventCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.preference.DropDownPreference;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceGroupAdapter;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;
import com.android.billingclient.api.zzbv;
import com.emanuelef.remote_capture.Billing;
import com.emanuelef.remote_capture.Log;
import com.emanuelef.remote_capture.MitmAddon;
import com.emanuelef.remote_capture.PlayBilling;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.VpnReconnectService;
import com.emanuelef.remote_capture.activities.BaseActivity;
import com.emanuelef.remote_capture.activities.BaseActivity$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.activities.IABActivity;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.activities.MitmSetupWizard;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.fragments.prefs.DnsSettings;
import com.emanuelef.remote_capture.fragments.prefs.GeoipSettings;
import com.emanuelef.remote_capture.fragments.prefs.GeoipSettings$$ExternalSyntheticLambda3;
import com.emanuelef.remote_capture.fragments.prefs.Socks5Settings;
import com.emanuelef.remote_capture.interfaces.FragmentViewCreatedListener;
import com.emanuelef.remote_capture.model.Prefs;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public class SettingsActivity extends BaseActivity implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback, FragmentManager.OnBackStackChangedListener, FragmentViewCreatedListener {
    private static final String ACTION_LANG_RESTART = "lang_restart";
    private static final String TAG = "SettingsActivity";
    public static final String TARGET_PREF_EXTRA = "target_pref";
    private WindowInsetsCompat mInsets = null;

    /* loaded from: classes.dex */
    public static class SettingsFragment extends PreferenceFragmentCompat {
        private SwitchPreference mAutoBlockPrivateDNS;
        private DropDownPreference mBlockQuic;
        private DropDownPreference mCapInterface;
        private Preference mDnsSettings;
        private SwitchPreference mFullPayloadEnabled;
        private boolean mHasStartedMitmWizard;
        private Billing mIab;
        private DropDownPreference mIpMode;
        private SwitchPreference mMalwareDetectionEnabled;
        private Preference mMitmWizard;
        private EditTextPreference mMitmproxyOpts;
        private SwitchPreference mPcapngEnabled;
        private Preference mPortMapping;
        private SwitchPreference mRestartOnDisconnect;
        private SwitchPreference mRootCaptureEnabled;
        private boolean mRootDecryptionNoticeShown = false;
        private Preference mSocks5Settings;
        private SwitchPreference mTlsDecryption;
        private Preference mVpnExceptions;

        private boolean checkDecrpytionWithRoot(boolean z, boolean z2) {
            if (this.mRootDecryptionNoticeShown || !z || !z2) {
                return true;
            }
            zzbv zzbvVar = new zzbv(requireContext());
            zzbvVar.setMessage(R.string.tls_decryption_with_root_msg);
            zzbvVar.setPositiveButton(R.string.ok, new AppsFragment$$ExternalSyntheticLambda0(3, this));
            zzbvVar.show();
            return false;
        }

        private boolean isPcapngEnabled() {
            if (!this.mIab.isPurchased(Billing.PCAPNG_SKU) || !this.mPcapngEnabled.mChecked) {
                return false;
            }
            return true;
        }

        public /* synthetic */ void lambda$checkDecrpytionWithRoot$15(DialogInterface dialogInterface, int i) {
            this.mRootCaptureEnabled.setChecked(true);
            this.mTlsDecryption.setChecked(true);
            this.mRootDecryptionNoticeShown = true;
        }

        public static WindowInsetsCompat lambda$onViewCreated$0(View view, WindowInsetsCompat windowInsetsCompat) {
            Insets insets = windowInsetsCompat.mImpl.getInsets(135);
            view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
            return WindowInsetsCompat.CONSUMED;
        }

        public /* synthetic */ boolean lambda$setupAppLanguagePref$11(Preference preference) {
            Intent intent = new Intent("android.settings.APP_LOCALE_SETTINGS");
            intent.setData(Uri.fromParts("package", requireContext().getPackageName(), null));
            startActivity(intent);
            return true;
        }

        public /* synthetic */ boolean lambda$setupAppLanguagePref$12(SharedPreferences sharedPreferences, Preference preference, Object obj) {
            if (sharedPreferences.edit().putString(Prefs.PREF_APP_LANGUAGE, obj.toString()).commit()) {
                Intent intent = new Intent(requireContext(), SettingsActivity.class);
                intent.addFlags(268468224);
                intent.setAction(SettingsActivity.ACTION_LANG_RESTART);
                startActivity(intent);
                Runtime.getRuntime().exit(0);
            }
            return false;
        }

        public boolean lambda$setupCapturePrefs$5(Preference preference, Object obj) {
            Boolean bool = (Boolean) obj;
            rootCaptureHideShow(bool.booleanValue());
            return checkDecrpytionWithRoot(bool.booleanValue(), this.mTlsDecryption.mChecked);
        }

        public /* synthetic */ boolean lambda$setupCapturePrefs$6(Preference preference) {
            startActivity(new Intent(requireContext(), VpnExemptionsActivity.class));
            return true;
        }

        public static /* synthetic */ boolean lambda$setupExporterPrefs$1(Preference preference, Object obj) {
            return Utils.validateIpAddress(obj.toString());
        }

        public static /* synthetic */ boolean lambda$setupExporterPrefs$3(Preference preference, Object obj) {
            return Utils.validatePort(obj.toString());
        }

        public static /* synthetic */ boolean lambda$setupHttpServerPrefs$4(Preference preference, Object obj) {
            return Utils.validatePort(obj.toString());
        }

        public /* synthetic */ boolean lambda$setupOtherPrefs$13(Preference preference) {
            startActivity(new Intent(requireContext(), PortMapActivity.class));
            return true;
        }

        public /* synthetic */ boolean lambda$setupOtherPrefs$14(Preference preference) {
            startActivity(new Intent(requireContext(), EditCtrlPermissions.class));
            return true;
        }

        public /* synthetic */ boolean lambda$setupSecurityPrefs$7(Preference preference) {
            if (this.mIab.isPurchased("malware_detection")) {
                return false;
            }
            this.mMalwareDetectionEnabled.setChecked(false);
            startActivity(new Intent(requireActivity(), IABActivity.class));
            return true;
        }

        public /* synthetic */ boolean lambda$setupTrafficInspectionPrefs$10(Preference preference) {
            this.mHasStartedMitmWizard = true;
            startActivity(new Intent(requireContext(), MitmSetupWizard.class));
            return true;
        }

        public /* synthetic */ boolean lambda$setupTrafficInspectionPrefs$8(Preference preference, Object obj) {
            Boolean bool = (Boolean) obj;
            boolean booleanValue = bool.booleanValue();
            Context requireContext = requireContext();
            if (booleanValue && Os.sysconf(OsConstants._SC_PAGE_SIZE) == 16384) {
                Utils.showToastLong(requireContext, R.string.tls_decryption_not_supported_16KB, new Object[0]);
                return false;
            } else if (!checkDecrpytionWithRoot(rootCaptureEnabled(), bool.booleanValue())) {
                return false;
            } else {
                if (!booleanValue || !MitmAddon.needsSetup(requireContext)) {
                    this.mMitmWizard.setVisible(bool.booleanValue());
                    this.mMitmproxyOpts.setVisible(bool.booleanValue());
                    socks5ProxyHideShow(bool.booleanValue(), rootCaptureEnabled());
                    return true;
                }
                this.mHasStartedMitmWizard = true;
                startActivity(new Intent(requireContext, MitmSetupWizard.class));
                return false;
            }
        }

        public /* synthetic */ boolean lambda$setupTrafficInspectionPrefs$9(Preference preference) {
            if (this.mIab.isPurchased(Billing.PCAPNG_SKU)) {
                return false;
            }
            this.mPcapngEnabled.setChecked(false);
            startActivity(new Intent(requireActivity(), IABActivity.class));
            return true;
        }

        private void refreshInterfaces() {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            arrayList.add(getString(R.string.internet));
            arrayList2.add("@inet");
            arrayList.add(getString(R.string.all_interfaces));
            arrayList2.add("any");
            try {
                Enumeration<NetworkInterface> networkInterfaces = Utils.getNetworkInterfaces();
                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface nextElement = networkInterfaces.nextElement();
                    if (nextElement.isUp()) {
                        String name = nextElement.getName();
                        arrayList.add(name);
                        arrayList2.add(name);
                    }
                }
            } catch (SocketException e) {
                e.printStackTrace();
            }
            this.mCapInterface.mEntryValues = (CharSequence[]) arrayList2.toArray(new String[0]);
            DropDownPreference dropDownPreference = this.mCapInterface;
            dropDownPreference.mEntries = (CharSequence[]) arrayList.toArray(new String[0]);
            ArrayAdapter arrayAdapter = dropDownPreference.mAdapter;
            arrayAdapter.clear();
            CharSequence[] charSequenceArr = dropDownPreference.mEntries;
            if (charSequenceArr != null) {
                for (CharSequence charSequence : charSequenceArr) {
                    arrayAdapter.add(charSequence.toString());
                }
            }
        }

        private <T extends Preference> T requirePreference(String str) {
            T t = (T) findPreference(str);
            if (t != null) {
                return t;
            }
            throw new IllegalStateException();
        }

        private boolean rootCaptureEnabled() {
            if (!Utils.isRootAvailable() || !this.mRootCaptureEnabled.mChecked) {
                return false;
            }
            return true;
        }

        private void rootCaptureHideShow(boolean z) {
            if (z) {
                this.mAutoBlockPrivateDNS.setVisible(false);
                this.mBlockQuic.setVisible(false);
                this.mSocks5Settings.setVisible(false);
            } else {
                this.mAutoBlockPrivateDNS.setVisible(true);
                this.mBlockQuic.setVisible(true);
                socks5ProxyHideShow(this.mTlsDecryption.mChecked, false);
            }
            if (VpnReconnectService.isAvailable()) {
                this.mRestartOnDisconnect.setVisible(!z);
            }
            this.mIpMode.setVisible(!z);
            this.mCapInterface.setVisible(z);
            this.mVpnExceptions.setVisible(!z);
            this.mDnsSettings.setVisible(!z);
            this.mPortMapping.setVisible(!z);
        }

        private void setupAppLanguagePref() {
            DropDownPreference dropDownPreference = (DropDownPreference) requirePreference(Prefs.PREF_APP_LANGUAGE);
            Preference requirePreference = requirePreference("app_language_external");
            if (Build.VERSION.SDK_INT >= 33) {
                dropDownPreference.setVisible(false);
                requirePreference.setVisible(true);
                LocaleList applicationLocales = ((LocaleManager) requireContext().getSystemService(LocaleManager.class)).getApplicationLocales();
                if (applicationLocales.equals(LocaleList.getEmptyLocaleList())) {
                    requirePreference.setSummary(getString(R.string.system_default));
                } else if (!applicationLocales.isEmpty()) {
                    requirePreference.setSummary(applicationLocales.get(0).getDisplayName());
                }
                requirePreference.mOnClickListener = new SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3(this, 0);
                return;
            }
            String[] supportedLocales = Utils.getSupportedLocales(requireContext());
            String[] strArr = new String[supportedLocales.length + 1];
            CharSequence[] charSequenceArr = new CharSequence[supportedLocales.length + 1];
            strArr[0] = "system";
            charSequenceArr[0] = getString(R.string.system_default);
            int i = 0;
            while (i < supportedLocales.length) {
                Locale forLanguageTag = Locale.forLanguageTag(supportedLocales[i]);
                int i2 = i + 1;
                strArr[i2] = supportedLocales[i];
                String displayName = forLanguageTag.getDisplayName(forLanguageTag);
                charSequenceArr[i2] = displayName.substring(0, 1).toUpperCase(forLanguageTag) + displayName.substring(1);
                i = i2;
            }
            dropDownPreference.mEntries = charSequenceArr;
            ArrayAdapter arrayAdapter = dropDownPreference.mAdapter;
            arrayAdapter.clear();
            CharSequence[] charSequenceArr2 = dropDownPreference.mEntries;
            if (charSequenceArr2 != null) {
                for (CharSequence charSequence : charSequenceArr2) {
                    arrayAdapter.add(charSequence.toString());
                }
            }
            dropDownPreference.mEntryValues = strArr;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
            if (SettingsActivity.ACTION_LANG_RESTART.equals(requireActivity().getIntent().getAction())) {
                scrollToPreference(dropDownPreference);
            }
            dropDownPreference.mOnChangeListener = new GeoipSettings$$ExternalSyntheticLambda3(this, 1, defaultSharedPreferences);
        }

        private void setupCapturePrefs() {
            this.mCapInterface = (DropDownPreference) requirePreference(Prefs.PREF_CAPTURE_INTERFACE);
            refreshInterfaces();
            this.mRootCaptureEnabled = (SwitchPreference) requirePreference(Prefs.PREF_ROOT_CAPTURE);
            if (Utils.isRootAvailable()) {
                this.mRootCaptureEnabled.mOnChangeListener = new SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3(this, 1);
            } else {
                this.mRootCaptureEnabled.setVisible(false);
            }
            SwitchPreference switchPreference = (SwitchPreference) requirePreference(Prefs.PREF_RESTART_ON_DISCONNECT);
            this.mRestartOnDisconnect = switchPreference;
            switchPreference.setVisible(VpnReconnectService.isAvailable());
            this.mDnsSettings = requirePreference("dns_settings");
            Preference requirePreference = requirePreference(Prefs.PREF_VPN_EXCEPTIONS);
            this.mVpnExceptions = requirePreference;
            requirePreference.mOnClickListener = new SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3(this, 2);
        }

        private void setupExporterPrefs() {
            ((EditTextPreference) requirePreference(Prefs.PREF_COLLECTOR_IP_KEY)).mOnChangeListener = new TransportImpl$$ExternalSyntheticLambda0(2);
            EditTextPreference editTextPreference = (EditTextPreference) requirePreference(Prefs.PREF_COLLECTOR_PORT_KEY);
            editTextPreference.mOnBindEditTextListener = new TransportImpl$$ExternalSyntheticLambda0(3);
            editTextPreference.mOnChangeListener = new BaseActivity$$ExternalSyntheticLambda0(28);
        }

        private void setupHttpServerPrefs() {
            ((EditTextPreference) requirePreference(Prefs.PREF_HTTP_SERVER_PORT)).mOnChangeListener = new TransportImpl$$ExternalSyntheticLambda0(1);
        }

        private void setupOtherPrefs() {
            setupAppLanguagePref();
            Preference requirePreference = requirePreference(Prefs.PREF_PORT_MAPPING);
            this.mPortMapping = requirePreference;
            requirePreference.mOnClickListener = new SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3(this, 7);
            this.mIpMode = (DropDownPreference) requirePreference(Prefs.PREF_IP_MODE);
            requirePreference("control_permissions").mOnClickListener = new SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3(this, 8);
        }

        private void setupSecurityPrefs() {
            this.mMalwareDetectionEnabled = (SwitchPreference) requirePreference("malware_detection");
            if (!this.mIab.isAvailable("malware_detection")) {
                PreferenceScreen preferenceScreen = getPreferenceScreen();
                Preference requirePreference = requirePreference("security");
                synchronized (preferenceScreen) {
                    try {
                        requirePreference.unregisterDependency();
                        if (requirePreference.mParentGroup == preferenceScreen) {
                            requirePreference.mParentGroup = null;
                        }
                        if (preferenceScreen.mPreferences.remove(requirePreference)) {
                            String str = requirePreference.mKey;
                            if (str != null) {
                                preferenceScreen.mIdRecycleCache.put(str, Long.valueOf(requirePreference.getId()));
                                preferenceScreen.mHandler.removeCallbacks(preferenceScreen.mClearRecycleCacheRunnable);
                                preferenceScreen.mHandler.post(preferenceScreen.mClearRecycleCacheRunnable);
                            }
                            if (preferenceScreen.mAttachedToHierarchy) {
                                requirePreference.onDetached();
                            }
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                PreferenceGroupAdapter preferenceGroupAdapter = preferenceScreen.mListener;
                if (preferenceGroupAdapter != null) {
                    Handler handler = preferenceGroupAdapter.mHandler;
                    PreferenceGroup.AnonymousClass1 r0 = preferenceGroupAdapter.mSyncRunnable;
                    handler.removeCallbacks(r0);
                    handler.post(r0);
                    return;
                }
                return;
            }
            this.mMalwareDetectionEnabled.mOnClickListener = new SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3(this, 6);
            if (!this.mIab.isPurchased("malware_detection")) {
                this.mMalwareDetectionEnabled.setChecked(false);
            }
        }

        private void setupTrafficInspectionPrefs() {
            this.mAutoBlockPrivateDNS = (SwitchPreference) requirePreference(Prefs.PREF_AUTO_BLOCK_PRIVATE_DNS);
            SwitchPreference switchPreference = (SwitchPreference) requirePreference(Prefs.PREF_TLS_DECRYPTION_KEY);
            this.mTlsDecryption = switchPreference;
            switchPreference.mOnChangeListener = new SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3(this, 3);
            this.mPcapngEnabled = (SwitchPreference) requirePreference(Prefs.PREF_PCAPNG_ENABLED);
            if (this.mIab.isAvailable(Billing.PCAPNG_SKU)) {
                this.mPcapngEnabled.mOnClickListener = new SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3(this, 4);
                if (!this.mIab.isPurchased(Billing.PCAPNG_SKU)) {
                    this.mPcapngEnabled.setChecked(false);
                }
            } else {
                this.mPcapngEnabled.setVisible(false);
            }
            this.mFullPayloadEnabled = (SwitchPreference) requirePreference(Prefs.PREF_FULL_PAYLOAD);
            this.mBlockQuic = (DropDownPreference) requirePreference(Prefs.PREF_BLOCK_QUIC);
            EditTextPreference editTextPreference = (EditTextPreference) requirePreference(Prefs.PREF_MITMPROXY_OPTS);
            this.mMitmproxyOpts = editTextPreference;
            editTextPreference.setVisible(this.mTlsDecryption.mChecked);
            Preference requirePreference = requirePreference("mitm_setup_wizard");
            this.mMitmWizard = requirePreference;
            requirePreference.setVisible(this.mTlsDecryption.mChecked);
            this.mMitmWizard.mOnClickListener = new SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3(this, 5);
            this.mSocks5Settings = requirePreference("socks5_settings");
        }

        private void socks5ProxyHideShow(boolean z, boolean z2) {
            boolean z3;
            Preference preference = this.mSocks5Settings;
            if (z || z2) {
                z3 = false;
            } else {
                z3 = true;
            }
            preference.setVisible(z3);
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            PlayBilling newInstance = Billing.newInstance(requireContext());
            this.mIab = newInstance;
            newInstance.connectBilling();
            super.onCreate(bundle);
        }

        @Override // androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle bundle, String str) {
            String stringExtra;
            setPreferencesFromResource(R.xml.root_preferences, str);
            setupExporterPrefs();
            setupHttpServerPrefs();
            setupTrafficInspectionPrefs();
            setupCapturePrefs();
            setupSecurityPrefs();
            setupOtherPrefs();
            socks5ProxyHideShow(this.mTlsDecryption.mChecked, rootCaptureEnabled());
            this.mBlockQuic.setVisible(!rootCaptureEnabled());
            rootCaptureHideShow(rootCaptureEnabled());
            Intent intent = requireActivity().getIntent();
            if (intent != null && (stringExtra = intent.getStringExtra(SettingsActivity.TARGET_PREF_EXTRA)) != null) {
                scrollToPreference(stringExtra);
            }
        }

        @Override // androidx.fragment.app.Fragment
        public void onDestroy() {
            this.mIab.disconnectBilling();
            super.onDestroy();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.mHasStartedMitmWizard && !MitmAddon.needsSetup(requireContext())) {
                Log.d(SettingsActivity.TAG, "mitm setup complete, enabling");
                this.mTlsDecryption.setChecked(true);
                this.mFullPayloadEnabled.setChecked(true);
            }
            this.mHasStartedMitmWizard = false;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            super.onViewCreated(view, bundle);
            BaseActivity$$ExternalSyntheticLambda0 baseActivity$$ExternalSyntheticLambda0 = new BaseActivity$$ExternalSyntheticLambda0(29);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(view, baseActivity$$ExternalSyntheticLambda0);
        }
    }

    public /* synthetic */ WindowInsetsCompat lambda$onCreateView$0(View view, WindowInsetsCompat windowInsetsCompat) {
        this.mInsets = windowInsetsCompat;
        return windowInsetsCompat;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent;
        if (!(getSupportFragmentManager().findFragmentById(R.id.fragment) instanceof SettingsFragment) || (intent = getIntent()) == null || !ACTION_LANG_RESTART.equals(intent.getAction())) {
            super.onBackPressed();
            return;
        }
        Intent intent2 = new Intent(this, MainActivity.class);
        intent2.addFlags(268435456);
        startActivity(intent2);
        finish();
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public /* bridge */ /* synthetic */ void onBackStackChangeCancelled() {
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public /* bridge */ /* synthetic */ void onBackStackChangeCommitted(Fragment fragment, boolean z) {
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public /* bridge */ /* synthetic */ void onBackStackChangeProgressed(BackEventCompat backEventCompat) {
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public /* bridge */ /* synthetic */ void onBackStackChangeStarted(Fragment fragment, boolean z) {
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (findFragmentById instanceof SettingsFragment) {
            setTitle(R.string.title_activity_settings);
            View view = findFragmentById.getView();
            WindowInsetsCompat windowInsetsCompat = this.mInsets;
            if (windowInsetsCompat != null && view != null) {
                ViewCompat.dispatchApplyWindowInsets(view, windowInsetsCompat);
            }
        }
    }

    @Override // com.emanuelef.remote_capture.activities.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(R.string.title_activity_settings);
        displayBackAction();
        setContentView(R.layout.fragment_activity);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.replace(R.id.fragment, new SettingsFragment(), "root");
        backStackRecord.commit();
        getSupportFragmentManager().mBackStackChangeListeners.add(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View onCreateView = super.onCreateView(view, str, context, attributeSet);
        if (onCreateView != null) {
            InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda0 = new InputConnectionCompat$$ExternalSyntheticLambda0(6, this);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(onCreateView, inputConnectionCompat$$ExternalSyntheticLambda0);
        }
        return onCreateView;
    }

    @Override // com.emanuelef.remote_capture.interfaces.FragmentViewCreatedListener
    public void onFragmentViewCreated(View view) {
        WindowInsetsCompat windowInsetsCompat = this.mInsets;
        if (windowInsetsCompat != null) {
            ViewCompat.dispatchApplyWindowInsets(view, windowInsetsCompat);
        }
    }

    @Override // androidx.preference.PreferenceFragmentCompat.OnPreferenceStartFragmentCallback
    public boolean onPreferenceStartFragment(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference) {
        Fragment fragment;
        String str = preference.mKey;
        Log.d(TAG, "startFragment: " + str);
        if (str.equals("geolocation")) {
            fragment = new GeoipSettings();
            setTitle(R.string.geolocation);
        } else if (str.equals("dns_settings")) {
            fragment = new DnsSettings();
            setTitle(R.string.dns_servers);
        } else if (str.equals("socks5_settings")) {
            fragment = new Socks5Settings();
            setTitle(R.string.socks5_proxy);
        } else {
            fragment = null;
        }
        if (fragment == null) {
            return false;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.replace(R.id.fragment, fragment, str);
        backStackRecord.mTransition = 4097;
        backStackRecord.addToBackStack(str);
        backStackRecord.commit();
        return true;
    }
}
