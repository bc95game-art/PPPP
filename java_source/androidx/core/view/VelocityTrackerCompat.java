package androidx.core.view;

import android.view.VelocityTracker;
import java.util.Map;
import java.util.WeakHashMap;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public abstract class VelocityTrackerCompat {
    public static final Map sFallbackTrackers = DesugarCollections.synchronizedMap(new WeakHashMap());

    /* loaded from: classes.dex */
    public abstract class Api34Impl {
        public static float getAxisVelocity(VelocityTracker velocityTracker, int i, int i2) {
            return velocityTracker.getAxisVelocity(i, i2);
        }

        public static boolean isAxisSupported(VelocityTracker velocityTracker, int i) {
            return velocityTracker.isAxisSupported(i);
        }

        public static float getAxisVelocity(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getAxisVelocity(i);
        }
    }
}
