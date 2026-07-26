package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.collection.internal.Lock;
import com.google.android.material.animation.AnimationUtils;
/* loaded from: classes.dex */
public final class FadeTabIndicatorInterpolator extends Lock {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FadeTabIndicatorInterpolator(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.collection.internal.Lock
    public final void updateIndicatorForOffset(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float f2;
        float f3;
        float f4;
        switch (this.$r8$classId) {
            case 0:
                int i = (f > 0.5f ? 1 : (f == 0.5f ? 0 : -1));
                if (i >= 0) {
                    view = view2;
                }
                RectF calculateIndicatorWidthForTab = Lock.calculateIndicatorWidthForTab(tabLayout, view);
                if (i < 0) {
                    f2 = AnimationUtils.lerp(1.0f, 0.0f, 0.0f, 0.5f, f);
                } else {
                    f2 = AnimationUtils.lerp(0.0f, 1.0f, 0.5f, 1.0f, f);
                }
                drawable.setBounds((int) calculateIndicatorWidthForTab.left, drawable.getBounds().top, (int) calculateIndicatorWidthForTab.right, drawable.getBounds().bottom);
                drawable.setAlpha((int) (f2 * 255.0f));
                return;
            default:
                RectF calculateIndicatorWidthForTab2 = Lock.calculateIndicatorWidthForTab(tabLayout, view);
                RectF calculateIndicatorWidthForTab3 = Lock.calculateIndicatorWidthForTab(tabLayout, view2);
                if (calculateIndicatorWidthForTab2.left < calculateIndicatorWidthForTab3.left) {
                    double d = (f * 3.141592653589793d) / 2.0d;
                    f4 = (float) (1.0d - Math.cos(d));
                    f3 = (float) Math.sin(d);
                } else {
                    double d2 = (f * 3.141592653589793d) / 2.0d;
                    f4 = (float) Math.sin(d2);
                    f3 = (float) (1.0d - Math.cos(d2));
                }
                drawable.setBounds(AnimationUtils.lerp((int) calculateIndicatorWidthForTab2.left, f4, (int) calculateIndicatorWidthForTab3.left), drawable.getBounds().top, AnimationUtils.lerp((int) calculateIndicatorWidthForTab2.right, f3, (int) calculateIndicatorWidthForTab3.right), drawable.getBounds().bottom);
                return;
        }
    }
}
