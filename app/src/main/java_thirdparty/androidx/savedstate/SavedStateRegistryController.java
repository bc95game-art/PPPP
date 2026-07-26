package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.navigation.Navigation;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
/* loaded from: classes.dex */
public final class SavedStateRegistryController {
    public final SavedStateRegistryImpl impl;
    public final SavedStateRegistry savedStateRegistry;

    public SavedStateRegistryController(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.impl = savedStateRegistryImpl;
        this.savedStateRegistry = new SavedStateRegistry(savedStateRegistryImpl);
    }

    public final void performAttach() {
        this.impl.performAttach();
    }

    public final void performSave(Bundle bundle) {
        SavedStateRegistryImpl savedStateRegistryImpl = this.impl;
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle2 = savedStateRegistryImpl.restoredState;
        if (bundle2 != null) {
            bundleOf.putAll(bundle2);
        }
        synchronized (savedStateRegistryImpl.lock) {
            for (Map.Entry entry : savedStateRegistryImpl.keyToProviders.entrySet()) {
                Navigation.m24putSavedStateimpl(bundleOf, (String) entry.getKey(), ((SavedStateRegistry.SavedStateProvider) entry.getValue()).saveState());
            }
        }
        if (!bundleOf.isEmpty()) {
            Navigation.m24putSavedStateimpl(bundle, "androidx.lifecycle.BundlableSavedStateRegistry.key", bundleOf);
        }
    }
}
