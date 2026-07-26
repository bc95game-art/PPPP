package androidx.navigation.internal;

import android.os.Bundle;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda1;
import androidx.collection.internal.LruHashMap;
import androidx.core.p002os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.Navigation$$ExternalSyntheticLambda0;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public final class NavBackStackEntryImpl {
    public final NavDestination destination;
    public final NavBackStackEntry entry;
    public Lifecycle.State hostLifecycleState;

    /* renamed from: id */
    public final String f11id;
    public final Bundle immutableArgs;
    public final LifecycleRegistry lifecycle;
    public Lifecycle.State maxLifecycle = Lifecycle.State.INITIALIZED;
    public final Bundle savedState;
    public boolean savedStateRegistryAttached;
    public final SavedStateRegistryController savedStateRegistryController;
    public final NavControllerViewModel viewModelStoreProvider;

    /* loaded from: classes.dex */
    public final class SavedStateViewModel extends ViewModel {
        public SavedStateViewModel(SavedStateHandle handle) {
            Intrinsics.checkNotNullParameter(handle, "handle");
        }
    }

    public NavBackStackEntryImpl(NavBackStackEntry navBackStackEntry) {
        this.entry = navBackStackEntry;
        this.destination = navBackStackEntry.destination;
        this.immutableArgs = navBackStackEntry.immutableArgs;
        this.hostLifecycleState = navBackStackEntry.hostLifecycleState;
        this.viewModelStoreProvider = navBackStackEntry.viewModelStoreProvider;
        this.f11id = navBackStackEntry.f10id;
        this.savedState = navBackStackEntry.savedState;
        this.savedStateRegistryController = new SavedStateRegistryController(new SavedStateRegistryImpl(navBackStackEntry, new ComponentActivity$$ExternalSyntheticLambda1(4, navBackStackEntry)));
        SynchronizedLazyImpl synchronizedLazyImpl = new SynchronizedLazyImpl(new Function0() { // from class: androidx.navigation.internal.NavBackStackEntryImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (r1) {
                    case 0:
                        return new SavedStateViewModelFactory();
                    default:
                        LruHashMap lruHashMap = new LruHashMap(1);
                        lruHashMap.addInitializer(Reflection.getOrCreateKotlinClass(NavBackStackEntryImpl.SavedStateViewModel.class), new Navigation$$ExternalSyntheticLambda0(8));
                        return lruHashMap.build();
                }
            }
        });
        this.lifecycle = new LifecycleRegistry(navBackStackEntry);
        SavedStateViewModelFactory savedStateViewModelFactory = (SavedStateViewModelFactory) synchronizedLazyImpl.getValue();
        new SynchronizedLazyImpl(new Function0() { // from class: androidx.navigation.internal.NavBackStackEntryImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                switch (r1) {
                    case 0:
                        return new SavedStateViewModelFactory();
                    default:
                        LruHashMap lruHashMap = new LruHashMap(1);
                        lruHashMap.addInitializer(Reflection.getOrCreateKotlinClass(NavBackStackEntryImpl.SavedStateViewModel.class), new Navigation$$ExternalSyntheticLambda0(8));
                        return lruHashMap.build();
                }
            }
        });
    }

    public final Bundle getArguments$navigation_common_release() {
        Bundle bundle = this.immutableArgs;
        if (bundle == null) {
            return null;
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        bundleOf.putAll(bundle);
        return bundleOf;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Reflection.getOrCreateKotlinClass(NavBackStackEntry.class).getSimpleName());
        sb.append("(" + this.f11id + ')');
        sb.append(" destination=");
        sb.append(this.destination);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void updateState$navigation_common_release() {
        if (!this.savedStateRegistryAttached) {
            SavedStateRegistryController savedStateRegistryController = this.savedStateRegistryController;
            savedStateRegistryController.performAttach();
            this.savedStateRegistryAttached = true;
            if (this.viewModelStoreProvider != null) {
                SavedStateHandleSupport.enableSavedStateHandles(this.entry);
            }
            SavedStateRegistryImpl savedStateRegistryImpl = savedStateRegistryController.impl;
            SavedStateRegistryOwner savedStateRegistryOwner = savedStateRegistryImpl.owner;
            if (!savedStateRegistryImpl.attached) {
                savedStateRegistryImpl.performAttach();
            }
            if (((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state.compareTo(Lifecycle.State.STARTED) >= 0) {
                throw new IllegalStateException(("performRestore cannot be called when owner is " + ((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state).toString());
            } else if (!savedStateRegistryImpl.isRestored) {
                Bundle bundle = null;
                Bundle bundle2 = this.savedState;
                if (bundle2 != null && bundle2.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
                    Bundle bundle3 = bundle2.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                    if (bundle3 != null) {
                        bundle = bundle3;
                    } else {
                        Navigation.keyOrValueNotFoundError("androidx.lifecycle.BundlableSavedStateRegistry.key");
                        throw null;
                    }
                }
                savedStateRegistryImpl.restoredState = bundle;
                savedStateRegistryImpl.isRestored = true;
            } else {
                throw new IllegalStateException("SavedStateRegistry was already restored.");
            }
        }
        int ordinal = this.hostLifecycleState.ordinal();
        int ordinal2 = this.maxLifecycle.ordinal();
        LifecycleRegistry lifecycleRegistry = this.lifecycle;
        if (ordinal < ordinal2) {
            lifecycleRegistry.setCurrentState(this.hostLifecycleState);
        } else {
            lifecycleRegistry.setCurrentState(this.maxLifecycle);
        }
    }
}
