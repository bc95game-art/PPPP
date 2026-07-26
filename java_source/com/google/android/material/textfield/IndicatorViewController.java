package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class IndicatorViewController {
    public AnimatorSet captionAnimator;
    public FrameLayout captionArea;
    public int captionDisplayed;
    public final int captionFadeInAnimationDuration;
    public final TimeInterpolator captionFadeInAnimationInterpolator;
    public final int captionFadeOutAnimationDuration;
    public final TimeInterpolator captionFadeOutAnimationInterpolator;
    public int captionToShow;
    public final int captionTranslationYAnimationDuration;
    public final TimeInterpolator captionTranslationYAnimationInterpolator;
    public final float captionTranslationYPx;
    public final Context context;
    public boolean errorEnabled;
    public CharSequence errorText;
    public int errorTextAppearance;
    public AppCompatTextView errorView;
    public int errorViewAccessibilityLiveRegion;
    public CharSequence errorViewContentDescription;
    public ColorStateList errorViewTextColor;
    public CharSequence helperText;
    public boolean helperTextEnabled;
    public int helperTextTextAppearance;
    public AppCompatTextView helperTextView;
    public ColorStateList helperTextViewTextColor;
    public LinearLayout indicatorArea;
    public int indicatorsAdded;
    public final TextInputLayout textInputView;
    public Typeface typeface;

    public IndicatorViewController(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.context = context;
        this.textInputView = textInputLayout;
        this.captionTranslationYPx = context.getResources().getDimensionPixelSize(C0130R.dimen.design_textinput_caption_translate_y);
        this.captionTranslationYAnimationDuration = LazyKt__LazyJVMKt.resolveThemeDuration(context, C0130R.attr.motionDurationShort4, 217);
        this.captionFadeInAnimationDuration = LazyKt__LazyJVMKt.resolveThemeDuration(context, C0130R.attr.motionDurationMedium4, 167);
        this.captionFadeOutAnimationDuration = LazyKt__LazyJVMKt.resolveThemeDuration(context, C0130R.attr.motionDurationShort4, 167);
        this.captionTranslationYAnimationInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(context, C0130R.attr.motionEasingEmphasizedDecelerateInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        this.captionFadeInAnimationInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(context, C0130R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.captionFadeOutAnimationInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(context, C0130R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void addIndicator(AppCompatTextView appCompatTextView, int i) {
        if (this.indicatorArea == null && this.captionArea == null) {
            Context context = this.context;
            LinearLayout linearLayout = new LinearLayout(context);
            this.indicatorArea = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.indicatorArea;
            TextInputLayout textInputLayout = this.textInputView;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.captionArea = new FrameLayout(context);
            this.indicatorArea.addView(this.captionArea, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                adjustIndicatorPadding();
            }
        }
        if (i == 0 || i == 1) {
            this.captionArea.setVisibility(0);
            this.captionArea.addView(appCompatTextView);
        } else {
            this.indicatorArea.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded++;
    }

    public final void adjustIndicatorPadding() {
        if (this.indicatorArea != null) {
            TextInputLayout textInputLayout = this.textInputView;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.context;
                boolean isFontScaleAtLeast1_3 = LazyKt__LazyJVMKt.isFontScaleAtLeast1_3(context);
                LinearLayout linearLayout = this.indicatorArea;
                int paddingStart = editText.getPaddingStart();
                if (isFontScaleAtLeast1_3) {
                    paddingStart = context.getResources().getDimensionPixelSize(C0130R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0130R.dimen.material_helper_text_default_padding_top);
                if (isFontScaleAtLeast1_3) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(C0130R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (isFontScaleAtLeast1_3) {
                    paddingEnd = context.getResources().getDimensionPixelSize(C0130R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void cancelCaptionAnimator() {
        AnimatorSet animatorSet = this.captionAnimator;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void createCaptionAnimators(ArrayList arrayList, boolean z, AppCompatTextView appCompatTextView, int i, int i2, int i3) {
        boolean z2;
        float f;
        long j;
        TimeInterpolator timeInterpolator;
        if (appCompatTextView != null && z) {
            if (i == i3 || i == i2) {
                if (i3 == i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(appCompatTextView, View.ALPHA, f);
                int i4 = this.captionFadeOutAnimationDuration;
                if (z2) {
                    j = this.captionFadeInAnimationDuration;
                } else {
                    j = i4;
                }
                ofFloat.setDuration(j);
                if (z2) {
                    timeInterpolator = this.captionFadeInAnimationInterpolator;
                } else {
                    timeInterpolator = this.captionFadeOutAnimationInterpolator;
                }
                ofFloat.setInterpolator(timeInterpolator);
                if (i == i3 && i2 != 0) {
                    ofFloat.setStartDelay(i4);
                }
                arrayList.add(ofFloat);
                if (i3 == i && i2 != 0) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(appCompatTextView, View.TRANSLATION_Y, -this.captionTranslationYPx, 0.0f);
                    ofFloat2.setDuration(this.captionTranslationYAnimationDuration);
                    ofFloat2.setInterpolator(this.captionTranslationYAnimationInterpolator);
                    ofFloat2.setStartDelay(i4);
                    arrayList.add(ofFloat2);
                }
            }
        }
    }

    public final TextView getCaptionViewFromDisplayState(int i) {
        if (i == 1) {
            return this.errorView;
        }
        if (i != 2) {
            return null;
        }
        return this.helperTextView;
    }

    public final void hideError() {
        this.errorText = null;
        cancelCaptionAnimator();
        if (this.captionDisplayed == 1) {
            if (!this.helperTextEnabled || TextUtils.isEmpty(this.helperText)) {
                this.captionToShow = 0;
            } else {
                this.captionToShow = 2;
            }
        }
        updateCaptionViewsVisibility(this.captionDisplayed, this.captionToShow, shouldAnimateCaptionView(this.errorView, ""));
    }

    public final void removeIndicator(AppCompatTextView appCompatTextView, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.indicatorArea;
        if (linearLayout != null) {
            if ((i == 0 || i == 1) && (frameLayout = this.captionArea) != null) {
                frameLayout.removeView(appCompatTextView);
            } else {
                linearLayout.removeView(appCompatTextView);
            }
            int i2 = this.indicatorsAdded - 1;
            this.indicatorsAdded = i2;
            LinearLayout linearLayout2 = this.indicatorArea;
            if (i2 == 0) {
                linearLayout2.setVisibility(8);
            }
        }
    }

    public final boolean shouldAnimateCaptionView(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.textInputView;
        if (!textInputLayout.isLaidOut() || !textInputLayout.isEnabled()) {
            return false;
        }
        if (this.captionToShow != this.captionDisplayed || appCompatTextView == null || !TextUtils.equals(appCompatTextView.getText(), charSequence)) {
            return true;
        }
        return false;
    }

    public final void updateCaptionViewsVisibility(final int i, final int i2, boolean z) {
        TextView captionViewFromDisplayState;
        TextView captionViewFromDisplayState2;
        if (i != i2) {
            if (z) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.captionAnimator = animatorSet;
                ArrayList arrayList = new ArrayList();
                createCaptionAnimators(arrayList, this.helperTextEnabled, this.helperTextView, 2, i, i2);
                createCaptionAnimators(arrayList, this.errorEnabled, this.errorView, 1, i, i2);
                LazyKt__LazyJVMKt.playTogether(animatorSet, arrayList);
                final TextView captionViewFromDisplayState3 = getCaptionViewFromDisplayState(i);
                final TextView captionViewFromDisplayState4 = getCaptionViewFromDisplayState(i2);
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.textfield.IndicatorViewController.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        AppCompatTextView appCompatTextView;
                        int i3 = i2;
                        IndicatorViewController indicatorViewController = IndicatorViewController.this;
                        indicatorViewController.captionDisplayed = i3;
                        indicatorViewController.captionAnimator = null;
                        TextView textView = captionViewFromDisplayState3;
                        if (textView != null) {
                            textView.setVisibility(4);
                            if (i == 1 && (appCompatTextView = indicatorViewController.errorView) != null) {
                                appCompatTextView.setText((CharSequence) null);
                            }
                        }
                        TextView textView2 = captionViewFromDisplayState4;
                        if (textView2 != null) {
                            textView2.setTranslationY(0.0f);
                            textView2.setAlpha(1.0f);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationStart(Animator animator) {
                        TextView textView = captionViewFromDisplayState4;
                        if (textView != null) {
                            textView.setVisibility(0);
                            textView.setAlpha(0.0f);
                        }
                    }
                });
                animatorSet.start();
            } else if (i != i2) {
                if (!(i2 == 0 || (captionViewFromDisplayState2 = getCaptionViewFromDisplayState(i2)) == null)) {
                    captionViewFromDisplayState2.setVisibility(0);
                    captionViewFromDisplayState2.setAlpha(1.0f);
                }
                if (!(i == 0 || (captionViewFromDisplayState = getCaptionViewFromDisplayState(i)) == null)) {
                    captionViewFromDisplayState.setVisibility(4);
                    if (i == 1) {
                        captionViewFromDisplayState.setText((CharSequence) null);
                    }
                }
                this.captionDisplayed = i2;
            }
            TextInputLayout textInputLayout = this.textInputView;
            textInputLayout.updateEditTextBackground();
            textInputLayout.updateLabelState(z, false);
            textInputLayout.updateTextInputBoxState();
        }
    }
}
