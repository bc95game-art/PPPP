package com.google.android.material.shape;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.p002os.BundleKt;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.tracing.Trace;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.util.BitSet;
import kotlin.LazyKt__LazyJVMKt;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    public static final SpringAnimatedCornerSizeProperty[] CORNER_SIZES_IN_PX = new SpringAnimatedCornerSizeProperty[4];
    public static final Paint clearPaint;
    public boolean boundsIsEmpty;
    public final BitSet containsIncompatibleShadowOp;
    public final ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    public final SpringAnimation[] cornerSpringAnimations;
    public SpringForce cornerSpringForce;
    public MaterialShapeDrawableState drawableState;
    public final ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    public final Paint fillPaint;
    public final RectF insetRectF;
    public final Matrix matrix;
    public InputConnectionCompat$$ExternalSyntheticLambda0 onCornerSizeChangeListener;
    public final Path path;
    public final RectF pathBounds;
    public boolean pathDirty;
    public final Path pathInsetByStroke;
    public final ShapeAppearancePathProvider pathProvider;
    public final C01961 pathShadowListener;
    public final RectF rectF;
    public int resolvedTintColor;
    public final Region scratchRegion;
    public boolean shadowBitmapDrawingEnable;
    public final ShadowRenderer shadowRenderer;
    public float[] springAnimatedCornerSizes;
    public float[] springAnimatedStrokeCornerSizes;
    public final C01961 strokeInsetCornerSizeUnaryOperator;
    public final Paint strokePaint;
    public boolean strokePathDirty;
    public ShapeAppearanceModel strokeShapeAppearanceModel;
    public PorterDuffColorFilter strokeTintFilter;
    public PorterDuffColorFilter tintFilter;
    public final Region transparentRegion;

    /* renamed from: com.google.android.material.shape.MaterialShapeDrawable$1 */
    /* loaded from: classes.dex */
    public final class C01961 {
        public /* synthetic */ C01961() {
        }

        public CornerSize apply(CornerSize cornerSize) {
            if (cornerSize instanceof RelativeCornerSize) {
                return cornerSize;
            }
            return new AdjustedCornerSize(-MaterialShapeDrawable.this.getStrokeInsetLength(), cornerSize);
        }
    }

    /* loaded from: classes.dex */
    public final class SpringAnimatedCornerSizeProperty extends BundleKt {
        public final int index;

        public SpringAnimatedCornerSizeProperty(int i) {
            this.index = i;
        }

        @Override // androidx.core.p002os.BundleKt
        public final float getValue(Shapeable shapeable) {
            float[] fArr = ((MaterialShapeDrawable) shapeable).springAnimatedCornerSizes;
            if (fArr != null) {
                return fArr[this.index];
            }
            return 0.0f;
        }

        @Override // androidx.core.p002os.BundleKt
        public final void setValue(Shapeable shapeable, float f) {
            MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) shapeable;
            float[] fArr = materialShapeDrawable.springAnimatedCornerSizes;
            if (fArr != null) {
                int i = this.index;
                if (fArr[i] != f) {
                    fArr[i] = f;
                    InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda0 = materialShapeDrawable.onCornerSizeChangeListener;
                    if (inputConnectionCompat$$ExternalSyntheticLambda0 != null) {
                        float cornerSizeDiffX = materialShapeDrawable.getCornerSizeDiffX();
                        MaterialButton materialButton = (MaterialButton) inputConnectionCompat$$ExternalSyntheticLambda0.f$0;
                        int i2 = (int) (cornerSizeDiffX * 0.11f);
                        if (materialButton.opticalCenterShift != i2) {
                            materialButton.opticalCenterShift = i2;
                            materialButton.updatePaddingsAndSizeForWidthAnimation();
                            materialButton.invalidate();
                        }
                    }
                    materialShapeDrawable.invalidateSelf();
                }
            }
        }
    }

    static {
        Paint paint = new Paint(1);
        clearPaint = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        int i = 0;
        while (true) {
            SpringAnimatedCornerSizeProperty[] springAnimatedCornerSizePropertyArr = CORNER_SIZES_IN_PX;
            if (i < springAnimatedCornerSizePropertyArr.length) {
                springAnimatedCornerSizePropertyArr[i] = new SpringAnimatedCornerSizeProperty(i);
                i++;
            } else {
                return;
            }
        }
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    public static float calculateRoundRectCornerSize(RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float[] fArr) {
        if (fArr != null) {
            if (fArr.length > 1) {
                float f = fArr[0];
                for (int i = 1; i < fArr.length; i++) {
                    if (fArr[i] != f) {
                        return -1.0f;
                    }
                }
            }
            if (shapeAppearanceModel.hasRoundedCorners()) {
                return fArr[0];
            }
            return -1.0f;
        } else if (shapeAppearanceModel.isRoundRect(rectF)) {
            return shapeAppearanceModel.topLeftCornerSize.getCornerSize(rectF);
        } else {
            return -1.0f;
        }
    }

    public final void calculatePath(RectF rectF, Path path) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        this.pathProvider.calculatePath(materialShapeDrawableState.shapeAppearanceModel, this.springAnimatedCornerSizes, materialShapeDrawableState.interpolation, rectF, this.pathShadowListener, path);
        if (this.drawableState.scale != 1.0f) {
            Matrix matrix = this.matrix;
            matrix.reset();
            float f = this.drawableState.scale;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.pathBounds, true);
    }

    public final int compositeElevationOverlayIfNeeded(int i) {
        float f;
        int i2;
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        float f2 = materialShapeDrawableState.elevation + 0.0f + materialShapeDrawableState.parentAbsoluteElevation;
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
        if (elevationOverlayProvider == null || !elevationOverlayProvider.elevationOverlayEnabled || ColorUtils.setAlphaComponent(i, 255) != elevationOverlayProvider.colorSurface) {
            return i;
        }
        float f3 = elevationOverlayProvider.displayDensity;
        if (f3 <= 0.0f || f2 <= 0.0f) {
            f = 0.0f;
        } else {
            f = Math.min(((((float) Math.log1p(f2 / f3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        int alpha = Color.alpha(i);
        int layer = LazyKt__LazyJVMKt.layer(ColorUtils.setAlphaComponent(i, 255), f, elevationOverlayProvider.elevationOverlayColor);
        if (f > 0.0f && (i2 = elevationOverlayProvider.elevationOverlayAccentColor) != 0) {
            layer = ColorUtils.compositeColors(ColorUtils.setAlphaComponent(i2, ElevationOverlayProvider.OVERLAY_ACCENT_COLOR_ALPHA), layer);
        }
        return ColorUtils.setAlphaComponent(layer, alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint;
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        Paint paint2 = this.fillPaint;
        paint2.setColorFilter(porterDuffColorFilter);
        int alpha = paint2.getAlpha();
        int i = this.drawableState.alpha;
        paint2.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        Paint paint3 = this.strokePaint;
        paint3.setColorFilter(porterDuffColorFilter2);
        paint3.setStrokeWidth(this.drawableState.strokeWidth);
        int alpha2 = paint3.getAlpha();
        int i2 = this.drawableState.alpha;
        paint3.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        Paint.Style style = this.drawableState.paintStyle;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            boolean z = this.pathDirty;
            paint = paint2;
            Path path = this.path;
            if (z) {
                calculatePath(getBoundsAsRectF(), path);
                this.pathDirty = false;
            }
            MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
            int i3 = materialShapeDrawableState.shadowCompatMode;
            if (i3 != 1 && materialShapeDrawableState.shadowCompatRadius > 0 && (i3 == 2 || (!isRoundRect() && !path.isConvex() && Build.VERSION.SDK_INT < 29))) {
                canvas.save();
                double d = 0;
                canvas.translate((int) (Math.sin(Math.toRadians(d)) * this.drawableState.shadowCompatOffset), (int) (Math.cos(Math.toRadians(d)) * this.drawableState.shadowCompatOffset));
                if (!this.shadowBitmapDrawingEnable) {
                    drawCompatShadow(canvas);
                    canvas.restore();
                } else {
                    RectF rectF = this.pathBounds;
                    int width = (int) (rectF.width() - getBounds().width());
                    int height = (int) (rectF.height() - getBounds().height());
                    if (width < 0 || height < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap createBitmap = Bitmap.createBitmap((this.drawableState.shadowCompatRadius * 2) + ((int) rectF.width()) + width, (this.drawableState.shadowCompatRadius * 2) + ((int) rectF.height()) + height, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(createBitmap);
                    float f = (getBounds().left - this.drawableState.shadowCompatRadius) - width;
                    float f2 = (getBounds().top - this.drawableState.shadowCompatRadius) - height;
                    canvas2.translate(-f, -f2);
                    drawCompatShadow(canvas2);
                    canvas.drawBitmap(createBitmap, f, f2, (Paint) null);
                    createBitmap.recycle();
                    canvas.restore();
                }
            }
            drawShape(canvas, paint, path, this.drawableState.shapeAppearanceModel, this.springAnimatedCornerSizes, getBoundsAsRectF());
        } else {
            paint = paint2;
        }
        if (hasStroke()) {
            if (this.strokePathDirty) {
                ShapeAppearanceModel shapeAppearanceModel = this.drawableState.shapeAppearanceModel;
                ShapeAppearanceModel.Builder builder = shapeAppearanceModel.toBuilder();
                CornerSize cornerSize = shapeAppearanceModel.topLeftCornerSize;
                C01961 r5 = this.strokeInsetCornerSizeUnaryOperator;
                builder.topLeftCornerSize = r5.apply(cornerSize);
                builder.topRightCornerSize = r5.apply(shapeAppearanceModel.topRightCornerSize);
                builder.bottomLeftCornerSize = r5.apply(shapeAppearanceModel.bottomLeftCornerSize);
                builder.bottomRightCornerSize = r5.apply(shapeAppearanceModel.bottomRightCornerSize);
                this.strokeShapeAppearanceModel = builder.build();
                float[] fArr = this.springAnimatedCornerSizes;
                if (fArr != null) {
                    if (this.springAnimatedStrokeCornerSizes == null) {
                        this.springAnimatedStrokeCornerSizes = new float[fArr.length];
                    }
                    float strokeInsetLength = getStrokeInsetLength();
                    int i4 = 0;
                    while (true) {
                        float[] fArr2 = this.springAnimatedCornerSizes;
                        if (i4 >= fArr2.length) {
                            break;
                        }
                        this.springAnimatedStrokeCornerSizes[i4] = Math.max(0.0f, fArr2[i4] - strokeInsetLength);
                        i4++;
                    }
                } else {
                    this.springAnimatedStrokeCornerSizes = null;
                }
                ShapeAppearanceModel shapeAppearanceModel2 = this.strokeShapeAppearanceModel;
                float[] fArr3 = this.springAnimatedStrokeCornerSizes;
                float f3 = this.drawableState.interpolation;
                RectF boundsAsRectF = getBoundsAsRectF();
                RectF rectF2 = this.insetRectF;
                rectF2.set(boundsAsRectF);
                float strokeInsetLength2 = getStrokeInsetLength();
                rectF2.inset(strokeInsetLength2, strokeInsetLength2);
                this.pathProvider.calculatePath(shapeAppearanceModel2, fArr3, f3, rectF2, null, this.pathInsetByStroke);
                this.strokePathDirty = false;
            }
            drawStrokeShape(canvas);
        }
        paint.setAlpha(alpha);
        paint3.setAlpha(alpha2);
    }

    public final void drawCompatShadow(Canvas canvas) {
        if (this.containsIncompatibleShadowOp.cardinality() > 0) {
            Log.w("MaterialShapeDrawable", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i = this.drawableState.shadowCompatOffset;
        Path path = this.path;
        ShadowRenderer shadowRenderer = this.shadowRenderer;
        if (i != 0) {
            canvas.drawPath(path, shadowRenderer.shadowPaint);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            ShapePath.ShadowCompatOperation shadowCompatOperation = this.cornerShadowOperation[i2];
            int i3 = this.drawableState.shadowCompatRadius;
            Matrix matrix = ShapePath.ShadowCompatOperation.IDENTITY_MATRIX;
            shadowCompatOperation.draw(matrix, shadowRenderer, i3, canvas);
            this.edgeShadowOperation[i2].draw(matrix, shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            double d = 0;
            int sin = (int) (Math.sin(Math.toRadians(d)) * this.drawableState.shadowCompatOffset);
            int cos = (int) (Math.cos(Math.toRadians(d)) * this.drawableState.shadowCompatOffset);
            canvas.translate(-sin, -cos);
            canvas.drawPath(path, clearPaint);
            canvas.translate(sin, cos);
        }
    }

    public final void drawShape(Canvas canvas, Paint paint, Path path, ShapeAppearanceModel shapeAppearanceModel, float[] fArr, RectF rectF) {
        float calculateRoundRectCornerSize = calculateRoundRectCornerSize(rectF, shapeAppearanceModel, fArr);
        if (calculateRoundRectCornerSize >= 0.0f) {
            float f = calculateRoundRectCornerSize * this.drawableState.interpolation;
            canvas.drawRoundRect(rectF, f, f, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    public void drawStrokeShape(Canvas canvas) {
        ShapeAppearanceModel shapeAppearanceModel = this.strokeShapeAppearanceModel;
        float[] fArr = this.springAnimatedStrokeCornerSizes;
        RectF boundsAsRectF = getBoundsAsRectF();
        RectF rectF = this.insetRectF;
        rectF.set(boundsAsRectF);
        float strokeInsetLength = getStrokeInsetLength();
        rectF.inset(strokeInsetLength, strokeInsetLength);
        drawShape(canvas, this.strokePaint, this.pathInsetByStroke, shapeAppearanceModel, fArr, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.drawableState.alpha;
    }

    public final RectF getBoundsAsRectF() {
        Rect bounds = getBounds();
        RectF rectF = this.rectF;
        rectF.set(bounds);
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public final float getCornerSizeDiffX() {
        float[] fArr = this.springAnimatedCornerSizes;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF boundsAsRectF = getBoundsAsRectF();
        ShapeAppearanceModel shapeAppearanceModel = this.drawableState.shapeAppearanceModel;
        ShapeAppearancePathProvider shapeAppearancePathProvider = this.pathProvider;
        shapeAppearancePathProvider.getClass();
        float cornerSize = shapeAppearanceModel.topLeftCornerSize.getCornerSize(boundsAsRectF);
        ShapeAppearanceModel shapeAppearanceModel2 = this.drawableState.shapeAppearanceModel;
        shapeAppearancePathProvider.getClass();
        float cornerSize2 = shapeAppearanceModel2.bottomLeftCornerSize.getCornerSize(boundsAsRectF) + cornerSize;
        ShapeAppearanceModel shapeAppearanceModel3 = this.drawableState.shapeAppearanceModel;
        shapeAppearancePathProvider.getClass();
        float cornerSize3 = cornerSize2 - shapeAppearanceModel3.bottomRightCornerSize.getCornerSize(boundsAsRectF);
        ShapeAppearanceModel shapeAppearanceModel4 = this.drawableState.shapeAppearanceModel;
        shapeAppearancePathProvider.getClass();
        return (cornerSize3 - shapeAppearanceModel4.topRightCornerSize.getCornerSize(boundsAsRectF)) / 2.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.drawableState.shadowCompatMode != 2) {
            RectF boundsAsRectF = getBoundsAsRectF();
            if (!boundsAsRectF.isEmpty()) {
                float calculateRoundRectCornerSize = calculateRoundRectCornerSize(boundsAsRectF, this.drawableState.shapeAppearanceModel, this.springAnimatedCornerSizes);
                if (calculateRoundRectCornerSize >= 0.0f) {
                    outline.setRoundRect(getBounds(), calculateRoundRectCornerSize * this.drawableState.interpolation);
                    return;
                }
                boolean z = this.pathDirty;
                Path path = this.path;
                if (z) {
                    calculatePath(boundsAsRectF, path);
                    this.pathDirty = false;
                }
                Trace.setOutlineToPath(outline, path);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.drawableState.padding;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    public final float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final float getTopLeftCornerResolvedSize() {
        float[] fArr = this.springAnimatedCornerSizes;
        if (fArr != null) {
            return fArr[3];
        }
        return this.drawableState.shapeAppearanceModel.topLeftCornerSize.getCornerSize(getBoundsAsRectF());
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.transparentRegion;
        region.set(bounds);
        RectF boundsAsRectF = getBoundsAsRectF();
        Path path = this.path;
        calculatePath(boundsAsRectF, path);
        Region region2 = this.scratchRegion;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final boolean hasStroke() {
        Paint.Style style = this.drawableState.paintStyle;
        if ((style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f) {
            return true;
        }
        return false;
    }

    public final void initializeElevationOverlay(Context context) {
        this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.pathDirty = true;
        this.strokePathDirty = true;
        super.invalidateSelf();
    }

    public final boolean isRoundRect() {
        if (!this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF())) {
            float[] fArr = this.springAnimatedCornerSizes;
            if (fArr != null) {
                if (fArr.length > 1) {
                    float f = fArr[0];
                    for (int i = 1; i < fArr.length; i++) {
                        if (fArr[i] != f) {
                            break;
                        }
                    }
                }
                if (this.drawableState.shapeAppearanceModel.hasRoundedCorners()) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.drawableState.tintList;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.drawableState.getClass();
        ColorStateList colorStateList2 = this.drawableState.strokeColor;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.drawableState.fillColor;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        StateListShapeAppearanceModel stateListShapeAppearanceModel = this.drawableState.stateListShapeAppearanceModel;
        if (stateListShapeAppearanceModel == null || !stateListShapeAppearanceModel.isStateful()) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        this.strokePathDirty = true;
        super.onBoundsChange(rect);
        if (this.drawableState.stateListShapeAppearanceModel != null && !rect.isEmpty()) {
            updateShape(getState(), this.boundsIsEmpty);
        }
        this.boundsIsEmpty = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        boolean z = false;
        if (this.drawableState.stateListShapeAppearanceModel != null) {
            updateShape(iArr, false);
        }
        boolean updateColorsForState = updateColorsForState(iArr);
        boolean updateTintFilter = updateTintFilter();
        if (updateColorsForState || updateTintFilter) {
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.alpha != i) {
            materialShapeDrawableState.alpha = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.drawableState.getClass();
        super.invalidateSelf();
    }

    public final void setCornerSpringForce(SpringForce springForce) {
        if (this.cornerSpringForce != springForce) {
            this.cornerSpringForce = springForce;
            int i = 0;
            while (true) {
                SpringAnimation[] springAnimationArr = this.cornerSpringAnimations;
                if (i < springAnimationArr.length) {
                    if (springAnimationArr[i] == null) {
                        springAnimationArr[i] = new SpringAnimation(this, CORNER_SIZES_IN_PX[i]);
                    }
                    SpringAnimation springAnimation = springAnimationArr[i];
                    SpringForce springForce2 = new SpringForce();
                    springForce2.setDampingRatio((float) springForce.mDampingRatio);
                    double d = springForce.mNaturalFreq;
                    springForce2.setStiffness((float) (d * d));
                    springAnimation.mSpring = springForce2;
                    i++;
                } else {
                    updateShape(getState(), true);
                    invalidateSelf();
                    return;
                }
            }
        }
    }

    public final void setElevation(float f) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.elevation != f) {
            materialShapeDrawableState.elevation = f;
            updateZ();
        }
    }

    public final void setFillColor(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.fillColor != colorStateList) {
            materialShapeDrawableState.fillColor = colorStateList;
            onStateChange(getState());
        }
    }

    public final void setInterpolation(float f) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.interpolation != f) {
            materialShapeDrawableState.interpolation = f;
            this.pathDirty = true;
            this.strokePathDirty = true;
            invalidateSelf();
        }
    }

    public final void setShadowColor() {
        this.shadowRenderer.setShadowColor(-12303292);
        this.drawableState.getClass();
        super.invalidateSelf();
    }

    public final void setShadowCompatibilityMode() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.shadowCompatMode != 2) {
            materialShapeDrawableState.shadowCompatMode = 2;
            super.invalidateSelf();
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        materialShapeDrawableState.shapeAppearanceModel = shapeAppearanceModel;
        materialShapeDrawableState.stateListShapeAppearanceModel = null;
        this.springAnimatedCornerSizes = null;
        this.springAnimatedStrokeCornerSizes = null;
        invalidateSelf();
    }

    public final void setStateListShapeAppearanceModel(StateListShapeAppearanceModel stateListShapeAppearanceModel) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.stateListShapeAppearanceModel != stateListShapeAppearanceModel) {
            materialShapeDrawableState.stateListShapeAppearanceModel = stateListShapeAppearanceModel;
            updateShape(getState(), true);
            invalidateSelf();
        }
    }

    public final void setStrokeColor(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.strokeColor != colorStateList) {
            materialShapeDrawableState.strokeColor = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.drawableState.tintList = colorStateList;
        updateTintFilter();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.tintMode != mode) {
            materialShapeDrawableState.tintMode = mode;
            updateTintFilter();
            super.invalidateSelf();
        }
    }

    public final boolean updateColorsForState(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.drawableState.fillColor == null || color2 == (colorForState2 = this.drawableState.fillColor.getColorForState(iArr, (color2 = (paint2 = this.fillPaint).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.drawableState.strokeColor == null || color == (colorForState = this.drawableState.strokeColor.getColorForState(iArr, (color = (paint = this.strokePaint).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final void updateShape(int[] iArr, boolean z) {
        boolean z2;
        ShapeAppearanceModel shapeAppearanceModel;
        CornerSize cornerSize;
        int i;
        RectF boundsAsRectF = getBoundsAsRectF();
        if (!(this.drawableState.stateListShapeAppearanceModel == null || boundsAsRectF.isEmpty())) {
            if (this.cornerSpringForce == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean z3 = z | z2;
            if (this.springAnimatedCornerSizes == null) {
                this.springAnimatedCornerSizes = new float[4];
            }
            StateListShapeAppearanceModel stateListShapeAppearanceModel = this.drawableState.stateListShapeAppearanceModel;
            ShapeAppearanceModel[] shapeAppearanceModelArr = stateListShapeAppearanceModel.shapeAppearanceModels;
            int i2 = stateListShapeAppearanceModel.stateCount;
            int[][] iArr2 = stateListShapeAppearanceModel.stateSpecs;
            StateListCornerSize stateListCornerSize = stateListShapeAppearanceModel.bottomRightCornerSizeOverride;
            StateListCornerSize stateListCornerSize2 = stateListShapeAppearanceModel.bottomLeftCornerSizeOverride;
            StateListCornerSize stateListCornerSize3 = stateListShapeAppearanceModel.topRightCornerSizeOverride;
            StateListCornerSize stateListCornerSize4 = stateListShapeAppearanceModel.topLeftCornerSizeOverride;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    i3 = -1;
                    break;
                } else if (StateSet.stateSetMatches(iArr2[i3], iArr)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 < 0) {
                int[] iArr3 = StateSet.WILD_CARD;
                int i4 = 0;
                while (true) {
                    if (i4 >= i2) {
                        i = -1;
                        break;
                    } else if (StateSet.stateSetMatches(iArr2[i4], iArr3)) {
                        i = i4;
                        break;
                    } else {
                        i4++;
                    }
                }
                i3 = i;
            }
            if (stateListCornerSize4 == null && stateListCornerSize3 == null && stateListCornerSize2 == null && stateListCornerSize == null) {
                shapeAppearanceModel = shapeAppearanceModelArr[i3];
            } else {
                ShapeAppearanceModel.Builder builder = shapeAppearanceModelArr[i3].toBuilder();
                if (stateListCornerSize4 != null) {
                    builder.topLeftCornerSize = stateListCornerSize4.getCornerSizeForState(iArr);
                }
                if (stateListCornerSize3 != null) {
                    builder.topRightCornerSize = stateListCornerSize3.getCornerSizeForState(iArr);
                }
                if (stateListCornerSize2 != null) {
                    builder.bottomLeftCornerSize = stateListCornerSize2.getCornerSizeForState(iArr);
                }
                if (stateListCornerSize != null) {
                    builder.bottomRightCornerSize = stateListCornerSize.getCornerSizeForState(iArr);
                }
                shapeAppearanceModel = builder.build();
            }
            for (int i5 = 0; i5 < 4; i5++) {
                this.pathProvider.getClass();
                if (i5 == 1) {
                    cornerSize = shapeAppearanceModel.bottomRightCornerSize;
                } else if (i5 == 2) {
                    cornerSize = shapeAppearanceModel.bottomLeftCornerSize;
                } else if (i5 != 3) {
                    cornerSize = shapeAppearanceModel.topRightCornerSize;
                } else {
                    cornerSize = shapeAppearanceModel.topLeftCornerSize;
                }
                float cornerSize2 = cornerSize.getCornerSize(boundsAsRectF);
                if (z3) {
                    this.springAnimatedCornerSizes[i5] = cornerSize2;
                }
                SpringAnimation[] springAnimationArr = this.cornerSpringAnimations;
                SpringAnimation springAnimation = springAnimationArr[i5];
                if (springAnimation != null) {
                    springAnimation.animateToFinalPosition(cornerSize2);
                    if (z3) {
                        springAnimationArr[i5].skipToEnd();
                    }
                }
            }
            if (z3) {
                invalidateSelf();
            }
        }
    }

    public final boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter3 = this.strokeTintFilter;
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        ColorStateList colorStateList = materialShapeDrawableState.tintList;
        PorterDuff.Mode mode = materialShapeDrawableState.tintMode;
        if (colorStateList == null || mode == null) {
            int color = this.fillPaint.getColor();
            int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(color);
            this.resolvedTintColor = compositeElevationOverlayIfNeeded;
            if (compositeElevationOverlayIfNeeded != color) {
                porterDuffColorFilter = new PorterDuffColorFilter(compositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN);
            } else {
                porterDuffColorFilter = null;
            }
        } else {
            int compositeElevationOverlayIfNeeded2 = compositeElevationOverlayIfNeeded(colorStateList.getColorForState(getState(), 0));
            this.resolvedTintColor = compositeElevationOverlayIfNeeded2;
            porterDuffColorFilter = new PorterDuffColorFilter(compositeElevationOverlayIfNeeded2, mode);
        }
        this.tintFilter = porterDuffColorFilter;
        this.drawableState.getClass();
        this.strokeTintFilter = null;
        this.drawableState.getClass();
        if (!Objects.equals(porterDuffColorFilter2, this.tintFilter) || !Objects.equals(porterDuffColorFilter3, this.strokeTintFilter)) {
            return true;
        }
        return false;
    }

    public final void updateZ() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        float f = materialShapeDrawableState.elevation + 0.0f;
        materialShapeDrawableState.shadowCompatRadius = (int) Math.ceil(0.75f * f);
        this.drawableState.shadowCompatOffset = (int) Math.ceil(f * 0.25f);
        updateTintFilter();
        super.invalidateSelf();
    }

    public MaterialShapeDrawable(Context context, AttributeSet attributeSet, int i, int i2) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i, i2).build());
    }

    public MaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel));
    }

    public MaterialShapeDrawable(MaterialShapeDrawableState materialShapeDrawableState) {
        ShapeAppearancePathProvider shapeAppearancePathProvider;
        this.strokeInsetCornerSizeUnaryOperator = new C01961();
        this.cornerShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint paint = new Paint(1);
        this.fillPaint = paint;
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        this.shadowRenderer = new ShadowRenderer();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            shapeAppearancePathProvider = ShapeAppearancePathProvider.Lazy.INSTANCE;
        } else {
            shapeAppearancePathProvider = new ShapeAppearancePathProvider();
        }
        this.pathProvider = shapeAppearancePathProvider;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.boundsIsEmpty = true;
        this.cornerSpringAnimations = new SpringAnimation[4];
        this.drawableState = materialShapeDrawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new C01961();
    }

    /* loaded from: classes.dex */
    public class MaterialShapeDrawableState extends Drawable.ConstantState {
        public int alpha;
        public float elevation;
        public ElevationOverlayProvider elevationOverlayProvider;
        public ColorStateList fillColor;
        public float interpolation;
        public Rect padding;
        public final Paint.Style paintStyle;
        public float parentAbsoluteElevation;
        public final float scale;
        public int shadowCompatMode;
        public int shadowCompatOffset;
        public int shadowCompatRadius;
        public ShapeAppearanceModel shapeAppearanceModel;
        public StateListShapeAppearanceModel stateListShapeAppearanceModel;
        public ColorStateList strokeColor;
        public float strokeWidth;
        public ColorStateList tintList;
        public PorterDuff.Mode tintMode;

        public MaterialShapeDrawableState(ShapeAppearanceModel shapeAppearanceModel) {
            this.fillColor = null;
            this.strokeColor = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = shapeAppearanceModel;
            this.elevationOverlayProvider = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.pathDirty = true;
            materialShapeDrawable.strokePathDirty = true;
            return materialShapeDrawable;
        }

        public MaterialShapeDrawableState(MaterialShapeDrawableState materialShapeDrawableState) {
            this.fillColor = null;
            this.strokeColor = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
            this.stateListShapeAppearanceModel = materialShapeDrawableState.stateListShapeAppearanceModel;
            this.elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
            this.strokeWidth = materialShapeDrawableState.strokeWidth;
            this.fillColor = materialShapeDrawableState.fillColor;
            this.strokeColor = materialShapeDrawableState.strokeColor;
            this.tintMode = materialShapeDrawableState.tintMode;
            this.tintList = materialShapeDrawableState.tintList;
            this.alpha = materialShapeDrawableState.alpha;
            this.scale = materialShapeDrawableState.scale;
            this.shadowCompatOffset = materialShapeDrawableState.shadowCompatOffset;
            this.shadowCompatMode = materialShapeDrawableState.shadowCompatMode;
            this.interpolation = materialShapeDrawableState.interpolation;
            this.parentAbsoluteElevation = materialShapeDrawableState.parentAbsoluteElevation;
            this.elevation = materialShapeDrawableState.elevation;
            this.shadowCompatRadius = materialShapeDrawableState.shadowCompatRadius;
            this.paintStyle = materialShapeDrawableState.paintStyle;
            if (materialShapeDrawableState.padding != null) {
                this.padding = new Rect(materialShapeDrawableState.padding);
            }
        }
    }
}
