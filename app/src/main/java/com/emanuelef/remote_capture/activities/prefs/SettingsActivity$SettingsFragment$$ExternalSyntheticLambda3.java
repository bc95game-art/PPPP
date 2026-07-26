package com.emanuelef.remote_capture.activities.prefs;

import androidx.preference.Preference;
import com.emanuelef.remote_capture.activities.prefs.SettingsActivity;
/* loaded from: classes.dex */
public final /* synthetic */ class SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3 implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SettingsActivity.SettingsFragment f$0;

    public /* synthetic */ SettingsActivity$SettingsFragment$$ExternalSyntheticLambda3(SettingsActivity.SettingsFragment settingsFragment, int i) {
        this.$r8$classId = i;
        this.f$0 = settingsFragment;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        switch (this.$r8$classId) {
            case 1:
                return SettingsActivity.SettingsFragment.m140$r8$lambda$yY8uusJ6qI43JdnLCIIWMZmvew(this.f$0, preference, obj);
            default:
                return SettingsActivity.SettingsFragment.$r8$lambda$fZswANIjQICYDeuSlzLWtXVtu3A(this.f$0, preference, obj);
        }
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        switch (this.$r8$classId) {
            case 0:
                return SettingsActivity.SettingsFragment.$r8$lambda$HMs2fPIYt7TTq1ZGgu1xLXvdqt8(this.f$0, preference);
            case 1:
            case 3:
            default:
                return SettingsActivity.SettingsFragment.m133$r8$lambda$JheUb1ui0xT6lamrW8Gtp1A744(this.f$0, preference);
            case 2:
                return SettingsActivity.SettingsFragment.m139$r8$lambda$oyCK1qQSi_9uCyAaJ4eh8yEHoE(this.f$0, preference);
            case 4:
                return SettingsActivity.SettingsFragment.m132$r8$lambda$CVYMw2B514lvVLilPXb0ZsWE8(this.f$0, preference);
            case 5:
                return SettingsActivity.SettingsFragment.m135$r8$lambda$SHmfAwtQeGRzUsOiACQmAIJz3I(this.f$0, preference);
            case 6:
                return SettingsActivity.SettingsFragment.m137$r8$lambda$_jmmuWMOEFM5ZZjp5p_LN3GL0Q(this.f$0, preference);
            case 7:
                return SettingsActivity.SettingsFragment.m136$r8$lambda$UPOgkKQINneLZR2ntpGfq28SA(this.f$0, preference);
        }
    }
}
