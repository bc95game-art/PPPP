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
public final class EdgeToEdgeApi29 implements EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean z, boolean z2) {
        BundleKt bundleKt;
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(view, "view");
        BundleKt.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
        window.setStatusBarContrastEnforced(false);
        window.setNavigationBarContrastEnforced(true);
        Transition.C01101 r3 = new Transition.C01101(view);
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            bundleKt = new WindowInsetsControllerCompat$Impl30(window, r3);
        } else if (i >= 26) {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window, r3);
        } else if (i >= 23) {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window, r3);
        } else {
            bundleKt = new WindowInsetsControllerCompat$Impl20(window, r3);
        }
        bundleKt.setAppearanceLightStatusBars(!z);
        bundleKt.setAppearanceLightNavigationBars(true ^ z2);
    }
}
