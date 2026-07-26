package androidx.savedstate;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LegacySavedStateHandleController$OnRecreation;
import androidx.navigation.Navigation;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class SavedStateRegistry {
    public final SavedStateRegistryImpl impl;
    public AppCompatActivity.AnonymousClass1 recreatorProvider;

    /* loaded from: classes.dex */
    public interface AutoRecreated {
    }

    /* loaded from: classes.dex */
    public interface SavedStateProvider {
        Bundle saveState();
    }

    public SavedStateRegistry(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.impl = savedStateRegistryImpl;
    }

    public final Bundle consumeRestoredStateForKey(String str) {
        Bundle bundle;
        SavedStateRegistryImpl savedStateRegistryImpl = this.impl;
        if (savedStateRegistryImpl.isRestored) {
            Bundle bundle2 = savedStateRegistryImpl.restoredState;
            if (bundle2 == null) {
                return null;
            }
            if (bundle2.containsKey(str)) {
                bundle = bundle2.getBundle(str);
                if (bundle == null) {
                    Navigation.keyOrValueNotFoundError(str);
                    throw null;
                }
            } else {
                bundle = null;
            }
            bundle2.remove(str);
            if (bundle2.isEmpty()) {
                savedStateRegistryImpl.restoredState = null;
            }
            return bundle;
        }
        throw new IllegalStateException("You can 'consumeRestoredStateForKey' only after the corresponding component has moved to the 'CREATED' state");
    }

    public final SavedStateProvider getSavedStateProvider() {
        SavedStateProvider savedStateProvider;
        SavedStateRegistryImpl savedStateRegistryImpl = this.impl;
        synchronized (savedStateRegistryImpl.lock) {
            Iterator it = savedStateRegistryImpl.keyToProviders.entrySet().iterator();
            do {
                savedStateProvider = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                SavedStateProvider savedStateProvider2 = (SavedStateProvider) entry.getValue();
                if (Intrinsics.areEqual((String) entry.getKey(), "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                    savedStateProvider = savedStateProvider2;
                    continue;
                }
            } while (savedStateProvider == null);
        }
        return savedStateProvider;
    }

    public final void registerSavedStateProvider(String str, SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        SavedStateRegistryImpl savedStateRegistryImpl = this.impl;
        synchronized (savedStateRegistryImpl.lock) {
            if (!savedStateRegistryImpl.keyToProviders.containsKey(str)) {
                savedStateRegistryImpl.keyToProviders.put(str, provider);
            } else {
                throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
            }
        }
    }

    public final void runOnNextRecreation() {
        if (this.impl.isAllowingSavingState) {
            AppCompatActivity.AnonymousClass1 r1 = this.recreatorProvider;
            if (r1 == null) {
                r1 = new AppCompatActivity.AnonymousClass1(this);
            }
            this.recreatorProvider = r1;
            try {
                LegacySavedStateHandleController$OnRecreation.class.getDeclaredConstructor(null);
                AppCompatActivity.AnonymousClass1 r12 = this.recreatorProvider;
                if (r12 != null) {
                    ((LinkedHashSet) r12.this$0).add(LegacySavedStateHandleController$OnRecreation.class.getName());
                }
            } catch (NoSuchMethodException e) {
                throw new IllegalArgumentException("Class " + LegacySavedStateHandleController$OnRecreation.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }
}
