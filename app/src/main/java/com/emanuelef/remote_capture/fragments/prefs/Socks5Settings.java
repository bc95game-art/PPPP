package com.emanuelef.remote_capture.fragments.prefs;

import android.os.Bundle;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.SwitchPreference;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.Prefs;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import j$.util.Objects;
/* loaded from: classes.dex */
public class Socks5Settings extends SettingsSubFragment {
    private EditTextPreference mPassword;
    private EditTextPreference mProxyHost;
    private EditTextPreference mProxyPort;
    private SwitchPreference mSocks5AuthEnabled;
    private EditTextPreference mUsername;

    public static /* synthetic */ boolean $r8$lambda$sJQFARlqn93lMKiE9Iffj0at35k(Socks5Settings socks5Settings, Preference preference, Object obj) {
        return socks5Settings.lambda$onCreatePreferences$4(preference, obj);
    }

    public static /* synthetic */ boolean lambda$onCreatePreferences$0(Preference preference, Object obj) {
        return Utils.validateHost(obj.toString());
    }

    public static /* synthetic */ boolean lambda$onCreatePreferences$3(Preference preference, Object obj) {
        return Utils.validatePort(obj.toString());
    }

    public boolean lambda$onCreatePreferences$4(Preference preference, Object obj) {
        toggleVisisiblity(((Boolean) obj).booleanValue(), this.mSocks5AuthEnabled.mChecked);
        return true;
    }

    public boolean lambda$onCreatePreferences$5(SwitchPreference switchPreference, Preference preference, Object obj) {
        toggleVisisiblity(switchPreference.mChecked, ((Boolean) obj).booleanValue());
        return true;
    }

    private void toggleVisisiblity(boolean z, boolean z2) {
        boolean z3;
        this.mProxyHost.setVisible(z);
        this.mProxyPort.setVisible(z);
        this.mSocks5AuthEnabled.setVisible(z);
        EditTextPreference editTextPreference = this.mUsername;
        boolean z4 = false;
        if (!z || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        editTextPreference.setVisible(z3);
        EditTextPreference editTextPreference2 = this.mPassword;
        if (z && z2) {
            z4 = true;
        }
        editTextPreference2.setVisible(z4);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.socks5_preferences, str);
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(Prefs.PREF_SOCKS5_PROXY_IP_KEY);
        Objects.requireNonNull(editTextPreference);
        this.mProxyHost = editTextPreference;
        editTextPreference.mOnChangeListener = new TransportImpl$$ExternalSyntheticLambda0(14);
        editTextPreference.mOnBindEditTextListener = new TransportImpl$$ExternalSyntheticLambda0(15);
        EditTextPreference editTextPreference2 = (EditTextPreference) findPreference(Prefs.PREF_SOCKS5_PROXY_PORT_KEY);
        Objects.requireNonNull(editTextPreference2);
        this.mProxyPort = editTextPreference2;
        editTextPreference2.mOnBindEditTextListener = new TransportImpl$$ExternalSyntheticLambda0(16);
        editTextPreference2.mOnChangeListener = new TransportImpl$$ExternalSyntheticLambda0(17);
        EditTextPreference editTextPreference3 = (EditTextPreference) findPreference(Prefs.PREF_SOCKS5_USERNAME_KEY);
        Objects.requireNonNull(editTextPreference3);
        this.mUsername = editTextPreference3;
        EditTextPreference editTextPreference4 = (EditTextPreference) findPreference(Prefs.PREF_SOCKS5_PASSWORD_KEY);
        Objects.requireNonNull(editTextPreference4);
        this.mPassword = editTextPreference4;
        SwitchPreference switchPreference = (SwitchPreference) findPreference(Prefs.PREF_SOCKS5_ENABLED_KEY);
        Objects.requireNonNull(switchPreference);
        SwitchPreference switchPreference2 = (SwitchPreference) findPreference(Prefs.PREF_SOCKS5_AUTH_ENABLED_KEY);
        Objects.requireNonNull(switchPreference2);
        this.mSocks5AuthEnabled = switchPreference2;
        switchPreference.mOnChangeListener = new InputConnectionCompat$$ExternalSyntheticLambda0(9, this);
        switchPreference2.mOnChangeListener = new GeoipSettings$$ExternalSyntheticLambda3(this, 2, switchPreference);
        toggleVisisiblity(switchPreference.mChecked, switchPreference2.mChecked);
    }
}
