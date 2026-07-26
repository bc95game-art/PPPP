package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.tasks.zzi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
/* loaded from: classes.dex */
public abstract class ActivityRecreator {
    public static final Class activityThreadClass;
    public static final Handler mainHandler = new Handler(Looper.getMainLooper());
    public static final Field mainThreadField;
    public static final Method performStopActivity2ParamsMethod;
    public static final Method performStopActivity3ParamsMethod;
    public static final Method requestRelaunchActivityMethod;
    public static final Field tokenField;

    /* loaded from: classes.dex */
    public final class LifecycleCheckCallbacks implements Application.ActivityLifecycleCallbacks {
        public Object currentlyRecreatingToken;
        public Activity mActivity;
        public final int mRecreatingHashCode;
        public boolean mStarted = false;
        public boolean mDestroyed = false;
        public boolean mStopQueued = false;

        public LifecycleCheckCallbacks(Activity activity) {
            this.mActivity = activity;
            this.mRecreatingHashCode = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            if (this.mActivity == activity) {
                this.mActivity = null;
                this.mDestroyed = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            if (this.mDestroyed && !this.mStopQueued && !this.mStarted) {
                Object obj = this.currentlyRecreatingToken;
                try {
                    Object obj2 = ActivityRecreator.tokenField.get(activity);
                    if (obj2 == obj && activity.hashCode() == this.mRecreatingHashCode) {
                        ActivityRecreator.mainHandler.postAtFrontOfQueue(new zzi(ActivityRecreator.mainThreadField.get(activity), 3, obj2));
                        this.mStopQueued = true;
                        this.currentlyRecreatingToken = null;
                    }
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while fetching field values", th);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (this.mActivity == activity) {
                this.mStarted = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:2|37|3|5|33|6|8|31|9|11|(12:35|14|16|(6:41|19|21|(3:39|26|27)|28|29)|18|21|(1:23)|39|26|27|28|29)|13|16|(0)|18|21|(0)|39|26|27|28|29) */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Class<?> cls;
        Field field;
        Field field2;
        Method declaredMethod;
        Class cls2;
        Method declaredMethod2;
        Class cls3;
        int i;
        Method method = null;
        try {
            cls = Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            cls = null;
        }
        activityThreadClass = cls;
        try {
            field = Activity.class.getDeclaredField("mMainThread");
            field.setAccessible(true);
        } catch (Throwable unused2) {
            field = null;
        }
        mainThreadField = field;
        try {
            field2 = Activity.class.getDeclaredField("mToken");
            field2.setAccessible(true);
        } catch (Throwable unused3) {
            field2 = null;
        }
        tokenField = field2;
        Class cls4 = activityThreadClass;
        Class<?> cls5 = Boolean.TYPE;
        if (cls4 != null) {
            try {
                declaredMethod = cls4.getDeclaredMethod("performStopActivity", IBinder.class, cls5, String.class);
                declaredMethod.setAccessible(true);
            } catch (Throwable unused4) {
            }
            performStopActivity3ParamsMethod = declaredMethod;
            cls2 = activityThreadClass;
            if (cls2 != null) {
                try {
                    declaredMethod2 = cls2.getDeclaredMethod("performStopActivity", IBinder.class, cls5);
                    declaredMethod2.setAccessible(true);
                } catch (Throwable unused5) {
                }
                performStopActivity2ParamsMethod = declaredMethod2;
                cls3 = activityThreadClass;
                i = Build.VERSION.SDK_INT;
                if ((i != 26 || i == 27) && cls3 != null) {
                    Method declaredMethod3 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls5, Configuration.class, Configuration.class, cls5, cls5);
                    declaredMethod3.setAccessible(true);
                    method = declaredMethod3;
                }
                requestRelaunchActivityMethod = method;
            }
            declaredMethod2 = null;
            performStopActivity2ParamsMethod = declaredMethod2;
            cls3 = activityThreadClass;
            i = Build.VERSION.SDK_INT;
            if (i != 26) {
            }
            Method declaredMethod32 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls5, Configuration.class, Configuration.class, cls5, cls5);
            declaredMethod32.setAccessible(true);
            method = declaredMethod32;
            requestRelaunchActivityMethod = method;
        }
        declaredMethod = null;
        performStopActivity3ParamsMethod = declaredMethod;
        cls2 = activityThreadClass;
        if (cls2 != null) {
        }
        declaredMethod2 = null;
        performStopActivity2ParamsMethod = declaredMethod2;
        cls3 = activityThreadClass;
        i = Build.VERSION.SDK_INT;
        if (i != 26) {
        }
        Method declaredMethod322 = cls3.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls5, Configuration.class, Configuration.class, cls5, cls5);
        declaredMethod322.setAccessible(true);
        method = declaredMethod322;
        requestRelaunchActivityMethod = method;
    }
}
