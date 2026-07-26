package androidx.navigation.internal;

import android.os.Bundle;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController;
import androidx.navigation.NavController$$ExternalSyntheticLambda0;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.NavUriUtils;
import androidx.navigation.Navigation;
import androidx.navigation.Navigation$$ExternalSyntheticLambda0;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.fragment.FragmentNavigator$$ExternalSyntheticLambda0;
import com.android.billingclient.api.zzca;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.ArrayAsCollection;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TakeWhileSequence;
import kotlin.sequences.TakeWhileSequence$iterator$1;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
/* loaded from: classes.dex */
public final class NavControllerImpl {
    public final StateFlowImpl _currentBackStack;
    public NavGraph _graph;
    public final StateFlowImpl _visibleEntries;
    public Function1 addToBackStackHandler;
    public Bundle[] backStackToRestore;
    public int dispatchReentrantCount;
    public LifecycleOwner lifecycleOwner;
    public final NavController navController;
    public Bundle navigatorStateToRestore;
    public NavControllerImpl$$ExternalSyntheticLambda2 popFromBackStackHandler;
    public final NavController$$ExternalSyntheticLambda0 updateOnBackPressedCallbackEnabledCallback;
    public NavControllerViewModel viewModel;
    public final ArrayDeque backQueue = new ArrayDeque();
    public final LinkedHashMap childToParentEntries = new LinkedHashMap();
    public final LinkedHashMap parentToChildCount = new LinkedHashMap();
    public final LinkedHashMap backStackMap = new LinkedHashMap();
    public final LinkedHashMap backStackStates = new LinkedHashMap();
    public final ArrayList onDestinationChangedListeners = new ArrayList();
    public Lifecycle.State hostLifecycleState = Lifecycle.State.INITIALIZED;
    public final FragmentNavigator$$ExternalSyntheticLambda0 lifecycleObserver = new FragmentNavigator$$ExternalSyntheticLambda0(1, this);
    public final NavigatorProvider _navigatorProvider = new NavigatorProvider();
    public final LinkedHashMap navigatorState = new LinkedHashMap();
    public final LinkedHashMap entrySavedState = new LinkedHashMap();
    public final ArrayList backStackEntriesToDispatch = new ArrayList();
    public final SharedFlowImpl _currentBackStackEntryFlow = new Object();

    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.Object, kotlinx.coroutines.flow.SharedFlowImpl] */
    public NavControllerImpl(NavController navController, NavController$$ExternalSyntheticLambda0 navController$$ExternalSyntheticLambda0) {
        this.navController = navController;
        this.updateOnBackPressedCallbackEnabledCallback = navController$$ExternalSyntheticLambda0;
        EmptyList emptyList = EmptyList.INSTANCE;
        this._currentBackStack = new StateFlowImpl(emptyList);
        this._visibleEntries = new StateFlowImpl(emptyList);
    }

    public static NavDestination findDestinationComprehensive$navigation_runtime_release(int i, NavDestination navDestination, NavDestination navDestination2, boolean z) {
        NavGraph navGraph;
        if (navDestination.impl.id == i && (navDestination2 == null || (navDestination.equals(navDestination2) && Intrinsics.areEqual(navDestination.parent, navDestination2.parent)))) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = null;
        }
        if (navGraph == null) {
            navGraph = navDestination.parent;
            Intrinsics.checkNotNull(navGraph);
        }
        return navGraph.impl.findNodeComprehensive$navigation_common_release(i, navGraph, navDestination2, z);
    }

    public static /* synthetic */ void popEntryFromBackStack$navigation_runtime_release$default(NavControllerImpl navControllerImpl, NavBackStackEntry navBackStackEntry) {
        navControllerImpl.popEntryFromBackStack$navigation_runtime_release(navBackStackEntry, false, new ArrayDeque());
    }

    public final void addEntryToBackStack(NavDestination navDestination, Bundle bundle, NavBackStackEntry navBackStackEntry, List list) {
        NavDestination navDestination2;
        Object obj;
        NavDestination navDestination3;
        Object obj2;
        Bundle bundle2;
        Object obj3;
        Object obj4;
        NavContext navContext = this.navController.navContext;
        NavDestination navDestination4 = navBackStackEntry.destination;
        boolean z = navDestination4 instanceof FloatingWindow;
        ArrayDeque arrayDeque = this.backQueue;
        if (!z) {
            while (!arrayDeque.isEmpty() && (((NavBackStackEntry) arrayDeque.last()).destination instanceof FloatingWindow) && popBackStackInternal$navigation_runtime_release(((NavBackStackEntry) arrayDeque.last()).destination.impl.id, true, false)) {
            }
        }
        ArrayDeque arrayDeque2 = new ArrayDeque();
        NavBackStackEntry navBackStackEntry2 = null;
        if (navDestination instanceof NavGraph) {
            NavDestination navDestination5 = navDestination4;
            do {
                Intrinsics.checkNotNull(navDestination5);
                navDestination5 = navDestination5.parent;
                if (navDestination5 != null) {
                    ListIterator listIterator = list.listIterator(list.size());
                    while (true) {
                        if (!listIterator.hasPrevious()) {
                            obj4 = null;
                            break;
                        }
                        obj4 = listIterator.previous();
                        if (Intrinsics.areEqual(((NavBackStackEntry) obj4).destination, navDestination5)) {
                            break;
                        }
                    }
                    NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj4;
                    if (navBackStackEntry3 == null) {
                        navBackStackEntry3 = NavUriUtils.create$default(navContext, navDestination5, bundle, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                    }
                    arrayDeque2.addFirst(navBackStackEntry3);
                    if (!arrayDeque.isEmpty() && ((NavBackStackEntry) arrayDeque.last()).destination == navDestination5) {
                        popEntryFromBackStack$navigation_runtime_release$default(this, (NavBackStackEntry) arrayDeque.last());
                    }
                }
                if (navDestination5 == null) {
                    break;
                }
            } while (navDestination5 != navDestination);
        }
        if (arrayDeque2.isEmpty()) {
            navDestination2 = navDestination4;
        } else {
            navDestination2 = ((NavBackStackEntry) arrayDeque2.first()).destination;
        }
        while (navDestination2 != null && findDestination$navigation_runtime_release(navDestination2.impl.id, navDestination2) != navDestination2) {
            navDestination2 = navDestination2.parent;
            if (navDestination2 != null) {
                if (bundle == null || !bundle.isEmpty()) {
                    bundle2 = bundle;
                } else {
                    bundle2 = null;
                }
                ListIterator listIterator2 = list.listIterator(list.size());
                while (true) {
                    if (!listIterator2.hasPrevious()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = listIterator2.previous();
                    if (Intrinsics.areEqual(((NavBackStackEntry) obj3).destination, navDestination2)) {
                        break;
                    }
                }
                NavBackStackEntry navBackStackEntry4 = (NavBackStackEntry) obj3;
                if (navBackStackEntry4 == null) {
                    navBackStackEntry4 = NavUriUtils.create$default(navContext, navDestination2, navDestination2.addInDefaultArgs(bundle2), getHostLifecycleState$navigation_runtime_release(), this.viewModel);
                }
                arrayDeque2.addFirst(navBackStackEntry4);
            }
        }
        if (!arrayDeque2.isEmpty()) {
            navDestination4 = ((NavBackStackEntry) arrayDeque2.first()).destination;
        }
        while (!arrayDeque.isEmpty() && (((NavBackStackEntry) arrayDeque.last()).destination instanceof NavGraph)) {
            NavDestination navDestination6 = ((NavBackStackEntry) arrayDeque.last()).destination;
            Intrinsics.checkNotNull(navDestination6, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            if (((SparseArrayCompat) ((NavGraph) navDestination6).impl.zzb).get(navDestination4.impl.id) != null) {
                break;
            }
            popEntryFromBackStack$navigation_runtime_release$default(this, (NavBackStackEntry) arrayDeque.last());
        }
        if (arrayDeque.isEmpty()) {
            obj = null;
        } else {
            obj = arrayDeque.elementData[arrayDeque.head];
        }
        NavBackStackEntry navBackStackEntry5 = (NavBackStackEntry) obj;
        if (navBackStackEntry5 == null) {
            if (arrayDeque2.isEmpty()) {
                obj2 = null;
            } else {
                obj2 = arrayDeque2.elementData[arrayDeque2.head];
            }
            navBackStackEntry5 = (NavBackStackEntry) obj2;
        }
        if (navBackStackEntry5 != null) {
            navDestination3 = navBackStackEntry5.destination;
        } else {
            navDestination3 = null;
        }
        if (!Intrinsics.areEqual(navDestination3, this._graph)) {
            ListIterator listIterator3 = list.listIterator(list.size());
            while (true) {
                if (!listIterator3.hasPrevious()) {
                    break;
                }
                Object previous = listIterator3.previous();
                NavDestination navDestination7 = ((NavBackStackEntry) previous).destination;
                NavGraph navGraph = this._graph;
                Intrinsics.checkNotNull(navGraph);
                if (Intrinsics.areEqual(navDestination7, navGraph)) {
                    navBackStackEntry2 = previous;
                    break;
                }
            }
            NavBackStackEntry navBackStackEntry6 = navBackStackEntry2;
            if (navBackStackEntry6 == null) {
                NavGraph navGraph2 = this._graph;
                Intrinsics.checkNotNull(navGraph2);
                NavGraph navGraph3 = this._graph;
                Intrinsics.checkNotNull(navGraph3);
                navBackStackEntry6 = NavUriUtils.create$default(navContext, navGraph2, navGraph3.addInDefaultArgs(bundle), getHostLifecycleState$navigation_runtime_release(), this.viewModel);
            }
            arrayDeque2.addFirst(navBackStackEntry6);
        }
        Iterator it = arrayDeque2.iterator();
        while (it.hasNext()) {
            NavBackStackEntry navBackStackEntry7 = (NavBackStackEntry) it.next();
            Object obj5 = this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry7.destination.navigatorName));
            if (obj5 != null) {
                ((NavController.NavControllerNavigatorState) obj5).addInternal(navBackStackEntry7);
            } else {
                throw new IllegalStateException(ViewModelProvider.Factory.CC.m(new StringBuilder("NavigatorBackStack for "), navDestination.navigatorName, " should already be created").toString());
            }
        }
        arrayDeque.addAll(arrayDeque2);
        arrayDeque.addLast(navBackStackEntry);
        ArrayList arrayList = new ArrayList(arrayDeque2.size() + 1);
        arrayList.addAll(arrayDeque2);
        arrayList.add(navBackStackEntry);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj6 = arrayList.get(i);
            i++;
            NavBackStackEntry navBackStackEntry8 = (NavBackStackEntry) obj6;
            NavGraph navGraph4 = navBackStackEntry8.destination.parent;
            if (navGraph4 != null) {
                linkChildToParent$navigation_runtime_release(navBackStackEntry8, getBackStackEntry$navigation_runtime_release(((NavDestination) navGraph4).impl.id));
            }
        }
    }

    public final boolean dispatchOnDestinationChanged$navigation_runtime_release() {
        boolean z;
        Continuation[] continuationArr;
        ArrayList arrayList = this.backStackEntriesToDispatch;
        ArrayDeque arrayDeque = this.backQueue;
        while (!arrayDeque.isEmpty() && (((NavBackStackEntry) arrayDeque.last()).destination instanceof NavGraph)) {
            popEntryFromBackStack$navigation_runtime_release$default(this, (NavBackStackEntry) arrayDeque.last());
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) arrayDeque.lastOrNull();
        if (navBackStackEntry != null) {
            arrayList.add(navBackStackEntry);
        }
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int i = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = i;
        int i2 = 0;
        if (i == 0) {
            ArrayList mutableList = CollectionsKt.toMutableList(arrayList);
            arrayList.clear();
            int size = mutableList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = mutableList.get(i3);
                int i4 = i3 + 1;
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
                Iterator it = CollectionsKt.toList(this.onDestinationChangedListeners).iterator();
                if (!it.hasNext()) {
                    SharedFlowImpl sharedFlowImpl = this._currentBackStackEntryFlow;
                    Continuation[] continuationArr2 = NullSurrogateKt.EMPTY_RESUMES;
                    synchronized (sharedFlowImpl) {
                        int i5 = sharedFlowImpl.bufferSize;
                        Object[] objArr = sharedFlowImpl.buffer;
                        if (objArr == null) {
                            objArr = sharedFlowImpl.growBuffer(null, i2, 2);
                        } else if (i5 >= objArr.length) {
                            objArr = sharedFlowImpl.growBuffer(objArr, i5, objArr.length * 2);
                        }
                        objArr[((int) (sharedFlowImpl.getHead() + i5)) & (objArr.length - 1)] = navBackStackEntry2;
                        int i6 = sharedFlowImpl.bufferSize + 1;
                        sharedFlowImpl.bufferSize = i6;
                        if (i6 > 1) {
                            Object[] objArr2 = sharedFlowImpl.buffer;
                            Intrinsics.checkNotNull(objArr2);
                            objArr2[(objArr2.length - 1) & ((int) sharedFlowImpl.getHead())] = null;
                            sharedFlowImpl.bufferSize--;
                            long head = sharedFlowImpl.getHead() + 1;
                            if (sharedFlowImpl.replayIndex < head) {
                                sharedFlowImpl.replayIndex = head;
                            }
                            if (sharedFlowImpl.minCollectorIndex < head) {
                                sharedFlowImpl.minCollectorIndex = head;
                            }
                        }
                        sharedFlowImpl.minCollectorIndex = sharedFlowImpl.getHead() + sharedFlowImpl.bufferSize;
                        continuationArr = continuationArr2;
                    }
                    for (Continuation continuation : continuationArr) {
                        if (continuation != null) {
                            continuation.resumeWith(Unit.INSTANCE);
                        }
                    }
                    i3 = i4;
                    i2 = 0;
                } else if (it.next() == null) {
                    NavDestination navDestination = navBackStackEntry2.destination;
                    navBackStackEntry2.impl.getArguments$navigation_common_release();
                    throw null;
                } else {
                    throw new ClassCastException();
                }
            }
            z = false;
            this._currentBackStack.setValue(CollectionsKt.toMutableList(arrayDeque));
            this._visibleEntries.setValue(populateVisibleEntries$navigation_runtime_release());
        } else {
            z = false;
        }
        if (navBackStackEntry != null) {
            return true;
        }
        return z;
    }

    public final NavDestination findDestination$navigation_runtime_release(int i, NavDestination navDestination) {
        NavDestination navDestination2;
        NavGraph navGraph = this._graph;
        if (navGraph == null) {
            return null;
        }
        if (((NavDestination) navGraph).impl.id == i) {
            if (navDestination == null) {
                return navGraph;
            }
            if (Intrinsics.areEqual(navGraph, navDestination) && navDestination.parent == null) {
                return this._graph;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.lastOrNull();
        if (navBackStackEntry == null || (navDestination2 = navBackStackEntry.destination) == null) {
            navDestination2 = this._graph;
            Intrinsics.checkNotNull(navDestination2);
        }
        return findDestinationComprehensive$navigation_runtime_release(i, navDestination2, navDestination, false);
    }

    public final NavBackStackEntry getBackStackEntry$navigation_runtime_release(int i) {
        Object obj;
        ArrayDeque arrayDeque = this.backQueue;
        ListIterator<E> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            if (((NavBackStackEntry) obj).destination.impl.id == i) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        StringBuilder m = ViewModelProvider.Factory.CC.m("No destination with ID ", i, " is on the NavController's back stack. The current destination is ");
        m.append(getCurrentDestination$navigation_runtime_release());
        throw new IllegalArgumentException(m.toString().toString());
    }

    public final NavDestination getCurrentDestination$navigation_runtime_release() {
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.backQueue.lastOrNull();
        if (navBackStackEntry != null) {
            return navBackStackEntry.destination;
        }
        return null;
    }

    public final NavGraph getGraph$navigation_runtime_release() {
        NavGraph navGraph = this._graph;
        if (navGraph != null) {
            Intrinsics.checkNotNull(navGraph, "null cannot be cast to non-null type androidx.navigation.NavGraph");
            return navGraph;
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()");
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        if (this.lifecycleOwner == null) {
            return Lifecycle.State.CREATED;
        }
        return this.hostLifecycleState;
    }

    public final void linkChildToParent$navigation_runtime_release(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.childToParentEntries.put(navBackStackEntry, navBackStackEntry2);
        LinkedHashMap linkedHashMap = this.parentToChildCount;
        if (linkedHashMap.get(navBackStackEntry2) == null) {
            linkedHashMap.put(navBackStackEntry2, new AtomicInt());
        }
        Object obj = linkedHashMap.get(navBackStackEntry2);
        Intrinsics.checkNotNull(obj);
        ((AtomicInt) obj).atomicInt.incrementAndGet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f6, code lost:
        if (r13.equals(r3) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0106, code lost:
        if (r3.id == r6.impl.id) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0108, code lost:
        r3 = new kotlin.collections.ArrayDeque();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0111, code lost:
        if (kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r12) < r14) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0113, code lost:
        r6 = (androidx.navigation.NavBackStackEntry) kotlin.collections.CollectionsKt__MutableCollectionsKt.removeLast(r12);
        unlinkChildFromParent$navigation_runtime_release(r6);
        r23 = r4;
        r15 = new androidx.navigation.NavBackStackEntry(r6.context, r6.destination, r6.destination.addInDefaultArgs(r26), r6.hostLifecycleState, r6.viewModelStoreProvider, r6.id, r6.savedState);
        r4 = r6.hostLifecycleState;
        r8 = r15.impl;
        r8.getClass();
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r8.hostLifecycleState = r4;
        r4 = r6.impl.maxLifecycle;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, "maxState");
        r8.maxLifecycle = r4;
        r8.updateState$navigation_common_release();
        r3.addFirst(r15);
        r4 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0166, code lost:
        r23 = r4;
        r4 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0170, code lost:
        if (r4.hasNext() == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0172, code lost:
        r6 = (androidx.navigation.NavBackStackEntry) r4.next();
        r7 = r6.destination.parent;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x017c, code lost:
        if (r7 == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x017e, code lost:
        linkChildToParent$navigation_runtime_release(r6, getBackStackEntry$navigation_runtime_release(((androidx.navigation.NavDestination) r7).impl.id));
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0189, code lost:
        r12.addLast(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x018d, code lost:
        r3 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0195, code lost:
        if (r3.hasNext() == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0197, code lost:
        r4 = (androidx.navigation.NavBackStackEntry) r3.next();
        r11.getNavigator(r4.destination.navigatorName).onLaunchSingleTop(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01a9, code lost:
        r7 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e8 A[LOOP:6: B:66:0x01e2->B:68:0x01e8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.jvm.internal.Ref$BooleanRef, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void navigate$navigation_runtime_release(final androidx.navigation.NavDestination r25, android.os.Bundle r26, androidx.navigation.NavOptions r27) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.internal.NavControllerImpl.navigate$navigation_runtime_release(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions):void");
    }

    /* JADX WARN: Type inference failed for: r1v12, types: [kotlin.jvm.internal.Ref$BooleanRef, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.Ref$BooleanRef, java.lang.Object] */
    public final boolean popBackStackInternal$navigation_runtime_release(int i, boolean z, boolean z2) {
        NavDestination navDestination;
        boolean z3;
        Object obj;
        String str;
        ArrayDeque arrayDeque = this.backQueue;
        if (arrayDeque.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.reversed(arrayDeque).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            NavDestination navDestination2 = ((NavBackStackEntry) it.next()).destination;
            String str2 = navDestination2.navigatorName;
            NavDestinationImpl navDestinationImpl = navDestination2.impl;
            Navigator navigator = this._navigatorProvider.getNavigator(str2);
            if (z || navDestinationImpl.id != i) {
                arrayList.add(navigator);
            }
            if (navDestinationImpl.id == i) {
                navDestination = navDestination2;
                break;
            }
        }
        if (navDestination == null) {
            int i2 = NavDestination.$r8$clinit;
            String message = "Ignoring popBackStack to destination " + Navigation.getDisplayName(this.navController.navContext, i) + " as it was not found on the current back stack";
            Intrinsics.checkNotNullParameter(message, "message");
            Log.i("NavController", message);
            return false;
        }
        ?? obj2 = new Object();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                z3 = z2;
                break;
            }
            int i4 = i3 + 1;
            Navigator navigator2 = (Navigator) arrayList.get(i3);
            ?? obj3 = new Object();
            NavBackStackEntry popUpTo = (NavBackStackEntry) arrayDeque.last();
            z3 = z2;
            NavControllerImpl$$ExternalSyntheticLambda2 navControllerImpl$$ExternalSyntheticLambda2 = new NavControllerImpl$$ExternalSyntheticLambda2(obj3, obj2, this, z3, arrayDeque2);
            Intrinsics.checkNotNullParameter(navigator2, "navigator");
            Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
            this.popFromBackStackHandler = navControllerImpl$$ExternalSyntheticLambda2;
            navigator2.popBackStack(popUpTo, z3);
            this.popFromBackStackHandler = null;
            if (!obj3.element) {
                break;
            }
            i3 = i4;
        }
        if (z3) {
            LinkedHashMap linkedHashMap = this.backStackMap;
            if (!z) {
                TakeWhileSequence$iterator$1 takeWhileSequence$iterator$1 = new TakeWhileSequence$iterator$1(new TakeWhileSequence(SequencesKt.generateSequence(navDestination, new Navigation$$ExternalSyntheticLambda0(9)), new Function1(this) { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda4
                    public final /* synthetic */ NavControllerImpl f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        boolean containsKey;
                        NavDestination destination = (NavDestination) obj4;
                        switch (r2) {
                            case 0:
                                Intrinsics.checkNotNullParameter(destination, "destination");
                                containsKey = this.f$0.backStackMap.containsKey(Integer.valueOf(destination.impl.id));
                                break;
                            default:
                                Intrinsics.checkNotNullParameter(destination, "destination");
                                containsKey = this.f$0.backStackMap.containsKey(Integer.valueOf(destination.impl.id));
                                break;
                        }
                        return Boolean.valueOf(!containsKey);
                    }
                }, 0));
                while (takeWhileSequence$iterator$1.hasNext()) {
                    Integer valueOf = Integer.valueOf(((NavDestination) takeWhileSequence$iterator$1.next()).impl.id);
                    if (arrayDeque2.isEmpty()) {
                        obj = null;
                    } else {
                        obj = arrayDeque2.elementData[arrayDeque2.head];
                    }
                    NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) obj;
                    if (navBackStackEntryState != null) {
                        str = (String) navBackStackEntryState.impl.zza;
                    } else {
                        str = null;
                    }
                    linkedHashMap.put(valueOf, str);
                }
            }
            if (!arrayDeque2.isEmpty()) {
                zzca zzcaVar = ((NavBackStackEntryState) arrayDeque2.first()).impl;
                TakeWhileSequence$iterator$1 takeWhileSequence$iterator$12 = new TakeWhileSequence$iterator$1(new TakeWhileSequence(SequencesKt.generateSequence(findDestination$navigation_runtime_release(zzcaVar.zzd, null), new Navigation$$ExternalSyntheticLambda0(10)), new Function1(this) { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda4
                    public final /* synthetic */ NavControllerImpl f$0;

                    {
                        this.f$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj4) {
                        boolean containsKey;
                        NavDestination destination = (NavDestination) obj4;
                        switch (r2) {
                            case 0:
                                Intrinsics.checkNotNullParameter(destination, "destination");
                                containsKey = this.f$0.backStackMap.containsKey(Integer.valueOf(destination.impl.id));
                                break;
                            default:
                                Intrinsics.checkNotNullParameter(destination, "destination");
                                containsKey = this.f$0.backStackMap.containsKey(Integer.valueOf(destination.impl.id));
                                break;
                        }
                        return Boolean.valueOf(!containsKey);
                    }
                }, 0));
                while (takeWhileSequence$iterator$12.hasNext()) {
                    linkedHashMap.put(Integer.valueOf(((NavDestination) takeWhileSequence$iterator$12.next()).impl.id), (String) zzcaVar.zza);
                }
                if (linkedHashMap.values().contains((String) zzcaVar.zza)) {
                    this.backStackStates.put((String) zzcaVar.zza, arrayDeque2);
                }
            }
        }
        this.updateOnBackPressedCallbackEnabledCallback.invoke();
        return obj2.element;
    }

    public final void popEntryFromBackStack$navigation_runtime_release(NavBackStackEntry popUpTo, boolean z, ArrayDeque arrayDeque) {
        NavControllerViewModel navControllerViewModel;
        ReadonlyStateFlow readonlyStateFlow;
        Set set;
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        ArrayDeque arrayDeque2 = this.backQueue;
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) arrayDeque2.last();
        if (Intrinsics.areEqual(navBackStackEntry, popUpTo)) {
            CollectionsKt__MutableCollectionsKt.removeLast(arrayDeque2);
            NavController.NavControllerNavigatorState navControllerNavigatorState = (NavController.NavControllerNavigatorState) this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry.destination.navigatorName));
            boolean z2 = true;
            if ((navControllerNavigatorState == null || (readonlyStateFlow = navControllerNavigatorState.transitionsInProgress) == null || (set = (Set) ((StateFlowImpl) readonlyStateFlow.$$delegate_0).getValue()) == null || !set.contains(navBackStackEntry)) && !this.parentToChildCount.containsKey(navBackStackEntry)) {
                z2 = false;
            }
            Lifecycle.State state = navBackStackEntry.impl.lifecycle.state;
            Lifecycle.State state2 = Lifecycle.State.CREATED;
            if (state.compareTo(state2) >= 0) {
                if (z) {
                    navBackStackEntry.setMaxLifecycle(state2);
                    arrayDeque.addFirst(new NavBackStackEntryState(navBackStackEntry));
                }
                if (!z2) {
                    navBackStackEntry.setMaxLifecycle(Lifecycle.State.DESTROYED);
                    unlinkChildFromParent$navigation_runtime_release(navBackStackEntry);
                } else {
                    navBackStackEntry.setMaxLifecycle(state2);
                }
            }
            if (!z && !z2 && (navControllerViewModel = this.viewModel) != null) {
                String backStackEntryId = navBackStackEntry.id;
                Intrinsics.checkNotNullParameter(backStackEntryId, "backStackEntryId");
                ViewModelStore viewModelStore = (ViewModelStore) navControllerViewModel.viewModelStores.remove(backStackEntryId);
                if (viewModelStore != null) {
                    viewModelStore.clear();
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException(("Attempted to pop " + popUpTo.destination + ", which is not the top of the back stack (" + navBackStackEntry.destination + ')').toString());
    }

    public final ArrayList populateVisibleEntries$navigation_runtime_release() {
        Lifecycle.State state;
        ArrayList arrayList = new ArrayList();
        Iterator it = this.navigatorState.values().iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            state = Lifecycle.State.STARTED;
            if (!hasNext) {
                break;
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : (Iterable) ((StateFlowImpl) ((NavController.NavControllerNavigatorState) it.next()).transitionsInProgress.$$delegate_0).getValue()) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if (!arrayList.contains(navBackStackEntry) && navBackStackEntry.impl.maxLifecycle.compareTo(state) < 0) {
                    arrayList2.add(obj);
                }
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = this.backQueue.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) next;
            if (!arrayList.contains(navBackStackEntry2) && navBackStackEntry2.impl.maxLifecycle.compareTo(state) >= 0) {
                arrayList3.add(next);
            }
        }
        CollectionsKt__MutableCollectionsKt.addAll(arrayList3, arrayList);
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            if (!(((NavBackStackEntry) obj2).destination instanceof NavGraph)) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [kotlin.jvm.internal.Ref$IntRef, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.jvm.internal.Ref$BooleanRef, java.lang.Object] */
    public final boolean restoreStateInternal(int i, final Bundle bundle, NavOptions navOptions) {
        NavDestination navDestination;
        String str;
        NavBackStackEntry navBackStackEntry;
        NavDestination navDestination2;
        Bundle bundle2;
        Integer valueOf = Integer.valueOf(i);
        LinkedHashMap linkedHashMap = this.backStackMap;
        int i2 = 0;
        if (!linkedHashMap.containsKey(valueOf)) {
            return false;
        }
        String str2 = (String) linkedHashMap.get(Integer.valueOf(i));
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullParameter(values, "<this>");
        Iterator it = values.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual((String) it.next(), str2)) {
                it.remove();
            }
        }
        LinkedHashMap linkedHashMap2 = this.backStackStates;
        TypeIntrinsics.asMutableMap(linkedHashMap2);
        ArrayDeque arrayDeque = (ArrayDeque) linkedHashMap2.remove(str2);
        NavContext context = this.navController.navContext;
        ArrayList arrayList = new ArrayList();
        NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) this.backQueue.lastOrNull();
        if (navBackStackEntry2 == null || (navDestination = navBackStackEntry2.destination) == null) {
            navDestination = getGraph$navigation_runtime_release();
        }
        if (arrayDeque != null) {
            Iterator it2 = arrayDeque.iterator();
            while (it2.hasNext()) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) it2.next();
                zzca zzcaVar = navBackStackEntryState.impl;
                zzca zzcaVar2 = navBackStackEntryState.impl;
                NavDestination findDestinationComprehensive$navigation_runtime_release = findDestinationComprehensive$navigation_runtime_release(zzcaVar.zzd, navDestination, null, true);
                if (findDestinationComprehensive$navigation_runtime_release != null) {
                    Lifecycle.State hostLifecycleState = getHostLifecycleState$navigation_runtime_release();
                    NavControllerViewModel navControllerViewModel = this.viewModel;
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(hostLifecycleState, "hostLifecycleState");
                    Bundle bundle3 = (Bundle) zzcaVar2.zzb;
                    if (bundle3 != null) {
                        bundle3.setClassLoader(context.context.getClassLoader());
                        bundle2 = bundle3;
                    } else {
                        bundle2 = null;
                    }
                    String id = (String) zzcaVar2.zza;
                    Intrinsics.checkNotNullParameter(id, "id");
                    arrayList.add(new NavBackStackEntry(context, findDestinationComprehensive$navigation_runtime_release, bundle2, hostLifecycleState, navControllerViewModel, id, (Bundle) zzcaVar2.zzc));
                    navDestination = findDestinationComprehensive$navigation_runtime_release;
                } else {
                    int i3 = NavDestination.$r8$clinit;
                    throw new IllegalStateException(("Restore State failed: destination " + Navigation.getDisplayName(context, zzcaVar2.zzd) + " cannot be found from the current destination " + navDestination).toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            if (!(((NavBackStackEntry) obj).destination instanceof NavGraph)) {
                arrayList3.add(obj);
            }
        }
        int size2 = arrayList3.size();
        int i5 = 0;
        while (i5 < size2) {
            Object obj2 = arrayList3.get(i5);
            i5++;
            NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj2;
            List list = (List) CollectionsKt.lastOrNull(arrayList2);
            if (list == null || (navBackStackEntry = (NavBackStackEntry) CollectionsKt.last(list)) == null || (navDestination2 = navBackStackEntry.destination) == null) {
                str = null;
            } else {
                str = navDestination2.navigatorName;
            }
            if (Intrinsics.areEqual(str, navBackStackEntry3.destination.navigatorName)) {
                list.add(navBackStackEntry3);
            } else {
                arrayList2.add(new ArrayList(new ArrayAsCollection(new NavBackStackEntry[]{navBackStackEntry3}, true)));
            }
        }
        final ?? obj3 = new Object();
        int size3 = arrayList2.size();
        while (i2 < size3) {
            Object obj4 = arrayList2.get(i2);
            i2++;
            List list2 = (List) obj4;
            Navigator navigator = this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt.first(list2)).destination.navigatorName);
            final ?? obj5 = new Object();
            final ArrayList arrayList4 = arrayList;
            this.addToBackStackHandler = new Function1() { // from class: androidx.navigation.internal.NavControllerImpl$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj6) {
                    List list3;
                    NavBackStackEntry entry = (NavBackStackEntry) obj6;
                    Intrinsics.checkNotNullParameter(entry, "entry");
                    Ref$BooleanRef.this.element = true;
                    ArrayList arrayList5 = arrayList4;
                    int indexOf = arrayList5.indexOf(entry);
                    if (indexOf != -1) {
                        Ref$IntRef ref$IntRef = obj5;
                        int i6 = indexOf + 1;
                        list3 = arrayList5.subList(ref$IntRef.element, i6);
                        ref$IntRef.element = i6;
                    } else {
                        list3 = EmptyList.INSTANCE;
                    }
                    this.addEntryToBackStack(entry.destination, bundle, entry, list3);
                    return Unit.INSTANCE;
                }
            };
            navigator.navigate(list2, navOptions);
            this.addToBackStackHandler = null;
            arrayList = arrayList4;
        }
        return obj3.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03a3 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v7, types: [androidx.navigation.NavDestination, androidx.navigation.NavGraph] */
    /* JADX WARN: Type inference failed for: r18v0, types: [android.os.Bundle[]] */
    /* JADX WARN: Type inference failed for: r18v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r18v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r18v3, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setGraph$navigation_runtime_release(androidx.navigation.NavGraph r35, android.os.Bundle r36) {
        /*
            Method dump skipped, instructions count: 1557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.internal.NavControllerImpl.setGraph$navigation_runtime_release(androidx.navigation.NavGraph, android.os.Bundle):void");
    }

    public final void unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry child) {
        Integer num;
        Intrinsics.checkNotNullParameter(child, "child");
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.childToParentEntries.remove(child);
        if (navBackStackEntry != null) {
            LinkedHashMap linkedHashMap = this.parentToChildCount;
            AtomicInt atomicInt = (AtomicInt) linkedHashMap.get(navBackStackEntry);
            if (atomicInt != null) {
                num = Integer.valueOf(atomicInt.atomicInt.decrementAndGet());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 0) {
                NavController.NavControllerNavigatorState navControllerNavigatorState = (NavController.NavControllerNavigatorState) this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry.destination.navigatorName));
                if (navControllerNavigatorState != null) {
                    navControllerNavigatorState.markTransitionComplete(navBackStackEntry);
                }
                linkedHashMap.remove(navBackStackEntry);
            }
        }
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        Boolean bool;
        AtomicInt atomicInt;
        ReadonlyStateFlow readonlyStateFlow;
        Set set;
        ArrayList mutableList = CollectionsKt.toMutableList(this.backQueue);
        if (!mutableList.isEmpty()) {
            int i = 0;
            ArrayList arrayList = new ArrayList(new ArrayAsCollection(new NavDestination[]{((NavBackStackEntry) CollectionsKt.last(mutableList)).destination}, true));
            ArrayList arrayList2 = new ArrayList();
            if (CollectionsKt.last(arrayList) instanceof FloatingWindow) {
                for (NavBackStackEntry navBackStackEntry : CollectionsKt.reversed(mutableList)) {
                    NavDestination navDestination = navBackStackEntry.destination;
                    arrayList2.add(navDestination);
                    if (!((navDestination instanceof FloatingWindow) || (navDestination instanceof NavGraph))) {
                        break;
                    }
                }
            }
            HashMap hashMap = new HashMap();
            for (NavBackStackEntry navBackStackEntry2 : CollectionsKt.reversed(mutableList)) {
                Lifecycle.State state = navBackStackEntry2.impl.maxLifecycle;
                NavDestination navDestination2 = navBackStackEntry2.destination;
                NavDestination navDestination3 = (NavDestination) CollectionsKt.firstOrNull(arrayList);
                Lifecycle.State state2 = Lifecycle.State.RESUMED;
                Lifecycle.State state3 = Lifecycle.State.STARTED;
                if (navDestination3 != null && navDestination3.impl.id == navDestination2.impl.id) {
                    if (state != state2) {
                        NavController.NavControllerNavigatorState navControllerNavigatorState = (NavController.NavControllerNavigatorState) this.navigatorState.get(this._navigatorProvider.getNavigator(navBackStackEntry2.destination.navigatorName));
                        if (navControllerNavigatorState == null || (readonlyStateFlow = navControllerNavigatorState.transitionsInProgress) == null || (set = (Set) ((StateFlowImpl) readonlyStateFlow.$$delegate_0).getValue()) == null) {
                            bool = null;
                        } else {
                            bool = Boolean.valueOf(set.contains(navBackStackEntry2));
                        }
                        if (Intrinsics.areEqual(bool, Boolean.TRUE) || ((atomicInt = (AtomicInt) this.parentToChildCount.get(navBackStackEntry2)) != null && atomicInt.atomicInt.get() == 0)) {
                            hashMap.put(navBackStackEntry2, state3);
                        } else {
                            hashMap.put(navBackStackEntry2, state2);
                        }
                    }
                    NavDestination navDestination4 = (NavDestination) CollectionsKt.firstOrNull(arrayList2);
                    if (navDestination4 != null && navDestination4.impl.id == navDestination2.impl.id) {
                        CollectionsKt__MutableCollectionsKt.removeFirst(arrayList2);
                    }
                    CollectionsKt__MutableCollectionsKt.removeFirst(arrayList);
                    NavGraph navGraph = navDestination2.parent;
                    if (navGraph != null) {
                        arrayList.add(navGraph);
                    }
                } else if (arrayList2.isEmpty() || navDestination2.impl.id != ((NavDestination) CollectionsKt.first(arrayList2)).impl.id) {
                    navBackStackEntry2.setMaxLifecycle(Lifecycle.State.CREATED);
                } else {
                    NavDestination navDestination5 = (NavDestination) CollectionsKt__MutableCollectionsKt.removeFirst(arrayList2);
                    if (state == state2) {
                        navBackStackEntry2.setMaxLifecycle(state3);
                    } else if (state != state3) {
                        hashMap.put(navBackStackEntry2, state3);
                    }
                    NavGraph navGraph2 = navDestination5.parent;
                    if (navGraph2 != null && !arrayList2.contains(navGraph2)) {
                        arrayList2.add(navGraph2);
                    }
                }
            }
            int size = mutableList.size();
            while (i < size) {
                Object obj = mutableList.get(i);
                i++;
                NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) obj;
                Lifecycle.State state4 = (Lifecycle.State) hashMap.get(navBackStackEntry3);
                if (state4 != null) {
                    navBackStackEntry3.setMaxLifecycle(state4);
                } else {
                    navBackStackEntry3.impl.updateState$navigation_common_release();
                }
            }
        }
    }
}
