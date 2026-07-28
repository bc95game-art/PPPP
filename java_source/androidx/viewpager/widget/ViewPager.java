package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.constraintlayout.core.SolverVariable;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.zzab;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.CaptureService;
import com.github.appintro.internal.AppIntroViewPager;
import com.google.android.material.tabs.TabLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public abstract class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private float mLastMotionX;
    private float mLastMotionY;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private PagerObserver mObserver;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private EdgeEffect mRightEdge;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    static final int[] LAYOUT_ATTRS = {16842931};
    private static final Comparator<ItemInfo> COMPARATOR = new C01171(0);
    private static final Interpolator sInterpolator = new animationInterpolatorC01182(0);
    private static final ViewPositionComparator sPositionComparator = new Object();
    private final ArrayList<ItemInfo> mItems = new ArrayList<>();
    private final ItemInfo mTempItem = new Object();
    private final Rect mTempRect = new Rect();
    private int mRestoredCurItem = -1;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private float mFirstOffset = -3.4028235E38f;
    private float mLastOffset = Float.MAX_VALUE;
    private int mOffscreenPageLimit = 1;
    private int mActivePointerId = -1;
    private boolean mFirstLayout = true;
    private boolean mNeedCalculatePageOffsets = false;
    private final Runnable mEndScrollRunnable = new zzab(8, (AppIntroViewPager) this);
    private int mScrollState = 0;

    /* renamed from: androidx.viewpager.widget.ViewPager$1 */
    /* loaded from: classes.dex */
    public final class C01171 implements Comparator {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ C01171(int i) {
            this.$r8$classId = i;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            boolean z;
            boolean z2;
            switch (this.$r8$classId) {
                case 0:
                    return ((ItemInfo) obj).position - ((ItemInfo) obj2).position;
                case 1:
                    return ((SolverVariable) obj).f1id - ((SolverVariable) obj2).f1id;
                case 2:
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    float z3 = ViewCompat.Api21Impl.getZ((View) obj);
                    float z4 = ViewCompat.Api21Impl.getZ((View) obj2);
                    if (z3 > z4) {
                        return -1;
                    }
                    if (z3 < z4) {
                        return 1;
                    }
                    return 0;
                case 3:
                    GapWorker.Task task = (GapWorker.Task) obj;
                    GapWorker.Task task2 = (GapWorker.Task) obj2;
                    RecyclerView recyclerView = task.view;
                    if (recyclerView == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (task2.view == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z == z2) {
                        boolean z5 = task.neededNextFrame;
                        if (z5 == task2.neededNextFrame) {
                            int i = task2.viewVelocity - task.viewVelocity;
                            if (i != 0) {
                                return i;
                            }
                            int i2 = task.distanceToItem - task2.distanceToItem;
                            if (i2 != 0) {
                                return i2;
                            }
                            return 0;
                        } else if (!z5) {
                            return 1;
                        }
                    } else if (recyclerView == null) {
                        return 1;
                    }
                    return -1;
                case 4:
                    return ((int[]) obj)[0] - ((int[]) obj2)[0];
                case 5:
                    return ((View) obj).getTop() - ((View) obj2).getTop();
                default:
                    return ((Comparable) obj).compareTo((Comparable) obj2);
            }
        }
    }

    /* renamed from: androidx.viewpager.widget.ViewPager$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class animationInterpolatorC01182 implements Interpolator {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ animationInterpolatorC01182(int i) {
            this.$r8$classId = i;
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            switch (this.$r8$classId) {
                case 0:
                case 1:
                default:
                    float f2 = f - 1.0f;
                    return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface DecorView {
    }

    /* loaded from: classes.dex */
    public final class ItemInfo {
        public Object object;
        public float offset;
        public int position;
        public boolean scrolling;
        public float widthFactor;
    }

    /* loaded from: classes.dex */
    public final class LayoutParams extends ViewGroup.LayoutParams {
        public int childIndex;
        public int gravity;
        public boolean isDecor;
        public boolean needsMeasure;
        public int position;
        public float widthFactor;
    }

    /* loaded from: classes.dex */
    public final class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        public MyAccessibilityDelegate() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
            if (r0.getCount() > 1) goto L7;
         */
        @Override // androidx.core.view.AccessibilityDelegateCompat
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            boolean z;
            PagerAdapter pagerAdapter;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            ViewPager viewPager = ViewPager.this;
            PagerAdapter pagerAdapter2 = viewPager.mAdapter;
            if (pagerAdapter2 != null) {
                z = true;
            }
            z = false;
            accessibilityEvent.setScrollable(z);
            if (accessibilityEvent.getEventType() == 4096 && (pagerAdapter = viewPager.mAdapter) != null) {
                accessibilityEvent.setItemCount(pagerAdapter.getCount());
                accessibilityEvent.setFromIndex(viewPager.mCurItem);
                accessibilityEvent.setToIndex(viewPager.mCurItem);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            boolean z;
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            ViewPager viewPager = ViewPager.this;
            PagerAdapter pagerAdapter = viewPager.mAdapter;
            if (pagerAdapter == null || pagerAdapter.getCount() <= 1) {
                z = false;
            } else {
                z = true;
            }
            accessibilityNodeInfoCompat.setScrollable(z);
            if (viewPager.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (viewPager.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.addAction(CaptureService.CONNECTIONS_LOG_SIZE);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            ViewPager viewPager = ViewPager.this;
            if (i != 4096) {
                if (i != 8192 || !viewPager.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager.setCurrentItem(viewPager.mCurItem - 1);
                return true;
            } else if (!viewPager.canScrollHorizontally(1)) {
                return false;
            } else {
                viewPager.setCurrentItem(viewPager.mCurItem + 1);
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnAdapterChangeListener {
    }

    /* loaded from: classes.dex */
    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    /* loaded from: classes.dex */
    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    /* loaded from: classes.dex */
    public final class PagerObserver extends DataSetObserver {
        public PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.C00522(7);
        public Parcelable adapterState;
        public final ClassLoader loader;
        public int position;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? SavedState.class.getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }
    }

    /* loaded from: classes.dex */
    public final class ViewPositionComparator implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            boolean z = layoutParams.isDecor;
            if (z == layoutParams2.isDecor) {
                return layoutParams.position - layoutParams2.position;
            }
            if (z) {
                return 1;
            }
            return -1;
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.viewpager.widget.ViewPager$ItemInfo, java.lang.Object] */
    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ItemInfo infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.viewpager.widget.ViewPager$ItemInfo, java.lang.Object] */
    public ItemInfo addNewItem(int i, int i2) {
        ?? obj = new Object();
        obj.position = i;
        obj.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
        obj.widthFactor = this.mAdapter.getPageWidth(i);
        if (i2 < 0 || i2 >= this.mItems.size()) {
            this.mItems.add(obj);
            return obj;
        }
        this.mItems.add(i2, obj);
        return obj;
    }

    public void addOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(onAdapterChangeListener);
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        boolean z;
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z2 = layoutParams2.isDecor;
        if (view.getClass().getAnnotation(DecorView.class) != null) {
            z = true;
        } else {
            z = false;
        }
        boolean z3 = z2 | z;
        layoutParams2.isDecor = z3;
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams);
        } else if (!z3) {
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean arrowScroll(int i) {
        View findNextFocus;
        boolean z;
        View findFocus = findFocus();
        if (findFocus != this) {
            if (findFocus != null) {
                for (ViewParent parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(findFocus.getClass().getSimpleName());
                for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                    sb.append(" => ");
                    sb.append(parent2.getClass().getSimpleName());
                }
                Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
            if (findNextFocus != null || findNextFocus == findFocus) {
                if (i != 17 || i == 1) {
                    z = pageLeft();
                } else {
                    if (i == 66 || i == 2) {
                        z = pageRight();
                    }
                    z = false;
                }
            } else if (i == 17) {
                int i2 = getChildRectInPagerCoordinates(findNextFocus, this.mTempRect).left;
                int i3 = getChildRectInPagerCoordinates(findFocus, this.mTempRect).left;
                if (findFocus == null || i2 < i3) {
                    z = findNextFocus.requestFocus();
                } else {
                    z = pageLeft();
                }
            } else {
                if (i == 66) {
                    int i4 = getChildRectInPagerCoordinates(findNextFocus, this.mTempRect).left;
                    int i5 = getChildRectInPagerCoordinates(findFocus, this.mTempRect).left;
                    if (findFocus == null || i4 > i5) {
                        z = findNextFocus.requestFocus();
                    } else {
                        z = pageRight();
                    }
                }
                z = false;
            }
            if (z) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return z;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        if (findNextFocus != null) {
        }
        if (i != 17) {
        }
        z = pageLeft();
        if (z) {
        }
        return z;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (!z || !view.canScrollHorizontally(-i)) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (clientWidth * this.mFirstOffset))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (clientWidth * this.mLastOffset))) {
            return false;
        } else {
            return true;
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public void clearOnPageChangeListeners() {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    public final void completeScroll(boolean z) {
        boolean z2;
        if (this.mScrollState == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = this.mItems.get(i);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                z2 = true;
            }
        }
        if (!z2) {
            return;
        }
        if (z) {
            Runnable runnable = this.mEndScrollRunnable;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            postOnAnimation(runnable);
            return;
        }
        this.mEndScrollRunnable.run();
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        postInvalidateOnAnimation();
    }

    public void dataSetChanged() {
        boolean z;
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        if (this.mItems.size() >= (this.mOffscreenPageLimit * 2) + 1 || this.mItems.size() >= count) {
            z = false;
        } else {
            z = true;
        }
        int i = this.mCurItem;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (!z2) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    int i3 = this.mCurItem;
                    if (i3 == itemInfo.position) {
                        i = Math.max(0, Math.min(i3, count - 1));
                    }
                } else {
                    int i4 = itemInfo.position;
                    if (i4 != itemPosition) {
                        if (i4 == this.mCurItem) {
                            i = itemPosition;
                        }
                        itemInfo.position = itemPosition;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
    }

    public final int determineTargetPage(int i, float f, int i2, int i3) {
        float f2;
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            if (i >= this.mCurItem) {
                f2 = 0.4f;
            } else {
                f2 = 0.6f;
            }
            i += (int) (f + f2);
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() <= 0) {
            return i;
        }
        ArrayList<ItemInfo> arrayList = this.mItems;
        return Math.max(this.mItems.get(0).position, Math.min(i, arrayList.get(arrayList.size() - 1).position));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public final void dispatchOnPageSelected(int i) {
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i2);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageSelected(i);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageSelected(i);
        }
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.mAdapter) != null && pagerAdapter.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                z = this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mRightEdge.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
                this.mRightEdge.setSize(height2, width2);
                z |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (z) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollX / clientWidth) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 21) {
            if (keyCode != 22) {
                if (keyCode != 61) {
                    return false;
                }
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
                return false;
            } else if (keyEvent.hasModifiers(2)) {
                return pageRight();
            } else {
                return arrowScroll(66);
            }
        } else if (keyEvent.hasModifiers(2)) {
            return pageLeft();
        } else {
            return arrowScroll(17);
        }
    }

    public void fakeDragBy(float f) {
        ArrayList<ItemInfo> arrayList;
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f;
            float scrollX = getScrollX() - f;
            float clientWidth = getClientWidth();
            float f2 = this.mFirstOffset * clientWidth;
            float f3 = this.mLastOffset * clientWidth;
            ItemInfo itemInfo = this.mItems.get(0);
            ItemInfo itemInfo2 = this.mItems.get(arrayList.size() - 1);
            if (itemInfo.position != 0) {
                f2 = itemInfo.offset * clientWidth;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f3 = itemInfo2.offset * clientWidth;
            }
            if (scrollX < f2) {
                scrollX = f2;
            } else if (scrollX > f3) {
                scrollX = f3;
            }
            int i = (int) scrollX;
            this.mLastMotionX = (scrollX - i) + this.mLastMotionX;
            scrollTo(i, getScrollY());
            pageScrolled(i);
            MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(obtain);
            obtain.recycle();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.viewpager.widget.ViewPager$LayoutParams, android.view.ViewGroup$LayoutParams] */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ?? layoutParams = new ViewGroup.LayoutParams(-1, -1);
        layoutParams.widthFactor = 0.0f;
        return layoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i2).getLayoutParams()).childIndex;
    }

    public final Rect getChildRectInPagerCoordinates(View view, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public ItemInfo infoForAnyChild(View view) {
        while (true) {
            ViewParent parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public ItemInfo infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    public final ItemInfo infoForCurrentScrollPosition() {
        float f;
        float f2;
        int i;
        int clientWidth = getClientWidth();
        float f3 = 0.0f;
        if (clientWidth > 0) {
            f = getScrollX() / clientWidth;
        } else {
            f = 0.0f;
        }
        if (clientWidth > 0) {
            f2 = this.mPageMargin / clientWidth;
        } else {
            f2 = 0.0f;
        }
        ItemInfo itemInfo = null;
        float f4 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        while (i3 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i3);
            if (!z && itemInfo2.position != (i = i2 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.offset = f3 + f4 + f2;
                itemInfo2.position = i;
                itemInfo2.widthFactor = this.mAdapter.getPageWidth(i);
                i3--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f3 = itemInfo3.offset;
            float f5 = itemInfo3.widthFactor + f3 + f2;
            if (!z && f < f3) {
                break;
            } else if (f < f5 || i3 == this.mItems.size() - 1) {
                return itemInfo3;
            } else {
                int i4 = itemInfo3.position;
                float f6 = itemInfo3.widthFactor;
                i3++;
                i2 = i4;
                f4 = f6;
                itemInfo = itemInfo3;
                z = false;
            }
        }
        return itemInfo;
    }

    public ItemInfo infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = this.mItems.get(i2);
            if (itemInfo.position == i) {
                return itemInfo;
            }
        }
        return null;
    }

    public void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (f * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this, new zzcl(this));
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width;
        int i;
        float f;
        int i2;
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && this.mMarginDrawable != null && this.mItems.size() > 0 && this.mAdapter != null) {
            int scrollX = getScrollX();
            float width2 = getWidth();
            float f2 = this.mPageMargin / width2;
            int i3 = 0;
            ItemInfo itemInfo = this.mItems.get(0);
            float f3 = itemInfo.offset;
            int size = this.mItems.size();
            int i4 = itemInfo.position;
            int i5 = this.mItems.get(size - 1).position;
            while (i4 < i5) {
                while (true) {
                    i = itemInfo.position;
                    if (i4 <= i || i3 >= size) {
                        break;
                    }
                    i3++;
                    itemInfo = this.mItems.get(i3);
                }
                if (i4 == i) {
                    float f4 = itemInfo.offset;
                    float f5 = itemInfo.widthFactor;
                    f = (f4 + f5) * width2;
                    f3 = f4 + f5 + f2;
                } else {
                    float pageWidth = this.mAdapter.getPageWidth(i4);
                    f = (f3 + pageWidth) * width2;
                    f3 = pageWidth + f2 + f3;
                }
                if (this.mPageMargin + f > scrollX) {
                    i2 = scrollX;
                    this.mMarginDrawable.setBounds(Math.round(f), this.mTopPageBounds, Math.round(this.mPageMargin + f), this.mBottomPageBounds);
                    this.mMarginDrawable.draw(canvas);
                } else {
                    i2 = scrollX;
                }
                if (f <= i2 + width) {
                    i4++;
                    scrollX = i2;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i = this.mActivePointerId;
            if (i != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i);
                float x2 = motionEvent.getX(findPointerIndex);
                float f2 = x2 - this.mLastMotionX;
                float abs = Math.abs(f2);
                float y2 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.mInitialMotionY);
                int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i2 != 0) {
                    float f3 = this.mLastMotionX;
                    if ((f3 >= this.mGutterSize || i2 <= 0) && ((f3 <= getWidth() - this.mGutterSize || f2 >= 0.0f) && canScroll(this, false, (int) f2, (int) x2, (int) y2))) {
                        this.mLastMotionX = x2;
                        this.mLastMotionY = y2;
                        this.mIsUnableToDrag = true;
                        return false;
                    }
                }
                float f4 = this.mTouchSlop;
                if (abs > f4 && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f5 = this.mInitialMotionX;
                    float f6 = this.mTouchSlop;
                    if (i2 > 0) {
                        f = f5 + f6;
                    } else {
                        f = f5 - f6;
                    }
                    this.mLastMotionX = f;
                    this.mLastMotionY = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > f4) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x2)) {
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ItemInfo infoForChild;
        int i5;
        int i6;
        int max;
        int max2;
        int childCount = getChildCount();
        int i7 = i3 - i;
        int i8 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i11 = layoutParams.gravity;
                    int i12 = i11 & 7;
                    int i13 = i11 & 112;
                    if (i12 != 1) {
                        if (i12 == 3) {
                            i5 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i12 != 5) {
                            i5 = paddingLeft;
                        } else {
                            max2 = (i7 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i13 == 16) {
                            if (i13 == 48) {
                                i6 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i13 != 80) {
                                i6 = paddingTop;
                            } else {
                                max = (i8 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i14 = paddingLeft + scrollX;
                            childAt.layout(i14, paddingTop, childAt.getMeasuredWidth() + i14, childAt.getMeasuredHeight() + paddingTop);
                            i9++;
                            paddingTop = i6;
                            paddingLeft = i5;
                        } else {
                            max = Math.max((i8 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i15 = max;
                        i6 = paddingTop;
                        paddingTop = i15;
                        int i142 = paddingLeft + scrollX;
                        childAt.layout(i142, paddingTop, childAt.getMeasuredWidth() + i142, childAt.getMeasuredHeight() + paddingTop);
                        i9++;
                        paddingTop = i6;
                        paddingLeft = i5;
                    } else {
                        max2 = Math.max((i7 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i16 = max2;
                    i5 = paddingLeft;
                    paddingLeft = i16;
                    if (i13 == 16) {
                    }
                    int i152 = max;
                    i6 = paddingTop;
                    paddingTop = i152;
                    int i1422 = paddingLeft + scrollX;
                    childAt.layout(i1422, paddingTop, childAt.getMeasuredWidth() + i1422, childAt.getMeasuredHeight() + paddingTop);
                    i9++;
                    paddingTop = i6;
                    paddingLeft = i5;
                }
            }
        }
        int i17 = (i7 - paddingLeft) - paddingRight;
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt2 = getChildAt(i18);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (infoForChild = infoForChild(childAt2)) != null) {
                    float f = i17;
                    int i19 = ((int) (infoForChild.offset * f)) + paddingLeft;
                    if (layoutParams2.needsMeasure) {
                        layoutParams2.needsMeasure = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.widthFactor), 1073741824), View.MeasureSpec.makeMeasureSpec((i8 - paddingTop) - paddingBottom, 1073741824));
                    }
                    childAt2.layout(i19, paddingTop, childAt2.getMeasuredWidth() + i19, childAt2.getMeasuredHeight() + paddingTop);
                }
            }
        }
        this.mTopPageBounds = paddingTop;
        this.mBottomPageBounds = i8 - paddingBottom;
        this.mDecorChildCount = i9;
        if (this.mFirstLayout) {
            z2 = false;
            scrollToItem(this.mCurItem, 0, false, false);
        } else {
            z2 = false;
        }
        this.mFirstLayout = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a7  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z;
        int i3;
        int i4;
        int i5;
        setMeasuredDimension(View.getDefaultSize(0, i), View.getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (!(childAt.getVisibility() == 8 || (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) == null || !layoutParams2.isDecor)) {
                int i8 = layoutParams2.gravity;
                int i9 = i8 & 7;
                int i10 = i8 & 112;
                if (i10 == 48 || i10 == 80) {
                    z = true;
                } else {
                    z = false;
                }
                if (!(i9 == 3 || i9 == 5)) {
                    z2 = false;
                }
                int i11 = Integer.MIN_VALUE;
                if (z) {
                    i11 = 1073741824;
                } else if (z2) {
                    i3 = 1073741824;
                    i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                    if (i4 == -2) {
                        if (i4 == -1) {
                            i4 = paddingLeft;
                        }
                        i11 = 1073741824;
                    } else {
                        i4 = paddingLeft;
                    }
                    i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                    if (i5 != -2) {
                        i5 = measuredHeight;
                        i7 = i3;
                    } else if (i5 == -1) {
                        i5 = measuredHeight;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                    if (!z) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (z2) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
                i3 = Integer.MIN_VALUE;
                i4 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i4 == -2) {
                }
                i5 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i5 != -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i11), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (!z) {
                }
            }
            i6++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i12 = 0; i12 < childCount2; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.isDecor)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * layoutParams.widthFactor), 1073741824), this.mChildHeightMeasureSpec);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageScrolled(int i, float f, int i2) {
        int i3;
        int left;
        int max;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i5 = layoutParams.gravity & 7;
                    if (i5 != 1) {
                        if (i5 == 3) {
                            i3 = childAt.getWidth() + paddingLeft;
                        } else if (i5 != 5) {
                            i3 = paddingLeft;
                        } else {
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        left = (paddingLeft + scrollX) - childAt.getLeft();
                        if (left != 0) {
                            childAt.offsetLeftAndRight(left);
                        }
                        paddingLeft = i3;
                    } else {
                        max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i6 = max;
                    i3 = paddingLeft;
                    paddingLeft = i6;
                    left = (paddingLeft + scrollX) - childAt.getLeft();
                    if (left != 0) {
                    }
                    paddingLeft = i3;
                }
            }
        }
        OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i7 = 0; i7 < size; i7++) {
                OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i7);
                if (onPageChangeListener2 != null) {
                    onPageChangeListener2.onPageScrolled(i, f, i2);
                }
            }
        }
        OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
        if (onPageChangeListener3 != null) {
            onPageChangeListener3.onPageScrolled(i, f, i2);
        }
        if (this.mPageTransformer != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i8 = 0; i8 < childCount2; i8++) {
                View childAt2 = getChildAt(i8);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        ItemInfo infoForChild;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i4 = 0;
            i2 = 1;
        } else {
            i4 = childCount - 1;
            i3 = -1;
            i2 = -1;
        }
        while (i4 != i3) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                return true;
            }
            i4 += i2;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        ClassLoader classLoader = savedState.loader;
        super.onRestoreInstanceState(savedState.mSuperState);
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.adapterState, classLoader);
            setCurrentItemInternal(savedState.position, false, true);
            return;
        }
        this.mRestoredCurItem = savedState.position;
        this.mRestoredAdapterState = savedState.adapterState;
        this.mRestoredClassLoader = classLoader;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.viewpager.widget.ViewPager$SavedState, android.os.Parcelable, androidx.customview.view.AbsSavedState] */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        absSavedState.position = this.mCurItem;
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter != null) {
            absSavedState.adapterState = pagerAdapter.saveState();
        }
        return absSavedState;
    }

    public final void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            if (actionIndex == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.mLastMotionX = motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.mPageMargin;
            recomputeScrollPosition(i, i3, i5, i5);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        float f;
        if (!this.mFakeDragging) {
            boolean z = false;
            if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.mAdapter) == null || pagerAdapter.getCount() == 0) {
                return false;
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                float x = motionEvent.getX();
                this.mInitialMotionX = x;
                this.mLastMotionX = x;
                float y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
            } else if (action != 1) {
                if (action == 2) {
                    if (!this.mIsBeingDragged) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex == -1) {
                            z = resetTouch();
                        } else {
                            float x2 = motionEvent.getX(findPointerIndex);
                            float abs = Math.abs(x2 - this.mLastMotionX);
                            float y2 = motionEvent.getY(findPointerIndex);
                            float abs2 = Math.abs(y2 - this.mLastMotionY);
                            if (abs > this.mTouchSlop && abs > abs2) {
                                this.mIsBeingDragged = true;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                                float f2 = this.mInitialMotionX;
                                if (x2 - f2 > 0.0f) {
                                    f = f2 + this.mTouchSlop;
                                } else {
                                    f = f2 - this.mTouchSlop;
                                }
                                this.mLastMotionX = f;
                                this.mLastMotionY = y2;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent2 = getParent();
                                if (parent2 != null) {
                                    parent2.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                    if (this.mIsBeingDragged) {
                        z = performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                    }
                } else if (action != 3) {
                    if (action == 5) {
                        int actionIndex = motionEvent.getActionIndex();
                        this.mLastMotionX = motionEvent.getX(actionIndex);
                        this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    } else if (action == 6) {
                        onSecondaryPointerUp(motionEvent);
                        this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                    }
                } else if (this.mIsBeingDragged) {
                    scrollToItem(this.mCurItem, 0, true, false);
                    z = resetTouch();
                }
            } else if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                float f3 = clientWidth;
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollX / f3) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (this.mPageMargin / f3)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
                z = resetTouch();
            }
            if (z) {
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                postInvalidateOnAnimation();
            }
        }
        return true;
    }

    public boolean pageLeft() {
        int i = this.mCurItem;
        if (i <= 0) {
            return false;
        }
        setCurrentItem(i - 1, true);
        return true;
    }

    public boolean pageRight() {
        PagerAdapter pagerAdapter = this.mAdapter;
        if (pagerAdapter == null || this.mCurItem >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public final boolean pageScrolled(int i) {
        if (this.mItems.size() != 0) {
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin;
            int i3 = clientWidth + i2;
            float f = clientWidth;
            int i4 = infoForCurrentScrollPosition.position;
            float f2 = ((i / f) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (i2 / f));
            this.mCalledSuper = false;
            onPageScrolled(i4, f2, (int) (i3 * f2));
            if (this.mCalledSuper) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    public final boolean performDrag(float f) {
        boolean z;
        boolean z2;
        float f2 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.mFirstOffset * clientWidth;
        float f4 = this.mLastOffset * clientWidth;
        boolean z3 = false;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.position != 0) {
            f3 = itemInfo.offset * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f4 = itemInfo2.offset * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.mLeftEdge.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.mRightEdge.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.mLastMotionX = (scrollX - i) + this.mLastMotionX;
        scrollTo(i, getScrollY());
        pageScrolled(i);
        return z3;
    }

    public void populate() {
        populate(this.mCurItem);
    }

    public final void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        float f;
        if (i2 <= 0 || this.mItems.isEmpty()) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            if (infoForPosition != null) {
                f = Math.min(infoForPosition.offset, this.mLastOffset);
            } else {
                f = 0.0f;
            }
            int paddingLeft = (int) (f * ((i - getPaddingLeft()) - getPaddingRight()));
            if (paddingLeft != getScrollX()) {
                completeScroll(false);
                scrollTo(paddingLeft, getScrollY());
            }
        } else if (!this.mScroller.isFinished()) {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
        }
    }

    public void removeOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(onAdapterChangeListener);
        }
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        List<OnPageChangeListener> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(onPageChangeListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final boolean resetTouch() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (this.mLeftEdge.isFinished() || this.mRightEdge.isFinished()) {
            return true;
        }
        return false;
    }

    public final void scrollToItem(int i, int i2, boolean z, boolean z2) {
        int i3;
        ItemInfo infoForPosition = infoForPosition(i);
        if (infoForPosition != null) {
            i3 = (int) (Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset)) * getClientWidth());
        } else {
            i3 = 0;
        }
        if (z) {
            smoothScrollTo(i3, 0, i2);
            if (z2) {
                dispatchOnPageSelected(i);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i);
        }
        completeScroll(false);
        scrollTo(i3, 0);
        pageScrolled(i3);
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        PagerAdapter pagerAdapter2 = this.mAdapter;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i = 0; i < this.mItems.size(); i++) {
                ItemInfo itemInfo = this.mItems.get(i);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            int i2 = 0;
            while (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).isDecor) {
                    removeViewAt(i2);
                    i2--;
                }
                i2++;
            }
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (pagerAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (!z) {
                populate();
            } else {
                requestLayout();
            }
        }
        List<OnAdapterChangeListener> list = this.mAdapterChangeListeners;
        if (!(list == null || list.isEmpty())) {
            int size = this.mAdapterChangeListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                TabLayout.AdapterChangeListener adapterChangeListener = (TabLayout.AdapterChangeListener) this.mAdapterChangeListeners.get(i3);
                TabLayout tabLayout = TabLayout.this;
                if (tabLayout.viewPager == this) {
                    tabLayout.setPagerAdapter(pagerAdapter, adapterChangeListener.autoRefresh);
                }
            }
        }
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, !this.mFirstLayout, false);
    }

    public void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    public OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        setPageTransformer(z, pageTransformer, 2);
    }

    public void setScrollState(int i) {
        boolean z;
        int i2;
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                if (i != 0) {
                    z = true;
                } else {
                    z = false;
                }
                int childCount = getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (z) {
                        i2 = this.mPageTransformerLayerType;
                    } else {
                        i2 = 0;
                    }
                    getChildAt(i3).setLayerType(i2, null);
                }
            }
            OnPageChangeListener onPageChangeListener = this.mOnPageChangeListener;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrollStateChanged(i);
            }
            List<OnPageChangeListener> list = this.mOnPageChangeListeners;
            if (list != null) {
                int size = list.size();
                for (int i4 = 0; i4 < size; i4++) {
                    OnPageChangeListener onPageChangeListener2 = this.mOnPageChangeListeners.get(i4);
                    if (onPageChangeListener2 != null) {
                        onPageChangeListener2.onPageScrollStateChanged(i);
                    }
                }
            }
            OnPageChangeListener onPageChangeListener3 = this.mInternalPageChangeListener;
            if (onPageChangeListener3 != null) {
                onPageChangeListener3.onPageScrollStateChanged(i);
            }
        }
    }

    public void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    public final void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.mMarginDrawable) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.viewpager.widget.ViewPager$LayoutParams, android.view.ViewGroup$LayoutParams] */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ?? layoutParams = new ViewGroup.LayoutParams(context, attributeSet);
        layoutParams.widthFactor = 0.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        layoutParams.gravity = obtainStyledAttributes.getInteger(0, 48);
        obtainStyledAttributes.recycle();
        return layoutParams;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
        if (r9 == r10) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
        r8 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void populate(int i) {
        ItemInfo itemInfo;
        String str;
        ItemInfo itemInfo2;
        float f;
        ItemInfo infoForChild;
        int i2;
        int i3;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        ItemInfo itemInfo5;
        int i4 = this.mCurItem;
        if (i4 != i) {
            itemInfo = infoForPosition(i4);
            this.mCurItem = i;
        } else {
            itemInfo = null;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
        } else if (this.mPopulatePending) {
            sortChildDrawingOrder();
        } else if (getWindowToken() != null) {
            this.mAdapter.startUpdate((ViewGroup) this);
            int i5 = this.mOffscreenPageLimit;
            int max = Math.max(0, this.mCurItem - i5);
            int count = this.mAdapter.getCount();
            int min = Math.min(count - 1, this.mCurItem + i5);
            if (count == this.mExpectedAdapterCount) {
                int i6 = 0;
                while (true) {
                    if (i6 >= this.mItems.size()) {
                        break;
                    }
                    itemInfo2 = this.mItems.get(i6);
                    int i7 = itemInfo2.position;
                    int i8 = this.mCurItem;
                    if (i7 < i8) {
                        i6++;
                    }
                }
                if (itemInfo2 == null && count > 0) {
                    itemInfo2 = addNewItem(this.mCurItem, i6);
                }
                if (itemInfo2 != null) {
                    int i9 = i6 - 1;
                    ItemInfo itemInfo6 = i9 >= 0 ? this.mItems.get(i9) : null;
                    int clientWidth = getClientWidth();
                    float paddingLeft = clientWidth <= 0 ? 0.0f : (getPaddingLeft() / clientWidth) + (2.0f - itemInfo2.widthFactor);
                    float f2 = 0.0f;
                    for (int i10 = this.mCurItem - 1; i10 >= 0; i10--) {
                        if (f2 < paddingLeft || i10 >= max) {
                            if (itemInfo6 == null || i10 != itemInfo6.position) {
                                f2 += addNewItem(i10, i9 + 1).widthFactor;
                                i6++;
                                if (i9 >= 0) {
                                    itemInfo5 = this.mItems.get(i9);
                                    itemInfo6 = itemInfo5;
                                }
                                itemInfo5 = null;
                                itemInfo6 = itemInfo5;
                            } else {
                                f2 += itemInfo6.widthFactor;
                                i9--;
                                if (i9 >= 0) {
                                    itemInfo5 = this.mItems.get(i9);
                                    itemInfo6 = itemInfo5;
                                }
                                itemInfo5 = null;
                                itemInfo6 = itemInfo5;
                            }
                        } else if (itemInfo6 == null) {
                            break;
                        } else if (i10 == itemInfo6.position && !itemInfo6.scrolling) {
                            this.mItems.remove(i9);
                            this.mAdapter.destroyItem((ViewGroup) this, i10, itemInfo6.object);
                            i9--;
                            i6--;
                            if (i9 >= 0) {
                                itemInfo5 = this.mItems.get(i9);
                                itemInfo6 = itemInfo5;
                            }
                            itemInfo5 = null;
                            itemInfo6 = itemInfo5;
                        }
                    }
                    f = 0.0f;
                    float f3 = itemInfo2.widthFactor;
                    int i11 = i6 + 1;
                    if (f3 < 2.0f) {
                        ItemInfo itemInfo7 = i11 < this.mItems.size() ? this.mItems.get(i11) : null;
                        float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                        int i12 = i11;
                        for (int i13 = this.mCurItem + 1; i13 < count; i13++) {
                            if (f3 < paddingRight || i13 <= min) {
                                if (itemInfo7 == null || i13 != itemInfo7.position) {
                                    ItemInfo addNewItem = addNewItem(i13, i12);
                                    i12++;
                                    f3 += addNewItem.widthFactor;
                                    if (i12 < this.mItems.size()) {
                                        itemInfo7 = this.mItems.get(i12);
                                    }
                                    itemInfo7 = null;
                                } else {
                                    f3 += itemInfo7.widthFactor;
                                    i12++;
                                    if (i12 < this.mItems.size()) {
                                        itemInfo7 = this.mItems.get(i12);
                                    }
                                    itemInfo7 = null;
                                }
                            } else if (itemInfo7 == null) {
                                break;
                            } else {
                                if (i13 == itemInfo7.position && !itemInfo7.scrolling) {
                                    this.mItems.remove(i12);
                                    this.mAdapter.destroyItem((ViewGroup) this, i13, itemInfo7.object);
                                    if (i12 < this.mItems.size()) {
                                        itemInfo7 = this.mItems.get(i12);
                                    }
                                    itemInfo7 = null;
                                }
                            }
                        }
                    }
                    int count2 = this.mAdapter.getCount();
                    int clientWidth2 = getClientWidth();
                    float f4 = clientWidth2 > 0 ? this.mPageMargin / clientWidth2 : 0.0f;
                    if (itemInfo != null) {
                        int i14 = itemInfo.position;
                        int i15 = itemInfo2.position;
                        if (i14 < i15) {
                            float f5 = itemInfo.offset + itemInfo.widthFactor + f4;
                            int i16 = i14 + 1;
                            int i17 = 0;
                            while (i16 <= itemInfo2.position && i17 < this.mItems.size()) {
                                ItemInfo itemInfo8 = this.mItems.get(i17);
                                while (true) {
                                    itemInfo4 = itemInfo8;
                                    if (i16 <= itemInfo4.position || i17 >= this.mItems.size() - 1) {
                                        break;
                                    }
                                    i17++;
                                    itemInfo8 = this.mItems.get(i17);
                                }
                                while (i16 < itemInfo4.position) {
                                    f5 += this.mAdapter.getPageWidth(i16) + f4;
                                    i16++;
                                }
                                itemInfo4.offset = f5;
                                f5 += itemInfo4.widthFactor + f4;
                                i16++;
                            }
                        } else if (i14 > i15) {
                            int size = this.mItems.size() - 1;
                            float f6 = itemInfo.offset;
                            while (true) {
                                i14--;
                                if (i14 < itemInfo2.position || size < 0) {
                                    break;
                                }
                                ItemInfo itemInfo9 = this.mItems.get(size);
                                while (true) {
                                    itemInfo3 = itemInfo9;
                                    if (i14 >= itemInfo3.position || size <= 0) {
                                        break;
                                    }
                                    size--;
                                    itemInfo9 = this.mItems.get(size);
                                }
                                while (i14 > itemInfo3.position) {
                                    f6 -= this.mAdapter.getPageWidth(i14) + f4;
                                    i14--;
                                }
                                f6 -= itemInfo3.widthFactor + f4;
                                itemInfo3.offset = f6;
                            }
                        }
                    }
                    int size2 = this.mItems.size();
                    float f7 = itemInfo2.offset;
                    int i18 = itemInfo2.position;
                    int i19 = i18 - 1;
                    this.mFirstOffset = i18 == 0 ? f7 : -3.4028235E38f;
                    int i20 = count2 - 1;
                    this.mLastOffset = i18 == i20 ? (itemInfo2.widthFactor + f7) - 1.0f : Float.MAX_VALUE;
                    int i21 = i6 - 1;
                    while (i21 >= 0) {
                        ItemInfo itemInfo10 = this.mItems.get(i21);
                        while (true) {
                            i3 = itemInfo10.position;
                            if (i19 <= i3) {
                                break;
                            }
                            i19--;
                            f7 -= this.mAdapter.getPageWidth(i19) + f4;
                        }
                        f7 -= itemInfo10.widthFactor + f4;
                        itemInfo10.offset = f7;
                        if (i3 == 0) {
                            this.mFirstOffset = f7;
                        }
                        i21--;
                        i19--;
                    }
                    float f8 = itemInfo2.offset + itemInfo2.widthFactor + f4;
                    int i22 = itemInfo2.position;
                    while (true) {
                        i22++;
                        if (i11 >= size2) {
                            break;
                        }
                        ItemInfo itemInfo11 = this.mItems.get(i11);
                        while (true) {
                            i2 = itemInfo11.position;
                            if (i22 >= i2) {
                                break;
                            }
                            i22++;
                            f8 += this.mAdapter.getPageWidth(i22) + f4;
                        }
                        if (i2 == i20) {
                            this.mLastOffset = (itemInfo11.widthFactor + f8) - 1.0f;
                        }
                        itemInfo11.offset = f8;
                        f8 += itemInfo11.widthFactor + f4;
                        i11++;
                    }
                    this.mNeedCalculatePageOffsets = false;
                    this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, itemInfo2.object);
                } else {
                    f = 0.0f;
                }
                this.mAdapter.finishUpdate((ViewGroup) this);
                int childCount = getChildCount();
                for (int i23 = 0; i23 < childCount; i23++) {
                    View childAt = getChildAt(i23);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    layoutParams.childIndex = i23;
                    if (!layoutParams.isDecor && layoutParams.widthFactor == f && (infoForChild = infoForChild(childAt)) != null) {
                        layoutParams.widthFactor = infoForChild.widthFactor;
                        layoutParams.position = infoForChild.position;
                    }
                }
                sortChildDrawingOrder();
                if (hasFocus()) {
                    View findFocus = findFocus();
                    ItemInfo infoForAnyChild = findFocus != null ? infoForAnyChild(findFocus) : null;
                    if (infoForAnyChild == null || infoForAnyChild.position != this.mCurItem) {
                        for (int i24 = 0; i24 < getChildCount(); i24++) {
                            View childAt2 = getChildAt(i24);
                            ItemInfo infoForChild2 = infoForChild(childAt2);
                            if (infoForChild2 != null && infoForChild2.position == this.mCurItem && childAt2.requestFocus(2)) {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                str = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                str = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + str + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
        }
    }

    public void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        PagerAdapter pagerAdapter = this.mAdapter;
        boolean z3 = false;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.mCurItem != i || this.mItems.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.mAdapter.getCount()) {
                i = this.mAdapter.getCount() - 1;
            }
            int i3 = this.mOffscreenPageLimit;
            int i4 = this.mCurItem;
            if (i > i4 + i3 || i < i4 - i3) {
                for (int i5 = 0; i5 < this.mItems.size(); i5++) {
                    this.mItems.get(i5).scrolling = true;
                }
            }
            if (this.mCurItem != i) {
                z3 = true;
            }
            if (this.mFirstLayout) {
                this.mCurItem = i;
                if (z3) {
                    dispatchOnPageSelected(i);
                }
                requestLayout();
                return;
            }
            populate(i);
            scrollToItem(i, i2, z, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer, int i) {
        int i2 = 1;
        boolean z2 = pageTransformer != null;
        boolean z3 = z2 != (this.mPageTransformer != null);
        this.mPageTransformer = pageTransformer;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i2 = 2;
            }
            this.mDrawingOrder = i2;
            this.mPageTransformerLayerType = i;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z3) {
            populate();
        }
    }

    public void smoothScrollTo(int i, int i2, int i3) {
        int scrollX;
        int i4;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if (scroller == null || scroller.isFinished()) {
            scrollX = getScrollX();
        } else {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i - i5;
        int i7 = i2 - scrollY;
        if (i6 == 0 && i7 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i8;
        float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f)) * f2) + f2;
        int abs = Math.abs(i3);
        if (abs > 0) {
            i4 = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs) * 1000.0f) * 4;
        } else {
            i4 = (int) (((Math.abs(i6) / ((this.mAdapter.getPageWidth(this.mCurItem) * f) + this.mPageMargin)) + 1.0f) * 100.0f);
        }
        int min = Math.min(i4, (int) MAX_SETTLE_DURATION);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i5, scrollY, i6, i7, min);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        postInvalidateOnAnimation();
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(ContextCompat$Api21Impl.getDrawable(getContext(), i));
    }
}
