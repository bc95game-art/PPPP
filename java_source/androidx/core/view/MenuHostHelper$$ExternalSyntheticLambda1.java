package androidx.core.view;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.fragment.FragmentNavigator;
import java.util.List;
import kotlinx.coroutines.flow.StateFlowImpl;
/* loaded from: classes.dex */
public final /* synthetic */ class MenuHostHelper$$ExternalSyntheticLambda1 implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ MenuHostHelper$$ExternalSyntheticLambda1(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.$r8$classId) {
            case 0:
                MenuHostHelper menuHostHelper = (MenuHostHelper) this.f$0;
                MenuProvider menuProvider = (MenuProvider) this.f$1;
                menuHostHelper.getClass();
                if (event == Lifecycle.Event.ON_DESTROY) {
                    menuHostHelper.removeMenuProvider(menuProvider);
                    return;
                }
                return;
            default:
                FragmentNavigator fragmentNavigator = (FragmentNavigator) this.f$0;
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.f$1;
                if (event == Lifecycle.Event.ON_RESUME && ((List) ((StateFlowImpl) fragmentNavigator.getState().backStack.$$delegate_0).getValue()).contains(navBackStackEntry)) {
                    if (FragmentNavigator.isLoggingEnabled()) {
                        Log.v("FragmentNavigator", "Marking transition complete for entry " + navBackStackEntry + " due to fragment " + lifecycleOwner + " view lifecycle reaching RESUMED");
                    }
                    fragmentNavigator.getState().markTransitionComplete(navBackStackEntry);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    if (FragmentNavigator.isLoggingEnabled()) {
                        Log.v("FragmentNavigator", "Marking transition complete for entry " + navBackStackEntry + " due to fragment " + lifecycleOwner + " view lifecycle reaching DESTROYED");
                    }
                    fragmentNavigator.getState().markTransitionComplete(navBackStackEntry);
                    return;
                }
                return;
        }
    }
}
