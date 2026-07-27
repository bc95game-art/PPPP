package androidx.appcompat.app;

import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppLocalesMetadataHolderService;
import androidx.appcompat.view.ActionMode;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda0;
import androidx.core.p002os.LocaleListCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class AppCompatDelegate {
    public static final SerialExecutor sSerialExecutorForLocalesStorage = new SerialExecutor(new Object());
    public static final int sDefaultNightMode = -100;
    public static LocaleListCompat sRequestedAppLocales = null;
    public static LocaleListCompat sStoredAppLocales = null;
    public static Boolean sIsAutoStoreLocalesOptedIn = null;
    public static boolean sIsFrameworkSyncChecked = false;
    public static final ArraySet sActivityDelegates = new ArraySet(0);
    public static final Object sActivityDelegatesLock = new Object();
    public static final Object sAppLocalesStorageSyncLock = new Object();

    /* loaded from: classes.dex */
    public abstract class Api24Impl {
        public static LocaleList localeListForLanguageTags(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api33Impl {
        public static LocaleList localeManagerGetApplicationLocales(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void localeManagerSetApplicationLocales(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    /* loaded from: classes.dex */
    public final class SerialExecutor implements Executor {
        public Runnable mActive;
        public final ThreadPerTaskExecutor mExecutor;
        public final Object mLock = new Object();
        public final ArrayDeque mTasks = new ArrayDeque();

        public SerialExecutor(ThreadPerTaskExecutor threadPerTaskExecutor) {
            this.mExecutor = threadPerTaskExecutor;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            synchronized (this.mLock) {
                try {
                    this.mTasks.add(new ResourcesCompat$FontCallback$$ExternalSyntheticLambda0(this, 1, runnable));
                    if (this.mActive == null) {
                        scheduleNext();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void scheduleNext() {
            synchronized (this.mLock) {
                try {
                    Runnable runnable = (Runnable) this.mTasks.poll();
                    this.mActive = runnable;
                    if (runnable != null) {
                        this.mExecutor.execute(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public final class ThreadPerTaskExecutor implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    public static boolean isAutoStorageOptedIn(Context context) {
        int i;
        if (sIsAutoStoreLocalesOptedIn == null) {
            try {
                int i2 = AppLocalesMetadataHolderService.$r8$clinit;
                if (Build.VERSION.SDK_INT >= 24) {
                    i = AppLocalesMetadataHolderService.Api24Impl.getDisabledComponentFlag() | 128;
                } else {
                    i = 640;
                }
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), i).metaData;
                if (bundle != null) {
                    sIsAutoStoreLocalesOptedIn = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                sIsAutoStoreLocalesOptedIn = Boolean.FALSE;
            }
        }
        return sIsAutoStoreLocalesOptedIn.booleanValue();
    }

    public static void removeDelegateFromActives(AppCompatDelegateImpl appCompatDelegateImpl) {
        synchronized (sActivityDelegatesLock) {
            try {
                ArraySet arraySet = sActivityDelegates;
                arraySet.getClass();
                ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(arraySet);
                while (keyIterator.hasNext()) {
                    AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) keyIterator.next()).get();
                    if (appCompatDelegate == appCompatDelegateImpl || appCompatDelegate == null) {
                        keyIterator.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void setTitle(CharSequence charSequence);

    public abstract ActionMode startSupportActionMode(ActionMode.Callback callback);
}
