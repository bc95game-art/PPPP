package androidx.navigation.fragment;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.navigation.internal.NavControllerImpl;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentNavigator$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ FragmentNavigator$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.$r8$classId) {
            case 0:
                FragmentNavigator fragmentNavigator = (FragmentNavigator) this.f$0;
                if (event == Lifecycle.Event.ON_DESTROY) {
                    Fragment fragment = (Fragment) lifecycleOwner;
                    Object obj = null;
                    for (Object obj2 : (Iterable) ((StateFlowImpl) fragmentNavigator.getState().transitionsInProgress.$$delegate_0).getValue()) {
                        if (Intrinsics.areEqual(((NavBackStackEntry) obj2).f10id, fragment.getTag())) {
                            obj = obj2;
                        }
                    }
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                    if (navBackStackEntry != null) {
                        if (FragmentNavigator.isLoggingEnabled()) {
                            Log.v("FragmentNavigator", "Marking transition complete for entry " + navBackStackEntry + " due to fragment " + lifecycleOwner + " lifecycle reaching DESTROYED");
                        }
                        fragmentNavigator.getState().markTransitionComplete(navBackStackEntry);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                NavControllerImpl navControllerImpl = (NavControllerImpl) this.f$0;
                navControllerImpl.hostLifecycleState = event.getTargetState();
                if (navControllerImpl._graph != null) {
                    ArrayList mutableList = CollectionsKt.toMutableList(navControllerImpl.backQueue);
                    int size = mutableList.size();
                    int i = 0;
                    while (i < size) {
                        Object obj3 = mutableList.get(i);
                        i++;
                        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj3;
                        navBackStackEntry2.getClass();
                        NavBackStackEntryImpl navBackStackEntryImpl = navBackStackEntry2.impl;
                        navBackStackEntryImpl.getClass();
                        navBackStackEntryImpl.entry.hostLifecycleState = event.getTargetState();
                        navBackStackEntryImpl.hostLifecycleState = event.getTargetState();
                        navBackStackEntryImpl.updateState$navigation_common_release();
                    }
                    return;
                }
                return;
            default:
                SavedStateRegistryImpl savedStateRegistryImpl = (SavedStateRegistryImpl) this.f$0;
                if (event == Lifecycle.Event.ON_START) {
                    savedStateRegistryImpl.isAllowingSavingState = true;
                    return;
                } else if (event == Lifecycle.Event.ON_STOP) {
                    savedStateRegistryImpl.isAllowingSavingState = false;
                    return;
                } else {
                    return;
                }
        }
    }
}
