package com.google.android.material.behavior;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public final /* synthetic */ class HideViewOnScrollBehavior$$ExternalSyntheticLambda0 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CoordinatorLayout.Behavior f$0;
    public final /* synthetic */ View f$1;

    public /* synthetic */ HideViewOnScrollBehavior$$ExternalSyntheticLambda0(CoordinatorLayout.Behavior behavior, View view, int i) {
        this.$r8$classId = i;
        this.f$0 = behavior;
        this.f$1 = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        switch (this.$r8$classId) {
            case 0:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f$0;
                if (z && hideViewOnScrollBehavior.currentState == 1) {
                    hideViewOnScrollBehavior.slideIn(this.f$1);
                    return;
                }
                return;
            default:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f$0;
                if (z && hideBottomViewOnScrollBehavior.currentState == 1) {
                    hideBottomViewOnScrollBehavior.slideUp(this.f$1);
                    return;
                }
                return;
        }
    }
}
