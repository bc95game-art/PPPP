package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class HideLeftViewOnScrollDelegate extends LazyKt__LazyJVMKt {
    public final /* synthetic */ int $r8$classId;

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int getSize(View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        int measuredWidth;
        int i;
        switch (this.$r8$classId) {
            case 0:
                measuredWidth = view.getMeasuredWidth();
                i = marginLayoutParams.leftMargin;
                break;
            case 1:
                measuredWidth = view.getMeasuredHeight();
                i = marginLayoutParams.bottomMargin;
                break;
            default:
                measuredWidth = view.getMeasuredWidth();
                i = marginLayoutParams.rightMargin;
                break;
        }
        return measuredWidth + i;
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final int getViewEdge() {
        switch (this.$r8$classId) {
            case 0:
                return 2;
            case 1:
                return 1;
            default:
                return 0;
        }
    }

    @Override // kotlin.LazyKt__LazyJVMKt
    public final ViewPropertyAnimator getViewTranslationAnimator(int i, View view) {
        switch (this.$r8$classId) {
            case 0:
                return view.animate().translationX(-i);
            case 1:
                return view.animate().translationY(i);
            default:
                return view.animate().translationX(i);
        }
    }
}
