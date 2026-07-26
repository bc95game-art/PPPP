package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import com.emanuelef.remote_capture.R;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda2;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class ClearTextEndIconDelegate extends EndIconDelegate {
    public final int animationFadeDuration;
    public final TimeInterpolator animationFadeInterpolator;
    public final int animationScaleDuration;
    public final TimeInterpolator animationScaleInterpolator;
    public EditText editText;
    public AnimatorSet iconInAnim;
    public ValueAnimator iconOutAnim;
    public final AppsFragment$$ExternalSyntheticLambda2 onIconClickListener = new AppsFragment$$ExternalSyntheticLambda2(9, this);
    public final ClearTextEndIconDelegate$$ExternalSyntheticLambda1 onFocusChangeListener = new ClearTextEndIconDelegate$$ExternalSyntheticLambda1(this, 0);

    public ClearTextEndIconDelegate(EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        this.animationFadeDuration = LazyKt__LazyJVMKt.resolveThemeDuration(endCompoundLayout.getContext(), R.attr.motionDurationShort3, 100);
        this.animationScaleDuration = LazyKt__LazyJVMKt.resolveThemeDuration(endCompoundLayout.getContext(), R.attr.motionDurationShort3, 150);
        this.animationFadeInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(endCompoundLayout.getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.animationScaleInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(endCompoundLayout.getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void afterEditTextChanged() {
        if (this.endLayout.suffixText == null) {
            animateIcon(shouldBeVisible());
        }
    }

    public final void animateIcon(boolean z) {
        boolean z2;
        if (this.endLayout.isEndIconVisible() == z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && !this.iconInAnim.isRunning()) {
            this.iconOutAnim.cancel();
            this.iconInAnim.start();
            if (z2) {
                this.iconInAnim.end();
            }
        } else if (!z) {
            this.iconInAnim.cancel();
            this.iconOutAnim.start();
            if (z2) {
                this.iconOutAnim.end();
            }
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final int getIconContentDescriptionResId() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final int getIconDrawableResId() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnFocusChangeListener getOnIconViewFocusChangeListener() {
        return this.onFocusChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void onEditTextAttached(EditText editText) {
        this.editText = editText;
        this.textInputLayout.setEndIconVisible(shouldBeVisible());
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void onSuffixVisibilityChanged(boolean z) {
        if (this.endLayout.suffixText != null) {
            animateIcon(z);
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void setUp() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.animationScaleInterpolator);
        ofFloat.setDuration(this.animationScaleDuration);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate$$ExternalSyntheticLambda2
            public final /* synthetic */ ClearTextEndIconDelegate f$0;

            {
                this.f$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (r2) {
                    case 0:
                        ClearTextEndIconDelegate clearTextEndIconDelegate = this.f$0;
                        clearTextEndIconDelegate.getClass();
                        clearTextEndIconDelegate.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    default:
                        ClearTextEndIconDelegate clearTextEndIconDelegate2 = this.f$0;
                        clearTextEndIconDelegate2.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = clearTextEndIconDelegate2.endIconView;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        return;
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.animationFadeInterpolator;
        ofFloat2.setInterpolator(timeInterpolator);
        int i = this.animationFadeDuration;
        ofFloat2.setDuration(i);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate$$ExternalSyntheticLambda2
            public final /* synthetic */ ClearTextEndIconDelegate f$0;

            {
                this.f$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (r2) {
                    case 0:
                        ClearTextEndIconDelegate clearTextEndIconDelegate = this.f$0;
                        clearTextEndIconDelegate.getClass();
                        clearTextEndIconDelegate.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    default:
                        ClearTextEndIconDelegate clearTextEndIconDelegate2 = this.f$0;
                        clearTextEndIconDelegate2.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = clearTextEndIconDelegate2.endIconView;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        return;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.iconInAnim = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.iconInAnim.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                switch (r2) {
                    case 1:
                        this.this$0.endLayout.setEndIconVisible(false);
                        return;
                    default:
                        super.onAnimationEnd(animator);
                        return;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                switch (r2) {
                    case 0:
                        this.this$0.endLayout.setEndIconVisible(true);
                        return;
                    default:
                        super.onAnimationStart(animator);
                        return;
                }
            }
        });
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(i);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate$$ExternalSyntheticLambda2
            public final /* synthetic */ ClearTextEndIconDelegate f$0;

            {
                this.f$0 = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (r2) {
                    case 0:
                        ClearTextEndIconDelegate clearTextEndIconDelegate = this.f$0;
                        clearTextEndIconDelegate.getClass();
                        clearTextEndIconDelegate.endIconView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        return;
                    default:
                        ClearTextEndIconDelegate clearTextEndIconDelegate2 = this.f$0;
                        clearTextEndIconDelegate2.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = clearTextEndIconDelegate2.endIconView;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        return;
                }
            }
        });
        this.iconOutAnim = ofFloat3;
        ofFloat3.addListener(new AnimatorListenerAdapter(this) { // from class: com.google.android.material.textfield.ClearTextEndIconDelegate.1
            public final /* synthetic */ ClearTextEndIconDelegate this$0;

            {
                this.this$0 = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                switch (r2) {
                    case 1:
                        this.this$0.endLayout.setEndIconVisible(false);
                        return;
                    default:
                        super.onAnimationEnd(animator);
                        return;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                switch (r2) {
                    case 0:
                        this.this$0.endLayout.setEndIconVisible(true);
                        return;
                    default:
                        super.onAnimationStart(animator);
                        return;
                }
            }
        });
    }

    public final boolean shouldBeVisible() {
        EditText editText = this.editText;
        if (editText == null) {
            return false;
        }
        if ((editText.hasFocus() || this.endIconView.hasFocus()) && this.editText.getText().length() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void tearDown() {
        EditText editText = this.editText;
        if (editText != null) {
            editText.post(new ActivityCompat$$ExternalSyntheticLambda0(22, this));
        }
    }
}
