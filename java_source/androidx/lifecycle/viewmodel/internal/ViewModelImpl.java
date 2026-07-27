package androidx.lifecycle.viewmodel.internal;

import androidx.collection.internal.Lock;
import androidx.lifecycle.ViewModelProvider;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
/* loaded from: classes.dex */
public final class ViewModelImpl {
    public volatile boolean isCleared;
    public final Lock lock = new Object();
    public final LinkedHashMap keyToCloseables = new LinkedHashMap();
    public final LinkedHashSet closeables = new LinkedHashSet();

    public static void closeWithRuntimeException(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                ViewModelProvider.Factory.CC.m601m(autoCloseable);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
