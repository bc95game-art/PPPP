package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
/* loaded from: classes.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    public int mAdapterState;
    public CompositeOnPageChangeCallback mCallback;
    public boolean mDataSetChangeHappened;
    public boolean mDispatchSelected;
    public int mDragStartPosition;
    public final LinearLayoutManager mLayoutManager;
    public final ViewPager2.RecyclerViewImpl mRecyclerView;
    public boolean mScrollHappened;
    public int mScrollState;
    public final ScrollEventValues mScrollValues = new Object();
    public int mTarget;
    public final ViewPager2 mViewPager;

    /* loaded from: classes.dex */
    public final class ScrollEventValues {
        public float mOffset;
        public int mOffsetPx;
        public int mPosition;
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues] */
    public ScrollEventAdapter(ViewPager2 viewPager2) {
        this.mViewPager = viewPager2;
        ViewPager2.RecyclerViewImpl recyclerViewImpl = viewPager2.mRecyclerView;
        this.mRecyclerView = recyclerViewImpl;
        this.mLayoutManager = (LinearLayoutManager) recyclerViewImpl.getLayoutManager();
        resetState();
    }

    public final void dispatchStateChanged(int i) {
        if ((this.mAdapterState != 3 || this.mScrollState != 0) && this.mScrollState != i) {
            this.mScrollState = i;
            CompositeOnPageChangeCallback compositeOnPageChangeCallback = this.mCallback;
            if (compositeOnPageChangeCallback != null) {
                compositeOnPageChangeCallback.onPageScrollStateChanged(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        CompositeOnPageChangeCallback compositeOnPageChangeCallback;
        CompositeOnPageChangeCallback compositeOnPageChangeCallback2;
        int i2 = this.mAdapterState;
        if (!(i2 == 1 && this.mScrollState == 1) && i == 1) {
            this.mAdapterState = 1;
            int i3 = this.mTarget;
            if (i3 != -1) {
                this.mDragStartPosition = i3;
                this.mTarget = -1;
            } else if (this.mDragStartPosition == -1) {
                this.mDragStartPosition = this.mLayoutManager.findFirstVisibleItemPosition();
            }
            dispatchStateChanged(1);
        } else if ((i2 != 1 && i2 != 4) || i != 2) {
            ScrollEventValues scrollEventValues = this.mScrollValues;
            if ((i2 == 1 || i2 == 4) && i == 0) {
                updateScrollEventValues();
                if (!this.mScrollHappened) {
                    int i4 = scrollEventValues.mPosition;
                    if (!(i4 == -1 || (compositeOnPageChangeCallback2 = this.mCallback) == null)) {
                        compositeOnPageChangeCallback2.onPageScrolled(i4, 0.0f, 0);
                    }
                } else if (scrollEventValues.mOffsetPx == 0) {
                    int i5 = this.mDragStartPosition;
                    int i6 = scrollEventValues.mPosition;
                    if (!(i5 == i6 || (compositeOnPageChangeCallback = this.mCallback) == null)) {
                        compositeOnPageChangeCallback.onPageSelected(i6);
                    }
                }
                dispatchStateChanged(0);
                resetState();
            }
            if (this.mAdapterState == 2 && i == 0 && this.mDataSetChangeHappened) {
                updateScrollEventValues();
                if (scrollEventValues.mOffsetPx == 0) {
                    int i7 = this.mTarget;
                    int i8 = scrollEventValues.mPosition;
                    if (i7 != i8) {
                        if (i8 == -1) {
                            i8 = 0;
                        }
                        CompositeOnPageChangeCallback compositeOnPageChangeCallback3 = this.mCallback;
                        if (compositeOnPageChangeCallback3 != null) {
                            compositeOnPageChangeCallback3.onPageSelected(i8);
                        }
                    }
                    dispatchStateChanged(0);
                    resetState();
                }
            }
        } else if (this.mScrollHappened) {
            dispatchStateChanged(2);
            this.mDispatchSelected = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r7 == r8) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int i3;
        CompositeOnPageChangeCallback compositeOnPageChangeCallback;
        boolean z;
        boolean z2;
        this.mScrollHappened = true;
        updateScrollEventValues();
        boolean z3 = this.mDispatchSelected;
        ScrollEventValues scrollEventValues = this.mScrollValues;
        if (z3) {
            this.mDispatchSelected = false;
            if (i2 <= 0) {
                if (i2 == 0) {
                    if (i < 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.mViewPager.mLayoutManager.getLayoutDirection() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                i3 = scrollEventValues.mPosition;
                this.mTarget = i3;
                if (!(this.mDragStartPosition == i3 || (compositeOnPageChangeCallback = this.mCallback) == null)) {
                    compositeOnPageChangeCallback.onPageSelected(i3);
                }
            }
            if (scrollEventValues.mOffsetPx != 0) {
                i3 = scrollEventValues.mPosition + 1;
                this.mTarget = i3;
                if (this.mDragStartPosition == i3) {
                    compositeOnPageChangeCallback.onPageSelected(i3);
                }
            }
            i3 = scrollEventValues.mPosition;
            this.mTarget = i3;
            if (this.mDragStartPosition == i3) {
            }
        } else if (this.mAdapterState == 0) {
            int i4 = scrollEventValues.mPosition;
            if (i4 == -1) {
                i4 = 0;
            }
            CompositeOnPageChangeCallback compositeOnPageChangeCallback2 = this.mCallback;
            if (compositeOnPageChangeCallback2 != null) {
                compositeOnPageChangeCallback2.onPageSelected(i4);
            }
        }
        int i5 = scrollEventValues.mPosition;
        if (i5 == -1) {
            i5 = 0;
        }
        float f = scrollEventValues.mOffset;
        int i6 = scrollEventValues.mOffsetPx;
        CompositeOnPageChangeCallback compositeOnPageChangeCallback3 = this.mCallback;
        if (compositeOnPageChangeCallback3 != null) {
            compositeOnPageChangeCallback3.onPageScrolled(i5, f, i6);
        }
        int i7 = scrollEventValues.mPosition;
        int i8 = this.mTarget;
        if ((i7 == i8 || i8 == -1) && scrollEventValues.mOffsetPx == 0 && this.mScrollState != 1) {
            dispatchStateChanged(0);
            resetState();
        }
    }

    public final void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        ScrollEventValues scrollEventValues = this.mScrollValues;
        scrollEventValues.mPosition = -1;
        scrollEventValues.mOffset = 0.0f;
        scrollEventValues.mOffsetPx = 0;
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mDataSetChangeHappened = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x011b, code lost:
        if (r5[r1 - 1][1] >= r6) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0122, code lost:
        if (r0.getChildCount() <= 1) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateScrollEventValues() {
        int i;
        boolean z;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int top;
        int i2;
        int bottom;
        int i3;
        LinearLayoutManager linearLayoutManager = this.mLayoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        ScrollEventValues scrollEventValues = this.mScrollValues;
        scrollEventValues.mPosition = findFirstVisibleItemPosition;
        float f = 0.0f;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.mPosition = -1;
            scrollEventValues.mOffset = 0.0f;
            scrollEventValues.mOffsetPx = 0;
            return;
        }
        View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.mPosition = -1;
            scrollEventValues.mOffset = 0.0f;
            scrollEventValues.mOffsetPx = 0;
            return;
        }
        int leftDecorationWidth = linearLayoutManager.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = linearLayoutManager.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = linearLayoutManager.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = linearLayoutManager.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams2.leftMargin;
            rightDecorationWidth += marginLayoutParams2.rightMargin;
            topDecorationHeight += marginLayoutParams2.topMargin;
            bottomDecorationHeight += marginLayoutParams2.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        int orientation = linearLayoutManager.getOrientation();
        ViewPager2.RecyclerViewImpl recyclerViewImpl = this.mRecyclerView;
        if (orientation == 0) {
            i = (findViewByPosition.getLeft() - leftDecorationWidth) - recyclerViewImpl.getPaddingLeft();
            if (this.mViewPager.mLayoutManager.getLayoutDirection() == 1) {
                i = -i;
            }
            height = width;
        } else {
            i = (findViewByPosition.getTop() - topDecorationHeight) - recyclerViewImpl.getPaddingTop();
        }
        int i4 = -i;
        scrollEventValues.mOffsetPx = i4;
        if (i4 < 0) {
            int childCount = linearLayoutManager.getChildCount();
            if (childCount != 0) {
                if (linearLayoutManager.getOrientation() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, childCount, 2);
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = linearLayoutManager.getChildAt(i5);
                    if (childAt != null) {
                        ViewGroup.LayoutParams layoutParams2 = childAt.getLayoutParams();
                        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                        } else {
                            marginLayoutParams = AnimateLayoutChangeDetector.ZERO_MARGIN_LAYOUT_PARAMS;
                        }
                        int[] iArr2 = iArr[i5];
                        if (z) {
                            top = childAt.getLeft();
                            i2 = marginLayoutParams.leftMargin;
                        } else {
                            top = childAt.getTop();
                            i2 = marginLayoutParams.topMargin;
                        }
                        iArr2[0] = top - i2;
                        int[] iArr3 = iArr[i5];
                        if (z) {
                            bottom = childAt.getRight();
                            i3 = marginLayoutParams.rightMargin;
                        } else {
                            bottom = childAt.getBottom();
                            i3 = marginLayoutParams.bottomMargin;
                        }
                        iArr3[1] = bottom + i3;
                    } else {
                        throw new IllegalStateException("null view contained in the view hierarchy");
                    }
                }
                Arrays.sort(iArr, new ViewPager.C01171(4));
                int i6 = 1;
                while (true) {
                    if (i6 >= childCount) {
                        int[] iArr4 = iArr[0];
                        int i7 = iArr4[1];
                        int i8 = iArr4[0];
                        int i9 = i7 - i8;
                        if (i8 <= 0) {
                        }
                    } else if (iArr[i6 - 1][1] != iArr[i6][0]) {
                        break;
                    } else {
                        i6++;
                    }
                }
                int childCount2 = linearLayoutManager.getChildCount();
                for (int i10 = 0; i10 < childCount2; i10++) {
                    if (AnimateLayoutChangeDetector.hasRunningChangingLayoutTransition(linearLayoutManager.getChildAt(i10))) {
                        throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                    }
                }
                Locale locale = Locale.US;
                throw new IllegalStateException(ViewModelProvider.Factory.CC.m604m(scrollEventValues.mOffsetPx, "Page can only be offset by a positive amount, not by "));
            }
        } else {
            if (height != 0) {
                f = i4 / height;
            }
            scrollEventValues.mOffset = f;
        }
    }
}
