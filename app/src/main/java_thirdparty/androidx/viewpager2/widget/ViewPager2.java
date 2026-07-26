package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.provider.CallbackWithHandler$2;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.emoji2.text.MetadataRepo;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.R$styleable;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ScrollEventAdapter;
import com.emanuelef.remote_capture.CaptureService;
import com.google.android.material.snackbar.SnackbarManager;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public final MetadataRepo mAccessibilityProvider;
    public int mCurrentItem;
    public final CompositeOnPageChangeCallback mExternalPageChangeCallbacks;
    public final FakeDrag mFakeDragger;
    public final LinearLayoutManagerImpl mLayoutManager;
    public final CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    public final PageTransformerAdapter mPageTransformerAdapter;
    public final PagerSnapHelperImpl mPagerSnapHelper;
    public Parcelable mPendingAdapterState;
    public final RecyclerViewImpl mRecyclerView;
    public final ScrollEventAdapter mScrollEventAdapter;
    public final Rect mTmpContainerRect = new Rect();
    public final Rect mTmpChildRect = new Rect();
    public boolean mCurrentItemDirty = false;
    public final AnonymousClass1 mCurrentItemDataSetChangeObserver = new RecyclerView.AdapterDataObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            switch (r1) {
                case 0:
                    ViewPager2 viewPager2 = (ViewPager2) this;
                    viewPager2.mCurrentItemDirty = true;
                    viewPager2.mScrollEventAdapter.mDataSetChangeHappened = true;
                    return;
                default:
                    ((MetadataRepo) this).updatePageAccessibilityActions();
                    return;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }
    };
    public int mPendingCurrentItem = -1;
    public RecyclerView.ItemAnimator mSavedItemAnimator = null;
    public boolean mSavedItemAnimatorPresent = false;
    public boolean mUserInputEnabled = true;
    public int mOffscreenPageLimit = -1;

    /* renamed from: androidx.viewpager2.widget.ViewPager2$4  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass4 implements RecyclerView.OnChildAttachStateChangeListener {
    }

    /* loaded from: classes.dex */
    public final class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl() {
            super(1);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            ViewPager2 viewPager2 = ViewPager2.this;
            int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.mAccessibilityProvider.getClass();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i;
            int i2;
            ViewPager2 viewPager2 = (ViewPager2) ViewPager2.this.mAccessibilityProvider.mTypeface;
            if (viewPager2.getOrientation() == 1) {
                i = viewPager2.mLayoutManager.getPosition(view);
            } else {
                i = 0;
            }
            if (viewPager2.getOrientation() == 0) {
                i2 = viewPager2.mLayoutManager.getPosition(view);
            } else {
                i2 = 0;
            }
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, i2, 1, false, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i, Bundle bundle) {
            ViewPager2.this.mAccessibilityProvider.getClass();
            return super.performAccessibilityAction(recycler, state, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public abstract void onPageSelected(int i);
    }

    /* loaded from: classes.dex */
    public interface PageTransformer {
    }

    /* loaded from: classes.dex */
    public final class PagerSnapHelperImpl extends PagerSnapHelper {
        public PagerSnapHelperImpl() {
        }

        @Override // androidx.recyclerview.widget.PagerSnapHelper
        public final View findSnapView(RecyclerView.LayoutManager layoutManager) {
            Object obj = ViewPager2.this.mFakeDragger.mScrollEventAdapter;
            return super.findSnapView(layoutManager);
        }
    }

    /* loaded from: classes.dex */
    public final class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public final CharSequence getAccessibilityClassName() {
            ViewPager2.this.mAccessibilityProvider.getClass();
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            ViewPager2 viewPager2 = ViewPager2.this;
            accessibilityEvent.setFromIndex(viewPager2.mCurrentItem);
            accessibilityEvent.setToIndex(viewPager2.mCurrentItem);
            accessibilityEvent.setSource((ViewPager2) viewPager2.mAccessibilityProvider.mTypeface);
            accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!ViewPager2.this.mUserInputEnabled || !super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            if (!ViewPager2.this.mUserInputEnabled || !super.onTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.AnonymousClass2(8);
        public Parcelable mAdapterState;
        public int mCurrentItem;
        public int mRecyclerViewId;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mRecyclerViewId = parcel.readInt();
            this.mCurrentItem = parcel.readInt();
            this.mAdapterState = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mRecyclerViewId);
            parcel.writeInt(this.mCurrentItem);
            parcel.writeParcelable(this.mAdapterState, i);
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v20, types: [androidx.viewpager2.widget.PageTransformerAdapter, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2, types: [androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.viewpager2.widget.ViewPager2$1] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, androidx.emoji2.text.MetadataRepo] */
    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback();
        this.mExternalPageChangeCallbacks = compositeOnPageChangeCallback;
        final ?? obj = new Object();
        obj.mTypeface = this;
        obj.mMetadataList = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$1
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean perform(View view) {
                switch (r2) {
                    case 0:
                        int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
                        ViewPager2 viewPager2 = (ViewPager2) obj.mTypeface;
                        if (viewPager2.mUserInputEnabled) {
                            viewPager2.setCurrentItemInternal(currentItem, true);
                        }
                        return true;
                    default:
                        int currentItem2 = ((ViewPager2) view).getCurrentItem() - 1;
                        ViewPager2 viewPager22 = (ViewPager2) obj.mTypeface;
                        if (viewPager22.mUserInputEnabled) {
                            viewPager22.setCurrentItemInternal(currentItem2, true);
                        }
                        return true;
                }
            }
        };
        obj.mEmojiCharArray = new AccessibilityViewCommand() { // from class: androidx.viewpager2.widget.ViewPager2$PageAwareAccessibilityProvider$1
            @Override // androidx.core.view.accessibility.AccessibilityViewCommand
            public final boolean perform(View view) {
                switch (r2) {
                    case 0:
                        int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
                        ViewPager2 viewPager2 = (ViewPager2) obj.mTypeface;
                        if (viewPager2.mUserInputEnabled) {
                            viewPager2.setCurrentItemInternal(currentItem, true);
                        }
                        return true;
                    default:
                        int currentItem2 = ((ViewPager2) view).getCurrentItem() - 1;
                        ViewPager2 viewPager22 = (ViewPager2) obj.mTypeface;
                        if (viewPager22.mUserInputEnabled) {
                            viewPager22.setCurrentItemInternal(currentItem2, true);
                        }
                        return true;
                }
            }
        };
        this.mAccessibilityProvider = obj;
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.mRecyclerView = recyclerViewImpl;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        recyclerViewImpl.setId(View.generateViewId());
        this.mRecyclerView.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl();
        this.mLayoutManager = linearLayoutManagerImpl;
        this.mRecyclerView.setLayoutManager(linearLayoutManagerImpl);
        this.mRecyclerView.setScrollingTouchSlop(1);
        int[] iArr = R$styleable.ViewPager2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, 0);
        try {
            setOrientation(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
            this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.mRecyclerView.addOnChildAttachStateChangeListener(new Object());
            ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
            this.mScrollEventAdapter = scrollEventAdapter;
            this.mFakeDragger = new FakeDrag(0, scrollEventAdapter);
            PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
            this.mPagerSnapHelper = pagerSnapHelperImpl;
            pagerSnapHelperImpl.attachToRecyclerView(this.mRecyclerView);
            this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
            CompositeOnPageChangeCallback compositeOnPageChangeCallback2 = new CompositeOnPageChangeCallback();
            this.mPageChangeEventDispatcher = compositeOnPageChangeCallback2;
            this.mScrollEventAdapter.mCallback = compositeOnPageChangeCallback2;
            OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback(this) { // from class: androidx.viewpager2.widget.ViewPager2.2
                public final /* synthetic */ ViewPager2 this$0;

                {
                    this.this$0 = this;
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i) {
                    switch (r2) {
                        case 0:
                            if (i == 0) {
                                this.this$0.updateCurrentItem();
                                return;
                            }
                            return;
                        default:
                            super.onPageScrollStateChanged(i);
                            return;
                    }
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public final void onPageSelected(int i) {
                    switch (r2) {
                        case 0:
                            ViewPager2 viewPager2 = this.this$0;
                            if (viewPager2.mCurrentItem != i) {
                                viewPager2.mCurrentItem = i;
                                viewPager2.mAccessibilityProvider.updatePageAccessibilityActions();
                                return;
                            }
                            return;
                        default:
                            ViewPager2 viewPager22 = this.this$0;
                            viewPager22.clearFocus();
                            if (viewPager22.hasFocus()) {
                                viewPager22.mRecyclerView.requestFocus(2);
                                return;
                            }
                            return;
                    }
                }
            };
            OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback(this) { // from class: androidx.viewpager2.widget.ViewPager2.2
                public final /* synthetic */ ViewPager2 this$0;

                {
                    this.this$0 = this;
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageScrollStateChanged(int i) {
                    switch (r2) {
                        case 0:
                            if (i == 0) {
                                this.this$0.updateCurrentItem();
                                return;
                            }
                            return;
                        default:
                            super.onPageScrollStateChanged(i);
                            return;
                    }
                }

                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public final void onPageSelected(int i) {
                    switch (r2) {
                        case 0:
                            ViewPager2 viewPager2 = this.this$0;
                            if (viewPager2.mCurrentItem != i) {
                                viewPager2.mCurrentItem = i;
                                viewPager2.mAccessibilityProvider.updatePageAccessibilityActions();
                                return;
                            }
                            return;
                        default:
                            ViewPager2 viewPager22 = this.this$0;
                            viewPager22.clearFocus();
                            if (viewPager22.hasFocus()) {
                                viewPager22.mRecyclerView.requestFocus(2);
                                return;
                            }
                            return;
                    }
                }
            };
            ((ArrayList) compositeOnPageChangeCallback2.mCallbacks).add(onPageChangeCallback);
            ((ArrayList) this.mPageChangeEventDispatcher.mCallbacks).add(onPageChangeCallback2);
            final MetadataRepo metadataRepo = this.mAccessibilityProvider;
            RecyclerViewImpl recyclerViewImpl2 = this.mRecyclerView;
            metadataRepo.getClass();
            recyclerViewImpl2.setImportantForAccessibility(2);
            metadataRepo.mRootNode = new RecyclerView.AdapterDataObserver() { // from class: androidx.viewpager2.widget.ViewPager2.1
                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public final void onChanged() {
                    switch (r1) {
                        case 0:
                            ViewPager2 viewPager2 = (ViewPager2) metadataRepo;
                            viewPager2.mCurrentItemDirty = true;
                            viewPager2.mScrollEventAdapter.mDataSetChangeHappened = true;
                            return;
                        default:
                            ((MetadataRepo) metadataRepo).updatePageAccessibilityActions();
                            return;
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public final void onItemRangeChanged(int i, int i2) {
                    onChanged();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public final void onItemRangeInserted(int i, int i2) {
                    onChanged();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public final void onItemRangeMoved(int i, int i2, int i3) {
                    onChanged();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public final void onItemRangeRemoved(int i, int i2) {
                    onChanged();
                }

                @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
                public final void onItemRangeChanged(int i, int i2, Object obj2) {
                    onChanged();
                }
            };
            ViewPager2 viewPager2 = (ViewPager2) metadataRepo.mTypeface;
            if (viewPager2.getImportantForAccessibility() == 0) {
                viewPager2.setImportantForAccessibility(1);
            }
            ((ArrayList) this.mPageChangeEventDispatcher.mCallbacks).add(compositeOnPageChangeCallback);
            ?? obj2 = new Object();
            this.mPageTransformerAdapter = obj2;
            ((ArrayList) this.mPageChangeEventDispatcher.mCallbacks).add(obj2);
            RecyclerViewImpl recyclerViewImpl3 = this.mRecyclerView;
            attachViewToParent(recyclerViewImpl3, 0, recyclerViewImpl3.getLayoutParams());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.mRecyclerView.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return this.mRecyclerView.canScrollVertically(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i = ((SavedState) parcelable).mRecyclerViewId;
            sparseArray.put(this.mRecyclerView.getId(), (Parcelable) sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        restorePendingState();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        this.mAccessibilityProvider.getClass();
        this.mAccessibilityProvider.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    public RecyclerView.Adapter getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        if (this.mLayoutManager.getOrientation() == 1) {
            return 1;
        }
        return 0;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        int orientation = getOrientation();
        RecyclerViewImpl recyclerViewImpl = this.mRecyclerView;
        if (orientation == 0) {
            height = recyclerViewImpl.getWidth() - recyclerViewImpl.getPaddingLeft();
            paddingBottom = recyclerViewImpl.getPaddingRight();
        } else {
            height = recyclerViewImpl.getHeight() - recyclerViewImpl.getPaddingTop();
            paddingBottom = recyclerViewImpl.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.mScrollState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        int i2;
        int itemCount;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ViewPager2 viewPager2 = (ViewPager2) this.mAccessibilityProvider.mTypeface;
        if (viewPager2.getAdapter() == null) {
            i2 = 0;
            i = 0;
        } else if (viewPager2.getOrientation() == 1) {
            i2 = viewPager2.getAdapter().getItemCount();
            i = 1;
        } else {
            i = viewPager2.getAdapter().getItemCount();
            i2 = 1;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) SnackbarManager.obtain(i2, i, 0, false).lock);
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && viewPager2.mUserInputEnabled) {
            if (viewPager2.mCurrentItem > 0) {
                accessibilityNodeInfo.addAction(CaptureService.CONNECTIONS_LOG_SIZE);
            }
            if (viewPager2.mCurrentItem < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.mTmpContainerRect;
        rect.left = paddingLeft;
        rect.right = (i3 - i) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i4 - i2) - getPaddingBottom();
        Rect rect2 = this.mTmpChildRect;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.mRecyclerView.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.mCurrentItemDirty) {
            updateCurrentItem();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        measureChild(this.mRecyclerView, i, i2);
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        int measuredState = this.mRecyclerView.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingTop = getPaddingTop();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, measuredState), View.resolveSizeAndState(Math.max(getPaddingBottom() + paddingTop + measuredHeight, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mPendingCurrentItem = savedState.mCurrentItem;
        this.mPendingAdapterState = savedState.mAdapterState;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View$BaseSavedState, android.os.Parcelable, androidx.viewpager2.widget.ViewPager2$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        ?? baseSavedState = new View.BaseSavedState(super.onSaveInstanceState());
        baseSavedState.mRecyclerViewId = this.mRecyclerView.getId();
        int i = this.mPendingCurrentItem;
        if (i == -1) {
            i = this.mCurrentItem;
        }
        baseSavedState.mCurrentItem = i;
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            baseSavedState.mAdapterState = parcelable;
            return baseSavedState;
        }
        RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        if (adapter instanceof FragmentStateAdapter) {
            baseSavedState.mAdapterState = ((FragmentStateAdapter) adapter).saveState();
        }
        return baseSavedState;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        int i2;
        this.mAccessibilityProvider.getClass();
        if (i != 8192 && i != 4096) {
            return super.performAccessibilityAction(i, bundle);
        }
        MetadataRepo metadataRepo = this.mAccessibilityProvider;
        ViewPager2 viewPager2 = (ViewPager2) metadataRepo.mTypeface;
        if (i == 8192 || i == 4096) {
            if (i == 8192) {
                i2 = viewPager2.getCurrentItem() - 1;
            } else {
                i2 = viewPager2.getCurrentItem() + 1;
            }
            ViewPager2 viewPager22 = (ViewPager2) metadataRepo.mTypeface;
            if (viewPager22.mUserInputEnabled) {
                viewPager22.setCurrentItemInternal(i2, true);
            }
            return true;
        }
        throw new IllegalStateException();
    }

    public final void restorePendingState() {
        RecyclerView.Adapter adapter;
        if (this.mPendingCurrentItem != -1 && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.mPendingAdapterState;
            if (parcelable != null) {
                if (adapter instanceof FragmentStateAdapter) {
                    ((FragmentStateAdapter) adapter).restoreState(parcelable);
                }
                this.mPendingAdapterState = null;
            }
            int max = Math.max(0, Math.min(this.mPendingCurrentItem, adapter.getItemCount() - 1));
            this.mCurrentItem = max;
            this.mPendingCurrentItem = -1;
            this.mRecyclerView.scrollToPosition(max);
            this.mAccessibilityProvider.updatePageAccessibilityActions();
        }
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.mRecyclerView.getAdapter();
        MetadataRepo metadataRepo = this.mAccessibilityProvider;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver((AnonymousClass1) metadataRepo.mRootNode);
        } else {
            metadataRepo.getClass();
        }
        AnonymousClass1 r1 = this.mCurrentItemDataSetChangeObserver;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(r1);
        }
        this.mRecyclerView.setAdapter(adapter);
        this.mCurrentItem = 0;
        restorePendingState();
        MetadataRepo metadataRepo2 = this.mAccessibilityProvider;
        metadataRepo2.updatePageAccessibilityActions();
        if (adapter != null) {
            adapter.registerAdapterDataObserver((AnonymousClass1) metadataRepo2.mRootNode);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(r1);
        }
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public final void setCurrentItemInternal(int i, boolean z) {
        int i2;
        int i3;
        CompositeOnPageChangeCallback compositeOnPageChangeCallback;
        RecyclerView.Adapter adapter = getAdapter();
        boolean z2 = false;
        if (adapter == null) {
            if (this.mPendingCurrentItem != -1) {
                this.mPendingCurrentItem = Math.max(i, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i, 0), adapter.getItemCount() - 1);
            int i4 = this.mCurrentItem;
            if (min != i4 || this.mScrollEventAdapter.mScrollState != 0) {
                if (min != i4 || !z) {
                    double d = i4;
                    this.mCurrentItem = min;
                    this.mAccessibilityProvider.updatePageAccessibilityActions();
                    ScrollEventAdapter scrollEventAdapter = this.mScrollEventAdapter;
                    if (scrollEventAdapter.mScrollState != 0) {
                        scrollEventAdapter.updateScrollEventValues();
                        ScrollEventAdapter.ScrollEventValues scrollEventValues = scrollEventAdapter.mScrollValues;
                        d = scrollEventValues.mPosition + scrollEventValues.mOffset;
                    }
                    ScrollEventAdapter scrollEventAdapter2 = this.mScrollEventAdapter;
                    scrollEventAdapter2.getClass();
                    if (z) {
                        i2 = 2;
                    } else {
                        i2 = 3;
                    }
                    scrollEventAdapter2.mAdapterState = i2;
                    if (scrollEventAdapter2.mTarget != min) {
                        z2 = true;
                    }
                    scrollEventAdapter2.mTarget = min;
                    scrollEventAdapter2.dispatchStateChanged(2);
                    if (z2 && (compositeOnPageChangeCallback = scrollEventAdapter2.mCallback) != null) {
                        compositeOnPageChangeCallback.onPageSelected(min);
                    }
                    if (!z) {
                        this.mRecyclerView.scrollToPosition(min);
                        return;
                    }
                    double d2 = min;
                    if (Math.abs(d2 - d) > 3.0d) {
                        if (d2 > d) {
                            i3 = min - 3;
                        } else {
                            i3 = min + 3;
                        }
                        this.mRecyclerView.scrollToPosition(i3);
                        RecyclerViewImpl recyclerViewImpl = this.mRecyclerView;
                        recyclerViewImpl.post(new CallbackWithHandler$2(min, recyclerViewImpl));
                        return;
                    }
                    this.mRecyclerView.smoothScrollToPosition(min);
                }
            }
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.mAccessibilityProvider.updatePageAccessibilityActions();
    }

    public void setOffscreenPageLimit(int i) {
        if (i >= 1 || i == -1) {
            this.mOffscreenPageLimit = i;
            this.mRecyclerView.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i) {
        this.mLayoutManager.setOrientation(i);
        this.mAccessibilityProvider.updatePageAccessibilityActions();
    }

    public void setPageTransformer(PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.mSavedItemAnimatorPresent) {
                this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
                this.mSavedItemAnimatorPresent = true;
            }
            this.mRecyclerView.setItemAnimator(null);
        } else if (this.mSavedItemAnimatorPresent) {
            this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
            this.mSavedItemAnimator = null;
            this.mSavedItemAnimatorPresent = false;
        }
        this.mPageTransformerAdapter.getClass();
        if (pageTransformer != null) {
            this.mPageTransformerAdapter.getClass();
            this.mPageTransformerAdapter.getClass();
        }
    }

    public void setUserInputEnabled(boolean z) {
        this.mUserInputEnabled = z;
        this.mAccessibilityProvider.updatePageAccessibilityActions();
    }

    public final void updateCurrentItem() {
        PagerSnapHelperImpl pagerSnapHelperImpl = this.mPagerSnapHelper;
        if (pagerSnapHelperImpl != null) {
            View findSnapView = pagerSnapHelperImpl.findSnapView(this.mLayoutManager);
            if (findSnapView != null) {
                int position = this.mLayoutManager.getPosition(findSnapView);
                if (position != this.mCurrentItem && getScrollState() == 0) {
                    this.mPageChangeEventDispatcher.onPageSelected(position);
                }
                this.mCurrentItemDirty = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public final void setCurrentItem(int i, boolean z) {
        Object obj = this.mFakeDragger.mScrollEventAdapter;
        setCurrentItemInternal(i, z);
    }
}
