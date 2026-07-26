package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.appcompat.widget.AppCompatPopupWindow;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.viewpager2.widget.FakeDrag;
import com.emanuelef.remote_capture.C0130R;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public View mAnchorView;
    public final Context mContext;
    public boolean mHasXOffset;
    public boolean mHasYOffset;
    public int mLastPosition;
    public final int mMenuMaxWidth;
    public PopupWindow.OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public final int mPopupStyleAttr;
    public MenuPresenter.Callback mPresenterCallback;
    public boolean mShouldCloseImmediately;
    public boolean mShowTitle;
    public View mShownAnchorView;
    public final Handler mSubMenuHoverHandler;
    public ViewTreeObserver mTreeObserver;
    public int mXOffset;
    public int mYOffset;
    public final ArrayList mPendingMenus = new ArrayList();
    public final ArrayList mShowingMenus = new ArrayList();
    public final AppCompatSpinner.ViewTreeObserver$OnGlobalLayoutListenerC00252 mGlobalLayoutListener = new AppCompatSpinner.ViewTreeObserver$OnGlobalLayoutListenerC00252(1, this);
    public final StandardMenuPopup.View$OnAttachStateChangeListenerC00202 mAttachStateChangeListener = new StandardMenuPopup.View$OnAttachStateChangeListenerC00202(1, this);
    public final FakeDrag mMenuItemHoverListener = new FakeDrag(3, this);
    public int mRawDropDownGravity = 0;
    public int mDropDownGravity = 0;
    public boolean mForceShowIcon = false;

    /* loaded from: classes.dex */
    public final class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i;
        }
    }

    public CascadingMenuPopup(Context context, View view, int i, boolean z) {
        int i2 = 0;
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = i;
        this.mOverflowOnly = z;
        this.mLastPosition = view.getLayoutDirection() != 1 ? 1 : i2;
        Resources resources = context.getResources();
        this.mMenuMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0130R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) arrayList.toArray(new CascadingMenuInfo[size]);
            for (int i = size - 1; i >= 0; i--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i];
                if (cascadingMenuInfo.window.mPopup.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final DropDownListView getListView() {
        ArrayList arrayList = this.mShowingMenus;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((CascadingMenuInfo) arrayList.get(arrayList.size() - 1)).window.mDropDownList;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean isShowing() {
        ArrayList arrayList = this.mShowingMenus;
        if (arrayList.size() <= 0 || !((CascadingMenuInfo) arrayList.get(0)).window.mPopup.isShowing()) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int i;
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (menuBuilder == ((CascadingMenuInfo) arrayList.get(i2)).menu) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int i3 = i2 + 1;
            if (i3 < arrayList.size()) {
                ((CascadingMenuInfo) arrayList.get(i3)).menu.close(false);
            }
            CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) arrayList.remove(i2);
            MenuBuilder menuBuilder2 = cascadingMenuInfo.menu;
            MenuPopupWindow menuPopupWindow = cascadingMenuInfo.window;
            AppCompatPopupWindow appCompatPopupWindow = menuPopupWindow.mPopup;
            menuBuilder2.removeMenuPresenter(this);
            if (this.mShouldCloseImmediately) {
                if (Build.VERSION.SDK_INT >= 23) {
                    MenuPopupWindow.Api23Impl.setExitTransition(appCompatPopupWindow, null);
                }
                appCompatPopupWindow.setAnimationStyle(0);
            }
            menuPopupWindow.dismiss();
            int size2 = arrayList.size();
            if (size2 > 0) {
                this.mLastPosition = ((CascadingMenuInfo) arrayList.get(size2 - 1)).position;
            } else {
                if (this.mAnchorView.getLayoutDirection() == 1) {
                    i = 0;
                } else {
                    i = 1;
                }
                this.mLastPosition = i;
            }
            if (size2 == 0) {
                dismiss();
                MenuPresenter.Callback callback = this.mPresenterCallback;
                if (callback != null) {
                    callback.onCloseMenu(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.mTreeObserver;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
                    }
                    this.mTreeObserver = null;
                }
                this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
                this.mOnDismissListener.onDismiss();
            } else if (z) {
                ((CascadingMenuInfo) arrayList.get(0)).menu.close(false);
            }
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = (CascadingMenuInfo) arrayList.get(i);
            if (!cascadingMenuInfo.window.mPopup.isShowing()) {
                break;
            }
            i++;
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) obj;
            if (subMenuBuilder == cascadingMenuInfo.menu) {
                cascadingMenuInfo.window.mDropDownList.requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        addMenu(subMenuBuilder);
        MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setAnchorView(View view) {
        if (this.mAnchorView != view) {
            this.mAnchorView = view;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(this.mRawDropDownGravity, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setGravity(int i) {
        if (this.mRawDropDownGravity != i) {
            this.mRawDropDownGravity = i;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(i, this.mAnchorView.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setHorizontalOffset(int i) {
        this.mHasXOffset = true;
        this.mXOffset = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setShowTitle(boolean z) {
        this.mShowTitle = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void setVerticalOffset(int i) {
        this.mHasYOffset = true;
        this.mYOffset = i;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void show() {
        if (!isShowing()) {
            ArrayList arrayList = this.mPendingMenus;
            int size = arrayList.size();
            boolean z = false;
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                showMenu((MenuBuilder) obj);
            }
            arrayList.clear();
            View view = this.mAnchorView;
            this.mShownAnchorView = view;
            if (view != null) {
                if (this.mTreeObserver == null) {
                    z = true;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.mTreeObserver = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
                }
                this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0166, code lost:
        if (((r2.getWidth() + r10[0]) + r5) > r9.right) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0168, code lost:
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x016b, code lost:
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0172, code lost:
        if ((r10[0] - r5) < 0) goto L68;
     */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.MenuPopupWindow] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showMenu(MenuBuilder menuBuilder) {
        char c;
        CascadingMenuInfo cascadingMenuInfo;
        View view;
        Rect rect;
        int i;
        boolean z;
        int i2;
        int i3;
        int i4;
        MenuItem menuItem;
        int i5;
        MenuAdapter menuAdapter;
        int firstVisiblePosition;
        boolean z2;
        Context context = this.mContext;
        LayoutInflater from = LayoutInflater.from(context);
        MenuAdapter menuAdapter2 = new MenuAdapter(menuBuilder, from, this.mOverflowOnly, C0130R.layout.abc_cascading_menu_item_layout);
        if (!isShowing() && this.mForceShowIcon) {
            menuAdapter2.mForceShowIcon = true;
        } else if (isShowing()) {
            int size = menuBuilder.mItems.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    z2 = false;
                    break;
                }
                MenuItem item = menuBuilder.getItem(i6);
                if (item.isVisible() && item.getIcon() != null) {
                    z2 = true;
                    break;
                }
                i6++;
            }
            menuAdapter2.mForceShowIcon = z2;
        }
        int measureIndividualMenuWidth = MenuPopup.measureIndividualMenuWidth(menuAdapter2, context, this.mMenuMaxWidth);
        ?? listPopupWindow = new ListPopupWindow(context, null, this.mPopupStyleAttr, 0);
        listPopupWindow.mHoverListener = this.mMenuItemHoverListener;
        listPopupWindow.mItemClickListener = this;
        AppCompatPopupWindow appCompatPopupWindow = listPopupWindow.mPopup;
        appCompatPopupWindow.setOnDismissListener(this);
        listPopupWindow.mDropDownAnchorView = this.mAnchorView;
        listPopupWindow.mDropDownGravity = this.mDropDownGravity;
        listPopupWindow.mModal = true;
        appCompatPopupWindow.setFocusable(true);
        appCompatPopupWindow.setInputMethodMode(2);
        listPopupWindow.setAdapter(menuAdapter2);
        listPopupWindow.setContentWidth(measureIndividualMenuWidth);
        listPopupWindow.mDropDownGravity = this.mDropDownGravity;
        ArrayList arrayList = this.mShowingMenus;
        if (arrayList.size() > 0) {
            cascadingMenuInfo = (CascadingMenuInfo) arrayList.get(arrayList.size() - 1);
            MenuBuilder menuBuilder2 = cascadingMenuInfo.menu;
            int size2 = menuBuilder2.mItems.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size2) {
                    menuItem = null;
                    break;
                }
                menuItem = menuBuilder2.getItem(i7);
                if (menuItem.hasSubMenu() && menuBuilder == menuItem.getSubMenu()) {
                    break;
                }
                i7++;
            }
            if (menuItem == null) {
                view = null;
                c = 0;
            } else {
                DropDownListView dropDownListView = cascadingMenuInfo.window.mDropDownList;
                ListAdapter adapter = dropDownListView.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i5 = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                    i5 = 0;
                }
                int count = menuAdapter.getCount();
                int i8 = 0;
                c = 0;
                while (true) {
                    if (i8 >= count) {
                        i8 = -1;
                        break;
                    } else if (menuItem == menuAdapter.getItem(i8)) {
                        break;
                    } else {
                        i8++;
                    }
                }
                if (i8 != -1 && (firstVisiblePosition = (i8 + i5) - dropDownListView.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < dropDownListView.getChildCount()) {
                    view = dropDownListView.getChildAt(firstVisiblePosition);
                } else {
                    view = null;
                }
            }
        } else {
            c = 0;
            view = null;
            cascadingMenuInfo = null;
        }
        if (view != null) {
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = MenuPopupWindow.sSetTouchModalMethod;
                if (method != null) {
                    try {
                        Object[] objArr = new Object[1];
                        objArr[c] = Boolean.FALSE;
                        method.invoke(appCompatPopupWindow, objArr);
                    } catch (Exception unused) {
                        Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    }
                }
            } else {
                MenuPopupWindow.Api29Impl.setTouchModal(appCompatPopupWindow, false);
            }
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 23) {
                MenuPopupWindow.Api23Impl.setEnterTransition(appCompatPopupWindow, null);
            }
            DropDownListView dropDownListView2 = ((CascadingMenuInfo) arrayList.get(arrayList.size() - 1)).window.mDropDownList;
            int[] iArr = new int[2];
            dropDownListView2.getLocationOnScreen(iArr);
            Rect rect2 = new Rect();
            this.mShownAnchorView.getWindowVisibleDisplayFrame(rect2);
            if (this.mLastPosition == 1) {
            }
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            this.mLastPosition = i;
            if (i9 >= 26) {
                listPopupWindow.mDropDownAnchorView = view;
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr2 = new int[2];
                this.mAnchorView.getLocationOnScreen(iArr2);
                int[] iArr3 = new int[2];
                view.getLocationOnScreen(iArr3);
                if ((this.mDropDownGravity & 7) == 5) {
                    iArr2[0] = this.mAnchorView.getWidth() + iArr2[0];
                    iArr3[0] = view.getWidth() + iArr3[0];
                }
                i3 = iArr3[1] - iArr2[1];
                i2 = iArr3[0] - iArr2[0];
            }
            if ((this.mDropDownGravity & 5) != 5) {
                if (z) {
                    i4 = i2 + view.getWidth();
                    listPopupWindow.mDropDownHorizontalOffset = i4;
                    listPopupWindow.mOverlapAnchorSet = true;
                    listPopupWindow.mOverlapAnchor = true;
                    listPopupWindow.setVerticalOffset(i3);
                }
                i4 = i2 - measureIndividualMenuWidth;
                listPopupWindow.mDropDownHorizontalOffset = i4;
                listPopupWindow.mOverlapAnchorSet = true;
                listPopupWindow.mOverlapAnchor = true;
                listPopupWindow.setVerticalOffset(i3);
            } else if (z) {
                i4 = i2 + measureIndividualMenuWidth;
                listPopupWindow.mDropDownHorizontalOffset = i4;
                listPopupWindow.mOverlapAnchorSet = true;
                listPopupWindow.mOverlapAnchor = true;
                listPopupWindow.setVerticalOffset(i3);
            } else {
                measureIndividualMenuWidth = view.getWidth();
                i4 = i2 - measureIndividualMenuWidth;
                listPopupWindow.mDropDownHorizontalOffset = i4;
                listPopupWindow.mOverlapAnchorSet = true;
                listPopupWindow.mOverlapAnchor = true;
                listPopupWindow.setVerticalOffset(i3);
            }
        } else {
            if (this.mHasXOffset) {
                listPopupWindow.mDropDownHorizontalOffset = this.mXOffset;
            }
            if (this.mHasYOffset) {
                listPopupWindow.setVerticalOffset(this.mYOffset);
            }
            Rect rect3 = this.mEpicenterBounds;
            if (rect3 != null) {
                rect = new Rect(rect3);
            } else {
                rect = null;
            }
            listPopupWindow.mEpicenterBounds = rect;
        }
        arrayList.add(new CascadingMenuInfo(listPopupWindow, menuBuilder, this.mLastPosition));
        listPopupWindow.show();
        DropDownListView dropDownListView3 = listPopupWindow.mDropDownList;
        dropDownListView3.setOnKeyListener(this);
        if (cascadingMenuInfo == null && this.mShowTitle && menuBuilder.mHeaderTitle != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0130R.layout.abc_popup_menu_header_item_layout, (ViewGroup) dropDownListView3, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.mHeaderTitle);
            dropDownListView3.addHeaderView(frameLayout, null, false);
            listPopupWindow.show();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView() {
        ArrayList arrayList = this.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ListAdapter adapter = ((CascadingMenuInfo) obj).window.mDropDownList.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((MenuAdapter) adapter).notifyDataSetChanged();
        }
    }
}
