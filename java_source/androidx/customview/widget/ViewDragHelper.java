package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.core.p002os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import com.android.billingclient.api.zzab;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class ViewDragHelper {
    public static final ViewPager.animationInterpolatorC01182 sInterpolator = new ViewPager.animationInterpolatorC01182(1);
    public final BundleKt mCallback;
    public View mCapturedView;
    public final int mDefaultEdgeSize;
    public int mDragState;
    public int[] mEdgeDragsInProgress;
    public int[] mEdgeDragsLocked;
    public int mEdgeSize;
    public int[] mInitialEdgesTouched;
    public float[] mInitialMotionX;
    public float[] mInitialMotionY;
    public float[] mLastMotionX;
    public float[] mLastMotionY;
    public final float mMaxVelocity;
    public float mMinVelocity;
    public final ViewGroup mParentView;
    public int mPointersDown;
    public boolean mReleaseInProgress;
    public final OverScroller mScroller;
    public int mTouchSlop;
    public int mTrackingEdges;
    public VelocityTracker mVelocityTracker;
    public int mActivePointerId = -1;
    public final zzab mSetIdleRunnable = new zzab(6, this);

    public ViewDragHelper(Context context, ViewGroup viewGroup, BundleKt bundleKt) {
        if (bundleKt != null) {
            this.mParentView = viewGroup;
            this.mCallback = bundleKt;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mDefaultEdgeSize = i;
            this.mEdgeSize = i;
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            this.mScroller = new OverScroller(context, sInterpolator);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    public final void cancel() {
        this.mActivePointerId = -1;
        float[] fArr = this.mInitialMotionX;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.mInitialMotionY, 0.0f);
            Arrays.fill(this.mLastMotionX, 0.0f);
            Arrays.fill(this.mLastMotionY, 0.0f);
            Arrays.fill(this.mInitialEdgesTouched, 0);
            Arrays.fill(this.mEdgeDragsInProgress, 0);
            Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public final void captureChildView(int i, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.mParentView;
        if (parent == viewGroup) {
            this.mCapturedView = view;
            this.mActivePointerId = i;
            this.mCallback.onViewCaptured(i, view);
            setDragState(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
    }

    public final boolean checkNewEdgeDrag(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.mInitialEdgesTouched[i] & i2) != i2 || (this.mTrackingEdges & i2) == 0 || (this.mEdgeDragsLocked[i] & i2) == i2 || (this.mEdgeDragsInProgress[i] & i2) == i2) {
            return false;
        }
        float f3 = this.mTouchSlop;
        if (abs <= f3 && abs2 <= f3) {
            return false;
        }
        if (abs < abs2 * 0.5f) {
            this.mCallback.getClass();
        }
        if ((this.mEdgeDragsInProgress[i] & i2) != 0 || abs <= this.mTouchSlop) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkTouchSlop(View view, float f, float f2) {
        boolean z;
        boolean z2;
        if (view != null) {
            BundleKt bundleKt = this.mCallback;
            if (bundleKt.getViewHorizontalDragRange(view) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (bundleKt.getViewVerticalDragRange() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && z2) {
                float f3 = f2 * f2;
                int i = this.mTouchSlop;
                if (f3 + (f * f) > i * i) {
                }
            } else if (!z ? !(!z2 || Math.abs(f2) <= this.mTouchSlop) : Math.abs(f) > this.mTouchSlop) {
                return true;
            }
        }
        return false;
    }

    public final void clearMotionHistory(int i) {
        float[] fArr = this.mInitialMotionX;
        if (fArr != null) {
            int i2 = this.mPointersDown;
            int i3 = 1 << i;
            if ((i2 & i3) != 0) {
                fArr[i] = 0.0f;
                this.mInitialMotionY[i] = 0.0f;
                this.mLastMotionX[i] = 0.0f;
                this.mLastMotionY[i] = 0.0f;
                this.mInitialEdgesTouched[i] = 0;
                this.mEdgeDragsInProgress[i] = 0;
                this.mEdgeDragsLocked[i] = 0;
                this.mPointersDown = (~i3) & i2;
            }
        }
    }

    public final int computeAxisDuration(int i, int i2, int i3) {
        int width;
        int i4;
        if (i == 0) {
            return 0;
        }
        float width2 = this.mParentView.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(i) / width) - 0.5f) * 0.47123894f)) * width2) + width2;
        int abs = Math.abs(i2);
        if (abs > 0) {
            i4 = Math.round(Math.abs(sin / abs) * 1000.0f) * 4;
        } else {
            i4 = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(i4, 600);
    }

    public final boolean continueSettling() {
        if (this.mDragState == 2) {
            OverScroller overScroller = this.mScroller;
            boolean computeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(left, this.mCapturedView);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(top, this.mCapturedView);
            }
            if (!(left == 0 && top == 0)) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY);
            }
            if (computeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.mParentView.post(this.mSetIdleRunnable);
            }
        }
        if (this.mDragState == 2) {
            return true;
        }
        return false;
    }

    public final View findTopChildUnder(int i, int i2) {
        ViewGroup viewGroup = this.mParentView;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.mCallback.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean forceSettleCapturedViewAt(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        OverScroller overScroller = this.mScroller;
        if (i5 == 0 && i6 == 0) {
            overScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        View view = this.mCapturedView;
        int i7 = (int) this.mMinVelocity;
        int i8 = (int) this.mMaxVelocity;
        int abs = Math.abs(i3);
        if (abs < i7) {
            i3 = 0;
        } else if (abs > i8) {
            if (i3 > 0) {
                i3 = i8;
            } else {
                i3 = -i8;
            }
        }
        int i9 = (int) this.mMinVelocity;
        int abs2 = Math.abs(i4);
        if (abs2 < i9) {
            i4 = 0;
        } else if (abs2 > i8) {
            if (i4 > 0) {
                i4 = i8;
            } else {
                i4 = -i8;
            }
        }
        int abs3 = Math.abs(i5);
        int abs4 = Math.abs(i6);
        int abs5 = Math.abs(i3);
        int abs6 = Math.abs(i4);
        int i10 = abs5 + abs6;
        int i11 = abs3 + abs4;
        if (i3 != 0) {
            f = abs5;
            f2 = i10;
        } else {
            f = abs3;
            f2 = i11;
        }
        float f5 = f / f2;
        if (i4 != 0) {
            f3 = abs6;
            f4 = i10;
        } else {
            f3 = abs4;
            f4 = i11;
        }
        float f6 = f3 / f4;
        BundleKt bundleKt = this.mCallback;
        overScroller.startScroll(left, top, i5, i6, (int) ((computeAxisDuration(i6, i4, bundleKt.getViewVerticalDragRange()) * f6) + (computeAxisDuration(i5, i3, bundleKt.getViewHorizontalDragRange(view)) * f5)));
        setDragState(2);
        return true;
    }

    public final boolean isValidPointerForActionMove(int i) {
        if ((this.mPointersDown & (1 << i)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void processTouchEvent(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        BundleKt bundleKt = this.mCallback;
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x, (int) y);
            saveInitialMotion(x, y, pointerId);
            tryCaptureViewForDrag(pointerId, findTopChildUnder);
            if ((this.mInitialEdgesTouched[pointerId] & this.mTrackingEdges) != 0) {
                bundleKt.onEdgeTouched();
            }
        } else if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.mDragState == 1) {
                    this.mReleaseInProgress = true;
                    bundleKt.onViewReleased(this.mCapturedView, 0.0f, 0.0f);
                    this.mReleaseInProgress = false;
                    if (this.mDragState == 1) {
                        setDragState(0);
                    }
                }
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                saveInitialMotion(x2, y2, pointerId2);
                if (this.mDragState == 0) {
                    tryCaptureViewForDrag(pointerId2, findTopChildUnder((int) x2, (int) y2));
                    if ((this.mInitialEdgesTouched[pointerId2] & this.mTrackingEdges) != 0) {
                        bundleKt.onEdgeTouched();
                        return;
                    }
                    return;
                }
                int i3 = (int) x2;
                int i4 = (int) y2;
                View view = this.mCapturedView;
                if (view != null && i3 >= view.getLeft() && i3 < view.getRight() && i4 >= view.getTop() && i4 < view.getBottom()) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    tryCaptureViewForDrag(pointerId2, this.mCapturedView);
                }
            } else if (actionMasked == 6) {
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                if (this.mDragState == 1 && pointerId3 == this.mActivePointerId) {
                    int pointerCount = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount) {
                            i = -1;
                            break;
                        }
                        int pointerId4 = motionEvent.getPointerId(i2);
                        if (pointerId4 != this.mActivePointerId) {
                            View findTopChildUnder2 = findTopChildUnder((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                            View view2 = this.mCapturedView;
                            if (findTopChildUnder2 == view2 && tryCaptureViewForDrag(pointerId4, view2)) {
                                i = this.mActivePointerId;
                                break;
                            }
                        }
                        i2++;
                    }
                    if (i == -1) {
                        releaseViewForPointerUp();
                    }
                }
                clearMotionHistory(pointerId3);
            }
        } else if (this.mDragState != 1) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (i2 < pointerCount2) {
                int pointerId5 = motionEvent.getPointerId(i2);
                if (isValidPointerForActionMove(pointerId5)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.mInitialMotionX[pointerId5];
                    float f2 = y3 - this.mInitialMotionY[pointerId5];
                    reportNewEdgeDrags(f, f2, pointerId5);
                    if (this.mDragState != 1) {
                        View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
                        if (checkTouchSlop(findTopChildUnder3, f, f2) && tryCaptureViewForDrag(pointerId5, findTopChildUnder3)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            saveLastMotion(motionEvent);
        } else if (isValidPointerForActionMove(this.mActivePointerId)) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            float x4 = motionEvent.getX(findPointerIndex);
            float y4 = motionEvent.getY(findPointerIndex);
            float[] fArr = this.mLastMotionX;
            int i5 = this.mActivePointerId;
            int i6 = (int) (x4 - fArr[i5]);
            int i7 = (int) (y4 - this.mLastMotionY[i5]);
            int left = this.mCapturedView.getLeft() + i6;
            int top = this.mCapturedView.getTop() + i7;
            int left2 = this.mCapturedView.getLeft();
            int top2 = this.mCapturedView.getTop();
            if (i6 != 0) {
                left = bundleKt.clampViewPositionHorizontal(left, this.mCapturedView);
                ViewCompat.offsetLeftAndRight(left - left2, this.mCapturedView);
            }
            if (i7 != 0) {
                top = bundleKt.clampViewPositionVertical(top, this.mCapturedView);
                ViewCompat.offsetTopAndBottom(top - top2, this.mCapturedView);
            }
            if (!(i6 == 0 && i7 == 0)) {
                bundleKt.onViewPositionChanged(this.mCapturedView, left, top);
            }
            saveLastMotion(motionEvent);
        }
    }

    public final void releaseViewForPointerUp() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        float f = this.mMaxVelocity;
        velocityTracker.computeCurrentVelocity(1000, f);
        float xVelocity = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        float f2 = this.mMinVelocity;
        float abs = Math.abs(xVelocity);
        if (abs < f2) {
            xVelocity = 0.0f;
        } else if (abs > f) {
            if (xVelocity > 0.0f) {
                xVelocity = f;
            } else {
                xVelocity = -f;
            }
        }
        float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        float f3 = this.mMinVelocity;
        float abs2 = Math.abs(yVelocity);
        if (abs2 < f3) {
            f = 0.0f;
        } else if (abs2 <= f) {
            f = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f = -f;
        }
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, xVelocity, f);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    public final void reportNewEdgeDrags(float f, float f2, int i) {
        boolean checkNewEdgeDrag = checkNewEdgeDrag(f, f2, i, 1);
        if (checkNewEdgeDrag(f2, f, i, 4)) {
            checkNewEdgeDrag |= true;
        }
        if (checkNewEdgeDrag(f, f2, i, 2)) {
            boolean z = checkNewEdgeDrag ? 1 : 0;
            char c = checkNewEdgeDrag ? 1 : 0;
            checkNewEdgeDrag = z | true;
        }
        if (checkNewEdgeDrag(f2, f, i, 8)) {
            boolean z2 = checkNewEdgeDrag ? 1 : 0;
            char c2 = checkNewEdgeDrag ? 1 : 0;
            checkNewEdgeDrag = z2 | true;
        }
        if (checkNewEdgeDrag) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i] = iArr[i] | (checkNewEdgeDrag ? 1 : 0);
            BundleKt bundleKt = this.mCallback;
            int i2 = checkNewEdgeDrag ? 1 : 0;
            int i3 = checkNewEdgeDrag ? 1 : 0;
            int i4 = checkNewEdgeDrag ? 1 : 0;
            bundleKt.onEdgeDragStarted(i2, i);
        }
    }

    public final void saveInitialMotion(float f, float f2, int i) {
        float[] fArr = this.mInitialMotionX;
        int i2 = 0;
        if (fArr == null || fArr.length <= i) {
            int i3 = i + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
        float[] fArr9 = this.mInitialMotionX;
        this.mLastMotionX[i] = f;
        fArr9[i] = f;
        float[] fArr10 = this.mInitialMotionY;
        this.mLastMotionY[i] = f2;
        fArr10[i] = f2;
        int[] iArr7 = this.mInitialEdgesTouched;
        int i4 = (int) f;
        int i5 = (int) f2;
        ViewGroup viewGroup = this.mParentView;
        if (i4 < viewGroup.getLeft() + this.mEdgeSize) {
            i2 = 1;
        }
        if (i5 < viewGroup.getTop() + this.mEdgeSize) {
            i2 |= 4;
        }
        if (i4 > viewGroup.getRight() - this.mEdgeSize) {
            i2 |= 2;
        }
        if (i5 > viewGroup.getBottom() - this.mEdgeSize) {
            i2 |= 8;
        }
        iArr7[i] = i2;
        this.mPointersDown |= 1 << i;
    }

    public final void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (isValidPointerForActionMove(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.mLastMotionX[pointerId] = x;
                this.mLastMotionY[pointerId] = y;
            }
        }
    }

    public final void setDragState(int i) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i) {
            this.mDragState = i;
            this.mCallback.onViewDragStateChanged(i);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public final boolean settleCapturedViewAt(int i, int i2) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i, i2, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d4, code lost:
        if (r13 != r12) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View findTopChildUnder;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        BundleKt bundleKt = this.mCallback;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float x = motionEvent.getX(actionIndex);
                            float y = motionEvent.getY(actionIndex);
                            saveInitialMotion(x, y, pointerId);
                            int i = this.mDragState;
                            if (i == 0) {
                                if ((this.mInitialEdgesTouched[pointerId] & this.mTrackingEdges) != 0) {
                                    bundleKt.onEdgeTouched();
                                }
                            } else if (i == 2 && (findTopChildUnder = findTopChildUnder((int) x, (int) y)) == this.mCapturedView) {
                                tryCaptureViewForDrag(pointerId, findTopChildUnder);
                            }
                        } else if (actionMasked == 6) {
                            clearMotionHistory(motionEvent.getPointerId(actionIndex));
                        }
                    }
                } else if (!(this.mInitialMotionX == null || this.mInitialMotionY == null)) {
                    int pointerCount = motionEvent.getPointerCount();
                    for (int i2 = 0; i2 < pointerCount; i2++) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (isValidPointerForActionMove(pointerId2)) {
                            float x2 = motionEvent.getX(i2);
                            float y2 = motionEvent.getY(i2);
                            float f = x2 - this.mInitialMotionX[pointerId2];
                            float f2 = y2 - this.mInitialMotionY[pointerId2];
                            View findTopChildUnder2 = findTopChildUnder((int) x2, (int) y2);
                            if (findTopChildUnder2 == null || !checkTouchSlop(findTopChildUnder2, f, f2)) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                int left = findTopChildUnder2.getLeft();
                                int clampViewPositionHorizontal = bundleKt.clampViewPositionHorizontal(((int) f) + left, findTopChildUnder2);
                                int top = findTopChildUnder2.getTop();
                                int clampViewPositionVertical = bundleKt.clampViewPositionVertical(((int) f2) + top, findTopChildUnder2);
                                int viewHorizontalDragRange = bundleKt.getViewHorizontalDragRange(findTopChildUnder2);
                                int viewVerticalDragRange = bundleKt.getViewVerticalDragRange();
                                if (viewHorizontalDragRange != 0) {
                                    if (viewHorizontalDragRange > 0) {
                                    }
                                }
                                if (viewVerticalDragRange != 0) {
                                    if (viewVerticalDragRange > 0 && clampViewPositionVertical == top) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            reportNewEdgeDrags(f, f2, pointerId2);
                            if (this.mDragState != 1) {
                                if (z && tryCaptureViewForDrag(pointerId2, findTopChildUnder2)) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    saveLastMotion(motionEvent);
                }
            }
            cancel();
        } else {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId3 = motionEvent.getPointerId(0);
            saveInitialMotion(x3, y3, pointerId3);
            View findTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
            if (findTopChildUnder3 == this.mCapturedView && this.mDragState == 2) {
                tryCaptureViewForDrag(pointerId3, findTopChildUnder3);
            }
            if ((this.mInitialEdgesTouched[pointerId3] & this.mTrackingEdges) != 0) {
                bundleKt.onEdgeTouched();
            }
        }
        if (this.mDragState == 1) {
            return true;
        }
        return false;
    }

    public final boolean smoothSlideViewTo(View view, int i, int i2) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i, i2, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    public final boolean tryCaptureViewForDrag(int i, View view) {
        if (view == this.mCapturedView && this.mActivePointerId == i) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(i, view)) {
            return false;
        }
        this.mActivePointerId = i;
        captureChildView(i, view);
        return true;
    }
}
