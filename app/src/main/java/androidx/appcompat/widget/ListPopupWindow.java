package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.SearchView;
import androidx.core.p002os.BundleKt;
import androidx.cursoradapter.widget.CursorAdapter;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    public static final Method sGetMaxAvailableHeightMethod;
    public static final Method sSetClipToWindowEnabledMethod;
    public static final Method sSetEpicenterBoundsMethod;
    public ListAdapter mAdapter;
    public final Context mContext;
    public View mDropDownAnchorView;
    public int mDropDownHorizontalOffset;
    public DropDownListView mDropDownList;
    public int mDropDownVerticalOffset;
    public boolean mDropDownVerticalOffsetSet;
    public Rect mEpicenterBounds;
    public final Handler mHandler;
    public AdapterView.OnItemClickListener mItemClickListener;
    public AdapterView.OnItemSelectedListener mItemSelectedListener;
    public boolean mModal;
    public CursorAdapter.MyDataSetObserver mObserver;
    public boolean mOverlapAnchor;
    public boolean mOverlapAnchorSet;
    public final AppCompatPopupWindow mPopup;
    public final int mDropDownHeight = -2;
    public int mDropDownWidth = -2;
    public final int mDropDownWindowLayoutType = 1002;
    public int mDropDownGravity = 0;
    public final int mListItemExpandMaximum = Integer.MAX_VALUE;
    public final ListSelectorHider mResizePopupRunnable = new ListSelectorHider(this, 1);
    public final PopupTouchInterceptor mTouchInterceptor = new PopupTouchInterceptor();
    public final PopupScrollListener mScrollListener = new PopupScrollListener();
    public final ListSelectorHider mHideSelector = new ListSelectorHider(this, 0);
    public final Rect mTempRect = new Rect();

    /* loaded from: classes.dex */
    public abstract class Api24Impl {
        public static int getMaxAvailableHeight(PopupWindow popupWindow, View view, int i, boolean z) {
            return popupWindow.getMaxAvailableHeight(view, i, z);
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api29Impl {
        public static void setEpicenterBounds(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void setIsClippedToScreen(PopupWindow popupWindow, boolean z) {
            popupWindow.setIsClippedToScreen(z);
        }
    }

    /* loaded from: classes.dex */
    public final class ListSelectorHider implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ ListPopupWindow this$0;

        public /* synthetic */ ListSelectorHider(ListPopupWindow listPopupWindow, int i) {
            this.$r8$classId = i;
            this.this$0 = listPopupWindow;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    DropDownListView dropDownListView = this.this$0.mDropDownList;
                    if (dropDownListView != null) {
                        dropDownListView.setListSelectionHidden(true);
                        dropDownListView.requestLayout();
                        return;
                    }
                    return;
                default:
                    ListPopupWindow listPopupWindow = this.this$0;
                    DropDownListView dropDownListView2 = listPopupWindow.mDropDownList;
                    if (dropDownListView2 != null && dropDownListView2.isAttachedToWindow() && listPopupWindow.mDropDownList.getCount() > listPopupWindow.mDropDownList.getChildCount() && listPopupWindow.mDropDownList.getChildCount() <= listPopupWindow.mListItemExpandMaximum) {
                        listPopupWindow.mPopup.setInputMethodMode(2);
                        listPopupWindow.show();
                        return;
                    }
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class PopupScrollListener implements AbsListView.OnScrollListener {
        public PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            ListSelectorHider listSelectorHider = listPopupWindow.mResizePopupRunnable;
            AppCompatPopupWindow appCompatPopupWindow = listPopupWindow.mPopup;
            if (i == 1 && appCompatPopupWindow.getInputMethodMode() != 2 && appCompatPopupWindow.getContentView() != null) {
                listPopupWindow.mHandler.removeCallbacks(listSelectorHider);
                listSelectorHider.run();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class PopupTouchInterceptor implements View.OnTouchListener {
        public PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            ListSelectorHider listSelectorHider = listPopupWindow.mResizePopupRunnable;
            Handler handler = listPopupWindow.mHandler;
            AppCompatPopupWindow appCompatPopupWindow = listPopupWindow.mPopup;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && appCompatPopupWindow != null && appCompatPopupWindow.isShowing() && x >= 0 && x < appCompatPopupWindow.getWidth() && y >= 0 && y < appCompatPopupWindow.getHeight()) {
                handler.postDelayed(listSelectorHider, 250L);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                handler.removeCallbacks(listSelectorHider);
                return false;
            }
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        if (i <= 28) {
            try {
                sSetClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", cls);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                sSetEpicenterBoundsMethod = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, cls);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.appcompat.widget.AppCompatPopupWindow, android.widget.PopupWindow] */
    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        Drawable drawable;
        int resourceId;
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ListPopupWindow, i, 0);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.mDropDownVerticalOffset = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        ?? popupWindow = new PopupWindow(context, attributeSet, i, 0);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.PopupWindow, i, 0);
        if (obtainStyledAttributes2.hasValue(2)) {
            BundleKt.setOverlapAnchor(popupWindow, obtainStyledAttributes2.getBoolean(2, false));
        }
        if (!obtainStyledAttributes2.hasValue(0) || (resourceId = obtainStyledAttributes2.getResourceId(0, 0)) == 0) {
            drawable = obtainStyledAttributes2.getDrawable(0);
        } else {
            drawable = BundleKt.getDrawable(context, resourceId);
        }
        popupWindow.setBackgroundDrawable(drawable);
        obtainStyledAttributes2.recycle();
        this.mPopup = popupWindow;
        popupWindow.setInputMethodMode(1);
    }

    public DropDownListView createDropDownListView(Context context, boolean z) {
        return new DropDownListView(context, z);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
        appCompatPopupWindow.dismiss();
        appCompatPopupWindow.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public final Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public final int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final DropDownListView getListView() {
        return this.mDropDownList;
    }

    public final int getVerticalOffset() {
        if (!this.mDropDownVerticalOffsetSet) {
            return 0;
        }
        return this.mDropDownVerticalOffset;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public void setAdapter(ListAdapter listAdapter) {
        CursorAdapter.MyDataSetObserver myDataSetObserver = this.mObserver;
        if (myDataSetObserver == null) {
            this.mObserver = new CursorAdapter.MyDataSetObserver(1, this);
        } else {
            ListAdapter listAdapter2 = this.mAdapter;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(myDataSetObserver);
            }
        }
        this.mAdapter = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.mAdapter);
        }
    }

    public final void setBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public final void setContentWidth(int i) {
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            Rect rect = this.mTempRect;
            background.getPadding(rect);
            this.mDropDownWidth = rect.left + rect.right + i;
            return;
        }
        this.mDropDownWidth = i;
    }

    public final void setHorizontalOffset(int i) {
        this.mDropDownHorizontalOffset = i;
    }

    public final void setVerticalOffset(int i) {
        this.mDropDownVerticalOffset = i;
        this.mDropDownVerticalOffsetSet = true;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void show() {
        int i;
        boolean z;
        int i2;
        int i3;
        boolean z2;
        DropDownListView dropDownListView;
        int i4;
        int i5;
        int i6;
        int i7;
        DropDownListView dropDownListView2 = this.mDropDownList;
        Context context = this.mContext;
        AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
        if (dropDownListView2 == null) {
            DropDownListView createDropDownListView = createDropDownListView(context, !this.mModal);
            this.mDropDownList = createDropDownListView;
            createDropDownListView.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new SearchView.C00369(1, this));
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.mItemSelectedListener;
            if (onItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(onItemSelectedListener);
            }
            appCompatPopupWindow.setContentView(this.mDropDownList);
        } else {
            ViewGroup viewGroup = (ViewGroup) appCompatPopupWindow.getContentView();
        }
        Drawable background = appCompatPopupWindow.getBackground();
        Rect rect = this.mTempRect;
        int i8 = 0;
        if (background != null) {
            background.getPadding(rect);
            int i9 = rect.top;
            i = rect.bottom + i9;
            if (!this.mDropDownVerticalOffsetSet) {
                this.mDropDownVerticalOffset = -i9;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        if (appCompatPopupWindow.getInputMethodMode() == 2) {
            z = true;
        } else {
            z = false;
        }
        View view = this.mDropDownAnchorView;
        int i10 = this.mDropDownVerticalOffset;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = sGetMaxAvailableHeightMethod;
            if (method != null) {
                try {
                    i2 = ((Integer) method.invoke(appCompatPopupWindow, view, Integer.valueOf(i10), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            i2 = appCompatPopupWindow.getMaxAvailableHeight(view, i10);
        } else {
            i2 = Api24Impl.getMaxAvailableHeight(appCompatPopupWindow, view, i10, z);
        }
        int i11 = this.mDropDownHeight;
        if (i11 == -1) {
            i3 = i2 + i;
        } else {
            int i12 = this.mDropDownWidth;
            if (i12 == -2) {
                i6 = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE);
            } else if (i12 != -1) {
                i6 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else {
                i6 = View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824);
            }
            int measureHeightOfChildrenCompat = this.mDropDownList.measureHeightOfChildrenCompat(i6, i2);
            if (measureHeightOfChildrenCompat > 0) {
                i7 = this.mDropDownList.getPaddingBottom() + this.mDropDownList.getPaddingTop() + i;
            } else {
                i7 = 0;
            }
            i3 = measureHeightOfChildrenCompat + i7;
        }
        if (appCompatPopupWindow.getInputMethodMode() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        BundleKt.setWindowLayoutType(appCompatPopupWindow, this.mDropDownWindowLayoutType);
        if (!appCompatPopupWindow.isShowing()) {
            int i13 = this.mDropDownWidth;
            if (i13 == -1) {
                i13 = -1;
            } else if (i13 == -2) {
                i13 = this.mDropDownAnchorView.getWidth();
            }
            if (i11 == -1) {
                i11 = -1;
            } else if (i11 == -2) {
                i11 = i3;
            }
            appCompatPopupWindow.setWidth(i13);
            appCompatPopupWindow.setHeight(i11);
            if (Build.VERSION.SDK_INT <= 28) {
                Method method2 = sSetClipToWindowEnabledMethod;
                if (method2 != null) {
                    try {
                        method2.invoke(appCompatPopupWindow, Boolean.TRUE);
                    } catch (Exception unused2) {
                        Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                    }
                }
            } else {
                Api29Impl.setIsClippedToScreen(appCompatPopupWindow, true);
            }
            appCompatPopupWindow.setOutsideTouchable(true);
            appCompatPopupWindow.setTouchInterceptor(this.mTouchInterceptor);
            if (this.mOverlapAnchorSet) {
                BundleKt.setOverlapAnchor(appCompatPopupWindow, this.mOverlapAnchor);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method3 = sSetEpicenterBoundsMethod;
                if (method3 != null) {
                    try {
                        method3.invoke(appCompatPopupWindow, this.mEpicenterBounds);
                    } catch (Exception e) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                    }
                }
            } else {
                Api29Impl.setEpicenterBounds(appCompatPopupWindow, this.mEpicenterBounds);
            }
            appCompatPopupWindow.showAsDropDown(this.mDropDownAnchorView, this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
            this.mDropDownList.setSelection(-1);
            if ((!this.mModal || this.mDropDownList.isInTouchMode()) && (dropDownListView = this.mDropDownList) != null) {
                dropDownListView.setListSelectionHidden(true);
                dropDownListView.requestLayout();
            }
            if (!this.mModal) {
                this.mHandler.post(this.mHideSelector);
            }
        } else if (this.mDropDownAnchorView.isAttachedToWindow()) {
            int i14 = this.mDropDownWidth;
            if (i14 == -1) {
                i14 = -1;
            } else if (i14 == -2) {
                i14 = this.mDropDownAnchorView.getWidth();
            }
            if (i11 == -1) {
                if (z2) {
                    i11 = i3;
                } else {
                    i11 = -1;
                }
                if (z2) {
                    if (this.mDropDownWidth == -1) {
                        i5 = -1;
                    } else {
                        i5 = 0;
                    }
                    appCompatPopupWindow.setWidth(i5);
                    appCompatPopupWindow.setHeight(0);
                } else {
                    if (this.mDropDownWidth == -1) {
                        i8 = -1;
                    }
                    appCompatPopupWindow.setWidth(i8);
                    appCompatPopupWindow.setHeight(-1);
                }
            } else if (i11 == -2) {
                i11 = i3;
            }
            appCompatPopupWindow.setOutsideTouchable(true);
            int i15 = i14;
            View view2 = this.mDropDownAnchorView;
            int i16 = this.mDropDownHorizontalOffset;
            int i17 = this.mDropDownVerticalOffset;
            if (i15 < 0) {
                i4 = -1;
            } else {
                i4 = i15;
            }
            if (i11 < 0) {
                i11 = -1;
            }
            appCompatPopupWindow.update(view2, i16, i17, i4, i11);
        }
    }
}
