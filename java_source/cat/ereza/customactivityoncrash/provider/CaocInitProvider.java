package cat.ereza.customactivityoncrash.provider;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cat.ereza.customactivityoncrash.activity.DefaultErrorActivity;
import cat.ereza.customactivityoncrash.config.CaocConfig;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class CaocInitProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.app.Application$ActivityLifecycleCallbacks, java.lang.Object, cat.ereza.customactivityoncrash.CustomActivityOnCrash$1] */
    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context context = getContext();
        Application application = CustomActivityOnCrash.application;
        try {
            if (context == null) {
                Log.e("CustomActivityOnCrash", "Install failed: context is null!");
            } else {
                final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                if (defaultUncaughtExceptionHandler == null || !defaultUncaughtExceptionHandler.getClass().getName().startsWith("cat.ereza.customactivityoncrash")) {
                    if (defaultUncaughtExceptionHandler != null && !defaultUncaughtExceptionHandler.getClass().getName().startsWith("com.android.internal.os")) {
                        Log.e("CustomActivityOnCrash", "IMPORTANT WARNING! You already have an UncaughtExceptionHandler, are you sure this is correct? If you use a custom UncaughtExceptionHandler, you must initialize it AFTER CustomActivityOnCrash! Installing anyway, but your original handler will not be called.");
                    }
                    CustomActivityOnCrash.application = (Application) context.getApplicationContext();
                    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: cat.ereza.customactivityoncrash.CustomActivityOnCrash$$ExternalSyntheticLambda0
                        /* JADX WARN: Can't wrap try/catch for region: R(13:4|(2:6|(6:8|(2:10|11)|64|(1:66)|67|85))|12|(4:14|(4:16|75|17|(1:22))|20|(0))|73|23|(12:28|(4:29|(2:31|(1:38)(1:79))|81|39)|80|41|(1:43)|44|(5:46|(5:48|71|49|(3:54|(2:77|58)|61)|62)|52|(0)|62)|63|64|(0)|67|85)|35|(2:37|84)|64|(0)|67|85) */
                        /* JADX WARN: Code restructure failed: missing block: B:24:0x00ba, code lost:
                            r7 = null;
                         */
                        /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
                        /* JADX WARN: Removed duplicated region for block: B:54:0x0180  */
                        /* JADX WARN: Removed duplicated region for block: B:66:0x01c8  */
                        @Override // java.lang.Thread.UncaughtExceptionHandler
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void uncaughtException(Thread thread, Throwable th) {
                            Activity activity;
                            StackTraceElement[] stackTrace;
                            Class<?> cls;
                            boolean z = CustomActivityOnCrash.config.enabled;
                            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = defaultUncaughtExceptionHandler;
                            if (z) {
                                Log.e("CustomActivityOnCrash", "App has crashed, executing CustomActivityOnCrash's UncaughtExceptionHandler", th);
                                long j = CustomActivityOnCrash.application.getSharedPreferences("custom_activity_on_crash", 0).getLong("last_crash_timestamp", -1L);
                                long time = new Date().getTime();
                                if (j <= time) {
                                    Application application2 = CustomActivityOnCrash.application;
                                    if (time - j < 3000) {
                                        Log.e("CustomActivityOnCrash", "App already crashed recently, not starting custom error activity because we could enter a restart loop. Are you sure that your app does not crash directly on init?", th);
                                        if (uncaughtExceptionHandler != null) {
                                            uncaughtExceptionHandler.uncaughtException(thread, th);
                                            return;
                                        }
                                        activity = (Activity) CustomActivityOnCrash.lastActivityCreated.get();
                                        if (activity != null) {
                                            activity.finish();
                                            CustomActivityOnCrash.lastActivityCreated.clear();
                                        }
                                        Process.killProcess(Process.myPid());
                                        System.exit(10);
                                    }
                                }
                                CustomActivityOnCrash.application.getSharedPreferences("custom_activity_on_crash", 0).edit().putLong("last_crash_timestamp", new Date().getTime()).commit();
                                Class cls2 = CustomActivityOnCrash.config.errorActivityClass;
                                Class<?> cls3 = null;
                                if (cls2 == null) {
                                    Application application3 = CustomActivityOnCrash.application;
                                    List<ResolveInfo> queryIntentActivities = application3.getPackageManager().queryIntentActivities(new Intent().setAction("cat.ereza.customactivityoncrash.ERROR").setPackage(application3.getPackageName()), 64);
                                    if (queryIntentActivities.size() > 0) {
                                        try {
                                            cls2 = Class.forName(queryIntentActivities.get(0).activityInfo.name);
                                        } catch (ClassNotFoundException e) {
                                            Log.e("CustomActivityOnCrash", "Failed when resolving the error activity class via intent filter, stack trace follows!", e);
                                        }
                                        if (cls2 == null) {
                                            cls2 = DefaultErrorActivity.class;
                                        }
                                    }
                                    cls2 = null;
                                    if (cls2 == null) {
                                    }
                                }
                                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/cmdline"));
                                String str = bufferedReader.readLine().trim();
                                bufferedReader.close();
                                if (str == null || !str.endsWith(":error_activity")) {
                                    Throwable th2 = th;
                                    do {
                                        for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                                            if (!stackTraceElement.getClassName().equals("android.app.ActivityThread") || !stackTraceElement.getMethodName().equals("handleBindApplication")) {
                                            }
                                        }
                                        th2 = th2.getCause();
                                    } while (th2 != null);
                                    Application application4 = CustomActivityOnCrash.application;
                                    Intent intent = new Intent(CustomActivityOnCrash.application, cls2);
                                    StringWriter stringWriter = new StringWriter();
                                    th.printStackTrace(new PrintWriter(stringWriter));
                                    String stringWriter2 = stringWriter.toString();
                                    if (stringWriter2.length() > 131071) {
                                        stringWriter2 = stringWriter2.substring(0, 131047) + " [stack trace too large]";
                                    }
                                    intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE", stringWriter2);
                                    CaocConfig caocConfig = CustomActivityOnCrash.config;
                                    if (caocConfig.restartActivityClass == null) {
                                        Application application5 = CustomActivityOnCrash.application;
                                        List<ResolveInfo> queryIntentActivities2 = application5.getPackageManager().queryIntentActivities(new Intent().setAction("cat.ereza.customactivityoncrash.RESTART").setPackage(application5.getPackageName()), 64);
                                        if (queryIntentActivities2.size() > 0) {
                                            try {
                                                cls = Class.forName(queryIntentActivities2.get(0).activityInfo.name);
                                            } catch (ClassNotFoundException e2) {
                                                Log.e("CustomActivityOnCrash", "Failed when resolving the restart activity class via intent filter, stack trace follows!", e2);
                                            }
                                            if (cls == null) {
                                                Intent launchIntentForPackage = application5.getPackageManager().getLaunchIntentForPackage(application5.getPackageName());
                                                if (!(launchIntentForPackage == null || launchIntentForPackage.getComponent() == null)) {
                                                    try {
                                                        cls3 = Class.forName(launchIntentForPackage.getComponent().getClassName());
                                                    } catch (ClassNotFoundException e3) {
                                                        Log.e("CustomActivityOnCrash", "Failed when resolving the restart activity class via getLaunchIntentForPackage, stack trace follows!", e3);
                                                    }
                                                }
                                                cls = cls3;
                                            }
                                            caocConfig.restartActivityClass = cls;
                                        }
                                        cls = null;
                                        if (cls == null) {
                                        }
                                        caocConfig.restartActivityClass = cls;
                                    }
                                    intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_CONFIG", CustomActivityOnCrash.config);
                                    intent.setFlags(268468224);
                                    Application application6 = CustomActivityOnCrash.application;
                                    CustomActivityOnCrash.application.startActivity(intent);
                                    activity = (Activity) CustomActivityOnCrash.lastActivityCreated.get();
                                    if (activity != null) {
                                    }
                                    Process.killProcess(Process.myPid());
                                    System.exit(10);
                                }
                                Log.e("CustomActivityOnCrash", "Your application class or your error activity have crashed, the custom activity will not be launched!");
                                if (uncaughtExceptionHandler != null) {
                                    uncaughtExceptionHandler.uncaughtException(thread, th);
                                    return;
                                }
                                activity = (Activity) CustomActivityOnCrash.lastActivityCreated.get();
                                if (activity != null) {
                                }
                                Process.killProcess(Process.myPid());
                                System.exit(10);
                            } else if (uncaughtExceptionHandler != null) {
                                uncaughtExceptionHandler.uncaughtException(thread, th);
                            }
                        }
                    });
                    Application application2 = CustomActivityOnCrash.application;
                    ?? obj = new Object();
                    obj.currentlyStartedActivities = 0;
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    application2.registerActivityLifecycleCallbacks(obj);
                } else {
                    Log.e("CustomActivityOnCrash", "CustomActivityOnCrash was already installed, doing nothing!");
                }
                Log.i("CustomActivityOnCrash", "CustomActivityOnCrash has been installed.");
            }
        } catch (Throwable th) {
            Log.e("CustomActivityOnCrash", "An unknown error occurred while installing CustomActivityOnCrash, it may not have been properly initialized. Please report this as a bug if needed.", th);
        }
        return false;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
