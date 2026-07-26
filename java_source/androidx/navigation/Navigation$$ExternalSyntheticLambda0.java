package androidx.navigation;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.internal.NavBackStackEntryImpl;
import com.emanuelef.remote_capture.C0130R;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final /* synthetic */ class Navigation$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Navigation$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                View it = (View) obj;
                Intrinsics.checkNotNullParameter(it, "it");
                ViewParent parent = it.getParent();
                if (parent instanceof View) {
                    return (View) parent;
                }
                return null;
            case 1:
                Context it2 = (Context) obj;
                Intrinsics.checkNotNullParameter(it2, "it");
                if (it2 instanceof ContextWrapper) {
                    return ((ContextWrapper) it2).getBaseContext();
                }
                return null;
            case 2:
                Context it3 = (Context) obj;
                Intrinsics.checkNotNullParameter(it3, "it");
                if (it3 instanceof ContextWrapper) {
                    return ((ContextWrapper) it3).getBaseContext();
                }
                return null;
            case 3:
                CreationExtras initializer = (CreationExtras) obj;
                Intrinsics.checkNotNullParameter(initializer, "$this$initializer");
                return new NavControllerViewModel();
            case 4:
                NavDestination it4 = (NavDestination) obj;
                Intrinsics.checkNotNullParameter(it4, "it");
                return it4.parent;
            case 5:
                NavDestination it5 = (NavDestination) obj;
                Intrinsics.checkNotNullParameter(it5, "it");
                if (!(it5 instanceof NavGraph)) {
                    return null;
                }
                NavGraph navGraph = (NavGraph) it5;
                return navGraph.findNode(navGraph.impl.zzd);
            case 6:
                View it6 = (View) obj;
                Intrinsics.checkNotNullParameter(it6, "it");
                Object tag = it6.getTag(C0130R.C0132id.nav_controller_view_tag);
                if (tag instanceof WeakReference) {
                    return (NavController) ((WeakReference) tag).get();
                }
                if (tag instanceof NavController) {
                    return (NavController) tag;
                }
                return null;
            case 7:
                CreationExtras initializer2 = (CreationExtras) obj;
                Intrinsics.checkNotNullParameter(initializer2, "$this$initializer");
                return new FragmentNavigator.ClearEntryStateViewModel();
            case 8:
                CreationExtras initializer3 = (CreationExtras) obj;
                Intrinsics.checkNotNullParameter(initializer3, "$this$initializer");
                return new NavBackStackEntryImpl.SavedStateViewModel(SavedStateHandleSupport.createSavedStateHandle(initializer3));
            case 9:
                NavDestination destination = (NavDestination) obj;
                Intrinsics.checkNotNullParameter(destination, "destination");
                NavGraph navGraph2 = destination.parent;
                if (navGraph2 == null || navGraph2.impl.zzd != destination.impl.f12id) {
                    return null;
                }
                return navGraph2;
            case 10:
                NavDestination destination2 = (NavDestination) obj;
                Intrinsics.checkNotNullParameter(destination2, "destination");
                NavGraph navGraph3 = destination2.parent;
                if (navGraph3 == null || navGraph3.impl.zzd != destination2.impl.f12id) {
                    return null;
                }
                return navGraph3;
            default:
                NavDestination it7 = (NavDestination) obj;
                Intrinsics.checkNotNullParameter(it7, "it");
                return Integer.valueOf(it7.impl.f12id);
        }
    }
}
