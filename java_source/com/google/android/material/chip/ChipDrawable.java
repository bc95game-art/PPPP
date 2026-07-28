package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.graphics.drawable.WrappedDrawableApi21;
import androidx.core.p002os.BundleKt;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class ChipDrawable extends MaterialShapeDrawable implements Drawable.Callback, TextDrawableHelper.TextDrawableDelegate {
    public static final int[] DEFAULT_STATE = {16842910};
    public static final ShapeDrawable closeIconRippleMask = new ShapeDrawable(new OvalShape());
    public boolean checkable;
    public Drawable checkedIcon;
    public ColorStateList checkedIconTint;
    public boolean checkedIconVisible;
    public ColorStateList chipBackgroundColor;
    public float chipEndPadding;
    public Drawable chipIcon;
    public float chipIconSize;
    public ColorStateList chipIconTint;
    public boolean chipIconVisible;
    public float chipMinHeight;
    public float chipStartPadding;
    public ColorStateList chipStrokeColor;
    public float chipStrokeWidth;
    public ColorStateList chipSurfaceColor;
    public Drawable closeIcon;
    public SpannableStringBuilder closeIconContentDescription;
    public float closeIconEndPadding;
    public RippleDrawable closeIconRipple;
    public float closeIconSize;
    public float closeIconStartPadding;
    public int[] closeIconStateSet;
    public ColorStateList closeIconTint;
    public boolean closeIconVisible;
    public ColorFilter colorFilter;
    public ColorStateList compatRippleColor;
    public final Context context;
    public boolean currentChecked;
    public int currentChipBackgroundColor;
    public int currentChipStrokeColor;
    public int currentChipSurfaceColor;
    public int currentCompatRippleColor;
    public int currentCompositeSurfaceBackgroundColor;
    public int currentTextColor;
    public int currentTint;
    public boolean hasChipIconTint;
    public MotionSpec hideMotionSpec;
    public float iconEndPadding;
    public float iconStartPadding;
    public boolean isShapeThemingEnabled;
    public int maxWidth;
    public ColorStateList rippleColor;
    public MotionSpec showMotionSpec;
    public final TextDrawableHelper textDrawableHelper;
    public float textEndPadding;
    public float textStartPadding;
    public ColorStateList tint;
    public PorterDuffColorFilter tintFilter;
    public TextUtils.TruncateAt truncateAt;
    public float chipCornerRadius = -1.0f;
    public final Paint chipPaint = new Paint(1);
    public final Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
    public final RectF rectF = new RectF();
    public final PointF pointF = new PointF();
    public final Path shapePath = new Path();
    public int alpha = 255;
    public PorterDuff.Mode tintMode = PorterDuff.Mode.SRC_IN;
    public WeakReference delegate = new WeakReference(null);
    public CharSequence text = "";
    public boolean shouldDrawText = true;

    /* loaded from: classes.dex */
    public interface Delegate {
    }

    public ChipDrawable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, C0130R.attr.chipStyle, C0130R.style.Widget_MaterialComponents_Chip_Action);
        initializeElevationOverlay(context);
        this.context = context;
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper = textDrawableHelper;
        textDrawableHelper.textPaint.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = DEFAULT_STATE;
        setState(iArr);
        setCloseIconState(iArr);
        closeIconRippleMask.setTint(-1);
    }

    public static void unapplyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final void applyChildDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            BundleKt.setLayoutDirection(drawable, BundleKt.getLayoutDirection(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.closeIcon) {
                if (drawable.isStateful()) {
                    drawable.setState(this.closeIconStateSet);
                }
                drawable.setTintList(this.closeIconTint);
                return;
            }
            Drawable drawable2 = this.chipIcon;
            if (drawable == drawable2 && this.hasChipIconTint) {
                drawable2.setTintList(this.chipIconTint);
            }
            if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    public final void calculateChipIconBounds(Rect rect, RectF rectF) {
        Drawable drawable;
        Drawable drawable2;
        rectF.setEmpty();
        if (showsChipIcon() || showsCheckedIcon()) {
            float f = this.chipStartPadding + this.iconStartPadding;
            if (this.currentChecked) {
                drawable = this.checkedIcon;
            } else {
                drawable = this.chipIcon;
            }
            float f2 = this.chipIconSize;
            if (f2 <= 0.0f && drawable != null) {
                f2 = drawable.getIntrinsicWidth();
            }
            if (BundleKt.getLayoutDirection(this) == 0) {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + f2;
            } else {
                float f4 = rect.right - f;
                rectF.right = f4;
                rectF.left = f4 - f2;
            }
            if (this.currentChecked) {
                drawable2 = this.checkedIcon;
            } else {
                drawable2 = this.chipIcon;
            }
            float f5 = this.chipIconSize;
            if (f5 <= 0.0f && drawable2 != null) {
                f5 = (float) Math.ceil(ViewUtils.dpToPx(this.context, 24));
                if (drawable2.getIntrinsicHeight() <= f5) {
                    f5 = drawable2.getIntrinsicHeight();
                }
            }
            float exactCenterY = rect.exactCenterY() - (f5 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f5;
        }
    }

    public final float calculateChipIconWidth() {
        Drawable drawable;
        if (!showsChipIcon() && !showsCheckedIcon()) {
            return 0.0f;
        }
        float f = this.iconStartPadding;
        if (this.currentChecked) {
            drawable = this.checkedIcon;
        } else {
            drawable = this.chipIcon;
        }
        float f2 = this.chipIconSize;
        if (f2 <= 0.0f && drawable != null) {
            f2 = drawable.getIntrinsicWidth();
        }
        return f2 + f + this.iconEndPadding;
    }

    public final float calculateCloseIconWidth() {
        if (showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }
        return 0.0f;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        int i2;
        Canvas canvas2;
        float f;
        boolean z;
        int i3;
        int i4;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && (i = this.alpha) != 0) {
            if (i < 255) {
                float f2 = bounds.left;
                float f3 = bounds.top;
                float f4 = bounds.right;
                float f5 = bounds.bottom;
                if (Build.VERSION.SDK_INT > 21) {
                    canvas2 = canvas;
                    i4 = canvas2.saveLayerAlpha(f2, f3, f4, f5, i);
                } else {
                    canvas2 = canvas;
                    i4 = canvas2.saveLayerAlpha(f2, f3, f4, f5, i, 31);
                }
                i2 = i4;
            } else {
                canvas2 = canvas;
                i2 = 0;
            }
            boolean z2 = this.isShapeThemingEnabled;
            Paint paint = this.chipPaint;
            RectF rectF = this.rectF;
            if (!z2) {
                paint.setColor(this.currentChipSurfaceColor);
                paint.setStyle(Paint.Style.FILL);
                rectF.set(bounds);
                canvas2.drawRoundRect(rectF, getChipCornerRadius(), getChipCornerRadius(), paint);
            }
            if (!this.isShapeThemingEnabled) {
                paint.setColor(this.currentChipBackgroundColor);
                paint.setStyle(Paint.Style.FILL);
                ColorFilter colorFilter = this.colorFilter;
                if (colorFilter == null) {
                    colorFilter = this.tintFilter;
                }
                paint.setColorFilter(colorFilter);
                rectF.set(bounds);
                canvas2.drawRoundRect(rectF, getChipCornerRadius(), getChipCornerRadius(), paint);
            }
            if (this.isShapeThemingEnabled) {
                super.draw(canvas);
            }
            if (this.chipStrokeWidth > 0.0f && !this.isShapeThemingEnabled) {
                paint.setColor(this.currentChipStrokeColor);
                paint.setStyle(Paint.Style.STROKE);
                if (!this.isShapeThemingEnabled) {
                    ColorFilter colorFilter2 = this.colorFilter;
                    if (colorFilter2 == null) {
                        colorFilter2 = this.tintFilter;
                    }
                    paint.setColorFilter(colorFilter2);
                }
                float f6 = this.chipStrokeWidth / 2.0f;
                rectF.set(bounds.left + f6, bounds.top + f6, bounds.right - f6, bounds.bottom - f6);
                float f7 = this.chipCornerRadius - (this.chipStrokeWidth / 2.0f);
                canvas2.drawRoundRect(rectF, f7, f7, paint);
            }
            paint.setColor(this.currentCompatRippleColor);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            if (!this.isShapeThemingEnabled) {
                canvas2.drawRoundRect(rectF, getChipCornerRadius(), getChipCornerRadius(), paint);
                f = 2.0f;
            } else {
                RectF rectF2 = new RectF(bounds);
                MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
                ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
                float[] fArr = this.springAnimatedCornerSizes;
                float f8 = materialShapeDrawableState.interpolation;
                MaterialShapeDrawable.C01961 r6 = this.pathShadowListener;
                ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
                f = 2.0f;
                Path path = this.shapePath;
                shapeAppearancePathProvider.calculatePath(shapeAppearanceModel, fArr, f8, rectF2, r6, path);
                drawShape(canvas2, paint, path, this.drawableState.shapeAppearanceModel, this.springAnimatedCornerSizes, getBoundsAsRectF());
            }
            if (showsChipIcon()) {
                calculateChipIconBounds(bounds, rectF);
                float f9 = rectF.left;
                float f10 = rectF.top;
                canvas2.translate(f9, f10);
                this.chipIcon.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
                this.chipIcon.draw(canvas2);
                canvas2.translate(-f9, -f10);
            }
            if (showsCheckedIcon()) {
                calculateChipIconBounds(bounds, rectF);
                float f11 = rectF.left;
                float f12 = rectF.top;
                canvas2.translate(f11, f12);
                this.checkedIcon.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
                this.checkedIcon.draw(canvas2);
                canvas2.translate(-f11, -f12);
            }
            if (this.shouldDrawText && this.text != null) {
                PointF pointF = this.pointF;
                pointF.set(0.0f, 0.0f);
                Paint.Align align = Paint.Align.LEFT;
                CharSequence charSequence = this.text;
                TextDrawableHelper textDrawableHelper = this.textDrawableHelper;
                if (charSequence != null) {
                    float calculateChipIconWidth = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                    if (BundleKt.getLayoutDirection(this) == 0) {
                        pointF.x = bounds.left + calculateChipIconWidth;
                    } else {
                        pointF.x = bounds.right - calculateChipIconWidth;
                        align = Paint.Align.RIGHT;
                    }
                    TextPaint textPaint = textDrawableHelper.textPaint;
                    Paint.FontMetrics fontMetrics = this.fontMetrics;
                    textPaint.getFontMetrics(fontMetrics);
                    pointF.y = bounds.centerY() - ((fontMetrics.descent + fontMetrics.ascent) / f);
                }
                rectF.setEmpty();
                if (this.text != null) {
                    float calculateChipIconWidth2 = calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding;
                    float calculateCloseIconWidth = calculateCloseIconWidth() + this.chipEndPadding + this.textEndPadding;
                    if (BundleKt.getLayoutDirection(this) == 0) {
                        rectF.left = bounds.left + calculateChipIconWidth2;
                        rectF.right = bounds.right - calculateCloseIconWidth;
                    } else {
                        rectF.left = bounds.left + calculateCloseIconWidth;
                        rectF.right = bounds.right - calculateChipIconWidth2;
                    }
                    rectF.top = bounds.top;
                    rectF.bottom = bounds.bottom;
                }
                TextAppearance textAppearance = textDrawableHelper.textAppearance;
                TextPaint textPaint2 = textDrawableHelper.textPaint;
                if (textAppearance != null) {
                    textPaint2.drawableState = getState();
                    textDrawableHelper.textAppearance.updateDrawState(this.context, textPaint2, textDrawableHelper.fontCallback);
                }
                textPaint2.setTextAlign(align);
                if (Math.round(textDrawableHelper.getTextWidth(this.text.toString())) > Math.round(rectF.width())) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int save = canvas2.save();
                    canvas2.clipRect(rectF);
                    i3 = save;
                } else {
                    i3 = 0;
                }
                CharSequence charSequence2 = this.text;
                if (z && this.truncateAt != null) {
                    charSequence2 = TextUtils.ellipsize(charSequence2, textPaint2, rectF.width(), this.truncateAt);
                }
                canvas.drawText(charSequence2, 0, charSequence2.length(), pointF.x, pointF.y, textPaint2);
                canvas2 = canvas;
                if (z) {
                    canvas2.restoreToCount(i3);
                }
            }
            if (showsCloseIcon()) {
                rectF.setEmpty();
                if (showsCloseIcon()) {
                    float f13 = this.chipEndPadding + this.closeIconEndPadding;
                    if (BundleKt.getLayoutDirection(this) == 0) {
                        float f14 = bounds.right - f13;
                        rectF.right = f14;
                        rectF.left = f14 - this.closeIconSize;
                    } else {
                        float f15 = bounds.left + f13;
                        rectF.left = f15;
                        rectF.right = f15 + this.closeIconSize;
                    }
                    float exactCenterY = bounds.exactCenterY();
                    float f16 = this.closeIconSize;
                    float f17 = exactCenterY - (f16 / f);
                    rectF.top = f17;
                    rectF.bottom = f17 + f16;
                }
                float f18 = rectF.left;
                float f19 = rectF.top;
                canvas2.translate(f18, f19);
                this.closeIcon.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(canvas2);
                canvas2.translate(-f18, -f19);
            }
            if (this.alpha < 255) {
                canvas2.restoreToCount(i2);
            }
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.alpha;
    }

    public final float getChipCornerRadius() {
        if (this.isShapeThemingEnabled) {
            return getTopLeftCornerResolvedSize();
        }
        return this.chipCornerRadius;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.chipMinHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(calculateCloseIconWidth() + this.textDrawableHelper.getTextWidth(this.text.toString()) + calculateChipIconWidth() + this.chipStartPadding + this.textStartPadding + this.textEndPadding + this.chipEndPadding), this.maxWidth);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.isShapeThemingEnabled) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.chipCornerRadius);
            outline2 = outline;
        } else {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.chipMinHeight, this.chipCornerRadius);
        }
        outline2.setAlpha(this.alpha / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (isStateful(this.chipSurfaceColor) || isStateful(this.chipBackgroundColor) || isStateful(this.chipStrokeColor)) {
            return true;
        }
        TextAppearance textAppearance = this.textDrawableHelper.textAppearance;
        if (textAppearance == null || (colorStateList = textAppearance.textColor) == null || !colorStateList.isStateful()) {
            return (this.checkedIconVisible && this.checkedIcon != null && this.checkable) || isStateful(this.chipIcon) || isStateful(this.checkedIcon) || isStateful(this.tint);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (showsChipIcon()) {
            onLayoutDirectionChanged |= BundleKt.setLayoutDirection(this.chipIcon, i);
        }
        if (showsCheckedIcon()) {
            onLayoutDirectionChanged |= BundleKt.setLayoutDirection(this.checkedIcon, i);
        }
        if (showsCloseIcon()) {
            onLayoutDirectionChanged |= BundleKt.setLayoutDirection(this.closeIcon, i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (showsChipIcon()) {
            onLevelChange |= this.chipIcon.setLevel(i);
        }
        if (showsCheckedIcon()) {
            onLevelChange |= this.checkedIcon.setLevel(i);
        }
        if (showsCloseIcon()) {
            onLevelChange |= this.closeIcon.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    public final void onSizeChange() {
        Delegate delegate = (Delegate) this.delegate.get();
        if (delegate != null) {
            Chip chip = (Chip) delegate;
            chip.ensureAccessibleTouchTarget(chip.minTouchTargetSize);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final boolean onStateChange(int[] iArr) {
        if (this.isShapeThemingEnabled) {
            super.onStateChange(iArr);
        }
        return onStateChange(iArr, this.closeIconStateSet);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public final void onTextSizeChange() {
        onSizeChange();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.alpha != i) {
            this.alpha = i;
            invalidateSelf();
        }
    }

    public final void setCheckable(boolean z) {
        if (this.checkable != z) {
            this.checkable = z;
            float calculateChipIconWidth = calculateChipIconWidth();
            if (!z && this.currentChecked) {
                this.currentChecked = false;
            }
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setCheckedIcon(Drawable drawable) {
        if (this.checkedIcon != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.checkedIcon = drawable;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(this.checkedIcon);
            applyChildDrawable(this.checkedIcon);
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setCheckedIconTint(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.checkedIconTint != colorStateList) {
            this.checkedIconTint = colorStateList;
            if (this.checkedIconVisible && (drawable = this.checkedIcon) != null && this.checkable) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setCheckedIconVisible(boolean z) {
        if (this.checkedIconVisible != z) {
            boolean showsCheckedIcon = showsCheckedIcon();
            this.checkedIconVisible = z;
            boolean showsCheckedIcon2 = showsCheckedIcon();
            if (showsCheckedIcon != showsCheckedIcon2) {
                if (showsCheckedIcon2) {
                    applyChildDrawable(this.checkedIcon);
                } else {
                    unapplyChildDrawable(this.checkedIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public final void setChipCornerRadius(float f) {
        if (this.chipCornerRadius != f) {
            this.chipCornerRadius = f;
            ShapeAppearanceModel.Builder builder = this.drawableState.shapeAppearanceModel.toBuilder();
            builder.setAllCornerSizes(f);
            setShapeAppearanceModel(builder.build());
        }
    }

    public final void setChipIcon(Drawable drawable) {
        Drawable drawable2 = this.chipIcon;
        Drawable drawable3 = null;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof WrappedDrawable) {
            drawable2 = ((WrappedDrawableApi21) ((WrappedDrawable) drawable2)).mDrawable;
        }
        if (drawable2 != drawable) {
            float calculateChipIconWidth = calculateChipIconWidth();
            if (drawable != null) {
                drawable3 = BundleKt.wrap(drawable).mutate();
            }
            this.chipIcon = drawable3;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            unapplyChildDrawable(drawable2);
            if (showsChipIcon()) {
                applyChildDrawable(this.chipIcon);
            }
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setChipIconSize(float f) {
        if (this.chipIconSize != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.chipIconSize = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setChipIconTint(ColorStateList colorStateList) {
        this.hasChipIconTint = true;
        if (this.chipIconTint != colorStateList) {
            this.chipIconTint = colorStateList;
            if (showsChipIcon()) {
                this.chipIcon.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setChipIconVisible(boolean z) {
        if (this.chipIconVisible != z) {
            boolean showsChipIcon = showsChipIcon();
            this.chipIconVisible = z;
            boolean showsChipIcon2 = showsChipIcon();
            if (showsChipIcon != showsChipIcon2) {
                if (showsChipIcon2) {
                    applyChildDrawable(this.chipIcon);
                } else {
                    unapplyChildDrawable(this.chipIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    public final void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.chipStrokeColor != colorStateList) {
            this.chipStrokeColor = colorStateList;
            if (this.isShapeThemingEnabled) {
                setStrokeColor(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setChipStrokeWidth(float f) {
        if (this.chipStrokeWidth != f) {
            this.chipStrokeWidth = f;
            this.chipPaint.setStrokeWidth(f);
            if (this.isShapeThemingEnabled) {
                this.drawableState.strokeWidth = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void setCloseIcon(Drawable drawable) {
        Drawable drawable2 = this.closeIcon;
        Drawable drawable3 = null;
        if (drawable2 == null) {
            drawable2 = null;
        } else if (drawable2 instanceof WrappedDrawable) {
            drawable2 = ((WrappedDrawableApi21) ((WrappedDrawable) drawable2)).mDrawable;
        }
        if (drawable2 != drawable) {
            float calculateCloseIconWidth = calculateCloseIconWidth();
            if (drawable != null) {
                drawable3 = BundleKt.wrap(drawable).mutate();
            }
            this.closeIcon = drawable3;
            this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), this.closeIcon, closeIconRippleMask);
            float calculateCloseIconWidth2 = calculateCloseIconWidth();
            unapplyChildDrawable(drawable2);
            if (showsCloseIcon()) {
                applyChildDrawable(this.closeIcon);
            }
            invalidateSelf();
            if (calculateCloseIconWidth != calculateCloseIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setCloseIconEndPadding(float f) {
        if (this.closeIconEndPadding != f) {
            this.closeIconEndPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public final void setCloseIconSize(float f) {
        if (this.closeIconSize != f) {
            this.closeIconSize = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public final void setCloseIconStartPadding(float f) {
        if (this.closeIconStartPadding != f) {
            this.closeIconStartPadding = f;
            invalidateSelf();
            if (showsCloseIcon()) {
                onSizeChange();
            }
        }
    }

    public final boolean setCloseIconState(int[] iArr) {
        if (Arrays.equals(this.closeIconStateSet, iArr)) {
            return false;
        }
        this.closeIconStateSet = iArr;
        if (showsCloseIcon()) {
            return onStateChange(getState(), iArr);
        }
        return false;
    }

    public final void setCloseIconTint(ColorStateList colorStateList) {
        if (this.closeIconTint != colorStateList) {
            this.closeIconTint = colorStateList;
            if (showsCloseIcon()) {
                this.closeIcon.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void setCloseIconVisible(boolean z) {
        if (this.closeIconVisible != z) {
            boolean showsCloseIcon = showsCloseIcon();
            this.closeIconVisible = z;
            boolean showsCloseIcon2 = showsCloseIcon();
            if (showsCloseIcon != showsCloseIcon2) {
                if (showsCloseIcon2) {
                    applyChildDrawable(this.closeIcon);
                } else {
                    unapplyChildDrawable(this.closeIcon);
                }
                invalidateSelf();
                onSizeChange();
            }
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.colorFilter != colorFilter) {
            this.colorFilter = colorFilter;
            invalidateSelf();
        }
    }

    public final void setIconEndPadding(float f) {
        if (this.iconEndPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconEndPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setIconStartPadding(float f) {
        if (this.iconStartPadding != f) {
            float calculateChipIconWidth = calculateChipIconWidth();
            this.iconStartPadding = f;
            float calculateChipIconWidth2 = calculateChipIconWidth();
            invalidateSelf();
            if (calculateChipIconWidth != calculateChipIconWidth2) {
                onSizeChange();
            }
        }
    }

    public final void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleColor != colorStateList) {
            this.rippleColor = colorStateList;
            this.compatRippleColor = null;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.tint != colorStateList) {
            this.tint = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        if (this.tintMode != mode) {
            this.tintMode = mode;
            ColorStateList colorStateList = this.tint;
            if (colorStateList == null || mode == null) {
                porterDuffColorFilter = null;
            } else {
                porterDuffColorFilter = new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            }
            this.tintFilter = porterDuffColorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (showsChipIcon()) {
            visible |= this.chipIcon.setVisible(z, z2);
        }
        if (showsCheckedIcon()) {
            visible |= this.checkedIcon.setVisible(z, z2);
        }
        if (showsCloseIcon()) {
            visible |= this.closeIcon.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final boolean showsCheckedIcon() {
        if (!this.checkedIconVisible || this.checkedIcon == null || !this.currentChecked) {
            return false;
        }
        return true;
    }

    public final boolean showsChipIcon() {
        if (!this.chipIconVisible || this.chipIcon == null) {
            return false;
        }
        return true;
    }

    public final boolean showsCloseIcon() {
        if (!this.closeIconVisible || this.closeIcon == null) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onStateChange(int[] iArr, int[] iArr2) {
        int i;
        int colorForState;
        int[] state;
        boolean z;
        boolean z2;
        int colorForState2;
        float calculateChipIconWidth;
        ColorStateList colorStateList;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.chipSurfaceColor;
        int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.currentChipSurfaceColor) : 0);
        boolean z3 = true;
        if (this.currentChipSurfaceColor != compositeElevationOverlayIfNeeded) {
            this.currentChipSurfaceColor = compositeElevationOverlayIfNeeded;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.chipBackgroundColor;
        int compositeElevationOverlayIfNeeded2 = compositeElevationOverlayIfNeeded(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.currentChipBackgroundColor) : 0);
        if (this.currentChipBackgroundColor != compositeElevationOverlayIfNeeded2) {
            this.currentChipBackgroundColor = compositeElevationOverlayIfNeeded2;
            onStateChange = true;
        }
        int compositeColors = ColorUtils.compositeColors(compositeElevationOverlayIfNeeded2, compositeElevationOverlayIfNeeded);
        if ((this.currentCompositeSurfaceBackgroundColor != compositeColors) || (this.drawableState.fillColor == null)) {
            this.currentCompositeSurfaceBackgroundColor = compositeColors;
            setFillColor(ColorStateList.valueOf(compositeColors));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.chipStrokeColor;
        int colorForState3 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.currentChipStrokeColor) : 0;
        if (this.currentChipStrokeColor != colorForState3) {
            this.currentChipStrokeColor = colorForState3;
            onStateChange = true;
        }
        if (this.compatRippleColor != null) {
            boolean z4 = false;
            boolean z5 = false;
            for (int i2 : iArr) {
                if (i2 == 16842910) {
                    z4 = true;
                } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                    z5 = true;
                }
            }
            if (z4 && z5) {
                i = this.compatRippleColor.getColorForState(iArr, this.currentCompatRippleColor);
                if (this.currentCompatRippleColor != i) {
                    this.currentCompatRippleColor = i;
                }
                TextAppearance textAppearance = this.textDrawableHelper.textAppearance;
                colorForState = (textAppearance != null || (colorStateList = textAppearance.textColor) == null) ? 0 : colorStateList.getColorForState(iArr, this.currentTextColor);
                if (this.currentTextColor != colorForState) {
                    this.currentTextColor = colorForState;
                    onStateChange = true;
                }
                state = getState();
                if (state != null) {
                    int length = state.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (state[i3] != 16842912) {
                            i3++;
                        } else if (this.checkable) {
                            z = true;
                        }
                    }
                    if (!(this.currentChecked == z || this.checkedIcon == null)) {
                        calculateChipIconWidth = calculateChipIconWidth();
                        this.currentChecked = z;
                        if (calculateChipIconWidth == calculateChipIconWidth()) {
                            onStateChange = true;
                            z2 = true;
                            ColorStateList colorStateList5 = this.tint;
                            colorForState2 = colorStateList5 == null ? colorStateList5.getColorForState(iArr, this.currentTint) : 0;
                            if (this.currentTint == colorForState2) {
                                this.currentTint = colorForState2;
                                ColorStateList colorStateList6 = this.tint;
                                PorterDuff.Mode mode = this.tintMode;
                                this.tintFilter = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
                            } else {
                                z3 = onStateChange;
                            }
                            if (isStateful(this.chipIcon)) {
                                z3 |= this.chipIcon.setState(iArr);
                            }
                            if (isStateful(this.checkedIcon)) {
                                z3 |= this.checkedIcon.setState(iArr);
                            }
                            if (isStateful(this.closeIcon)) {
                                int[] iArr3 = new int[iArr.length + iArr2.length];
                                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                                System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
                                z3 |= this.closeIcon.setState(iArr3);
                            }
                            if (isStateful(this.closeIconRipple)) {
                                z3 |= this.closeIconRipple.setState(iArr2);
                            }
                            if (z3) {
                                invalidateSelf();
                            }
                            if (z2) {
                                onSizeChange();
                            }
                            return z3;
                        }
                        onStateChange = true;
                    }
                    z2 = false;
                    ColorStateList colorStateList52 = this.tint;
                    if (colorStateList52 == null) {
                    }
                    if (this.currentTint == colorForState2) {
                    }
                    if (isStateful(this.chipIcon)) {
                    }
                    if (isStateful(this.checkedIcon)) {
                    }
                    if (isStateful(this.closeIcon)) {
                    }
                    if (isStateful(this.closeIconRipple)) {
                    }
                    if (z3) {
                    }
                    if (z2) {
                    }
                    return z3;
                }
                z = false;
                if (this.currentChecked == z) {
                    calculateChipIconWidth = calculateChipIconWidth();
                    this.currentChecked = z;
                    if (calculateChipIconWidth == calculateChipIconWidth()) {
                    }
                }
                z2 = false;
                ColorStateList colorStateList522 = this.tint;
                if (colorStateList522 == null) {
                }
                if (this.currentTint == colorForState2) {
                }
                if (isStateful(this.chipIcon)) {
                }
                if (isStateful(this.checkedIcon)) {
                }
                if (isStateful(this.closeIcon)) {
                }
                if (isStateful(this.closeIconRipple)) {
                }
                if (z3) {
                }
                if (z2) {
                }
                return z3;
            }
        }
        i = 0;
        if (this.currentCompatRippleColor != i) {
        }
        TextAppearance textAppearance2 = this.textDrawableHelper.textAppearance;
        if (textAppearance2 != null) {
        }
        if (this.currentTextColor != colorForState) {
        }
        state = getState();
        if (state != null) {
        }
        z = false;
        if (this.currentChecked == z) {
        }
        z2 = false;
        ColorStateList colorStateList5222 = this.tint;
        if (colorStateList5222 == null) {
        }
        if (this.currentTint == colorForState2) {
        }
        if (isStateful(this.chipIcon)) {
        }
        if (isStateful(this.checkedIcon)) {
        }
        if (isStateful(this.closeIcon)) {
        }
        if (isStateful(this.closeIconRipple)) {
        }
        if (z3) {
        }
        if (z2) {
        }
        return z3;
    }

    public static boolean isStateful(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean isStateful(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }
}
