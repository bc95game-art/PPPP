package androidx.core.widget;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.DropDownListView;
import androidx.core.view.ViewCompat;
import com.android.billingclient.api.zzab;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class ListViewAutoScrollHelper implements View.OnTouchListener {
    public static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    public boolean mAlreadyDelayed;
    public boolean mAnimating;
    public boolean mEnabled;
    public final float[] mMaximumEdges;
    public final float[] mMaximumVelocity;
    public final float[] mMinimumVelocity;
    public boolean mNeedsCancel;
    public boolean mNeedsReset;
    public final float[] mRelativeEdges;
    public final float[] mRelativeVelocity;
    public zzab mRunnable;
    public final AutoScrollHelper$ClampedScroller mScroller;
    public final DropDownListView mTarget;
    public final DropDownListView mTarget$1;
    public final AccelerateInterpolator mEdgeInterpolator = new AccelerateInterpolator();
    public final int mEdgeType = 1;
    public final int mActivationDelay = DEFAULT_ACTIVATION_DELAY;

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, androidx.core.widget.AutoScrollHelper$ClampedScroller] */
    public ListViewAutoScrollHelper(DropDownListView dropDownListView) {
        ?? obj = new Object();
        obj.mStartTime = Long.MIN_VALUE;
        obj.mStopTime = -1L;
        obj.mDeltaTime = 0L;
        this.mScroller = obj;
        float[] fArr = {0.0f, 0.0f};
        this.mRelativeEdges = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.mMaximumEdges = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.mRelativeVelocity = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.mMinimumVelocity = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.mMaximumVelocity = fArr5;
        this.mTarget$1 = dropDownListView;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        obj.mRampUpDuration = 500;
        obj.mRampDownDuration = 500;
        this.mTarget = dropDownListView;
    }

    public static float constrain(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float computeTargetVelocity(int i, float f, float f2, float f3) {
        float f4;
        int i2;
        float f5;
        float constrain = constrain(this.mRelativeEdges[i] * f2, 0.0f, this.mMaximumEdges[i]);
        float constrainEdgeValue = constrainEdgeValue(f2 - f, constrain) - constrainEdgeValue(f, constrain);
        AccelerateInterpolator accelerateInterpolator = this.mEdgeInterpolator;
        if (constrainEdgeValue < 0.0f) {
            f5 = -accelerateInterpolator.getInterpolation(-constrainEdgeValue);
        } else if (constrainEdgeValue > 0.0f) {
            f5 = accelerateInterpolator.getInterpolation(constrainEdgeValue);
        } else {
            f4 = 0.0f;
            i2 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
            if (i2 != 0) {
                return 0.0f;
            }
            float f6 = this.mRelativeVelocity[i];
            float f7 = this.mMinimumVelocity[i];
            float f8 = this.mMaximumVelocity[i];
            float f9 = f6 * f3;
            if (i2 > 0) {
                return constrain(f4 * f9, f7, f8);
            }
            return -constrain((-f4) * f9, f7, f8);
        }
        f4 = constrain(f5, -1.0f, 1.0f);
        i2 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
        if (i2 != 0) {
        }
    }

    public final float constrainEdgeValue(float f, float f2) {
        if (f2 != 0.0f) {
            int i = this.mEdgeType;
            if (i == 0 || i == 1) {
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.mAnimating && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f < 0.0f) {
                return f / (-f2);
            }
        }
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
        if (r0 != 3) goto L28;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        if (this.mEnabled) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                    }
                }
                requestStop();
                return false;
            }
            this.mNeedsCancel = true;
            this.mAlreadyDelayed = false;
            DropDownListView dropDownListView = this.mTarget$1;
            float computeTargetVelocity = computeTargetVelocity(0, motionEvent.getX(), view.getWidth(), dropDownListView.getWidth());
            float computeTargetVelocity2 = computeTargetVelocity(1, motionEvent.getY(), view.getHeight(), dropDownListView.getHeight());
            AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
            autoScrollHelper$ClampedScroller.mTargetVelocityX = computeTargetVelocity;
            autoScrollHelper$ClampedScroller.mTargetVelocityY = computeTargetVelocity2;
            if (!this.mAnimating && shouldAnimate()) {
                if (this.mRunnable == null) {
                    this.mRunnable = new zzab(5, this);
                }
                this.mAnimating = true;
                this.mNeedsReset = true;
                if (this.mAlreadyDelayed || (i = this.mActivationDelay) <= 0) {
                    this.mRunnable.run();
                } else {
                    zzab zzabVar = this.mRunnable;
                    long j = i;
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    dropDownListView.postOnAnimationDelayed(zzabVar, j);
                }
                this.mAlreadyDelayed = true;
            }
        }
        return false;
    }

    public final void requestStop() {
        int i = 0;
        if (this.mNeedsReset) {
            this.mAnimating = false;
            return;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
        int i2 = (int) (currentAnimationTimeMillis - autoScrollHelper$ClampedScroller.mStartTime);
        int i3 = autoScrollHelper$ClampedScroller.mRampDownDuration;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        autoScrollHelper$ClampedScroller.mEffectiveRampDown = i;
        autoScrollHelper$ClampedScroller.mStopValue = autoScrollHelper$ClampedScroller.getValueAt(currentAnimationTimeMillis);
        autoScrollHelper$ClampedScroller.mStopTime = currentAnimationTimeMillis;
    }

    public final boolean shouldAnimate() {
        DropDownListView dropDownListView;
        int count;
        AutoScrollHelper$ClampedScroller autoScrollHelper$ClampedScroller = this.mScroller;
        float f = autoScrollHelper$ClampedScroller.mTargetVelocityY;
        int abs = (int) (f / Math.abs(f));
        Math.abs(autoScrollHelper$ClampedScroller.mTargetVelocityX);
        if (!(abs == 0 || (count = (dropDownListView = this.mTarget).getCount()) == 0)) {
            int childCount = dropDownListView.getChildCount();
            int firstVisiblePosition = dropDownListView.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && dropDownListView.getChildAt(0).getTop() >= 0)) : !(i >= count && dropDownListView.getChildAt(childCount - 1).getBottom() <= dropDownListView.getHeight())) {
                return true;
            }
        }
        return false;
    }
}
