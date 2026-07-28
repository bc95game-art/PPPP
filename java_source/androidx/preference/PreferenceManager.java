package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
/* loaded from: classes.dex */
public final class PreferenceManager {
    public final Context mContext;
    public SharedPreferences.Editor mEditor;
    public boolean mNoCommit;
    public PreferenceFragmentCompat mOnDisplayPreferenceDialogListener;
    public PreferenceFragmentCompat mOnNavigateToScreenListener;
    public PreferenceFragmentCompat mOnPreferenceTreeClickListener;
    public PreferenceScreen mPreferenceScreen;
    public final String mSharedPreferencesName;
    public long mNextId = 0;
    public SharedPreferences mSharedPreferences = null;

    public PreferenceManager(Context context) {
        this.mContext = context;
        this.mSharedPreferencesName = getDefaultSharedPreferencesName(context);
    }

    public static SharedPreferences getDefaultSharedPreferences(Context context) {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context), 0);
    }

    public static String getDefaultSharedPreferencesName(Context context) {
        return context.getPackageName() + "_preferences";
    }

    public final SharedPreferences.Editor getEditor() {
        if (!this.mNoCommit) {
            return getSharedPreferences().edit();
        }
        if (this.mEditor == null) {
            this.mEditor = getSharedPreferences().edit();
        }
        return this.mEditor;
    }

    public final long getNextId() {
        long j;
        synchronized (this) {
            j = this.mNextId;
            this.mNextId = 1 + j;
        }
        return j;
    }

    public final SharedPreferences getSharedPreferences() {
        if (this.mSharedPreferences == null) {
            this.mSharedPreferences = this.mContext.getSharedPreferences(this.mSharedPreferencesName, 0);
        }
        return this.mSharedPreferences;
    }

    /* JADX WARN: Finally extract failed */
    public final PreferenceScreen inflateFromResource(Context context, int i, PreferenceScreen preferenceScreen) {
        this.mNoCommit = true;
        PreferenceInflater preferenceInflater = new PreferenceInflater(context, this);
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            PreferenceGroup inflate = preferenceInflater.inflate(xml, preferenceScreen);
            xml.close();
            PreferenceScreen preferenceScreen2 = (PreferenceScreen) inflate;
            preferenceScreen2.onAttachedToHierarchy(this);
            SharedPreferences.Editor editor = this.mEditor;
            if (editor != null) {
                editor.apply();
            }
            this.mNoCommit = false;
            return preferenceScreen2;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }
}
