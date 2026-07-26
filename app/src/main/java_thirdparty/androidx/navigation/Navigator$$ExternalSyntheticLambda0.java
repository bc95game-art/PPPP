package androidx.navigation;

import androidx.navigation.NavOptions;
import androidx.navigation.internal.NavBackStackEntryImpl;
import androidx.navigation.internal.NavControllerImpl;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
/* loaded from: classes.dex */
public final /* synthetic */ class Navigator$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Navigator$$ExternalSyntheticLambda0(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        NavDestination navigate;
        NavGraph navGraph;
        int i = this.$r8$classId;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (i) {
            case 0:
                Navigator navigator = (Navigator) obj3;
                NavOptions navOptions = (NavOptions) obj2;
                NavBackStackEntry backStackEntry = (NavBackStackEntry) obj;
                Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
                NavBackStackEntryImpl navBackStackEntryImpl = backStackEntry.impl;
                NavDestination navDestination = backStackEntry.destination;
                if (navDestination == null) {
                    navDestination = null;
                }
                if (navDestination == null || (navigate = navigator.navigate(navDestination, navBackStackEntryImpl.getArguments$navigation_common_release(), navOptions)) == null) {
                    return null;
                }
                if (navigate.equals(navDestination)) {
                    return backStackEntry;
                }
                return navigator.getState().createBackStackEntry(navigate, navigate.addInDefaultArgs(navBackStackEntryImpl.getArguments$navigation_common_release()));
            default:
                NavDestination navDestination2 = (NavDestination) obj3;
                NavControllerImpl navControllerImpl = ((NavController) obj2).impl;
                NavOptionsBuilder navOptions2 = (NavOptionsBuilder) obj;
                Intrinsics.checkNotNullParameter(navOptions2, "$this$navOptions");
                NavOptions.Builder builder = navOptions2.builder;
                builder.enterAnim = 0;
                builder.exitAnim = 0;
                if (navDestination2 instanceof NavGraph) {
                    int i2 = NavDestination.$r8$clinit;
                    Iterator it = SequencesKt.generateSequence(navDestination2, new Navigation$$ExternalSyntheticLambda0(4)).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            NavDestination navDestination3 = (NavDestination) it.next();
                            NavDestination currentDestination$navigation_runtime_release = navControllerImpl.getCurrentDestination$navigation_runtime_release();
                            if (currentDestination$navigation_runtime_release != null) {
                                navGraph = currentDestination$navigation_runtime_release.parent;
                            } else {
                                navGraph = null;
                            }
                            if (Intrinsics.areEqual(navDestination3, navGraph)) {
                            }
                        } else {
                            int i3 = NavGraph.$r8$clinit;
                            Iterator it2 = SequencesKt.generateSequence(navControllerImpl.getGraph$navigation_runtime_release(), new Navigation$$ExternalSyntheticLambda0(5)).iterator();
                            if (it2.hasNext()) {
                                Object next = it2.next();
                                while (it2.hasNext()) {
                                    next = it2.next();
                                }
                                navOptions2.popUpToId = ((NavDestination) next).impl.id;
                                navOptions2.saveState = true;
                            } else {
                                throw new NoSuchElementException("Sequence is empty.");
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
        }
    }
}
