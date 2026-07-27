package com.github.appintro.internal;

import android.content.Context;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public final class CustomFontCache {
    public static final CustomFontCache INSTANCE = new CustomFontCache();
    private static final String TAG = LogHelper.INSTANCE.makeLogTag(Reflection.getOrCreateKotlinClass(CustomFontCache.class));
    private static final HashMap<String, Typeface> cache = new HashMap<>();

    private CustomFontCache() {
    }

    public final void getFont(Context ctx, String str, ResourcesCompat.FontCallback fontCallback) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(fontCallback, "fontCallback");
        Unit unit = null;
        if (str == null || str.length() == 0) {
            LogHelper.w$default(TAG, "Empty typeface path provided!", null, 4, null);
            return;
        }
        HashMap<String, Typeface> hashMap = cache;
        Typeface typeface = hashMap.get(str);
        if (typeface != null) {
            fontCallback.onFontRetrieved(typeface);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            Typeface newTypeface = Typeface.createFromAsset(ctx.getAssets(), str);
            Intrinsics.checkNotNullExpressionValue(newTypeface, "newTypeface");
            hashMap.put(str, newTypeface);
            fontCallback.onFontRetrieved(newTypeface);
        }
    }
}
