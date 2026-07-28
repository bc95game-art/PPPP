package com.github.appintro.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class LayoutUtil {
    public static final LayoutUtil INSTANCE = new LayoutUtil();

    private LayoutUtil() {
    }

    public static final boolean isRtl(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (ctx.getResources().getConfiguration().getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }
}
