package androidx.fragment.app.strictmode;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class FragmentStrictMode {
    public static final Policy defaultPolicy = Policy.LAX;

    /* loaded from: classes.dex */
    public final class Policy {
        public static final Policy LAX;

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.fragment.app.strictmode.FragmentStrictMode$Policy] */
        static {
            ?? obj = new Object();
            new LinkedHashMap();
            LAX = obj;
        }
    }

    public static Policy getNearestPolicy(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                Intrinsics.checkNotNullExpressionValue(fragment.getParentFragmentManager(), "declaringFragment.parentFragmentManager");
            }
            fragment = fragment.getParentFragment();
        }
        return defaultPolicy;
    }

    public static void logIfDebuggingEnabled(Violation violation) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(violation.fragment.getClass().getName()), violation);
        }
    }

    public static final void onFragmentReuse(Fragment fragment, String previousFragmentId) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(previousFragmentId, "previousFragmentId");
        logIfDebuggingEnabled(new Violation(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + previousFragmentId));
        getNearestPolicy(fragment).getClass();
    }
}
