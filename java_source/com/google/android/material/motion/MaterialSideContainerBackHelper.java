package com.google.android.material.motion;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.util.Log;
import android.util.Property;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.animation.AnimationUtils;
/* loaded from: classes.dex */
public final class MaterialSideContainerBackHelper extends MaterialBackAnimationHelper {
    public final float maxScaleXDistanceGrow;
    public final float maxScaleXDistanceShrink;
    public final float maxScaleYDistance;

    public MaterialSideContainerBackHelper(View view) {
        super(view);
        Resources resources = view.getResources();
        this.maxScaleXDistanceShrink = resources.getDimension(C0130R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
        this.maxScaleXDistanceGrow = resources.getDimension(C0130R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
        this.maxScaleYDistance = resources.getDimension(C0130R.dimen.m3_back_progress_side_container_max_scale_y_distance);
    }

    public final void cancelBackProgress() {
        if (this.backEvent == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        BackEventCompat backEventCompat = this.backEvent;
        this.backEvent = null;
        if (backEventCompat != null) {
            AnimatorSet animatorSet = new AnimatorSet();
            View view = this.view;
            animatorSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f));
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), View.SCALE_Y, 1.0f));
                }
            }
            animatorSet.setDuration(this.cancelDuration);
            animatorSet.start();
        }
    }

    public final void finishBackProgress(BackEventCompat backEventCompat, final int i, AnimatorListenerAdapter animatorListenerAdapter, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        final boolean z;
        boolean z2;
        int i2;
        if (backEventCompat.swipeEdge == 0) {
            z = true;
        } else {
            z = false;
        }
        View view = this.view;
        if ((Gravity.getAbsoluteGravity(i, view.getLayoutDirection()) & 3) == 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        float scaleX = view.getScaleX() * view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (z2) {
                i2 = marginLayoutParams.leftMargin;
            } else {
                i2 = marginLayoutParams.rightMargin;
            }
        } else {
            i2 = 0;
        }
        float f = scaleX + i2;
        Property property = View.TRANSLATION_X;
        if (z2) {
            f = -f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, f);
        if (animatorUpdateListener != null) {
            ofFloat.addUpdateListener(animatorUpdateListener);
        }
        ofFloat.setInterpolator(new FastOutSlowInInterpolator(0));
        ofFloat.setDuration(AnimationUtils.lerp(this.hideDurationMax, backEventCompat.progress, this.hideDurationMin));
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.motion.MaterialSideContainerBackHelper.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                MaterialSideContainerBackHelper materialSideContainerBackHelper = MaterialSideContainerBackHelper.this;
                materialSideContainerBackHelper.view.setTranslationX(0.0f);
                materialSideContainerBackHelper.updateBackProgress(0.0f, z, i);
            }
        });
        ofFloat.addListener(animatorListenerAdapter);
        ofFloat.start();
    }

    public final void updateBackProgress(float f, boolean z, int i) {
        boolean z2;
        float f2;
        float f3;
        float f4;
        float interpolation = this.progressInterpolator.getInterpolation(f);
        View view = this.view;
        boolean z3 = true;
        if ((Gravity.getAbsoluteGravity(i, view.getLayoutDirection()) & 3) == 3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2) {
            z3 = false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        float f5 = width;
        if (f5 > 0.0f) {
            float f6 = height;
            if (f6 > 0.0f) {
                float f7 = this.maxScaleXDistanceShrink / f5;
                float f8 = this.maxScaleXDistanceGrow / f5;
                float f9 = this.maxScaleYDistance / f6;
                if (z2) {
                    f5 = 0.0f;
                }
                view.setPivotX(f5);
                if (!z3) {
                    f8 = -f7;
                }
                float lerp = AnimationUtils.lerp(0.0f, f8, interpolation);
                float f10 = lerp + 1.0f;
                float lerp2 = 1.0f - AnimationUtils.lerp(0.0f, f9, interpolation);
                if (!(Float.isNaN(f10) || Float.isNaN(lerp2))) {
                    view.setScaleX(f10);
                    view.setScaleY(lerp2);
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            View childAt = viewGroup.getChildAt(i2);
                            if (z2) {
                                f2 = childAt.getWidth() + (width - childAt.getRight());
                            } else {
                                f2 = -childAt.getLeft();
                            }
                            childAt.setPivotX(f2);
                            childAt.setPivotY(-childAt.getTop());
                            if (z3) {
                                f3 = 1.0f - lerp;
                            } else {
                                f3 = 1.0f;
                            }
                            if (lerp2 != 0.0f) {
                                f4 = (f10 / lerp2) * f3;
                            } else {
                                f4 = 1.0f;
                            }
                            if (!Float.isNaN(f3) && !Float.isNaN(f4)) {
                                childAt.setScaleX(f3);
                                childAt.setScaleY(f4);
                            }
                        }
                    }
                }
            }
        }
    }
}
