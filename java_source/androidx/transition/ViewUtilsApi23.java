package androidx.transition;

import android.os.Build;
import android.view.View;
/* loaded from: classes.dex */
public class ViewUtilsApi23 extends ViewUtilsApi22 {
    public static boolean sTryHiddenSetTransitionVisibility = true;

    /* loaded from: classes.dex */
    public abstract class Api29Impl {
        public static void setTransitionVisibility(View view, int i) {
            view.setTransitionVisibility(i);
        }
    }

    @Override // androidx.transition.ViewUtilsApi21
    public void setTransitionVisibility(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, i);
        } else if (sTryHiddenSetTransitionVisibility) {
            try {
                Api29Impl.setTransitionVisibility(view, i);
            } catch (NoSuchMethodError unused) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }
}
