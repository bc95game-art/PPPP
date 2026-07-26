package androidx.navigation;

import android.os.Bundle;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigator;
import androidx.navigation.internal.NavDestinationImpl;
import com.android.billingclient.api.zzca;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.internal.Intrinsics;
@Navigator.Name("navigation")
/* loaded from: classes.dex */
public class NavGraphNavigator extends Navigator {
    public final NavigatorProvider navigatorProvider;

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        Intrinsics.checkNotNullParameter(navigatorProvider, "navigatorProvider");
        this.navigatorProvider = navigatorProvider;
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination createDestination() {
        return new NavGraph(this);
    }

    @Override // androidx.navigation.Navigator
    public final void navigate(List list, NavOptions navOptions) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
            NavDestination navDestination = navBackStackEntry.destination;
            Intrinsics.checkNotNull(navDestination, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            NavGraph navGraph = (NavGraph) navDestination;
            Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
            zzca zzcaVar = navGraph.impl;
            int i = zzcaVar.zzd;
            if (i == 0) {
                NavDestinationImpl navDestinationImpl = ((NavDestination) navGraph).impl;
                String superName = (String) navDestinationImpl.idName;
                if (superName == null) {
                    superName = String.valueOf(navDestinationImpl.f12id);
                }
                Intrinsics.checkNotNullParameter(superName, "superName");
                if (((NavDestination) ((NavGraph) zzcaVar.zza)).impl.f12id == 0) {
                    superName = "the root navigation";
                }
                throw new IllegalStateException("no start destination defined via app:startDestination for ".concat(superName).toString());
            }
            NavDestination navDestination2 = (NavDestination) ((SparseArrayCompat) zzcaVar.zzb).get(i);
            if (navDestination2 == null) {
                if (((String) zzcaVar.zzc) == null) {
                    zzcaVar.zzc = String.valueOf(zzcaVar.zzd);
                }
                String str = (String) zzcaVar.zzc;
                Intrinsics.checkNotNull(str);
                throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m595m("navigation destination ", str, " is not a direct child of this NavGraph"));
            }
            this.navigatorProvider.getNavigator(navDestination2.navigatorName).navigate(LazyKt__LazyJVMKt.listOf(getState().createBackStackEntry(navDestination2, navDestination2.addInDefaultArgs(arguments$navigation_common_release))), navOptions);
        }
    }
}
