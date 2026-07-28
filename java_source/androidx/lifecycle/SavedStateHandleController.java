package androidx.lifecycle;

import androidx.activity.ComponentActivity$$ExternalSyntheticLambda2;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class SavedStateHandleController implements LifecycleEventObserver, AutoCloseable {
    public final SavedStateHandle handle;
    public boolean isAttached;
    public final String key;

    public SavedStateHandleController(String str, SavedStateHandle savedStateHandle) {
        this.key = str;
        this.handle = savedStateHandle;
    }

    public final void attachToLifecycle(SavedStateRegistry registry, Lifecycle lifecycle) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (!this.isAttached) {
            this.isAttached = true;
            lifecycle.addObserver(this);
            registry.registerSavedStateProvider(this.key, (ComponentActivity$$ExternalSyntheticLambda2) this.handle.impl.mCertificates);
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner");
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.isAttached = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
