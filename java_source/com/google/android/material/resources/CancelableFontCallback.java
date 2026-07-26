package com.google.android.material.resources;

import android.graphics.Typeface;
import com.google.android.material.internal.CollapsingTextHelper;
import kotlin.LazyKt__LazyJVMKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
/* loaded from: classes.dex */
public final class CancelableFontCallback extends LazyKt__LazyJVMKt {
    public final ReadonlyStateFlow applyFont;
    public boolean cancelled;
    public final Typeface fallbackFont;

    public CancelableFontCallback(ReadonlyStateFlow readonlyStateFlow, Typeface typeface) {
        this.fallbackFont = typeface;
        this.applyFont = readonlyStateFlow;
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final void onFontRetrievalFailed(int i) {
        if (!this.cancelled) {
            CollapsingTextHelper collapsingTextHelper = (CollapsingTextHelper) this.applyFont.$$delegate_0;
            if (collapsingTextHelper.setCollapsedTypefaceInternal(this.fallbackFont)) {
                collapsingTextHelper.recalculate(false);
            }
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final void onFontRetrieved(Typeface typeface, boolean z) {
        if (!this.cancelled) {
            CollapsingTextHelper collapsingTextHelper = (CollapsingTextHelper) this.applyFont.$$delegate_0;
            if (collapsingTextHelper.setCollapsedTypefaceInternal(typeface)) {
                collapsingTextHelper.recalculate(false);
            }
        }
    }
}
