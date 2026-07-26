package com.github.appintro.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class TypefaceContainer {
    private int typeFaceResource;
    private String typeFaceUrl;

    public TypefaceContainer() {
        this(null, 0, 3, null);
    }

    public static /* synthetic */ TypefaceContainer copy$default(TypefaceContainer typefaceContainer, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = typefaceContainer.typeFaceUrl;
        }
        if ((i2 & 2) != 0) {
            i = typefaceContainer.typeFaceResource;
        }
        return typefaceContainer.copy(str, i);
    }

    public final void applyTo(final TextView textView) {
        if (textView != null && textView.getContext() != null) {
            if (this.typeFaceUrl != null || this.typeFaceResource != 0) {
                ResourcesCompat.FontCallback typefaceContainer$applyTo$callback$1 = new ResourcesCompat.FontCallback() { // from class: com.github.appintro.internal.TypefaceContainer$applyTo$callback$1
                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrievalFailed(int i) {
                    }

                    @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                    public void onFontRetrieved(Typeface typeface) {
                        Intrinsics.checkNotNullParameter(typeface, "typeface");
                        textView.setTypeface(typeface);
                    }
                };
                if (this.typeFaceResource != 0) {
                    Context context = textView.getContext();
                    int i = this.typeFaceResource;
                    ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
                    if (context.isRestricted()) {
                        typefaceContainer$applyTo$callback$1.callbackFailAsync(-4, null);
                    } else {
                        ResourcesCompat.loadFont(context, i, new TypedValue(), 0, typefaceContainer$applyTo$callback$1, false, false);
                    }
                } else {
                    CustomFontCache customFontCache = CustomFontCache.INSTANCE;
                    Context context2 = textView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "textView.context");
                    customFontCache.getFont(context2, this.typeFaceUrl, typefaceContainer$applyTo$callback$1);
                }
            }
        }
    }

    public final String component1() {
        return this.typeFaceUrl;
    }

    public final int component2() {
        return this.typeFaceResource;
    }

    public final TypefaceContainer copy(String str, int i) {
        return new TypefaceContainer(str, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypefaceContainer)) {
            return false;
        }
        TypefaceContainer typefaceContainer = (TypefaceContainer) obj;
        return Intrinsics.areEqual(this.typeFaceUrl, typefaceContainer.typeFaceUrl) && this.typeFaceResource == typefaceContainer.typeFaceResource;
    }

    public final int getTypeFaceResource() {
        return this.typeFaceResource;
    }

    public final String getTypeFaceUrl() {
        return this.typeFaceUrl;
    }

    public int hashCode() {
        String str = this.typeFaceUrl;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.typeFaceResource;
    }

    public final void setTypeFaceResource(int i) {
        this.typeFaceResource = i;
    }

    public final void setTypeFaceUrl(String str) {
        this.typeFaceUrl = str;
    }

    public String toString() {
        return "TypefaceContainer(typeFaceUrl=" + ((Object) this.typeFaceUrl) + ", typeFaceResource=" + this.typeFaceResource + ')';
    }

    public TypefaceContainer(String str, int i) {
        this.typeFaceUrl = str;
        this.typeFaceResource = i;
    }

    public /* synthetic */ TypefaceContainer(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0 : i);
    }
}
