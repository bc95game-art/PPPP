package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.navigation.internal.NavContext;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class NavBackStackEntry implements LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    public final NavContext context;
    public NavDestination destination;
    public Lifecycle.State hostLifecycleState;

    /* renamed from: id */
    public final String f10id;
    public final Bundle immutableArgs;
    public final NavBackStackEntryImpl impl = new NavBackStackEntryImpl(this);
    public final Bundle savedState;
    public final NavControllerViewModel viewModelStoreProvider;

    public NavBackStackEntry(NavContext navContext, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavControllerViewModel navControllerViewModel, String str, Bundle bundle2) {
        this.context = navContext;
        this.destination = navDestination;
        this.immutableArgs = bundle;
        this.hostLifecycleState = state;
        this.viewModelStoreProvider = navControllerViewModel;
        this.f10id = str;
        this.savedState = bundle2;
    }

    public final boolean equals(Object obj) {
        Set<String> keySet;
        Object obj2;
        if (obj != null && (obj instanceof NavBackStackEntry)) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            Bundle bundle = navBackStackEntry.immutableArgs;
            if (Intrinsics.areEqual(this.f10id, navBackStackEntry.f10id) && Intrinsics.areEqual(this.destination, navBackStackEntry.destination) && Intrinsics.areEqual(this.impl.lifecycle, navBackStackEntry.impl.lifecycle) && Intrinsics.areEqual(getSavedStateRegistry(), navBackStackEntry.getSavedStateRegistry())) {
                Bundle bundle2 = this.immutableArgs;
                if (Intrinsics.areEqual(bundle2, bundle)) {
                    return true;
                }
                if (!(bundle2 == null || (keySet = bundle2.keySet()) == null)) {
                    if (keySet.isEmpty()) {
                        return true;
                    }
                    for (String str : keySet) {
                        Object obj3 = bundle2.get(str);
                        if (bundle != null) {
                            obj2 = bundle.get(str);
                        } else {
                            obj2 = null;
                        }
                        if (!Intrinsics.areEqual(obj3, obj2)) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        NavBackStackEntryImpl navBackStackEntryImpl = this.impl;
        navBackStackEntryImpl.getClass();
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(0);
        NavBackStackEntry navBackStackEntry = navBackStackEntryImpl.entry;
        LinkedHashMap linkedHashMap = mutableCreationExtras.extras;
        linkedHashMap.put(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, navBackStackEntry);
        linkedHashMap.put(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, navBackStackEntry);
        Bundle arguments$navigation_common_release = navBackStackEntryImpl.getArguments$navigation_common_release();
        if (arguments$navigation_common_release != null) {
            linkedHashMap.put(SavedStateHandleSupport.DEFAULT_ARGS_KEY, arguments$navigation_common_release);
        }
        Application application2 = null;
        NavContext navContext = this.context;
        if (navContext != null) {
            Context applicationContext = navContext.context.getApplicationContext();
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                if (application != null) {
                    application2 = application;
                }
                if (application2 != null) {
                    linkedHashMap.put(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, application2);
                }
                return mutableCreationExtras;
            }
        }
        application = null;
        if (application != null) {
        }
        if (application2 != null) {
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.impl.lifecycle;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.impl.savedStateRegistryController.savedStateRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        NavBackStackEntryImpl navBackStackEntryImpl = this.impl;
        if (!navBackStackEntryImpl.savedStateRegistryAttached) {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels until it is added to the NavController's back stack (i.e., the Lifecycle of the NavBackStackEntry reaches the CREATED state).");
        } else if (navBackStackEntryImpl.lifecycle.state != Lifecycle.State.DESTROYED) {
            NavControllerViewModel navControllerViewModel = navBackStackEntryImpl.viewModelStoreProvider;
            if (navControllerViewModel != null) {
                String backStackEntryId = navBackStackEntryImpl.f11id;
                Intrinsics.checkNotNullParameter(backStackEntryId, "backStackEntryId");
                LinkedHashMap linkedHashMap = navControllerViewModel.viewModelStores;
                ViewModelStore viewModelStore = (ViewModelStore) linkedHashMap.get(backStackEntryId);
                if (viewModelStore != null) {
                    return viewModelStore;
                }
                ViewModelStore viewModelStore2 = new ViewModelStore();
                linkedHashMap.put(backStackEntryId, viewModelStore2);
                return viewModelStore2;
            }
            throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
        } else {
            throw new IllegalStateException("You cannot access the NavBackStackEntry's ViewModels after the NavBackStackEntry is destroyed.");
        }
    }

    public final int hashCode() {
        Set<String> keySet;
        int i;
        int hashCode = this.destination.hashCode() + (this.f10id.hashCode() * 31);
        Bundle bundle = this.immutableArgs;
        if (!(bundle == null || (keySet = bundle.keySet()) == null)) {
            for (String str : keySet) {
                int i2 = hashCode * 31;
                Object obj = bundle.get(str);
                if (obj != null) {
                    i = obj.hashCode();
                } else {
                    i = 0;
                }
                hashCode = i2 + i;
            }
        }
        return getSavedStateRegistry().hashCode() + ((this.impl.lifecycle.hashCode() + (hashCode * 31)) * 31);
    }

    public final void setMaxLifecycle(Lifecycle.State state) {
        NavBackStackEntryImpl navBackStackEntryImpl = this.impl;
        navBackStackEntryImpl.getClass();
        navBackStackEntryImpl.maxLifecycle = state;
        navBackStackEntryImpl.updateState$navigation_common_release();
    }

    public final String toString() {
        return this.impl.toString();
    }
}
