package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.viewpager2.widget.FakeDrag;
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior {
    public boolean interceptingEvents;
    public boolean requestingDisallowInterceptTouchEvent;
    public ViewDragHelper viewDragHelper;
    public int swipeDirection = 2;
    public float alphaStartSwipeDistance = 0.0f;
    public float alphaEndSwipeDistance = 0.5f;
    public final AnonymousClass1 dragCallback = new BundleKt() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
        public int activePointerId = -1;
        public int originalCapturedViewLeft;

        @Override // androidx.core.os.BundleKt
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

        @Override // androidx.core.os.BundleKt
        public final int clampViewPositionVertical(int i, View view) {
            return view.getTop();
        }

        @Override // androidx.core.os.BundleKt
        public final int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // androidx.core.os.BundleKt
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

        @Override // androidx.core.os.BundleKt
        public final void onViewDragStateChanged(int i) {
        }

        @Override // androidx.core.os.BundleKt
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
        @Override // androidx.core.os.BundleKt
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onViewReleased(android.view.View r9, float r10, float r11) {
            /*
                r8 = this;
                r11 = -1
                r8.activePointerId = r11
                int r11 = r9.getWidth()
                r0 = 0
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r2 = 1
                r3 = 0
                int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r4 == 0) goto L37
                int r5 = r9.getLayoutDirection()
                if (r5 != r2) goto L18
                r5 = 1
                goto L19
            L18:
                r5 = 0
            L19:
                int r6 = r1.swipeDirection
                r7 = 2
                if (r6 != r7) goto L1f
                goto L51
            L1f:
                if (r6 != 0) goto L2b
                if (r5 == 0) goto L28
                int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r4 >= 0) goto L65
                goto L51
            L28:
                if (r4 <= 0) goto L65
                goto L51
            L2b:
                if (r6 != r2) goto L65
                if (r5 == 0) goto L32
                if (r4 <= 0) goto L65
                goto L51
            L32:
                int r4 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r4 >= 0) goto L65
                goto L51
            L37:
                int r4 = r9.getLeft()
                int r5 = r8.originalCapturedViewLeft
                int r4 = r4 - r5
                int r5 = r9.getWidth()
                float r5 = (float) r5
                r6 = 1056964608(0x3f000000, float:0.5)
                float r5 = r5 * r6
                int r5 = java.lang.Math.round(r5)
                int r4 = java.lang.Math.abs(r4)
                if (r4 < r5) goto L65
            L51:
                int r10 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
                if (r10 < 0) goto L60
                int r10 = r9.getLeft()
                int r0 = r8.originalCapturedViewLeft
                if (r10 >= r0) goto L5e
                goto L60
            L5e:
                int r0 = r0 + r11
                goto L69
            L60:
                int r10 = r8.originalCapturedViewLeft
                int r0 = r10 - r11
                goto L69
            L65:
                int r10 = r8.originalCapturedViewLeft
                r0 = r10
                r2 = 0
            L69:
                androidx.customview.widget.ViewDragHelper r10 = r1.viewDragHelper
                int r11 = r9.getTop()
                boolean r10 = r10.settleCapturedViewAt(r0, r11)
                if (r10 == 0) goto L7d
                com.google.android.gms.tasks.zzi r10 = new com.google.android.gms.tasks.zzi
                r10.<init>(r1, r9, r2)
                r9.postOnAnimation(r10)
            L7d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.core.os.BundleKt
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
