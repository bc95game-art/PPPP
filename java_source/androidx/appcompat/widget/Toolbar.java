package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.p002os.BundleKt;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.android.billingclient.api.zzab;
import com.android.billingclient.api.zzcn;
import com.emanuelef.remote_capture.C0130R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.internal.NavigationMenuPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.text.MatcherMatchResult;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    public zzcn mActionMenuPresenterCallback;
    public OnBackInvokedCallback mBackInvokedCallback;
    public boolean mBackInvokedCallbackEnabled;
    public OnBackInvokedDispatcher mBackInvokedDispatcher;
    public final int mButtonGravity;
    public AppCompatImageButton mCollapseButtonView;
    public final CharSequence mCollapseDescription;
    public final Drawable mCollapseIcon;
    public boolean mCollapsible;
    public int mContentInsetEndWithActions;
    public int mContentInsetStartWithNavigation;
    public RtlSpacingHelper mContentInsets;
    public boolean mEatingHover;
    public boolean mEatingTouch;
    public View mExpandedActionView;
    public ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    public final int mGravity;
    public final ArrayList mHiddenViews;
    public AppCompatImageView mLogoView;
    public final int mMaxButtonHeight;
    public ToolbarActionBar.C00172 mMenuBuilderCallback;
    public final MenuHostHelper mMenuHostHelper;
    public ActionMenuView mMenuView;
    public final C00381 mMenuViewItemClickListener;
    public AppCompatImageButton mNavButtonView;
    public OnMenuItemClickListener mOnMenuItemClickListener;
    public ActionMenuPresenter mOuterActionMenuPresenter;
    public Context mPopupContext;
    public int mPopupTheme;
    public ArrayList mProvidedMenuItems;
    public final zzab mShowOverflowMenuRunnable;
    public CharSequence mSubtitleText;
    public int mSubtitleTextAppearance;
    public ColorStateList mSubtitleTextColor;
    public AppCompatTextView mSubtitleTextView;
    public final int[] mTempMargins;
    public final ArrayList mTempViews;
    public int mTitleMarginBottom;
    public int mTitleMarginEnd;
    public int mTitleMarginStart;
    public int mTitleMarginTop;
    public CharSequence mTitleText;
    public int mTitleTextAppearance;
    public ColorStateList mTitleTextColor;
    public AppCompatTextView mTitleTextView;
    public ToolbarWidgetWrapper mWrapper;

    /* renamed from: androidx.appcompat.widget.Toolbar$1 */
    /* loaded from: classes.dex */
    public final class C00381 implements ActionMenuView.OnMenuItemClickListener, MenuBuilder.Callback {
        public /* synthetic */ C00381() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            Toolbar toolbar = Toolbar.this;
            ActionMenuPresenter actionMenuPresenter = toolbar.mMenuView.mPresenter;
            if (actionMenuPresenter == null || !actionMenuPresenter.isOverflowMenuShowing()) {
                Iterator it = toolbar.mMenuHostHelper.mMenuProviders.iterator();
                while (it.hasNext()) {
                    ((MenuProvider) it.next()).onPrepareMenu(menuBuilder);
                }
            }
            ToolbarActionBar.C00172 r0 = toolbar.mMenuBuilderCallback;
            if (r0 != null) {
                r0.onMenuModeChange(menuBuilder);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.Toolbar$4 */
    /* loaded from: classes.dex */
    public final class View$OnClickListenerC00394 implements View.OnClickListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ View$OnClickListenerC00394(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MenuItemImpl menuItemImpl;
            boolean z;
            Message message;
            Message message2;
            Message message3;
            Message message4;
            switch (this.$r8$classId) {
                case 0:
                    ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = ((Toolbar) this.this$0).mExpandedMenuPresenter;
                    if (expandedActionViewMenuPresenter == null) {
                        menuItemImpl = null;
                    } else {
                        menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem;
                    }
                    if (menuItemImpl != null) {
                        menuItemImpl.collapseActionView();
                        return;
                    }
                    return;
                case 1:
                    DrawerLayout drawerLayout = ((ActionBarDrawerToggle) this.this$0).mDrawerLayout;
                    int drawerLockMode = drawerLayout.getDrawerLockMode(8388611);
                    View findDrawerWithGravity = drawerLayout.findDrawerWithGravity(8388611);
                    if (findDrawerWithGravity != null) {
                        z = DrawerLayout.isDrawerVisible(findDrawerWithGravity);
                    } else {
                        z = false;
                    }
                    if (z && drawerLockMode != 2) {
                        drawerLayout.closeDrawer$2();
                        return;
                    } else if (drawerLockMode != 1) {
                        View findDrawerWithGravity2 = drawerLayout.findDrawerWithGravity(8388611);
                        if (findDrawerWithGravity2 != null) {
                            drawerLayout.openDrawer(findDrawerWithGravity2);
                            return;
                        }
                        throw new IllegalArgumentException("No drawer view found with gravity " + DrawerLayout.gravityToString(8388611));
                    } else {
                        return;
                    }
                case 2:
                    AlertController alertController = (AlertController) this.this$0;
                    if (view == alertController.mButtonPositive && (message4 = alertController.mButtonPositiveMessage) != null) {
                        message = Message.obtain(message4);
                    } else if (view == alertController.mButtonNegative && (message3 = alertController.mButtonNegativeMessage) != null) {
                        message = Message.obtain(message3);
                    } else if (view != alertController.mButtonNeutral || (message2 = alertController.mButtonNeutralMessage) == null) {
                        message = null;
                    } else {
                        message = Message.obtain(message2);
                    }
                    if (message != null) {
                        message.sendToTarget();
                    }
                    alertController.mHandler.obtainMessage(1, alertController.mDialog).sendToTarget();
                    return;
                case 3:
                    ((ActionMode) this.this$0).finish();
                    return;
                case 4:
                    MaterialCalendar materialCalendar = (MaterialCalendar) this.this$0;
                    int i = materialCalendar.calendarSelector;
                    if (i == 2) {
                        materialCalendar.setSelector$1(1);
                        materialCalendar.recyclerView.announceForAccessibility(materialCalendar.getString(C0130R.string.mtrl_picker_toggled_to_day_selection));
                        return;
                    } else if (i == 1) {
                        materialCalendar.setSelector$1(2);
                        materialCalendar.yearSelector.announceForAccessibility(materialCalendar.getString(C0130R.string.mtrl_picker_toggled_to_year_selection));
                        return;
                    } else {
                        return;
                    }
                default:
                    NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
                    NavigationMenuPresenter navigationMenuPresenter = (NavigationMenuPresenter) this.this$0;
                    NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter = navigationMenuPresenter.adapter;
                    boolean z2 = true;
                    if (navigationMenuAdapter != null) {
                        navigationMenuAdapter.updateSuspended = true;
                    }
                    MenuItemImpl itemData = navigationMenuItemView.getItemData();
                    boolean performItemAction = navigationMenuPresenter.menu.performItemAction(itemData, navigationMenuPresenter, 0);
                    if (itemData == null || !itemData.isCheckable() || !performItemAction) {
                        z2 = false;
                    } else {
                        navigationMenuPresenter.adapter.setCheckedItem(itemData);
                    }
                    NavigationMenuPresenter.NavigationMenuAdapter navigationMenuAdapter2 = navigationMenuPresenter.adapter;
                    if (navigationMenuAdapter2 != null) {
                        navigationMenuAdapter2.updateSuspended = false;
                    }
                    if (z2) {
                        navigationMenuPresenter.updateMenuView();
                        return;
                    }
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api33Impl {
        public static OnBackInvokedDispatcher findOnBackInvokedDispatcher(View view) {
            return view.findOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback newOnBackInvokedCallback(Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new Toolbar$Api33Impl$$ExternalSyntheticLambda0(0, runnable);
        }

        public static void tryRegisterOnBackInvokedCallback(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        public static void tryUnregisterOnBackInvokedCallback(Object obj, Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* loaded from: classes.dex */
    public final class ExpandedActionViewMenuPresenter implements MenuPresenter {
        public MenuItemImpl mCurrentExpandedItem;
        public MenuBuilder mMenu;

        public ExpandedActionViewMenuPresenter() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean collapseItemActionView(MenuItemImpl menuItemImpl) {
            Toolbar toolbar = Toolbar.this;
            View view = toolbar.mExpandedActionView;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewCollapsed();
            }
            toolbar.removeView(toolbar.mExpandedActionView);
            toolbar.removeView(toolbar.mCollapseButtonView);
            toolbar.mExpandedActionView = null;
            ArrayList arrayList = toolbar.mHiddenViews;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                toolbar.addView((View) arrayList.get(size));
            }
            arrayList.clear();
            this.mCurrentExpandedItem = null;
            toolbar.requestLayout();
            menuItemImpl.mIsActionViewExpanded = false;
            menuItemImpl.mMenu.onItemsChanged(false);
            toolbar.updateBackInvokedCallbackState();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean expandItemActionView(MenuItemImpl menuItemImpl) {
            Toolbar toolbar = Toolbar.this;
            toolbar.ensureCollapseButtonView();
            ViewParent parent = toolbar.mCollapseButtonView.getParent();
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.mCollapseButtonView);
                }
                toolbar.addView(toolbar.mCollapseButtonView);
            }
            View actionView = menuItemImpl.getActionView();
            toolbar.mExpandedActionView = actionView;
            this.mCurrentExpandedItem = menuItemImpl;
            ViewParent parent2 = actionView.getParent();
            if (parent2 != toolbar) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar.mExpandedActionView);
                }
                LayoutParams generateDefaultLayoutParams = Toolbar.generateDefaultLayoutParams();
                generateDefaultLayoutParams.gravity = (toolbar.mButtonGravity & 112) | 8388611;
                generateDefaultLayoutParams.mViewType = 2;
                toolbar.mExpandedActionView.setLayoutParams(generateDefaultLayoutParams);
                toolbar.addView(toolbar.mExpandedActionView);
            }
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (!(((LayoutParams) childAt.getLayoutParams()).mViewType == 2 || childAt == toolbar.mMenuView)) {
                    toolbar.removeViewAt(childCount);
                    toolbar.mHiddenViews.add(childAt);
                }
            }
            toolbar.requestLayout();
            menuItemImpl.mIsActionViewExpanded = true;
            menuItemImpl.mMenu.onItemsChanged(false);
            View view = toolbar.mExpandedActionView;
            if (view instanceof CollapsibleActionView) {
                ((CollapsibleActionView) view).onActionViewExpanded();
            }
            toolbar.updateBackInvokedCallbackState();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final void initForMenu(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.mMenu;
            if (!(menuBuilder2 == null || (menuItemImpl = this.mCurrentExpandedItem) == null)) {
                menuBuilder2.collapseItemActionView(menuItemImpl);
            }
            this.mMenu = menuBuilder;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
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
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final void updateMenuView() {
            if (this.mCurrentExpandedItem != null) {
                MenuBuilder menuBuilder = this.mMenu;
                if (menuBuilder != null) {
                    int size = menuBuilder.mItems.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mMenu.getItem(i) == this.mCurrentExpandedItem) {
                            return;
                        }
                    }
                }
                collapseItemActionView(this.mCurrentExpandedItem);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnMenuItemClickListener {
    }

    /* loaded from: classes.dex */
    public final class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AbsSavedState.C00522(2);
        public int expandedMenuItemId;
        public boolean isOverflowOpen;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            boolean z;
            this.expandedMenuItemId = parcel.readInt();
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.isOverflowOpen = z;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.expandedMenuItemId);
            parcel.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    public static int getHorizontalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public static int getVerticalMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void addCustomViewsWithGravity(ArrayList arrayList, int i) {
        boolean z;
        if (getLayoutDirection() == 1) {
            z = true;
        } else {
            z = false;
        }
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (z) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mViewType == 0 && shouldLayout(childAt)) {
                    int i3 = layoutParams.gravity;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i3, layoutDirection) & 7;
                    if (!(absoluteGravity2 == 1 || absoluteGravity2 == 3 || absoluteGravity2 == 5)) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.mViewType == 0 && shouldLayout(childAt2)) {
                int i5 = layoutParams2.gravity;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i5, layoutDirection2) & 7;
                if (!(absoluteGravity3 == 1 || absoluteGravity3 == 3 || absoluteGravity3 == 5)) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // androidx.core.view.MenuHost
    public final void addMenuProvider(MenuProvider menuProvider) {
        MenuHostHelper menuHostHelper = this.mMenuHostHelper;
        menuHostHelper.mMenuProviders.add(menuProvider);
        menuHostHelper.mOnInvalidateMenuCallback.run();
    }

    public final void addSystemView(View view, boolean z) {
        LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams2)) {
            layoutParams = generateLayoutParams(layoutParams2);
        } else {
            layoutParams = (LayoutParams) layoutParams2;
        }
        layoutParams.mViewType = 1;
        if (!z || this.mExpandedActionView == null) {
            addView(view, layoutParams);
            return;
        }
        view.setLayoutParams(layoutParams);
        this.mHiddenViews.add(view);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!super.checkLayoutParams(layoutParams) || !(layoutParams instanceof LayoutParams)) {
            return false;
        }
        return true;
    }

    public final void ensureCollapseButtonView() {
        if (this.mCollapseButtonView == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, C0130R.attr.toolbarNavigationButtonStyle);
            this.mCollapseButtonView = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.mCollapseIcon);
            this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388611;
            generateDefaultLayoutParams.mViewType = 2;
            this.mCollapseButtonView.setLayoutParams(generateDefaultLayoutParams);
            this.mCollapseButtonView.setOnClickListener(new View$OnClickListenerC00394(0, this));
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.RtlSpacingHelper, java.lang.Object] */
    public final void ensureContentInsets() {
        if (this.mContentInsets == null) {
            ?? obj = new Object();
            obj.mLeft = 0;
            obj.mRight = 0;
            obj.mStart = Integer.MIN_VALUE;
            obj.mEnd = Integer.MIN_VALUE;
            obj.mExplicitLeft = 0;
            obj.mExplicitRight = 0;
            obj.mIsRtl = false;
            obj.mIsRelative = false;
            this.mContentInsets = obj;
        }
    }

    public final void ensureMenu() {
        ensureMenuView();
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView.mMenu == null) {
            MenuBuilder menuBuilder = (MenuBuilder) actionMenuView.getMenu();
            if (this.mExpandedMenuPresenter == null) {
                this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter();
            }
            this.mMenuView.setExpandedActionViewsExclusive(true);
            menuBuilder.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
            updateBackInvokedCallbackState();
        }
    }

    public final void ensureMenuView() {
        if (this.mMenuView == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.mMenuView = actionMenuView;
            actionMenuView.setPopupTheme(this.mPopupTheme);
            this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
            ActionMenuView actionMenuView2 = this.mMenuView;
            zzcn zzcnVar = this.mActionMenuPresenterCallback;
            C00381 r2 = new C00381();
            actionMenuView2.mActionMenuPresenterCallback = zzcnVar;
            actionMenuView2.mMenuBuilderCallback = r2;
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388613;
            this.mMenuView.setLayoutParams(generateDefaultLayoutParams);
            addSystemView(this.mMenuView, false);
        }
    }

    public final void ensureNavButtonView() {
        if (this.mNavButtonView == null) {
            this.mNavButtonView = new AppCompatImageButton(getContext(), null, C0130R.attr.toolbarNavigationButtonStyle);
            LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.gravity = (this.mButtonGravity & 112) | 8388611;
            this.mNavButtonView.setLayoutParams(generateDefaultLayoutParams);
        }
    }

    public final int getChildTop(int i, View view) {
        int i2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        if (i > 0) {
            i2 = (measuredHeight - i) / 2;
        } else {
            i2 = 0;
        }
        int i3 = layoutParams.gravity & 112;
        if (!(i3 == 16 || i3 == 48 || i3 == 80)) {
            i3 = this.mGravity & 112;
        }
        if (i3 == 48) {
            return getPaddingTop() - i2;
        }
        if (i3 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (i4 < i5) {
            i4 = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i6 < i7) {
                i4 = Math.max(0, i4 - (i7 - i6));
            }
        }
        return paddingTop + i4;
    }

    public CharSequence getCollapseContentDescription() {
        AppCompatImageButton appCompatImageButton = this.mCollapseButtonView;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        AppCompatImageButton appCompatImageButton = this.mCollapseButtonView;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper == null) {
            return 0;
        }
        if (rtlSpacingHelper.mIsRtl) {
            return rtlSpacingHelper.mLeft;
        }
        return rtlSpacingHelper.mRight;
    }

    public int getContentInsetEndWithActions() {
        int i = this.mContentInsetEndWithActions;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.mLeft;
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.mRight;
        }
        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        if (rtlSpacingHelper == null) {
            return 0;
        }
        if (rtlSpacingHelper.mIsRtl) {
            return rtlSpacingHelper.mRight;
        }
        return rtlSpacingHelper.mLeft;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.mContentInsetStartWithNavigation;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder menuBuilder;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null || (menuBuilder = actionMenuView.mMenu) == null || !menuBuilder.hasVisibleItems()) {
            return getContentInsetEnd();
        }
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    }

    public int getCurrentContentInsetLeft() {
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (getLayoutDirection() == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView appCompatImageView = this.mLogoView;
        if (appCompatImageView != null) {
            return appCompatImageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView appCompatImageView = this.mLogoView;
        if (appCompatImageView != null) {
            return appCompatImageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    public View getNavButtonView() {
        return this.mNavButtonView;
    }

    public CharSequence getNavigationContentDescription() {
        AppCompatImageButton appCompatImageButton = this.mNavButtonView;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        AppCompatImageButton appCompatImageButton = this.mNavButtonView;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.mPopupContext;
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    public final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    public final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    public DecorToolbar getWrapper() {
        if (this.mWrapper == null) {
            this.mWrapper = new ToolbarWidgetWrapper(this, true);
        }
        return this.mWrapper;
    }

    public final void invalidateMenu() {
        ArrayList arrayList = this.mProvidedMenuItems;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            getMenu().removeItem(((MenuItem) obj).getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = this.mMenuHostHelper.mMenuProviders.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).onCreateMenu(menu, menuInflater);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.mProvidedMenuItems = currentMenuItems2;
    }

    public final boolean isChildOrHidden(View view) {
        if (view.getParent() == this || this.mHiddenViews.contains(view)) {
            return true;
        }
        return false;
    }

    public final boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null || (actionMenuPresenter = actionMenuView.mPresenter) == null || !actionMenuPresenter.isOverflowMenuShowing()) {
            return false;
        }
        return true;
    }

    public final int layoutChildLeft(View view, int i, int i2, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int childTop = getChildTop(i2, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, childTop, max + measuredWidth, view.getMeasuredHeight() + childTop);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + max;
    }

    public final int layoutChildRight(View view, int i, int i2, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int childTop = getChildTop(i2, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, childTop, max, view.getMeasuredHeight() + childTop);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    public final int measureChildCollapseMargins(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void measureChildConstrained(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateBackInvokedCallbackState();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
        updateBackInvokedCallbackState();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.mEatingHover = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x028f A[LOOP:0: B:102:0x028d->B:103:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02a7 A[LOOP:1: B:105:0x02a5->B:106:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02c6 A[LOOP:2: B:108:0x02c4->B:109:0x02c6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0319 A[LOOP:3: B:116:0x0317->B:117:0x0319, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0218  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        int i5;
        int i6;
        int i7;
        int max;
        boolean shouldLayout;
        boolean shouldLayout2;
        boolean z3;
        int i8;
        int size;
        int i9;
        int i10;
        int size2;
        int i11;
        int size3;
        int i12;
        int i13;
        int i14;
        int size4;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        boolean z4;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        if (getLayoutDirection() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i23 = width - paddingRight;
        int[] iArr = this.mTempMargins;
        iArr[1] = 0;
        iArr[0] = 0;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        int minimumHeight = getMinimumHeight();
        if (minimumHeight >= 0) {
            i5 = Math.min(minimumHeight, i4 - i2);
        } else {
            i5 = 0;
        }
        if (!shouldLayout(this.mNavButtonView)) {
            i7 = paddingLeft;
        } else if (z2) {
            i6 = layoutChildRight(this.mNavButtonView, i23, i5, iArr);
            i7 = paddingLeft;
            if (shouldLayout(this.mCollapseButtonView)) {
                if (z2) {
                    i6 = layoutChildRight(this.mCollapseButtonView, i6, i5, iArr);
                } else {
                    i7 = layoutChildLeft(this.mCollapseButtonView, i7, i5, iArr);
                }
            }
            if (shouldLayout(this.mMenuView)) {
                if (z2) {
                    i7 = layoutChildLeft(this.mMenuView, i7, i5, iArr);
                } else {
                    i6 = layoutChildRight(this.mMenuView, i6, i5, iArr);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i7);
            iArr[1] = Math.max(0, currentContentInsetRight - (i23 - i6));
            max = Math.max(i7, currentContentInsetLeft);
            int min = Math.min(i6, i23 - currentContentInsetRight);
            if (shouldLayout(this.mExpandedActionView)) {
                if (z2) {
                    min = layoutChildRight(this.mExpandedActionView, min, i5, iArr);
                } else {
                    max = layoutChildLeft(this.mExpandedActionView, max, i5, iArr);
                }
            }
            if (shouldLayout(this.mLogoView)) {
                if (z2) {
                    min = layoutChildRight(this.mLogoView, min, i5, iArr);
                } else {
                    max = layoutChildLeft(this.mLogoView, max, i5, iArr);
                }
            }
            shouldLayout = shouldLayout(this.mTitleTextView);
            shouldLayout2 = shouldLayout(this.mSubtitleTextView);
            if (!shouldLayout) {
                LayoutParams layoutParams = (LayoutParams) this.mTitleTextView.getLayoutParams();
                z3 = z2;
                i8 = this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            } else {
                z3 = z2;
                i8 = 0;
            }
            if (!shouldLayout2) {
                LayoutParams layoutParams2 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
                int i24 = i8;
                i8 = this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + i24;
            }
            if (!shouldLayout || shouldLayout2) {
                if (!shouldLayout) {
                    appCompatTextView = this.mTitleTextView;
                } else {
                    appCompatTextView = this.mSubtitleTextView;
                }
                if (!shouldLayout2) {
                    appCompatTextView2 = this.mSubtitleTextView;
                } else {
                    appCompatTextView2 = this.mTitleTextView;
                }
                LayoutParams layoutParams3 = (LayoutParams) appCompatTextView.getLayoutParams();
                LayoutParams layoutParams4 = (LayoutParams) appCompatTextView2.getLayoutParams();
                int i25 = i8;
                if ((shouldLayout || this.mTitleTextView.getMeasuredWidth() <= 0) && (!shouldLayout2 || this.mSubtitleTextView.getMeasuredWidth() <= 0)) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                i15 = this.mGravity & 112;
                int i26 = max;
                if (i15 != 48) {
                    i16 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + this.mTitleMarginTop;
                } else if (i15 != 80) {
                    int i27 = (((height - paddingTop) - paddingBottom) - i25) / 2;
                    int i28 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + this.mTitleMarginTop;
                    if (i27 < i28) {
                        i27 = i28;
                    } else {
                        int i29 = (((height - paddingBottom) - i25) - i27) - paddingTop;
                        int i30 = ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                        int i31 = this.mTitleMarginBottom;
                        if (i29 < i30 + i31) {
                            i27 = Math.max(0, i27 - ((((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin + i31) - i29));
                        }
                    }
                    i16 = paddingTop + i27;
                } else {
                    i16 = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin) - this.mTitleMarginBottom) - i25;
                }
                if (!z3) {
                    if (z4) {
                        i20 = this.mTitleMarginStart;
                    } else {
                        i20 = 0;
                    }
                    int i32 = i20 - iArr[1];
                    min -= Math.max(0, i32);
                    iArr[1] = Math.max(0, -i32);
                    if (shouldLayout) {
                        int measuredWidth = min - this.mTitleTextView.getMeasuredWidth();
                        int measuredHeight = this.mTitleTextView.getMeasuredHeight() + i16;
                        this.mTitleTextView.layout(measuredWidth, i16, min, measuredHeight);
                        i21 = measuredWidth - this.mTitleMarginEnd;
                        i16 = measuredHeight + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mTitleTextView.getLayoutParams())).bottomMargin;
                    } else {
                        i21 = min;
                    }
                    if (shouldLayout2) {
                        int i33 = i16 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
                        this.mSubtitleTextView.layout(min - this.mSubtitleTextView.getMeasuredWidth(), i33, min, this.mSubtitleTextView.getMeasuredHeight() + i33);
                        i22 = min - this.mTitleMarginEnd;
                    } else {
                        i22 = min;
                    }
                    if (z4) {
                        min = Math.min(i21, i22);
                    }
                    max = i26;
                } else {
                    if (z4) {
                        i17 = this.mTitleMarginStart;
                    } else {
                        i17 = 0;
                    }
                    int i34 = i17 - iArr[0];
                    max = Math.max(0, i34) + i26;
                    iArr[0] = Math.max(0, -i34);
                    if (shouldLayout) {
                        int measuredWidth2 = this.mTitleTextView.getMeasuredWidth() + max;
                        int measuredHeight2 = this.mTitleTextView.getMeasuredHeight() + i16;
                        this.mTitleTextView.layout(max, i16, measuredWidth2, measuredHeight2);
                        i18 = measuredWidth2 + this.mTitleMarginEnd;
                        i16 = measuredHeight2 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mTitleTextView.getLayoutParams())).bottomMargin;
                    } else {
                        i18 = max;
                    }
                    if (shouldLayout2) {
                        int i35 = i16 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
                        int measuredWidth3 = this.mSubtitleTextView.getMeasuredWidth() + max;
                        this.mSubtitleTextView.layout(max, i35, measuredWidth3, this.mSubtitleTextView.getMeasuredHeight() + i35);
                        i19 = measuredWidth3 + this.mTitleMarginEnd;
                    } else {
                        i19 = max;
                    }
                    if (z4) {
                        max = Math.max(i18, i19);
                    }
                }
            }
            ArrayList arrayList = this.mTempViews;
            addCustomViewsWithGravity(arrayList, 3);
            size = arrayList.size();
            i9 = max;
            for (i10 = 0; i10 < size; i10++) {
                i9 = layoutChildLeft((View) arrayList.get(i10), i9, i5, iArr);
            }
            addCustomViewsWithGravity(arrayList, 5);
            size2 = arrayList.size();
            for (i11 = 0; i11 < size2; i11++) {
                min = layoutChildRight((View) arrayList.get(i11), min, i5, iArr);
            }
            addCustomViewsWithGravity(arrayList, 1);
            int i36 = iArr[0];
            int i37 = iArr[1];
            size3 = arrayList.size();
            int i38 = i36;
            i12 = 0;
            int i39 = 0;
            while (i12 < size3) {
                View view = (View) arrayList.get(i12);
                LayoutParams layoutParams5 = (LayoutParams) view.getLayoutParams();
                int i40 = i37;
                int i41 = ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin - i38;
                int i42 = ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin - i40;
                int max2 = Math.max(0, i41);
                int max3 = Math.max(0, i42);
                int max4 = Math.max(0, -i41);
                int max5 = Math.max(0, -i42);
                i39 += view.getMeasuredWidth() + max2 + max3;
                i12++;
                i38 = max4;
                i37 = max5;
            }
            i14 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i39 / 2);
            int i43 = i39 + i14;
            if (i14 >= i9) {
                if (i43 > min) {
                    i9 = i14 - (i43 - min);
                } else {
                    i9 = i14;
                }
            }
            size4 = arrayList.size();
            for (i13 = 0; i13 < size4; i13++) {
                i9 = layoutChildLeft((View) arrayList.get(i13), i9, i5, iArr);
            }
            arrayList.clear();
        } else {
            i7 = layoutChildLeft(this.mNavButtonView, paddingLeft, i5, iArr);
        }
        i6 = i23;
        if (shouldLayout(this.mCollapseButtonView)) {
        }
        if (shouldLayout(this.mMenuView)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i7);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i23 - i6));
        max = Math.max(i7, currentContentInsetLeft2);
        int min2 = Math.min(i6, i23 - currentContentInsetRight2);
        if (shouldLayout(this.mExpandedActionView)) {
        }
        if (shouldLayout(this.mLogoView)) {
        }
        shouldLayout = shouldLayout(this.mTitleTextView);
        shouldLayout2 = shouldLayout(this.mSubtitleTextView);
        if (!shouldLayout) {
        }
        if (!shouldLayout2) {
        }
        if (!shouldLayout) {
        }
        if (!shouldLayout) {
        }
        if (!shouldLayout2) {
        }
        LayoutParams layoutParams32 = (LayoutParams) appCompatTextView.getLayoutParams();
        LayoutParams layoutParams42 = (LayoutParams) appCompatTextView2.getLayoutParams();
        int i252 = i8;
        if (shouldLayout) {
        }
        z4 = false;
        i15 = this.mGravity & 112;
        int i262 = max;
        if (i15 != 48) {
        }
        if (!z3) {
        }
        ArrayList arrayList2 = this.mTempViews;
        addCustomViewsWithGravity(arrayList2, 3);
        size = arrayList2.size();
        i9 = max;
        while (i10 < size) {
        }
        addCustomViewsWithGravity(arrayList2, 5);
        size2 = arrayList2.size();
        while (i11 < size2) {
        }
        addCustomViewsWithGravity(arrayList2, 1);
        int i362 = iArr[0];
        int i372 = iArr[1];
        size3 = arrayList2.size();
        int i382 = i362;
        i12 = 0;
        int i392 = 0;
        while (i12 < size3) {
        }
        i14 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i392 / 2);
        int i432 = i392 + i14;
        if (i14 >= i9) {
        }
        size4 = arrayList2.size();
        while (i13 < size4) {
        }
        arrayList2.clear();
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        char c;
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z = ViewUtils.sInitComputeFitSystemWindowsMethod;
        int i10 = 0;
        if (getLayoutDirection() == 1) {
            c2 = 1;
            c = 0;
        } else {
            c2 = 0;
            c = 1;
        }
        if (shouldLayout(this.mNavButtonView)) {
            measureChildConstrained(this.mNavButtonView, i, 0, i2, this.mMaxButtonHeight);
            i5 = getHorizontalMargins(this.mNavButtonView) + this.mNavButtonView.getMeasuredWidth();
            i4 = Math.max(0, getVerticalMargins(this.mNavButtonView) + this.mNavButtonView.getMeasuredHeight());
            i3 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        if (shouldLayout(this.mCollapseButtonView)) {
            measureChildConstrained(this.mCollapseButtonView, i, 0, i2, this.mMaxButtonHeight);
            i5 = getHorizontalMargins(this.mCollapseButtonView) + this.mCollapseButtonView.getMeasuredWidth();
            i4 = Math.max(i4, getVerticalMargins(this.mCollapseButtonView) + this.mCollapseButtonView.getMeasuredHeight());
            i3 = View.combineMeasuredStates(i3, this.mCollapseButtonView.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i5);
        int max2 = Math.max(0, currentContentInsetStart - i5);
        char c3 = c2;
        int[] iArr = this.mTempMargins;
        iArr[c3] = max2;
        if (shouldLayout(this.mMenuView)) {
            measureChildConstrained(this.mMenuView, i, max, i2, this.mMaxButtonHeight);
            i6 = getHorizontalMargins(this.mMenuView) + this.mMenuView.getMeasuredWidth();
            i4 = Math.max(i4, getVerticalMargins(this.mMenuView) + this.mMenuView.getMeasuredHeight());
            i3 = View.combineMeasuredStates(i3, this.mMenuView.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c] = Math.max(0, currentContentInsetEnd - i6);
        if (shouldLayout(this.mExpandedActionView)) {
            max3 += measureChildCollapseMargins(this.mExpandedActionView, i, max3, i2, 0, iArr);
            i4 = Math.max(i4, getVerticalMargins(this.mExpandedActionView) + this.mExpandedActionView.getMeasuredHeight());
            i3 = View.combineMeasuredStates(i3, this.mExpandedActionView.getMeasuredState());
        }
        if (shouldLayout(this.mLogoView)) {
            max3 += measureChildCollapseMargins(this.mLogoView, i, max3, i2, 0, iArr);
            i4 = Math.max(i4, getVerticalMargins(this.mLogoView) + this.mLogoView.getMeasuredHeight());
            i3 = View.combineMeasuredStates(i3, this.mLogoView.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((LayoutParams) childAt.getLayoutParams()).mViewType != 0 || !shouldLayout(childAt)) {
                max3 = max3;
            } else {
                max3 += measureChildCollapseMargins(childAt, i, max3, i2, 0, iArr);
                int max4 = Math.max(i4, getVerticalMargins(childAt) + childAt.getMeasuredHeight());
                i3 = View.combineMeasuredStates(i3, childAt.getMeasuredState());
                i4 = max4;
            }
        }
        int i12 = max3;
        int i13 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int i14 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView)) {
            measureChildCollapseMargins(this.mTitleTextView, i, i12 + i14, i2, i13, iArr);
            int horizontalMargins = getHorizontalMargins(this.mTitleTextView) + this.mTitleTextView.getMeasuredWidth();
            i8 = getVerticalMargins(this.mTitleTextView) + this.mTitleTextView.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i3, this.mTitleTextView.getMeasuredState());
            i9 = horizontalMargins;
        } else {
            i7 = i3;
            i9 = 0;
            i8 = 0;
        }
        if (shouldLayout(this.mSubtitleTextView)) {
            i9 = Math.max(i9, measureChildCollapseMargins(this.mSubtitleTextView, i, i12 + i14, i2, i13 + i8, iArr));
            i8 += getVerticalMargins(this.mSubtitleTextView) + this.mSubtitleTextView.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i7, this.mSubtitleTextView.getMeasuredState());
        }
        int max5 = Math.max(i4, i8);
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max5;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + i12 + i9, getSuggestedMinimumWidth()), i, (-16777216) & i7);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, i7 << 16);
        if (this.mCollapsible) {
            int childCount2 = getChildCount();
            for (int i15 = 0; i15 < childCount2; i15++) {
                View childAt2 = getChildAt(i15);
                if (!shouldLayout(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i10);
        }
        i10 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuBuilder menuBuilder;
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.mSuperState);
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            menuBuilder = actionMenuView.mMenu;
        } else {
            menuBuilder = null;
        }
        int i = savedState.expandedMenuItemId;
        if (!(i == 0 || this.mExpandedMenuPresenter == null || menuBuilder == null || (findItem = menuBuilder.findItem(i)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.isOverflowOpen) {
            zzab zzabVar = this.mShowOverflowMenuRunnable;
            removeCallbacks(zzabVar);
            post(zzabVar);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        if (z != rtlSpacingHelper.mIsRtl) {
            rtlSpacingHelper.mIsRtl = z;
            if (!rtlSpacingHelper.mIsRelative) {
                rtlSpacingHelper.mLeft = rtlSpacingHelper.mExplicitLeft;
                rtlSpacingHelper.mRight = rtlSpacingHelper.mExplicitRight;
            } else if (z) {
                int i2 = rtlSpacingHelper.mEnd;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = rtlSpacingHelper.mExplicitLeft;
                }
                rtlSpacingHelper.mLeft = i2;
                int i3 = rtlSpacingHelper.mStart;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = rtlSpacingHelper.mExplicitRight;
                }
                rtlSpacingHelper.mRight = i3;
            } else {
                int i4 = rtlSpacingHelper.mStart;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = rtlSpacingHelper.mExplicitLeft;
                }
                rtlSpacingHelper.mLeft = i4;
                int i5 = rtlSpacingHelper.mEnd;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = rtlSpacingHelper.mExplicitRight;
                }
                rtlSpacingHelper.mRight = i5;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.os.Parcelable, androidx.customview.view.AbsSavedState, androidx.appcompat.widget.Toolbar$SavedState] */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        MenuItemImpl menuItemImpl;
        ?? absSavedState = new AbsSavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
        if (!(expandedActionViewMenuPresenter == null || (menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem) == null)) {
            absSavedState.expandedMenuItemId = menuItemImpl.mId;
        }
        absSavedState.isOverflowOpen = isOverflowMenuShowing();
        return absSavedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.mEatingTouch = false;
        return true;
    }

    @Override // androidx.core.view.MenuHost
    public final void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.removeMenuProvider(menuProvider);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.mBackInvokedCallbackEnabled != z) {
            this.mBackInvokedCallbackEnabled = z;
            updateBackInvokedCallbackState();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(BundleKt.getDrawable(getContext(), i));
    }

    public void setCollapsible(boolean z) {
        this.mCollapsible = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.mContentInsetEndWithActions) {
            this.mContentInsetEndWithActions = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.mContentInsetStartWithNavigation) {
            this.mContentInsetStartWithNavigation = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(BundleKt.getDrawable(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(BundleKt.getDrawable(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.mPopupTheme != i) {
            this.mPopupTheme = i;
            if (i == 0) {
                this.mPopupContext = getContext();
            } else {
                this.mPopupContext = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.mTitleMarginBottom = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.mTitleMarginEnd = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.mTitleMarginStart = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.mTitleMarginTop = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public final boolean shouldLayout(View view) {
        if (view == null || view.getParent() != this || view.getVisibility() == 8) {
            return false;
        }
        return true;
    }

    public final boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView == null || (actionMenuPresenter = actionMenuView.mPresenter) == null || !actionMenuPresenter.showOverflowMenu()) {
            return false;
        }
        return true;
    }

    public final void updateBackInvokedCallbackState() {
        boolean z;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher findOnBackInvokedDispatcher = Api33Impl.findOnBackInvokedDispatcher(this);
            ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mExpandedMenuPresenter;
            if (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null || findOnBackInvokedDispatcher == null || !isAttachedToWindow() || !this.mBackInvokedCallbackEnabled) {
                z = false;
            } else {
                z = true;
            }
            if (z && this.mBackInvokedDispatcher == null) {
                if (this.mBackInvokedCallback == null) {
                    this.mBackInvokedCallback = Api33Impl.newOnBackInvokedCallback(new Toolbar$$ExternalSyntheticLambda0(this, 0));
                }
                Api33Impl.tryRegisterOnBackInvokedCallback(findOnBackInvokedDispatcher, this.mBackInvokedCallback);
                this.mBackInvokedDispatcher = findOnBackInvokedDispatcher;
            } else if (!z && (onBackInvokedDispatcher = this.mBackInvokedDispatcher) != null) {
                Api33Impl.tryUnregisterOnBackInvokedCallback(onBackInvokedDispatcher, this.mBackInvokedCallback);
                this.mBackInvokedDispatcher = null;
            }
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, C0130R.attr.toolbarStyle);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new MenuHostHelper(new Toolbar$$ExternalSyntheticLambda0(this, 1));
        this.mProvidedMenuItems = new ArrayList();
        this.mMenuViewItemClickListener = new C00381();
        this.mShowOverflowMenuRunnable = new zzab(4, this);
        Context context2 = getContext();
        int[] iArr = R$styleable.Toolbar;
        MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(context2, attributeSet, iArr, C0130R.attr.toolbarStyle);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, (TypedArray) obtainStyledAttributes.input, C0130R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) obtainStyledAttributes.input;
        this.mTitleTextAppearance = typedArray.getResourceId(28, 0);
        this.mSubtitleTextAppearance = typedArray.getResourceId(19, 0);
        this.mGravity = typedArray.getInteger(0, 8388627);
        this.mButtonGravity = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.mTitleMarginBottom = dimensionPixelOffset;
        this.mTitleMarginTop = dimensionPixelOffset;
        this.mTitleMarginEnd = dimensionPixelOffset;
        this.mTitleMarginStart = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.mTitleMarginStart = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.mTitleMarginEnd = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.mTitleMarginTop = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.mTitleMarginBottom = dimensionPixelOffset5;
        }
        this.mMaxButtonHeight = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        ensureContentInsets();
        RtlSpacingHelper rtlSpacingHelper = this.mContentInsets;
        rtlSpacingHelper.mIsRelative = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            rtlSpacingHelper.mExplicitLeft = dimensionPixelSize;
            rtlSpacingHelper.mLeft = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            rtlSpacingHelper.mExplicitRight = dimensionPixelSize2;
            rtlSpacingHelper.mRight = dimensionPixelSize2;
        }
        if (!(dimensionPixelOffset6 == Integer.MIN_VALUE && dimensionPixelOffset7 == Integer.MIN_VALUE)) {
            rtlSpacingHelper.setRelative(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.mContentInsetStartWithNavigation = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.mCollapseIcon = obtainStyledAttributes.getDrawable(4);
        this.mCollapseDescription = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.mPopupContext = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(16);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(11);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(obtainStyledAttributes.getColorStateList(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(obtainStyledAttributes.getColorStateList(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.Toolbar$LayoutParams, android.view.ViewGroup$MarginLayoutParams] */
    public static LayoutParams generateDefaultLayoutParams() {
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.mViewType = 0;
        marginLayoutParams.gravity = 8388627;
        return marginLayoutParams;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.Toolbar$LayoutParams, android.view.ViewGroup$LayoutParams, android.view.ViewGroup$MarginLayoutParams] */
    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ?? marginLayoutParams = new ViewGroup.MarginLayoutParams(context, attributeSet);
        marginLayoutParams.gravity = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
        marginLayoutParams.gravity = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        marginLayoutParams.mViewType = 0;
        return marginLayoutParams;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureCollapseButtonView();
        }
        AppCompatImageButton appCompatImageButton = this.mCollapseButtonView;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            ensureCollapseButtonView();
            this.mCollapseButtonView.setImageDrawable(drawable);
            return;
        }
        AppCompatImageButton appCompatImageButton = this.mCollapseButtonView;
        if (appCompatImageButton != null) {
            appCompatImageButton.setImageDrawable(this.mCollapseIcon);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.mLogoView == null) {
                this.mLogoView = new AppCompatImageView(getContext(), null, 0);
            }
            if (!isChildOrHidden(this.mLogoView)) {
                addSystemView(this.mLogoView, true);
            }
        } else {
            AppCompatImageView appCompatImageView = this.mLogoView;
            if (appCompatImageView != null && isChildOrHidden(appCompatImageView)) {
                removeView(this.mLogoView);
                this.mHiddenViews.remove(this.mLogoView);
            }
        }
        AppCompatImageView appCompatImageView2 = this.mLogoView;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.mLogoView == null) {
            this.mLogoView = new AppCompatImageView(getContext(), null, 0);
        }
        AppCompatImageView appCompatImageView = this.mLogoView;
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            ensureNavButtonView();
        }
        AppCompatImageButton appCompatImageButton = this.mNavButtonView;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
            BundleKt.setTooltipText(this.mNavButtonView, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            ensureNavButtonView();
            if (!isChildOrHidden(this.mNavButtonView)) {
                addSystemView(this.mNavButtonView, true);
            }
        } else {
            AppCompatImageButton appCompatImageButton = this.mNavButtonView;
            if (appCompatImageButton != null && isChildOrHidden(appCompatImageButton)) {
                removeView(this.mNavButtonView);
                this.mHiddenViews.remove(this.mNavButtonView);
            }
        }
        AppCompatImageButton appCompatImageButton2 = this.mNavButtonView;
        if (appCompatImageButton2 != null) {
            appCompatImageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mSubtitleTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context, null);
                this.mSubtitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mSubtitleTextAppearance;
                if (i != 0) {
                    this.mSubtitleTextView.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.mSubtitleTextColor;
                if (colorStateList != null) {
                    this.mSubtitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mSubtitleTextView)) {
                addSystemView(this.mSubtitleTextView, true);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.mSubtitleTextView;
            if (appCompatTextView2 != null && isChildOrHidden(appCompatTextView2)) {
                removeView(this.mSubtitleTextView);
                this.mHiddenViews.remove(this.mSubtitleTextView);
            }
        }
        AppCompatTextView appCompatTextView3 = this.mSubtitleTextView;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.mSubtitleText = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.mSubtitleTextColor = colorStateList;
        AppCompatTextView appCompatTextView = this.mSubtitleTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.mTitleTextView == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView = new AppCompatTextView(context, null);
                this.mTitleTextView = appCompatTextView;
                appCompatTextView.setSingleLine();
                this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.mTitleTextAppearance;
                if (i != 0) {
                    this.mTitleTextView.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.mTitleTextColor;
                if (colorStateList != null) {
                    this.mTitleTextView.setTextColor(colorStateList);
                }
            }
            if (!isChildOrHidden(this.mTitleTextView)) {
                addSystemView(this.mTitleTextView, true);
            }
        } else {
            AppCompatTextView appCompatTextView2 = this.mTitleTextView;
            if (appCompatTextView2 != null && isChildOrHidden(appCompatTextView2)) {
                removeView(this.mTitleTextView);
                this.mHiddenViews.remove(this.mTitleTextView);
            }
        }
        AppCompatTextView appCompatTextView3 = this.mTitleTextView;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.mTitleText = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.mTitleTextColor = colorStateList;
        AppCompatTextView appCompatTextView = this.mTitleTextView;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    /* loaded from: classes.dex */
    public final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public int mViewType;

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = 0;
            this.gravity = layoutParams.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = 0;
        }
    }

    public static LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof LayoutParams;
        if (z) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(layoutParams2);
            layoutParams3.mViewType = 0;
            layoutParams3.mViewType = layoutParams2.mViewType;
            return layoutParams3;
        } else if (z) {
            LayoutParams layoutParams4 = new LayoutParams((LayoutParams) layoutParams);
            layoutParams4.mViewType = 0;
            return layoutParams4;
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            LayoutParams layoutParams5 = new LayoutParams(marginLayoutParams);
            layoutParams5.mViewType = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = marginLayoutParams.bottomMargin;
            return layoutParams5;
        } else {
            LayoutParams layoutParams6 = new LayoutParams(layoutParams);
            layoutParams6.mViewType = 0;
            return layoutParams6;
        }
    }
}
