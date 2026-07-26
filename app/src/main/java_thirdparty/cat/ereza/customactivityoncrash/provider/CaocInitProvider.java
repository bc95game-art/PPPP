package cat.ereza.customactivityoncrash.provider;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import java.lang.Thread;
import java.text.SimpleDateFormat;
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
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final void uncaughtException(java.lang.Thread r14, java.lang.Throwable r15) {
                            /*
                                Method dump skipped, instructions count: 483
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: cat.ereza.customactivityoncrash.CustomActivityOnCrash$$ExternalSyntheticLambda0.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
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
