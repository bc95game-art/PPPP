package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.collection.LruCache;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.FastScroller;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.zzcl;
import com.google.android.gms.common.zzb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
/* loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    public boolean mLastLayoutFromEnd;
    public boolean mLastLayoutRTL;
    public final LayoutState mLayoutState;
    public final zzcl mLazySpanLookup;
    public final int mOrientation;
    public SavedState mPendingSavedState;
    public int[] mPrefetchDistances;
    public final OrientationHelper mPrimaryOrientation;
    public final BitSet mRemainingSpans;
    public boolean mReverseLayout;
    public final OrientationHelper mSecondaryOrientation;
    public int mSizePerSpan;
    public final int mSpanCount;
    public final LruCache[] mSpans;
    public boolean mShouldReverseLayout = false;
    public int mPendingScrollPosition = -1;
    public int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    public final int mGapStrategy = 2;
    public final Rect mTmpRect = new Rect();
    public final AnchorInfo mAnchorInfo = new AnchorInfo();
    public final boolean mSmoothScrollbarEnabled = true;
    public final FastScroller.RunnableC00991 mCheckForGapsRunnable = new FastScroller.RunnableC00991(1, this);

    /* loaded from: classes.dex */
    public final class AnchorInfo {
        public boolean mInvalidateOffsets;
        public boolean mLayoutFromEnd;
        public int mOffset;
        public int mPosition;
        public int[] mSpanReferenceLines;
        public boolean mValid;

        public AnchorInfo() {
            reset();
        }

        public final void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] iArr = this.mSpanReferenceLines;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class LayoutParams extends RecyclerView.LayoutParams {
        public LruCache mSpan;
    }

    /* loaded from: classes.dex */
    public final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new zzb(20);
        public boolean mAnchorLayoutFromEnd;
        public int mAnchorPosition;
        public ArrayList mFullSpanItems;
        public boolean mLastLayoutRTL;
        public boolean mReverseLayout;
        public int[] mSpanLookup;
        public int mSpanLookupSize;
        public int[] mSpanOffsets;
        public int mSpanOffsetsSize;
        public int mVisibleAnchorPosition;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? 1 : 0);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            parcel.writeInt(this.mLastLayoutRTL ? 1 : 0);
            parcel.writeList(this.mFullSpanItems);
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.recyclerview.widget.LayoutState, java.lang.Object] */
    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        zzcl zzclVar = new zzcl(15, false);
        this.mLazySpanLookup = zzclVar;
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 == 0 || i3 == 1) {
            assertNotInLayoutOrScroll(null);
            if (i3 != this.mOrientation) {
                this.mOrientation = i3;
                OrientationHelper orientationHelper = this.mPrimaryOrientation;
                this.mPrimaryOrientation = this.mSecondaryOrientation;
                this.mSecondaryOrientation = orientationHelper;
                requestLayout();
            }
            int i4 = properties.spanCount;
            assertNotInLayoutOrScroll(null);
            if (i4 != this.mSpanCount) {
                zzclVar.clear();
                requestLayout();
                this.mSpanCount = i4;
                this.mRemainingSpans = new BitSet(this.mSpanCount);
                this.mSpans = new LruCache[this.mSpanCount];
                for (int i5 = 0; i5 < this.mSpanCount; i5++) {
                    this.mSpans[i5] = new LruCache(this, i5);
                }
                requestLayout();
            }
            boolean z = properties.reverseLayout;
            assertNotInLayoutOrScroll(null);
            SavedState savedState = this.mPendingSavedState;
            if (!(savedState == null || savedState.mReverseLayout == z)) {
                savedState.mReverseLayout = z;
            }
            this.mReverseLayout = z;
            requestLayout();
            ?? obj = new Object();
            obj.mRecycle = true;
            obj.mStartLine = 0;
            obj.mEndLine = 0;
            this.mLayoutState = obj;
            this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
            this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public static int updateSpecWithExtra(int i, int i2, int i3) {
        int mode;
        if ((i2 != 0 || i3 != 0) && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824)) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    public final boolean checkForGaps() {
        int i;
        if (!(getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow())) {
            if (this.mShouldReverseLayout) {
                i = getLastChildPosition();
                getFirstChildPosition();
            } else {
                i = getFirstChildPosition();
                getLastChildPosition();
            }
            if (i == 0 && hasGapsToFix() != null) {
                this.mLazySpanLookup.clear();
                requestSimpleAnimationsInNextLayout();
                requestLayout();
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        LayoutState layoutState;
        int endLine;
        int i3;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (!(getChildCount() == 0 || i == 0)) {
            prepareLayoutStateForDelta(i, state);
            int[] iArr = this.mPrefetchDistances;
            if (iArr == null || iArr.length < this.mSpanCount) {
                this.mPrefetchDistances = new int[this.mSpanCount];
            }
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = this.mSpanCount;
                layoutState = this.mLayoutState;
                if (i4 >= i6) {
                    break;
                }
                if (layoutState.mItemDirection == -1) {
                    endLine = layoutState.mStartLine;
                    i3 = this.mSpans[i4].getStartLine(endLine);
                } else {
                    endLine = this.mSpans[i4].getEndLine(layoutState.mEndLine);
                    i3 = layoutState.mEndLine;
                }
                int i7 = endLine - i3;
                if (i7 >= 0) {
                    this.mPrefetchDistances[i5] = i7;
                    i5++;
                }
                i4++;
            }
            Arrays.sort(this.mPrefetchDistances, 0, i5);
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = layoutState.mCurrentPosition;
                if (i9 >= 0 && i9 < state.getItemCount()) {
                    ((GapWorker.LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).addPosition(layoutState.mCurrentPosition, this.mPrefetchDistances[i8]);
                    layoutState.mCurrentPosition += layoutState.mItemDirection;
                } else {
                    return;
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.mSmoothScrollbarEnabled;
        return Navigation.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(z), findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset$1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeHorizontalScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.mSmoothScrollbarEnabled;
        return Navigation.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(z), findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    public final int computeScrollOffset$1(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.mSmoothScrollbarEnabled;
        return Navigation.computeScrollOffset(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(z), findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
        if (r4 != r3.mShouldReverseLayout) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r3.mShouldReverseLayout != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        r1 = 1;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PointF computeScrollVectorForPosition(int i) {
        boolean z;
        int i2 = -1;
        if (getChildCount() != 0) {
            if (i < getFirstChildPosition()) {
                z = true;
            } else {
                z = false;
            }
        }
        PointF pointF = new PointF();
        if (i2 == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = i2;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = i2;
        return pointF;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.mSmoothScrollbarEnabled;
        return Navigation.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(z), findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset$1(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int computeVerticalScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        boolean z = !this.mSmoothScrollbarEnabled;
        return Navigation.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(z), findFirstVisibleItemClosestToEnd(z), this, this.mSmoothScrollbarEnabled);
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x028e, code lost:
        r0.recycle(r21, r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state) {
        int i;
        int startAfterPadding;
        int i2;
        int i3;
        LruCache lruCache;
        boolean z;
        int i4;
        int i5;
        int startAfterPadding2;
        int decoratedMeasurement;
        int i6;
        int i7;
        int i8;
        StaggeredGridLayoutManager staggeredGridLayoutManager = this;
        int i9 = 1;
        staggeredGridLayoutManager.mRemainingSpans.set(0, staggeredGridLayoutManager.mSpanCount, true);
        LayoutState layoutState2 = staggeredGridLayoutManager.mLayoutState;
        if (!layoutState2.mInfinite) {
            if (layoutState.mLayoutDirection == 1) {
                i8 = layoutState.mEndLine + layoutState.mAvailable;
            } else {
                i8 = layoutState.mStartLine - layoutState.mAvailable;
            }
            i = i8;
        } else if (layoutState.mLayoutDirection == 1) {
            i = Integer.MAX_VALUE;
        } else {
            i = Integer.MIN_VALUE;
        }
        int i10 = layoutState.mLayoutDirection;
        for (int i11 = 0; i11 < staggeredGridLayoutManager.mSpanCount; i11++) {
            if (!((ArrayList) staggeredGridLayoutManager.mSpans[i11].map).isEmpty()) {
                staggeredGridLayoutManager.updateRemainingSpans(staggeredGridLayoutManager.mSpans[i11], i10, i);
            }
        }
        if (staggeredGridLayoutManager.mShouldReverseLayout) {
            startAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding();
        } else {
            startAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding();
        }
        int i12 = startAfterPadding;
        boolean z2 = false;
        while (true) {
            int i13 = layoutState.mCurrentPosition;
            int i14 = -1;
            if (i13 < 0 || i13 >= state.getItemCount() || (!layoutState2.mInfinite && staggeredGridLayoutManager.mRemainingSpans.isEmpty())) {
                break;
            }
            View viewForPosition = recycler.getViewForPosition(layoutState.mCurrentPosition);
            layoutState.mCurrentPosition += layoutState.mItemDirection;
            LayoutParams layoutParams = (LayoutParams) viewForPosition.getLayoutParams();
            int layoutPosition = layoutParams.mViewHolder.getLayoutPosition();
            zzcl zzclVar = staggeredGridLayoutManager.mLazySpanLookup;
            int[] iArr = (int[]) zzclVar.zzb;
            if (iArr == null || layoutPosition >= iArr.length) {
                i3 = -1;
            } else {
                i3 = iArr[layoutPosition];
            }
            if (i3 == -1) {
                if (staggeredGridLayoutManager.preferLastSpan(layoutState.mLayoutDirection)) {
                    i6 = staggeredGridLayoutManager.mSpanCount - i9;
                    i7 = -1;
                } else {
                    i14 = staggeredGridLayoutManager.mSpanCount;
                    i7 = 1;
                    i6 = 0;
                }
                LruCache lruCache2 = null;
                if (layoutState.mLayoutDirection == i9) {
                    int startAfterPadding3 = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding();
                    int i15 = Integer.MAX_VALUE;
                    while (i6 != i14) {
                        LruCache lruCache3 = staggeredGridLayoutManager.mSpans[i6];
                        int i16 = i7;
                        int endLine = lruCache3.getEndLine(startAfterPadding3);
                        if (endLine < i15) {
                            lruCache2 = lruCache3;
                            i15 = endLine;
                        }
                        i6 += i16;
                        i7 = i16;
                    }
                } else {
                    int i17 = i7;
                    int endAfterPadding = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding();
                    int i18 = Integer.MIN_VALUE;
                    while (i6 != i14) {
                        LruCache lruCache4 = staggeredGridLayoutManager.mSpans[i6];
                        int startLine = lruCache4.getStartLine(endAfterPadding);
                        if (startLine > i18) {
                            lruCache2 = lruCache4;
                            i18 = startLine;
                        }
                        i6 += i17;
                    }
                }
                lruCache = lruCache2;
                zzclVar.ensureSize(layoutPosition);
                ((int[]) zzclVar.zzb)[layoutPosition] = lruCache.missCount;
            } else {
                lruCache = staggeredGridLayoutManager.mSpans[i3];
            }
            LruCache lruCache5 = lruCache;
            layoutParams.mSpan = lruCache5;
            if (layoutState.mLayoutDirection == 1) {
                staggeredGridLayoutManager.addView(viewForPosition);
                z = false;
            } else {
                z = false;
                staggeredGridLayoutManager.addView(viewForPosition, 0);
            }
            if (staggeredGridLayoutManager.mOrientation == 1) {
                int i19 = staggeredGridLayoutManager.mSizePerSpan;
                int widthMode = staggeredGridLayoutManager.getWidthMode();
                int i20 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                int i21 = z ? 1 : 0;
                int i22 = z ? 1 : 0;
                staggeredGridLayoutManager.measureChildWithDecorationsAndMargin$1(viewForPosition, RecyclerView.LayoutManager.getChildMeasureSpec(i19, widthMode, i21, i20, z), RecyclerView.LayoutManager.getChildMeasureSpec(staggeredGridLayoutManager.getHeight(), staggeredGridLayoutManager.getHeightMode(), staggeredGridLayoutManager.getPaddingBottom() + staggeredGridLayoutManager.getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true));
            } else {
                staggeredGridLayoutManager.measureChildWithDecorationsAndMargin$1(viewForPosition, RecyclerView.LayoutManager.getChildMeasureSpec(staggeredGridLayoutManager.getWidth(), staggeredGridLayoutManager.getWidthMode(), staggeredGridLayoutManager.getPaddingRight() + staggeredGridLayoutManager.getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(staggeredGridLayoutManager.mSizePerSpan, staggeredGridLayoutManager.getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false));
            }
            if (layoutState.mLayoutDirection == 1) {
                i5 = lruCache5.getEndLine(i12);
                i4 = staggeredGridLayoutManager.mPrimaryOrientation.getDecoratedMeasurement(viewForPosition) + i5;
            } else {
                i4 = lruCache5.getStartLine(i12);
                i5 = i4 - staggeredGridLayoutManager.mPrimaryOrientation.getDecoratedMeasurement(viewForPosition);
            }
            if (layoutState.mLayoutDirection == 1) {
                LruCache lruCache6 = layoutParams.mSpan;
                lruCache6.getClass();
                LayoutParams layoutParams2 = (LayoutParams) viewForPosition.getLayoutParams();
                layoutParams2.mSpan = lruCache6;
                ArrayList arrayList = (ArrayList) lruCache6.map;
                arrayList.add(viewForPosition);
                lruCache6.size = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    lruCache6.maxSize = Integer.MIN_VALUE;
                }
                if (layoutParams2.mViewHolder.isRemoved() || layoutParams2.mViewHolder.isUpdated()) {
                    lruCache6.hitCount = ((StaggeredGridLayoutManager) lruCache6.lock).mPrimaryOrientation.getDecoratedMeasurement(viewForPosition) + lruCache6.hitCount;
                }
            } else {
                LruCache lruCache7 = layoutParams.mSpan;
                lruCache7.getClass();
                LayoutParams layoutParams3 = (LayoutParams) viewForPosition.getLayoutParams();
                layoutParams3.mSpan = lruCache7;
                ArrayList arrayList2 = (ArrayList) lruCache7.map;
                arrayList2.add(0, viewForPosition);
                lruCache7.maxSize = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    lruCache7.size = Integer.MIN_VALUE;
                }
                if (layoutParams3.mViewHolder.isRemoved() || layoutParams3.mViewHolder.isUpdated()) {
                    lruCache7.hitCount = ((StaggeredGridLayoutManager) lruCache7.lock).mPrimaryOrientation.getDecoratedMeasurement(viewForPosition) + lruCache7.hitCount;
                }
            }
            if (!staggeredGridLayoutManager.isLayoutRTL() || staggeredGridLayoutManager.mOrientation != 1) {
                startAfterPadding2 = staggeredGridLayoutManager.mSecondaryOrientation.getStartAfterPadding() + (lruCache5.missCount * staggeredGridLayoutManager.mSizePerSpan);
                decoratedMeasurement = staggeredGridLayoutManager.mSecondaryOrientation.getDecoratedMeasurement(viewForPosition) + startAfterPadding2;
            } else {
                decoratedMeasurement = staggeredGridLayoutManager.mSecondaryOrientation.getEndAfterPadding() - (((staggeredGridLayoutManager.mSpanCount - 1) - lruCache5.missCount) * staggeredGridLayoutManager.mSizePerSpan);
                startAfterPadding2 = decoratedMeasurement - staggeredGridLayoutManager.mSecondaryOrientation.getDecoratedMeasurement(viewForPosition);
            }
            int i23 = startAfterPadding2;
            int i24 = decoratedMeasurement;
            if (staggeredGridLayoutManager.mOrientation == 1) {
                staggeredGridLayoutManager.layoutDecoratedWithMargins(viewForPosition, i23, i5, i24, i4);
                staggeredGridLayoutManager = this;
            } else {
                staggeredGridLayoutManager.layoutDecoratedWithMargins(viewForPosition, i5, i23, i4, i24);
            }
            staggeredGridLayoutManager.updateRemainingSpans(lruCache5, layoutState2.mLayoutDirection, i);
            staggeredGridLayoutManager.recycle(recycler, layoutState2);
            if (layoutState2.mStopInFocusable && viewForPosition.hasFocusable()) {
                staggeredGridLayoutManager.mRemainingSpans.set(lruCache5.missCount, false);
            }
            z2 = true;
            i9 = 1;
        }
        if (layoutState2.mLayoutDirection == -1) {
            i2 = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding() - staggeredGridLayoutManager.getMinStart(staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding());
        } else {
            i2 = staggeredGridLayoutManager.getMaxEnd(staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding()) - staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding();
        }
        if (i2 > 0) {
            return Math.min(layoutState.mAvailable, i2);
        }
        return 0;
    }

    public final View findFirstVisibleItemClosestToEnd(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final View findFirstVisibleItemClosestToStart(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void fixEndGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i = endAfterPadding - (-scrollBy(-endAfterPadding, recycler, state));
            if (z && i > 0) {
                this.mPrimaryOrientation.offsetChildren(i);
            }
        }
    }

    public final void fixStartGap(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int scrollBy = startAfterPadding - scrollBy(startAfterPadding, recycler, state);
            if (z && scrollBy > 0) {
                this.mPrimaryOrientation.offsetChildren(-scrollBy);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new RecyclerView.LayoutParams(-2, -1);
        }
        return new RecyclerView.LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new RecyclerView.LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return Math.min(this.mSpanCount, state.getItemCount());
        }
        return -1;
    }

    public final int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public final int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final int getMaxEnd(int i) {
        int endLine = this.mSpans[0].getEndLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    public final int getMinStart(int i) {
        int startLine = this.mSpans[0].getStartLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return Math.min(this.mSpanCount, state.getItemCount());
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleUpdate(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        zzcl zzclVar;
        int[] iArr;
        int i7;
        ArrayList arrayList;
        int i8;
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
        if (this.mShouldReverseLayout) {
            i4 = getLastChildPosition();
        } else {
            i4 = getFirstChildPosition();
        }
        if (i3 != 8) {
            i6 = i + i2;
        } else if (i < i2) {
            i6 = i2 + 1;
        } else {
            i6 = i + 1;
            i5 = i2;
            zzclVar = this.mLazySpanLookup;
            iArr = (int[]) zzclVar.zzb;
            if (iArr != null && i5 < iArr.length) {
                arrayList = (ArrayList) zzclVar.zzc;
                if (arrayList != null) {
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) zzclVar.zzc).get(size);
                            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition == i5) {
                                break;
                            }
                        }
                    }
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = null;
                    if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem != null) {
                        ((ArrayList) zzclVar.zzc).remove(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                    }
                    int size2 = ((ArrayList) zzclVar.zzc).size();
                    int i9 = 0;
                    while (true) {
                        if (i9 >= size2) {
                            i9 = -1;
                            break;
                        } else if (((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) zzclVar.zzc).get(i9)).mPosition >= i5) {
                            break;
                        } else {
                            i9++;
                        }
                    }
                    if (i9 != -1) {
                        ((ArrayList) zzclVar.zzc).remove(i9);
                        i8 = ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) zzclVar.zzc).get(i9)).mPosition;
                        if (i8 == -1) {
                            int[] iArr2 = (int[]) zzclVar.zzb;
                            Arrays.fill(iArr2, i5, iArr2.length, -1);
                            int length = ((int[]) zzclVar.zzb).length;
                        } else {
                            Arrays.fill((int[]) zzclVar.zzb, i5, Math.min(i8 + 1, ((int[]) zzclVar.zzb).length), -1);
                        }
                    }
                }
                i8 = -1;
                if (i8 == -1) {
                }
            }
            if (i3 != 1) {
                zzclVar.offsetForAddition(i, i2);
            } else if (i3 == 2) {
                zzclVar.offsetForRemoval(i, i2);
            } else if (i3 == 8) {
                zzclVar.offsetForRemoval(i, 1);
                zzclVar.offsetForAddition(i2, 1);
            }
            if (i6 <= i4) {
                if (this.mShouldReverseLayout) {
                    i7 = getFirstChildPosition();
                } else {
                    i7 = getLastChildPosition();
                }
                if (i5 <= i7) {
                    requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        i5 = i;
        zzclVar = this.mLazySpanLookup;
        iArr = (int[]) zzclVar.zzb;
        if (iArr != null) {
            arrayList = (ArrayList) zzclVar.zzc;
            if (arrayList != null) {
            }
            i8 = -1;
            if (i8 == -1) {
            }
        }
        if (i3 != 1) {
        }
        if (i6 <= i4) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View hasGapsToFix() {
        char c;
        boolean z;
        boolean z2;
        int childCount = getChildCount();
        int i = childCount - 1;
        BitSet bitSet = new BitSet(this.mSpanCount);
        bitSet.set(0, this.mSpanCount, true);
        int i2 = -1;
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            c = 65535;
        } else {
            c = 1;
        }
        if (this.mShouldReverseLayout) {
            childCount = -1;
        } else {
            i = 0;
        }
        if (i < childCount) {
            i2 = 1;
        }
        while (i != childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.mSpan.missCount)) {
                LruCache lruCache = layoutParams.mSpan;
                if (this.mShouldReverseLayout) {
                    int i3 = lruCache.size;
                    if (i3 == Integer.MIN_VALUE) {
                        lruCache.calculateCachedEnd();
                        i3 = lruCache.size;
                    }
                    if (i3 < this.mPrimaryOrientation.getEndAfterPadding()) {
                        ArrayList arrayList = (ArrayList) lruCache.map;
                        ((LayoutParams) ((View) arrayList.get(arrayList.size() - 1)).getLayoutParams()).getClass();
                        return childAt;
                    }
                } else {
                    int i4 = lruCache.maxSize;
                    ArrayList arrayList2 = (ArrayList) lruCache.map;
                    if (i4 == Integer.MIN_VALUE) {
                        View view = (View) arrayList2.get(0);
                        lruCache.maxSize = ((StaggeredGridLayoutManager) lruCache.lock).mPrimaryOrientation.getDecoratedStart(view);
                        ((LayoutParams) view.getLayoutParams()).getClass();
                        i4 = lruCache.maxSize;
                    }
                    if (i4 > this.mPrimaryOrientation.getStartAfterPadding()) {
                        ((LayoutParams) ((View) arrayList2.get(0)).getLayoutParams()).getClass();
                        return childAt;
                    }
                }
                bitSet.clear(layoutParams.mSpan.missCount);
            }
            i += i2;
            if (i != childCount) {
                View childAt2 = getChildAt(i);
                if (this.mShouldReverseLayout) {
                    int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                    if (decoratedEnd == decoratedEnd2) {
                        if (layoutParams.mSpan.missCount - ((LayoutParams) childAt2.getLayoutParams()).mSpan.missCount >= 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (c >= 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z == z2) {
                            return childAt;
                        }
                    } else {
                        continue;
                    }
                } else {
                    int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                    int decoratedStart2 = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                    if (decoratedStart == decoratedStart2) {
                        if (layoutParams.mSpan.missCount - ((LayoutParams) childAt2.getLayoutParams()).mSpan.missCount >= 0) {
                        }
                        if (c >= 0) {
                        }
                        if (z == z2) {
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isAutoMeasureEnabled() {
        if (this.mGapStrategy != 0) {
            return true;
        }
        return false;
    }

    public final boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean isLayoutReversed() {
        return this.mReverseLayout;
    }

    public final void measureChildWithDecorationsAndMargin$1(View view, int i, int i2) {
        Rect rect = this.mTmpRect;
        calculateItemDecorationsForChild(view, rect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int updateSpecWithExtra = updateSpecWithExtra(i, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int updateSpecWithExtra2 = updateSpecWithExtra(i2, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect.bottom);
        if (shouldMeasureChild(view, updateSpecWithExtra, updateSpecWithExtra2, layoutParams)) {
            view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            LruCache lruCache = this.mSpans[i2];
            int i3 = lruCache.maxSize;
            if (i3 != Integer.MIN_VALUE) {
                lruCache.maxSize = i3 + i;
            }
            int i4 = lruCache.size;
            if (i4 != Integer.MIN_VALUE) {
                lruCache.size = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            LruCache lruCache = this.mSpans[i2];
            int i3 = lruCache.maxSize;
            if (i3 != Integer.MIN_VALUE) {
                lruCache.maxSize = i3 + i;
            }
            int i4 = lruCache.size;
            if (i4 != Integer.MIN_VALUE) {
                lruCache.size = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.mLazySpanLookup.clear();
        for (int i = 0; i < this.mSpanCount; i++) {
            this.mSpans[i].clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        onDetachedFromWindow(recyclerView);
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i = 0; i < this.mSpanCount; i++) {
            this.mSpans[i].clear();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x003b, code lost:
        if (r8.mOrientation == 1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:
        if (r8.mOrientation == 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x004d, code lost:
        if (isLayoutRTL() == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0059, code lost:
        if (isLayoutRTL() == false) goto L28;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        int i6;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse$1();
        if (i == 1) {
            if (this.mOrientation != 1) {
            }
            i2 = -1;
        } else if (i == 2) {
            if (this.mOrientation != 1) {
            }
            i2 = 1;
        } else if (i != 17) {
            if (i != 33) {
                if (i == 66) {
                }
            }
            i2 = Integer.MIN_VALUE;
        }
        if (i2 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        layoutParams.getClass();
        LruCache lruCache = layoutParams.mSpan;
        if (i2 == 1) {
            i3 = getLastChildPosition();
        } else {
            i3 = getFirstChildPosition();
        }
        updateLayoutState(i3, state);
        setLayoutStateDirection(i2);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = layoutState.mItemDirection + i3;
        layoutState.mAvailable = (int) (this.mPrimaryOrientation.getTotalSpace() * 0.33333334f);
        layoutState.mStopInFocusable = true;
        layoutState.mRecycle = false;
        fill(recycler, layoutState, state);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        View focusableViewAfter = lruCache.getFocusableViewAfter(i3, i2);
        if (!(focusableViewAfter == null || focusableViewAfter == findContainingItemView)) {
            return focusableViewAfter;
        }
        if (preferLastSpan(i2)) {
            for (int i7 = this.mSpanCount - 1; i7 >= 0; i7--) {
                View focusableViewAfter2 = this.mSpans[i7].getFocusableViewAfter(i3, i2);
                if (!(focusableViewAfter2 == null || focusableViewAfter2 == findContainingItemView)) {
                    return focusableViewAfter2;
                }
            }
        } else {
            for (int i8 = 0; i8 < this.mSpanCount; i8++) {
                View focusableViewAfter3 = this.mSpans[i8].getFocusableViewAfter(i3, i2);
                if (!(focusableViewAfter3 == null || focusableViewAfter3 == findContainingItemView)) {
                    return focusableViewAfter3;
                }
            }
        }
        boolean z3 = !this.mReverseLayout;
        if (i2 == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z3 == z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i4 = lruCache.findFirstPartiallyVisibleItemPosition();
        } else {
            i4 = lruCache.findLastPartiallyVisibleItemPosition();
        }
        View findViewByPosition = findViewByPosition(i4);
        if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
            return findViewByPosition;
        }
        if (preferLastSpan(i2)) {
            for (int i9 = this.mSpanCount - 1; i9 >= 0; i9--) {
                if (i9 != lruCache.missCount) {
                    if (z2) {
                        i6 = this.mSpans[i9].findFirstPartiallyVisibleItemPosition();
                    } else {
                        i6 = this.mSpans[i9].findLastPartiallyVisibleItemPosition();
                    }
                    View findViewByPosition2 = findViewByPosition(i6);
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i10 = 0; i10 < this.mSpanCount; i10++) {
                if (z2) {
                    i5 = this.mSpans[i10].findFirstPartiallyVisibleItemPosition();
                } else {
                    i5 = this.mSpans[i10].findLastPartiallyVisibleItemPosition();
                }
                View findViewByPosition3 = findViewByPosition(i5);
                if (!(findViewByPosition3 == null || findViewByPosition3 == findContainingItemView)) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                int position = getPosition(findFirstVisibleItemClosestToStart);
                int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName("androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.mOrientation == 0) {
            LruCache lruCache = layoutParams2.mSpan;
            if (lruCache == null) {
                i2 = -1;
            } else {
                i2 = lruCache.missCount;
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i2, 1, -1, -1, false, false));
            return;
        }
        LruCache lruCache2 = layoutParams2.mSpan;
        if (lruCache2 == null) {
            i = -1;
        } else {
            i = lruCache2.missCount;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, i, 1, false, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        handleUpdate(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        handleUpdate(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        onLayoutChildren(recycler, state, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State state) {
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.mAnchorPosition = -1;
                savedState.mVisibleAnchorPosition = -1;
                savedState.mSpanOffsets = null;
                savedState.mSpanOffsetsSize = 0;
                savedState.mSpanLookupSize = 0;
                savedState.mSpanLookup = null;
                savedState.mFullSpanItems = null;
            }
            requestLayout();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState, android.os.Parcelable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState, android.os.Parcelable, java.lang.Object] */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final Parcelable onSaveInstanceState() {
        int i;
        View view;
        int i2;
        int startAfterPadding;
        int[] iArr;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            ?? obj = new Object();
            obj.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            obj.mAnchorPosition = savedState.mAnchorPosition;
            obj.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            obj.mSpanOffsets = savedState.mSpanOffsets;
            obj.mSpanLookupSize = savedState.mSpanLookupSize;
            obj.mSpanLookup = savedState.mSpanLookup;
            obj.mReverseLayout = savedState.mReverseLayout;
            obj.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            obj.mLastLayoutRTL = savedState.mLastLayoutRTL;
            obj.mFullSpanItems = savedState.mFullSpanItems;
            return obj;
        }
        ?? obj2 = new Object();
        obj2.mReverseLayout = this.mReverseLayout;
        obj2.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        obj2.mLastLayoutRTL = this.mLastLayoutRTL;
        zzcl zzclVar = this.mLazySpanLookup;
        if (zzclVar == null || (iArr = (int[]) zzclVar.zzb) == null) {
            obj2.mSpanLookupSize = 0;
        } else {
            obj2.mSpanLookup = iArr;
            obj2.mSpanLookupSize = iArr.length;
            obj2.mFullSpanItems = (ArrayList) zzclVar.zzc;
        }
        int i3 = -1;
        if (getChildCount() > 0) {
            if (this.mLastLayoutFromEnd) {
                i = getLastChildPosition();
            } else {
                i = getFirstChildPosition();
            }
            obj2.mAnchorPosition = i;
            if (this.mShouldReverseLayout) {
                view = findFirstVisibleItemClosestToEnd(true);
            } else {
                view = findFirstVisibleItemClosestToStart(true);
            }
            if (view != null) {
                i3 = getPosition(view);
            }
            obj2.mVisibleAnchorPosition = i3;
            int i4 = this.mSpanCount;
            obj2.mSpanOffsetsSize = i4;
            obj2.mSpanOffsets = new int[i4];
            for (int i5 = 0; i5 < this.mSpanCount; i5++) {
                if (this.mLastLayoutFromEnd) {
                    i2 = this.mSpans[i5].getEndLine(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                        i2 -= startAfterPadding;
                        obj2.mSpanOffsets[i5] = i2;
                    } else {
                        obj2.mSpanOffsets[i5] = i2;
                    }
                } else {
                    i2 = this.mSpans[i5].getStartLine(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                        i2 -= startAfterPadding;
                        obj2.mSpanOffsets[i5] = i2;
                    } else {
                        obj2.mSpanOffsets[i5] = i2;
                    }
                }
            }
            return obj2;
        }
        obj2.mAnchorPosition = -1;
        obj2.mVisibleAnchorPosition = -1;
        obj2.mSpanOffsetsSize = 0;
        return obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int i) {
        if (i == 0) {
            checkForGaps();
        }
    }

    public final boolean preferLastSpan(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.mOrientation == 0) {
            if (i == -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 != this.mShouldReverseLayout) {
                return true;
            }
            return false;
        }
        if (i == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z == this.mShouldReverseLayout) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    public final void prepareLayoutStateForDelta(int i, RecyclerView.State state) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = getLastChildPosition();
            i2 = 1;
        } else {
            i3 = getFirstChildPosition();
            i2 = -1;
        }
        LayoutState layoutState = this.mLayoutState;
        layoutState.mRecycle = true;
        updateLayoutState(i3, state);
        setLayoutStateDirection(i2);
        layoutState.mCurrentPosition = i3 + layoutState.mItemDirection;
        layoutState.mAvailable = Math.abs(i);
    }

    public final void recycle(RecyclerView.Recycler recycler, LayoutState layoutState) {
        int i;
        int i2;
        if (layoutState.mRecycle && !layoutState.mInfinite) {
            if (layoutState.mAvailable != 0) {
                int i3 = 1;
                if (layoutState.mLayoutDirection == -1) {
                    int i4 = layoutState.mStartLine;
                    int startLine = this.mSpans[0].getStartLine(i4);
                    while (i3 < this.mSpanCount) {
                        int startLine2 = this.mSpans[i3].getStartLine(i4);
                        if (startLine2 > startLine) {
                            startLine = startLine2;
                        }
                        i3++;
                    }
                    int i5 = i4 - startLine;
                    if (i5 < 0) {
                        i2 = layoutState.mEndLine;
                    } else {
                        i2 = layoutState.mEndLine - Math.min(i5, layoutState.mAvailable);
                    }
                    recycleFromEnd(i2, recycler);
                    return;
                }
                int i6 = layoutState.mEndLine;
                int endLine = this.mSpans[0].getEndLine(i6);
                while (i3 < this.mSpanCount) {
                    int endLine2 = this.mSpans[i3].getEndLine(i6);
                    if (endLine2 < endLine) {
                        endLine = endLine2;
                    }
                    i3++;
                }
                int i7 = endLine - layoutState.mEndLine;
                if (i7 < 0) {
                    i = layoutState.mStartLine;
                } else {
                    i = Math.min(i7, layoutState.mAvailable) + layoutState.mStartLine;
                }
                recycleFromStart(i, recycler);
            } else if (layoutState.mLayoutDirection == -1) {
                recycleFromEnd(layoutState.mEndLine, recycler);
            } else {
                recycleFromStart(layoutState.mStartLine, recycler);
            }
        }
    }

    public final void recycleFromEnd(int i, RecyclerView.Recycler recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= i && this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.getClass();
                if (((ArrayList) layoutParams.mSpan.map).size() != 1) {
                    LruCache lruCache = layoutParams.mSpan;
                    ArrayList arrayList = (ArrayList) lruCache.map;
                    int size = arrayList.size();
                    View view = (View) arrayList.remove(size - 1);
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    layoutParams2.mSpan = null;
                    if (layoutParams2.mViewHolder.isRemoved() || layoutParams2.mViewHolder.isUpdated()) {
                        lruCache.hitCount -= ((StaggeredGridLayoutManager) lruCache.lock).mPrimaryOrientation.getDecoratedMeasurement(view);
                    }
                    if (size == 1) {
                        lruCache.maxSize = Integer.MIN_VALUE;
                    }
                    lruCache.size = Integer.MIN_VALUE;
                    removeAndRecycleView(childAt, recycler);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void recycleFromStart(int i, RecyclerView.Recycler recycler) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= i && this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.getClass();
                if (((ArrayList) layoutParams.mSpan.map).size() != 1) {
                    LruCache lruCache = layoutParams.mSpan;
                    ArrayList arrayList = (ArrayList) lruCache.map;
                    View view = (View) arrayList.remove(0);
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    layoutParams2.mSpan = null;
                    if (arrayList.size() == 0) {
                        lruCache.size = Integer.MIN_VALUE;
                    }
                    if (layoutParams2.mViewHolder.isRemoved() || layoutParams2.mViewHolder.isUpdated()) {
                        lruCache.hitCount -= ((StaggeredGridLayoutManager) lruCache.lock).mPrimaryOrientation.getDecoratedMeasurement(view);
                    }
                    lruCache.maxSize = Integer.MIN_VALUE;
                    removeAndRecycleView(childAt, recycler);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void resolveShouldLayoutReverse$1() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    public final int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i, state);
        LayoutState layoutState = this.mLayoutState;
        int fill = fill(recycler, layoutState, state);
        if (layoutState.mAvailable >= fill) {
            if (i < 0) {
                i = -fill;
            } else {
                i = fill;
            }
        }
        this.mPrimaryOrientation.offsetChildren(-i);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        layoutState.mAvailable = 0;
        recycle(recycler, layoutState);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void scrollToPosition(int i) {
        SavedState savedState = this.mPendingSavedState;
        if (!(savedState == null || savedState.mAnchorPosition == i)) {
            savedState.mSpanOffsets = null;
            savedState.mSpanOffsetsSize = 0;
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler, state);
    }

    public final void setLayoutStateDirection(int i) {
        boolean z;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = i;
        boolean z2 = this.mShouldReverseLayout;
        int i2 = 1;
        if (i == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z2 != z) {
            i2 = -1;
        }
        layoutState.mItemDirection = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            i3 = RecyclerView.LayoutManager.chooseSize(i, (this.mSizePerSpan * this.mSpanCount) + paddingRight, getMinimumWidth());
        } else {
            i3 = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            i4 = RecyclerView.LayoutManager.chooseSize(i2, (this.mSizePerSpan * this.mSpanCount) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.mTargetPosition = i;
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateLayoutState(int i, RecyclerView.State state) {
        int i2;
        int i3;
        int i4;
        boolean z;
        LayoutState layoutState = this.mLayoutState;
        boolean z2 = false;
        layoutState.mAvailable = 0;
        layoutState.mCurrentPosition = i;
        if (!isSmoothScrolling() || (i4 = state.mTargetPosition) == -1) {
            i3 = 0;
        } else {
            boolean z3 = this.mShouldReverseLayout;
            if (i4 < i) {
                z = true;
            } else {
                z = false;
            }
            if (z3 == z) {
                i3 = this.mPrimaryOrientation.getTotalSpace();
            } else {
                i2 = this.mPrimaryOrientation.getTotalSpace();
                i3 = 0;
                if (!getClipToPadding()) {
                    layoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i2;
                    layoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + i3;
                } else {
                    layoutState.mEndLine = this.mPrimaryOrientation.getEnd() + i3;
                    layoutState.mStartLine = -i2;
                }
                layoutState.mStopInFocusable = false;
                layoutState.mRecycle = true;
                if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
                    z2 = true;
                }
                layoutState.mInfinite = z2;
            }
        }
        i2 = 0;
        if (!getClipToPadding()) {
        }
        layoutState.mStopInFocusable = false;
        layoutState.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0) {
            z2 = true;
        }
        layoutState.mInfinite = z2;
    }

    public final void updateRemainingSpans(LruCache lruCache, int i, int i2) {
        int i3 = lruCache.hitCount;
        int i4 = lruCache.missCount;
        if (i == -1) {
            int i5 = lruCache.maxSize;
            if (i5 == Integer.MIN_VALUE) {
                View view = (View) ((ArrayList) lruCache.map).get(0);
                lruCache.maxSize = ((StaggeredGridLayoutManager) lruCache.lock).mPrimaryOrientation.getDecoratedStart(view);
                ((LayoutParams) view.getLayoutParams()).getClass();
                i5 = lruCache.maxSize;
            }
            if (i5 + i3 <= i2) {
                this.mRemainingSpans.set(i4, false);
                return;
            }
            return;
        }
        int i6 = lruCache.size;
        if (i6 == Integer.MIN_VALUE) {
            lruCache.calculateCachedEnd();
            i6 = lruCache.size;
        }
        if (i6 - i3 >= i2) {
            this.mRemainingSpans.set(i4, false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01a6, code lost:
        if ((r11 < getFirstChildPosition()) != r16.mShouldReverseLayout) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01a8, code lost:
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01aa, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0417, code lost:
        if (checkForGaps() != false) goto L239;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0198, code lost:
        if (r16.mShouldReverseLayout != false) goto L104;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        SavedState savedState;
        int i;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        int startAfterPadding;
        SavedState savedState2 = this.mPendingSavedState;
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (!(savedState2 == null && this.mPendingScrollPosition == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            anchorInfo.reset();
            return;
        }
        boolean z3 = anchorInfo.mValid;
        StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
        boolean z4 = true;
        boolean z5 = (z3 && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) ? false : true;
        zzcl zzclVar = this.mLazySpanLookup;
        if (z5) {
            anchorInfo.reset();
            SavedState savedState3 = this.mPendingSavedState;
            if (savedState3 != null) {
                int i7 = savedState3.mSpanOffsetsSize;
                if (i7 > 0) {
                    if (i7 == this.mSpanCount) {
                        for (int i8 = 0; i8 < this.mSpanCount; i8++) {
                            this.mSpans[i8].clear();
                            SavedState savedState4 = this.mPendingSavedState;
                            int i9 = savedState4.mSpanOffsets[i8];
                            if (i9 != Integer.MIN_VALUE) {
                                if (savedState4.mAnchorLayoutFromEnd) {
                                    startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                                } else {
                                    startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                                }
                                i9 += startAfterPadding;
                            }
                            LruCache lruCache = this.mSpans[i8];
                            lruCache.maxSize = i9;
                            lruCache.size = i9;
                        }
                    } else {
                        savedState3.mSpanOffsets = null;
                        savedState3.mSpanOffsetsSize = 0;
                        savedState3.mSpanLookupSize = 0;
                        savedState3.mSpanLookup = null;
                        savedState3.mFullSpanItems = null;
                        savedState3.mAnchorPosition = savedState3.mVisibleAnchorPosition;
                    }
                }
                SavedState savedState5 = this.mPendingSavedState;
                this.mLastLayoutRTL = savedState5.mLastLayoutRTL;
                boolean z6 = savedState5.mReverseLayout;
                assertNotInLayoutOrScroll(null);
                SavedState savedState6 = this.mPendingSavedState;
                if (!(savedState6 == null || savedState6.mReverseLayout == z6)) {
                    savedState6.mReverseLayout = z6;
                }
                this.mReverseLayout = z6;
                requestLayout();
                resolveShouldLayoutReverse$1();
                SavedState savedState7 = this.mPendingSavedState;
                int i10 = savedState7.mAnchorPosition;
                if (i10 != -1) {
                    this.mPendingScrollPosition = i10;
                    anchorInfo.mLayoutFromEnd = savedState7.mAnchorLayoutFromEnd;
                } else {
                    anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
                }
                if (savedState7.mSpanLookupSize > 1) {
                    zzclVar.zzb = savedState7.mSpanLookup;
                    zzclVar.zzc = savedState7.mFullSpanItems;
                }
            } else {
                resolveShouldLayoutReverse$1();
                anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
            }
            if (!state.mInPreLayout && (i3 = this.mPendingScrollPosition) != -1) {
                if (i3 < 0 || i3 >= state.getItemCount()) {
                    this.mPendingScrollPosition = -1;
                    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                } else {
                    SavedState savedState8 = this.mPendingSavedState;
                    if (savedState8 == null || savedState8.mAnchorPosition == -1 || savedState8.mSpanOffsetsSize < 1) {
                        View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                        if (findViewByPosition != null) {
                            if (this.mShouldReverseLayout) {
                                i5 = getLastChildPosition();
                            } else {
                                i5 = getFirstChildPosition();
                            }
                            anchorInfo.mPosition = i5;
                            if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                                if (anchorInfo.mLayoutFromEnd) {
                                    anchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                                } else {
                                    anchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(findViewByPosition);
                                }
                            } else if (this.mPrimaryOrientation.getDecoratedMeasurement(findViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                                if (anchorInfo.mLayoutFromEnd) {
                                    i6 = this.mPrimaryOrientation.getEndAfterPadding();
                                } else {
                                    i6 = this.mPrimaryOrientation.getStartAfterPadding();
                                }
                                anchorInfo.mOffset = i6;
                            } else {
                                int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(findViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                                if (decoratedStart < 0) {
                                    anchorInfo.mOffset = -decoratedStart;
                                } else {
                                    int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                                    if (endAfterPadding < 0) {
                                        anchorInfo.mOffset = endAfterPadding;
                                    } else {
                                        anchorInfo.mOffset = Integer.MIN_VALUE;
                                    }
                                }
                            }
                        } else {
                            int i11 = this.mPendingScrollPosition;
                            anchorInfo.mPosition = i11;
                            int i12 = this.mPendingScrollPositionOffset;
                            if (i12 == Integer.MIN_VALUE) {
                                if (getChildCount() == 0) {
                                }
                                anchorInfo.mLayoutFromEnd = z2;
                                if (z2) {
                                    i4 = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding();
                                } else {
                                    i4 = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding();
                                }
                                anchorInfo.mOffset = i4;
                            } else if (anchorInfo.mLayoutFromEnd) {
                                anchorInfo.mOffset = staggeredGridLayoutManager.mPrimaryOrientation.getEndAfterPadding() - i12;
                            } else {
                                anchorInfo.mOffset = staggeredGridLayoutManager.mPrimaryOrientation.getStartAfterPadding() + i12;
                            }
                            anchorInfo.mInvalidateOffsets = true;
                        }
                    } else {
                        anchorInfo.mOffset = Integer.MIN_VALUE;
                        anchorInfo.mPosition = this.mPendingScrollPosition;
                    }
                    anchorInfo.mValid = true;
                }
            }
            if (this.mLastLayoutFromEnd) {
                int itemCount = state.getItemCount();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    i2 = getPosition(getChildAt(childCount));
                    if (i2 >= 0 && i2 < itemCount) {
                        break;
                    }
                }
                i2 = 0;
                anchorInfo.mPosition = i2;
                anchorInfo.mOffset = Integer.MIN_VALUE;
            } else {
                int itemCount2 = state.getItemCount();
                int childCount2 = getChildCount();
                for (int i13 = 0; i13 < childCount2; i13++) {
                    int position = getPosition(getChildAt(i13));
                    if (position >= 0 && position < itemCount2) {
                        i2 = position;
                        break;
                    }
                }
                i2 = 0;
                anchorInfo.mPosition = i2;
                anchorInfo.mOffset = Integer.MIN_VALUE;
            }
            anchorInfo.mValid = true;
        }
        if (this.mPendingSavedState == null && this.mPendingScrollPosition == -1 && !(anchorInfo.mLayoutFromEnd == this.mLastLayoutFromEnd && isLayoutRTL() == this.mLastLayoutRTL)) {
            zzclVar.clear();
            anchorInfo.mInvalidateOffsets = true;
        }
        if (getChildCount() > 0 && ((savedState = this.mPendingSavedState) == null || savedState.mSpanOffsetsSize < 1)) {
            if (anchorInfo.mInvalidateOffsets) {
                for (int i14 = 0; i14 < this.mSpanCount; i14++) {
                    this.mSpans[i14].clear();
                    int i15 = anchorInfo.mOffset;
                    if (i15 != Integer.MIN_VALUE) {
                        LruCache lruCache2 = this.mSpans[i14];
                        lruCache2.maxSize = i15;
                        lruCache2.size = i15;
                    }
                }
            } else if (z5 || anchorInfo.mSpanReferenceLines == null) {
                for (int i16 = 0; i16 < this.mSpanCount; i16++) {
                    LruCache lruCache3 = this.mSpans[i16];
                    boolean z7 = this.mShouldReverseLayout;
                    int i17 = anchorInfo.mOffset;
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = (StaggeredGridLayoutManager) lruCache3.lock;
                    if (z7) {
                        i = lruCache3.getEndLine(Integer.MIN_VALUE);
                    } else {
                        i = lruCache3.getStartLine(Integer.MIN_VALUE);
                    }
                    lruCache3.clear();
                    if (i != Integer.MIN_VALUE && ((!z7 || i >= staggeredGridLayoutManager2.mPrimaryOrientation.getEndAfterPadding()) && (z7 || i <= staggeredGridLayoutManager2.mPrimaryOrientation.getStartAfterPadding()))) {
                        if (i17 != Integer.MIN_VALUE) {
                            i += i17;
                        }
                        lruCache3.size = i;
                        lruCache3.maxSize = i;
                    }
                }
                LruCache[] lruCacheArr = this.mSpans;
                int length = lruCacheArr.length;
                int[] iArr = anchorInfo.mSpanReferenceLines;
                if (iArr == null || iArr.length < length) {
                    anchorInfo.mSpanReferenceLines = new int[staggeredGridLayoutManager.mSpans.length];
                }
                for (int i18 = 0; i18 < length; i18++) {
                    anchorInfo.mSpanReferenceLines[i18] = lruCacheArr[i18].getStartLine(Integer.MIN_VALUE);
                }
            } else {
                for (int i19 = 0; i19 < this.mSpanCount; i19++) {
                    LruCache lruCache4 = this.mSpans[i19];
                    lruCache4.clear();
                    int i20 = anchorInfo.mSpanReferenceLines[i19];
                    lruCache4.maxSize = i20;
                    lruCache4.size = i20;
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mRecycle = false;
        int totalSpace = this.mSecondaryOrientation.getTotalSpace();
        this.mSizePerSpan = totalSpace / this.mSpanCount;
        View.MeasureSpec.makeMeasureSpec(totalSpace, this.mSecondaryOrientation.getMode());
        updateLayoutState(anchorInfo.mPosition, state);
        if (anchorInfo.mLayoutFromEnd) {
            setLayoutStateDirection(-1);
            fill(recycler, layoutState, state);
            setLayoutStateDirection(1);
            layoutState.mCurrentPosition = anchorInfo.mPosition + layoutState.mItemDirection;
            fill(recycler, layoutState, state);
        } else {
            setLayoutStateDirection(1);
            fill(recycler, layoutState, state);
            setLayoutStateDirection(-1);
            layoutState.mCurrentPosition = anchorInfo.mPosition + layoutState.mItemDirection;
            fill(recycler, layoutState, state);
        }
        if (this.mSecondaryOrientation.getMode() != 1073741824) {
            int childCount3 = getChildCount();
            float f = 0.0f;
            for (int i21 = 0; i21 < childCount3; i21++) {
                View childAt = getChildAt(i21);
                float decoratedMeasurement = this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement >= f) {
                    ((LayoutParams) childAt.getLayoutParams()).getClass();
                    f = Math.max(f, decoratedMeasurement);
                }
            }
            int i22 = this.mSizePerSpan;
            int round = Math.round(f * this.mSpanCount);
            if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.mSecondaryOrientation.getTotalSpace());
            }
            this.mSizePerSpan = round / this.mSpanCount;
            View.MeasureSpec.makeMeasureSpec(round, this.mSecondaryOrientation.getMode());
            if (this.mSizePerSpan != i22) {
                for (int i23 = 0; i23 < childCount3; i23++) {
                    View childAt2 = getChildAt(i23);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    layoutParams.getClass();
                    if (!isLayoutRTL() || this.mOrientation != 1) {
                        int i24 = layoutParams.mSpan.missCount;
                        int i25 = this.mSizePerSpan * i24;
                        int i26 = i24 * i22;
                        if (this.mOrientation == 1) {
                            childAt2.offsetLeftAndRight(i25 - i26);
                        } else {
                            childAt2.offsetTopAndBottom(i25 - i26);
                        }
                    } else {
                        int i27 = -((this.mSpanCount - 1) - layoutParams.mSpan.missCount);
                        childAt2.offsetLeftAndRight((this.mSizePerSpan * i27) - (i27 * i22));
                    }
                }
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout) {
                fixEndGap(recycler, state, true);
                fixStartGap(recycler, state, false);
            } else {
                fixStartGap(recycler, state, true);
                fixEndGap(recycler, state, false);
            }
        }
        if (z && !state.mInPreLayout && this.mGapStrategy != 0 && getChildCount() > 0 && hasGapsToFix() != null) {
            removeCallbacks(this.mCheckForGapsRunnable);
        }
        z4 = false;
        if (state.mInPreLayout) {
            anchorInfo.reset();
        }
        this.mLastLayoutFromEnd = anchorInfo.mLayoutFromEnd;
        this.mLastLayoutRTL = isLayoutRTL();
        if (z4) {
            anchorInfo.reset();
            onLayoutChildren(recycler, state, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new RecyclerView.LayoutParams(layoutParams);
    }
}
