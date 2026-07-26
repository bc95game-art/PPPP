package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.R;
/* loaded from: classes.dex */
public final class Visibility$OverlayListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
    public boolean mHasOverlay = true;
    public final ViewGroup mOverlayHost;
    public final View mOverlayView;
    public final View mStartView;
    public final /* synthetic */ Fade this$0;

    public Visibility$OverlayListener(Fade fade, ViewGroup viewGroup, View view, View view2) {
        this.this$0 = fade;
        this.mOverlayHost = viewGroup;
        this.mOverlayView = view;
        this.mStartView = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        removeFromOverlay();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.mOverlayHost.getOverlay().remove(this.mOverlayView);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.mOverlayView;
        if (view.getParent() == null) {
            this.mOverlayHost.getOverlay().add(view);
        } else {
            this.this$0.cancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z) {
        if (z) {
            View view = this.mStartView;
            View view2 = this.mOverlayView;
            view.setTag(R.id.save_overlay_view, view2);
            this.mOverlayHost.getOverlay().add(view2);
            this.mHasOverlay = true;
        }
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
        if (this.mHasOverlay) {
            removeFromOverlay();
        }
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionEnd$1(Transition transition) {
        transition.removeListener(this);
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        throw null;
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionStart$1(Transition transition) {
    }

    public final void removeFromOverlay() {
        this.mStartView.setTag(R.id.save_overlay_view, null);
        this.mOverlayHost.getOverlay().remove(this.mOverlayView);
        this.mHasOverlay = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        if (!z) {
            removeFromOverlay();
        }
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionPause() {
    }

    @Override // androidx.transition.Transition.TransitionListener
    public final void onTransitionResume() {
    }
}
