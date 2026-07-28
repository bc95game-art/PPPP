package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.zzcl;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import p004j$.util.DesugarCollections;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public static final Set sSupportedDirectionsForActionScrollInDirection = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(17, 66, 33, 130)));
    public int[] mCachedBorders;
    public View[] mSet;
    public boolean mPendingSpanCountChange = false;
    public int mSpanCount = -1;
    public final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
    public final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
    public final zzcl mSpanSizeLookup = new zzcl(14);
    public final Rect mDecorInsets = new Rect();
    public int mPositionTargetedByScrollInDirection = -1;
    public int mRowWithAccessibilityFocus = -1;
    public int mColumnWithAccessibilityFocus = -1;

    /* loaded from: classes.dex */
    public final class LayoutParams extends RecyclerView.LayoutParams {
        public int mSpanIndex = -1;
        public int mSpanSize = 0;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        setSpanCount(RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2).spanCount);
    }

    public final void calculateItemBorders(int i) {
        int i2;
        int[] iArr = this.mCachedBorders;
        int i3 = this.mSpanCount;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.mCachedBorders = iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i;
        int i2 = this.mSpanCount;
        for (int i3 = 0; i3 < this.mSpanCount && (i = layoutState.mCurrentPosition) >= 0 && i < state.getItemCount() && i2 > 0; i3++) {
            ((GapWorker.LayoutPrefetchRegistryImpl) layoutPrefetchRegistry).addPosition(layoutState.mCurrentPosition, Math.max(0, layoutState.mScrollingOffset));
            this.mSpanSizeLookup.getClass();
            i2--;
            layoutState.mCurrentPosition += layoutState.mItemDirection;
        }
    }

    public final void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int i;
        int i2;
        int childCount = getChildCount();
        int i3 = 1;
        if (z2) {
            i2 = getChildCount() - 1;
            i = -1;
            i3 = -1;
        } else {
            i = childCount;
            i2 = 0;
        }
        int itemCount = state.getItemCount();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (i2 != i) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount && getSpanIndex(position, recycler, state) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).mViewHolder.isRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i3;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.GridLayoutManager$LayoutParams, androidx.recyclerview.widget.RecyclerView$LayoutParams] */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        ?? layoutParams = new RecyclerView.LayoutParams(context, attributeSet);
        layoutParams.mSpanIndex = -1;
        layoutParams.mSpanSize = 0;
        return layoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return Math.min(this.mSpanCount, getItemCount());
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(state.getItemCount() - 1, recycler, state) + 1;
    }

    public final int getColumnIndex(int i) {
        if (this.mOrientation == 0) {
            RecyclerView recyclerView = this.mRecyclerView;
            return getSpanGroupIndex(i, recyclerView.mRecycler, recyclerView.mState);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        return getSpanIndex(i, recyclerView2.mRecycler, recyclerView2.mState);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return Math.min(this.mSpanCount, getItemCount());
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(state.getItemCount() - 1, recycler, state) + 1;
    }

    public final int getRowIndex(int i) {
        if (this.mOrientation == 1) {
            RecyclerView recyclerView = this.mRecyclerView;
            return getSpanGroupIndex(i, recyclerView.mRecycler, recyclerView.mState);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        return getSpanIndex(i, recyclerView2.mRecycler, recyclerView2.mState);
    }

    public final HashSet getRowIndices(int i) {
        return getRowOrColumnIndices(getRowIndex(i), i);
    }

    public final HashSet getRowOrColumnIndices(int i, int i2) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.mRecyclerView;
        int spanSize = getSpanSize(i2, recyclerView.mRecycler, recyclerView.mState);
        for (int i3 = i; i3 < i + spanSize; i3++) {
            hashSet.add(Integer.valueOf(i3));
        }
        return hashSet;
    }

    public final int getSpaceForSpanRange(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.mCachedBorders;
        int i3 = this.mSpanCount;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int getSpanGroupIndex(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.mInPreLayout;
        zzcl zzclVar = this.mSpanSizeLookup;
        if (!z) {
            int i2 = this.mSpanCount;
            zzclVar.getClass();
            return zzcl.getSpanGroupIndex(i, i2);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        int i3 = this.mSpanCount;
        zzclVar.getClass();
        return zzcl.getSpanGroupIndex(convertPreLayoutPositionToPostLayout, i3);
    }

    public final int getSpanIndex(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.mInPreLayout;
        zzcl zzclVar = this.mSpanSizeLookup;
        if (!z) {
            int i2 = this.mSpanCount;
            zzclVar.getClass();
            return i % i2;
        }
        int i3 = this.mPreLayoutSpanIndexCache.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        int i4 = this.mSpanCount;
        zzclVar.getClass();
        return convertPreLayoutPositionToPostLayout % i4;
    }

    public final int getSpanSize(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.mInPreLayout;
        zzcl zzclVar = this.mSpanSizeLookup;
        if (!z) {
            zzclVar.getClass();
            return 1;
        }
        int i2 = this.mPreLayoutSpanSizeCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (recycler.convertPreLayoutPositionToPostLayout(i) == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        zzclVar.getClass();
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x009f, code lost:
        r21.mFinished = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z3;
        int i11;
        View next;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        if (modeInOther != 1073741824) {
            z = true;
        } else {
            z = false;
        }
        if (getChildCount() > 0) {
            i = this.mCachedBorders[this.mSpanCount];
        } else {
            i = 0;
        }
        if (z) {
            updateMeasurements();
        }
        if (layoutState.mItemDirection == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i12 = this.mSpanCount;
        if (!z2) {
            i12 = getSpanIndex(layoutState.mCurrentPosition, recycler, state) + getSpanSize(layoutState.mCurrentPosition, recycler, state);
        }
        int i13 = 0;
        while (i13 < this.mSpanCount && (i11 = layoutState.mCurrentPosition) >= 0 && i11 < state.getItemCount() && i12 > 0) {
            int i14 = layoutState.mCurrentPosition;
            int spanSize = getSpanSize(i14, recycler, state);
            if (spanSize <= this.mSpanCount) {
                i12 -= spanSize;
                if (i12 < 0 || (next = layoutState.next(recycler)) == null) {
                    break;
                }
                this.mSet[i13] = next;
                i13++;
            } else {
                throw new IllegalArgumentException("Item at position " + i14 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
        }
        if (z2) {
            i3 = i13;
            i4 = 0;
            i2 = 1;
        } else {
            i4 = i13 - 1;
            i3 = -1;
            i2 = -1;
        }
        int i15 = 0;
        while (i4 != i3) {
            View view = this.mSet[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int spanSize2 = getSpanSize(getPosition(view), recycler, state);
            layoutParams.mSpanSize = spanSize2;
            layoutParams.mSpanIndex = i15;
            i15 += spanSize2;
            i4 += i2;
        }
        float f = 0.0f;
        int i16 = 0;
        for (int i17 = 0; i17 < i13; i17++) {
            View view2 = this.mSet[i17];
            if (layoutState.mScrapList != null) {
                z3 = false;
                if (z2) {
                    addDisappearingView(view2);
                } else {
                    addDisappearingView(view2, 0);
                }
            } else if (z2) {
                addView(view2);
                z3 = false;
            } else {
                z3 = false;
                addView(view2, 0);
            }
            calculateItemDecorationsForChild(view2, this.mDecorInsets);
            measureChild(view2, modeInOther, z3);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view2);
            if (decoratedMeasurement > i16) {
                i16 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (this.mOrientationHelper.getDecoratedMeasurementInOther(view2) * 1.0f) / ((LayoutParams) view2.getLayoutParams()).mSpanSize;
            if (decoratedMeasurementInOther > f) {
                f = decoratedMeasurementInOther;
            }
        }
        if (z) {
            calculateItemBorders(Math.max(Math.round(f * this.mSpanCount), i));
            i16 = 0;
            for (int i18 = 0; i18 < i13; i18++) {
                View view3 = this.mSet[i18];
                measureChild(view3, 1073741824, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view3);
                if (decoratedMeasurement2 > i16) {
                    i16 = decoratedMeasurement2;
                }
            }
        }
        for (int i19 = 0; i19 < i13; i19++) {
            View view4 = this.mSet[i19];
            if (this.mOrientationHelper.getDecoratedMeasurement(view4) != i16) {
                LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
                Rect rect = layoutParams2.mDecorInsets;
                int i20 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                int i21 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(layoutParams2.mSpanIndex, layoutParams2.mSpanSize);
                if (this.mOrientation == 1) {
                    i10 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i21, ((ViewGroup.MarginLayoutParams) layoutParams2).width, false);
                    i9 = View.MeasureSpec.makeMeasureSpec(i16 - i20, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i16 - i21, 1073741824);
                    i9 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, 1073741824, i20, ((ViewGroup.MarginLayoutParams) layoutParams2).height, false);
                    i10 = makeMeasureSpec;
                }
                if (shouldReMeasureChild(view4, i10, i9, (RecyclerView.LayoutParams) view4.getLayoutParams())) {
                    view4.measure(i10, i9);
                }
            }
        }
        layoutChunkResult.mConsumed = i16;
        if (this.mOrientation != 1) {
            if (layoutState.mLayoutDirection == -1) {
                int i22 = layoutState.mOffset;
                i8 = i22 - i16;
                i7 = i22;
            } else {
                int i23 = layoutState.mOffset;
                i7 = i23 + i16;
                i8 = i23;
            }
            i6 = 0;
            i5 = 0;
        } else if (layoutState.mLayoutDirection == -1) {
            i5 = layoutState.mOffset;
            i6 = i5 - i16;
            i8 = 0;
            i7 = 0;
        } else {
            int i24 = layoutState.mOffset;
            i6 = i24;
            i7 = 0;
            i5 = i24 + i16;
            i8 = 0;
        }
        for (int i25 = 0; i25 < i13; i25++) {
            View view5 = this.mSet[i25];
            LayoutParams layoutParams3 = (LayoutParams) view5.getLayoutParams();
            if (this.mOrientation != 1) {
                i6 = getPaddingTop() + this.mCachedBorders[layoutParams3.mSpanIndex];
                i5 = this.mOrientationHelper.getDecoratedMeasurementInOther(view5) + i6;
            } else if (isLayoutRTL()) {
                i7 = this.mCachedBorders[this.mSpanCount - layoutParams3.mSpanIndex] + getPaddingLeft();
                i8 = i7 - this.mOrientationHelper.getDecoratedMeasurementInOther(view5);
            } else {
                i8 = getPaddingLeft() + this.mCachedBorders[layoutParams3.mSpanIndex];
                i7 = this.mOrientationHelper.getDecoratedMeasurementInOther(view5) + i8;
            }
            int i26 = i7;
            int i27 = i8;
            int i28 = i5;
            layoutDecoratedWithMargins(view5, i27, i6, i26, i28);
            i8 = i27;
            i7 = i26;
            i5 = i28;
            if (layoutParams3.mViewHolder.isRemoved() || layoutParams3.mViewHolder.isUpdated()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
            layoutChunkResult.mFocusable = view5.hasFocusable() | layoutChunkResult.mFocusable;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    public final void measureChild(View view, int i, boolean z) {
        int i2;
        int i3;
        boolean z2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.mDecorInsets;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(layoutParams.mSpanIndex, layoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            i2 = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i3 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i3 = childMeasureSpec;
            i2 = childMeasureSpec2;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            z2 = shouldReMeasureChild(view, i2, i3, layoutParams2);
        } else {
            z2 = shouldMeasureChild(view, i2, i3, layoutParams2);
        }
        if (z2) {
            view.measure(i2, i3);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        boolean z;
        super.onAnchorReady(recycler, state, anchorInfo, i);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.mInPreLayout) {
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            int spanIndex = getSpanIndex(anchorInfo.mPosition, recycler, state);
            if (z) {
                while (spanIndex > 0) {
                    int i2 = anchorInfo.mPosition;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    anchorInfo.mPosition = i3;
                    spanIndex = getSpanIndex(i3, recycler, state);
                }
            } else {
                int itemCount = state.getItemCount() - 1;
                int i4 = anchorInfo.mPosition;
                while (i4 < itemCount) {
                    int i5 = i4 + 1;
                    int spanIndex2 = getSpanIndex(i5, recycler, state);
                    if (spanIndex2 <= spanIndex) {
                        break;
                    }
                    i4 = i5;
                    spanIndex = spanIndex2;
                }
                anchorInfo.mPosition = i4;
            }
        }
        ensureViewSet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00d3, code lost:
        if (r13 == r4) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f3, code lost:
        if (r13 == r8) goto L66;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0111  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z;
        int i2;
        int i3;
        int i4;
        boolean z2;
        View view2;
        View view3;
        int i5;
        View view4;
        int i6;
        int i7;
        boolean z3;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        View findContainingItemView = findContainingItemView(view);
        View view5 = null;
        if (findContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        int i8 = layoutParams.mSpanIndex;
        int i9 = layoutParams.mSpanSize + i8;
        if (super.onFocusSearchFailed(view, i, recycler, state) == null) {
            return null;
        }
        if (convertFocusDirectionToLayoutDirection(i) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z != this.mShouldReverseLayout) {
            i4 = getChildCount() - 1;
            i3 = -1;
            i2 = -1;
        } else {
            i3 = getChildCount();
            i4 = 0;
            i2 = 1;
        }
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            z2 = false;
        } else {
            z2 = true;
        }
        int spanGroupIndex = getSpanGroupIndex(i4, recycler2, state2);
        int i10 = i4;
        int i11 = 0;
        int i12 = -1;
        int i13 = -1;
        int i14 = 0;
        View view6 = null;
        while (i10 != i3) {
            int spanGroupIndex2 = getSpanGroupIndex(i10, recycler2, state2);
            View childAt = getChildAt(i10);
            if (childAt == findContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || spanGroupIndex2 == spanGroupIndex) {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                int i15 = layoutParams2.mSpanIndex;
                view2 = findContainingItemView;
                int i16 = layoutParams2.mSpanSize + i15;
                if (childAt.hasFocusable() && i15 == i8 && i16 == i9) {
                    return childAt;
                }
                if ((!childAt.hasFocusable() || view5 != null) && (childAt.hasFocusable() || view6 != null)) {
                    view3 = view5;
                    int min = Math.min(i16, i9) - Math.max(i15, i8);
                    if (childAt.hasFocusable()) {
                        if (min <= i11) {
                            if (min == i11) {
                                if (i15 > i12) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            }
                        }
                    } else if (view3 == null) {
                        view4 = view6;
                        i5 = i11;
                        boolean z4 = true;
                        if (isViewPartiallyVisible(childAt, false, true)) {
                            i6 = i14;
                            if (min > i6) {
                                i7 = i13;
                            } else {
                                if (min == i6) {
                                    i7 = i13;
                                    if (i15 <= i7) {
                                        z4 = false;
                                    }
                                } else {
                                    i7 = i13;
                                }
                                i13 = i7;
                                i14 = i6;
                                view6 = view4;
                                i11 = i5;
                                view5 = view3;
                                i10 += i2;
                                recycler2 = recycler;
                                state2 = state;
                                findContainingItemView = view2;
                            }
                            if (!childAt.hasFocusable()) {
                                i13 = i7;
                                i14 = i6;
                                i12 = layoutParams2.mSpanIndex;
                                view6 = view4;
                                view5 = childAt;
                                i11 = Math.min(i16, i9) - Math.max(i15, i8);
                                i10 += i2;
                                recycler2 = recycler;
                                state2 = state;
                                findContainingItemView = view2;
                            } else {
                                int i17 = layoutParams2.mSpanIndex;
                                i14 = Math.min(i16, i9) - Math.max(i15, i8);
                                view6 = childAt;
                                i13 = i17;
                                i11 = i5;
                                view5 = view3;
                                i10 += i2;
                                recycler2 = recycler;
                                state2 = state;
                                findContainingItemView = view2;
                            }
                        }
                        i7 = i13;
                        i6 = i14;
                        i13 = i7;
                        i14 = i6;
                        view6 = view4;
                        i11 = i5;
                        view5 = view3;
                        i10 += i2;
                        recycler2 = recycler;
                        state2 = state;
                        findContainingItemView = view2;
                    }
                } else {
                    view3 = view5;
                }
                view4 = view6;
                i5 = i11;
                i7 = i13;
                i6 = i14;
                if (!childAt.hasFocusable()) {
                }
            } else if (view5 != null) {
                break;
            } else {
                view2 = findContainingItemView;
                view3 = view5;
            }
            view4 = view6;
            i5 = i11;
            i7 = i13;
            i6 = i14;
            i13 = i7;
            i14 = i6;
            view6 = view4;
            i11 = i5;
            view5 = view3;
            i10 += i2;
            recycler2 = recycler;
            state2 = state;
            findContainingItemView = view2;
        }
        View view7 = view5;
        View view8 = view6;
        if (view7 != null) {
            return view7;
        }
        return view8;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName(GridView.class.getName());
        RecyclerView.Adapter adapter = this.mRecyclerView.mAdapter;
        if (adapter != null && adapter.getItemCount() > 1) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(layoutParams2.mViewHolder.getLayoutPosition(), recycler, state);
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.mSpanIndex, layoutParams2.mSpanSize, spanGroupIndex, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(spanGroupIndex, 1, layoutParams2.mSpanIndex, layoutParams2.mSpanSize, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        zzcl zzclVar = this.mSpanSizeLookup;
        zzclVar.invalidateSpanIndexCache();
        ((SparseIntArray) zzclVar.zzc).clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsChanged(RecyclerView recyclerView) {
        zzcl zzclVar = this.mSpanSizeLookup;
        zzclVar.invalidateSpanIndexCache();
        ((SparseIntArray) zzclVar.zzc).clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        zzcl zzclVar = this.mSpanSizeLookup;
        zzclVar.invalidateSpanIndexCache();
        ((SparseIntArray) zzclVar.zzc).clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        zzcl zzclVar = this.mSpanSizeLookup;
        zzclVar.invalidateSpanIndexCache();
        ((SparseIntArray) zzclVar.zzc).clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        zzcl zzclVar = this.mSpanSizeLookup;
        zzclVar.invalidateSpanIndexCache();
        ((SparseIntArray) zzclVar.zzc).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.mInPreLayout;
        SparseIntArray sparseIntArray = this.mPreLayoutSpanIndexCache;
        SparseIntArray sparseIntArray2 = this.mPreLayoutSpanSizeCache;
        if (z) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int layoutPosition = layoutParams.mViewHolder.getLayoutPosition();
                sparseIntArray2.put(layoutPosition, layoutParams.mSpanSize);
                sparseIntArray.put(layoutPosition, layoutParams.mSpanIndex);
            }
        }
        super.onLayoutChildren(recycler, state);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutCompleted(RecyclerView.State state) {
        View findViewByPosition;
        super.onLayoutCompleted(state);
        this.mPendingSpanCountChange = false;
        int i = this.mPositionTargetedByScrollInDirection;
        if (i != -1 && (findViewByPosition = findViewByPosition(i)) != null) {
            findViewByPosition.sendAccessibilityEvent(67108864);
            this.mPositionTargetedByScrollInDirection = -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x027d  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        View view;
        RecyclerView.ViewHolder childViewHolder;
        int i2;
        int i3;
        if (i == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_IN_DIRECTION.getId() && i != -1) {
            int i4 = 0;
            while (true) {
                if (i4 >= getChildCount()) {
                    view = null;
                    break;
                }
                View childAt = getChildAt(i4);
                Objects.requireNonNull(childAt);
                if (childAt.isAccessibilityFocused()) {
                    view = getChildAt(i4);
                    break;
                }
                i4++;
            }
            if (!(view == null || bundle == null)) {
                int i5 = bundle.getInt("android.view.accessibility.action.ARGUMENT_DIRECTION_INT", -1);
                if (sSupportedDirectionsForActionScrollInDirection.contains(Integer.valueOf(i5)) && (childViewHolder = this.mRecyclerView.getChildViewHolder(view)) != null) {
                    int absoluteAdapterPosition = childViewHolder.getAbsoluteAdapterPosition();
                    int rowIndex = getRowIndex(absoluteAdapterPosition);
                    int columnIndex = getColumnIndex(absoluteAdapterPosition);
                    if (rowIndex >= 0 && columnIndex >= 0) {
                        if (!getRowIndices(absoluteAdapterPosition).contains(Integer.valueOf(this.mRowWithAccessibilityFocus)) || !getRowOrColumnIndices(getColumnIndex(absoluteAdapterPosition), absoluteAdapterPosition).contains(Integer.valueOf(this.mColumnWithAccessibilityFocus))) {
                            this.mRowWithAccessibilityFocus = rowIndex;
                            this.mColumnWithAccessibilityFocus = columnIndex;
                        }
                        int i6 = this.mRowWithAccessibilityFocus;
                        if (i6 == -1) {
                            i6 = rowIndex;
                        }
                        int i7 = this.mColumnWithAccessibilityFocus;
                        if (i7 != -1) {
                            columnIndex = i7;
                        }
                        if (i5 == 17) {
                            i2 = absoluteAdapterPosition - 1;
                            while (i2 >= 0) {
                                int rowIndex2 = getRowIndex(i2);
                                int columnIndex2 = getColumnIndex(i2);
                                if (rowIndex2 < 0 || columnIndex2 < 0) {
                                    break;
                                } else if (this.mOrientation == 1) {
                                    if ((rowIndex2 == i6 && columnIndex2 < columnIndex) || rowIndex2 < i6) {
                                        this.mRowWithAccessibilityFocus = rowIndex2;
                                        this.mColumnWithAccessibilityFocus = columnIndex2;
                                        break;
                                    }
                                    i2--;
                                } else {
                                    if (getRowIndices(i2).contains(Integer.valueOf(i6)) && columnIndex2 < columnIndex) {
                                        this.mColumnWithAccessibilityFocus = columnIndex2;
                                        break;
                                    }
                                    i2--;
                                }
                            }
                            i2 = -1;
                            if (i2 == -1) {
                            }
                            if (i2 != -1) {
                            }
                        } else if (i5 == 33) {
                            i2 = absoluteAdapterPosition - 1;
                            while (i2 >= 0) {
                                int rowIndex3 = getRowIndex(i2);
                                int columnIndex3 = getColumnIndex(i2);
                                if (rowIndex3 < 0 || columnIndex3 < 0) {
                                    break;
                                } else if (this.mOrientation == 1) {
                                    if (rowIndex3 < i6 && getRowOrColumnIndices(getColumnIndex(i2), i2).contains(Integer.valueOf(columnIndex))) {
                                        this.mRowWithAccessibilityFocus = rowIndex3;
                                        break;
                                    }
                                    i2--;
                                } else {
                                    if (rowIndex3 < i6 && columnIndex3 == columnIndex) {
                                        this.mRowWithAccessibilityFocus = ((Integer) Collections.max(getRowIndices(i2))).intValue();
                                        break;
                                    }
                                    i2--;
                                }
                            }
                            i2 = -1;
                            if (i2 == -1) {
                            }
                            if (i2 != -1) {
                            }
                        } else if (i5 == 66) {
                            i2 = absoluteAdapterPosition + 1;
                            while (i2 < getItemCount()) {
                                int rowIndex4 = getRowIndex(i2);
                                int columnIndex4 = getColumnIndex(i2);
                                if (rowIndex4 < 0 || columnIndex4 < 0) {
                                    break;
                                } else if (this.mOrientation == 1) {
                                    if ((rowIndex4 == i6 && columnIndex4 > columnIndex) || rowIndex4 > i6) {
                                        this.mRowWithAccessibilityFocus = rowIndex4;
                                        this.mColumnWithAccessibilityFocus = columnIndex4;
                                        break;
                                    }
                                    i2++;
                                } else {
                                    if (columnIndex4 > columnIndex && getRowIndices(i2).contains(Integer.valueOf(i6))) {
                                        this.mColumnWithAccessibilityFocus = columnIndex4;
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            i2 = -1;
                            if (i2 == -1) {
                                if (i5 != 17) {
                                }
                            }
                            if (i2 != -1) {
                            }
                        } else if (i5 == 130) {
                            i2 = absoluteAdapterPosition + 1;
                            while (i2 < getItemCount()) {
                                int rowIndex5 = getRowIndex(i2);
                                int columnIndex5 = getColumnIndex(i2);
                                if (rowIndex5 < 0 || columnIndex5 < 0) {
                                    break;
                                } else if (this.mOrientation == 1) {
                                    if (rowIndex5 > i6 && (columnIndex5 == columnIndex || getRowOrColumnIndices(getColumnIndex(i2), i2).contains(Integer.valueOf(columnIndex)))) {
                                        this.mRowWithAccessibilityFocus = rowIndex5;
                                        break;
                                    }
                                    i2++;
                                } else {
                                    if (rowIndex5 > i6 && columnIndex5 == columnIndex) {
                                        this.mRowWithAccessibilityFocus = getRowIndex(i2);
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            i2 = -1;
                            if (i2 == -1 && (i3 = this.mOrientation) == 0) {
                                if (i5 != 17) {
                                    if (rowIndex >= 0 && i3 != 1) {
                                        TreeMap treeMap = new TreeMap(Collections.reverseOrder());
                                        int i8 = 0;
                                        loop5: while (true) {
                                            if (i8 >= getItemCount()) {
                                                for (Integer num : treeMap.keySet()) {
                                                    int intValue = num.intValue();
                                                    if (intValue < rowIndex) {
                                                        i2 = ((Integer) treeMap.get(num)).intValue();
                                                        this.mRowWithAccessibilityFocus = intValue;
                                                        this.mColumnWithAccessibilityFocus = getColumnIndex(i2);
                                                        break;
                                                    }
                                                }
                                            } else {
                                                Iterator it = getRowIndices(i8).iterator();
                                                while (it.hasNext()) {
                                                    Integer num2 = (Integer) it.next();
                                                    if (num2.intValue() < 0) {
                                                        break loop5;
                                                    }
                                                    treeMap.put(num2, Integer.valueOf(i8));
                                                }
                                                i8++;
                                            }
                                        }
                                    }
                                    i2 = -1;
                                } else if (i5 == 66) {
                                    if (rowIndex >= 0 && i3 != 1) {
                                        TreeMap treeMap2 = new TreeMap();
                                        int i9 = 0;
                                        loop8: while (true) {
                                            if (i9 >= getItemCount()) {
                                                for (Integer num3 : treeMap2.keySet()) {
                                                    int intValue2 = num3.intValue();
                                                    if (intValue2 > rowIndex) {
                                                        i2 = ((Integer) treeMap2.get(num3)).intValue();
                                                        this.mRowWithAccessibilityFocus = intValue2;
                                                        this.mColumnWithAccessibilityFocus = 0;
                                                        break;
                                                    }
                                                }
                                            } else {
                                                Iterator it2 = getRowIndices(i9).iterator();
                                                while (it2.hasNext()) {
                                                    Integer num4 = (Integer) it2.next();
                                                    if (num4.intValue() < 0) {
                                                        break loop8;
                                                    } else if (!treeMap2.containsKey(num4)) {
                                                        treeMap2.put(num4, Integer.valueOf(i9));
                                                    }
                                                }
                                                i9++;
                                            }
                                        }
                                    }
                                    i2 = -1;
                                }
                            }
                            if (i2 != -1) {
                                scrollToPosition(i2);
                                this.mPositionTargetedByScrollInDirection = i2;
                                return true;
                            }
                        }
                    }
                }
            }
        } else if (i != 16908343 || bundle == null) {
            return super.performAccessibilityAction(i, bundle);
        } else {
            int i10 = bundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT", -1);
            int i11 = bundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT", -1);
            if (!(i10 == -1 || i11 == -1)) {
                int itemCount = this.mRecyclerView.mAdapter.getItemCount();
                int i12 = 0;
                while (true) {
                    if (i12 >= itemCount) {
                        i12 = -1;
                        break;
                    }
                    RecyclerView recyclerView = this.mRecyclerView;
                    int spanIndex = getSpanIndex(i12, recyclerView.mRecycler, recyclerView.mState);
                    RecyclerView recyclerView2 = this.mRecyclerView;
                    int spanGroupIndex = getSpanGroupIndex(i12, recyclerView2.mRecycler, recyclerView2.mState);
                    if (this.mOrientation == 1) {
                        if (spanIndex == i11 && spanGroupIndex == i10) {
                            break;
                        }
                        i12++;
                    } else {
                        if (spanIndex == i10 && spanGroupIndex == i11) {
                            break;
                        }
                        i12++;
                    }
                }
                if (i12 > -1) {
                    scrollToPositionWithOffset(i12, 0);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            i3 = RecyclerView.LayoutManager.chooseSize(i, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            i3 = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            i4 = RecyclerView.LayoutManager.chooseSize(i2, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public final void setSpanCount(int i) {
        if (i != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i >= 1) {
                this.mSpanCount = i;
                this.mSpanSizeLookup.invalidateSpanIndexCache();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m604m(i, "Span count should be at least 1. Provided "));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState != null || this.mPendingSpanCountChange) {
            return false;
        }
        return true;
    }

    public final void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.recyclerview.widget.GridLayoutManager$LayoutParams, androidx.recyclerview.widget.RecyclerView$LayoutParams] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.recyclerview.widget.GridLayoutManager$LayoutParams, androidx.recyclerview.widget.RecyclerView$LayoutParams] */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ?? layoutParams2 = new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            layoutParams2.mSpanIndex = -1;
            layoutParams2.mSpanSize = 0;
            return layoutParams2;
        }
        ?? layoutParams3 = new RecyclerView.LayoutParams(layoutParams);
        layoutParams3.mSpanIndex = -1;
        layoutParams3.mSpanSize = 0;
        return layoutParams3;
    }

    public GridLayoutManager(int i) {
        super(1);
        setSpanCount(i);
    }
}
