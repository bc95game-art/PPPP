package androidx.arch.core.executor;

import android.os.Looper;
import androidx.core.p002os.BundleKt;
/* loaded from: classes.dex */
public final class ArchTaskExecutor extends BundleKt {
    public static volatile ArchTaskExecutor sInstance;
    public final DefaultTaskExecutor mDelegate = new DefaultTaskExecutor();

    public static ArchTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (ArchTaskExecutor.class) {
            try {
                if (sInstance == null) {
                    sInstance = new ArchTaskExecutor();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sInstance;
    }

    public final void postToMainThread(Runnable runnable) {
        DefaultTaskExecutor defaultTaskExecutor = this.mDelegate;
        if (defaultTaskExecutor.mMainHandler == null) {
            synchronized (defaultTaskExecutor.mLock) {
                try {
                    if (defaultTaskExecutor.mMainHandler == null) {
                        defaultTaskExecutor.mMainHandler = DefaultTaskExecutor.createAsync(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        defaultTaskExecutor.mMainHandler.post(runnable);
    }
}
