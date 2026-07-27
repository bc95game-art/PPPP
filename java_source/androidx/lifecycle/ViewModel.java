package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
/* loaded from: classes.dex */
public abstract class ViewModel {
    public final ViewModelImpl impl = new ViewModelImpl();

    public final void clear$lifecycle_viewmodel_release() {
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null && !viewModelImpl.isCleared) {
            viewModelImpl.isCleared = true;
            synchronized (viewModelImpl.lock) {
                try {
                    for (AutoCloseable autoCloseable : viewModelImpl.keyToCloseables.values()) {
                        ViewModelImpl.closeWithRuntimeException(autoCloseable);
                    }
                    for (AutoCloseable autoCloseable2 : viewModelImpl.closeables) {
                        ViewModelImpl.closeWithRuntimeException(autoCloseable2);
                    }
                    viewModelImpl.closeables.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        onCleared();
    }

    public void onCleared() {
    }
}
