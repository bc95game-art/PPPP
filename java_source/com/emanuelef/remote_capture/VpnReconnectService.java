package com.emanuelef.remote_capture;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.p002os.BundleKt;
import androidx.preference.PreferenceManager;
import com.emanuelef.remote_capture.activities.MainActivity;
import com.emanuelef.remote_capture.model.CaptureSettings;
/* loaded from: classes.dex */
public class VpnReconnectService extends Service {
    private static VpnReconnectService INSTANCE = null;
    private static final String NOTIFY_CHAN_VPNRECONNECT = "VPN Reconnection";
    public static final int NOTIFY_ID_VPNRECONNECT = 10;
    private static final String STOP_ACTION = "stop";
    private static final String TAG = "VpnReconnectService";
    private Network mActiveVpnNetwork;
    private Handler mHandler;
    private ConnectivityManager.NetworkCallback mNetworkCallback;

    /* renamed from: com.emanuelef.remote_capture.VpnReconnectService$1 */
    /* loaded from: classes.dex */
    public class C01401 extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ ConnectivityManager val$cm;

        public C01401(ConnectivityManager connectivityManager) {
            VpnReconnectService.this = r1;
            this.val$cm = connectivityManager;
        }

        public /* synthetic */ void lambda$onLost$1() {
            Log.m583i(VpnReconnectService.TAG, "Active VPN disconnected, starting the capture");
            VpnReconnectService.this.unregisterNetworkCallback();
            VpnReconnectService vpnReconnectService = VpnReconnectService.this;
            CaptureSettings captureSettings = new CaptureSettings(vpnReconnectService, PreferenceManager.getDefaultSharedPreferences(vpnReconnectService));
            CaptureHelper captureHelper = new CaptureHelper(vpnReconnectService);
            captureHelper.setListener(new PlayBilling$$ExternalSyntheticLambda15(1));
            captureHelper.startCapture(captureSettings);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            Log.m587d(VpnReconnectService.TAG, "onAvailable: " + network);
            VpnReconnectService.this.checkAvailableNetwork(this.val$cm, network);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            Log.m587d(VpnReconnectService.TAG, "onLost: " + network);
            if (network.equals(VpnReconnectService.this.mActiveVpnNetwork)) {
                VpnReconnectService.this.mHandler.postDelayed(new CaptureService$$ExternalSyntheticLambda0(7, this), 3000L);
            }
        }
    }

    private Notification buildNotification() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFY_CHAN_VPNRECONNECT, NOTIFY_CHAN_VPNRECONNECT, 2);
            notificationChannel.setShowBadge(false);
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), Utils.getIntentFlags(134217728));
        Intent intent = new Intent(this, VpnReconnectService.class);
        intent.setAction("stop");
        PendingIntent service = PendingIntent.getService(this, 0, intent, Utils.getIntentFlags(0));
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, NOTIFY_CHAN_VPNRECONNECT);
        notificationCompat$Builder.mNotification.icon = C0130R.C0131drawable.ic_logo;
        notificationCompat$Builder.mColor = BundleKt.getColor(this, C0130R.color.colorPrimary);
        notificationCompat$Builder.mContentIntent = activity;
        notificationCompat$Builder.mNotification.deleteIntent = service;
        notificationCompat$Builder.setFlag(2, true);
        notificationCompat$Builder.setFlag(16, false);
        notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(getString(C0130R.string.vpn_reconnection));
        notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(getString(C0130R.string.waiting_for_vpn_disconnect));
        notificationCompat$Builder.mVisibility = 1;
        notificationCompat$Builder.mCategory = "status";
        notificationCompat$Builder.mPriority = -1;
        Log.m587d(TAG, "running");
        return notificationCompat$Builder.build();
    }

    public void checkAvailableNetwork(ConnectivityManager connectivityManager, Network network) {
        NetworkCapabilities networkCapabilities;
        if (!network.equals(this.mActiveVpnNetwork) && (networkCapabilities = connectivityManager.getNetworkCapabilities(network)) != null && networkCapabilities.hasTransport(4)) {
            this.mActiveVpnNetwork = network;
            Log.m587d(TAG, "Detected active VPN network: " + this.mActiveVpnNetwork);
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static boolean isAvailable() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void lambda$onStartCommand$0() {
        Log.m583i(TAG, "Could not detect a VPN within the timeout, automatic reconnection aborted");
        stopService();
    }

    private boolean registerNetworkCallbacks() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
        this.mNetworkCallback = new C01401(connectivityManager);
        try {
            Log.m587d(TAG, "registerNetworkCallback");
            NetworkRequest.Builder removeCapability = new NetworkRequest.Builder().removeCapability(15);
            if (Build.VERSION.SDK_INT >= 31) {
                removeCapability.setIncludeOtherUidNetworks(true);
            }
            connectivityManager.registerNetworkCallback(removeCapability.build(), this.mNetworkCallback);
            Network runningVpn = Utils.getRunningVpn(this);
            if (runningVpn != null) {
                checkAvailableNetwork(connectivityManager, runningVpn);
            }
            return true;
        } catch (SecurityException e) {
            e.printStackTrace();
            Log.m585e(TAG, "registerNetworkCallback failed");
            this.mNetworkCallback = null;
            return false;
        }
    }

    public static void stopService() {
        Log.m587d(TAG, "stopService called");
        VpnReconnectService vpnReconnectService = INSTANCE;
        if (vpnReconnectService != null) {
            vpnReconnectService.unregisterNetworkCallback();
            if (Build.VERSION.SDK_INT >= 24) {
                vpnReconnectService.stopForeground(1);
            } else {
                vpnReconnectService.stopForeground(true);
            }
            vpnReconnectService.stopSelf();
        }
    }

    public void unregisterNetworkCallback() {
        if (this.mNetworkCallback != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            try {
                Log.m587d(TAG, "unregisterNetworkCallback");
                connectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
            } catch (IllegalArgumentException e) {
                Log.m581w(TAG, "unregisterNetworkCallback failed: " + e);
            }
            this.mNetworkCallback = null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.m587d(TAG, "onCreate");
        this.mHandler = new Handler(Looper.getMainLooper());
        INSTANCE = this;
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.m587d(TAG, "onDestroy");
        unregisterNetworkCallback();
        INSTANCE = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.m587d(TAG, "onStartCommand");
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("stop")) {
            if (Build.VERSION.SDK_INT >= 34) {
                startForeground(10, buildNotification(), 1073741824);
            } else {
                startForeground(10, buildNotification());
            }
            this.mHandler.postDelayed(new CaptureService$$ExternalSyntheticLambda1(1), 10000L);
            if (registerNetworkCallbacks()) {
                return 1;
            }
            stopService();
            return 2;
        }
        Utils.showToastLong(this, C0130R.string.vpn_reconnection_aborted, new Object[0]);
        stopService();
        return 2;
    }
}
