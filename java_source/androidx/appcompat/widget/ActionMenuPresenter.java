package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.p002os.BundleKt;
import androidx.viewpager2.widget.FakeDrag;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.gms.common.zzb;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class ActionMenuPresenter implements MenuPresenter {
    public OverflowPopup mActionButtonPopup;
    public int mActionItemWidthLimit;
    public MenuPresenter.Callback mCallback;
    public Context mContext;
    public boolean mExpandedActionViewsExclusive;
    public int mId;
    public int mMaxItems;
    public MenuBuilder mMenu;
    public MenuView mMenuView;
    public int mOpenSubMenuId;
    public OverflowMenuButton mOverflowButton;
    public OverflowPopup mOverflowPopup;
    public Drawable mPendingOverflowIcon;
    public boolean mPendingOverflowIconSet;
    public ActionMenuPopupCallback mPopupCallback;
    public OpenOverflowRunnable mPostedOpenRunnable;
    public boolean mReserveOverflow;
    public boolean mReserveOverflowSet;
    public final Context mSystemContext;
    public final LayoutInflater mSystemInflater;
    public int mWidthLimit;
    public final int mMenuLayoutRes = C0130R.layout.abc_action_menu_layout;
    public final int mItemLayoutRes = C0130R.layout.abc_action_menu_item_layout;
    public final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    public final FakeDrag mPopupPresenterCallback = new FakeDrag(5, this);

    /* loaded from: classes.dex */
    public final class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        public ActionMenuPopupCallback() {
        }
    }

    /* loaded from: classes.dex */
    public final class OpenOverflowRunnable implements Runnable {
        public final OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MenuBuilder.Callback callback;
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
            if (!(menuBuilder == null || (callback = menuBuilder.mCallback) == null)) {
                callback.onMenuModeChange(menuBuilder);
            }
            View view = (View) actionMenuPresenter.mMenuView;
            if (!(view == null || view.getWindowToken() == null)) {
                OverflowPopup overflowPopup = this.mPopup;
                if (!overflowPopup.isShowing()) {
                    if (overflowPopup.mAnchorView != null) {
                        overflowPopup.showPopup(0, 0, false, false);
                    }
                }
                actionMenuPresenter.mOverflowPopup = overflowPopup;
            }
            actionMenuPresenter.mPostedOpenRunnable = null;
        }
    }

    /* loaded from: classes.dex */
    public final class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, null, C0130R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            BundleKt.setTooltipText(this, getContentDescription());
            setOnTouchListener(new C00221(this, this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public final boolean needsDividerAfter() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public final boolean needsDividerBefore() {
            return false;
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.showOverflowMenu();
            return true;
        }

        @Override // android.widget.ImageView
        public final boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat$Api21Impl.setHotspotBounds(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }

        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$OverflowMenuButton$1 */
        /* loaded from: classes.dex */
        public final class C00221 extends ForwardingListener {
            public final /* synthetic */ int $r8$classId = 1;
            public final /* synthetic */ View this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00221(ActionMenuItemView actionMenuItemView) {
                super(actionMenuItemView);
                this.this$1 = actionMenuItemView;
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public final ShowableListMenu getPopup() {
                OverflowPopup overflowPopup;
                switch (this.$r8$classId) {
                    case 0:
                        OverflowPopup overflowPopup2 = ActionMenuPresenter.this.mOverflowPopup;
                        if (overflowPopup2 == null) {
                            return null;
                        }
                        return overflowPopup2.getPopup();
                    default:
                        ActionMenuItemView.PopupCallback popupCallback = ((ActionMenuItemView) this.this$1).mPopupCallback;
                        if (popupCallback == null || (overflowPopup = ActionMenuPresenter.this.mActionButtonPopup) == null) {
                            return null;
                        }
                        return overflowPopup.getPopup();
                }
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public final boolean onForwardingStarted() {
                ShowableListMenu popup;
                switch (this.$r8$classId) {
                    case 0:
                        ActionMenuPresenter.this.showOverflowMenu();
                        return true;
                    default:
                        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.this$1;
                        MenuBuilder.ItemInvoker itemInvoker = actionMenuItemView.mItemInvoker;
                        if (itemInvoker == null || !itemInvoker.invokeItem(actionMenuItemView.mItemData) || (popup = getPopup()) == null || !popup.isShowing()) {
                            return false;
                        }
                        return true;
                }
            }

            @Override // androidx.appcompat.widget.ForwardingListener
            public boolean onForwardingStopped() {
                switch (this.$r8$classId) {
                    case 0:
                        ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                        if (actionMenuPresenter.mPostedOpenRunnable != null) {
                            return false;
                        }
                        actionMenuPresenter.hideOverflowMenu();
                        return true;
                    default:
                        return super.onForwardingStopped();
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00221(OverflowMenuButton overflowMenuButton, OverflowMenuButton overflowMenuButton2) {
                super(overflowMenuButton2);
                this.this$1 = overflowMenuButton;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new zzb(3);
        public int openSubMenuId;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    public ActionMenuPresenter(Context context) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from(context);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean expandItemActionView(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean flagActionItems() {
        int i;
        ArrayList arrayList;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
        if (menuBuilder != null) {
            arrayList = menuBuilder.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i3 = actionMenuPresenter.mMaxItems;
        int i4 = actionMenuPresenter.mActionItemWidthLimit;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.mMenuView;
        int i5 = 0;
        boolean z5 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i2 = 2;
            z = true;
            if (i5 >= i) {
                break;
            }
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i5);
            int i8 = menuItemImpl.mShowAsAction;
            if ((i8 & 2) == 2) {
                i6++;
            } else if ((i8 & 1) == 1) {
                i7++;
            } else {
                z5 = true;
            }
            if (actionMenuPresenter.mExpandedActionViewsExclusive && menuItemImpl.mIsActionViewExpanded) {
                i3 = 0;
            }
            i5++;
        }
        if (actionMenuPresenter.mReserveOverflow && (z5 || i7 + i6 > i3)) {
            i3--;
        }
        int i9 = i3 - i6;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.mActionButtonGroups;
        sparseBooleanArray.clear();
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            MenuItemImpl menuItemImpl2 = (MenuItemImpl) arrayList.get(i10);
            int i12 = menuItemImpl2.mShowAsAction;
            if ((i12 & 2) == i2) {
                z2 = true;
            } else {
                z2 = false;
            }
            int i13 = menuItemImpl2.mGroup;
            if (z2) {
                View itemView = actionMenuPresenter.getItemView(menuItemImpl2, null, viewGroup);
                itemView.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = itemView.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                if (i13 != 0) {
                    sparseBooleanArray.put(i13, z);
                }
                menuItemImpl2.setIsActionButton(z);
            } else if ((i12 & 1) == z) {
                boolean z6 = sparseBooleanArray.get(i13);
                if ((i9 > 0 || z6) && i4 > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    View itemView2 = actionMenuPresenter.getItemView(menuItemImpl2, null, viewGroup);
                    itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = itemView2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    if (i4 + i11 > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z3 &= z4;
                }
                if (z3 && i13 != 0) {
                    sparseBooleanArray.put(i13, true);
                } else if (z6) {
                    sparseBooleanArray.put(i13, false);
                    for (int i14 = 0; i14 < i10; i14++) {
                        MenuItemImpl menuItemImpl3 = (MenuItemImpl) arrayList.get(i14);
                        if (menuItemImpl3.mGroup == i13) {
                            if ((menuItemImpl3.mFlags & 32) == 32) {
                                i9++;
                            }
                            menuItemImpl3.setIsActionButton(false);
                        }
                    }
                }
                if (z3) {
                    i9--;
                }
                menuItemImpl2.setIsActionButton(z3);
            } else {
                menuItemImpl2.setIsActionButton(false);
                i10++;
                i2 = 2;
                actionMenuPresenter = this;
                z = true;
            }
            i10++;
            i2 = 2;
            actionMenuPresenter = this;
            z = true;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final int getId() {
        return this.mId;
    }

    public final View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView itemView;
        View actionView = menuItemImpl.getActionView();
        int i = 0;
        if (actionView == null || menuItemImpl.hasCollapsibleActionView()) {
            if (view instanceof MenuView.ItemView) {
                itemView = (MenuView.ItemView) view;
            } else {
                itemView = (MenuView.ItemView) this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
            }
            itemView.initialize(menuItemImpl);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
            if (this.mPopupCallback == null) {
                this.mPopupCallback = new ActionMenuPopupCallback();
            }
            actionMenuItemView.setPopupCallback(this.mPopupCallback);
            actionView = (View) itemView;
        }
        if (menuItemImpl.mIsActionViewExpanded) {
            i = 8;
        }
        actionView.setVisibility(i);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof ActionMenuView.LayoutParams)) {
            actionView.setLayoutParams(ActionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public final boolean hideOverflowMenu() {
        MenuView menuView;
        OpenOverflowRunnable openOverflowRunnable = this.mPostedOpenRunnable;
        if (openOverflowRunnable == null || (menuView = this.mMenuView) == null) {
            OverflowPopup overflowPopup = this.mOverflowPopup;
            if (overflowPopup == null) {
                return false;
            }
            if (overflowPopup.isShowing()) {
                overflowPopup.mPopup.dismiss();
            }
            return true;
        }
        ((View) menuView).removeCallbacks(openOverflowRunnable);
        this.mPostedOpenRunnable = null;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
        this.mContext = context;
        LayoutInflater.from(context);
        this.mMenu = menuBuilder;
        Resources resources = context.getResources();
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = true;
        }
        int i = 2;
        this.mWidthLimit = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.mMaxItems = i;
        int i4 = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.mSystemContext);
                this.mOverflowButton = overflowMenuButton;
                if (this.mPendingOverflowIconSet) {
                    overflowMenuButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i4 -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = i4;
        float f = resources.getDisplayMetrics().density;
    }

    public final boolean isOverflowMenuShowing() {
        OverflowPopup overflowPopup = this.mOverflowPopup;
        if (overflowPopup == null || !overflowPopup.isShowing()) {
            return false;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        hideOverflowMenu();
        OverflowPopup overflowPopup = this.mActionButtonPopup;
        if (overflowPopup != null && overflowPopup.isShowing()) {
            overflowPopup.mPopup.dismiss();
        }
        MenuPresenter.Callback callback = this.mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).openSubMenuId) > 0 && (findItem = this.mMenu.findItem(i)) != null) {
            onSubMenuSelected((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, java.lang.Object, androidx.appcompat.widget.ActionMenuPresenter$SavedState] */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable onSaveInstanceState() {
        ?? obj = new Object();
        obj.openSubMenuId = this.mOpenSubMenuId;
        return obj;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean z;
        if (subMenuBuilder.hasVisibleItems()) {
            SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
            while (true) {
                MenuBuilder menuBuilder = subMenuBuilder2.mParentMenu;
                if (menuBuilder == this.mMenu) {
                    break;
                }
                subMenuBuilder2 = (SubMenuBuilder) menuBuilder;
            }
            MenuItemImpl menuItemImpl = subMenuBuilder2.mItem;
            ViewGroup viewGroup = (ViewGroup) this.mMenuView;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItemImpl) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                this.mOpenSubMenuId = subMenuBuilder.mItem.mId;
                int size = subMenuBuilder.mItems.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = subMenuBuilder.getItem(i2);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                OverflowPopup overflowPopup = new OverflowPopup(this.mContext, subMenuBuilder, view);
                this.mActionButtonPopup = overflowPopup;
                overflowPopup.mForceShowIcon = z;
                MenuPopup menuPopup = overflowPopup.mPopup;
                if (menuPopup != null) {
                    menuPopup.setForceShowIcon(z);
                }
                OverflowPopup overflowPopup2 = this.mActionButtonPopup;
                if (!overflowPopup2.isShowing()) {
                    if (overflowPopup2.mAnchorView != null) {
                        overflowPopup2.showPopup(0, 0, false, false);
                    } else {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                }
                MenuPresenter.Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onOpenSubMenu(subMenuBuilder);
                }
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void setCallback(MenuPresenter.Callback callback) {
        throw null;
    }

    public final boolean showOverflowMenu() {
        MenuBuilder menuBuilder;
        if (!this.mReserveOverflow || isOverflowMenuShowing() || (menuBuilder = this.mMenu) == null || this.mMenuView == null || this.mPostedOpenRunnable != null) {
            return false;
        }
        menuBuilder.flagActionItems();
        if (menuBuilder.mNonActionItems.isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton));
        this.mPostedOpenRunnable = openOverflowRunnable;
        ((View) this.mMenuView).post(openOverflowRunnable);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void updateMenuView() {
        int i;
        MenuItemImpl menuItemImpl;
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        ArrayList arrayList = null;
        boolean z = false;
        if (viewGroup != null) {
            MenuBuilder menuBuilder = this.mMenu;
            if (menuBuilder != null) {
                menuBuilder.flagActionItems();
                ArrayList visibleItems = this.mMenu.getVisibleItems();
                int size = visibleItems.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    MenuItemImpl menuItemImpl2 = (MenuItemImpl) visibleItems.get(i2);
                    if ((menuItemImpl2.mFlags & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt instanceof MenuView.ItemView) {
                            menuItemImpl = ((MenuView.ItemView) childAt).getItemData();
                        } else {
                            menuItemImpl = null;
                        }
                        View itemView = getItemView(menuItemImpl2, childAt, viewGroup);
                        if (menuItemImpl2 != menuItemImpl) {
                            itemView.setPressed(false);
                            itemView.jumpDrawablesToCurrentState();
                        }
                        if (itemView != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) itemView.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(itemView);
                            }
                            ((ViewGroup) this.mMenuView).addView(itemView, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.mOverflowButton) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.mMenuView).requestLayout();
        MenuBuilder menuBuilder2 = this.mMenu;
        if (menuBuilder2 != null) {
            menuBuilder2.flagActionItems();
            ArrayList arrayList2 = menuBuilder2.mActionItems;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                MenuItemWrapperICS.ActionProviderWrapper actionProviderWrapper = ((MenuItemImpl) arrayList2.get(i3)).mActionProvider;
            }
        }
        MenuBuilder menuBuilder3 = this.mMenu;
        if (menuBuilder3 != null) {
            menuBuilder3.flagActionItems();
            arrayList = menuBuilder3.mNonActionItems;
        }
        if (this.mReserveOverflow && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z = !((MenuItemImpl) arrayList.get(0)).mIsActionViewExpanded;
            } else if (size3 > 0) {
                z = true;
            }
        }
        if (z) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup3 != this.mMenuView) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.mOverflowButton);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                OverflowMenuButton overflowMenuButton = this.mOverflowButton;
                actionMenuView.getClass();
                ActionMenuView.LayoutParams generateDefaultLayoutParams = ActionMenuView.generateDefaultLayoutParams();
                generateDefaultLayoutParams.isOverflowButton = true;
                actionMenuView.addView(overflowMenuButton, generateDefaultLayoutParams);
            }
        } else {
            OverflowMenuButton overflowMenuButton2 = this.mOverflowButton;
            if (overflowMenuButton2 != null) {
                ViewParent parent = overflowMenuButton2.getParent();
                MenuView menuView = this.mMenuView;
                if (parent == menuView) {
                    ((ViewGroup) menuView).removeView(this.mOverflowButton);
                }
            }
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }

    /* loaded from: classes.dex */
    public final class OverflowPopup extends MenuPopupHelper {
        public final /* synthetic */ int $r8$classId = 0;

        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view) {
            super(context, menuBuilder, view, true, C0130R.attr.actionOverflowMenuStyle, 0);
            this.mDropDownGravity = 8388613;
            FakeDrag fakeDrag = ActionMenuPresenter.this.mPopupPresenterCallback;
            this.mPresenterCallback = fakeDrag;
            MenuPopup menuPopup = this.mPopup;
            if (menuPopup != null) {
                menuPopup.setCallback(fakeDrag);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public final void onDismiss() {
            switch (this.$r8$classId) {
                case 0:
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    MenuBuilder menuBuilder = actionMenuPresenter.mMenu;
                    if (menuBuilder != null) {
                        menuBuilder.close(true);
                    }
                    actionMenuPresenter.mOverflowPopup = null;
                    super.onDismiss();
                    return;
                default:
                    ActionMenuPresenter actionMenuPresenter2 = ActionMenuPresenter.this;
                    actionMenuPresenter2.mActionButtonPopup = null;
                    actionMenuPresenter2.mOpenSubMenuId = 0;
                    super.onDismiss();
                    return;
            }
        }

        public OverflowPopup(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, C0130R.attr.actionOverflowMenuStyle, 0);
            if ((subMenuBuilder.mItem.mFlags & 32) != 32) {
                View view2 = ActionMenuPresenter.this.mOverflowButton;
                this.mAnchorView = view2 == null ? (View) ActionMenuPresenter.this.mMenuView : view2;
            }
            FakeDrag fakeDrag = ActionMenuPresenter.this.mPopupPresenterCallback;
            this.mPresenterCallback = fakeDrag;
            MenuPopup menuPopup = this.mPopup;
            if (menuPopup != null) {
                menuPopup.setCallback(fakeDrag);
            }
        }
    }
}
