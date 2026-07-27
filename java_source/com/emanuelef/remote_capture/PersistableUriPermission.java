package com.emanuelef.remote_capture;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.UriPermission;
import android.net.Uri;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.FragmentManager;
import androidx.preference.PreferenceManager;
/* loaded from: classes.dex */
public class PersistableUriPermission {
    private static int PERSIST_MODE = 3;
    private static final String PREF_KEY = "persistable_uri";
    private static final String TAG = "PersistableUriPermission";
    public String key = "";
    private final Context mCtx;
    private PupListener mListener;
    private String mNewKey;
    private final ActivityResultLauncher mPcapLauncher;
    private final SharedPreferences mPrefs;
    public Uri persistableUri;

    /* loaded from: classes.dex */
    public interface PupListener {
        void onUriChecked(Uri uri);
    }

    public PersistableUriPermission(ComponentActivity componentActivity) {
        this.mCtx = componentActivity;
        this.mPrefs = PreferenceManager.getDefaultSharedPreferences(componentActivity);
        this.mPcapLauncher = componentActivity.registerForActivityResult(new FragmentManager.FragmentIntentSenderContract(3), new PlayBilling$$ExternalSyntheticLambda4(4, this));
        reload();
    }

    private void openFileSelector(boolean z) {
        String uniquePcapFileName = Utils.getUniquePcapFileName(this.mCtx, z);
        Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        intent.putExtra("android.intent.extra.TITLE", uniquePcapFileName);
        if (Utils.supportsFileDialog(this.mCtx, intent)) {
            try {
                this.mPcapLauncher.launch(intent);
                return;
            } catch (ActivityNotFoundException unused) {
            }
        }
        Log.m581w(TAG, "No app found to handle file selection");
        Utils.showToastLong(this.mCtx, C0130R.string.no_activity_file_selection, new Object[0]);
        this.mListener.onUriChecked(null);
    }

    public void pcapFileResult(ActivityResult activityResult) {
        int i = activityResult.mResultCode;
        Intent intent = activityResult.mData;
        if (i != -1 || intent == null) {
            this.mListener.onUriChecked(null);
            return;
        }
        Uri data = intent.getData();
        if ((intent.getFlags() & 64) != 0) {
            try {
                this.mCtx.getContentResolver().takePersistableUriPermission(data, PERSIST_MODE);
                this.persistableUri = data;
                this.key = this.mNewKey;
                save();
            } catch (SecurityException e) {
                Log.m585e(TAG, "Could not get PersistableUriPermission");
                e.printStackTrace();
            }
        }
        this.mListener.onUriChecked(data);
    }

    public void checkPermission(String str, boolean z, PupListener pupListener) {
        boolean equals = str.equals(this.key);
        this.mNewKey = str;
        this.mListener = pupListener;
        boolean z2 = false;
        for (UriPermission uriPermission : this.mCtx.getContentResolver().getPersistedUriPermissions()) {
            if (!equals || !uriPermission.getUri().equals(this.persistableUri)) {
                Log.m587d(TAG, "Releasing URI permission: " + uriPermission.getUri().toString());
                this.mCtx.getContentResolver().releasePersistableUriPermission(uriPermission.getUri(), PERSIST_MODE);
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            openFileSelector(z);
        } else {
            this.mListener.onUriChecked(this.persistableUri);
        }
    }

    public void reload() {
        String string = this.mPrefs.getString(PREF_KEY, "");
        int indexOf = string.indexOf("|");
        if (indexOf >= 0) {
            this.key = string.substring(0, indexOf);
            this.persistableUri = Uri.parse(string.substring(indexOf + 1));
        }
    }

    public void save() {
        this.mPrefs.edit().putString(PREF_KEY, this.key + "|" + this.persistableUri).apply();
    }
}
