package androidx.core.view;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.core.os.BundleKt;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.CaptureService;
/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat$Impl30 extends BundleKt {
    public final WindowInsetsController mInsetsController;
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl30(Window window, Transition.AnonymousClass1 r2) {
        this.mInsetsController = window.getInsetsController();
        this.mWindow = window;
    }

    @Override // androidx.core.os.BundleKt
    public final void setAppearanceLightNavigationBars(boolean z) {
        Window window = this.mWindow;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.mInsetsController.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.mInsetsController.setSystemBarsAppearance(0, 16);
    }

    @Override // androidx.core.os.BundleKt
    public final void setAppearanceLightStatusBars(boolean z) {
        Window window = this.mWindow;
        if (z) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | CaptureService.CONNECTIONS_LOG_SIZE);
            }
            this.mInsetsController.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.mInsetsController.setSystemBarsAppearance(0, 8);
    }
}
