package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.BundleKt;
import androidx.core.os.TraceCompat;
import androidx.core.util.TimeUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.poolingcontainer.PoolingContainerListenerHolder;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.AdapterHelper;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewInfoStore;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.R;
import com.google.android.material.snackbar.SnackbarManager;
import j$.util.DesugarCollections;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.collections.CollectionsKt__CollectionsKt;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements NestedScrollingChild {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final String LOW_RES_ROTARY_ENCODER_FEATURE = "android.hardware.rotaryencoder.lowres";
    static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    private static final float SCROLL_FRICTION = 0.015f;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static boolean sDebugAssertionsEnabled = false;
    static final StretchEdgeEffectFactory sDefaultEdgeEffectFactory;
    static final Interpolator sQuinticInterpolator;
    static boolean sVerboseLoggingEnabled = false;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    DifferentialMotionFlingController mDifferentialMotionFlingController;
    private final DifferentialMotionFlingTarget mDifferentialMotionFlingTarget;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    boolean mLowResRotaryEncoderFeature;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final List<RecyclerListener> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    float mScaledHorizontalScrollFactor;
    float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    private static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$5  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass5 implements DifferentialMotionFlingTarget, ViewInfoStore.ProcessCallback, ItemAnimator.ItemAnimatorListener {
        public /* synthetic */ AnonymousClass5() {
        }

        public void dispatchUpdate(AdapterHelper.UpdateOp updateOp) {
            int i = updateOp.cmd;
            RecyclerView recyclerView = RecyclerView.this;
            if (i == 1) {
                recyclerView.mLayout.onItemsAdded(recyclerView, updateOp.positionStart, updateOp.itemCount);
            } else if (i == 2) {
                recyclerView.mLayout.onItemsRemoved(recyclerView, updateOp.positionStart, updateOp.itemCount);
            } else if (i == 4) {
                recyclerView.mLayout.onItemsUpdated(recyclerView, updateOp.positionStart, updateOp.itemCount, updateOp.payload);
            } else if (i == 8) {
                recyclerView.mLayout.onItemsMoved(recyclerView, updateOp.positionStart, updateOp.itemCount, 1);
            }
        }

        public ViewHolder findViewHolder(int i) {
            RecyclerView recyclerView = RecyclerView.this;
            ViewHolder findViewHolderForPosition = recyclerView.findViewHolderForPosition(i, true);
            if (findViewHolderForPosition != null) {
                ChildHelper childHelper = recyclerView.mChildHelper;
                if (!childHelper.mHiddenViews.contains(findViewHolderForPosition.itemView)) {
                    return findViewHolderForPosition;
                }
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "assuming view holder cannot be find because it is hidden");
                }
            }
            return null;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public float getScaledScrollFactor() {
            float f;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout.canScrollVertically()) {
                f = recyclerView.mScaledVerticalScrollFactor;
            } else if (!recyclerView.mLayout.canScrollHorizontally()) {
                return RecyclerView.DECELERATION_RATE;
            } else {
                f = recyclerView.mScaledHorizontalScrollFactor;
            }
            return -f;
        }

        public void removeViewAt(int i) {
            RecyclerView recyclerView = RecyclerView.this;
            View childAt = recyclerView.getChildAt(i);
            if (childAt != null) {
                recyclerView.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            recyclerView.removeViewAt(i);
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public boolean startDifferentialMotionFling(float f) {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout.canScrollVertically()) {
                i2 = (int) f;
                i = 0;
            } else {
                if (recyclerView.mLayout.canScrollHorizontally()) {
                    i = (int) f;
                } else {
                    i = 0;
                }
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            recyclerView.stopScroll();
            return recyclerView.flingNoThresholdCheck(i, i2);
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public void stopDifferentialMotionFling() {
            RecyclerView.this.stopScroll();
        }
    }

    /* loaded from: classes.dex */
    public final class AdapterDataObservable extends Observable {
        public final boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public final void notifyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        public final void notifyItemMoved(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }

        public final void notifyStateRestorationPolicyChanged() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AdapterDataObserver) ((Observable) this).mObservers.get(size)).onStateRestorationPolicyChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class AdapterDataObserver {
        public abstract void onChanged();

        public void onItemRangeChanged(int i, int i2) {
        }

        public abstract void onItemRangeInserted(int i, int i2);

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public abstract void onItemRangeRemoved(int i, int i2);

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api35Impl {
        public static void setFrameContentVelocity(View view, float f) {
            try {
                view.setFrameContentVelocity(f);
            } catch (LinkageError unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface ChildDrawingOrderCallback {
    }

    /* loaded from: classes.dex */
    public abstract class EdgeEffectFactory {
    }

    /* loaded from: classes.dex */
    public abstract class ItemAnimator {
        public long mAddDuration;
        public long mChangeDuration;
        public ArrayList mFinishedListeners;
        public ItemAnimatorListener mListener;
        public long mMoveDuration;
        public long mRemoveDuration;

        /* loaded from: classes.dex */
        public interface ItemAnimatorListener {
        }

        /* loaded from: classes.dex */
        public final class ItemHolderInfo {
            public int left;
            public int top;

            public final void setFrom(ViewHolder viewHolder) {
                View view = viewHolder.itemView;
                this.left = view.getLeft();
                this.top = view.getTop();
                view.getRight();
                view.getBottom();
            }
        }

        public static void buildAdapterChangeFlagsForAnimations(ViewHolder viewHolder) {
            int i = viewHolder.mFlags;
            if (!viewHolder.isInvalid() && (i & 4) == 0) {
                viewHolder.getOldPosition();
                viewHolder.getAbsoluteAdapterPosition();
            }
        }

        public abstract boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, ItemHolderInfo itemHolderInfo, ItemHolderInfo itemHolderInfo2);

        public final void dispatchAnimationFinished(ViewHolder viewHolder) {
            ItemAnimatorListener itemAnimatorListener = this.mListener;
            if (itemAnimatorListener != null) {
                RecyclerView recyclerView = RecyclerView.this;
                viewHolder.setIsRecyclable(true);
                if (viewHolder.mShadowedHolder != null && viewHolder.mShadowingHolder == null) {
                    viewHolder.mShadowedHolder = null;
                }
                viewHolder.mShadowingHolder = null;
                if (!viewHolder.shouldBeKeptAsChild() && !recyclerView.removeAnimatingView(viewHolder.itemView) && viewHolder.isTmpDetached()) {
                    recyclerView.removeDetachedView(viewHolder.itemView, false);
                }
            }
        }

        public abstract void endAnimation(ViewHolder viewHolder);

        public abstract void endAnimations();

        public abstract boolean isRunning();
    }

    /* loaded from: classes.dex */
    public abstract class LayoutManager {
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;
        boolean mRequestedSimpleAnimations = false;
        boolean mIsAttachedToWindow = false;
        boolean mAutoMeasure = false;
        private boolean mMeasurementCacheEnabled = true;
        private boolean mItemPrefetchEnabled = true;

        /* loaded from: classes.dex */
        public interface LayoutPrefetchRegistry {
        }

        /* loaded from: classes.dex */
        public final class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;
        }

        public LayoutManager() {
            OpReorderer opReorderer = new OpReorderer(1, this);
            this.mHorizontalBoundCheckCallback = opReorderer;
            OpReorderer opReorderer2 = new OpReorderer(2, this);
            this.mVerticalBoundCheckCallback = opReorderer2;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(opReorderer);
            this.mVerticalBoundCheck = new ViewBoundsCheck(opReorderer2);
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(size, Math.max(i2, i3));
            }
            if (mode != 1073741824) {
                return Math.max(i2, i3);
            }
            return size;
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
            if (r3 >= 0) goto L5;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto L11
                if (r3 < 0) goto Lf
            Lc:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L21
            Lf:
                r3 = 0
                goto L21
            L11:
                if (r3 < 0) goto L14
                goto Lc
            L14:
                r4 = -1
                if (r3 != r4) goto L1b
                r2 = 1073741824(0x40000000, float:2.0)
            L19:
                r3 = r1
                goto L21
            L1b:
                r4 = -2
                if (r3 != r4) goto Lf
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L19
            L21:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, boolean):int");
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.RecyclerView$LayoutManager$Properties, java.lang.Object] */
        public static Properties getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            ?? obj = new Object();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i, i2);
            obj.orientation = obtainStyledAttributes.getInt(0, 1);
            obj.spanCount = obtainStyledAttributes.getInt(10, 1);
            obj.reverseLayout = obtainStyledAttributes.getBoolean(9, false);
            obj.stackFromEnd = obtainStyledAttributes.getBoolean(11, false);
            obtainStyledAttributes.recycle();
            return obj;
        }

        public static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode != Integer.MIN_VALUE) {
                if (mode == 0) {
                    return true;
                }
                if (mode == 1073741824 && size == i) {
                    return true;
                }
                return false;
            } else if (size >= i) {
                return true;
            } else {
                return false;
            }
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view) {
            addView(view, -1);
        }

        public final void addViewInt(View view, int i, boolean z) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                SimpleArrayMap simpleArrayMap = this.mRecyclerView.mViewInfoStore.mLayoutHolderMap;
                ViewInfoStore.InfoRecord infoRecord = (ViewInfoStore.InfoRecord) simpleArrayMap.get(childViewHolderInt);
                if (infoRecord == null) {
                    infoRecord = ViewInfoStore.InfoRecord.obtain();
                    simpleArrayMap.put(childViewHolderInt, infoRecord);
                }
                infoRecord.flags |= 1;
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.attachViewToParent(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int indexOfChild = this.mChildHelper.indexOfChild(view);
                if (i == -1) {
                    i = this.mChildHelper.getChildCount();
                }
                if (indexOfChild == -1) {
                    StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sb.append(this.mRecyclerView.indexOfChild(view));
                    throw new IllegalStateException(ViewModelProvider.Factory.CC.m(this.mRecyclerView, sb));
                } else if (indexOfChild != i) {
                    this.mRecyclerView.mLayout.moveView(indexOfChild, i);
                }
            } else {
                this.mChildHelper.addView(view, i, false);
                layoutParams.mInsetsDirty = true;
                SmoothScroller smoothScroller = this.mSmoothScroller;
                if (smoothScroller != null && smoothScroller.mRunning && smoothScroller.mRecyclerView.getChildLayoutPosition(view) == smoothScroller.mTargetPosition) {
                    smoothScroller.mTargetView = view;
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "smooth scroll target view has been attached");
                    }
                }
            }
            if (layoutParams.mPendingInvalidate) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "consuming pending invalidate on child " + layoutParams.mViewHolder);
                }
                childViewHolderInt.itemView.invalidate();
                layoutParams.mPendingInvalidate = false;
            }
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                SimpleArrayMap simpleArrayMap = this.mRecyclerView.mViewInfoStore.mLayoutHolderMap;
                ViewInfoStore.InfoRecord infoRecord = (ViewInfoStore.InfoRecord) simpleArrayMap.get(childViewHolderInt);
                if (infoRecord == null) {
                    infoRecord = ViewInfoStore.InfoRecord.obtain();
                    simpleArrayMap.put(childViewHolderInt, infoRecord);
                }
                infoRecord.flags |= 1;
            } else {
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            }
            this.mChildHelper.attachViewToParent(view, i, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public abstract boolean canScrollHorizontally();

        public abstract boolean canScrollVertically();

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public abstract int computeHorizontalScrollExtent(State state);

        public abstract int computeHorizontalScrollOffset(State state);

        public abstract int computeHorizontalScrollRange(State state);

        public abstract int computeVerticalScrollExtent(State state);

        public abstract int computeVerticalScrollOffset(State state);

        public abstract int computeVerticalScrollRange(State state);

        public void detachAndScrapAttachedViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(recycler, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, Recycler recycler) {
            scrapOrRecycleView(recycler, this.mChildHelper.indexOfChild(view), view);
        }

        public void detachAndScrapViewAt(int i, Recycler recycler) {
            scrapOrRecycleView(recycler, i, getChildAt(i));
        }

        public void detachView(View view) {
            int indexOfChild = this.mChildHelper.indexOfChild(view);
            if (indexOfChild >= 0) {
                this.mChildHelper.detachViewFromParent(indexOfChild);
            }
        }

        public void detachViewAt(int i) {
            getChildAt(i);
            this.mChildHelper.detachViewFromParent(i);
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, recycler);
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View view) {
            ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
            if (itemAnimator != null) {
                itemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.mHiddenViews.contains(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.mInPreLayout || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
        }

        public View getChildAt(int i) {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildAt(i);
            }
            return null;
        }

        public int getChildCount() {
            ChildHelper childHelper = this.mChildHelper;
            if (childHelper != null) {
                return childHelper.getChildCount();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || !recyclerView.mClipToPadding) {
                return false;
            }
            return true;
        }

        public int getColumnCountForAccessibility(Recycler recycler, State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(View view) {
            return getBottomDecorationHeight(view) + view.getBottom();
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return getRightDecorationWidth(view) + view.getRight();
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.mHiddenViews.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            Adapter adapter;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                adapter = recyclerView.getAdapter();
            } else {
                adapter = null;
            }
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return this.mRecyclerView.getLayoutDirection();
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.left;
        }

        public int getMinimumHeight() {
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return recyclerView.getMinimumHeight();
        }

        public int getMinimumWidth() {
            RecyclerView recyclerView = this.mRecyclerView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return recyclerView.getMinimumWidth();
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return 0;
            }
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return recyclerView.getPaddingEnd();
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return 0;
            }
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return recyclerView.getPaddingStart();
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).mViewHolder.getLayoutPosition();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(Recycler recycler, State state) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(Recycler recycler, State state) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || !recyclerView.hasFocus()) {
                return false;
            }
            return true;
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(this.mRecyclerView, new StringBuilder("View should be fully attached to be ignored")));
            }
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public abstract boolean isAutoMeasureEnabled();

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || !recyclerView.isFocused()) {
                return false;
            }
            return true;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(Recycler recycler, State state) {
            return false;
        }

        public boolean isLayoutReversed() {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller == null || !smoothScroller.mRunning) {
                return false;
            }
            return true;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3;
            if (!this.mHorizontalBoundCheck.isViewWithinBoundFlags(view) || !this.mVerticalBoundCheck.isViewWithinBoundFlags(view)) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z) {
                return z3;
            }
            return !z3;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).mDecorInsets;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.mDecorInsets;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public abstract void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler);

        public abstract View onFocusSearchFailed(View view, int i, Recycler recycler, State state);

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                ChildHelper childHelper = this.mChildHelper;
                if (!childHelper.mHiddenViews.contains(childViewHolderInt.itemView)) {
                    RecyclerView recyclerView = this.mRecyclerView;
                    onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
                }
            }
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public abstract void onLayoutChildren(Recycler recycler, State state);

        public abstract void onLayoutCompleted(State state);

        public void onMeasure(Recycler recycler, State state, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public void onSmoothScrollerStopped(SmoothScroller smoothScroller) {
            if (this.mSmoothScroller == smoothScroller) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityActionForItem(Recycler recycler, State state, View view, int i, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                recyclerView.postOnAnimation(runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.removeViewAt(childCount);
            }
        }

        public void removeAndRecycleAllViews(Recycler recycler) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, recycler);
                }
            }
        }

        public void removeAndRecycleScrapInt(Recycler recycler) {
            ArrayList arrayList = recycler.mAttachedScrap;
            int size = arrayList.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = ((ViewHolder) arrayList.get(i)).itemView;
                ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    ItemAnimator itemAnimator = this.mRecyclerView.mItemAnimator;
                    if (itemAnimator != null) {
                        itemAnimator.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    ViewHolder childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.mScrapContainer = null;
                    childViewHolderInt2.mInChangeScrap = false;
                    childViewHolderInt2.clearReturnedFromScrapFlag();
                    recycler.recycleViewHolderInternal(childViewHolderInt2);
                }
            }
            arrayList.clear();
            ArrayList arrayList2 = recycler.mChangedScrap;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, Recycler recycler) {
            removeView(view);
            recycler.recycleView(view);
        }

        public void removeAndRecycleViewAt(int i, Recycler recycler) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            recycler.recycleView(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View view) {
            ChildHelper childHelper = this.mChildHelper;
            AnonymousClass5 r1 = childHelper.mCallback;
            int i = childHelper.mRemoveStatus;
            if (i == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            } else if (i != 2) {
                try {
                    childHelper.mRemoveStatus = 1;
                    childHelper.mViewInRemoveView = view;
                    int indexOfChild = RecyclerView.this.indexOfChild(view);
                    if (indexOfChild >= 0) {
                        if (childHelper.mBucket.remove(indexOfChild)) {
                            childHelper.unhideViewInternal(view);
                        }
                        r1.removeViewAt(indexOfChild);
                    }
                    childHelper.mRemoveStatus = 0;
                    childHelper.mViewInRemoveView = null;
                } catch (Throwable th) {
                    childHelper.mRemoveStatus = 0;
                    childHelper.mViewInRemoveView = null;
                    throw th;
                }
            } else {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.removeViewAt(i);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00b3, code lost:
            if ((r5.bottom - r10) > r2) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
            /*
                r8 = this;
                int r0 = r8.getPaddingLeft()
                int r1 = r8.getPaddingTop()
                int r2 = r8.getWidth()
                int r3 = r8.getPaddingRight()
                int r2 = r2 - r3
                int r3 = r8.getHeight()
                int r4 = r8.getPaddingBottom()
                int r3 = r3 - r4
                int r4 = r10.getLeft()
                int r5 = r11.left
                int r4 = r4 + r5
                int r5 = r10.getScrollX()
                int r4 = r4 - r5
                int r5 = r10.getTop()
                int r6 = r11.top
                int r5 = r5 + r6
                int r10 = r10.getScrollY()
                int r5 = r5 - r10
                int r10 = r11.width()
                int r10 = r10 + r4
                int r11 = r11.height()
                int r11 = r11 + r5
                int r4 = r4 - r0
                r0 = 0
                int r6 = java.lang.Math.min(r0, r4)
                int r5 = r5 - r1
                int r1 = java.lang.Math.min(r0, r5)
                int r10 = r10 - r2
                int r2 = java.lang.Math.max(r0, r10)
                int r11 = r11 - r3
                int r11 = java.lang.Math.max(r0, r11)
                int r3 = r8.getLayoutDirection()
                r7 = 1
                if (r3 != r7) goto L60
                if (r2 == 0) goto L5b
                goto L68
            L5b:
                int r2 = java.lang.Math.max(r6, r10)
                goto L68
            L60:
                if (r6 == 0) goto L63
                goto L67
            L63:
                int r6 = java.lang.Math.min(r4, r2)
            L67:
                r2 = r6
            L68:
                if (r1 == 0) goto L6b
                goto L6f
            L6b:
                int r1 = java.lang.Math.min(r5, r11)
            L6f:
                int[] r10 = new int[]{r2, r1}
                r11 = r10[r0]
                r10 = r10[r7]
                if (r13 == 0) goto Lb6
                android.view.View r13 = r9.getFocusedChild()
                if (r13 != 0) goto L80
                goto Lbb
            L80:
                int r1 = r8.getPaddingLeft()
                int r2 = r8.getPaddingTop()
                int r3 = r8.getWidth()
                int r4 = r8.getPaddingRight()
                int r3 = r3 - r4
                int r4 = r8.getHeight()
                int r5 = r8.getPaddingBottom()
                int r4 = r4 - r5
                androidx.recyclerview.widget.RecyclerView r5 = r8.mRecyclerView
                android.graphics.Rect r5 = r5.mTempRect
                r8.getDecoratedBoundsWithMargins(r13, r5)
                int r13 = r5.left
                int r13 = r13 - r11
                if (r13 >= r3) goto Lbb
                int r13 = r5.right
                int r13 = r13 - r11
                if (r13 <= r1) goto Lbb
                int r13 = r5.top
                int r13 = r13 - r10
                if (r13 >= r4) goto Lbb
                int r13 = r5.bottom
                int r13 = r13 - r10
                if (r13 > r2) goto Lb6
                goto Lbb
            Lb6:
                if (r11 != 0) goto Lbc
                if (r10 == 0) goto Lbb
                goto Lbc
            Lbb:
                return r0
            Lbc:
                if (r12 == 0) goto Lc2
                r9.scrollBy(r11, r10)
                goto Lc5
            Lc2:
                r9.smoothScrollBy(r11, r10)
            Lc5:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.requestChildRectangleOnScreen(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public final void scrapOrRecycleView(Recycler recycler, int i, View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    Log.d(RecyclerView.TAG, "ignoring view " + childViewHolderInt);
                }
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                detachViewAt(i);
                recycler.scrapView(view);
                this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
            } else {
                removeViewAt(i);
                recycler.recycleViewHolderInternal(childViewHolderInt);
            }
        }

        public abstract int scrollHorizontallyBy(int i, Recycler recycler, State state);

        public abstract void scrollToPosition(int i);

        public abstract int scrollVerticallyBy(int i, Recycler recycler, State state);

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i2, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.mRecyclerView.mTempRect.set(i5, i6, i3, i4);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            if (view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) || !isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return true;
            }
            return false;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            if (!this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) {
                return true;
            }
            return false;
        }

        public abstract void smoothScrollToPosition(RecyclerView recyclerView, State state, int i);

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(SmoothScroller smoothScroller) {
            SmoothScroller smoothScroller2 = this.mSmoothScroller;
            if (!(smoothScroller2 == null || smoothScroller == smoothScroller2 || !smoothScroller2.mRunning)) {
                smoothScroller2.stop();
            }
            this.mSmoothScroller = smoothScroller;
            RecyclerView recyclerView = this.mRecyclerView;
            smoothScroller.getClass();
            ViewFlinger viewFlinger = recyclerView.mViewFlinger;
            RecyclerView.this.removeCallbacks(viewFlinger);
            viewFlinger.mOverScroller.abortAnimation();
            if (smoothScroller.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + smoothScroller.getClass().getSimpleName() + " was started more than once. Each instance of" + smoothScroller.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            smoothScroller.mRecyclerView = recyclerView;
            smoothScroller.mLayoutManager = this;
            int i = smoothScroller.mTargetPosition;
            if (i != -1) {
                recyclerView.mState.mTargetPosition = i;
                smoothScroller.mRunning = true;
                smoothScroller.mPendingInitialRun = true;
                smoothScroller.mTargetView = recyclerView.mLayout.findViewByPosition(i);
                smoothScroller.mRecyclerView.mViewFlinger.postOnAnimation();
                smoothScroller.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public void stopIgnoringView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void stopSmoothScroller() {
            SmoothScroller smoothScroller = this.mSmoothScroller;
            if (smoothScroller != null) {
                smoothScroller.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        public void onInitializeAccessibilityEvent(Recycler recycler, State state, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                Adapter adapter = this.mRecyclerView.mAdapter;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.getItemCount());
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(Recycler recycler, State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(CaptureService.CONNECTIONS_LOG_SIZE);
                accessibilityNodeInfoCompat.setScrollable(true);
                accessibilityNodeInfoCompat.setBooleanProperty(67108864, true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
                accessibilityNodeInfoCompat.setScrollable(true);
                accessibilityNodeInfoCompat.setBooleanProperty(67108864, true);
            }
            accessibilityNodeInfoCompat.mInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) SnackbarManager.obtain(getRowCountForAccessibility(recycler, state), getColumnCountForAccessibility(recycler, state), getSelectionModeForAccessibility(recycler, state), isLayoutHierarchical(recycler, state)).lock);
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, State state, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x008e A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00e1  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean performAccessibilityAction(androidx.recyclerview.widget.RecyclerView.Recycler r11, androidx.recyclerview.widget.RecyclerView.State r12, int r13, android.os.Bundle r14) {
            /*
                Method dump skipped, instructions count: 257
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.performAccessibilityAction(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i, bundle);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
            if (r5 == 1073741824) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1e
                if (r7 < 0) goto L13
            L10:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L31
            L13:
                if (r7 != r1) goto L1b
                if (r5 == r2) goto L23
                if (r5 == 0) goto L1b
                if (r5 == r3) goto L23
            L1b:
                r5 = 0
                r7 = 0
                goto L31
            L1e:
                if (r7 < 0) goto L21
                goto L10
            L21:
                if (r7 != r1) goto L25
            L23:
                r7 = r4
                goto L31
            L25:
                if (r7 != r0) goto L1b
                if (r5 == r2) goto L2e
                if (r5 != r3) goto L2c
                goto L2e
            L2c:
                r5 = 0
                goto L23
            L2e:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L23
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.LayoutManager.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public void attachView(View view) {
            attachView(view, -1);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }
    }

    /* loaded from: classes.dex */
    public interface OnChildAttachStateChangeListener {
    }

    /* loaded from: classes.dex */
    public abstract class OnFlingListener {
    }

    /* loaded from: classes.dex */
    public interface OnItemTouchListener {
    }

    /* loaded from: classes.dex */
    public abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public abstract void onScrolled(RecyclerView recyclerView, int i, int i2);
    }

    /* loaded from: classes.dex */
    public final class RecycledViewPool {
        public int mAttachCountForClearing;
        public Set mAttachedAdaptersForPoolingContainer;
        public SparseArray mScrap;

        /* loaded from: classes.dex */
        public final class ScrapData {
            public final ArrayList mScrapHeap = new ArrayList();
            public final int mMaxScrap = 5;
            public long mCreateRunningAverageNs = 0;
            public long mBindRunningAverageNs = 0;
        }

        public final ScrapData getScrapDataForType(int i) {
            SparseArray sparseArray = this.mScrap;
            ScrapData scrapData = (ScrapData) sparseArray.get(i);
            if (scrapData != null) {
                return scrapData;
            }
            ScrapData scrapData2 = new ScrapData();
            sparseArray.put(i, scrapData2);
            return scrapData2;
        }
    }

    /* loaded from: classes.dex */
    public final class Recycler {
        public final ArrayList mAttachedScrap;
        public RecycledViewPool mRecyclerPool;
        public final List mUnmodifiableAttachedScrap;
        public ArrayList mChangedScrap = null;
        public final ArrayList mCachedViews = new ArrayList();
        public int mRequestedCacheMax = 2;
        public int mViewCacheMax = 2;

        public Recycler() {
            ArrayList arrayList = new ArrayList();
            this.mAttachedScrap = arrayList;
            this.mUnmodifiableAttachedScrap = DesugarCollections.unmodifiableList(arrayList);
        }

        public static void invalidateDisplayListInt(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    invalidateDisplayListInt((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public final void addViewHolderToRecycledViewPool(ViewHolder viewHolder, boolean z) {
            AccessibilityDelegateCompat accessibilityDelegateCompat;
            RecyclerView.clearNestedRecyclerViewIfNotNested(viewHolder);
            View view = viewHolder.itemView;
            RecyclerView recyclerView = RecyclerView.this;
            RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate = recyclerView.mAccessibilityDelegate;
            if (recyclerViewAccessibilityDelegate != null) {
                AccessibilityDelegateCompat itemDelegate = recyclerViewAccessibilityDelegate.getItemDelegate();
                if (itemDelegate instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) {
                    accessibilityDelegateCompat = (AccessibilityDelegateCompat) ((RecyclerViewAccessibilityDelegate.ItemDelegate) itemDelegate).mOriginalItemDelegates.remove(view);
                } else {
                    accessibilityDelegateCompat = null;
                }
                ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
            }
            if (z) {
                if (recyclerView.mRecyclerListeners.size() <= 0) {
                    Adapter adapter = recyclerView.mAdapter;
                    if (adapter != null) {
                        adapter.onViewRecycled(viewHolder);
                    }
                    if (recyclerView.mState != null) {
                        recyclerView.mViewInfoStore.removeViewHolder(viewHolder);
                    }
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        Log.d(RecyclerView.TAG, "dispatchViewRecycled: " + viewHolder);
                    }
                } else {
                    recyclerView.mRecyclerListeners.get(0).getClass();
                    throw new ClassCastException();
                }
            }
            viewHolder.mBindingAdapter = null;
            viewHolder.mOwnerRecyclerView = null;
            RecycledViewPool recycledViewPool = getRecycledViewPool();
            recycledViewPool.getClass();
            int itemViewType = viewHolder.getItemViewType();
            ArrayList arrayList = recycledViewPool.getScrapDataForType(itemViewType).mScrapHeap;
            if (((RecycledViewPool.ScrapData) recycledViewPool.mScrap.get(itemViewType)).mMaxScrap <= arrayList.size()) {
                BundleKt.callPoolingContainerOnRelease(viewHolder.itemView);
            } else if (!RecyclerView.sDebugAssertionsEnabled || !arrayList.contains(viewHolder)) {
                viewHolder.resetInternal();
                arrayList.add(viewHolder);
            } else {
                throw new IllegalArgumentException("this scrap item already exists");
            }
        }

        public final int convertPreLayoutPositionToPostLayout(int i) {
            RecyclerView recyclerView = RecyclerView.this;
            if (i < 0 || i >= recyclerView.mState.getItemCount()) {
                StringBuilder m = ViewModelProvider.Factory.CC.m("invalid position ", i, ". State item count is ");
                m.append(recyclerView.mState.getItemCount());
                m.append(recyclerView.exceptionLabel());
                throw new IndexOutOfBoundsException(m.toString());
            } else if (!recyclerView.mState.mInPreLayout) {
                return i;
            } else {
                return recyclerView.mAdapterHelper.findPositionOffset(i, 0);
            }
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, androidx.recyclerview.widget.RecyclerView$RecycledViewPool] */
        public final RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool == null) {
                ?? obj = new Object();
                obj.mScrap = new SparseArray();
                obj.mAttachCountForClearing = 0;
                obj.mAttachedAdaptersForPoolingContainer = Collections.newSetFromMap(new IdentityHashMap());
                this.mRecyclerPool = obj;
                maybeSendPoolingContainerAttach();
            }
            return this.mRecyclerPool;
        }

        public final View getViewForPosition(int i) {
            return tryGetViewHolderForPositionByDeadline(i, RecyclerView.FOREVER_NS).itemView;
        }

        public final void maybeSendPoolingContainerAttach() {
            if (this.mRecyclerPool != null) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mAdapter != null && recyclerView.isAttachedToWindow()) {
                    RecycledViewPool recycledViewPool = this.mRecyclerPool;
                    recycledViewPool.mAttachedAdaptersForPoolingContainer.add(recyclerView.mAdapter);
                }
            }
        }

        public final void poolingContainerDetach(Adapter adapter, boolean z) {
            RecycledViewPool recycledViewPool = this.mRecyclerPool;
            if (recycledViewPool != null) {
                SparseArray sparseArray = recycledViewPool.mScrap;
                Set set = recycledViewPool.mAttachedAdaptersForPoolingContainer;
                set.remove(adapter);
                if (set.size() == 0 && !z) {
                    for (int i = 0; i < sparseArray.size(); i++) {
                        ArrayList arrayList = ((RecycledViewPool.ScrapData) sparseArray.get(sparseArray.keyAt(i))).mScrapHeap;
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            BundleKt.callPoolingContainerOnRelease(((ViewHolder) arrayList.get(i2)).itemView);
                        }
                    }
                }
            }
        }

        public final void recycleAndClearCachedViews() {
            ArrayList arrayList = this.mCachedViews;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                recycleCachedViewAt(size);
            }
            arrayList.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = RecyclerView.this.mPrefetchRegistry;
                int[] iArr = layoutPrefetchRegistryImpl.mPrefetchArray;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                layoutPrefetchRegistryImpl.mCount = 0;
            }
        }

        public final void recycleCachedViewAt(int i) {
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "Recycling cached view at index " + i);
            }
            ArrayList arrayList = this.mCachedViews;
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i);
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "CachedViewHolder to be recycled: " + viewHolder);
            }
            addViewHolderToRecycledViewPool(viewHolder, true);
            arrayList.remove(i);
        }

        public final void recycleView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            boolean isTmpDetached = childViewHolderInt.isTmpDetached();
            RecyclerView recyclerView = RecyclerView.this;
            if (isTmpDetached) {
                recyclerView.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            recycleViewHolderInternal(childViewHolderInt);
            if (recyclerView.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                recyclerView.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:56:0x00d4, code lost:
            r4 = r4 - 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void recycleViewHolderInternal(androidx.recyclerview.widget.RecyclerView.ViewHolder r12) {
            /*
                Method dump skipped, instructions count: 341
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.recycleViewHolderInternal(androidx.recyclerview.widget.RecyclerView$ViewHolder):void");
        }

        public final void scrapView(View view) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            boolean hasAnyOfTheFlags = childViewHolderInt.hasAnyOfTheFlags(12);
            RecyclerView recyclerView = RecyclerView.this;
            if (!hasAnyOfTheFlags && childViewHolderInt.isUpdated() && !recyclerView.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.mChangedScrap == null) {
                    this.mChangedScrap = new ArrayList();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.mChangedScrap.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || recyclerView.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.mAttachedScrap.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(recyclerView, new StringBuilder("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:164:0x0304, code lost:
            r9 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:248:0x04a6, code lost:
            if ((r12 + r10) >= r30) goto L236;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:128:0x024e  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x0259  */
        /* JADX WARN: Removed duplicated region for block: B:216:0x0409  */
        /* JADX WARN: Removed duplicated region for block: B:224:0x0426  */
        /* JADX WARN: Removed duplicated region for block: B:245:0x0497  */
        /* JADX WARN: Removed duplicated region for block: B:251:0x04ae  */
        /* JADX WARN: Removed duplicated region for block: B:252:0x04bf  */
        /* JADX WARN: Removed duplicated region for block: B:255:0x04c7  */
        /* JADX WARN: Removed duplicated region for block: B:258:0x04e2  */
        /* JADX WARN: Removed duplicated region for block: B:261:0x04f1  */
        /* JADX WARN: Removed duplicated region for block: B:279:0x0531  */
        /* JADX WARN: Removed duplicated region for block: B:282:0x0538  */
        /* JADX WARN: Removed duplicated region for block: B:286:0x0543  */
        /* JADX WARN: Removed duplicated region for block: B:287:0x054f  */
        /* JADX WARN: Removed duplicated region for block: B:293:0x0568 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0091  */
        /* JADX WARN: Type inference failed for: r4v30, types: [java.lang.Object, androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.recyclerview.widget.RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline(int r29, long r30) {
            /*
                Method dump skipped, instructions count: 1440
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.Recycler.tryGetViewHolderForPositionByDeadline(int, long):androidx.recyclerview.widget.RecyclerView$ViewHolder");
        }

        public final void unscrapView(ViewHolder viewHolder) {
            if (viewHolder.mInChangeScrap) {
                this.mChangedScrap.remove(viewHolder);
            } else {
                this.mAttachedScrap.remove(viewHolder);
            }
            viewHolder.mScrapContainer = null;
            viewHolder.mInChangeScrap = false;
            viewHolder.clearReturnedFromScrapFlag();
        }

        public final void updateViewCacheSize() {
            int i;
            LayoutManager layoutManager = RecyclerView.this.mLayout;
            if (layoutManager != null) {
                i = layoutManager.mPrefetchMaxCountObserved;
            } else {
                i = 0;
            }
            this.mViewCacheMax = this.mRequestedCacheMax + i;
            ArrayList arrayList = this.mCachedViews;
            for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.mViewCacheMax; size--) {
                recycleCachedViewAt(size);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface RecyclerListener {
    }

    /* loaded from: classes.dex */
    public final class RecyclerViewDataObserver extends AdapterDataObserver {
        public RecyclerViewDataObserver() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.assertNotInLayoutOrScroll(null);
            recyclerView.mState.mStructureChanged = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                recyclerView.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = recyclerView.mAdapterHelper;
            ArrayList arrayList = adapterHelper.mPendingUpdates;
            if (i2 >= 1) {
                arrayList.add(adapterHelper.obtainUpdateOp(obj, 4, i, i2));
                adapterHelper.mExistingUpdateTypes |= 4;
                if (arrayList.size() == 1) {
                    triggerUpdateProcessor();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i, int i2) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = recyclerView.mAdapterHelper;
            ArrayList arrayList = adapterHelper.mPendingUpdates;
            if (i2 >= 1) {
                arrayList.add(adapterHelper.obtainUpdateOp(null, 1, i, i2));
                adapterHelper.mExistingUpdateTypes |= 1;
                if (arrayList.size() == 1) {
                    triggerUpdateProcessor();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = recyclerView.mAdapterHelper;
            ArrayList arrayList = adapterHelper.mPendingUpdates;
            if (i != i2) {
                if (i3 == 1) {
                    arrayList.add(adapterHelper.obtainUpdateOp(null, 8, i, i2));
                    adapterHelper.mExistingUpdateTypes |= 8;
                    if (arrayList.size() == 1) {
                        triggerUpdateProcessor();
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i, int i2) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.assertNotInLayoutOrScroll(null);
            AdapterHelper adapterHelper = recyclerView.mAdapterHelper;
            ArrayList arrayList = adapterHelper.mPendingUpdates;
            if (i2 >= 1) {
                arrayList.add(adapterHelper.obtainUpdateOp(null, 2, i, i2));
                adapterHelper.mExistingUpdateTypes |= 2;
                if (arrayList.size() == 1) {
                    triggerUpdateProcessor();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onStateRestorationPolicyChanged() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState != null && (adapter = recyclerView.mAdapter) != null && adapter.canRestoreState()) {
                recyclerView.requestLayout();
            }
        }

        public final void triggerUpdateProcessor() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mHasFixedSize || !recyclerView.mIsAttached) {
                recyclerView.mAdapterUpdateDuringMeasure = true;
                recyclerView.requestLayout();
                return;
            }
            Runnable runnable = recyclerView.mUpdateChildViewsRunnable;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            recyclerView.postOnAnimation(runnable);
        }
    }

    /* loaded from: classes.dex */
    public final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.AnonymousClass2(6);
        public Parcelable mLayoutState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mLayoutState = parcel.readParcelable(classLoader == null ? LayoutManager.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.mLayoutState, 0);
        }
    }

    /* loaded from: classes.dex */
    public abstract class SmoothScroller {
        public LayoutManager mLayoutManager;
        public boolean mPendingInitialRun;
        public RecyclerView mRecyclerView;
        public final Action mRecyclingAction;
        public boolean mRunning;
        public boolean mStarted;
        public int mTargetPosition = -1;
        public View mTargetView;

        /* loaded from: classes.dex */
        public final class Action {
            public boolean mChanged;
            public int mConsecutiveUpdates;
            public int mDuration;
            public int mDx;
            public int mDy;
            public Interpolator mInterpolator;
            public int mJumpToPosition;

            public final void runIfNecessary(RecyclerView recyclerView) {
                int i = this.mJumpToPosition;
                if (i >= 0) {
                    this.mJumpToPosition = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.mChanged = false;
                } else if (this.mChanged) {
                    Interpolator interpolator = this.mInterpolator;
                    if (interpolator == null || this.mDuration >= 1) {
                        int i2 = this.mDuration;
                        if (i2 >= 1) {
                            recyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, interpolator, i2);
                            int i3 = this.mConsecutiveUpdates + 1;
                            this.mConsecutiveUpdates = i3;
                            if (i3 > 10) {
                                Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                            }
                            this.mChanged = false;
                            return;
                        }
                        throw new IllegalStateException("Scroll duration must be a positive number");
                    }
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else {
                    this.mConsecutiveUpdates = 0;
                }
            }
        }

        /* loaded from: classes.dex */
        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int i);
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action, java.lang.Object] */
        public SmoothScroller() {
            ?? obj = new Object();
            obj.mJumpToPosition = -1;
            obj.mChanged = false;
            obj.mConsecutiveUpdates = 0;
            obj.mDx = 0;
            obj.mDy = 0;
            obj.mDuration = Integer.MIN_VALUE;
            obj.mInterpolator = null;
            this.mRecyclingAction = obj;
        }

        public PointF computeScrollVectorForPosition(int i) {
            LayoutManager layoutManager = this.mLayoutManager;
            if (layoutManager instanceof ScrollVectorProvider) {
                return ((ScrollVectorProvider) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        }

        public final void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f = computeScrollVectorForPosition.x;
                if (!(f == RecyclerView.DECELERATION_RATE && computeScrollVectorForPosition.y == RecyclerView.DECELERATION_RATE)) {
                    recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(computeScrollVectorForPosition.y), null);
                }
            }
            boolean z = false;
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            Action action = this.mRecyclingAction;
            if (view != null) {
                if (this.mRecyclerView.getChildLayoutPosition(view) == this.mTargetPosition) {
                    View view2 = this.mTargetView;
                    State state = recyclerView.mState;
                    onTargetFound(view2, action);
                    action.runIfNecessary(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                State state2 = recyclerView.mState;
                LinearSmoothScroller linearSmoothScroller = (LinearSmoothScroller) this;
                if (linearSmoothScroller.mRecyclerView.mLayout.getChildCount() == 0) {
                    linearSmoothScroller.stop();
                } else {
                    int i3 = linearSmoothScroller.mInterimTargetDx;
                    int i4 = i3 - i;
                    if (i3 * i4 <= 0) {
                        i4 = 0;
                    }
                    linearSmoothScroller.mInterimTargetDx = i4;
                    int i5 = linearSmoothScroller.mInterimTargetDy;
                    int i6 = i5 - i2;
                    if (i5 * i6 <= 0) {
                        i6 = 0;
                    }
                    linearSmoothScroller.mInterimTargetDy = i6;
                    if (i4 == 0 && i6 == 0) {
                        PointF computeScrollVectorForPosition2 = linearSmoothScroller.computeScrollVectorForPosition(linearSmoothScroller.mTargetPosition);
                        if (computeScrollVectorForPosition2 != null) {
                            float f2 = computeScrollVectorForPosition2.x;
                            if (!(f2 == RecyclerView.DECELERATION_RATE && computeScrollVectorForPosition2.y == RecyclerView.DECELERATION_RATE)) {
                                float f3 = computeScrollVectorForPosition2.y;
                                float sqrt = (float) Math.sqrt((f3 * f3) + (f2 * f2));
                                float f4 = computeScrollVectorForPosition2.x / sqrt;
                                computeScrollVectorForPosition2.x = f4;
                                float f5 = computeScrollVectorForPosition2.y / sqrt;
                                computeScrollVectorForPosition2.y = f5;
                                linearSmoothScroller.mTargetVector = computeScrollVectorForPosition2;
                                linearSmoothScroller.mInterimTargetDx = (int) (f4 * 10000.0f);
                                linearSmoothScroller.mInterimTargetDy = (int) (f5 * 10000.0f);
                                int calculateTimeForScrolling = linearSmoothScroller.calculateTimeForScrolling(10000);
                                action.mDx = (int) (linearSmoothScroller.mInterimTargetDx * 1.2f);
                                action.mDy = (int) (linearSmoothScroller.mInterimTargetDy * 1.2f);
                                action.mDuration = (int) (calculateTimeForScrolling * 1.2f);
                                action.mInterpolator = linearSmoothScroller.mLinearInterpolator;
                                action.mChanged = true;
                            }
                        }
                        action.mJumpToPosition = linearSmoothScroller.mTargetPosition;
                        linearSmoothScroller.stop();
                    }
                }
                if (action.mJumpToPosition >= 0) {
                    z = true;
                }
                action.runIfNecessary(recyclerView);
                if (z && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.postOnAnimation();
                }
            }
        }

        public abstract void onTargetFound(View view, Action action);

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                LinearSmoothScroller linearSmoothScroller = (LinearSmoothScroller) this;
                linearSmoothScroller.mInterimTargetDy = 0;
                linearSmoothScroller.mInterimTargetDx = 0;
                linearSmoothScroller.mTargetVector = null;
                this.mRecyclerView.mState.mTargetPosition = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class State {
        public int mDeletedInvisibleItemCountSincePreviousLayout;
        public long mFocusedItemId;
        public int mFocusedItemPosition;
        public int mFocusedSubChildId;
        public boolean mInPreLayout;
        public boolean mIsMeasuring;
        public int mItemCount;
        public int mLayoutStep;
        public int mPreviousLayoutItemCount;
        public boolean mRunPredictiveAnimations;
        public boolean mRunSimpleAnimations;
        public boolean mStructureChanged;
        public int mTargetPosition;
        public boolean mTrackOldChangeHolders;

        public final void assertLayoutStep(int i) {
            if ((this.mLayoutStep & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
            }
        }

        public final int getItemCount() {
            if (this.mInPreLayout) {
                return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
            }
            return this.mItemCount;
        }

        public final String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=null, mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }
    }

    /* loaded from: classes.dex */
    public final class StretchEdgeEffectFactory extends EdgeEffectFactory {
    }

    /* loaded from: classes.dex */
    public abstract class ViewCacheExtension {
    }

    /* loaded from: classes.dex */
    public final class ViewFlinger implements Runnable {
        public Interpolator mInterpolator;
        public int mLastFlingX;
        public int mLastFlingY;
        public OverScroller mOverScroller;
        public boolean mEatRunOnAnimationRequest = false;
        public boolean mReSchedulePostAnimationCallback = false;

        public ViewFlinger() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = interpolator;
            this.mOverScroller = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public final void fling(int i, int i2) {
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator interpolator = this.mInterpolator;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.mInterpolator = interpolator2;
                this.mOverScroller = new OverScroller(recyclerView.getContext(), interpolator2);
            }
            this.mOverScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public final void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest) {
                this.mReSchedulePostAnimationCallback = true;
                return;
            }
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.removeCallbacks(this);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            recyclerView.postOnAnimation(this);
        }

        @Override // java.lang.Runnable
        public final void run() {
            int i;
            int i2;
            int i3;
            int i4;
            boolean z;
            boolean z2;
            boolean z3;
            int i5;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                recyclerView.removeCallbacks(this);
                this.mOverScroller.abortAnimation();
                return;
            }
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.mOverScroller;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                this.mLastFlingX = currX;
                this.mLastFlingY = currY;
                int consumeFlingInHorizontalStretch = recyclerView.consumeFlingInHorizontalStretch(currX - this.mLastFlingX);
                int consumeFlingInVerticalStretch = recyclerView.consumeFlingInVerticalStretch(currY - this.mLastFlingY);
                int[] iArr = recyclerView.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView.dispatchNestedPreScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr, null, 1)) {
                    int[] iArr2 = recyclerView.mReusableIntPair;
                    consumeFlingInHorizontalStretch -= iArr2[0];
                    consumeFlingInVerticalStretch -= iArr2[1];
                }
                if (recyclerView.getOverScrollMode() != 2) {
                    recyclerView.considerReleasingGlowsOnScroll(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch);
                }
                if (recyclerView.mAdapter != null) {
                    int[] iArr3 = recyclerView.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView.scrollStep(consumeFlingInHorizontalStretch, consumeFlingInVerticalStretch, iArr3);
                    int[] iArr4 = recyclerView.mReusableIntPair;
                    int i6 = iArr4[0];
                    int i7 = iArr4[1];
                    int i8 = consumeFlingInHorizontalStretch - i6;
                    int i9 = consumeFlingInVerticalStretch - i7;
                    SmoothScroller smoothScroller = recyclerView.mLayout.mSmoothScroller;
                    if (smoothScroller != null && !smoothScroller.mPendingInitialRun && smoothScroller.mRunning) {
                        int itemCount = recyclerView.mState.getItemCount();
                        if (itemCount == 0) {
                            smoothScroller.stop();
                        } else if (smoothScroller.mTargetPosition >= itemCount) {
                            smoothScroller.mTargetPosition = itemCount - 1;
                            smoothScroller.onAnimation(i6, i7);
                        } else {
                            smoothScroller.onAnimation(i6, i7);
                        }
                    }
                    i2 = i8;
                    i4 = i6;
                    i = i9;
                    i3 = i7;
                } else {
                    i2 = consumeFlingInHorizontalStretch;
                    i = consumeFlingInVerticalStretch;
                    i4 = 0;
                    i3 = 0;
                }
                if (!recyclerView.mItemDecorations.isEmpty()) {
                    recyclerView.invalidate();
                }
                int[] iArr5 = recyclerView.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView.dispatchNestedScroll(i4, i3, i2, i, null, 1, iArr5);
                int[] iArr6 = recyclerView.mReusableIntPair;
                int i10 = i2 - iArr6[0];
                int i11 = i - iArr6[1];
                if (!(i4 == 0 && i3 == 0)) {
                    recyclerView.dispatchOnScrolled(i4, i3);
                }
                if (!recyclerView.awakenScrollBars()) {
                    recyclerView.invalidate();
                }
                if (overScroller.getCurrX() == overScroller.getFinalX()) {
                    z = true;
                } else {
                    z = false;
                }
                if (overScroller.getCurrY() == overScroller.getFinalY()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (overScroller.isFinished() || ((z || i10 != 0) && (z2 || i11 != 0))) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                SmoothScroller smoothScroller2 = recyclerView.mLayout.mSmoothScroller;
                if ((smoothScroller2 == null || !smoothScroller2.mPendingInitialRun) && z3) {
                    if (recyclerView.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (i10 < 0) {
                            i5 = -currVelocity;
                        } else if (i10 > 0) {
                            i5 = currVelocity;
                        } else {
                            i5 = 0;
                        }
                        if (i11 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i11 <= 0) {
                            currVelocity = 0;
                        }
                        recyclerView.absorbGlows(i5, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        GapWorker.LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
                        int[] iArr7 = layoutPrefetchRegistryImpl.mPrefetchArray;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        layoutPrefetchRegistryImpl.mCount = 0;
                    }
                } else {
                    postOnAnimation();
                    GapWorker gapWorker = recyclerView.mGapWorker;
                    if (gapWorker != null) {
                        gapWorker.postFromTraversal(recyclerView, i4, i3);
                    }
                }
                if (Build.VERSION.SDK_INT >= 35) {
                    Api35Impl.setFrameContentVelocity(recyclerView, Math.abs(overScroller.getCurrVelocity()));
                }
            }
            SmoothScroller smoothScroller3 = recyclerView.mLayout.mSmoothScroller;
            if (smoothScroller3 != null && smoothScroller3.mPendingInitialRun) {
                smoothScroller3.onAnimation(0, 0);
            }
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback) {
                recyclerView.removeCallbacks(this);
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                recyclerView.postOnAnimation(this);
                return;
            }
            recyclerView.setScrollState(0);
            recyclerView.stopNestedScroll(1);
        }

        public final void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3) {
            boolean z;
            int i4;
            RecyclerView recyclerView = RecyclerView.this;
            if (i3 == Integer.MIN_VALUE) {
                int abs = Math.abs(i);
                int abs2 = Math.abs(i2);
                if (abs > abs2) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    i4 = recyclerView.getWidth();
                } else {
                    i4 = recyclerView.getHeight();
                }
                if (!z) {
                    abs = abs2;
                }
                i3 = Math.min((int) (((abs / i4) + 1.0f) * 300.0f), (int) RecyclerView.MAX_SCROLL_DURATION);
            }
            int i5 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.mInterpolator != interpolator) {
                this.mInterpolator = interpolator;
                this.mOverScroller = new OverScroller(recyclerView.getContext(), interpolator);
            }
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            recyclerView.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, i, i2, i5);
            if (Build.VERSION.SDK_INT < 23) {
                this.mOverScroller.computeScrollOffset();
            }
            postOnAnimation();
        }
    }

    /* loaded from: classes.dex */
    public abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        Adapter mBindingAdapter;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        ViewHolder mShadowedHolder = null;
        ViewHolder mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        Recycler mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public ViewHolder(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((FLAG_ADAPTER_FULLUPDATE & this.mFlags) == 0) {
                if (this.mPayloads == null) {
                    ArrayList arrayList = new ArrayList();
                    this.mPayloads = arrayList;
                    this.mUnmodifiedPayloads = DesugarCollections.unmodifiableList(arrayList);
                }
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) != 0) {
                return false;
            }
            View view = this.itemView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (view.hasTransientState()) {
                return true;
            }
            return false;
        }

        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final Adapter getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            if (i == -1) {
                return this.mPosition;
            }
            return i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            if (i == -1) {
                return this.mPosition;
            }
            return i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i) {
            if ((i & this.mFlags) != 0) {
                return true;
            }
            return false;
        }

        public boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) != 0 || isInvalid()) {
                return true;
            }
            return false;
        }

        public boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) {
                return false;
            }
            return true;
        }

        public boolean isBound() {
            if ((this.mFlags & 1) != 0) {
                return true;
            }
            return false;
        }

        public boolean isInvalid() {
            if ((this.mFlags & 4) != 0) {
                return true;
            }
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) != 0) {
                return false;
            }
            View view = this.itemView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (!view.hasTransientState()) {
                return true;
            }
            return false;
        }

        public boolean isRemoved() {
            if ((this.mFlags & 8) != 0) {
                return true;
            }
            return false;
        }

        public boolean isScrap() {
            if (this.mScrapContainer != null) {
                return true;
            }
            return false;
        }

        public boolean isTmpDetached() {
            if ((this.mFlags & FLAG_TMP_DETACHED) != 0) {
                return true;
            }
            return false;
        }

        public boolean isUpdated() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        public boolean needsUpdate() {
            if ((this.mFlags & 2) != 0) {
                return true;
            }
            return false;
        }

        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = this.itemView.getImportantForAccessibility();
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            if (!RecyclerView.sDebugAssertionsEnabled || !isTmpDetached()) {
                this.mFlags = 0;
                this.mPosition = -1;
                this.mOldPosition = -1;
                this.mItemId = -1L;
                this.mPreLayoutPosition = -1;
                this.mIsRecyclableCount = 0;
                this.mShadowedHolder = null;
                this.mShadowingHolder = null;
                clearPayload();
                this.mWasImportantForAccessibilityBeforeHidden = 0;
                this.mPendingAccessibilityState = -1;
                RecyclerView.clearNestedRecyclerViewIfNotNested(this);
                return;
            }
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public final void setIsRecyclable(boolean z) {
            int i;
            int i2 = this.mIsRecyclableCount;
            if (z) {
                i = i2 - 1;
            } else {
                i = i2 + 1;
            }
            this.mIsRecyclableCount = i;
            if (i < 0) {
                this.mIsRecyclableCount = 0;
                if (!RecyclerView.sDebugAssertionsEnabled) {
                    Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                } else {
                    throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                }
            } else if (!z && i == 1) {
                this.mFlags |= 16;
            } else if (z && i == 0) {
                this.mFlags &= -17;
            }
            if (RecyclerView.sVerboseLoggingEnabled) {
                Log.d(RecyclerView.TAG, "setIsRecyclable val:" + z + ":" + this);
            }
        }

        public void setScrapContainer(Recycler recycler, boolean z) {
            this.mScrapContainer = recycler;
            this.mInChangeScrap = z;
        }

        public boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) != 0) {
                return true;
            }
            return false;
        }

        public boolean shouldIgnore() {
            if ((this.mFlags & FLAG_IGNORE) != 0) {
                return true;
            }
            return false;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String str;
            String str2;
            if (getClass().isAnonymousClass()) {
                str = "ViewHolder";
            } else {
                str = getClass().getSimpleName();
            }
            StringBuilder sb = new StringBuilder(str + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                if (this.mInChangeScrap) {
                    str2 = "[changeScrap]";
                } else {
                    str2 = "[attachedScrap]";
                }
                sb.append(str2);
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        public boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) != 0) {
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.recyclerview.widget.RecyclerView$StretchEdgeEffectFactory, java.lang.Object] */
    static {
        boolean z;
        if (Build.VERSION.SDK_INT >= 23) {
            z = true;
        } else {
            z = false;
        }
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = z;
        ALLOW_THREAD_GAP_WORK = true;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new ViewPager.AnonymousClass2(2);
        sDefaultEdgeEffectFactory = new Object();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public static void clearNestedRecyclerViewIfNotNested(ViewHolder viewHolder) {
        WeakReference<RecyclerView> weakReference = viewHolder.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView != viewHolder.itemView) {
                    ViewParent parent = recyclerView.getParent();
                    if (parent instanceof View) {
                        recyclerView = (View) parent;
                    } else {
                        recyclerView = null;
                    }
                } else {
                    return;
                }
            }
            viewHolder.mNestedRecyclerView = null;
        }
    }

    public static int consumeFlingInStretch(int i, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i2) {
        if (i > 0 && edgeEffect != null && BundleKt.getDistance(edgeEffect) != DECELERATION_RATE) {
            int round = Math.round(BundleKt.onPullDistance(edgeEffect, ((-i) * FLING_DESTRETCH_FACTOR) / i2, 0.5f) * ((-i2) / FLING_DESTRETCH_FACTOR));
            if (round != i) {
                edgeEffect.finish();
            }
            return i - round;
        } else if (i >= 0 || edgeEffect2 == null || BundleKt.getDistance(edgeEffect2) == DECELERATION_RATE) {
            return i;
        } else {
            float f = i2;
            int round2 = Math.round(BundleKt.onPullDistance(edgeEffect2, (i * FLING_DESTRETCH_FACTOR) / f, 0.5f) * (f / FLING_DESTRETCH_FACTOR));
            if (round2 != i) {
                edgeEffect2.finish();
            }
            return i - round2;
        }
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    public static ViewHolder getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.mDecorInsets;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
        }
        return this.mScrollingChildHelper;
    }

    public static void setDebugAssertionsEnabled(boolean z) {
        sDebugAssertionsEnabled = z;
    }

    public static void setVerboseLoggingEnabled(boolean z) {
        sVerboseLoggingEnabled = z;
    }

    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i != 0 || i2 != 0) {
            postInvalidateOnAnimation();
        }
    }

    public final void addAnimatingView(ViewHolder viewHolder) {
        boolean z;
        View view = viewHolder.itemView;
        if (view.getParent() == this) {
            z = true;
        } else {
            z = false;
        }
        this.mRecycler.unscrapView(getChildViewHolder(view));
        if (viewHolder.isTmpDetached()) {
            this.mChildHelper.attachViewToParent(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.addView(view, -1, true);
        } else {
            ChildHelper childHelper = this.mChildHelper;
            int indexOfChild = RecyclerView.this.indexOfChild(view);
            if (indexOfChild >= 0) {
                childHelper.mBucket.set(indexOfChild);
                childHelper.hideViewInternal(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null || !layoutManager.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(ItemDecoration itemDecoration, int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(itemDecoration);
        } else {
            this.mItemDecorations.add(i, itemDecoration);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(onChildAttachStateChangeListener);
    }

    public void addOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.add(onItemTouchListener);
    }

    public void addOnScrollListener(OnScrollListener onScrollListener) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(onScrollListener);
    }

    public void addRecyclerListener(RecyclerListener recyclerListener) {
        boolean z;
        if (recyclerListener != null) {
            z = true;
        } else {
            z = false;
        }
        TimeUtils.checkArgument("'listener' arg cannot be null.", z);
        this.mRecyclerListeners.add(recyclerListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void animateAppearance(androidx.recyclerview.widget.RecyclerView.ViewHolder r8, androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo r9, androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo r10) {
        /*
            r7 = this;
            r0 = 0
            r8.setIsRecyclable(r0)
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r0 = r7.mItemAnimator
            r1 = r0
            androidx.recyclerview.widget.DefaultItemAnimator r1 = (androidx.recyclerview.widget.DefaultItemAnimator) r1
            if (r9 == 0) goto L1b
            r1.getClass()
            int r3 = r9.left
            int r5 = r10.left
            if (r3 != r5) goto L1d
            int r0 = r9.top
            int r2 = r10.top
            if (r0 == r2) goto L1b
            goto L1d
        L1b:
            r2 = r8
            goto L27
        L1d:
            int r4 = r9.top
            int r6 = r10.top
            r2 = r8
            boolean r8 = r1.animateMove(r2, r3, r4, r5, r6)
            goto L36
        L27:
            r1.resetAnimation(r2)
            android.view.View r8 = r2.itemView
            r9 = 0
            r8.setAlpha(r9)
            java.util.ArrayList r8 = r1.mPendingAdditions
            r8.add(r2)
            r8 = 1
        L36:
            if (r8 == 0) goto L3b
            r7.postAnimationRunner()
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.animateAppearance(androidx.recyclerview.widget.RecyclerView$ViewHolder, androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo, androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo):void");
    }

    public void animateDisappearance(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo, ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i;
        int i2;
        boolean z;
        addAnimatingView(viewHolder);
        viewHolder.setIsRecyclable(false);
        DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) this.mItemAnimator;
        defaultItemAnimator.getClass();
        int i3 = itemHolderInfo.left;
        int i4 = itemHolderInfo.top;
        View view = viewHolder.itemView;
        if (itemHolderInfo2 == null) {
            i = view.getLeft();
        } else {
            i = itemHolderInfo2.left;
        }
        int i5 = i;
        if (itemHolderInfo2 == null) {
            i2 = view.getTop();
        } else {
            i2 = itemHolderInfo2.top;
        }
        int i6 = i2;
        if (viewHolder.isRemoved() || (i3 == i5 && i4 == i6)) {
            defaultItemAnimator.resetAnimation(viewHolder);
            defaultItemAnimator.mPendingRemovals.add(viewHolder);
            z = true;
        } else {
            view.layout(i5, i6, view.getWidth() + i5, view.getHeight() + i6);
            z = defaultItemAnimator.animateMove(viewHolder, i3, i4, i5, i6);
        }
        if (z) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException(ViewModelProvider.Factory.CC.m(this, new StringBuilder("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        throw new IllegalStateException(ViewModelProvider.Factory.CC.m(this, sb));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(ViewModelProvider.Factory.CC.m(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(ViewModelProvider.Factory.CC.m(this, new StringBuilder(""))));
        }
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder viewHolder) {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator == null) {
            return true;
        }
        DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) itemAnimator;
        if (!viewHolder.getUnmodifiedPayloads().isEmpty() || !defaultItemAnimator.mSupportsChangeAnimations || viewHolder.isInvalid()) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !this.mLayout.checkLayoutParams((LayoutParams) layoutParams)) {
            return false;
        }
        return true;
    }

    public void clearOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        Recycler recycler = this.mRecycler;
        ArrayList arrayList = recycler.mAttachedScrap;
        ArrayList arrayList2 = recycler.mCachedViews;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ViewHolder) arrayList2.get(i2)).clearOldPosition();
        }
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            ((ViewHolder) arrayList.get(i3)).clearOldPosition();
        }
        ArrayList arrayList3 = recycler.mChangedScrap;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ((ViewHolder) recycler.mChangedScrap.get(i4)).clearOldPosition();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null && layoutManager.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            postInvalidateOnAnimation();
        }
    }

    public int consumeFlingInHorizontalStretch(int i) {
        return consumeFlingInStretch(i, this.mLeftGlow, this.mRightGlow, getWidth());
    }

    public int consumeFlingInVerticalStretch(int i) {
        return consumeFlingInStretch(i, this.mTopGlow, this.mBottomGlow, getHeight());
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            Trace.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            Trace.endSection();
        } else if (this.mAdapterHelper.hasPendingUpdates()) {
            AdapterHelper adapterHelper = this.mAdapterHelper;
            int i = adapterHelper.mExistingUpdateTypes;
            if ((i & 4) != 0 && (i & 11) == 0) {
                Trace.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                this.mAdapterHelper.preProcess();
                if (!this.mLayoutWasDefered) {
                    int childCount = this.mChildHelper.getChildCount();
                    int i2 = 0;
                    while (true) {
                        if (i2 < childCount) {
                            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
                            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                                dispatchLayout();
                                break;
                            }
                            i2++;
                        } else {
                            this.mAdapterHelper.consumePostponedUpdates();
                            break;
                        }
                    }
                }
                stopInterceptRequestLayout(true);
                onExitLayoutOrScroll();
                Trace.endSection();
            } else if (adapterHelper.hasPendingUpdates()) {
                Trace.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                Trace.endSection();
            }
        }
    }

    public void defaultOnMeasure(int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        setMeasuredDimension(LayoutManager.chooseSize(i, paddingRight, getMinimumWidth()), LayoutManager.chooseSize(i2, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void dispatchChildAttached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                ((ViewPager2.AnonymousClass4) this.mOnChildAttachStateListeners.get(size)).getClass();
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }
        }
    }

    public void dispatchChildDetached(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).getClass();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        LayoutManager layoutManager = getLayoutManager();
        int i = 0;
        if (layoutManager != null) {
            if (layoutManager.canScrollVertically()) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 92 || keyCode == 93) {
                    int measuredHeight = getMeasuredHeight();
                    if (keyCode == 93) {
                        smoothScrollBy(0, measuredHeight, null, Integer.MIN_VALUE);
                        return true;
                    }
                    smoothScrollBy(0, -measuredHeight, null, Integer.MIN_VALUE);
                    return true;
                } else if (keyCode == 122 || keyCode == 123) {
                    boolean isLayoutReversed = layoutManager.isLayoutReversed();
                    if (keyCode == 122) {
                        if (isLayoutReversed) {
                            i = getAdapter().getItemCount();
                        }
                    } else if (!isLayoutReversed) {
                        i = getAdapter().getItemCount();
                    }
                    smoothScrollToPosition(i);
                    return true;
                }
            } else if (layoutManager.canScrollHorizontally()) {
                int keyCode2 = keyEvent.getKeyCode();
                if (keyCode2 == 92 || keyCode2 == 93) {
                    int measuredWidth = getMeasuredWidth();
                    if (keyCode2 == 93) {
                        smoothScrollBy(measuredWidth, 0, null, Integer.MIN_VALUE);
                        return true;
                    }
                    smoothScrollBy(-measuredWidth, 0, null, Integer.MIN_VALUE);
                    return true;
                } else if (keyCode2 == 122 || keyCode2 == 123) {
                    boolean isLayoutReversed2 = layoutManager.isLayoutReversed();
                    if (keyCode2 == 122) {
                        if (isLayoutReversed2) {
                            i = getAdapter().getItemCount();
                        }
                    } else if (!isLayoutReversed2) {
                        i = getAdapter().getItemCount();
                    }
                    smoothScrollToPosition(i);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x0372, code lost:
        if (r17.mChildHelper.mHiddenViews.contains(getFocusedChild()) == false) goto L197;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02bf A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v15, types: [java.lang.Object, androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dispatchLayout() {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.dispatchLayout():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.lang.Object, androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo] */
    public final void dispatchLayoutStep1() {
        View view;
        ViewInfoStore.InfoRecord infoRecord;
        int i;
        boolean z = true;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        ViewInfoStore viewInfoStore = this.mViewInfoStore;
        viewInfoStore.mLayoutHolderMap.clear();
        viewInfoStore.mOldChangedHolders.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        ViewHolder viewHolder = null;
        if (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) {
            view = null;
        } else {
            view = getFocusedChild();
        }
        if (view != null) {
            viewHolder = findContainingViewHolder(view);
        }
        long j = -1;
        if (viewHolder == null) {
            State state = this.mState;
            state.mFocusedItemId = -1L;
            state.mFocusedItemPosition = -1;
            state.mFocusedSubChildId = -1;
        } else {
            State state2 = this.mState;
            if (this.mAdapter.hasStableIds()) {
                j = viewHolder.getItemId();
            }
            state2.mFocusedItemId = j;
            State state3 = this.mState;
            if (this.mDataSetHasChangedAfterLayout) {
                i = -1;
            } else if (viewHolder.isRemoved()) {
                i = viewHolder.mOldPosition;
            } else {
                i = viewHolder.getAbsoluteAdapterPosition();
            }
            state3.mFocusedItemPosition = i;
            State state4 = this.mState;
            View view2 = viewHolder.itemView;
            int id = view2.getId();
            while (!view2.isFocused() && (view2 instanceof ViewGroup) && view2.hasFocus()) {
                view2 = ((ViewGroup) view2).getFocusedChild();
                if (view2.getId() != -1) {
                    id = view2.getId();
                }
            }
            state4.mFocusedSubChildId = id;
        }
        State state5 = this.mState;
        if (!state5.mRunSimpleAnimations || !this.mItemsChanged) {
            z = false;
        }
        state5.mTrackOldChangeHolders = z;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        state5.mInPreLayout = state5.mRunPredictiveAnimations;
        state5.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations) {
            int childCount = this.mChildHelper.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    ItemAnimator itemAnimator = this.mItemAnimator;
                    ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    itemAnimator.getClass();
                    ?? obj = new Object();
                    obj.setFrom(childViewHolderInt);
                    SimpleArrayMap simpleArrayMap = this.mViewInfoStore.mLayoutHolderMap;
                    ViewInfoStore.InfoRecord infoRecord2 = (ViewInfoStore.InfoRecord) simpleArrayMap.get(childViewHolderInt);
                    if (infoRecord2 == null) {
                        infoRecord2 = ViewInfoStore.InfoRecord.obtain();
                        simpleArrayMap.put(childViewHolderInt, infoRecord2);
                    }
                    infoRecord2.preInfo = obj;
                    infoRecord2.flags |= 4;
                    if (this.mState.mTrackOldChangeHolders && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.mOldChangedHolders.put(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.mRunPredictiveAnimations) {
            saveOldPositions();
            State state6 = this.mState;
            boolean z2 = state6.mStructureChanged;
            state6.mStructureChanged = false;
            this.mLayout.onLayoutChildren(this.mRecycler, state6);
            this.mState.mStructureChanged = z2;
            for (int i3 = 0; i3 < this.mChildHelper.getChildCount(); i3++) {
                ViewHolder childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
                if (!childViewHolderInt2.shouldIgnore() && ((infoRecord = (ViewInfoStore.InfoRecord) this.mViewInfoStore.mLayoutHolderMap.get(childViewHolderInt2)) == null || (infoRecord.flags & 4) == 0)) {
                    ItemAnimator.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                    boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(CaptureService.CONNECTIONS_LOG_SIZE);
                    ItemAnimator itemAnimator2 = this.mItemAnimator;
                    childViewHolderInt2.getUnmodifiedPayloads();
                    itemAnimator2.getClass();
                    ?? obj2 = new Object();
                    obj2.setFrom(childViewHolderInt2);
                    if (hasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, obj2);
                    } else {
                        SimpleArrayMap simpleArrayMap2 = this.mViewInfoStore.mLayoutHolderMap;
                        ViewInfoStore.InfoRecord infoRecord3 = (ViewInfoStore.InfoRecord) simpleArrayMap2.get(childViewHolderInt2);
                        if (infoRecord3 == null) {
                            infoRecord3 = ViewInfoStore.InfoRecord.obtain();
                            simpleArrayMap2.put(childViewHolderInt2, infoRecord3);
                        }
                        infoRecord3.flags |= 2;
                        infoRecord3.preInfo = obj2;
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
    }

    public final void dispatchLayoutStep2() {
        boolean z;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.mLayoutState;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        State state = this.mState;
        state.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, state);
        State state2 = this.mState;
        state2.mStructureChanged = false;
        if (!state2.mRunSimpleAnimations || this.mItemAnimator == null) {
            z = false;
        } else {
            z = true;
        }
        state2.mRunSimpleAnimations = z;
        state2.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().dispatchNestedScrollInternal(i, i2, i3, i4, iArr, 0, null);
    }

    public void dispatchOnScrollStateChanged(int i) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(this, i);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        OnScrollListener onScrollListener = this.mScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScrolled(this, i, i2);
        }
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = this.mPendingAccessibilityImportanceChange.get(size);
            if (viewHolder.itemView.getParent() == this && !viewHolder.shouldIgnore() && (i = viewHolder.mPendingAccessibilityState) != -1) {
                viewHolder.itemView.setImportantForAccessibility(i);
                viewHolder.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        int i2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z4 = false;
        for (int i3 = 0; i3 < size; i3++) {
            this.mItemDecorations.get(i3).onDrawOver(canvas, this);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z5 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            if (this.mClipToPadding) {
                i2 = getPaddingBottom();
            } else {
                i2 = 0;
            }
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + i2, DECELERATION_RATE);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            if (edgeEffect2 == null || !edgeEffect2.draw(canvas)) {
                z = false;
            } else {
                z = true;
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            if (edgeEffect4 == null || !edgeEffect4.draw(canvas)) {
                z3 = false;
            } else {
                z3 = true;
            }
            z |= z3;
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            if (this.mClipToPadding) {
                i = getPaddingTop();
            } else {
                i = 0;
            }
            canvas.rotate(90.0f);
            canvas.translate(i, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            if (edgeEffect6 == null || !edgeEffect6.draw(canvas)) {
                z2 = false;
            } else {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z |= z4;
            canvas.restoreToCount(save4);
        }
        if (z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            z5 = z;
        }
        if (z5) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            ((StretchEdgeEffectFactory) this.mEdgeEffectFactory).getClass();
            EdgeEffect edgeEffect = new EdgeEffect(getContext());
            this.mBottomGlow = edgeEffect;
            if (this.mClipToPadding) {
                edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            ((StretchEdgeEffectFactory) this.mEdgeEffectFactory).getClass();
            EdgeEffect edgeEffect = new EdgeEffect(getContext());
            this.mLeftGlow = edgeEffect;
            if (this.mClipToPadding) {
                edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            ((StretchEdgeEffectFactory) this.mEdgeEffectFactory).getClass();
            EdgeEffect edgeEffect = new EdgeEffect(getContext());
            this.mRightGlow = edgeEffect;
            if (this.mClipToPadding) {
                edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            ((StretchEdgeEffectFactory) this.mEdgeEffectFactory).getClass();
            EdgeEffect edgeEffect = new EdgeEffect(getContext());
            this.mTopGlow = edgeEffect;
            if (this.mClipToPadding) {
                edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final void fillRemainingScrollValues(State state) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.mOverScroller;
            overScroller.getFinalX();
            overScroller.getCurrX();
            state.getClass();
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        state.getClass();
    }

    public View findChildViewUnder(float f, float f2) {
        for (int childCount = this.mChildHelper.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mChildHelper.getChildAt(childCount);
            float translationX = childAt.getTranslationX();
            float translationY = childAt.getTranslationY();
            if (f >= childAt.getLeft() + translationX && f <= childAt.getRight() + translationX && f2 >= childAt.getTop() + translationY && f2 <= childAt.getBottom() + translationY) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            return r3
        L17:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public ViewHolder findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean findInterceptingOnItemTouchListener(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$OnItemTouchListener> r1 = r11.mOnItemTouchListeners
            int r1 = r1.size()
            r2 = 0
            r3 = 0
        Lc:
            if (r3 >= r1) goto L69
            java.util.ArrayList<androidx.recyclerview.widget.RecyclerView$OnItemTouchListener> r4 = r11.mOnItemTouchListeners
            java.lang.Object r4 = r4.get(r3)
            androidx.recyclerview.widget.RecyclerView$OnItemTouchListener r4 = (androidx.recyclerview.widget.RecyclerView.OnItemTouchListener) r4
            r5 = r4
            androidx.recyclerview.widget.FastScroller r5 = (androidx.recyclerview.widget.FastScroller) r5
            int r6 = r5.mState
            r7 = 1
            r8 = 2
            if (r6 != r7) goto L5e
            float r6 = r12.getX()
            float r9 = r12.getY()
            boolean r6 = r5.isPointInsideVerticalThumb(r6, r9)
            float r9 = r12.getX()
            float r10 = r12.getY()
            boolean r9 = r5.isPointInsideHorizontalThumb(r9, r10)
            int r10 = r12.getAction()
            if (r10 != 0) goto L66
            if (r6 != 0) goto L41
            if (r9 == 0) goto L66
        L41:
            if (r9 == 0) goto L4e
            r5.mDragState = r7
            float r6 = r12.getX()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.mHorizontalDragX = r6
            goto L5a
        L4e:
            if (r6 == 0) goto L5a
            r5.mDragState = r8
            float r6 = r12.getY()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.mVerticalDragY = r6
        L5a:
            r5.setState(r8)
            goto L60
        L5e:
            if (r6 != r8) goto L66
        L60:
            r5 = 3
            if (r0 == r5) goto L66
            r11.mInterceptingOnItemTouchListener = r4
            return r7
        L66:
            int r3 = r3 + 1
            goto Lc
        L69:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findInterceptingOnItemTouchListener(android.view.MotionEvent):boolean");
    }

    public final void findMinMaxChildLayoutPositions(int[] iArr) {
        int childCount = this.mChildHelper.getChildCount();
        if (childCount == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getChildAt(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public ViewHolder findViewHolderForAdapterPosition(int i) {
        ViewHolder viewHolder = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i) {
                ChildHelper childHelper = this.mChildHelper;
                if (!childHelper.mHiddenViews.contains(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                viewHolder = childViewHolderInt;
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForItemId(long j) {
        Adapter adapter = this.mAdapter;
        ViewHolder viewHolder = null;
        if (adapter != null && adapter.hasStableIds()) {
            int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
            for (int i = 0; i < unfilteredChildCount; i++) {
                ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    ChildHelper childHelper = this.mChildHelper;
                    if (!childHelper.mHiddenViews.contains(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    viewHolder = childViewHolderInt;
                }
            }
        }
        return viewHolder;
    }

    public ViewHolder findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    public boolean fling(int i, int i2) {
        return fling(i, i2, this.mMinFlingVelocity, this.mMaxFlingVelocity);
    }

    public boolean flingNoThresholdCheck(int i, int i2) {
        return fling(i, i2, 0, Integer.MAX_VALUE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0171, code lost:
        if (r11 > 0) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0188, code lost:
        if (r5 > 0) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x018b, code lost:
        if (r11 < 0) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x018e, code lost:
        if (r5 < 0) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0197, code lost:
        if ((r5 * r6) <= 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x01a0, code lost:
        if ((r5 * r6) >= 0) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(ViewModelProvider.Factory.CC.m(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(ViewModelProvider.Factory.CC.m(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(ViewHolder viewHolder) {
        if (viewHolder.hasAnyOfTheFlags(524) || !viewHolder.isBound()) {
            return -1;
        }
        AdapterHelper adapterHelper = this.mAdapterHelper;
        int i = viewHolder.mPosition;
        ArrayList arrayList = adapterHelper.mPendingUpdates;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            AdapterHelper.UpdateOp updateOp = (AdapterHelper.UpdateOp) arrayList.get(i2);
            int i3 = updateOp.cmd;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = updateOp.positionStart;
                    if (i4 <= i) {
                        int i5 = updateOp.itemCount;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = updateOp.positionStart;
                    if (i6 == i) {
                        i = updateOp.itemCount;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (updateOp.itemCount <= i) {
                            i++;
                        }
                    }
                }
            } else if (updateOp.positionStart <= i) {
                i += updateOp.itemCount;
            }
        }
        return i;
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.getBaseline();
        }
        return super.getBaseline();
    }

    public long getChangedHolderKey(ViewHolder viewHolder) {
        if (this.mAdapter.hasStableIds()) {
            return viewHolder.getItemId();
        }
        return viewHolder.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        return super.getChildDrawingOrder(i, i2);
    }

    public long getChildItemId(View view) {
        ViewHolder childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public ViewHolder getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        boolean z = layoutParams.mInsetsDirty;
        Rect rect = layoutParams.mDecorInsets;
        if (!z || (this.mState.mInPreLayout && (layoutParams.mViewHolder.isUpdated() || layoutParams.mViewHolder.isInvalid()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this);
            int i2 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.mInsetsDirty = false;
        return rect;
    }

    public ItemDecoration getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.mItemDecorations.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent(0);
    }

    public boolean hasPendingAdapterUpdates() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.hasPendingUpdates()) {
            return true;
        }
        return false;
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AnonymousClass5());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
        }
        Resources resources = getContext().getResources();
        new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                layoutManager.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return false;
        }
        return true;
    }

    public boolean isAnimating() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator == null || !itemAnimator.isRunning()) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter > 0) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().mIsNestedScrollingEnabled;
    }

    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    public void markItemDecorInsetsDirty() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
        }
        ArrayList arrayList = this.mRecycler.mCachedViews;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            LayoutParams layoutParams = (LayoutParams) ((ViewHolder) arrayList.get(i2)).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.mInsetsDirty = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        Recycler recycler = this.mRecycler;
        ArrayList arrayList = recycler.mCachedViews;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i2);
            if (viewHolder != null) {
                viewHolder.addFlags(6);
                viewHolder.addChangePayload(null);
            }
        }
        Adapter adapter = RecyclerView.this.mAdapter;
        if (adapter == null || !adapter.hasStableIds()) {
            recycler.recycleAndClearCachedViews();
        }
    }

    public void nestedScrollBy(int i, int i2) {
        nestedScrollByInternal(i, i2, null);
    }

    public final void nestedScrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int i3;
        float f;
        float f2;
        int i4;
        int i5;
        int i6;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int[] iArr = this.mReusableIntPair;
            int i7 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollVertically) {
                i3 = canScrollHorizontally | 2;
            } else {
                i3 = canScrollHorizontally;
            }
            if (motionEvent == null) {
                f = getHeight() / 2.0f;
            } else {
                f = motionEvent.getY();
            }
            if (motionEvent == null) {
                f2 = getWidth() / 2.0f;
            } else {
                f2 = motionEvent.getX();
            }
            int releaseHorizontalGlow = i - releaseHorizontalGlow(i, f);
            int releaseVerticalGlow$1 = i2 - releaseVerticalGlow$1(i2, f2);
            startNestedScroll(i3, 1);
            if (canScrollHorizontally) {
                i4 = releaseHorizontalGlow;
            } else {
                i4 = 0;
            }
            if (canScrollVertically) {
                i5 = releaseVerticalGlow$1;
            } else {
                i5 = 0;
            }
            if (dispatchNestedPreScroll(i4, i5, this.mReusableIntPair, this.mScrollOffset, 1)) {
                int[] iArr2 = this.mReusableIntPair;
                releaseHorizontalGlow -= iArr2[0];
                releaseVerticalGlow$1 -= iArr2[1];
            }
            if (canScrollHorizontally) {
                i6 = releaseHorizontalGlow;
            } else {
                i6 = 0;
            }
            if (canScrollVertically) {
                i7 = releaseVerticalGlow$1;
            }
            scrollByInternal(i6, i7, motionEvent, 1);
            GapWorker gapWorker = this.mGapWorker;
            if (!(gapWorker == null || (releaseHorizontalGlow == 0 && releaseVerticalGlow$1 == 0))) {
                gapWorker.postFromTraversal(this, releaseHorizontalGlow, releaseVerticalGlow$1);
            }
            stopNestedScroll(1);
        }
    }

    public void offsetChildrenHorizontal(int i) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.mChildHelper.getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        int childCount = this.mChildHelper.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            this.mChildHelper.getChildAt(i2).offsetTopAndBottom(i);
        }
    }

    public void offsetPositionRecordsForInsert(int i, int i2) {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i3 = 0; i3 < unfilteredChildCount; i3++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForInsert attached child " + i3 + " holder " + childViewHolderInt + " now at position " + (childViewHolderInt.mPosition + i2));
                }
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.mStructureChanged = true;
            }
        }
        ArrayList arrayList = this.mRecycler.mCachedViews;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i4);
            if (viewHolder != null && viewHolder.mPosition >= i) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForInsert cached " + i4 + " holder " + viewHolder + " now at position " + (viewHolder.mPosition + i2));
                }
                viewHolder.offsetPosition(i2, false);
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        int i10 = -1;
        if (i < i2) {
            i5 = i;
            i4 = i2;
            i3 = -1;
        } else {
            i4 = i;
            i5 = i2;
            i3 = 1;
        }
        for (int i11 = 0; i11 < unfilteredChildCount; i11++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i11));
            if (childViewHolderInt != null && (i9 = childViewHolderInt.mPosition) >= i5 && i9 <= i4) {
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForMove attached child " + i11 + " holder " + childViewHolderInt);
                }
                if (childViewHolderInt.mPosition == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i3, false);
                }
                this.mState.mStructureChanged = true;
            }
        }
        ArrayList arrayList = this.mRecycler.mCachedViews;
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(i12);
            if (viewHolder != null && (i8 = viewHolder.mPosition) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    viewHolder.offsetPosition(i2 - i, false);
                } else {
                    viewHolder.offsetPosition(i10, false);
                }
                if (sVerboseLoggingEnabled) {
                    Log.d(TAG, "offsetPositionRecordsForMove cached child " + i12 + " holder " + viewHolder);
                }
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i4 = 0; i4 < unfilteredChildCount; i4++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i5 = childViewHolderInt.mPosition;
                if (i5 >= i3) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + i4 + " holder " + childViewHolderInt + " now at position " + (childViewHolderInt.mPosition - i2));
                    }
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.mStructureChanged = true;
                } else if (i5 >= i) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + i4 + " holder " + childViewHolderInt + " now REMOVED");
                    }
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.mStructureChanged = true;
                }
            }
        }
        Recycler recycler = this.mRecycler;
        ArrayList arrayList = recycler.mCachedViews;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
            if (viewHolder != null) {
                int i6 = viewHolder.mPosition;
                if (i6 >= i3) {
                    if (sVerboseLoggingEnabled) {
                        Log.d(TAG, "offsetPositionRecordsForRemove cached " + size + " holder " + viewHolder + " now at position " + (viewHolder.mPosition - i2));
                    }
                    viewHolder.offsetPosition(-i2, z);
                } else if (i6 >= i) {
                    viewHolder.addFlags(8);
                    recycler.recycleCachedViewAt(size);
                }
            }
        }
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
        if (r1 >= 30.0f) goto L20;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.mLayoutOrScrollCounter = r0
            r1 = 1
            r5.mIsAttached = r1
            boolean r2 = r5.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r5.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$Recycler r1 = r5.mRecycler
            r1.maybeSendPoolingContainerAttach()
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r5.mLayout
            if (r1 == 0) goto L23
            r1.dispatchAttachedToWindow(r5)
        L23:
            r5.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L7d
            java.lang.ThreadLocal r0 = androidx.recyclerview.widget.GapWorker.sGapWorker
            java.lang.Object r1 = r0.get()
            androidx.recyclerview.widget.GapWorker r1 = (androidx.recyclerview.widget.GapWorker) r1
            r5.mGapWorker = r1
            if (r1 != 0) goto L63
            androidx.recyclerview.widget.GapWorker r1 = new androidx.recyclerview.widget.GapWorker
            r1.<init>()
            r5.mGapWorker = r1
            java.util.WeakHashMap r1 = androidx.core.view.ViewCompat.sViewPropertyAnimatorMap
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L55
            if (r1 == 0) goto L55
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L55
            goto L57
        L55:
            r1 = 1114636288(0x42700000, float:60.0)
        L57:
            androidx.recyclerview.widget.GapWorker r2 = r5.mGapWorker
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.mFrameIntervalNs = r3
            r0.set(r2)
        L63:
            androidx.recyclerview.widget.GapWorker r0 = r5.mGapWorker
            java.util.ArrayList r0 = r0.mRecyclerViews
            boolean r1 = androidx.recyclerview.widget.RecyclerView.sDebugAssertionsEnabled
            if (r1 == 0) goto L7a
            boolean r1 = r0.contains(r5)
            if (r1 != 0) goto L72
            goto L7a
        L72:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "RecyclerView already present in worker list!"
            r0.<init>(r1)
            throw r0
        L7a:
            r0.add(r5)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        GapWorker gapWorker;
        super.onDetachedFromWindow();
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        stopScroll();
        int i = 0;
        this.mIsAttached = false;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.getClass();
        do {
        } while (ViewInfoStore.InfoRecord.sPool.acquire() != null);
        Recycler recycler = this.mRecycler;
        ArrayList arrayList = recycler.mCachedViews;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            BundleKt.callPoolingContainerOnRelease(((ViewHolder) arrayList.get(i2)).itemView);
        }
        recycler.poolingContainerDetach(RecyclerView.this.mAdapter, false);
        while (i < getChildCount()) {
            int i3 = i + 1;
            View childAt = getChildAt(i);
            if (childAt != null) {
                PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) childAt.getTag(R.id.pooling_container_listener_holder_tag);
                if (poolingContainerListenerHolder == null) {
                    poolingContainerListenerHolder = new PoolingContainerListenerHolder();
                    childAt.setTag(R.id.pooling_container_listener_holder_tag, poolingContainerListenerHolder);
                }
                ArrayList arrayList2 = poolingContainerListenerHolder.listeners;
                int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList2);
                if (-1 >= lastIndex) {
                    i = i3;
                } else {
                    arrayList2.get(lastIndex).getClass();
                    throw new ClassCastException();
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        if (ALLOW_THREAD_GAP_WORK && (gapWorker = this.mGapWorker) != null) {
            boolean remove = gapWorker.mRecyclerViews.remove(this);
            if (!sDebugAssertionsEnabled || remove) {
                this.mGapWorker = null;
                return;
            }
            throw new IllegalStateException("RecyclerView removal failed!");
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
        if (r13.mLayout.canScrollHorizontally() != false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1 A[ADDED_TO_REGION] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            r1 = 0
            if (r0 != 0) goto L8
        L5:
            r7 = r13
            goto La8
        L8:
            boolean r0 = r13.mLayoutSuppressed
            if (r0 == 0) goto Ld
            goto L5
        Ld:
            int r0 = r14.getAction()
            r2 = 8
            if (r0 != r2) goto L5
            int r0 = r14.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L47
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r13.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2e
            r0 = 9
            float r0 = r14.getAxisValue(r0)
            float r0 = -r0
            goto L2f
        L2e:
            r0 = 0
        L2f:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = r13.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L42
            r2 = 10
            float r2 = r14.getAxisValue(r2)
            r3 = r2
            r4 = 0
            r2 = r0
            r0 = 0
            goto L6c
        L42:
            r2 = r0
        L43:
            r0 = 0
            r3 = 0
            r4 = 0
            goto L6c
        L47:
            int r0 = r14.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L43
            r0 = 26
            float r3 = r14.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = r13.mLayout
            boolean r4 = r4.canScrollVertically()
            if (r4 == 0) goto L62
            float r3 = -r3
            r2 = r3
        L60:
            r3 = 0
            goto L6a
        L62:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = r13.mLayout
            boolean r4 = r4.canScrollHorizontally()
            if (r4 == 0) goto L60
        L6a:
            boolean r4 = r13.mLowResRotaryEncoderFeature
        L6c:
            float r5 = r13.mScaledVerticalScrollFactor
            float r2 = r2 * r5
            int r2 = (int) r2
            float r5 = r13.mScaledHorizontalScrollFactor
            float r3 = r3 * r5
            int r3 = (int) r3
            if (r4 == 0) goto L9b
            androidx.recyclerview.widget.RecyclerView$ViewFlinger r5 = r13.mViewFlinger
            android.widget.OverScroller r5 = r5.mOverScroller
            int r6 = r5.getFinalY()
            int r7 = r5.getCurrY()
            int r6 = r6 - r7
            int r9 = r6 + r2
            int r2 = r5.getFinalX()
            int r5 = r5.getCurrX()
            int r2 = r2 - r5
            int r8 = r2 + r3
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            r12 = 1
            r10 = 0
            r7 = r13
            r7.smoothScrollBy(r8, r9, r10, r11, r12)
            goto L9f
        L9b:
            r7 = r13
            r13.nestedScrollByInternal(r3, r2, r14)
        L9f:
            if (r0 == 0) goto La8
            if (r4 != 0) goto La8
            androidx.core.view.DifferentialMotionFlingController r2 = r7.mDifferentialMotionFlingController
            r2.onMotionEvent(r14, r0)
        La8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (!this.mLayoutSuppressed) {
            this.mInterceptingOnItemTouchListener = null;
            if (findInterceptingOnItemTouchListener(motionEvent)) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                stopNestedScroll(0);
                releaseGlows();
                setScrollState(0);
                return true;
            }
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager != null) {
                boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
                boolean canScrollVertically = this.mLayout.canScrollVertically();
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.mIgnoreMotionEventTillDown) {
                        this.mIgnoreMotionEventTillDown = false;
                    }
                    this.mScrollPointerId = motionEvent.getPointerId(0);
                    int x = (int) (motionEvent.getX() + 0.5f);
                    this.mLastTouchX = x;
                    this.mInitialTouchX = x;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.mLastTouchY = y;
                    this.mInitialTouchY = y;
                    EdgeEffect edgeEffect = this.mLeftGlow;
                    if (edgeEffect == null || BundleKt.getDistance(edgeEffect) == DECELERATION_RATE || canScrollHorizontally(-1)) {
                        z = false;
                    } else {
                        BundleKt.onPullDistance(this.mLeftGlow, DECELERATION_RATE, 1.0f - (motionEvent.getY() / getHeight()));
                        z = true;
                    }
                    EdgeEffect edgeEffect2 = this.mRightGlow;
                    if (!(edgeEffect2 == null || BundleKt.getDistance(edgeEffect2) == DECELERATION_RATE || canScrollHorizontally(1))) {
                        BundleKt.onPullDistance(this.mRightGlow, DECELERATION_RATE, motionEvent.getY() / getHeight());
                        z = true;
                    }
                    EdgeEffect edgeEffect3 = this.mTopGlow;
                    if (!(edgeEffect3 == null || BundleKt.getDistance(edgeEffect3) == DECELERATION_RATE || canScrollVertically(-1))) {
                        BundleKt.onPullDistance(this.mTopGlow, DECELERATION_RATE, motionEvent.getX() / getWidth());
                        z = true;
                    }
                    EdgeEffect edgeEffect4 = this.mBottomGlow;
                    if (!(edgeEffect4 == null || BundleKt.getDistance(edgeEffect4) == DECELERATION_RATE || canScrollVertically(1))) {
                        BundleKt.onPullDistance(this.mBottomGlow, DECELERATION_RATE, 1.0f - (motionEvent.getX() / getWidth()));
                        z = true;
                    }
                    if (z || this.mScrollState == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        stopNestedScroll(1);
                    }
                    int[] iArr = this.mNestedOffsets;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    startNestedScrollForType(0);
                } else if (actionMasked == 1) {
                    this.mVelocityTracker.clear();
                    stopNestedScroll(0);
                } else if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
                    if (findPointerIndex < 0) {
                        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
                    if (this.mScrollState != 1) {
                        int i = x2 - this.mInitialTouchX;
                        int i2 = y2 - this.mInitialTouchY;
                        if (!canScrollHorizontally || Math.abs(i) <= this.mTouchSlop) {
                            z2 = false;
                        } else {
                            this.mLastTouchX = x2;
                            z2 = true;
                        }
                        if (canScrollVertically && Math.abs(i2) > this.mTouchSlop) {
                            this.mLastTouchY = y2;
                            z2 = true;
                        }
                        if (z2) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                    if (velocityTracker2 != null) {
                        velocityTracker2.clear();
                    }
                    stopNestedScroll(0);
                    releaseGlows();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
                    int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.mLastTouchX = x3;
                    this.mInitialTouchX = x3;
                    int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.mLastTouchY = y3;
                    this.mInitialTouchY = y3;
                } else if (actionMasked == 6) {
                    onPointerUp(motionEvent);
                }
                if (this.mScrollState == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Trace.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        Trace.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (layoutManager.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z;
            if (!z && this.mAdapter != null) {
                if (this.mState.mLayoutStep == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i, i2);
                this.mState.mIsMeasuring = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.mIsMeasuring = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i, i2);
                }
                this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
                this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                State state = this.mState;
                if (state.mRunPredictiveAnimations) {
                    state.mInPreLayout = true;
                } else {
                    this.mAdapterHelper.consumeUpdatesInOnePass();
                    this.mState.mInPreLayout = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.mRunPredictiveAnimations) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                this.mState.mItemCount = adapter.getItemCount();
            } else {
                this.mState.mItemCount = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            stopInterceptRequestLayout(false);
            this.mState.mInPreLayout = false;
        }
    }

    public final void onPointerUp(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.mSuperState);
        requestLayout();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.recyclerview.widget.RecyclerView$SavedState, androidx.customview.view.AbsSavedState] */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            absSavedState.mLayoutState = savedState.mLayoutState;
            return absSavedState;
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            absSavedState.mLayoutState = layoutManager.onSaveInstanceState();
            return absSavedState;
        }
        absSavedState.mLayoutState = null;
        return absSavedState;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            invalidateGlows();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0212  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 799
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            Runnable runnable = this.mItemAnimatorRunner;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            postOnAnimation(runnable);
            this.mPostedAnimatorRunner = true;
        }
    }

    public final void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            AdapterHelper adapterHelper = this.mAdapterHelper;
            adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPendingUpdates);
            adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPostponedList);
            adapterHelper.mExistingUpdateTypes = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (this.mItemAnimator == null || !this.mLayout.supportsPredictiveItemAnimations()) {
            this.mAdapterHelper.consumeUpdatesInOnePass();
        } else {
            this.mAdapterHelper.preProcess();
        }
        if (this.mItemsAddedOrRemoved || this.mItemsChanged) {
            z = true;
        } else {
            z = false;
        }
        State state = this.mState;
        if (!this.mFirstLayoutComplete || this.mItemAnimator == null || ((!(z3 = this.mDataSetHasChangedAfterLayout) && !z && !this.mLayout.mRequestedSimpleAnimations) || (z3 && !this.mAdapter.hasStableIds()))) {
            z2 = false;
        } else {
            z2 = true;
        }
        state.mRunSimpleAnimations = z2;
        State state2 = this.mState;
        if (state2.mRunSimpleAnimations && z && !this.mDataSetHasChangedAfterLayout && this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations()) {
            z4 = true;
        }
        state2.mRunPredictiveAnimations = z4;
    }

    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder viewHolder, ItemAnimator.ItemHolderInfo itemHolderInfo) {
        viewHolder.setFlags(0, CaptureService.CONNECTIONS_LOG_SIZE);
        if (this.mState.mTrackOldChangeHolders && viewHolder.isUpdated() && !viewHolder.isRemoved() && !viewHolder.shouldIgnore()) {
            this.mViewInfoStore.mOldChangedHolders.put(getChangedHolderKey(viewHolder), viewHolder);
        }
        SimpleArrayMap simpleArrayMap = this.mViewInfoStore.mLayoutHolderMap;
        ViewInfoStore.InfoRecord infoRecord = (ViewInfoStore.InfoRecord) simpleArrayMap.get(viewHolder);
        if (infoRecord == null) {
            infoRecord = ViewInfoStore.InfoRecord.obtain();
            simpleArrayMap.put(viewHolder, infoRecord);
        }
        infoRecord.preInfo = itemHolderInfo;
        infoRecord.flags |= 4;
    }

    public final void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            postInvalidateOnAnimation();
        }
    }

    public final int releaseHorizontalGlow(int i, float f) {
        float height = f / getHeight();
        float width = i / getWidth();
        EdgeEffect edgeEffect = this.mLeftGlow;
        float f2 = DECELERATION_RATE;
        if (edgeEffect == null || BundleKt.getDistance(edgeEffect) == DECELERATION_RATE) {
            EdgeEffect edgeEffect2 = this.mRightGlow;
            if (!(edgeEffect2 == null || BundleKt.getDistance(edgeEffect2) == DECELERATION_RATE)) {
                if (canScrollHorizontally(1)) {
                    this.mRightGlow.onRelease();
                } else {
                    float onPullDistance = BundleKt.onPullDistance(this.mRightGlow, width, height);
                    if (BundleKt.getDistance(this.mRightGlow) == DECELERATION_RATE) {
                        this.mRightGlow.onRelease();
                    }
                    f2 = onPullDistance;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.mLeftGlow.onRelease();
            } else {
                float f3 = -BundleKt.onPullDistance(this.mLeftGlow, -width, 1.0f - height);
                if (BundleKt.getDistance(this.mLeftGlow) == DECELERATION_RATE) {
                    this.mLeftGlow.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getWidth());
    }

    public final int releaseVerticalGlow$1(int i, float f) {
        float width = f / getWidth();
        float height = i / getHeight();
        EdgeEffect edgeEffect = this.mTopGlow;
        float f2 = DECELERATION_RATE;
        if (edgeEffect == null || BundleKt.getDistance(edgeEffect) == DECELERATION_RATE) {
            EdgeEffect edgeEffect2 = this.mBottomGlow;
            if (!(edgeEffect2 == null || BundleKt.getDistance(edgeEffect2) == DECELERATION_RATE)) {
                if (canScrollVertically(1)) {
                    this.mBottomGlow.onRelease();
                } else {
                    float onPullDistance = BundleKt.onPullDistance(this.mBottomGlow, height, 1.0f - width);
                    if (BundleKt.getDistance(this.mBottomGlow) == DECELERATION_RATE) {
                        this.mBottomGlow.onRelease();
                    }
                    f2 = onPullDistance;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.mTopGlow.onRelease();
            } else {
                float f3 = -BundleKt.onPullDistance(this.mTopGlow, -height, width);
                if (BundleKt.getDistance(this.mTopGlow) == DECELERATION_RATE) {
                    this.mTopGlow.onRelease();
                }
                f2 = f3;
            }
            invalidate();
        }
        return Math.round(f2 * getHeight());
    }

    public void removeAndRecycleViews() {
        ItemAnimator itemAnimator = this.mItemAnimator;
        if (itemAnimator != null) {
            itemAnimator.endAnimations();
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        Recycler recycler = this.mRecycler;
        recycler.mAttachedScrap.clear();
        recycler.recycleAndClearCachedViews();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        ChildHelper childHelper = this.mChildHelper;
        ChildHelper.Bucket bucket = childHelper.mBucket;
        AnonymousClass5 r2 = childHelper.mCallback;
        int i = childHelper.mRemoveStatus;
        boolean z = false;
        z = false;
        if (i == 1) {
            if (childHelper.mViewInRemoveView != view) {
                throw new IllegalStateException("Cannot call removeViewIfHidden within removeView(At) for a different view");
            }
        } else if (i != 2) {
            try {
                childHelper.mRemoveStatus = 2;
                int indexOfChild = RecyclerView.this.indexOfChild(view);
                if (indexOfChild == -1) {
                    childHelper.unhideViewInternal(view);
                } else if (bucket.get(indexOfChild)) {
                    bucket.remove(indexOfChild);
                    childHelper.unhideViewInternal(view);
                    r2.removeViewAt(indexOfChild);
                }
                childHelper.mRemoveStatus = 0;
                z = true;
            } finally {
                childHelper.mRemoveStatus = 0;
            }
        } else {
            throw new IllegalStateException("Cannot call removeViewIfHidden within removeViewIfHidden");
        }
        if (z) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.unscrapView(childViewHolderInt);
            this.mRecycler.recycleViewHolderInternal(childViewHolderInt);
            if (sVerboseLoggingEnabled) {
                Log.d(TAG, "after removing animated view: " + view + ", " + this);
            }
        }
        stopInterceptRequestLayout(!z ? 1 : 0);
        return z;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        ViewHolder childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(this, sb));
            }
        } else if (sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(this, sb2));
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(ItemDecoration itemDecoration) {
        boolean z;
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(itemDecoration);
        if (this.mItemDecorations.isEmpty()) {
            if (getOverScrollMode() == 2) {
                z = true;
            } else {
                z = false;
            }
            setWillNotDraw(z);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i < 0 || i >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i));
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener onChildAttachStateChangeListener) {
        List<OnChildAttachStateChangeListener> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(onChildAttachStateChangeListener);
        }
    }

    public void removeOnItemTouchListener(OnItemTouchListener onItemTouchListener) {
        this.mOnItemTouchListeners.remove(onItemTouchListener);
        if (this.mInterceptingOnItemTouchListener == onItemTouchListener) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(OnScrollListener onScrollListener) {
        List<OnScrollListener> list = this.mScrollListeners;
        if (list != null) {
            list.remove(onScrollListener);
        }
    }

    public void removeRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecyclerListeners.remove(recyclerListener);
    }

    public void repositionShadowingViews() {
        ViewHolder viewHolder;
        int childCount = this.mChildHelper.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mChildHelper.getChildAt(i);
            ViewHolder childViewHolder = getChildViewHolder(childAt);
            if (!(childViewHolder == null || (viewHolder = childViewHolder.mShadowingHolder) == null)) {
                View view = viewHolder.itemView;
                int left = childAt.getLeft();
                int top = childAt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public final void requestChildOnScreen(View view, View view2) {
        View view3;
        boolean z;
        if (view2 != null) {
            view3 = view2;
        } else {
            view3 = view;
        }
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.mInsetsDirty) {
                Rect rect = layoutParams2.mDecorInsets;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        LayoutManager layoutManager = this.mLayout;
        Rect rect3 = this.mTempRect;
        boolean z2 = !this.mFirstLayoutComplete;
        if (view2 == null) {
            z = true;
        } else {
            z = false;
        }
        layoutManager.requestChildRectangleOnScreen(this, view, rect3, z2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        for (int i = 0; i < unfilteredChildCount; i++) {
            ViewHolder childViewHolderInt = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
            if (!sDebugAssertionsEnabled || childViewHolderInt.mPosition != -1 || childViewHolderInt.isRemoved()) {
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.saveOldPosition();
                }
            } else {
                throw new IllegalStateException(ViewModelProvider.Factory.CC.m(this, new StringBuilder("view holder cannot have position -1 unless it is removed")));
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, null, 0);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean scrollByInternal(int r20, int r21, android.view.MotionEvent r22, int r23) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.scrollByInternal(int, int, android.view.MotionEvent, int):boolean");
    }

    public void scrollStep(int i, int i2, int[] iArr) {
        int i3;
        int i4;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        Trace.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (i != 0) {
            i3 = this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState);
        } else {
            i3 = 0;
        }
        if (i2 != 0) {
            i4 = this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState);
        } else {
            i4 = 0;
        }
        Trace.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = i3;
            iArr[1] = i4;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            layoutManager.scrollToPosition(i);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
        this.mAccessibilityDelegate = recyclerViewAccessibilityDelegate;
        ViewCompat.setAccessibilityDelegate(this, recyclerViewAccessibilityDelegate);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public final void setAdapterInternal(Adapter adapter, boolean z, boolean z2) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        AdapterHelper adapterHelper = this.mAdapterHelper;
        adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPendingUpdates);
        adapterHelper.recycleUpdateOpsAndClearList(adapterHelper.mPostponedList);
        adapterHelper.mExistingUpdateTypes = 0;
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.onAdapterChanged(adapter3, this.mAdapter);
        }
        Recycler recycler = this.mRecycler;
        Adapter adapter4 = this.mAdapter;
        recycler.mAttachedScrap.clear();
        recycler.recycleAndClearCachedViews();
        recycler.poolingContainerDetach(adapter3, true);
        RecycledViewPool recycledViewPool = recycler.getRecycledViewPool();
        if (adapter3 != null) {
            recycledViewPool.mAttachCountForClearing--;
        }
        if (!z && recycledViewPool.mAttachCountForClearing == 0) {
            SparseArray sparseArray = recycledViewPool.mScrap;
            for (int i = 0; i < sparseArray.size(); i++) {
                RecycledViewPool.ScrapData scrapData = (RecycledViewPool.ScrapData) sparseArray.valueAt(i);
                ArrayList arrayList = scrapData.mScrapHeap;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    BundleKt.callPoolingContainerOnRelease(((ViewHolder) obj).itemView);
                }
                scrapData.mScrapHeap.clear();
            }
        }
        if (adapter4 != null) {
            recycledViewPool.mAttachCountForClearing++;
        } else {
            recycledViewPool.getClass();
        }
        recycler.maybeSendPoolingContainerAttach();
        this.mState.mStructureChanged = true;
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != null) {
            setChildrenDrawingOrderEnabled(false);
        }
    }

    public boolean setChildImportantForAccessibilityInternal(ViewHolder viewHolder, int i) {
        if (isComputingLayout()) {
            viewHolder.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(viewHolder);
            return false;
        }
        viewHolder.itemView.setImportantForAccessibility(i);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(EdgeEffectFactory edgeEffectFactory) {
        edgeEffectFactory.getClass();
        this.mEdgeEffectFactory = edgeEffectFactory;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        ItemAnimator itemAnimator2 = this.mItemAnimator;
        if (itemAnimator2 != null) {
            itemAnimator2.endAnimations();
            this.mItemAnimator.mListener = null;
        }
        this.mItemAnimator = itemAnimator;
        if (itemAnimator != null) {
            itemAnimator.mListener = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int i) {
        Recycler recycler = this.mRecycler;
        recycler.mRequestedCacheMax = i;
        recycler.updateViewCacheSize();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                ItemAnimator itemAnimator = this.mItemAnimator;
                if (itemAnimator != null) {
                    itemAnimator.endAnimations();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                Recycler recycler = this.mRecycler;
                recycler.mAttachedScrap.clear();
                recycler.recycleAndClearCachedViews();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView(null);
                this.mLayout = null;
            } else {
                Recycler recycler2 = this.mRecycler;
                recycler2.mAttachedScrap.clear();
                recycler2.recycleAndClearCachedViews();
            }
            ChildHelper childHelper = this.mChildHelper;
            RecyclerView recyclerView = RecyclerView.this;
            childHelper.mBucket.reset();
            ArrayList arrayList = childHelper.mHiddenViews;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ViewHolder childViewHolderInt = getChildViewHolderInt((View) arrayList.get(size));
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(recyclerView);
                }
                arrayList.remove(size);
            }
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                recyclerView.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            recyclerView.removeAllViews();
            this.mLayout = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.mRecyclerView == null) {
                    layoutManager.setRecyclerView(this);
                    if (this.mIsAttached) {
                        this.mLayout.dispatchAttachedToWindow(this);
                    }
                } else {
                    StringBuilder sb = new StringBuilder("LayoutManager ");
                    sb.append(layoutManager);
                    sb.append(" is already attached to a RecyclerView:");
                    throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m(layoutManager.mRecyclerView, sb));
                }
            }
            this.mRecycler.updateViewCacheSize();
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.mIsNestedScrollingEnabled) {
            ViewGroup viewGroup = scrollingChildHelper.mView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.stopNestedScroll(viewGroup);
        }
        scrollingChildHelper.mIsNestedScrollingEnabled = z;
    }

    public void setOnFlingListener(OnFlingListener onFlingListener) {
        this.mOnFlingListener = onFlingListener;
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(RecycledViewPool recycledViewPool) {
        RecycledViewPool recycledViewPool2;
        Recycler recycler = this.mRecycler;
        RecyclerView recyclerView = RecyclerView.this;
        recycler.poolingContainerDetach(recyclerView.mAdapter, false);
        if (recycler.mRecyclerPool != null) {
            recycledViewPool2.mAttachCountForClearing--;
        }
        recycler.mRecyclerPool = recycledViewPool;
        if (!(recycledViewPool == null || recyclerView.getAdapter() == null)) {
            recycler.mRecyclerPool.mAttachCountForClearing++;
        }
        recycler.maybeSendPoolingContainerAttach();
    }

    @Deprecated
    public void setRecyclerListener(RecyclerListener recyclerListener) {
    }

    public void setScrollState(int i) {
        if (i != this.mScrollState) {
            if (sVerboseLoggingEnabled) {
                StringBuilder m = ViewModelProvider.Factory.CC.m("setting scroll state to ", i, " from ");
                m.append(this.mScrollState);
                Log.d(TAG, m.toString(), new Exception());
            }
            this.mScrollState = i;
            if (i != 2) {
                ViewFlinger viewFlinger = this.mViewFlinger;
                RecyclerView.this.removeCallbacks(viewFlinger);
                viewFlinger.mOverScroller.abortAnimation();
                LayoutManager layoutManager = this.mLayout;
                if (layoutManager != null) {
                    layoutManager.stopSmoothScroller();
                }
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension viewCacheExtension) {
        this.mRecycler.getClass();
    }

    public final boolean shouldAbsorb(EdgeEffect edgeEffect, int i, int i2) {
        if (i > 0) {
            return true;
        }
        float distance = BundleKt.getDistance(edgeEffect) * i2;
        double log = Math.log((Math.abs(-i) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION));
        double d = DECELERATION_RATE;
        if (((float) (Math.exp((d / (d - 1.0d)) * log) * this.mPhysicalCoef * SCROLL_FRICTION)) < distance) {
            return true;
        }
        return false;
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i;
        int i2 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        if (accessibilityEvent != null) {
            i = accessibilityEvent.getContentChangeTypes();
        } else {
            i = 0;
        }
        if (i != 0) {
            i2 = i;
        }
        this.mEatenAccessibilityChangeFlags |= i2;
        return true;
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollToPosition(int i) {
        if (!this.mLayoutSuppressed) {
            LayoutManager layoutManager = this.mLayout;
            if (layoutManager == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                layoutManager.smoothScrollToPosition(this, this.mState, i);
            }
        }
    }

    public void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().startNestedScroll(i, 0);
    }

    public final void startNestedScrollForType(int i) {
        boolean canScrollHorizontally = this.mLayout.canScrollHorizontally();
        if (this.mLayout.canScrollVertically()) {
            boolean z = canScrollHorizontally ? 1 : 0;
            char c = canScrollHorizontally ? 1 : 0;
            canScrollHorizontally = z | true;
        }
        int i2 = canScrollHorizontally ? 1 : 0;
        int i3 = canScrollHorizontally ? 1 : 0;
        startNestedScroll(i2, i);
    }

    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            if (!sDebugAssertionsEnabled) {
                this.mInterceptRequestLayoutDepth = 1;
            } else {
                throw new IllegalStateException(ViewModelProvider.Factory.CC.m(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll(0);
    }

    public void stopScroll() {
        setScrollState(0);
        ViewFlinger viewFlinger = this.mViewFlinger;
        RecyclerView.this.removeCallbacks(viewFlinger);
        viewFlinger.mOverScroller.abortAnimation();
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            layoutManager.stopSmoothScroller();
        }
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, DECELERATION_RATE, DECELERATION_RATE, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(Adapter adapter, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i, int i2, Object obj) {
        int i3;
        int i4;
        int unfilteredChildCount = this.mChildHelper.getUnfilteredChildCount();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < unfilteredChildCount; i6++) {
            View unfilteredChildAt = this.mChildHelper.getUnfilteredChildAt(i6);
            ViewHolder childViewHolderInt = getChildViewHolderInt(unfilteredChildAt);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i4 = childViewHolderInt.mPosition) >= i && i4 < i5) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) unfilteredChildAt.getLayoutParams()).mInsetsDirty = true;
            }
        }
        Recycler recycler = this.mRecycler;
        ArrayList arrayList = recycler.mCachedViews;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) arrayList.get(size);
            if (viewHolder != null && (i3 = viewHolder.mPosition) >= i && i3 < i5) {
                viewHolder.addFlags(2);
                recycler.recycleCachedViewAt(size);
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class Adapter {
        private final AdapterDataObservable mObservable = new Observable();
        private boolean mHasStableIds = false;
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* loaded from: classes.dex */
        public final class StateRestorationPolicy extends Enum {
            public static final /* synthetic */ StateRestorationPolicy[] $VALUES;
            public static final StateRestorationPolicy ALLOW;

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v0, types: [androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy, java.lang.Enum] */
            static {
                ?? r0 = new Enum("ALLOW", 0);
                ALLOW = r0;
                $VALUES = new StateRestorationPolicy[]{r0, new Enum("PREVENT_WHEN_EMPTY", 1), new Enum("PREVENT", 2)};
            }

            public static StateRestorationPolicy valueOf(String str) {
                return (StateRestorationPolicy) Enum.valueOf(StateRestorationPolicy.class, str);
            }

            public static StateRestorationPolicy[] values() {
                return (StateRestorationPolicy[]) $VALUES.clone();
            }
        }

        public final void bindViewHolder(ViewHolder viewHolder, int i) {
            boolean z;
            if (viewHolder.mBindingAdapter == null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                viewHolder.mPosition = i;
                if (hasStableIds()) {
                    viewHolder.mItemId = getItemId(i);
                }
                viewHolder.setFlags(1, 519);
                if (TraceCompat.isEnabled()) {
                    Trace.beginSection(String.format("RV onBindViewHolder type=0x%X", Integer.valueOf(viewHolder.mItemViewType)));
                }
            }
            viewHolder.mBindingAdapter = this;
            if (RecyclerView.sDebugAssertionsEnabled) {
                if (viewHolder.itemView.getParent() == null && viewHolder.itemView.isAttachedToWindow() != viewHolder.isTmpDetached()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + viewHolder.isTmpDetached() + ", attached to window: " + viewHolder.itemView.isAttachedToWindow() + ", holder: " + viewHolder);
                } else if (viewHolder.itemView.getParent() == null && viewHolder.itemView.isAttachedToWindow()) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + viewHolder);
                }
            }
            onBindViewHolder(viewHolder, i, viewHolder.getUnmodifiedPayloads());
            if (z) {
                viewHolder.clearPayload();
                ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).mInsetsDirty = true;
                }
                Trace.endSection();
            }
        }

        public boolean canRestoreState() {
            int ordinal = this.mStateRestorationPolicy.ordinal();
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return false;
                }
            } else if (getItemCount() <= 0) {
                return false;
            }
            return true;
        }

        public final ViewHolder createViewHolder(ViewGroup viewGroup, int i) {
            try {
                if (TraceCompat.isEnabled()) {
                    Trace.beginSection(String.format("RV onCreateViewHolder type=0x%X", Integer.valueOf(i)));
                }
                ViewHolder onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    Trace.endSection();
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }

        public int findRelativeAdapterPositionIn(Adapter adapter, ViewHolder viewHolder, int i) {
            if (adapter == this) {
                return i;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.notifyItemRangeChanged(i, 1, null);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.notifyItemRangeInserted(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.notifyItemMoved(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.notifyItemRangeChanged(i, i2, null);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.notifyItemRangeInserted(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.notifyItemRangeRemoved(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.notifyItemRangeRemoved(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(ViewHolder viewHolder, int i);

        public void onBindViewHolder(ViewHolder viewHolder, int i, List<Object> list) {
            onBindViewHolder(viewHolder, i);
        }

        public abstract ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(ViewHolder viewHolder) {
            return false;
        }

        public void onViewAttachedToWindow(ViewHolder viewHolder) {
        }

        public void onViewDetachedFromWindow(ViewHolder viewHolder) {
        }

        public void onViewRecycled(ViewHolder viewHolder) {
        }

        public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.registerObserver(adapterDataObserver);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.notifyStateRestorationPolicyChanged();
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
            this.mObservable.unregisterObserver(adapterDataObserver);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.notifyItemRangeChanged(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.notifyItemRangeChanged(i, i2, obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.recyclerview.widget.RecyclerView$ItemAnimator, androidx.recyclerview.widget.DefaultItemAnimator, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.lang.Object, androidx.recyclerview.widget.RecyclerView$State] */
    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float f;
        float f2;
        ClassLoader classLoader;
        Constructor constructor;
        this.mObserver = new RecyclerViewDataObserver();
        this.mRecycler = new Recycler();
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new Runnable(this) { // from class: androidx.recyclerview.widget.RecyclerView.1
            public final /* synthetic */ RecyclerView this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                long j;
                int i2 = r2;
                RecyclerView recyclerView = this.this$0;
                switch (i2) {
                    case 0:
                        if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                            if (!recyclerView.mIsAttached) {
                                recyclerView.requestLayout();
                                return;
                            } else if (recyclerView.mLayoutSuppressed) {
                                recyclerView.mLayoutWasDefered = true;
                                return;
                            } else {
                                recyclerView.consumePendingUpdateOperations();
                                return;
                            }
                        } else {
                            return;
                        }
                    default:
                        ItemAnimator itemAnimator = recyclerView.mItemAnimator;
                        if (itemAnimator != null) {
                            final DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) itemAnimator;
                            long j2 = defaultItemAnimator.mRemoveDuration;
                            ArrayList arrayList = defaultItemAnimator.mPendingRemovals;
                            boolean isEmpty = arrayList.isEmpty();
                            ArrayList arrayList2 = defaultItemAnimator.mPendingMoves;
                            boolean isEmpty2 = arrayList2.isEmpty();
                            ArrayList arrayList3 = defaultItemAnimator.mPendingChanges;
                            boolean isEmpty3 = arrayList3.isEmpty();
                            ArrayList arrayList4 = defaultItemAnimator.mPendingAdditions;
                            boolean isEmpty4 = arrayList4.isEmpty();
                            if (!isEmpty || !isEmpty2 || !isEmpty4 || !isEmpty3) {
                                int size = arrayList.size();
                                int i3 = 0;
                                while (i3 < size) {
                                    Object obj = arrayList.get(i3);
                                    int i4 = i3 + 1;
                                    ViewHolder viewHolder = (ViewHolder) obj;
                                    View view = viewHolder.itemView;
                                    ViewPropertyAnimator animate = view.animate();
                                    defaultItemAnimator.mRemoveAnimations.add(viewHolder);
                                    animate.setDuration(j2).alpha(RecyclerView.DECELERATION_RATE).setListener(new DefaultItemAnimator.AnonymousClass4(viewHolder, animate, view)).start();
                                    i3 = i4;
                                    arrayList = arrayList;
                                    isEmpty = isEmpty;
                                }
                                boolean z2 = isEmpty;
                                arrayList.clear();
                                if (!isEmpty2) {
                                    final ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    defaultItemAnimator.mMovesList.add(arrayList5);
                                    arrayList2.clear();
                                    Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            final View view2;
                                            switch (r3) {
                                                case 0:
                                                    ArrayList arrayList6 = arrayList5;
                                                    int size2 = arrayList6.size();
                                                    int i5 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                                                        if (i5 < size2) {
                                                            Object obj2 = arrayList6.get(i5);
                                                            i5++;
                                                            MoveInfo moveInfo = (MoveInfo) obj2;
                                                            final RecyclerView.ViewHolder viewHolder2 = moveInfo.holder;
                                                            int i6 = moveInfo.fromX;
                                                            int i7 = moveInfo.fromY;
                                                            int i8 = moveInfo.toX;
                                                            int i9 = moveInfo.toY;
                                                            defaultItemAnimator2.getClass();
                                                            final View view3 = viewHolder2.itemView;
                                                            final int i10 = i8 - i6;
                                                            final int i11 = i9 - i7;
                                                            if (i10 != 0) {
                                                                view3.animate().translationX(0.0f);
                                                            }
                                                            if (i11 != 0) {
                                                                view3.animate().translationY(0.0f);
                                                            }
                                                            final ViewPropertyAnimator animate2 = view3.animate();
                                                            defaultItemAnimator2.mMoveAnimations.add(viewHolder2);
                                                            animate2.setDuration(defaultItemAnimator2.mMoveDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationCancel(Animator animator) {
                                                                    int i12 = i10;
                                                                    View view4 = view3;
                                                                    if (i12 != 0) {
                                                                        view4.setTranslationX(0.0f);
                                                                    }
                                                                    if (i11 != 0) {
                                                                        view4.setTranslationY(0.0f);
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    animate2.setListener(null);
                                                                    DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator2;
                                                                    RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                                                                    defaultItemAnimator3.dispatchAnimationFinished(viewHolder3);
                                                                    defaultItemAnimator3.mMoveAnimations.remove(viewHolder3);
                                                                    defaultItemAnimator3.dispatchFinishedWhenDone();
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    defaultItemAnimator2.getClass();
                                                                }
                                                            }).start();
                                                        } else {
                                                            arrayList6.clear();
                                                            defaultItemAnimator2.mMovesList.remove(arrayList6);
                                                            return;
                                                        }
                                                    }
                                                case 1:
                                                    ArrayList arrayList7 = arrayList5;
                                                    int size3 = arrayList7.size();
                                                    int i12 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator;
                                                        if (i12 < size3) {
                                                            Object obj3 = arrayList7.get(i12);
                                                            i12++;
                                                            final ChangeInfo changeInfo = (ChangeInfo) obj3;
                                                            ArrayList arrayList8 = defaultItemAnimator3.mChangeAnimations;
                                                            long j3 = defaultItemAnimator3.mChangeDuration;
                                                            RecyclerView.ViewHolder viewHolder3 = changeInfo.oldHolder;
                                                            View view4 = null;
                                                            if (viewHolder3 == null) {
                                                                view2 = null;
                                                            } else {
                                                                view2 = viewHolder3.itemView;
                                                            }
                                                            RecyclerView.ViewHolder viewHolder4 = changeInfo.newHolder;
                                                            if (viewHolder4 != null) {
                                                                view4 = viewHolder4.itemView;
                                                            }
                                                            final View view5 = view4;
                                                            if (view2 != null) {
                                                                final ViewPropertyAnimator duration = view2.animate().setDuration(j3);
                                                                arrayList8.add(changeInfo.oldHolder);
                                                                duration.translationX(changeInfo.toX - changeInfo.fromX);
                                                                duration.translationY(changeInfo.toY - changeInfo.fromY);
                                                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                duration.setListener(null);
                                                                                View view6 = view2;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                duration.setListener(null);
                                                                                View view7 = view2;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                            if (view5 != null) {
                                                                final ViewPropertyAnimator animate3 = view5.animate();
                                                                arrayList8.add(changeInfo.newHolder);
                                                                animate3.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                animate3.setListener(null);
                                                                                View view6 = view5;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                animate3.setListener(null);
                                                                                View view7 = view5;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                        } else {
                                                            arrayList7.clear();
                                                            defaultItemAnimator3.mChangesList.remove(arrayList7);
                                                            return;
                                                        }
                                                    }
                                                default:
                                                    ArrayList arrayList9 = arrayList5;
                                                    int size4 = arrayList9.size();
                                                    int i13 = 0;
                                                    while (true) {
                                                        DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                        if (i13 < size4) {
                                                            Object obj4 = arrayList9.get(i13);
                                                            i13++;
                                                            RecyclerView.ViewHolder viewHolder5 = (RecyclerView.ViewHolder) obj4;
                                                            defaultItemAnimator4.getClass();
                                                            View view6 = viewHolder5.itemView;
                                                            ViewPropertyAnimator animate4 = view6.animate();
                                                            defaultItemAnimator4.mAddAnimations.add(viewHolder5);
                                                            animate4.alpha(1.0f).setDuration(defaultItemAnimator4.mAddDuration).setListener(new AnonymousClass4(viewHolder5, view6, animate4)).start();
                                                        } else {
                                                            arrayList9.clear();
                                                            defaultItemAnimator4.mAdditionsList.remove(arrayList9);
                                                            return;
                                                        }
                                                    }
                                            }
                                        }
                                    };
                                    if (!z2) {
                                        View view2 = ((DefaultItemAnimator.MoveInfo) arrayList5.get(0)).holder.itemView;
                                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                        view2.postOnAnimationDelayed(runnable, j2);
                                    } else {
                                        runnable.run();
                                    }
                                }
                                if (!isEmpty3) {
                                    final ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    defaultItemAnimator.mChangesList.add(arrayList6);
                                    arrayList3.clear();
                                    Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            final View view22;
                                            switch (r3) {
                                                case 0:
                                                    ArrayList arrayList62 = arrayList6;
                                                    int size2 = arrayList62.size();
                                                    int i5 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                                                        if (i5 < size2) {
                                                            Object obj2 = arrayList62.get(i5);
                                                            i5++;
                                                            MoveInfo moveInfo = (MoveInfo) obj2;
                                                            final RecyclerView.ViewHolder viewHolder2 = moveInfo.holder;
                                                            int i6 = moveInfo.fromX;
                                                            int i7 = moveInfo.fromY;
                                                            int i8 = moveInfo.toX;
                                                            int i9 = moveInfo.toY;
                                                            defaultItemAnimator2.getClass();
                                                            final View view3 = viewHolder2.itemView;
                                                            final int i10 = i8 - i6;
                                                            final int i11 = i9 - i7;
                                                            if (i10 != 0) {
                                                                view3.animate().translationX(0.0f);
                                                            }
                                                            if (i11 != 0) {
                                                                view3.animate().translationY(0.0f);
                                                            }
                                                            final ViewPropertyAnimator animate2 = view3.animate();
                                                            defaultItemAnimator2.mMoveAnimations.add(viewHolder2);
                                                            animate2.setDuration(defaultItemAnimator2.mMoveDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationCancel(Animator animator) {
                                                                    int i12 = i10;
                                                                    View view4 = view3;
                                                                    if (i12 != 0) {
                                                                        view4.setTranslationX(0.0f);
                                                                    }
                                                                    if (i11 != 0) {
                                                                        view4.setTranslationY(0.0f);
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    animate2.setListener(null);
                                                                    DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator2;
                                                                    RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                                                                    defaultItemAnimator3.dispatchAnimationFinished(viewHolder3);
                                                                    defaultItemAnimator3.mMoveAnimations.remove(viewHolder3);
                                                                    defaultItemAnimator3.dispatchFinishedWhenDone();
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    defaultItemAnimator2.getClass();
                                                                }
                                                            }).start();
                                                        } else {
                                                            arrayList62.clear();
                                                            defaultItemAnimator2.mMovesList.remove(arrayList62);
                                                            return;
                                                        }
                                                    }
                                                case 1:
                                                    ArrayList arrayList7 = arrayList6;
                                                    int size3 = arrayList7.size();
                                                    int i12 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator;
                                                        if (i12 < size3) {
                                                            Object obj3 = arrayList7.get(i12);
                                                            i12++;
                                                            final ChangeInfo changeInfo = (ChangeInfo) obj3;
                                                            ArrayList arrayList8 = defaultItemAnimator3.mChangeAnimations;
                                                            long j3 = defaultItemAnimator3.mChangeDuration;
                                                            RecyclerView.ViewHolder viewHolder3 = changeInfo.oldHolder;
                                                            View view4 = null;
                                                            if (viewHolder3 == null) {
                                                                view22 = null;
                                                            } else {
                                                                view22 = viewHolder3.itemView;
                                                            }
                                                            RecyclerView.ViewHolder viewHolder4 = changeInfo.newHolder;
                                                            if (viewHolder4 != null) {
                                                                view4 = viewHolder4.itemView;
                                                            }
                                                            final View view5 = view4;
                                                            if (view22 != null) {
                                                                final ViewPropertyAnimator duration = view22.animate().setDuration(j3);
                                                                arrayList8.add(changeInfo.oldHolder);
                                                                duration.translationX(changeInfo.toX - changeInfo.fromX);
                                                                duration.translationY(changeInfo.toY - changeInfo.fromY);
                                                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                duration.setListener(null);
                                                                                View view6 = view22;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                duration.setListener(null);
                                                                                View view7 = view22;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                            if (view5 != null) {
                                                                final ViewPropertyAnimator animate3 = view5.animate();
                                                                arrayList8.add(changeInfo.newHolder);
                                                                animate3.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                animate3.setListener(null);
                                                                                View view6 = view5;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                animate3.setListener(null);
                                                                                View view7 = view5;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                        } else {
                                                            arrayList7.clear();
                                                            defaultItemAnimator3.mChangesList.remove(arrayList7);
                                                            return;
                                                        }
                                                    }
                                                default:
                                                    ArrayList arrayList9 = arrayList6;
                                                    int size4 = arrayList9.size();
                                                    int i13 = 0;
                                                    while (true) {
                                                        DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                        if (i13 < size4) {
                                                            Object obj4 = arrayList9.get(i13);
                                                            i13++;
                                                            RecyclerView.ViewHolder viewHolder5 = (RecyclerView.ViewHolder) obj4;
                                                            defaultItemAnimator4.getClass();
                                                            View view6 = viewHolder5.itemView;
                                                            ViewPropertyAnimator animate4 = view6.animate();
                                                            defaultItemAnimator4.mAddAnimations.add(viewHolder5);
                                                            animate4.alpha(1.0f).setDuration(defaultItemAnimator4.mAddDuration).setListener(new AnonymousClass4(viewHolder5, view6, animate4)).start();
                                                        } else {
                                                            arrayList9.clear();
                                                            defaultItemAnimator4.mAdditionsList.remove(arrayList9);
                                                            return;
                                                        }
                                                    }
                                            }
                                        }
                                    };
                                    if (!z2) {
                                        View view3 = ((DefaultItemAnimator.ChangeInfo) arrayList6.get(0)).oldHolder.itemView;
                                        WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                                        view3.postOnAnimationDelayed(runnable2, j2);
                                    } else {
                                        runnable2.run();
                                    }
                                }
                                if (!isEmpty4) {
                                    final ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    defaultItemAnimator.mAdditionsList.add(arrayList7);
                                    arrayList4.clear();
                                    Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            final View view22;
                                            switch (r3) {
                                                case 0:
                                                    ArrayList arrayList62 = arrayList7;
                                                    int size2 = arrayList62.size();
                                                    int i5 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                                                        if (i5 < size2) {
                                                            Object obj2 = arrayList62.get(i5);
                                                            i5++;
                                                            MoveInfo moveInfo = (MoveInfo) obj2;
                                                            final RecyclerView.ViewHolder viewHolder2 = moveInfo.holder;
                                                            int i6 = moveInfo.fromX;
                                                            int i7 = moveInfo.fromY;
                                                            int i8 = moveInfo.toX;
                                                            int i9 = moveInfo.toY;
                                                            defaultItemAnimator2.getClass();
                                                            final View view32 = viewHolder2.itemView;
                                                            final int i10 = i8 - i6;
                                                            final int i11 = i9 - i7;
                                                            if (i10 != 0) {
                                                                view32.animate().translationX(0.0f);
                                                            }
                                                            if (i11 != 0) {
                                                                view32.animate().translationY(0.0f);
                                                            }
                                                            final ViewPropertyAnimator animate2 = view32.animate();
                                                            defaultItemAnimator2.mMoveAnimations.add(viewHolder2);
                                                            animate2.setDuration(defaultItemAnimator2.mMoveDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationCancel(Animator animator) {
                                                                    int i12 = i10;
                                                                    View view4 = view32;
                                                                    if (i12 != 0) {
                                                                        view4.setTranslationX(0.0f);
                                                                    }
                                                                    if (i11 != 0) {
                                                                        view4.setTranslationY(0.0f);
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    animate2.setListener(null);
                                                                    DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator2;
                                                                    RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                                                                    defaultItemAnimator3.dispatchAnimationFinished(viewHolder3);
                                                                    defaultItemAnimator3.mMoveAnimations.remove(viewHolder3);
                                                                    defaultItemAnimator3.dispatchFinishedWhenDone();
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    defaultItemAnimator2.getClass();
                                                                }
                                                            }).start();
                                                        } else {
                                                            arrayList62.clear();
                                                            defaultItemAnimator2.mMovesList.remove(arrayList62);
                                                            return;
                                                        }
                                                    }
                                                case 1:
                                                    ArrayList arrayList72 = arrayList7;
                                                    int size3 = arrayList72.size();
                                                    int i12 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator;
                                                        if (i12 < size3) {
                                                            Object obj3 = arrayList72.get(i12);
                                                            i12++;
                                                            final ChangeInfo changeInfo = (ChangeInfo) obj3;
                                                            ArrayList arrayList8 = defaultItemAnimator3.mChangeAnimations;
                                                            long j3 = defaultItemAnimator3.mChangeDuration;
                                                            RecyclerView.ViewHolder viewHolder3 = changeInfo.oldHolder;
                                                            View view4 = null;
                                                            if (viewHolder3 == null) {
                                                                view22 = null;
                                                            } else {
                                                                view22 = viewHolder3.itemView;
                                                            }
                                                            RecyclerView.ViewHolder viewHolder4 = changeInfo.newHolder;
                                                            if (viewHolder4 != null) {
                                                                view4 = viewHolder4.itemView;
                                                            }
                                                            final View view5 = view4;
                                                            if (view22 != null) {
                                                                final ViewPropertyAnimator duration = view22.animate().setDuration(j3);
                                                                arrayList8.add(changeInfo.oldHolder);
                                                                duration.translationX(changeInfo.toX - changeInfo.fromX);
                                                                duration.translationY(changeInfo.toY - changeInfo.fromY);
                                                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                duration.setListener(null);
                                                                                View view6 = view22;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                duration.setListener(null);
                                                                                View view7 = view22;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                            if (view5 != null) {
                                                                final ViewPropertyAnimator animate3 = view5.animate();
                                                                arrayList8.add(changeInfo.newHolder);
                                                                animate3.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                animate3.setListener(null);
                                                                                View view6 = view5;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                animate3.setListener(null);
                                                                                View view7 = view5;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                        } else {
                                                            arrayList72.clear();
                                                            defaultItemAnimator3.mChangesList.remove(arrayList72);
                                                            return;
                                                        }
                                                    }
                                                default:
                                                    ArrayList arrayList9 = arrayList7;
                                                    int size4 = arrayList9.size();
                                                    int i13 = 0;
                                                    while (true) {
                                                        DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                        if (i13 < size4) {
                                                            Object obj4 = arrayList9.get(i13);
                                                            i13++;
                                                            RecyclerView.ViewHolder viewHolder5 = (RecyclerView.ViewHolder) obj4;
                                                            defaultItemAnimator4.getClass();
                                                            View view6 = viewHolder5.itemView;
                                                            ViewPropertyAnimator animate4 = view6.animate();
                                                            defaultItemAnimator4.mAddAnimations.add(viewHolder5);
                                                            animate4.alpha(1.0f).setDuration(defaultItemAnimator4.mAddDuration).setListener(new AnonymousClass4(viewHolder5, view6, animate4)).start();
                                                        } else {
                                                            arrayList9.clear();
                                                            defaultItemAnimator4.mAdditionsList.remove(arrayList9);
                                                            return;
                                                        }
                                                    }
                                            }
                                        }
                                    };
                                    if (!z2 || !isEmpty2 || !isEmpty3) {
                                        long j3 = 0;
                                        if (z2) {
                                            j2 = 0;
                                        }
                                        if (!isEmpty2) {
                                            j = defaultItemAnimator.mMoveDuration;
                                        } else {
                                            j = 0;
                                        }
                                        if (!isEmpty3) {
                                            j3 = defaultItemAnimator.mChangeDuration;
                                        }
                                        z = false;
                                        View view4 = ((ViewHolder) arrayList7.get(0)).itemView;
                                        WeakHashMap weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                                        view4.postOnAnimationDelayed(runnable3, Math.max(j, j3) + j2);
                                        recyclerView.mPostedAnimatorRunner = z;
                                        return;
                                    }
                                    runnable3.run();
                                }
                            }
                        }
                        z = false;
                        recyclerView.mPostedAnimatorRunner = z;
                        return;
                }
            }
        };
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = sDefaultEdgeEffectFactory;
        ?? obj = new Object();
        Object[] objArr = null;
        obj.mListener = null;
        obj.mFinishedListeners = new ArrayList();
        obj.mAddDuration = 120L;
        obj.mRemoveDuration = 120L;
        obj.mMoveDuration = 250L;
        obj.mChangeDuration = 250L;
        obj.mSupportsChangeAnimations = true;
        obj.mPendingRemovals = new ArrayList();
        obj.mPendingAdditions = new ArrayList();
        obj.mPendingMoves = new ArrayList();
        obj.mPendingChanges = new ArrayList();
        obj.mAdditionsList = new ArrayList();
        obj.mMovesList = new ArrayList();
        obj.mChangesList = new ArrayList();
        obj.mAddAnimations = new ArrayList();
        obj.mMoveAnimations = new ArrayList();
        obj.mRemoveAnimations = new ArrayList();
        obj.mChangeAnimations = new ArrayList();
        this.mItemAnimator = obj;
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new Object() : null;
        ?? obj2 = new Object();
        obj2.mTargetPosition = -1;
        obj2.mPreviousLayoutItemCount = 0;
        obj2.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        obj2.mLayoutStep = 1;
        obj2.mItemCount = 0;
        obj2.mStructureChanged = false;
        obj2.mInPreLayout = false;
        obj2.mTrackOldChangeHolders = false;
        obj2.mIsMeasuring = false;
        obj2.mRunSimpleAnimations = false;
        obj2.mRunPredictiveAnimations = false;
        this.mState = obj2;
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new AnonymousClass5();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new Runnable(this) { // from class: androidx.recyclerview.widget.RecyclerView.1
            public final /* synthetic */ RecyclerView this$0;

            {
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean z;
                long j;
                int i2 = r2;
                RecyclerView recyclerView = this.this$0;
                switch (i2) {
                    case 0:
                        if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                            if (!recyclerView.mIsAttached) {
                                recyclerView.requestLayout();
                                return;
                            } else if (recyclerView.mLayoutSuppressed) {
                                recyclerView.mLayoutWasDefered = true;
                                return;
                            } else {
                                recyclerView.consumePendingUpdateOperations();
                                return;
                            }
                        } else {
                            return;
                        }
                    default:
                        ItemAnimator itemAnimator = recyclerView.mItemAnimator;
                        if (itemAnimator != null) {
                            final DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) itemAnimator;
                            long j2 = defaultItemAnimator.mRemoveDuration;
                            ArrayList arrayList = defaultItemAnimator.mPendingRemovals;
                            boolean isEmpty = arrayList.isEmpty();
                            ArrayList arrayList2 = defaultItemAnimator.mPendingMoves;
                            boolean isEmpty2 = arrayList2.isEmpty();
                            ArrayList arrayList3 = defaultItemAnimator.mPendingChanges;
                            boolean isEmpty3 = arrayList3.isEmpty();
                            ArrayList arrayList4 = defaultItemAnimator.mPendingAdditions;
                            boolean isEmpty4 = arrayList4.isEmpty();
                            if (!isEmpty || !isEmpty2 || !isEmpty4 || !isEmpty3) {
                                int size = arrayList.size();
                                int i3 = 0;
                                while (i3 < size) {
                                    Object obj3 = arrayList.get(i3);
                                    int i4 = i3 + 1;
                                    ViewHolder viewHolder = (ViewHolder) obj3;
                                    View view = viewHolder.itemView;
                                    ViewPropertyAnimator animate = view.animate();
                                    defaultItemAnimator.mRemoveAnimations.add(viewHolder);
                                    animate.setDuration(j2).alpha(RecyclerView.DECELERATION_RATE).setListener(new DefaultItemAnimator.AnonymousClass4(viewHolder, animate, view)).start();
                                    i3 = i4;
                                    arrayList = arrayList;
                                    isEmpty = isEmpty;
                                }
                                boolean z2 = isEmpty;
                                arrayList.clear();
                                if (!isEmpty2) {
                                    final ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    defaultItemAnimator.mMovesList.add(arrayList5);
                                    arrayList2.clear();
                                    Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            final View view22;
                                            switch (r3) {
                                                case 0:
                                                    ArrayList arrayList62 = arrayList5;
                                                    int size2 = arrayList62.size();
                                                    int i5 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                                                        if (i5 < size2) {
                                                            Object obj22 = arrayList62.get(i5);
                                                            i5++;
                                                            MoveInfo moveInfo = (MoveInfo) obj22;
                                                            final RecyclerView.ViewHolder viewHolder2 = moveInfo.holder;
                                                            int i6 = moveInfo.fromX;
                                                            int i7 = moveInfo.fromY;
                                                            int i8 = moveInfo.toX;
                                                            int i9 = moveInfo.toY;
                                                            defaultItemAnimator2.getClass();
                                                            final View view32 = viewHolder2.itemView;
                                                            final int i10 = i8 - i6;
                                                            final int i11 = i9 - i7;
                                                            if (i10 != 0) {
                                                                view32.animate().translationX(0.0f);
                                                            }
                                                            if (i11 != 0) {
                                                                view32.animate().translationY(0.0f);
                                                            }
                                                            final ViewPropertyAnimator animate2 = view32.animate();
                                                            defaultItemAnimator2.mMoveAnimations.add(viewHolder2);
                                                            animate2.setDuration(defaultItemAnimator2.mMoveDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationCancel(Animator animator) {
                                                                    int i12 = i10;
                                                                    View view4 = view32;
                                                                    if (i12 != 0) {
                                                                        view4.setTranslationX(0.0f);
                                                                    }
                                                                    if (i11 != 0) {
                                                                        view4.setTranslationY(0.0f);
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    animate2.setListener(null);
                                                                    DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator2;
                                                                    RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                                                                    defaultItemAnimator3.dispatchAnimationFinished(viewHolder3);
                                                                    defaultItemAnimator3.mMoveAnimations.remove(viewHolder3);
                                                                    defaultItemAnimator3.dispatchFinishedWhenDone();
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    defaultItemAnimator2.getClass();
                                                                }
                                                            }).start();
                                                        } else {
                                                            arrayList62.clear();
                                                            defaultItemAnimator2.mMovesList.remove(arrayList62);
                                                            return;
                                                        }
                                                    }
                                                case 1:
                                                    ArrayList arrayList72 = arrayList5;
                                                    int size3 = arrayList72.size();
                                                    int i12 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator;
                                                        if (i12 < size3) {
                                                            Object obj32 = arrayList72.get(i12);
                                                            i12++;
                                                            final ChangeInfo changeInfo = (ChangeInfo) obj32;
                                                            ArrayList arrayList8 = defaultItemAnimator3.mChangeAnimations;
                                                            long j3 = defaultItemAnimator3.mChangeDuration;
                                                            RecyclerView.ViewHolder viewHolder3 = changeInfo.oldHolder;
                                                            View view4 = null;
                                                            if (viewHolder3 == null) {
                                                                view22 = null;
                                                            } else {
                                                                view22 = viewHolder3.itemView;
                                                            }
                                                            RecyclerView.ViewHolder viewHolder4 = changeInfo.newHolder;
                                                            if (viewHolder4 != null) {
                                                                view4 = viewHolder4.itemView;
                                                            }
                                                            final View view5 = view4;
                                                            if (view22 != null) {
                                                                final ViewPropertyAnimator duration = view22.animate().setDuration(j3);
                                                                arrayList8.add(changeInfo.oldHolder);
                                                                duration.translationX(changeInfo.toX - changeInfo.fromX);
                                                                duration.translationY(changeInfo.toY - changeInfo.fromY);
                                                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                duration.setListener(null);
                                                                                View view6 = view22;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                duration.setListener(null);
                                                                                View view7 = view22;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                            if (view5 != null) {
                                                                final ViewPropertyAnimator animate3 = view5.animate();
                                                                arrayList8.add(changeInfo.newHolder);
                                                                animate3.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                animate3.setListener(null);
                                                                                View view6 = view5;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                animate3.setListener(null);
                                                                                View view7 = view5;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                        } else {
                                                            arrayList72.clear();
                                                            defaultItemAnimator3.mChangesList.remove(arrayList72);
                                                            return;
                                                        }
                                                    }
                                                default:
                                                    ArrayList arrayList9 = arrayList5;
                                                    int size4 = arrayList9.size();
                                                    int i13 = 0;
                                                    while (true) {
                                                        DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                        if (i13 < size4) {
                                                            Object obj4 = arrayList9.get(i13);
                                                            i13++;
                                                            RecyclerView.ViewHolder viewHolder5 = (RecyclerView.ViewHolder) obj4;
                                                            defaultItemAnimator4.getClass();
                                                            View view6 = viewHolder5.itemView;
                                                            ViewPropertyAnimator animate4 = view6.animate();
                                                            defaultItemAnimator4.mAddAnimations.add(viewHolder5);
                                                            animate4.alpha(1.0f).setDuration(defaultItemAnimator4.mAddDuration).setListener(new AnonymousClass4(viewHolder5, view6, animate4)).start();
                                                        } else {
                                                            arrayList9.clear();
                                                            defaultItemAnimator4.mAdditionsList.remove(arrayList9);
                                                            return;
                                                        }
                                                    }
                                            }
                                        }
                                    };
                                    if (!z2) {
                                        View view2 = ((DefaultItemAnimator.MoveInfo) arrayList5.get(0)).holder.itemView;
                                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                        view2.postOnAnimationDelayed(runnable, j2);
                                    } else {
                                        runnable.run();
                                    }
                                }
                                if (!isEmpty3) {
                                    final ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    defaultItemAnimator.mChangesList.add(arrayList6);
                                    arrayList3.clear();
                                    Runnable runnable2 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            final View view22;
                                            switch (r3) {
                                                case 0:
                                                    ArrayList arrayList62 = arrayList6;
                                                    int size2 = arrayList62.size();
                                                    int i5 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                                                        if (i5 < size2) {
                                                            Object obj22 = arrayList62.get(i5);
                                                            i5++;
                                                            MoveInfo moveInfo = (MoveInfo) obj22;
                                                            final RecyclerView.ViewHolder viewHolder2 = moveInfo.holder;
                                                            int i6 = moveInfo.fromX;
                                                            int i7 = moveInfo.fromY;
                                                            int i8 = moveInfo.toX;
                                                            int i9 = moveInfo.toY;
                                                            defaultItemAnimator2.getClass();
                                                            final View view32 = viewHolder2.itemView;
                                                            final int i10 = i8 - i6;
                                                            final int i11 = i9 - i7;
                                                            if (i10 != 0) {
                                                                view32.animate().translationX(0.0f);
                                                            }
                                                            if (i11 != 0) {
                                                                view32.animate().translationY(0.0f);
                                                            }
                                                            final ViewPropertyAnimator animate2 = view32.animate();
                                                            defaultItemAnimator2.mMoveAnimations.add(viewHolder2);
                                                            animate2.setDuration(defaultItemAnimator2.mMoveDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationCancel(Animator animator) {
                                                                    int i12 = i10;
                                                                    View view4 = view32;
                                                                    if (i12 != 0) {
                                                                        view4.setTranslationX(0.0f);
                                                                    }
                                                                    if (i11 != 0) {
                                                                        view4.setTranslationY(0.0f);
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    animate2.setListener(null);
                                                                    DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator2;
                                                                    RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                                                                    defaultItemAnimator3.dispatchAnimationFinished(viewHolder3);
                                                                    defaultItemAnimator3.mMoveAnimations.remove(viewHolder3);
                                                                    defaultItemAnimator3.dispatchFinishedWhenDone();
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    defaultItemAnimator2.getClass();
                                                                }
                                                            }).start();
                                                        } else {
                                                            arrayList62.clear();
                                                            defaultItemAnimator2.mMovesList.remove(arrayList62);
                                                            return;
                                                        }
                                                    }
                                                case 1:
                                                    ArrayList arrayList72 = arrayList6;
                                                    int size3 = arrayList72.size();
                                                    int i12 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator;
                                                        if (i12 < size3) {
                                                            Object obj32 = arrayList72.get(i12);
                                                            i12++;
                                                            final ChangeInfo changeInfo = (ChangeInfo) obj32;
                                                            ArrayList arrayList8 = defaultItemAnimator3.mChangeAnimations;
                                                            long j3 = defaultItemAnimator3.mChangeDuration;
                                                            RecyclerView.ViewHolder viewHolder3 = changeInfo.oldHolder;
                                                            View view4 = null;
                                                            if (viewHolder3 == null) {
                                                                view22 = null;
                                                            } else {
                                                                view22 = viewHolder3.itemView;
                                                            }
                                                            RecyclerView.ViewHolder viewHolder4 = changeInfo.newHolder;
                                                            if (viewHolder4 != null) {
                                                                view4 = viewHolder4.itemView;
                                                            }
                                                            final View view5 = view4;
                                                            if (view22 != null) {
                                                                final ViewPropertyAnimator duration = view22.animate().setDuration(j3);
                                                                arrayList8.add(changeInfo.oldHolder);
                                                                duration.translationX(changeInfo.toX - changeInfo.fromX);
                                                                duration.translationY(changeInfo.toY - changeInfo.fromY);
                                                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                duration.setListener(null);
                                                                                View view6 = view22;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                duration.setListener(null);
                                                                                View view7 = view22;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                            if (view5 != null) {
                                                                final ViewPropertyAnimator animate3 = view5.animate();
                                                                arrayList8.add(changeInfo.newHolder);
                                                                animate3.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                animate3.setListener(null);
                                                                                View view6 = view5;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                animate3.setListener(null);
                                                                                View view7 = view5;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                        } else {
                                                            arrayList72.clear();
                                                            defaultItemAnimator3.mChangesList.remove(arrayList72);
                                                            return;
                                                        }
                                                    }
                                                default:
                                                    ArrayList arrayList9 = arrayList6;
                                                    int size4 = arrayList9.size();
                                                    int i13 = 0;
                                                    while (true) {
                                                        DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                        if (i13 < size4) {
                                                            Object obj4 = arrayList9.get(i13);
                                                            i13++;
                                                            RecyclerView.ViewHolder viewHolder5 = (RecyclerView.ViewHolder) obj4;
                                                            defaultItemAnimator4.getClass();
                                                            View view6 = viewHolder5.itemView;
                                                            ViewPropertyAnimator animate4 = view6.animate();
                                                            defaultItemAnimator4.mAddAnimations.add(viewHolder5);
                                                            animate4.alpha(1.0f).setDuration(defaultItemAnimator4.mAddDuration).setListener(new AnonymousClass4(viewHolder5, view6, animate4)).start();
                                                        } else {
                                                            arrayList9.clear();
                                                            defaultItemAnimator4.mAdditionsList.remove(arrayList9);
                                                            return;
                                                        }
                                                    }
                                            }
                                        }
                                    };
                                    if (!z2) {
                                        View view3 = ((DefaultItemAnimator.ChangeInfo) arrayList6.get(0)).oldHolder.itemView;
                                        WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                                        view3.postOnAnimationDelayed(runnable2, j2);
                                    } else {
                                        runnable2.run();
                                    }
                                }
                                if (!isEmpty4) {
                                    final ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    defaultItemAnimator.mAdditionsList.add(arrayList7);
                                    arrayList4.clear();
                                    Runnable runnable3 = new Runnable() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            final View view22;
                                            switch (r3) {
                                                case 0:
                                                    ArrayList arrayList62 = arrayList7;
                                                    int size2 = arrayList62.size();
                                                    int i5 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator2 = defaultItemAnimator;
                                                        if (i5 < size2) {
                                                            Object obj22 = arrayList62.get(i5);
                                                            i5++;
                                                            MoveInfo moveInfo = (MoveInfo) obj22;
                                                            final RecyclerView.ViewHolder viewHolder2 = moveInfo.holder;
                                                            int i6 = moveInfo.fromX;
                                                            int i7 = moveInfo.fromY;
                                                            int i8 = moveInfo.toX;
                                                            int i9 = moveInfo.toY;
                                                            defaultItemAnimator2.getClass();
                                                            final View view32 = viewHolder2.itemView;
                                                            final int i10 = i8 - i6;
                                                            final int i11 = i9 - i7;
                                                            if (i10 != 0) {
                                                                view32.animate().translationX(0.0f);
                                                            }
                                                            if (i11 != 0) {
                                                                view32.animate().translationY(0.0f);
                                                            }
                                                            final ViewPropertyAnimator animate2 = view32.animate();
                                                            defaultItemAnimator2.mMoveAnimations.add(viewHolder2);
                                                            animate2.setDuration(defaultItemAnimator2.mMoveDuration).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.6
                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationCancel(Animator animator) {
                                                                    int i12 = i10;
                                                                    View view4 = view32;
                                                                    if (i12 != 0) {
                                                                        view4.setTranslationX(0.0f);
                                                                    }
                                                                    if (i11 != 0) {
                                                                        view4.setTranslationY(0.0f);
                                                                    }
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationEnd(Animator animator) {
                                                                    animate2.setListener(null);
                                                                    DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator2;
                                                                    RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                                                                    defaultItemAnimator3.dispatchAnimationFinished(viewHolder3);
                                                                    defaultItemAnimator3.mMoveAnimations.remove(viewHolder3);
                                                                    defaultItemAnimator3.dispatchFinishedWhenDone();
                                                                }

                                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                public final void onAnimationStart(Animator animator) {
                                                                    defaultItemAnimator2.getClass();
                                                                }
                                                            }).start();
                                                        } else {
                                                            arrayList62.clear();
                                                            defaultItemAnimator2.mMovesList.remove(arrayList62);
                                                            return;
                                                        }
                                                    }
                                                case 1:
                                                    ArrayList arrayList72 = arrayList7;
                                                    int size3 = arrayList72.size();
                                                    int i12 = 0;
                                                    while (true) {
                                                        final DefaultItemAnimator defaultItemAnimator3 = defaultItemAnimator;
                                                        if (i12 < size3) {
                                                            Object obj32 = arrayList72.get(i12);
                                                            i12++;
                                                            final ChangeInfo changeInfo = (ChangeInfo) obj32;
                                                            ArrayList arrayList8 = defaultItemAnimator3.mChangeAnimations;
                                                            long j3 = defaultItemAnimator3.mChangeDuration;
                                                            RecyclerView.ViewHolder viewHolder3 = changeInfo.oldHolder;
                                                            View view4 = null;
                                                            if (viewHolder3 == null) {
                                                                view22 = null;
                                                            } else {
                                                                view22 = viewHolder3.itemView;
                                                            }
                                                            RecyclerView.ViewHolder viewHolder4 = changeInfo.newHolder;
                                                            if (viewHolder4 != null) {
                                                                view4 = viewHolder4.itemView;
                                                            }
                                                            final View view5 = view4;
                                                            if (view22 != null) {
                                                                final ViewPropertyAnimator duration = view22.animate().setDuration(j3);
                                                                arrayList8.add(changeInfo.oldHolder);
                                                                duration.translationX(changeInfo.toX - changeInfo.fromX);
                                                                duration.translationY(changeInfo.toY - changeInfo.fromY);
                                                                duration.alpha(0.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                duration.setListener(null);
                                                                                View view6 = view22;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                duration.setListener(null);
                                                                                View view7 = view22;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                            if (view5 != null) {
                                                                final ViewPropertyAnimator animate3 = view5.animate();
                                                                arrayList8.add(changeInfo.newHolder);
                                                                animate3.translationX(0.0f).translationY(0.0f).setDuration(j3).alpha(1.0f).setListener(new AnimatorListenerAdapter() { // from class: androidx.recyclerview.widget.DefaultItemAnimator.7
                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationEnd(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                animate3.setListener(null);
                                                                                View view6 = view5;
                                                                                view6.setAlpha(1.0f);
                                                                                view6.setTranslationX(0.0f);
                                                                                view6.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo2 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo2.oldHolder;
                                                                                DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator3;
                                                                                defaultItemAnimator4.dispatchAnimationFinished(viewHolder5);
                                                                                defaultItemAnimator4.mChangeAnimations.remove(changeInfo2.oldHolder);
                                                                                defaultItemAnimator4.dispatchFinishedWhenDone();
                                                                                return;
                                                                            default:
                                                                                animate3.setListener(null);
                                                                                View view7 = view5;
                                                                                view7.setAlpha(1.0f);
                                                                                view7.setTranslationX(0.0f);
                                                                                view7.setTranslationY(0.0f);
                                                                                ChangeInfo changeInfo3 = changeInfo;
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo3.newHolder;
                                                                                DefaultItemAnimator defaultItemAnimator5 = defaultItemAnimator3;
                                                                                defaultItemAnimator5.dispatchAnimationFinished(viewHolder6);
                                                                                defaultItemAnimator5.mChangeAnimations.remove(changeInfo3.newHolder);
                                                                                defaultItemAnimator5.dispatchFinishedWhenDone();
                                                                                return;
                                                                        }
                                                                    }

                                                                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                                    public final void onAnimationStart(Animator animator) {
                                                                        switch (r5) {
                                                                            case 0:
                                                                                RecyclerView.ViewHolder viewHolder5 = changeInfo.oldHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                            default:
                                                                                RecyclerView.ViewHolder viewHolder6 = changeInfo.newHolder;
                                                                                defaultItemAnimator3.getClass();
                                                                                return;
                                                                        }
                                                                    }
                                                                }).start();
                                                            }
                                                        } else {
                                                            arrayList72.clear();
                                                            defaultItemAnimator3.mChangesList.remove(arrayList72);
                                                            return;
                                                        }
                                                    }
                                                default:
                                                    ArrayList arrayList9 = arrayList7;
                                                    int size4 = arrayList9.size();
                                                    int i13 = 0;
                                                    while (true) {
                                                        DefaultItemAnimator defaultItemAnimator4 = defaultItemAnimator;
                                                        if (i13 < size4) {
                                                            Object obj4 = arrayList9.get(i13);
                                                            i13++;
                                                            RecyclerView.ViewHolder viewHolder5 = (RecyclerView.ViewHolder) obj4;
                                                            defaultItemAnimator4.getClass();
                                                            View view6 = viewHolder5.itemView;
                                                            ViewPropertyAnimator animate4 = view6.animate();
                                                            defaultItemAnimator4.mAddAnimations.add(viewHolder5);
                                                            animate4.alpha(1.0f).setDuration(defaultItemAnimator4.mAddDuration).setListener(new AnonymousClass4(viewHolder5, view6, animate4)).start();
                                                        } else {
                                                            arrayList9.clear();
                                                            defaultItemAnimator4.mAdditionsList.remove(arrayList9);
                                                            return;
                                                        }
                                                    }
                                            }
                                        }
                                    };
                                    if (!z2 || !isEmpty2 || !isEmpty3) {
                                        long j3 = 0;
                                        if (z2) {
                                            j2 = 0;
                                        }
                                        if (!isEmpty2) {
                                            j = defaultItemAnimator.mMoveDuration;
                                        } else {
                                            j = 0;
                                        }
                                        if (!isEmpty3) {
                                            j3 = defaultItemAnimator.mChangeDuration;
                                        }
                                        z = false;
                                        View view4 = ((ViewHolder) arrayList7.get(0)).itemView;
                                        WeakHashMap weakHashMap3 = ViewCompat.sViewPropertyAnimatorMap;
                                        view4.postOnAnimationDelayed(runnable3, Math.max(j, j3) + j2);
                                        recyclerView.mPostedAnimatorRunner = z;
                                        return;
                                    }
                                    runnable3.run();
                                }
                            }
                        }
                        z = false;
                        recyclerView.mPostedAnimatorRunner = z;
                        return;
                }
            }
        };
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new AnonymousClass5();
        AnonymousClass5 r3 = new AnonymousClass5();
        this.mDifferentialMotionFlingTarget = r3;
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(getContext(), r3);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            Method method = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
            f = ViewConfigurationCompat.Api26Impl.getScaledHorizontalScrollFactor(viewConfiguration);
        } else {
            f = ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
        }
        this.mScaledHorizontalScrollFactor = f;
        if (i2 >= 26) {
            f2 = ViewConfigurationCompat.Api26Impl.getScaledVerticalScrollFactor(viewConfiguration);
        } else {
            f2 = ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
        }
        this.mScaledVerticalScrollFactor = f2;
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.mListener = this.mItemAnimatorListener;
        initAdapterManager();
        this.mChildHelper = new ChildHelper(new AnonymousClass5());
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if ((i2 >= 26 ? ViewCompat.Api26Impl.getImportantForAutofill(this) : 0) == 0 && i2 >= 26) {
            ViewCompat.Api26Impl.setImportantForAutofill(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] iArr = R$styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, i);
        String string = obtainStyledAttributes.getString(8);
        if (obtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(1, true);
        boolean z = obtainStyledAttributes.getBoolean(3, false);
        this.mEnableFastScroller = z;
        if (z) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(6), obtainStyledAttributes.getDrawable(7), (StateListDrawable) obtainStyledAttributes.getDrawable(4), obtainStyledAttributes.getDrawable(5));
        }
        obtainStyledAttributes.recycle();
        this.mLowResRotaryEncoderFeature = context.getPackageManager().hasSystemFeature(LOW_RES_ROTARY_ENCODER_FEATURE);
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                }
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(trim, false, classLoader).asSubclass(LayoutManager.class);
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), 0};
                    } catch (NoSuchMethodException e) {
                        try {
                            constructor = asSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e2) {
                            e2.initCause(e);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + trim, e2);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (ClassCastException e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + trim, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + trim, e4);
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + trim, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e6);
                } catch (InvocationTargetException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e7);
                }
            }
        }
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr2, attributeSet, obtainStyledAttributes2, i);
        boolean z2 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
        setTag(R.id.is_pooling_container_tag, Boolean.TRUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0038 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.recyclerview.widget.RecyclerView.ViewHolder findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.ChildHelper r0 = r5.mChildHelper
            int r0 = r0.getUnfilteredChildCount()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3c
            androidx.recyclerview.widget.ChildHelper r3 = r5.mChildHelper
            android.view.View r3 = r3.getUnfilteredChildAt(r2)
            androidx.recyclerview.widget.RecyclerView$ViewHolder r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L39
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L39
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L39
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L39
        L2a:
            androidx.recyclerview.widget.ChildHelper r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            java.util.ArrayList r1 = r1.mHiddenViews
            boolean r1 = r1.contains(r4)
            if (r1 == 0) goto L38
            r1 = r3
            goto L39
        L38:
            return r3
        L39:
            int r2 = r2 + 1
            goto L8
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$ViewHolder");
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x020b, code lost:
        if (r1 < r13) goto L124;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00eb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean fling(int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int, int, int):boolean");
    }

    public void onExitLayoutOrScroll(boolean z) {
        int i = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i;
        if (i >= 1) {
            return;
        }
        if (!sDebugAssertionsEnabled || i >= 0) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                int i2 = this.mEatenAccessibilityChangeFlags;
                this.mEatenAccessibilityChangeFlags = 0;
                if (i2 != 0 && isAccessibilityEnabled()) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(2048);
                    obtain.setContentChangeTypes(i2);
                    sendAccessibilityEventUnchecked(obtain);
                }
                dispatchPendingImportantForAccessibilityChanges();
                return;
            }
            return;
        }
        throw new IllegalStateException(ViewModelProvider.Factory.CC.m(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().dispatchNestedScrollInternal(i, i2, i3, i4, iArr, i5, null);
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().hasNestedScrollingParent(i);
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3) {
        smoothScrollBy(i, i2, interpolator, i3, false);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().startNestedScroll(i, i2);
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().stopNestedScroll(i);
    }

    /* loaded from: classes.dex */
    public class LayoutParams extends ViewGroup.MarginLayoutParams {
        public final Rect mDecorInsets = new Rect();
        public boolean mInsetsDirty = true;
        public boolean mPendingInvalidate = false;
        public ViewHolder mViewHolder;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
        }
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int i4 = 0;
            if (!layoutManager.canScrollHorizontally()) {
                i = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i2 = 0;
            }
            if (i != 0 || i2 != 0) {
                if (i3 == Integer.MIN_VALUE || i3 > 0) {
                    if (z) {
                        if (i != 0) {
                            i4 = 1;
                        }
                        if (i2 != 0) {
                            i4 |= 2;
                        }
                        startNestedScroll(i4, 1);
                    }
                    this.mViewFlinger.smoothScrollBy(i, i2, interpolator, i3);
                    return;
                }
                scrollBy(i, i2);
            }
        }
    }

    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().dispatchNestedScrollInternal(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public void addItemDecoration(ItemDecoration itemDecoration) {
        addItemDecoration(itemDecoration, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        LayoutManager layoutManager = this.mLayout;
        if (layoutManager != null) {
            return layoutManager.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(ViewModelProvider.Factory.CC.m(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    /* loaded from: classes.dex */
    public abstract class ItemDecoration {
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView) {
            ((LayoutParams) view.getLayoutParams()).mViewHolder.getLayoutPosition();
            rect.set(0, 0, 0, 0);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }
    }
}
