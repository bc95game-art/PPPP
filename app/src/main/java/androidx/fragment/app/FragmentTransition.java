package androidx.fragment.app;

import android.view.View;
import androidx.transition.FragmentTransitionSupport;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class FragmentTransition {
    public static final FragmentTransitionCompat21 PLATFORM_IMPL = new Object();
    public static final FragmentTransitionImpl SUPPORT_IMPL;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.fragment.app.FragmentTransitionCompat21, java.lang.Object] */
    static {
        FragmentTransitionImpl fragmentTransitionImpl = null;
        try {
            fragmentTransitionImpl = (FragmentTransitionImpl) FragmentTransitionSupport.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        SUPPORT_IMPL = fragmentTransitionImpl;
    }

    public static final void setViewVisibility(ArrayList views, int i) {
        Intrinsics.checkNotNullParameter(views, "views");
        int size = views.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = views.get(i2);
            i2++;
            ((View) obj).setVisibility(i);
        }
    }
}
