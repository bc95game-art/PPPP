package com.google.android.material.slider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.p002os.BundleKt;
import androidx.tracing.Trace;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public class Slider extends BaseSlider {
    public Slider(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842788});
        if (obtainStyledAttributes.hasValue(0)) {
            setValue(obtainStyledAttributes.getFloat(0, 0.0f));
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.defaultThumbDrawable.drawableState.elevation;
    }

    public int getThumbHeight() {
        return this.thumbHeight;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public int getThumbRadius() {
        return this.thumbWidth / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.defaultThumbDrawable.drawableState.strokeColor;
    }

    public float getThumbStrokeWidth() {
        return this.defaultThumbDrawable.drawableState.strokeWidth;
    }

    public ColorStateList getThumbTintList() {
        return this.defaultThumbDrawable.drawableState.fillColor;
    }

    public int getThumbTrackGapSize() {
        return this.thumbTrackGapSize;
    }

    public int getThumbWidth() {
        return this.thumbWidth;
    }

    public int getTickActiveRadius() {
        return this.tickActiveRadius;
    }

    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    public int getTickInactiveRadius() {
        return this.tickInactiveRadius;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public int getTickVisibilityMode() {
        return this.tickVisibilityMode;
    }

    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public int getTrackCornerSize() {
        int i = this.trackCornerSize;
        if (i == -1) {
            return this.trackThickness / 2;
        }
        return i;
    }

    public int getTrackHeight() {
        return this.trackThickness;
    }

    public ColorStateList getTrackIconActiveColor() {
        return this.trackIconActiveColor;
    }

    public Drawable getTrackIconActiveEnd() {
        return this.trackIconActiveEnd;
    }

    public Drawable getTrackIconActiveStart() {
        return this.trackIconActiveStart;
    }

    public ColorStateList getTrackIconInactiveColor() {
        return this.trackIconInactiveColor;
    }

    public Drawable getTrackIconInactiveEnd() {
        return this.trackIconInactiveEnd;
    }

    public Drawable getTrackIconInactiveStart() {
        return this.trackIconInactiveStart;
    }

    public int getTrackIconSize() {
        return this.trackIconSize;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public int getTrackInsideCornerSize() {
        return this.trackInsideCornerSize;
    }

    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public int getTrackStopIndicatorSize() {
        return this.trackStopIndicatorSize;
    }

    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValue() {
        return getValues().get(0).floatValue();
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setCentered(boolean z) {
        if (this.centered != z) {
            this.centered = z;
            if (z) {
                setValues(Float.valueOf((this.valueFrom + this.valueTo) / 2.0f));
            } else {
                setValues(Float.valueOf(this.valueFrom));
            }
            updateWidgetLayout(true);
        }
    }

    public void setCustomThumbDrawable(int i) {
        setCustomThumbDrawable(getResources().getDrawable(i));
    }

    @Override // com.google.android.material.slider.BaseSlider, android.view.View
    public /* bridge */ /* synthetic */ void setEnabled(boolean z) {
        super.setEnabled(z);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = i;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(i);
        postInvalidate();
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setHaloRadius(int i) {
        if (i != this.haloRadius) {
            this.haloRadius = i;
            Drawable background = getBackground();
            if (!(getBackground() instanceof RippleDrawable) || !(background instanceof RippleDrawable)) {
                postInvalidate();
            } else {
                Trace.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
            }
        }
    }

    public void setHaloRadiusResource(int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setHaloTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.haloColor)) {
            this.haloColor = colorStateList;
            Drawable background = getBackground();
            if (!(getBackground() instanceof RippleDrawable) || !(background instanceof RippleDrawable)) {
                int colorForState = getColorForState(colorStateList);
                Paint paint = this.haloPaint;
                paint.setColor(colorForState);
                paint.setAlpha(63);
                invalidate();
                return;
            }
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setLabelBehavior(int i) {
        if (this.labelBehavior != i) {
            this.labelBehavior = i;
            updateWidgetLayout(true);
        }
    }

    public void setLabelFormatter(LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setOrientation(int i) {
        if (this.widgetOrientation != i) {
            this.widgetOrientation = i;
            updateWidgetLayout(true);
        }
    }

    public void setStepSize(float f) {
        if (f < 0.0f) {
            float f2 = this.valueFrom;
            float f3 = this.valueTo;
            throw new IllegalArgumentException("The stepSize(" + f + ") must be 0, or a factor of the valueFrom(" + f2 + ")-valueTo(" + f3 + ") range");
        } else if (this.stepSize != f) {
            this.stepSize = f;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setThumbElevation(float f) {
        this.defaultThumbDrawable.setElevation(f);
    }

    public void setThumbElevationResource(int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setThumbHeight(int i) {
        if (i != this.thumbHeight) {
            this.thumbHeight = i;
            this.defaultThumbDrawable.setBounds(0, 0, this.thumbWidth, i);
            Drawable drawable = this.customThumbDrawable;
            if (drawable != null) {
                adjustCustomThumbDrawableBounds(drawable);
            }
            for (Drawable drawable2 : this.customThumbDrawablesForValues) {
                adjustCustomThumbDrawableBounds(drawable2);
            }
            updateWidgetLayout(false);
        }
    }

    public void setThumbHeightResource(int i) {
        setThumbHeight(getResources().getDimensionPixelSize(i));
    }

    public void setThumbRadius(int i) {
        int i2 = i * 2;
        setThumbWidth(i2);
        setThumbHeight(i2);
    }

    public void setThumbRadiusResource(int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.defaultThumbDrawable.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i) {
        if (i != 0) {
            setThumbStrokeColor(BundleKt.getColorStateList(getContext(), i));
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setThumbStrokeWidth(float f) {
        MaterialShapeDrawable materialShapeDrawable = this.defaultThumbDrawable;
        materialShapeDrawable.drawableState.strokeWidth = f;
        materialShapeDrawable.invalidateSelf();
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.defaultThumbDrawable;
        if (!colorStateList.equals(materialShapeDrawable.drawableState.fillColor)) {
            materialShapeDrawable.setFillColor(colorStateList);
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setThumbTrackGapSize(int i) {
        if (this.thumbTrackGapSize != i) {
            this.thumbTrackGapSize = i;
            invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, com.google.android.material.shape.ShapeAppearanceModel] */
    @Override // com.google.android.material.slider.BaseSlider
    public void setThumbWidth(int i) {
        if (i != this.thumbWidth) {
            this.thumbWidth = i;
            ?? obj = new Object();
            ?? obj2 = new Object();
            ?? obj3 = new Object();
            ?? obj4 = new Object();
            float f = this.thumbWidth / 2.0f;
            LazyKt__LazyJVMKt createCornerTreatment = LazyKt__LazyJVMKt.createCornerTreatment(0);
            AbsoluteCornerSize absoluteCornerSize = new AbsoluteCornerSize(f);
            AbsoluteCornerSize absoluteCornerSize2 = new AbsoluteCornerSize(f);
            AbsoluteCornerSize absoluteCornerSize3 = new AbsoluteCornerSize(f);
            AbsoluteCornerSize absoluteCornerSize4 = new AbsoluteCornerSize(f);
            ?? obj5 = new Object();
            obj5.topLeftCorner = createCornerTreatment;
            obj5.topRightCorner = createCornerTreatment;
            obj5.bottomRightCorner = createCornerTreatment;
            obj5.bottomLeftCorner = createCornerTreatment;
            obj5.topLeftCornerSize = absoluteCornerSize;
            obj5.topRightCornerSize = absoluteCornerSize2;
            obj5.bottomRightCornerSize = absoluteCornerSize3;
            obj5.bottomLeftCornerSize = absoluteCornerSize4;
            obj5.topEdge = obj;
            obj5.rightEdge = obj2;
            obj5.bottomEdge = obj3;
            obj5.leftEdge = obj4;
            MaterialShapeDrawable materialShapeDrawable = this.defaultThumbDrawable;
            materialShapeDrawable.setShapeAppearanceModel(obj5);
            materialShapeDrawable.setBounds(0, 0, this.thumbWidth, this.thumbHeight);
            Drawable drawable = this.customThumbDrawable;
            if (drawable != null) {
                adjustCustomThumbDrawableBounds(drawable);
            }
            for (Drawable drawable2 : this.customThumbDrawablesForValues) {
                adjustCustomThumbDrawableBounds(drawable2);
            }
            updateWidgetLayout(false);
        }
    }

    public void setThumbWidthResource(int i) {
        setThumbWidth(getResources().getDimensionPixelSize(i));
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTickActiveRadius(int i) {
        if (this.tickActiveRadius != i) {
            this.tickActiveRadius = i;
            this.activeTicksPaint.setStrokeWidth(i * 2);
            updateWidgetLayout(false);
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.tickColorActive)) {
            this.tickColorActive = colorStateList;
            this.activeTicksPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTickInactiveRadius(int i) {
        if (this.tickInactiveRadius != i) {
            this.tickInactiveRadius = i;
            this.inactiveTicksPaint.setStrokeWidth(i * 2);
            updateWidgetLayout(false);
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.tickColorInactive)) {
            this.tickColorInactive = colorStateList;
            this.inactiveTicksPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisibilityMode(int i) {
        if (this.tickVisibilityMode != i) {
            this.tickVisibilityMode = i;
            postInvalidate();
        }
    }

    @Deprecated
    public void setTickVisible(boolean z) {
        int i;
        if (z) {
            i = 0;
        } else {
            i = 2;
        }
        setTickVisibilityMode(i);
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.trackColorActive)) {
            this.trackColorActive = colorStateList;
            this.activeTrackPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackCornerSize(int i) {
        if (this.trackCornerSize != i) {
            this.trackCornerSize = i;
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackHeight(int i) {
        if (this.trackThickness != i) {
            this.trackThickness = i;
            this.inactiveTrackPaint.setStrokeWidth(i);
            this.activeTrackPaint.setStrokeWidth(this.trackThickness);
            updateWidgetLayout(false);
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackIconActiveColor(ColorStateList colorStateList) {
        if (colorStateList != this.trackIconActiveColor) {
            this.trackIconActiveColor = colorStateList;
            updateTrackIconActiveStart();
            updateTrackIconActiveEnd();
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackIconActiveEnd(Drawable drawable) {
        if (drawable != this.trackIconActiveEnd) {
            this.trackIconActiveEnd = drawable;
            this.trackIconActiveEndMutated = false;
            updateTrackIconActiveEnd();
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackIconActiveStart(Drawable drawable) {
        if (drawable != this.trackIconActiveStart) {
            this.trackIconActiveStart = drawable;
            this.trackIconActiveStartMutated = false;
            updateTrackIconActiveStart();
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackIconInactiveColor(ColorStateList colorStateList) {
        if (colorStateList != this.trackIconInactiveColor) {
            this.trackIconInactiveColor = colorStateList;
            updateTrackIconInactiveStart();
            updateTrackIconInactiveEnd();
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackIconInactiveEnd(Drawable drawable) {
        if (drawable != this.trackIconInactiveEnd) {
            this.trackIconInactiveEnd = drawable;
            this.trackIconInactiveEndMutated = false;
            updateTrackIconInactiveEnd();
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackIconInactiveStart(Drawable drawable) {
        if (drawable != this.trackIconInactiveStart) {
            this.trackIconInactiveStart = drawable;
            this.trackIconInactiveStartMutated = false;
            updateTrackIconInactiveStart();
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackIconSize(int i) {
        if (this.trackIconSize != i) {
            this.trackIconSize = i;
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.trackColorInactive)) {
            this.trackColorInactive = colorStateList;
            this.inactiveTrackPaint.setColor(getColorForState(colorStateList));
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackInsideCornerSize(int i) {
        if (this.trackInsideCornerSize != i) {
            this.trackInsideCornerSize = i;
            invalidate();
        }
    }

    @Override // com.google.android.material.slider.BaseSlider
    public void setTrackStopIndicatorSize(int i) {
        if (this.trackStopIndicatorSize != i) {
            this.trackStopIndicatorSize = i;
            this.stopIndicatorPaint.setStrokeWidth(i);
            invalidate();
        }
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValue(float f) {
        setValues(Float.valueOf(f));
    }

    public void setValueFrom(float f) {
        this.valueFrom = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.valueTo = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setCustomThumbDrawable(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        adjustCustomThumbDrawableBounds(newDrawable);
        this.customThumbDrawable = newDrawable;
        this.customThumbDrawablesForValues.clear();
        postInvalidate();
    }

    public void setTrackIconActiveEnd(int i) {
        setTrackIconActiveEnd(i != 0 ? BundleKt.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconActiveStart(int i) {
        setTrackIconActiveStart(i != 0 ? BundleKt.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconInactiveEnd(int i) {
        setTrackIconInactiveEnd(i != 0 ? BundleKt.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconInactiveStart(int i) {
        setTrackIconInactiveStart(i != 0 ? BundleKt.getDrawable(getContext(), i) : null);
    }
}
