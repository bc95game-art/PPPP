package androidx.appcompat.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.content.res.CamUtils;
import androidx.core.p002os.BundleKt;
import androidx.core.p002os.LocaleListCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.Navigation;
import androidx.savedstate.SavedStateRegistry;
import com.google.android.gms.common.wrappers.InstantApps;
import java.util.Arrays;
import java.util.LinkedHashSet;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import p004j$.util.Objects;
/* loaded from: classes.dex */
public abstract class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        getSavedStateRegistry().registerSavedStateProvider(DELEGATE_TAG, new C00121(this));
        addOnContextAvailableListener(new OnContextAvailableListener() { // from class: androidx.appcompat.app.AppCompatActivity.2
            @Override // androidx.activity.contextaware.OnContextAvailableListener
            public final void onContextAvailable(ComponentActivity componentActivity) {
                AppCompatActivity appCompatActivity = AppCompatActivity.this;
                AppCompatDelegate delegate = appCompatActivity.getDelegate();
                delegate.installViewFactory();
                appCompatActivity.getSavedStateRegistry().consumeRestoredStateForKey(AppCompatActivity.DELEGATE_TAG);
                delegate.onCreate();
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.ensureSubDecor();
        ((ViewGroup) appCompatDelegateImpl.mSubDecor.findViewById(16908290)).addView(view, layoutParams);
        appCompatDelegateImpl.mAppCompatWindowCallback.bypassOnContentChanged(appCompatDelegateImpl.mWindow.getCallback());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.mBaseContextAttached = true;
        int i = appCompatDelegateImpl.mLocalNightMode;
        if (i == -100) {
            i = AppCompatDelegate.sDefaultNightMode;
        }
        int mapNightMode = appCompatDelegateImpl.mapNightMode(context, i);
        if (AppCompatDelegate.isAutoStorageOptedIn(context) && AppCompatDelegate.isAutoStorageOptedIn(context)) {
            if (Build.VERSION.SDK_INT < 33) {
                synchronized (AppCompatDelegate.sAppLocalesStorageSyncLock) {
                    try {
                        LocaleListCompat localeListCompat = AppCompatDelegate.sRequestedAppLocales;
                        if (localeListCompat == null) {
                            if (AppCompatDelegate.sStoredAppLocales == null) {
                                AppCompatDelegate.sStoredAppLocales = LocaleListCompat.forLanguageTags(NavUtils.readLocales(context));
                            }
                            if (!AppCompatDelegate.sStoredAppLocales.mImpl.isEmpty()) {
                                AppCompatDelegate.sRequestedAppLocales = AppCompatDelegate.sStoredAppLocales;
                            }
                        } else if (!localeListCompat.equals(AppCompatDelegate.sStoredAppLocales)) {
                            LocaleListCompat localeListCompat2 = AppCompatDelegate.sRequestedAppLocales;
                            AppCompatDelegate.sStoredAppLocales = localeListCompat2;
                            NavUtils.persistLocales(context, localeListCompat2.mImpl.toLanguageTags());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } else if (!AppCompatDelegate.sIsFrameworkSyncChecked) {
                AppCompatDelegate.sSerialExecutorForLocalesStorage.execute(new AppCompatDelegate$$ExternalSyntheticLambda0(context, 0));
            }
        }
        LocaleListCompat calculateApplicationLocales = AppCompatDelegateImpl.calculateApplicationLocales(context);
        Configuration configuration = null;
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(AppCompatDelegateImpl.createOverrideAppConfiguration(context, mapNightMode, calculateApplicationLocales, null, false));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            try {
                ((androidx.appcompat.view.ContextThemeWrapper) context).applyOverrideConfiguration(AppCompatDelegateImpl.createOverrideAppConfiguration(context, mapNightMode, calculateApplicationLocales, null, false));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (AppCompatDelegateImpl.sCanReturnDifferentContext) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f = configuration3.fontScale;
                    float f2 = configuration4.fontScale;
                    if (f != f2) {
                        configuration.fontScale = f2;
                    }
                    int i2 = configuration3.mcc;
                    int i3 = configuration4.mcc;
                    if (i2 != i3) {
                        configuration.mcc = i3;
                    }
                    int i4 = configuration3.mnc;
                    int i5 = configuration4.mnc;
                    if (i4 != i5) {
                        configuration.mnc = i5;
                    }
                    int i6 = Build.VERSION.SDK_INT;
                    if (i6 >= 24) {
                        AppCompatDelegateImpl.Api24Impl.generateConfigDelta_locale(configuration3, configuration4, configuration);
                    } else if (!Objects.equals(configuration3.locale, configuration4.locale)) {
                        configuration.locale = configuration4.locale;
                    }
                    int i7 = configuration3.touchscreen;
                    int i8 = configuration4.touchscreen;
                    if (i7 != i8) {
                        configuration.touchscreen = i8;
                    }
                    int i9 = configuration3.keyboard;
                    int i10 = configuration4.keyboard;
                    if (i9 != i10) {
                        configuration.keyboard = i10;
                    }
                    int i11 = configuration3.keyboardHidden;
                    int i12 = configuration4.keyboardHidden;
                    if (i11 != i12) {
                        configuration.keyboardHidden = i12;
                    }
                    int i13 = configuration3.navigation;
                    int i14 = configuration4.navigation;
                    if (i13 != i14) {
                        configuration.navigation = i14;
                    }
                    int i15 = configuration3.navigationHidden;
                    int i16 = configuration4.navigationHidden;
                    if (i15 != i16) {
                        configuration.navigationHidden = i16;
                    }
                    int i17 = configuration3.orientation;
                    int i18 = configuration4.orientation;
                    if (i17 != i18) {
                        configuration.orientation = i18;
                    }
                    int i19 = configuration3.screenLayout & 15;
                    int i20 = configuration4.screenLayout & 15;
                    if (i19 != i20) {
                        configuration.screenLayout |= i20;
                    }
                    int i21 = configuration3.screenLayout & 192;
                    int i22 = configuration4.screenLayout & 192;
                    if (i21 != i22) {
                        configuration.screenLayout |= i22;
                    }
                    int i23 = configuration3.screenLayout & 48;
                    int i24 = configuration4.screenLayout & 48;
                    if (i23 != i24) {
                        configuration.screenLayout |= i24;
                    }
                    int i25 = configuration3.screenLayout & 768;
                    int i26 = configuration4.screenLayout & 768;
                    if (i25 != i26) {
                        configuration.screenLayout |= i26;
                    }
                    if (i6 >= 26) {
                        InstantApps.generateConfigDelta_colorMode(configuration3, configuration4, configuration);
                    }
                    int i27 = configuration3.uiMode & 15;
                    int i28 = configuration4.uiMode & 15;
                    if (i27 != i28) {
                        configuration.uiMode |= i28;
                    }
                    int i29 = configuration3.uiMode & 48;
                    int i30 = configuration4.uiMode & 48;
                    if (i29 != i30) {
                        configuration.uiMode |= i30;
                    }
                    int i31 = configuration3.screenWidthDp;
                    int i32 = configuration4.screenWidthDp;
                    if (i31 != i32) {
                        configuration.screenWidthDp = i32;
                    }
                    int i33 = configuration3.screenHeightDp;
                    int i34 = configuration4.screenHeightDp;
                    if (i33 != i34) {
                        configuration.screenHeightDp = i34;
                    }
                    int i35 = configuration3.smallestScreenWidthDp;
                    int i36 = configuration4.smallestScreenWidthDp;
                    if (i35 != i36) {
                        configuration.smallestScreenWidthDp = i36;
                    }
                    int i37 = configuration3.densityDpi;
                    int i38 = configuration4.densityDpi;
                    if (i37 != i38) {
                        configuration.densityDpi = i38;
                    }
                }
            }
            Configuration createOverrideAppConfiguration = AppCompatDelegateImpl.createOverrideAppConfiguration(context, mapNightMode, calculateApplicationLocales, configuration, true);
            androidx.appcompat.view.ContextThemeWrapper contextThemeWrapper = new androidx.appcompat.view.ContextThemeWrapper(context, 2132083343);
            contextThemeWrapper.applyOverrideConfiguration(createOverrideAppConfiguration);
            try {
                if (context.getTheme() != null) {
                    CamUtils.rebase(contextThemeWrapper.getTheme());
                }
            } catch (NullPointerException unused3) {
            }
            context = contextThemeWrapper;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.closeOptionsMenu()) {
            super.closeOptionsMenu();
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.onMenuKeyEvent(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.ensureSubDecor();
        return (T) appCompatDelegateImpl.mWindow.findViewById(i);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            AppCompatDelegate.SerialExecutor serialExecutor = AppCompatDelegate.sSerialExecutorForLocalesStorage;
            this.mDelegate = new AppCompatDelegateImpl(this, null, this, this);
        }
        return this.mDelegate;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.DelegateProvider
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.getClass();
        return new AppCompatDelegateImpl.C00153(appCompatDelegateImpl, 2);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        Context context;
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mMenuInflater == null) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar != null) {
                context = actionBar.getThemedContext();
            } else {
                context = appCompatDelegateImpl.mContext;
            }
            appCompatDelegateImpl.mMenuInflater = new SupportMenuInflater(context);
        }
        return appCompatDelegateImpl.mMenuInflater;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i = VectorEnabledTintResources.$r8$clinit;
        }
        if (resources == null) {
            return super.getResources();
        }
        return resources;
    }

    public ActionBar getSupportActionBar() {
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        return appCompatDelegateImpl.mActionBar;
    }

    @Override // androidx.core.app.TaskStackBuilder.SupportParentable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mHasActionBar && appCompatDelegateImpl.mSubDecorInstalled) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (actionBar != null) {
                actionBar.onConfigurationChanged();
            }
        }
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        Context context = appCompatDelegateImpl.mContext;
        synchronized (appCompatDrawableManager) {
            appCompatDrawableManager.mResourceManager.onConfigurationChanged(context);
        }
        appCompatDelegateImpl.mEffectiveConfiguration = new Configuration(appCompatDelegateImpl.mContext.getResources().getConfiguration());
        appCompatDelegateImpl.applyApplicationSpecificConfig(false, false);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.getClass();
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = NavUtils.getParentActivityIntent(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(taskStackBuilder.mSourceContext.getPackageManager());
            }
            taskStackBuilder.addParentStack(component);
            taskStackBuilder.mIntents.add(supportParentActivityIntent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void onLocalesChanged(LocaleListCompat localeListCompat) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onNightModeChanged(int i) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((AppCompatDelegateImpl) getDelegate()).ensureSubDecor();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ((AppCompatDelegateImpl) getDelegate()).applyApplicationSpecificConfig(true, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        appCompatDelegateImpl.initWindowDecorActionBar();
        ActionBar actionBar = appCompatDelegateImpl.mActionBar;
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            TaskStackBuilder taskStackBuilder = new TaskStackBuilder(this);
            onCreateSupportNavigateUpTaskStack(taskStackBuilder);
            onPrepareSupportNavigateUpTaskStack(taskStackBuilder);
            taskStackBuilder.startActivities();
            try {
                finishAffinity();
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.openOptionsMenu()) {
            super.openOptionsMenu();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        initializeViewTreeOwners();
        getDelegate().setContentView(i);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        CharSequence charSequence;
        AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) getDelegate();
        if (appCompatDelegateImpl.mHost instanceof Activity) {
            appCompatDelegateImpl.initWindowDecorActionBar();
            ActionBar actionBar = appCompatDelegateImpl.mActionBar;
            if (!(actionBar instanceof WindowDecorActionBar)) {
                appCompatDelegateImpl.mMenuInflater = null;
                if (actionBar != null) {
                    actionBar.onDestroy();
                }
                appCompatDelegateImpl.mActionBar = null;
                if (toolbar != null) {
                    Object obj = appCompatDelegateImpl.mHost;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = appCompatDelegateImpl.mTitle;
                    }
                    ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, charSequence, appCompatDelegateImpl.mAppCompatWindowCallback);
                    appCompatDelegateImpl.mActionBar = toolbarActionBar;
                    appCompatDelegateImpl.mAppCompatWindowCallback.mActionBarCallback = toolbarActionBar.mMenuCallback;
                    toolbar.setBackInvokedCallbackEnabled(true);
                } else {
                    appCompatDelegateImpl.mAppCompatWindowCallback.mActionBarCallback = null;
                }
                appCompatDelegateImpl.invalidateOptionsMenu();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        ((AppCompatDelegateImpl) getDelegate()).mThemeResId = i;
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return getDelegate().startSupportActionMode(callback);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().requestWindowFeature(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    /* renamed from: androidx.appcompat.app.AppCompatActivity$1 */
    /* loaded from: classes.dex */
    public final class C00121 implements SavedStateRegistry.SavedStateProvider {
        public final /* synthetic */ int $r8$classId;
        public final Object this$0;

        public C00121(SavedStateRegistry savedStateRegistry) {
            this.$r8$classId = 1;
            this.this$0 = new LinkedHashSet();
            savedStateRegistry.registerSavedStateProvider("androidx.savedstate.Restarter", this);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public final Bundle saveState() {
            switch (this.$r8$classId) {
                case 0:
                    Bundle bundle = new Bundle();
                    ((AppCompatActivity) this.this$0).getDelegate().getClass();
                    return bundle;
                default:
                    Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    Navigation.m656putStringListimpl(bundleOf, "classes_to_restore", CollectionsKt.toList((LinkedHashSet) this.this$0));
                    return bundleOf;
            }
        }

        public C00121(AppCompatActivity appCompatActivity) {
            this.$r8$classId = 0;
            this.this$0 = appCompatActivity;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        getDelegate().setContentView(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        getDelegate().setContentView(view, layoutParams);
    }
}
