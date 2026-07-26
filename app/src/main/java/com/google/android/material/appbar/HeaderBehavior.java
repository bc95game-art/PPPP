package com.google.android.material.appbar;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.android.billingclient.api.zzam;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public abstract class HeaderBehavior extends ViewOffsetBehavior {
    public int activePointerId;
    public zzam flingRunnable;
    public boolean isBeingDragged;
    public int lastMotionY;
    public OverScroller scroller;
    public int touchSlop;
    public VelocityTracker velocityTracker;

    public abstract int getTopBottomOffsetForScrollingSibling();

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z;
        View view2;
        int findPointerIndex;
        if (this.touchSlop < 0) {
            this.touchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.isBeingDragged) {
            int i = this.activePointerId;
            if (!(i == -1 || (findPointerIndex = motionEvent.findPointerIndex(i)) == -1)) {
                int y = (int) motionEvent.getY(findPointerIndex);
                if (Math.abs(y - this.lastMotionY) > this.touchSlop) {
                    this.lastMotionY = y;
                    return true;
                }
            }
            return false;
        }
        if (motionEvent.getActionMasked() == 0) {
            this.activePointerId = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            AppBarLayout appBarLayout = (AppBarLayout) view;
            WeakReference weakReference = ((AppBarLayout.BaseBehavior) this).lastNestedScrollingChildRef;
            if ((weakReference == null || ((view2 = (View) weakReference.get()) != null && view2.isShown() && !view2.canScrollVertically(-1))) && coordinatorLayout.isPointInChildBounds(view, x, y2)) {
                z = true;
            } else {
                z = false;
            }
            this.isBeingDragged = z;
            if (z) {
                this.lastMotionY = y2;
                this.activePointerId = motionEvent.getPointerId(0);
                if (this.velocityTracker == null) {
                    this.velocityTracker = VelocityTracker.obtain();
                }
                OverScroller overScroller = this.scroller;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.scroller.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fa A[ADDED_TO_REGION] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int i;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.activePointerId);
                if (findPointerIndex != -1) {
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i2 = this.lastMotionY - y;
                    this.lastMotionY = y;
                    AppBarLayout appBarLayout = (AppBarLayout) view;
                    setHeaderTopBottomOffset(coordinatorLayout, view, getTopBottomOffsetForScrollingSibling() - i2, appBarLayout.getTopInset() + (-appBarLayout.getDownNestedScrollRange()), 0);
                }
                return false;
            } else if (actionMasked != 3) {
                if (actionMasked == 6) {
                    if (motionEvent.getActionIndex() == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    this.activePointerId = motionEvent.getPointerId(i);
                    this.lastMotionY = (int) (motionEvent.getY(i) + 0.5f);
                }
            }
            z = false;
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (!this.isBeingDragged || z) {
                return true;
            }
            return false;
        }
        VelocityTracker velocityTracker3 = this.velocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
            this.velocityTracker.computeCurrentVelocity(1000);
            float yVelocity = this.velocityTracker.getYVelocity(this.activePointerId);
            AppBarLayout appBarLayout2 = (AppBarLayout) view;
            int i3 = -appBarLayout2.getTotalScrollRange();
            Runnable runnable = this.flingRunnable;
            if (runnable != null) {
                view.removeCallbacks(runnable);
                this.flingRunnable = null;
            }
            if (this.scroller == null) {
                this.scroller = new OverScroller(view.getContext());
            }
            this.scroller.fling(0, getTopAndBottomOffset(), 0, Math.round(yVelocity), 0, 0, i3, 0);
            if (this.scroller.computeScrollOffset()) {
                zzam zzamVar = new zzam(this, coordinatorLayout, view);
                this.flingRunnable = zzamVar;
                view.postOnAnimation(zzamVar);
            } else {
                ((AppBarLayout.BaseBehavior) this).snapToChildIfNeeded(coordinatorLayout, appBarLayout2);
                if (appBarLayout2.liftOnScroll) {
                    appBarLayout2.setLiftedState(appBarLayout2.shouldLift(AppBarLayout.BaseBehavior.findFirstScrollingChild(coordinatorLayout)));
                }
            }
            z = true;
            this.isBeingDragged = false;
            this.activePointerId = -1;
            velocityTracker2 = this.velocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.velocityTracker = null;
            }
            velocityTracker = this.velocityTracker;
            if (velocityTracker != null) {
            }
            if (!this.isBeingDragged) {
            }
            return true;
        }
        z = false;
        this.isBeingDragged = false;
        this.activePointerId = -1;
        velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
        }
        velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
        }
        if (!this.isBeingDragged) {
        }
        return true;
    }

    public abstract int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3);

    public final void setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, View view, int i) {
        setHeaderTopBottomOffset(coordinatorLayout, view, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
