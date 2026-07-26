package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.emanuelef.remote_capture.R;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import java.util.ArrayList;
import kotlin.LazyKt__LazyJVMKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ClockHandView extends View {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final float centerDotRadius;
    public boolean changedDuringTouch;
    public int circleRadius;
    public double degRad;
    public boolean isMultiLevel;
    public float originalDeg;
    public final Paint paint;
    public final ValueAnimator rotationAnimator;
    public final int selectorRadius;
    public final int selectorStrokeWidth;
    public final ArrayList listeners = new ArrayList();
    public final RectF selectorBox = new RectF();
    public int currentLevel = 1;

    /* renamed from: com.google.android.material.timepicker.ClockHandView$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* loaded from: classes.dex */
    public interface OnRotateListener {
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.rotationAnimator = valueAnimator;
        Paint paint = new Paint();
        this.paint = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        LazyKt__LazyJVMKt.resolveThemeDuration(context, R.attr.motionDurationLong2, 200);
        LazyKt__LazyJVMKt.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.selectorRadius = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        Resources resources = getResources();
        this.selectorStrokeWidth = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        setHandRotation(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        obtainStyledAttributes.recycle();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.ClockHandView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i = ClockHandView.$r8$clinit;
                ClockHandView.this.setHandRotationInternal(((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter());
    }

    public final int getLeveledCircleRadius(int i) {
        if (i == 2) {
            return Math.round(this.circleRadius * 0.66f);
        }
        return this.circleRadius;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int leveledCircleRadius;
        int i;
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = width;
        float leveledCircleRadius2 = getLeveledCircleRadius(this.currentLevel);
        float cos = (((float) Math.cos(this.degRad)) * leveledCircleRadius2) + f;
        float f2 = height;
        Paint paint = this.paint;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, (leveledCircleRadius2 * ((float) Math.sin(this.degRad))) + f2, this.selectorRadius, paint);
        double sin = Math.sin(this.degRad);
        paint.setStrokeWidth(this.selectorStrokeWidth);
        canvas.drawLine(f, f2, width + ((int) (Math.cos(this.degRad) * r2)), height + ((int) (r2 * sin)), paint);
        canvas.drawCircle(f, f2, this.centerDotRadius, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.rotationAnimator.isRunning()) {
            setHandRotation(this.originalDeg);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z4 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                z2 = this.changedDuringTouch;
                if (this.isMultiLevel) {
                    if (((float) Math.hypot(x - (getWidth() / 2), y - (getHeight() / 2))) <= getLeveledCircleRadius(2) + ViewUtils.dpToPx(getContext(), 12)) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    this.currentLevel = i;
                }
            } else {
                z2 = false;
            }
            z = false;
        } else {
            this.changedDuringTouch = false;
            z2 = false;
            z = true;
        }
        boolean z5 = this.changedDuringTouch;
        int degrees = (int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x - (getWidth() / 2)));
        int i2 = degrees + 90;
        if (i2 < 0) {
            i2 = degrees + 450;
        }
        float f = i2;
        if (this.originalDeg != f) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z || !z3) {
            if (z3 || z2) {
                setHandRotation(f);
            }
            this.changedDuringTouch = z5 | z4;
            return true;
        }
        z4 = true;
        this.changedDuringTouch = z5 | z4;
        return true;
    }

    public final void setHandRotation(float f) {
        this.rotationAnimator.cancel();
        setHandRotationInternal(f);
    }

    public final void setHandRotationInternal(float f) {
        float f2 = f % 360.0f;
        this.originalDeg = f2;
        this.degRad = Math.toRadians(f2 - 90.0f);
        float leveledCircleRadius = getLeveledCircleRadius(this.currentLevel);
        float cos = (((float) Math.cos(this.degRad)) * leveledCircleRadius) + (getWidth() / 2);
        float sin = (leveledCircleRadius * ((float) Math.sin(this.degRad))) + (getHeight() / 2);
        float f3 = this.selectorRadius;
        this.selectorBox.set(cos - f3, sin - f3, cos + f3, sin + f3);
        ArrayList arrayList = this.listeners;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ClockFaceView clockFaceView = (ClockFaceView) ((OnRotateListener) obj);
            if (Math.abs(clockFaceView.currentHandRotation - f2) > 0.001f) {
                clockFaceView.currentHandRotation = f2;
                clockFaceView.findIntersectingTextView();
            }
        }
        invalidate();
    }
}
