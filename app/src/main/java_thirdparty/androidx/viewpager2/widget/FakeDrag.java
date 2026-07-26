package androidx.viewpager2.widget;

import android.content.ClipDescription;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MenuProvider;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.inputmethod.InputContentInfoCompat$InputContentInfoCompatApi25Impl;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.navigation.Navigation;
import androidx.profileinstaller.ProfileInstallReceiver;
import androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback;
import androidx.viewpager2.widget.FakeDrag;
import com.android.billingclient.api.zzcl;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.SnackbarManager;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.WeakHashMap;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.MatcherMatchResult;
/* loaded from: classes.dex */
public class FakeDrag implements MenuItemHoverListener, MenuPresenter.Callback, MenuBuilder.Callback, AppCompatTextView.SuperCaller, OnApplyWindowInsetsListener, DifferentialMotionFlingTarget, AccessibilityViewCommand, ViewModelProvider.Factory, ProfileInstaller$DiagnosticsCallback, Factory, MaterialButton.OnPressedChangeListener {
    public final /* synthetic */ int $r8$classId;
    public Object mScrollEventAdapter;

    public /* synthetic */ FakeDrag(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public /* synthetic */ ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
        ViewModel create;
        create = create(RangesKt.getJavaClass(classReference), mutableCreationExtras);
        return create;
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        return null;
    }

    public AccessibilityNodeInfoCompat findFocus(int i) {
        return null;
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new MatcherMatchResult((Context) ((SnackbarManager) this.mScrollEventAdapter).lock, new Object(), new Object(), 15);
    }

    @Override // androidx.core.view.DifferentialMotionFlingTarget
    public float getScaledScrollFactor() {
        return -((NestedScrollView) this.mScrollEventAdapter).getVerticalScrollFactorCompat();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        boolean z;
        WindowInsetsCompat windowInsetsCompat2;
        int i = 0;
        boolean z2 = true;
        switch (this.$r8$classId) {
            case 8:
                WindowInsetsCompat.Impl impl = windowInsetsCompat.mImpl;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.mScrollEventAdapter;
                if (!Objects.equals(coordinatorLayout.mLastInsets, windowInsetsCompat)) {
                    coordinatorLayout.mLastInsets = windowInsetsCompat;
                    if (windowInsetsCompat.getSystemWindowInsetTop() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    coordinatorLayout.mDrawStatusBarBackground = z;
                    if (z || coordinatorLayout.getBackground() != null) {
                        z2 = false;
                    }
                    coordinatorLayout.setWillNotDraw(z2);
                    if (!impl.isConsumed()) {
                        int childCount = coordinatorLayout.getChildCount();
                        while (i < childCount) {
                            View childAt = coordinatorLayout.getChildAt(i);
                            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                            if (!childAt.getFitsSystemWindows() || ((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).mBehavior == null || !impl.isConsumed()) {
                                i++;
                            }
                        }
                    }
                    coordinatorLayout.requestLayout();
                }
                return windowInsetsCompat;
            default:
                AppBarLayout appBarLayout = (AppBarLayout) this.mScrollEventAdapter;
                if (appBarLayout.getFitsSystemWindows()) {
                    windowInsetsCompat2 = windowInsetsCompat;
                } else {
                    windowInsetsCompat2 = null;
                }
                if (!Objects.equals(appBarLayout.lastInsets, windowInsetsCompat2)) {
                    appBarLayout.lastInsets = windowInsetsCompat2;
                    if (appBarLayout.statusBarForeground != null && appBarLayout.getTopInset() > 0) {
                        i = 1;
                    }
                    appBarLayout.setWillNotDraw(i ^ 1);
                    appBarLayout.requestLayout();
                }
                return windowInsetsCompat;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder instanceof SubMenuBuilder) {
            ((SubMenuBuilder) menuBuilder).mParentMenu.getRootMenu().close(false);
        }
        MenuPresenter.Callback callback = ((ActionMenuPresenter) this.mScrollEventAdapter).mCallback;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onDiagnosticReceived() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
        CascadingMenuPopup cascadingMenuPopup = (CascadingMenuPopup) this.mScrollEventAdapter;
        Handler handler = cascadingMenuPopup.mSubMenuHoverHandler;
        final CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo = null;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = cascadingMenuPopup.mShowingMenus;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == ((CascadingMenuPopup.CascadingMenuInfo) arrayList.get(i)).menu) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            int i2 = i + 1;
            if (i2 < arrayList.size()) {
                cascadingMenuInfo = (CascadingMenuPopup.CascadingMenuInfo) arrayList.get(i2);
            }
            handler.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup$3$1
                @Override // java.lang.Runnable
                public final void run() {
                    CascadingMenuPopup cascadingMenuPopup2 = (CascadingMenuPopup) FakeDrag.this.mScrollEventAdapter;
                    CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo2 = cascadingMenuInfo;
                    if (cascadingMenuInfo2 != null) {
                        cascadingMenuPopup2.mShouldCloseImmediately = true;
                        cascadingMenuInfo2.menu.close(false);
                        cascadingMenuPopup2.mShouldCloseImmediately = false;
                    }
                    MenuItemImpl menuItemImpl2 = menuItemImpl;
                    if (menuItemImpl2.isEnabled() && menuItemImpl2.hasSubMenu()) {
                        menuBuilder.performItemAction(menuItemImpl2, null, 4);
                    }
                }
            }, menuBuilder, SystemClock.uptimeMillis() + 200);
        }
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        ((CascadingMenuPopup) this.mScrollEventAdapter).mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        boolean z;
        ActionMenuView.OnMenuItemClickListener onMenuItemClickListener = ((ActionMenuView) this.mScrollEventAdapter).mOnMenuItemClickListener;
        if (onMenuItemClickListener != null) {
            Toolbar toolbar = Toolbar.this;
            Iterator it = toolbar.mMenuHostHelper.mMenuProviders.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((MenuProvider) it.next()).onMenuItemSelected(menuItem)) {
                        z = true;
                        break;
                    }
                } else {
                    Toolbar.OnMenuItemClickListener onMenuItemClickListener2 = toolbar.mOnMenuItemClickListener;
                    if (onMenuItemClickListener2 != null) {
                        z = ToolbarActionBar.this.mWindowCallback.onMenuItemSelected(0, menuItem);
                    } else {
                        z = false;
                    }
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder menuBuilder) {
        MenuBuilder.Callback callback = ((ActionMenuView) this.mScrollEventAdapter).mMenuBuilderCallback;
        if (callback != null) {
            callback.onMenuModeChange(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        ActionMenuPresenter actionMenuPresenter = (ActionMenuPresenter) this.mScrollEventAdapter;
        if (menuBuilder == actionMenuPresenter.mMenu) {
            return false;
        }
        actionMenuPresenter.mOpenSubMenuId = ((SubMenuBuilder) menuBuilder).mItem.mId;
        MenuPresenter.Callback callback = actionMenuPresenter.mCallback;
        if (callback != null) {
            return callback.onOpenSubMenu(menuBuilder);
        }
        return false;
    }

    @Override // androidx.profileinstaller.ProfileInstaller$DiagnosticsCallback
    public void onResultReceived(int i, Object obj) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) obj);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.mScrollEventAdapter).setResultCode(i);
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view) {
        int i;
        switch (this.$r8$classId) {
            case 14:
                DrawerLayout drawerLayout = (DrawerLayout) this.mScrollEventAdapter;
                if (!DrawerLayout.isDrawerOpen(view) || drawerLayout.getDrawerLockMode(view) == 2) {
                    return false;
                }
                drawerLayout.closeDrawer(view, true);
                return true;
            default:
                SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.mScrollEventAdapter;
                boolean z = false;
                if (!swipeDismissBehavior.canSwipeDismissView(view)) {
                    return false;
                }
                if (view.getLayoutDirection() == 1) {
                    z = true;
                }
                int i2 = swipeDismissBehavior.swipeDirection;
                if ((i2 != 0 || !z) && (i2 != 1 || z)) {
                    i = view.getWidth();
                } else {
                    i = -view.getWidth();
                }
                ViewCompat.offsetLeftAndRight(i, view);
                view.setAlpha(0.0f);
                return true;
        }
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        return false;
    }

    @Override // androidx.core.view.DifferentialMotionFlingTarget
    public boolean startDifferentialMotionFling(float f) {
        if (f == 0.0f) {
            return false;
        }
        stopDifferentialMotionFling();
        ((NestedScrollView) this.mScrollEventAdapter).fling((int) f);
        return true;
    }

    @Override // androidx.core.view.DifferentialMotionFlingTarget
    public void stopDifferentialMotionFling() {
        ((NestedScrollView) this.mScrollEventAdapter).mScroller.abortAnimation();
    }

    public /* synthetic */ FakeDrag(int i, Object obj) {
        this.$r8$classId = i;
        this.mScrollEventAdapter = obj;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public ViewModel create(Class cls) {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    public FakeDrag(ViewModelInitializer[] initializers) {
        this.$r8$classId = 18;
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        this.mScrollEventAdapter = initializers;
    }

    public FakeDrag(final TextView textView) {
        this.$r8$classId = 17;
        this.mScrollEventAdapter = new Navigation(textView) { // from class: androidx.emoji2.viewsintegration.EmojiTextViewHelper$SkippingHelper19
            public final EmojiTextViewHelper$HelperInternal19 mHelperDelegate;

            {
                this.mHelperDelegate = new EmojiTextViewHelper$HelperInternal19(textView);
            }

            @Override // androidx.navigation.Navigation
            public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
                boolean z;
                if (EmojiCompat.sInstance != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return inputFilterArr;
                }
                return this.mHelperDelegate.getFilters(inputFilterArr);
            }

            @Override // androidx.navigation.Navigation
            public final boolean isEnabled() {
                return this.mHelperDelegate.mEnabled;
            }

            @Override // androidx.navigation.Navigation
            public final void setAllCaps(boolean z) {
                boolean z2;
                if (EmojiCompat.sInstance != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    this.mHelperDelegate.setAllCaps(z);
                }
            }

            @Override // androidx.navigation.Navigation
            public final void setEnabled(boolean z) {
                boolean z2;
                EmojiTextViewHelper$HelperInternal19 emojiTextViewHelper$HelperInternal19 = this.mHelperDelegate;
                if (EmojiCompat.sInstance != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    emojiTextViewHelper$HelperInternal19.mEnabled = z;
                } else {
                    emojiTextViewHelper$HelperInternal19.setEnabled(z);
                }
            }

            @Override // androidx.navigation.Navigation
            public final TransformationMethod wrapTransformationMethod(TransformationMethod transformationMethod) {
                boolean z;
                if (EmojiCompat.sInstance != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    return transformationMethod;
                }
                return this.mHelperDelegate.wrapTransformationMethod(transformationMethod);
            }
        };
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        ViewModel viewModel;
        ViewModelInitializer viewModelInitializer;
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(cls);
        ViewModelInitializer[] viewModelInitializerArr = (ViewModelInitializer[]) this.mScrollEventAdapter;
        ViewModelInitializer[] initializers = (ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length);
        Intrinsics.checkNotNullParameter(initializers, "initializers");
        int length = initializers.length;
        int i = 0;
        while (true) {
            viewModel = null;
            if (i >= length) {
                viewModelInitializer = null;
                break;
            }
            viewModelInitializer = initializers[i];
            if (viewModelInitializer.clazz.equals(orCreateKotlinClass)) {
                break;
            }
            i++;
        }
        if (viewModelInitializer != null) {
            viewModel = (ViewModel) viewModelInitializer.initializer.invoke(mutableCreationExtras);
        }
        if (viewModel != null) {
            return viewModel;
        }
        throw new IllegalArgumentException(("No initializer set for given class " + Navigation.getCanonicalName(orCreateKotlinClass)).toString());
    }

    public FakeDrag(EditText editText) {
        this.$r8$classId = 16;
        this.mScrollEventAdapter = new zzcl(editText);
    }

    public FakeDrag() {
        this.$r8$classId = 11;
        if (Build.VERSION.SDK_INT >= 26) {
            this.mScrollEventAdapter = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19(this);
        } else {
            this.mScrollEventAdapter = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19(this);
        }
    }

    public FakeDrag(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.$r8$classId = 12;
        if (Build.VERSION.SDK_INT >= 25) {
            this.mScrollEventAdapter = new InputContentInfoCompat$InputContentInfoCompatApi25Impl(uri, clipDescription, uri2);
        } else {
            this.mScrollEventAdapter = new MatcherMatchResult(uri, clipDescription, uri2, 6);
        }
    }

    public void setFirstBaselineToTopHeight(int i) {
    }

    public void setLastBaselineToBottomHeight(int i) {
    }

    public void setLineHeight(int i, float f) {
    }
}
