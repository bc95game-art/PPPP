package com.google.android.material.textfield;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.os.BundleKt;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.ViewModelProvider;
import com.emanuelef.remote_capture.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.ripple.RippleUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public final class EndCompoundLayout extends LinearLayout {
    public EditText editText;
    public final EndIconDelegates endIconDelegates;
    public final FrameLayout endIconFrame;
    public int endIconMinSize;
    public View.OnLongClickListener endIconOnLongClickListener;
    public ImageView.ScaleType endIconScaleType;
    public ColorStateList endIconTintList;
    public PorterDuff.Mode endIconTintMode;
    public final CheckableImageButton endIconView;
    public View.OnLongClickListener errorIconOnLongClickListener;
    public ColorStateList errorIconTintList;
    public PorterDuff.Mode errorIconTintMode;
    public final CheckableImageButton errorIconView;
    public boolean hintExpanded;
    public CharSequence suffixText;
    public final AppCompatTextView suffixTextView;
    public final TextInputLayout textInputLayout;
    public AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
    public int endIconMode = 0;
    public final LinkedHashSet endIconChangedListeners = new LinkedHashSet();
    public final AnonymousClass1 editTextWatcher = new TextWatcherAdapter() { // from class: com.google.android.material.textfield.EndCompoundLayout.1
        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            EndCompoundLayout.this.getEndIconDelegate().afterEditTextChanged();
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            EndCompoundLayout.this.getEndIconDelegate().beforeEditTextChanged();
        }
    };
    public final AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");

    /* renamed from: com.google.android.material.textfield.EndCompoundLayout$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 {
        public AnonymousClass2() {
        }

        public final void onEditTextAttached(TextInputLayout textInputLayout) {
            EndCompoundLayout endCompoundLayout = EndCompoundLayout.this;
            AnonymousClass1 r1 = endCompoundLayout.editTextWatcher;
            if (endCompoundLayout.editText != textInputLayout.getEditText()) {
                EditText editText = endCompoundLayout.editText;
                if (editText != null) {
                    editText.removeTextChangedListener(r1);
                    if (endCompoundLayout.editText.getOnFocusChangeListener() == endCompoundLayout.getEndIconDelegate().getOnEditTextFocusChangeListener()) {
                        endCompoundLayout.editText.setOnFocusChangeListener(null);
                    }
                }
                EditText editText2 = textInputLayout.getEditText();
                endCompoundLayout.editText = editText2;
                if (editText2 != null) {
                    editText2.addTextChangedListener(r1);
                }
                endCompoundLayout.getEndIconDelegate().onEditTextAttached(endCompoundLayout.editText);
                endCompoundLayout.setOnFocusChangeListenersIfNeeded(endCompoundLayout.getEndIconDelegate());
            }
        }
    }

    /* loaded from: classes.dex */
    public final class EndIconDelegates {
        public final int customEndIconDrawableId;
        public final SparseArray delegates = new SparseArray();
        public final EndCompoundLayout endLayout;
        public final int passwordIconDrawableId;

        public EndIconDelegates(EndCompoundLayout endCompoundLayout, MatcherMatchResult matcherMatchResult) {
            this.endLayout = endCompoundLayout;
            TypedArray typedArray = (TypedArray) matcherMatchResult.input;
            this.customEndIconDrawableId = typedArray.getResourceId(28, 0);
            this.passwordIconDrawableId = typedArray.getResourceId(53, 0);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.android.material.textfield.EndCompoundLayout$1] */
    public EndCompoundLayout(TextInputLayout textInputLayout, MatcherMatchResult matcherMatchResult) {
        super(textInputLayout.getContext());
        CharSequence text;
        AnonymousClass2 r4 = new AnonymousClass2();
        this.textInputLayout = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.endIconFrame = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater from = LayoutInflater.from(getContext());
        CheckableImageButton createIconView = createIconView(this, from, R.id.text_input_error_icon);
        this.errorIconView = createIconView;
        CheckableImageButton createIconView2 = createIconView(frameLayout, from, R.id.text_input_end_icon);
        this.endIconView = createIconView2;
        this.endIconDelegates = new EndIconDelegates(this, matcherMatchResult);
        CharSequence charSequence = null;
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
        this.suffixTextView = appCompatTextView;
        TypedArray typedArray = (TypedArray) matcherMatchResult.input;
        if (typedArray.hasValue(38)) {
            this.errorIconTintList = LazyKt__LazyJVMKt.getColorStateList(getContext(), matcherMatchResult, 38);
        }
        if (typedArray.hasValue(39)) {
            this.errorIconTintMode = ViewUtils.parseTintMode(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            setErrorIconDrawable(matcherMatchResult.getDrawable(37));
        }
        createIconView.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        createIconView.setImportantForAccessibility(2);
        createIconView.setClickable(false);
        createIconView.setPressable(false);
        createIconView.setCheckable(false);
        createIconView.setFocusable(false);
        if (!typedArray.hasValue(54)) {
            if (typedArray.hasValue(32)) {
                this.endIconTintList = LazyKt__LazyJVMKt.getColorStateList(getContext(), matcherMatchResult, 32);
            }
            if (typedArray.hasValue(33)) {
                this.endIconTintMode = ViewUtils.parseTintMode(typedArray.getInt(33, -1), null);
            }
        }
        if (typedArray.hasValue(30)) {
            setEndIconMode(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && createIconView2.getContentDescription() != (text = typedArray.getText(27))) {
                createIconView2.setContentDescription(text);
            }
            createIconView2.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(54)) {
            if (typedArray.hasValue(55)) {
                this.endIconTintList = LazyKt__LazyJVMKt.getColorStateList(getContext(), matcherMatchResult, 55);
            }
            if (typedArray.hasValue(56)) {
                this.endIconTintMode = ViewUtils.parseTintMode(typedArray.getInt(56, -1), null);
            }
            setEndIconMode(typedArray.getBoolean(54, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(52);
            if (createIconView2.getContentDescription() != text2) {
                createIconView2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize >= 0) {
            if (dimensionPixelSize != this.endIconMinSize) {
                this.endIconMinSize = dimensionPixelSize;
                createIconView2.setMinimumWidth(dimensionPixelSize);
                createIconView2.setMinimumHeight(dimensionPixelSize);
                createIconView.setMinimumWidth(dimensionPixelSize);
                createIconView.setMinimumHeight(dimensionPixelSize);
            }
            if (typedArray.hasValue(31)) {
                ImageView.ScaleType convertScaleType = LazyKt__LazyJVMKt.convertScaleType(typedArray.getInt(31, -1));
                this.endIconScaleType = convertScaleType;
                createIconView2.setScaleType(convertScaleType);
                createIconView.setScaleType(convertScaleType);
            }
            appCompatTextView.setVisibility(8);
            appCompatTextView.setId(R.id.textinput_suffix_text);
            appCompatTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
            appCompatTextView.setAccessibilityLiveRegion(1);
            TextViewCompat.setTextAppearance(appCompatTextView, typedArray.getResourceId(73, 0));
            if (typedArray.hasValue(74)) {
                appCompatTextView.setTextColor(matcherMatchResult.getColorStateList(74));
            }
            CharSequence text3 = typedArray.getText(72);
            this.suffixText = !TextUtils.isEmpty(text3) ? text3 : charSequence;
            appCompatTextView.setText(text3);
            updateSuffixTextVisibility();
            frameLayout.addView(createIconView2);
            addView(appCompatTextView);
            addView(frameLayout);
            addView(createIconView);
            textInputLayout.editTextAttachedListeners.add(r4);
            if (textInputLayout.editText != null) {
                r4.onEditTextAttached(textInputLayout);
            }
            addOnAttachStateChangeListener(new StandardMenuPopup.AnonymousClass2(4, this));
            return;
        }
        throw new IllegalArgumentException("endIconSize cannot be less than 0");
    }

    public final CheckableImageButton createIconView(ViewGroup viewGroup, LayoutInflater layoutInflater, int i) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i);
        if (Build.VERSION.SDK_INT < 23) {
            checkableImageButton.setBackground(RippleUtils.RippleUtilsLollipop.access$000(checkableImageButton.getContext(), (int) ViewUtils.dpToPx(checkableImageButton.getContext(), 4)));
        }
        if (LazyKt__LazyJVMKt.isFontScaleAtLeast1_3(getContext())) {
            ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).setMarginStart(0);
        }
        return checkableImageButton;
    }

    public final EndIconDelegate getEndIconDelegate() {
        EndIconDelegate endIconDelegate;
        int i = this.endIconMode;
        EndIconDelegates endIconDelegates = this.endIconDelegates;
        SparseArray sparseArray = endIconDelegates.delegates;
        EndIconDelegate endIconDelegate2 = (EndIconDelegate) sparseArray.get(i);
        if (endIconDelegate2 != null) {
            return endIconDelegate2;
        }
        EndCompoundLayout endCompoundLayout = endIconDelegates.endLayout;
        if (i == -1) {
            endIconDelegate = new NoEndIconDelegate(endCompoundLayout, 1);
        } else if (i == 0) {
            endIconDelegate = new NoEndIconDelegate(endCompoundLayout, 0);
        } else if (i == 1) {
            endIconDelegate = new PasswordToggleEndIconDelegate(endCompoundLayout, endIconDelegates.passwordIconDrawableId);
        } else if (i == 2) {
            endIconDelegate = new ClearTextEndIconDelegate(endCompoundLayout);
        } else if (i == 3) {
            endIconDelegate = new DropdownMenuEndIconDelegate(endCompoundLayout);
        } else {
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(i, "Invalid end icon mode: "));
        }
        sparseArray.append(i, endIconDelegate);
        return endIconDelegate;
    }

    public final int getSuffixTextEndOffset() {
        int i;
        if (isEndIconVisible() || isErrorIconVisible()) {
            CheckableImageButton checkableImageButton = this.endIconView;
            i = ((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()).getMarginStart() + checkableImageButton.getMeasuredWidth();
        } else {
            i = 0;
        }
        return this.suffixTextView.getPaddingEnd() + getPaddingEnd() + i;
    }

    public final boolean isEndIconVisible() {
        if (this.endIconFrame.getVisibility() == 0 && this.endIconView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final boolean isErrorIconVisible() {
        if (this.errorIconView.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void refreshIconState(boolean z) {
        boolean z2;
        boolean isActivated;
        boolean z3;
        EndIconDelegate endIconDelegate = getEndIconDelegate();
        boolean isIconCheckable = endIconDelegate.isIconCheckable();
        CheckableImageButton checkableImageButton = this.endIconView;
        boolean z4 = true;
        if (!isIconCheckable || (z3 = checkableImageButton.checked) == endIconDelegate.isIconChecked()) {
            z2 = false;
        } else {
            checkableImageButton.setChecked(!z3);
            z2 = true;
        }
        if (!(endIconDelegate instanceof DropdownMenuEndIconDelegate) || (isActivated = checkableImageButton.isActivated()) == ((DropdownMenuEndIconDelegate) endIconDelegate).editTextHasFocus) {
            z4 = z2;
        } else {
            checkableImageButton.setActivated(!isActivated);
        }
        if (z || z4) {
            LazyKt__LazyJVMKt.refreshIconDrawableState(this.textInputLayout, checkableImageButton, this.endIconTintList);
        }
    }

    public final void setEndIconMode(int i) {
        boolean z;
        Drawable drawable;
        if (this.endIconMode != i) {
            EndIconDelegate endIconDelegate = getEndIconDelegate();
            AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = this.touchExplorationStateChangeListener;
            AccessibilityManager accessibilityManager = this.accessibilityManager;
            if (!(touchExplorationStateChangeListener == null || accessibilityManager == null)) {
                accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
            }
            CharSequence charSequence = null;
            this.touchExplorationStateChangeListener = null;
            endIconDelegate.tearDown();
            this.endIconMode = i;
            Iterator it = this.endIconChangedListeners.iterator();
            if (!it.hasNext()) {
                if (i != 0) {
                    z = true;
                } else {
                    z = false;
                }
                setEndIconVisible(z);
                EndIconDelegate endIconDelegate2 = getEndIconDelegate();
                int i2 = this.endIconDelegates.customEndIconDrawableId;
                if (i2 == 0) {
                    i2 = endIconDelegate2.getIconDrawableResId();
                }
                if (i2 != 0) {
                    drawable = BundleKt.getDrawable(getContext(), i2);
                } else {
                    drawable = null;
                }
                CheckableImageButton checkableImageButton = this.endIconView;
                checkableImageButton.setImageDrawable(drawable);
                TextInputLayout textInputLayout = this.textInputLayout;
                if (drawable != null) {
                    LazyKt__LazyJVMKt.applyIconTint(textInputLayout, checkableImageButton, this.endIconTintList, this.endIconTintMode);
                    LazyKt__LazyJVMKt.refreshIconDrawableState(textInputLayout, checkableImageButton, this.endIconTintList);
                }
                int iconContentDescriptionResId = endIconDelegate2.getIconContentDescriptionResId();
                if (iconContentDescriptionResId != 0) {
                    charSequence = getResources().getText(iconContentDescriptionResId);
                }
                if (checkableImageButton.getContentDescription() != charSequence) {
                    checkableImageButton.setContentDescription(charSequence);
                }
                checkableImageButton.setCheckable(endIconDelegate2.isIconCheckable());
                if (endIconDelegate2.isBoxBackgroundModeSupported(textInputLayout.getBoxBackgroundMode())) {
                    endIconDelegate2.setUp();
                    AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener2 = endIconDelegate2.getTouchExplorationStateChangeListener();
                    this.touchExplorationStateChangeListener = touchExplorationStateChangeListener2;
                    if (!(touchExplorationStateChangeListener2 == null || accessibilityManager == null || !isAttachedToWindow())) {
                        accessibilityManager.addTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
                    }
                    View.OnClickListener onIconClickListener = endIconDelegate2.getOnIconClickListener();
                    View.OnLongClickListener onLongClickListener = this.endIconOnLongClickListener;
                    checkableImageButton.setOnClickListener(onIconClickListener);
                    LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, onLongClickListener);
                    EditText editText = this.editText;
                    if (editText != null) {
                        endIconDelegate2.onEditTextAttached(editText);
                        setOnFocusChangeListenersIfNeeded(endIconDelegate2);
                    }
                    LazyKt__LazyJVMKt.applyIconTint(textInputLayout, checkableImageButton, this.endIconTintList, this.endIconTintMode);
                    refreshIconState(true);
                    return;
                }
                throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i);
            }
            throw ViewModelProvider.Factory.CC.m(it);
        }
    }

    public final void setEndIconVisible(boolean z) {
        int i;
        if (isEndIconVisible() != z) {
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            this.endIconView.setVisibility(i);
            updateEndLayoutVisibility();
            updateSuffixTextViewPadding();
            this.textInputLayout.updateDummyDrawables();
        }
    }

    public final void setErrorIconDrawable(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.errorIconView;
        checkableImageButton.setImageDrawable(drawable);
        updateErrorIconVisibility();
        LazyKt__LazyJVMKt.applyIconTint(this.textInputLayout, checkableImageButton, this.errorIconTintList, this.errorIconTintMode);
    }

    public final void setOnFocusChangeListenersIfNeeded(EndIconDelegate endIconDelegate) {
        if (this.editText != null) {
            if (endIconDelegate.getOnEditTextFocusChangeListener() != null) {
                this.editText.setOnFocusChangeListener(endIconDelegate.getOnEditTextFocusChangeListener());
            }
            if (endIconDelegate.getOnIconViewFocusChangeListener() != null) {
                this.endIconView.setOnFocusChangeListener(endIconDelegate.getOnIconViewFocusChangeListener());
            }
        }
    }

    public final void updateEndLayoutVisibility() {
        int i;
        char c;
        int i2 = 8;
        if (this.endIconView.getVisibility() != 0 || isErrorIconVisible()) {
            i = 8;
        } else {
            i = 0;
        }
        this.endIconFrame.setVisibility(i);
        if (this.suffixText == null || this.hintExpanded) {
            c = '\b';
        } else {
            c = 0;
        }
        if (isEndIconVisible() || isErrorIconVisible() || c == 0) {
            i2 = 0;
        }
        setVisibility(i2);
    }

    public final void updateErrorIconVisibility() {
        int i;
        CheckableImageButton checkableImageButton = this.errorIconView;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.textInputLayout;
        if (drawable == null || !textInputLayout.indicatorViewController.errorEnabled || !textInputLayout.shouldShowError()) {
            i = 8;
        } else {
            i = 0;
        }
        checkableImageButton.setVisibility(i);
        updateEndLayoutVisibility();
        updateSuffixTextViewPadding();
        if (this.endIconMode == 0) {
            textInputLayout.updateDummyDrawables();
        }
    }

    public final void updateSuffixTextViewPadding() {
        int i;
        TextInputLayout textInputLayout = this.textInputLayout;
        if (textInputLayout.editText != null) {
            if (isEndIconVisible() || isErrorIconVisible()) {
                i = 0;
            } else {
                i = textInputLayout.editText.getPaddingEnd();
            }
            this.suffixTextView.setPaddingRelative(getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), textInputLayout.editText.getPaddingTop(), i, textInputLayout.editText.getPaddingBottom());
        }
    }

    public final void updateSuffixTextVisibility() {
        int i;
        AppCompatTextView appCompatTextView = this.suffixTextView;
        int visibility = appCompatTextView.getVisibility();
        boolean z = false;
        if (this.suffixText == null || this.hintExpanded) {
            i = 8;
        } else {
            i = 0;
        }
        if (visibility != i) {
            EndIconDelegate endIconDelegate = getEndIconDelegate();
            if (i == 0) {
                z = true;
            }
            endIconDelegate.onSuffixVisibilityChanged(z);
        }
        updateEndLayoutVisibility();
        appCompatTextView.setVisibility(i);
        this.textInputLayout.updateDummyDrawables();
    }
}
