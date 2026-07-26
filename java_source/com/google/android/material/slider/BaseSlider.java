package com.google.android.material.slider;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import androidx.constraintlayout.core.SolverVariable$Type$EnumUnboxingSharedUtility;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.graphics.ColorUtils;
import androidx.core.p002os.BundleKt;
import androidx.core.provider.CallbackWithHandler$2;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import androidx.transition.Transition;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.fragments.HttpLogFragment$$ExternalSyntheticLambda14;
import com.google.android.gms.common.zzc;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.WeakHashMap;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public abstract class BaseSlider extends View {
    public static final /* synthetic */ int $r8$clinit = 0;
    public CallbackWithHandler$2 accessibilityEventSender;
    public final AccessibilityHelper accessibilityHelper;
    public final AccessibilityManager accessibilityManager;
    public final Paint activeTicksPaint;
    public Drawable customThumbDrawable;
    public final MaterialShapeDrawable defaultThumbDrawable;
    public final int defaultThumbRadius;
    public final int defaultTickActiveRadius;
    public final int defaultTickInactiveRadius;
    public final int defaultTrackThickness;
    public boolean dirtyConfig;
    public LabelFormatter formatter;
    public ColorStateList haloColor;
    public final Paint haloPaint;
    public int haloRadius;
    public final Paint inactiveTicksPaint;
    public int labelBehavior;
    public final int labelPadding;
    public final int labelStyle;
    public ValueAnimator labelsInAnimator;
    public ValueAnimator labelsOutAnimator;
    public MotionEvent lastEvent;
    public final int minTickSpacing;
    public final int minTouchTargetSize;
    public final int minTrackSidePadding;
    public final int minWidgetThickness;
    public final BaseSlider$$ExternalSyntheticLambda2 onGlobalLayoutListener;
    public final BaseSlider$$ExternalSyntheticLambda1 onScrollChangedListener;
    public final ActivityCompat$$ExternalSyntheticLambda0 resetActiveThumbIndex;
    public final int scaledTouchSlop;
    public float stepSize;
    public final Paint stopIndicatorPaint;
    public int thumbHeight;
    public final Paint thumbPaint;
    public int thumbTrackGapSize;
    public int thumbWidth;
    public int tickActiveRadius;
    public ColorStateList tickColorActive;
    public ColorStateList tickColorInactive;
    public int tickInactiveRadius;
    public int tickVisibilityMode;
    public float[] ticksCoordinates;
    public final int tooltipTimeoutMillis;
    public float touchDownAxis1;
    public float touchDownAxis2;
    public float touchPosition;
    public ColorStateList trackColorActive;
    public ColorStateList trackColorInactive;
    public int trackCornerSize;
    public ColorStateList trackIconActiveColor;
    public Drawable trackIconActiveEnd;
    public Drawable trackIconActiveStart;
    public ColorStateList trackIconInactiveColor;
    public Drawable trackIconInactiveEnd;
    public Drawable trackIconInactiveStart;
    public final int trackIconPadding;
    public int trackIconSize;
    public int trackInsideCornerSize;
    public int trackSidePadding;
    public int trackStopIndicatorSize;
    public int trackThickness;
    public int trackWidth;
    public float valueFrom;
    public float valueTo;
    public int widgetOrientation;
    public int widgetThickness;
    public final ArrayList labels = new ArrayList();
    public final ArrayList changeListeners = new ArrayList();
    public final ArrayList touchListeners = new ArrayList();
    public boolean labelsAreAnimatedIn = false;
    public int defaultThumbWidth = -1;
    public int defaultThumbTrackGapSize = -1;
    public boolean centered = false;
    public boolean trackIconActiveStartMutated = false;
    public boolean trackIconActiveEndMutated = false;
    public boolean trackIconInactiveStartMutated = false;
    public boolean trackIconInactiveEndMutated = false;
    public boolean thumbIsPressed = false;
    public ArrayList values = new ArrayList();
    public int activeThumbIdx = -1;
    public int focusedThumbIdx = -1;
    public boolean isLongPress = false;
    public final Path trackPath = new Path();
    public final RectF activeTrackRect = new RectF();
    public final RectF inactiveTrackLeftRect = new RectF();
    public final RectF inactiveTrackRightRect = new RectF();
    public final RectF cornerRect = new RectF();
    public final Rect labelRect = new Rect();
    public final RectF iconRectF = new RectF();
    public final Rect iconRect = new Rect();
    public final Matrix rotationMatrix = new Matrix();
    public List customThumbDrawablesForValues = Collections.EMPTY_LIST;
    public int separationUnit = 0;
    public boolean thisAndAncestorsVisible = isShown();
    public final Paint inactiveTrackPaint = new Paint();
    public final Paint activeTrackPaint = new Paint();

    /* loaded from: classes.dex */
    public final class AccessibilityHelper extends ExploreByTouchHelper {
        public final Slider slider;
        public final Rect virtualViewBounds = new Rect();

        public AccessibilityHelper(Slider slider) {
            super(slider);
            this.slider = slider;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final int getVirtualViewAt(float f, float f2) {
            int i = 0;
            while (true) {
                Slider slider = this.slider;
                if (i >= slider.getValues().size()) {
                    return -1;
                }
                Rect rect = this.virtualViewBounds;
                slider.updateBoundsForVirtualViewId(i, rect);
                if (rect.contains((int) f, (int) f2)) {
                    return i;
                }
                i++;
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final void getVisibleVirtualViews(ArrayList arrayList) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                arrayList.add(Integer.valueOf(i));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            float f;
            float f2;
            Slider slider = this.slider;
            if (!slider.isEnabled()) {
                return false;
            }
            if (i2 == 4096 || i2 == 8192) {
                float f3 = slider.stepSize;
                if (f3 == 0.0f) {
                    f3 = 1.0f;
                }
                if ((slider.valueTo - slider.valueFrom) / f3 > 20) {
                    f3 *= Math.round(f / f2);
                }
                if (i2 == 8192) {
                    f3 = -f3;
                }
                if (slider.isRtl()) {
                    f3 = -f3;
                }
                if (!slider.snapThumbToValue(i, BundleKt.clamp(slider.getValues().get(i).floatValue() + f3, slider.getValueFrom(), slider.getValueTo()))) {
                    return false;
                }
                slider.setActiveThumbIndex(i);
                ActivityCompat$$ExternalSyntheticLambda0 activityCompat$$ExternalSyntheticLambda0 = slider.resetActiveThumbIndex;
                slider.removeCallbacks(activityCompat$$ExternalSyntheticLambda0);
                slider.postDelayed(activityCompat$$ExternalSyntheticLambda0, slider.tooltipTimeoutMillis);
                slider.updateHaloHotspot();
                slider.postInvalidate();
                invalidateVirtualView(i);
                return true;
            } else if (i2 != 16908349 || bundle == null || !bundle.containsKey("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE") || !slider.snapThumbToValue(i, bundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"))) {
                return false;
            } else {
                slider.updateHaloHotspot();
                slider.postInvalidate();
                invalidateVirtualView(i);
                return true;
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public final void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Object obj;
            String str;
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            Slider slider = this.slider;
            List<Float> values = slider.getValues();
            Float f = values.get(i);
            float floatValue = f.floatValue();
            float valueFrom = slider.getValueFrom();
            float valueTo = slider.getValueTo();
            if (slider.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(CaptureService.CONNECTIONS_LOG_SIZE);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            NumberFormat numberInstance = NumberFormat.getNumberInstance();
            numberInstance.setMaximumFractionDigits(2);
            try {
                valueFrom = numberInstance.parse(numberInstance.format(valueFrom)).floatValue();
                valueTo = numberInstance.parse(numberInstance.format(valueTo)).floatValue();
                floatValue = numberInstance.parse(numberInstance.format(floatValue)).floatValue();
            } catch (ParseException unused) {
                int i2 = BaseSlider.$r8$clinit;
                Log.w("BaseSlider", "Error parsing value(" + f + "), valueFrom(" + valueFrom + "), and valueTo(" + valueTo + ") into a float.");
            }
            accessibilityNodeInfo.setRangeInfo(AccessibilityNodeInfo.RangeInfo.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (slider.getContentDescription() != null) {
                sb.append(slider.getContentDescription());
                sb.append(",");
            }
            String formatValue = slider.formatValue(floatValue);
            String string = slider.getContext().getString(C0130R.string.material_slider_value);
            if (values.size() > 1) {
                if (i == slider.getValues().size() - 1) {
                    str = slider.getContext().getString(C0130R.string.material_slider_range_end);
                } else if (i == 0) {
                    str = slider.getContext().getString(C0130R.string.material_slider_range_start);
                } else {
                    str = "";
                }
                string = str;
            }
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30) {
                obj = ViewCompat.Api30Impl.getStateDescription(slider);
            } else {
                obj = slider.getTag(C0130R.C0132id.tag_state_description);
                if (!CharSequence.class.isInstance(obj)) {
                    obj = null;
                }
            }
            CharSequence charSequence = (CharSequence) obj;
            if (TextUtils.isEmpty(charSequence)) {
                Locale.getDefault();
                sb.append(string + ", " + formatValue);
            } else if (i3 >= 30) {
                AccessibilityNodeInfoCompat.Api30Impl.setStateDescription(accessibilityNodeInfo, charSequence);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            Rect rect = this.virtualViewBounds;
            slider.updateBoundsForVirtualViewId(i, rect);
            accessibilityNodeInfo.setBoundsInParent(rect);
        }
    }

    /* loaded from: classes.dex */
    public final class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new zzc(6);
        public boolean hasFocus;
        public float stepSize;
        public float valueFrom;
        public float valueTo;
        public ArrayList values;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [com.google.android.material.slider.BaseSlider$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.google.android.material.slider.BaseSlider$$ExternalSyntheticLambda2] */
    public BaseSlider(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, C0130R.attr.sliderStyle, C0130R.style.Widget_MaterialComponents_Slider), attributeSet, C0130R.attr.sliderStyle);
        int i;
        int i2;
        int i3;
        this.stepSize = 0.0f;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.defaultThumbDrawable = materialShapeDrawable;
        final Slider slider = (Slider) this;
        this.onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.slider.BaseSlider$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                Slider.this.updateLabels();
            }
        };
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.slider.BaseSlider$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Slider.this.updateLabels();
            }
        };
        int i4 = 21;
        this.resetActiveThumbIndex = new ActivityCompat$$ExternalSyntheticLambda0(21, slider);
        Context context2 = getContext();
        Paint paint = new Paint(1);
        this.thumbPaint = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.haloPaint = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.inactiveTicksPaint = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.activeTicksPaint = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.stopIndicatorPaint = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        Resources resources = context2.getResources();
        this.minWidgetThickness = resources.getDimensionPixelSize(C0130R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(C0130R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = dimensionPixelOffset;
        this.trackSidePadding = dimensionPixelOffset;
        this.defaultThumbRadius = resources.getDimensionPixelSize(C0130R.dimen.mtrl_slider_thumb_radius);
        this.defaultTrackThickness = resources.getDimensionPixelSize(C0130R.dimen.mtrl_slider_track_height);
        this.defaultTickActiveRadius = resources.getDimensionPixelSize(C0130R.dimen.mtrl_slider_tick_radius);
        this.defaultTickInactiveRadius = resources.getDimensionPixelSize(C0130R.dimen.mtrl_slider_tick_radius);
        this.minTickSpacing = resources.getDimensionPixelSize(C0130R.dimen.mtrl_slider_tick_min_spacing);
        this.labelPadding = resources.getDimensionPixelSize(C0130R.dimen.mtrl_slider_label_padding);
        this.trackIconPadding = resources.getDimensionPixelOffset(C0130R.dimen.m3_slider_track_icon_padding);
        ViewUtils.checkCompatibleTheme(context2, attributeSet, C0130R.attr.sliderStyle, C0130R.style.Widget_MaterialComponents_Slider);
        int[] iArr = R$styleable.Slider;
        ViewUtils.checkTextAppearance(context2, attributeSet, iArr, C0130R.attr.sliderStyle, C0130R.style.Widget_MaterialComponents_Slider, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, C0130R.attr.sliderStyle, C0130R.style.Widget_MaterialComponents_Slider);
        setOrientation(obtainStyledAttributes.getInt(2, 0));
        this.labelStyle = obtainStyledAttributes.getResourceId(10, C0130R.style.Widget_MaterialComponents_Tooltip);
        this.valueFrom = obtainStyledAttributes.getFloat(4, 0.0f);
        this.valueTo = obtainStyledAttributes.getFloat(5, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        setCentered(obtainStyledAttributes.getBoolean(6, false));
        this.stepSize = obtainStyledAttributes.getFloat(3, 0.0f);
        this.minTouchTargetSize = (int) Math.ceil(obtainStyledAttributes.getDimension(11, LazyKt__LazyJVMKt.resolveMinimumAccessibleTouchTarget(context2)));
        int i5 = 27;
        boolean hasValue = obtainStyledAttributes.hasValue(27);
        if (hasValue) {
            i = 27;
        } else {
            i = 29;
        }
        i5 = !hasValue ? 28 : i5;
        ColorStateList colorStateList = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, i);
        setTrackInactiveTintList(colorStateList == null ? BundleKt.getColorStateList(context2, C0130R.color.material_slider_inactive_track_color) : colorStateList);
        ColorStateList colorStateList2 = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, i5);
        setTrackActiveTintList(colorStateList2 == null ? BundleKt.getColorStateList(context2, C0130R.color.material_slider_active_track_color) : colorStateList2);
        materialShapeDrawable.setFillColor(LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 12));
        if (obtainStyledAttributes.hasValue(16)) {
            setThumbStrokeColor(LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 16));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(17, 0.0f));
        ColorStateList colorStateList3 = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 7);
        setHaloTintList(colorStateList3 == null ? BundleKt.getColorStateList(context2, C0130R.color.material_slider_halo_color) : colorStateList3);
        if (obtainStyledAttributes.hasValue(25)) {
            i2 = obtainStyledAttributes.getInt(25, -1);
        } else if (obtainStyledAttributes.getBoolean(26, true)) {
            i2 = 0;
        } else {
            i2 = 2;
        }
        this.tickVisibilityMode = i2;
        boolean hasValue2 = obtainStyledAttributes.hasValue(20);
        if (hasValue2) {
            i3 = 20;
        } else {
            i3 = 22;
        }
        i4 = hasValue2 ? 20 : i4;
        ColorStateList colorStateList4 = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, i3);
        setTickInactiveTintList(colorStateList4 == null ? BundleKt.getColorStateList(context2, C0130R.color.material_slider_inactive_tick_marks_color) : colorStateList4);
        ColorStateList colorStateList5 = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, i4);
        setTickActiveTintList(colorStateList5 == null ? BundleKt.getColorStateList(context2, C0130R.color.material_slider_active_tick_marks_color) : colorStateList5);
        setThumbTrackGapSize(obtainStyledAttributes.getDimensionPixelSize(18, 0));
        setTrackStopIndicatorSize(obtainStyledAttributes.getDimensionPixelSize(40, 0));
        setTrackCornerSize(obtainStyledAttributes.getDimensionPixelSize(30, -1));
        setTrackInsideCornerSize(obtainStyledAttributes.getDimensionPixelSize(39, 0));
        setTrackIconActiveStart(LazyKt__LazyJVMKt.getDrawable(context2, obtainStyledAttributes, 34));
        setTrackIconActiveEnd(LazyKt__LazyJVMKt.getDrawable(context2, obtainStyledAttributes, 33));
        setTrackIconActiveColor(LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 32));
        setTrackIconInactiveStart(LazyKt__LazyJVMKt.getDrawable(context2, obtainStyledAttributes, 37));
        setTrackIconInactiveEnd(LazyKt__LazyJVMKt.getDrawable(context2, obtainStyledAttributes, 36));
        setTrackIconInactiveColor(LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 35));
        setTrackIconSize(obtainStyledAttributes.getDimensionPixelSize(38, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(15, 0) * 2;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(19, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(14, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(8, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(13, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(31, 0));
        setTickActiveRadius(obtainStyledAttributes.getDimensionPixelSize(23, this.trackStopIndicatorSize / 2));
        setTickInactiveRadius(obtainStyledAttributes.getDimensionPixelSize(24, this.trackStopIndicatorSize / 2));
        setLabelBehavior(obtainStyledAttributes.getInt(9, 0));
        if (!obtainStyledAttributes.getBoolean(0, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode();
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper = new AccessibilityHelper(slider);
        this.accessibilityHelper = accessibilityHelper;
        ViewCompat.setAccessibilityDelegate(this, accessibilityHelper);
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.accessibilityManager = accessibilityManager;
        if (Build.VERSION.SDK_INT >= 29) {
            this.tooltipTimeoutMillis = accessibilityManager.getRecommendedTimeoutMillis(10000, 6);
        } else {
            this.tooltipTimeoutMillis = 120000;
        }
    }

    public final void adjustCustomThumbDrawableBounds(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.thumbWidth, this.thumbHeight);
            return;
        }
        float max = Math.max(this.thumbWidth, this.thumbHeight) / Math.max(intrinsicWidth, intrinsicHeight);
        drawable.setBounds(0, 0, (int) (intrinsicWidth * max), (int) (intrinsicHeight * max));
    }

    public final void calculateBoundsAndDrawTrackIcon(Canvas canvas, RectF rectF, Drawable drawable, boolean z) {
        boolean z2;
        float f;
        if (drawable != null) {
            int i = this.trackIconSize;
            float f2 = rectF.right - rectF.left;
            int i2 = this.trackIconPadding;
            RectF rectF2 = this.iconRectF;
            if (f2 >= (i2 * 2) + i) {
                if (isRtl() || isVertical()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z ^ z2) {
                    f = rectF.left + i2;
                } else {
                    f = (rectF.right - i2) - i;
                }
                float f3 = i;
                float calculateTrackCenter = calculateTrackCenter() - (f3 / 2.0f);
                rectF2.set(f, calculateTrackCenter, f + f3, f3 + calculateTrackCenter);
            } else {
                rectF2.setEmpty();
            }
            if (!rectF2.isEmpty()) {
                if (isVertical()) {
                    this.rotationMatrix.mapRect(rectF2);
                }
                Rect rect = this.iconRect;
                rectF2.round(rect);
                drawable.setBounds(rect);
                drawable.draw(canvas);
            }
        }
    }

    public final int calculateTrackCenter() {
        int i = this.widgetThickness / 2;
        int i2 = this.labelBehavior;
        int i3 = 0;
        if (i2 == 1 || i2 == 3) {
            i3 = ((TooltipDrawable) this.labels.get(0)).getIntrinsicHeight();
        }
        return i + i3;
    }

    public final ValueAnimator createLabelAnimator(boolean z) {
        float f;
        ValueAnimator valueAnimator;
        int i;
        TimeInterpolator timeInterpolator;
        float f2 = 1.0f;
        if (z) {
            f = 0.0f;
        } else {
            f = 1.0f;
        }
        if (z) {
            valueAnimator = this.labelsOutAnimator;
        } else {
            valueAnimator = this.labelsInAnimator;
        }
        if (valueAnimator != null && valueAnimator.isRunning()) {
            f = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            valueAnimator.cancel();
        }
        if (!z) {
            f2 = 0.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        if (z) {
            i = LazyKt__LazyJVMKt.resolveThemeDuration(getContext(), C0130R.attr.motionDurationMedium4, 83);
            timeInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(getContext(), C0130R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.DECELERATE_INTERPOLATOR);
        } else {
            i = LazyKt__LazyJVMKt.resolveThemeDuration(getContext(), C0130R.attr.motionDurationShort3, 117);
            timeInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(getContext(), C0130R.attr.motionEasingEmphasizedAccelerateInterpolator, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        }
        ofFloat.setDuration(i);
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.addUpdateListener(new ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(3, this));
        return ofFloat;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public final void drawInactiveTrackSection(float f, float f2, float f3, float f4, Canvas canvas, RectF rectF, int i) {
        if (f2 - f > getTrackCornerSize() - this.thumbTrackGapSize) {
            rectF.set(f, f3, f2, f4);
        } else {
            rectF.setEmpty();
        }
        updateTrack(canvas, this.inactiveTrackPaint, rectF, getTrackCornerSize(), i);
    }

    public final void drawStopIndicator(Canvas canvas, float f, float f2) {
        ArrayList arrayList = this.values;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            float valueToX = valueToX(((Float) obj).floatValue());
            float f3 = (this.thumbWidth / 2.0f) + this.thumbTrackGapSize;
            if (f >= valueToX - f3 && f <= valueToX + f3) {
                return;
            }
        }
        boolean isVertical = isVertical();
        Paint paint = this.stopIndicatorPaint;
        if (isVertical) {
            canvas.drawPoint(f2, f, paint);
        } else {
            canvas.drawPoint(f, f2, paint);
        }
    }

    public final void drawThumbDrawable(Canvas canvas, int i, int i2, float f, Drawable drawable) {
        canvas.save();
        if (isVertical()) {
            canvas.concat(this.rotationMatrix);
        }
        canvas.translate((this.trackSidePadding + ((int) (normalizeValue(f) * i))) - (drawable.getBounds().width() / 2.0f), i2 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    public final void drawTicks(int i, int i2, Canvas canvas, Paint paint) {
        float f;
        while (i < i2) {
            if (isVertical()) {
                f = this.ticksCoordinates[i + 1];
            } else {
                f = this.ticksCoordinates[i];
            }
            float f2 = (this.thumbWidth / 2.0f) + this.thumbTrackGapSize;
            Iterator it = this.values.iterator();
            if (it.hasNext()) {
                float valueToX = valueToX(((Float) it.next()).floatValue());
                if (f >= valueToX - f2 && f <= valueToX + f2) {
                    i += 2;
                }
            }
            if (this.centered) {
                float f3 = (this.thumbWidth / 2.0f) + this.thumbTrackGapSize;
                float f4 = ((this.trackSidePadding * 2) + this.trackWidth) / 2.0f;
                if (f >= f4 - f3 && f <= f4 + f3) {
                    i += 2;
                }
            }
            float[] fArr = this.ticksCoordinates;
            canvas.drawPoint(fArr[i], fArr[i + 1], paint);
            i += 2;
        }
    }

    public final void drawTrackIcons(Canvas canvas, RectF rectF, RectF rectF2) {
        if (this.trackIconActiveStart != null || this.trackIconActiveEnd != null || this.trackIconInactiveStart != null || this.trackIconInactiveEnd != null) {
            if (this.values.size() > 1) {
                Log.w("BaseSlider", "Track icons can only be used when only 1 thumb is present.");
            }
            calculateBoundsAndDrawTrackIcon(canvas, rectF, this.trackIconActiveStart, true);
            calculateBoundsAndDrawTrackIcon(canvas, rectF2, this.trackIconInactiveStart, true);
            calculateBoundsAndDrawTrackIcon(canvas, rectF, this.trackIconActiveEnd, false);
            calculateBoundsAndDrawTrackIcon(canvas, rectF2, this.trackIconInactiveEnd, false);
        }
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        this.stopIndicatorPaint.setColor(getColorForState(this.tickColorInactive));
        ArrayList arrayList = this.labels;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            TooltipDrawable tooltipDrawable = (TooltipDrawable) obj;
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        MaterialShapeDrawable materialShapeDrawable = this.defaultThumbDrawable;
        if (materialShapeDrawable.isStateful()) {
            materialShapeDrawable.setState(getDrawableState());
        }
        int colorForState = getColorForState(this.haloColor);
        Paint paint = this.haloPaint;
        paint.setColor(colorForState);
        paint.setAlpha(63);
    }

    public final void ensureLabelsAdded() {
        if (!this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = true;
            ValueAnimator createLabelAnimator = createLabelAnimator(true);
            this.labelsInAnimator = createLabelAnimator;
            this.labelsOutAnimator = null;
            createLabelAnimator.start();
        }
        ArrayList arrayList = this.labels;
        Iterator it = arrayList.iterator();
        for (int i = 0; i < this.values.size() && it.hasNext(); i++) {
            if (i != this.focusedThumbIdx) {
                setValueForLabel((TooltipDrawable) it.next(), ((Float) this.values.get(i)).floatValue());
            }
        }
        if (it.hasNext()) {
            setValueForLabel((TooltipDrawable) it.next(), ((Float) this.values.get(this.focusedThumbIdx)).floatValue());
            return;
        }
        throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(arrayList.size()), Integer.valueOf(this.values.size())));
    }

    public final void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            ValueAnimator createLabelAnimator = createLabelAnimator(false);
            this.labelsOutAnimator = createLabelAnimator;
            this.labelsInAnimator = null;
            createLabelAnimator.addListener(new Transition.C01123(9, this));
            this.labelsOutAnimator.start();
        }
    }

    public final String formatValue(float f) {
        String str;
        LabelFormatter labelFormatter = this.formatter;
        if (labelFormatter != null) {
            return labelFormatter.getFormattedValue(f);
        }
        if (((int) f) == f) {
            str = "%.0f";
        } else {
            str = "%.2f";
        }
        return String.format(str, Float.valueOf(f));
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.mAccessibilityFocusedVirtualViewId;
    }

    public final float[] getActiveRange() {
        float floatValue = ((Float) this.values.get(0)).floatValue();
        ArrayList arrayList = this.values;
        float floatValue2 = ((Float) arrayList.get(arrayList.size() - 1)).floatValue();
        if (this.values.size() == 1) {
            floatValue = this.valueFrom;
        }
        float normalizeValue = normalizeValue(floatValue);
        float normalizeValue2 = normalizeValue(floatValue2);
        if (this.centered) {
            float min = Math.min(0.5f, normalizeValue2);
            normalizeValue2 = Math.max(0.5f, normalizeValue2);
            normalizeValue = min;
        }
        return (this.centered || (!isRtl() && !isVertical())) ? new float[]{normalizeValue, normalizeValue2} : new float[]{normalizeValue2, normalizeValue};
    }

    public final int getColorForState(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public abstract int getThumbRadius();

    public abstract int getTrackCornerSize();

    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public final boolean isMultipleOfStepSize(double d) {
        double doubleValue = new BigDecimal(Double.toString(d)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        if (Math.abs(Math.round(doubleValue) - doubleValue) < 1.0E-4d) {
            return true;
        }
        return false;
    }

    public final boolean isPotentialHorizontalScroll(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if ((viewGroup.canScrollHorizontally(1) || viewGroup.canScrollHorizontally(-1)) && viewGroup.shouldDelayChildPressedState()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isPotentialVerticalScroll(MotionEvent motionEvent) {
        if (motionEvent.getToolType(0) != 3) {
            for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean isRtl() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public final boolean isVertical() {
        if (this.widgetOrientation == 1) {
            return true;
        }
        return false;
    }

    public final boolean moveFocus(int i) {
        int i2 = this.focusedThumbIdx;
        long j = i2 + i;
        long size = this.values.size() - 1;
        if (j < 0) {
            j = 0;
        } else if (j > size) {
            j = size;
        }
        int i3 = (int) j;
        this.focusedThumbIdx = i3;
        if (i3 == i2) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = i3;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    public final void moveFocusInAbsoluteDirection(int i) {
        if (isRtl() || isVertical()) {
            if (i == Integer.MIN_VALUE) {
                i = Integer.MAX_VALUE;
            } else {
                i = -i;
            }
        }
        moveFocus(i);
    }

    public final float normalizeValue(float f) {
        float f2 = this.valueFrom;
        float f3 = (f - f2) / (this.valueTo - f2);
        if (isRtl() || isVertical()) {
            return 1.0f - f3;
        }
        return f3;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.thisAndAncestorsVisible = isShown();
        getViewTreeObserver().addOnScrollChangedListener(this.onScrollChangedListener);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
        ArrayList arrayList = this.labels;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            TooltipDrawable tooltipDrawable = (TooltipDrawable) obj;
            ViewGroup contentView = ViewUtils.getContentView(this);
            if (contentView == null) {
                tooltipDrawable.getClass();
            } else {
                tooltipDrawable.getClass();
                int[] iArr = new int[2];
                contentView.getLocationOnScreen(iArr);
                tooltipDrawable.locationOnScreenX = iArr[0];
                contentView.getWindowVisibleDisplayFrame(tooltipDrawable.displayFrame);
                contentView.addOnLayoutChangeListener(tooltipDrawable.attachedViewLayoutChangeListener);
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        CallbackWithHandler$2 callbackWithHandler$2 = this.accessibilityEventSender;
        if (callbackWithHandler$2 != null) {
            removeCallbacks(callbackWithHandler$2);
        }
        int i = 0;
        this.labelsAreAnimatedIn = false;
        ArrayList arrayList = this.labels;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            TooltipDrawable tooltipDrawable = (TooltipDrawable) obj;
            ViewGroup contentView = ViewUtils.getContentView(this);
            if (contentView != null) {
                contentView.getOverlay().remove(tooltipDrawable);
                contentView.removeOnLayoutChangeListener(tooltipDrawable.attachedViewLayoutChangeListener);
            }
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0142  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onDraw(Canvas canvas) {
        int i;
        int i2;
        int i3;
        float f;
        float f2;
        float f3;
        float f4;
        BaseSlider baseSlider;
        int i4;
        char c;
        ArrayList arrayList;
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            updateTicksCoordinates();
        }
        super.onDraw(canvas);
        int calculateTrackCenter = calculateTrackCenter();
        int i5 = this.trackWidth;
        float[] activeRange = getActiveRange();
        float f5 = calculateTrackCenter;
        float f6 = this.trackThickness / 2.0f;
        float f7 = f5 - f6;
        float f8 = f6 + f5;
        int i6 = 0;
        float f9 = i5;
        float f10 = activeRange[0] * f9;
        RectF rectF = this.inactiveTrackLeftRect;
        drawInactiveTrackSection(this.trackSidePadding - getTrackCornerSize(), (f10 + this.trackSidePadding) - this.thumbTrackGapSize, f7, f8, canvas, rectF, 2);
        float f11 = (activeRange[1] * f9) + this.trackSidePadding + this.thumbTrackGapSize;
        int trackCornerSize = getTrackCornerSize();
        RectF rectF2 = this.inactiveTrackRightRect;
        int i7 = 3;
        int i8 = 1;
        drawInactiveTrackSection(f11, trackCornerSize + i + i5, f7, f8, canvas, rectF2, 3);
        int i9 = this.trackWidth;
        float[] activeRange2 = getActiveRange();
        float f12 = this.trackSidePadding;
        float f13 = i9;
        float f14 = (activeRange2[0] * f13) + f12;
        int i10 = 2;
        float f15 = (activeRange2[1] * f13) + f12;
        RectF rectF3 = this.activeTrackRect;
        if (f14 >= f15) {
            rectF3.setEmpty();
        } else {
            if (this.values.size() != 1 || this.centered) {
                i2 = 4;
            } else {
                if (!isRtl() && !isVertical()) {
                    i7 = 2;
                }
                i2 = i7;
            }
            int i11 = 0;
            while (i11 < this.values.size()) {
                if (this.values.size() > i8) {
                    if (i11 > 0) {
                        f15 = valueToX(((Float) this.values.get(i11 - 1)).floatValue());
                    } else {
                        f15 = f14;
                    }
                    f14 = valueToX(((Float) this.values.get(i11)).floatValue());
                    if (!isRtl() && !isVertical()) {
                        f14 = f15;
                        f15 = f14;
                    }
                }
                int trackCornerSize2 = getTrackCornerSize();
                int ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i2);
                if (ordinal != i8) {
                    if (ordinal == i10) {
                        f14 += this.thumbTrackGapSize;
                        f15 += trackCornerSize2;
                    } else if (ordinal == 3) {
                        if (!this.centered) {
                            f = this.thumbTrackGapSize;
                            f14 += f;
                            f15 -= f;
                        } else if (activeRange2[i8] == 0.5f) {
                            f14 += this.thumbTrackGapSize;
                        } else if (activeRange2[0] == 0.5f) {
                            i3 = this.thumbTrackGapSize;
                        }
                    }
                    f2 = f15;
                    f3 = f14;
                    if (f3 < f2) {
                        rectF3.setEmpty();
                        f4 = f3;
                    } else {
                        float f16 = this.trackThickness / 2.0f;
                        rectF3.set(f3, f5 - f16, f2, f16 + f5);
                        float f17 = trackCornerSize2;
                        f4 = f3;
                        updateTrack(canvas, this.activeTrackPaint, rectF3, f17, i2);
                    }
                    i11++;
                    f15 = f2;
                    f14 = f4;
                    i10 = 2;
                    i8 = 1;
                } else {
                    f14 -= trackCornerSize2;
                    i3 = this.thumbTrackGapSize;
                }
                f = i3;
                f15 -= f;
                f2 = f15;
                f3 = f14;
                if (f3 < f2) {
                }
                i11++;
                f15 = f2;
                f14 = f4;
                i10 = 2;
                i8 = 1;
            }
        }
        Canvas canvas2 = canvas;
        if (isRtl() || isVertical()) {
            drawTrackIcons(canvas2, rectF3, rectF);
        } else {
            drawTrackIcons(canvas2, rectF3, rectF2);
        }
        float[] fArr = this.ticksCoordinates;
        if (!(fArr == null || fArr.length == 0)) {
            float[] activeRange3 = getActiveRange();
            int ceil = (int) Math.ceil(((this.ticksCoordinates.length / 2.0f) - 1.0f) * activeRange3[0]);
            int floor = (int) Math.floor(((this.ticksCoordinates.length / 2.0f) - 1.0f) * activeRange3[1]);
            Paint paint = this.inactiveTicksPaint;
            if (ceil > 0) {
                drawTicks(0, ceil * 2, canvas2, paint);
            }
            if (ceil <= floor) {
                drawTicks(ceil * 2, (floor + 1) * 2, canvas2, this.activeTicksPaint);
            }
            int i12 = (floor + 1) * 2;
            float[] fArr2 = this.ticksCoordinates;
            if (i12 < fArr2.length) {
                drawTicks(i12, fArr2.length, canvas2, paint);
            }
        }
        if (this.trackStopIndicatorSize > 0 && !this.values.isEmpty()) {
            float floatValue = ((Float) this.values.get(arrayList.size() - 1)).floatValue();
            float f18 = this.valueTo;
            if (floatValue < f18) {
                drawStopIndicator(canvas2, valueToX(f18), f5);
            }
            if (this.centered || (this.values.size() > 1 && ((Float) this.values.get(0)).floatValue() > this.valueFrom)) {
                drawStopIndicator(canvas2, valueToX(this.valueFrom), f5);
            }
        }
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            int i13 = this.trackWidth;
            if (!(getBackground() instanceof RippleDrawable)) {
                float[] fArr3 = {(normalizeValue(((Float) this.values.get(this.focusedThumbIdx)).floatValue()) * i13) + this.trackSidePadding, f5};
                if (isVertical()) {
                    this.rotationMatrix.mapPoints(fArr3);
                }
                if (Build.VERSION.SDK_INT < 28) {
                    float f19 = fArr3[0];
                    float f20 = this.haloRadius;
                    c = 1;
                    float f21 = fArr3[1];
                    baseSlider = this;
                    canvas.clipRect(f19 - f20, f21 - f20, f19 + f20, f21 + f20, Region.Op.UNION);
                    canvas2 = canvas;
                } else {
                    baseSlider = this;
                    c = 1;
                }
                canvas2.drawCircle(fArr3[0], fArr3[c], baseSlider.haloRadius, baseSlider.haloPaint);
                baseSlider.updateLabels();
                int i14 = baseSlider.trackWidth;
                while (i6 < baseSlider.values.size()) {
                    float floatValue2 = ((Float) baseSlider.values.get(i6)).floatValue();
                    Drawable drawable = baseSlider.customThumbDrawable;
                    if (drawable != null) {
                        i4 = calculateTrackCenter;
                        baseSlider.drawThumbDrawable(canvas2, i14, i4, floatValue2, drawable);
                    } else {
                        BaseSlider baseSlider2 = baseSlider;
                        i4 = calculateTrackCenter;
                        if (i6 < baseSlider2.customThumbDrawablesForValues.size()) {
                            baseSlider2.drawThumbDrawable(canvas, i14, i4, floatValue2, (Drawable) baseSlider2.customThumbDrawablesForValues.get(i6));
                        } else {
                            if (!baseSlider2.isEnabled()) {
                                canvas.drawCircle((baseSlider2.normalizeValue(floatValue2) * i14) + baseSlider2.trackSidePadding, f5, baseSlider2.getThumbRadius(), baseSlider2.thumbPaint);
                            }
                            baseSlider2.drawThumbDrawable(canvas, i14, i4, floatValue2, baseSlider2.defaultThumbDrawable);
                        }
                    }
                    i6++;
                    baseSlider = this;
                    canvas2 = canvas;
                    calculateTrackCenter = i4;
                }
            }
        }
        baseSlider = this;
        baseSlider.updateLabels();
        int i142 = baseSlider.trackWidth;
        while (i6 < baseSlider.values.size()) {
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        AccessibilityHelper accessibilityHelper = this.accessibilityHelper;
        if (!z) {
            this.activeThumbIdx = -1;
            accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
            return;
        }
        if (i == 1) {
            moveFocus(Integer.MAX_VALUE);
        } else if (i == 2) {
            moveFocus(Integer.MIN_VALUE);
        } else if (i == 17) {
            moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        } else if (i == 66) {
            moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        }
        accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(false);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        float f;
        float f2;
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        Float f3 = null;
        Boolean bool = null;
        f3 = null;
        f3 = null;
        if (this.activeThumbIdx == -1) {
            if (i != 61) {
                if (i != 66) {
                    if (i != 81) {
                        if (i != 69) {
                            if (i != 70) {
                                switch (i) {
                                    case 21:
                                        moveFocusInAbsoluteDirection(-1);
                                        bool = Boolean.TRUE;
                                        break;
                                    case 22:
                                        moveFocusInAbsoluteDirection(1);
                                        bool = Boolean.TRUE;
                                        break;
                                }
                            }
                        } else {
                            moveFocus(-1);
                            bool = Boolean.TRUE;
                        }
                    }
                    moveFocus(1);
                    bool = Boolean.TRUE;
                }
                this.activeThumbIdx = this.focusedThumbIdx;
                postInvalidate();
                bool = Boolean.TRUE;
            } else if (keyEvent.hasNoModifiers()) {
                bool = Boolean.valueOf(moveFocus(1));
            } else if (keyEvent.isShiftPressed()) {
                bool = Boolean.valueOf(moveFocus(-1));
            } else {
                bool = Boolean.FALSE;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
            return super.onKeyDown(i, keyEvent);
        }
        boolean isLongPress = this.isLongPress | keyEvent.isLongPress();
        this.isLongPress = isLongPress;
        float f4 = 1.0f;
        if (isLongPress) {
            float f5 = this.stepSize;
            if (f5 != 0.0f) {
                f4 = f5;
            }
            if ((this.valueTo - this.valueFrom) / f4 > 20) {
                f4 *= Math.round(f / f2);
            }
        } else {
            float f6 = this.stepSize;
            if (f6 != 0.0f) {
                f4 = f6;
            }
        }
        if (i != 69) {
            if (i != 70 && i != 81) {
                switch (i) {
                    case 19:
                        if (isVertical()) {
                            f3 = Float.valueOf(f4);
                            break;
                        }
                        break;
                    case 20:
                        if (isVertical()) {
                            f3 = Float.valueOf(-f4);
                            break;
                        }
                        break;
                    case 21:
                        if (!isRtl()) {
                            f4 = -f4;
                        }
                        f3 = Float.valueOf(f4);
                        break;
                    case 22:
                        if (isRtl()) {
                            f4 = -f4;
                        }
                        f3 = Float.valueOf(f4);
                        break;
                }
            } else {
                f3 = Float.valueOf(f4);
            }
        } else {
            f3 = Float.valueOf(-f4);
        }
        if (f3 != null) {
            if (snapThumbToValue(this.activeThumbIdx, f3.floatValue() + ((Float) this.values.get(this.activeThumbIdx)).floatValue())) {
                updateHaloHotspot();
                postInvalidate();
            }
            return true;
        }
        if (i != 23) {
            if (i != 61) {
                if (i != 66) {
                    return super.onKeyDown(i, keyEvent);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return moveFocus(1);
            } else {
                if (keyEvent.isShiftPressed()) {
                    return moveFocus(-1);
                }
                return false;
            }
        }
        this.activeThumbIdx = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3 = this.labelBehavior;
        int i4 = 0;
        if (i3 == 1 || i3 == 3) {
            i4 = ((TooltipDrawable) this.labels.get(0)).getIntrinsicHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.widgetThickness + i4, 1073741824);
        if (isVertical()) {
            super.onMeasure(makeMeasureSpec, i2);
        } else {
            super.onMeasure(i, makeMeasureSpec);
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, com.google.android.material.slider.BaseSlider$SliderState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.valueFrom = this.valueFrom;
        baseSavedState.valueTo = this.valueTo;
        baseSavedState.values = new ArrayList(this.values);
        baseSavedState.stepSize = this.stepSize;
        baseSavedState.hasFocus = hasFocus();
        return baseSavedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        if (isVertical()) {
            i = i2;
        }
        this.trackWidth = Math.max(i - (this.trackSidePadding * 2), 0);
        updateTicksCoordinates();
        updateHaloHotspot();
    }

    public final void onStartTrackingTouch() {
        ArrayList arrayList = this.touchListeners;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((BaseOnSliderTouchListener) obj).onStartTrackingTouch(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
        if (r3 != 3) goto L77;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        float f2;
        int i;
        int i2 = 0;
        if (isEnabled()) {
            if (isVertical()) {
                f = motionEvent.getY();
            } else {
                f = motionEvent.getX();
            }
            if (isVertical()) {
                f2 = motionEvent.getX();
            } else {
                f2 = motionEvent.getY();
            }
            float f3 = (f - this.trackSidePadding) / this.trackWidth;
            this.touchPosition = f3;
            float max = Math.max(0.0f, f3);
            this.touchPosition = max;
            this.touchPosition = Math.min(1.0f, max);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                int i3 = this.scaledTouchSlop;
                if (actionMasked != 1) {
                    if (actionMasked == 2) {
                        if (!this.thumbIsPressed) {
                            if ((isVertical() || !isPotentialVerticalScroll(motionEvent) || Math.abs(f - this.touchDownAxis1) >= i3) && (!isVertical() || !isPotentialHorizontalScroll(motionEvent) || Math.abs(f2 - this.touchDownAxis2) >= i3 * 0.8f)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                                Slider slider = (Slider) this;
                                if (slider.getActiveThumbIndex() == -1) {
                                    slider.setActiveThumbIndex(0);
                                }
                                this.thumbIsPressed = true;
                                updateThumbWidthWhenPressed();
                                onStartTrackingTouch();
                            }
                        }
                        snapTouchPosition();
                        updateHaloHotspot();
                        invalidate();
                    }
                }
                this.thumbIsPressed = false;
                MotionEvent motionEvent2 = this.lastEvent;
                if (motionEvent2 != null && motionEvent2.getActionMasked() == 0) {
                    float f4 = i3;
                    if (Math.abs(this.lastEvent.getX() - motionEvent.getX()) <= f4 && Math.abs(this.lastEvent.getY() - motionEvent.getY()) <= f4) {
                        Slider slider2 = (Slider) this;
                        if (slider2.getActiveThumbIndex() == -1) {
                            slider2.setActiveThumbIndex(0);
                        }
                        onStartTrackingTouch();
                    }
                }
                if (this.activeThumbIdx != -1) {
                    snapTouchPosition();
                    updateHaloHotspot();
                    if (!(this.thumbTrackGapSize <= 0 || (i = this.defaultThumbWidth) == -1 || this.defaultThumbTrackGapSize == -1)) {
                        setThumbWidth(i);
                        setThumbTrackGapSize(this.defaultThumbTrackGapSize);
                    }
                    this.activeThumbIdx = -1;
                    ArrayList arrayList = this.touchListeners;
                    int size = arrayList.size();
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        ((BaseOnSliderTouchListener) obj).onStopTrackingTouch(this);
                    }
                }
                invalidate();
            } else {
                this.touchDownAxis1 = f;
                this.touchDownAxis2 = f2;
                if ((isVertical() || !isPotentialVerticalScroll(motionEvent)) && (!isVertical() || !isPotentialHorizontalScroll(motionEvent))) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    Slider slider3 = (Slider) this;
                    if (slider3.getActiveThumbIndex() == -1) {
                        slider3.setActiveThumbIndex(0);
                    }
                    requestFocus();
                    this.thumbIsPressed = true;
                    updateThumbWidthWhenPressed();
                    onStartTrackingTouch();
                    snapTouchPosition();
                    updateHaloHotspot();
                    invalidate();
                }
            }
            setPressed(this.thumbIsPressed);
            this.lastEvent = MotionEvent.obtain(motionEvent);
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        this.thisAndAncestorsVisible = z;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        ViewOverlay viewOverlay;
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            ViewGroup contentView = ViewUtils.getContentView(this);
            if (contentView == null) {
                viewOverlay = null;
            } else {
                viewOverlay = contentView.getOverlay();
            }
            if (viewOverlay != null) {
                ArrayList arrayList = this.labels;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    viewOverlay.remove((TooltipDrawable) obj);
                }
            }
        }
    }

    public void setActiveThumbIndex(int i) {
        this.activeThumbIdx = i;
    }

    public abstract void setCentered(boolean z);

    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            drawableArr[i] = getResources().getDrawable(iArr[i]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        int i;
        super.setEnabled(z);
        if (z) {
            i = 0;
        } else {
            i = 2;
        }
        setLayerType(i, null);
    }

    public abstract void setHaloRadius(int i);

    public abstract void setHaloTintList(ColorStateList colorStateList);

    public abstract void setLabelBehavior(int i);

    public abstract void setOrientation(int i);

    public void setSeparationUnit(int i) {
        this.separationUnit = i;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public abstract void setThumbElevation(float f);

    public abstract void setThumbHeight(int i);

    public abstract void setThumbStrokeColor(ColorStateList colorStateList);

    public abstract void setThumbStrokeWidth(float f);

    public abstract void setThumbTrackGapSize(int i);

    public abstract void setThumbWidth(int i);

    public abstract void setTickActiveRadius(int i);

    public abstract void setTickActiveTintList(ColorStateList colorStateList);

    public abstract void setTickInactiveRadius(int i);

    public abstract void setTickInactiveTintList(ColorStateList colorStateList);

    public abstract void setTrackActiveTintList(ColorStateList colorStateList);

    public abstract void setTrackCornerSize(int i);

    public abstract void setTrackHeight(int i);

    public abstract void setTrackIconActiveColor(ColorStateList colorStateList);

    public abstract void setTrackIconActiveEnd(Drawable drawable);

    public abstract void setTrackIconActiveStart(Drawable drawable);

    public abstract void setTrackIconInactiveColor(ColorStateList colorStateList);

    public abstract void setTrackIconInactiveEnd(Drawable drawable);

    public abstract void setTrackIconInactiveStart(Drawable drawable);

    public abstract void setTrackIconSize(int i);

    public abstract void setTrackInactiveTintList(ColorStateList colorStateList);

    public abstract void setTrackInsideCornerSize(int i);

    public abstract void setTrackStopIndicatorSize(int i);

    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setValueForLabel(TooltipDrawable tooltipDrawable, float f) {
        int i;
        int i2;
        int i3;
        int i4;
        ViewGroup contentView;
        ViewOverlay viewOverlay;
        int intrinsicHeight;
        String formatValue = formatValue(f);
        if (!TextUtils.equals(tooltipDrawable.text, formatValue)) {
            tooltipDrawable.text = formatValue;
            tooltipDrawable.textDrawableHelper.textSizeDirty = true;
            tooltipDrawable.invalidateSelf();
        }
        if (isVertical()) {
            i4 = (this.trackSidePadding + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicHeight() / 2);
            i = tooltipDrawable.getIntrinsicHeight() + i4;
            if (isRtl()) {
                i3 = calculateTrackCenter() - ((this.thumbHeight / 2) + this.labelPadding);
                intrinsicHeight = tooltipDrawable.getIntrinsicWidth();
            } else {
                i2 = (this.thumbHeight / 2) + this.labelPadding + calculateTrackCenter();
                i3 = tooltipDrawable.getIntrinsicWidth() + i2;
                Rect rect = this.labelRect;
                rect.set(i4, i2, i, i3);
                if (isVertical()) {
                    RectF rectF = new RectF(rect);
                    this.rotationMatrix.mapRect(rectF);
                    rectF.round(rect);
                }
                DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect);
                tooltipDrawable.setBounds(rect);
                contentView = ViewUtils.getContentView(this);
                if (contentView != null) {
                    viewOverlay = null;
                } else {
                    viewOverlay = contentView.getOverlay();
                }
                if (viewOverlay == null) {
                    viewOverlay.add(tooltipDrawable);
                    return;
                }
                return;
            }
        } else {
            i4 = (this.trackSidePadding + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
            i = tooltipDrawable.getIntrinsicWidth() + i4;
            i3 = calculateTrackCenter() - ((this.thumbHeight / 2) + this.labelPadding);
            intrinsicHeight = tooltipDrawable.getIntrinsicHeight();
        }
        i2 = i3 - intrinsicHeight;
        Rect rect2 = this.labelRect;
        rect2.set(i4, i2, i, i3);
        if (isVertical()) {
        }
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, rect2);
        tooltipDrawable.setBounds(rect2);
        contentView = ViewUtils.getContentView(this);
        if (contentView != null) {
        }
        if (viewOverlay == null) {
        }
    }

    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public final void setValuesInternal(ArrayList arrayList) {
        TextAppearance textAppearance;
        int i;
        int i2;
        int i3;
        ViewGroup contentView;
        int resourceId;
        ViewGroup contentView2;
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.values.size() != arrayList.size() || !this.values.equals(arrayList)) {
                this.values = arrayList;
                int i4 = 1;
                this.dirtyConfig = true;
                this.focusedThumbIdx = 0;
                updateHaloHotspot();
                ArrayList arrayList2 = this.labels;
                if (arrayList2.size() > this.values.size()) {
                    List<TooltipDrawable> subList = arrayList2.subList(this.values.size(), arrayList2.size());
                    for (TooltipDrawable tooltipDrawable : subList) {
                        if (isAttachedToWindow() && (contentView2 = ViewUtils.getContentView(this)) != null) {
                            contentView2.getOverlay().remove(tooltipDrawable);
                            contentView2.removeOnLayoutChangeListener(tooltipDrawable.attachedViewLayoutChangeListener);
                        }
                    }
                    subList.clear();
                }
                while (arrayList2.size() < this.values.size()) {
                    Context context = getContext();
                    int i5 = this.labelStyle;
                    TooltipDrawable tooltipDrawable2 = new TooltipDrawable(context, i5);
                    TypedArray obtainStyledAttributes = ViewUtils.obtainStyledAttributes(tooltipDrawable2.context, null, R$styleable.Tooltip, 0, i5, new int[0]);
                    Context context2 = tooltipDrawable2.context;
                    tooltipDrawable2.arrowSize = context2.getResources().getDimensionPixelSize(C0130R.dimen.mtrl_tooltip_arrowSize);
                    boolean z = obtainStyledAttributes.getBoolean(8, true);
                    tooltipDrawable2.showMarker = z;
                    if (z) {
                        ShapeAppearanceModel.Builder builder = tooltipDrawable2.drawableState.shapeAppearanceModel.toBuilder();
                        builder.bottomEdge = tooltipDrawable2.createMarkerEdge();
                        tooltipDrawable2.setShapeAppearanceModel(builder.build());
                    } else {
                        tooltipDrawable2.arrowSize = 0;
                    }
                    CharSequence text = obtainStyledAttributes.getText(6);
                    boolean equals = TextUtils.equals(tooltipDrawable2.text, text);
                    TextDrawableHelper textDrawableHelper = tooltipDrawable2.textDrawableHelper;
                    if (!equals) {
                        tooltipDrawable2.text = text;
                        textDrawableHelper.textSizeDirty = true;
                        tooltipDrawable2.invalidateSelf();
                    }
                    if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) {
                        textAppearance = null;
                    } else {
                        textAppearance = new TextAppearance(context2, resourceId);
                    }
                    if (textAppearance != null && obtainStyledAttributes.hasValue(1)) {
                        textAppearance.textColor = LazyKt__LazyJVMKt.getColorStateList(context2, obtainStyledAttributes, 1);
                    }
                    textDrawableHelper.setTextAppearance(textAppearance, context2);
                    TypedValue resolveTypedValueOrThrow = LazyKt__LazyJVMKt.resolveTypedValueOrThrow(C0130R.attr.colorOnBackground, context2, TooltipDrawable.class.getCanonicalName());
                    int i6 = resolveTypedValueOrThrow.resourceId;
                    if (i6 != 0) {
                        i = BundleKt.getColor(context2, i6);
                    } else {
                        i = resolveTypedValueOrThrow.data;
                    }
                    TypedValue resolveTypedValueOrThrow2 = LazyKt__LazyJVMKt.resolveTypedValueOrThrow(16842801, context2, TooltipDrawable.class.getCanonicalName());
                    int i7 = resolveTypedValueOrThrow2.resourceId;
                    if (i7 != 0) {
                        i2 = BundleKt.getColor(context2, i7);
                    } else {
                        i2 = resolveTypedValueOrThrow2.data;
                    }
                    tooltipDrawable2.setFillColor(ColorStateList.valueOf(obtainStyledAttributes.getColor(7, ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i, 153), ColorUtils.setAlphaComponent(i2, 229)))));
                    TypedValue resolveTypedValueOrThrow3 = LazyKt__LazyJVMKt.resolveTypedValueOrThrow(C0130R.attr.colorSurface, context2, TooltipDrawable.class.getCanonicalName());
                    int i8 = resolveTypedValueOrThrow3.resourceId;
                    if (i8 != 0) {
                        i3 = BundleKt.getColor(context2, i8);
                    } else {
                        i3 = resolveTypedValueOrThrow3.data;
                    }
                    tooltipDrawable2.setStrokeColor(ColorStateList.valueOf(i3));
                    tooltipDrawable2.padding = obtainStyledAttributes.getDimensionPixelSize(2, 0);
                    tooltipDrawable2.minWidth = obtainStyledAttributes.getDimensionPixelSize(4, 0);
                    tooltipDrawable2.minHeight = obtainStyledAttributes.getDimensionPixelSize(5, 0);
                    tooltipDrawable2.layoutMargin = obtainStyledAttributes.getDimensionPixelSize(3, 0);
                    obtainStyledAttributes.recycle();
                    arrayList2.add(tooltipDrawable2);
                    if (isAttachedToWindow() && (contentView = ViewUtils.getContentView(this)) != null) {
                        int[] iArr = new int[2];
                        contentView.getLocationOnScreen(iArr);
                        tooltipDrawable2.locationOnScreenX = iArr[0];
                        contentView.getWindowVisibleDisplayFrame(tooltipDrawable2.displayFrame);
                        contentView.addOnLayoutChangeListener(tooltipDrawable2.attachedViewLayoutChangeListener);
                    }
                }
                if (arrayList2.size() == 1) {
                    i4 = 0;
                }
                int size = arrayList2.size();
                int i9 = 0;
                while (i9 < size) {
                    Object obj = arrayList2.get(i9);
                    i9++;
                    TooltipDrawable tooltipDrawable3 = (TooltipDrawable) obj;
                    tooltipDrawable3.drawableState.strokeWidth = i4;
                    tooltipDrawable3.invalidateSelf();
                }
                ArrayList arrayList3 = this.changeListeners;
                int size2 = arrayList3.size();
                int i10 = 0;
                while (i10 < size2) {
                    Object obj2 = arrayList3.get(i10);
                    i10++;
                    HttpLogFragment$$ExternalSyntheticLambda14 httpLogFragment$$ExternalSyntheticLambda14 = (HttpLogFragment$$ExternalSyntheticLambda14) obj2;
                    ArrayList arrayList4 = this.values;
                    int size3 = arrayList4.size();
                    int i11 = 0;
                    while (i11 < size3) {
                        Object obj3 = arrayList4.get(i11);
                        i11++;
                        httpLogFragment$$ExternalSyntheticLambda14.onValueChange(this, ((Float) obj3).floatValue(), false);
                    }
                }
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    public final boolean snapThumbToValue(int i, float f) {
        float f2;
        float f3;
        this.focusedThumbIdx = i;
        int i2 = 0;
        if (Math.abs(f - ((Float) this.values.get(i)).floatValue()) < 1.0E-4d) {
            return false;
        }
        float minSeparation = getMinSeparation();
        if (this.separationUnit == 0) {
            if (minSeparation == 0.0f) {
                minSeparation = 0.0f;
            } else {
                float f4 = this.valueFrom;
                minSeparation = ((f4 - this.valueTo) * ((minSeparation - this.trackSidePadding) / this.trackWidth)) + f4;
            }
        }
        if (isRtl() || isVertical()) {
            minSeparation = -minSeparation;
        }
        int i3 = i + 1;
        if (i3 >= this.values.size()) {
            f2 = this.valueTo;
        } else {
            f2 = ((Float) this.values.get(i3)).floatValue() - minSeparation;
        }
        int i4 = i - 1;
        if (i4 < 0) {
            f3 = this.valueFrom;
        } else {
            f3 = minSeparation + ((Float) this.values.get(i4)).floatValue();
        }
        this.values.set(i, Float.valueOf(BundleKt.clamp(f, f3, f2)));
        ArrayList arrayList = this.changeListeners;
        int size = arrayList.size();
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((HttpLogFragment$$ExternalSyntheticLambda14) obj).onValueChange(this, ((Float) this.values.get(i)).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            Runnable runnable = this.accessibilityEventSender;
            if (runnable == null) {
                this.accessibilityEventSender = new CallbackWithHandler$2(this);
            } else {
                removeCallbacks(runnable);
            }
            CallbackWithHandler$2 callbackWithHandler$2 = this.accessibilityEventSender;
            callbackWithHandler$2.val$reason = i;
            postDelayed(callbackWithHandler$2, 200L);
        }
        return true;
    }

    public final void snapTouchPosition() {
        double d;
        float f;
        int i;
        float f2 = this.touchPosition;
        float f3 = this.stepSize;
        if (f3 > 0.0f) {
            d = Math.round(f2 * i) / ((int) ((this.valueTo - this.valueFrom) / f3));
        } else {
            d = f2;
        }
        if (isRtl() || isVertical()) {
            d = 1.0d - d;
        }
        float f4 = this.valueTo;
        snapThumbToValue(this.activeThumbIdx, (float) ((d * (f4 - f)) + this.valueFrom));
    }

    public final void updateBoundsForVirtualViewId(int i, Rect rect) {
        int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i).floatValue()) * this.trackWidth));
        int calculateTrackCenter = calculateTrackCenter();
        int max = Math.max(this.thumbWidth / 2, this.minTouchTargetSize / 2);
        int max2 = Math.max(this.thumbHeight / 2, this.minTouchTargetSize / 2);
        RectF rectF = new RectF(normalizeValue - max, calculateTrackCenter - max2, normalizeValue + max, calculateTrackCenter + max2);
        if (isVertical()) {
            this.rotationMatrix.mapRect(rectF);
        }
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public final void updateHaloHotspot() {
        int i;
        if ((getBackground() instanceof RippleDrawable) && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                float normalizeValue = (normalizeValue(((Float) this.values.get(this.focusedThumbIdx)).floatValue()) * this.trackWidth) + this.trackSidePadding;
                int calculateTrackCenter = calculateTrackCenter();
                float f = this.haloRadius;
                float[] fArr = {normalizeValue - f, calculateTrackCenter - i, normalizeValue + f, calculateTrackCenter + i};
                if (isVertical()) {
                    this.rotationMatrix.mapPoints(fArr);
                }
                background.setHotspotBounds((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
            }
        }
    }

    public final void updateLabels() {
        float f;
        boolean z;
        boolean isVertical = isVertical();
        boolean isRtl = isRtl();
        float f2 = 0.5f;
        if (!isVertical || !isRtl) {
            f = 1.2f;
            if (isVertical) {
                f = 0.5f;
                f2 = 1.2f;
            }
        } else {
            f = 0.5f;
            f2 = -0.2f;
        }
        ArrayList arrayList = this.labels;
        int size = arrayList.size();
        boolean z2 = false;
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            TooltipDrawable tooltipDrawable = (TooltipDrawable) obj;
            tooltipDrawable.tooltipPivotX = f2;
            tooltipDrawable.tooltipPivotY = f;
            tooltipDrawable.invalidateSelf();
        }
        int i2 = this.labelBehavior;
        if (i2 == 0 || i2 == 1) {
            if (this.activeThumbIdx == -1 || !isEnabled()) {
                ensureLabelsRemoved();
            } else {
                ensureLabelsAdded();
            }
        } else if (i2 == 2) {
            ensureLabelsRemoved();
        } else if (i2 == 3) {
            if (isEnabled()) {
                Rect rect = new Rect();
                ViewUtils.getContentView(this).getHitRect(rect);
                if (getLocalVisibleRect(rect)) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        z = this.thisAndAncestorsVisible;
                    } else {
                        z = isShown();
                    }
                    if (z) {
                        z2 = true;
                    }
                }
                if (z2) {
                    ensureLabelsAdded();
                    return;
                }
            }
            ensureLabelsRemoved();
        } else {
            throw new IllegalArgumentException("Unexpected labelBehavior: " + this.labelBehavior);
        }
    }

    public final void updateThumbWidthWhenPressed() {
        int i = this.thumbTrackGapSize;
        if (i > 0) {
            int i2 = this.thumbWidth;
            this.defaultThumbWidth = i2;
            this.defaultThumbTrackGapSize = i;
            int round = Math.round(i2 * 0.5f);
            int i3 = this.thumbWidth - round;
            setThumbWidth(round);
            setThumbTrackGapSize(this.thumbTrackGapSize - (i3 / 2));
        }
    }

    public final void updateTicksCoordinates() {
        validateConfigurationIfDirty();
        float f = this.stepSize;
        int i = 0;
        if (f <= 0.0f) {
            updateTicksCoordinates(0);
            return;
        }
        int i2 = this.tickVisibilityMode;
        if (i2 == 0) {
            i = Math.min((int) (((this.valueTo - this.valueFrom) / f) + 1.0f), (this.trackWidth / this.minTickSpacing) + 1);
        } else if (i2 == 1) {
            int i3 = (int) (((this.valueTo - this.valueFrom) / f) + 1.0f);
            if (i3 <= (this.trackWidth / this.minTickSpacing) + 1) {
                i = i3;
            }
        } else if (i2 != 2) {
            throw new IllegalStateException("Unexpected tickVisibilityMode: " + this.tickVisibilityMode);
        }
        updateTicksCoordinates(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateTrack(Canvas canvas, Paint paint, RectF rectF, float f, int i) {
        float f2;
        float f3;
        int ordinal;
        boolean isVertical;
        int i2;
        float valueToX;
        float f4;
        int i3;
        if (!rectF.isEmpty()) {
            if (!this.values.isEmpty() && this.thumbTrackGapSize > 0) {
                if (isRtl() || isVertical()) {
                    i3 = this.values.size() - 1;
                } else {
                    i3 = 0;
                }
                float valueToX2 = valueToX(((Float) this.values.get(i3)).floatValue()) - this.trackSidePadding;
                if (valueToX2 < f) {
                    f2 = Math.max(valueToX2, this.trackInsideCornerSize);
                    if (!this.values.isEmpty() && this.thumbTrackGapSize > 0) {
                        if (!isRtl() || isVertical()) {
                            i2 = 0;
                        } else {
                            i2 = this.values.size() - 1;
                        }
                        valueToX = valueToX(((Float) this.values.get(i2)).floatValue()) - this.trackSidePadding;
                        f4 = this.trackWidth;
                        if (valueToX > f4 - f) {
                            f3 = Math.max(f4 - valueToX, this.trackInsideCornerSize);
                            ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i);
                            if (ordinal == 1) {
                                f3 = this.trackInsideCornerSize;
                            } else if (ordinal == 2) {
                                f2 = this.trackInsideCornerSize;
                            } else if (ordinal == 3) {
                                f2 = this.trackInsideCornerSize;
                                f3 = f2;
                            }
                            paint.setStyle(Paint.Style.FILL);
                            paint.setStrokeCap(Paint.Cap.BUTT);
                            if (this.thumbTrackGapSize > 0) {
                                paint.setAntiAlias(true);
                            }
                            RectF rectF2 = new RectF(rectF);
                            isVertical = isVertical();
                            Matrix matrix = this.rotationMatrix;
                            if (isVertical) {
                                matrix.mapRect(rectF2);
                            }
                            Path path = this.trackPath;
                            path.reset();
                            if (rectF.width() >= f2 + f3) {
                                path.addRoundRect(rectF2, isVertical() ? new float[]{f2, f2, f2, f2, f3, f3, f3, f3} : new float[]{f2, f2, f3, f3, f3, f3, f2, f2}, Path.Direction.CW);
                                canvas.drawPath(path, paint);
                                return;
                            }
                            float min = Math.min(f2, f3);
                            float max = Math.max(f2, f3);
                            canvas.save();
                            path.addRoundRect(rectF2, min, min, Path.Direction.CW);
                            canvas.clipPath(path);
                            int ordinal2 = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i);
                            RectF rectF3 = this.cornerRect;
                            if (ordinal2 == 1) {
                                float f5 = rectF.left;
                                rectF3.set(f5, rectF.top, (2.0f * max) + f5, rectF.bottom);
                            } else if (ordinal2 != 2) {
                                rectF3.set(rectF.centerX() - max, rectF.top, rectF.centerX() + max, rectF.bottom);
                            } else {
                                float f6 = rectF.right;
                                rectF3.set(f6 - (2.0f * max), rectF.top, f6, rectF.bottom);
                            }
                            if (isVertical()) {
                                matrix.mapRect(rectF3);
                            }
                            canvas.drawRoundRect(rectF3, max, max, paint);
                            canvas.restore();
                            return;
                        }
                    }
                    f3 = f;
                    ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i);
                    if (ordinal == 1) {
                    }
                    paint.setStyle(Paint.Style.FILL);
                    paint.setStrokeCap(Paint.Cap.BUTT);
                    if (this.thumbTrackGapSize > 0) {
                    }
                    RectF rectF22 = new RectF(rectF);
                    isVertical = isVertical();
                    Matrix matrix2 = this.rotationMatrix;
                    if (isVertical) {
                    }
                    Path path2 = this.trackPath;
                    path2.reset();
                    if (rectF.width() >= f2 + f3) {
                    }
                }
            }
            f2 = f;
            if (!this.values.isEmpty()) {
                if (!isRtl()) {
                }
                i2 = 0;
                valueToX = valueToX(((Float) this.values.get(i2)).floatValue()) - this.trackSidePadding;
                f4 = this.trackWidth;
                if (valueToX > f4 - f) {
                }
            }
            f3 = f;
            ordinal = SolverVariable$Type$EnumUnboxingSharedUtility.ordinal(i);
            if (ordinal == 1) {
            }
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeCap(Paint.Cap.BUTT);
            if (this.thumbTrackGapSize > 0) {
            }
            RectF rectF222 = new RectF(rectF);
            isVertical = isVertical();
            Matrix matrix22 = this.rotationMatrix;
            if (isVertical) {
            }
            Path path22 = this.trackPath;
            path22.reset();
            if (rectF.width() >= f2 + f3) {
            }
        }
    }

    public final void updateTrackIconActiveEnd() {
        Drawable drawable = this.trackIconActiveEnd;
        if (drawable != null) {
            if (!this.trackIconActiveEndMutated && this.trackIconActiveColor != null) {
                this.trackIconActiveEnd = BundleKt.wrap(drawable).mutate();
                this.trackIconActiveEndMutated = true;
            }
            if (this.trackIconActiveEndMutated) {
                this.trackIconActiveEnd.setTintList(this.trackIconActiveColor);
            }
        }
    }

    public final void updateTrackIconActiveStart() {
        Drawable drawable = this.trackIconActiveStart;
        if (drawable != null) {
            if (!this.trackIconActiveStartMutated && this.trackIconActiveColor != null) {
                this.trackIconActiveStart = BundleKt.wrap(drawable).mutate();
                this.trackIconActiveStartMutated = true;
            }
            if (this.trackIconActiveStartMutated) {
                this.trackIconActiveStart.setTintList(this.trackIconActiveColor);
            }
        }
    }

    public final void updateTrackIconInactiveEnd() {
        Drawable drawable = this.trackIconInactiveEnd;
        if (drawable != null) {
            if (!this.trackIconInactiveEndMutated && this.trackIconInactiveColor != null) {
                this.trackIconInactiveEnd = BundleKt.wrap(drawable).mutate();
                this.trackIconInactiveEndMutated = true;
            }
            if (this.trackIconInactiveEndMutated) {
                this.trackIconInactiveEnd.setTintList(this.trackIconInactiveColor);
            }
        }
    }

    public final void updateTrackIconInactiveStart() {
        Drawable drawable = this.trackIconInactiveStart;
        if (drawable != null) {
            if (!this.trackIconInactiveStartMutated && this.trackIconInactiveColor != null) {
                this.trackIconInactiveStart = BundleKt.wrap(drawable).mutate();
                this.trackIconInactiveStartMutated = true;
            }
            if (this.trackIconInactiveStartMutated) {
                this.trackIconInactiveStart.setTintList(this.trackIconInactiveColor);
            }
        }
    }

    public final void updateWidgetLayout(boolean z) {
        int paddingTop;
        int paddingBottom;
        boolean z2;
        int i;
        if (isVertical()) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i2 = paddingBottom + paddingTop;
        int max = Math.max(this.minWidgetThickness, Math.max(this.trackThickness + i2, this.thumbHeight + i2));
        boolean z3 = true;
        if (max == this.widgetThickness) {
            z2 = false;
        } else {
            this.widgetThickness = max;
            z2 = true;
        }
        int max2 = Math.max(Math.max(Math.max((this.thumbWidth / 2) - this.defaultThumbRadius, 0), Math.max((this.trackThickness - this.defaultTrackThickness) / 2, 0)), Math.max(Math.max(this.tickActiveRadius - this.defaultTickActiveRadius, 0), Math.max(this.tickInactiveRadius - this.defaultTickInactiveRadius, 0))) + this.minTrackSidePadding;
        if (this.trackSidePadding == max2) {
            z3 = false;
        } else {
            this.trackSidePadding = max2;
            if (isLaidOut()) {
                if (isVertical()) {
                    i = getHeight();
                } else {
                    i = getWidth();
                }
                this.trackWidth = Math.max(i - (this.trackSidePadding * 2), 0);
                updateTicksCoordinates();
            }
        }
        if (isVertical()) {
            float calculateTrackCenter = calculateTrackCenter();
            Matrix matrix = this.rotationMatrix;
            matrix.reset();
            matrix.setRotate(90.0f, calculateTrackCenter, calculateTrackCenter);
        }
        if (z2 || z) {
            requestLayout();
        } else if (z3) {
            postInvalidate();
        }
    }

    public final void validateConfigurationIfDirty() {
        if (!this.dirtyConfig) {
            return;
        }
        if (this.valueFrom < this.valueTo) {
            ArrayList arrayList = this.values;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Float f = (Float) obj;
                if (f.floatValue() < this.valueFrom || f.floatValue() > this.valueTo) {
                    float f2 = this.valueFrom;
                    float f3 = this.valueTo;
                    throw new IllegalStateException("Slider value(" + f + ") must be greater or equal to valueFrom(" + f2 + "), and lower or equal to valueTo(" + f3 + ")");
                } else if (this.stepSize > 0.0f && !valueLandsOnTick(f.floatValue())) {
                    float f4 = this.valueFrom;
                    float f5 = this.stepSize;
                    throw new IllegalStateException("Value(" + f + ") must be equal to valueFrom(" + f4 + ") plus a multiple of stepSize(" + f5 + ") when using stepSize(" + f5 + ")");
                }
            }
            if (this.stepSize <= 0.0f || valueLandsOnTick(this.valueTo)) {
                float minSeparation = getMinSeparation();
                if (minSeparation >= 0.0f) {
                    float f6 = this.stepSize;
                    if (f6 > 0.0f && minSeparation > 0.0f) {
                        if (this.separationUnit != 1) {
                            float f7 = this.stepSize;
                            throw new IllegalStateException("minSeparation(" + minSeparation + ") cannot be set as a dimension when using stepSize(" + f7 + ")");
                        } else if (minSeparation < f6 || !isMultipleOfStepSize(minSeparation)) {
                            float f8 = this.stepSize;
                            throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal and a multiple of stepSize(" + f8 + ") when using stepSize(" + f8 + ")");
                        }
                    }
                    float f9 = this.stepSize;
                    if (f9 != 0.0f) {
                        if (((int) f9) != f9) {
                            Log.w("BaseSlider", "Floating point value used for stepSize(" + f9 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                        }
                        float f10 = this.valueFrom;
                        if (((int) f10) != f10) {
                            Log.w("BaseSlider", "Floating point value used for valueFrom(" + f10 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                        }
                        float f11 = this.valueTo;
                        if (((int) f11) != f11) {
                            Log.w("BaseSlider", "Floating point value used for valueTo(" + f11 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
                        }
                    }
                    this.dirtyConfig = false;
                    return;
                }
                throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal to 0");
            }
            float f12 = this.stepSize;
            float f13 = this.valueFrom;
            float f14 = this.valueTo;
            throw new IllegalStateException("The stepSize(" + f12 + ") must be 0, or a factor of the valueFrom(" + f13 + ")-valueTo(" + f14 + ") range");
        }
        float f15 = this.valueFrom;
        float f16 = this.valueTo;
        throw new IllegalStateException("valueFrom(" + f15 + ") must be smaller than valueTo(" + f16 + ")");
    }

    public final boolean valueLandsOnTick(float f) {
        return isMultipleOfStepSize(new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.valueFrom)), MathContext.DECIMAL64).doubleValue());
    }

    public final float valueToX(float f) {
        return (normalizeValue(f) * this.trackWidth) + this.trackSidePadding;
    }

    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList(list));
    }

    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.customThumbDrawable = null;
        this.customThumbDrawablesForValues = new ArrayList();
        for (Drawable drawable : drawableArr) {
            List list = this.customThumbDrawablesForValues;
            Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
            adjustCustomThumbDrawableBounds(newDrawable);
            list.add(newDrawable);
        }
        postInvalidate();
    }

    public final void updateTicksCoordinates(int i) {
        if (i == 0) {
            this.ticksCoordinates = null;
            return;
        }
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != i * 2) {
            this.ticksCoordinates = new float[i * 2];
        }
        float f = this.trackWidth / (i - 1);
        float calculateTrackCenter = calculateTrackCenter();
        for (int i2 = 0; i2 < i * 2; i2 += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i2] = ((i2 / 2.0f) * f) + this.trackSidePadding;
            fArr2[i2 + 1] = calculateTrackCenter;
        }
        if (isVertical()) {
            this.rotationMatrix.mapPoints(this.ticksCoordinates);
        }
    }
}
