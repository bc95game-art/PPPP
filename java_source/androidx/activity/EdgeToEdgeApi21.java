package androidx.activity;

import android.view.View;
import android.view.Window;
import androidx.core.p002os.BundleKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class EdgeToEdgeApi21 implements EdgeToEdgeImpl {
    @Override // androidx.activity.EdgeToEdgeImpl
    public void setUp(SystemBarStyle statusBarStyle, SystemBarStyle navigationBarStyle, Window window, View view, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(view, "view");
        BundleKt.setDecorFitsSystemWindows(window, false);
        window.addFlags(67108864);
        window.addFlags(134217728);
    }
}
