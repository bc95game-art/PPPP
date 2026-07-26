package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$Builder;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.R;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.zac;
import com.google.android.gms.common.internal.zad;
import com.google.android.gms.common.internal.zzah;
/* loaded from: classes.dex */
public final class GoogleApiAvailability extends GoogleApiAvailabilityLight {
    public static final Object zaa = new Object();
    public static final GoogleApiAvailability zab = new Object();

    public static AlertDialog zaa(Activity activity, int i, zad zadVar, DialogInterface.OnCancelListener onCancelListener) {
        String str;
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        activity.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(activity, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(zac.zac(activity, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Resources resources = activity.getResources();
        if (i == 1) {
            str = resources.getString(R.string.common_google_play_services_install_button);
        } else if (i == 2) {
            str = resources.getString(R.string.common_google_play_services_update_button);
        } else if (i != 3) {
            str = resources.getString(17039370);
        } else {
            str = resources.getString(R.string.common_google_play_services_enable_button);
        }
        if (str != null) {
            builder.setPositiveButton(str, zadVar);
        }
        String zaf = zac.zaf(activity, i);
        if (zaf != null) {
            builder.setTitle(zaf);
        }
        Log.w("GoogleApiAvailability", ViewModelProvider.Factory.CC.m(i, "Creating dialog for Google Play services availability issue. ConnectionResult="), new IllegalArgumentException());
        return builder.create();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.android.gms.common.ErrorDialogFragment, android.app.DialogFragment] */
    public static void zad(Activity activity, AlertDialog alertDialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
                SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
                zzah.checkNotNull(alertDialog, "Cannot display null dialog");
                alertDialog.setOnCancelListener(null);
                alertDialog.setOnDismissListener(null);
                supportErrorDialogFragment.zaa = alertDialog;
                if (onCancelListener != null) {
                    supportErrorDialogFragment.zab = onCancelListener;
                }
                supportErrorDialogFragment.show(supportFragmentManager, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        ?? dialogFragment = new DialogFragment();
        zzah.checkNotNull(alertDialog, "Cannot display null dialog");
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        dialogFragment.zaa = alertDialog;
        if (onCancelListener != null) {
            dialogFragment.zab = onCancelListener;
        }
        dialogFragment.show(fragmentManager, str);
    }

    public final void showErrorDialogFragment(GoogleApiActivity googleApiActivity, int i, GoogleApiActivity googleApiActivity2) {
        AlertDialog zaa2 = zaa(googleApiActivity, i, new zad(super.getErrorResolutionIntent(i, googleApiActivity, "d"), googleApiActivity, 0), googleApiActivity2);
        if (zaa2 != null) {
            zad(googleApiActivity, zaa2, "GooglePlayServicesErrorDialog", googleApiActivity2);
        }
    }

    public final void zae(Context context, int i, PendingIntent pendingIntent) {
        String str;
        String str2;
        int i2;
        Log.w("GoogleApiAvailability", "GMS core API Availability. ConnectionResult=" + i + ", tag=null", new IllegalArgumentException());
        if (i == 18) {
            new zad(this, context).sendEmptyMessageDelayed(1, 120000L);
        } else if (pendingIntent != null) {
            if (i == 6) {
                str = zac.zah(context, "common_google_play_services_resolution_required_title");
            } else {
                str = zac.zaf(context, i);
            }
            if (str == null) {
                str = context.getResources().getString(R.string.common_google_play_services_notification_ticker);
            }
            if (i == 6 || i == 19) {
                str2 = zac.zag(context, "common_google_play_services_resolution_required_text", zac.zaa(context));
            } else {
                str2 = zac.zac(context, i);
            }
            Resources resources = context.getResources();
            Object systemService = context.getSystemService("notification");
            zzah.checkNotNull(systemService);
            NotificationManager notificationManager = (NotificationManager) systemService;
            NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(context, null);
            notificationCompat$Builder.mLocalOnly = true;
            notificationCompat$Builder.setFlag(16, true);
            notificationCompat$Builder.mContentTitle = NotificationCompat$Builder.limitCharSequenceLength(str);
            zzcl zzclVar = new zzcl(6, false);
            zzclVar.zzc = NotificationCompat$Builder.limitCharSequenceLength(str2);
            notificationCompat$Builder.setStyle(zzclVar);
            PackageManager packageManager = context.getPackageManager();
            if (Navigation.zze == null) {
                Navigation.zze = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
            }
            if (Navigation.zze.booleanValue()) {
                notificationCompat$Builder.mNotification.icon = context.getApplicationInfo().icon;
                notificationCompat$Builder.mPriority = 2;
                if (Navigation.isWearableWithoutPlayStore(context)) {
                    notificationCompat$Builder.mActions.add(new NotificationCompat$Action(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), pendingIntent));
                } else {
                    notificationCompat$Builder.mContentIntent = pendingIntent;
                }
            } else {
                notificationCompat$Builder.mNotification.icon = 17301642;
                String string = resources.getString(R.string.common_google_play_services_notification_ticker);
                notificationCompat$Builder.mNotification.tickerText = NotificationCompat$Builder.limitCharSequenceLength(string);
                notificationCompat$Builder.mNotification.when = System.currentTimeMillis();
                notificationCompat$Builder.mContentIntent = pendingIntent;
                notificationCompat$Builder.mContentText = NotificationCompat$Builder.limitCharSequenceLength(str2);
            }
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 26) {
                if (i3 >= 26) {
                    synchronized (zaa) {
                    }
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                    String string2 = context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
                    if (notificationChannel == null) {
                        notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string2, 4));
                    } else if (!string2.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(string2);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                    notificationCompat$Builder.mChannelId = "com.google.android.gms.availability";
                } else {
                    throw new IllegalStateException();
                }
            }
            Notification build = notificationCompat$Builder.build();
            if (i == 1 || i == 2 || i == 3) {
                GooglePlayServicesUtil.sCanceledAvailabilityNotification.set(false);
                i2 = 10436;
            } else {
                i2 = 39789;
            }
            notificationManager.notify(i2, build);
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public final void zag(Activity activity, LifecycleFragment lifecycleFragment, int i, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog zaa2 = zaa(activity, i, new zad(super.getErrorResolutionIntent(i, activity, "d"), lifecycleFragment, 1), onCancelListener);
        if (zaa2 != null) {
            zad(activity, zaa2, "GooglePlayServicesErrorDialog", onCancelListener);
        }
    }
}
