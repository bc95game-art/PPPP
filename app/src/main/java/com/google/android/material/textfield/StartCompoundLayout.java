package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import com.emanuelef.remote_capture.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.ripple.RippleUtils;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class StartCompoundLayout extends LinearLayout {
    public boolean hintExpanded;
    public CharSequence prefixText;
    public final AppCompatTextView prefixTextView;
    public int startIconMinSize;
    public View.OnLongClickListener startIconOnLongClickListener;
    public ImageView.ScaleType startIconScaleType;
    public ColorStateList startIconTintList;
    public PorterDuff.Mode startIconTintMode;
    public final CheckableImageButton startIconView;
    public final TextInputLayout textInputLayout;

    public StartCompoundLayout(TextInputLayout textInputLayout, MatcherMatchResult matcherMatchResult) {
        super(textInputLayout.getContext());
        CharSequence text;
        Drawable createOvalRipple;
        this.textInputLayout = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388611));
        CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_start_icon, (ViewGroup) this, false);
        this.startIconView = checkableImageButton;
        if (Build.VERSION.SDK_INT < 23) {
            createOvalRipple = RippleUtils.RippleUtilsLollipop.createOvalRipple(checkableImageButton.getContext(), (int) ViewUtils.dpToPx(checkableImageButton.getContext(), 4));
            checkableImageButton.setBackground(createOvalRipple);
        }
        CharSequence charSequence = null;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.prefixTextView = appCompatTextView;
        if (LazyKt__LazyJVMKt.isFontScaleAtLeast1_3(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginEnd(0);
        }
        View.OnLongClickListener onLongClickListener = this.startIconOnLongClickListener;
        checkableImageButton.setOnClickListener(null);
        LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, onLongClickListener);
        this.startIconOnLongClickListener = null;
        checkableImageButton.setOnLongClickListener(null);
        LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, null);
        TypedArray typedArray = (TypedArray) matcherMatchResult.input;
        if (typedArray.hasValue(70)) {
            this.startIconTintList = LazyKt__LazyJVMKt.getColorStateList(getContext(), matcherMatchResult, 70);
        }
        if (typedArray.hasValue(71)) {
            this.startIconTintMode = ViewUtils.parseTintMode(typedArray.getInt(71, -1), null);
        }
        if (typedArray.hasValue(67)) {
            setStartIconDrawable(matcherMatchResult.getDrawable(67));
            if (typedArray.hasValue(66) && checkableImageButton.getContentDescription() != (text = typedArray.getText(66))) {
                checkableImageButton.setContentDescription(text);
            }
            checkableImageButton.setCheckable(typedArray.getBoolean(65, true));
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(68, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize >= 0) {
            if (dimensionPixelSize != this.startIconMinSize) {
                this.startIconMinSize = dimensionPixelSize;
                checkableImageButton.setMinimumWidth(dimensionPixelSize);
                checkableImageButton.setMinimumHeight(dimensionPixelSize);
            }
            if (typedArray.hasValue(69)) {
                ImageView.ScaleType convertScaleType = LazyKt__LazyJVMKt.convertScaleType(typedArray.getInt(69, -1));
                this.startIconScaleType = convertScaleType;
                checkableImageButton.setScaleType(convertScaleType);
            }
            appCompatTextView.setVisibility(8);
            appCompatTextView.setId(R.id.textinput_prefix_text);
            appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            appCompatTextView.setAccessibilityLiveRegion(1);
            TextViewCompat.setTextAppearance(appCompatTextView, typedArray.getResourceId(61, 0));
            if (typedArray.hasValue(62)) {
                appCompatTextView.setTextColor(matcherMatchResult.getColorStateList(62));
            }
            CharSequence text2 = typedArray.getText(60);
            this.prefixText = !TextUtils.isEmpty(text2) ? text2 : charSequence;
            appCompatTextView.setText(text2);
            updateVisibility();
            addView(checkableImageButton);
            addView(appCompatTextView);
            return;
        }
        throw new IllegalArgumentException("startIconSize cannot be less than 0");
    }

    public final int getPrefixTextStartOffset() {
        int i;
        CheckableImageButton checkableImageButton = this.startIconView;
        if (checkableImageButton.getVisibility() == 0) {
            i = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginEnd() + checkableImageButton.getMeasuredWidth();
        } else {
            i = 0;
        }
        return this.prefixTextView.getPaddingStart() + getPaddingStart() + i;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        updatePrefixTextViewPadding();
    }

    public final void setStartIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.startIconView;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            ColorStateList colorStateList = this.startIconTintList;
            PorterDuff.Mode mode = this.startIconTintMode;
            TextInputLayout textInputLayout = this.textInputLayout;
            LazyKt__LazyJVMKt.applyIconTint(textInputLayout, checkableImageButton, colorStateList, mode);
            setStartIconVisible(true);
            LazyKt__LazyJVMKt.refreshIconDrawableState(textInputLayout, checkableImageButton, this.startIconTintList);
            return;
        }
        setStartIconVisible(false);
        View.OnLongClickListener onLongClickListener = this.startIconOnLongClickListener;
        checkableImageButton.setOnClickListener(null);
        LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, onLongClickListener);
        this.startIconOnLongClickListener = null;
        checkableImageButton.setOnLongClickListener(null);
        LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, null);
        if (checkableImageButton.getContentDescription() != null) {
            checkableImageButton.setContentDescription(null);
        }
    }

    public final void setStartIconVisible(boolean z) {
        boolean z2;
        CheckableImageButton checkableImageButton = this.startIconView;
        int i = 0;
        if (checkableImageButton.getVisibility() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 != z) {
            if (!z) {
                i = 8;
            }
            checkableImageButton.setVisibility(i);
            updatePrefixTextViewPadding();
            updateVisibility();
        }
    }

    public final void updatePrefixTextViewPadding() {
        int i;
        EditText editText = this.textInputLayout.editText;
        if (editText != null) {
            if (this.startIconView.getVisibility() == 0) {
                i = 0;
            } else {
                i = editText.getPaddingStart();
            }
            this.prefixTextView.setPaddingRelative(i, editText.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), editText.getCompoundPaddingBottom());
        }
    }

    public final void updateVisibility() {
        int i;
        int i2 = 8;
        if (this.prefixText == null || this.hintExpanded) {
            i = 8;
        } else {
            i = 0;
        }
        if (this.startIconView.getVisibility() == 0 || i == 0) {
            i2 = 0;
        }
        setVisibility(i2);
        this.prefixTextView.setVisibility(i);
        this.textInputLayout.updateDummyDrawables();
    }
}
