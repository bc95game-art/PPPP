package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.p002os.BundleKt;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.android.billingclient.api.zzcl;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class SpringAnimation {
    public final ArrayList mEndListeners;
    public boolean mEndRequested;
    public long mLastFrameTime;
    public float mMaxValue;
    public float mMinValue;
    public float mMinVisibleChange;
    public float mPendingPosition;
    public final BundleKt mProperty;
    public boolean mRunning;
    public SpringForce mSpring;
    public boolean mStartValueIsSet;
    public final Shapeable mTarget;
    public final ArrayList mUpdateListeners;
    public float mValue;
    public float mVelocity;
    public static final DynamicAnimation$4 SCALE_X = new BundleKt() { // from class: androidx.dynamicanimation.animation.DynamicAnimation$4
        @Override // androidx.core.p002os.BundleKt
        public final float getValue(Shapeable shapeable) {
            switch (r1) {
                case 0:
                    return ((View) shapeable).getScaleX();
                case 1:
                    return ((View) shapeable).getAlpha();
                case 2:
                    return ((View) shapeable).getScaleY();
                case 3:
                    return ((View) shapeable).getRotation();
                case 4:
                    return ((View) shapeable).getRotationX();
                default:
                    return ((View) shapeable).getRotationY();
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final void setValue(Shapeable shapeable, float f) {
            switch (r1) {
                case 0:
                    ((View) shapeable).setScaleX(f);
                    return;
                case 1:
                    ((View) shapeable).setAlpha(f);
                    return;
                case 2:
                    ((View) shapeable).setScaleY(f);
                    return;
                case 3:
                    ((View) shapeable).setRotation(f);
                    return;
                case 4:
                    ((View) shapeable).setRotationX(f);
                    return;
                default:
                    ((View) shapeable).setRotationY(f);
                    return;
            }
        }
    };
    public static final DynamicAnimation$4 SCALE_Y = new BundleKt() { // from class: androidx.dynamicanimation.animation.DynamicAnimation$4
        @Override // androidx.core.p002os.BundleKt
        public final float getValue(Shapeable shapeable) {
            switch (r1) {
                case 0:
                    return ((View) shapeable).getScaleX();
                case 1:
                    return ((View) shapeable).getAlpha();
                case 2:
                    return ((View) shapeable).getScaleY();
                case 3:
                    return ((View) shapeable).getRotation();
                case 4:
                    return ((View) shapeable).getRotationX();
                default:
                    return ((View) shapeable).getRotationY();
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final void setValue(Shapeable shapeable, float f) {
            switch (r1) {
                case 0:
                    ((View) shapeable).setScaleX(f);
                    return;
                case 1:
                    ((View) shapeable).setAlpha(f);
                    return;
                case 2:
                    ((View) shapeable).setScaleY(f);
                    return;
                case 3:
                    ((View) shapeable).setRotation(f);
                    return;
                case 4:
                    ((View) shapeable).setRotationX(f);
                    return;
                default:
                    ((View) shapeable).setRotationY(f);
                    return;
            }
        }
    };
    public static final DynamicAnimation$4 ROTATION = new BundleKt() { // from class: androidx.dynamicanimation.animation.DynamicAnimation$4
        @Override // androidx.core.p002os.BundleKt
        public final float getValue(Shapeable shapeable) {
            switch (r1) {
                case 0:
                    return ((View) shapeable).getScaleX();
                case 1:
                    return ((View) shapeable).getAlpha();
                case 2:
                    return ((View) shapeable).getScaleY();
                case 3:
                    return ((View) shapeable).getRotation();
                case 4:
                    return ((View) shapeable).getRotationX();
                default:
                    return ((View) shapeable).getRotationY();
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final void setValue(Shapeable shapeable, float f) {
            switch (r1) {
                case 0:
                    ((View) shapeable).setScaleX(f);
                    return;
                case 1:
                    ((View) shapeable).setAlpha(f);
                    return;
                case 2:
                    ((View) shapeable).setScaleY(f);
                    return;
                case 3:
                    ((View) shapeable).setRotation(f);
                    return;
                case 4:
                    ((View) shapeable).setRotationX(f);
                    return;
                default:
                    ((View) shapeable).setRotationY(f);
                    return;
            }
        }
    };
    public static final DynamicAnimation$4 ROTATION_X = new BundleKt() { // from class: androidx.dynamicanimation.animation.DynamicAnimation$4
        @Override // androidx.core.p002os.BundleKt
        public final float getValue(Shapeable shapeable) {
            switch (r1) {
                case 0:
                    return ((View) shapeable).getScaleX();
                case 1:
                    return ((View) shapeable).getAlpha();
                case 2:
                    return ((View) shapeable).getScaleY();
                case 3:
                    return ((View) shapeable).getRotation();
                case 4:
                    return ((View) shapeable).getRotationX();
                default:
                    return ((View) shapeable).getRotationY();
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final void setValue(Shapeable shapeable, float f) {
            switch (r1) {
                case 0:
                    ((View) shapeable).setScaleX(f);
                    return;
                case 1:
                    ((View) shapeable).setAlpha(f);
                    return;
                case 2:
                    ((View) shapeable).setScaleY(f);
                    return;
                case 3:
                    ((View) shapeable).setRotation(f);
                    return;
                case 4:
                    ((View) shapeable).setRotationX(f);
                    return;
                default:
                    ((View) shapeable).setRotationY(f);
                    return;
            }
        }
    };
    public static final DynamicAnimation$4 ROTATION_Y = new BundleKt() { // from class: androidx.dynamicanimation.animation.DynamicAnimation$4
        @Override // androidx.core.p002os.BundleKt
        public final float getValue(Shapeable shapeable) {
            switch (r1) {
                case 0:
                    return ((View) shapeable).getScaleX();
                case 1:
                    return ((View) shapeable).getAlpha();
                case 2:
                    return ((View) shapeable).getScaleY();
                case 3:
                    return ((View) shapeable).getRotation();
                case 4:
                    return ((View) shapeable).getRotationX();
                default:
                    return ((View) shapeable).getRotationY();
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final void setValue(Shapeable shapeable, float f) {
            switch (r1) {
                case 0:
                    ((View) shapeable).setScaleX(f);
                    return;
                case 1:
                    ((View) shapeable).setAlpha(f);
                    return;
                case 2:
                    ((View) shapeable).setScaleY(f);
                    return;
                case 3:
                    ((View) shapeable).setRotation(f);
                    return;
                case 4:
                    ((View) shapeable).setRotationX(f);
                    return;
                default:
                    ((View) shapeable).setRotationY(f);
                    return;
            }
        }
    };
    public static final DynamicAnimation$4 ALPHA = new BundleKt() { // from class: androidx.dynamicanimation.animation.DynamicAnimation$4
        @Override // androidx.core.p002os.BundleKt
        public final float getValue(Shapeable shapeable) {
            switch (r1) {
                case 0:
                    return ((View) shapeable).getScaleX();
                case 1:
                    return ((View) shapeable).getAlpha();
                case 2:
                    return ((View) shapeable).getScaleY();
                case 3:
                    return ((View) shapeable).getRotation();
                case 4:
                    return ((View) shapeable).getRotationX();
                default:
                    return ((View) shapeable).getRotationY();
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final void setValue(Shapeable shapeable, float f) {
            switch (r1) {
                case 0:
                    ((View) shapeable).setScaleX(f);
                    return;
                case 1:
                    ((View) shapeable).setAlpha(f);
                    return;
                case 2:
                    ((View) shapeable).setScaleY(f);
                    return;
                case 3:
                    ((View) shapeable).setRotation(f);
                    return;
                case 4:
                    ((View) shapeable).setRotationX(f);
                    return;
                default:
                    ((View) shapeable).setRotationY(f);
                    return;
            }
        }
    };

    public SpringAnimation(final FloatValueHolder floatValueHolder) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -3.4028235E38f;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = null;
        this.mProperty = new BundleKt() { // from class: androidx.dynamicanimation.animation.DynamicAnimation$15
            @Override // androidx.core.p002os.BundleKt
            public final float getValue(Shapeable shapeable) {
                return FloatValueHolder.this.mValue;
            }

            @Override // androidx.core.p002os.BundleKt
            public final void setValue(Shapeable shapeable, float f) {
                FloatValueHolder.this.mValue = f;
            }
        };
        this.mMinVisibleChange = 1.0f;
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public static AnimationHandler getAnimationHandler() {
        ThreadLocal threadLocal = AnimationHandler.sAnimatorHandler;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler(new zzcl(10)));
        }
        return (AnimationHandler) threadLocal.get();
    }

    public final void animateToFinalPosition(float f) {
        if (this.mRunning) {
            this.mPendingPosition = f;
            return;
        }
        if (this.mSpring == null) {
            this.mSpring = new SpringForce(f);
        }
        SpringForce springForce = this.mSpring;
        double d = f;
        springForce.mFinalPosition = d;
        double d2 = (float) d;
        if (d2 > this.mMaxValue) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        } else if (d2 >= this.mMinValue) {
            double abs = Math.abs(this.mMinVisibleChange * 0.75f);
            springForce.mValueThreshold = abs;
            springForce.mVelocityThreshold = abs * 62.5d;
            zzcl zzclVar = getAnimationHandler().mScheduler;
            zzclVar.getClass();
            if (Thread.currentThread() == ((Looper) zzclVar.zzc).getThread()) {
                boolean z = this.mRunning;
                if (!z && !z) {
                    this.mRunning = true;
                    if (!this.mStartValueIsSet) {
                        this.mValue = this.mProperty.getValue(this.mTarget);
                    }
                    float f2 = this.mValue;
                    if (f2 > this.mMaxValue || f2 < this.mMinValue) {
                        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
                    }
                    getAnimationHandler().addAnimationFrameCallback(this);
                    return;
                }
                return;
            }
            throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
        } else {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    public final void setPropertyValue(float f) {
        ArrayList arrayList;
        this.mProperty.setValue(this.mTarget, f);
        int i = 0;
        while (true) {
            arrayList = this.mUpdateListeners;
            if (i >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i) != null) {
                Transition.SeekController seekController = (Transition.SeekController) arrayList.get(i);
                float f2 = this.mValue;
                TransitionSet transitionSet = seekController.this$0;
                long max = Math.max(-1L, Math.min(transitionSet.mTotalDuration + 1, Math.round(f2)));
                transitionSet.setCurrentPlayTimeMillis(max, seekController.mCurrentPlayTime);
                seekController.mCurrentPlayTime = max;
            }
            i++;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public final void skipToEnd() {
        if (this.mSpring.mDampingRatio > 0.0d) {
            zzcl zzclVar = getAnimationHandler().mScheduler;
            zzclVar.getClass();
            if (Thread.currentThread() != ((Looper) zzclVar.zzc).getThread()) {
                throw new AndroidRuntimeException("Animations may only be started on the same thread as the animation handler");
            } else if (this.mRunning) {
                this.mEndRequested = true;
            }
        } else {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
    }

    public SpringAnimation(Shapeable shapeable, BundleKt bundleKt) {
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mMaxValue = Float.MAX_VALUE;
        this.mMinValue = -3.4028235E38f;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = shapeable;
        this.mProperty = bundleKt;
        if (bundleKt == ROTATION || bundleKt == ROTATION_X || bundleKt == ROTATION_Y) {
            this.mMinVisibleChange = 0.1f;
        } else if (bundleKt == ALPHA) {
            this.mMinVisibleChange = 0.00390625f;
        } else if (bundleKt == SCALE_X || bundleKt == SCALE_Y) {
            this.mMinVisibleChange = 0.002f;
        } else {
            this.mMinVisibleChange = 1.0f;
        }
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }
}
