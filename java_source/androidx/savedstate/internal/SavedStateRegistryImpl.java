package androidx.savedstate.internal;

import android.os.Bundle;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda1;
import androidx.collection.internal.Lock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.navigation.fragment.FragmentNavigator$$ExternalSyntheticLambda0;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.LinkedHashMap;
/* loaded from: classes.dex */
public final class SavedStateRegistryImpl {
    public boolean attached;
    public boolean isRestored;
    public final ComponentActivity$$ExternalSyntheticLambda1 onAttach;
    public final SavedStateRegistryOwner owner;
    public Bundle restoredState;
    public final Lock lock = new Object();
    public final LinkedHashMap keyToProviders = new LinkedHashMap();
    public boolean isAllowingSavingState = true;

    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.collection.internal.Lock, java.lang.Object] */
    public SavedStateRegistryImpl(SavedStateRegistryOwner savedStateRegistryOwner, ComponentActivity$$ExternalSyntheticLambda1 componentActivity$$ExternalSyntheticLambda1) {
        this.owner = savedStateRegistryOwner;
        this.onAttach = componentActivity$$ExternalSyntheticLambda1;
    }

    public final void performAttach() {
        SavedStateRegistryOwner savedStateRegistryOwner = this.owner;
        if (((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        } else if (!this.attached) {
            this.onAttach.invoke();
            savedStateRegistryOwner.getLifecycle().addObserver(new FragmentNavigator$$ExternalSyntheticLambda0(2, this));
            this.attached = true;
        } else {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
    }
}
