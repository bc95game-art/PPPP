package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.view.inputmethod.InputConnectionCompat$$ExternalSyntheticLambda0;
import androidx.dynamicanimation.animation.SpringForce;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.StateListShapeAppearanceModel;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public final class MaterialButtonHelper {
    public ColorStateList backgroundTint;
    public PorterDuff.Mode backgroundTintMode;
    public boolean checkable;
    public int cornerRadius;
    public SpringForce cornerSpringForce;
    public int elevation;
    public int insetBottom;
    public int insetLeft;
    public int insetRight;
    public int insetTop;
    public MaterialShapeDrawable maskDrawable;
    public final MaterialButton materialButton;
    public InputConnectionCompat$$ExternalSyntheticLambda0 onCornerSizeChangeListener;
    public ColorStateList rippleColor;
    public RippleDrawable rippleDrawable;
    public ShapeAppearanceModel shapeAppearanceModel;
    public StateListShapeAppearanceModel stateListShapeAppearanceModel;
    public ColorStateList strokeColor;
    public int strokeWidth;
    public boolean shouldDrawSurfaceColorStroke = false;
    public boolean backgroundOverwritten = false;
    public boolean cornerRadiusSet = false;
    public boolean toggleCheckedStateOnClick = true;

    public MaterialButtonHelper(MaterialButton materialButton, ShapeAppearanceModel shapeAppearanceModel) {
        this.materialButton = materialButton;
        this.shapeAppearanceModel = shapeAppearanceModel;
    }

    public final MaterialShapeDrawable getMaterialShapeDrawable(boolean z) {
        RippleDrawable rippleDrawable = this.rippleDrawable;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (MaterialShapeDrawable) ((LayerDrawable) ((InsetDrawable) this.rippleDrawable.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void setVerticalInsets(int i, int i2) {
        MaterialButton materialButton = this.materialButton;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i3 = this.insetTop;
        int i4 = this.insetBottom;
        this.insetBottom = i2;
        this.insetTop = i;
        if (!this.backgroundOverwritten) {
            updateBackground();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    public final void updateBackground() {
        int i;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        StateListShapeAppearanceModel stateListShapeAppearanceModel = this.stateListShapeAppearanceModel;
        if (stateListShapeAppearanceModel != null) {
            materialShapeDrawable.setStateListShapeAppearanceModel(stateListShapeAppearanceModel);
        }
        SpringForce springForce = this.cornerSpringForce;
        if (springForce != null) {
            materialShapeDrawable.setCornerSpringForce(springForce);
        }
        InputConnectionCompat$$ExternalSyntheticLambda0 inputConnectionCompat$$ExternalSyntheticLambda0 = this.onCornerSizeChangeListener;
        if (inputConnectionCompat$$ExternalSyntheticLambda0 != null) {
            materialShapeDrawable.onCornerSizeChangeListener = inputConnectionCompat$$ExternalSyntheticLambda0;
        }
        MaterialButton materialButton = this.materialButton;
        materialShapeDrawable.initializeElevationOverlay(materialButton.getContext());
        materialShapeDrawable.setTintList(this.backgroundTint);
        PorterDuff.Mode mode = this.backgroundTintMode;
        if (mode != null) {
            materialShapeDrawable.setTintMode(mode);
        }
        ColorStateList colorStateList = this.strokeColor;
        materialShapeDrawable.drawableState.strokeWidth = this.strokeWidth;
        materialShapeDrawable.invalidateSelf();
        materialShapeDrawable.setStrokeColor(colorStateList);
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        StateListShapeAppearanceModel stateListShapeAppearanceModel2 = this.stateListShapeAppearanceModel;
        if (stateListShapeAppearanceModel2 != null) {
            materialShapeDrawable2.setStateListShapeAppearanceModel(stateListShapeAppearanceModel2);
        }
        SpringForce springForce2 = this.cornerSpringForce;
        if (springForce2 != null) {
            materialShapeDrawable2.setCornerSpringForce(springForce2);
        }
        materialShapeDrawable2.setTint(0);
        float f = this.strokeWidth;
        if (this.shouldDrawSurfaceColorStroke) {
            i = LazyKt__LazyJVMKt.getColor(C0130R.attr.colorSurface, materialButton);
        } else {
            i = 0;
        }
        materialShapeDrawable2.drawableState.strokeWidth = f;
        materialShapeDrawable2.invalidateSelf();
        materialShapeDrawable2.setStrokeColor(ColorStateList.valueOf(i));
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.maskDrawable = materialShapeDrawable3;
        StateListShapeAppearanceModel stateListShapeAppearanceModel3 = this.stateListShapeAppearanceModel;
        if (stateListShapeAppearanceModel3 != null) {
            materialShapeDrawable3.setStateListShapeAppearanceModel(stateListShapeAppearanceModel3);
        }
        SpringForce springForce3 = this.cornerSpringForce;
        if (springForce3 != null) {
            this.maskDrawable.setCornerSpringForce(springForce3);
        }
        this.maskDrawable.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.rippleColor), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{materialShapeDrawable2, materialShapeDrawable}), this.insetLeft, this.insetTop, this.insetRight, this.insetBottom), this.maskDrawable);
        this.rippleDrawable = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        MaterialShapeDrawable materialShapeDrawable4 = getMaterialShapeDrawable(false);
        if (materialShapeDrawable4 != null) {
            materialShapeDrawable4.setElevation(this.elevation);
            materialShapeDrawable4.setState(materialButton.getDrawableState());
        }
    }

    public final void updateButtonShape() {
        Shapeable shapeable;
        if (Build.VERSION.SDK_INT >= 23 || this.backgroundOverwritten) {
            MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable(false);
            if (materialShapeDrawable != null) {
                StateListShapeAppearanceModel stateListShapeAppearanceModel = this.stateListShapeAppearanceModel;
                if (stateListShapeAppearanceModel != null) {
                    materialShapeDrawable.setStateListShapeAppearanceModel(stateListShapeAppearanceModel);
                } else {
                    materialShapeDrawable.setShapeAppearanceModel(this.shapeAppearanceModel);
                }
                SpringForce springForce = this.cornerSpringForce;
                if (springForce != null) {
                    materialShapeDrawable.setCornerSpringForce(springForce);
                }
            }
            MaterialShapeDrawable materialShapeDrawable2 = getMaterialShapeDrawable(true);
            if (materialShapeDrawable2 != null) {
                StateListShapeAppearanceModel stateListShapeAppearanceModel2 = this.stateListShapeAppearanceModel;
                if (stateListShapeAppearanceModel2 != null) {
                    materialShapeDrawable2.setStateListShapeAppearanceModel(stateListShapeAppearanceModel2);
                } else {
                    materialShapeDrawable2.setShapeAppearanceModel(this.shapeAppearanceModel);
                }
                SpringForce springForce2 = this.cornerSpringForce;
                if (springForce2 != null) {
                    materialShapeDrawable2.setCornerSpringForce(springForce2);
                }
            }
            RippleDrawable rippleDrawable = this.rippleDrawable;
            if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
                shapeable = null;
            } else if (this.rippleDrawable.getNumberOfLayers() > 2) {
                shapeable = (Shapeable) this.rippleDrawable.getDrawable(2);
            } else {
                shapeable = (Shapeable) this.rippleDrawable.getDrawable(1);
            }
            if (shapeable != null) {
                shapeable.setShapeAppearanceModel(this.shapeAppearanceModel);
                if (shapeable instanceof MaterialShapeDrawable) {
                    MaterialShapeDrawable materialShapeDrawable3 = (MaterialShapeDrawable) shapeable;
                    StateListShapeAppearanceModel stateListShapeAppearanceModel3 = this.stateListShapeAppearanceModel;
                    if (stateListShapeAppearanceModel3 != null) {
                        materialShapeDrawable3.setStateListShapeAppearanceModel(stateListShapeAppearanceModel3);
                    }
                    SpringForce springForce3 = this.cornerSpringForce;
                    if (springForce3 != null) {
                        materialShapeDrawable3.setCornerSpringForce(springForce3);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        MaterialButton materialButton = this.materialButton;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        updateBackground();
        materialButton.setPaddingRelative(paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    public final void updateStroke() {
        int i = 0;
        MaterialShapeDrawable materialShapeDrawable = getMaterialShapeDrawable(false);
        MaterialShapeDrawable materialShapeDrawable2 = getMaterialShapeDrawable(true);
        if (materialShapeDrawable != null) {
            ColorStateList colorStateList = this.strokeColor;
            materialShapeDrawable.drawableState.strokeWidth = this.strokeWidth;
            materialShapeDrawable.invalidateSelf();
            materialShapeDrawable.setStrokeColor(colorStateList);
            if (materialShapeDrawable2 != null) {
                float f = this.strokeWidth;
                if (this.shouldDrawSurfaceColorStroke) {
                    i = LazyKt__LazyJVMKt.getColor(C0130R.attr.colorSurface, this.materialButton);
                }
                materialShapeDrawable2.drawableState.strokeWidth = f;
                materialShapeDrawable2.invalidateSelf();
                materialShapeDrawable2.setStrokeColor(ColorStateList.valueOf(i));
            }
        }
    }
}
