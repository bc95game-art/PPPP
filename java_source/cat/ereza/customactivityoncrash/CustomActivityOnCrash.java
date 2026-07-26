package cat.ereza.customactivityoncrash;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.lifecycle.ViewModelProvider;
import cat.ereza.customactivityoncrash.config.CaocConfig;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Locale;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public abstract class CustomActivityOnCrash {
    public static Application application;
    public static CaocConfig config = new CaocConfig();
    public static WeakReference lastActivityCreated = new WeakReference(null);

    /* renamed from: cat.ereza.customactivityoncrash.CustomActivityOnCrash$1 */
    /* loaded from: classes.dex */
    public final class C01241 implements Application.ActivityLifecycleCallbacks {
        public int currentlyStartedActivities;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity.getClass() != CustomActivityOnCrash.config.errorActivityClass) {
                CustomActivityOnCrash.lastActivityCreated = new WeakReference(activity);
                new Date().getTime();
                Application application = CustomActivityOnCrash.application;
            }
            Application application2 = CustomActivityOnCrash.application;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            Application application = CustomActivityOnCrash.application;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            Application application = CustomActivityOnCrash.application;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Application application = CustomActivityOnCrash.application;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            this.currentlyStartedActivities++;
            Application application = CustomActivityOnCrash.application;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            this.currentlyStartedActivities--;
            Application application = CustomActivityOnCrash.application;
        }
    }

    static {
        new ArrayDeque(50);
    }

    public static String capitalize(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static String getAllErrorDetailsFromIntent(Context context, Intent intent) {
        long j;
        String str;
        String str2;
        String str3;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        try {
            ZipFile zipFile = new ZipFile(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir);
            j = zipFile.getEntry("classes.dex").getTime();
            zipFile.close();
        } catch (Exception unused) {
            j = 0;
        }
        if (j > 631152000000L) {
            str = simpleDateFormat.format(new Date(j));
        } else {
            str = null;
        }
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused2) {
            str2 = "Unknown";
        }
        String m = ViewModelProvider.Factory.CC.m595m("Build version: ", str2, " \n");
        if (str != null) {
            m = m + "Build date: " + str + " \n";
        }
        String str4 = m + "Current date: " + simpleDateFormat.format(date) + " \n";
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append("Device: ");
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (str6.startsWith(str5)) {
            str3 = capitalize(str6);
        } else {
            str3 = capitalize(str5) + " " + str6;
        }
        String m2 = ViewModelProvider.Factory.CC.m596m(ViewModelProvider.Factory.CC.m593m(sb, str3, " \n") + "OS version: Android " + Build.VERSION.RELEASE + " (SDK " + Build.VERSION.SDK_INT + ") \n \n", "Stack trace:  \n");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m2);
        sb2.append(intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE"));
        String sb3 = sb2.toString();
        String stringExtra = intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_ACTIVITY_LOG");
        if (stringExtra != null) {
            sb3 = ViewModelProvider.Factory.CC.m596m(ViewModelProvider.Factory.CC.m596m(sb3, "\nUser actions: \n"), stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_CUSTOM_CRASH_DATA");
        if (stringExtra2 != null) {
            return ViewModelProvider.Factory.CC.m596m(ViewModelProvider.Factory.CC.m596m(sb3, "\nAdditional data: \n"), stringExtra2);
        }
        return sb3;
    }

    public static CaocConfig getConfigFromIntent(Intent intent) {
        CaocConfig caocConfig = (CaocConfig) intent.getSerializableExtra("cat.ereza.customactivityoncrash.EXTRA_CONFIG");
        if (!(caocConfig == null || intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE") == null)) {
            Log.e("CustomActivityOnCrash", "The previous app process crashed. This is the stack trace of the crash:\n" + intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE"));
        }
        return caocConfig;
    }

    public static void restartApplication(Activity activity, CaocConfig caocConfig) {
        Intent intent = new Intent(activity, caocConfig.restartActivityClass);
        intent.addFlags(270565376);
        if (intent.getComponent() != null) {
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
        }
        activity.finish();
        activity.startActivity(intent);
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}
