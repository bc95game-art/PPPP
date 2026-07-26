package androidx.activity;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.FragmentNavigator$$ExternalSyntheticLambda0;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.internal.NavControllerImpl;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistryOwner;
import com.emanuelef.remote_capture.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda1(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v2, types: [java.lang.Throwable] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        Bundle[] bundleArr;
        Boolean bool;
        boolean z;
        int i;
        String str;
        Lifecycle lifecycle;
        switch (this.$r8$classId) {
            case 0:
                ((ComponentActivity) this.f$0).reportFullyDrawn();
                return null;
            case 1:
                return SavedStateHandleSupport.getSavedStateHandlesVM((ViewModelStoreOwner) this.f$0);
            case 2:
                NavHostFragment navHostFragment = (NavHostFragment) this.f$0;
                Context context = navHostFragment.getContext();
                if (context != null) {
                    NavController navController = new NavController(context);
                    NavControllerImpl navControllerImpl = navController.impl;
                    FragmentNavigator$$ExternalSyntheticLambda0 fragmentNavigator$$ExternalSyntheticLambda0 = navControllerImpl.lifecycleObserver;
                    NavigatorProvider navigatorProvider = navControllerImpl._navigatorProvider;
                    if (!navHostFragment.equals(navControllerImpl.lifecycleOwner)) {
                        LifecycleOwner lifecycleOwner = navControllerImpl.lifecycleOwner;
                        if (!(lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
                            lifecycle.removeObserver(fragmentNavigator$$ExternalSyntheticLambda0);
                        }
                        navControllerImpl.lifecycleOwner = navHostFragment;
                        navHostFragment.getLifecycle().addObserver(fragmentNavigator$$ExternalSyntheticLambda0);
                    }
                    ViewModelStore viewModelStore = navHostFragment.getViewModelStore();
                    Intrinsics.checkNotNullExpressionValue(viewModelStore, "<get-viewModelStore>(...)");
                    if (!Intrinsics.areEqual(navControllerImpl.viewModel, Navigation.getInstance(viewModelStore))) {
                        if (navControllerImpl.backQueue.isEmpty()) {
                            navControllerImpl.viewModel = Navigation.getInstance(viewModelStore);
                        } else {
                            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
                        }
                    }
                    Context requireContext = navHostFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    FragmentManager childFragmentManager = navHostFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                    navigatorProvider.addNavigator(new DialogFragmentNavigator(requireContext, childFragmentManager));
                    Context requireContext2 = navHostFragment.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                    FragmentManager childFragmentManager2 = navHostFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                    int id = navHostFragment.getId();
                    if (id == 0 || id == -1) {
                        id = R.id.nav_host_fragment_container;
                    }
                    navigatorProvider.addNavigator(new FragmentNavigator(requireContext2, childFragmentManager2, id));
                    Bundle consumeRestoredStateForKey = navHostFragment.getSavedStateRegistry().consumeRestoredStateForKey("android-support-nav:fragment:navControllerState");
                    int i2 = 0;
                    String str2 = null;
                    if (consumeRestoredStateForKey != null) {
                        consumeRestoredStateForKey.setClassLoader(context.getClassLoader());
                        LinkedHashMap linkedHashMap = navControllerImpl.backStackStates;
                        if (consumeRestoredStateForKey.containsKey("android-support-nav:controller:navigatorState")) {
                            bundle3 = consumeRestoredStateForKey.getBundle("android-support-nav:controller:navigatorState");
                            if (bundle3 == null) {
                                Navigation.keyOrValueNotFoundError("android-support-nav:controller:navigatorState");
                                throw null;
                            }
                        } else {
                            bundle3 = null;
                        }
                        navControllerImpl.navigatorStateToRestore = bundle3;
                        if (consumeRestoredStateForKey.containsKey("android-support-nav:controller:backStack")) {
                            bundleArr = (Bundle[]) Navigation.m21getSavedStateListimpl(consumeRestoredStateForKey, "android-support-nav:controller:backStack").toArray(new Bundle[0]);
                        } else {
                            bundleArr = null;
                        }
                        navControllerImpl.backStackToRestore = bundleArr;
                        linkedHashMap.clear();
                        if (consumeRestoredStateForKey.containsKey("android-support-nav:controller:backStackDestIds") && consumeRestoredStateForKey.containsKey("android-support-nav:controller:backStackIds")) {
                            int[] intArray = consumeRestoredStateForKey.getIntArray("android-support-nav:controller:backStackDestIds");
                            if (intArray != null) {
                                ArrayList<String> stringArrayList = consumeRestoredStateForKey.getStringArrayList("android-support-nav:controller:backStackIds");
                                if (stringArrayList != null) {
                                    int length = intArray.length;
                                    int i3 = 0;
                                    int i4 = 0;
                                    while (i3 < length) {
                                        int i5 = i4 + 1;
                                        Integer valueOf = Integer.valueOf(intArray[i3]);
                                        String str3 = str2;
                                        LinkedHashMap linkedHashMap2 = navControllerImpl.backStackMap;
                                        int i6 = length;
                                        if (!Intrinsics.areEqual(stringArrayList.get(i4), "")) {
                                            str = stringArrayList.get(i4);
                                        } else {
                                            str = str3;
                                        }
                                        linkedHashMap2.put(valueOf, str);
                                        i3++;
                                        i4 = i5;
                                        str2 = str3;
                                        length = i6;
                                    }
                                } else {
                                    Navigation.keyOrValueNotFoundError("android-support-nav:controller:backStackIds");
                                    throw null;
                                }
                            } else {
                                Navigation.keyOrValueNotFoundError("android-support-nav:controller:backStackDestIds");
                                throw null;
                            }
                        }
                        ?? r16 = str2;
                        if (consumeRestoredStateForKey.containsKey("android-support-nav:controller:backStackStates")) {
                            ArrayList<String> stringArrayList2 = consumeRestoredStateForKey.getStringArrayList("android-support-nav:controller:backStackStates");
                            if (stringArrayList2 != null) {
                                int size = stringArrayList2.size();
                                int i7 = 0;
                                while (i7 < size) {
                                    String str4 = stringArrayList2.get(i7);
                                    i7++;
                                    String str5 = str4;
                                    String key = "android-support-nav:controller:backStackStates:" + str5;
                                    Intrinsics.checkNotNullParameter(key, "key");
                                    if (consumeRestoredStateForKey.containsKey(key)) {
                                        ArrayList arrayList = Navigation.m21getSavedStateListimpl(consumeRestoredStateForKey, "android-support-nav:controller:backStackStates:" + str5);
                                        ArrayDeque arrayDeque = new ArrayDeque(arrayList.size());
                                        int size2 = arrayList.size();
                                        int i8 = 0;
                                        while (i8 < size2) {
                                            Object obj = arrayList.get(i8);
                                            i8++;
                                            arrayDeque.addLast(new NavBackStackEntryState((Bundle) obj));
                                            size = size;
                                        }
                                        i = size;
                                        linkedHashMap.put(str5, arrayDeque);
                                    } else {
                                        i = size;
                                    }
                                    size = i;
                                }
                            } else {
                                Navigation.keyOrValueNotFoundError("android-support-nav:controller:backStackStates");
                                throw r16;
                            }
                        }
                        i2 = 0;
                        boolean z2 = consumeRestoredStateForKey.getBoolean("android-support-nav:controller:deepLinkHandled", false);
                        if (z2 || !consumeRestoredStateForKey.getBoolean("android-support-nav:controller:deepLinkHandled", true)) {
                            bool = Boolean.valueOf(z2);
                        } else {
                            bool = r16;
                        }
                        if (bool != null) {
                            z = bool.booleanValue();
                        } else {
                            z = false;
                        }
                        navController.deepLinkHandled = z;
                        bundle = r16;
                    } else {
                        bundle = null;
                    }
                    navHostFragment.getSavedStateRegistry().registerSavedStateProvider("android-support-nav:fragment:navControllerState", new ComponentActivity$$ExternalSyntheticLambda2(2, navController));
                    Bundle consumeRestoredStateForKey2 = navHostFragment.getSavedStateRegistry().consumeRestoredStateForKey("android-support-nav:fragment:graphId");
                    if (consumeRestoredStateForKey2 != null) {
                        navHostFragment.graphId = consumeRestoredStateForKey2.getInt("android-support-nav:fragment:graphId");
                    }
                    navHostFragment.getSavedStateRegistry().registerSavedStateProvider("android-support-nav:fragment:graphId", new ComponentActivity$$ExternalSyntheticLambda2(3, navHostFragment));
                    int i9 = navHostFragment.graphId;
                    SynchronizedLazyImpl synchronizedLazyImpl = navController.navInflater$delegate;
                    if (i9 != 0) {
                        navControllerImpl.setGraph$navigation_runtime_release(((NavInflater) synchronizedLazyImpl.getValue()).inflate(i9), bundle);
                    } else {
                        Bundle bundle4 = bundle;
                        Bundle arguments = navHostFragment.getArguments();
                        if (arguments != null) {
                            i2 = arguments.getInt("android-support-nav:fragment:graphId");
                        }
                        if (arguments != null) {
                            bundle2 = arguments.getBundle("android-support-nav:fragment:startDestinationArgs");
                        } else {
                            bundle2 = bundle4;
                        }
                        if (i2 != 0) {
                            navControllerImpl.setGraph$navigation_runtime_release(((NavInflater) synchronizedLazyImpl.getValue()).inflate(i2), bundle2);
                        }
                    }
                    return navController;
                }
                throw new IllegalStateException("NavController cannot be created before the fragment is attached");
            case 3:
                String uriPattern = (String) this.f$0;
                Intrinsics.checkNotNullParameter(uriPattern, "uriPattern");
                return new NavDeepLink(uriPattern, null, null);
            default:
                SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) this.f$0;
                savedStateRegistryOwner.getLifecycle().addObserver(new Recreator(0, savedStateRegistryOwner));
                return Unit.INSTANCE;
        }
    }
}
