package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.graphics.ColorUtils;
import androidx.core.os.BundleKt;
import androidx.core.text.BidiFormatter;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.android.billingclient.api.zzab;
import com.android.billingclient.api.zzcn;
import com.emanuelef.remote_capture.R;
import com.google.android.datatransport.runtime.TransportImpl$$ExternalSyntheticLambda0;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.CutoutDrawable;
import com.google.android.material.textfield.EndCompoundLayout;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.text.MatcherMatchResult;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
/* loaded from: classes.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final int[][] EDIT_TEXT_BACKGROUND_RIPPLE_STATE = {new int[]{16842919}, new int[0]};
    public ValueAnimator animator;
    public boolean areCornerRadiiRtl;
    public MaterialShapeDrawable boxBackground;
    public boolean boxBackgroundApplied;
    public int boxBackgroundColor;
    public int boxBackgroundMode;
    public int boxCollapsedPaddingTopPx;
    public final int boxLabelCutoutPaddingPx;
    public int boxStrokeColor;
    public int boxStrokeWidthDefaultPx;
    public int boxStrokeWidthFocusedPx;
    public int boxStrokeWidthPx;
    public MaterialShapeDrawable boxUnderlineDefault;
    public MaterialShapeDrawable boxUnderlineFocused;
    public final CollapsingTextHelper collapsingTextHelper;
    public boolean counterEnabled;
    public int counterMaxLength;
    public int counterOverflowTextAppearance;
    public ColorStateList counterOverflowTextColor;
    public boolean counterOverflowed;
    public int counterTextAppearance;
    public ColorStateList counterTextColor;
    public AppCompatTextView counterView;
    public ColorStateList cursorColor;
    public ColorStateList cursorErrorColor;
    public int defaultFilledBackgroundColor;
    public ColorStateList defaultHintTextColor;
    public int defaultStrokeColor;
    public int disabledColor;
    public int disabledFilledBackgroundColor;
    public EditText editText;
    public ColorDrawable endDummyDrawable;
    public int endDummyDrawableWidth;
    public final EndCompoundLayout endLayout;
    public boolean expandedHintEnabled;
    public final int extraSpaceBetweenPlaceholderAndHint;
    public StateListDrawable filledDropDownMenuBackground;
    public int focusedFilledBackgroundColor;
    public int focusedStrokeColor;
    public ColorStateList focusedTextColor;
    public CharSequence hint;
    public boolean hintAnimationEnabled;
    public boolean hintEnabled;
    public boolean hintExpanded;
    public int hoveredFilledBackgroundColor;
    public int hoveredStrokeColor;
    public boolean inDrawableStateChanged;
    public final FrameLayout inputFrame;
    public boolean isProvidingHint;
    public Drawable originalEditTextEndDrawable;
    public int originalEditTextMinimumHeight;
    public CharSequence originalHint;
    public MaterialShapeDrawable outlinedDropDownMenuBackground;
    public boolean placeholderEnabled;
    public Fade placeholderFadeIn;
    public Fade placeholderFadeOut;
    public CharSequence placeholderText;
    public int placeholderTextAppearance;
    public ColorStateList placeholderTextColor;
    public AppCompatTextView placeholderTextView;
    public boolean restoringSavedState;
    public ShapeAppearanceModel shapeAppearanceModel;
    public ColorDrawable startDummyDrawable;
    public int startDummyDrawableWidth;
    public final StartCompoundLayout startLayout;
    public ColorStateList strokeErrorColor;
    public Typeface typeface;
    public int minEms = -1;
    public int maxEms = -1;
    public int minWidth = -1;
    public int maxWidth = -1;
    public final IndicatorViewController indicatorViewController = new IndicatorViewController(this);
    public LengthCounter lengthCounter = new TransportImpl$$ExternalSyntheticLambda0(27);
    public final Rect tmpRect = new Rect();
    public final Rect tmpBoundsRect = new Rect();
    public final RectF tmpRectF = new RectF();
    public final LinkedHashSet editTextAttachedListeners = new LinkedHashSet();
    public boolean globalLayoutListenerAdded = false;

    /* renamed from: com.google.android.material.textfield.TextInputLayout$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 extends AccessibilityDelegateCompat {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass2(int i) {
            this.$r8$classId = i;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            boolean z;
            switch (this.$r8$classId) {
                case 1:
                    super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                    accessibilityEvent.setClassName(ScrollView.class.getName());
                    if (nestedScrollView.getScrollRange() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    accessibilityEvent.setScrollable(z);
                    accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
                    accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
                    accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
                    accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
                    return;
                default:
                    super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                    return;
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            switch (this.$r8$classId) {
                case 0:
                    AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    accessibilityNodeInfo.setVisibleToUser(false);
                    return;
                case 1:
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                    accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
                    if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                        accessibilityNodeInfoCompat.setScrollable(true);
                        if (nestedScrollView.getScrollY() > 0) {
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                        }
                        if (nestedScrollView.getScrollY() < scrollRange) {
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfoCompat.mInfo;
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                    if (!DrawerLayout.includeChildForAccessibility(view)) {
                        accessibilityNodeInfo2.setParent(null);
                        return;
                    }
                    return;
                case 3:
                    AccessibilityNodeInfo accessibilityNodeInfo3 = accessibilityNodeInfoCompat.mInfo;
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo3);
                    accessibilityNodeInfo3.setCollectionInfo(null);
                    return;
                case 4:
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    accessibilityNodeInfoCompat.setScrollable(false);
                    return;
                default:
                    AccessibilityNodeInfo accessibilityNodeInfo4 = accessibilityNodeInfoCompat.mInfo;
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo4);
                    accessibilityNodeInfo4.setCollectionInfo(null);
                    return;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
            if (r6 != 16908346) goto L29;
         */
        @Override // androidx.core.view.AccessibilityDelegateCompat
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean performAccessibilityAction(android.view.View r5, int r6, android.os.Bundle r7) {
            /*
                r4 = this;
                int r0 = r4.$r8$classId
                switch(r0) {
                    case 1: goto La;
                    default: goto L5;
                }
            L5:
                boolean r5 = super.performAccessibilityAction(r5, r6, r7)
                return r5
            La:
                boolean r7 = super.performAccessibilityAction(r5, r6, r7)
                r0 = 1
                if (r7 == 0) goto L13
                goto La1
            L13:
                androidx.core.widget.NestedScrollView r5 = (androidx.core.widget.NestedScrollView) r5
                boolean r7 = r5.isEnabled()
                r1 = 0
                if (r7 != 0) goto L1e
                goto La0
            L1e:
                int r7 = r5.getHeight()
                android.graphics.Rect r2 = new android.graphics.Rect
                r2.<init>()
                android.graphics.Matrix r3 = r5.getMatrix()
                boolean r3 = r3.isIdentity()
                if (r3 == 0) goto L3b
                boolean r3 = r5.getGlobalVisibleRect(r2)
                if (r3 == 0) goto L3b
                int r7 = r2.height()
            L3b:
                r2 = 4096(0x1000, float:5.74E-42)
                if (r6 == r2) goto L75
                r2 = 8192(0x2000, float:1.14794E-41)
                if (r6 == r2) goto L4e
                r2 = 16908344(0x1020038, float:2.3877386E-38)
                if (r6 == r2) goto L4e
                r2 = 16908346(0x102003a, float:2.3877392E-38)
                if (r6 == r2) goto L75
                goto La0
            L4e:
                int r6 = r5.getPaddingBottom()
                int r7 = r7 - r6
                int r6 = r5.getPaddingTop()
                int r7 = r7 - r6
                int r6 = r5.getScrollY()
                int r6 = r6 - r7
                int r6 = java.lang.Math.max(r6, r1)
                int r7 = r5.getScrollY()
                if (r6 == r7) goto La0
                int r7 = r5.getScrollX()
                int r1 = r1 - r7
                int r7 = r5.getScrollY()
                int r6 = r6 - r7
                r5.smoothScrollBy(r1, r6, r0)
                goto La1
            L75:
                int r6 = r5.getPaddingBottom()
                int r7 = r7 - r6
                int r6 = r5.getPaddingTop()
                int r7 = r7 - r6
                int r6 = r5.getScrollY()
                int r6 = r6 + r7
                int r7 = r5.getScrollRange()
                int r6 = java.lang.Math.min(r6, r7)
                int r7 = r5.getScrollY()
                if (r6 == r7) goto La0
                int r7 = r5.getScrollX()
                int r1 = r1 - r7
                int r7 = r5.getScrollY()
                int r6 = r6 - r7
                r5.smoothScrollBy(r1, r6, r0)
                goto La1
            La0:
                r0 = 0
            La1:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.AnonymousClass2.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
        }
    }

    /* loaded from: classes.dex */
    public final class AccessibilityDelegate extends AccessibilityDelegateCompat {
        public final TextInputLayout layout;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.layout = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            CharSequence charSequence;
            boolean z;
            String str;
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            TextInputLayout textInputLayout = this.layout;
            EditText editText = textInputLayout.getEditText();
            if (editText != null) {
                charSequence = editText.getText();
            } else {
                charSequence = null;
            }
            CharSequence hint = textInputLayout.getHint();
            CharSequence error = textInputLayout.getError();
            CharSequence placeholderText = textInputLayout.getPlaceholderText();
            int counterMaxLength = textInputLayout.getCounterMaxLength();
            CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            boolean isEmpty2 = TextUtils.isEmpty(hint);
            boolean z2 = textInputLayout.hintExpanded;
            boolean isEmpty3 = TextUtils.isEmpty(error);
            if (!isEmpty3 || !TextUtils.isEmpty(counterOverflowDescription)) {
                z = true;
            } else {
                z = false;
            }
            if (!isEmpty2) {
                str = hint.toString();
            } else {
                str = "";
            }
            StartCompoundLayout startCompoundLayout = textInputLayout.startLayout;
            View view2 = startCompoundLayout.prefixTextView;
            if (view2.getVisibility() == 0) {
                accessibilityNodeInfo.setLabelFor(view2);
                accessibilityNodeInfoCompat.setTraversalAfter(view2);
            } else {
                accessibilityNodeInfoCompat.setTraversalAfter(startCompoundLayout.startIconView);
            }
            if (!isEmpty) {
                accessibilityNodeInfoCompat.setText(charSequence);
            } else if (!TextUtils.isEmpty(str)) {
                accessibilityNodeInfoCompat.setText(str);
                if (!z2 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(str + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(str);
                } else {
                    if (!isEmpty) {
                        str = ((Object) charSequence) + ", " + str;
                    }
                    accessibilityNodeInfoCompat.setText(str);
                }
                accessibilityNodeInfoCompat.setShowingHintText(isEmpty);
            }
            if (charSequence == null || charSequence.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
            if (z) {
                if (isEmpty3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfo.setError(error);
            }
            AppCompatTextView appCompatTextView = textInputLayout.indicatorViewController.helperTextView;
            if (appCompatTextView != null) {
                accessibilityNodeInfo.setLabelFor(appCompatTextView);
            }
            textInputLayout.endLayout.getEndIconDelegate().onInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            this.layout.endLayout.getEndIconDelegate().onPopulateAccessibilityEvent(accessibilityEvent);
        }
    }

    /* loaded from: classes.dex */
    public interface LengthCounter {
    }

    /* loaded from: classes.dex */
    public final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.AnonymousClass2(16);
        public CharSequence error;
        public boolean isEndIconChecked;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isEndIconChecked = parcel.readInt() != 1 ? false : true;
        }

        public final String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.error) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isEndIconChecked ? 1 : 0);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.textInputStyle, R.style.Widget_Design_TextInputLayout), attributeSet, R.attr.textInputStyle);
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.collapsingTextHelper = collapsingTextHelper;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.inputFrame = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        collapsingTextHelper.textSizeInterpolator = linearInterpolator;
        collapsingTextHelper.recalculate(false);
        collapsingTextHelper.positionInterpolator = linearInterpolator;
        collapsingTextHelper.recalculate(false);
        if (collapsingTextHelper.collapsedTextGravity != 8388659) {
            collapsingTextHelper.collapsedTextGravity = 8388659;
            collapsingTextHelper.recalculate(false);
        }
        ViewUtils.checkCompatibleTheme(context2, attributeSet, R.attr.textInputStyle, R.style.Widget_Design_TextInputLayout);
        int[] iArr = R$styleable.TextInputLayout;
        ViewUtils.checkTextAppearance(context2, attributeSet, iArr, R.attr.textInputStyle, R.style.Widget_Design_TextInputLayout, 22, 20, 40, 45, 50);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, R.attr.textInputStyle, R.style.Widget_Design_TextInputLayout);
        MatcherMatchResult matcherMatchResult = new MatcherMatchResult(context2, obtainStyledAttributes);
        StartCompoundLayout startCompoundLayout = new StartCompoundLayout(this, matcherMatchResult);
        this.startLayout = startCompoundLayout;
        this.hintEnabled = obtainStyledAttributes.getBoolean(48, true);
        setHint(obtainStyledAttributes.getText(4));
        this.hintAnimationEnabled = obtainStyledAttributes.getBoolean(47, true);
        this.expandedHintEnabled = obtainStyledAttributes.getBoolean(42, true);
        if (obtainStyledAttributes.hasValue(6)) {
            setMinEms(obtainStyledAttributes.getInt(6, -1));
        } else if (obtainStyledAttributes.hasValue(3)) {
            setMinWidth(obtainStyledAttributes.getDimensionPixelSize(3, -1));
        }
        if (obtainStyledAttributes.hasValue(5)) {
            setMaxEms(obtainStyledAttributes.getInt(5, -1));
        } else if (obtainStyledAttributes.hasValue(2)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        }
        this.shapeAppearanceModel = ShapeAppearanceModel.builder(context2, attributeSet, (int) R.attr.textInputStyle, (int) R.style.Widget_Design_TextInputLayout).build();
        this.boxLabelCutoutPaddingPx = context2.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = obtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.extraSpaceBetweenPlaceholderAndHint = getResources().getDimensionPixelSize(R.dimen.m3_multiline_hint_filled_text_extra_space);
        this.boxStrokeWidthDefaultPx = obtainStyledAttributes.getDimensionPixelSize(16, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default));
        this.boxStrokeWidthFocusedPx = obtainStyledAttributes.getDimensionPixelSize(17, context2.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused));
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        float dimension = obtainStyledAttributes.getDimension(13, -1.0f);
        float dimension2 = obtainStyledAttributes.getDimension(12, -1.0f);
        float dimension3 = obtainStyledAttributes.getDimension(10, -1.0f);
        float dimension4 = obtainStyledAttributes.getDimension(11, -1.0f);
        ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
        if (dimension >= 0.0f) {
            builder.topLeftCornerSize = new AbsoluteCornerSize(dimension);
        }
        if (dimension2 >= 0.0f) {
            builder.topRightCornerSize = new AbsoluteCornerSize(dimension2);
        }
        if (dimension3 >= 0.0f) {
            builder.bottomRightCornerSize = new AbsoluteCornerSize(dimension3);
        }
        if (dimension4 >= 0.0f) {
            builder.bottomLeftCornerSize = new AbsoluteCornerSize(dimension4);
        }
        this.shapeAppearanceModel = builder.build();
        ColorStateList colorStateList = LazyKt__LazyJVMKt.getColorStateList(context2, matcherMatchResult, 7);
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            this.defaultFilledBackgroundColor = defaultColor;
            this.boxBackgroundColor = defaultColor;
            if (colorStateList.isStateful()) {
                this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
                this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            } else {
                this.focusedFilledBackgroundColor = this.defaultFilledBackgroundColor;
                ColorStateList colorStateList2 = BundleKt.getColorStateList(context2, R.color.mtrl_filled_background_color);
                this.disabledFilledBackgroundColor = colorStateList2.getColorForState(new int[]{-16842910}, -1);
                this.hoveredFilledBackgroundColor = colorStateList2.getColorForState(new int[]{16843623}, -1);
            }
        } else {
            this.boxBackgroundColor = 0;
            this.defaultFilledBackgroundColor = 0;
            this.disabledFilledBackgroundColor = 0;
            this.focusedFilledBackgroundColor = 0;
            this.hoveredFilledBackgroundColor = 0;
        }
        if (obtainStyledAttributes.hasValue(1)) {
            ColorStateList colorStateList3 = matcherMatchResult.getColorStateList(1);
            this.focusedTextColor = colorStateList3;
            this.defaultHintTextColor = colorStateList3;
        }
        ColorStateList colorStateList4 = LazyKt__LazyJVMKt.getColorStateList(context2, matcherMatchResult, 14);
        this.focusedStrokeColor = obtainStyledAttributes.getColor(14, 0);
        this.defaultStrokeColor = BundleKt.getColor(context2, R.color.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = BundleKt.getColor(context2, R.color.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = BundleKt.getColor(context2, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (colorStateList4 != null) {
            setBoxStrokeColorStateList(colorStateList4);
        }
        if (obtainStyledAttributes.hasValue(15)) {
            setBoxStrokeErrorColor(LazyKt__LazyJVMKt.getColorStateList(context2, matcherMatchResult, 15));
        }
        if (obtainStyledAttributes.getResourceId(50, -1) != -1) {
            setHintTextAppearance(obtainStyledAttributes.getResourceId(50, 0));
        }
        this.cursorColor = matcherMatchResult.getColorStateList(24);
        this.cursorErrorColor = matcherMatchResult.getColorStateList(25);
        int resourceId = obtainStyledAttributes.getResourceId(40, 0);
        CharSequence text = obtainStyledAttributes.getText(35);
        int i = obtainStyledAttributes.getInt(34, 1);
        boolean z = obtainStyledAttributes.getBoolean(36, false);
        int resourceId2 = obtainStyledAttributes.getResourceId(45, 0);
        boolean z2 = obtainStyledAttributes.getBoolean(44, false);
        CharSequence text2 = obtainStyledAttributes.getText(43);
        int resourceId3 = obtainStyledAttributes.getResourceId(58, 0);
        CharSequence text3 = obtainStyledAttributes.getText(57);
        boolean z3 = obtainStyledAttributes.getBoolean(18, false);
        setCounterMaxLength(obtainStyledAttributes.getInt(19, -1));
        this.counterTextAppearance = obtainStyledAttributes.getResourceId(22, 0);
        this.counterOverflowTextAppearance = obtainStyledAttributes.getResourceId(20, 0);
        setBoxBackgroundMode(obtainStyledAttributes.getInt(8, 0));
        setErrorContentDescription(text);
        setErrorAccessibilityLiveRegion(i);
        setCounterOverflowTextAppearance(this.counterOverflowTextAppearance);
        setHelperTextTextAppearance(resourceId2);
        setErrorTextAppearance(resourceId);
        setCounterTextAppearance(this.counterTextAppearance);
        setPlaceholderText(text3);
        setPlaceholderTextAppearance(resourceId3);
        if (obtainStyledAttributes.hasValue(41)) {
            setErrorTextColor(matcherMatchResult.getColorStateList(41));
        }
        if (obtainStyledAttributes.hasValue(46)) {
            setHelperTextColor(matcherMatchResult.getColorStateList(46));
        }
        if (obtainStyledAttributes.hasValue(51)) {
            setHintTextColor(matcherMatchResult.getColorStateList(51));
        }
        if (obtainStyledAttributes.hasValue(23)) {
            setCounterTextColor(matcherMatchResult.getColorStateList(23));
        }
        if (obtainStyledAttributes.hasValue(21)) {
            setCounterOverflowTextColor(matcherMatchResult.getColorStateList(21));
        }
        if (obtainStyledAttributes.hasValue(59)) {
            setPlaceholderTextColor(matcherMatchResult.getColorStateList(59));
        }
        EndCompoundLayout endCompoundLayout = new EndCompoundLayout(this, matcherMatchResult);
        this.endLayout = endCompoundLayout;
        boolean z4 = obtainStyledAttributes.getBoolean(0, true);
        setHintMaxLines(obtainStyledAttributes.getInt(49, 1));
        matcherMatchResult.recycle();
        setImportantForAccessibility(2);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
        frameLayout.addView(startCompoundLayout);
        frameLayout.addView(endCompoundLayout);
        addView(frameLayout);
        setEnabled(z4);
        setHelperTextEnabled(z2);
        setErrorEnabled(z);
        setCounterEnabled(z3);
        setHelperText(text2);
    }

    private Drawable getEditTextBoxBackground() {
        int i;
        EditText editText = this.editText;
        if (!(editText instanceof AutoCompleteTextView) || editText.getInputType() != 0) {
            return this.boxBackground;
        }
        int color = LazyKt__LazyJVMKt.getColor(R.attr.colorControlHighlight, this.editText);
        int i2 = this.boxBackgroundMode;
        int[][] iArr = EDIT_TEXT_BACKGROUND_RIPPLE_STATE;
        if (i2 == 2) {
            Context context = getContext();
            MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
            TypedValue resolveTypedValueOrThrow = LazyKt__LazyJVMKt.resolveTypedValueOrThrow(R.attr.colorSurface, context, "TextInputLayout");
            int i3 = resolveTypedValueOrThrow.resourceId;
            if (i3 != 0) {
                i = BundleKt.getColor(context, i3);
            } else {
                i = resolveTypedValueOrThrow.data;
            }
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.drawableState.shapeAppearanceModel);
            int layer = LazyKt__LazyJVMKt.layer(color, 0.1f, i);
            materialShapeDrawable2.setFillColor(new ColorStateList(iArr, new int[]{layer, 0}));
            materialShapeDrawable2.setTint(i);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{layer, i});
            MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.drawableState.shapeAppearanceModel);
            materialShapeDrawable3.setTint(-1);
            return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
        } else if (i2 != 1) {
            return null;
        } else {
            MaterialShapeDrawable materialShapeDrawable4 = this.boxBackground;
            int i4 = this.boxBackgroundColor;
            return new RippleDrawable(new ColorStateList(iArr, new int[]{LazyKt__LazyJVMKt.layer(color, 0.1f, i4), i4}), materialShapeDrawable4, materialShapeDrawable4);
        }
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.filledDropDownMenuBackground == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.filledDropDownMenuBackground = stateListDrawable;
            stateListDrawable.addState(new int[]{16842922}, getOrCreateOutlinedDropDownMenuBackground());
            this.filledDropDownMenuBackground.addState(new int[0], getDropDownMaterialShapeDrawable(false));
        }
        return this.filledDropDownMenuBackground;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.outlinedDropDownMenuBackground == null) {
            this.outlinedDropDownMenuBackground = getDropDownMaterialShapeDrawable(true);
        }
        return this.outlinedDropDownMenuBackground;
    }

    public static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    private void setEditText(EditText editText) {
        if (this.editText == null) {
            if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.editText = editText;
            int i = this.minEms;
            if (i != -1) {
                setMinEms(i);
            } else {
                setMinWidth(this.minWidth);
            }
            int i2 = this.maxEms;
            if (i2 != -1) {
                setMaxEms(i2);
            } else {
                setMaxWidth(this.maxWidth);
            }
            this.boxBackgroundApplied = false;
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            Typeface typeface = this.editText.getTypeface();
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            collapsingTextHelper.setTypefaces(typeface);
            float textSize = this.editText.getTextSize();
            if (collapsingTextHelper.expandedTextSize != textSize) {
                collapsingTextHelper.expandedTextSize = textSize;
                collapsingTextHelper.recalculate(false);
            }
            float letterSpacing = this.editText.getLetterSpacing();
            if (collapsingTextHelper.expandedLetterSpacing != letterSpacing) {
                collapsingTextHelper.expandedLetterSpacing = letterSpacing;
                collapsingTextHelper.recalculate(false);
            }
            int gravity = this.editText.getGravity();
            int i3 = (gravity & (-113)) | 48;
            if (collapsingTextHelper.collapsedTextGravity != i3) {
                collapsingTextHelper.collapsedTextGravity = i3;
                collapsingTextHelper.recalculate(false);
            }
            if (collapsingTextHelper.expandedTextGravity != gravity) {
                collapsingTextHelper.expandedTextGravity = gravity;
                collapsingTextHelper.recalculate(false);
            }
            this.originalEditTextMinimumHeight = editText.getMinimumHeight();
            this.editText.addTextChangedListener(new TextWatcher(editText) { // from class: com.google.android.material.textfield.TextInputLayout.1
                public int previousLineCount;
                public final /* synthetic */ EditText val$editText;

                {
                    this.val$editText = editText;
                    this.previousLineCount = editText.getLineCount();
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.updateLabelState(!textInputLayout.restoringSavedState, false);
                    if (textInputLayout.counterEnabled) {
                        textInputLayout.updateCounter(editable);
                    }
                    if (textInputLayout.placeholderEnabled) {
                        textInputLayout.updatePlaceholderText(editable);
                    }
                    EditText editText2 = this.val$editText;
                    int lineCount = editText2.getLineCount();
                    int i4 = this.previousLineCount;
                    if (lineCount != i4) {
                        if (lineCount < i4) {
                            int minimumHeight = editText2.getMinimumHeight();
                            int i5 = textInputLayout.originalEditTextMinimumHeight;
                            if (minimumHeight != i5) {
                                editText2.setMinimumHeight(i5);
                            }
                        }
                        this.previousLineCount = lineCount;
                    }
                }

                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
                }
            });
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    CharSequence hint = this.editText.getHint();
                    this.originalHint = hint;
                    setHint(hint);
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                updateCursorColor();
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText());
            }
            updateEditTextBackground();
            this.indicatorViewController.adjustIndicatorPadding();
            this.startLayout.bringToFront();
            EndCompoundLayout endCompoundLayout = this.endLayout;
            endCompoundLayout.bringToFront();
            Iterator it = this.editTextAttachedListeners.iterator();
            while (it.hasNext()) {
                ((EndCompoundLayout.AnonymousClass2) it.next()).onEditTextAttached(this);
            }
            endCompoundLayout.updateSuffixTextViewPadding();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            if (charSequence == null || !TextUtils.equals(collapsingTextHelper.text, charSequence)) {
                collapsingTextHelper.text = charSequence;
                collapsingTextHelper.textToDraw = null;
                collapsingTextHelper.recalculate(false);
            }
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.placeholderEnabled != z) {
            if (z) {
                AppCompatTextView appCompatTextView = this.placeholderTextView;
                if (appCompatTextView != null) {
                    this.inputFrame.addView(appCompatTextView);
                    this.placeholderTextView.setVisibility(0);
                }
            } else {
                AppCompatTextView appCompatTextView2 = this.placeholderTextView;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setVisibility(8);
                }
                this.placeholderTextView = null;
            }
            this.placeholderEnabled = z;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            FrameLayout frameLayout = this.inputFrame;
            frameLayout.addView(view, layoutParams2);
            frameLayout.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public final void adjustFilledEditTextPaddingForLargeFont() {
        if (this.editText != null && this.boxBackgroundMode == 1) {
            if (getHintMaxLines() != 1) {
                EditText editText = this.editText;
                editText.setPaddingRelative(editText.getPaddingStart(), (int) (this.collapsingTextHelper.getCollapsedTextHeight() + this.extraSpaceBetweenPlaceholderAndHint), this.editText.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            } else if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                EditText editText2 = this.editText;
                editText2.setPaddingRelative(editText2.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), this.editText.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (LazyKt__LazyJVMKt.isFontScaleAtLeast1_3(getContext())) {
                EditText editText3 = this.editText;
                editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), this.editText.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
    }

    public final void animateToExpansionFraction(float f) {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper.expandedFraction != f) {
            if (this.animator == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.animator = valueAnimator;
                valueAnimator.setInterpolator(LazyKt__LazyJVMKt.resolveThemeInterpolator(getContext(), R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
                this.animator.setDuration(LazyKt__LazyJVMKt.resolveThemeDuration(getContext(), R.attr.motionDurationMedium4, 167));
                this.animator.addUpdateListener(new TabLayout.AnonymousClass1(2, this));
            }
            this.animator.setFloatValues(collapsingTextHelper.expandedFraction, f);
            this.animator.start();
        }
    }

    public final void applyBoxAttributes() {
        ColorStateList colorStateList;
        int i;
        int i2;
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null) {
            ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawable.drawableState.shapeAppearanceModel;
            ShapeAppearanceModel shapeAppearanceModel2 = this.shapeAppearanceModel;
            if (shapeAppearanceModel != shapeAppearanceModel2) {
                materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel2);
            }
            if (this.boxBackgroundMode == 2 && (i = this.boxStrokeWidthPx) > -1 && (i2 = this.boxStrokeColor) != 0) {
                MaterialShapeDrawable materialShapeDrawable2 = this.boxBackground;
                materialShapeDrawable2.drawableState.strokeWidth = i;
                materialShapeDrawable2.invalidateSelf();
                materialShapeDrawable2.setStrokeColor(ColorStateList.valueOf(i2));
            }
            int i3 = this.boxBackgroundColor;
            if (this.boxBackgroundMode == 1) {
                i3 = ColorUtils.compositeColors(this.boxBackgroundColor, LazyKt__LazyJVMKt.getColor(getContext(), R.attr.colorSurface, 0));
            }
            this.boxBackgroundColor = i3;
            this.boxBackground.setFillColor(ColorStateList.valueOf(i3));
            MaterialShapeDrawable materialShapeDrawable3 = this.boxUnderlineDefault;
            if (!(materialShapeDrawable3 == null || this.boxUnderlineFocused == null)) {
                if (this.boxStrokeWidthPx > -1 && this.boxStrokeColor != 0) {
                    if (this.editText.isFocused()) {
                        colorStateList = ColorStateList.valueOf(this.defaultStrokeColor);
                    } else {
                        colorStateList = ColorStateList.valueOf(this.boxStrokeColor);
                    }
                    materialShapeDrawable3.setFillColor(colorStateList);
                    this.boxUnderlineFocused.setFillColor(ColorStateList.valueOf(this.boxStrokeColor));
                }
                invalidate();
            }
            updateEditTextBoxBackgroundIfNeeded();
        }
    }

    public final Rect calculateCollapsedTextBounds(Rect rect) {
        boolean z;
        if (this.editText != null) {
            if (getLayoutDirection() == 1) {
                z = true;
            } else {
                z = false;
            }
            int i = rect.bottom;
            Rect rect2 = this.tmpBoundsRect;
            rect2.bottom = i;
            int i2 = this.boxBackgroundMode;
            if (i2 == 1) {
                rect2.left = getLabelLeftBoundAlignedWithPrefixAndSuffix(rect.left, z);
                rect2.top = rect.top + this.boxCollapsedPaddingTopPx;
                rect2.right = getLabelRightBoundAlignedWithPrefixAndSuffix(rect.right, z);
                return rect2;
            } else if (i2 != 2) {
                rect2.left = getLabelLeftBoundAlignedWithPrefixAndSuffix(rect.left, z);
                rect2.top = getPaddingTop();
                rect2.right = getLabelRightBoundAlignedWithPrefixAndSuffix(rect.right, z);
                return rect2;
            } else {
                rect2.left = this.editText.getPaddingLeft() + rect.left;
                rect2.top = rect.top - calculateLabelMarginTop();
                rect2.right = rect.right - this.editText.getPaddingRight();
                return rect2;
            }
        } else {
            throw new IllegalStateException();
        }
    }

    public final int calculateLabelMarginTop() {
        if (this.hintEnabled) {
            int i = this.boxBackgroundMode;
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            if (i == 0) {
                return (int) collapsingTextHelper.getCollapsedTextHeight();
            }
            if (i == 2) {
                if (getHintMaxLines() == 1) {
                    return (int) (collapsingTextHelper.getCollapsedTextHeight() / 2.0f);
                }
                float collapsedTextHeight = collapsingTextHelper.getCollapsedTextHeight();
                TextPaint textPaint = collapsingTextHelper.tmpPaint;
                textPaint.setTextSize(collapsingTextHelper.collapsedTextSize);
                textPaint.setTypeface(collapsingTextHelper.collapsedTypeface);
                textPaint.setLetterSpacing(collapsingTextHelper.collapsedLetterSpacing);
                return Math.max(0, (int) (collapsedTextHeight - ((-textPaint.ascent()) / 2.0f)));
            }
        }
        return 0;
    }

    public final Fade createPlaceholderFadeTransition() {
        Fade fade = new Fade();
        fade.mDuration = LazyKt__LazyJVMKt.resolveThemeDuration(getContext(), R.attr.motionDurationShort2, 87);
        fade.mInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(getContext(), R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        return fade;
    }

    public final boolean cutoutEnabled() {
        if (!this.hintEnabled || TextUtils.isEmpty(this.hint) || !(this.boxBackground instanceof CutoutDrawable)) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        EditText editText = this.editText;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        if (this.originalHint != null) {
            boolean z = this.isProvidingHint;
            this.isProvidingHint = false;
            CharSequence hint = editText.getHint();
            this.editText.setHint(this.originalHint);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i);
            } finally {
                this.editText.setHint(hint);
                this.isProvidingHint = z;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i);
            onProvideAutofillVirtualStructure(viewStructure, i);
            FrameLayout frameLayout = this.inputFrame;
            viewStructure.setChildCount(frameLayout.getChildCount());
            for (int i2 = 0; i2 < frameLayout.getChildCount(); i2++) {
                View childAt = frameLayout.getChildAt(i2);
                ViewStructure newChild = viewStructure.newChild(i2);
                childAt.dispatchProvideAutofillStructure(newChild, i);
                if (childAt == this.editText) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        Canvas canvas2 = canvas;
        super.draw(canvas);
        boolean z = this.hintEnabled;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (z) {
            TextPaint textPaint = collapsingTextHelper.textPaint;
            RectF rectF = collapsingTextHelper.currentBounds;
            int save = canvas2.save();
            if (collapsingTextHelper.textToDraw != null && rectF.width() > 0.0f && rectF.height() > 0.0f) {
                textPaint.setTextSize(collapsingTextHelper.currentTextSize);
                float f = collapsingTextHelper.currentDrawX;
                float f2 = collapsingTextHelper.currentDrawY;
                float f3 = collapsingTextHelper.scale;
                if (f3 != 1.0f) {
                    canvas2.scale(f3, f3, f, f2);
                }
                if ((collapsingTextHelper.expandedMaxLines > 1 || collapsingTextHelper.collapsedMaxLines > 1) && !collapsingTextHelper.isRtl && collapsingTextHelper.shouldTruncateCollapsedToSingleLine()) {
                    int alpha = textPaint.getAlpha();
                    canvas2.translate(collapsingTextHelper.currentDrawX - collapsingTextHelper.textLayout.getLineStart(0), f2);
                    float f4 = alpha;
                    textPaint.setAlpha((int) (collapsingTextHelper.expandedTextBlend * f4));
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 31) {
                        float f5 = collapsingTextHelper.currentShadowRadius;
                        float f6 = collapsingTextHelper.currentShadowDx;
                        float f7 = collapsingTextHelper.currentShadowDy;
                        int i2 = collapsingTextHelper.currentShadowColor;
                        textPaint.setShadowLayer(f5, f6, f7, ColorUtils.setAlphaComponent(i2, (textPaint.getAlpha() * Color.alpha(i2)) / 255));
                    }
                    collapsingTextHelper.textLayout.draw(canvas2);
                    textPaint.setAlpha((int) (collapsingTextHelper.collapsedTextBlend * f4));
                    if (i >= 31) {
                        float f8 = collapsingTextHelper.currentShadowRadius;
                        float f9 = collapsingTextHelper.currentShadowDx;
                        float f10 = collapsingTextHelper.currentShadowDy;
                        int i3 = collapsingTextHelper.currentShadowColor;
                        textPaint.setShadowLayer(f8, f9, f10, ColorUtils.setAlphaComponent(i3, (Color.alpha(i3) * textPaint.getAlpha()) / 255));
                    }
                    int lineBaseline = collapsingTextHelper.textLayout.getLineBaseline(0);
                    CharSequence charSequence = collapsingTextHelper.textToDrawCollapsed;
                    float f11 = lineBaseline;
                    canvas2.drawText(charSequence, 0, charSequence.length(), 0.0f, f11, textPaint);
                    if (i >= 31) {
                        textPaint.setShadowLayer(collapsingTextHelper.currentShadowRadius, collapsingTextHelper.currentShadowDx, collapsingTextHelper.currentShadowDy, collapsingTextHelper.currentShadowColor);
                    }
                    String trim = collapsingTextHelper.textToDrawCollapsed.toString().trim();
                    if (trim.endsWith("…")) {
                        trim = trim.substring(0, trim.length() - 1);
                    }
                    String str = trim;
                    textPaint.setAlpha(alpha);
                    canvas2 = canvas;
                    canvas2.drawText(str, 0, Math.min(collapsingTextHelper.textLayout.getLineEnd(0), str.length()), 0.0f, f11, (Paint) textPaint);
                } else {
                    canvas2.translate(f, f2);
                    collapsingTextHelper.textLayout.draw(canvas2);
                }
                canvas2.restoreToCount(save);
            }
        }
        if (this.boxUnderlineFocused != null && (materialShapeDrawable = this.boxUnderlineDefault) != null) {
            materialShapeDrawable.draw(canvas2);
            if (this.editText.isFocused()) {
                Rect bounds = this.boxUnderlineFocused.getBounds();
                Rect bounds2 = this.boxUnderlineDefault.getBounds();
                float f12 = collapsingTextHelper.expandedFraction;
                int centerX = bounds2.centerX();
                bounds.left = AnimationUtils.lerp(centerX, f12, bounds2.left);
                bounds.right = AnimationUtils.lerp(centerX, f12, bounds2.right);
                this.boxUnderlineFocused.draw(canvas2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void drawableStateChanged() {
        /*
            r4 = this;
            boolean r0 = r4.inDrawableStateChanged
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            r4.inDrawableStateChanged = r0
            super.drawableStateChanged()
            int[] r1 = r4.getDrawableState()
            r2 = 0
            com.google.android.material.internal.CollapsingTextHelper r3 = r4.collapsingTextHelper
            if (r3 == 0) goto L2f
            r3.state = r1
            android.content.res.ColorStateList r1 = r3.collapsedTextColor
            if (r1 == 0) goto L20
            boolean r1 = r1.isStateful()
            if (r1 != 0) goto L2a
        L20:
            android.content.res.ColorStateList r1 = r3.expandedTextColor
            if (r1 == 0) goto L2f
            boolean r1 = r1.isStateful()
            if (r1 == 0) goto L2f
        L2a:
            r3.recalculate(r2)
            r1 = 1
            goto L30
        L2f:
            r1 = 0
        L30:
            android.widget.EditText r3 = r4.editText
            if (r3 == 0) goto L45
            boolean r3 = r4.isLaidOut()
            if (r3 == 0) goto L41
            boolean r3 = r4.isEnabled()
            if (r3 == 0) goto L41
            goto L42
        L41:
            r0 = 0
        L42:
            r4.updateLabelState(r0, r2)
        L45:
            r4.updateEditTextBackground()
            r4.updateTextInputBoxState()
            if (r1 == 0) goto L50
            r4.invalidate()
        L50:
            r4.inDrawableStateChanged = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.drawableStateChanged():void");
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.editText;
        if (editText == null) {
            return super.getBaseline();
        }
        return calculateLabelMarginTop() + getPaddingTop() + editText.getBaseline();
    }

    public MaterialShapeDrawable getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public int getBoxBackgroundMode() {
        return this.boxBackgroundMode;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.boxCollapsedPaddingTopPx;
    }

    public float getBoxCornerRadiusBottomEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.tmpRectF;
        if (layoutDirection == 1) {
            return this.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(rectF);
        }
        return this.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusBottomStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.tmpRectF;
        if (layoutDirection == 1) {
            return this.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(rectF);
        }
        return this.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusTopEnd() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.tmpRectF;
        if (layoutDirection == 1) {
            return this.shapeAppearanceModel.topLeftCornerSize.getCornerSize(rectF);
        }
        return this.shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF);
    }

    public float getBoxCornerRadiusTopStart() {
        int layoutDirection = getLayoutDirection();
        RectF rectF = this.tmpRectF;
        if (layoutDirection == 1) {
            return this.shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF);
        }
        return this.shapeAppearanceModel.topLeftCornerSize.getCornerSize(rectF);
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.strokeErrorColor;
    }

    public int getBoxStrokeWidth() {
        return this.boxStrokeWidthDefaultPx;
    }

    public int getBoxStrokeWidthFocused() {
        return this.boxStrokeWidthFocusedPx;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    public CharSequence getCounterOverflowDescription() {
        AppCompatTextView appCompatTextView;
        if (!this.counterEnabled || !this.counterOverflowed || (appCompatTextView = this.counterView) == null) {
            return null;
        }
        return appCompatTextView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.counterOverflowTextColor;
    }

    public ColorStateList getCounterTextColor() {
        return this.counterTextColor;
    }

    public ColorStateList getCursorColor() {
        return this.cursorColor;
    }

    public ColorStateList getCursorErrorColor() {
        return this.cursorErrorColor;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, com.google.android.material.shape.ShapeAppearanceModel] */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.LazyKt__LazyJVMKt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.LazyKt__LazyJVMKt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.LazyKt__LazyJVMKt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlin.LazyKt__LazyJVMKt, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    public final MaterialShapeDrawable getDropDownMaterialShapeDrawable(boolean z) {
        float f;
        float f2;
        ColorStateList colorStateList;
        int i;
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        if (z) {
            f = dimensionPixelOffset;
        } else {
            f = 0.0f;
        }
        EditText editText = this.editText;
        if (editText instanceof MaterialAutoCompleteTextView) {
            f2 = ((MaterialAutoCompleteTextView) editText).getPopupElevation();
        } else {
            f2 = getResources().getDimensionPixelOffset(R.dimen.m3_comp_outlined_autocomplete_menu_container_elevation);
        }
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ?? obj = new Object();
        ?? obj2 = new Object();
        ?? obj3 = new Object();
        ?? obj4 = new Object();
        ?? obj5 = new Object();
        ?? obj6 = new Object();
        ?? obj7 = new Object();
        ?? obj8 = new Object();
        AbsoluteCornerSize absoluteCornerSize = new AbsoluteCornerSize(f);
        AbsoluteCornerSize absoluteCornerSize2 = new AbsoluteCornerSize(f);
        AbsoluteCornerSize absoluteCornerSize3 = new AbsoluteCornerSize(dimensionPixelOffset);
        AbsoluteCornerSize absoluteCornerSize4 = new AbsoluteCornerSize(dimensionPixelOffset);
        ?? obj9 = new Object();
        obj9.topLeftCorner = obj;
        obj9.topRightCorner = obj2;
        obj9.bottomRightCorner = obj3;
        obj9.bottomLeftCorner = obj4;
        obj9.topLeftCornerSize = absoluteCornerSize;
        obj9.topRightCornerSize = absoluteCornerSize2;
        obj9.bottomRightCornerSize = absoluteCornerSize4;
        obj9.bottomLeftCornerSize = absoluteCornerSize3;
        obj9.topEdge = obj5;
        obj9.rightEdge = obj6;
        obj9.bottomEdge = obj7;
        obj9.leftEdge = obj8;
        EditText editText2 = this.editText;
        if (editText2 instanceof MaterialAutoCompleteTextView) {
            colorStateList = ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList();
        } else {
            colorStateList = null;
        }
        Context context = getContext();
        if (colorStateList == null) {
            Paint paint = MaterialShapeDrawable.clearPaint;
            TypedValue resolveTypedValueOrThrow = LazyKt__LazyJVMKt.resolveTypedValueOrThrow(R.attr.colorSurface, context, "MaterialShapeDrawable");
            int i2 = resolveTypedValueOrThrow.resourceId;
            if (i2 != 0) {
                i = BundleKt.getColor(context, i2);
            } else {
                i = resolveTypedValueOrThrow.data;
            }
            colorStateList = ColorStateList.valueOf(i);
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(colorStateList);
        materialShapeDrawable.setElevation(f2);
        materialShapeDrawable.setShapeAppearanceModel(obj9);
        MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
        if (materialShapeDrawableState.padding == null) {
            materialShapeDrawableState.padding = new Rect();
        }
        materialShapeDrawable.drawableState.padding.set(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        materialShapeDrawable.invalidateSelf();
        return materialShapeDrawable;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getEndIconContentDescription() {
        return this.endLayout.endIconView.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.endLayout.endIconView.getDrawable();
    }

    public int getEndIconMinSize() {
        return this.endLayout.endIconMinSize;
    }

    public int getEndIconMode() {
        return this.endLayout.endIconMode;
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.endLayout.endIconScaleType;
    }

    public CheckableImageButton getEndIconView() {
        return this.endLayout.endIconView;
    }

    public CharSequence getError() {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.errorEnabled) {
            return indicatorViewController.errorText;
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.indicatorViewController.errorViewAccessibilityLiveRegion;
    }

    public CharSequence getErrorContentDescription() {
        return this.indicatorViewController.errorViewContentDescription;
    }

    public int getErrorCurrentTextColors() {
        AppCompatTextView appCompatTextView = this.indicatorViewController.errorView;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public Drawable getErrorIconDrawable() {
        return this.endLayout.errorIconView.getDrawable();
    }

    public CharSequence getHelperText() {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.helperTextEnabled) {
            return indicatorViewController.helperText;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        AppCompatTextView appCompatTextView = this.indicatorViewController.helperTextView;
        if (appCompatTextView != null) {
            return appCompatTextView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    public final int getHintCurrentCollapsedTextColor() {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        return collapsingTextHelper.getCurrentColor(collapsingTextHelper.collapsedTextColor);
    }

    public int getHintMaxLines() {
        return this.collapsingTextHelper.expandedMaxLines;
    }

    public ColorStateList getHintTextColor() {
        return this.focusedTextColor;
    }

    public final int getLabelLeftBoundAlignedWithPrefixAndSuffix(int i, boolean z) {
        int compoundPaddingLeft;
        if (!z && getPrefixText() != null) {
            compoundPaddingLeft = this.startLayout.getPrefixTextStartOffset();
        } else if (!z || getSuffixText() == null) {
            compoundPaddingLeft = this.editText.getCompoundPaddingLeft();
        } else {
            compoundPaddingLeft = this.endLayout.getSuffixTextEndOffset();
        }
        return compoundPaddingLeft + i;
    }

    public final int getLabelRightBoundAlignedWithPrefixAndSuffix(int i, boolean z) {
        int compoundPaddingRight;
        if (!z && getSuffixText() != null) {
            compoundPaddingRight = this.endLayout.getSuffixTextEndOffset();
        } else if (!z || getPrefixText() == null) {
            compoundPaddingRight = this.editText.getCompoundPaddingRight();
        } else {
            compoundPaddingRight = this.startLayout.getPrefixTextStartOffset();
        }
        return i - compoundPaddingRight;
    }

    public LengthCounter getLengthCounter() {
        return this.lengthCounter;
    }

    public int getMaxEms() {
        return this.maxEms;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getMinEms() {
        return this.minEms;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.endLayout.endIconView.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.endLayout.endIconView.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.placeholderEnabled) {
            return this.placeholderText;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.placeholderTextAppearance;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.placeholderTextColor;
    }

    public CharSequence getPrefixText() {
        return this.startLayout.prefixText;
    }

    public ColorStateList getPrefixTextColor() {
        return this.startLayout.prefixTextView.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.startLayout.prefixTextView;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    public CharSequence getStartIconContentDescription() {
        return this.startLayout.startIconView.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.startLayout.startIconView.getDrawable();
    }

    public int getStartIconMinSize() {
        return this.startLayout.startIconMinSize;
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.startLayout.startIconScaleType;
    }

    public CharSequence getSuffixText() {
        return this.endLayout.suffixText;
    }

    public ColorStateList getSuffixTextColor() {
        return this.endLayout.suffixTextView.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.endLayout.suffixTextView;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    /* JADX WARN: Type inference failed for: r0v26, types: [com.google.android.material.textfield.CutoutDrawable, com.google.android.material.shape.MaterialShapeDrawable] */
    public final void onApplyBoxBackgroundMode() {
        int i = this.boxBackgroundMode;
        if (i == 0) {
            this.boxBackground = null;
            this.boxUnderlineDefault = null;
            this.boxUnderlineFocused = null;
        } else if (i == 1) {
            this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.boxUnderlineDefault = new MaterialShapeDrawable();
            this.boxUnderlineFocused = new MaterialShapeDrawable();
        } else if (i == 2) {
            if (!this.hintEnabled || (this.boxBackground instanceof CutoutDrawable)) {
                this.boxBackground = new MaterialShapeDrawable(this.shapeAppearanceModel);
            } else {
                ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModel;
                int i2 = CutoutDrawable.$r8$clinit;
                if (shapeAppearanceModel == null) {
                    shapeAppearanceModel = new ShapeAppearanceModel();
                }
                CutoutDrawable.CutoutDrawableState cutoutDrawableState = new CutoutDrawable.CutoutDrawableState(shapeAppearanceModel, new RectF());
                ?? materialShapeDrawable = new MaterialShapeDrawable(cutoutDrawableState);
                materialShapeDrawable.drawableState = cutoutDrawableState;
                this.boxBackground = materialShapeDrawable;
            }
            this.boxUnderlineDefault = null;
            this.boxUnderlineFocused = null;
        } else {
            throw new IllegalArgumentException(this.boxBackgroundMode + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
        updateEditTextBoxBackgroundIfNeeded();
        updateTextInputBoxState();
        if (this.boxBackgroundMode == 1) {
            if (getContext().getResources().getConfiguration().fontScale >= 2.0f) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (LazyKt__LazyJVMKt.isFontScaleAtLeast1_3(getContext())) {
                this.boxCollapsedPaddingTopPx = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        adjustFilledEditTextPaddingForLargeFont();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
        EditText editText = this.editText;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i3 = this.boxBackgroundMode;
                if (i3 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i3 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int max;
        EndCompoundLayout endCompoundLayout = this.endLayout;
        endCompoundLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        boolean z = false;
        this.globalLayoutListenerAdded = false;
        if (this.editText != null && this.editText.getMeasuredHeight() < (max = Math.max(endCompoundLayout.getMeasuredHeight(), this.startLayout.getMeasuredHeight()))) {
            this.editText.setMinimumHeight(max);
            z = true;
        }
        boolean updateDummyDrawables = updateDummyDrawables();
        if (z || updateDummyDrawables) {
            this.editText.post(new ActivityCompat$$ExternalSyntheticLambda0(24, this));
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        int i6;
        int i7;
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.editText;
        if (editText != null) {
            ThreadLocal threadLocal = DescendantOffsetUtils.matrix;
            int width = editText.getWidth();
            int height = editText.getHeight();
            Rect rect = this.tmpRect;
            rect.set(0, 0, width, height);
            DescendantOffsetUtils.offsetDescendantRect(this, editText, rect);
            MaterialShapeDrawable materialShapeDrawable = this.boxUnderlineDefault;
            if (materialShapeDrawable != null) {
                int i8 = rect.bottom;
                materialShapeDrawable.setBounds(rect.left, i8 - this.boxStrokeWidthDefaultPx, rect.right, i8);
            }
            MaterialShapeDrawable materialShapeDrawable2 = this.boxUnderlineFocused;
            if (materialShapeDrawable2 != null) {
                int i9 = rect.bottom;
                materialShapeDrawable2.setBounds(rect.left, i9 - this.boxStrokeWidthFocusedPx, rect.right, i9);
            }
            if (this.hintEnabled) {
                float textSize = this.editText.getTextSize();
                CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
                float f2 = collapsingTextHelper.expandedTextSize;
                TextPaint textPaint = collapsingTextHelper.tmpPaint;
                if (f2 != textSize) {
                    collapsingTextHelper.expandedTextSize = textSize;
                    collapsingTextHelper.recalculate(false);
                }
                int gravity = this.editText.getGravity();
                int i10 = (gravity & (-113)) | 48;
                if (collapsingTextHelper.collapsedTextGravity != i10) {
                    collapsingTextHelper.collapsedTextGravity = i10;
                    collapsingTextHelper.recalculate(false);
                }
                if (collapsingTextHelper.expandedTextGravity != gravity) {
                    collapsingTextHelper.expandedTextGravity = gravity;
                    collapsingTextHelper.recalculate(false);
                }
                Rect calculateCollapsedTextBounds = calculateCollapsedTextBounds(rect);
                int i11 = calculateCollapsedTextBounds.left;
                int i12 = calculateCollapsedTextBounds.top;
                int i13 = calculateCollapsedTextBounds.right;
                int i14 = calculateCollapsedTextBounds.bottom;
                Rect rect2 = collapsingTextHelper.collapsedBounds;
                if (!(rect2.left == i11 && rect2.top == i12 && rect2.right == i13 && rect2.bottom == i14)) {
                    rect2.set(i11, i12, i13, i14);
                    collapsingTextHelper.boundsChanged = true;
                }
                if (this.editText != null) {
                    if (getHintMaxLines() == 1) {
                        textPaint.setTextSize(collapsingTextHelper.expandedTextSize);
                        textPaint.setTypeface(collapsingTextHelper.expandedTypeface);
                        textPaint.setLetterSpacing(collapsingTextHelper.expandedLetterSpacing);
                        f = -textPaint.ascent();
                    } else {
                        textPaint.setTextSize(collapsingTextHelper.expandedTextSize);
                        textPaint.setTypeface(collapsingTextHelper.expandedTypeface);
                        textPaint.setLetterSpacing(collapsingTextHelper.expandedLetterSpacing);
                        f = collapsingTextHelper.expandedLineCount * (textPaint.descent() + (-textPaint.ascent()));
                    }
                    int compoundPaddingLeft = this.editText.getCompoundPaddingLeft() + rect.left;
                    Rect rect3 = this.tmpBoundsRect;
                    rect3.left = compoundPaddingLeft;
                    if (this.boxBackgroundMode != 1 || this.editText.getMinLines() > 1) {
                        if (this.boxBackgroundMode != 0 || getHintMaxLines() == 1) {
                            i7 = 0;
                        } else {
                            textPaint.setTextSize(collapsingTextHelper.expandedTextSize);
                            textPaint.setTypeface(collapsingTextHelper.expandedTypeface);
                            textPaint.setLetterSpacing(collapsingTextHelper.expandedLetterSpacing);
                            i7 = (int) ((-textPaint.ascent()) / 2.0f);
                        }
                        i5 = (this.editText.getCompoundPaddingTop() + rect.top) - i7;
                    } else {
                        i5 = (int) (rect.centerY() - (f / 2.0f));
                    }
                    rect3.top = i5;
                    rect3.right = rect.right - this.editText.getCompoundPaddingRight();
                    if (this.boxBackgroundMode != 1 || this.editText.getMinLines() > 1) {
                        i6 = rect.bottom - this.editText.getCompoundPaddingBottom();
                    } else {
                        i6 = (int) (rect3.top + f);
                    }
                    rect3.bottom = i6;
                    int i15 = rect3.left;
                    int i16 = rect3.top;
                    int i17 = rect3.right;
                    Rect rect4 = collapsingTextHelper.expandedBounds;
                    if (!(rect4.left == i15 && rect4.top == i16 && rect4.right == i17 && rect4.bottom == i6 && true == collapsingTextHelper.alignBaselineAtBottom)) {
                        rect4.set(i15, i16, i17, i6);
                        collapsingTextHelper.boundsChanged = true;
                        collapsingTextHelper.alignBaselineAtBottom = true;
                    }
                    collapsingTextHelper.recalculate(false);
                    if (cutoutEnabled() && !this.hintExpanded) {
                        openCutout();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        float f;
        float f2;
        EditText editText;
        super.onMeasure(i, i2);
        boolean z = this.globalLayoutListenerAdded;
        EndCompoundLayout endCompoundLayout = this.endLayout;
        if (!z) {
            endCompoundLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.globalLayoutListenerAdded = true;
        }
        if (!(this.placeholderTextView == null || (editText = this.editText) == null)) {
            this.placeholderTextView.setGravity(editText.getGravity());
            this.placeholderTextView.setPadding(this.editText.getCompoundPaddingLeft(), this.editText.getCompoundPaddingTop(), this.editText.getCompoundPaddingRight(), this.editText.getCompoundPaddingBottom());
        }
        endCompoundLayout.updateSuffixTextViewPadding();
        if (getHintMaxLines() != 1) {
            int measuredWidth = (this.editText.getMeasuredWidth() - this.editText.getCompoundPaddingLeft()) - this.editText.getCompoundPaddingRight();
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            TextPaint textPaint = collapsingTextHelper.tmpPaint;
            textPaint.setTextSize(collapsingTextHelper.collapsedTextSize);
            textPaint.setTypeface(collapsingTextHelper.collapsedTypeface);
            textPaint.setLetterSpacing(collapsingTextHelper.collapsedLetterSpacing);
            float f3 = measuredWidth;
            collapsingTextHelper.collapsedHeight = collapsingTextHelper.createStaticLayout(collapsingTextHelper.collapsedMaxLines, textPaint, collapsingTextHelper.text, (collapsingTextHelper.collapsedTextSize / collapsingTextHelper.expandedTextSize) * f3, collapsingTextHelper.isRtl).getHeight();
            textPaint.setTextSize(collapsingTextHelper.expandedTextSize);
            textPaint.setTypeface(collapsingTextHelper.expandedTypeface);
            textPaint.setLetterSpacing(collapsingTextHelper.expandedLetterSpacing);
            collapsingTextHelper.expandedHeight = collapsingTextHelper.createStaticLayout(collapsingTextHelper.expandedMaxLines, textPaint, collapsingTextHelper.text, f3, collapsingTextHelper.isRtl).getHeight();
            EditText editText2 = this.editText;
            ThreadLocal threadLocal = DescendantOffsetUtils.matrix;
            int width = editText2.getWidth();
            int height = editText2.getHeight();
            Rect rect = this.tmpRect;
            boolean z2 = false;
            rect.set(0, 0, width, height);
            DescendantOffsetUtils.offsetDescendantRect(this, editText2, rect);
            Rect calculateCollapsedTextBounds = calculateCollapsedTextBounds(rect);
            int i3 = calculateCollapsedTextBounds.left;
            int i4 = calculateCollapsedTextBounds.top;
            int i5 = calculateCollapsedTextBounds.right;
            int i6 = calculateCollapsedTextBounds.bottom;
            Rect rect2 = collapsingTextHelper.collapsedBounds;
            if (!(rect2.left == i3 && rect2.top == i4 && rect2.right == i5 && rect2.bottom == i6)) {
                rect2.set(i3, i4, i5, i6);
                collapsingTextHelper.boundsChanged = true;
            }
            updateInputLayoutMargins();
            adjustFilledEditTextPaddingForLargeFont();
            if (this.editText != null) {
                int i7 = collapsingTextHelper.expandedHeight;
                if (i7 != -1) {
                    f = i7;
                } else {
                    TextPaint textPaint2 = collapsingTextHelper.tmpPaint;
                    textPaint2.setTextSize(collapsingTextHelper.expandedTextSize);
                    textPaint2.setTypeface(collapsingTextHelper.expandedTypeface);
                    textPaint2.setLetterSpacing(collapsingTextHelper.expandedLetterSpacing);
                    f = -textPaint2.ascent();
                }
                float f4 = 0.0f;
                if (this.placeholderText != null) {
                    TextPaint textPaint3 = new TextPaint(129);
                    textPaint3.set(this.placeholderTextView.getPaint());
                    textPaint3.setTextSize(this.placeholderTextView.getTextSize());
                    textPaint3.setTypeface(this.placeholderTextView.getTypeface());
                    textPaint3.setLetterSpacing(this.placeholderTextView.getLetterSpacing());
                    try {
                        StaticLayoutBuilderCompat staticLayoutBuilderCompat = new StaticLayoutBuilderCompat(this.placeholderText, textPaint3, measuredWidth);
                        if (getLayoutDirection() == 1) {
                            z2 = true;
                        }
                        staticLayoutBuilderCompat.isRtl = z2;
                        staticLayoutBuilderCompat.includePad = true;
                        float lineSpacingExtra = this.placeholderTextView.getLineSpacingExtra();
                        float lineSpacingMultiplier = this.placeholderTextView.getLineSpacingMultiplier();
                        staticLayoutBuilderCompat.lineSpacingAdd = lineSpacingExtra;
                        staticLayoutBuilderCompat.lineSpacingMultiplier = lineSpacingMultiplier;
                        staticLayoutBuilderCompat.staticLayoutBuilderConfigurer = new InputConnectionCompat$$ExternalSyntheticLambda0(17, this);
                        StaticLayout build = staticLayoutBuilderCompat.build();
                        if (this.boxBackgroundMode == 1) {
                            f2 = collapsingTextHelper.getCollapsedTextHeight() + this.boxCollapsedPaddingTopPx + this.extraSpaceBetweenPlaceholderAndHint;
                        } else {
                            f2 = 0.0f;
                        }
                        f4 = build.getHeight() + f2;
                    } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e) {
                        Log.e("TextInputLayout", e.getCause().getMessage(), e);
                    }
                }
                float max = Math.max(f, f4);
                if (this.editText.getMeasuredHeight() < max) {
                    this.editText.setMinimumHeight(Math.round(max));
                }
            }
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        setError(savedState.error);
        if (savedState.isEndIconChecked) {
            post(new zzab(15, this));
        }
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, com.google.android.material.shape.ShapeAppearanceModel] */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        if (z != this.areCornerRadiiRtl) {
            CornerSize cornerSize = this.shapeAppearanceModel.topLeftCornerSize;
            RectF rectF = this.tmpRectF;
            float cornerSize2 = cornerSize.getCornerSize(rectF);
            float cornerSize3 = this.shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF);
            float cornerSize4 = this.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(rectF);
            float cornerSize5 = this.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(rectF);
            ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModel;
            LazyKt__LazyJVMKt lazyKt__LazyJVMKt = shapeAppearanceModel.topLeftCorner;
            LazyKt__LazyJVMKt lazyKt__LazyJVMKt2 = shapeAppearanceModel.topRightCorner;
            LazyKt__LazyJVMKt lazyKt__LazyJVMKt3 = shapeAppearanceModel.bottomLeftCorner;
            LazyKt__LazyJVMKt lazyKt__LazyJVMKt4 = shapeAppearanceModel.bottomRightCorner;
            ?? obj = new Object();
            ?? obj2 = new Object();
            ?? obj3 = new Object();
            ?? obj4 = new Object();
            AbsoluteCornerSize absoluteCornerSize = new AbsoluteCornerSize(cornerSize3);
            AbsoluteCornerSize absoluteCornerSize2 = new AbsoluteCornerSize(cornerSize2);
            AbsoluteCornerSize absoluteCornerSize3 = new AbsoluteCornerSize(cornerSize5);
            AbsoluteCornerSize absoluteCornerSize4 = new AbsoluteCornerSize(cornerSize4);
            ?? obj5 = new Object();
            obj5.topLeftCorner = lazyKt__LazyJVMKt2;
            obj5.topRightCorner = lazyKt__LazyJVMKt;
            obj5.bottomRightCorner = lazyKt__LazyJVMKt3;
            obj5.bottomLeftCorner = lazyKt__LazyJVMKt4;
            obj5.topLeftCornerSize = absoluteCornerSize;
            obj5.topRightCornerSize = absoluteCornerSize2;
            obj5.bottomRightCornerSize = absoluteCornerSize4;
            obj5.bottomLeftCornerSize = absoluteCornerSize3;
            obj5.topEdge = obj;
            obj5.rightEdge = obj2;
            obj5.bottomEdge = obj3;
            obj5.leftEdge = obj4;
            this.areCornerRadiiRtl = z;
            setShapeAppearanceModel(obj5);
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.material.textfield.TextInputLayout$SavedState, android.os.Parcelable, androidx.customview.view.AbsSavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        boolean z;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        if (shouldShowError()) {
            absSavedState.error = getError();
        }
        EndCompoundLayout endCompoundLayout = this.endLayout;
        if (endCompoundLayout.endIconMode == 0 || !endCompoundLayout.endIconView.checked) {
            z = false;
        } else {
            z = true;
        }
        absSavedState.isEndIconChecked = z;
        return absSavedState;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void openCutout() {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.openCutout():void");
    }

    public void setBoxBackgroundColor(int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            this.defaultFilledBackgroundColor = i;
            this.focusedFilledBackgroundColor = i;
            this.hoveredFilledBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(BundleKt.getColor(getContext(), i));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.defaultFilledBackgroundColor = defaultColor;
        this.boxBackgroundColor = defaultColor;
        this.disabledFilledBackgroundColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.focusedFilledBackgroundColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.hoveredFilledBackgroundColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        applyBoxAttributes();
    }

    public void setBoxBackgroundMode(int i) {
        if (i != this.boxBackgroundMode) {
            this.boxBackgroundMode = i;
            if (this.editText != null) {
                onApplyBoxBackgroundMode();
            }
        }
    }

    public void setBoxCollapsedPaddingTop(int i) {
        this.boxCollapsedPaddingTopPx = i;
    }

    public void setBoxCornerFamily(int i) {
        ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
        CornerSize cornerSize = this.shapeAppearanceModel.topLeftCornerSize;
        builder.topLeftCorner = LazyKt__LazyJVMKt.createCornerTreatment(i);
        builder.topLeftCornerSize = cornerSize;
        CornerSize cornerSize2 = this.shapeAppearanceModel.topRightCornerSize;
        builder.topRightCorner = LazyKt__LazyJVMKt.createCornerTreatment(i);
        builder.topRightCornerSize = cornerSize2;
        CornerSize cornerSize3 = this.shapeAppearanceModel.bottomLeftCornerSize;
        builder.bottomLeftCorner = LazyKt__LazyJVMKt.createCornerTreatment(i);
        builder.bottomLeftCornerSize = cornerSize3;
        CornerSize cornerSize4 = this.shapeAppearanceModel.bottomRightCornerSize;
        builder.bottomRightCorner = LazyKt__LazyJVMKt.createCornerTreatment(i);
        builder.bottomRightCornerSize = cornerSize4;
        this.shapeAppearanceModel = builder.build();
        applyBoxAttributes();
    }

    public void setBoxStrokeColor(int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.defaultStrokeColor = colorStateList.getDefaultColor();
            this.disabledColor = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.hoveredStrokeColor = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.focusedStrokeColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.focusedStrokeColor != colorStateList.getDefaultColor()) {
            this.focusedStrokeColor = colorStateList.getDefaultColor();
        }
        updateTextInputBoxState();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.strokeErrorColor != colorStateList) {
            this.strokeErrorColor = colorStateList;
            updateTextInputBoxState();
        }
    }

    public void setBoxStrokeWidth(int i) {
        this.boxStrokeWidthDefaultPx = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocused(int i) {
        this.boxStrokeWidthFocusedPx = i;
        updateTextInputBoxState();
    }

    public void setBoxStrokeWidthFocusedResource(int i) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i));
    }

    public void setBoxStrokeWidthResource(int i) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i));
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            IndicatorViewController indicatorViewController = this.indicatorViewController;
            Editable editable = null;
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
                this.counterView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.typeface;
                if (typeface != null) {
                    this.counterView.setTypeface(typeface);
                }
                this.counterView.setMaxLines(1);
                indicatorViewController.addIndicator(this.counterView, 2);
                ((ViewGroup.MarginLayoutParams) this.counterView.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                updateCounterTextAppearanceAndColor();
                if (this.counterView != null) {
                    EditText editText = this.editText;
                    if (editText != null) {
                        editable = editText.getText();
                    }
                    updateCounter(editable);
                }
            } else {
                indicatorViewController.removeIndicator(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public void setCounterMaxLength(int i) {
        Editable editable;
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled && this.counterView != null) {
                EditText editText = this.editText;
                if (editText == null) {
                    editable = null;
                } else {
                    editable = editText.getText();
                }
                updateCounter(editable);
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i) {
        if (this.counterOverflowTextAppearance != i) {
            this.counterOverflowTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.counterOverflowTextColor != colorStateList) {
            this.counterOverflowTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextAppearance(int i) {
        if (this.counterTextAppearance != i) {
            this.counterTextAppearance = i;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.counterTextColor != colorStateList) {
            this.counterTextColor = colorStateList;
            updateCounterTextAppearanceAndColor();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.cursorColor != colorStateList) {
            this.cursorColor = colorStateList;
            updateCursorColor();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.cursorErrorColor != colorStateList) {
            this.cursorErrorColor = colorStateList;
            if (shouldShowError() || (this.counterView != null && this.counterOverflowed)) {
                updateCursorColor();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false, false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    public void setEndIconActivated(boolean z) {
        this.endLayout.endIconView.setActivated(z);
    }

    public void setEndIconCheckable(boolean z) {
        this.endLayout.endIconView.setCheckable(z);
    }

    public void setEndIconContentDescription(int i) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        CharSequence text = i != 0 ? endCompoundLayout.getResources().getText(i) : null;
        CheckableImageButton checkableImageButton = endCompoundLayout.endIconView;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
    }

    public void setEndIconDrawable(int i) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        Drawable drawable = i != 0 ? BundleKt.getDrawable(endCompoundLayout.getContext(), i) : null;
        TextInputLayout textInputLayout = endCompoundLayout.textInputLayout;
        CheckableImageButton checkableImageButton = endCompoundLayout.endIconView;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            LazyKt__LazyJVMKt.applyIconTint(textInputLayout, checkableImageButton, endCompoundLayout.endIconTintList, endCompoundLayout.endIconTintMode);
            LazyKt__LazyJVMKt.refreshIconDrawableState(textInputLayout, checkableImageButton, endCompoundLayout.endIconTintList);
        }
    }

    public void setEndIconMinSize(int i) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        if (i < 0) {
            endCompoundLayout.getClass();
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        } else if (i != endCompoundLayout.endIconMinSize) {
            endCompoundLayout.endIconMinSize = i;
            CheckableImageButton checkableImageButton = endCompoundLayout.endIconView;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
            CheckableImageButton checkableImageButton2 = endCompoundLayout.errorIconView;
            checkableImageButton2.setMinimumWidth(i);
            checkableImageButton2.setMinimumHeight(i);
        }
    }

    public void setEndIconMode(int i) {
        this.endLayout.setEndIconMode(i);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        CheckableImageButton checkableImageButton = endCompoundLayout.endIconView;
        View.OnLongClickListener onLongClickListener = endCompoundLayout.endIconOnLongClickListener;
        checkableImageButton.setOnClickListener(onClickListener);
        LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        endCompoundLayout.endIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = endCompoundLayout.endIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        endCompoundLayout.endIconScaleType = scaleType;
        endCompoundLayout.endIconView.setScaleType(scaleType);
        endCompoundLayout.errorIconView.setScaleType(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        if (endCompoundLayout.endIconTintList != colorStateList) {
            endCompoundLayout.endIconTintList = colorStateList;
            LazyKt__LazyJVMKt.applyIconTint(endCompoundLayout.textInputLayout, endCompoundLayout.endIconView, colorStateList, endCompoundLayout.endIconTintMode);
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        if (endCompoundLayout.endIconTintMode != mode) {
            endCompoundLayout.endIconTintMode = mode;
            LazyKt__LazyJVMKt.applyIconTint(endCompoundLayout.textInputLayout, endCompoundLayout.endIconView, endCompoundLayout.endIconTintList, mode);
        }
    }

    public void setEndIconVisible(boolean z) {
        this.endLayout.setEndIconVisible(z);
    }

    public void setError(CharSequence charSequence) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (!indicatorViewController.errorEnabled) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            indicatorViewController.cancelCaptionAnimator();
            indicatorViewController.errorText = charSequence;
            indicatorViewController.errorView.setText(charSequence);
            int i = indicatorViewController.captionDisplayed;
            if (i != 1) {
                indicatorViewController.captionToShow = 1;
            }
            indicatorViewController.updateCaptionViewsVisibility(i, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.errorView, charSequence));
            return;
        }
        indicatorViewController.hideError();
    }

    public void setErrorAccessibilityLiveRegion(int i) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.errorViewAccessibilityLiveRegion = i;
        AppCompatTextView appCompatTextView = indicatorViewController.errorView;
        if (appCompatTextView != null) {
            appCompatTextView.setAccessibilityLiveRegion(i);
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.errorViewContentDescription = charSequence;
        AppCompatTextView appCompatTextView = indicatorViewController.errorView;
        if (appCompatTextView != null) {
            appCompatTextView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        TextInputLayout textInputLayout = indicatorViewController.textInputView;
        if (indicatorViewController.errorEnabled != z) {
            indicatorViewController.cancelCaptionAnimator();
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController.context, null);
                indicatorViewController.errorView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_error);
                indicatorViewController.errorView.setTextAlignment(5);
                Typeface typeface = indicatorViewController.typeface;
                if (typeface != null) {
                    indicatorViewController.errorView.setTypeface(typeface);
                }
                int i = indicatorViewController.errorTextAppearance;
                indicatorViewController.errorTextAppearance = i;
                AppCompatTextView appCompatTextView2 = indicatorViewController.errorView;
                if (appCompatTextView2 != null) {
                    indicatorViewController.textInputView.setTextAppearanceCompatWithErrorFallback(appCompatTextView2, i);
                }
                ColorStateList colorStateList = indicatorViewController.errorViewTextColor;
                indicatorViewController.errorViewTextColor = colorStateList;
                AppCompatTextView appCompatTextView3 = indicatorViewController.errorView;
                if (!(appCompatTextView3 == null || colorStateList == null)) {
                    appCompatTextView3.setTextColor(colorStateList);
                }
                CharSequence charSequence = indicatorViewController.errorViewContentDescription;
                indicatorViewController.errorViewContentDescription = charSequence;
                AppCompatTextView appCompatTextView4 = indicatorViewController.errorView;
                if (appCompatTextView4 != null) {
                    appCompatTextView4.setContentDescription(charSequence);
                }
                int i2 = indicatorViewController.errorViewAccessibilityLiveRegion;
                indicatorViewController.errorViewAccessibilityLiveRegion = i2;
                AppCompatTextView appCompatTextView5 = indicatorViewController.errorView;
                if (appCompatTextView5 != null) {
                    appCompatTextView5.setAccessibilityLiveRegion(i2);
                }
                indicatorViewController.errorView.setVisibility(4);
                indicatorViewController.addIndicator(indicatorViewController.errorView, 0);
            } else {
                indicatorViewController.hideError();
                indicatorViewController.removeIndicator(indicatorViewController.errorView, 0);
                indicatorViewController.errorView = null;
                textInputLayout.updateEditTextBackground();
                textInputLayout.updateTextInputBoxState();
            }
            indicatorViewController.errorEnabled = z;
        }
    }

    public void setErrorIconDrawable(int i) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        endCompoundLayout.setErrorIconDrawable(i != 0 ? BundleKt.getDrawable(endCompoundLayout.getContext(), i) : null);
        LazyKt__LazyJVMKt.refreshIconDrawableState(endCompoundLayout.textInputLayout, endCompoundLayout.errorIconView, endCompoundLayout.errorIconTintList);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        CheckableImageButton checkableImageButton = endCompoundLayout.errorIconView;
        View.OnLongClickListener onLongClickListener = endCompoundLayout.errorIconOnLongClickListener;
        checkableImageButton.setOnClickListener(onClickListener);
        LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        endCompoundLayout.errorIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = endCompoundLayout.errorIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        if (endCompoundLayout.errorIconTintList != colorStateList) {
            endCompoundLayout.errorIconTintList = colorStateList;
            LazyKt__LazyJVMKt.applyIconTint(endCompoundLayout.textInputLayout, endCompoundLayout.errorIconView, colorStateList, endCompoundLayout.errorIconTintMode);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        if (endCompoundLayout.errorIconTintMode != mode) {
            endCompoundLayout.errorIconTintMode = mode;
            LazyKt__LazyJVMKt.applyIconTint(endCompoundLayout.textInputLayout, endCompoundLayout.errorIconView, endCompoundLayout.errorIconTintList, mode);
        }
    }

    public void setErrorTextAppearance(int i) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.errorTextAppearance = i;
        AppCompatTextView appCompatTextView = indicatorViewController.errorView;
        if (appCompatTextView != null) {
            indicatorViewController.textInputView.setTextAppearanceCompatWithErrorFallback(appCompatTextView, i);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.errorViewTextColor = colorStateList;
        AppCompatTextView appCompatTextView = indicatorViewController.errorView;
        if (appCompatTextView != null && colorStateList != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z) {
        if (this.expandedHintEnabled != z) {
            this.expandedHintEnabled = z;
            updateLabelState(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        boolean isEmpty = TextUtils.isEmpty(charSequence);
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (!isEmpty) {
            if (!indicatorViewController.helperTextEnabled) {
                setHelperTextEnabled(true);
            }
            indicatorViewController.cancelCaptionAnimator();
            indicatorViewController.helperText = charSequence;
            indicatorViewController.helperTextView.setText(charSequence);
            int i = indicatorViewController.captionDisplayed;
            if (i != 2) {
                indicatorViewController.captionToShow = 2;
            }
            indicatorViewController.updateCaptionViewsVisibility(i, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.helperTextView, charSequence));
        } else if (indicatorViewController.helperTextEnabled) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.helperTextViewTextColor = colorStateList;
        AppCompatTextView appCompatTextView = indicatorViewController.helperTextView;
        if (appCompatTextView != null && colorStateList != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z) {
        final IndicatorViewController indicatorViewController = this.indicatorViewController;
        TextInputLayout textInputLayout = indicatorViewController.textInputView;
        if (indicatorViewController.helperTextEnabled != z) {
            indicatorViewController.cancelCaptionAnimator();
            if (z) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(indicatorViewController.context, null);
                indicatorViewController.helperTextView = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_helper_text);
                indicatorViewController.helperTextView.setTextAlignment(5);
                Typeface typeface = indicatorViewController.typeface;
                if (typeface != null) {
                    indicatorViewController.helperTextView.setTypeface(typeface);
                }
                indicatorViewController.helperTextView.setVisibility(4);
                indicatorViewController.helperTextView.setAccessibilityLiveRegion(1);
                int i = indicatorViewController.helperTextTextAppearance;
                indicatorViewController.helperTextTextAppearance = i;
                AppCompatTextView appCompatTextView2 = indicatorViewController.helperTextView;
                if (appCompatTextView2 != null) {
                    TextViewCompat.setTextAppearance(appCompatTextView2, i);
                }
                ColorStateList colorStateList = indicatorViewController.helperTextViewTextColor;
                indicatorViewController.helperTextViewTextColor = colorStateList;
                AppCompatTextView appCompatTextView3 = indicatorViewController.helperTextView;
                if (!(appCompatTextView3 == null || colorStateList == null)) {
                    appCompatTextView3.setTextColor(colorStateList);
                }
                indicatorViewController.addIndicator(indicatorViewController.helperTextView, 1);
                indicatorViewController.helperTextView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.google.android.material.textfield.IndicatorViewController.2
                    @Override // android.view.View.AccessibilityDelegate
                    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                        EditText editText = IndicatorViewController.this.textInputView.getEditText();
                        if (editText != null) {
                            accessibilityNodeInfo.setLabeledBy(editText);
                        }
                    }
                });
            } else {
                indicatorViewController.cancelCaptionAnimator();
                int i2 = indicatorViewController.captionDisplayed;
                if (i2 == 2) {
                    indicatorViewController.captionToShow = 0;
                }
                indicatorViewController.updateCaptionViewsVisibility(i2, indicatorViewController.captionToShow, indicatorViewController.shouldAnimateCaptionView(indicatorViewController.helperTextView, ""));
                indicatorViewController.removeIndicator(indicatorViewController.helperTextView, 1);
                indicatorViewController.helperTextView = null;
                textInputLayout.updateEditTextBackground();
                textInputLayout.updateTextInputBoxState();
            }
            indicatorViewController.helperTextEnabled = z;
        }
    }

    public void setHelperTextTextAppearance(int i) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        indicatorViewController.helperTextTextAppearance = i;
        AppCompatTextView appCompatTextView = indicatorViewController.helperTextView;
        if (appCompatTextView != null) {
            TextViewCompat.setTextAppearance(appCompatTextView, i);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (!z) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.editText.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public void setHintMaxLines(int i) {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (i != collapsingTextHelper.collapsedMaxLines) {
            collapsingTextHelper.collapsedMaxLines = i;
            collapsingTextHelper.recalculate(false);
        }
        if (i != collapsingTextHelper.expandedMaxLines) {
            collapsingTextHelper.expandedMaxLines = i;
            collapsingTextHelper.recalculate(false);
        }
        requestLayout();
    }

    public void setHintTextAppearance(int i) {
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        TextInputLayout textInputLayout = collapsingTextHelper.view;
        TextAppearance textAppearance = new TextAppearance(textInputLayout.getContext(), i);
        ColorStateList colorStateList = textAppearance.textColor;
        if (colorStateList != null) {
            collapsingTextHelper.collapsedTextColor = colorStateList;
        }
        float f = textAppearance.textSize;
        if (f != 0.0f) {
            collapsingTextHelper.collapsedTextSize = f;
        }
        ColorStateList colorStateList2 = textAppearance.shadowColor;
        if (colorStateList2 != null) {
            collapsingTextHelper.collapsedShadowColor = colorStateList2;
        }
        collapsingTextHelper.collapsedShadowDx = textAppearance.shadowDx;
        collapsingTextHelper.collapsedShadowDy = textAppearance.shadowDy;
        collapsingTextHelper.collapsedShadowRadius = textAppearance.shadowRadius;
        collapsingTextHelper.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = collapsingTextHelper.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancelled = true;
        }
        ReadonlyStateFlow readonlyStateFlow = new ReadonlyStateFlow(collapsingTextHelper);
        textAppearance.createFallbackFont();
        collapsingTextHelper.collapsedFontCallback = new CancelableFontCallback(readonlyStateFlow, textAppearance.font);
        textAppearance.getFontAsync(textInputLayout.getContext(), collapsingTextHelper.collapsedFontCallback);
        collapsingTextHelper.recalculate(false);
        this.focusedTextColor = collapsingTextHelper.collapsedTextColor;
        if (this.editText != null) {
            updateLabelState(false, false);
            updateInputLayoutMargins();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.focusedTextColor != colorStateList) {
            if (this.defaultHintTextColor == null) {
                CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
                if (collapsingTextHelper.collapsedTextColor != colorStateList) {
                    collapsingTextHelper.collapsedTextColor = colorStateList;
                    collapsingTextHelper.recalculate(false);
                }
            }
            this.focusedTextColor = colorStateList;
            if (this.editText != null) {
                updateLabelState(false, false);
            }
        }
    }

    public void setLengthCounter(LengthCounter lengthCounter) {
        this.lengthCounter = lengthCounter;
    }

    public void setMaxEms(int i) {
        this.maxEms = i;
        EditText editText = this.editText;
        if (editText != null && i != -1) {
            editText.setMaxEms(i);
        }
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
        EditText editText = this.editText;
        if (editText != null && i != -1) {
            editText.setMaxWidth(i);
        }
    }

    public void setMaxWidthResource(int i) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    public void setMinEms(int i) {
        this.minEms = i;
        EditText editText = this.editText;
        if (editText != null && i != -1) {
            editText.setMinEms(i);
        }
    }

    public void setMinWidth(int i) {
        this.minWidth = i;
        EditText editText = this.editText;
        if (editText != null && i != -1) {
            editText.setMinWidth(i);
        }
    }

    public void setMinWidthResource(int i) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        endCompoundLayout.endIconView.setContentDescription(i != 0 ? endCompoundLayout.getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        endCompoundLayout.endIconView.setImageDrawable(i != 0 ? BundleKt.getDrawable(endCompoundLayout.getContext(), i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        if (z && endCompoundLayout.endIconMode != 1) {
            endCompoundLayout.setEndIconMode(1);
        } else if (!z) {
            endCompoundLayout.setEndIconMode(0);
        } else {
            endCompoundLayout.getClass();
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        endCompoundLayout.endIconTintList = colorStateList;
        LazyKt__LazyJVMKt.applyIconTint(endCompoundLayout.textInputLayout, endCompoundLayout.endIconView, colorStateList, endCompoundLayout.endIconTintMode);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        endCompoundLayout.endIconTintMode = mode;
        LazyKt__LazyJVMKt.applyIconTint(endCompoundLayout.textInputLayout, endCompoundLayout.endIconView, endCompoundLayout.endIconTintList, mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        Editable editable = null;
        if (this.placeholderTextView == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null);
            this.placeholderTextView = appCompatTextView;
            appCompatTextView.setId(R.id.textinput_placeholder);
            this.placeholderTextView.setImportantForAccessibility(1);
            this.placeholderTextView.setAccessibilityLiveRegion(1);
            Fade createPlaceholderFadeTransition = createPlaceholderFadeTransition();
            this.placeholderFadeIn = createPlaceholderFadeTransition;
            createPlaceholderFadeTransition.mStartDelay = 67L;
            this.placeholderFadeOut = createPlaceholderFadeTransition();
            setPlaceholderTextAppearance(this.placeholderTextAppearance);
            setPlaceholderTextColor(this.placeholderTextColor);
            ViewCompat.setAccessibilityDelegate(this.placeholderTextView, new AnonymousClass2(0));
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.placeholderEnabled) {
                setPlaceholderTextEnabled(true);
            }
            this.placeholderText = charSequence;
        }
        EditText editText = this.editText;
        if (editText != null) {
            editable = editText.getText();
        }
        updatePlaceholderText(editable);
    }

    public void setPlaceholderTextAppearance(int i) {
        this.placeholderTextAppearance = i;
        AppCompatTextView appCompatTextView = this.placeholderTextView;
        if (appCompatTextView != null) {
            TextViewCompat.setTextAppearance(appCompatTextView, i);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.placeholderTextColor != colorStateList) {
            this.placeholderTextColor = colorStateList;
            AppCompatTextView appCompatTextView = this.placeholderTextView;
            if (appCompatTextView != null && colorStateList != null) {
                appCompatTextView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        CharSequence charSequence2;
        StartCompoundLayout startCompoundLayout = this.startLayout;
        startCompoundLayout.getClass();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        startCompoundLayout.prefixText = charSequence2;
        startCompoundLayout.prefixTextView.setText(charSequence);
        startCompoundLayout.updateVisibility();
    }

    public void setPrefixTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.startLayout.prefixTextView, i);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.startLayout.prefixTextView.setTextColor(colorStateList);
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = this.boxBackground;
        if (materialShapeDrawable != null && materialShapeDrawable.drawableState.shapeAppearanceModel != shapeAppearanceModel) {
            this.shapeAppearanceModel = shapeAppearanceModel;
            applyBoxAttributes();
        }
    }

    public void setStartIconCheckable(boolean z) {
        this.startLayout.startIconView.setCheckable(z);
    }

    public void setStartIconContentDescription(int i) {
        setStartIconContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setStartIconDrawable(int i) {
        setStartIconDrawable(i != 0 ? BundleKt.getDrawable(getContext(), i) : null);
    }

    public void setStartIconMinSize(int i) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        if (i < 0) {
            startCompoundLayout.getClass();
            throw new IllegalArgumentException("startIconSize cannot be less than 0");
        } else if (i != startCompoundLayout.startIconMinSize) {
            startCompoundLayout.startIconMinSize = i;
            CheckableImageButton checkableImageButton = startCompoundLayout.startIconView;
            checkableImageButton.setMinimumWidth(i);
            checkableImageButton.setMinimumHeight(i);
        }
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        CheckableImageButton checkableImageButton = startCompoundLayout.startIconView;
        View.OnLongClickListener onLongClickListener = startCompoundLayout.startIconOnLongClickListener;
        checkableImageButton.setOnClickListener(onClickListener);
        LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        startCompoundLayout.startIconOnLongClickListener = onLongClickListener;
        CheckableImageButton checkableImageButton = startCompoundLayout.startIconView;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        LazyKt__LazyJVMKt.setIconClickable(checkableImageButton, onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        startCompoundLayout.startIconScaleType = scaleType;
        startCompoundLayout.startIconView.setScaleType(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        if (startCompoundLayout.startIconTintList != colorStateList) {
            startCompoundLayout.startIconTintList = colorStateList;
            LazyKt__LazyJVMKt.applyIconTint(startCompoundLayout.textInputLayout, startCompoundLayout.startIconView, colorStateList, startCompoundLayout.startIconTintMode);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        StartCompoundLayout startCompoundLayout = this.startLayout;
        if (startCompoundLayout.startIconTintMode != mode) {
            startCompoundLayout.startIconTintMode = mode;
            LazyKt__LazyJVMKt.applyIconTint(startCompoundLayout.textInputLayout, startCompoundLayout.startIconView, startCompoundLayout.startIconTintList, mode);
        }
    }

    public void setStartIconVisible(boolean z) {
        this.startLayout.setStartIconVisible(z);
    }

    public void setSuffixText(CharSequence charSequence) {
        CharSequence charSequence2;
        EndCompoundLayout endCompoundLayout = this.endLayout;
        endCompoundLayout.getClass();
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = null;
        } else {
            charSequence2 = charSequence;
        }
        endCompoundLayout.suffixText = charSequence2;
        endCompoundLayout.suffixTextView.setText(charSequence);
        endCompoundLayout.updateSuffixTextVisibility();
    }

    public void setSuffixTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.endLayout.suffixTextView, i);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.endLayout.suffixTextView.setTextColor(colorStateList);
    }

    public final void setTextAppearanceCompatWithErrorFallback(AppCompatTextView appCompatTextView, int i) {
        try {
            TextViewCompat.setTextAppearance(appCompatTextView, i);
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (appCompatTextView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
            TextViewCompat.setTextAppearance(appCompatTextView, 2132083182);
            appCompatTextView.setTextColor(BundleKt.getColor(getContext(), R.color.design_error));
        }
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.editText;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.typeface) {
            this.typeface = typeface;
            this.collapsingTextHelper.setTypefaces(typeface);
            IndicatorViewController indicatorViewController = this.indicatorViewController;
            if (typeface != indicatorViewController.typeface) {
                indicatorViewController.typeface = typeface;
                AppCompatTextView appCompatTextView = indicatorViewController.errorView;
                if (appCompatTextView != null) {
                    appCompatTextView.setTypeface(typeface);
                }
                AppCompatTextView appCompatTextView2 = indicatorViewController.helperTextView;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTypeface(typeface);
                }
            }
            AppCompatTextView appCompatTextView3 = this.counterView;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setTypeface(typeface);
            }
        }
    }

    public final boolean shouldShowError() {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        if (indicatorViewController.captionToShow != 1 || indicatorViewController.errorView == null || TextUtils.isEmpty(indicatorViewController.errorText)) {
            return false;
        }
        return true;
    }

    public final void updateCounter(Editable editable) {
        int i;
        boolean z;
        int i2;
        BidiFormatter bidiFormatter;
        ((TransportImpl$$ExternalSyntheticLambda0) this.lengthCounter).getClass();
        if (editable != null) {
            i = editable.length();
        } else {
            i = 0;
        }
        boolean z2 = this.counterOverflowed;
        int i3 = this.counterMaxLength;
        String str = null;
        if (i3 == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            if (i > i3) {
                z = true;
            } else {
                z = false;
            }
            this.counterOverflowed = z;
            Context context = getContext();
            AppCompatTextView appCompatTextView = this.counterView;
            int i4 = this.counterMaxLength;
            if (this.counterOverflowed) {
                i2 = R.string.character_counter_overflowed_content_description;
            } else {
                i2 = R.string.character_counter_content_description;
            }
            appCompatTextView.setContentDescription(context.getString(i2, Integer.valueOf(i), Integer.valueOf(i4)));
            if (z2 != this.counterOverflowed) {
                updateCounterTextAppearanceAndColor();
            }
            String str2 = BidiFormatter.LRM_STRING;
            if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                bidiFormatter = BidiFormatter.DEFAULT_RTL_INSTANCE;
            } else {
                bidiFormatter = BidiFormatter.DEFAULT_LTR_INSTANCE;
            }
            AppCompatTextView appCompatTextView2 = this.counterView;
            String string = getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.counterMaxLength));
            bidiFormatter.getClass();
            zzcn zzcnVar = TextDirectionHeuristicsCompat.LTR;
            if (string != null) {
                str = bidiFormatter.unicodeWrap(string).toString();
            }
            appCompatTextView2.setText(str);
        }
        if (this.editText != null && z2 != this.counterOverflowed) {
            updateLabelState(false, false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }

    public final void updateCounterTextAppearanceAndColor() {
        int i;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        AppCompatTextView appCompatTextView = this.counterView;
        if (appCompatTextView != null) {
            if (this.counterOverflowed) {
                i = this.counterOverflowTextAppearance;
            } else {
                i = this.counterTextAppearance;
            }
            setTextAppearanceCompatWithErrorFallback(appCompatTextView, i);
            if (!this.counterOverflowed && (colorStateList2 = this.counterTextColor) != null) {
                this.counterView.setTextColor(colorStateList2);
            }
            if (this.counterOverflowed && (colorStateList = this.counterOverflowTextColor) != null) {
                this.counterView.setTextColor(colorStateList);
            }
        }
    }

    public final void updateCursorColor() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.cursorColor;
        if (colorStateList2 == null) {
            Context context = getContext();
            TypedValue resolve = LazyKt__LazyJVMKt.resolve(context, R.attr.colorControlActivated);
            if (resolve != null) {
                int i = resolve.resourceId;
                if (i != 0) {
                    colorStateList2 = BundleKt.getColorStateList(context, i);
                } else {
                    int i2 = resolve.data;
                    if (i2 != 0) {
                        colorStateList2 = ColorStateList.valueOf(i2);
                    }
                }
            }
            colorStateList2 = null;
        }
        EditText editText = this.editText;
        if (editText != null && editText.getTextCursorDrawable() != null) {
            Drawable mutate = BundleKt.wrap(this.editText.getTextCursorDrawable()).mutate();
            if ((shouldShowError() || (this.counterView != null && this.counterOverflowed)) && (colorStateList = this.cursorErrorColor) != null) {
                colorStateList2 = colorStateList;
            }
            mutate.setTintList(colorStateList2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean updateDummyDrawables() {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.updateDummyDrawables():boolean");
    }

    public final void updateEditTextBackground() {
        Drawable background;
        AppCompatTextView appCompatTextView;
        EditText editText = this.editText;
        if (editText != null && this.boxBackgroundMode == 0 && (background = editText.getBackground()) != null) {
            int[] iArr = DrawableUtils.CHECKED_STATE_SET;
            Drawable mutate = background.mutate();
            if (shouldShowError()) {
                mutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
            } else if (!this.counterOverflowed || (appCompatTextView = this.counterView) == null) {
                BundleKt.clearColorFilter(mutate);
                this.editText.refreshDrawableState();
            } else {
                mutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(appCompatTextView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void updateEditTextBoxBackgroundIfNeeded() {
        EditText editText = this.editText;
        if (editText != null && this.boxBackground != null) {
            if ((this.boxBackgroundApplied || editText.getBackground() == null) && this.boxBackgroundMode != 0) {
                this.editText.setBackground(getEditTextBoxBackground());
                this.boxBackgroundApplied = true;
            }
        }
    }

    public final void updateInputLayoutMargins() {
        if (this.boxBackgroundMode != 1) {
            FrameLayout frameLayout = this.inputFrame;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) frameLayout.getLayoutParams();
            int calculateLabelMarginTop = calculateLabelMarginTop();
            if (calculateLabelMarginTop != layoutParams.topMargin) {
                layoutParams.topMargin = calculateLabelMarginTop;
                frameLayout.requestLayout();
            }
        }
    }

    public final void updateLabelState(boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        ColorStateList colorStateList;
        AppCompatTextView appCompatTextView;
        ColorStateList colorStateList2;
        int i;
        boolean isEnabled = isEnabled();
        EditText editText = this.editText;
        if (editText == null || TextUtils.isEmpty(editText.getText())) {
            z3 = false;
        } else {
            z3 = true;
        }
        EditText editText2 = this.editText;
        if (editText2 == null || !editText2.hasFocus()) {
            z4 = false;
        } else {
            z4 = true;
        }
        ColorStateList colorStateList3 = this.defaultHintTextColor;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        if (colorStateList3 != null) {
            collapsingTextHelper.setCollapsedAndExpandedTextColor(colorStateList3);
        }
        Editable editable = null;
        if (!isEnabled) {
            ColorStateList colorStateList4 = this.defaultHintTextColor;
            if (colorStateList4 != null) {
                i = colorStateList4.getColorForState(new int[]{-16842910}, this.disabledColor);
            } else {
                i = this.disabledColor;
            }
            collapsingTextHelper.setCollapsedAndExpandedTextColor(ColorStateList.valueOf(i));
        } else if (shouldShowError()) {
            AppCompatTextView appCompatTextView2 = this.indicatorViewController.errorView;
            if (appCompatTextView2 != null) {
                colorStateList2 = appCompatTextView2.getTextColors();
            } else {
                colorStateList2 = null;
            }
            collapsingTextHelper.setCollapsedAndExpandedTextColor(colorStateList2);
        } else if (this.counterOverflowed && (appCompatTextView = this.counterView) != null) {
            collapsingTextHelper.setCollapsedAndExpandedTextColor(appCompatTextView.getTextColors());
        } else if (!(!z4 || (colorStateList = this.focusedTextColor) == null || collapsingTextHelper.collapsedTextColor == colorStateList)) {
            collapsingTextHelper.collapsedTextColor = colorStateList;
            collapsingTextHelper.recalculate(false);
        }
        EndCompoundLayout endCompoundLayout = this.endLayout;
        StartCompoundLayout startCompoundLayout = this.startLayout;
        if (z3 || !this.expandedHintEnabled || (isEnabled() && z4)) {
            if (z2 || this.hintExpanded) {
                ValueAnimator valueAnimator = this.animator;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.animator.cancel();
                }
                if (!z || !this.hintAnimationEnabled) {
                    collapsingTextHelper.setExpansionFraction(1.0f);
                } else {
                    animateToExpansionFraction(1.0f);
                }
                this.hintExpanded = false;
                if (cutoutEnabled()) {
                    openCutout();
                }
                EditText editText3 = this.editText;
                if (editText3 != null) {
                    editable = editText3.getText();
                }
                updatePlaceholderText(editable);
                startCompoundLayout.hintExpanded = false;
                startCompoundLayout.updateVisibility();
                endCompoundLayout.hintExpanded = false;
                endCompoundLayout.updateSuffixTextVisibility();
            }
        } else if (z2 || !this.hintExpanded) {
            ValueAnimator valueAnimator2 = this.animator;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.animator.cancel();
            }
            if (!z || !this.hintAnimationEnabled) {
                collapsingTextHelper.setExpansionFraction(0.0f);
            } else {
                animateToExpansionFraction(0.0f);
            }
            if (cutoutEnabled() && !((CutoutDrawable) this.boxBackground).drawableState.cutoutBounds.isEmpty() && cutoutEnabled()) {
                ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.hintExpanded = true;
            AppCompatTextView appCompatTextView3 = this.placeholderTextView;
            if (appCompatTextView3 != null && this.placeholderEnabled) {
                appCompatTextView3.setText((CharSequence) null);
                TransitionManager.beginDelayedTransition(this.inputFrame, this.placeholderFadeOut);
                this.placeholderTextView.setVisibility(4);
            }
            startCompoundLayout.hintExpanded = true;
            startCompoundLayout.updateVisibility();
            endCompoundLayout.hintExpanded = true;
            endCompoundLayout.updateSuffixTextVisibility();
        }
    }

    public final void updatePlaceholderText(Editable editable) {
        int i;
        ((TransportImpl$$ExternalSyntheticLambda0) this.lengthCounter).getClass();
        if (editable != null) {
            i = editable.length();
        } else {
            i = 0;
        }
        FrameLayout frameLayout = this.inputFrame;
        if (i != 0 || this.hintExpanded) {
            AppCompatTextView appCompatTextView = this.placeholderTextView;
            if (appCompatTextView != null && this.placeholderEnabled) {
                appCompatTextView.setText((CharSequence) null);
                TransitionManager.beginDelayedTransition(frameLayout, this.placeholderFadeOut);
                this.placeholderTextView.setVisibility(4);
            }
        } else if (this.placeholderTextView != null && this.placeholderEnabled && !TextUtils.isEmpty(this.placeholderText)) {
            this.placeholderTextView.setText(this.placeholderText);
            TransitionManager.beginDelayedTransition(frameLayout, this.placeholderFadeIn);
            this.placeholderTextView.setVisibility(0);
            this.placeholderTextView.bringToFront();
        }
    }

    public final void updateStrokeErrorColor(boolean z, boolean z2) {
        int defaultColor = this.strokeErrorColor.getDefaultColor();
        int colorForState = this.strokeErrorColor.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.strokeErrorColor.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.boxStrokeColor = colorForState2;
        } else if (z2) {
            this.boxStrokeColor = colorForState;
        } else {
            this.boxStrokeColor = defaultColor;
        }
    }

    public final void updateTextInputBoxState() {
        boolean z;
        AppCompatTextView appCompatTextView;
        EditText editText;
        EditText editText2;
        if (this.boxBackground != null && this.boxBackgroundMode != 0) {
            boolean z2 = false;
            if (isFocused() || ((editText2 = this.editText) != null && editText2.hasFocus())) {
                z = true;
            } else {
                z = false;
            }
            if (isHovered() || ((editText = this.editText) != null && editText.isHovered())) {
                z2 = true;
            }
            if (!isEnabled()) {
                this.boxStrokeColor = this.disabledColor;
            } else if (shouldShowError()) {
                if (this.strokeErrorColor != null) {
                    updateStrokeErrorColor(z, z2);
                } else {
                    this.boxStrokeColor = getErrorCurrentTextColors();
                }
            } else if (!this.counterOverflowed || (appCompatTextView = this.counterView) == null) {
                if (z) {
                    this.boxStrokeColor = this.focusedStrokeColor;
                } else if (z2) {
                    this.boxStrokeColor = this.hoveredStrokeColor;
                } else {
                    this.boxStrokeColor = this.defaultStrokeColor;
                }
            } else if (this.strokeErrorColor != null) {
                updateStrokeErrorColor(z, z2);
            } else {
                this.boxStrokeColor = appCompatTextView.getCurrentTextColor();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                updateCursorColor();
            }
            EndCompoundLayout endCompoundLayout = this.endLayout;
            TextInputLayout textInputLayout = endCompoundLayout.textInputLayout;
            CheckableImageButton checkableImageButton = endCompoundLayout.endIconView;
            TextInputLayout textInputLayout2 = endCompoundLayout.textInputLayout;
            endCompoundLayout.updateErrorIconVisibility();
            LazyKt__LazyJVMKt.refreshIconDrawableState(textInputLayout2, endCompoundLayout.errorIconView, endCompoundLayout.errorIconTintList);
            LazyKt__LazyJVMKt.refreshIconDrawableState(textInputLayout2, checkableImageButton, endCompoundLayout.endIconTintList);
            if (endCompoundLayout.getEndIconDelegate() instanceof DropdownMenuEndIconDelegate) {
                if (!textInputLayout.shouldShowError() || checkableImageButton.getDrawable() == null) {
                    LazyKt__LazyJVMKt.applyIconTint(textInputLayout, checkableImageButton, endCompoundLayout.endIconTintList, endCompoundLayout.endIconTintMode);
                } else {
                    Drawable mutate = BundleKt.wrap(checkableImageButton.getDrawable()).mutate();
                    mutate.setTint(textInputLayout.getErrorCurrentTextColors());
                    checkableImageButton.setImageDrawable(mutate);
                }
            }
            StartCompoundLayout startCompoundLayout = this.startLayout;
            LazyKt__LazyJVMKt.refreshIconDrawableState(startCompoundLayout.textInputLayout, startCompoundLayout.startIconView, startCompoundLayout.startIconTintList);
            if (this.boxBackgroundMode == 2) {
                int i = this.boxStrokeWidthPx;
                if (!z || !isEnabled()) {
                    this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
                } else {
                    this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
                }
                if (this.boxStrokeWidthPx != i && cutoutEnabled() && !this.hintExpanded) {
                    if (cutoutEnabled()) {
                        ((CutoutDrawable) this.boxBackground).setCutout(0.0f, 0.0f, 0.0f, 0.0f);
                    }
                    openCutout();
                }
            }
            if (this.boxBackgroundMode == 1) {
                if (!isEnabled()) {
                    this.boxBackgroundColor = this.disabledFilledBackgroundColor;
                } else if (z2 && !z) {
                    this.boxBackgroundColor = this.hoveredFilledBackgroundColor;
                } else if (z) {
                    this.boxBackgroundColor = this.focusedFilledBackgroundColor;
                } else {
                    this.boxBackgroundColor = this.defaultFilledBackgroundColor;
                }
            }
            applyBoxAttributes();
        }
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.startLayout.startIconView;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.startLayout.setStartIconDrawable(drawable);
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.endLayout.endIconView.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.endLayout.endIconView.setImageDrawable(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.endLayout.setErrorIconDrawable(drawable);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        CheckableImageButton checkableImageButton = this.endLayout.endIconView;
        if (checkableImageButton.getContentDescription() != charSequence) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        EndCompoundLayout endCompoundLayout = this.endLayout;
        TextInputLayout textInputLayout = endCompoundLayout.textInputLayout;
        CheckableImageButton checkableImageButton = endCompoundLayout.endIconView;
        checkableImageButton.setImageDrawable(drawable);
        if (drawable != null) {
            LazyKt__LazyJVMKt.applyIconTint(textInputLayout, checkableImageButton, endCompoundLayout.endIconTintList, endCompoundLayout.endIconTintMode);
            LazyKt__LazyJVMKt.refreshIconDrawableState(textInputLayout, checkableImageButton, endCompoundLayout.endIconTintList);
        }
    }
}
