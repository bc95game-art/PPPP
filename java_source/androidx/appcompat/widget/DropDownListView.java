package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.widget.ListViewAutoScrollHelper;
import com.android.billingclient.api.zzab;
import com.emanuelef.remote_capture.C0130R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class DropDownListView extends ListView {
    public boolean mDrawsInPressedState;
    public final boolean mHijackFocus;
    public boolean mListSelectionHidden;
    public int mMotionPosition;
    public zzab mResolveHoverRunnable;
    public ListViewAutoScrollHelper mScrollHelper;
    public GateKeeperDrawable mSelector;
    public final Rect mSelectorRect = new Rect();
    public int mSelectionLeftPadding = 0;
    public int mSelectionTopPadding = 0;
    public int mSelectionRightPadding = 0;
    public int mSelectionBottomPadding = 0;

    /* loaded from: classes.dex */
    public abstract class Api21Impl {
        public static void drawableHotspotChanged(View view, float f, float f2) {
            view.drawableHotspotChanged(f, f2);
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api30Impl {
        public static final boolean sHasMethods;
        public static final Method sPositionSelector;
        public static final Method sSetNextSelectedPositionInt;
        public static final Method sSetSelectedPositionInt;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                sPositionSelector = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                sSetSelectedPositionInt = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                sSetNextSelectedPositionInt = declaredMethod3;
                declaredMethod3.setAccessible(true);
                sHasMethods = true;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api33Impl {
        public static boolean isSelectedChildViewEnabled(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void setSelectedChildViewEnabled(AbsListView absListView, boolean z) {
            absListView.setSelectedChildViewEnabled(z);
        }
    }

    /* loaded from: classes.dex */
    public final class GateKeeperDrawable extends Drawable implements Drawable.Callback {
        public Drawable mDrawable;
        public boolean mEnabled;

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            if (this.mEnabled) {
                draw$androidx$appcompat$graphics$drawable$DrawableWrapperCompat(canvas);
            }
        }

        public final void draw$androidx$appcompat$graphics$drawable$DrawableWrapperCompat(Canvas canvas) {
            this.mDrawable.draw(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        public final int getChangingConfigurations() {
            return this.mDrawable.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable
        public final Drawable getCurrent() {
            return this.mDrawable.getCurrent();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.mDrawable.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.mDrawable.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getMinimumHeight() {
            return this.mDrawable.getMinimumHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getMinimumWidth() {
            return this.mDrawable.getMinimumWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return this.mDrawable.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean getPadding(Rect rect) {
            return this.mDrawable.getPadding(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public final int[] getState() {
            return this.mDrawable.getState();
        }

        @Override // android.graphics.drawable.Drawable
        public final Region getTransparentRegion() {
            return this.mDrawable.getTransparentRegion();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable drawable) {
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean isAutoMirrored() {
            return this.mDrawable.isAutoMirrored();
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean isStateful() {
            return this.mDrawable.isStateful();
        }

        @Override // android.graphics.drawable.Drawable
        public final void jumpToCurrentState() {
            this.mDrawable.jumpToCurrentState();
        }

        @Override // android.graphics.drawable.Drawable
        public final void onBoundsChange(Rect rect) {
            this.mDrawable.setBounds(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean onLevelChange(int i) {
            return this.mDrawable.setLevel(i);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i) {
            this.mDrawable.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAutoMirrored(boolean z) {
            this.mDrawable.setAutoMirrored(z);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setChangingConfigurations(int i) {
            this.mDrawable.setChangingConfigurations(i);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
            this.mDrawable.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setDither(boolean z) {
            this.mDrawable.setDither(z);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setFilterBitmap(boolean z) {
            this.mDrawable.setFilterBitmap(z);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setHotspot(float f, float f2) {
            if (this.mEnabled) {
                m623x31706bc5(f, f2);
            }
        }

        /* renamed from: setHotspot$androidx$appcompat$graphics$drawable$DrawableWrapperCompat */
        public final void m623x31706bc5(float f, float f2) {
            DrawableCompat$Api21Impl.setHotspot(this.mDrawable, f, f2);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.mEnabled) {
                m622x34671590(i, i2, i3, i4);
            }
        }

        /* renamed from: setHotspotBounds$androidx$appcompat$graphics$drawable$DrawableWrapperCompat */
        public final void m622x34671590(int i, int i2, int i3, int i4) {
            DrawableCompat$Api21Impl.setHotspotBounds(this.mDrawable, i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean setState(int[] iArr) {
            if (this.mEnabled) {
                return this.mDrawable.setState(iArr);
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setTint(int i) {
            DrawableCompat$Api21Impl.setTint(this.mDrawable, i);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setTintList(ColorStateList colorStateList) {
            DrawableCompat$Api21Impl.setTintList(this.mDrawable, colorStateList);
        }

        @Override // android.graphics.drawable.Drawable
        public final void setTintMode(PorterDuff.Mode mode) {
            DrawableCompat$Api21Impl.setTintMode(this.mDrawable, mode);
        }

        @Override // android.graphics.drawable.Drawable
        public final boolean setVisible(boolean z, boolean z2) {
            if (this.mEnabled) {
                return m621x868cf842(z, z2);
            }
            return false;
        }

        /* renamed from: setVisible$androidx$appcompat$graphics$drawable$DrawableWrapperCompat */
        public final boolean m621x868cf842(boolean z, boolean z2) {
            if (super.setVisible(z, z2) || this.mDrawable.setVisible(z, z2)) {
                return true;
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            unscheduleSelf(runnable);
        }
    }

    /* loaded from: classes.dex */
    public abstract class PreApi33Impl {
        public static final Field sIsChildViewEnabled;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            sIsChildViewEnabled = field;
        }
    }

    public DropDownListView(Context context, boolean z) {
        super(context, null, C0130R.attr.dropDownListViewStyle);
        this.mHijackFocus = z;
        setCacheColorHint(0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.mSelectorRect;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.mResolveHoverRunnable == null) {
            super.drawableStateChanged();
            GateKeeperDrawable gateKeeperDrawable = this.mSelector;
            if (gateKeeperDrawable != null) {
                gateKeeperDrawable.mEnabled = true;
            }
            Drawable selector = getSelector();
            if (selector != null && this.mDrawsInPressedState && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        if (this.mHijackFocus || super.hasFocus()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        if (this.mHijackFocus || super.hasWindowFocus()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean isFocused() {
        if (this.mHijackFocus || super.isFocused()) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        if ((!this.mHijackFocus || !this.mListSelectionHidden) && !super.isInTouchMode()) {
            return false;
        }
        return true;
    }

    public final int measureHeightOfChildrenCompat(int i, int i2) {
        int i3;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i4 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i5 = 0;
        for (int i6 = 0; i6 < count; i6++) {
            int itemViewType = adapter.getItemViewType(i6);
            if (itemViewType != i5) {
                view = null;
                i5 = itemViewType;
            }
            view = adapter.getView(i6, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i7 = layoutParams.height;
            if (i7 > 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(i7, 1073741824);
            } else {
                i3 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, i3);
            view.forceLayout();
            if (i6 > 0) {
                i4 += dividerHeight;
            }
            i4 += view.getMeasuredHeight();
            if (i4 >= i2) {
                return i2;
            }
        }
        return i4;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.mResolveHoverRunnable = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0148 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x017b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onForwardedEvent(MotionEvent motionEvent, int i) {
        boolean z;
        View childAt;
        boolean z2;
        boolean z3;
        boolean z4;
        View childAt2;
        int actionMasked = motionEvent.getActionMasked();
        boolean z5 = false;
        if (actionMasked == 1) {
            z = false;
        } else if (actionMasked != 2) {
            if (actionMasked != 3) {
                z = true;
                if (z || z5) {
                    this.mDrawsInPressedState = false;
                    setPressed(false);
                    drawableStateChanged();
                    childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
                    if (childAt != null) {
                        childAt.setPressed(false);
                    }
                }
                if (!z) {
                    if (this.mScrollHelper == null) {
                        this.mScrollHelper = new ListViewAutoScrollHelper(this);
                    }
                    ListViewAutoScrollHelper listViewAutoScrollHelper = this.mScrollHelper;
                    boolean z6 = listViewAutoScrollHelper.mEnabled;
                    listViewAutoScrollHelper.mEnabled = true;
                    listViewAutoScrollHelper.onTouch(this, motionEvent);
                } else {
                    ListViewAutoScrollHelper listViewAutoScrollHelper2 = this.mScrollHelper;
                    if (listViewAutoScrollHelper2 != null) {
                        if (listViewAutoScrollHelper2.mEnabled) {
                            listViewAutoScrollHelper2.requestStop();
                        }
                        listViewAutoScrollHelper2.mEnabled = false;
                    }
                }
                return z;
            }
            z = false;
            if (z) {
            }
            this.mDrawsInPressedState = false;
            setPressed(false);
            drawableStateChanged();
            childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
            if (childAt != null) {
            }
            if (!z) {
            }
            return z;
        } else {
            z = true;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex >= 0) {
            int x = (int) motionEvent.getX(findPointerIndex);
            int y = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, y);
            if (pointToPosition == -1) {
                z5 = true;
            } else {
                View childAt3 = getChildAt(pointToPosition - getFirstVisiblePosition());
                float f = x;
                float f2 = y;
                this.mDrawsInPressedState = true;
                int i2 = Build.VERSION.SDK_INT;
                Api21Impl.drawableHotspotChanged(this, f, f2);
                if (!isPressed()) {
                    setPressed(true);
                }
                layoutChildren();
                int i3 = this.mMotionPosition;
                if (!(i3 == -1 || (childAt2 = getChildAt(i3 - getFirstVisiblePosition())) == null || childAt2 == childAt3 || !childAt2.isPressed())) {
                    childAt2.setPressed(false);
                }
                this.mMotionPosition = pointToPosition;
                Api21Impl.drawableHotspotChanged(childAt3, f - childAt3.getLeft(), f2 - childAt3.getTop());
                if (!childAt3.isPressed()) {
                    childAt3.setPressed(true);
                }
                Drawable selector = getSelector();
                if (selector == null || pointToPosition == -1) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    selector.setVisible(false, false);
                }
                int left = childAt3.getLeft();
                int top = childAt3.getTop();
                int right = childAt3.getRight();
                int bottom = childAt3.getBottom();
                Rect rect = this.mSelectorRect;
                rect.set(left, top, right, bottom);
                rect.left -= this.mSelectionLeftPadding;
                rect.top -= this.mSelectionTopPadding;
                rect.right += this.mSelectionRightPadding;
                rect.bottom += this.mSelectionBottomPadding;
                if (i2 >= 33) {
                    z3 = Api33Impl.isSelectedChildViewEnabled(this);
                } else {
                    Field field = PreApi33Impl.sIsChildViewEnabled;
                    if (field != null) {
                        try {
                            z3 = field.getBoolean(this);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    z3 = false;
                }
                if (childAt3.isEnabled() != z3) {
                    boolean z7 = !z3;
                    if (Build.VERSION.SDK_INT >= 33) {
                        Api33Impl.setSelectedChildViewEnabled(this, z7);
                    } else {
                        Field field2 = PreApi33Impl.sIsChildViewEnabled;
                        if (field2 != null) {
                            try {
                                field2.set(this, Boolean.valueOf(z7));
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (pointToPosition != -1) {
                        refreshDrawableState();
                    }
                }
                if (z2) {
                    float exactCenterX = rect.exactCenterX();
                    float exactCenterY = rect.exactCenterY();
                    if (getVisibility() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    selector.setVisible(z4, false);
                    DrawableCompat$Api21Impl.setHotspot(selector, exactCenterX, exactCenterY);
                }
                Drawable selector2 = getSelector();
                if (!(selector2 == null || pointToPosition == -1)) {
                    DrawableCompat$Api21Impl.setHotspot(selector2, f, f2);
                }
                GateKeeperDrawable gateKeeperDrawable = this.mSelector;
                if (gateKeeperDrawable != null) {
                    gateKeeperDrawable.mEnabled = false;
                }
                refreshDrawableState();
                if (actionMasked == 1) {
                    performItemClick(childAt3, pointToPosition, getItemIdAtPosition(pointToPosition));
                }
                z = true;
                z5 = false;
            }
            if (z) {
            }
            this.mDrawsInPressedState = false;
            setPressed(false);
            drawableStateChanged();
            childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
            if (childAt != null) {
            }
            if (!z) {
            }
            return z;
        }
        z = false;
        if (z) {
        }
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
        }
        if (!z) {
        }
        return z;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.mResolveHoverRunnable == null) {
            zzab zzabVar = new zzab(3, this);
            this.mResolveHoverRunnable = zzabVar;
            post(zzabVar);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i < 30 || !Api30Impl.sHasMethods) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        try {
                            Api30Impl.sPositionSelector.invoke(this, Integer.valueOf(pointToPosition), childAt, Boolean.FALSE, -1, -1);
                            Api30Impl.sSetSelectedPositionInt.invoke(this, Integer.valueOf(pointToPosition));
                            Api30Impl.sSetNextSelectedPositionInt.invoke(this, Integer.valueOf(pointToPosition));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.mDrawsInPressedState && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
            return onHoverEvent;
        }
        setSelection(-1);
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mMotionPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        zzab zzabVar = this.mResolveHoverRunnable;
        if (zzabVar != null) {
            DropDownListView dropDownListView = (DropDownListView) zzabVar.zza;
            dropDownListView.mResolveHoverRunnable = null;
            dropDownListView.removeCallbacks(zzabVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.mListSelectionHidden = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.appcompat.widget.DropDownListView$GateKeeperDrawable, android.graphics.drawable.Drawable$Callback, android.graphics.drawable.Drawable] */
    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable;
        if (drawable != 0) {
            ?? drawable2 = new Drawable();
            Drawable drawable3 = drawable2.mDrawable;
            if (drawable3 != null) {
                drawable3.setCallback(null);
            }
            drawable2.mDrawable = drawable;
            if (drawable != 0) {
                drawable.setCallback(drawable2);
            }
            drawable2.mEnabled = true;
            gateKeeperDrawable = drawable2;
        } else {
            gateKeeperDrawable = null;
        }
        this.mSelector = gateKeeperDrawable;
        super.setSelector(gateKeeperDrawable);
        Rect rect = new Rect();
        if (drawable != 0) {
            drawable.getPadding(rect);
        }
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
    }
}
