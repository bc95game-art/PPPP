package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper$Api23Impl;
import androidx.appcompat.view.WindowCallbackWrapper$Api24Impl;
import androidx.appcompat.view.WindowCallbackWrapper$Api26Impl;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar$Api33Impl$$ExternalSyntheticLambda0;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.app.NavUtils;
import androidx.core.p002os.BundleKt;
import androidx.core.p002os.LocaleListCompat;
import androidx.core.p002os.LocaleListInterface;
import androidx.core.view.DifferentialMotionFlingController$$ExternalSyntheticLambda0;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.emoji2.text.MetadataRepo;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.android.billingclient.api.zzcl;
import com.emanuelef.remote_capture.Blacklists;
import com.emanuelef.remote_capture.C0130R;
import com.emanuelef.remote_capture.CaptureService;
import com.emanuelef.remote_capture.fragments.LogviewFragment;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.text.MatcherMatchResult;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public final class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public ActionBar mActionBar;
    public C00153 mActionMenuPresenterCallback;
    public ActionMode mActionMode;
    public PopupWindow mActionModePopup;
    public ActionBarContextView mActionModeView;
    public int mActivityHandlesConfigFlags;
    public boolean mActivityHandlesConfigFlagsChecked;
    public final Object mAppCompatCallback;
    public AppCompatViewInflater mAppCompatViewInflater;
    public AppCompatWindowCallback mAppCompatWindowCallback;
    public AutoTimeNightModeManager mAutoBatteryNightModeManager;
    public AutoTimeNightModeManager mAutoTimeNightModeManager;
    public OnBackInvokedCallback mBackCallback;
    public boolean mBaseContextAttached;
    public boolean mClosingActionMenu;
    public final Context mContext;
    public boolean mCreated;
    public DecorContentParent mDecorContentParent;
    public boolean mDestroyed;
    public OnBackInvokedDispatcher mDispatcher;
    public Configuration mEffectiveConfiguration;
    public boolean mEnableDefaultActionBarUp;
    public boolean mFeatureIndeterminateProgress;
    public boolean mFeatureProgress;
    public boolean mHasActionBar;
    public final Object mHost;
    public int mInvalidatePanelMenuFeatures;
    public boolean mInvalidatePanelMenuPosted;
    public boolean mIsFloating;
    public final int mLocalNightMode;
    public boolean mLongPressBackDown;
    public SupportMenuInflater mMenuInflater;
    public boolean mOverlayActionBar;
    public boolean mOverlayActionMode;
    public C00153 mPanelMenuPresenterCallback;
    public PanelFeatureState[] mPanels;
    public PanelFeatureState mPreparedPanel;
    public RunnableC00142 mShowActionModePopup;
    public View mStatusGuard;
    public ViewGroup mSubDecor;
    public boolean mSubDecorInstalled;
    public Rect mTempRect1;
    public Rect mTempRect2;
    public int mThemeResId;
    public CharSequence mTitle;
    public TextView mTitleView;
    public Window mWindow;
    public boolean mWindowNoTitle;
    public static final SimpleArrayMap sLocalNightModes = new SimpleArrayMap(0);
    public static final int[] sWindowBackgroundStyleable = {16842836};
    public static final boolean sCanReturnDifferentContext = !"robolectric".equals(Build.FINGERPRINT);
    public ViewPropertyAnimatorCompat mFadeAnim = null;
    public final RunnableC00142 mInvalidatePanelMenuRunnable = new RunnableC00142(this, 0);

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$2 */
    /* loaded from: classes.dex */
    public final class RunnableC00142 implements Runnable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        public /* synthetic */ RunnableC00142(AppCompatDelegateImpl appCompatDelegateImpl, int i) {
            this.$r8$classId = i;
            this.this$0 = appCompatDelegateImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup viewGroup;
            switch (this.$r8$classId) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                    if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1) != 0) {
                        appCompatDelegateImpl.doInvalidatePanelMenu(0);
                    }
                    if ((appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 4096) != 0) {
                        appCompatDelegateImpl.doInvalidatePanelMenu(108);
                    }
                    appCompatDelegateImpl.mInvalidatePanelMenuPosted = false;
                    appCompatDelegateImpl.mInvalidatePanelMenuFeatures = 0;
                    return;
                default:
                    AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
                    appCompatDelegateImpl2.mActionModePopup.showAtLocation(appCompatDelegateImpl2.mActionModeView, 55, 0, 0);
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl2.mFadeAnim;
                    if (viewPropertyAnimatorCompat != null) {
                        viewPropertyAnimatorCompat.cancel();
                    }
                    if (!appCompatDelegateImpl2.mSubDecorInstalled || (viewGroup = appCompatDelegateImpl2.mSubDecor) == null || !viewGroup.isLaidOut()) {
                        appCompatDelegateImpl2.mActionModeView.setAlpha(1.0f);
                        appCompatDelegateImpl2.mActionModeView.setVisibility(0);
                        return;
                    }
                    appCompatDelegateImpl2.mActionModeView.setAlpha(0.0f);
                    ViewPropertyAnimatorCompat animate = ViewCompat.animate(appCompatDelegateImpl2.mActionModeView);
                    animate.alpha(1.0f);
                    appCompatDelegateImpl2.mFadeAnim = animate;
                    animate.setListener(new C00167(1, this));
                    return;
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$3 */
    /* loaded from: classes.dex */
    public final class C00153 implements OnApplyWindowInsetsListener, ContentFrameLayout.OnAttachListener, ActionBarDrawerToggle.Delegate, MenuPresenter.Callback {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ AppCompatDelegateImpl this$0;

        public /* synthetic */ C00153(AppCompatDelegateImpl appCompatDelegateImpl, int i) {
            this.$r8$classId = i;
            this.this$0 = appCompatDelegateImpl;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.this$0.getActionBarThemedContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(this.this$0.getActionBarThemedContext(), null, new int[]{C0130R.attr.homeAsUpIndicator});
            Drawable drawable = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) {
                return false;
            }
            return true;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x0090
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:92)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public androidx.core.view.WindowInsetsCompat onApplyWindowInsets(android.view.View r19, androidx.core.view.WindowInsetsCompat r20) {
            /*
                Method dump skipped, instructions count: 415
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.C00153.onApplyWindowInsets(android.view.View, androidx.core.view.WindowInsetsCompat):androidx.core.view.WindowInsetsCompat");
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            boolean z2;
            int i;
            PanelFeatureState panelFeatureState;
            switch (this.$r8$classId) {
                case 3:
                    this.this$0.checkCloseActionMenu(menuBuilder);
                    return;
                default:
                    MenuBuilder rootMenu = menuBuilder.getRootMenu();
                    int i2 = 0;
                    if (rootMenu != menuBuilder) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        menuBuilder = rootMenu;
                    }
                    AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                    PanelFeatureState[] panelFeatureStateArr = appCompatDelegateImpl.mPanels;
                    if (panelFeatureStateArr != null) {
                        i = panelFeatureStateArr.length;
                    } else {
                        i = 0;
                    }
                    while (true) {
                        if (i2 >= i) {
                            panelFeatureState = null;
                        } else {
                            panelFeatureState = panelFeatureStateArr[i2];
                            if (panelFeatureState == null || panelFeatureState.menu != menuBuilder) {
                                i2++;
                            }
                        }
                    }
                    if (panelFeatureState == null) {
                        return;
                    }
                    if (z2) {
                        appCompatDelegateImpl.callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, rootMenu);
                        appCompatDelegateImpl.closePanel(panelFeatureState, true);
                        return;
                    }
                    appCompatDelegateImpl.closePanel(panelFeatureState, z);
                    return;
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            Window.Callback callback;
            switch (this.$r8$classId) {
                case 3:
                    Window.Callback callback2 = this.this$0.mWindow.getCallback();
                    if (callback2 == null) {
                        return true;
                    }
                    callback2.onMenuOpened(108, menuBuilder);
                    return true;
                default:
                    if (menuBuilder != menuBuilder.getRootMenu()) {
                        return true;
                    }
                    AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                    if (!appCompatDelegateImpl.mHasActionBar || (callback = appCompatDelegateImpl.mWindow.getCallback()) == null || appCompatDelegateImpl.mDestroyed) {
                        return true;
                    }
                    callback.onMenuOpened(108, menuBuilder);
                    return true;
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int i) {
            AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i);
            }
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(DrawerArrowDrawable drawerArrowDrawable, int i) {
            AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawerArrowDrawable);
                actionBar.setHomeActionContentDescription(i);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$7 */
    /* loaded from: classes.dex */
    public final class C00167 extends BundleKt {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ C00167(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            int i = this.$r8$classId;
            Object obj = this.this$0;
            switch (i) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) obj;
                    appCompatDelegateImpl.mActionModeView.setAlpha(1.0f);
                    appCompatDelegateImpl.mFadeAnim.setListener(null);
                    appCompatDelegateImpl.mFadeAnim = null;
                    return;
                case 1:
                    AppCompatDelegateImpl appCompatDelegateImpl2 = ((RunnableC00142) obj).this$0;
                    appCompatDelegateImpl2.mActionModeView.setAlpha(1.0f);
                    appCompatDelegateImpl2.mFadeAnim.setListener(null);
                    appCompatDelegateImpl2.mFadeAnim = null;
                    return;
                default:
                    AppCompatDelegateImpl appCompatDelegateImpl3 = (AppCompatDelegateImpl) ((zzcl) obj).zzc;
                    appCompatDelegateImpl3.mActionModeView.setVisibility(8);
                    PopupWindow popupWindow = appCompatDelegateImpl3.mActionModePopup;
                    if (popupWindow != null) {
                        popupWindow.dismiss();
                    } else if (appCompatDelegateImpl3.mActionModeView.getParent() instanceof View) {
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api20Impl.requestApplyInsets((View) appCompatDelegateImpl3.mActionModeView.getParent());
                    }
                    appCompatDelegateImpl3.mActionModeView.killMode();
                    appCompatDelegateImpl3.mFadeAnim.setListener(null);
                    appCompatDelegateImpl3.mFadeAnim = null;
                    ViewGroup viewGroup = appCompatDelegateImpl3.mSubDecor;
                    WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api20Impl.requestApplyInsets(viewGroup);
                    return;
            }
        }

        @Override // androidx.core.p002os.BundleKt, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart() {
            int i = this.$r8$classId;
            Object obj = this.this$0;
            switch (i) {
                case 0:
                    AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) obj;
                    appCompatDelegateImpl.mActionModeView.setVisibility(0);
                    if (appCompatDelegateImpl.mActionModeView.getParent() instanceof View) {
                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api20Impl.requestApplyInsets((View) appCompatDelegateImpl.mActionModeView.getParent());
                        return;
                    }
                    return;
                case 1:
                    ((RunnableC00142) obj).this$0.mActionModeView.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api21Impl {
        public static boolean isPowerSaveMode(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        public static String toLanguageTag(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api24Impl {
        public static void generateConfigDelta_locale(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }

        public static LocaleListCompat getLocales(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }

        public static void setDefaultLocales(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.mImpl.toLanguageTags()));
        }

        public static void setLocales(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.mImpl.toLanguageTags()));
        }
    }

    /* loaded from: classes.dex */
    public abstract class Api33Impl {
        public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        public static OnBackInvokedCallback registerOnBackPressedCallback(Object obj, AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            Toolbar$Api33Impl$$ExternalSyntheticLambda0 toolbar$Api33Impl$$ExternalSyntheticLambda0 = new Toolbar$Api33Impl$$ExternalSyntheticLambda0(2, appCompatDelegateImpl);
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m613m(obj).registerOnBackInvokedCallback(1000000, toolbar$Api33Impl$$ExternalSyntheticLambda0);
            return toolbar$Api33Impl$$ExternalSyntheticLambda0;
        }

        public static void unregisterOnBackInvokedCallback(Object obj, Object obj2) {
            DifferentialMotionFlingController$$ExternalSyntheticLambda0.m613m(obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* loaded from: classes.dex */
    public final class AppCompatWindowCallback implements Window.Callback {
        public ToolbarActionBar.C00172 mActionBarCallback;
        public boolean mDispatchKeyEventBypassEnabled;
        public boolean mOnContentChangedBypassEnabled;
        public boolean mOnPanelClosedBypassEnabled;
        public final Window.Callback mWrapped;

        public AppCompatWindowCallback(Window.Callback callback) {
            if (callback != null) {
                this.mWrapped = callback;
                return;
            }
            throw new IllegalArgumentException("Window callback may not be null");
        }

        public final void bypassOnContentChanged(Window.Callback callback) {
            try {
                this.mOnContentChangedBypassEnabled = true;
                callback.onContentChanged();
            } finally {
                this.mOnContentChangedBypassEnabled = false;
            }
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchGenericMotionEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            boolean z = this.mDispatchKeyEventBypassEnabled;
            Window.Callback callback = this.mWrapped;
            if (z) {
                return callback.dispatchKeyEvent(keyEvent);
            }
            if (AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || callback.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (!this.mWrapped.dispatchKeyShortcutEvent(keyEvent)) {
                int keyCode = keyEvent.getKeyCode();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar == null || !actionBar.onKeyShortcut(keyCode, keyEvent)) {
                    PanelFeatureState panelFeatureState = appCompatDelegateImpl.mPreparedPanel;
                    if (panelFeatureState == null || !appCompatDelegateImpl.performPanelShortcut(panelFeatureState, keyEvent.getKeyCode(), keyEvent)) {
                        if (appCompatDelegateImpl.mPreparedPanel == null) {
                            PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(0);
                            appCompatDelegateImpl.preparePanel(panelState, keyEvent);
                            boolean performPanelShortcut = appCompatDelegateImpl.performPanelShortcut(panelState, keyEvent.getKeyCode(), keyEvent);
                            panelState.isPrepared = false;
                            if (performPanelShortcut) {
                            }
                        }
                        return false;
                    }
                    PanelFeatureState panelFeatureState2 = appCompatDelegateImpl.mPreparedPanel;
                    if (panelFeatureState2 != null) {
                        panelFeatureState2.isHandled = true;
                        return true;
                    }
                }
            }
            return true;
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            return this.mWrapped.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            return this.mWrapped.dispatchTrackballEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeFinished(android.view.ActionMode actionMode) {
            this.mWrapped.onActionModeFinished(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onActionModeStarted(android.view.ActionMode actionMode) {
            this.mWrapped.onActionModeStarted(actionMode);
        }

        @Override // android.view.Window.Callback
        public final void onAttachedToWindow() {
            this.mWrapped.onAttachedToWindow();
        }

        @Override // android.view.Window.Callback
        public final void onContentChanged() {
            if (this.mOnContentChangedBypassEnabled) {
                this.mWrapped.onContentChanged();
            }
        }

        @Override // android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof MenuBuilder)) {
                return this.mWrapped.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public final View onCreatePanelView(int i) {
            View view;
            ToolbarActionBar.C00172 r0 = this.mActionBarCallback;
            if (r0 != null) {
                if (i == 0) {
                    view = new View(ToolbarActionBar.this.mDecorToolbar.mToolbar.getContext());
                } else {
                    view = null;
                }
                if (view != null) {
                    return view;
                }
            }
            return this.mWrapped.onCreatePanelView(i);
        }

        @Override // android.view.Window.Callback
        public final void onDetachedFromWindow() {
            this.mWrapped.onDetachedFromWindow();
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
            return this.mWrapped.onMenuItemSelected(i, menuItem);
        }

        @Override // android.view.Window.Callback
        public final boolean onMenuOpened(int i, Menu menu) {
            onMenuOpened$androidx$appcompat$view$WindowCallbackWrapper(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i == 108) {
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(true);
                }
            } else {
                appCompatDelegateImpl.getClass();
            }
            return true;
        }

        public final boolean onMenuOpened$androidx$appcompat$view$WindowCallbackWrapper(int i, Menu menu) {
            return this.mWrapped.onMenuOpened(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPanelClosed(int i, Menu menu) {
            if (this.mOnPanelClosedBypassEnabled) {
                this.mWrapped.onPanelClosed(i, menu);
                return;
            }
            onPanelClosed$androidx$appcompat$view$WindowCallbackWrapper(i, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i == 108) {
                appCompatDelegateImpl.initWindowDecorActionBar();
                ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                if (actionBar != null) {
                    actionBar.dispatchMenuVisibilityChanged(false);
                }
            } else if (i == 0) {
                PanelFeatureState panelState = appCompatDelegateImpl.getPanelState(i);
                if (panelState.isOpen) {
                    appCompatDelegateImpl.closePanel(panelState, false);
                }
            }
        }

        public final void onPanelClosed$androidx$appcompat$view$WindowCallbackWrapper(int i, Menu menu) {
            this.mWrapped.onPanelClosed(i, menu);
        }

        @Override // android.view.Window.Callback
        public final void onPointerCaptureChanged(boolean z) {
            WindowCallbackWrapper$Api26Impl.onPointerCaptureChanged(this.mWrapped, z);
        }

        @Override // android.view.Window.Callback
        public final boolean onPreparePanel(int i, View view, Menu menu) {
            MenuBuilder menuBuilder;
            if (menu instanceof MenuBuilder) {
                menuBuilder = (MenuBuilder) menu;
            } else {
                menuBuilder = null;
            }
            if (i == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = true;
            }
            ToolbarActionBar.C00172 r3 = this.mActionBarCallback;
            if (r3 != null && i == 0) {
                ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
                if (!toolbarActionBar.mToolbarMenuPrepared) {
                    toolbarActionBar.mDecorToolbar.mMenuPrepared = true;
                    toolbarActionBar.mToolbarMenuPrepared = true;
                }
            }
            boolean onPreparePanel = this.mWrapped.onPreparePanel(i, view, menu);
            if (menuBuilder != null) {
                menuBuilder.mOverrideVisibleItems = false;
            }
            return onPreparePanel;
        }

        @Override // android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
            MenuBuilder menuBuilder = AppCompatDelegateImpl.this.getPanelState(0).menu;
            if (menuBuilder != null) {
                m630x7817ce5b(list, menuBuilder, i);
            } else {
                m630x7817ce5b(list, menu, i);
            }
        }

        /* renamed from: onProvideKeyboardShortcuts$androidx$appcompat$view$WindowCallbackWrapper */
        public final void m630x7817ce5b(List list, Menu menu, int i) {
            WindowCallbackWrapper$Api24Impl.onProvideKeyboardShortcuts(this.mWrapped, list, menu, i);
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested(SearchEvent searchEvent) {
            return WindowCallbackWrapper$Api23Impl.onSearchRequested(this.mWrapped, searchEvent);
        }

        @Override // android.view.Window.Callback
        public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
            this.mWrapped.onWindowAttributesChanged(layoutParams);
        }

        @Override // android.view.Window.Callback
        public final void onWindowFocusChanged(boolean z) {
            this.mWrapped.onWindowFocusChanged(z);
        }

        @Override // android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (i != 0) {
                return WindowCallbackWrapper$Api23Impl.onWindowStartingActionMode(this.mWrapped, callback, i);
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            MetadataRepo metadataRepo = new MetadataRepo(appCompatDelegateImpl.mContext, callback);
            androidx.appcompat.view.ActionMode startSupportActionMode = appCompatDelegateImpl.startSupportActionMode(metadataRepo);
            if (startSupportActionMode != null) {
                return metadataRepo.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public final boolean onSearchRequested() {
            return this.mWrapped.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            MetadataRepo metadataRepo = new MetadataRepo(appCompatDelegateImpl.mContext, callback);
            androidx.appcompat.view.ActionMode startSupportActionMode = appCompatDelegateImpl.startSupportActionMode(metadataRepo);
            if (startSupportActionMode != null) {
                return metadataRepo.getActionModeWrapper(startSupportActionMode);
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public final class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(ContextThemeWrapper contextThemeWrapper) {
            super(contextThemeWrapper, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (AppCompatDelegateImpl.this.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                return true;
            }
            return false;
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.closePanel(appCompatDelegateImpl.getPanelState(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int i) {
            setBackgroundDrawable(BundleKt.getDrawable(getContext(), i));
        }
    }

    /* loaded from: classes.dex */
    public final class PanelFeatureState {
        public int background;
        public View createdPanelView;
        public ListMenuDecorView decorView;
        public int featureId;
        public Bundle frozenActionViewState;
        public int gravity;
        public boolean isHandled;
        public boolean isOpen;
        public boolean isPrepared;
        public ListMenuPresenter listMenuPresenter;
        public ContextThemeWrapper listPresenterContext;
        public MenuBuilder menu;
        public boolean refreshDecorView;
        public boolean refreshMenuContent;
        public View shownPanelView;
        public int windowAnimations;
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        AppCompatActivity appCompatActivity = null;
        this.mLocalNightMode = -100;
        this.mContext = context;
        this.mAppCompatCallback = appCompatCallback;
        this.mHost = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof AppCompatActivity)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        }
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        appCompatActivity = (AppCompatActivity) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (appCompatActivity != null) {
                this.mLocalNightMode = ((AppCompatDelegateImpl) appCompatActivity.getDelegate()).mLocalNightMode;
            }
        }
        if (this.mLocalNightMode == -100) {
            String name = this.mHost.getClass().getName();
            SimpleArrayMap simpleArrayMap = sLocalNightModes;
            Integer num = (Integer) simpleArrayMap.get(name);
            if (num != null) {
                this.mLocalNightMode = num.intValue();
                simpleArrayMap.remove(this.mHost.getClass().getName());
            }
        }
        if (window != null) {
            attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    public static LocaleListCompat calculateApplicationLocales(Context context) {
        LocaleListCompat localeListCompat;
        LocaleListCompat localeListCompat2;
        Locale locale;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || (localeListCompat = AppCompatDelegate.sRequestedAppLocales) == null) {
            return null;
        }
        LocaleListInterface localeListInterface = localeListCompat.mImpl;
        LocaleListCompat configurationLocales = getConfigurationLocales(context.getApplicationContext().getResources().getConfiguration());
        if (i >= 24) {
            if (localeListInterface.isEmpty()) {
                localeListCompat2 = LocaleListCompat.sEmptyLocaleList;
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                for (int i2 = 0; i2 < configurationLocales.mImpl.size() + localeListInterface.size(); i2++) {
                    if (i2 < localeListInterface.size()) {
                        locale = localeListInterface.get(i2);
                    } else {
                        locale = configurationLocales.mImpl.get(i2 - localeListInterface.size());
                    }
                    if (locale != null) {
                        linkedHashSet.add(locale);
                    }
                }
                localeListCompat2 = LocaleListCompat.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
            }
        } else if (localeListInterface.isEmpty()) {
            localeListCompat2 = LocaleListCompat.sEmptyLocaleList;
        } else {
            localeListCompat2 = LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(localeListInterface.get(0)));
        }
        if (localeListCompat2.mImpl.isEmpty()) {
            return configurationLocales;
        }
        return localeListCompat2;
    }

    public static Configuration createOverrideAppConfiguration(Context context, int i, LocaleListCompat localeListCompat, Configuration configuration, boolean z) {
        int i2;
        if (i == 1) {
            i2 = 16;
        } else if (i == 2) {
            i2 = 32;
        } else if (z) {
            i2 = 0;
        } else {
            i2 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (localeListCompat != null) {
            LocaleListInterface localeListInterface = localeListCompat.mImpl;
            if (Build.VERSION.SDK_INT >= 24) {
                Api24Impl.setLocales(configuration2, localeListCompat);
                return configuration2;
            }
            configuration2.setLocale(localeListInterface.get(0));
            configuration2.setLayoutDirection(localeListInterface.get(0));
        }
        return configuration2;
    }

    public static LocaleListCompat getConfigurationLocales(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.getLocales(configuration);
        }
        return LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(configuration.locale));
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x020f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0103 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean applyApplicationSpecificConfig(boolean z, boolean z2) {
        LocaleListCompat localeListCompat;
        int i;
        Configuration configuration;
        int i2;
        int i3;
        LocaleListCompat localeListCompat2;
        int i4;
        boolean z3;
        LocaleListCompat localeListCompat3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i5;
        Activity activity;
        boolean z7;
        NoSuchFieldException e;
        Field field;
        Map map;
        boolean z8;
        NoSuchFieldException e2;
        Field declaredField;
        Field field2;
        Object obj;
        Object obj2;
        Object obj3;
        Activity activity2;
        int i6;
        if (this.mDestroyed) {
            return false;
        }
        int i7 = this.mLocalNightMode;
        if (i7 == -100) {
            i7 = AppCompatDelegate.sDefaultNightMode;
        }
        Context context = this.mContext;
        int mapNightMode = mapNightMode(context, i7);
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 33) {
            localeListCompat = calculateApplicationLocales(context);
        } else {
            localeListCompat = null;
        }
        if (!z2 && localeListCompat != null) {
            localeListCompat = getConfigurationLocales(context.getResources().getConfiguration());
        }
        Configuration createOverrideAppConfiguration = createOverrideAppConfiguration(context, mapNightMode, localeListCompat, null, false);
        boolean z9 = this.mActivityHandlesConfigFlagsChecked;
        Object obj4 = this.mHost;
        if (!z9 && (obj4 instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                i = 0;
                configuration = this.mEffectiveConfiguration;
                if (configuration == null) {
                    configuration = context.getResources().getConfiguration();
                }
                i2 = configuration.uiMode & 48;
                i3 = createOverrideAppConfiguration.uiMode & 48;
                LocaleListCompat configurationLocales = getConfigurationLocales(configuration);
                if (localeListCompat != null) {
                    localeListCompat2 = null;
                } else {
                    localeListCompat2 = getConfigurationLocales(createOverrideAppConfiguration);
                }
                if (i2 == i3) {
                    i4 = LogviewFragment.MAX_LINES;
                } else {
                    i4 = 0;
                }
                if (localeListCompat2 != null && !configurationLocales.equals(localeListCompat2)) {
                    i4 |= 8196;
                }
                if (((~i) & i4) != 0 && z && this.mBaseContextAttached && ((sCanReturnDifferentContext || this.mCreated) && (obj4 instanceof Activity))) {
                    activity2 = (Activity) obj4;
                    if (!activity2.isChild()) {
                        int i9 = Build.VERSION.SDK_INT;
                        if (i9 >= 31 && (i4 & CaptureService.CONNECTIONS_LOG_SIZE) != 0) {
                            activity2.getWindow().getDecorView().setLayoutDirection(createOverrideAppConfiguration.getLayoutDirection());
                        }
                        if (i9 >= 28) {
                            activity2.recreate();
                        } else {
                            new Handler(activity2.getMainLooper()).post(new ActivityCompat$$ExternalSyntheticLambda0(0, activity2));
                        }
                        z3 = true;
                        if (!z3 || i4 == 0) {
                            localeListCompat3 = localeListCompat2;
                            z4 = z3;
                        } else {
                            if ((i & i4) == i4) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            Resources resources = context.getResources();
                            Configuration configuration2 = new Configuration(resources.getConfiguration());
                            configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i3;
                            if (localeListCompat2 != null) {
                                LocaleListInterface localeListInterface = localeListCompat2.mImpl;
                                if (Build.VERSION.SDK_INT >= 24) {
                                    Api24Impl.setLocales(configuration2, localeListCompat2);
                                } else {
                                    configuration2.setLocale(localeListInterface.get(0));
                                    configuration2.setLayoutDirection(localeListInterface.get(0));
                                }
                            }
                            resources.updateConfiguration(configuration2, null);
                            int i10 = Build.VERSION.SDK_INT;
                            if (i10 < 26 && i10 < 28) {
                                if (i10 >= 24) {
                                    if (!BundleKt.sResourcesImplFieldFetched) {
                                        try {
                                            Field declaredField2 = Resources.class.getDeclaredField("mResourcesImpl");
                                            BundleKt.sResourcesImplField = declaredField2;
                                            declaredField2.setAccessible(true);
                                        } catch (NoSuchFieldException e3) {
                                            Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e3);
                                        }
                                        BundleKt.sResourcesImplFieldFetched = true;
                                    }
                                    Field field3 = BundleKt.sResourcesImplField;
                                    if (field3 != null) {
                                        try {
                                            obj2 = field3.get(resources);
                                        } catch (IllegalAccessException e4) {
                                            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e4);
                                            obj2 = null;
                                        }
                                        if (obj2 != null) {
                                            if (!BundleKt.sDrawableCacheFieldFetched) {
                                                try {
                                                    Field declaredField3 = obj2.getClass().getDeclaredField("mDrawableCache");
                                                    BundleKt.sDrawableCacheField = declaredField3;
                                                    declaredField3.setAccessible(true);
                                                } catch (NoSuchFieldException e5) {
                                                    Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e5);
                                                }
                                                BundleKt.sDrawableCacheFieldFetched = true;
                                            }
                                            Field field4 = BundleKt.sDrawableCacheField;
                                            if (field4 != null) {
                                                try {
                                                    obj3 = field4.get(obj2);
                                                } catch (IllegalAccessException e6) {
                                                    Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e6);
                                                }
                                                if (obj3 != null) {
                                                    BundleKt.flushThemedResourcesCache(obj3);
                                                }
                                            }
                                            obj3 = null;
                                            if (obj3 != null) {
                                            }
                                        }
                                    }
                                } else {
                                    z6 = z5;
                                    localeListCompat3 = localeListCompat2;
                                    if (i10 >= 23) {
                                        if (!BundleKt.sDrawableCacheFieldFetched) {
                                            try {
                                                declaredField = Resources.class.getDeclaredField("mDrawableCache");
                                                BundleKt.sDrawableCacheField = declaredField;
                                                z8 = true;
                                            } catch (NoSuchFieldException e7) {
                                                e2 = e7;
                                                z8 = true;
                                            }
                                            try {
                                                declaredField.setAccessible(true);
                                            } catch (NoSuchFieldException e8) {
                                                e2 = e8;
                                                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e2);
                                                BundleKt.sDrawableCacheFieldFetched = z8;
                                                field2 = BundleKt.sDrawableCacheField;
                                                if (field2 != null) {
                                                }
                                                obj = null;
                                                if (obj != null) {
                                                }
                                                i5 = this.mThemeResId;
                                                if (i5 != 0) {
                                                }
                                                if (z6) {
                                                }
                                                z4 = true;
                                                if (z4) {
                                                }
                                                if (localeListCompat3 != null) {
                                                }
                                                if (i7 == 0) {
                                                }
                                                if (i7 == 3) {
                                                }
                                                return z4;
                                            }
                                            BundleKt.sDrawableCacheFieldFetched = z8;
                                        }
                                        field2 = BundleKt.sDrawableCacheField;
                                        if (field2 != null) {
                                            try {
                                                obj = field2.get(resources);
                                            } catch (IllegalAccessException e9) {
                                                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e9);
                                            }
                                            if (obj != null) {
                                                BundleKt.flushThemedResourcesCache(obj);
                                            }
                                        }
                                        obj = null;
                                        if (obj != null) {
                                        }
                                    } else {
                                        if (!BundleKt.sDrawableCacheFieldFetched) {
                                            try {
                                                Field declaredField4 = Resources.class.getDeclaredField("mDrawableCache");
                                                BundleKt.sDrawableCacheField = declaredField4;
                                                z7 = true;
                                                try {
                                                    declaredField4.setAccessible(true);
                                                } catch (NoSuchFieldException e10) {
                                                    e = e10;
                                                    Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
                                                    BundleKt.sDrawableCacheFieldFetched = z7;
                                                    field = BundleKt.sDrawableCacheField;
                                                    if (field != null) {
                                                    }
                                                    i5 = this.mThemeResId;
                                                    if (i5 != 0) {
                                                    }
                                                    if (z6) {
                                                    }
                                                    z4 = true;
                                                    if (z4) {
                                                    }
                                                    if (localeListCompat3 != null) {
                                                    }
                                                    if (i7 == 0) {
                                                    }
                                                    if (i7 == 3) {
                                                    }
                                                    return z4;
                                                }
                                            } catch (NoSuchFieldException e11) {
                                                e = e11;
                                                z7 = true;
                                            }
                                            BundleKt.sDrawableCacheFieldFetched = z7;
                                        }
                                        field = BundleKt.sDrawableCacheField;
                                        if (field != null) {
                                            try {
                                                map = (Map) field.get(resources);
                                            } catch (IllegalAccessException e12) {
                                                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e12);
                                                map = null;
                                            }
                                            if (map != null) {
                                                map.clear();
                                            }
                                        }
                                    }
                                    i5 = this.mThemeResId;
                                    if (i5 != 0) {
                                        context.setTheme(i5);
                                        if (Build.VERSION.SDK_INT >= 23) {
                                            context.getTheme().applyStyle(this.mThemeResId, true);
                                            if (z6 && (obj4 instanceof Activity)) {
                                                activity = (Activity) obj4;
                                                if (!(activity instanceof LifecycleOwner)) {
                                                    if (((LifecycleRegistry) ((LifecycleOwner) activity).getLifecycle()).state.compareTo(Lifecycle.State.CREATED) >= 0) {
                                                        activity.onConfigurationChanged(configuration2);
                                                    }
                                                } else if (this.mCreated && !this.mDestroyed) {
                                                    activity.onConfigurationChanged(configuration2);
                                                }
                                            }
                                            z4 = true;
                                        }
                                    }
                                    if (z6) {
                                        activity = (Activity) obj4;
                                        if (!(activity instanceof LifecycleOwner)) {
                                        }
                                    }
                                    z4 = true;
                                }
                            }
                            z6 = z5;
                            localeListCompat3 = localeListCompat2;
                            i5 = this.mThemeResId;
                            if (i5 != 0) {
                            }
                            if (z6) {
                            }
                            z4 = true;
                        }
                        if (z4 && (obj4 instanceof AppCompatActivity)) {
                            if ((i4 & LogviewFragment.MAX_LINES) != 0) {
                                ((AppCompatActivity) obj4).onNightModeChanged(mapNightMode);
                            }
                            if ((i4 & 4) != 0) {
                                ((AppCompatActivity) obj4).onLocalesChanged(localeListCompat);
                            }
                        }
                        if (localeListCompat3 != null) {
                            LocaleListCompat configurationLocales2 = getConfigurationLocales(context.getResources().getConfiguration());
                            if (Build.VERSION.SDK_INT >= 24) {
                                Api24Impl.setDefaultLocales(configurationLocales2);
                            } else {
                                Locale.setDefault(configurationLocales2.mImpl.get(0));
                            }
                        }
                        if (i7 == 0) {
                            getAutoTimeNightModeManager(context).setup();
                        } else {
                            AutoTimeNightModeManager autoTimeNightModeManager = this.mAutoTimeNightModeManager;
                            if (autoTimeNightModeManager != null) {
                                autoTimeNightModeManager.cleanup();
                            }
                        }
                        if (i7 == 3) {
                            if (this.mAutoBatteryNightModeManager == null) {
                                this.mAutoBatteryNightModeManager = new AutoTimeNightModeManager(context);
                            }
                            this.mAutoBatteryNightModeManager.setup();
                        } else {
                            AutoTimeNightModeManager autoTimeNightModeManager2 = this.mAutoBatteryNightModeManager;
                            if (autoTimeNightModeManager2 != null) {
                                autoTimeNightModeManager2.cleanup();
                            }
                        }
                        return z4;
                    }
                }
                z3 = false;
                if (!z3) {
                }
                localeListCompat3 = localeListCompat2;
                z4 = z3;
                if (z4) {
                    if ((i4 & LogviewFragment.MAX_LINES) != 0) {
                    }
                    if ((i4 & 4) != 0) {
                    }
                }
                if (localeListCompat3 != null) {
                }
                if (i7 == 0) {
                }
                if (i7 == 3) {
                }
                return z4;
            }
            if (i8 >= 29) {
                i6 = 269221888;
            } else if (i8 >= 24) {
                i6 = 786432;
            } else {
                i6 = 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj4.getClass()), i6);
                if (activityInfo != null) {
                    this.mActivityHandlesConfigFlags = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e13) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e13);
                this.mActivityHandlesConfigFlags = 0;
            }
        }
        this.mActivityHandlesConfigFlagsChecked = true;
        i = this.mActivityHandlesConfigFlags;
        configuration = this.mEffectiveConfiguration;
        if (configuration == null) {
        }
        i2 = configuration.uiMode & 48;
        i3 = createOverrideAppConfiguration.uiMode & 48;
        LocaleListCompat configurationLocales3 = getConfigurationLocales(configuration);
        if (localeListCompat != null) {
        }
        if (i2 == i3) {
        }
        if (localeListCompat2 != null) {
            i4 |= 8196;
        }
        if (((~i) & i4) != 0) {
            activity2 = (Activity) obj4;
            if (!activity2.isChild()) {
            }
        }
        z3 = false;
        if (!z3) {
        }
        localeListCompat3 = localeListCompat2;
        z4 = z3;
        if (z4) {
        }
        if (localeListCompat3 != null) {
        }
        if (i7 == 0) {
        }
        if (i7 == 3) {
        }
        return z4;
    }

    public final void attachToWindow(Window window) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        if (this.mWindow == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof AppCompatWindowCallback)) {
                AppCompatWindowCallback appCompatWindowCallback = new AppCompatWindowCallback(callback);
                this.mAppCompatWindowCallback = appCompatWindowCallback;
                window.setCallback(appCompatWindowCallback);
                MatcherMatchResult obtainStyledAttributes = MatcherMatchResult.obtainStyledAttributes(this.mContext, null, sWindowBackgroundStyleable);
                Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(0);
                if (drawableIfKnown != null) {
                    window.setBackgroundDrawable(drawableIfKnown);
                }
                obtainStyledAttributes.recycle();
                this.mWindow = window;
                if (Build.VERSION.SDK_INT >= 33 && (onBackInvokedDispatcher = this.mDispatcher) == null) {
                    if (!(onBackInvokedDispatcher == null || (onBackInvokedCallback = this.mBackCallback) == null)) {
                        Api33Impl.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
                        this.mBackCallback = null;
                    }
                    Object obj = this.mHost;
                    if (obj instanceof Activity) {
                        Activity activity = (Activity) obj;
                        if (activity.getWindow() != null) {
                            this.mDispatcher = Api33Impl.getOnBackInvokedDispatcher(activity);
                            updateBackInvokedCallbackState();
                            return;
                        }
                    }
                    this.mDispatcher = null;
                    updateBackInvokedCallbackState();
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    public final void callOnPanelClosed(int i, PanelFeatureState panelFeatureState, MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            if (panelFeatureState == null && i >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.mPanels;
                if (i < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i];
                }
            }
            if (panelFeatureState != null) {
                menuBuilder = panelFeatureState.menu;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.isOpen) && !this.mDestroyed) {
            AppCompatWindowCallback appCompatWindowCallback = this.mAppCompatWindowCallback;
            Window.Callback callback = this.mWindow.getCallback();
            appCompatWindowCallback.getClass();
            try {
                appCompatWindowCallback.mOnPanelClosedBypassEnabled = true;
                callback.onPanelClosed(i, menuBuilder);
            } finally {
                appCompatWindowCallback.mOnPanelClosedBypassEnabled = false;
            }
        }
    }

    public final void checkCloseActionMenu(MenuBuilder menuBuilder) {
        ActionMenuPresenter actionMenuPresenter;
        if (!this.mClosingActionMenu) {
            this.mClosingActionMenu = true;
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.mDecorContentParent;
            actionBarOverlayLayout.pullChildren();
            ActionMenuView actionMenuView = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar.mMenuView;
            if (!(actionMenuView == null || (actionMenuPresenter = actionMenuView.mPresenter) == null)) {
                actionMenuPresenter.hideOverflowMenu();
                ActionMenuPresenter.OverflowPopup overflowPopup = actionMenuPresenter.mActionButtonPopup;
                if (overflowPopup != null && overflowPopup.isShowing()) {
                    overflowPopup.mPopup.dismiss();
                }
            }
            Window.Callback callback = this.mWindow.getCallback();
            if (callback != null && !this.mDestroyed) {
                callback.onPanelClosed(108, menuBuilder);
            }
            this.mClosingActionMenu = false;
        }
    }

    public final void closePanel(PanelFeatureState panelFeatureState, boolean z) {
        ListMenuDecorView listMenuDecorView;
        DecorContentParent decorContentParent;
        if (z && panelFeatureState.featureId == 0 && (decorContentParent = this.mDecorContentParent) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decorContentParent;
            actionBarOverlayLayout.pullChildren();
            if (((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar.isOverflowMenuShowing()) {
                checkCloseActionMenu(panelFeatureState.menu);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (!(windowManager == null || !panelFeatureState.isOpen || (listMenuDecorView = panelFeatureState.decorView) == null)) {
            windowManager.removeView(listMenuDecorView);
            if (z) {
                callOnPanelClosed(panelFeatureState.featureId, panelFeatureState, null);
            }
        }
        panelFeatureState.isPrepared = false;
        panelFeatureState.isHandled = false;
        panelFeatureState.isOpen = false;
        panelFeatureState.shownPanelView = null;
        panelFeatureState.refreshDecorView = true;
        if (this.mPreparedPanel == panelFeatureState) {
            this.mPreparedPanel = null;
        }
        if (panelFeatureState.featureId == 0) {
            updateBackInvokedCallbackState();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0037, code lost:
        if (r4.dispatchKeyEvent(r7) != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f0, code lost:
        if (r7.hideOverflowMenu() != false) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        boolean z2;
        ActionMenuView actionMenuView;
        View decorView;
        Object obj = this.mHost;
        boolean z3 = true;
        if ((!(obj instanceof KeyEventDispatcher$Component) && !(obj instanceof AlertDialog)) || (decorView = this.mWindow.getDecorView()) == null || !BundleKt.dispatchBeforeHierarchy(decorView, keyEvent)) {
            if (keyEvent.getKeyCode() == 82) {
                AppCompatWindowCallback appCompatWindowCallback = this.mAppCompatWindowCallback;
                Window.Callback callback = this.mWindow.getCallback();
                appCompatWindowCallback.getClass();
                try {
                    appCompatWindowCallback.mDispatchKeyEventBypassEnabled = true;
                } finally {
                    appCompatWindowCallback.mDispatchKeyEventBypassEnabled = false;
                }
            }
            int keyCode = keyEvent.getKeyCode();
            if (keyEvent.getAction() == 0) {
                if (keyCode != 4) {
                    if (keyCode == 82) {
                        if (keyEvent.getRepeatCount() == 0) {
                            PanelFeatureState panelState = getPanelState(0);
                            if (!panelState.isOpen) {
                                preparePanel(panelState, keyEvent);
                                return true;
                            }
                        }
                    }
                    return false;
                }
                if ((keyEvent.getFlags() & 128) == 0) {
                    z3 = false;
                }
                this.mLongPressBackDown = z3;
                return false;
            } else if (keyCode != 4) {
                if (keyCode == 82) {
                    if (this.mActionMode == null) {
                        PanelFeatureState panelState2 = getPanelState(0);
                        DecorContentParent decorContentParent = this.mDecorContentParent;
                        Context context = this.mContext;
                        if (decorContentParent != null) {
                            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decorContentParent;
                            actionBarOverlayLayout.pullChildren();
                            Toolbar toolbar = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar;
                            if (toolbar.getVisibility() == 0 && (actionMenuView = toolbar.mMenuView) != null && actionMenuView.mReserveOverflow && !ViewConfiguration.get(context).hasPermanentMenuKey()) {
                                ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.mDecorContentParent;
                                actionBarOverlayLayout2.pullChildren();
                                if (((ToolbarWidgetWrapper) actionBarOverlayLayout2.mDecorToolbar).mToolbar.isOverflowMenuShowing()) {
                                    ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.mDecorContentParent;
                                    actionBarOverlayLayout3.pullChildren();
                                    ActionMenuView actionMenuView2 = ((ToolbarWidgetWrapper) actionBarOverlayLayout3.mDecorToolbar).mToolbar.mMenuView;
                                    if (actionMenuView2 != null) {
                                        ActionMenuPresenter actionMenuPresenter = actionMenuView2.mPresenter;
                                        if (actionMenuPresenter != null) {
                                        }
                                    }
                                } else if (!this.mDestroyed && preparePanel(panelState2, keyEvent)) {
                                    ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.mDecorContentParent;
                                    actionBarOverlayLayout4.pullChildren();
                                    z = ((ToolbarWidgetWrapper) actionBarOverlayLayout4.mDecorToolbar).mToolbar.showOverflowMenu();
                                    if (z) {
                                        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                                        if (audioManager != null) {
                                            audioManager.playSoundEffect(0);
                                            return true;
                                        }
                                        Log.w("AppCompatDelegate", "Couldn't get audio manager");
                                        return true;
                                    }
                                }
                                z = false;
                                if (z) {
                                }
                            }
                        }
                        boolean z4 = panelState2.isOpen;
                        if (z4 || panelState2.isHandled) {
                            closePanel(panelState2, true);
                            z = z4;
                            if (z) {
                            }
                        } else {
                            if (panelState2.isPrepared) {
                                if (panelState2.refreshMenuContent) {
                                    panelState2.isPrepared = false;
                                    z2 = preparePanel(panelState2, keyEvent);
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    openPanel(panelState2, keyEvent);
                                    z = true;
                                    if (z) {
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                            }
                        }
                    }
                }
                return false;
            } else if (!onBackPressed()) {
                return false;
            }
        }
        return true;
    }

    public final void doInvalidatePanelMenu(int i) {
        PanelFeatureState panelState = getPanelState(i);
        if (panelState.menu != null) {
            Bundle bundle = new Bundle();
            panelState.menu.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                panelState.frozenActionViewState = bundle;
            }
            panelState.menu.stopDispatchingItemsChanged();
            panelState.menu.clear();
        }
        panelState.refreshMenuContent = true;
        panelState.refreshDecorView = true;
        if ((i == 108 || i == 0) && this.mDecorContentParent != null) {
            PanelFeatureState panelState2 = getPanelState(0);
            panelState2.isPrepared = false;
            preparePanel(panelState2, null);
        }
    }

    public final void ensureSubDecor() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (!this.mSubDecorInstalled) {
            Context context2 = this.mContext;
            int[] iArr = R$styleable.AppCompatTheme;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            if (obtainStyledAttributes.hasValue(117)) {
                if (obtainStyledAttributes.getBoolean(126, false)) {
                    requestWindowFeature(1);
                } else if (obtainStyledAttributes.getBoolean(117, false)) {
                    requestWindowFeature(108);
                }
                if (obtainStyledAttributes.getBoolean(118, false)) {
                    requestWindowFeature(109);
                }
                if (obtainStyledAttributes.getBoolean(119, false)) {
                    requestWindowFeature(10);
                }
                this.mIsFloating = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
                ensureWindow();
                this.mWindow.getDecorView();
                LayoutInflater from = LayoutInflater.from(context2);
                if (this.mWindowNoTitle) {
                    viewGroup = this.mOverlayActionMode ? (ViewGroup) from.inflate(C0130R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(C0130R.layout.abc_screen_simple, (ViewGroup) null);
                } else if (this.mIsFloating) {
                    viewGroup = (ViewGroup) from.inflate(C0130R.layout.abc_dialog_title_material, (ViewGroup) null);
                    this.mOverlayActionBar = false;
                    this.mHasActionBar = false;
                } else if (this.mHasActionBar) {
                    TypedValue typedValue = new TypedValue();
                    context2.getTheme().resolveAttribute(C0130R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new ContextThemeWrapper(context2, typedValue.resourceId);
                    } else {
                        context = context2;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C0130R.layout.abc_screen_toolbar, (ViewGroup) null);
                    DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(C0130R.C0132id.decor_content_parent);
                    this.mDecorContentParent = decorContentParent;
                    decorContentParent.setWindowCallback(this.mWindow.getCallback());
                    if (this.mOverlayActionBar) {
                        ((ActionBarOverlayLayout) this.mDecorContentParent).initFeature(109);
                    }
                    if (this.mFeatureProgress) {
                        ((ActionBarOverlayLayout) this.mDecorContentParent).initFeature(2);
                    }
                    if (this.mFeatureIndeterminateProgress) {
                        ((ActionBarOverlayLayout) this.mDecorContentParent).initFeature(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    C00153 r3 = new C00153(this, 0);
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(viewGroup, r3);
                    if (this.mDecorContentParent == null) {
                        this.mTitleView = (TextView) viewGroup.findViewById(C0130R.C0132id.title);
                    }
                    boolean z = ViewUtils.sInitComputeFitSystemWindowsMethod;
                    try {
                        Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        method.invoke(viewGroup, null);
                    } catch (IllegalAccessException e) {
                        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
                    } catch (NoSuchMethodException unused) {
                        Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                    } catch (InvocationTargetException e2) {
                        Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
                    }
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(C0130R.C0132id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.mWindow.findViewById(16908290);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(16908290);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground(null);
                        }
                    }
                    this.mWindow.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new C00153(this, 1));
                    this.mSubDecor = viewGroup;
                    Object obj = this.mHost;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.mTitle;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        DecorContentParent decorContentParent2 = this.mDecorContentParent;
                        if (decorContentParent2 != null) {
                            decorContentParent2.setWindowTitle(charSequence);
                        } else {
                            ActionBar actionBar = this.mActionBar;
                            if (actionBar != null) {
                                actionBar.setWindowTitle(charSequence);
                            } else {
                                TextView textView = this.mTitleView;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.mSubDecor.findViewById(16908290);
                    View decorView = this.mWindow.getDecorView();
                    contentFrameLayout2.mDecorPadding.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    if (contentFrameLayout2.isLaidOut()) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(iArr);
                    obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
                    if (obtainStyledAttributes2.hasValue(122)) {
                        obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(123)) {
                        obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
                    }
                    if (obtainStyledAttributes2.hasValue(120)) {
                        obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(121)) {
                        obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.mSubDecorInstalled = true;
                    PanelFeatureState panelState = getPanelState(0);
                    if (!this.mDestroyed && panelState.menu == null) {
                        invalidatePanelMenu(108);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.mHasActionBar + ", windowActionBarOverlay: " + this.mOverlayActionBar + ", android:windowIsFloating: " + this.mIsFloating + ", windowActionModeOverlay: " + this.mOverlayActionMode + ", windowNoTitle: " + this.mWindowNoTitle + " }");
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void ensureWindow() {
        if (this.mWindow == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                attachToWindow(((Activity) obj).getWindow());
            }
        }
        if (this.mWindow == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final Context getActionBarThemedContext() {
        Context context;
        initWindowDecorActionBar();
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            context = actionBar.getThemedContext();
        } else {
            context = null;
        }
        if (context == null) {
            return this.mContext;
        }
        return context;
    }

    public final BaseMenuWrapper getAutoTimeNightModeManager(Context context) {
        if (this.mAutoTimeNightModeManager == null) {
            if (MatcherMatchResult.sInstance == null) {
                Context applicationContext = context.getApplicationContext();
                MatcherMatchResult.sInstance = new MatcherMatchResult(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.mAutoTimeNightModeManager = new AutoTimeNightModeManager(MatcherMatchResult.sInstance);
        }
        return this.mAutoTimeNightModeManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, java.lang.Object] */
    public final PanelFeatureState getPanelState(int i) {
        Object[] objArr = this.mPanels;
        if (objArr == null || objArr.length <= i) {
            PanelFeatureState[] panelFeatureStateArr = new PanelFeatureState[i + 1];
            if (objArr != null) {
                System.arraycopy(objArr, 0, panelFeatureStateArr, 0, objArr.length);
            }
            this.mPanels = panelFeatureStateArr;
            objArr = panelFeatureStateArr;
        }
        PanelFeatureState panelFeatureState = objArr[i];
        if (panelFeatureState != 0) {
            return panelFeatureState;
        }
        ?? obj = new Object();
        obj.featureId = i;
        obj.refreshDecorView = false;
        objArr[i] = obj;
        return obj;
    }

    public final void initWindowDecorActionBar() {
        ensureSubDecor();
        if (this.mHasActionBar && this.mActionBar == null) {
            Object obj = this.mHost;
            if (obj instanceof Activity) {
                this.mActionBar = new WindowDecorActionBar((Activity) obj, this.mOverlayActionBar);
            } else if (obj instanceof Dialog) {
                this.mActionBar = new WindowDecorActionBar((Dialog) obj);
            }
            ActionBar actionBar = this.mActionBar;
            if (actionBar != null) {
                actionBar.setDefaultDisplayHomeAsUpEnabled(this.mEnableDefaultActionBarUp);
            }
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void installViewFactory() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void invalidateOptionsMenu() {
        if (this.mActionBar != null) {
            initWindowDecorActionBar();
            if (!this.mActionBar.invalidateOptionsMenu()) {
                invalidatePanelMenu(0);
            }
        }
    }

    public final void invalidatePanelMenu(int i) {
        this.mInvalidatePanelMenuFeatures = (1 << i) | this.mInvalidatePanelMenuFeatures;
        if (!this.mInvalidatePanelMenuPosted) {
            View decorView = this.mWindow.getDecorView();
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            decorView.postOnAnimation(this.mInvalidatePanelMenuRunnable);
            this.mInvalidatePanelMenuPosted = true;
        }
    }

    public final int mapNightMode(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (!(i == 1 || i == 2)) {
                        if (i == 3) {
                            if (this.mAutoBatteryNightModeManager == null) {
                                this.mAutoBatteryNightModeManager = new AutoTimeNightModeManager(context);
                            }
                            return this.mAutoBatteryNightModeManager.getApplyableNightMode();
                        }
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return getAutoTimeNightModeManager(context).getApplyableNightMode();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean onBackPressed() {
        boolean z = this.mLongPressBackDown;
        this.mLongPressBackDown = false;
        PanelFeatureState panelState = getPanelState(0);
        if (!panelState.isOpen) {
            androidx.appcompat.view.ActionMode actionMode = this.mActionMode;
            if (actionMode != null) {
                actionMode.finish();
                return true;
            }
            initWindowDecorActionBar();
            ActionBar actionBar = this.mActionBar;
            if (actionBar == null || !actionBar.collapseActionView()) {
                return false;
            }
        } else if (!z) {
            closePanel(panelState, true);
            return true;
        }
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void onCreate() {
        String str;
        this.mBaseContextAttached = true;
        applyApplicationSpecificConfig(false, true);
        ensureWindow();
        Object obj = this.mHost;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = NavUtils.getParentActivityName(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                ActionBar actionBar = this.mActionBar;
                if (actionBar == null) {
                    this.mEnableDefaultActionBarUp = true;
                } else {
                    actionBar.setDefaultDisplayHomeAsUpEnabled(true);
                }
            }
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
                AppCompatDelegate.sActivityDelegates.add(new WeakReference(this));
            }
        }
        this.mEffectiveConfiguration = new Configuration(this.mContext.getResources().getConfiguration());
        this.mCreated = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x010d, code lost:
        if (r10.equals("ImageButton") == false) goto L23;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x01e2 -> B:128:0x01e8). Please submit an issue!!! */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View view2;
        View view3 = null;
        if (this.mAppCompatViewInflater == null) {
            int[] iArr = R$styleable.AppCompatTheme;
            Context context2 = this.mContext;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            String string = obtainStyledAttributes.getString(116);
            obtainStyledAttributes.recycle();
            if (string == null) {
                this.mAppCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.mAppCompatViewInflater = (AppCompatViewInflater) context2.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.mAppCompatViewInflater = new AppCompatViewInflater();
                }
            }
        }
        AppCompatViewInflater appCompatViewInflater = this.mAppCompatViewInflater;
        int i = VectorEnabledTintResources.$r8$clinit;
        appCompatViewInflater.getClass();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.View, 0, 0);
        char c = 4;
        int resourceId = obtainStyledAttributes2.getResourceId(4, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes2.recycle();
        Context contextThemeWrapper = (resourceId == 0 || ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).mThemeResource == resourceId)) ? context : new ContextThemeWrapper(context, resourceId);
        str.getClass();
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -937446323:
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                view2 = new AppCompatRatingBar(contextThemeWrapper, attributeSet);
                break;
            case 1:
                view2 = new AppCompatCheckedTextView(contextThemeWrapper, attributeSet);
                break;
            case 2:
                view2 = new AppCompatMultiAutoCompleteTextView(contextThemeWrapper, attributeSet);
                break;
            case 3:
                view2 = appCompatViewInflater.createTextView(contextThemeWrapper, attributeSet);
                break;
            case 4:
                view2 = new AppCompatImageButton(contextThemeWrapper, attributeSet, C0130R.attr.imageButtonStyle);
                break;
            case 5:
                view2 = new AppCompatSeekBar(contextThemeWrapper, attributeSet);
                break;
            case 6:
                view2 = new AppCompatSpinner(contextThemeWrapper, attributeSet);
                break;
            case 7:
                view2 = appCompatViewInflater.createRadioButton(contextThemeWrapper, attributeSet);
                break;
            case '\b':
                view2 = new AppCompatToggleButton(contextThemeWrapper, attributeSet);
                break;
            case '\t':
                view2 = new AppCompatImageView(contextThemeWrapper, attributeSet, 0);
                break;
            case '\n':
                view2 = appCompatViewInflater.createAutoCompleteTextView(contextThemeWrapper, attributeSet);
                break;
            case 11:
                view2 = appCompatViewInflater.createCheckBox(contextThemeWrapper, attributeSet);
                break;
            case '\f':
                view2 = new AppCompatEditText(contextThemeWrapper, attributeSet);
                break;
            case '\r':
                view2 = appCompatViewInflater.createButton(contextThemeWrapper, attributeSet);
                break;
            default:
                view2 = null;
                break;
        }
        if (view2 != null || context == contextThemeWrapper) {
            view3 = view2;
        } else {
            Object[] objArr = appCompatViewInflater.mConstructorArgs;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = contextThemeWrapper;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = AppCompatViewInflater.sClassPrefixList;
                        if (i2 < 3) {
                            View createViewByPrefix = appCompatViewInflater.createViewByPrefix(contextThemeWrapper, str, strArr[i2]);
                            if (createViewByPrefix != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view3 = createViewByPrefix;
                            } else {
                                i2++;
                            }
                        } else {
                            objArr[0] = null;
                            objArr[1] = null;
                        }
                    }
                } else {
                    View createViewByPrefix2 = appCompatViewInflater.createViewByPrefix(contextThemeWrapper, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view3 = createViewByPrefix2;
                }
            } catch (Exception unused) {
                objArr[0] = view3;
                objArr[1] = view3;
            } catch (Throwable th2) {
                objArr[0] = view3;
                objArr[1] = view3;
                throw th2;
            }
        }
        if (view3 != null) {
            Context context3 = view3.getContext();
            if ((context3 instanceof ContextWrapper) && view3.hasOnClickListeners()) {
                TypedArray obtainStyledAttributes3 = context3.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sOnClickAttrs);
                String string2 = obtainStyledAttributes3.getString(0);
                if (string2 != null) {
                    view3.setOnClickListener(new AppCompatViewInflater.DeclaredOnClickListener(view3, string2));
                }
                obtainStyledAttributes3.recycle();
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray obtainStyledAttributes4 = contextThemeWrapper.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sAccessibilityHeading);
                if (obtainStyledAttributes4.hasValue(0)) {
                    boolean z = obtainStyledAttributes4.getBoolean(0, false);
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    new ViewCompat.C00461(C0130R.C0132id.tag_accessibility_heading, Boolean.class, 0, 28, 3).set(view3, Boolean.valueOf(z));
                }
                obtainStyledAttributes4.recycle();
                TypedArray obtainStyledAttributes5 = contextThemeWrapper.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sAccessibilityPaneTitle);
                if (obtainStyledAttributes5.hasValue(0)) {
                    ViewCompat.setAccessibilityPaneTitle(view3, obtainStyledAttributes5.getString(0));
                }
                obtainStyledAttributes5.recycle();
                TypedArray obtainStyledAttributes6 = contextThemeWrapper.obtainStyledAttributes(attributeSet, AppCompatViewInflater.sScreenReaderFocusable);
                if (obtainStyledAttributes6.hasValue(0)) {
                    boolean z2 = obtainStyledAttributes6.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    new ViewCompat.C00461(C0130R.C0132id.tag_screen_reader_focusable, Boolean.class, 0, 28, 0).set(view3, Boolean.valueOf(z2));
                }
                obtainStyledAttributes6.recycle();
            }
        }
        return view3;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onDestroy() {
        ActionBar actionBar;
        AutoTimeNightModeManager autoTimeNightModeManager;
        AutoTimeNightModeManager autoTimeNightModeManager2;
        if (this.mHost instanceof Activity) {
            synchronized (AppCompatDelegate.sActivityDelegatesLock) {
                AppCompatDelegate.removeDelegateFromActives(this);
            }
        }
        if (this.mInvalidatePanelMenuPosted) {
            this.mWindow.getDecorView().removeCallbacks(this.mInvalidatePanelMenuRunnable);
        }
        this.mDestroyed = true;
        if (this.mLocalNightMode != -100) {
            Object obj = this.mHost;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                sLocalNightModes.put(this.mHost.getClass().getName(), Integer.valueOf(this.mLocalNightMode));
                actionBar = this.mActionBar;
                if (actionBar != null) {
                    actionBar.onDestroy();
                }
                autoTimeNightModeManager = this.mAutoTimeNightModeManager;
                if (autoTimeNightModeManager != null) {
                    autoTimeNightModeManager.cleanup();
                }
                autoTimeNightModeManager2 = this.mAutoBatteryNightModeManager;
                if (autoTimeNightModeManager2 == null) {
                    autoTimeNightModeManager2.cleanup();
                    return;
                }
                return;
            }
        }
        sLocalNightModes.remove(this.mHost.getClass().getName());
        actionBar = this.mActionBar;
        if (actionBar != null) {
        }
        autoTimeNightModeManager = this.mAutoTimeNightModeManager;
        if (autoTimeNightModeManager != null) {
        }
        autoTimeNightModeManager2 = this.mAutoBatteryNightModeManager;
        if (autoTimeNightModeManager2 == null) {
        }
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        int i;
        PanelFeatureState panelFeatureState;
        Window.Callback callback = this.mWindow.getCallback();
        if (callback != null && !this.mDestroyed) {
            MenuBuilder rootMenu = menuBuilder.getRootMenu();
            PanelFeatureState[] panelFeatureStateArr = this.mPanels;
            if (panelFeatureStateArr != null) {
                i = panelFeatureStateArr.length;
            } else {
                i = 0;
            }
            int i2 = 0;
            while (true) {
                if (i2 < i) {
                    panelFeatureState = panelFeatureStateArr[i2];
                    if (panelFeatureState != null && panelFeatureState.menu == rootMenu) {
                        break;
                    }
                    i2++;
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                return callback.onMenuItemSelected(panelFeatureState.featureId, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
        if (r6.isOverflowMenuShowing() != false) goto L20;
     */
    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMenuModeChange(MenuBuilder menuBuilder) {
        ActionMenuView actionMenuView;
        ActionMenuPresenter actionMenuPresenter;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decorContentParent;
            actionBarOverlayLayout.pullChildren();
            Toolbar toolbar = ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mToolbar;
            if (toolbar.getVisibility() == 0 && (actionMenuView = toolbar.mMenuView) != null && actionMenuView.mReserveOverflow) {
                if (ViewConfiguration.get(this.mContext).hasPermanentMenuKey()) {
                    ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.mDecorContentParent;
                    actionBarOverlayLayout2.pullChildren();
                    ActionMenuView actionMenuView2 = ((ToolbarWidgetWrapper) actionBarOverlayLayout2.mDecorToolbar).mToolbar.mMenuView;
                    if (actionMenuView2 != null) {
                        ActionMenuPresenter actionMenuPresenter2 = actionMenuView2.mPresenter;
                        if (actionMenuPresenter2 != null) {
                            if (actionMenuPresenter2.mPostedOpenRunnable == null) {
                            }
                        }
                    }
                }
                Window.Callback callback = this.mWindow.getCallback();
                ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.mDecorContentParent;
                actionBarOverlayLayout3.pullChildren();
                if (((ToolbarWidgetWrapper) actionBarOverlayLayout3.mDecorToolbar).mToolbar.isOverflowMenuShowing()) {
                    ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.mDecorContentParent;
                    actionBarOverlayLayout4.pullChildren();
                    ActionMenuView actionMenuView3 = ((ToolbarWidgetWrapper) actionBarOverlayLayout4.mDecorToolbar).mToolbar.mMenuView;
                    if (!(actionMenuView3 == null || (actionMenuPresenter = actionMenuView3.mPresenter) == null)) {
                        actionMenuPresenter.hideOverflowMenu();
                    }
                    if (!this.mDestroyed) {
                        callback.onPanelClosed(108, getPanelState(0).menu);
                        return;
                    }
                    return;
                } else if (callback != null && !this.mDestroyed) {
                    if (this.mInvalidatePanelMenuPosted && (1 & this.mInvalidatePanelMenuFeatures) != 0) {
                        View decorView = this.mWindow.getDecorView();
                        RunnableC00142 r2 = this.mInvalidatePanelMenuRunnable;
                        decorView.removeCallbacks(r2);
                        r2.run();
                    }
                    PanelFeatureState panelState = getPanelState(0);
                    MenuBuilder menuBuilder2 = panelState.menu;
                    if (menuBuilder2 != null && !panelState.refreshMenuContent && callback.onPreparePanel(0, panelState.createdPanelView, menuBuilder2)) {
                        callback.onMenuOpened(108, panelState.menu);
                        ActionBarOverlayLayout actionBarOverlayLayout5 = (ActionBarOverlayLayout) this.mDecorContentParent;
                        actionBarOverlayLayout5.pullChildren();
                        ((ToolbarWidgetWrapper) actionBarOverlayLayout5.mDecorToolbar).mToolbar.showOverflowMenu();
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        PanelFeatureState panelState2 = getPanelState(0);
        panelState2.refreshDecorView = true;
        closePanel(panelState2, false);
        openPanel(panelState2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:
        if (r15 != null) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0165, code lost:
        if (r15.mAdapter.getCount() > 0) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void openPanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        boolean z = panelFeatureState.isOpen;
        int i2 = panelFeatureState.featureId;
        if (!z && !this.mDestroyed) {
            Context context = this.mContext;
            if (i2 != 0 || (context.getResources().getConfiguration().screenLayout & 15) != 4) {
                Window.Callback callback = this.mWindow.getCallback();
                if (callback == null || callback.onMenuOpened(i2, panelFeatureState.menu)) {
                    WindowManager windowManager = (WindowManager) context.getSystemService("window");
                    if (windowManager != null && preparePanel(panelFeatureState, keyEvent)) {
                        ListMenuDecorView listMenuDecorView = panelFeatureState.decorView;
                        if (listMenuDecorView == null || panelFeatureState.refreshDecorView) {
                            if (listMenuDecorView == null) {
                                Context actionBarThemedContext = getActionBarThemedContext();
                                TypedValue typedValue = new TypedValue();
                                Resources.Theme newTheme = actionBarThemedContext.getResources().newTheme();
                                newTheme.setTo(actionBarThemedContext.getTheme());
                                newTheme.resolveAttribute(C0130R.attr.actionBarPopupTheme, typedValue, true);
                                int i3 = typedValue.resourceId;
                                if (i3 != 0) {
                                    newTheme.applyStyle(i3, true);
                                }
                                newTheme.resolveAttribute(C0130R.attr.panelMenuListTheme, typedValue, true);
                                int i4 = typedValue.resourceId;
                                if (i4 != 0) {
                                    newTheme.applyStyle(i4, true);
                                } else {
                                    newTheme.applyStyle(2132083331, true);
                                }
                                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(actionBarThemedContext, 0);
                                contextThemeWrapper.getTheme().setTo(newTheme);
                                panelFeatureState.listPresenterContext = contextThemeWrapper;
                                TypedArray obtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R$styleable.AppCompatTheme);
                                panelFeatureState.background = obtainStyledAttributes.getResourceId(86, 0);
                                panelFeatureState.windowAnimations = obtainStyledAttributes.getResourceId(1, 0);
                                obtainStyledAttributes.recycle();
                                panelFeatureState.decorView = new ListMenuDecorView(panelFeatureState.listPresenterContext);
                                panelFeatureState.gravity = 81;
                            } else if (panelFeatureState.refreshDecorView && listMenuDecorView.getChildCount() > 0) {
                                panelFeatureState.decorView.removeAllViews();
                            }
                            View view = panelFeatureState.createdPanelView;
                            if (view != null) {
                                panelFeatureState.shownPanelView = view;
                            } else {
                                if (panelFeatureState.menu != null) {
                                    if (this.mPanelMenuPresenterCallback == null) {
                                        this.mPanelMenuPresenterCallback = new C00153(this, 4);
                                    }
                                    C00153 r15 = this.mPanelMenuPresenterCallback;
                                    if (panelFeatureState.listMenuPresenter == null) {
                                        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(panelFeatureState.listPresenterContext);
                                        panelFeatureState.listMenuPresenter = listMenuPresenter;
                                        listMenuPresenter.mCallback = r15;
                                        MenuBuilder menuBuilder = panelFeatureState.menu;
                                        menuBuilder.addMenuPresenter(listMenuPresenter, menuBuilder.mContext);
                                    }
                                    ListMenuPresenter listMenuPresenter2 = panelFeatureState.listMenuPresenter;
                                    ListMenuDecorView listMenuDecorView2 = panelFeatureState.decorView;
                                    if (listMenuPresenter2.mMenuView == null) {
                                        listMenuPresenter2.mMenuView = (ExpandedMenuView) listMenuPresenter2.mInflater.inflate(C0130R.layout.abc_expanded_menu_layout, (ViewGroup) listMenuDecorView2, false);
                                        if (listMenuPresenter2.mAdapter == null) {
                                            listMenuPresenter2.mAdapter = new ListMenuPresenter.MenuAdapter();
                                        }
                                        listMenuPresenter2.mMenuView.setAdapter((ListAdapter) listMenuPresenter2.mAdapter);
                                        listMenuPresenter2.mMenuView.setOnItemClickListener(listMenuPresenter2);
                                    }
                                    ExpandedMenuView expandedMenuView = listMenuPresenter2.mMenuView;
                                    panelFeatureState.shownPanelView = expandedMenuView;
                                }
                                panelFeatureState.refreshDecorView = true;
                                return;
                            }
                            if (panelFeatureState.shownPanelView != null) {
                                if (panelFeatureState.createdPanelView == null) {
                                    ListMenuPresenter listMenuPresenter3 = panelFeatureState.listMenuPresenter;
                                    if (listMenuPresenter3.mAdapter == null) {
                                        listMenuPresenter3.mAdapter = new ListMenuPresenter.MenuAdapter();
                                    }
                                }
                                ViewGroup.LayoutParams layoutParams2 = panelFeatureState.shownPanelView.getLayoutParams();
                                if (layoutParams2 == null) {
                                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                                }
                                panelFeatureState.decorView.setBackgroundResource(panelFeatureState.background);
                                ViewParent parent = panelFeatureState.shownPanelView.getParent();
                                if (parent instanceof ViewGroup) {
                                    ((ViewGroup) parent).removeView(panelFeatureState.shownPanelView);
                                }
                                panelFeatureState.decorView.addView(panelFeatureState.shownPanelView, layoutParams2);
                                if (!panelFeatureState.shownPanelView.hasFocus()) {
                                    panelFeatureState.shownPanelView.requestFocus();
                                }
                            }
                            panelFeatureState.refreshDecorView = true;
                            return;
                        }
                        View view2 = panelFeatureState.createdPanelView;
                        if (!(view2 == null || (layoutParams = view2.getLayoutParams()) == null || layoutParams.width != -1)) {
                            i = -1;
                            panelFeatureState.isHandled = false;
                            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
                            layoutParams3.gravity = panelFeatureState.gravity;
                            layoutParams3.windowAnimations = panelFeatureState.windowAnimations;
                            windowManager.addView(panelFeatureState.decorView, layoutParams3);
                            panelFeatureState.isOpen = true;
                            if (i2 != 0) {
                                updateBackInvokedCallbackState();
                                return;
                            }
                            return;
                        }
                        i = -2;
                        panelFeatureState.isHandled = false;
                        WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
                        layoutParams32.gravity = panelFeatureState.gravity;
                        layoutParams32.windowAnimations = panelFeatureState.windowAnimations;
                        windowManager.addView(panelFeatureState.decorView, layoutParams32);
                        panelFeatureState.isOpen = true;
                        if (i2 != 0) {
                        }
                    }
                } else {
                    closePanel(panelFeatureState, true);
                }
            }
        }
    }

    public final boolean performPanelShortcut(PanelFeatureState panelFeatureState, int i, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.isPrepared || preparePanel(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.menu) != null) {
            return menuBuilder.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d5, code lost:
        if (r13.menu == null) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean preparePanel(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        boolean z;
        int i;
        boolean z2;
        DecorContentParent decorContentParent;
        DecorContentParent decorContentParent2;
        DecorContentParent decorContentParent3;
        Resources.Theme theme;
        DecorContentParent decorContentParent4;
        if (!this.mDestroyed) {
            boolean z3 = panelFeatureState.isPrepared;
            int i2 = panelFeatureState.featureId;
            if (z3) {
                return true;
            }
            PanelFeatureState panelFeatureState2 = this.mPreparedPanel;
            if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
                closePanel(panelFeatureState2, false);
            }
            Window.Callback callback = this.mWindow.getCallback();
            if (callback != null) {
                panelFeatureState.createdPanelView = callback.onCreatePanelView(i2);
            }
            if (i2 == 0 || i2 == 108) {
                z = true;
            } else {
                z = false;
            }
            if (z && (decorContentParent4 = this.mDecorContentParent) != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) decorContentParent4;
                actionBarOverlayLayout.pullChildren();
                ((ToolbarWidgetWrapper) actionBarOverlayLayout.mDecorToolbar).mMenuPrepared = true;
            }
            if (panelFeatureState.createdPanelView == null && (!z || !(this.mActionBar instanceof ToolbarActionBar))) {
                MenuBuilder menuBuilder = panelFeatureState.menu;
                if (menuBuilder == null || panelFeatureState.refreshMenuContent) {
                    if (menuBuilder == null) {
                        Context context = this.mContext;
                        if ((i2 == 0 || i2 == 108) && this.mDecorContentParent != null) {
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme theme2 = context.getTheme();
                            theme2.resolveAttribute(C0130R.attr.actionBarTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                                theme.applyStyle(typedValue.resourceId, true);
                                theme.resolveAttribute(C0130R.attr.actionBarWidgetTheme, typedValue, true);
                            } else {
                                theme2.resolveAttribute(C0130R.attr.actionBarWidgetTheme, typedValue, true);
                                theme = null;
                            }
                            if (typedValue.resourceId != 0) {
                                if (theme == null) {
                                    theme = context.getResources().newTheme();
                                    theme.setTo(theme2);
                                }
                                theme.applyStyle(typedValue.resourceId, true);
                            }
                            if (theme != null) {
                                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                                contextThemeWrapper.getTheme().setTo(theme);
                                context = contextThemeWrapper;
                            }
                        }
                        MenuBuilder menuBuilder2 = new MenuBuilder(context);
                        menuBuilder2.mCallback = this;
                        MenuBuilder menuBuilder3 = panelFeatureState.menu;
                        if (menuBuilder2 != menuBuilder3) {
                            if (menuBuilder3 != null) {
                                menuBuilder3.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                            }
                            panelFeatureState.menu = menuBuilder2;
                            ListMenuPresenter listMenuPresenter = panelFeatureState.listMenuPresenter;
                            if (listMenuPresenter != null) {
                                menuBuilder2.addMenuPresenter(listMenuPresenter, menuBuilder2.mContext);
                            }
                        }
                    }
                    if (z && (decorContentParent3 = this.mDecorContentParent) != null) {
                        if (this.mActionMenuPresenterCallback == null) {
                            this.mActionMenuPresenterCallback = new C00153(this, 3);
                        }
                        ((ActionBarOverlayLayout) decorContentParent3).setMenu(panelFeatureState.menu, this.mActionMenuPresenterCallback);
                    }
                    panelFeatureState.menu.stopDispatchingItemsChanged();
                    if (!callback.onCreatePanelMenu(i2, panelFeatureState.menu)) {
                        MenuBuilder menuBuilder4 = panelFeatureState.menu;
                        if (menuBuilder4 != null) {
                            if (menuBuilder4 != null) {
                                menuBuilder4.removeMenuPresenter(panelFeatureState.listMenuPresenter);
                            }
                            panelFeatureState.menu = null;
                        }
                        if (z && (decorContentParent2 = this.mDecorContentParent) != null) {
                            ((ActionBarOverlayLayout) decorContentParent2).setMenu(null, this.mActionMenuPresenterCallback);
                        }
                    } else {
                        panelFeatureState.refreshMenuContent = false;
                    }
                }
                panelFeatureState.menu.stopDispatchingItemsChanged();
                Bundle bundle = panelFeatureState.frozenActionViewState;
                if (bundle != null) {
                    panelFeatureState.menu.restoreActionViewStates(bundle);
                    panelFeatureState.frozenActionViewState = null;
                }
                if (!callback.onPreparePanel(0, panelFeatureState.createdPanelView, panelFeatureState.menu)) {
                    if (z && (decorContentParent = this.mDecorContentParent) != null) {
                        ((ActionBarOverlayLayout) decorContentParent).setMenu(null, this.mActionMenuPresenterCallback);
                    }
                    panelFeatureState.menu.startDispatchingItemsChanged();
                    return false;
                }
                if (keyEvent != null) {
                    i = keyEvent.getDeviceId();
                } else {
                    i = -1;
                }
                if (KeyCharacterMap.load(i).getKeyboardType() != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                panelFeatureState.menu.setQwertyMode(z2);
                panelFeatureState.menu.startDispatchingItemsChanged();
            }
            panelFeatureState.isPrepared = true;
            panelFeatureState.isHandled = false;
            this.mPreparedPanel = panelFeatureState;
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean requestWindowFeature(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.mWindowNoTitle && i == 108) {
            return false;
        }
        if (this.mHasActionBar && i == 1) {
            this.mHasActionBar = false;
        }
        if (i == 1) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mWindowNoTitle = true;
            return true;
        } else if (i == 2) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = true;
            return true;
        } else if (i == 5) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureIndeterminateProgress = true;
            return true;
        } else if (i == 10) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionMode = true;
            return true;
        } else if (i == 108) {
            throwFeatureRequestIfSubDecorInstalled();
            this.mHasActionBar = true;
            return true;
        } else if (i != 109) {
            return this.mWindow.requestFeature(i);
        } else {
            throwFeatureRequestIfSubDecorInstalled();
            this.mOverlayActionBar = true;
            return true;
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.mActionBar;
        if (actionBar != null) {
            actionBar.setWindowTitle(charSequence);
            return;
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0196  */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.Object, androidx.appcompat.view.StandaloneActionMode, androidx.appcompat.view.menu.MenuBuilder$Callback, androidx.appcompat.view.ActionMode] */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.appcompat.app.AppCompatCallback, java.lang.Object] */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final androidx.appcompat.view.ActionMode startSupportActionMode(ActionMode.Callback callback) {
        androidx.appcompat.view.ActionMode onWindowStartingSupportActionMode;
        androidx.appcompat.view.ActionMode actionMode;
        ViewGroup viewGroup;
        if (callback != null) {
            androidx.appcompat.view.ActionMode actionMode2 = this.mActionMode;
            if (actionMode2 != null) {
                actionMode2.finish();
            }
            zzcl zzclVar = new zzcl(2, this, callback, false);
            initWindowDecorActionBar();
            ActionBar actionBar = this.mActionBar;
            ?? r3 = this.mAppCompatCallback;
            if (actionBar != null) {
                androidx.appcompat.view.ActionMode startActionMode = actionBar.startActionMode(zzclVar);
                this.mActionMode = startActionMode;
                if (startActionMode != null) {
                    r3.onSupportActionModeStarted(startActionMode);
                }
            }
            if (this.mActionMode == null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
                if (viewPropertyAnimatorCompat != null) {
                    viewPropertyAnimatorCompat.cancel();
                }
                androidx.appcompat.view.ActionMode actionMode3 = this.mActionMode;
                if (actionMode3 != null) {
                    actionMode3.finish();
                }
                if (!this.mDestroyed) {
                    try {
                        onWindowStartingSupportActionMode = r3.onWindowStartingSupportActionMode(zzclVar);
                    } catch (AbstractMethodError unused) {
                    }
                    if (onWindowStartingSupportActionMode == null) {
                        this.mActionMode = onWindowStartingSupportActionMode;
                    } else {
                        if (this.mActionModeView == null) {
                            if (this.mIsFloating) {
                                TypedValue typedValue = new TypedValue();
                                Context context = this.mContext;
                                Resources.Theme theme = context.getTheme();
                                theme.resolveAttribute(C0130R.attr.actionBarTheme, typedValue, true);
                                if (typedValue.resourceId != 0) {
                                    Resources.Theme newTheme = context.getResources().newTheme();
                                    newTheme.setTo(theme);
                                    newTheme.applyStyle(typedValue.resourceId, true);
                                    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, 0);
                                    contextThemeWrapper.getTheme().setTo(newTheme);
                                    context = contextThemeWrapper;
                                }
                                this.mActionModeView = new ActionBarContextView(context, null);
                                PopupWindow popupWindow = new PopupWindow(context, (AttributeSet) null, (int) C0130R.attr.actionModePopupWindowStyle);
                                this.mActionModePopup = popupWindow;
                                BundleKt.setWindowLayoutType(popupWindow, 2);
                                this.mActionModePopup.setContentView(this.mActionModeView);
                                this.mActionModePopup.setWidth(-1);
                                context.getTheme().resolveAttribute(C0130R.attr.actionBarSize, typedValue, true);
                                this.mActionModeView.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()));
                                this.mActionModePopup.setHeight(-2);
                                this.mShowActionModePopup = new RunnableC00142(this, 1);
                            } else {
                                ViewStubCompat viewStubCompat = (ViewStubCompat) this.mSubDecor.findViewById(C0130R.C0132id.action_mode_bar_stub);
                                if (viewStubCompat != null) {
                                    viewStubCompat.setLayoutInflater(LayoutInflater.from(getActionBarThemedContext()));
                                    this.mActionModeView = (ActionBarContextView) viewStubCompat.inflate();
                                }
                            }
                        }
                        if (this.mActionModeView != null) {
                            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = this.mFadeAnim;
                            if (viewPropertyAnimatorCompat2 != null) {
                                viewPropertyAnimatorCompat2.cancel();
                            }
                            this.mActionModeView.killMode();
                            Context context2 = this.mActionModeView.getContext();
                            ActionBarContextView actionBarContextView = this.mActionModeView;
                            ?? obj = new Object();
                            obj.mContext = context2;
                            obj.mContextView = actionBarContextView;
                            obj.mCallback = zzclVar;
                            MenuBuilder menuBuilder = new MenuBuilder(actionBarContextView.getContext());
                            menuBuilder.mDefaultShowAsAction = 1;
                            obj.mMenu = menuBuilder;
                            menuBuilder.mCallback = obj;
                            if (((ActionMode.Callback) zzclVar.zzb).onCreateActionMode(obj, menuBuilder)) {
                                obj.invalidate();
                                this.mActionModeView.initForMode(obj);
                                this.mActionMode = obj;
                                if (!this.mSubDecorInstalled || (viewGroup = this.mSubDecor) == null || !viewGroup.isLaidOut()) {
                                    this.mActionModeView.setAlpha(1.0f);
                                    this.mActionModeView.setVisibility(0);
                                    if (this.mActionModeView.getParent() instanceof View) {
                                        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                                        ViewCompat.Api20Impl.requestApplyInsets((View) this.mActionModeView.getParent());
                                    }
                                } else {
                                    this.mActionModeView.setAlpha(0.0f);
                                    ViewPropertyAnimatorCompat animate = ViewCompat.animate(this.mActionModeView);
                                    animate.alpha(1.0f);
                                    this.mFadeAnim = animate;
                                    animate.setListener(new C00167(0, this));
                                }
                                if (this.mActionModePopup != null) {
                                    this.mWindow.getDecorView().post(this.mShowActionModePopup);
                                }
                            } else {
                                this.mActionMode = null;
                            }
                        }
                    }
                    actionMode = this.mActionMode;
                    if (actionMode != null) {
                        r3.onSupportActionModeStarted(actionMode);
                    }
                    updateBackInvokedCallbackState();
                    this.mActionMode = this.mActionMode;
                }
                onWindowStartingSupportActionMode = null;
                if (onWindowStartingSupportActionMode == null) {
                }
                actionMode = this.mActionMode;
                if (actionMode != null) {
                }
                updateBackInvokedCallbackState();
                this.mActionMode = this.mActionMode;
            }
            updateBackInvokedCallbackState();
            return this.mActionMode;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public final void throwFeatureRequestIfSubDecorInstalled() {
        if (this.mSubDecorInstalled) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void updateBackInvokedCallbackState() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.mDispatcher != null && (getPanelState(0).isOpen || this.mActionMode != null)) {
                z = true;
            }
            if (z && this.mBackCallback == null) {
                this.mBackCallback = Api33Impl.registerOnBackPressedCallback(this.mDispatcher, this);
            } else if (!z && (onBackInvokedCallback = this.mBackCallback) != null) {
                Api33Impl.unregisterOnBackInvokedCallback(this.mDispatcher, onBackInvokedCallback);
                this.mBackCallback = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class AutoTimeNightModeManager extends BaseMenuWrapper {
        public final /* synthetic */ int $r8$classId = 1;
        public final Object mTwilightManager;

        public AutoTimeNightModeManager(MatcherMatchResult matcherMatchResult) {
            super(AppCompatDelegateImpl.this);
            this.mTwilightManager = matcherMatchResult;
        }

        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final IntentFilter createIntentFilterForBroadcastReceiver() {
            switch (this.$r8$classId) {
                case 0:
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.TIME_SET");
                    intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
                    intentFilter.addAction("android.intent.action.TIME_TICK");
                    return intentFilter;
                default:
                    IntentFilter intentFilter2 = new IntentFilter();
                    intentFilter2.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                    return intentFilter2;
            }
        }

        /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object, androidx.appcompat.app.TwilightCalculator] */
        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final int getApplyableNightMode() {
            boolean z;
            Location location;
            long j;
            Location location2;
            switch (this.$r8$classId) {
                case 0:
                    MatcherMatchResult matcherMatchResult = (MatcherMatchResult) this.mTwilightManager;
                    TwilightManager$TwilightState twilightManager$TwilightState = (TwilightManager$TwilightState) matcherMatchResult.groups;
                    LocationManager locationManager = (LocationManager) matcherMatchResult.input;
                    if (twilightManager$TwilightState.nextUpdate > System.currentTimeMillis()) {
                        z = twilightManager$TwilightState.isNight;
                    } else {
                        Context context = (Context) matcherMatchResult.matcher;
                        Location location3 = null;
                        if (BundleKt.checkSelfPermission$1(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                            try {
                            } catch (Exception e) {
                                Log.d("TwilightManager", "Failed to get last known location", e);
                            }
                            if (locationManager.isProviderEnabled("network")) {
                                location2 = locationManager.getLastKnownLocation("network");
                                location = location2;
                            }
                            location2 = null;
                            location = location2;
                        } else {
                            location = null;
                        }
                        if (BundleKt.checkSelfPermission$1(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            try {
                                if (locationManager.isProviderEnabled("gps")) {
                                    location3 = locationManager.getLastKnownLocation("gps");
                                }
                            } catch (Exception e2) {
                                Log.d("TwilightManager", "Failed to get last known location", e2);
                            }
                        }
                        if (location3 == null || location == null ? location3 != null : location3.getTime() > location.getTime()) {
                            location = location3;
                        }
                        z = false;
                        if (location != null) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (TwilightCalculator.sInstance == null) {
                                TwilightCalculator.sInstance = new Object();
                            }
                            TwilightCalculator twilightCalculator = TwilightCalculator.sInstance;
                            twilightCalculator.calculateTwilight(location.getLatitude(), location.getLongitude(), currentTimeMillis - Blacklists.BLACKLISTS_UPDATE_MILLIS);
                            twilightCalculator.calculateTwilight(location.getLatitude(), location.getLongitude(), currentTimeMillis);
                            if (twilightCalculator.state == 1) {
                                z = true;
                            }
                            long j2 = twilightCalculator.sunrise;
                            long j3 = twilightCalculator.sunset;
                            twilightCalculator.calculateTwilight(location.getLatitude(), location.getLongitude(), currentTimeMillis + Blacklists.BLACKLISTS_UPDATE_MILLIS);
                            long j4 = twilightCalculator.sunrise;
                            if (j2 == -1 || j3 == -1) {
                                j = currentTimeMillis + 43200000;
                            } else {
                                if (currentTimeMillis > j3) {
                                    j2 = j4;
                                } else if (currentTimeMillis > j2) {
                                    j2 = j3;
                                }
                                j = j2 + 60000;
                            }
                            twilightManager$TwilightState.isNight = z;
                            twilightManager$TwilightState.nextUpdate = j;
                        } else {
                            Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                            int i = Calendar.getInstance().get(11);
                            if (i < 6 || i >= 22) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        return 2;
                    }
                    return 1;
                default:
                    if (Api21Impl.isPowerSaveMode((PowerManager) this.mTwilightManager)) {
                        return 2;
                    }
                    return 1;
            }
        }

        @Override // androidx.appcompat.view.menu.BaseMenuWrapper
        public final void onChange() {
            switch (this.$r8$classId) {
                case 0:
                    AppCompatDelegateImpl.this.applyApplicationSpecificConfig(true, true);
                    return;
                default:
                    AppCompatDelegateImpl.this.applyApplicationSpecificConfig(true, true);
                    return;
            }
        }

        public AutoTimeNightModeManager(Context context) {
            super(AppCompatDelegateImpl.this);
            this.mTwilightManager = (PowerManager) context.getApplicationContext().getSystemService("power");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(int i) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.mContext).inflate(i, viewGroup);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup) this.mSubDecor.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.bypassOnContentChanged(this.mWindow.getCallback());
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
