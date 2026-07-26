package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.BackEventCompat;
import androidx.activity.Cancellable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcher$addCallback$1;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.os.BundleKt;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.emoji2.text.MetadataRepo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.Navigation;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.transition.ViewUtilsApi21;
import androidx.viewpager2.widget.FakeDrag;
import com.emanuelef.remote_capture.R;
import com.google.android.gms.common.zzb;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public abstract class FragmentManager {
    public FragmentContainer mContainer;
    public ArrayList mCreatedMenus;
    public boolean mDestroyed;
    public boolean mExecutingActions;
    public boolean mHavePendingDeferredStart;
    public FragmentHostCallback mHost;
    public boolean mNeedMenuInvalidate;
    public FragmentManagerViewModel mNonConfig;
    public OnBackPressedDispatcher mOnBackPressedDispatcher;
    public Fragment mParent;
    public Fragment mPrimaryNav;
    public ActivityResultRegistry.AnonymousClass2 mRequestPermissions;
    public ActivityResultRegistry.AnonymousClass2 mStartActivityForResult;
    public ActivityResultRegistry.AnonymousClass2 mStartIntentSenderForResult;
    public boolean mStateSaved;
    public boolean mStopped;
    public ArrayList mTmpAddedFragments;
    public ArrayList mTmpIsPop;
    public ArrayList mTmpRecords;
    public final ArrayList mPendingActions = new ArrayList();
    public final FragmentStore mFragmentStore = new FragmentStore();
    public ArrayList mBackStack = new ArrayList();
    public final FragmentLayoutInflaterFactory mLayoutInflaterFactory = new FragmentLayoutInflaterFactory(this);
    public BackStackRecord mTransitioningOp = null;
    public boolean mHandlingTransitioningOp = false;
    public final AnonymousClass1 mOnBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.fragment.app.FragmentManager.1
        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackCancelled() {
            boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
            FragmentManager fragmentManager = FragmentManager.this;
            if (isLoggingEnabled) {
                Log.d("FragmentManager", "handleOnBackCancelled. PREDICTIVE_BACK = true fragment manager " + fragmentManager);
            }
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "cancelBackStackTransition for transition " + fragmentManager.mTransitioningOp);
            }
            BackStackRecord backStackRecord = fragmentManager.mTransitioningOp;
            if (backStackRecord != null) {
                backStackRecord.mCommitted = false;
                backStackRecord.collapseOps();
                BackStackRecord backStackRecord2 = fragmentManager.mTransitioningOp;
                Fragment$$ExternalSyntheticLambda1 fragment$$ExternalSyntheticLambda1 = new Fragment$$ExternalSyntheticLambda1(4, fragmentManager);
                if (backStackRecord2.mCommitRunnables == null) {
                    backStackRecord2.mCommitRunnables = new ArrayList();
                }
                backStackRecord2.mCommitRunnables.add(fragment$$ExternalSyntheticLambda1);
                fragmentManager.mTransitioningOp.commit();
                fragmentManager.mHandlingTransitioningOp = true;
                fragmentManager.execPendingActions(true);
                fragmentManager.forcePostponedTransactions();
                fragmentManager.mHandlingTransitioningOp = false;
                fragmentManager.mTransitioningOp = null;
            }
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackPressed() {
            boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
            FragmentManager fragmentManager = FragmentManager.this;
            if (isLoggingEnabled) {
                Log.d("FragmentManager", "handleOnBackPressed. PREDICTIVE_BACK = true fragment manager " + fragmentManager);
            }
            AnonymousClass1 r1 = fragmentManager.mOnBackPressedCallback;
            ArrayList arrayList = fragmentManager.mBackStackChangeListeners;
            fragmentManager.mHandlingTransitioningOp = true;
            fragmentManager.execPendingActions(true);
            int i = 0;
            fragmentManager.mHandlingTransitioningOp = false;
            if (fragmentManager.mTransitioningOp != null) {
                if (!arrayList.isEmpty()) {
                    LinkedHashSet<Fragment> linkedHashSet = new LinkedHashSet(FragmentManager.fragmentsFromRecord(fragmentManager.mTransitioningOp));
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        OnBackStackChangedListener onBackStackChangedListener = (OnBackStackChangedListener) obj;
                        for (Fragment fragment : linkedHashSet) {
                            onBackStackChangedListener.onBackStackChangeCommitted(fragment, true);
                        }
                    }
                }
                ArrayList arrayList2 = fragmentManager.mTransitioningOp.mOps;
                int size2 = arrayList2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    Fragment fragment2 = ((FragmentTransaction.Op) obj2).mFragment;
                    if (fragment2 != null) {
                        fragment2.mTransitioning = false;
                    }
                }
                Iterator it = fragmentManager.collectChangedControllers(new ArrayList(Collections.singletonList(fragmentManager.mTransitioningOp)), 0, 1).iterator();
                while (it.hasNext()) {
                    DefaultSpecialEffectsController defaultSpecialEffectsController = (DefaultSpecialEffectsController) it.next();
                    ArrayList arrayList3 = defaultSpecialEffectsController.runningOperations;
                    if (FragmentManager.isLoggingEnabled(3)) {
                        Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
                    }
                    defaultSpecialEffectsController.processStart(arrayList3);
                    defaultSpecialEffectsController.commitEffects$fragment_release(arrayList3);
                }
                ArrayList arrayList4 = fragmentManager.mTransitioningOp.mOps;
                int size3 = arrayList4.size();
                while (i < size3) {
                    Object obj3 = arrayList4.get(i);
                    i++;
                    Fragment fragment3 = ((FragmentTransaction.Op) obj3).mFragment;
                    if (fragment3 != null && fragment3.mContainer == null) {
                        fragmentManager.createOrGetFragmentStateManager(fragment3).moveToExpectedState();
                    }
                }
                fragmentManager.mTransitioningOp = null;
                fragmentManager.updateOnBackPressedCallbackEnabled();
                if (FragmentManager.isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "Op is being set to null");
                    Log.d("FragmentManager", "OnBackPressedCallback enabled=" + r1.isEnabled + " for  FragmentManager " + fragmentManager);
                }
            } else if (r1.isEnabled) {
                if (FragmentManager.isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "Calling popBackStackImmediate via onBackPressed callback");
                }
                fragmentManager.popBackStackImmediate();
            } else {
                if (FragmentManager.isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "Calling onBackPressed via onBackPressed callback");
                }
                fragmentManager.mOnBackPressedDispatcher.onBackPressed();
            }
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackProgressed(BackEventCompat backEvent) {
            boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(2);
            FragmentManager fragmentManager = FragmentManager.this;
            if (isLoggingEnabled) {
                Log.v("FragmentManager", "handleOnBackProgressed. PREDICTIVE_BACK = true fragment manager " + fragmentManager);
            }
            if (fragmentManager.mTransitioningOp != null) {
                int i = 0;
                Iterator it = fragmentManager.collectChangedControllers(new ArrayList(Collections.singletonList(fragmentManager.mTransitioningOp)), 0, 1).iterator();
                while (it.hasNext()) {
                    DefaultSpecialEffectsController defaultSpecialEffectsController = (DefaultSpecialEffectsController) it.next();
                    defaultSpecialEffectsController.getClass();
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + backEvent.progress);
                    }
                    ArrayList arrayList = defaultSpecialEffectsController.runningOperations;
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj = arrayList.get(i2);
                        i2++;
                        CollectionsKt__MutableCollectionsKt.addAll(((SpecialEffectsController$FragmentStateManagerOperation) obj).effects, arrayList2);
                    }
                    List list = CollectionsKt.toList(CollectionsKt.toSet(arrayList2));
                    int size2 = list.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        ((SpecialEffectsController$Effect) list.get(i3)).onProgress(backEvent, defaultSpecialEffectsController.container);
                    }
                }
                ArrayList arrayList3 = fragmentManager.mBackStackChangeListeners;
                int size3 = arrayList3.size();
                while (i < size3) {
                    Object obj2 = arrayList3.get(i);
                    i++;
                    ((OnBackStackChangedListener) obj2).onBackStackChangeProgressed(backEvent);
                }
            }
        }

        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackStarted(BackEventCompat backEventCompat) {
            boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
            FragmentManager fragmentManager = FragmentManager.this;
            if (isLoggingEnabled) {
                Log.d("FragmentManager", "handleOnBackStarted. PREDICTIVE_BACK = true fragment manager " + fragmentManager);
            }
            fragmentManager.endAnimatingAwayFragments();
            fragmentManager.enqueueAction(new PrepareBackStackTransitionState(), false);
        }
    };
    public final AtomicInteger mBackStackIndex = new AtomicInteger();
    public final Map mBackStackStates = DesugarCollections.synchronizedMap(new HashMap());
    public final Map mResults = DesugarCollections.synchronizedMap(new HashMap());
    public final ArrayList mBackStackChangeListeners = new ArrayList();
    public final FragmentAnim$AnimationOrAnimator mLifecycleCallbacksDispatcher = new FragmentAnim$AnimationOrAnimator(this);
    public final CopyOnWriteArrayList mOnAttachListeners = new CopyOnWriteArrayList();
    public final FragmentManager$$ExternalSyntheticLambda0 mOnConfigurationChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0
        public final /* synthetic */ FragmentManager f$0;

        {
            this.f$0 = this;
        }

        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            switch (r2) {
                case 0:
                    Configuration configuration = (Configuration) obj;
                    FragmentManager fragmentManager = this.f$0;
                    if (fragmentManager.isParentAdded()) {
                        fragmentManager.dispatchConfigurationChanged(false, configuration);
                        return;
                    }
                    return;
                case 1:
                    Integer num = (Integer) obj;
                    FragmentManager fragmentManager2 = this.f$0;
                    if (fragmentManager2.isParentAdded() && num.intValue() == 80) {
                        fragmentManager2.dispatchLowMemory(false);
                        return;
                    }
                    return;
                case 2:
                    MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                    FragmentManager fragmentManager3 = this.f$0;
                    if (fragmentManager3.isParentAdded()) {
                        fragmentManager3.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        return;
                    }
                    return;
                default:
                    PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                    FragmentManager fragmentManager4 = this.f$0;
                    if (fragmentManager4.isParentAdded()) {
                        fragmentManager4.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        return;
                    }
                    return;
            }
        }
    };
    public final FragmentManager$$ExternalSyntheticLambda0 mOnTrimMemoryListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0
        public final /* synthetic */ FragmentManager f$0;

        {
            this.f$0 = this;
        }

        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            switch (r2) {
                case 0:
                    Configuration configuration = (Configuration) obj;
                    FragmentManager fragmentManager = this.f$0;
                    if (fragmentManager.isParentAdded()) {
                        fragmentManager.dispatchConfigurationChanged(false, configuration);
                        return;
                    }
                    return;
                case 1:
                    Integer num = (Integer) obj;
                    FragmentManager fragmentManager2 = this.f$0;
                    if (fragmentManager2.isParentAdded() && num.intValue() == 80) {
                        fragmentManager2.dispatchLowMemory(false);
                        return;
                    }
                    return;
                case 2:
                    MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                    FragmentManager fragmentManager3 = this.f$0;
                    if (fragmentManager3.isParentAdded()) {
                        fragmentManager3.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        return;
                    }
                    return;
                default:
                    PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                    FragmentManager fragmentManager4 = this.f$0;
                    if (fragmentManager4.isParentAdded()) {
                        fragmentManager4.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        return;
                    }
                    return;
            }
        }
    };
    public final FragmentManager$$ExternalSyntheticLambda0 mOnMultiWindowModeChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0
        public final /* synthetic */ FragmentManager f$0;

        {
            this.f$0 = this;
        }

        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            switch (r2) {
                case 0:
                    Configuration configuration = (Configuration) obj;
                    FragmentManager fragmentManager = this.f$0;
                    if (fragmentManager.isParentAdded()) {
                        fragmentManager.dispatchConfigurationChanged(false, configuration);
                        return;
                    }
                    return;
                case 1:
                    Integer num = (Integer) obj;
                    FragmentManager fragmentManager2 = this.f$0;
                    if (fragmentManager2.isParentAdded() && num.intValue() == 80) {
                        fragmentManager2.dispatchLowMemory(false);
                        return;
                    }
                    return;
                case 2:
                    MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                    FragmentManager fragmentManager3 = this.f$0;
                    if (fragmentManager3.isParentAdded()) {
                        fragmentManager3.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        return;
                    }
                    return;
                default:
                    PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                    FragmentManager fragmentManager4 = this.f$0;
                    if (fragmentManager4.isParentAdded()) {
                        fragmentManager4.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        return;
                    }
                    return;
            }
        }
    };
    public final FragmentManager$$ExternalSyntheticLambda0 mOnPictureInPictureModeChangedListener = new Consumer(this) { // from class: androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0
        public final /* synthetic */ FragmentManager f$0;

        {
            this.f$0 = this;
        }

        @Override // androidx.core.util.Consumer
        public final void accept(Object obj) {
            switch (r2) {
                case 0:
                    Configuration configuration = (Configuration) obj;
                    FragmentManager fragmentManager = this.f$0;
                    if (fragmentManager.isParentAdded()) {
                        fragmentManager.dispatchConfigurationChanged(false, configuration);
                        return;
                    }
                    return;
                case 1:
                    Integer num = (Integer) obj;
                    FragmentManager fragmentManager2 = this.f$0;
                    if (fragmentManager2.isParentAdded() && num.intValue() == 80) {
                        fragmentManager2.dispatchLowMemory(false);
                        return;
                    }
                    return;
                case 2:
                    MultiWindowModeChangedInfo multiWindowModeChangedInfo = (MultiWindowModeChangedInfo) obj;
                    FragmentManager fragmentManager3 = this.f$0;
                    if (fragmentManager3.isParentAdded()) {
                        fragmentManager3.dispatchMultiWindowModeChanged(multiWindowModeChangedInfo.isInMultiWindowMode, false);
                        return;
                    }
                    return;
                default:
                    PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo = (PictureInPictureModeChangedInfo) obj;
                    FragmentManager fragmentManager4 = this.f$0;
                    if (fragmentManager4.isParentAdded()) {
                        fragmentManager4.dispatchPictureInPictureModeChanged(pictureInPictureModeChangedInfo.isInPictureInPictureMode, false);
                        return;
                    }
                    return;
            }
        }
    };
    public final AnonymousClass2 mMenuProvider = new MenuProvider() { // from class: androidx.fragment.app.FragmentManager.2
        @Override // androidx.core.view.MenuProvider
        public final void onCreateMenu(Menu menu, MenuInflater menuInflater) {
            FragmentManager.this.dispatchCreateOptionsMenu(menu, menuInflater);
        }

        @Override // androidx.core.view.MenuProvider
        public final void onMenuClosed(Menu menu) {
            FragmentManager.this.dispatchOptionsMenuClosed(menu);
        }

        @Override // androidx.core.view.MenuProvider
        public final boolean onMenuItemSelected(MenuItem menuItem) {
            return FragmentManager.this.dispatchOptionsItemSelected(menuItem);
        }

        @Override // androidx.core.view.MenuProvider
        public final void onPrepareMenu(Menu menu) {
            FragmentManager.this.dispatchPrepareOptionsMenu(menu);
        }
    };
    public int mCurState = -1;
    public final AnonymousClass3 mHostFragmentFactory = new AnonymousClass3();
    public final ViewUtilsApi21 mDefaultSpecialEffectsControllerFactory = new Object();
    public ArrayDeque mLaunchedFragments = new ArrayDeque();
    public final Fragment.AnonymousClass4 mExecCommit = new Fragment.AnonymousClass4(2, this);

    /* renamed from: androidx.fragment.app.FragmentManager$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass3 {
        public static final SimpleArrayMap sClassCacheMap = new SimpleArrayMap(0);

        public AnonymousClass3() {
        }

        public static Class loadClass(ClassLoader classLoader, String str) {
            SimpleArrayMap simpleArrayMap = sClassCacheMap;
            SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(classLoader);
            if (simpleArrayMap2 == null) {
                simpleArrayMap2 = new SimpleArrayMap(0);
                simpleArrayMap.put(classLoader, simpleArrayMap2);
            }
            Class cls = (Class) simpleArrayMap2.get(str);
            if (cls != null) {
                return cls;
            }
            Class<?> cls2 = Class.forName(str, false, classLoader);
            simpleArrayMap2.put(str, cls2);
            return cls2;
        }

        public static Class loadFragmentClass(ClassLoader classLoader, String str) {
            try {
                return loadClass(classLoader, str);
            } catch (ClassCastException e) {
                throw new RuntimeException(ViewModelProvider.Factory.CC.m("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException(ViewModelProvider.Factory.CC.m("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
            }
        }

        public final Fragment instantiate(String str) {
            return Fragment.instantiate(FragmentManager.this.mHost.context, str, null);
        }
    }

    /* loaded from: classes.dex */
    public final class FragmentIntentSenderContract extends ActivityResultContract {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ FragmentIntentSenderContract(int i) {
            this.$r8$classId = i;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Intent createIntent(Context context, Object obj) {
            Bundle bundleExtra;
            switch (this.$r8$classId) {
                case 0:
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) obj;
                    Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                    Intent intent2 = intentSenderRequest.fillInIntent;
                    if (!(intent2 == null || (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                        intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                        intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                        if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                            IntentSender intentSender = intentSenderRequest.intentSender;
                            Intrinsics.checkNotNullParameter(intentSender, "intentSender");
                            intentSenderRequest = new IntentSenderRequest(intentSender, null, intentSenderRequest.flagsMask, intentSenderRequest.flagsValues);
                        }
                    }
                    intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                    }
                    return intent;
                case 1:
                    String[] input = (String[]) obj;
                    Intrinsics.checkNotNullParameter(input, "input");
                    Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
                    Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                    return putExtra;
                case 2:
                    String input2 = (String) obj;
                    Intrinsics.checkNotNullParameter(input2, "input");
                    Intent putExtra2 = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", new String[]{input2});
                    Intrinsics.checkNotNullExpressionValue(putExtra2, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                    return putExtra2;
                case 3:
                    Intent input3 = (Intent) obj;
                    Intrinsics.checkNotNullParameter(input3, "input");
                    return input3;
                default:
                    IntentSenderRequest input4 = (IntentSenderRequest) obj;
                    Intrinsics.checkNotNullParameter(input4, "input");
                    Intent putExtra3 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", input4);
                    Intrinsics.checkNotNullExpressionValue(putExtra3, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
                    return putExtra3;
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public FakeDrag getSynchronousResult(Context context, Object obj) {
            switch (this.$r8$classId) {
                case 1:
                    String[] input = (String[]) obj;
                    Intrinsics.checkNotNullParameter(input, "input");
                    if (input.length == 0) {
                        return new FakeDrag(1, EmptyMap.INSTANCE);
                    }
                    for (String str : input) {
                        if (BundleKt.checkSelfPermission(context, str) != 0) {
                            return null;
                        }
                    }
                    int mapCapacity = MapsKt__MapsKt.mapCapacity(input.length);
                    if (mapCapacity < 16) {
                        mapCapacity = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
                    for (String str2 : input) {
                        linkedHashMap.put(str2, Boolean.TRUE);
                    }
                    return new FakeDrag(1, linkedHashMap);
                case 2:
                    String input2 = (String) obj;
                    Intrinsics.checkNotNullParameter(input2, "input");
                    if (BundleKt.checkSelfPermission(context, input2) == 0) {
                        return new FakeDrag(1, Boolean.TRUE);
                    }
                    return null;
                default:
                    return super.getSynchronousResult(context, obj);
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Object parseResult(Intent intent, int i) {
            boolean z;
            switch (this.$r8$classId) {
                case 0:
                    return new ActivityResult(intent, i);
                case 1:
                    if (i == -1 && intent != null) {
                        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                        if (!(intArrayExtra == null || stringArrayExtra == null)) {
                            ArrayList arrayList = new ArrayList(intArrayExtra.length);
                            for (int i2 : intArrayExtra) {
                                if (i2 == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                arrayList.add(Boolean.valueOf(z));
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (String str : stringArrayExtra) {
                                if (str != null) {
                                    arrayList2.add(str);
                                }
                            }
                            Iterator it = arrayList2.iterator();
                            Iterator it2 = arrayList.iterator();
                            ArrayList arrayList3 = new ArrayList(Math.min(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10), CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10)));
                            while (it.hasNext() && it2.hasNext()) {
                                arrayList3.add(new Pair(it.next(), it2.next()));
                            }
                            return MapsKt__MapsKt.toMap(arrayList3);
                        }
                    }
                    return EmptyMap.INSTANCE;
                case 2:
                    if (intent == null || i != -1) {
                        return Boolean.FALSE;
                    }
                    int[] intArrayExtra2 = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    boolean z2 = false;
                    if (intArrayExtra2 != null) {
                        int length = intArrayExtra2.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                if (intArrayExtra2[i3] == 0) {
                                    z2 = true;
                                } else {
                                    i3++;
                                }
                            }
                        }
                    }
                    return Boolean.valueOf(z2);
                case 3:
                    return new ActivityResult(intent, i);
                default:
                    return new ActivityResult(intent, i);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new zzb(8);
        public int mRequestCode;
        public String mWho;

        public LaunchedFragmentInfo(String str, int i) {
            this.mWho = str;
            this.mRequestCode = i;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mWho);
            parcel.writeInt(this.mRequestCode);
        }
    }

    /* loaded from: classes.dex */
    public interface OnBackStackChangedListener {
        void onBackStackChangeCancelled();

        void onBackStackChangeCommitted(Fragment fragment, boolean z);

        void onBackStackChangeProgressed(BackEventCompat backEventCompat);

        void onBackStackChangeStarted(Fragment fragment, boolean z);

        void onBackStackChanged();
    }

    /* loaded from: classes.dex */
    public interface OpGenerator {
        boolean generateOps(ArrayList arrayList, ArrayList arrayList2);
    }

    /* loaded from: classes.dex */
    public final class PopBackStackState implements OpGenerator {
        public final int mId;
        public final String mName;

        public PopBackStackState(String str, int i) {
            this.mName = str;
            this.mId = i;
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean generateOps(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = FragmentManager.this.mPrimaryNav;
            if (fragment != null && this.mId < 0 && this.mName == null && fragment.getChildFragmentManager().popBackStackImmediate(-1, 0)) {
                return false;
            }
            return FragmentManager.this.popBackStackState(arrayList, arrayList2, this.mName, this.mId, 1);
        }
    }

    /* loaded from: classes.dex */
    public final class PrepareBackStackTransitionState implements OpGenerator {
        public PrepareBackStackTransitionState() {
        }

        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        public final boolean generateOps(ArrayList arrayList, ArrayList arrayList2) {
            boolean z;
            ArrayList arrayList3;
            ArrayList arrayList4;
            FragmentManager fragmentManager = FragmentManager.this;
            ArrayList arrayList5 = fragmentManager.mBackStackChangeListeners;
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "FragmentManager has the following pending actions inside of prepareBackStackState: " + fragmentManager.mPendingActions);
            }
            int i = 0;
            if (fragmentManager.mBackStack.isEmpty()) {
                Log.i("FragmentManager", "Ignoring call to start back stack pop because the back stack is empty.");
                arrayList4 = arrayList;
                arrayList3 = arrayList2;
                z = false;
            } else {
                ArrayList arrayList6 = fragmentManager.mBackStack;
                BackStackRecord backStackRecord = (BackStackRecord) arrayList6.get(arrayList6.size() - 1);
                fragmentManager.mTransitioningOp = backStackRecord;
                ArrayList arrayList7 = backStackRecord.mOps;
                int size = arrayList7.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList7.get(i2);
                    i2++;
                    Fragment fragment = ((FragmentTransaction.Op) obj).mFragment;
                    if (fragment != null) {
                        fragment.mTransitioning = true;
                    }
                }
                arrayList4 = arrayList;
                arrayList3 = arrayList2;
                z = fragmentManager.popBackStackState(arrayList4, arrayList3, null, -1, 0);
            }
            if (!arrayList5.isEmpty() && arrayList4.size() > 0) {
                boolean booleanValue = ((Boolean) arrayList3.get(arrayList4.size() - 1)).booleanValue();
                LinkedHashSet<Fragment> linkedHashSet = new LinkedHashSet();
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    linkedHashSet.addAll(FragmentManager.fragmentsFromRecord((BackStackRecord) obj2));
                }
                int size3 = arrayList5.size();
                while (i < size3) {
                    Object obj3 = arrayList5.get(i);
                    i++;
                    OnBackStackChangedListener onBackStackChangedListener = (OnBackStackChangedListener) obj3;
                    for (Fragment fragment2 : linkedHashSet) {
                        onBackStackChangedListener.onBackStackChangeStarted(fragment2, booleanValue);
                    }
                }
            }
            return z;
        }
    }

    /* loaded from: classes.dex */
    public final class SaveBackStackState implements OpGenerator {
        public final /* synthetic */ int $r8$classId;
        public final String mName;
        public final /* synthetic */ FragmentManager this$0;

        public /* synthetic */ SaveBackStackState(FragmentManager fragmentManager, String str, int i) {
            this.$r8$classId = i;
            this.this$0 = fragmentManager;
            this.mName = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:75:0x01e5, code lost:
            if (r9 != 8) goto L78;
         */
        @Override // androidx.fragment.app.FragmentManager.OpGenerator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean generateOps(java.util.ArrayList r23, java.util.ArrayList r24) {
            /*
                Method dump skipped, instructions count: 836
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.SaveBackStackState.generateOps(java.util.ArrayList, java.util.ArrayList):boolean");
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v17, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v18, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r0v20, types: [androidx.fragment.app.FragmentManager$2] */
    /* JADX WARN: Type inference failed for: r0v23, types: [androidx.transition.ViewUtilsApi21, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.fragment.app.FragmentManager$1] */
    public FragmentManager() {
        DesugarCollections.synchronizedMap(new HashMap());
    }

    public static HashSet fragmentsFromRecord(BackStackRecord backStackRecord) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < backStackRecord.mOps.size(); i++) {
            Fragment fragment = ((FragmentTransaction.Op) backStackRecord.mOps.get(i)).mFragment;
            if (fragment != null && backStackRecord.mAddToBackStack) {
                hashSet.add(fragment);
            }
        }
        return hashSet;
    }

    public static boolean isLoggingEnabled(int i) {
        if (Log.isLoggable("FragmentManager", i)) {
            return true;
        }
        return false;
    }

    public static boolean isMenuAvailable(Fragment fragment) {
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        ArrayList activeFragments = fragment.mChildFragmentManager.mFragmentStore.getActiveFragments();
        int size = activeFragments.size();
        boolean z = false;
        int i = 0;
        while (i < size) {
            Object obj = activeFragments.get(i);
            i++;
            Fragment fragment2 = (Fragment) obj;
            if (fragment2 != null) {
                z = isMenuAvailable(fragment2);
                continue;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPrimaryNavigation(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.mPrimaryNav) || !isPrimaryNavigation(fragmentManager.mParent)) {
            return false;
        }
        return true;
    }

    public static void showFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public final FragmentStateManager addFragment(Fragment fragment) {
        String str = fragment.mPreviousWho;
        if (str != null) {
            FragmentStrictMode.onFragmentReuse(fragment, str);
        }
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        FragmentStateManager createOrGetFragmentStateManager = createOrGetFragmentStateManager(fragment);
        fragment.mFragmentManager = this;
        FragmentStore fragmentStore = this.mFragmentStore;
        fragmentStore.makeActive(createOrGetFragmentStateManager);
        if (!fragment.mDetached) {
            fragmentStore.addFragment(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
        }
        return createOrGetFragmentStateManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void attachController(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, final Fragment fragment) {
        String str;
        if (this.mHost == null) {
            this.mHost = fragmentHostCallback;
            this.mContainer = fragmentContainer;
            this.mParent = fragment;
            CopyOnWriteArrayList copyOnWriteArrayList = this.mOnAttachListeners;
            if (fragment != null) {
                copyOnWriteArrayList.add(new FragmentOnAttachListener() { // from class: androidx.fragment.app.FragmentManager.7
                    @Override // androidx.fragment.app.FragmentOnAttachListener
                    public final void onAttachFragment(FragmentManager fragmentManager, Fragment fragment2) {
                        Fragment.this.onAttachFragment(fragment2);
                    }
                });
            } else if (fragmentHostCallback instanceof FragmentOnAttachListener) {
                copyOnWriteArrayList.add((FragmentOnAttachListener) fragmentHostCallback);
            }
            if (this.mParent != null) {
                updateOnBackPressedCallbackEnabled();
            }
            if (fragmentHostCallback instanceof OnBackPressedDispatcherOwner) {
                OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) fragmentHostCallback;
                OnBackPressedDispatcher onBackPressedDispatcher = onBackPressedDispatcherOwner.getOnBackPressedDispatcher();
                this.mOnBackPressedDispatcher = onBackPressedDispatcher;
                Fragment fragment2 = onBackPressedDispatcherOwner;
                if (fragment != null) {
                    fragment2 = fragment;
                }
                onBackPressedDispatcher.getClass();
                AnonymousClass1 onBackPressedCallback = this.mOnBackPressedCallback;
                Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
                Lifecycle lifecycle = fragment2.getLifecycle();
                if (((LifecycleRegistry) lifecycle).state != Lifecycle.State.DESTROYED) {
                    onBackPressedCallback.cancellables.add(new OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(onBackPressedDispatcher, lifecycle, onBackPressedCallback));
                    onBackPressedDispatcher.updateEnabledCallbacks();
                    onBackPressedCallback.enabledChangedCallback = new OnBackPressedDispatcher$addCallback$1(0, onBackPressedDispatcher);
                }
            }
            if (fragment != null) {
                FragmentManagerViewModel fragmentManagerViewModel = fragment.mFragmentManager.mNonConfig;
                HashMap hashMap = fragmentManagerViewModel.mChildNonConfigs;
                FragmentManagerViewModel fragmentManagerViewModel2 = (FragmentManagerViewModel) hashMap.get(fragment.mWho);
                if (fragmentManagerViewModel2 == null) {
                    fragmentManagerViewModel2 = new FragmentManagerViewModel(fragmentManagerViewModel.mStateAutomaticallySaved);
                    hashMap.put(fragment.mWho, fragmentManagerViewModel2);
                }
                this.mNonConfig = fragmentManagerViewModel2;
            } else if (fragmentHostCallback instanceof ViewModelStoreOwner) {
                ViewModelStore store = ((ViewModelStoreOwner) fragmentHostCallback).getViewModelStore();
                Intrinsics.checkNotNullParameter(store, "store");
                CreationExtras.Empty defaultCreationExtras = CreationExtras.Empty.INSTANCE;
                Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
                MetadataRepo metadataRepo = new MetadataRepo(store, FragmentManagerViewModel.FACTORY, defaultCreationExtras);
                ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FragmentManagerViewModel.class);
                String canonicalName = Navigation.getCanonicalName(orCreateKotlinClass);
                if (canonicalName != null) {
                    this.mNonConfig = (FragmentManagerViewModel) metadataRepo.getViewModel$lifecycle_viewmodel_release(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
                } else {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
            } else {
                this.mNonConfig = new FragmentManagerViewModel(false);
            }
            this.mNonConfig.mIsStateSaved = isStateSaved();
            this.mFragmentStore.mNonConfig = this.mNonConfig;
            FragmentHostCallback fragmentHostCallback2 = this.mHost;
            if ((fragmentHostCallback2 instanceof SavedStateRegistryOwner) && fragment == null) {
                SavedStateRegistry savedStateRegistry = ((SavedStateRegistryOwner) fragmentHostCallback2).getSavedStateRegistry();
                savedStateRegistry.registerSavedStateProvider("android:support:fragments", new FragmentManager$$ExternalSyntheticLambda4(0, this));
                Bundle consumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey("android:support:fragments");
                if (consumeRestoredStateForKey != null) {
                    restoreSaveStateInternal(consumeRestoredStateForKey);
                }
            }
            FragmentHostCallback fragmentHostCallback3 = this.mHost;
            if (fragmentHostCallback3 instanceof ActivityResultRegistryOwner) {
                ActivityResultRegistry activityResultRegistry = ((ActivityResultRegistryOwner) fragmentHostCallback3).getActivityResultRegistry();
                if (fragment != null) {
                    str = ViewModelProvider.Factory.CC.m(new StringBuilder(), fragment.mWho, ":");
                } else {
                    str = "";
                }
                String str2 = "FragmentManager:" + str;
                this.mStartActivityForResult = activityResultRegistry.register(ViewModelProvider.Factory.CC.m(str2, "StartActivityForResult"), new FragmentIntentSenderContract(3), new ActivityResultCallback(this) { // from class: androidx.fragment.app.FragmentManager.8
                    public final /* synthetic */ FragmentManager this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(Object obj) {
                        int i;
                        switch (r2) {
                            case 0:
                                ActivityResult activityResult = (ActivityResult) obj;
                                FragmentManager fragmentManager = this.this$0;
                                LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollLast();
                                if (launchedFragmentInfo == null) {
                                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                                    return;
                                }
                                String str3 = launchedFragmentInfo.mWho;
                                int i2 = launchedFragmentInfo.mRequestCode;
                                Fragment findFragmentByWho = fragmentManager.mFragmentStore.findFragmentByWho(str3);
                                if (findFragmentByWho == null) {
                                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                                    return;
                                }
                                findFragmentByWho.onActivityResult(i2, activityResult.mResultCode, activityResult.mData);
                                return;
                            case 1:
                                Map map = (Map) obj;
                                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                                ArrayList arrayList = new ArrayList(map.values());
                                int[] iArr = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    if (((Boolean) arrayList.get(i3)).booleanValue()) {
                                        i = 0;
                                    } else {
                                        i = -1;
                                    }
                                    iArr[i3] = i;
                                }
                                FragmentManager fragmentManager2 = this.this$0;
                                LaunchedFragmentInfo launchedFragmentInfo2 = (LaunchedFragmentInfo) fragmentManager2.mLaunchedFragments.pollFirst();
                                if (launchedFragmentInfo2 == null) {
                                    Log.w("FragmentManager", "No permissions were requested for " + this);
                                    return;
                                }
                                String str4 = launchedFragmentInfo2.mWho;
                                int i4 = launchedFragmentInfo2.mRequestCode;
                                Fragment findFragmentByWho2 = fragmentManager2.mFragmentStore.findFragmentByWho(str4);
                                if (findFragmentByWho2 == null) {
                                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str4);
                                    return;
                                }
                                findFragmentByWho2.onRequestPermissionsResult(i4, strArr, iArr);
                                return;
                            default:
                                ActivityResult activityResult2 = (ActivityResult) obj;
                                FragmentManager fragmentManager3 = this.this$0;
                                LaunchedFragmentInfo launchedFragmentInfo3 = (LaunchedFragmentInfo) fragmentManager3.mLaunchedFragments.pollFirst();
                                if (launchedFragmentInfo3 == null) {
                                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                                    return;
                                }
                                String str5 = launchedFragmentInfo3.mWho;
                                int i5 = launchedFragmentInfo3.mRequestCode;
                                Fragment findFragmentByWho3 = fragmentManager3.mFragmentStore.findFragmentByWho(str5);
                                if (findFragmentByWho3 == null) {
                                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str5);
                                    return;
                                }
                                findFragmentByWho3.onActivityResult(i5, activityResult2.mResultCode, activityResult2.mData);
                                return;
                        }
                    }
                });
                this.mStartIntentSenderForResult = activityResultRegistry.register(ViewModelProvider.Factory.CC.m(str2, "StartIntentSenderForResult"), new FragmentIntentSenderContract(0), new ActivityResultCallback(this) { // from class: androidx.fragment.app.FragmentManager.8
                    public final /* synthetic */ FragmentManager this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(Object obj) {
                        int i;
                        switch (r2) {
                            case 0:
                                ActivityResult activityResult = (ActivityResult) obj;
                                FragmentManager fragmentManager = this.this$0;
                                LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollLast();
                                if (launchedFragmentInfo == null) {
                                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                                    return;
                                }
                                String str3 = launchedFragmentInfo.mWho;
                                int i2 = launchedFragmentInfo.mRequestCode;
                                Fragment findFragmentByWho = fragmentManager.mFragmentStore.findFragmentByWho(str3);
                                if (findFragmentByWho == null) {
                                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                                    return;
                                }
                                findFragmentByWho.onActivityResult(i2, activityResult.mResultCode, activityResult.mData);
                                return;
                            case 1:
                                Map map = (Map) obj;
                                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                                ArrayList arrayList = new ArrayList(map.values());
                                int[] iArr = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    if (((Boolean) arrayList.get(i3)).booleanValue()) {
                                        i = 0;
                                    } else {
                                        i = -1;
                                    }
                                    iArr[i3] = i;
                                }
                                FragmentManager fragmentManager2 = this.this$0;
                                LaunchedFragmentInfo launchedFragmentInfo2 = (LaunchedFragmentInfo) fragmentManager2.mLaunchedFragments.pollFirst();
                                if (launchedFragmentInfo2 == null) {
                                    Log.w("FragmentManager", "No permissions were requested for " + this);
                                    return;
                                }
                                String str4 = launchedFragmentInfo2.mWho;
                                int i4 = launchedFragmentInfo2.mRequestCode;
                                Fragment findFragmentByWho2 = fragmentManager2.mFragmentStore.findFragmentByWho(str4);
                                if (findFragmentByWho2 == null) {
                                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str4);
                                    return;
                                }
                                findFragmentByWho2.onRequestPermissionsResult(i4, strArr, iArr);
                                return;
                            default:
                                ActivityResult activityResult2 = (ActivityResult) obj;
                                FragmentManager fragmentManager3 = this.this$0;
                                LaunchedFragmentInfo launchedFragmentInfo3 = (LaunchedFragmentInfo) fragmentManager3.mLaunchedFragments.pollFirst();
                                if (launchedFragmentInfo3 == null) {
                                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                                    return;
                                }
                                String str5 = launchedFragmentInfo3.mWho;
                                int i5 = launchedFragmentInfo3.mRequestCode;
                                Fragment findFragmentByWho3 = fragmentManager3.mFragmentStore.findFragmentByWho(str5);
                                if (findFragmentByWho3 == null) {
                                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str5);
                                    return;
                                }
                                findFragmentByWho3.onActivityResult(i5, activityResult2.mResultCode, activityResult2.mData);
                                return;
                        }
                    }
                });
                this.mRequestPermissions = activityResultRegistry.register(ViewModelProvider.Factory.CC.m(str2, "RequestPermissions"), new FragmentIntentSenderContract(1), new ActivityResultCallback(this) { // from class: androidx.fragment.app.FragmentManager.8
                    public final /* synthetic */ FragmentManager this$0;

                    {
                        this.this$0 = this;
                    }

                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(Object obj) {
                        int i;
                        switch (r2) {
                            case 0:
                                ActivityResult activityResult = (ActivityResult) obj;
                                FragmentManager fragmentManager = this.this$0;
                                LaunchedFragmentInfo launchedFragmentInfo = (LaunchedFragmentInfo) fragmentManager.mLaunchedFragments.pollLast();
                                if (launchedFragmentInfo == null) {
                                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                                    return;
                                }
                                String str3 = launchedFragmentInfo.mWho;
                                int i2 = launchedFragmentInfo.mRequestCode;
                                Fragment findFragmentByWho = fragmentManager.mFragmentStore.findFragmentByWho(str3);
                                if (findFragmentByWho == null) {
                                    Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                                    return;
                                }
                                findFragmentByWho.onActivityResult(i2, activityResult.mResultCode, activityResult.mData);
                                return;
                            case 1:
                                Map map = (Map) obj;
                                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                                ArrayList arrayList = new ArrayList(map.values());
                                int[] iArr = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    if (((Boolean) arrayList.get(i3)).booleanValue()) {
                                        i = 0;
                                    } else {
                                        i = -1;
                                    }
                                    iArr[i3] = i;
                                }
                                FragmentManager fragmentManager2 = this.this$0;
                                LaunchedFragmentInfo launchedFragmentInfo2 = (LaunchedFragmentInfo) fragmentManager2.mLaunchedFragments.pollFirst();
                                if (launchedFragmentInfo2 == null) {
                                    Log.w("FragmentManager", "No permissions were requested for " + this);
                                    return;
                                }
                                String str4 = launchedFragmentInfo2.mWho;
                                int i4 = launchedFragmentInfo2.mRequestCode;
                                Fragment findFragmentByWho2 = fragmentManager2.mFragmentStore.findFragmentByWho(str4);
                                if (findFragmentByWho2 == null) {
                                    Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str4);
                                    return;
                                }
                                findFragmentByWho2.onRequestPermissionsResult(i4, strArr, iArr);
                                return;
                            default:
                                ActivityResult activityResult2 = (ActivityResult) obj;
                                FragmentManager fragmentManager3 = this.this$0;
                                LaunchedFragmentInfo launchedFragmentInfo3 = (LaunchedFragmentInfo) fragmentManager3.mLaunchedFragments.pollFirst();
                                if (launchedFragmentInfo3 == null) {
                                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                                    return;
                                }
                                String str5 = launchedFragmentInfo3.mWho;
                                int i5 = launchedFragmentInfo3.mRequestCode;
                                Fragment findFragmentByWho3 = fragmentManager3.mFragmentStore.findFragmentByWho(str5);
                                if (findFragmentByWho3 == null) {
                                    Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str5);
                                    return;
                                }
                                findFragmentByWho3.onActivityResult(i5, activityResult2.mResultCode, activityResult2.mData);
                                return;
                        }
                    }
                });
            }
            FragmentHostCallback fragmentHostCallback4 = this.mHost;
            if (fragmentHostCallback4 instanceof OnConfigurationChangedProvider) {
                ((OnConfigurationChangedProvider) fragmentHostCallback4).addOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
            }
            FragmentHostCallback fragmentHostCallback5 = this.mHost;
            if (fragmentHostCallback5 instanceof OnTrimMemoryProvider) {
                ((OnTrimMemoryProvider) fragmentHostCallback5).addOnTrimMemoryListener(this.mOnTrimMemoryListener);
            }
            FragmentHostCallback fragmentHostCallback6 = this.mHost;
            if (fragmentHostCallback6 instanceof OnMultiWindowModeChangedProvider) {
                ((OnMultiWindowModeChangedProvider) fragmentHostCallback6).addOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
            }
            FragmentHostCallback fragmentHostCallback7 = this.mHost;
            if (fragmentHostCallback7 instanceof OnPictureInPictureModeChangedProvider) {
                ((OnPictureInPictureModeChangedProvider) fragmentHostCallback7).addOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
            }
            FragmentHostCallback fragmentHostCallback8 = this.mHost;
            if ((fragmentHostCallback8 instanceof MenuHost) && fragment == null) {
                ((MenuHost) fragmentHostCallback8).addMenuProvider(this.mMenuProvider);
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public final void attachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.mFragmentStore.addFragment(fragment);
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
            }
        }
    }

    public final void cleanupExec() {
        this.mExecutingActions = false;
        this.mTmpIsPop.clear();
        this.mTmpRecords.clear();
    }

    public final HashSet collectAllSpecialEffectsController() {
        DefaultSpecialEffectsController defaultSpecialEffectsController;
        HashSet hashSet = new HashSet();
        ArrayList activeFragmentStateManagers = this.mFragmentStore.getActiveFragmentStateManagers();
        int size = activeFragmentStateManagers.size();
        int i = 0;
        while (i < size) {
            Object obj = activeFragmentStateManagers.get(i);
            i++;
            ViewGroup viewGroup = ((FragmentStateManager) obj).mFragment.mContainer;
            if (viewGroup != null) {
                ViewUtilsApi21 factory = getSpecialEffectsControllerFactory();
                Intrinsics.checkNotNullParameter(factory, "factory");
                Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
                if (tag instanceof DefaultSpecialEffectsController) {
                    defaultSpecialEffectsController = (DefaultSpecialEffectsController) tag;
                } else {
                    defaultSpecialEffectsController = new DefaultSpecialEffectsController(viewGroup);
                    viewGroup.setTag(R.id.special_effects_controller_view_tag, defaultSpecialEffectsController);
                }
                hashSet.add(defaultSpecialEffectsController);
            }
        }
        return hashSet;
    }

    public final HashSet collectChangedControllers(ArrayList arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            ArrayList arrayList2 = ((BackStackRecord) arrayList.get(i)).mOps;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                Fragment fragment = ((FragmentTransaction.Op) obj).mFragment;
                if (!(fragment == null || (viewGroup = fragment.mContainer) == null)) {
                    hashSet.add(DefaultSpecialEffectsController.getOrCreateController(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    public final FragmentStateManager createOrGetFragmentStateManager(Fragment fragment) {
        String str = fragment.mWho;
        FragmentStore fragmentStore = this.mFragmentStore;
        FragmentStateManager fragmentStateManager = (FragmentStateManager) fragmentStore.mActive.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager;
        }
        FragmentStateManager fragmentStateManager2 = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, fragmentStore, fragment);
        fragmentStateManager2.restoreState(this.mHost.context.getClassLoader());
        fragmentStateManager2.mFragmentManagerState = this.mCurState;
        return fragmentStateManager2;
    }

    public final void detachFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                FragmentStore fragmentStore = this.mFragmentStore;
                synchronized (fragmentStore.mAdded) {
                    fragmentStore.mAdded.remove(fragment);
                }
                fragment.mAdded = false;
                if (isMenuAvailable(fragment)) {
                    this.mNeedMenuInvalidate = true;
                }
                setVisibleRemovingFragment(fragment);
            }
        }
    }

    public final void dispatchConfigurationChanged(boolean z, Configuration configuration) {
        if (!z || !(this.mHost instanceof OnConfigurationChangedProvider)) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    fragment.performConfigurationChanged(configuration);
                    if (z) {
                        fragment.mChildFragmentManager.dispatchConfigurationChanged(true, configuration);
                    }
                }
            }
            return;
        }
        throwException(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        throw null;
    }

    public final boolean dispatchContextItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.mCurState < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.mCreatedMenus != null) {
            for (int i = 0; i < this.mCreatedMenus.size(); i++) {
                Fragment fragment2 = (Fragment) this.mCreatedMenus.get(i);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.mCreatedMenus = arrayList;
        return z;
    }

    public final void dispatchDestroy() {
        boolean z = true;
        this.mDestroyed = true;
        execPendingActions(true);
        endAnimatingAwayFragments();
        FragmentHostCallback fragmentHostCallback = this.mHost;
        boolean z2 = fragmentHostCallback instanceof ViewModelStoreOwner;
        FragmentStore fragmentStore = this.mFragmentStore;
        if (z2) {
            z = fragmentStore.mNonConfig.mHasBeenCleared;
        } else {
            AppCompatActivity appCompatActivity = fragmentHostCallback.context;
            if (ViewModelProvider.Factory.CC.m((Object) appCompatActivity)) {
                z = true ^ appCompatActivity.isChangingConfigurations();
            }
        }
        if (z) {
            for (BackStackState backStackState : this.mBackStackStates.values()) {
                ArrayList arrayList = backStackState.mFragments;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    fragmentStore.mNonConfig.clearNonConfigState((String) obj, false);
                }
            }
        }
        dispatchStateChange(-1);
        FragmentHostCallback fragmentHostCallback2 = this.mHost;
        if (fragmentHostCallback2 instanceof OnTrimMemoryProvider) {
            ((OnTrimMemoryProvider) fragmentHostCallback2).removeOnTrimMemoryListener(this.mOnTrimMemoryListener);
        }
        FragmentHostCallback fragmentHostCallback3 = this.mHost;
        if (fragmentHostCallback3 instanceof OnConfigurationChangedProvider) {
            ((OnConfigurationChangedProvider) fragmentHostCallback3).removeOnConfigurationChangedListener(this.mOnConfigurationChangedListener);
        }
        FragmentHostCallback fragmentHostCallback4 = this.mHost;
        if (fragmentHostCallback4 instanceof OnMultiWindowModeChangedProvider) {
            ((OnMultiWindowModeChangedProvider) fragmentHostCallback4).removeOnMultiWindowModeChangedListener(this.mOnMultiWindowModeChangedListener);
        }
        FragmentHostCallback fragmentHostCallback5 = this.mHost;
        if (fragmentHostCallback5 instanceof OnPictureInPictureModeChangedProvider) {
            ((OnPictureInPictureModeChangedProvider) fragmentHostCallback5).removeOnPictureInPictureModeChangedListener(this.mOnPictureInPictureModeChangedListener);
        }
        FragmentHostCallback fragmentHostCallback6 = this.mHost;
        if ((fragmentHostCallback6 instanceof MenuHost) && this.mParent == null) {
            ((MenuHost) fragmentHostCallback6).removeMenuProvider(this.mMenuProvider);
        }
        this.mHost = null;
        this.mContainer = null;
        this.mParent = null;
        if (this.mOnBackPressedDispatcher != null) {
            Iterator it = this.mOnBackPressedCallback.cancellables.iterator();
            while (it.hasNext()) {
                ((Cancellable) it.next()).cancel();
            }
            this.mOnBackPressedDispatcher = null;
        }
        ActivityResultRegistry.AnonymousClass2 r0 = this.mStartActivityForResult;
        if (r0 != null) {
            r0.unregister();
            this.mStartIntentSenderForResult.unregister();
            this.mRequestPermissions.unregister();
        }
    }

    public final void dispatchLowMemory(boolean z) {
        if (!z || !(this.mHost instanceof OnTrimMemoryProvider)) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    fragment.performLowMemory();
                    if (z) {
                        fragment.mChildFragmentManager.dispatchLowMemory(true);
                    }
                }
            }
            return;
        }
        throwException(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        throw null;
    }

    public final void dispatchMultiWindowModeChanged(boolean z, boolean z2) {
        if (!z2 || !(this.mHost instanceof OnMultiWindowModeChangedProvider)) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    fragment.performMultiWindowModeChanged(z);
                    if (z2) {
                        fragment.mChildFragmentManager.dispatchMultiWindowModeChanged(z, true);
                    }
                }
            }
            return;
        }
        throwException(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        throw null;
    }

    public final void dispatchOnHiddenChanged() {
        ArrayList activeFragments = this.mFragmentStore.getActiveFragments();
        int size = activeFragments.size();
        int i = 0;
        while (i < size) {
            Object obj = activeFragments.get(i);
            i++;
            Fragment fragment = (Fragment) obj;
            if (fragment != null) {
                fragment.onHiddenChanged(fragment.isHidden());
                fragment.mChildFragmentManager.dispatchOnHiddenChanged();
            }
        }
    }

    public final boolean dispatchOptionsItemSelected(MenuItem menuItem) {
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void dispatchOptionsMenuClosed(Menu menu) {
        if (this.mCurState >= 1) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public final void dispatchParentPrimaryNavigationFragmentChanged(Fragment fragment) {
        if (fragment != null) {
            if (fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho))) {
                fragment.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void dispatchPictureInPictureModeChanged(boolean z, boolean z2) {
        if (!z2 || !(this.mHost instanceof OnPictureInPictureModeChangedProvider)) {
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    fragment.performPictureInPictureModeChanged(z);
                    if (z2) {
                        fragment.mChildFragmentManager.dispatchPictureInPictureModeChanged(z, true);
                    }
                }
            }
            return;
        }
        throwException(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        throw null;
    }

    public final boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mCurState < 1) {
            return false;
        }
        for (Fragment fragment : this.mFragmentStore.getFragments()) {
            if (fragment != null && fragment.isMenuVisible() && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Finally extract failed */
    public final void dispatchStateChange(int i) {
        try {
            this.mExecutingActions = true;
            for (FragmentStateManager fragmentStateManager : this.mFragmentStore.mActive.values()) {
                if (fragmentStateManager != null) {
                    fragmentStateManager.mFragmentManagerState = i;
                }
            }
            moveToState(i, false);
            Iterator it = collectAllSpecialEffectsController().iterator();
            while (it.hasNext()) {
                ((DefaultSpecialEffectsController) it.next()).forceCompleteAllOperations();
            }
            this.mExecutingActions = false;
            execPendingActions(true);
        } catch (Throwable th) {
            this.mExecutingActions = false;
            throw th;
        }
    }

    public final void doPendingDeferredStart() {
        if (this.mHavePendingDeferredStart) {
            this.mHavePendingDeferredStart = false;
            startPendingDeferredFragments();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        String m = ViewModelProvider.Factory.CC.m(str, "    ");
        FragmentStore fragmentStore = this.mFragmentStore;
        ArrayList arrayList = fragmentStore.mAdded;
        String m2 = ViewModelProvider.Factory.CC.m(str, "    ");
        HashMap hashMap = fragmentStore.mActive;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager fragmentStateManager : hashMap.values()) {
                printWriter.print(str);
                if (fragmentStateManager != null) {
                    Fragment fragment = fragmentStateManager.mFragment;
                    printWriter.println(fragment);
                    fragment.dump(m2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size2 = arrayList.size();
        if (size2 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size2; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(((Fragment) arrayList.get(i)).toString());
            }
        }
        ArrayList arrayList2 = this.mCreatedMenus;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(((Fragment) this.mCreatedMenus.get(i2)).toString());
            }
        }
        int size3 = this.mBackStack.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.dump(m, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.mBackStackIndex.get());
        synchronized (this.mPendingActions) {
            try {
                int size4 = this.mPendingActions.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println((OpGenerator) this.mPendingActions.get(i4));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.mHost);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.mContainer);
        if (this.mParent != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.mParent);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.mCurState);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.mStateSaved);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        if (this.mNeedMenuInvalidate) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.mNeedMenuInvalidate);
        }
    }

    public final void endAnimatingAwayFragments() {
        Iterator it = collectAllSpecialEffectsController().iterator();
        while (it.hasNext()) {
            ((DefaultSpecialEffectsController) it.next()).forceCompleteAllOperations();
        }
    }

    public final void enqueueAction(OpGenerator opGenerator, boolean z) {
        if (!z) {
            if (this.mHost == null) {
                if (this.mDestroyed) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (isStateSaved()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.mPendingActions) {
            try {
                if (this.mHost != null) {
                    this.mPendingActions.add(opGenerator);
                    scheduleCommit();
                } else if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void ensureExecReady(boolean z) {
        if (this.mExecutingActions) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.mHost == null) {
            if (this.mDestroyed) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.mHost.handler.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (!z && isStateSaved()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.mTmpRecords == null) {
            this.mTmpRecords = new ArrayList();
            this.mTmpIsPop = new ArrayList();
        }
    }

    public final boolean execPendingActions(boolean z) {
        boolean z2;
        BackStackRecord backStackRecord;
        ensureExecReady(z);
        if (!this.mHandlingTransitioningOp && (backStackRecord = this.mTransitioningOp) != null) {
            backStackRecord.mCommitted = false;
            backStackRecord.collapseOps();
            if (isLoggingEnabled(3)) {
                Log.d("FragmentManager", "Reversing mTransitioningOp " + this.mTransitioningOp + " as part of execPendingActions for actions " + this.mPendingActions);
            }
            this.mTransitioningOp.commitInternal(false, false);
            this.mPendingActions.add(0, this.mTransitioningOp);
            ArrayList arrayList = this.mTransitioningOp.mOps;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Fragment fragment = ((FragmentTransaction.Op) obj).mFragment;
                if (fragment != null) {
                    fragment.mTransitioning = false;
                }
            }
            this.mTransitioningOp = null;
        }
        boolean z3 = false;
        while (true) {
            ArrayList arrayList2 = this.mTmpRecords;
            ArrayList arrayList3 = this.mTmpIsPop;
            synchronized (this.mPendingActions) {
                if (this.mPendingActions.isEmpty()) {
                    z2 = false;
                } else {
                    int size2 = this.mPendingActions.size();
                    z2 = false;
                    for (int i2 = 0; i2 < size2; i2++) {
                        z2 |= ((OpGenerator) this.mPendingActions.get(i2)).generateOps(arrayList2, arrayList3);
                    }
                    this.mPendingActions.clear();
                    this.mHost.handler.removeCallbacks(this.mExecCommit);
                }
            }
            if (z2) {
                z3 = true;
                this.mExecutingActions = true;
                try {
                    removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                } finally {
                    cleanupExec();
                }
            } else {
                updateOnBackPressedCallbackEnabled();
                doPendingDeferredStart();
                this.mFragmentStore.mActive.values().removeAll(Collections.singleton(null));
                return z3;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void execSingleAction(BackStackRecord backStackRecord, boolean z) {
        if (!z || (this.mHost != null && !this.mDestroyed)) {
            ensureExecReady(z);
            BackStackRecord backStackRecord2 = this.mTransitioningOp;
            if (backStackRecord2 != null) {
                backStackRecord2.mCommitted = false;
                backStackRecord2.collapseOps();
                if (isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "Reversing mTransitioningOp " + this.mTransitioningOp + " as part of execSingleAction for action " + backStackRecord);
                }
                this.mTransitioningOp.commitInternal(false, false);
                this.mTransitioningOp.generateOps(this.mTmpRecords, this.mTmpIsPop);
                ArrayList arrayList = this.mTransitioningOp.mOps;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    Fragment fragment = ((FragmentTransaction.Op) obj).mFragment;
                    if (fragment != null) {
                        fragment.mTransitioning = false;
                    }
                }
                this.mTransitioningOp = null;
            }
            backStackRecord.generateOps(this.mTmpRecords, this.mTmpIsPop);
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
                cleanupExec();
                updateOnBackPressedCallbackEnabled();
                doPendingDeferredStart();
                this.mFragmentStore.mActive.values().removeAll(Collections.singleton(null));
            } catch (Throwable th) {
                cleanupExec();
                throw th;
            }
        }
    }

    public final void executeOpsTogether(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        int i3;
        boolean z;
        int i4;
        boolean z2;
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        boolean z4 = ((BackStackRecord) arrayList.get(i9)).mReorderingAllowed;
        ArrayList arrayList3 = this.mTmpAddedFragments;
        if (arrayList3 == null) {
            this.mTmpAddedFragments = new ArrayList();
        } else {
            arrayList3.clear();
        }
        ArrayList arrayList4 = this.mTmpAddedFragments;
        FragmentStore fragmentStore = this.mFragmentStore;
        arrayList4.addAll(fragmentStore.getFragments());
        Fragment fragment = this.mPrimaryNav;
        int i10 = i9;
        boolean z5 = false;
        while (true) {
            int i11 = 1;
            if (i10 < i2) {
                BackStackRecord backStackRecord = (BackStackRecord) arrayList.get(i10);
                if (!((Boolean) arrayList2.get(i10)).booleanValue()) {
                    ArrayList arrayList5 = this.mTmpAddedFragments;
                    ArrayList arrayList6 = backStackRecord.mOps;
                    int i12 = 0;
                    while (i12 < arrayList6.size()) {
                        FragmentTransaction.Op op = (FragmentTransaction.Op) arrayList6.get(i12);
                        z4 = z4;
                        int i13 = op.mCmd;
                        if (i13 != i11) {
                            i5 = i10;
                            if (i13 != 2) {
                                if (i13 == 3 || i13 == 6) {
                                    arrayList5.remove(op.mFragment);
                                    Fragment fragment2 = op.mFragment;
                                    if (fragment2 == fragment) {
                                        arrayList6.add(i12, new FragmentTransaction.Op(fragment2, 9));
                                        i12++;
                                        z3 = z5;
                                        fragment = null;
                                        i6 = 1;
                                    }
                                } else if (i13 != 7) {
                                    if (i13 == 8) {
                                        arrayList6.add(i12, new FragmentTransaction.Op(9, 0, fragment));
                                        op.mFromExpandedOp = true;
                                        i12++;
                                        fragment = op.mFragment;
                                    }
                                }
                                z3 = z5;
                                i6 = 1;
                            } else {
                                Fragment fragment3 = op.mFragment;
                                int i14 = fragment3.mContainerId;
                                int size = arrayList5.size() - 1;
                                boolean z6 = false;
                                while (size >= 0) {
                                    int i15 = size;
                                    Fragment fragment4 = (Fragment) arrayList5.get(size);
                                    z5 = z5;
                                    if (fragment4.mContainerId != i14) {
                                        i7 = i14;
                                    } else if (fragment4 == fragment3) {
                                        i7 = i14;
                                        z6 = true;
                                    } else {
                                        if (fragment4 == fragment) {
                                            i7 = i14;
                                            i8 = 0;
                                            arrayList6.add(i12, new FragmentTransaction.Op(9, 0, fragment4));
                                            i12++;
                                            fragment = null;
                                        } else {
                                            i7 = i14;
                                            i8 = 0;
                                        }
                                        fragment = fragment;
                                        FragmentTransaction.Op op2 = new FragmentTransaction.Op(3, i8, fragment4);
                                        op2.mEnterAnim = op.mEnterAnim;
                                        op2.mPopEnterAnim = op.mPopEnterAnim;
                                        op2.mExitAnim = op.mExitAnim;
                                        op2.mPopExitAnim = op.mPopExitAnim;
                                        arrayList6.add(i12, op2);
                                        arrayList5.remove(fragment4);
                                        i12++;
                                    }
                                    size = i15 - 1;
                                    i14 = i7;
                                }
                                z3 = z5;
                                i6 = 1;
                                if (z6) {
                                    arrayList6.remove(i12);
                                    i12--;
                                } else {
                                    op.mCmd = 1;
                                    op.mFromExpandedOp = true;
                                    arrayList5.add(fragment3);
                                }
                            }
                            i12 += i6;
                            i10 = i5;
                            z5 = z3;
                            i11 = 1;
                        } else {
                            i5 = i10;
                        }
                        z3 = z5;
                        i6 = 1;
                        arrayList5.add(op.mFragment);
                        i12 += i6;
                        i10 = i5;
                        z5 = z3;
                        i11 = 1;
                    }
                    z2 = z4;
                    i4 = i10;
                    z = z5;
                } else {
                    z2 = z4;
                    i4 = i10;
                    z = z5;
                    int i16 = 1;
                    ArrayList arrayList7 = this.mTmpAddedFragments;
                    ArrayList arrayList8 = backStackRecord.mOps;
                    int size2 = arrayList8.size() - 1;
                    while (size2 >= 0) {
                        FragmentTransaction.Op op3 = (FragmentTransaction.Op) arrayList8.get(size2);
                        int i17 = op3.mCmd;
                        if (i17 != i16) {
                            if (i17 != 3) {
                                switch (i17) {
                                    case 8:
                                        fragment = null;
                                        break;
                                    case 9:
                                        fragment = op3.mFragment;
                                        break;
                                    case 10:
                                        op3.mCurrentMaxState = op3.mOldMaxState;
                                        break;
                                }
                                size2--;
                                i16 = 1;
                            }
                            arrayList7.add(op3.mFragment);
                            size2--;
                            i16 = 1;
                        }
                        arrayList7.remove(op3.mFragment);
                        size2--;
                        i16 = 1;
                    }
                }
                z5 = z || backStackRecord.mAddToBackStack;
                i10 = i4 + 1;
                z4 = z2;
            } else {
                boolean z7 = z4;
                boolean z8 = z5;
                this.mTmpAddedFragments.clear();
                if (!z7 && this.mCurState >= 1) {
                    for (int i18 = i9; i18 < i2; i18++) {
                        ArrayList arrayList9 = ((BackStackRecord) arrayList.get(i18)).mOps;
                        int size3 = arrayList9.size();
                        int i19 = 0;
                        while (i19 < size3) {
                            Object obj = arrayList9.get(i19);
                            i19++;
                            Fragment fragment5 = ((FragmentTransaction.Op) obj).mFragment;
                            if (!(fragment5 == null || fragment5.mFragmentManager == null)) {
                                fragmentStore.makeActive(createOrGetFragmentStateManager(fragment5));
                            }
                        }
                    }
                }
                int i20 = i9;
                while (i20 < i2) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) arrayList.get(i20);
                    if (((Boolean) arrayList2.get(i20)).booleanValue()) {
                        backStackRecord2.bumpBackStackNesting(-1);
                        FragmentManager fragmentManager = backStackRecord2.mManager;
                        ArrayList arrayList10 = backStackRecord2.mOps;
                        boolean z9 = true;
                        for (int size4 = arrayList10.size() - 1; size4 >= 0; size4--) {
                            FragmentTransaction.Op op4 = (FragmentTransaction.Op) arrayList10.get(size4);
                            Fragment fragment6 = op4.mFragment;
                            if (fragment6 != null) {
                                fragment6.mBeingSaved = backStackRecord2.mBeingSaved;
                                fragment6.setPopDirection(z9);
                                int i21 = backStackRecord2.mTransition;
                                int i22 = 8194;
                                if (i21 != 4097) {
                                    if (i21 != 8194) {
                                        i22 = 4100;
                                        if (i21 != 8197) {
                                            i22 = i21 != 4099 ? i21 != 4100 ? 0 : 8197 : 4099;
                                        }
                                    } else {
                                        i22 = 4097;
                                    }
                                }
                                fragment6.setNextTransition(i22);
                                fragment6.setSharedElementNames(backStackRecord2.mSharedElementTargetNames, backStackRecord2.mSharedElementSourceNames);
                            }
                            switch (op4.mCmd) {
                                case 1:
                                    fragment6.setAnimations(op4.mEnterAnim, op4.mExitAnim, op4.mPopEnterAnim, op4.mPopExitAnim);
                                    z9 = true;
                                    fragmentManager.setExitAnimationOrder(fragment6, true);
                                    fragmentManager.removeFragment(fragment6);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + op4.mCmd);
                                case 3:
                                    fragment6.setAnimations(op4.mEnterAnim, op4.mExitAnim, op4.mPopEnterAnim, op4.mPopExitAnim);
                                    fragmentManager.addFragment(fragment6);
                                    z9 = true;
                                    break;
                                case 4:
                                    fragment6.setAnimations(op4.mEnterAnim, op4.mExitAnim, op4.mPopEnterAnim, op4.mPopExitAnim);
                                    fragmentManager.getClass();
                                    showFragment(fragment6);
                                    z9 = true;
                                    break;
                                case 5:
                                    fragment6.setAnimations(op4.mEnterAnim, op4.mExitAnim, op4.mPopEnterAnim, op4.mPopExitAnim);
                                    fragmentManager.setExitAnimationOrder(fragment6, true);
                                    fragmentManager.hideFragment(fragment6);
                                    z9 = true;
                                    break;
                                case 6:
                                    fragment6.setAnimations(op4.mEnterAnim, op4.mExitAnim, op4.mPopEnterAnim, op4.mPopExitAnim);
                                    fragmentManager.attachFragment(fragment6);
                                    z9 = true;
                                    break;
                                case 7:
                                    fragment6.setAnimations(op4.mEnterAnim, op4.mExitAnim, op4.mPopEnterAnim, op4.mPopExitAnim);
                                    fragmentManager.setExitAnimationOrder(fragment6, true);
                                    fragmentManager.detachFragment(fragment6);
                                    z9 = true;
                                    break;
                                case 8:
                                    fragmentManager.setPrimaryNavigationFragment(null);
                                    z9 = true;
                                    break;
                                case 9:
                                    fragmentManager.setPrimaryNavigationFragment(fragment6);
                                    z9 = true;
                                    break;
                                case 10:
                                    op4.mCurrentMaxState = fragment6.mMaxState;
                                    fragmentManager.setMaxLifecycle(fragment6, op4.mOldMaxState);
                                    z9 = true;
                                    break;
                            }
                        }
                    } else {
                        backStackRecord2.bumpBackStackNesting(1);
                        FragmentManager fragmentManager2 = backStackRecord2.mManager;
                        ArrayList arrayList11 = backStackRecord2.mOps;
                        int size5 = arrayList11.size();
                        int i23 = 0;
                        while (i23 < size5) {
                            FragmentTransaction.Op op5 = (FragmentTransaction.Op) arrayList11.get(i23);
                            Fragment fragment7 = op5.mFragment;
                            if (fragment7 != null) {
                                fragment7.mBeingSaved = backStackRecord2.mBeingSaved;
                                fragment7.setPopDirection(false);
                                fragment7.setNextTransition(backStackRecord2.mTransition);
                                fragment7.setSharedElementNames(backStackRecord2.mSharedElementSourceNames, backStackRecord2.mSharedElementTargetNames);
                            }
                            switch (op5.mCmd) {
                                case 1:
                                    i3 = i20;
                                    fragment7.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                                    fragmentManager2.setExitAnimationOrder(fragment7, false);
                                    fragmentManager2.addFragment(fragment7);
                                    break;
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + op5.mCmd);
                                case 3:
                                    i3 = i20;
                                    fragment7.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                                    fragmentManager2.removeFragment(fragment7);
                                    break;
                                case 4:
                                    i3 = i20;
                                    fragment7.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                                    fragmentManager2.hideFragment(fragment7);
                                    break;
                                case 5:
                                    i3 = i20;
                                    fragment7.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                                    fragmentManager2.setExitAnimationOrder(fragment7, false);
                                    showFragment(fragment7);
                                    break;
                                case 6:
                                    i3 = i20;
                                    fragment7.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                                    fragmentManager2.detachFragment(fragment7);
                                    break;
                                case 7:
                                    i3 = i20;
                                    fragment7.setAnimations(op5.mEnterAnim, op5.mExitAnim, op5.mPopEnterAnim, op5.mPopExitAnim);
                                    fragmentManager2.setExitAnimationOrder(fragment7, false);
                                    fragmentManager2.attachFragment(fragment7);
                                    break;
                                case 8:
                                    fragmentManager2.setPrimaryNavigationFragment(fragment7);
                                    i3 = i20;
                                    break;
                                case 9:
                                    fragmentManager2.setPrimaryNavigationFragment(null);
                                    i3 = i20;
                                    break;
                                case 10:
                                    op5.mOldMaxState = fragment7.mMaxState;
                                    fragmentManager2.setMaxLifecycle(fragment7, op5.mCurrentMaxState);
                                    i3 = i20;
                                    break;
                            }
                            i23++;
                            i20 = i3;
                        }
                    }
                    i20++;
                }
                boolean booleanValue = ((Boolean) arrayList2.get(i2 - 1)).booleanValue();
                ArrayList arrayList12 = this.mBackStackChangeListeners;
                if (z8 && !arrayList12.isEmpty()) {
                    LinkedHashSet<Fragment> linkedHashSet = new LinkedHashSet();
                    int size6 = arrayList.size();
                    int i24 = 0;
                    while (i24 < size6) {
                        Object obj2 = arrayList.get(i24);
                        i24++;
                        linkedHashSet.addAll(fragmentsFromRecord((BackStackRecord) obj2));
                    }
                    if (this.mTransitioningOp == null) {
                        int size7 = arrayList12.size();
                        int i25 = 0;
                        while (i25 < size7) {
                            Object obj3 = arrayList12.get(i25);
                            i25++;
                            OnBackStackChangedListener onBackStackChangedListener = (OnBackStackChangedListener) obj3;
                            for (Fragment fragment8 : linkedHashSet) {
                                onBackStackChangedListener.onBackStackChangeStarted(fragment8, booleanValue);
                            }
                        }
                        int size8 = arrayList12.size();
                        int i26 = 0;
                        while (i26 < size8) {
                            Object obj4 = arrayList12.get(i26);
                            i26++;
                            OnBackStackChangedListener onBackStackChangedListener2 = (OnBackStackChangedListener) obj4;
                            for (Fragment fragment9 : linkedHashSet) {
                                onBackStackChangedListener2.onBackStackChangeCommitted(fragment9, booleanValue);
                            }
                        }
                    }
                }
                for (int i27 = i9; i27 < i2; i27++) {
                    BackStackRecord backStackRecord3 = (BackStackRecord) arrayList.get(i27);
                    if (booleanValue) {
                        for (int size9 = backStackRecord3.mOps.size() - 1; size9 >= 0; size9--) {
                            Fragment fragment10 = ((FragmentTransaction.Op) backStackRecord3.mOps.get(size9)).mFragment;
                            if (fragment10 != null) {
                                createOrGetFragmentStateManager(fragment10).moveToExpectedState();
                            }
                        }
                    } else {
                        ArrayList arrayList13 = backStackRecord3.mOps;
                        int size10 = arrayList13.size();
                        int i28 = 0;
                        while (i28 < size10) {
                            Object obj5 = arrayList13.get(i28);
                            i28++;
                            Fragment fragment11 = ((FragmentTransaction.Op) obj5).mFragment;
                            if (fragment11 != null) {
                                createOrGetFragmentStateManager(fragment11).moveToExpectedState();
                            }
                        }
                    }
                }
                moveToState(this.mCurState, true);
                Iterator it = collectChangedControllers(arrayList, i9, i2).iterator();
                while (it.hasNext()) {
                    DefaultSpecialEffectsController defaultSpecialEffectsController = (DefaultSpecialEffectsController) it.next();
                    defaultSpecialEffectsController.operationDirectionIsPop = booleanValue;
                    defaultSpecialEffectsController.markPostponedState();
                    defaultSpecialEffectsController.executePendingOperations();
                }
                while (i9 < i2) {
                    BackStackRecord backStackRecord4 = (BackStackRecord) arrayList.get(i9);
                    if (((Boolean) arrayList2.get(i9)).booleanValue() && backStackRecord4.mIndex >= 0) {
                        backStackRecord4.mIndex = -1;
                    }
                    if (backStackRecord4.mCommitRunnables != null) {
                        for (int i29 = 0; i29 < backStackRecord4.mCommitRunnables.size(); i29++) {
                            ((Runnable) backStackRecord4.mCommitRunnables.get(i29)).run();
                        }
                        backStackRecord4.mCommitRunnables = null;
                    }
                    i9++;
                }
                if (z8) {
                    for (int i30 = 0; i30 < arrayList12.size(); i30++) {
                        ((OnBackStackChangedListener) arrayList12.get(i30)).onBackStackChanged();
                    }
                    return;
                }
                return;
            }
        }
    }

    public final int findBackStackIndex(String str, int i, boolean z) {
        if (this.mBackStack.isEmpty()) {
            return -1;
        }
        if (str != null || i >= 0) {
            int size = this.mBackStack.size() - 1;
            while (size >= 0) {
                BackStackRecord backStackRecord = (BackStackRecord) this.mBackStack.get(size);
                if ((str != null && str.equals(backStackRecord.mName)) || (i >= 0 && i == backStackRecord.mIndex)) {
                    break;
                }
                size--;
            }
            if (size < 0) {
                return size;
            }
            if (z) {
                while (size > 0) {
                    BackStackRecord backStackRecord2 = (BackStackRecord) this.mBackStack.get(size - 1);
                    if ((str == null || !str.equals(backStackRecord2.mName)) && (i < 0 || i != backStackRecord2.mIndex)) {
                        break;
                    }
                    size--;
                }
                return size;
            } else if (size == this.mBackStack.size() - 1) {
                return -1;
            } else {
                return size + 1;
            }
        } else if (z) {
            return 0;
        } else {
            return this.mBackStack.size() - 1;
        }
    }

    public final Fragment findFragmentById(int i) {
        FragmentStore fragmentStore = this.mFragmentStore;
        ArrayList arrayList = fragmentStore.mAdded;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) arrayList.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (FragmentStateManager fragmentStateManager : fragmentStore.mActive.values()) {
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final Fragment findFragmentByTag(String str) {
        FragmentStore fragmentStore = this.mFragmentStore;
        ArrayList arrayList = fragmentStore.mAdded;
        if (str != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) arrayList.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (FragmentStateManager fragmentStateManager : fragmentStore.mActive.values()) {
            if (fragmentStateManager != null) {
                Fragment fragment2 = fragmentStateManager.mFragment;
                if (str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public final void forcePostponedTransactions() {
        Iterator it = collectAllSpecialEffectsController().iterator();
        while (it.hasNext()) {
            DefaultSpecialEffectsController defaultSpecialEffectsController = (DefaultSpecialEffectsController) it.next();
            if (defaultSpecialEffectsController.isContainerPostponed) {
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                defaultSpecialEffectsController.isContainerPostponed = false;
                defaultSpecialEffectsController.executePendingOperations();
            }
        }
    }

    public final Fragment getFragment(Bundle bundle, String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment findActiveFragment = this.mFragmentStore.findActiveFragment(string);
        if (findActiveFragment != null) {
            return findActiveFragment;
        }
        throwException(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        throw null;
    }

    public final ViewGroup getFragmentContainer(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId <= 0 || !this.mContainer.onHasView()) {
            return null;
        }
        View onFindViewById = this.mContainer.onFindViewById(fragment.mContainerId);
        if (onFindViewById instanceof ViewGroup) {
            return (ViewGroup) onFindViewById;
        }
        return null;
    }

    public final AnonymousClass3 getFragmentFactory() {
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getFragmentFactory();
        }
        return this.mHostFragmentFactory;
    }

    public final ViewUtilsApi21 getSpecialEffectsControllerFactory() {
        Fragment fragment = this.mParent;
        if (fragment != null) {
            return fragment.mFragmentManager.getSpecialEffectsControllerFactory();
        }
        return this.mDefaultSpecialEffectsControllerFactory;
    }

    public final void hideFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            setVisibleRemovingFragment(fragment);
        }
    }

    public final boolean isParentAdded() {
        Fragment fragment = this.mParent;
        if (fragment == null) {
            return true;
        }
        if (!fragment.isAdded() || !this.mParent.getParentFragmentManager().isParentAdded()) {
            return false;
        }
        return true;
    }

    public final boolean isStateSaved() {
        if (this.mStateSaved || this.mStopped) {
            return true;
        }
        return false;
    }

    public final void moveToState(int i, boolean z) {
        FragmentHostCallback fragmentHostCallback;
        if (this.mHost == null && i != -1) {
            throw new IllegalStateException("No activity");
        } else if (z || i != this.mCurState) {
            this.mCurState = i;
            FragmentStore fragmentStore = this.mFragmentStore;
            HashMap hashMap = fragmentStore.mActive;
            ArrayList arrayList = fragmentStore.mAdded;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                FragmentStateManager fragmentStateManager = (FragmentStateManager) hashMap.get(((Fragment) obj).mWho);
                if (fragmentStateManager != null) {
                    fragmentStateManager.moveToExpectedState();
                }
            }
            for (FragmentStateManager fragmentStateManager2 : hashMap.values()) {
                if (fragmentStateManager2 != null) {
                    fragmentStateManager2.moveToExpectedState();
                    Fragment fragment = fragmentStateManager2.mFragment;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        if (fragment.mBeingSaved && !fragmentStore.mSavedState.containsKey(fragment.mWho)) {
                            fragmentStore.setSavedState(fragmentStateManager2.saveState(), fragment.mWho);
                        }
                        fragmentStore.makeInactive(fragmentStateManager2);
                    }
                }
            }
            startPendingDeferredFragments();
            if (this.mNeedMenuInvalidate && (fragmentHostCallback = this.mHost) != null && this.mCurState == 7) {
                ((FragmentActivity.HostCallbacks) fragmentHostCallback).this$0.invalidateMenu();
                this.mNeedMenuInvalidate = false;
            }
        }
    }

    public final void noteStateNotSaved() {
        if (this.mHost != null) {
            this.mStateSaved = false;
            this.mStopped = false;
            this.mNonConfig.mIsStateSaved = false;
            for (Fragment fragment : this.mFragmentStore.getFragments()) {
                if (fragment != null) {
                    fragment.noteStateNotSaved();
                }
            }
        }
    }

    public final boolean popBackStackImmediate() {
        return popBackStackImmediate(-1, 0);
    }

    public final boolean popBackStackState(ArrayList arrayList, ArrayList arrayList2, String str, int i, int i2) {
        boolean z;
        if ((i2 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        int findBackStackIndex = findBackStackIndex(str, i, z);
        if (findBackStackIndex < 0) {
            return false;
        }
        for (int size = this.mBackStack.size() - 1; size >= findBackStackIndex; size--) {
            arrayList.add((BackStackRecord) this.mBackStack.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void putFragment(Bundle bundle, String str, Fragment fragment) {
        if (fragment.mFragmentManager == this) {
            bundle.putString(str, fragment.mWho);
        } else {
            throwException(new IllegalStateException(ViewModelProvider.Factory.CC.m("Fragment ", fragment, " is not currently in the FragmentManager")));
            throw null;
        }
    }

    public final void removeFragment(Fragment fragment) {
        if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean isInBackStack = fragment.isInBackStack();
        if (!fragment.mDetached || !isInBackStack) {
            FragmentStore fragmentStore = this.mFragmentStore;
            synchronized (fragmentStore.mAdded) {
                fragmentStore.mAdded.remove(fragment);
            }
            fragment.mAdded = false;
            if (isMenuAvailable(fragment)) {
                this.mNeedMenuInvalidate = true;
            }
            fragment.mRemoving = true;
            setVisibleRemovingFragment(fragment);
        }
    }

    public final void removeRedundantOperationsAndExecute(ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                int size = arrayList.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    if (!((BackStackRecord) arrayList.get(i)).mReorderingAllowed) {
                        if (i2 != i) {
                            executeOpsTogether(arrayList, arrayList2, i2, i);
                        }
                        i2 = i + 1;
                        if (((Boolean) arrayList2.get(i)).booleanValue()) {
                            while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((BackStackRecord) arrayList.get(i2)).mReorderingAllowed) {
                                i2++;
                            }
                        }
                        executeOpsTogether(arrayList, arrayList2, i, i2);
                        i = i2 - 1;
                    }
                    i++;
                }
                if (i2 != size) {
                    executeOpsTogether(arrayList, arrayList2, i2, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public final void restoreSaveStateInternal(Bundle bundle) {
        FragmentAnim$AnimationOrAnimator fragmentAnim$AnimationOrAnimator;
        int i;
        FragmentStateManager fragmentStateManager;
        Bundle bundle2;
        Bundle bundle3;
        Bundle bundle4;
        for (String str : bundle.keySet()) {
            if (str.startsWith("result_") && (bundle4 = bundle.getBundle(str)) != null) {
                bundle4.setClassLoader(this.mHost.context.getClassLoader());
                this.mResults.put(str.substring(7), bundle4);
            }
        }
        HashMap hashMap = new HashMap();
        for (String str2 : bundle.keySet()) {
            if (str2.startsWith("fragment_") && (bundle3 = bundle.getBundle(str2)) != null) {
                bundle3.setClassLoader(this.mHost.context.getClassLoader());
                hashMap.put(str2.substring(9), bundle3);
            }
        }
        FragmentStore fragmentStore = this.mFragmentStore;
        HashMap hashMap2 = fragmentStore.mSavedState;
        HashMap hashMap3 = fragmentStore.mActive;
        hashMap2.clear();
        hashMap2.putAll(hashMap);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle.getParcelable("state");
        if (fragmentManagerState != null) {
            hashMap3.clear();
            ArrayList arrayList = fragmentManagerState.mActive;
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                fragmentAnim$AnimationOrAnimator = this.mLifecycleCallbacksDispatcher;
                if (i2 >= size) {
                    break;
                }
                Object obj = arrayList.get(i2);
                i2++;
                Bundle savedState = fragmentStore.setSavedState(null, (String) obj);
                if (savedState != null) {
                    Fragment fragment = (Fragment) this.mNonConfig.mRetainedFragments.get(((FragmentState) savedState.getParcelable("state")).mWho);
                    if (fragment != null) {
                        if (isLoggingEnabled(2)) {
                            i = 2;
                            Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                        } else {
                            i = 2;
                        }
                        fragmentStateManager = new FragmentStateManager(fragmentAnim$AnimationOrAnimator, fragmentStore, fragment, savedState);
                        bundle2 = savedState;
                    } else {
                        i = 2;
                        bundle2 = savedState;
                        fragmentStateManager = new FragmentStateManager(this.mLifecycleCallbacksDispatcher, this.mFragmentStore, this.mHost.context.getClassLoader(), getFragmentFactory(), savedState);
                    }
                    Fragment fragment2 = fragmentStateManager.mFragment;
                    fragment2.mSavedFragmentState = bundle2;
                    fragment2.mFragmentManager = this;
                    if (isLoggingEnabled(i)) {
                        Log.v("FragmentManager", "restoreSaveState: active (" + fragment2.mWho + "): " + fragment2);
                    }
                    fragmentStateManager.restoreState(this.mHost.context.getClassLoader());
                    fragmentStore.makeActive(fragmentStateManager);
                    fragmentStateManager.mFragmentManagerState = this.mCurState;
                }
            }
            FragmentManagerViewModel fragmentManagerViewModel = this.mNonConfig;
            fragmentManagerViewModel.getClass();
            ArrayList arrayList2 = new ArrayList(fragmentManagerViewModel.mRetainedFragments.values());
            int size2 = arrayList2.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                Fragment fragment3 = (Fragment) obj2;
                if (hashMap3.get(fragment3.mWho) == null) {
                    if (isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.mActive);
                    }
                    this.mNonConfig.removeRetainedFragment(fragment3);
                    fragment3.mFragmentManager = this;
                    FragmentStateManager fragmentStateManager2 = new FragmentStateManager(fragmentAnim$AnimationOrAnimator, fragmentStore, fragment3);
                    fragmentStateManager2.mFragmentManagerState = 1;
                    fragmentStateManager2.moveToExpectedState();
                    fragment3.mRemoving = true;
                    fragmentStateManager2.moveToExpectedState();
                }
            }
            ArrayList arrayList3 = fragmentManagerState.mAdded;
            fragmentStore.mAdded.clear();
            if (arrayList3 != null) {
                int size3 = arrayList3.size();
                int i4 = 0;
                while (i4 < size3) {
                    Object obj3 = arrayList3.get(i4);
                    i4++;
                    String str3 = (String) obj3;
                    Fragment findActiveFragment = fragmentStore.findActiveFragment(str3);
                    if (findActiveFragment != null) {
                        if (isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + findActiveFragment);
                        }
                        fragmentStore.addFragment(findActiveFragment);
                    } else {
                        throw new IllegalStateException(ViewModelProvider.Factory.CC.m("No instantiated fragment for (", str3, ")"));
                    }
                }
            }
            if (fragmentManagerState.mBackStack != null) {
                this.mBackStack = new ArrayList(fragmentManagerState.mBackStack.length);
                int i5 = 0;
                while (true) {
                    BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.mBackStack;
                    if (i5 >= backStackRecordStateArr.length) {
                        break;
                    }
                    BackStackRecordState backStackRecordState = backStackRecordStateArr[i5];
                    ArrayList arrayList4 = backStackRecordState.mFragmentWhos;
                    BackStackRecord backStackRecord = new BackStackRecord(this);
                    backStackRecordState.fillInBackStackRecord(backStackRecord);
                    backStackRecord.mIndex = backStackRecordState.mIndex;
                    for (int i6 = 0; i6 < arrayList4.size(); i6++) {
                        String str4 = (String) arrayList4.get(i6);
                        if (str4 != null) {
                            ((FragmentTransaction.Op) backStackRecord.mOps.get(i6)).mFragment = fragmentStore.findActiveFragment(str4);
                        }
                    }
                    backStackRecord.bumpBackStackNesting(1);
                    if (isLoggingEnabled(2)) {
                        StringBuilder m = ViewModelProvider.Factory.CC.m("restoreAllState: back stack #", i5, " (index ");
                        m.append(backStackRecord.mIndex);
                        m.append("): ");
                        m.append(backStackRecord);
                        Log.v("FragmentManager", m.toString());
                        PrintWriter printWriter = new PrintWriter(new LogWriter());
                        backStackRecord.dump("  ", printWriter, false);
                        printWriter.close();
                    }
                    this.mBackStack.add(backStackRecord);
                    i5++;
                }
            } else {
                this.mBackStack = new ArrayList();
            }
            this.mBackStackIndex.set(fragmentManagerState.mBackStackIndex);
            String str5 = fragmentManagerState.mPrimaryNavActiveWho;
            if (str5 != null) {
                Fragment findActiveFragment2 = fragmentStore.findActiveFragment(str5);
                this.mPrimaryNav = findActiveFragment2;
                dispatchParentPrimaryNavigationFragmentChanged(findActiveFragment2);
            }
            ArrayList arrayList5 = fragmentManagerState.mBackStackStateKeys;
            if (arrayList5 != null) {
                for (int i7 = 0; i7 < arrayList5.size(); i7++) {
                    this.mBackStackStates.put((String) arrayList5.get(i7), (BackStackState) fragmentManagerState.mBackStackStates.get(i7));
                }
            }
            this.mLaunchedFragments = new ArrayDeque(fragmentManagerState.mLaunchedFragments);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.os.Parcelable, androidx.fragment.app.FragmentManagerState, java.lang.Object] */
    public final Bundle saveAllStateInternal() {
        int i;
        ArrayList arrayList;
        BackStackRecordState[] backStackRecordStateArr;
        Bundle bundle = new Bundle();
        forcePostponedTransactions();
        endAnimatingAwayFragments();
        execPendingActions(true);
        this.mStateSaved = true;
        this.mNonConfig.mIsStateSaved = true;
        FragmentStore fragmentStore = this.mFragmentStore;
        fragmentStore.getClass();
        HashMap hashMap = fragmentStore.mActive;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        for (FragmentStateManager fragmentStateManager : hashMap.values()) {
            if (fragmentStateManager != null) {
                Fragment fragment = fragmentStateManager.mFragment;
                fragmentStore.setSavedState(fragmentStateManager.saveState(), fragment.mWho);
                arrayList2.add(fragment.mWho);
                if (isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragment.mSavedFragmentState);
                }
            }
        }
        HashMap hashMap2 = this.mFragmentStore.mSavedState;
        if (!hashMap2.isEmpty()) {
            FragmentStore fragmentStore2 = this.mFragmentStore;
            synchronized (fragmentStore2.mAdded) {
                try {
                    if (fragmentStore2.mAdded.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(fragmentStore2.mAdded.size());
                        ArrayList arrayList3 = fragmentStore2.mAdded;
                        int size = arrayList3.size();
                        int i2 = 0;
                        while (i2 < size) {
                            Object obj = arrayList3.get(i2);
                            i2++;
                            Fragment fragment2 = (Fragment) obj;
                            arrayList.add(fragment2.mWho);
                            if (isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + fragment2.mWho + "): " + fragment2);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int size2 = this.mBackStack.size();
            if (size2 > 0) {
                backStackRecordStateArr = new BackStackRecordState[size2];
                for (i = 0; i < size2; i++) {
                    backStackRecordStateArr[i] = new BackStackRecordState((BackStackRecord) this.mBackStack.get(i));
                    if (isLoggingEnabled(2)) {
                        StringBuilder m = ViewModelProvider.Factory.CC.m("saveAllState: adding back stack #", i, ": ");
                        m.append(this.mBackStack.get(i));
                        Log.v("FragmentManager", m.toString());
                    }
                }
            } else {
                backStackRecordStateArr = null;
            }
            ?? obj2 = new Object();
            obj2.mPrimaryNavActiveWho = null;
            ArrayList arrayList4 = new ArrayList();
            obj2.mBackStackStateKeys = arrayList4;
            ArrayList arrayList5 = new ArrayList();
            obj2.mBackStackStates = arrayList5;
            obj2.mActive = arrayList2;
            obj2.mAdded = arrayList;
            obj2.mBackStack = backStackRecordStateArr;
            obj2.mBackStackIndex = this.mBackStackIndex.get();
            Fragment fragment3 = this.mPrimaryNav;
            if (fragment3 != null) {
                obj2.mPrimaryNavActiveWho = fragment3.mWho;
            }
            arrayList4.addAll(this.mBackStackStates.keySet());
            arrayList5.addAll(this.mBackStackStates.values());
            obj2.mLaunchedFragments = new ArrayList(this.mLaunchedFragments);
            bundle.putParcelable("state", obj2);
            for (String str : this.mResults.keySet()) {
                bundle.putBundle("result_" + str, (Bundle) this.mResults.get(str));
            }
            for (String str2 : hashMap2.keySet()) {
                bundle.putBundle("fragment_" + str2, (Bundle) hashMap2.get(str2));
            }
        } else if (isLoggingEnabled(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        FragmentStateManager fragmentStateManager = (FragmentStateManager) this.mFragmentStore.mActive.get(fragment.mWho);
        if (fragmentStateManager != null) {
            Fragment fragment2 = fragmentStateManager.mFragment;
            if (fragment2.equals(fragment)) {
                if (fragment2.mState > -1) {
                    return new Fragment.SavedState(fragmentStateManager.saveState());
                }
                return null;
            }
        }
        throwException(new IllegalStateException(ViewModelProvider.Factory.CC.m("Fragment ", fragment, " is not currently in the FragmentManager")));
        throw null;
    }

    public final void scheduleCommit() {
        synchronized (this.mPendingActions) {
            try {
                if (this.mPendingActions.size() == 1) {
                    this.mHost.handler.removeCallbacks(this.mExecCommit);
                    this.mHost.handler.post(this.mExecCommit);
                    updateOnBackPressedCallbackEnabled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setExitAnimationOrder(Fragment fragment, boolean z) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null && (fragmentContainer instanceof FragmentContainerView)) {
            ((FragmentContainerView) fragmentContainer).setDrawDisappearingViewsLast(!z);
        }
    }

    public final void setMaxLifecycle(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    public final void setPrimaryNavigationFragment(Fragment fragment) {
        if (fragment != null) {
            if (!fragment.equals(this.mFragmentStore.findActiveFragment(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
                throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
            }
        }
        Fragment fragment2 = this.mPrimaryNav;
        this.mPrimaryNav = fragment;
        dispatchParentPrimaryNavigationFragmentChanged(fragment2);
        dispatchParentPrimaryNavigationFragmentChanged(this.mPrimaryNav);
    }

    public final void setVisibleRemovingFragment(Fragment fragment) {
        ViewGroup fragmentContainer = getFragmentContainer(fragment);
        if (fragmentContainer != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                if (fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    fragmentContainer.setTag(R.id.visible_removing_fragment_view_tag, fragment);
                }
                ((Fragment) fragmentContainer.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void startPendingDeferredFragments() {
        ArrayList activeFragmentStateManagers = this.mFragmentStore.getActiveFragmentStateManagers();
        int size = activeFragmentStateManagers.size();
        int i = 0;
        while (i < size) {
            Object obj = activeFragmentStateManagers.get(i);
            i++;
            FragmentStateManager fragmentStateManager = (FragmentStateManager) obj;
            Fragment fragment = fragmentStateManager.mFragment;
            if (fragment.mDeferStart) {
                if (this.mExecutingActions) {
                    this.mHavePendingDeferredStart = true;
                } else {
                    fragment.mDeferStart = false;
                    fragmentStateManager.moveToExpectedState();
                }
            }
        }
    }

    public final void throwException(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter());
        FragmentHostCallback fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            try {
                ((FragmentActivity.HostCallbacks) fragmentHostCallback).this$0.dump("  ", null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                dump("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.mParent;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.mParent)));
            sb.append("}");
        } else {
            FragmentHostCallback fragmentHostCallback = this.mHost;
            if (fragmentHostCallback != null) {
                sb.append(fragmentHostCallback.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.mHost)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void updateOnBackPressedCallbackEnabled() {
        int i;
        synchronized (this.mPendingActions) {
            try {
                boolean z = true;
                if (!this.mPendingActions.isEmpty()) {
                    setEnabled(true);
                    if (isLoggingEnabled(3)) {
                        Log.d("FragmentManager", "FragmentManager " + this + " enabling OnBackPressedCallback, caused by non-empty pending actions");
                    }
                    return;
                }
                int size = this.mBackStack.size();
                if (this.mTransitioningOp != null) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (size + i <= 0 || !isPrimaryNavigation(this.mParent)) {
                    z = false;
                }
                if (isLoggingEnabled(3)) {
                    Log.d("FragmentManager", "OnBackPressedCallback for FragmentManager " + this + " enabled state is " + z);
                }
                setEnabled(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean popBackStackImmediate(int i, int i2) {
        execPendingActions(false);
        ensureExecReady(true);
        Fragment fragment = this.mPrimaryNav;
        if (fragment != null && i < 0 && fragment.getChildFragmentManager().popBackStackImmediate()) {
            return true;
        }
        boolean popBackStackState = popBackStackState(this.mTmpRecords, this.mTmpIsPop, null, i, i2);
        if (popBackStackState) {
            this.mExecutingActions = true;
            try {
                removeRedundantOperationsAndExecute(this.mTmpRecords, this.mTmpIsPop);
            } finally {
                cleanupExec();
            }
        }
        updateOnBackPressedCallbackEnabled();
        doPendingDeferredStart();
        this.mFragmentStore.mActive.values().removeAll(Collections.singleton(null));
        return popBackStackState;
    }
}
