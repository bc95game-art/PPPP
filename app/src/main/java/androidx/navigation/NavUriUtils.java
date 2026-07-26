package androidx.navigation;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.internal.NavContext;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class NavUriUtils {
    public static NavBackStackEntry create$default(NavContext navContext, NavDestination destination, Bundle bundle, Lifecycle.State hostLifecycleState, NavControllerViewModel navControllerViewModel) {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(hostLifecycleState, "hostLifecycleState");
        return new NavBackStackEntry(navContext, destination, bundle, hostLifecycleState, navControllerViewModel, uuid, null);
    }
}
