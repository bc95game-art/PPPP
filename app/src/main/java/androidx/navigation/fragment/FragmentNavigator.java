package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.activity.BackEventCompat;
import androidx.collection.internal.LruHashMap;
import androidx.core.p002os.BundleKt;
import androidx.emoji2.text.MetadataRepo;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDeepLink$$ExternalSyntheticLambda8;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.Navigation$$ExternalSyntheticLambda0;
import androidx.navigation.Navigator;
import androidx.navigation.internal.NavControllerImpl;
import androidx.viewpager2.widget.FakeDrag;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.StateFlowImpl;
@Navigator.Name("fragment")
/* loaded from: classes.dex */
public class FragmentNavigator extends Navigator {
    public final int containerId;
    public final Context context;
    public final FragmentManager fragmentManager;
    public final LinkedHashSet savedIds = new LinkedHashSet();
    public final ArrayList pendingOps = new ArrayList();
    public final FragmentNavigator$$ExternalSyntheticLambda0 fragmentObserver = new FragmentNavigator$$ExternalSyntheticLambda0(0, this);
    public final NavDeepLink$$ExternalSyntheticLambda8 fragmentViewObserver = new NavDeepLink$$ExternalSyntheticLambda8(2, this);

    /* loaded from: classes.dex */
    public static final class ClearEntryStateViewModel extends ViewModel {
        public WeakReference completeTransition;

        @Override // androidx.lifecycle.ViewModel
        public final void onCleared() {
            WeakReference weakReference = this.completeTransition;
            if (weakReference != null) {
                Function0 function0 = (Function0) weakReference.get();
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("completeTransition");
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public final class Destination extends NavDestination {
        public String _className;

        @Override // androidx.navigation.NavDestination
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Destination) || !super.equals(obj) || !Intrinsics.areEqual(this._className, ((Destination) obj)._className)) {
                return false;
            }
            return true;
        }

        @Override // androidx.navigation.NavDestination
        public final int hashCode() {
            int i;
            int hashCode = super.hashCode() * 31;
            String str = this._className;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            return hashCode + i;
        }

        @Override // androidx.navigation.NavDestination
        public final void onInflate(Context context, AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.FragmentNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
            String string = obtainAttributes.getString(0);
            if (string != null) {
                this._className = string;
            }
            obtainAttributes.recycle();
        }

        @Override // androidx.navigation.NavDestination
        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this._className;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
            return sb2;
        }
    }

    public FragmentNavigator(Context context, FragmentManager fragmentManager, int i) {
        this.context = context;
        this.fragmentManager = fragmentManager;
        this.containerId = i;
    }

    public static void addPendingOps$default(FragmentNavigator fragmentNavigator, String str, int i) {
        boolean z;
        boolean z2;
        int lastIndex;
        int i2 = 0;
        if ((i & 2) != 0) {
            z = false;
        } else {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        ArrayList arrayList = fragmentNavigator.pendingOps;
        if (z2) {
            Intrinsics.checkNotNullParameter(arrayList, "<this>");
            int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            if (lastIndex2 >= 0) {
                int i3 = 0;
                while (true) {
                    Object obj = arrayList.get(i2);
                    Pair it = (Pair) obj;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (!Intrinsics.areEqual(it.first, str)) {
                        if (i3 != i2) {
                            arrayList.set(i3, obj);
                        }
                        i3++;
                    }
                    if (i2 == lastIndex2) {
                        break;
                    }
                    i2++;
                }
                i2 = i3;
            }
            if (i2 < arrayList.size() && i2 <= (lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList))) {
                while (true) {
                    arrayList.remove(lastIndex);
                    if (lastIndex == i2) {
                        break;
                    }
                    lastIndex--;
                }
            }
        }
        arrayList.add(new Pair(str, Boolean.valueOf(z)));
    }

    public static boolean isLoggingEnabled() {
        if (Log.isLoggable("FragmentManager", 2) || Log.isLoggable("FragmentNavigator", 2)) {
            return true;
        }
        return false;
    }

    public final void attachClearViewModel$navigation_fragment_release(Fragment fragment, NavBackStackEntry navBackStackEntry, NavController.NavControllerNavigatorState navControllerNavigatorState) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModelStore viewModelStore = fragment.getViewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "<get-viewModelStore>(...)");
        LruHashMap lruHashMap = new LruHashMap(1);
        lruHashMap.addInitializer(Reflection.getOrCreateKotlinClass(ClearEntryStateViewModel.class), new Navigation$$ExternalSyntheticLambda0(7));
        FakeDrag build = lruHashMap.build();
        CreationExtras.Empty defaultCreationExtras = CreationExtras.Empty.INSTANCE;
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
        MetadataRepo metadataRepo = new MetadataRepo(viewModelStore, build, defaultCreationExtras);
        ClassReference orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ClearEntryStateViewModel.class);
        String canonicalName = Navigation.getCanonicalName(orCreateKotlinClass);
        if (canonicalName != null) {
            ((ClearEntryStateViewModel) metadataRepo.getViewModel$lifecycle_viewmodel_release(orCreateKotlinClass, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName))).completeTransition = new WeakReference(new FragmentNavigator$$ExternalSyntheticLambda6(navBackStackEntry, navControllerNavigatorState, this, fragment));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination createDestination() {
        return new NavDestination(this);
    }

    public final BackStackRecord createFragmentTransaction(NavBackStackEntry navBackStackEntry, NavOptions navOptions) {
        int i;
        int i2;
        int i3;
        int i4;
        NavDestination navDestination = navBackStackEntry.destination;
        Intrinsics.checkNotNull(navDestination, "null cannot be cast to non-null type androidx.navigation.fragment.FragmentNavigator.Destination");
        Bundle arguments$navigation_common_release = navBackStackEntry.impl.getArguments$navigation_common_release();
        String str = ((Destination) navDestination)._className;
        if (str != null) {
            int i5 = 0;
            char charAt = str.charAt(0);
            Context context = this.context;
            if (charAt == '.') {
                str = context.getPackageName() + str;
            }
            FragmentManager fragmentManager = this.fragmentManager;
            FragmentManager.C00753 fragmentFactory = fragmentManager.getFragmentFactory();
            context.getClassLoader();
            Fragment instantiate = fragmentFactory.instantiate(str);
            Intrinsics.checkNotNullExpressionValue(instantiate, "instantiate(...)");
            instantiate.setArguments(arguments$navigation_common_release);
            BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
            if (navOptions != null) {
                i = navOptions.enterAnim;
            } else {
                i = -1;
            }
            if (navOptions != null) {
                i2 = navOptions.exitAnim;
            } else {
                i2 = -1;
            }
            if (navOptions != null) {
                i3 = navOptions.popEnterAnim;
            } else {
                i3 = -1;
            }
            if (navOptions != null) {
                i4 = navOptions.popExitAnim;
            } else {
                i4 = -1;
            }
            if (!(i == -1 && i2 == -1 && i3 == -1 && i4 == -1)) {
                if (i == -1) {
                    i = 0;
                }
                if (i2 == -1) {
                    i2 = 0;
                }
                if (i3 == -1) {
                    i3 = 0;
                }
                if (i4 != -1) {
                    i5 = i4;
                }
                backStackRecord.mEnterAnim = i;
                backStackRecord.mExitAnim = i2;
                backStackRecord.mPopEnterAnim = i3;
                backStackRecord.mPopExitAnim = i5;
            }
            backStackRecord.replace(this.containerId, instantiate, navBackStackEntry.f10id);
            backStackRecord.setPrimaryNavigationFragment(instantiate);
            backStackRecord.mReorderingAllowed = true;
            return backStackRecord;
        }
        throw new IllegalStateException("Fragment class was not set");
    }

    @Override // androidx.navigation.Navigator
    public final void navigate(List list, NavOptions navOptions) {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager.isStateSaved()) {
            Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
            boolean isEmpty = ((List) ((StateFlowImpl) getState().backStack.$$delegate_0).getValue()).isEmpty();
            if (navOptions == null || isEmpty || !navOptions.restoreState || !this.savedIds.remove(navBackStackEntry.f10id)) {
                BackStackRecord createFragmentTransaction = createFragmentTransaction(navBackStackEntry, navOptions);
                String str = navBackStackEntry.f10id;
                if (!isEmpty) {
                    NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.lastOrNull((List) ((StateFlowImpl) getState().backStack.$$delegate_0).getValue());
                    if (navBackStackEntry2 != null) {
                        addPendingOps$default(this, navBackStackEntry2.f10id, 6);
                    }
                    addPendingOps$default(this, str, 6);
                    createFragmentTransaction.addToBackStack(str);
                }
                createFragmentTransaction.commit();
                if (isLoggingEnabled()) {
                    Log.v("FragmentNavigator", "Calling pushWithTransition via navigate() on entry " + navBackStackEntry);
                }
                getState().pushWithTransition(navBackStackEntry);
            } else {
                fragmentManager.enqueueAction(new FragmentManager.SaveBackStackState(fragmentManager, navBackStackEntry.f10id, 1), false);
                getState().pushWithTransition(navBackStackEntry);
            }
        }
    }

    @Override // androidx.navigation.Navigator
    public final void onAttach(final NavController.NavControllerNavigatorState navControllerNavigatorState) {
        this._state = navControllerNavigatorState;
        this.isAttached = true;
        if (isLoggingEnabled()) {
            Log.v("FragmentNavigator", "onAttach");
        }
        FragmentOnAttachListener fragmentNavigator$$ExternalSyntheticLambda3 = new FragmentOnAttachListener() { // from class: androidx.navigation.fragment.FragmentNavigator$$ExternalSyntheticLambda3
            @Override // androidx.fragment.app.FragmentOnAttachListener
            public final void onAttachFragment(FragmentManager fragmentManager, Fragment fragment) {
                Object obj;
                Intrinsics.checkNotNullParameter(fragmentManager, "<unused var>");
                NavController.NavControllerNavigatorState navControllerNavigatorState2 = NavController.NavControllerNavigatorState.this;
                List list = (List) ((StateFlowImpl) navControllerNavigatorState2.backStack.$$delegate_0).getValue();
                ListIterator listIterator = list.listIterator(list.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        obj = null;
                        break;
                    }
                    obj = listIterator.previous();
                    if (Intrinsics.areEqual(((NavBackStackEntry) obj).f10id, fragment.getTag())) {
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                boolean isLoggingEnabled = FragmentNavigator.isLoggingEnabled();
                FragmentNavigator fragmentNavigator = this;
                if (isLoggingEnabled) {
                    Log.v("FragmentNavigator", "Attaching fragment " + fragment + " associated with entry " + navBackStackEntry + " to FragmentManager " + fragmentNavigator.fragmentManager);
                }
                if (navBackStackEntry != null) {
                    LiveData viewLifecycleOwnerLiveData = fragment.getViewLifecycleOwnerLiveData();
                    final FragmentNavigator$$ExternalSyntheticLambda4 fragmentNavigator$$ExternalSyntheticLambda4 = new FragmentNavigator$$ExternalSyntheticLambda4(fragmentNavigator, fragment, navBackStackEntry);
                    viewLifecycleOwnerLiveData.observe(fragment, new Observer() { // from class: androidx.navigation.fragment.FragmentNavigator$sam$androidx_lifecycle_Observer$0
                        public final boolean equals(Object obj2) {
                            if (!(obj2 instanceof Observer) || !(obj2 instanceof FragmentNavigator$sam$androidx_lifecycle_Observer$0)) {
                                return false;
                            }
                            return FragmentNavigator$$ExternalSyntheticLambda4.this.equals(FragmentNavigator$$ExternalSyntheticLambda4.this);
                        }

                        public final int hashCode() {
                            return FragmentNavigator$$ExternalSyntheticLambda4.this.hashCode();
                        }

                        @Override // androidx.lifecycle.Observer
                        public final /* synthetic */ void onChanged(Object obj2) {
                            FragmentNavigator$$ExternalSyntheticLambda4.this.invoke(obj2);
                        }
                    });
                    fragment.getLifecycle().addObserver(fragmentNavigator.fragmentObserver);
                    fragmentNavigator.attachClearViewModel$navigation_fragment_release(fragment, navBackStackEntry, navControllerNavigatorState2);
                }
            }
        };
        FragmentManager fragmentManager = this.fragmentManager;
        fragmentManager.mOnAttachListeners.add(fragmentNavigator$$ExternalSyntheticLambda3);
        fragmentManager.mBackStackChangeListeners.add(new FragmentManager.OnBackStackChangedListener() { // from class: androidx.navigation.fragment.FragmentNavigator$onAttach$2
            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final /* synthetic */ void onBackStackChangeCancelled() {
            }

            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChangeCommitted(Fragment fragment, boolean z) {
                Object obj;
                Object obj2;
                boolean z2;
                FragmentNavigator fragmentNavigator = this;
                ArrayList arrayList = fragmentNavigator.pendingOps;
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                NavController.NavControllerNavigatorState navControllerNavigatorState2 = NavController.NavControllerNavigatorState.this;
                ArrayList plus = CollectionsKt.plus((Collection) ((StateFlowImpl) navControllerNavigatorState2.backStack.$$delegate_0).getValue(), (Iterable) ((StateFlowImpl) navControllerNavigatorState2.transitionsInProgress.$$delegate_0).getValue());
                ListIterator listIterator = plus.listIterator(plus.size());
                while (true) {
                    obj = null;
                    if (!listIterator.hasPrevious()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = listIterator.previous();
                    if (Intrinsics.areEqual(((NavBackStackEntry) obj2).f10id, fragment.getTag())) {
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj2;
                boolean z3 = true;
                if (!z || !arrayList.isEmpty() || !fragment.isRemoving()) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    Object obj3 = arrayList.get(i);
                    i++;
                    if (Intrinsics.areEqual(((Pair) obj3).first, fragment.getTag())) {
                        obj = obj3;
                        break;
                    }
                }
                Pair pair = (Pair) obj;
                if (pair != null) {
                    arrayList.remove(pair);
                }
                if (!z2 && FragmentNavigator.isLoggingEnabled()) {
                    Log.v("FragmentNavigator", "OnBackStackChangedCommitted for fragment " + fragment + " associated with entry " + navBackStackEntry);
                }
                if (pair == null || !((Boolean) pair.second).booleanValue()) {
                    z3 = false;
                }
                if (!z && !z3 && navBackStackEntry == null) {
                    throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m597m("The fragment ", fragment, " is unknown to the FragmentNavigator. Please use the navigate() function to add fragments to the FragmentNavigator managed FragmentManager.").toString());
                } else if (navBackStackEntry != null) {
                    fragmentNavigator.attachClearViewModel$navigation_fragment_release(fragment, navBackStackEntry, navControllerNavigatorState2);
                    if (z2) {
                        if (FragmentNavigator.isLoggingEnabled()) {
                            Log.v("FragmentNavigator", "OnBackStackChangedCommitted for fragment " + fragment + " popping associated entry " + navBackStackEntry + " via system back");
                        }
                        navControllerNavigatorState2.popWithTransition(navBackStackEntry, false);
                    }
                }
            }

            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final /* synthetic */ void onBackStackChangeProgressed(BackEventCompat backEventCompat) {
            }

            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChangeStarted(Fragment fragment, boolean z) {
                Object obj;
                Intrinsics.checkNotNullParameter(fragment, "fragment");
                if (z) {
                    NavController.NavControllerNavigatorState navControllerNavigatorState2 = NavController.NavControllerNavigatorState.this;
                    List list = (List) ((StateFlowImpl) navControllerNavigatorState2.backStack.$$delegate_0).getValue();
                    ListIterator listIterator = list.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            obj = null;
                            break;
                        }
                        obj = listIterator.previous();
                        if (Intrinsics.areEqual(((NavBackStackEntry) obj).f10id, fragment.getTag())) {
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                    if (FragmentNavigator.isLoggingEnabled()) {
                        Log.v("FragmentNavigator", "OnBackStackChangedStarted for fragment " + fragment + " associated with entry " + navBackStackEntry);
                    }
                    if (navBackStackEntry != null) {
                        StateFlowImpl stateFlowImpl = navControllerNavigatorState2._transitionsInProgress;
                        stateFlowImpl.setValue(SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry));
                        NavControllerImpl navControllerImpl = navControllerNavigatorState2.this$0.impl;
                        navControllerImpl.getClass();
                        if (navControllerImpl.backQueue.contains(navBackStackEntry)) {
                            navBackStackEntry.setMaxLifecycle(Lifecycle.State.STARTED);
                            return;
                        }
                        throw new IllegalStateException("Cannot transition entry that is not in the back stack");
                    }
                }
            }

            @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
            public final void onBackStackChanged() {
            }
        });
    }

    @Override // androidx.navigation.Navigator
    public final void onLaunchSingleTop(NavBackStackEntry navBackStackEntry) {
        String str = navBackStackEntry.f10id;
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager.isStateSaved()) {
            Log.i("FragmentNavigator", "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        BackStackRecord createFragmentTransaction = createFragmentTransaction(navBackStackEntry, null);
        List list = (List) ((StateFlowImpl) getState().backStack.$$delegate_0).getValue();
        if (list.size() > 1) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.getOrNull(CollectionsKt__CollectionsKt.getLastIndex(list) - 1, list);
            if (navBackStackEntry2 != null) {
                addPendingOps$default(this, navBackStackEntry2.f10id, 6);
            }
            addPendingOps$default(this, str, 4);
            fragmentManager.enqueueAction(new FragmentManager.PopBackStackState(str, -1), false);
            addPendingOps$default(this, str, 2);
            createFragmentTransaction.addToBackStack(str);
        }
        createFragmentTransaction.commit();
        getState().onLaunchSingleTop(navBackStackEntry);
    }

    @Override // androidx.navigation.Navigator
    public final void onRestoreState(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("androidx-nav-fragment:navigator:savedIds");
        if (stringArrayList != null) {
            LinkedHashSet linkedHashSet = this.savedIds;
            linkedHashSet.clear();
            CollectionsKt__MutableCollectionsKt.addAll(stringArrayList, linkedHashSet);
        }
    }

    @Override // androidx.navigation.Navigator
    public final Bundle onSaveState() {
        LinkedHashSet linkedHashSet = this.savedIds;
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return BundleKt.bundleOf(new Pair("androidx-nav-fragment:navigator:savedIds", new ArrayList(linkedHashSet)));
    }

    @Override // androidx.navigation.Navigator
    public final void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        int i;
        boolean z2;
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager.isStateSaved()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List list = (List) ((StateFlowImpl) getState().backStack.$$delegate_0).getValue();
        int indexOf = list.indexOf(navBackStackEntry);
        List subList = list.subList(indexOf, list.size());
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.first(list);
        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) CollectionsKt.getOrNull(indexOf - 1, list);
        if (navBackStackEntry3 != null) {
            addPendingOps$default(this, navBackStackEntry3.f10id, 6);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = subList.iterator();
        while (true) {
            boolean z3 = false;
            if (it.hasNext()) {
                Object next = it.next();
                NavBackStackEntry navBackStackEntry4 = (NavBackStackEntry) next;
                ArrayList arrayList2 = this.pendingOps;
                Intrinsics.checkNotNullParameter(arrayList2, "<this>");
                String str = navBackStackEntry4.f10id;
                Iterator it2 = arrayList2.iterator();
                int i2 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i = -1;
                        break;
                    }
                    Pair it3 = (Pair) it2.next();
                    Intrinsics.checkNotNullParameter(it3, "it");
                    String str2 = (String) it3.first;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    } else if (Intrinsics.areEqual(str, str2)) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i >= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || !Intrinsics.areEqual(navBackStackEntry4.f10id, navBackStackEntry2.f10id)) {
                    z3 = true;
                }
                if (z3) {
                    arrayList.add(next);
                }
            } else {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    addPendingOps$default(this, ((NavBackStackEntry) obj).f10id, 4);
                }
                if (z) {
                    for (NavBackStackEntry navBackStackEntry5 : CollectionsKt.reversed(subList)) {
                        if (Intrinsics.areEqual(navBackStackEntry5, navBackStackEntry2)) {
                            Log.i("FragmentNavigator", "FragmentManager cannot save the state of the initial destination " + navBackStackEntry5);
                        } else {
                            fragmentManager.enqueueAction(new FragmentManager.SaveBackStackState(fragmentManager, navBackStackEntry5.f10id, 0), false);
                            this.savedIds.add(navBackStackEntry5.f10id);
                        }
                    }
                } else {
                    fragmentManager.enqueueAction(new FragmentManager.PopBackStackState(navBackStackEntry.f10id, -1), false);
                }
                if (isLoggingEnabled()) {
                    Log.v("FragmentNavigator", "Calling popWithTransition via popBackStack() on entry " + navBackStackEntry + " with savedState " + z);
                }
                getState().popWithTransition(navBackStackEntry, z);
                return;
            }
        }
    }
}
