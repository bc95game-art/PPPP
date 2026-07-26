package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.os.BundleKt;
import androidx.loader.content.ModernAsyncTask$1;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public final class DefaultTaskExecutor extends BundleKt {
    public final Object mLock = new Object();
    public volatile Handler mMainHandler;

    /* loaded from: classes.dex */
    public abstract class Api28Impl {
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public DefaultTaskExecutor() {
        Executors.newFixedThreadPool(4, new ModernAsyncTask$1(1));
    }

    public static Handler createAsync(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createAsync(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }
}
