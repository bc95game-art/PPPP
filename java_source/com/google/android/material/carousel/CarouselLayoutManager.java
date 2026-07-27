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
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.graphics.ColorUtils;
import androidx.dynamicanimation.animation.DynamicAnimation$MassState;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.R$styleable;
import java.util.ArrayList;
import java.util.List;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public final DynamicAnimation$MassState carouselStrategy;
    public CarouselOrientationHelper$1 orientationHelper;
    public final View.OnLayoutChangeListener recyclerViewSizeChangeListener;

    /* renamed from: com.google.android.material.carousel.CarouselLayoutManager$1 */
    /* loaded from: classes.dex */
    public final class C01721 extends LinearSmoothScroller {
        public final /* synthetic */ int $r8$classId = 1;

        public /* synthetic */ C01721(Context context) {
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

        public C01721(CarouselLayoutManager carouselLayoutManager, Context context) {
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
            float dimension = recyclerView.getResources().getDimension(C0130R.dimen.m3_carousel_debug_keyline_width);
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
            f = context.getResources().getDimension(C0130R.dimen.m3_carousel_small_item_size_min);
        }
        dynamicAnimation$MassState.mValue = f;
        float f2 = dynamicAnimation$MassState.mVelocity;
        if (f2 <= 0.0f) {
            f2 = context.getResources().getDimension(C0130R.dimen.m3_carousel_small_item_size_max);
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
    */
    public final View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        char c;
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = this.orientationHelper.orientation;
        if (i != 1) {
            if (i != 2) {
                if (i == 17) {
                    if (i2 == 0) {
                    }
                    c = 0;
                } else if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            Log.d("CarouselLayoutManager", "Unknown focus request:" + i);
                        }
                        c = 0;
                    } else {
                        if (i2 == 0) {
                        }
                        c = 0;
                    }
                }
                if (c == 0) {
                    return null;
                }
                int i3 = 0;
                if (c == 65535) {
                    if (getPosition(view) == 0) {
                        return null;
                    }
                    int position = getPosition(getChildAt(0)) - 1;
                    if (position < 0 || position >= getItemCount()) {
                        if (isLayoutRtl()) {
                            i3 = getChildCount() - 1;
                        }
                        return getChildAt(i3);
                    }
                    this.orientationHelper.getParentStart();
                    throw null;
                } else if (getPosition(view) == getItemCount() - 1) {
                    return null;
                } else {
                    int position2 = getPosition(getChildAt(getChildCount() - 1)) + 1;
                    if (position2 < 0 || position2 >= getItemCount()) {
                        if (!isLayoutRtl()) {
                            i3 = getChildCount() - 1;
                        }
                        return getChildAt(i3);
                    }
                    this.orientationHelper.getParentStart();
                    throw null;
                }
            }
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
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
        throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(i, "invalid orientation:"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        C01721 r2 = new C01721(this, recyclerView.getContext());
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
