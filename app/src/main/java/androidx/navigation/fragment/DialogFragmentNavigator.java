package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentOnAttachListener;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlinx.coroutines.flow.StateFlowImpl;
@Navigator.Name("dialog")
/* loaded from: classes.dex */
public final class DialogFragmentNavigator extends Navigator {
    public final Context context;
    public final FragmentManager fragmentManager;
    public final LinkedHashSet restoredTagsAwaitingAttach = new LinkedHashSet();
    public final Recreator observer = new Recreator(1, this);
    public final LinkedHashMap transitioningFragments = new LinkedHashMap();

    /* loaded from: classes.dex */
    public final class Destination extends NavDestination implements FloatingWindow {
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
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.DialogFragmentNavigator);
            Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(...)");
            String string = obtainAttributes.getString(0);
            if (string != null) {
                this._className = string;
            }
            obtainAttributes.recycle();
        }
    }

    public DialogFragmentNavigator(Context context, FragmentManager fragmentManager) {
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination createDestination() {
        return new NavDestination(this);
    }

    public final DialogFragment createDialogFragment(NavBackStackEntry navBackStackEntry) {
        NavDestination navDestination = navBackStackEntry.destination;
        Intrinsics.checkNotNull(navDestination, "null cannot be cast to non-null type androidx.navigation.fragment.DialogFragmentNavigator.Destination");
        Destination destination = (Destination) navDestination;
        String str = destination._className;
        if (str != null) {
            char charAt = str.charAt(0);
            Context context = this.context;
            if (charAt == '.') {
                str = context.getPackageName() + str;
            }
            FragmentManager.C00753 fragmentFactory = this.fragmentManager.getFragmentFactory();
            context.getClassLoader();
            Fragment instantiate = fragmentFactory.instantiate(str);
            Intrinsics.checkNotNullExpressionValue(instantiate, "instantiate(...)");
            if (DialogFragment.class.isAssignableFrom(instantiate.getClass())) {
                DialogFragment dialogFragment = (DialogFragment) instantiate;
                dialogFragment.setArguments(navBackStackEntry.impl.getArguments$navigation_common_release());
                dialogFragment.getLifecycle().addObserver(this.observer);
                this.transitioningFragments.put(navBackStackEntry.f10id, dialogFragment);
                return dialogFragment;
            }
            StringBuilder sb = new StringBuilder("Dialog destination ");
            String str2 = destination._className;
            if (str2 != null) {
                throw new IllegalArgumentException(ViewModelProvider.Factory.CC.m593m(sb, str2, " is not an instance of DialogFragment").toString());
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }
        throw new IllegalStateException("DialogFragment class was not set");
    }

    @Override // androidx.navigation.Navigator
    public final void navigate(List list, NavOptions navOptions) {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager.isStateSaved()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
            createDialogFragment(navBackStackEntry).show(fragmentManager, navBackStackEntry.f10id);
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.lastOrNull((List) ((StateFlowImpl) getState().backStack.$$delegate_0).getValue());
            boolean contains = CollectionsKt.contains((Iterable) ((StateFlowImpl) getState().transitionsInProgress.$$delegate_0).getValue(), navBackStackEntry2);
            getState().pushWithTransition(navBackStackEntry);
            if (navBackStackEntry2 != null && !contains) {
                getState().markTransitionComplete(navBackStackEntry2);
            }
        }
    }

    @Override // androidx.navigation.Navigator
    public final void onAttach(NavController.NavControllerNavigatorState navControllerNavigatorState) {
        Lifecycle lifecycle;
        this._state = navControllerNavigatorState;
        this.isAttached = true;
        Iterator it = ((List) ((StateFlowImpl) navControllerNavigatorState.backStack.$$delegate_0).getValue()).iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            FragmentManager fragmentManager = this.fragmentManager;
            if (hasNext) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(navBackStackEntry.f10id);
                if (dialogFragment == null || (lifecycle = dialogFragment.getLifecycle()) == null) {
                    this.restoredTagsAwaitingAttach.add(navBackStackEntry.f10id);
                } else {
                    lifecycle.addObserver(this.observer);
                }
            } else {
                fragmentManager.mOnAttachListeners.add(new FragmentOnAttachListener() { // from class: androidx.navigation.fragment.DialogFragmentNavigator$$ExternalSyntheticLambda0
                    @Override // androidx.fragment.app.FragmentOnAttachListener
                    public final void onAttachFragment(FragmentManager fragmentManager2, Fragment fragment) {
                        Intrinsics.checkNotNullParameter(fragmentManager2, "<unused var>");
                        DialogFragmentNavigator dialogFragmentNavigator = DialogFragmentNavigator.this;
                        LinkedHashSet linkedHashSet = dialogFragmentNavigator.restoredTagsAwaitingAttach;
                        String tag = fragment.getTag();
                        if (!(linkedHashSet instanceof KMappedMarker) || (linkedHashSet instanceof KMutableCollection)) {
                            if (linkedHashSet.remove(tag)) {
                                fragment.getLifecycle().addObserver(dialogFragmentNavigator.observer);
                            }
                            LinkedHashMap linkedHashMap = dialogFragmentNavigator.transitioningFragments;
                            String tag2 = fragment.getTag();
                            TypeIntrinsics.asMutableMap(linkedHashMap);
                            linkedHashMap.remove(tag2);
                            return;
                        }
                        TypeIntrinsics.throwCce(linkedHashSet, "kotlin.collections.MutableCollection");
                        throw null;
                    }
                });
                return;
            }
        }
    }

    @Override // androidx.navigation.Navigator
    public final void onLaunchSingleTop(NavBackStackEntry navBackStackEntry) {
        String str = navBackStackEntry.f10id;
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager.isStateSaved()) {
            Log.i("DialogFragmentNavigator", "Ignoring onLaunchSingleTop() call: FragmentManager has already saved its state");
            return;
        }
        DialogFragment dialogFragment = (DialogFragment) this.transitioningFragments.get(str);
        if (dialogFragment == null) {
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
            if (findFragmentByTag instanceof DialogFragment) {
                dialogFragment = (DialogFragment) findFragmentByTag;
            } else {
                dialogFragment = null;
            }
        }
        if (dialogFragment != null) {
            dialogFragment.getLifecycle().removeObserver(this.observer);
            dialogFragment.dismissInternal(false, false);
        }
        createDialogFragment(navBackStackEntry).show(fragmentManager, str);
        NavController.NavControllerNavigatorState state = getState();
        List list = (List) ((StateFlowImpl) state.backStack.$$delegate_0).getValue();
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) listIterator.previous();
            if (Intrinsics.areEqual(navBackStackEntry2.f10id, str)) {
                StateFlowImpl stateFlowImpl = state._transitionsInProgress;
                stateFlowImpl.setValue(SetsKt.plus(SetsKt.plus((Set) stateFlowImpl.getValue(), navBackStackEntry2), navBackStackEntry));
                state.onLaunchSingleTop(navBackStackEntry);
                return;
            }
        }
        throw new NoSuchElementException("List contains no element matching the predicate.");
    }

    @Override // androidx.navigation.Navigator
    public final void popBackStack(NavBackStackEntry navBackStackEntry, boolean z) {
        FragmentManager fragmentManager = this.fragmentManager;
        if (fragmentManager.isStateSaved()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return;
        }
        List list = (List) ((StateFlowImpl) getState().backStack.$$delegate_0).getValue();
        int indexOf = list.indexOf(navBackStackEntry);
        for (NavBackStackEntry navBackStackEntry2 : CollectionsKt.reversed(list.subList(indexOf, list.size()))) {
            Fragment findFragmentByTag = fragmentManager.findFragmentByTag(navBackStackEntry2.f10id);
            if (findFragmentByTag != null) {
                ((DialogFragment) findFragmentByTag).dismissInternal(false, false);
            }
        }
        popWithTransition(indexOf, navBackStackEntry, z);
    }

    public final void popWithTransition(int i, NavBackStackEntry navBackStackEntry, boolean z) {
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.getOrNull(i - 1, (List) ((StateFlowImpl) getState().backStack.$$delegate_0).getValue());
        boolean contains = CollectionsKt.contains((Iterable) ((StateFlowImpl) getState().transitionsInProgress.$$delegate_0).getValue(), navBackStackEntry2);
        getState().popWithTransition(navBackStackEntry, z);
        if (navBackStackEntry2 != null && !contains) {
            getState().markTransitionComplete(navBackStackEntry2);
        }
    }
}
