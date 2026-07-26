package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.fragment.FragmentNavigator$$ExternalSyntheticLambda6;
import androidx.navigation.internal.NavContext;
import androidx.navigation.internal.NavControllerImpl;
import androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda2;
import androidx.transition.ViewUtilsApi21;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
/* loaded from: classes.dex */
public abstract class NavController {
    public final Activity activity;
    public final Context context;
    public boolean deepLinkHandled;
    public final boolean enableOnBackPressedCallback;
    public final NavControllerImpl impl = new NavControllerImpl(this, new NavController$$ExternalSyntheticLambda0(this, 0));
    public final NavContext navContext;
    public final SynchronizedLazyImpl navInflater$delegate;
    public final NavController$onBackPressedCallback$1 onBackPressedCallback;

    /* loaded from: classes.dex */
    public final class NavControllerNavigatorState {
        public final StateFlowImpl _backStack;
        public final StateFlowImpl _transitionsInProgress;
        public final ReadonlyStateFlow backStack;
        public final ViewUtilsApi21 backStackLock = new Object();
        public boolean isNavigating;
        public final Navigator navigator;
        public final /* synthetic */ NavController this$0;
        public final ReadonlyStateFlow transitionsInProgress;

        /* JADX WARN: Type inference failed for: r3v1, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
        public NavControllerNavigatorState(NavController navController, Navigator navigator) {
            Intrinsics.checkNotNullParameter(navigator, "navigator");
            this.this$0 = navController;
            StateFlowImpl stateFlowImpl = new StateFlowImpl(EmptyList.INSTANCE);
            this._backStack = stateFlowImpl;
            StateFlowImpl stateFlowImpl2 = new StateFlowImpl(EmptySet.INSTANCE);
            this._transitionsInProgress = stateFlowImpl2;
            this.backStack = new ReadonlyStateFlow(stateFlowImpl);
            this.transitionsInProgress = new ReadonlyStateFlow(stateFlowImpl2);
            this.navigator = navigator;
        }

        public final void addInternal(NavBackStackEntry backStackEntry) {
            Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
            synchronized (this.backStackLock) {
                StateFlowImpl stateFlowImpl = this._backStack;
                Collection collection = (Collection) stateFlowImpl.getValue();
                Intrinsics.checkNotNullParameter(collection, "<this>");
                ArrayList arrayList = new ArrayList(collection.size() + 1);
                arrayList.addAll(collection);
                arrayList.add(backStackEntry);
                stateFlowImpl.setValue(arrayList);
            }
        }

        public final NavBackStackEntry createBackStackEntry(NavDestination navDestination, Bundle bundle) {
            NavControllerImpl navControllerImpl = this.this$0.impl;
            navControllerImpl.getClass();
            return NavUriUtils.create$default(navControllerImpl.navController.navContext, navDestination, bundle, navControllerImpl.getHostLifecycleState$navigation_runtime_release(), navControllerImpl.viewModel);
        }

        public final void markTransitionComplete(NavBackStackEntry entry) {
            NavControllerViewModel navControllerViewModel;
            Intrinsics.checkNotNullParameter(entry, "entry");
            NavControllerImpl navControllerImpl = this.this$0.impl;
            StateFlowImpl stateFlowImpl = navControllerImpl._visibleEntries;
            String backStackEntryId = entry.id;
            LinkedHashMap linkedHashMap = navControllerImpl.entrySavedState;
            boolean areEqual = Intrinsics.areEqual(linkedHashMap.get(entry), Boolean.TRUE);
            StateFlowImpl stateFlowImpl2 = this._transitionsInProgress;
            Set set = (Set) stateFlowImpl2.getValue();
            Intrinsics.checkNotNullParameter(set, "<this>");
            LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsKt.mapCapacity(set.size()));
            boolean z = false;
            for (Object obj : set) {
                boolean z2 = true;
                if (!z && Intrinsics.areEqual(obj, entry)) {
                    z = true;
                    z2 = false;
                }
                if (z2) {
                    linkedHashSet.add(obj);
                }
            }
            stateFlowImpl2.setValue(linkedHashSet);
            linkedHashMap.remove(entry);
            ArrayDeque arrayDeque = navControllerImpl.backQueue;
            if (!arrayDeque.contains(entry)) {
                navControllerImpl.unlinkChildFromParent$navigation_runtime_release(entry);
                if (entry.impl.lifecycle.state.compareTo(Lifecycle.State.CREATED) >= 0) {
                    entry.setMaxLifecycle(Lifecycle.State.DESTROYED);
                }
                if (!arrayDeque.isEmpty()) {
                    Iterator it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((NavBackStackEntry) it.next()).id, backStackEntryId)) {
                            break;
                        }
                    }
                }
                if (!areEqual && (navControllerViewModel = navControllerImpl.viewModel) != null) {
                    Intrinsics.checkNotNullParameter(backStackEntryId, "backStackEntryId");
                    ViewModelStore viewModelStore = (ViewModelStore) navControllerViewModel.viewModelStores.remove(backStackEntryId);
                    if (viewModelStore != null) {
                        viewModelStore.clear();
                    }
                }
                navControllerImpl.updateBackStackLifecycle$navigation_runtime_release();
                stateFlowImpl.setValue(navControllerImpl.populateVisibleEntries$navigation_runtime_release());
            } else if (!this.isNavigating) {
                navControllerImpl.updateBackStackLifecycle$navigation_runtime_release();
                navControllerImpl._currentBackStack.setValue(CollectionsKt.toMutableList(arrayDeque));
                stateFlowImpl.setValue(navControllerImpl.populateVisibleEntries$navigation_runtime_release());
            }
        }

        public final void onLaunchSingleTop(NavBackStackEntry navBackStackEntry) {
            int i;
            synchronized (this.backStackLock) {
                try {
                    ArrayList mutableList = CollectionsKt.toMutableList((Collection) ((StateFlowImpl) this.backStack.$$delegate_0).getValue());
                    ListIterator listIterator = mutableList.listIterator(mutableList.size());
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            if (Intrinsics.areEqual(((NavBackStackEntry) listIterator.previous()).id, navBackStackEntry.id)) {
                                i = listIterator.nextIndex();
                                break;
                            }
                        } else {
                            i = -1;
                            break;
                        }
                    }
                    mutableList.set(i, navBackStackEntry);
                    this._backStack.setValue(mutableList);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void pop(NavBackStackEntry navBackStackEntry, boolean z) {
            NavControllerImpl navControllerImpl = this.this$0.impl;
            FragmentNavigator$$ExternalSyntheticLambda6 fragmentNavigator$$ExternalSyntheticLambda6 = new FragmentNavigator$$ExternalSyntheticLambda6(this, navBackStackEntry, z);
            navControllerImpl.getClass();
            Navigator navigator = navControllerImpl._navigatorProvider.getNavigator(navBackStackEntry.destination.navigatorName);
            navControllerImpl.entrySavedState.put(navBackStackEntry, Boolean.valueOf(z));
            if (navigator.equals(this.navigator)) {
                NavControllerImpl$$ExternalSyntheticLambda2 navControllerImpl$$ExternalSyntheticLambda2 = navControllerImpl.popFromBackStackHandler;
                if (navControllerImpl$$ExternalSyntheticLambda2 != null) {
                    navControllerImpl$$ExternalSyntheticLambda2.invoke(navBackStackEntry);
                    fragmentNavigator$$ExternalSyntheticLambda6.invoke();
                    return;
                }
                ArrayDeque arrayDeque = navControllerImpl.backQueue;
                int indexOf = arrayDeque.indexOf(navBackStackEntry);
                if (indexOf < 0) {
                    String message = "Ignoring pop of " + navBackStackEntry + " as it was not found on the current back stack";
                    Intrinsics.checkNotNullParameter(message, "message");
                    Log.i("NavController", message);
                    return;
                }
                int i = indexOf + 1;
                if (i != arrayDeque.size) {
                    navControllerImpl.popBackStackInternal$navigation_runtime_release(((NavBackStackEntry) arrayDeque.get(i)).destination.impl.id, true, false);
                }
                NavControllerImpl.popEntryFromBackStack$navigation_runtime_release$default(navControllerImpl, navBackStackEntry);
                fragmentNavigator$$ExternalSyntheticLambda6.invoke();
                navControllerImpl.updateOnBackPressedCallbackEnabledCallback.invoke();
                navControllerImpl.dispatchOnDestinationChanged$navigation_runtime_release();
                return;
            }
            Object obj = navControllerImpl.navigatorState.get(navigator);
            Intrinsics.checkNotNull(obj);
            ((NavControllerNavigatorState) obj).pop(navBackStackEntry, z);
        }

        public final void popWithTransition(NavBackStackEntry navBackStackEntry, boolean z) {
            Object obj;
            StateFlowImpl stateFlowImpl = this._transitionsInProgress;
            Iterable iterable = (Iterable) stateFlowImpl.getValue();
            boolean z2 = iterable instanceof Collection;
            ReadonlyStateFlow readonlyStateFlow = this.backStack;
            if (!z2 || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((NavBackStackEntry) it.next()) == navBackStackEntry) {
                        Iterable<NavBackStackEntry> iterable2 = (Iterable) ((StateFlowImpl) readonlyStateFlow.$$delegate_0).getValue();
                        if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                            for (NavBackStackEntry navBackStackEntry2 : iterable2) {
                                if (navBackStackEntry2 == navBackStackEntry) {
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
            }
            stateFlowImpl.setValue(SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry));
            StateFlowImpl stateFlowImpl2 = (StateFlowImpl) readonlyStateFlow.$$delegate_0;
            List list = (List) ((StateFlowImpl) readonlyStateFlow.$$delegate_0).getValue();
            ListIterator listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    obj = null;
                    break;
                }
                obj = listIterator.previous();
                NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj;
                if (!Intrinsics.areEqual(navBackStackEntry3, navBackStackEntry) && ((List) stateFlowImpl2.getValue()).lastIndexOf(navBackStackEntry3) < ((List) stateFlowImpl2.getValue()).lastIndexOf(navBackStackEntry)) {
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry4 = (NavBackStackEntry) obj;
            if (navBackStackEntry4 != null) {
                stateFlowImpl.setValue(SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry4));
            }
            pop(navBackStackEntry, z);
        }

        public final void push(NavBackStackEntry backStackEntry) {
            Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
            NavControllerImpl navControllerImpl = this.this$0.impl;
            navControllerImpl.getClass();
            Navigator navigator = navControllerImpl._navigatorProvider.getNavigator(backStackEntry.destination.navigatorName);
            if (navigator.equals(this.navigator)) {
                Function1 function1 = navControllerImpl.addToBackStackHandler;
                if (function1 != null) {
                    function1.invoke(backStackEntry);
                    addInternal(backStackEntry);
                    return;
                }
                String message = "Ignoring add of destination " + backStackEntry.destination + " outside of the call to navigate(). ";
                Intrinsics.checkNotNullParameter(message, "message");
                Log.i("NavController", message);
                return;
            }
            Object obj = navControllerImpl.navigatorState.get(navigator);
            if (obj != null) {
                ((NavControllerNavigatorState) obj).push(backStackEntry);
                return;
            }
            throw new IllegalStateException(ViewModelProvider.Factory.CC.m(new StringBuilder("NavigatorBackStack for "), backStackEntry.destination.navigatorName, " should already be created").toString());
        }

        public final void pushWithTransition(NavBackStackEntry navBackStackEntry) {
            StateFlowImpl stateFlowImpl = this._transitionsInProgress;
            Iterable iterable = (Iterable) stateFlowImpl.getValue();
            boolean z = iterable instanceof Collection;
            ReadonlyStateFlow readonlyStateFlow = this.backStack;
            if (!z || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (((NavBackStackEntry) it.next()) == navBackStackEntry) {
                        Iterable<NavBackStackEntry> iterable2 = (Iterable) ((StateFlowImpl) readonlyStateFlow.$$delegate_0).getValue();
                        if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                            for (NavBackStackEntry navBackStackEntry2 : iterable2) {
                                if (navBackStackEntry2 == navBackStackEntry) {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) CollectionsKt.lastOrNull((List) ((StateFlowImpl) readonlyStateFlow.$$delegate_0).getValue());
            if (navBackStackEntry3 != null) {
                stateFlowImpl.setValue(SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry3));
            }
            stateFlowImpl.setValue(SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry));
            push(navBackStackEntry);
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.navigation.NavController$onBackPressedCallback$1] */
    public NavController(Context context) {
        Object obj;
        this.context = context;
        this.navContext = new NavContext(context, false);
        Iterator it = SequencesKt.generateSequence(context, new Navigation$$ExternalSyntheticLambda0(2)).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.activity = (Activity) obj;
        this.onBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.navigation.NavController$onBackPressedCallback$1
            @Override // androidx.activity.OnBackPressedCallback
            public final void handleOnBackPressed() {
                NavControllerImpl navControllerImpl = NavController.this.impl;
                if (!navControllerImpl.backQueue.isEmpty()) {
                    NavDestination currentDestination$navigation_runtime_release = navControllerImpl.getCurrentDestination$navigation_runtime_release();
                    Intrinsics.checkNotNull(currentDestination$navigation_runtime_release);
                    if (navControllerImpl.popBackStackInternal$navigation_runtime_release(currentDestination$navigation_runtime_release.impl.id, true, false)) {
                        navControllerImpl.dispatchOnDestinationChanged$navigation_runtime_release();
                    }
                }
            }
        };
        this.enableOnBackPressedCallback = true;
        NavigatorProvider navigatorProvider = this.impl._navigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this.impl._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.navInflater$delegate = new SynchronizedLazyImpl(new NavController$$ExternalSyntheticLambda0(this, 1));
    }
}
