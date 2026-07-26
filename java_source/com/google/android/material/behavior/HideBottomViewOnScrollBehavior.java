package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.p002os.BundleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.animation.AnimationUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.LazyKt__LazyJVMKt;
@Deprecated
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior {
    public AccessibilityManager accessibilityManager;
    public ViewPropertyAnimator currentAnimator;
    public int enterAnimDuration;
    public TimeInterpolator enterAnimInterpolator;
    public int exitAnimDuration;
    public TimeInterpolator exitAnimInterpolator;
    public HideViewOnScrollBehavior$$ExternalSyntheticLambda0 touchExplorationListener;
    public final LinkedHashSet onScrollStateChangedListeners = new LinkedHashSet();
    public int height = 0;
    public final boolean disableOnTouchExploration = true;
    public int currentState = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.height = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.enterAnimDuration = LazyKt__LazyJVMKt.resolveThemeDuration(view.getContext(), C0130R.attr.motionDurationLong2, 225);
        this.exitAnimDuration = LazyKt__LazyJVMKt.resolveThemeDuration(view.getContext(), C0130R.attr.motionDurationMedium4, 175);
        this.enterAnimInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(view.getContext(), C0130R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(view.getContext(), C0130R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        if (this.accessibilityManager == null) {
            this.accessibilityManager = (AccessibilityManager) BundleKt.getSystemService(view.getContext(), AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || this.touchExplorationListener != null) {
            return false;
        }
        HideViewOnScrollBehavior$$ExternalSyntheticLambda0 hideViewOnScrollBehavior$$ExternalSyntheticLambda0 = new HideViewOnScrollBehavior$$ExternalSyntheticLambda0(this, view, 1);
        this.touchExplorationListener = hideViewOnScrollBehavior$$ExternalSyntheticLambda0;
        accessibilityManager.addTouchExplorationStateChangeListener(hideViewOnScrollBehavior$$ExternalSyntheticLambda0);
        view.addOnAttachStateChangeListener(new StandardMenuPopup.View$OnAttachStateChangeListenerC00202(2, this));
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i > 0) {
            if (this.currentState != 1) {
                if (!this.disableOnTouchExploration || (accessibilityManager = this.accessibilityManager) == null || !accessibilityManager.isTouchExplorationEnabled()) {
                    ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
                    if (viewPropertyAnimator != null) {
                        viewPropertyAnimator.cancel();
                        view.clearAnimation();
                    }
                    this.currentState = 1;
                    Iterator it = this.onScrollStateChangedListeners.iterator();
                    if (!it.hasNext()) {
                        this.currentAnimator = view.animate().translationY(this.height).setInterpolator(this.exitAnimInterpolator).setDuration(this.exitAnimDuration).setListener(new Transition.C01123(4, this));
                        return;
                    }
                    throw ViewModelProvider.Factory.CC.m592m(it);
                }
            }
        } else if (i < 0) {
            slideUp(view);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        if (i == 2) {
            return true;
        }
        return false;
    }

    public final void slideUp(View view) {
        if (this.currentState != 2) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.currentState = 2;
            Iterator it = this.onScrollStateChangedListeners.iterator();
            if (!it.hasNext()) {
                this.currentAnimator = view.animate().translationY(0).setInterpolator(this.enterAnimInterpolator).setDuration(this.enterAnimDuration).setListener(new Transition.C01123(4, this));
                return;
            }
            throw ViewModelProvider.Factory.CC.m592m(it);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
