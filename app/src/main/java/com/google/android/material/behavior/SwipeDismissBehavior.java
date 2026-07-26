package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.p002os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager2.widget.FakeDrag;
import com.google.android.gms.tasks.zzi;
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior {
    public boolean interceptingEvents;
    public boolean requestingDisallowInterceptTouchEvent;
    public ViewDragHelper viewDragHelper;
    public int swipeDirection = 2;
    public float alphaStartSwipeDistance = 0.0f;
    public float alphaEndSwipeDistance = 0.5f;
    public final C01691 dragCallback = new BundleKt() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
        public int activePointerId = -1;
        public int originalCapturedViewLeft;

        @Override // androidx.core.p002os.BundleKt
        public final int clampViewPositionHorizontal(int i, View view) {
            boolean z;
            int i2;
            int i3;
            int width;
            if (view.getLayoutDirection() == 1) {
                z = true;
            } else {
                z = false;
            }
            int i4 = SwipeDismissBehavior.this.swipeDirection;
            if (i4 == 0) {
                if (z) {
                    i3 = this.originalCapturedViewLeft - view.getWidth();
                    i2 = this.originalCapturedViewLeft;
                } else {
                    i3 = this.originalCapturedViewLeft;
                    width = view.getWidth();
                    i2 = width + i3;
                }
            } else if (i4 != 1) {
                i3 = this.originalCapturedViewLeft - view.getWidth();
                i2 = view.getWidth() + this.originalCapturedViewLeft;
            } else if (z) {
                i3 = this.originalCapturedViewLeft;
                width = view.getWidth();
                i2 = width + i3;
            } else {
                i3 = this.originalCapturedViewLeft - view.getWidth();
                i2 = this.originalCapturedViewLeft;
            }
            return Math.min(Math.max(i3, i), i2);
        }

        @Override // androidx.core.p002os.BundleKt
        public final int clampViewPositionVertical(int i, View view) {
            return view.getTop();
        }

        @Override // androidx.core.p002os.BundleKt
        public final int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // androidx.core.p002os.BundleKt
        public final void onViewCaptured(int i, View view) {
            this.activePointerId = i;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
                swipeDismissBehavior.requestingDisallowInterceptTouchEvent = true;
                parent.requestDisallowInterceptTouchEvent(true);
                swipeDismissBehavior.requestingDisallowInterceptTouchEvent = false;
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final void onViewDragStateChanged(int i) {
        }

        @Override // androidx.core.p002os.BundleKt
        public final void onViewPositionChanged(View view, int i, int i2) {
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            float width = view.getWidth() * swipeDismissBehavior.alphaStartSwipeDistance;
            float width2 = view.getWidth() * swipeDismissBehavior.alphaEndSwipeDistance;
            float abs = Math.abs(i - this.originalCapturedViewLeft);
            if (abs <= width) {
                view.setAlpha(1.0f);
            } else if (abs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((abs - width) / (width2 - width))), 1.0f));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
            if (java.lang.Math.abs(r4) >= java.lang.Math.round(r9.getWidth() * 0.5f)) goto L22;
         */
        @Override // androidx.core.p002os.BundleKt
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onViewReleased(View view, float f, float f2) {
            int i;
            boolean z;
            this.activePointerId = -1;
            int width = view.getWidth();
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            boolean z2 = true;
            int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i2 != 0) {
                if (view.getLayoutDirection() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                int i3 = swipeDismissBehavior.swipeDirection;
                if (i3 != 2) {
                    if (i3 == 0) {
                        i = this.originalCapturedViewLeft;
                        z2 = false;
                    } else {
                        i = this.originalCapturedViewLeft;
                        z2 = false;
                    }
                }
                if (f >= 0.0f) {
                    int left = view.getLeft();
                    int i4 = this.originalCapturedViewLeft;
                    if (left >= i4) {
                        i = i4 + width;
                    }
                }
                i = this.originalCapturedViewLeft - width;
            } else {
                int left2 = view.getLeft() - this.originalCapturedViewLeft;
            }
            if (swipeDismissBehavior.viewDragHelper.settleCapturedViewAt(i, view.getTop())) {
                view.postOnAnimation(new zzi(swipeDismissBehavior, view, z2));
            }
        }

        @Override // androidx.core.p002os.BundleKt
        public final boolean tryCaptureView(int i, View view) {
            int i2 = this.activePointerId;
            if ((i2 == -1 || i2 == i) && SwipeDismissBehavior.this.canSwipeDismissView(view)) {
                return true;
            }
            return false;
        }
    };

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (z) {
            if (this.viewDragHelper == null) {
                this.viewDragHelper = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.dragCallback);
            }
            if (!this.requestingDisallowInterceptTouchEvent && this.viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            ViewCompat.removeActionWithId(1048576, view);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, view);
            if (canSwipeDismissView(view)) {
                ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, new FakeDrag(27, this));
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.viewDragHelper == null) {
            return false;
        }
        if (this.requestingDisallowInterceptTouchEvent && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }
}
