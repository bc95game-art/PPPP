package com.google.android.material.sidesheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.content.res.ResourcesCompat$FontCallback$$ExternalSyntheticLambda1;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import androidx.lifecycle.ViewModelProvider;
import androidx.transition.Transition;
import com.android.billingclient.api.zzab;
import com.emanuelef.remote_capture.R;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.LazyKt__LazyJVMKt;
/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior implements MaterialBackHandler {
    public final ColorStateList backgroundTint;
    public final LinkedHashSet callbacks;
    public int childWidth;
    public final int coplanarSiblingViewId;
    public WeakReference coplanarSiblingViewRef;
    public final AnonymousClass1 dragCallback;
    public final boolean draggable;
    public final float elevation;
    public final float hideFriction;
    public boolean ignoreEvents;
    public int initialX;
    public int innerMargin;
    public final MaterialShapeDrawable materialShapeDrawable;
    public int parentInnerEdge;
    public int parentWidth;
    public final ShapeAppearanceModel shapeAppearanceModel;
    public LazyKt__LazyJVMKt sheetDelegate;
    public MaterialSideContainerBackHelper sideContainerBackHelper;
    public int state;
    public final StateSettlingTracker stateSettlingTracker;
    public VelocityTracker velocityTracker;
    public ViewDragHelper viewDragHelper;
    public WeakReference viewRef;

    /* renamed from: com.google.android.material.sidesheet.SideSheetBehavior$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends BundleKt {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ CoordinatorLayout.Behavior this$0;

        public /* synthetic */ AnonymousClass1(CoordinatorLayout.Behavior behavior, int i) {
            this.$r8$classId = i;
            this.this$0 = behavior;
        }

        @Override // androidx.core.os.BundleKt
        public final int clampViewPositionHorizontal(int i, View view) {
            switch (this.$r8$classId) {
                case 0:
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.this$0;
                    return BundleKt.clamp(i, sideSheetBehavior.sheetDelegate.getMinViewPositionHorizontal(), sideSheetBehavior.sheetDelegate.getMaxViewPositionHorizontal());
                default:
                    return view.getLeft();
            }
        }

        @Override // androidx.core.os.BundleKt
        public final int clampViewPositionVertical(int i, View view) {
            switch (this.$r8$classId) {
                case 0:
                    return view.getTop();
                default:
                    return BundleKt.clamp(i, ((BottomSheetBehavior) this.this$0).getExpandedOffset(), getViewVerticalDragRange());
            }
        }

        @Override // androidx.core.os.BundleKt
        public int getViewHorizontalDragRange(View view) {
            switch (this.$r8$classId) {
                case 0:
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.this$0;
                    return sideSheetBehavior.childWidth + sideSheetBehavior.innerMargin;
                default:
                    return super.getViewHorizontalDragRange(view);
            }
        }

        @Override // androidx.core.os.BundleKt
        public int getViewVerticalDragRange() {
            switch (this.$r8$classId) {
                case 1:
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.this$0;
                    if (bottomSheetBehavior.hideable) {
                        return bottomSheetBehavior.parentHeight;
                    }
                    return bottomSheetBehavior.collapsedOffset;
                default:
                    return super.getViewVerticalDragRange();
            }
        }

        @Override // androidx.core.os.BundleKt
        public final void onViewDragStateChanged(int i) {
            switch (this.$r8$classId) {
                case 0:
                    if (i == 1) {
                        SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.this$0;
                        if (sideSheetBehavior.draggable) {
                            sideSheetBehavior.setStateInternal(1);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    if (i == 1) {
                        BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.this$0;
                        if (bottomSheetBehavior.draggable) {
                            bottomSheetBehavior.setStateInternal(1);
                            return;
                        }
                        return;
                    }
                    return;
            }
        }

        @Override // androidx.core.os.BundleKt
        public final void onViewPositionChanged(View view, int i, int i2) {
            View view2;
            ViewGroup.MarginLayoutParams marginLayoutParams;
            switch (this.$r8$classId) {
                case 0:
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.this$0;
                    WeakReference weakReference = sideSheetBehavior.coplanarSiblingViewRef;
                    if (weakReference != null) {
                        view2 = (View) weakReference.get();
                    } else {
                        view2 = null;
                    }
                    if (!(view2 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) == null)) {
                        sideSheetBehavior.sheetDelegate.updateCoplanarSiblingLayoutParams(marginLayoutParams, view.getLeft(), view.getRight());
                        view2.setLayoutParams(marginLayoutParams);
                    }
                    LinkedHashSet linkedHashSet = sideSheetBehavior.callbacks;
                    if (!linkedHashSet.isEmpty()) {
                        sideSheetBehavior.sheetDelegate.calculateSlideOffset(i);
                        Iterator it = linkedHashSet.iterator();
                        if (it.hasNext()) {
                            throw ViewModelProvider.Factory.CC.m(it);
                        }
                        return;
                    }
                    return;
                default:
                    ((BottomSheetBehavior) this.this$0).dispatchOnSlide(i2);
                    return;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
            if (r7 > r0.halfExpandedOffset) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
            if (java.lang.Math.abs(r6.getTop() - r0.getExpandedOffset()) < java.lang.Math.abs(r6.getTop() - r0.halfExpandedOffset)) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00be, code lost:
            if (java.lang.Math.abs(r7 - r0.fitToContentsOffset) < java.lang.Math.abs(r7 - r0.collapsedOffset)) goto L8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0113, code lost:
            if (r0.sheetDelegate.isReleasedCloseToInnerEdge(r6) == false) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0143, code lost:
            if (java.lang.Math.abs(r7 - r0.sheetDelegate.getExpandedOffset()) < java.lang.Math.abs(r7 - r0.sheetDelegate.getHiddenOffset())) goto L64;
         */
        @Override // androidx.core.os.BundleKt
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onViewReleased(android.view.View r6, float r7, float r8) {
            /*
                Method dump skipped, instructions count: 340
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.AnonymousClass1.onViewReleased(android.view.View, float, float):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
            if (r5.canScrollVertically(-1) != false) goto L23;
         */
        @Override // androidx.core.os.BundleKt
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean tryCaptureView(int r5, android.view.View r6) {
            /*
                r4 = this;
                int r0 = r4.$r8$classId
                switch(r0) {
                    case 0: goto L41;
                    default: goto L5;
                }
            L5:
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r0 = r4.this$0
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r0
                int r1 = r0.state
                r2 = 1
                if (r1 != r2) goto Lf
                goto L3f
            Lf:
                boolean r3 = r0.touchingScrollingChild
                if (r3 == 0) goto L14
                goto L3f
            L14:
                r3 = 3
                if (r1 != r3) goto L31
                int r1 = r0.activePointerId
                if (r1 != r5) goto L31
                java.lang.ref.WeakReference r5 = r0.nestedScrollingChildRef
                if (r5 == 0) goto L26
                java.lang.Object r5 = r5.get()
                android.view.View r5 = (android.view.View) r5
                goto L27
            L26:
                r5 = 0
            L27:
                if (r5 == 0) goto L31
                r1 = -1
                boolean r5 = r5.canScrollVertically(r1)
                if (r5 == 0) goto L31
                goto L3f
            L31:
                android.os.SystemClock.uptimeMillis()
                java.lang.ref.WeakReference r5 = r0.viewRef
                if (r5 == 0) goto L3f
                java.lang.Object r5 = r5.get()
                if (r5 != r6) goto L3f
                goto L40
            L3f:
                r2 = 0
            L40:
                return r2
            L41:
                androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r5 = r4.this$0
                com.google.android.material.sidesheet.SideSheetBehavior r5 = (com.google.android.material.sidesheet.SideSheetBehavior) r5
                int r0 = r5.state
                r1 = 0
                r2 = 1
                if (r0 != r2) goto L4c
                goto L57
            L4c:
                java.lang.ref.WeakReference r5 = r5.viewRef
                if (r5 == 0) goto L57
                java.lang.Object r5 = r5.get()
                if (r5 != r6) goto L57
                r1 = 1
            L57:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.AnonymousClass1.tryCaptureView(int, android.view.View):boolean");
        }
    }

    public SideSheetBehavior() {
        this.stateSettlingTracker = new StateSettlingTracker(this);
        this.draggable = true;
        this.state = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new AnonymousClass1(this, 0);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void cancelBackProgress() {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper != null) {
            materialSideContainerBackHelper.cancelBackProgress();
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void handleBackInvoked() {
        final View view;
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper != null) {
            BackEventCompat backEventCompat = materialSideContainerBackHelper.backEvent;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
            materialSideContainerBackHelper.backEvent = null;
            int i = 5;
            if (backEventCompat == null || Build.VERSION.SDK_INT < 34) {
                setState(5);
                return;
            }
            LazyKt__LazyJVMKt lazyKt__LazyJVMKt = this.sheetDelegate;
            if (!(lazyKt__LazyJVMKt == null || lazyKt__LazyJVMKt.getSheetEdge() == 0)) {
                i = 3;
            }
            Transition.AnonymousClass3 r4 = new Transition.AnonymousClass3(8, this);
            WeakReference weakReference = this.coplanarSiblingViewRef;
            if (weakReference != null) {
                view = (View) weakReference.get();
            } else {
                view = null;
            }
            if (!(view == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) == null)) {
                final int coplanarSiblingAdjacentMargin = this.sheetDelegate.getCoplanarSiblingAdjacentMargin(marginLayoutParams);
                animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.sidesheet.SideSheetBehavior$$ExternalSyntheticLambda2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        SideSheetBehavior.this.sheetDelegate.updateCoplanarSiblingAdjacentMargin(marginLayoutParams, AnimationUtils.lerp(coplanarSiblingAdjacentMargin, valueAnimator.getAnimatedFraction(), 0));
                        view.requestLayout();
                    }
                };
            }
            materialSideContainerBackHelper.finishBackProgress(backEventCompat, i, r4, animatorUpdateListener);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onDetachedFromLayoutParams() {
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        VelocityTracker velocityTracker;
        if ((view.isShown() || ViewCompat.getAccessibilityPaneTitle(view) != null) && this.draggable) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0 && (velocityTracker = this.velocityTracker) != null) {
                velocityTracker.recycle();
                this.velocityTracker = null;
            }
            if (this.velocityTracker == null) {
                this.velocityTracker = VelocityTracker.obtain();
            }
            this.velocityTracker.addMovement(motionEvent);
            if (actionMasked == 0) {
                this.initialX = (int) motionEvent.getX();
            } else if ((actionMasked == 1 || actionMasked == 3) && this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
            if (this.ignoreEvents || (viewDragHelper = this.viewDragHelper) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        this.ignoreEvents = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i2;
        int i3;
        int i4;
        View findViewById;
        View view2;
        View view3;
        int i5;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        int i6 = 0;
        if (this.viewRef == null) {
            this.viewRef = new WeakReference(view);
            this.sideContainerBackHelper = new MaterialSideContainerBackHelper(view);
            MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
            if (materialShapeDrawable != null) {
                view.setBackground(materialShapeDrawable);
                float f = this.elevation;
                if (f == -1.0f) {
                    f = view.getElevation();
                }
                this.materialShapeDrawable.setElevation(f);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    ViewCompat.setBackgroundTintList(view, colorStateList);
                }
            }
            if (this.state == 5) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            if (view.getVisibility() != i5) {
                view.setVisibility(i5);
            }
            updateAccessibilityActions$1();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (ViewCompat.getAccessibilityPaneTitle(view) == null) {
                ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        if (Gravity.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) view.getLayoutParams()).gravity, i) == 3) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        LazyKt__LazyJVMKt lazyKt__LazyJVMKt = this.sheetDelegate;
        if (lazyKt__LazyJVMKt == null || lazyKt__LazyJVMKt.getSheetEdge() != i2) {
            CoordinatorLayout.LayoutParams layoutParams = null;
            ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModel;
            if (i2 == 0) {
                this.sheetDelegate = new LeftSheetDelegate(this, 1);
                if (shapeAppearanceModel != null) {
                    WeakReference weakReference = this.viewRef;
                    if (!(weakReference == null || (view3 = (View) weakReference.get()) == null || !(view3.getLayoutParams() instanceof CoordinatorLayout.LayoutParams))) {
                        layoutParams = (CoordinatorLayout.LayoutParams) view3.getLayoutParams();
                    }
                    if (layoutParams == null || ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin <= 0) {
                        ShapeAppearanceModel.Builder builder = shapeAppearanceModel.toBuilder();
                        builder.topRightCornerSize = new AbsoluteCornerSize(0.0f);
                        builder.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
                        ShapeAppearanceModel build = builder.build();
                        MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
                        if (materialShapeDrawable2 != null) {
                            materialShapeDrawable2.setShapeAppearanceModel(build);
                        }
                    }
                }
            } else if (i2 == 1) {
                this.sheetDelegate = new LeftSheetDelegate(this, 0);
                if (shapeAppearanceModel != null) {
                    WeakReference weakReference2 = this.viewRef;
                    if (!(weakReference2 == null || (view2 = (View) weakReference2.get()) == null || !(view2.getLayoutParams() instanceof CoordinatorLayout.LayoutParams))) {
                        layoutParams = (CoordinatorLayout.LayoutParams) view2.getLayoutParams();
                    }
                    if (layoutParams == null || ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin <= 0) {
                        ShapeAppearanceModel.Builder builder2 = shapeAppearanceModel.toBuilder();
                        builder2.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
                        builder2.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
                        ShapeAppearanceModel build2 = builder2.build();
                        MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
                        if (materialShapeDrawable3 != null) {
                            materialShapeDrawable3.setShapeAppearanceModel(build2);
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("Invalid sheet edge position value: " + i2 + ". Must be 0 or 1.");
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.dragCallback);
        }
        int outerEdge = this.sheetDelegate.getOuterEdge(view);
        coordinatorLayout.onLayoutChild(i, view);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentInnerEdge = this.sheetDelegate.getParentInnerEdge(coordinatorLayout);
        this.childWidth = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams != null) {
            i3 = this.sheetDelegate.calculateInnerMargin(marginLayoutParams);
        } else {
            i3 = 0;
        }
        this.innerMargin = i3;
        int i7 = this.state;
        if (i7 == 1 || i7 == 2) {
            i6 = outerEdge - this.sheetDelegate.getOuterEdge(view);
        } else if (i7 != 3) {
            if (i7 == 5) {
                i6 = this.sheetDelegate.getHiddenOffset();
            } else {
                throw new IllegalStateException("Unexpected value: " + this.state);
            }
        }
        ViewCompat.offsetLeftAndRight(i6, view);
        if (!(this.coplanarSiblingViewRef != null || (i4 = this.coplanarSiblingViewId) == -1 || (findViewById = coordinatorLayout.findViewById(i4)) == null)) {
            this.coplanarSiblingViewRef = new WeakReference(findViewById);
        }
        for (Object obj : this.callbacks) {
            if (obj != null) {
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onRestoreInstanceState(View view, Parcelable parcelable) {
        int i = ((SavedState) parcelable).state;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.state = i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new SavedState(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper$1()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.velocityTracker) != null) {
            velocityTracker.recycle();
            this.velocityTracker = null;
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper$1() && actionMasked == 2 && !this.ignoreEvents && shouldHandleDraggingWithHelper$1()) {
            float abs = Math.abs(this.initialX - motionEvent.getX());
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            if (abs > viewDragHelper.mTouchSlop) {
                viewDragHelper.captureChildView(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.ignoreEvents;
    }

    public final void setState(int i) {
        String str;
        if (i == 1 || i == 2) {
            StringBuilder sb = new StringBuilder("STATE_");
            if (i == 1) {
                str = "DRAGGING";
            } else {
                str = "SETTLING";
            }
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(sb, str, " should not be set externally."));
        }
        WeakReference weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            setStateInternal(i);
            return;
        }
        View view = (View) this.viewRef.get();
        ResourcesCompat$FontCallback$$ExternalSyntheticLambda1 resourcesCompat$FontCallback$$ExternalSyntheticLambda1 = new ResourcesCompat$FontCallback$$ExternalSyntheticLambda1(i, 2, this);
        ViewParent parent = view.getParent();
        if (parent == null || !parent.isLayoutRequested() || !view.isAttachedToWindow()) {
            resourcesCompat$FontCallback$$ExternalSyntheticLambda1.run();
        } else {
            view.post(resourcesCompat$FontCallback$$ExternalSyntheticLambda1);
        }
    }

    public final void setStateInternal(int i) {
        View view;
        int i2;
        if (this.state != i) {
            this.state = i;
            WeakReference weakReference = this.viewRef;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (this.state == 5) {
                    i2 = 4;
                } else {
                    i2 = 0;
                }
                if (view.getVisibility() != i2) {
                    view.setVisibility(i2);
                }
                Iterator it = this.callbacks.iterator();
                if (!it.hasNext()) {
                    updateAccessibilityActions$1();
                    return;
                }
                throw ViewModelProvider.Factory.CC.m(it);
            }
        }
    }

    public final boolean shouldHandleDraggingWithHelper$1() {
        if (this.viewDragHelper == null) {
            return false;
        }
        if (this.draggable || this.state == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void startBackProgress(BackEventCompat backEventCompat) {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper != null) {
            materialSideContainerBackHelper.backEvent = backEventCompat;
        }
    }

    public final void startSettling$1(View view, int i, boolean z) {
        int i2;
        if (i == 3) {
            i2 = this.sheetDelegate.getExpandedOffset();
        } else if (i == 5) {
            i2 = this.sheetDelegate.getHiddenOffset();
        } else {
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(i, "Invalid state to get outer edge offset: "));
        }
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper == null || (!z ? !viewDragHelper.smoothSlideViewTo(view, i2, view.getTop()) : !viewDragHelper.settleCapturedViewAt(i2, view.getTop()))) {
            setStateInternal(i);
            return;
        }
        setStateInternal(2);
        this.stateSettlingTracker.continueSettlingToState(i);
    }

    public final void updateAccessibilityActions$1() {
        View view;
        WeakReference weakReference = this.viewRef;
        if (weakReference != null && (view = (View) weakReference.get()) != null) {
            ViewCompat.removeActionWithId(262144, view);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, view);
            ViewCompat.removeActionWithId(1048576, view);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(0, view);
            if (this.state != 5) {
                ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.SideSheetBehavior$$ExternalSyntheticLambda1
                    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                    public final boolean perform(View view2) {
                        SideSheetBehavior.this.setState(r2);
                        return true;
                    }
                });
            }
            if (this.state != 3) {
                ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, new AccessibilityViewCommand() { // from class: com.google.android.material.sidesheet.SideSheetBehavior$$ExternalSyntheticLambda1
                    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                    public final boolean perform(View view2) {
                        SideSheetBehavior.this.setState(r2);
                        return true;
                    }
                });
            }
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void updateBackProgress(BackEventCompat backEventCompat) {
        int i;
        View view;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        boolean z;
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.sideContainerBackHelper;
        if (materialSideContainerBackHelper != null) {
            LazyKt__LazyJVMKt lazyKt__LazyJVMKt = this.sheetDelegate;
            if (lazyKt__LazyJVMKt == null || lazyKt__LazyJVMKt.getSheetEdge() == 0) {
                i = 5;
            } else {
                i = 3;
            }
            if (materialSideContainerBackHelper.backEvent == null) {
                Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
            }
            BackEventCompat backEventCompat2 = materialSideContainerBackHelper.backEvent;
            materialSideContainerBackHelper.backEvent = backEventCompat;
            if (backEventCompat2 != null) {
                if (backEventCompat.swipeEdge == 0) {
                    z = true;
                } else {
                    z = false;
                }
                materialSideContainerBackHelper.updateBackProgress(backEventCompat.progress, z, i);
            }
            WeakReference weakReference = this.viewRef;
            if (weakReference != null && weakReference.get() != null) {
                View view2 = (View) this.viewRef.get();
                WeakReference weakReference2 = this.coplanarSiblingViewRef;
                if (weakReference2 != null) {
                    view = (View) weakReference2.get();
                } else {
                    view = null;
                }
                if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
                    this.sheetDelegate.updateCoplanarSiblingAdjacentMargin(marginLayoutParams, (int) ((view2.getScaleX() * this.childWidth) + this.innerMargin));
                    view.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public final class SavedState extends androidx.customview.view.AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.AnonymousClass2(14);
        public final int state;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }

        public SavedState(SideSheetBehavior sideSheetBehavior) {
            super(android.view.AbsSavedState.EMPTY_STATE);
            this.state = sideSheetBehavior.state;
        }
    }

    /* loaded from: classes.dex */
    public final class StateSettlingTracker {
        public final /* synthetic */ int $r8$classId;
        public final Runnable continueSettlingRunnable;
        public boolean isContinueSettlingRunnablePosted;
        public int targetState;
        public final /* synthetic */ CoordinatorLayout.Behavior this$0;

        public StateSettlingTracker(SideSheetBehavior sideSheetBehavior) {
            this.$r8$classId = 0;
            this.this$0 = sideSheetBehavior;
            this.continueSettlingRunnable = new ActivityCompat$$ExternalSyntheticLambda0(20, this);
        }

        public final void continueSettlingToState(int i) {
            switch (this.$r8$classId) {
                case 0:
                    SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.this$0;
                    WeakReference weakReference = sideSheetBehavior.viewRef;
                    if (weakReference != null && weakReference.get() != null) {
                        this.targetState = i;
                        if (!this.isContinueSettlingRunnablePosted) {
                            ((View) sideSheetBehavior.viewRef.get()).postOnAnimation((ActivityCompat$$ExternalSyntheticLambda0) this.continueSettlingRunnable);
                            this.isContinueSettlingRunnablePosted = true;
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.this$0;
                    WeakReference weakReference2 = bottomSheetBehavior.viewRef;
                    if (weakReference2 != null && weakReference2.get() != null) {
                        this.targetState = i;
                        if (!this.isContinueSettlingRunnablePosted) {
                            ((View) bottomSheetBehavior.viewRef.get()).postOnAnimation((zzab) this.continueSettlingRunnable);
                            this.isContinueSettlingRunnablePosted = true;
                            return;
                        }
                        return;
                    }
                    return;
            }
        }

        public StateSettlingTracker(BottomSheetBehavior bottomSheetBehavior) {
            this.$r8$classId = 1;
            this.this$0 = bottomSheetBehavior;
            this.continueSettlingRunnable = new zzab(14, this);
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.stateSettlingTracker = new StateSettlingTracker(this);
        this.draggable = true;
        this.state = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new AnonymousClass1(this, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SideSheetBehavior_Layout);
        if (obtainStyledAttributes.hasValue(3)) {
            this.backgroundTint = LazyKt__LazyJVMKt.getColorStateList(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.shapeAppearanceModel = ShapeAppearanceModel.builder(context, attributeSet, 0, (int) R.style.Widget_Material3_SideSheet).build();
        }
        if (obtainStyledAttributes.hasValue(5)) {
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            this.coplanarSiblingViewId = resourceId;
            WeakReference weakReference = this.coplanarSiblingViewRef;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.coplanarSiblingViewRef = null;
            WeakReference weakReference2 = this.viewRef;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        ShapeAppearanceModel shapeAppearanceModel = this.shapeAppearanceModel;
        if (shapeAppearanceModel != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
            this.materialShapeDrawable = materialShapeDrawable;
            materialShapeDrawable.initializeElevationOverlay(context);
            ColorStateList colorStateList = this.backgroundTint;
            if (colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.materialShapeDrawable.setTint(typedValue.data);
            }
        }
        this.elevation = obtainStyledAttributes.getDimension(2, -1.0f);
        this.draggable = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
