package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.FilteringSequence$iterator$1;
import kotlin.sequences.TakeWhileSequence;
import kotlinx.coroutines.flow.StateFlowImpl;
/* loaded from: classes.dex */
public abstract class Navigator {
    public NavController.NavControllerNavigatorState _state;
    public boolean isAttached;

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface Name {
        String value();
    }

    public abstract NavDestination createDestination();

    public final NavController.NavControllerNavigatorState getState() {
        NavController.NavControllerNavigatorState navControllerNavigatorState = this._state;
        if (navControllerNavigatorState != null) {
            return navControllerNavigatorState;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached");
    }

    public NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions) {
        return navDestination;
    }

    public void onAttach(NavController.NavControllerNavigatorState navControllerNavigatorState) {
        this._state = navControllerNavigatorState;
        this.isAttached = true;
    }

    public void onLaunchSingleTop(NavBackStackEntry navBackStackEntry) {
        NavDestination navDestination = navBackStackEntry.destination;
        if (navDestination == null) {
            navDestination = null;
        }
        if (navDestination != null) {
            NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
            navOptionsBuilder.launchSingleTop = true;
            boolean z = navOptionsBuilder.launchSingleTop;
            boolean z2 = navOptionsBuilder.restoreState;
            int i = navOptionsBuilder.popUpToId;
            boolean z3 = navOptionsBuilder.saveState;
            NavOptions.Builder builder = navOptionsBuilder.builder;
            navigate(navDestination, null, new NavOptions(z, z2, i, false, z3, builder.enterAnim, builder.exitAnim, -1, -1));
            getState().onLaunchSingleTop(navBackStackEntry);
        }
    }

    public void onRestoreState(Bundle bundle) {
    }

    public Bundle onSaveState() {
        return null;
    }

    public boolean popBackStack() {
        return true;
    }

    public void navigate(List list, NavOptions navOptions) {
        FilteringSequence$iterator$1 filteringSequence$iterator$1 = new FilteringSequence$iterator$1(new FilteringSequence(0, new TakeWhileSequence(new FilteringSequence(1, list), new Navigator$$ExternalSyntheticLambda0(this, 0, navOptions), 1)));
        while (filteringSequence$iterator$1.hasNext()) {
            getState().push((NavBackStackEntry) filteringSequence$iterator$1.next());
        }
    }

    public void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        List list = (List) ((StateFlowImpl) getState().backStack.$$delegate_0).getValue();
        if (list.contains(navBackStackEntry)) {
            ListIterator listIterator = list.listIterator(list.size());
            NavBackStackEntry navBackStackEntry2 = null;
            while (popBackStack()) {
                navBackStackEntry2 = (NavBackStackEntry) listIterator.previous();
                if (Intrinsics.areEqual(navBackStackEntry2, navBackStackEntry)) {
                    break;
                }
            }
            if (navBackStackEntry2 != null) {
                getState().pop(navBackStackEntry2, z);
                return;
            }
            return;
        }
        throw new IllegalStateException(("popBackStack was called with " + navBackStackEntry + " which does not exist in back stack " + list).toString());
    }
}
