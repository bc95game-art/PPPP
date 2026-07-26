package androidx.viewpager2.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onScrolled(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
        /*
            r5 = this;
            r6 = 1
            r5.mScrollHappened = r6
            r5.updateScrollEventValues()
            boolean r0 = r5.mDispatchSelected
            r1 = -1
            androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues r2 = r5.mScrollValues
            r3 = 0
            if (r0 == 0) goto L40
            r5.mDispatchSelected = r3
            if (r8 > 0) goto L28
            if (r8 != 0) goto L30
            if (r7 >= 0) goto L18
            r7 = 1
            goto L19
        L18:
            r7 = 0
        L19:
            androidx.viewpager2.widget.ViewPager2 r8 = r5.mViewPager
            androidx.viewpager2.widget.ViewPager2$LinearLayoutManagerImpl r8 = r8.mLayoutManager
            int r8 = r8.getLayoutDirection()
            if (r8 != r6) goto L25
            r8 = 1
            goto L26
        L25:
            r8 = 0
        L26:
            if (r7 != r8) goto L30
        L28:
            int r7 = r2.mOffsetPx
            if (r7 == 0) goto L30
            int r7 = r2.mPosition
            int r7 = r7 + r6
            goto L32
        L30:
            int r7 = r2.mPosition
        L32:
            r5.mTarget = r7
            int r8 = r5.mDragStartPosition
            if (r8 == r7) goto L50
            androidx.viewpager2.widget.CompositeOnPageChangeCallback r8 = r5.mCallback
            if (r8 == 0) goto L50
            r8.onPageSelected(r7)
            goto L50
        L40:
            int r7 = r5.mAdapterState
            if (r7 != 0) goto L50
            int r7 = r2.mPosition
            if (r7 != r1) goto L49
            r7 = 0
        L49:
            androidx.viewpager2.widget.CompositeOnPageChangeCallback r8 = r5.mCallback
            if (r8 == 0) goto L50
            r8.onPageSelected(r7)
        L50:
            int r7 = r2.mPosition
            if (r7 != r1) goto L55
            r7 = 0
        L55:
            float r8 = r2.mOffset
            int r0 = r2.mOffsetPx
            androidx.viewpager2.widget.CompositeOnPageChangeCallback r4 = r5.mCallback
            if (r4 == 0) goto L60
            r4.onPageScrolled(r7, r8, r0)
        L60:
            int r7 = r2.mPosition
            int r8 = r5.mTarget
            if (r7 == r8) goto L68
            if (r8 != r1) goto L76
        L68:
            int r7 = r2.mOffsetPx
            if (r7 != 0) goto L76
            int r7 = r5.mScrollState
            if (r7 == r6) goto L76
            r5.dispatchStateChanged(r3)
            r5.resetState()
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateScrollEventValues() {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ScrollEventAdapter.updateScrollEventValues():void");
    }
}
