package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
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
/* loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior {
    public AccessibilityManager accessibilityManager;
    public ViewPropertyAnimator currentAnimator;
    public int enterAnimDuration;
    public TimeInterpolator enterAnimInterpolator;
    public int exitAnimDuration;
    public TimeInterpolator exitAnimInterpolator;
    public LazyKt__LazyJVMKt hideOnScrollViewDelegate;
    public HideViewOnScrollBehavior$$ExternalSyntheticLambda0 touchExplorationListener;
    public final LinkedHashSet onScrollStateChangedListeners = new LinkedHashSet();
    public int size = 0;
    public int currentState = 2;

    public HideViewOnScrollBehavior() {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i2;
        if (this.accessibilityManager == null) {
            this.accessibilityManager = (AccessibilityManager) BundleKt.getSystemService(view.getContext(), AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null && this.touchExplorationListener == null) {
            HideViewOnScrollBehavior$$ExternalSyntheticLambda0 hideViewOnScrollBehavior$$ExternalSyntheticLambda0 = new HideViewOnScrollBehavior$$ExternalSyntheticLambda0(this, view, 0);
            this.touchExplorationListener = hideViewOnScrollBehavior$$ExternalSyntheticLambda0;
            accessibilityManager.addTouchExplorationStateChangeListener(hideViewOnScrollBehavior$$ExternalSyntheticLambda0);
            view.addOnAttachStateChangeListener(new StandardMenuPopup.View$OnAttachStateChangeListenerC00202(3, this));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i3 = ((CoordinatorLayout.LayoutParams) view.getLayoutParams()).gravity;
        if (i3 == 80 || i3 == 81) {
            setViewEdgeInternal(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i3, i);
            if (absoluteGravity == 3 || absoluteGravity == 19) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            setViewEdgeInternal(i2);
        }
        this.size = this.hideOnScrollViewDelegate.getSize(view, marginLayoutParams);
        this.enterAnimDuration = LazyKt__LazyJVMKt.resolveThemeDuration(view.getContext(), C0130R.attr.motionDurationLong2, 225);
        this.exitAnimDuration = LazyKt__LazyJVMKt.resolveThemeDuration(view.getContext(), C0130R.attr.motionDurationMedium4, 175);
        this.enterAnimInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(view.getContext(), C0130R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(view.getContext(), C0130R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        if (i > 0) {
            if (this.currentState != 1) {
                AccessibilityManager accessibilityManager = this.accessibilityManager;
                if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                    ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
                    if (viewPropertyAnimator != null) {
                        viewPropertyAnimator.cancel();
                        view.clearAnimation();
                    }
                    this.currentState = 1;
                    Iterator it = this.onScrollStateChangedListeners.iterator();
                    if (!it.hasNext()) {
                        int i4 = this.size;
                        this.currentAnimator = this.hideOnScrollViewDelegate.getViewTranslationAnimator(i4, view).setInterpolator(this.exitAnimInterpolator).setDuration(this.exitAnimDuration).setListener(new Transition.C01123(5, this));
                        return;
                    }
                    throw ViewModelProvider.Factory.CC.m592m(it);
                }
            }
        } else if (i < 0) {
            slideIn(view);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        if (i == 2) {
            return true;
        }
        return false;
    }

    public final void setViewEdgeInternal(int i) {
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt = this.hideOnScrollViewDelegate;
        if (lazyKt__LazyJVMKt != null && lazyKt__LazyJVMKt.getViewEdge() == i) {
            return;
        }
        if (i == 0) {
            this.hideOnScrollViewDelegate = new HideLeftViewOnScrollDelegate(2);
        } else if (i == 1) {
            this.hideOnScrollViewDelegate = new HideLeftViewOnScrollDelegate(1);
        } else if (i == 2) {
            this.hideOnScrollViewDelegate = new HideLeftViewOnScrollDelegate(0);
        } else {
            throw new IllegalArgumentException("Invalid view edge position value: " + i + ". Must be 0, 1 or 2.");
        }
    }

    public final void slideIn(View view) {
        if (this.currentState != 2) {
            ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.currentState = 2;
            Iterator it = this.onScrollStateChangedListeners.iterator();
            if (!it.hasNext()) {
                this.hideOnScrollViewDelegate.getClass();
                this.currentAnimator = this.hideOnScrollViewDelegate.getViewTranslationAnimator(0, view).setInterpolator(this.enterAnimInterpolator).setDuration(this.enterAnimDuration).setListener(new Transition.C01123(5, this));
                return;
            }
            throw ViewModelProvider.Factory.CC.m592m(it);
        }
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
