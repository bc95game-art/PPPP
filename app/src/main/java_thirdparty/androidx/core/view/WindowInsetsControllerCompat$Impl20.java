package androidx.core.view;

import android.view.View;
import android.view.Window;
import androidx.core.os.BundleKt;
import androidx.transition.Transition;
/* loaded from: classes.dex */
public class WindowInsetsControllerCompat$Impl20 extends BundleKt {
    public final Window mWindow;

    public WindowInsetsControllerCompat$Impl20(Window window, Transition.AnonymousClass1 r2) {
        this.mWindow = window;
    }

    public final void unsetSystemUiFlag(int i) {
        View decorView = this.mWindow.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }
}
