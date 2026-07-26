package androidx.appcompat.app;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.core.app.NavUtils;
import androidx.core.p002os.LocaleListCompat;
import androidx.core.p002os.LocaleListPlatformWrapper;
import androidx.profileinstaller.Encoding;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final /* synthetic */ class AppCompatDelegate$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Context f$0;

    public /* synthetic */ AppCompatDelegate$$ExternalSyntheticLambda0(Context context, int i) {
        this.$r8$classId = i;
        this.f$0 = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x008a, code lost:
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.util.concurrent.Executor, java.lang.Object] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        LocaleListCompat localeListCompat;
        Object obj;
        Context context;
        switch (this.$r8$classId) {
            case 0:
                int i = Build.VERSION.SDK_INT;
                if (i >= 33) {
                    Context context2 = this.f$0;
                    ComponentName componentName = new ComponentName(context2, "androidx.appcompat.app.AppLocalesMetadataHolderService");
                    if (context2.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                        if (i < 33) {
                            localeListCompat = AppCompatDelegate.sRequestedAppLocales;
                            break;
                        } else {
                            ArraySet arraySet = AppCompatDelegate.sActivityDelegates;
                            arraySet.getClass();
                            ArrayMap.KeyIterator keyIterator = new ArrayMap.KeyIterator(arraySet);
                            while (true) {
                                if (keyIterator.hasNext()) {
                                    AppCompatDelegate appCompatDelegate = (AppCompatDelegate) ((WeakReference) keyIterator.next()).get();
                                    if (appCompatDelegate != null && (context = ((AppCompatDelegateImpl) appCompatDelegate).mContext) != null) {
                                        obj = context.getSystemService("locale");
                                    }
                                } else {
                                    obj = null;
                                }
                            }
                            if (obj != null) {
                                localeListCompat = new LocaleListCompat(new LocaleListPlatformWrapper(AppCompatDelegate.Api33Impl.localeManagerGetApplicationLocales(obj)));
                                if (localeListCompat.mImpl.isEmpty()) {
                                    String readLocales = NavUtils.readLocales(context2);
                                    Object systemService = context2.getSystemService("locale");
                                    if (systemService != null) {
                                        AppCompatDelegate.Api33Impl.localeManagerSetApplicationLocales(systemService, AppCompatDelegate.Api24Impl.localeListForLanguageTags(readLocales));
                                    }
                                }
                                context2.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                            }
                            localeListCompat = LocaleListCompat.sEmptyLocaleList;
                            if (localeListCompat.mImpl.isEmpty()) {
                            }
                            context2.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
                        }
                    }
                }
                AppCompatDelegate.sIsFrameworkSyncChecked = true;
                return;
            case 1:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new AppCompatDelegate$$ExternalSyntheticLambda0(this.f$0, 2));
                return;
            default:
                Encoding.writeProfile(this.f$0, new Object(), Encoding.EMPTY_DIAGNOSTICS, false);
                return;
        }
    }
}
