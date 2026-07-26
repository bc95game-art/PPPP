package androidx.navigation;

import android.os.Bundle;
import com.android.billingclient.api.zzca;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class NavBackStackEntryState {
    public final zzca impl;

    public NavBackStackEntryState(NavBackStackEntry navBackStackEntry) {
        this.impl = new zzca(navBackStackEntry, navBackStackEntry.destination.impl.id);
    }

    public NavBackStackEntryState(Bundle state) {
        Intrinsics.checkNotNullParameter(state, "state");
        state.setClassLoader(NavBackStackEntryState.class.getClassLoader());
        this.impl = new zzca(state);
    }
}
