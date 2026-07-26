package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.navigation.NavBackStackEntry;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentNavigator$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ FragmentNavigator f$0;
    public final /* synthetic */ Fragment f$1;
    public final /* synthetic */ NavBackStackEntry f$2;

    public /* synthetic */ FragmentNavigator$$ExternalSyntheticLambda4(FragmentNavigator fragmentNavigator, Fragment fragment, NavBackStackEntry navBackStackEntry) {
        this.f$0 = fragmentNavigator;
        this.f$1 = fragment;
        this.f$2 = navBackStackEntry;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) obj;
        FragmentNavigator fragmentNavigator = this.f$0;
        ArrayList arrayList = fragmentNavigator.pendingOps;
        Fragment fragment = this.f$1;
        boolean z = false;
        if (arrayList == null || !arrayList.isEmpty()) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                Object obj2 = arrayList.get(i);
                i++;
                if (Intrinsics.areEqual(((Pair) obj2).first, fragment.getTag())) {
                    z = true;
                    break;
                }
            }
        }
        if (lifecycleOwner != null && !z) {
            Lifecycle lifecycle = fragment.getViewLifecycleOwner().getLifecycle();
            if (((LifecycleRegistry) lifecycle).state.compareTo(Lifecycle.State.CREATED) >= 0) {
                lifecycle.addObserver((LifecycleObserver) fragmentNavigator.fragmentViewObserver.invoke(this.f$2));
            }
        }
        return Unit.INSTANCE;
    }
}
