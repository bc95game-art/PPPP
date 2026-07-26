package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.collection.SimpleArrayMap;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.content.ContextCompat$Api21Impl;
import androidx.core.p002os.BundleKt;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.emoji2.text.MetadataRepo;
import androidx.navigation.NavOptions;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.FakeDrag;
import com.emanuelef.remote_capture.C0130R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import p004j$.util.DesugarCollections;
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    public static final Class[] CONSTRUCTOR_PARAMS;
    public static final ViewPager.C01171 TOP_SORTED_CHILDREN_COMPARATOR;
    public static final String WIDGET_PACKAGE_NAME;
    public static final ThreadLocal sConstructors;
    public static final Pools$SynchronizedPool sRectPool;
    public FakeDrag mApplyWindowInsetsListener;
    public View mBehaviorTouchView;
    public boolean mDisallowInterceptReset;
    public boolean mDrawStatusBarBackground;
    public boolean mIsAttachedToWindow;
    public final int[] mKeylines;
    public WindowInsetsCompat mLastInsets;
    public boolean mNeedsPreDrawListener;
    public View mNestedScrollingTarget;
    public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    public OnPreDrawListener mOnPreDrawListener;
    public Drawable mStatusBarBackground;
    public final ArrayList mDependencySortedChildren = new ArrayList();
    public final MetadataRepo mChildDag = new MetadataRepo(2);
    public final ArrayList mTempList1 = new ArrayList();
    public final ArrayList mTempDependenciesList = new ArrayList();
    public final int[] mBehaviorConsumed = new int[2];
    public final int[] mNestedScrollingV2ConsumedCompat = new int[2];
    public final NavOptions.Builder mNestedScrollingParentHelper = new Object();

    /* loaded from: classes.dex */
    public interface AttachedBehavior {
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface DefaultBehavior {
        Class value();
    }

    /* loaded from: classes.dex */
    public final class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        public HierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            coordinatorLayout.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = coordinatorLayout.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        public OnPreDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.C00522(3);
        public SparseArray behaviorStates;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.behaviorStates.append(iArr[i], readParcelableArray[i]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int i2;
            super.writeToParcel(parcel, i);
            SparseArray sparseArray = this.behaviorStates;
            if (sparseArray != null) {
                i2 = sparseArray.size();
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            int[] iArr = new int[i2];
            Parcelable[] parcelableArr = new Parcelable[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                iArr[i3] = this.behaviorStates.keyAt(i3);
                parcelableArr[i3] = (Parcelable) this.behaviorStates.valueAt(i3);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    static {
        String str;
        Package r0 = CoordinatorLayout.class.getPackage();
        if (r0 != null) {
            str = r0.getName();
        } else {
            str = null;
        }
        WIDGET_PACKAGE_NAME = str;
        TOP_SORTED_CHILDREN_COMPARATOR = new ViewPager.C01171(2);
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal();
        sRectPool = new Pools$SynchronizedPool(12);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.navigation.NavOptions$Builder, java.lang.Object] */
    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, C0130R.attr.coordinatorLayoutStyle);
        Context context2;
        CoordinatorLayout coordinatorLayout;
        int[] iArr = R$styleable.CoordinatorLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, C0130R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            coordinatorLayout = this;
            context2 = context;
            coordinatorLayout.saveAttributeDataForStyleable(context2, iArr, attributeSet, obtainStyledAttributes, C0130R.attr.coordinatorLayoutStyle, 0);
        } else {
            coordinatorLayout = this;
            context2 = context;
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            coordinatorLayout.mKeylines = intArray;
            float f = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i = 0; i < length; i++) {
                int[] iArr2 = coordinatorLayout.mKeylines;
                iArr2[i] = (int) (iArr2[i] * f);
            }
        }
        coordinatorLayout.mStatusBarBackground = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect acquireTempRect() {
        Rect rect = (Rect) sRectPool.acquire();
        if (rect == null) {
            return new Rect();
        }
        return rect;
    }

    public static void getDesiredAnchoredChildRectWithoutConstraints(int i, Rect rect, Rect rect2, LayoutParams layoutParams, int i2, int i3) {
        int i4;
        int i5;
        int i6 = layoutParams.gravity;
        if (i6 == 0) {
            i6 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i6, i);
        int i7 = layoutParams.anchorGravity;
        if ((i7 & 7) == 0) {
            i7 |= 8388611;
        }
        if ((i7 & 112) == 0) {
            i7 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i7, i);
        int i8 = absoluteGravity & 7;
        int i9 = absoluteGravity & 112;
        int i10 = absoluteGravity2 & 7;
        int i11 = absoluteGravity2 & 112;
        if (i10 == 1) {
            i4 = rect.left + (rect.width() / 2);
        } else if (i10 != 5) {
            i4 = rect.left;
        } else {
            i4 = rect.right;
        }
        if (i11 == 16) {
            i5 = rect.top + (rect.height() / 2);
        } else if (i11 != 80) {
            i5 = rect.top;
        } else {
            i5 = rect.bottom;
        }
        if (i8 == 1) {
            i4 -= i2 / 2;
        } else if (i8 != 5) {
            i4 -= i2;
        }
        if (i9 == 16) {
            i5 -= i3 / 2;
        } else if (i9 != 80) {
            i5 -= i3;
        }
        rect2.set(i4, i5, i2 + i4, i3 + i5);
    }

    public static LayoutParams getResolvedLayoutParams(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.mBehaviorResolved) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                Behavior behavior2 = layoutParams.mBehavior;
                if (behavior2 != behavior) {
                    if (behavior2 != null) {
                        behavior2.onDetachedFromLayoutParams();
                    }
                    layoutParams.mBehavior = behavior;
                    layoutParams.mBehaviorResolved = true;
                    if (behavior != null) {
                        behavior.onAttachedToLayoutParams(layoutParams);
                    }
                }
                layoutParams.mBehaviorResolved = true;
                return layoutParams;
            }
            DefaultBehavior defaultBehavior = null;
            for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                if (defaultBehavior != null) {
                    break;
                }
            }
            if (defaultBehavior != null) {
                try {
                    Behavior behavior3 = (Behavior) defaultBehavior.value().getDeclaredConstructor(null).newInstance(null);
                    Behavior behavior4 = layoutParams.mBehavior;
                    if (behavior4 != behavior3) {
                        if (behavior4 != null) {
                            behavior4.onDetachedFromLayoutParams();
                        }
                        layoutParams.mBehavior = behavior3;
                        layoutParams.mBehaviorResolved = true;
                        if (behavior3 != null) {
                            behavior3.onAttachedToLayoutParams(layoutParams);
                        }
                    }
                } catch (Exception e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            layoutParams.mBehaviorResolved = true;
        }
        return layoutParams;
    }

    public static void setInsetOffsetX(int i, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i2 = layoutParams.mInsetOffsetX;
        if (i2 != i) {
            ViewCompat.offsetLeftAndRight(i - i2, view);
            layoutParams.mInsetOffsetX = i;
        }
    }

    public static void setInsetOffsetY(int i, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i2 = layoutParams.mInsetOffsetY;
        if (i2 != i) {
            ViewCompat.offsetTopAndBottom(i - i2, view);
            layoutParams.mInsetOffsetY = i;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public final void constrainChildRect(LayoutParams layoutParams, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    public final void dispatchDependentViewsChanged(View view) {
        List list = (List) ((SimpleArrayMap) this.mChildDag.mEmojiCharArray).get(view);
        if (!(list == null || list.isEmpty())) {
            for (int i = 0; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                Behavior behavior = ((LayoutParams) view2.getLayoutParams()).mBehavior;
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).mBehavior;
        if (behavior != null) {
            behavior.getClass();
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        boolean z;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        if (drawable == null || !drawable.isStateful()) {
            z = false;
        } else {
            z = drawable.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final void getChildRect(View view, Rect rect, boolean z) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList getDependencies(View view) {
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.mChildDag.mEmojiCharArray;
        int i = simpleArrayMap.size;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList2 = (ArrayList) simpleArrayMap.valueAt(i2);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(simpleArrayMap.keyAt(i2));
            }
        }
        ArrayList arrayList3 = this.mTempDependenciesList;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final List<View> getDependencySortedChildren() {
        prepareChildren();
        return DesugarCollections.unmodifiableList(this.mDependencySortedChildren);
    }

    public final void getDescendantRect(View view, Rect rect) {
        ThreadLocal threadLocal = ViewGroupUtils.sMatrix;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = ViewGroupUtils.sMatrix;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        ViewGroupUtils.offsetDescendantMatrix(this, view, matrix);
        ThreadLocal threadLocal3 = ViewGroupUtils.sRectF;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int getKeyline(int i) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < iArr.length) {
            return iArr[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        NavOptions.Builder builder = this.mNestedScrollingParentHelper;
        return builder.exitAnim | builder.enterAnim;
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final boolean isPointInChildBounds(View view, int i, int i2) {
        Pools$SynchronizedPool pools$SynchronizedPool = sRectPool;
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            return acquireTempRect.contains(i, i2);
        } finally {
            acquireTempRect.setEmpty();
            pools$SynchronizedPool.release(acquireTempRect);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (getFitsSystemWindows()) {
                ViewCompat.Api20Impl.requestApplyInsets(this);
            }
        }
        this.mIsAttachedToWindow = true;
    }

    public final void onChildViewsChanged(int i) {
        int i2;
        Rect rect;
        int i3;
        ArrayList arrayList;
        boolean z;
        boolean z2;
        boolean z3;
        int width;
        int i4;
        int i5;
        int i6;
        int height;
        int i7;
        int i8;
        int i9;
        Rect rect2;
        int i10;
        int i11;
        int i12;
        ArrayList arrayList2;
        View view;
        LayoutParams layoutParams;
        boolean z4;
        Behavior behavior;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList3 = this.mDependencySortedChildren;
        int size = arrayList3.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        int i13 = 0;
        while (true) {
            Pools$SynchronizedPool pools$SynchronizedPool = sRectPool;
            if (i13 < size) {
                View view2 = (View) arrayList3.get(i13);
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                if (i != 0 || view2.getVisibility() != 8) {
                    int i14 = 0;
                    while (i14 < i13) {
                        if (layoutParams2.mAnchorDirectChild == ((View) arrayList3.get(i14))) {
                            LayoutParams layoutParams3 = (LayoutParams) view2.getLayoutParams();
                            if (layoutParams3.mAnchorView != null) {
                                Rect acquireTempRect4 = acquireTempRect();
                                Rect acquireTempRect5 = acquireTempRect();
                                LayoutParams layoutParams4 = layoutParams2;
                                Rect acquireTempRect6 = acquireTempRect();
                                getDescendantRect(layoutParams3.mAnchorView, acquireTempRect4);
                                getChildRect(view2, acquireTempRect5, false);
                                int measuredWidth = view2.getMeasuredWidth();
                                View view3 = view2;
                                int measuredHeight = view3.getMeasuredHeight();
                                arrayList2 = arrayList3;
                                layoutParams = layoutParams4;
                                i12 = i14;
                                layoutDirection = layoutDirection;
                                i10 = i13;
                                view = view3;
                                getDesiredAnchoredChildRectWithoutConstraints(layoutDirection, acquireTempRect4, acquireTempRect6, layoutParams3, measuredWidth, measuredHeight);
                                i11 = size;
                                rect2 = acquireTempRect3;
                                if (acquireTempRect6.left == acquireTempRect5.left && acquireTempRect6.top == acquireTempRect5.top) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                constrainChildRect(layoutParams3, acquireTempRect6, measuredWidth, measuredHeight);
                                int i15 = acquireTempRect6.left - acquireTempRect5.left;
                                int i16 = acquireTempRect6.top - acquireTempRect5.top;
                                if (i15 != 0) {
                                    ViewCompat.offsetLeftAndRight(i15, view);
                                }
                                if (i16 != 0) {
                                    ViewCompat.offsetTopAndBottom(i16, view);
                                }
                                if (z4 && (behavior = layoutParams3.mBehavior) != null) {
                                    behavior.onDependentViewChanged(this, view, layoutParams3.mAnchorView);
                                }
                                acquireTempRect4.setEmpty();
                                pools$SynchronizedPool.release(acquireTempRect4);
                                acquireTempRect5.setEmpty();
                                pools$SynchronizedPool.release(acquireTempRect5);
                                acquireTempRect6.setEmpty();
                                pools$SynchronizedPool.release(acquireTempRect6);
                                i14 = i12 + 1;
                                layoutParams2 = layoutParams;
                                view2 = view;
                                arrayList3 = arrayList2;
                                size = i11;
                                i13 = i10;
                                acquireTempRect3 = rect2;
                            }
                        }
                        arrayList2 = arrayList3;
                        layoutParams = layoutParams2;
                        i12 = i14;
                        i11 = size;
                        rect2 = acquireTempRect3;
                        i10 = i13;
                        view = view2;
                        i14 = i12 + 1;
                        layoutParams2 = layoutParams;
                        view2 = view;
                        arrayList3 = arrayList2;
                        size = i11;
                        i13 = i10;
                        acquireTempRect3 = rect2;
                    }
                    ArrayList arrayList4 = arrayList3;
                    LayoutParams layoutParams5 = layoutParams2;
                    int i17 = size;
                    Rect rect3 = acquireTempRect3;
                    i2 = i13;
                    View view4 = view2;
                    getChildRect(view4, acquireTempRect2, true);
                    if (layoutParams5.insetEdge != 0 && !acquireTempRect2.isEmpty()) {
                        int absoluteGravity = Gravity.getAbsoluteGravity(layoutParams5.insetEdge, layoutDirection);
                        int i18 = absoluteGravity & 112;
                        if (i18 == 48) {
                            acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                        } else if (i18 == 80) {
                            acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                        }
                        int i19 = absoluteGravity & 7;
                        if (i19 == 3) {
                            acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                        } else if (i19 == 5) {
                            acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                        }
                    }
                    if (layoutParams5.dodgeInsetEdges != 0 && view4.getVisibility() == 0) {
                        WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                        if (view4.isLaidOut() && view4.getWidth() > 0 && view4.getHeight() > 0) {
                            LayoutParams layoutParams6 = (LayoutParams) view4.getLayoutParams();
                            Behavior behavior2 = layoutParams6.mBehavior;
                            Rect acquireTempRect7 = acquireTempRect();
                            Rect acquireTempRect8 = acquireTempRect();
                            acquireTempRect8.set(view4.getLeft(), view4.getTop(), view4.getRight(), view4.getBottom());
                            if (behavior2 == null || !behavior2.getInsetDodgeRect(view4, acquireTempRect7)) {
                                acquireTempRect7.set(acquireTempRect8);
                            } else if (!acquireTempRect8.contains(acquireTempRect7)) {
                                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + acquireTempRect7.toShortString() + " | Bounds:" + acquireTempRect8.toShortString());
                            }
                            acquireTempRect8.setEmpty();
                            pools$SynchronizedPool.release(acquireTempRect8);
                            if (acquireTempRect7.isEmpty()) {
                                acquireTempRect7.setEmpty();
                                pools$SynchronizedPool.release(acquireTempRect7);
                            } else {
                                int absoluteGravity2 = Gravity.getAbsoluteGravity(layoutParams6.dodgeInsetEdges, layoutDirection);
                                if ((absoluteGravity2 & 48) != 48 || (i8 = (acquireTempRect7.top - ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin) - layoutParams6.mInsetOffsetY) >= (i9 = acquireTempRect.top)) {
                                    z2 = false;
                                } else {
                                    setInsetOffsetY(i9 - i8, view4);
                                    z2 = true;
                                }
                                if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - acquireTempRect7.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin) + layoutParams6.mInsetOffsetY) < (i7 = acquireTempRect.bottom)) {
                                    setInsetOffsetY(height - i7, view4);
                                    z2 = true;
                                }
                                if (!z2) {
                                    setInsetOffsetY(0, view4);
                                }
                                if ((absoluteGravity2 & 3) != 3 || (i5 = (acquireTempRect7.left - ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin) - layoutParams6.mInsetOffsetX) >= (i6 = acquireTempRect.left)) {
                                    z3 = false;
                                } else {
                                    setInsetOffsetX(i6 - i5, view4);
                                    z3 = true;
                                }
                                if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - acquireTempRect7.right) - ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin) + layoutParams6.mInsetOffsetX) < (i4 = acquireTempRect.right)) {
                                    setInsetOffsetX(width - i4, view4);
                                    z3 = true;
                                }
                                if (!z3) {
                                    setInsetOffsetX(0, view4);
                                }
                                acquireTempRect7.setEmpty();
                                pools$SynchronizedPool.release(acquireTempRect7);
                            }
                        }
                    }
                    if (i != 2) {
                        rect = rect3;
                        rect.set(((LayoutParams) view4.getLayoutParams()).mLastChildRect);
                        if (rect.equals(acquireTempRect2)) {
                            arrayList = arrayList4;
                            i3 = i17;
                        } else {
                            ((LayoutParams) view4.getLayoutParams()).mLastChildRect.set(acquireTempRect2);
                        }
                    } else {
                        rect = rect3;
                    }
                    int i20 = i2 + 1;
                    i3 = i17;
                    while (true) {
                        arrayList = arrayList4;
                        if (i20 >= i3) {
                            break;
                        }
                        View view5 = (View) arrayList.get(i20);
                        LayoutParams layoutParams7 = (LayoutParams) view5.getLayoutParams();
                        Behavior behavior3 = layoutParams7.mBehavior;
                        if (behavior3 != null && behavior3.layoutDependsOn(view5, view4)) {
                            if (i != 0 || !layoutParams7.mDidChangeAfterNestedScroll) {
                                if (i != 2) {
                                    z = behavior3.onDependentViewChanged(this, view5, view4);
                                } else {
                                    behavior3.onDependentViewRemoved(this, view4);
                                    z = true;
                                }
                                if (i == 1) {
                                    layoutParams7.mDidChangeAfterNestedScroll = z;
                                }
                            } else {
                                layoutParams7.mDidChangeAfterNestedScroll = false;
                            }
                        }
                        i20++;
                        arrayList4 = arrayList;
                    }
                } else {
                    arrayList = arrayList3;
                    i3 = size;
                    rect = acquireTempRect3;
                    i2 = i13;
                }
                i13 = i2 + 1;
                acquireTempRect3 = rect;
                size = i3;
                arrayList3 = arrayList;
            } else {
                Rect rect4 = acquireTempRect3;
                acquireTempRect.setEmpty();
                pools$SynchronizedPool.release(acquireTempRect);
                acquireTempRect2.setEmpty();
                pools$SynchronizedPool.release(acquireTempRect2);
                rect4.setEmpty();
                pools$SynchronizedPool.release(rect4);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(0, view);
        }
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
            if (windowInsetsCompat != null) {
                i = windowInsetsCompat.getSystemWindowInsetTop();
            } else {
                i = 0;
            }
            if (i > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), i);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean performIntercept = performIntercept(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return performIntercept;
        }
        resetTouchBehaviors(true);
        return performIntercept;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior behavior;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.mDependencySortedChildren;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) arrayList.get(i5);
            if (view.getVisibility() != 8 && ((behavior = ((LayoutParams) view.getLayoutParams()).mBehavior) == null || !behavior.onLayoutChild(this, view, layoutDirection))) {
                onLayoutChild(layoutDirection, view);
            }
        }
    }

    public final void onLayoutChild(int i, View view) {
        Rect acquireTempRect;
        Rect acquireTempRect2;
        int i2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        View view2 = layoutParams.mAnchorView;
        if (view2 != null || layoutParams.mAnchorId == -1) {
            Pools$SynchronizedPool pools$SynchronizedPool = sRectPool;
            if (view2 != null) {
                acquireTempRect = acquireTempRect();
                acquireTempRect2 = acquireTempRect();
                try {
                    getDescendantRect(view2, acquireTempRect);
                    LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                    int measuredWidth = view.getMeasuredWidth();
                    int measuredHeight = view.getMeasuredHeight();
                    getDesiredAnchoredChildRectWithoutConstraints(i, acquireTempRect, acquireTempRect2, layoutParams2, measuredWidth, measuredHeight);
                    constrainChildRect(layoutParams2, acquireTempRect2, measuredWidth, measuredHeight);
                    view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
                } finally {
                    acquireTempRect.setEmpty();
                    pools$SynchronizedPool.release(acquireTempRect);
                    acquireTempRect2.setEmpty();
                    pools$SynchronizedPool.release(acquireTempRect2);
                }
            } else {
                int i3 = layoutParams.keyline;
                if (i3 >= 0) {
                    LayoutParams layoutParams3 = (LayoutParams) view.getLayoutParams();
                    int i4 = layoutParams3.gravity;
                    if (i4 == 0) {
                        i4 = 8388661;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
                    int i5 = absoluteGravity & 7;
                    int i6 = absoluteGravity & 112;
                    int width = getWidth();
                    int height = getHeight();
                    int measuredWidth2 = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    if (i == 1) {
                        i3 = width - i3;
                    }
                    int keyline = getKeyline(i3) - measuredWidth2;
                    if (i5 == 1) {
                        keyline += measuredWidth2 / 2;
                    } else if (i5 == 5) {
                        keyline += measuredWidth2;
                    }
                    if (i6 == 16) {
                        i2 = measuredHeight2 / 2;
                    } else if (i6 != 80) {
                        i2 = 0;
                    } else {
                        i2 = measuredHeight2;
                    }
                    int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin));
                    int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin, Math.min(i2, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin));
                    view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
                    return;
                }
                LayoutParams layoutParams4 = (LayoutParams) view.getLayoutParams();
                acquireTempRect = acquireTempRect();
                acquireTempRect.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin);
                if (this.mLastInsets != null) {
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                        acquireTempRect.left = this.mLastInsets.getSystemWindowInsetLeft() + acquireTempRect.left;
                        acquireTempRect.top = this.mLastInsets.getSystemWindowInsetTop() + acquireTempRect.top;
                        acquireTempRect.right -= this.mLastInsets.getSystemWindowInsetRight();
                        acquireTempRect.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
                    }
                }
                acquireTempRect2 = acquireTempRect();
                int i7 = layoutParams4.gravity;
                if ((i7 & 7) == 0) {
                    i7 |= 8388611;
                }
                if ((i7 & 112) == 0) {
                    i7 |= 48;
                }
                Gravity.apply(i7, view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i);
                view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
            }
        } else {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x018b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasure(int i, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        ArrayList arrayList;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        Behavior behavior;
        int i12;
        int i13;
        View view;
        int i14;
        int i15;
        int i16;
        CoordinatorLayout coordinatorLayout = this;
        coordinatorLayout.prepareChildren();
        int childCount = coordinatorLayout.getChildCount();
        int i17 = 0;
        loop0: while (true) {
            if (i17 >= childCount) {
                z = false;
                break;
            }
            View childAt = coordinatorLayout.getChildAt(i17);
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) coordinatorLayout.mChildDag.mEmojiCharArray;
            int i18 = simpleArrayMap.size;
            for (int i19 = 0; i19 < i18; i19++) {
                ArrayList arrayList2 = (ArrayList) simpleArrayMap.valueAt(i19);
                if (arrayList2 != null && arrayList2.contains(childAt)) {
                    z = true;
                    break loop0;
                }
            }
            i17++;
        }
        if (z != coordinatorLayout.mNeedsPreDrawListener) {
            if (z) {
                if (coordinatorLayout.mIsAttachedToWindow) {
                    if (coordinatorLayout.mOnPreDrawListener == null) {
                        coordinatorLayout.mOnPreDrawListener = new OnPreDrawListener();
                    }
                    coordinatorLayout.getViewTreeObserver().addOnPreDrawListener(coordinatorLayout.mOnPreDrawListener);
                }
                coordinatorLayout.mNeedsPreDrawListener = true;
            } else {
                if (coordinatorLayout.mIsAttachedToWindow && coordinatorLayout.mOnPreDrawListener != null) {
                    coordinatorLayout.getViewTreeObserver().removeOnPreDrawListener(coordinatorLayout.mOnPreDrawListener);
                }
                coordinatorLayout.mNeedsPreDrawListener = false;
            }
        }
        int paddingLeft = coordinatorLayout.getPaddingLeft();
        int paddingTop = coordinatorLayout.getPaddingTop();
        int paddingRight = coordinatorLayout.getPaddingRight();
        int paddingBottom = coordinatorLayout.getPaddingBottom();
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int layoutDirection = coordinatorLayout.getLayoutDirection();
        if (layoutDirection == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i20 = paddingLeft + paddingRight;
        int i21 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = coordinatorLayout.getSuggestedMinimumWidth();
        int suggestedMinimumHeight = coordinatorLayout.getSuggestedMinimumHeight();
        if (coordinatorLayout.mLastInsets == null || !coordinatorLayout.getFitsSystemWindows()) {
            z3 = false;
        } else {
            z3 = true;
        }
        ArrayList arrayList3 = coordinatorLayout.mDependencySortedChildren;
        int size3 = arrayList3.size();
        int i22 = 0;
        int i23 = 0;
        while (i22 < size3) {
            View view2 = (View) arrayList3.get(i22);
            int i24 = suggestedMinimumWidth;
            if (view2.getVisibility() == 8) {
                arrayList = arrayList3;
                i3 = size3;
                i6 = i22;
                i5 = paddingLeft;
                suggestedMinimumWidth = i24;
                i4 = paddingRight;
            } else {
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                int i25 = layoutParams.keyline;
                if (i25 < 0 || mode == 0) {
                    i7 = suggestedMinimumHeight;
                } else {
                    int keyline = coordinatorLayout.getKeyline(i25);
                    int i26 = layoutParams.gravity;
                    if (i26 == 0) {
                        i26 = 8388661;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i26, layoutDirection) & 7;
                    i7 = suggestedMinimumHeight;
                    if ((absoluteGravity == 3 && !z2) || (absoluteGravity == 5 && z2)) {
                        i16 = Math.max(0, (size - paddingRight) - keyline);
                    } else if ((absoluteGravity == 5 && !z2) || (absoluteGravity == 3 && z2)) {
                        i16 = Math.max(0, keyline - paddingLeft);
                    }
                    int i27 = size3;
                    i8 = i16;
                    i9 = i27;
                    if (z3 || view2.getFitsSystemWindows()) {
                        i3 = i9;
                        i10 = i;
                        i11 = i2;
                    } else {
                        i3 = i9;
                        int systemWindowInsetRight = coordinatorLayout.mLastInsets.getSystemWindowInsetRight() + coordinatorLayout.mLastInsets.getSystemWindowInsetLeft();
                        int systemWindowInsetBottom = coordinatorLayout.mLastInsets.getSystemWindowInsetBottom() + coordinatorLayout.mLastInsets.getSystemWindowInsetTop();
                        i10 = View.MeasureSpec.makeMeasureSpec(size - systemWindowInsetRight, mode);
                        i11 = View.MeasureSpec.makeMeasureSpec(size2 - systemWindowInsetBottom, mode2);
                    }
                    behavior = layoutParams.mBehavior;
                    if (behavior == null) {
                        i5 = paddingLeft;
                        i13 = i24;
                        i4 = paddingRight;
                        i12 = i7;
                        arrayList = arrayList3;
                        int i28 = i10;
                        i6 = i22;
                        int i29 = i11;
                        boolean onMeasureChild = behavior.onMeasureChild(this, view2, i28, i8, i29);
                        view = view2;
                        i10 = i28;
                        i15 = i8;
                        i14 = i29;
                        if (onMeasureChild) {
                            coordinatorLayout = this;
                            int max = Math.max(i13, view.getMeasuredWidth() + i20 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                            int max2 = Math.max(i12, view.getMeasuredHeight() + i21 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                            i23 = View.combineMeasuredStates(i23, view.getMeasuredState());
                            suggestedMinimumWidth = max;
                            suggestedMinimumHeight = max2;
                        }
                    } else {
                        i5 = paddingLeft;
                        i13 = i24;
                        i4 = paddingRight;
                        i12 = i7;
                        arrayList = arrayList3;
                        i15 = i8;
                        i14 = i11;
                        view = view2;
                        i6 = i22;
                    }
                    coordinatorLayout = this;
                    coordinatorLayout.measureChildWithMargins(view, i10, i15, i14, 0);
                    int max3 = Math.max(i13, view.getMeasuredWidth() + i20 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    int max22 = Math.max(i12, view.getMeasuredHeight() + i21 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                    i23 = View.combineMeasuredStates(i23, view.getMeasuredState());
                    suggestedMinimumWidth = max3;
                    suggestedMinimumHeight = max22;
                }
                i9 = size3;
                i8 = 0;
                if (z3) {
                }
                i3 = i9;
                i10 = i;
                i11 = i2;
                behavior = layoutParams.mBehavior;
                if (behavior == null) {
                }
                coordinatorLayout = this;
                coordinatorLayout.measureChildWithMargins(view, i10, i15, i14, 0);
                int max32 = Math.max(i13, view.getMeasuredWidth() + i20 + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                int max222 = Math.max(i12, view.getMeasuredHeight() + i21 + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                i23 = View.combineMeasuredStates(i23, view.getMeasuredState());
                suggestedMinimumWidth = max32;
                suggestedMinimumHeight = max222;
            }
            i22 = i6 + 1;
            paddingLeft = i5;
            paddingRight = i4;
            size3 = i3;
            arrayList3 = arrayList;
        }
        int i30 = i23;
        coordinatorLayout.setMeasuredDimension(View.resolveSizeAndState(suggestedMinimumWidth, i, (-16777216) & i30), View.resolveSizeAndState(suggestedMinimumHeight, i2, i30 << 16));
    }

    public final void onMeasureChild(View view, int i, int i2, int i3) {
        measureChildWithMargins(view, i, i2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0)) {
                    Behavior behavior = layoutParams.mBehavior;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        Behavior behavior;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0) && (behavior = layoutParams.mBehavior) != null) {
                    z |= behavior.onNestedPreFling(view);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        NavOptions.Builder builder = this.mNestedScrollingParentHelper;
        if (i2 == 1) {
            builder.exitAnim = i;
        } else {
            builder.enterAnim = i;
        }
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((LayoutParams) getChildAt(i3).getLayoutParams()).getClass();
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        SparseArray sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = getResolvedLayoutParams(childAt).mBehavior;
            if (!(id == -1 || behavior == null || (parcelable2 = (Parcelable) sparseArray.get(id)) == null)) {
                behavior.onRestoreInstanceState(childAt, parcelable2);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).mBehavior;
            if (!(id == -1 || behavior == null || (onSaveInstanceState = behavior.onSaveInstanceState(childAt)) == null)) {
                sparseArray.append(id, onSaveInstanceState);
            }
        }
        absSavedState.behaviorStates = sparseArray;
        return absSavedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(int i, View view) {
        NavOptions.Builder builder = this.mNestedScrollingParentHelper;
        if (i == 1) {
            builder.exitAnim = 0;
        } else {
            builder.enterAnim = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i)) {
                Behavior behavior = layoutParams.mBehavior;
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, i);
                }
                if (i == 0) {
                    layoutParams.mDidAcceptNestedScrollTouch = false;
                } else if (i == 1) {
                    layoutParams.mDidAcceptNestedScrollNonTouch = false;
                }
                layoutParams.mDidChangeAfterNestedScroll = false;
            }
        }
        this.mNestedScrollingTarget = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3 != false) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (this.mBehaviorTouchView == null) {
            z2 = performIntercept(motionEvent, 1);
        } else {
            z2 = false;
        }
        Behavior behavior = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).mBehavior;
        if (behavior != null) {
            z = behavior.onTouchEvent(this, this.mBehaviorTouchView, motionEvent);
            motionEvent2 = null;
            if (this.mBehaviorTouchView != null) {
                z |= super.onTouchEvent(motionEvent);
            } else if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked == 1 && actionMasked != 3) {
                return z;
            }
            resetTouchBehaviors(false);
            return z;
        }
        z = false;
        motionEvent2 = null;
        if (this.mBehaviorTouchView != null) {
        }
        if (motionEvent2 != null) {
        }
        if (actionMasked == 1) {
        }
        resetTouchBehaviors(false);
        return z;
    }

    public final boolean performIntercept(MotionEvent motionEvent, int i) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.mTempList1;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            if (isChildrenDrawingOrderEnabled) {
                i2 = getChildDrawingOrder(childCount, i3);
            } else {
                i2 = i3;
            }
            arrayList.add(getChildAt(i2));
        }
        ViewPager.C01171 r5 = TOP_SORTED_CHILDREN_COMPARATOR;
        if (r5 != null) {
            Collections.sort(arrayList, r5);
        }
        int size = arrayList.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        for (int i4 = 0; i4 < size; i4++) {
            View view = (View) arrayList.get(i4);
            Behavior behavior = ((LayoutParams) view.getLayoutParams()).mBehavior;
            if (z && actionMasked != 0) {
                if (behavior != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i == 0) {
                        behavior.onInterceptTouchEvent(this, view, motionEvent2);
                    } else if (i == 1) {
                        behavior.onTouchEvent(this, view, motionEvent2);
                    }
                }
            } else if (!z && behavior != null) {
                if (i == 0) {
                    z = behavior.onInterceptTouchEvent(this, view, motionEvent);
                } else if (i == 1) {
                    z = behavior.onTouchEvent(this, view, motionEvent);
                }
                if (z) {
                    this.mBehaviorTouchView = view;
                }
            }
        }
        arrayList.clear();
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00f9, code lost:
        if ((android.view.Gravity.getAbsoluteGravity(r8.dodgeInsetEdges, r12) & r13) == r13) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void prepareChildren() {
        ArrayList arrayList = this.mDependencySortedChildren;
        arrayList.clear();
        MetadataRepo metadataRepo = this.mChildDag;
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) metadataRepo.mEmojiCharArray;
        Pools$SimplePool pools$SimplePool = (Pools$SimplePool) metadataRepo.mMetadataList;
        SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) metadataRepo.mEmojiCharArray;
        int i = simpleArrayMap.size;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList2 = (ArrayList) simpleArrayMap.valueAt(i2);
            if (arrayList2 != null) {
                arrayList2.clear();
                pools$SimplePool.release(arrayList2);
            }
        }
        simpleArrayMap.clear();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams resolvedLayoutParams = getResolvedLayoutParams(childAt);
            int i4 = resolvedLayoutParams.mAnchorId;
            if (i4 == -1) {
                resolvedLayoutParams.mAnchorDirectChild = null;
                resolvedLayoutParams.mAnchorView = null;
            } else {
                View view = resolvedLayoutParams.mAnchorView;
                if (view != null && view.getId() == i4) {
                    View view2 = resolvedLayoutParams.mAnchorView;
                    for (ViewParent parent = view2.getParent(); parent != this; parent = parent.getParent()) {
                        if (parent == null || parent == childAt) {
                            resolvedLayoutParams.mAnchorDirectChild = null;
                            resolvedLayoutParams.mAnchorView = null;
                        } else {
                            if (parent instanceof View) {
                                view2 = (View) parent;
                            }
                        }
                    }
                    resolvedLayoutParams.mAnchorDirectChild = view2;
                }
                View findViewById = findViewById(i4);
                resolvedLayoutParams.mAnchorView = findViewById;
                if (findViewById != null) {
                    if (findViewById != this) {
                        for (ViewParent parent2 = findViewById.getParent(); parent2 != this && parent2 != null; parent2 = parent2.getParent()) {
                            if (parent2 != childAt) {
                                if (parent2 instanceof View) {
                                    findViewById = (View) parent2;
                                }
                            } else if (isInEditMode()) {
                                resolvedLayoutParams.mAnchorDirectChild = null;
                                resolvedLayoutParams.mAnchorView = null;
                            } else {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                        }
                        resolvedLayoutParams.mAnchorDirectChild = findViewById;
                    } else if (isInEditMode()) {
                        resolvedLayoutParams.mAnchorDirectChild = null;
                        resolvedLayoutParams.mAnchorView = null;
                    } else {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                } else if (isInEditMode()) {
                    resolvedLayoutParams.mAnchorDirectChild = null;
                    resolvedLayoutParams.mAnchorView = null;
                } else {
                    throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(i4) + " to anchor view " + childAt);
                }
            }
            if (!simpleArrayMap2.containsKey(childAt)) {
                simpleArrayMap2.put(childAt, null);
            }
            for (int i5 = 0; i5 < childCount; i5++) {
                if (i5 != i3) {
                    View childAt2 = getChildAt(i5);
                    if (childAt2 != resolvedLayoutParams.mAnchorDirectChild) {
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        int layoutDirection = getLayoutDirection();
                        int absoluteGravity = Gravity.getAbsoluteGravity(((LayoutParams) childAt2.getLayoutParams()).insetEdge, layoutDirection);
                        if (absoluteGravity != 0) {
                        }
                        Behavior behavior = resolvedLayoutParams.mBehavior;
                        if (behavior == null) {
                            continue;
                        } else if (!behavior.layoutDependsOn(childAt, childAt2)) {
                            continue;
                        }
                    }
                    if (!simpleArrayMap2.containsKey(childAt2) && !simpleArrayMap2.containsKey(childAt2)) {
                        simpleArrayMap2.put(childAt2, null);
                    }
                    if (!simpleArrayMap2.containsKey(childAt2) || !simpleArrayMap2.containsKey(childAt)) {
                        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
                    }
                    ArrayList arrayList3 = (ArrayList) simpleArrayMap2.get(childAt2);
                    if (arrayList3 == null) {
                        arrayList3 = (ArrayList) pools$SimplePool.acquire();
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        simpleArrayMap2.put(childAt2, arrayList3);
                    }
                    arrayList3.add(childAt);
                }
            }
        }
        ArrayList arrayList4 = (ArrayList) metadataRepo.mRootNode;
        arrayList4.clear();
        HashSet hashSet = (HashSet) metadataRepo.mTypeface;
        hashSet.clear();
        int i6 = simpleArrayMap2.size;
        for (int i7 = 0; i7 < i6; i7++) {
            metadataRepo.dfs(simpleArrayMap2.keyAt(i7), arrayList4, hashSet);
        }
        arrayList.addAll(arrayList4);
        Collections.reverse(arrayList);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).mBehavior;
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.mDisallowInterceptReset) {
            resetTouchBehaviors(false);
            this.mDisallowInterceptReset = true;
        }
    }

    public final void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).mBehavior;
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    behavior.onInterceptTouchEvent(this, childAt, obtain);
                } else {
                    behavior.onTouchEvent(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((LayoutParams) getChildAt(i2).getLayoutParams()).getClass();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        boolean z;
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                Drawable drawable4 = this.mStatusBarBackground;
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                BundleKt.setLayoutDirection(drawable4, getLayoutDirection());
                Drawable drawable5 = this.mStatusBarBackground;
                if (getVisibility() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                drawable5.setVisible(z, false);
                this.mStatusBarBackground.setCallback(this);
            }
            WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = ContextCompat$Api21Impl.getDrawable(getContext(), i);
        } else {
            drawable = null;
        }
        setStatusBarBackground(drawable);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        Drawable drawable = this.mStatusBarBackground;
        if (drawable != null && drawable.isVisible() != z) {
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    public final void setupForInsets() {
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (getFitsSystemWindows()) {
            if (this.mApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = new FakeDrag(8, this);
            }
            ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
            setSystemUiVisibility(1280);
            return;
        }
        ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(this, null);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        Behavior behavior;
        int min;
        int min2;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i3) && (behavior = layoutParams.mBehavior) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedPreScroll(this, childAt, view, i, i2, iArr2, i3);
                    if (i > 0) {
                        min = Math.max(i4, iArr2[0]);
                    } else {
                        min = Math.min(i4, iArr2[0]);
                    }
                    i4 = min;
                    if (i2 > 0) {
                        min2 = Math.max(i5, iArr2[1]);
                    } else {
                        min2 = Math.min(i5, iArr2[1]);
                    }
                    i5 = min2;
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int i3;
        int i4;
        View view3;
        int childCount = getChildCount();
        int i5 = 0;
        boolean z = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                view3 = view;
                i4 = i;
                i3 = i2;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.mBehavior;
                if (behavior != null) {
                    view3 = view;
                    i4 = i;
                    i3 = i2;
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(this, childAt, view3, i4, i3);
                    z |= onStartNestedScroll;
                    if (i3 == 0) {
                        layoutParams.mDidAcceptNestedScrollTouch = onStartNestedScroll;
                    } else if (i3 == 1) {
                        layoutParams.mDidAcceptNestedScrollNonTouch = onStartNestedScroll;
                    }
                } else {
                    view3 = view;
                    i4 = i;
                    i3 = i2;
                    if (i3 == 0) {
                        layoutParams.mDidAcceptNestedScrollTouch = false;
                    } else if (i3 == 1) {
                        layoutParams.mDidAcceptNestedScrollNonTouch = false;
                    }
                }
            }
            i5++;
            view = view3;
            i = i4;
            i2 = i3;
        }
        return z;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Behavior behavior;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        boolean z = false;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i5) && (behavior = layoutParams.mBehavior) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behavior.onNestedScroll(this, childAt, i2, i3, i4, iArr2);
                    if (i3 > 0) {
                        i6 = Math.max(i6, iArr2[0]);
                    } else {
                        i6 = Math.min(i6, iArr2[0]);
                    }
                    if (i4 > 0) {
                        i7 = Math.max(i7, iArr2[1]);
                    } else {
                        i7 = Math.min(i7, iArr2[1]);
                    }
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    /* loaded from: classes.dex */
    public final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public final int anchorGravity;
        public int dodgeInsetEdges;
        public final int gravity;
        public final int insetEdge;
        public final int keyline;
        public View mAnchorDirectChild;
        public final int mAnchorId;
        public View mAnchorView;
        public Behavior mBehavior;
        public boolean mBehaviorResolved;
        public boolean mDidAcceptNestedScrollNonTouch;
        public boolean mDidAcceptNestedScrollTouch;
        public boolean mDidChangeAfterNestedScroll;
        public int mInsetOffsetX;
        public int mInsetOffsetY;
        public final Rect mLastChildRect;

        public LayoutParams() {
            super(-2, -2);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public final boolean isNestedScrollAccepted(int i) {
            if (i == 0) {
                return this.mDidAcceptNestedScrollTouch;
            }
            if (i != 1) {
                return false;
            }
            return this.mDidAcceptNestedScrollNonTouch;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Behavior behavior;
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(0, 0);
            this.mAnchorId = obtainStyledAttributes.getResourceId(1, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(2, 0);
            this.keyline = obtainStyledAttributes.getInteger(6, -1);
            this.insetEdge = obtainStyledAttributes.getInt(5, 0);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(4, 0);
            boolean hasValue = obtainStyledAttributes.hasValue(3);
            this.mBehaviorResolved = hasValue;
            if (hasValue) {
                String string = obtainStyledAttributes.getString(3);
                String str = CoordinatorLayout.WIDGET_PACKAGE_NAME;
                if (TextUtils.isEmpty(string)) {
                    behavior = null;
                } else {
                    if (string.startsWith(".")) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str2 = CoordinatorLayout.WIDGET_PACKAGE_NAME;
                        if (!TextUtils.isEmpty(str2)) {
                            string = str2 + '.' + string;
                        }
                    }
                    try {
                        ThreadLocal threadLocal = CoordinatorLayout.sConstructors;
                        Map map = (Map) threadLocal.get();
                        if (map == null) {
                            map = new HashMap();
                            threadLocal.set(map);
                        }
                        Constructor<?> constructor = (Constructor) map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.CONSTRUCTOR_PARAMS);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        behavior = (Behavior) constructor.newInstance(context, attributeSet);
                    } catch (Exception e) {
                        throw new RuntimeException("Could not inflate Behavior subclass " + string, e);
                    }
                }
                this.mBehavior = behavior;
            }
            obtainStyledAttributes.recycle();
            Behavior behavior2 = this.mBehavior;
            if (behavior2 != null) {
                behavior2.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mBehaviorResolved = false;
            this.gravity = 0;
            this.anchorGravity = 0;
            this.keyline = -1;
            this.mAnchorId = -1;
            this.insetEdge = 0;
            this.dodgeInsetEdges = 0;
            this.mLastChildRect = new Rect();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(0, view);
    }

    /* loaded from: classes.dex */
    public abstract class Behavior {
        public boolean getInsetDodgeRect(View view, Rect rect) {
            return false;
        }

        public boolean layoutDependsOn(View view, View view2) {
            return false;
        }

        public void onAttachedToLayoutParams(LayoutParams layoutParams) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return false;
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            return false;
        }

        public boolean onNestedPreFling(View view) {
            return false;
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
            iArr[0] = iArr[0] + i2;
            iArr[1] = iArr[1] + i3;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            return false;
        }

        public Parcelable onSaveInstanceState(View view) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
            return false;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, View view) {
        }

        public void onRestoreInstanceState(View view, Parcelable parcelable) {
        }
    }
}
