package androidx.core.view;

import android.view.View;
import android.view.Window;
import com.emanuelef.remote_capture.CaptureService;
/* loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl23 extends WindowInsetsControllerCompat$Impl20 {
    @Override // androidx.core.os.BundleKt
    public final void setAppearanceLightStatusBars(boolean z) {
        if (z) {
            Window window = this.mWindow;
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(8192 | decorView.getSystemUiVisibility());
            return;
        }
        unsetSystemUiFlag(CaptureService.CONNECTIONS_LOG_SIZE);
    }
}
