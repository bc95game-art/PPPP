package com.google.android.material.motion;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.emanuelef.remote_capture.R;
import com.google.android.material.animation.AnimationUtils;
/* loaded from: classes.dex */
public final class MaterialBottomContainerBackHelper extends MaterialBackAnimationHelper {
    public final float maxScaleXDistance;
    public final float maxScaleYDistance;

    public MaterialBottomContainerBackHelper(View view) {
        super(view);
        Resources resources = view.getResources();
        this.maxScaleXDistance = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
        this.maxScaleYDistance = resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
    }

    public final AnimatorSet createResetScaleAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        View view = this.view;
        animatorSet.playTogether(ObjectAnimator.ofFloat(view, View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(view, View.SCALE_Y, 1.0f));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                animatorSet.playTogether(ObjectAnimator.ofFloat(viewGroup.getChildAt(i), View.SCALE_Y, 1.0f));
            }
        }
        animatorSet.setInterpolator(new FastOutSlowInInterpolator(0));
        return animatorSet;
    }

    public final void updateBackProgress(float f) {
        float f2;
        float interpolation = this.progressInterpolator.getInterpolation(f);
        View view = this.view;
        float width = view.getWidth();
        float height = view.getHeight();
        if (width > 0.0f && height > 0.0f) {
            float lerp = 1.0f - AnimationUtils.lerp(0.0f, this.maxScaleXDistance / width, interpolation);
            float lerp2 = 1.0f - AnimationUtils.lerp(0.0f, this.maxScaleYDistance / height, interpolation);
            if (!(Float.isNaN(lerp) || Float.isNaN(lerp2))) {
                view.setScaleX(lerp);
                view.setPivotY(height);
                view.setScaleY(lerp2);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        View childAt = viewGroup.getChildAt(i);
                        childAt.setPivotY(-childAt.getTop());
                        if (lerp2 != 0.0f) {
                            f2 = lerp / lerp2;
                        } else {
                            f2 = 1.0f;
                        }
                        childAt.setScaleY(f2);
                    }
                }
            }
        }
    }
}
