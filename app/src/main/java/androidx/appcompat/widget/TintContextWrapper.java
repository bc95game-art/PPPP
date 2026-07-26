package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
/* loaded from: classes.dex */
public abstract class TintContextWrapper extends ContextWrapper {
    public static final Object CACHE_LOCK = null;

    public static void wrap(Context context) {
        if (!(context.getResources() instanceof TintResources)) {
            context.getResources();
            int i = VectorEnabledTintResources.$r8$clinit;
        }
    }
}
