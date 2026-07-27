package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityCompat$$ExternalSyntheticLambda0;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda1;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.navigation.Navigation;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import androidx.tracing.Trace;
import androidx.viewpager2.widget.FakeDrag;
import com.emanuelef.remote_capture.C0130R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public abstract class ComponentActivity extends androidx.core.app.ComponentActivity implements ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, MenuHost {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private int mContentLayoutId;
    private ViewModelProvider.Factory mDefaultFactory;
    final FullyDrawnReporter mFullyDrawnReporter;
    final ReportFullyDrawnExecutor mReportFullyDrawnExecutor;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;
    final ContextAwareHelper mContextAwareHelper = new ContextAwareHelper();
    private final MenuHostHelper mMenuHostHelper = new MenuHostHelper(new ActivityCompat$$ExternalSyntheticLambda0(1, this));
    private final LifecycleRegistry mLifecycleRegistry = new LifecycleRegistry(this);
    private OnBackPressedDispatcher mOnBackPressedDispatcher = null;
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ActivityResultRegistry mActivityResultRegistry = new ActivityResultRegistry() { // from class: androidx.activity.ComponentActivity.1
        {
            ComponentActivity.this = this;
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public final void onLaunch(int i, ActivityResultContract activityResultContract, Object obj) {
            Bundle bundle;
            int i2;
            ComponentActivity componentActivity = ComponentActivity.this;
            FakeDrag synchronousResult = activityResultContract.getSynchronousResult(componentActivity, obj);
            if (synchronousResult != null) {
                new Handler(Looper.getMainLooper()).post(new ActivityCompat.RunnableC00421(this, i, synchronousResult, 1));
                return;
            }
            Intent createIntent = activityResultContract.createIntent(componentActivity, obj);
            if (createIntent.getExtras() != null && createIntent.getExtras().getClassLoader() == null) {
                createIntent.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (createIntent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = createIntent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                createIntent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            } else {
                bundle = null;
            }
            Bundle bundle2 = bundle;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(createIntent.getAction())) {
                String[] stringArrayExtra = createIntent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                ActivityCompat.requestPermissions(componentActivity, stringArrayExtra, i);
            } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(createIntent.getAction())) {
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) createIntent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    i2 = i;
                    try {
                        componentActivity.startIntentSenderForResult(intentSenderRequest.intentSender, i2, intentSenderRequest.fillInIntent, intentSenderRequest.flagsMask, intentSenderRequest.flagsValues, 0, bundle2);
                    } catch (IntentSender.SendIntentException e) {
                        e = e;
                        new Handler(Looper.getMainLooper()).post(new ActivityCompat.RunnableC00421(this, i2, e, 2));
                    }
                } catch (IntentSender.SendIntentException e2) {
                    e = e2;
                    i2 = i;
                }
            } else {
                componentActivity.startActivityForResult(createIntent, i, bundle2);
            }
        }
    };
    private final CopyOnWriteArrayList<Consumer> mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<Consumer> mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<Consumer> mOnNewIntentListeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<Consumer> mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<Consumer> mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
    private boolean mDispatchingOnMultiWindowModeChanged = false;
    private boolean mDispatchingOnPictureInPictureModeChanged = false;

    /* loaded from: classes.dex */
    public abstract class Api33Impl {
        public static OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* loaded from: classes.dex */
    public final class NonConfigurationInstances {
        public Object custom;
        public ViewModelStore viewModelStore;
    }

    /* loaded from: classes.dex */
    public interface ReportFullyDrawnExecutor extends Executor {
        void viewCreated(View view);
    }

    /* loaded from: classes.dex */
    public final class ReportFullyDrawnExecutorApi16Impl implements ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {
        public final long mEndWatchTimeMillis = SystemClock.uptimeMillis() + 10000;
        public boolean mOnDrawScheduled = false;
        public Runnable mRunnable;

        public ReportFullyDrawnExecutorApi16Impl() {
            ComponentActivity.this = r5;
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.mRunnable = runnable;
            View decorView = ComponentActivity.this.getWindow().getDecorView();
            if (!this.mOnDrawScheduled) {
                decorView.postOnAnimation(new ActivityCompat$$ExternalSyntheticLambda0(2, this));
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public final void onDraw() {
            boolean z;
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
                this.mRunnable = null;
                FullyDrawnReporter fullyDrawnReporter = ComponentActivity.this.mFullyDrawnReporter;
                synchronized (fullyDrawnReporter.lock) {
                    z = fullyDrawnReporter.reportedFullyDrawn;
                }
                if (z) {
                    this.mOnDrawScheduled = false;
                    ComponentActivity.this.getWindow().getDecorView().post(this);
                }
            } else if (SystemClock.uptimeMillis() > this.mEndWatchTimeMillis) {
                this.mOnDrawScheduled = false;
                ComponentActivity.this.getWindow().getDecorView().post(this);
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComponentActivity.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.ComponentActivity.ReportFullyDrawnExecutor
        public final void viewCreated(View view) {
            if (!this.mOnDrawScheduled) {
                this.mOnDrawScheduled = true;
                view.getViewTreeObserver().addOnDrawListener(this);
            }
        }
    }

    public static void $r8$lambda$278Cq622rQ9X9WaDkyOm2xm3rFw(ComponentActivity componentActivity) {
        Bundle consumeRestoredStateForKey = componentActivity.getSavedStateRegistry().consumeRestoredStateForKey(ACTIVITY_RESULT_TAG);
        if (consumeRestoredStateForKey != null) {
            ActivityResultRegistry activityResultRegistry = componentActivity.mActivityResultRegistry;
            HashMap hashMap = activityResultRegistry.mKeyToRc;
            HashMap hashMap2 = activityResultRegistry.mRcToKey;
            Bundle bundle = activityResultRegistry.mPendingResults;
            ArrayList<Integer> integerArrayList = consumeRestoredStateForKey.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = consumeRestoredStateForKey.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (!(stringArrayList == null || integerArrayList == null)) {
                activityResultRegistry.mLaunchedKeys = consumeRestoredStateForKey.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                bundle.putAll(consumeRestoredStateForKey.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                for (int i = 0; i < stringArrayList.size(); i++) {
                    String str = stringArrayList.get(i);
                    if (hashMap.containsKey(str)) {
                        Integer num = (Integer) hashMap.remove(str);
                        if (!bundle.containsKey(str)) {
                            hashMap2.remove(num);
                        }
                    }
                    Integer num2 = integerArrayList.get(i);
                    num2.intValue();
                    String str2 = stringArrayList.get(i);
                    hashMap2.put(num2, str2);
                    activityResultRegistry.mKeyToRc.put(str2, num2);
                }
            }
        }
    }

    /* renamed from: $r8$lambda$71Q7mCYu4-mmbn-a-hJ05KgHel0 */
    public static Bundle m631$r8$lambda$71Q7mCYu4mmbnahJ05KgHel0(ComponentActivity componentActivity) {
        Bundle bundle = new Bundle();
        ActivityResultRegistry activityResultRegistry = componentActivity.mActivityResultRegistry;
        activityResultRegistry.getClass();
        HashMap hashMap = activityResultRegistry.mKeyToRc;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(hashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(hashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(activityResultRegistry.mLaunchedKeys));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) activityResultRegistry.mPendingResults.clone());
        return bundle;
    }

    public ComponentActivity() {
        SavedStateRegistryController savedStateRegistryController = new SavedStateRegistryController(new SavedStateRegistryImpl(this, new ComponentActivity$$ExternalSyntheticLambda1(4, this)));
        this.mSavedStateRegistryController = savedStateRegistryController;
        ReportFullyDrawnExecutorApi16Impl reportFullyDrawnExecutorApi16Impl = new ReportFullyDrawnExecutorApi16Impl();
        this.mReportFullyDrawnExecutor = reportFullyDrawnExecutorApi16Impl;
        this.mFullyDrawnReporter = new FullyDrawnReporter(reportFullyDrawnExecutorApi16Impl, new ComponentActivity$$ExternalSyntheticLambda1(0, this));
        if (getLifecycle() != null) {
            int i = Build.VERSION.SDK_INT;
            getLifecycle().addObserver(new ImmLeaksCleaner(this, 2));
            getLifecycle().addObserver(new ImmLeaksCleaner(this, 1));
            getLifecycle().addObserver(new ImmLeaksCleaner(this, 3));
            savedStateRegistryController.performAttach();
            SavedStateHandleSupport.enableSavedStateHandles(this);
            if (i <= 23) {
                Lifecycle lifecycle = getLifecycle();
                ImmLeaksCleaner immLeaksCleaner = new ImmLeaksCleaner();
                immLeaksCleaner.mActivity = this;
                lifecycle.addObserver(immLeaksCleaner);
            }
            getSavedStateRegistry().registerSavedStateProvider(ACTIVITY_RESULT_TAG, new ComponentActivity$$ExternalSyntheticLambda2(0, this));
            addOnContextAvailableListener(new OnContextAvailableListener() { // from class: androidx.activity.ComponentActivity$$ExternalSyntheticLambda3
                @Override // androidx.activity.contextaware.OnContextAvailableListener
                public final void onContextAvailable(ComponentActivity componentActivity) {
                    ComponentActivity.$r8$lambda$278Cq622rQ9X9WaDkyOm2xm3rFw(ComponentActivity.this);
                }
            });
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.core.view.MenuHost
    public void addMenuProvider(MenuProvider menuProvider) {
        MenuHostHelper menuHostHelper = this.mMenuHostHelper;
        menuHostHelper.mMenuProviders.add(menuProvider);
        menuHostHelper.mOnInvalidateMenuCallback.run();
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void addOnConfigurationChangedListener(Consumer consumer) {
        this.mOnConfigurationChangedListeners.add(consumer);
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener listener) {
        ContextAwareHelper contextAwareHelper = this.mContextAwareHelper;
        contextAwareHelper.getClass();
        Intrinsics.checkNotNullParameter(listener, "listener");
        ComponentActivity componentActivity = contextAwareHelper.context;
        if (componentActivity != null) {
            listener.onContextAvailable(componentActivity);
        }
        contextAwareHelper.listeners.add(listener);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void addOnMultiWindowModeChangedListener(Consumer consumer) {
        this.mOnMultiWindowModeChangedListeners.add(consumer);
    }

    public final void addOnNewIntentListener(Consumer consumer) {
        this.mOnNewIntentListeners.add(consumer);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void addOnPictureInPictureModeChangedListener(Consumer consumer) {
        this.mOnPictureInPictureModeChangedListeners.add(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void addOnTrimMemoryListener(Consumer consumer) {
        this.mOnTrimMemoryListeners.add(consumer);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this.mViewModelStore = nonConfigurationInstances.viewModelStore;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
    }

    @Override // androidx.activity.result.ActivityResultRegistryOwner
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(0);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = mutableCreationExtras.extras;
        if (application != null) {
            linkedHashMap.put(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, getApplication());
        }
        linkedHashMap.put(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        linkedHashMap.put(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            linkedHashMap.put(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        }
        return mutableCreationExtras;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Bundle bundle;
        if (this.mDefaultFactory == null) {
            Application application = getApplication();
            if (getIntent() != null) {
                bundle = getIntent().getExtras();
            } else {
                bundle = null;
            }
            this.mDefaultFactory = new SavedStateViewModelFactory(application, this, bundle);
        }
        return this.mDefaultFactory;
    }

    public FullyDrawnReporter getFullyDrawnReporter() {
        return this.mFullyDrawnReporter;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.custom;
        }
        return null;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.OnBackPressedDispatcherOwner
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        if (this.mOnBackPressedDispatcher == null) {
            this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() { // from class: androidx.activity.ComponentActivity.5
                {
                    ComponentActivity.this = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ComponentActivity.super.onBackPressed();
                    } catch (IllegalStateException e) {
                        if (!TextUtils.equals(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                            throw e;
                        }
                    } catch (NullPointerException e2) {
                        if (!TextUtils.equals(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                            throw e2;
                        }
                    }
                }
            });
            getLifecycle().addObserver(new ImmLeaksCleaner(this, 4));
        }
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.savedStateRegistry;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView, "<this>");
        decorView.setTag(C0130R.C0132id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView2, "<this>");
        decorView2.setTag(C0130R.C0132id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView3, "<this>");
        decorView3.setTag(C0130R.C0132id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView4, "<this>");
        decorView4.setTag(C0130R.C0132id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        Intrinsics.checkNotNullParameter(decorView5, "<this>");
        decorView5.setTag(C0130R.C0132id.report_drawn, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.mActivityResultRegistry.dispatchResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<Consumer> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        SavedStateRegistryImpl savedStateRegistryImpl = this.mSavedStateRegistryController.impl;
        SavedStateRegistryOwner savedStateRegistryOwner = savedStateRegistryImpl.owner;
        if (!savedStateRegistryImpl.attached) {
            savedStateRegistryImpl.performAttach();
        }
        if (((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state.compareTo(Lifecycle.State.STARTED) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + ((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state).toString());
        } else if (!savedStateRegistryImpl.isRestored) {
            Bundle bundle2 = null;
            if (bundle != null && bundle.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
                Bundle bundle3 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                if (bundle3 != null) {
                    bundle2 = bundle3;
                } else {
                    Navigation.keyOrValueNotFoundError("androidx.lifecycle.BundlableSavedStateRegistry.key");
                    throw null;
                }
            }
            savedStateRegistryImpl.restoredState = bundle2;
            savedStateRegistryImpl.isRestored = true;
            ContextAwareHelper contextAwareHelper = this.mContextAwareHelper;
            contextAwareHelper.getClass();
            contextAwareHelper.context = this;
            Iterator it = contextAwareHelper.listeners.iterator();
            while (it.hasNext()) {
                ((OnContextAvailableListener) it.next()).onContextAvailable(this);
            }
            super.onCreate(bundle);
            int i = ReportFragment.$r8$clinit;
            ReportFragment.Companion.injectIfNeededIn(this);
            int i2 = this.mContentLayoutId;
            if (i2 != 0) {
                setContentView(i2);
            }
        } else {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        MenuHostHelper menuHostHelper = this.mMenuHostHelper;
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = menuHostHelper.mMenuProviders.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).onCreateMenu(menu, menuInflater);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            Iterator it = this.mMenuHostHelper.mMenuProviders.iterator();
            while (it.hasNext()) {
                if (((MenuProvider) it.next()).onMenuItemSelected(menuItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (!this.mDispatchingOnMultiWindowModeChanged) {
            Iterator<Consumer> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new MultiWindowModeChangedInfo(z));
            }
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<Consumer> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        Iterator it = this.mMenuHostHelper.mMenuProviders.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).onMenuClosed(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if (!this.mDispatchingOnPictureInPictureModeChanged) {
            Iterator<Consumer> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().accept(new PictureInPictureModeChangedInfo(z));
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = this.mMenuHostHelper.mMenuProviders.iterator();
        while (it.hasNext()) {
            ((MenuProvider) it.next()).onPrepareMenu(menu);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.dispatchResult(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.activity.ComponentActivity$NonConfigurationInstances, java.lang.Object] */
    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.viewModelStore;
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        ?? obj = new Object();
        obj.custom = onRetainCustomNonConfigurationInstance;
        obj.viewModelStore = viewModelStore;
        return obj;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<Consumer> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.context;
    }

    public final <I, O> ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback activityResultCallback) {
        return activityResultRegistry.register("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    @Override // androidx.core.view.MenuHost
    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.removeMenuProvider(menuProvider);
    }

    @Override // androidx.core.content.OnConfigurationChangedProvider
    public final void removeOnConfigurationChangedListener(Consumer consumer) {
        this.mOnConfigurationChangedListeners.remove(consumer);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener listener) {
        ContextAwareHelper contextAwareHelper = this.mContextAwareHelper;
        contextAwareHelper.getClass();
        Intrinsics.checkNotNullParameter(listener, "listener");
        contextAwareHelper.listeners.remove(listener);
    }

    @Override // androidx.core.app.OnMultiWindowModeChangedProvider
    public final void removeOnMultiWindowModeChangedListener(Consumer consumer) {
        this.mOnMultiWindowModeChangedListeners.remove(consumer);
    }

    public final void removeOnNewIntentListener(Consumer consumer) {
        this.mOnNewIntentListeners.remove(consumer);
    }

    @Override // androidx.core.app.OnPictureInPictureModeChangedProvider
    public final void removeOnPictureInPictureModeChangedListener(Consumer consumer) {
        this.mOnPictureInPictureModeChangedListeners.remove(consumer);
    }

    @Override // androidx.core.content.OnTrimMemoryProvider
    public final void removeOnTrimMemoryListener(Consumer consumer) {
        this.mOnTrimMemoryListeners.remove(consumer);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (Trace.isEnabled()) {
                android.os.Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            FullyDrawnReporter fullyDrawnReporter = this.mFullyDrawnReporter;
            synchronized (fullyDrawnReporter.lock) {
                fullyDrawnReporter.reportedFullyDrawn = true;
                ArrayList arrayList = fullyDrawnReporter.onReportCallbacks;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((Function0) obj).invoke();
                }
                fullyDrawnReporter.onReportCallbacks.clear();
            }
            android.os.Trace.endSection();
        } catch (Throwable th) {
            android.os.Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* JADX WARN: Finally extract failed */
    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration newConfig) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, newConfig);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<Consumer> it = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it.hasNext()) {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                it.next().accept(new MultiWindowModeChangedInfo(z));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration newConfig) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, newConfig);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<Consumer> it = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it.hasNext()) {
                Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                it.next().accept(new PictureInPictureModeChangedInfo(z));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> ActivityResultLauncher registerForActivityResult(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        return registerForActivityResult(activityResultContract, this.mActivityResultRegistry, activityResultCallback);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(view);
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        MenuHostHelper menuHostHelper = this.mMenuHostHelper;
        menuHostHelper.mMenuProviders.add(menuProvider);
        menuHostHelper.mOnInvalidateMenuCallback.run();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap hashMap = menuHostHelper.mProviderToLifecycleContainers;
        MenuHostHelper.LifecycleContainer lifecycleContainer = (MenuHostHelper.LifecycleContainer) hashMap.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.mLifecycle.removeObserver(lifecycleContainer.mObserver);
            lifecycleContainer.mObserver = null;
        }
        hashMap.put(menuProvider, new MenuHostHelper.LifecycleContainer(lifecycle, new MenuHostHelper$$ExternalSyntheticLambda1(menuHostHelper, 0, menuProvider)));
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        this.mReportFullyDrawnExecutor.viewCreated(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(final MenuProvider menuProvider, LifecycleOwner lifecycleOwner, final Lifecycle.State state) {
        final MenuHostHelper menuHostHelper = this.mMenuHostHelper;
        menuHostHelper.getClass();
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        HashMap hashMap = menuHostHelper.mProviderToLifecycleContainers;
        MenuHostHelper.LifecycleContainer lifecycleContainer = (MenuHostHelper.LifecycleContainer) hashMap.remove(menuProvider);
        if (lifecycleContainer != null) {
            lifecycleContainer.mLifecycle.removeObserver(lifecycleContainer.mObserver);
            lifecycleContainer.mObserver = null;
        }
        hashMap.put(menuProvider, new MenuHostHelper.LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.MenuHostHelper$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                Lifecycle.Event event2;
                MenuHostHelper menuHostHelper2 = MenuHostHelper.this;
                menuHostHelper2.getClass();
                Runnable runnable = menuHostHelper2.mOnInvalidateMenuCallback;
                CopyOnWriteArrayList copyOnWriteArrayList = menuHostHelper2.mMenuProviders;
                Lifecycle.Event.Companion.getClass();
                Lifecycle.State state2 = state;
                Intrinsics.checkNotNullParameter(state2, "state");
                int ordinal = state2.ordinal();
                Lifecycle.Event event3 = null;
                if (ordinal == 2) {
                    event2 = Lifecycle.Event.ON_CREATE;
                } else if (ordinal == 3) {
                    event2 = Lifecycle.Event.ON_START;
                } else if (ordinal != 4) {
                    event2 = null;
                } else {
                    event2 = Lifecycle.Event.ON_RESUME;
                }
                MenuProvider menuProvider2 = menuProvider;
                if (event == event2) {
                    copyOnWriteArrayList.add(menuProvider2);
                    runnable.run();
                    return;
                }
                Lifecycle.Event event4 = Lifecycle.Event.ON_DESTROY;
                if (event == event4) {
                    menuHostHelper2.removeMenuProvider(menuProvider2);
                    return;
                }
                int ordinal2 = state2.ordinal();
                if (ordinal2 == 2) {
                    event3 = event4;
                } else if (ordinal2 == 3) {
                    event3 = Lifecycle.Event.ON_STOP;
                } else if (ordinal2 == 4) {
                    event3 = Lifecycle.Event.ON_PAUSE;
                }
                if (event == event3) {
                    copyOnWriteArrayList.remove(menuProvider2);
                    runnable.run();
                }
            }
        }));
    }
}
