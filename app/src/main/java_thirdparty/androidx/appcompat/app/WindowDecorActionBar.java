package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0;
import androidx.viewpager2.widget.FakeDrag;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {
    public static final AccelerateInterpolator sHideInterpolator = new AccelerateInterpolator();
    public static final DecelerateInterpolator sShowInterpolator = new DecelerateInterpolator();
    public ActionModeImpl mActionMode;
    public ActionBarContainer mContainerView;
    public final View mContentView;
    public Context mContext;
    public ActionBarContextView mContextView;
    public ViewPropertyAnimatorCompatSet mCurrentShowAnim;
    public DecorToolbar mDecorToolbar;
    public ActionModeImpl mDeferredDestroyActionMode;
    public zzcl mDeferredModeDestroyCallback;
    public boolean mDisplayHomeAsUpSet;
    public boolean mHiddenBySystem;
    public boolean mHideOnContentScroll;
    public boolean mLastMenuVisibility;
    public ActionBarOverlayLayout mOverlayLayout;
    public boolean mShowHideAnimationEnabled;
    public boolean mShowingForMode;
    public Context mThemedContext;
    public final ArrayList mMenuVisibilityListeners = new ArrayList();
    public int mCurWindowVisibility = 0;
    public boolean mContentAnimations = true;
    public boolean mNowShowing = true;
    public final AnonymousClass1 mHideListener = new AnonymousClass1(this, 0);
    public final AnonymousClass1 mShowListener = new AnonymousClass1(this, 1);
    public final FakeDrag mUpdateListener = new FakeDrag(2, this);

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends BundleKt {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ WindowDecorActionBar this$0;

        public /* synthetic */ AnonymousClass1(WindowDecorActionBar windowDecorActionBar, int i) {
            this.$r8$classId = i;
            this.this$0 = windowDecorActionBar;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            View view;
            int i = this.$r8$classId;
            WindowDecorActionBar windowDecorActionBar = this.this$0;
            switch (i) {
                case 0:
                    if (windowDecorActionBar.mContentAnimations && (view = windowDecorActionBar.mContentView) != null) {
                        view.setTranslationY(0.0f);
                        windowDecorActionBar.mContainerView.setTranslationY(0.0f);
                    }
                    windowDecorActionBar.mContainerView.setVisibility(8);
                    windowDecorActionBar.mContainerView.setTransitioning(false);
                    windowDecorActionBar.mCurrentShowAnim = null;
                    zzcl zzclVar = windowDecorActionBar.mDeferredModeDestroyCallback;
                    if (zzclVar != null) {
                        zzclVar.onDestroyActionMode(windowDecorActionBar.mDeferredDestroyActionMode);
                        windowDecorActionBar.mDeferredDestroyActionMode = null;
                        windowDecorActionBar.mDeferredModeDestroyCallback = null;
                    }
                    ActionBarOverlayLayout actionBarOverlayLayout = windowDecorActionBar.mOverlayLayout;
                    if (actionBarOverlayLayout != null) {
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api20Impl.requestApplyInsets(actionBarOverlayLayout);
                        return;
                    }
                    return;
                default:
                    windowDecorActionBar.mCurrentShowAnim = null;
                    windowDecorActionBar.mContainerView.requestLayout();
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {
        public final Context mActionModeContext;
        public zzcl mCallback;
        public WeakReference mCustomView;
        public final MenuBuilder mMenu;

        public ActionModeImpl(Context context, zzcl zzclVar) {
            this.mActionModeContext = context;
            this.mCallback = zzclVar;
            MenuBuilder menuBuilder = new MenuBuilder(context);
            menuBuilder.mDefaultShowAsAction = 1;
            this.mMenu = menuBuilder;
            menuBuilder.mCallback = this;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void finish() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.mActionMode == this) {
                if (windowDecorActionBar.mHiddenBySystem) {
                    windowDecorActionBar.mDeferredDestroyActionMode = this;
                    windowDecorActionBar.mDeferredModeDestroyCallback = this.mCallback;
                } else {
                    this.mCallback.onDestroyActionMode(this);
                }
                this.mCallback = null;
                windowDecorActionBar.animateToMode(false);
                ActionBarContextView actionBarContextView = windowDecorActionBar.mContextView;
                if (actionBarContextView.mClose == null) {
                    actionBarContextView.killMode();
                }
                windowDecorActionBar.mOverlayLayout.setHideOnContentScrollEnabled(windowDecorActionBar.mHideOnContentScroll);
                windowDecorActionBar.mActionMode = null;
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public final View getCustomView() {
            WeakReference weakReference = this.mCustomView;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final MenuBuilder getMenu() {
            return this.mMenu;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final MenuInflater getMenuInflater() {
            return new SupportMenuInflater(this.mActionModeContext);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final CharSequence getSubtitle() {
            return WindowDecorActionBar.this.mContextView.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final CharSequence getTitle() {
            return WindowDecorActionBar.this.mContextView.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void invalidate() {
            if (WindowDecorActionBar.this.mActionMode == this) {
                MenuBuilder menuBuilder = this.mMenu;
                menuBuilder.stopDispatchingItemsChanged();
                try {
                    this.mCallback.onPrepareActionMode(this, menuBuilder);
                } finally {
                    menuBuilder.startDispatchingItemsChanged();
                }
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public final boolean isTitleOptional() {
            return WindowDecorActionBar.this.mContextView.mTitleOptional;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            zzcl zzclVar = this.mCallback;
            if (zzclVar != null) {
                return ((ActionMode.Callback) zzclVar.zzb).onActionItemClicked(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.mCallback != null) {
                invalidate();
                ActionMenuPresenter actionMenuPresenter = WindowDecorActionBar.this.mContextView.mActionMenuPresenter;
                if (actionMenuPresenter != null) {
                    actionMenuPresenter.showOverflowMenu();
                }
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setCustomView(View view) {
            WindowDecorActionBar.this.mContextView.setCustomView(view);
            this.mCustomView = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setSubtitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setTitle(CharSequence charSequence) {
            WindowDecorActionBar.this.mContextView.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setTitleOptionalHint(boolean z) {
            this.mTitleOptionalHint = z;
            WindowDecorActionBar.this.mContextView.setTitleOptional(z);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setSubtitle(int i) {
            setSubtitle(WindowDecorActionBar.this.mContext.getResources().getString(i));
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void setTitle(int i) {
            setTitle(WindowDecorActionBar.this.mContext.getResources().getString(i));
        }
    }

    public WindowDecorActionBar(Activity activity, boolean z) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        init(decorView);
        if (!z) {
            this.mContentView = decorView.findViewById(16908290);
        }
    }

    public final void animateToMode(boolean z) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2;
        long j;
        if (z) {
            if (!this.mShowingForMode) {
                this.mShowingForMode = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                updateVisibility(false);
            }
        } else if (this.mShowingForMode) {
            this.mShowingForMode = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            updateVisibility(false);
        }
        if (this.mContainerView.isLaidOut()) {
            if (z) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
                viewPropertyAnimatorCompat2 = ViewCompat.animate(toolbarWidgetWrapper.mToolbar);
                viewPropertyAnimatorCompat2.alpha(0.0f);
                viewPropertyAnimatorCompat2.setDuration(100L);
                viewPropertyAnimatorCompat2.setListener(new ToolbarWidgetWrapper.AnonymousClass2(toolbarWidgetWrapper, 4));
                viewPropertyAnimatorCompat = this.mContextView.setupAnimatorToVisibility(0, 200L);
            } else {
                ToolbarWidgetWrapper toolbarWidgetWrapper2 = (ToolbarWidgetWrapper) this.mDecorToolbar;
                ViewPropertyAnimatorCompat animate = ViewCompat.animate(toolbarWidgetWrapper2.mToolbar);
                animate.alpha(1.0f);
                animate.setDuration(200L);
                animate.setListener(new ToolbarWidgetWrapper.AnonymousClass2(toolbarWidgetWrapper2, 0));
                viewPropertyAnimatorCompat2 = this.mContextView.setupAnimatorToVisibility(8, 100L);
                viewPropertyAnimatorCompat = animate;
            }
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
            ArrayList arrayList = viewPropertyAnimatorCompatSet.mAnimators;
            arrayList.add(viewPropertyAnimatorCompat2);
            View view = (View) viewPropertyAnimatorCompat2.mView.get();
            if (view != null) {
                j = view.animate().getDuration();
            } else {
                j = 0;
            }
            View view2 = (View) viewPropertyAnimatorCompat.mView.get();
            if (view2 != null) {
                view2.animate().setStartDelay(j);
            }
            arrayList.add(viewPropertyAnimatorCompat);
            viewPropertyAnimatorCompatSet.start();
        } else if (z) {
            ((ToolbarWidgetWrapper) this.mDecorToolbar).mToolbar.setVisibility(4);
            this.mContextView.setVisibility(0);
        } else {
            ((ToolbarWidgetWrapper) this.mDecorToolbar).mToolbar.setVisibility(0);
            this.mContextView.setVisibility(8);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean collapseActionView() {
        Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter;
        MenuItemImpl menuItemImpl;
        DecorToolbar decorToolbar = this.mDecorToolbar;
        if (decorToolbar == null || (expandedActionViewMenuPresenter = ((ToolbarWidgetWrapper) decorToolbar).mToolbar.mExpandedMenuPresenter) == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null) {
            return false;
        }
        Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter2 = ((ToolbarWidgetWrapper) decorToolbar).mToolbar.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter2 == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = expandedActionViewMenuPresenter2.mCurrentExpandedItem;
        }
        if (menuItemImpl == null) {
            return true;
        }
        menuItemImpl.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void dispatchMenuVisibilityChanged(boolean z) {
        if (z != this.mLastMenuVisibility) {
            this.mLastMenuVisibility = z;
            ArrayList arrayList = this.mMenuVisibilityListeners;
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                throw new ClassCastException();
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int getDisplayOptions() {
        return ((ToolbarWidgetWrapper) this.mDecorToolbar).mDisplayOpts;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final Context getThemedContext() {
        if (this.mThemedContext == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.mThemedContext = new ContextThemeWrapper(this.mContext, i);
            } else {
                this.mThemedContext = this.mContext;
            }
        }
        return this.mThemedContext;
    }

    public final void init(View view) {
        DecorToolbar decorToolbar;
        boolean z;
        String str;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R.id.decor_content_parent);
        this.mOverlayLayout = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(R.id.action_bar);
        if (findViewById instanceof DecorToolbar) {
            decorToolbar = (DecorToolbar) findViewById;
        } else if (findViewById instanceof Toolbar) {
            decorToolbar = ((Toolbar) findViewById).getWrapper();
        } else {
            if (findViewById != null) {
                str = findViewById.getClass().getSimpleName();
            } else {
                str = "null";
            }
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(str));
        }
        this.mDecorToolbar = decorToolbar;
        this.mContextView = (ActionBarContextView) view.findViewById(R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R.id.action_bar_container);
        this.mContainerView = actionBarContainer;
        DecorToolbar decorToolbar2 = this.mDecorToolbar;
        if (decorToolbar2 == null || this.mContextView == null || actionBarContainer == null) {
            throw new IllegalStateException("WindowDecorActionBar can only be used with a compatible window decor layout");
        }
        Context context = ((ToolbarWidgetWrapper) decorToolbar2).mToolbar.getContext();
        this.mContext = context;
        if ((((ToolbarWidgetWrapper) this.mDecorToolbar).mDisplayOpts & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.mDisplayHomeAsUpSet = true;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        this.mDecorToolbar.getClass();
        setHasEmbeddedTabs(context.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(null, R$styleable.ActionBar, R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.mOverlayLayout;
            if (actionBarOverlayLayout2.mOverlayMode) {
                this.mHideOnContentScroll = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.mContainerView;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            ViewCompat.Api21Impl.setElevation(actionBarContainer2, dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void onConfigurationChanged() {
        setHasEmbeddedTabs(this.mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl == null || (menuBuilder = actionModeImpl.mMenu) == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() == 1) {
            z = false;
        }
        menuBuilder.setQwertyMode(z);
        return menuBuilder.performShortcut(i, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDefaultDisplayHomeAsUpEnabled(boolean z) {
        if (!this.mDisplayHomeAsUpSet) {
            setDisplayHomeAsUpEnabled(z);
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setDisplayHomeAsUpEnabled(boolean z) {
        int i;
        if (z) {
            i = 4;
        } else {
            i = 0;
        }
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        int i2 = toolbarWidgetWrapper.mDisplayOpts;
        this.mDisplayHomeAsUpSet = true;
        toolbarWidgetWrapper.setDisplayOptions((i & 4) | (i2 & (-5)));
    }

    public final void setHasEmbeddedTabs(boolean z) {
        if (!z) {
            ((ToolbarWidgetWrapper) this.mDecorToolbar).getClass();
            this.mContainerView.setTabContainer(null);
        } else {
            this.mContainerView.setTabContainer(null);
            ((ToolbarWidgetWrapper) this.mDecorToolbar).getClass();
        }
        this.mDecorToolbar.getClass();
        ((ToolbarWidgetWrapper) this.mDecorToolbar).mToolbar.setCollapsible(false);
        this.mOverlayLayout.setHasNonEmbeddedTabs(false);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setHomeActionContentDescription(int i) {
        ((ToolbarWidgetWrapper) this.mDecorToolbar).setNavigationContentDescription(i);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setHomeAsUpIndicator(Drawable drawable) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        toolbarWidgetWrapper.mNavIcon = drawable;
        Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
        if ((toolbarWidgetWrapper.mDisplayOpts & 4) != 0) {
            if (drawable == null) {
                drawable = toolbarWidgetWrapper.mDefaultNavigationIcon;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        toolbar.setNavigationIcon((Drawable) null);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setShowHideAnimationEnabled(boolean z) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mShowHideAnimationEnabled = z;
        if (!z && (viewPropertyAnimatorCompatSet = this.mCurrentShowAnim) != null) {
            viewPropertyAnimatorCompatSet.cancel();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setWindowTitle(CharSequence charSequence) {
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        if (!toolbarWidgetWrapper.mTitleSet) {
            Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
            toolbarWidgetWrapper.mTitle = charSequence;
            if ((toolbarWidgetWrapper.mDisplayOpts & 8) != 0) {
                toolbar.setTitle(charSequence);
                if (toolbarWidgetWrapper.mTitleSet) {
                    ViewCompat.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final ActionMode startActionMode(zzcl zzclVar) {
        ActionModeImpl actionModeImpl = this.mActionMode;
        if (actionModeImpl != null) {
            actionModeImpl.finish();
        }
        this.mOverlayLayout.setHideOnContentScrollEnabled(false);
        this.mContextView.killMode();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.mContextView.getContext(), zzclVar);
        MenuBuilder menuBuilder = actionModeImpl2.mMenu;
        menuBuilder.stopDispatchingItemsChanged();
        try {
            if (!((ActionMode.Callback) actionModeImpl2.mCallback.zzb).onCreateActionMode(actionModeImpl2, menuBuilder)) {
                return null;
            }
            this.mActionMode = actionModeImpl2;
            actionModeImpl2.invalidate();
            this.mContextView.initForMode(actionModeImpl2);
            animateToMode(true);
            return actionModeImpl2;
        } finally {
            menuBuilder.startDispatchingItemsChanged();
        }
    }

    public final void updateVisibility(boolean z) {
        int[] iArr;
        int[] iArr2;
        boolean z2 = this.mHiddenBySystem;
        boolean z3 = this.mShowingForMode;
        ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0 viewPropertyAnimatorCompat$$ExternalSyntheticLambda0 = null;
        FakeDrag fakeDrag = this.mUpdateListener;
        View view = this.mContentView;
        if (!z3 && z2) {
            if (this.mNowShowing) {
                this.mNowShowing = false;
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.mCurrentShowAnim;
                if (viewPropertyAnimatorCompatSet != null) {
                    viewPropertyAnimatorCompatSet.cancel();
                }
                int i = this.mCurWindowVisibility;
                AnonymousClass1 r1 = this.mHideListener;
                if (i != 0 || (!this.mShowHideAnimationEnabled && !z)) {
                    r1.onAnimationEnd();
                    return;
                }
                this.mContainerView.setAlpha(1.0f);
                this.mContainerView.setTransitioning(true);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
                float f = -this.mContainerView.getHeight();
                if (z) {
                    this.mContainerView.getLocationInWindow(new int[]{0, 0});
                    f -= iArr2[1];
                }
                ViewPropertyAnimatorCompat animate = ViewCompat.animate(this.mContainerView);
                animate.translationY(f);
                View view2 = (View) animate.mView.get();
                if (view2 != null) {
                    if (fakeDrag != null) {
                        viewPropertyAnimatorCompat$$ExternalSyntheticLambda0 = new ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(fakeDrag, view2);
                    }
                    view2.animate().setUpdateListener(viewPropertyAnimatorCompat$$ExternalSyntheticLambda0);
                }
                boolean z4 = viewPropertyAnimatorCompatSet2.mIsStarted;
                ArrayList arrayList = viewPropertyAnimatorCompatSet2.mAnimators;
                if (!z4) {
                    arrayList.add(animate);
                }
                if (this.mContentAnimations && view != null) {
                    ViewPropertyAnimatorCompat animate2 = ViewCompat.animate(view);
                    animate2.translationY(f);
                    if (!viewPropertyAnimatorCompatSet2.mIsStarted) {
                        arrayList.add(animate2);
                    }
                }
                boolean z5 = viewPropertyAnimatorCompatSet2.mIsStarted;
                if (!z5) {
                    viewPropertyAnimatorCompatSet2.mInterpolator = sHideInterpolator;
                }
                if (!z5) {
                    viewPropertyAnimatorCompatSet2.mDuration = 250L;
                }
                if (!z5) {
                    viewPropertyAnimatorCompatSet2.mListener = r1;
                }
                this.mCurrentShowAnim = viewPropertyAnimatorCompatSet2;
                viewPropertyAnimatorCompatSet2.start();
            }
        } else if (!this.mNowShowing) {
            this.mNowShowing = true;
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet3 = this.mCurrentShowAnim;
            if (viewPropertyAnimatorCompatSet3 != null) {
                viewPropertyAnimatorCompatSet3.cancel();
            }
            this.mContainerView.setVisibility(0);
            int i2 = this.mCurWindowVisibility;
            AnonymousClass1 r12 = this.mShowListener;
            if (i2 != 0 || (!this.mShowHideAnimationEnabled && !z)) {
                this.mContainerView.setAlpha(1.0f);
                this.mContainerView.setTranslationY(0.0f);
                if (this.mContentAnimations && view != null) {
                    view.setTranslationY(0.0f);
                }
                r12.onAnimationEnd();
            } else {
                this.mContainerView.setTranslationY(0.0f);
                float f2 = -this.mContainerView.getHeight();
                if (z) {
                    this.mContainerView.getLocationInWindow(new int[]{0, 0});
                    f2 -= iArr[1];
                }
                this.mContainerView.setTranslationY(f2);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet4 = new ViewPropertyAnimatorCompatSet();
                ViewPropertyAnimatorCompat animate3 = ViewCompat.animate(this.mContainerView);
                animate3.translationY(0.0f);
                View view3 = (View) animate3.mView.get();
                if (view3 != null) {
                    if (fakeDrag != null) {
                        viewPropertyAnimatorCompat$$ExternalSyntheticLambda0 = new ViewPropertyAnimatorCompat$$ExternalSyntheticLambda0(fakeDrag, view3);
                    }
                    view3.animate().setUpdateListener(viewPropertyAnimatorCompat$$ExternalSyntheticLambda0);
                }
                boolean z6 = viewPropertyAnimatorCompatSet4.mIsStarted;
                ArrayList arrayList2 = viewPropertyAnimatorCompatSet4.mAnimators;
                if (!z6) {
                    arrayList2.add(animate3);
                }
                if (this.mContentAnimations && view != null) {
                    view.setTranslationY(f2);
                    ViewPropertyAnimatorCompat animate4 = ViewCompat.animate(view);
                    animate4.translationY(0.0f);
                    if (!viewPropertyAnimatorCompatSet4.mIsStarted) {
                        arrayList2.add(animate4);
                    }
                }
                boolean z7 = viewPropertyAnimatorCompatSet4.mIsStarted;
                if (!z7) {
                    viewPropertyAnimatorCompatSet4.mInterpolator = sShowInterpolator;
                }
                if (!z7) {
                    viewPropertyAnimatorCompatSet4.mDuration = 250L;
                }
                if (!z7) {
                    viewPropertyAnimatorCompatSet4.mListener = r12;
                }
                this.mCurrentShowAnim = viewPropertyAnimatorCompatSet4;
                viewPropertyAnimatorCompatSet4.start();
            }
            ActionBarOverlayLayout actionBarOverlayLayout = this.mOverlayLayout;
            if (actionBarOverlayLayout != null) {
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ViewCompat.Api20Impl.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void setHomeAsUpIndicator() {
        ToolbarWidgetWrapper toolbarWidgetWrapper = (ToolbarWidgetWrapper) this.mDecorToolbar;
        Toolbar toolbar = toolbarWidgetWrapper.mToolbar;
        Drawable drawable = BundleKt.getDrawable(toolbar.getContext(), R.drawable.ic_close);
        toolbarWidgetWrapper.mNavIcon = drawable;
        if ((toolbarWidgetWrapper.mDisplayOpts & 4) != 0) {
            if (drawable == null) {
                drawable = toolbarWidgetWrapper.mDefaultNavigationIcon;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        toolbar.setNavigationIcon((Drawable) null);
    }

    public WindowDecorActionBar(Dialog dialog) {
        new ArrayList();
        init(dialog.getWindow().getDecorView());
    }
}
