package androidx.savedstate;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.DialogFragmentNavigator$observer$1$WhenMappings;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
/* loaded from: classes.dex */
public final class Recreator implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final Object owner;

    public /* synthetic */ Recreator(int i, Object obj) {
        this.$r8$classId = i;
        this.owner = obj;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        int i;
        switch (this.$r8$classId) {
            case 0:
                SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) this.owner;
                if (event == Lifecycle.Event.ON_CREATE) {
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    Bundle consumeRestoredStateForKey = savedStateRegistryOwner.getSavedStateRegistry().consumeRestoredStateForKey("androidx.savedstate.Restarter");
                    if (consumeRestoredStateForKey != null) {
                        ArrayList<String> stringArrayList = consumeRestoredStateForKey.getStringArrayList("classes_to_restore");
                        if (stringArrayList != null) {
                            int size = stringArrayList.size();
                            int i2 = 0;
                            while (i2 < size) {
                                String str = stringArrayList.get(i2);
                                i2++;
                                String str2 = str;
                                try {
                                    Class<? extends U> asSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
                                    Intrinsics.checkNotNull(asSubclass);
                                    try {
                                        Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                                        declaredConstructor.setAccessible(true);
                                        try {
                                            Object newInstance = declaredConstructor.newInstance(null);
                                            Intrinsics.checkNotNull(newInstance);
                                            SavedStateRegistry.AutoRecreated autoRecreated = (SavedStateRegistry.AutoRecreated) newInstance;
                                            if (savedStateRegistryOwner instanceof ViewModelStoreOwner) {
                                                ViewModelStore viewModelStore = ((ViewModelStoreOwner) savedStateRegistryOwner).getViewModelStore();
                                                SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                                                viewModelStore.getClass();
                                                LinkedHashMap linkedHashMap = viewModelStore.map;
                                                Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                                                while (it.hasNext()) {
                                                    String key = (String) it.next();
                                                    Intrinsics.checkNotNullParameter(key, "key");
                                                    ViewModel viewModel = (ViewModel) linkedHashMap.get(key);
                                                    if (viewModel != null) {
                                                        SavedStateHandleSupport.attachHandleIfNeeded(viewModel, savedStateRegistry, savedStateRegistryOwner.getLifecycle());
                                                    }
                                                }
                                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                                    savedStateRegistry.runOnNextRecreation();
                                                }
                                            } else {
                                                throw new IllegalStateException(("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner. Received owner: " + savedStateRegistryOwner).toString());
                                            }
                                        } catch (Exception e) {
                                            throw new RuntimeException("Failed to instantiate " + str2, e);
                                        }
                                    } catch (NoSuchMethodException e2) {
                                        throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
                                    }
                                } catch (ClassNotFoundException e3) {
                                    throw new RuntimeException(ViewModelProvider.Factory.CC.m595m("Class ", str2, " wasn't found"), e3);
                                }
                            }
                            return;
                        }
                        throw new IllegalStateException("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                    }
                    return;
                }
                throw new AssertionError("Next event must be ON_CREATE");
            default:
                DialogFragmentNavigator dialogFragmentNavigator = (DialogFragmentNavigator) this.owner;
                int i3 = DialogFragmentNavigator$observer$1$WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i3 != 1) {
                    Object obj = null;
                    if (i3 == 2) {
                        DialogFragment dialogFragment = (DialogFragment) lifecycleOwner;
                        for (Object obj2 : (Iterable) ((StateFlowImpl) dialogFragmentNavigator.getState().transitionsInProgress.$$delegate_0).getValue()) {
                            if (Intrinsics.areEqual(((NavBackStackEntry) obj2).f10id, dialogFragment.getTag())) {
                                obj = obj2;
                            }
                        }
                        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                        if (navBackStackEntry != null) {
                            dialogFragmentNavigator.getState().markTransitionComplete(navBackStackEntry);
                            return;
                        }
                        return;
                    } else if (i3 == 3) {
                        DialogFragment dialogFragment2 = (DialogFragment) lifecycleOwner;
                        if (!dialogFragment2.requireDialog().isShowing()) {
                            List list = (List) ((StateFlowImpl) dialogFragmentNavigator.getState().backStack.$$delegate_0).getValue();
                            ListIterator listIterator = list.listIterator(list.size());
                            while (true) {
                                if (!listIterator.hasPrevious()) {
                                    i = -1;
                                } else if (Intrinsics.areEqual(((NavBackStackEntry) listIterator.previous()).f10id, dialogFragment2.getTag())) {
                                    i = listIterator.nextIndex();
                                }
                            }
                            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) CollectionsKt.getOrNull(i, list);
                            if (!Intrinsics.areEqual(CollectionsKt.lastOrNull(list), navBackStackEntry2)) {
                                Log.i("DialogFragmentNavigator", "Dialog " + dialogFragment2 + " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
                            }
                            if (navBackStackEntry2 != null) {
                                dialogFragmentNavigator.popWithTransition(i, navBackStackEntry2, false);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (i3 == 4) {
                        DialogFragment dialogFragment3 = (DialogFragment) lifecycleOwner;
                        for (Object obj3 : (Iterable) ((StateFlowImpl) dialogFragmentNavigator.getState().transitionsInProgress.$$delegate_0).getValue()) {
                            if (Intrinsics.areEqual(((NavBackStackEntry) obj3).f10id, dialogFragment3.getTag())) {
                                obj = obj3;
                            }
                        }
                        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj;
                        if (navBackStackEntry3 != null) {
                            dialogFragmentNavigator.getState().markTransitionComplete(navBackStackEntry3);
                        }
                        dialogFragment3.getLifecycle().removeObserver(this);
                        return;
                    } else {
                        return;
                    }
                } else {
                    DialogFragment dialogFragment4 = (DialogFragment) lifecycleOwner;
                    Iterable<NavBackStackEntry> iterable = (Iterable) ((StateFlowImpl) dialogFragmentNavigator.getState().backStack.$$delegate_0).getValue();
                    if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                        for (NavBackStackEntry navBackStackEntry4 : iterable) {
                            if (Intrinsics.areEqual(navBackStackEntry4.f10id, dialogFragment4.getTag())) {
                                return;
                            }
                        }
                    }
                    dialogFragment4.dismissInternal(false, false);
                    return;
                }
        }
    }
}
