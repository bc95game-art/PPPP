package com.emanuelef.remote_capture;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.RemoteException;
import androidx.core.content.pm.PackageInfoCompat$Api28Impl;
import androidx.lifecycle.ViewModelProvider;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.interfaces.MitmListener;
import com.emanuelef.remote_capture.model.Prefs;
import com.pcapdroid.mitm.MitmAPI;
import java.io.IOException;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class MitmAddon {
    public static final long PACKAGE_VERSION_CODE = 21;
    public static final String PACKAGE_VERSION_NAME = "1.4";
    public static final String REPOSITORY = "https://github.com/emanuele-f/PCAPdroid-mitm";
    private static final String TAG = "MitmAddon";
    private final ServiceConnection mConnection = new ServiceConnection() { // from class: com.emanuelef.remote_capture.MitmAddon.1
        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            Log.w(MitmAddon.TAG, "onBindingDied");
            MitmAddon.this.disconnect();
            MitmAddon.this.mReceiver.onMitmServiceDisconnect();
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            Log.w(MitmAddon.TAG, "onNullBinding");
            MitmAddon.this.disconnect();
            MitmAddon.this.mReceiver.onMitmServiceDisconnect();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(MitmAddon.TAG, "Service connected");
            MitmAddon.this.mService = new Messenger(iBinder);
            if (MitmAddon.this.mStopRequested) {
                MitmAddon.this.stopProxy();
            } else {
                MitmAddon.this.mReceiver.onMitmServiceConnect();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i(MitmAddon.TAG, "Service disconnected");
            MitmAddon.this.disconnect();
            MitmAddon.this.mReceiver.onMitmServiceDisconnect();
        }
    };
    private final Context mContext;
    private final Messenger mMessenger;
    private final MitmListener mReceiver;
    private Messenger mService;
    private boolean mStopRequested;

    /* loaded from: classes.dex */
    public static class ReplyHandler extends Handler {
        private final WeakReference<MitmListener> mReceiver;

        public ReplyHandler(Looper looper, MitmListener mitmListener) {
            super(looper);
            this.mReceiver = new WeakReference<>(mitmListener);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            Log.d(MitmAddon.TAG, "Message: " + message.what);
            MitmListener mitmListener = this.mReceiver.get();
            if (mitmListener != null && message.what == 2) {
                if (message.getData() != null) {
                    str = message.getData().getString(MitmAPI.CERTIFICATE_RESULT);
                } else {
                    str = null;
                }
                mitmListener.onMitmGetCaCertificateResult(str);
            }
        }
    }

    public MitmAddon(Context context, MitmListener mitmListener) {
        this.mContext = context.getApplicationContext();
        this.mReceiver = mitmListener;
        this.mMessenger = new Messenger(new ReplyHandler(context.getMainLooper(), mitmListener));
    }

    public static String getGithubReleaseUrl(String str) {
        StringBuilder sb = new StringBuilder("https://github.com/emanuele-f/PCAPdroid-mitm/releases/download/v");
        sb.append(str);
        sb.append("/PCAPdroid-mitm_v");
        sb.append(str);
        sb.append("_");
        return ViewModelProvider.Factory.CC.m(sb, Build.SUPPORTED_ABIS[0], ".apk");
    }

    public static long getInstalledVersion(Context context) {
        try {
            PackageInfo packageInfo = Utils.getPackageInfo(context.getPackageManager(), MitmAPI.PACKAGE_NAME, 0);
            if (Build.VERSION.SDK_INT >= 28) {
                return PackageInfoCompat$Api28Impl.getLongVersionCode(packageInfo);
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1L;
        }
    }

    public static String getInstalledVersionName(Context context) {
        try {
            return Utils.getPackageInfo(context.getPackageManager(), MitmAPI.PACKAGE_NAME, 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String getNewVersionAvailable(Context context) {
        long j;
        if (!Prefs.isIgnoredMitmVersion(PreferenceManager.getDefaultSharedPreferences(context), PACKAGE_VERSION_NAME)) {
            try {
                PackageInfo packageInfo = Utils.getPackageInfo(context.getPackageManager(), MitmAPI.PACKAGE_NAME, 0);
                if (Build.VERSION.SDK_INT >= 28) {
                    j = PackageInfoCompat$Api28Impl.getLongVersionCode(packageInfo);
                } else {
                    j = packageInfo.versionCode;
                }
                if (j < 21) {
                    if (Utils.isSemanticVersionCompatible(PACKAGE_VERSION_NAME, packageInfo.versionName)) {
                        return PACKAGE_VERSION_NAME;
                    }
                    return "";
                }
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            }
        }
        return "";
    }

    public static int getUid(Context context) {
        try {
            return Utils.getPackageUid(context.getPackageManager(), MitmAPI.PACKAGE_NAME, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static void ignoreNewVersion(Context context) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(Prefs.PREF_IGNORED_MITM_VERSION, PACKAGE_VERSION_NAME).apply();
    }

    public static boolean isCAInstallationSkipped(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(Prefs.PREF_CA_INSTALLATION_SKIPPED, false);
    }

    public static boolean isDozeEnabled(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (Build.VERSION.SDK_INT < 23 || powerManager == null || powerManager.isIgnoringBatteryOptimizations(MitmAPI.PACKAGE_NAME)) {
            return false;
        }
        return true;
    }

    public static boolean isInstalled(Context context) {
        try {
            return Utils.isSemanticVersionCompatible(PACKAGE_VERSION_NAME, Utils.getPackageInfo(context.getPackageManager(), MitmAPI.PACKAGE_NAME, 0).versionName);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean needsSetup(Context context) {
        if (!Prefs.isTLSDecryptionSetupDone(PreferenceManager.getDefaultSharedPreferences(context))) {
            return true;
        }
        if (isInstalled(context)) {
            return false;
        }
        setDecryptionSetupDone(context, false);
        return true;
    }

    public static void setCAInstallationSkipped(Context context, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(Prefs.PREF_CA_INSTALLATION_SKIPPED, z).apply();
    }

    public static void setDecryptionSetupDone(Context context, boolean z) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(Prefs.PREF_TLS_DECRYPTION_SETUP_DONE, z).apply();
    }

    public boolean connect(int i) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MitmAPI.PACKAGE_NAME, MitmAPI.MITM_SERVICE));
        if (this.mContext.bindService(intent, this.mConnection, i | 513)) {
            return true;
        }
        try {
            this.mContext.unbindService(this.mConnection);
        } catch (IllegalArgumentException unused) {
            Log.w(TAG, "unbindService failed");
        }
        this.mService = null;
        return false;
    }

    public boolean disableDoze() {
        if (this.mService == null) {
            return false;
        }
        Log.i(TAG, "Send disable doze");
        try {
            this.mService.send(Message.obtain((Handler) null, 4));
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void disconnect() {
        if (this.mService != null) {
            Log.i(TAG, "Unbinding service...");
            try {
                this.mContext.unbindService(this.mConnection);
            } catch (IllegalArgumentException unused) {
                Log.w(TAG, "unbindService failed");
            }
            this.mService = null;
        }
    }

    public boolean isConnected() {
        if (this.mService != null) {
            return true;
        }
        return false;
    }

    public boolean requestCaCertificate() {
        if (this.mService == null) {
            Log.e(TAG, "Not connected");
            return false;
        }
        Message obtain = Message.obtain((Handler) null, 2);
        obtain.replyTo = this.mMessenger;
        try {
            this.mService.send(obtain);
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ParcelFileDescriptor startProxy(MitmAPI.MitmConfig mitmConfig) {
        if (this.mService == null) {
            Log.e(TAG, "Not connected");
            return null;
        }
        try {
            ParcelFileDescriptor[] createReliableSocketPair = ParcelFileDescriptor.createReliableSocketPair();
            Message obtain = Message.obtain(null, 1, 0, 0, createReliableSocketPair[0]);
            Bundle bundle = new Bundle();
            bundle.putSerializable(MitmAPI.MITM_CONFIG, mitmConfig);
            obtain.setData(bundle);
            try {
                this.mService.send(obtain);
                Utils.safeClose(createReliableSocketPair[0]);
                return createReliableSocketPair[1];
            } catch (RemoteException | NullPointerException e) {
                e.printStackTrace();
                Utils.safeClose(createReliableSocketPair[0]);
                Utils.safeClose(createReliableSocketPair[1]);
                return null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean stopProxy() {
        if (this.mService == null) {
            Log.i(TAG, "Not connected, postponing stop message");
            this.mStopRequested = true;
            return true;
        }
        Log.i(TAG, "Send stop message");
        try {
            this.mService.send(Message.obtain((Handler) null, 3));
            this.mStopRequested = false;
            return true;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
