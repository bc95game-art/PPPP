package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.internal.Lock;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import kotlin.LazyKt__LazyJVMKt;
import org.brotli.dec.IntReader;
@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public float dependencyOriginalTranslationX;
    public float dependencyOriginalTranslationY;
    public final int[] tmpArray;
    public final Rect tmpRect;
    public final RectF tmpRectF1;
    public final RectF tmpRectF2;

    public FabTransformationBehavior() {
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    public static Pair calculateMotionTiming(float f, float f2, boolean z, IntReader intReader) {
        MotionTiming motionTiming;
        MotionTiming motionTiming2;
        int i;
        if (f == 0.0f || f2 == 0.0f) {
            motionTiming2 = ((MotionSpec) intReader.byteBuffer).getTiming("translationXLinear");
            motionTiming = ((MotionSpec) intReader.byteBuffer).getTiming("translationYLinear");
        } else if ((!z || f2 >= 0.0f) && (z || i <= 0)) {
            motionTiming2 = ((MotionSpec) intReader.byteBuffer).getTiming("translationXCurveDownwards");
            motionTiming = ((MotionSpec) intReader.byteBuffer).getTiming("translationYCurveDownwards");
        } else {
            motionTiming2 = ((MotionSpec) intReader.byteBuffer).getTiming("translationXCurveUpwards");
            motionTiming = ((MotionSpec) intReader.byteBuffer).getTiming("translationYCurveUpwards");
        }
        return new Pair(motionTiming2, motionTiming);
    }

    public static float calculateValueOfAnimationAtEndOfExpansion(IntReader intReader, MotionTiming motionTiming, float f) {
        long j = motionTiming.delay;
        long j2 = motionTiming.duration;
        MotionTiming timing = ((MotionSpec) intReader.byteBuffer).getTiming("expansion");
        return AnimationUtils.lerp(f, 0.0f, motionTiming.getInterpolator().getInterpolation(((float) (((timing.delay + timing.duration) + 17) - j)) / ((float) j2)));
    }

    public final float calculateTranslationX(View view, View view2, Lock lock) {
        RectF rectF = this.tmpRectF1;
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view2, rectF2);
        lock.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float calculateTranslationY(View view, View view2, Lock lock) {
        RectF rectF = this.tmpRectF1;
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view2, rectF2);
        lock.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void calculateWindowBounds(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.tmpArray;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean layoutDependsOn(View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        } else if (!(view2 instanceof FloatingActionButton)) {
            return false;
        } else {
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId()) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet onCreateExpandedStateChangeAnimation(final View view, final View view2, final boolean z, boolean z2) {
        ObjectAnimator objectAnimator;
        float f;
        char c;
        ObjectAnimator objectAnimator2;
        ObjectAnimator objectAnimator3;
        ViewGroup viewGroup;
        ObjectAnimator objectAnimator4;
        IntReader onCreateMotionSpec = onCreateMotionSpec(view2.getContext(), z);
        if (z) {
            this.dependencyOriginalTranslationX = view.getTranslationX();
            this.dependencyOriginalTranslationY = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float elevation = view2.getElevation() - view.getElevation();
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimator = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -elevation);
        }
        ((MotionSpec) onCreateMotionSpec.byteBuffer).getTiming("elevation").apply(objectAnimator);
        arrayList.add(objectAnimator);
        float calculateTranslationX = calculateTranslationX(view, view2, (Lock) onCreateMotionSpec.intBuffer);
        float calculateTranslationY = calculateTranslationY(view, view2, (Lock) onCreateMotionSpec.intBuffer);
        Pair calculateMotionTiming = calculateMotionTiming(calculateTranslationX, calculateTranslationY, z, onCreateMotionSpec);
        MotionTiming motionTiming = (MotionTiming) calculateMotionTiming.first;
        MotionTiming motionTiming2 = (MotionTiming) calculateMotionTiming.second;
        RectF rectF = this.tmpRectF1;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-calculateTranslationX);
                view2.setTranslationY(-calculateTranslationY);
            }
            c = 0;
            objectAnimator3 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            f = 0.0f;
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            float calculateValueOfAnimationAtEndOfExpansion = calculateValueOfAnimationAtEndOfExpansion(onCreateMotionSpec, motionTiming, -calculateTranslationX);
            float calculateValueOfAnimationAtEndOfExpansion2 = calculateValueOfAnimationAtEndOfExpansion(onCreateMotionSpec, motionTiming2, -calculateTranslationY);
            Rect rect = this.tmpRect;
            view2.getWindowVisibleDisplayFrame(rect);
            rectF.set(rect);
            RectF rectF2 = this.tmpRectF2;
            calculateWindowBounds(view2, rectF2);
            rectF2.offset(calculateValueOfAnimationAtEndOfExpansion, calculateValueOfAnimationAtEndOfExpansion2);
            rectF2.intersect(rectF);
            rectF.set(rectF2);
        } else {
            c = 0;
            f = 0.0f;
            objectAnimator3 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -calculateTranslationX);
            objectAnimator2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -calculateTranslationY);
        }
        motionTiming.apply(objectAnimator3);
        motionTiming2.apply(objectAnimator2);
        arrayList.add(objectAnimator3);
        arrayList.add(objectAnimator2);
        rectF.width();
        rectF.height();
        float calculateTranslationX2 = calculateTranslationX(view, view2, (Lock) onCreateMotionSpec.intBuffer);
        float calculateTranslationY2 = calculateTranslationY(view, view2, (Lock) onCreateMotionSpec.intBuffer);
        Pair calculateMotionTiming2 = calculateMotionTiming(calculateTranslationX2, calculateTranslationY2, z, onCreateMotionSpec);
        MotionTiming motionTiming3 = (MotionTiming) calculateMotionTiming2.first;
        MotionTiming motionTiming4 = (MotionTiming) calculateMotionTiming2.second;
        Property property = View.TRANSLATION_X;
        if (!z) {
            calculateTranslationX2 = this.dependencyOriginalTranslationX;
        }
        float[] fArr = new float[1];
        fArr[c] = calculateTranslationX2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        if (!z) {
            calculateTranslationY2 = this.dependencyOriginalTranslationY;
        }
        float[] fArr2 = new float[1];
        fArr2[c] = calculateTranslationY2;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        motionTiming3.apply(ofFloat);
        motionTiming4.apply(ofFloat2);
        arrayList.add(ofFloat);
        arrayList.add(ofFloat2);
        if (view2 instanceof ViewGroup) {
            View findViewById = view2.findViewById(C0130R.C0132id.mtrl_child_content_container);
            if (findViewById == null) {
                viewGroup = (ViewGroup) view2;
            } else if (findViewById instanceof ViewGroup) {
                viewGroup = (ViewGroup) findViewById;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (z) {
                    if (!z2) {
                        ChildrenAlphaProperty.CHILDREN_ALPHA.set(viewGroup, Float.valueOf(f));
                    }
                    ChildrenAlphaProperty childrenAlphaProperty = ChildrenAlphaProperty.CHILDREN_ALPHA;
                    float[] fArr3 = new float[1];
                    fArr3[c] = 1.0f;
                    objectAnimator4 = ObjectAnimator.ofFloat(viewGroup, childrenAlphaProperty, fArr3);
                } else {
                    ChildrenAlphaProperty childrenAlphaProperty2 = ChildrenAlphaProperty.CHILDREN_ALPHA;
                    float[] fArr4 = new float[1];
                    fArr4[c] = f;
                    objectAnimator4 = ObjectAnimator.ofFloat(viewGroup, childrenAlphaProperty2, fArr4);
                }
                ((MotionSpec) onCreateMotionSpec.byteBuffer).getTiming("contentFade").apply(objectAnimator4);
                arrayList.add(objectAnimator4);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        LazyKt__LazyJVMKt.playTogether(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.transformation.FabTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                if (!z) {
                    view2.setVisibility(4);
                    View view3 = view;
                    view3.setAlpha(1.0f);
                    view3.setVisibility(0);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                if (z) {
                    view2.setVisibility(0);
                    View view3 = view;
                    view3.setAlpha(0.0f);
                    view3.setVisibility(4);
                }
            }
        });
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    public abstract IntReader onCreateMotionSpec(Context context, boolean z);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }
}
