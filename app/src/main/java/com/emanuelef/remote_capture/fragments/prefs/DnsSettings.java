package com.emanuelef.remote_capture.fragments.prefs;

import android.os.Bundle;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.Utils;
import com.emanuelef.remote_capture.model.Prefs;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import j$.util.Objects;
/* loaded from: classes.dex */
public class DnsSettings extends SettingsSubFragment {
    public static /* synthetic */ boolean lambda$onCreatePreferences$0(Preference preference, Object obj) {
        return Utils.validateIpv4Address(obj.toString());
    }

    public static /* synthetic */ boolean lambda$onCreatePreferences$1(Preference preference, Object obj) {
        String obj2 = obj.toString();
        if (obj2.equals("::") || !Utils.validateIpv6Address(obj2)) {
            return false;
        }
        return true;
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(R.xml.dns_preferences, str);
        EditTextPreference editTextPreference = (EditTextPreference) findPreference(Prefs.PREF_DNS_SERVER_V4);
        Objects.requireNonNull(editTextPreference);
        editTextPreference.mOnChangeListener = new TransportImpl$$ExternalSyntheticLambda0(12);
        EditTextPreference editTextPreference2 = (EditTextPreference) findPreference(Prefs.PREF_DNS_SERVER_V6);
        Objects.requireNonNull(editTextPreference2);
        editTextPreference2.mOnChangeListener = new TransportImpl$$ExternalSyntheticLambda0(13);
    }
}
