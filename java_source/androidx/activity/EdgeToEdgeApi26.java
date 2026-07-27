package androidx.activity;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.p002os.BundleKt;
import androidx.core.view.WindowInsetsControllerCompat$Impl20;
import androidx.core.view.WindowInsetsControllerCompat$Impl30;
import androidx.transition.Transition;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class EdgeToEdgeApi26 implements EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean z, boolean z2) {
        int i;
        int i2;
        BundleKt bundleKt;
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(view, "view");
        BundleKt.setDecorFitsSystemWindows(window, false);
        if (z) {
            i = statusBarStyle.darkScrim;
        } else {
            i = statusBarStyle.lightScrim;
        }
        window.setStatusBarColor(i);
        if (z2) {
            i2 = navigationBarStyle.darkScrim;
        } else {
            i2 = navigationBarStyle.lightScrim;
        }
        window.setNavigationBarColor(i2);
        Transition.C01101 r2 = new Transition.C01101(view);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            bundleKt = new WindowInsetsControllerCompat$Impl30(window, r2);
        } else if (i3 >= 26) {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window, r2);
        } else if (i3 >= 23) {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window, r2);
        } else {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window, r2);
        }
        bundleKt.setAppearanceLightStatusBars(!z);
        bundleKt.setAppearanceLightNavigationBars(!z2);
    }
}
