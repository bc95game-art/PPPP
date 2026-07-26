package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.fragments.AppsFragment$$ExternalSyntheticLambda2;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class DropdownMenuEndIconDelegate extends EndIconDelegate {
    public AccessibilityManager accessibilityManager;
    public final int animationFadeInDuration;
    public final TimeInterpolator animationFadeInterpolator;
    public final int animationFadeOutDuration;
    public AutoCompleteTextView autoCompleteTextView;
    public boolean dropdownPopupDirty;
    public boolean editTextHasFocus;
    public ValueAnimator fadeInAnim;
    public ValueAnimator fadeOutAnim;
    public boolean isEndIconChecked;
    public final AppsFragment$$ExternalSyntheticLambda2 onIconClickListener = new AppsFragment$$ExternalSyntheticLambda2(10, this);
    public final ClearTextEndIconDelegate$$ExternalSyntheticLambda1 onEditTextFocusChangeListener = new ClearTextEndIconDelegate$$ExternalSyntheticLambda1(this, 1);
    public final DropdownMenuEndIconDelegate$$ExternalSyntheticLambda5 touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate$$ExternalSyntheticLambda5
        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public final void onTouchExplorationStateChanged(boolean z) {
            int i;
            DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
            AutoCompleteTextView autoCompleteTextView = dropdownMenuEndIconDelegate.autoCompleteTextView;
            if (autoCompleteTextView != null && autoCompleteTextView.getInputType() == 0) {
                CheckableImageButton checkableImageButton = dropdownMenuEndIconDelegate.endIconView;
                if (z) {
                    i = 2;
                } else {
                    i = 1;
                }
                checkableImageButton.setImportantForAccessibility(i);
            }
        }
    };
    public long dropdownPopupActivatedAt = Long.MAX_VALUE;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.material.textfield.DropdownMenuEndIconDelegate$$ExternalSyntheticLambda5] */
    public DropdownMenuEndIconDelegate(EndCompoundLayout endCompoundLayout) {
        super(endCompoundLayout);
        this.animationFadeInDuration = LazyKt__LazyJVMKt.resolveThemeDuration(endCompoundLayout.getContext(), C0130R.attr.motionDurationShort3, 67);
        this.animationFadeOutDuration = LazyKt__LazyJVMKt.resolveThemeDuration(endCompoundLayout.getContext(), C0130R.attr.motionDurationShort3, 50);
        this.animationFadeInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(endCompoundLayout.getContext(), C0130R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void afterEditTextChanged() {
        if (this.accessibilityManager.isTouchExplorationEnabled() && this.autoCompleteTextView.getInputType() != 0 && !this.endIconView.hasFocus()) {
            this.autoCompleteTextView.dismissDropDown();
        }
        this.autoCompleteTextView.post(new ActivityCompat$$ExternalSyntheticLambda0(23, this));
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final int getIconContentDescriptionResId() {
        return C0130R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final int getIconDrawableResId() {
        return C0130R.C0131drawable.mtrl_dropdown_arrow;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnFocusChangeListener getOnEditTextFocusChangeListener() {
        return this.onEditTextFocusChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final View.OnClickListener getOnIconClickListener() {
        return this.onIconClickListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final AccessibilityManager.TouchExplorationStateChangeListener getTouchExplorationStateChangeListener() {
        return this.touchExplorationStateChangeListener;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final boolean isBoxBackgroundModeSupported(int i) {
        return i != 0;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final boolean isIconChecked() {
        return this.isEndIconChecked;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void onEditTextAttached(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            this.autoCompleteTextView = autoCompleteTextView;
            autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate$$ExternalSyntheticLambda1
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                        long j = uptimeMillis - dropdownMenuEndIconDelegate.dropdownPopupActivatedAt;
                        if (j < 0 || j > 300) {
                            dropdownMenuEndIconDelegate.dropdownPopupDirty = false;
                        }
                        dropdownMenuEndIconDelegate.showHideDropdown();
                        dropdownMenuEndIconDelegate.dropdownPopupDirty = true;
                        dropdownMenuEndIconDelegate.dropdownPopupActivatedAt = SystemClock.uptimeMillis();
                    }
                    return false;
                }
            });
            this.autoCompleteTextView.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.DropdownMenuEndIconDelegate$$ExternalSyntheticLambda2
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = DropdownMenuEndIconDelegate.this;
                    dropdownMenuEndIconDelegate.dropdownPopupDirty = true;
                    dropdownMenuEndIconDelegate.dropdownPopupActivatedAt = SystemClock.uptimeMillis();
                    dropdownMenuEndIconDelegate.setEndIconChecked(false);
                }
            });
            this.autoCompleteTextView.setThreshold(0);
            TextInputLayout textInputLayout = this.textInputLayout;
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (editText.getInputType() == 0 && this.accessibilityManager.isTouchExplorationEnabled()) {
                this.endIconView.setImportantForAccessibility(2);
            }
            textInputLayout.setEndIconVisible(true);
            return;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.autoCompleteTextView.getInputType() == 0) {
            accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
        }
        if (accessibilityNodeInfoCompat.isShowingHintText()) {
            accessibilityNodeInfoCompat.setHintText(null);
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        boolean z;
        if (this.accessibilityManager.isEnabled() && this.autoCompleteTextView.getInputType() == 0) {
            if ((accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.isEndIconChecked && !this.autoCompleteTextView.isPopupShowing()) {
                z = true;
            } else {
                z = false;
            }
            if (accessibilityEvent.getEventType() == 1 || z) {
                showHideDropdown();
                this.dropdownPopupDirty = true;
                this.dropdownPopupActivatedAt = SystemClock.uptimeMillis();
            }
        }
    }

    public final void setEndIconChecked(boolean z) {
        if (this.isEndIconChecked != z) {
            this.isEndIconChecked = z;
            this.fadeInAnim.cancel();
            this.fadeOutAnim.start();
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void setUp() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.animationFadeInterpolator;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration(this.animationFadeInDuration);
        ofFloat.addUpdateListener(new ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(4, this));
        this.fadeInAnim = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(this.animationFadeOutDuration);
        ofFloat2.addUpdateListener(new ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(4, this));
        this.fadeOutAnim = ofFloat2;
        ofFloat2.addListener(new Transition.C01123(10, this));
        this.accessibilityManager = (AccessibilityManager) this.context.getSystemService("accessibility");
    }

    public final void showHideDropdown() {
        if (this.autoCompleteTextView != null) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.dropdownPopupActivatedAt;
            if (uptimeMillis < 0 || uptimeMillis > 300) {
                this.dropdownPopupDirty = false;
            }
            if (!this.dropdownPopupDirty) {
                setEndIconChecked(!this.isEndIconChecked);
                if (this.isEndIconChecked) {
                    this.autoCompleteTextView.requestFocus();
                    this.autoCompleteTextView.showDropDown();
                    return;
                }
                this.autoCompleteTextView.dismissDropDown();
                return;
            }
            this.dropdownPopupDirty = false;
        }
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void tearDown() {
        AutoCompleteTextView autoCompleteTextView = this.autoCompleteTextView;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.autoCompleteTextView.setOnDismissListener(null);
        }
    }
}
