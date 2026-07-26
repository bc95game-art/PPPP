package androidx.core.view;

import android.view.View;
import android.view.Window;
/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat$Impl26 extends WindowInsetsControllerCompat$Impl23 {
    @Override // androidx.core.p002os.BundleKt
    public final void setAppearanceLightNavigationBars(boolean z) {
        if (z) {
            Window window = this.mWindow;
            window.clearFlags(134217728);
            window.addFlags(Integer.MIN_VALUE);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(16 | decorView.getSystemUiVisibility());
            return;
        }
        unsetSystemUiFlag(16);
    }
}
