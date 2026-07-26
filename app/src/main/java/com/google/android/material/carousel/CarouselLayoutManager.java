package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.graphics.ColorUtils;
import androidx.dynamicanimation.animation.DynamicAnimation$MassState;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.R;
import com.google.android.material.R$styleable;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public final DynamicAnimation$MassState carouselStrategy;
    public CarouselOrientationHelper$1 orientationHelper;
    public final View.OnLayoutChangeListener recyclerViewSizeChangeListener;

    /* renamed from: com.google.android.material.carousel.CarouselLayoutManager$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends LinearSmoothScroller {
        public final /* synthetic */ int $r8$classId = 1;

        public /* synthetic */ AnonymousClass1(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDxToMakeVisible(View view, int i) {
            switch (this.$r8$classId) {
                case 0:
                    return 0;
                default:
                    return super.calculateDxToMakeVisible(view, i);
            }
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDyToMakeVisible(View view, int i) {
            switch (this.$r8$classId) {
                case 0:
                    return 0;
                default:
                    return super.calculateDyToMakeVisible(view, i);
            }
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            switch (this.$r8$classId) {
                case 1:
                    return 100.0f / displayMetrics.densityDpi;
                default:
                    return super.calculateSpeedPerPixel(displayMetrics);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public PointF computeScrollVectorForPosition(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return null;
                default:
                    return super.computeScrollVectorForPosition(i);
            }
        }

        public AnonymousClass1(CarouselLayoutManager carouselLayoutManager, Context context) {
            super(context);
        }
    }

    /* loaded from: classes.dex */
    public final class DebugItemDecoration extends RecyclerView.ItemDecoration {
        public final List keylines = DesugarCollections.unmodifiableList(new ArrayList());
        public final Paint linePaint;

        public DebugItemDecoration() {
            Paint paint = new Paint();
            this.linePaint = paint;
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
            Canvas canvas2;
            int i;
            int i2;
            float dimension = recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width);
            Paint paint = this.linePaint;
            paint.setStrokeWidth(dimension);
            for (KeylineState$Keyline keylineState$Keyline : this.keylines) {
                keylineState$Keyline.getClass();
                ThreadLocal threadLocal = ColorUtils.TEMP_ARRAY;
                float f = 1.0f - 0.0f;
                paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f))));
                int i3 = 0;
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).isHorizontal()) {
                    CarouselOrientationHelper$1 carouselOrientationHelper$1 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).orientationHelper;
                    switch (carouselOrientationHelper$1.$r8$classId) {
                        case 0:
                            break;
                        default:
                            i3 = carouselOrientationHelper$1.val$carouselLayoutManager.getPaddingTop();
                            break;
                    }
                    float f2 = i3;
                    CarouselOrientationHelper$1 carouselOrientationHelper$12 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).orientationHelper;
                    switch (carouselOrientationHelper$12.$r8$classId) {
                        case 0:
                            i2 = carouselOrientationHelper$12.val$carouselLayoutManager.getHeight();
                            break;
                        default:
                            CarouselLayoutManager carouselLayoutManager = carouselOrientationHelper$12.val$carouselLayoutManager;
                            i2 = carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
                            break;
                    }
                    canvas2 = canvas;
                    canvas2.drawLine(0.0f, f2, 0.0f, i2, paint);
                } else {
                    canvas2 = canvas;
                    CarouselOrientationHelper$1 carouselOrientationHelper$13 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).orientationHelper;
                    switch (carouselOrientationHelper$13.$r8$classId) {
                        case 0:
                            i3 = carouselOrientationHelper$13.val$carouselLayoutManager.getPaddingLeft();
                            break;
                    }
                    float f3 = i3;
                    CarouselOrientationHelper$1 carouselOrientationHelper$14 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).orientationHelper;
                    switch (carouselOrientationHelper$14.$r8$classId) {
                        case 0:
                            CarouselLayoutManager carouselLayoutManager2 = carouselOrientationHelper$14.val$carouselLayoutManager;
                            i = carouselLayoutManager2.getWidth() - carouselLayoutManager2.getPaddingRight();
                            break;
                        default:
                            i = carouselOrientationHelper$14.val$carouselLayoutManager.getWidth();
                            break;
                    }
                    canvas2.drawLine(f3, 0.0f, i, 0.0f, paint);
                }
                canvas = canvas2;
            }
        }
    }

    public CarouselLayoutManager() {
        DynamicAnimation$MassState dynamicAnimation$MassState = new DynamicAnimation$MassState();
        new DebugItemDecoration();
        this.recyclerViewSizeChangeListener = new View.OnLayoutChangeListener() { // from class: com.google.android.material.carousel.CarouselLayoutManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (i3 - i != i7 - i5 || i4 - i2 != i8 - i6) {
                    view.post(new ActivityCompat$$ExternalSyntheticLambda0(17, CarouselLayoutManager.this));
                }
            }
        };
        this.carouselStrategy = dynamicAnimation$MassState;
        requestLayout();
        setOrientation(0);
    }

    public final float addEnd(float f, float f2) {
        if (isLayoutRtl()) {
            return f - f2;
        }
        return f + f2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        return isHorizontal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return !isHorizontal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollExtent(RecyclerView.State state) {
        getChildCount();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollRange(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF computeScrollVectorForPosition(int i) {
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollExtent(RecyclerView.State state) {
        getChildCount();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollRange(RecyclerView.State state) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        rect.centerY();
        if (isHorizontal()) {
            rect.centerX();
        }
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        return true;
    }

    public final boolean isHorizontal() {
        if (this.orientationHelper.orientation == 0) {
            return true;
        }
        return false;
    }

    public final boolean isLayoutRtl() {
        if (!isHorizontal() || getLayoutDirection() != 1) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void measureChildWithMargins(View view, int i, int i2) {
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        Context context = recyclerView.getContext();
        DynamicAnimation$MassState dynamicAnimation$MassState = this.carouselStrategy;
        float f = dynamicAnimation$MassState.mValue;
        if (f <= 0.0f) {
            f = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        dynamicAnimation$MassState.mValue = f;
        float f2 = dynamicAnimation$MassState.mVelocity;
        if (f2 <= 0.0f) {
            f2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        dynamicAnimation$MassState.mVelocity = f2;
        requestLayout();
        recyclerView.addOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        onDetachedFromWindow(recyclerView);
        recyclerView.removeOnLayoutChangeListener(this.recyclerViewSizeChangeListener);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003b, code lost:
        if (r6 == 1) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
        if (isLayoutRtl() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0049, code lost:
        if (r6 == 1) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
        if (isLayoutRtl() != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onFocusSearchFailed(android.view.View r4, int r5, androidx.recyclerview.widget.RecyclerView.Recycler r6, androidx.recyclerview.widget.RecyclerView.State r7) {
        /*
            r3 = this;
            int r6 = r3.getChildCount()
            if (r6 != 0) goto L8
            goto L97
        L8:
            com.google.android.material.carousel.CarouselOrientationHelper$1 r6 = r3.orientationHelper
            int r6 = r6.orientation
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = -1
            r1 = 1
            if (r5 == r1) goto L47
            r2 = 2
            if (r5 == r2) goto L3d
            r2 = 17
            if (r5 == r2) goto L4c
            r2 = 33
            if (r5 == r2) goto L49
            r2 = 66
            if (r5 == r2) goto L3f
            r2 = 130(0x82, float:1.82E-43)
            if (r5 == r2) goto L3b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r2 = "Unknown focus request:"
            r6.<init>(r2)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "CarouselLayoutManager"
            android.util.Log.d(r6, r5)
        L38:
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L55
        L3b:
            if (r6 != r1) goto L38
        L3d:
            r5 = 1
            goto L55
        L3f:
            if (r6 != 0) goto L38
            boolean r5 = r3.isLayoutRtl()
            if (r5 == 0) goto L3d
        L47:
            r5 = -1
            goto L55
        L49:
            if (r6 != r1) goto L38
            goto L47
        L4c:
            if (r6 != 0) goto L38
            boolean r5 = r3.isLayoutRtl()
            if (r5 == 0) goto L47
            goto L3d
        L55:
            if (r5 != r7) goto L58
            goto L97
        L58:
            r6 = 0
            if (r5 != r0) goto L8c
            int r4 = r3.getPosition(r4)
            if (r4 != 0) goto L62
            goto L97
        L62:
            android.view.View r4 = r3.getChildAt(r6)
            int r4 = r3.getPosition(r4)
            int r4 = r4 - r1
            if (r4 < 0) goto L7b
            int r5 = r3.getItemCount()
            if (r4 < r5) goto L74
            goto L7b
        L74:
            com.google.android.material.carousel.CarouselOrientationHelper$1 r4 = r3.orientationHelper
            r4.getParentStart()
            r4 = 0
            throw r4
        L7b:
            boolean r4 = r3.isLayoutRtl()
            if (r4 == 0) goto L87
            int r4 = r3.getChildCount()
            int r6 = r4 + (-1)
        L87:
            android.view.View r4 = r3.getChildAt(r6)
            return r4
        L8c:
            int r4 = r3.getPosition(r4)
            int r5 = r3.getItemCount()
            int r5 = r5 - r1
            if (r4 != r5) goto L99
        L97:
            r4 = 0
            return r4
        L99:
            int r4 = r3.getChildCount()
            int r4 = r4 - r1
            android.view.View r4 = r3.getChildAt(r4)
            int r4 = r3.getPosition(r4)
            int r4 = r4 + r1
            if (r4 < 0) goto Lb7
            int r5 = r3.getItemCount()
            if (r4 < r5) goto Lb0
            goto Lb7
        Lb0:
            com.google.android.material.carousel.CarouselOrientationHelper$1 r4 = r3.orientationHelper
            r4.getParentStart()
            r4 = 0
            throw r4
        Lb7:
            boolean r4 = r3.isLayoutRtl()
            if (r4 == 0) goto Lbe
            goto Lc4
        Lbe:
            int r4 = r3.getChildCount()
            int r6 = r4 + (-1)
        Lc4:
            android.view.View r4 = r3.getChildAt(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView recyclerView) {
        super.onItemsChanged(recyclerView);
        getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        if (state.getItemCount() > 0) {
            if (isHorizontal()) {
                i = getWidth();
            } else {
                i = getHeight();
            }
            if (i > 0.0f) {
                isLayoutRtl();
                measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
                throw null;
            }
        }
        removeAndRecycleAllViews(recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State state) {
        if (getChildCount() != 0) {
            getPosition(getChildAt(0));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isHorizontal() || getChildCount() == 0 || i == 0) {
            return 0;
        }
        measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!canScrollVertically() || getChildCount() == 0 || i == 0) {
            return 0;
        }
        measureChildWithMargins(recycler.getViewForPosition(0), 0, 0);
        throw null;
    }

    public final void setOrientation(int i) {
        CarouselOrientationHelper$1 carouselOrientationHelper$1;
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll(null);
            CarouselOrientationHelper$1 carouselOrientationHelper$12 = this.orientationHelper;
            if (carouselOrientationHelper$12 == null || i != carouselOrientationHelper$12.orientation) {
                if (i == 0) {
                    carouselOrientationHelper$1 = new CarouselOrientationHelper$1(this, 1);
                } else if (i == 1) {
                    carouselOrientationHelper$1 = new CarouselOrientationHelper$1(this, 0);
                } else {
                    throw new IllegalArgumentException("invalid orientation");
                }
                this.orientationHelper = carouselOrientationHelper$1;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(i, "invalid orientation:"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        AnonymousClass1 r2 = new AnonymousClass1(this, recyclerView.getContext());
        r2.mTargetPosition = i;
        startSmoothScroll(r2);
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        new DebugItemDecoration();
        this.recyclerViewSizeChangeListener = new View.OnLayoutChangeListener() { // from class: com.google.android.material.carousel.CarouselLayoutManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i22, int i32, int i4, int i5, int i6, int i7, int i8) {
                if (i32 - i3 != i7 - i5 || i4 - i22 != i8 - i6) {
                    view.post(new ActivityCompat$$ExternalSyntheticLambda0(17, CarouselLayoutManager.this));
                }
            }
        };
        this.carouselStrategy = new DynamicAnimation$MassState();
        requestLayout();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            obtainStyledAttributes.getInt(0, 0);
            requestLayout();
            setOrientation(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
        }
    }
}
