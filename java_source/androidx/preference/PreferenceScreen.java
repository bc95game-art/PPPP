package androidx.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.content.res.CamUtils;
import com.emanuelef.remote_capture.C0130R;
/* loaded from: classes.dex */
public final class PreferenceScreen extends PreferenceGroup {
    public final boolean mShouldUseGeneratedIds = true;

    public PreferenceScreen(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, CamUtils.getAttr(context, C0130R.attr.preferenceScreenStyle, 16842891), 0);
    }

    @Override // androidx.preference.Preference
    public final void onClick() {
        PreferenceFragmentCompat preferenceFragmentCompat;
        if (this.mIntent == null && this.mFragment == null && this.mPreferences.size() != 0 && (preferenceFragmentCompat = this.mPreferenceManager.mOnNavigateToScreenListener) != null) {
            preferenceFragmentCompat.onNavigateToScreen(this);
        }
    }
}
