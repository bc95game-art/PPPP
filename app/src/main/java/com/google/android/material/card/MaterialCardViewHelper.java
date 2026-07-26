package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.cardview.R$styleable;
import androidx.cardview.widget.CardView;
import androidx.cardview.widget.RoundRectDrawable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;
import androidx.core.p002os.BundleKt;
import androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class MaterialCardViewHelper {
    public static final ColorDrawable CHECKED_ICON_NONE;
    public static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    public final MaterialShapeDrawable bgDrawable;
    public boolean checkable;
    public Drawable checkedIcon;
    public int checkedIconGravity;
    public int checkedIconMargin;
    public int checkedIconSize;
    public ColorStateList checkedIconTint;
    public LayerDrawable clickableForegroundDrawable;
    public Drawable fgDrawable;
    public final MaterialShapeDrawable foregroundContentDrawable;
    public MaterialShapeDrawable foregroundShapeDrawable;
    public ValueAnimator iconAnimator;
    public final TimeInterpolator iconFadeAnimInterpolator;
    public final int iconFadeInAnimDuration;
    public final int iconFadeOutAnimDuration;
    public final MaterialCardView materialCardView;
    public ColorStateList rippleColor;
    public RippleDrawable rippleDrawable;
    public ShapeAppearanceModel shapeAppearanceModel;
    public ColorStateList strokeColor;
    public int strokeWidth;
    public final Rect userContentPadding = new Rect();
    public boolean isBackgroundOverwritten = false;
    public float checkedAnimationProgress = 0.0f;

    /* renamed from: com.google.android.material.card.MaterialCardViewHelper$1 */
    /* loaded from: classes.dex */
    public final class C01711 extends InsetDrawable {
        @Override // android.graphics.drawable.Drawable
        public final int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public final int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public final boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        ColorDrawable colorDrawable;
        if (Build.VERSION.SDK_INT <= 28) {
            colorDrawable = new ColorDrawable();
        } else {
            colorDrawable = null;
        }
        CHECKED_ICON_NONE = colorDrawable;
    }

    public MaterialCardViewHelper(MaterialCardView materialCardView, AttributeSet attributeSet) {
        this.materialCardView = materialCardView;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, C0130R.attr.materialCardViewStyle, C0130R.style.Widget_MaterialComponents_CardView);
        this.bgDrawable = materialShapeDrawable;
        materialShapeDrawable.initializeElevationOverlay(materialCardView.getContext());
        materialShapeDrawable.setShadowColor();
        ShapeAppearanceModel.Builder builder = materialShapeDrawable.drawableState.shapeAppearanceModel.toBuilder();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R$styleable.CardView, C0130R.attr.materialCardViewStyle, C0130R.style.CardView);
        if (obtainStyledAttributes.hasValue(3)) {
            builder.setAllCornerSizes(obtainStyledAttributes.getDimension(3, 0.0f));
        }
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearanceModel(builder.build());
        this.iconFadeAnimInterpolator = LazyKt__LazyJVMKt.resolveThemeInterpolator(materialCardView.getContext(), C0130R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.iconFadeInAnimDuration = LazyKt__LazyJVMKt.resolveThemeDuration(materialCardView.getContext(), C0130R.attr.motionDurationShort2, 300);
        this.iconFadeOutAnimDuration = LazyKt__LazyJVMKt.resolveThemeDuration(materialCardView.getContext(), C0130R.attr.motionDurationShort1, 300);
        obtainStyledAttributes.recycle();
    }

    public static float calculateCornerPaddingForCornerTreatment(LazyKt__LazyJVMKt lazyKt__LazyJVMKt, float f) {
        if (lazyKt__LazyJVMKt instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - COS_45) * f);
        }
        if (lazyKt__LazyJVMKt instanceof CutCornerTreatment) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    public final float calculateActualCornerPadding() {
        float f;
        float f2;
        float f3;
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt = this.shapeAppearanceModel.topLeftCorner;
        MaterialShapeDrawable materialShapeDrawable = this.bgDrawable;
        float calculateCornerPaddingForCornerTreatment = calculateCornerPaddingForCornerTreatment(lazyKt__LazyJVMKt, materialShapeDrawable.getTopLeftCornerResolvedSize());
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt2 = this.shapeAppearanceModel.topRightCorner;
        float[] fArr = materialShapeDrawable.springAnimatedCornerSizes;
        if (fArr != null) {
            f = fArr[0];
        } else {
            f = materialShapeDrawable.drawableState.shapeAppearanceModel.topRightCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF());
        }
        float max = Math.max(calculateCornerPaddingForCornerTreatment, calculateCornerPaddingForCornerTreatment(lazyKt__LazyJVMKt2, f));
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt3 = this.shapeAppearanceModel.bottomRightCorner;
        float[] fArr2 = materialShapeDrawable.springAnimatedCornerSizes;
        if (fArr2 != null) {
            f2 = fArr2[1];
        } else {
            f2 = materialShapeDrawable.drawableState.shapeAppearanceModel.bottomRightCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF());
        }
        float calculateCornerPaddingForCornerTreatment2 = calculateCornerPaddingForCornerTreatment(lazyKt__LazyJVMKt3, f2);
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt4 = this.shapeAppearanceModel.bottomLeftCorner;
        float[] fArr3 = materialShapeDrawable.springAnimatedCornerSizes;
        if (fArr3 != null) {
            f3 = fArr3[2];
        } else {
            f3 = materialShapeDrawable.drawableState.shapeAppearanceModel.bottomLeftCornerSize.getCornerSize(materialShapeDrawable.getBoundsAsRectF());
        }
        return Math.max(max, Math.max(calculateCornerPaddingForCornerTreatment2, calculateCornerPaddingForCornerTreatment(lazyKt__LazyJVMKt4, f3)));
    }

    public final LayerDrawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.foregroundShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
            this.rippleDrawable = new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
        }
        if (this.clickableForegroundDrawable == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, this.checkedIcon});
            this.clickableForegroundDrawable = layerDrawable;
            layerDrawable.setId(2, C0130R.C0132id.mtrl_card_checked_layer_id);
        }
        return this.clickableForegroundDrawable;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [android.graphics.drawable.InsetDrawable, com.google.android.material.card.MaterialCardViewHelper$1] */
    public final C01711 insetDrawable(Drawable drawable) {
        int i;
        int i2;
        float f;
        MaterialCardView materialCardView = this.materialCardView;
        if (materialCardView.getUseCompatPadding()) {
            float maxCardElevation = materialCardView.getMaxCardElevation() * 1.5f;
            float f2 = 0.0f;
            if (shouldAddCornerPaddingOutsideCardBackground()) {
                f = calculateActualCornerPadding();
            } else {
                f = 0.0f;
            }
            int ceil = (int) Math.ceil(maxCardElevation + f);
            float maxCardElevation2 = materialCardView.getMaxCardElevation();
            if (shouldAddCornerPaddingOutsideCardBackground()) {
                f2 = calculateActualCornerPadding();
            }
            i2 = (int) Math.ceil(maxCardElevation2 + f2);
            i = ceil;
        } else {
            i2 = 0;
            i = 0;
        }
        return new InsetDrawable(drawable, i2, i, i2, i);
    }

    public final void recalculateCheckedIconPosition(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        float f;
        if (this.clickableForegroundDrawable != null) {
            MaterialCardView materialCardView = this.materialCardView;
            if (materialCardView.getUseCompatPadding()) {
                float maxCardElevation = materialCardView.getMaxCardElevation() * 1.5f;
                float f2 = 0.0f;
                if (shouldAddCornerPaddingOutsideCardBackground()) {
                    f = calculateActualCornerPadding();
                } else {
                    f = 0.0f;
                }
                i4 = (int) Math.ceil((maxCardElevation + f) * 2.0f);
                float maxCardElevation2 = materialCardView.getMaxCardElevation();
                if (shouldAddCornerPaddingOutsideCardBackground()) {
                    f2 = calculateActualCornerPadding();
                }
                i3 = (int) Math.ceil((maxCardElevation2 + f2) * 2.0f);
            } else {
                i4 = 0;
                i3 = 0;
            }
            int i11 = this.checkedIconGravity;
            if ((i11 & 8388613) == 8388613) {
                i5 = ((i - this.checkedIconMargin) - this.checkedIconSize) - i3;
            } else {
                i5 = this.checkedIconMargin;
            }
            if ((i11 & 80) == 80) {
                i6 = this.checkedIconMargin;
            } else {
                i6 = ((i2 - this.checkedIconMargin) - this.checkedIconSize) - i4;
            }
            int i12 = i6;
            if ((i11 & 8388613) == 8388613) {
                i7 = this.checkedIconMargin;
            } else {
                i7 = ((i - this.checkedIconMargin) - this.checkedIconSize) - i3;
            }
            if ((i11 & 80) == 80) {
                i8 = ((i2 - this.checkedIconMargin) - this.checkedIconSize) - i4;
            } else {
                i8 = this.checkedIconMargin;
            }
            int i13 = i8;
            if (materialCardView.getLayoutDirection() == 1) {
                i10 = i7;
                i9 = i5;
            } else {
                i9 = i7;
                i10 = i5;
            }
            this.clickableForegroundDrawable.setLayerInset(2, i10, i13, i9, i12);
        }
    }

    public final void setChecked(boolean z, boolean z2) {
        float f;
        int i;
        Drawable drawable = this.checkedIcon;
        if (drawable != null) {
            int i2 = 0;
            float f2 = 0.0f;
            if (z2) {
                if (z) {
                    f2 = 1.0f;
                }
                if (z) {
                    f = 1.0f - this.checkedAnimationProgress;
                } else {
                    f = this.checkedAnimationProgress;
                }
                ValueAnimator valueAnimator = this.iconAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.iconAnimator = null;
                }
                ValueAnimator ofFloat = ValueAnimator.ofFloat(this.checkedAnimationProgress, f2);
                this.iconAnimator = ofFloat;
                ofFloat.addUpdateListener(new ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(1, this));
                this.iconAnimator.setInterpolator(this.iconFadeAnimInterpolator);
                ValueAnimator valueAnimator2 = this.iconAnimator;
                if (z) {
                    i = this.iconFadeInAnimDuration;
                } else {
                    i = this.iconFadeOutAnimDuration;
                }
                valueAnimator2.setDuration(i * f);
                this.iconAnimator.start();
                return;
            }
            if (z) {
                i2 = 255;
            }
            drawable.setAlpha(i2);
            if (z) {
                f2 = 1.0f;
            }
            this.checkedAnimationProgress = f2;
        }
    }

    public final void setCheckedIcon(Drawable drawable) {
        if (drawable != null) {
            Drawable mutate = BundleKt.wrap(drawable).mutate();
            this.checkedIcon = mutate;
            mutate.setTintList(this.checkedIconTint);
            setChecked(this.materialCardView.checked, false);
        } else {
            this.checkedIcon = CHECKED_ICON_NONE;
        }
        LayerDrawable layerDrawable = this.clickableForegroundDrawable;
        if (layerDrawable != null) {
            layerDrawable.setDrawableByLayerId(C0130R.C0132id.mtrl_card_checked_layer_id, this.checkedIcon);
        }
    }

    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearanceModel = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.bgDrawable;
        materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        materialShapeDrawable.shadowBitmapDrawingEnable = !materialShapeDrawable.isRoundRect();
        MaterialShapeDrawable materialShapeDrawable2 = this.foregroundContentDrawable;
        if (materialShapeDrawable2 != null) {
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
        }
        MaterialShapeDrawable materialShapeDrawable3 = this.foregroundShapeDrawable;
        if (materialShapeDrawable3 != null) {
            materialShapeDrawable3.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public final boolean shouldAddCornerPaddingOutsideCardBackground() {
        MaterialCardView materialCardView = this.materialCardView;
        if (!materialCardView.getPreventCornerOverlap() || !this.bgDrawable.isRoundRect() || !materialCardView.getUseCompatPadding()) {
            return false;
        }
        return true;
    }

    public final boolean shouldUseClickableForeground() {
        View view = this.materialCardView;
        if (view.isClickable()) {
            return true;
        }
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    public final void updateClickable() {
        Drawable drawable;
        Drawable drawable2 = this.fgDrawable;
        if (shouldUseClickableForeground()) {
            drawable = getClickableForeground();
        } else {
            drawable = this.foregroundContentDrawable;
        }
        this.fgDrawable = drawable;
        if (drawable2 != drawable) {
            int i = Build.VERSION.SDK_INT;
            MaterialCardView materialCardView = this.materialCardView;
            if (i < 23 || !(materialCardView.getForeground() instanceof InsetDrawable)) {
                materialCardView.setForeground(insetDrawable(drawable));
            } else {
                ((InsetDrawable) materialCardView.getForeground()).setDrawable(drawable);
            }
        }
    }

    public final void updateContentPadding() {
        float f;
        MaterialCardView materialCardView = this.materialCardView;
        float f2 = 0.0f;
        if ((!materialCardView.getPreventCornerOverlap() || this.bgDrawable.isRoundRect()) && !shouldAddCornerPaddingOutsideCardBackground()) {
            f = 0.0f;
        } else {
            f = calculateActualCornerPadding();
        }
        if (materialCardView.getPreventCornerOverlap() && materialCardView.getUseCompatPadding()) {
            f2 = (float) ((1.0d - COS_45) * materialCardView.getCardViewRadius());
        }
        int i = (int) (f - f2);
        Rect rect = this.userContentPadding;
        materialCardView.mContentPadding.set(rect.left + i, rect.top + i, rect.right + i, rect.bottom + i);
        zzcl zzclVar = materialCardView.mCardViewDelegate;
        CardView cardView = (CardView) zzclVar.zzc;
        if (!cardView.getUseCompatPadding()) {
            zzclVar.setShadowPadding(0, 0, 0, 0);
            return;
        }
        RoundRectDrawable roundRectDrawable = (RoundRectDrawable) ((Drawable) zzclVar.zzb);
        float f3 = roundRectDrawable.mPadding;
        float f4 = roundRectDrawable.mRadius;
        int ceil = (int) Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(f3, f4, cardView.getPreventCornerOverlap()));
        int ceil2 = (int) Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(f3, f4, cardView.getPreventCornerOverlap()));
        zzclVar.setShadowPadding(ceil, ceil2, ceil, ceil2);
    }

    public final void updateInsets() {
        boolean z = this.isBackgroundOverwritten;
        MaterialCardView materialCardView = this.materialCardView;
        if (!z) {
            materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }
}
