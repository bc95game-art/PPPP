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
public final class EdgeToEdgeApi23 implements EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean z, boolean z2) {
        int i;
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
        window.setNavigationBarColor(navigationBarStyle.darkScrim);
        Transition.C01101 r1 = new Transition.C01101(view);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            bundleKt = new WindowInsetsControllerCompat$Impl30(window, r1);
        } else if (i2 >= 26) {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window, r1);
        } else if (i2 >= 23) {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window, r1);
        } else {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window, r1);
        }
        bundleKt.setAppearanceLightStatusBars(!z);
    }
}
