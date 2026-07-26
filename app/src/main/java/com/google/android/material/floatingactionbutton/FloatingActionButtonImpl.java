package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.core.os.BundleKt;
import androidx.core.util.TimeUtils;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.emanuelef.remote_capture.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import kotlin.LazyKt__LazyJVMKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
/* loaded from: classes.dex */
public final class FloatingActionButtonImpl {
    public BorderDrawable borderDrawable;
    public RippleDrawable contentBackground;
    public Animator currentAnimator;
    public float elevation;
    public boolean ensureMinTouchTargetSize;
    public MotionSpec hideMotionSpec;
    public float hoveredFocusedTranslationZ;
    public int maxImageSize;
    public int minTouchTargetSize;
    public float pressedTranslationZ;
    public RippleDrawable rippleDrawable;
    public final ReadonlyStateFlow shadowViewDelegate;
    public ShapeAppearanceModel shapeAppearance;
    public AlwaysStatefulMaterialShapeDrawable shapeDrawable;
    public MotionSpec showMotionSpec;
    public StateListAnimator stateListAnimator;
    public final FloatingActionButton view;
    public static final FastOutSlowInInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final int SHOW_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    public static final int SHOW_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    public static final int HIDE_ANIM_DURATION_ATTR = R.attr.motionDurationMedium1;
    public static final int HIDE_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] PRESSED_ENABLED_STATE_SET = {16842919, 16842910};
    public static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {16843623, 16842908, 16842910};
    public static final int[] FOCUSED_ENABLED_STATE_SET = {16842908, 16842910};
    public static final int[] HOVERED_ENABLED_STATE_SET = {16843623, 16842910};
    public static final int[] ENABLED_STATE_SET = {16842910};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public boolean shadowPaddingEnabled = true;
    public float imageMatrixScale = 1.0f;
    public int animState = 0;
    public final Rect tmpRect = new Rect();
    public final RectF tmpRectF1 = new RectF();
    public final RectF tmpRectF2 = new RectF();
    public final Matrix tmpMatrix = new Matrix();

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass4 implements TypeEvaluator {
        public final /* synthetic */ int $r8$classId;
        public Object floatEvaluator;

        public AnonymousClass4(int i) {
            this.$r8$classId = i;
            switch (i) {
                case 1:
                    return;
                default:
                    this.floatEvaluator = new FloatEvaluator();
                    return;
            }
        }

        @Override // android.animation.TypeEvaluator
        public final Object evaluate(float f, Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    float floatValue = ((FloatEvaluator) this.floatEvaluator).evaluate(f, (Number) ((Float) obj), (Number) ((Float) obj2)).floatValue();
                    if (floatValue < 0.1f) {
                        floatValue = 0.0f;
                    }
                    return Float.valueOf(floatValue);
                default:
                    PathParser$PathDataNode[] pathParser$PathDataNodeArr = (PathParser$PathDataNode[]) obj;
                    PathParser$PathDataNode[] pathParser$PathDataNodeArr2 = (PathParser$PathDataNode[]) obj2;
                    if (BundleKt.canMorph(pathParser$PathDataNodeArr, pathParser$PathDataNodeArr2)) {
                        if (!BundleKt.canMorph((PathParser$PathDataNode[]) this.floatEvaluator, pathParser$PathDataNodeArr)) {
                            this.floatEvaluator = BundleKt.deepCopyNodes(pathParser$PathDataNodeArr);
                        }
                        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
                            PathParser$PathDataNode pathParser$PathDataNode = ((PathParser$PathDataNode[]) this.floatEvaluator)[i];
                            PathParser$PathDataNode pathParser$PathDataNode2 = pathParser$PathDataNodeArr[i];
                            PathParser$PathDataNode pathParser$PathDataNode3 = pathParser$PathDataNodeArr2[i];
                            pathParser$PathDataNode.getClass();
                            pathParser$PathDataNode.mType = pathParser$PathDataNode2.mType;
                            int i2 = 0;
                            while (true) {
                                float[] fArr = pathParser$PathDataNode2.mParams;
                                if (i2 < fArr.length) {
                                    pathParser$PathDataNode.mParams[i2] = (pathParser$PathDataNode3.mParams[i2] * f) + ((1.0f - f) * fArr[i2]);
                                    i2++;
                                }
                            }
                        }
                        return (PathParser$PathDataNode[]) this.floatEvaluator;
                    }
                    throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
        }
    }

    /* loaded from: classes.dex */
    public final class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public final boolean isStateful() {
            return true;
        }
    }

    public FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ReadonlyStateFlow readonlyStateFlow) {
        this.view = floatingActionButton;
        this.shadowViewDelegate = readonlyStateFlow;
    }

    public final void calculateImageMatrixFromScale(float f, Matrix matrix) {
        Drawable drawable;
        matrix.reset();
        if (this.view.getDrawable() != null && this.maxImageSize != 0) {
            RectF rectF = this.tmpRectF1;
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            float f2 = this.maxImageSize;
            RectF rectF2 = this.tmpRectF2;
            rectF2.set(0.0f, 0.0f, f2, f2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            float f3 = this.maxImageSize / 2.0f;
            matrix.postScale(f, f, f3, f3);
        }
    }

    public final AnimatorSet createAnimator(MotionSpec motionSpec, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.view;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(floatingActionButton, property, fArr);
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(floatingActionButton, View.SCALE_X, f2);
        motionSpec.getTiming("scale").apply(ofFloat2);
        int i = Build.VERSION.SDK_INT;
        if (i == 26) {
            ofFloat2.setEvaluator(new AnonymousClass4(0));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(floatingActionButton, View.SCALE_Y, f2);
        motionSpec.getTiming("scale").apply(ofFloat3);
        if (i == 26) {
            ofFloat3.setEvaluator(new AnonymousClass4(0));
        }
        arrayList.add(ofFloat3);
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f3, matrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(floatingActionButton, new ImageMatrixProperty(), new TypeEvaluator() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
            public final float[] tempStartValues = new float[9];
            public final float[] tempEndValues = new float[9];
            public final Matrix tempMatrix = new Matrix();

            @Override // android.animation.TypeEvaluator
            public final Object evaluate(float f4, Object obj, Object obj2) {
                FloatingActionButtonImpl.this.imageMatrixScale = f4;
                float[] fArr2 = this.tempStartValues;
                ((Matrix) obj).getValues(fArr2);
                float[] fArr3 = this.tempEndValues;
                ((Matrix) obj2).getValues(fArr3);
                for (int i2 = 0; i2 < 9; i2++) {
                    float f5 = fArr3[i2];
                    float f6 = fArr2[i2];
                    fArr3[i2] = ((f5 - f6) * f4) + f6;
                }
                Matrix matrix2 = this.tempMatrix;
                matrix2.setValues(fArr3);
                return matrix2;
            }
        }, new Matrix(matrix));
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        LazyKt__LazyJVMKt.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet createDefaultAnimator(final float f, final float f2, final float f3, int i, int i2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.view;
        final float alpha = floatingActionButton.getAlpha();
        final float scaleX = floatingActionButton.getScaleX();
        final float scaleY = floatingActionButton.getScaleY();
        final float f4 = this.imageMatrixScale;
        final Matrix matrix = new Matrix(this.tmpMatrix);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.getClass();
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingActionButton floatingActionButton2 = floatingActionButtonImpl.view;
                floatingActionButton2.setAlpha(AnimationUtils.lerp(alpha, f, 0.0f, 0.2f, floatValue));
                float f5 = scaleX;
                float f6 = f2;
                floatingActionButton2.setScaleX(AnimationUtils.lerp(f5, f6, floatValue));
                floatingActionButton2.setScaleY(AnimationUtils.lerp(scaleY, f6, floatValue));
                float f7 = f4;
                float f8 = f3;
                floatingActionButtonImpl.imageMatrixScale = AnimationUtils.lerp(f7, f8, floatValue);
                float lerp = AnimationUtils.lerp(f7, f8, floatValue);
                Matrix matrix2 = matrix;
                floatingActionButtonImpl.calculateImageMatrixFromScale(lerp, matrix2);
                floatingActionButton2.setImageMatrix(matrix2);
            }
        });
        arrayList.add(ofFloat);
        LazyKt__LazyJVMKt.playTogether(animatorSet, arrayList);
        animatorSet.setDuration(LazyKt__LazyJVMKt.resolveThemeDuration(floatingActionButton.getContext(), i, floatingActionButton.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(LazyKt__LazyJVMKt.resolveThemeInterpolator(floatingActionButton.getContext(), i2, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    public final AnimatorSet createElevationAnimator(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.view;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", fArr).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        return animatorSet;
    }

    public final void onElevationsChanged(float f, float f2, float f3) {
        int i = Build.VERSION.SDK_INT;
        FloatingActionButton floatingActionButton = this.view;
        if (i == 21) {
            floatingActionButton.refreshDrawableState();
        } else if (floatingActionButton.getStateListAnimator() == this.stateListAnimator) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(f, f3));
            stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
            stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
            stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f).setDuration(0L));
            if (i >= 22 && i <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
            stateListAnimator.addState(ENABLED_STATE_SET, animatorSet);
            stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
            this.stateListAnimator = stateListAnimator;
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (((FloatingActionButton) this.shadowViewDelegate.$$delegate_0).compatPadding || (this.ensureMinTouchTargetSize && floatingActionButton.getSizeDimension() < this.minTouchTargetSize)) {
            updatePadding();
        }
    }

    public final void onTranslationChanged() {
    }

    public final void setShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearance = shapeAppearanceModel;
        AlwaysStatefulMaterialShapeDrawable alwaysStatefulMaterialShapeDrawable = this.shapeDrawable;
        if (alwaysStatefulMaterialShapeDrawable != null) {
            alwaysStatefulMaterialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        RippleDrawable rippleDrawable = this.rippleDrawable;
        if (rippleDrawable instanceof Shapeable) {
            ((Shapeable) rippleDrawable).setShapeAppearanceModel(shapeAppearanceModel);
        }
        BorderDrawable borderDrawable = this.borderDrawable;
        if (borderDrawable != null) {
            borderDrawable.shapeAppearanceModel = shapeAppearanceModel;
            borderDrawable.invalidateSelf();
        }
    }

    public final void updatePadding() {
        float f;
        ReadonlyStateFlow readonlyStateFlow = this.shadowViewDelegate;
        FloatingActionButton floatingActionButton = (FloatingActionButton) readonlyStateFlow.$$delegate_0;
        boolean z = ((FloatingActionButton) readonlyStateFlow.$$delegate_0).compatPadding;
        Rect rect = this.tmpRect;
        FloatingActionButton floatingActionButton2 = this.view;
        int i = 0;
        if (z) {
            if (this.ensureMinTouchTargetSize) {
                i = Math.max((this.minTouchTargetSize - floatingActionButton2.getSizeDimension()) / 2, 0);
            }
            if (this.shadowPaddingEnabled) {
                f = floatingActionButton2.getElevation() + this.pressedTranslationZ;
            } else {
                f = 0.0f;
            }
            int max = Math.max(i, (int) Math.ceil(f));
            int max2 = Math.max(i, (int) Math.ceil(f * 1.5f));
            rect.set(max, max2, max, max2);
        } else {
            if (this.ensureMinTouchTargetSize) {
                int sizeDimension = floatingActionButton2.getSizeDimension();
                int i2 = this.minTouchTargetSize;
                if (sizeDimension < i2) {
                    int sizeDimension2 = (i2 - floatingActionButton2.getSizeDimension()) / 2;
                    rect.set(sizeDimension2, sizeDimension2, sizeDimension2, sizeDimension2);
                }
            }
            rect.set(0, 0, 0, 0);
        }
        TimeUtils.checkNotNull(this.contentBackground, "Didn't initialize content background");
        if (((FloatingActionButton) readonlyStateFlow.$$delegate_0).compatPadding || (this.ensureMinTouchTargetSize && floatingActionButton2.getSizeDimension() < this.minTouchTargetSize)) {
            FloatingActionButtonImpl.super.setBackgroundDrawable(new InsetDrawable((Drawable) this.contentBackground, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            RippleDrawable rippleDrawable = this.contentBackground;
            if (rippleDrawable != null) {
                FloatingActionButtonImpl.super.setBackgroundDrawable(rippleDrawable);
            }
        }
        int i3 = rect.left;
        int i4 = rect.top;
        int i5 = rect.right;
        int i6 = rect.bottom;
        floatingActionButton.shadowPadding.set(i3, i4, i5, i6);
        int i7 = floatingActionButton.imagePadding;
        floatingActionButton.setPadding(i3 + i7, i4 + i7, i5 + i7, i6 + i7);
    }
}
