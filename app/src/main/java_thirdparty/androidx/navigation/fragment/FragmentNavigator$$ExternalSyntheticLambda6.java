package androidx.navigation.fragment;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentNavigator$$ExternalSyntheticLambda6 implements Function0 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ NavController.NavControllerNavigatorState f$1;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ FragmentNavigator$$ExternalSyntheticLambda6(NavBackStackEntry navBackStackEntry, NavController.NavControllerNavigatorState navControllerNavigatorState, FragmentNavigator fragmentNavigator, Fragment fragment) {
        this.f$1 = navControllerNavigatorState;
        this.f$3 = fragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                NavController.NavControllerNavigatorState navControllerNavigatorState = this.f$1;
                Fragment fragment = (Fragment) this.f$3;
                for (NavBackStackEntry navBackStackEntry : (Iterable) ((StateFlowImpl) navControllerNavigatorState.transitionsInProgress.$$delegate_0).getValue()) {
                    if (FragmentNavigator.isLoggingEnabled()) {
                        Log.v("FragmentNavigator", "Marking transition complete for entry " + navBackStackEntry + " due to fragment " + fragment + " viewmodel being cleared");
                    }
                    navControllerNavigatorState.markTransitionComplete(navBackStackEntry);
                }
                return Unit.INSTANCE;
            default:
                NavController.NavControllerNavigatorState navControllerNavigatorState2 = this.f$1;
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) this.f$3;
                synchronized (navControllerNavigatorState2.backStackLock) {
                    try {
                        StateFlowImpl stateFlowImpl = navControllerNavigatorState2._backStack;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : (Iterable) stateFlowImpl.getValue()) {
                            if (Intrinsics.areEqual((NavBackStackEntry) obj, navBackStackEntry2)) {
                                stateFlowImpl.setValue(arrayList);
                            } else {
                                arrayList.add(obj);
                            }
                        }
                        stateFlowImpl.setValue(arrayList);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ FragmentNavigator$$ExternalSyntheticLambda6(NavController.NavControllerNavigatorState navControllerNavigatorState, NavBackStackEntry navBackStackEntry, boolean z) {
        this.f$1 = navControllerNavigatorState;
        this.f$3 = navBackStackEntry;
    }
}
