package androidx.navigation.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.ContainerHelpersKt;
import androidx.core.app.TaskStackBuilder;
import androidx.core.p002os.BundleKt;
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
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavUriUtils;
import androidx.navigation.Navigation;
import androidx.navigation.Navigation$$ExternalSyntheticLambda0;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator$$ExternalSyntheticLambda0;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.fragment.FragmentNavigator$$ExternalSyntheticLambda0;
import com.android.billingclient.api.zzca;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayAsCollection;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.collections.ReversedListReadOnly$listIterator$1;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.TakeWhileSequence;
import kotlin.sequences.TakeWhileSequence$iterator$1;
import kotlin.text.MatcherMatchResult;
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
        if (navDestination.impl.f12id == i && (navDestination2 == null || (navDestination.equals(navDestination2) && Intrinsics.areEqual(navDestination.parent, navDestination2.parent)))) {
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
            while (!arrayDeque.isEmpty() && (((NavBackStackEntry) arrayDeque.last()).destination instanceof FloatingWindow) && popBackStackInternal$navigation_runtime_release(((NavBackStackEntry) arrayDeque.last()).destination.impl.f12id, true, false)) {
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
        while (navDestination2 != null && findDestination$navigation_runtime_release(navDestination2.impl.f12id, navDestination2) != navDestination2) {
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
            if (((SparseArrayCompat) ((NavGraph) navDestination6).impl.zzb).get(navDestination4.impl.f12id) != null) {
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
                throw new IllegalStateException(ViewModelProvider.Factory.CC.m593m(new StringBuilder("NavigatorBackStack for "), navDestination.navigatorName, " should already be created").toString());
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
                linkChildToParent$navigation_runtime_release(navBackStackEntry8, getBackStackEntry$navigation_runtime_release(((NavDestination) navGraph4).impl.f12id));
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
        if (((NavDestination) navGraph).impl.f12id == i) {
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
            if (((NavBackStackEntry) obj).destination.impl.f12id == i) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
        if (navBackStackEntry != null) {
            return navBackStackEntry;
        }
        StringBuilder m = ViewModelProvider.Factory.CC.m598m("No destination with ID ", i, " is on the NavController's back stack. The current destination is ");
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

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:657)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:515)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:243)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:174)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:167)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:286)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:265)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:270)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f6, code lost:
        if (r13.equals(r3) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0106, code lost:
        if (r3.f12id == r6.impl.f12id) goto L46;
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
        r15 = new androidx.navigation.NavBackStackEntry(r6.context, r6.destination, r6.destination.addInDefaultArgs(r26), r6.hostLifecycleState, r6.viewModelStoreProvider, r6.f10id, r6.savedState);
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
        linkChildToParent$navigation_runtime_release(r6, getBackStackEntry$navigation_runtime_release(((androidx.navigation.NavDestination) r7).impl.f12id));
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
            if (z || navDestinationImpl.f12id != i) {
                arrayList.add(navigator);
            }
            if (navDestinationImpl.f12id == i) {
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
                                containsKey = this.f$0.backStackMap.containsKey(Integer.valueOf(destination.impl.f12id));
                                break;
                            default:
                                Intrinsics.checkNotNullParameter(destination, "destination");
                                containsKey = this.f$0.backStackMap.containsKey(Integer.valueOf(destination.impl.f12id));
                                break;
                        }
                        return Boolean.valueOf(!containsKey);
                    }
                }, 0));
                while (takeWhileSequence$iterator$1.hasNext()) {
                    Integer valueOf = Integer.valueOf(((NavDestination) takeWhileSequence$iterator$1.next()).impl.f12id);
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
                                containsKey = this.f$0.backStackMap.containsKey(Integer.valueOf(destination.impl.f12id));
                                break;
                            default:
                                Intrinsics.checkNotNullParameter(destination, "destination");
                                containsKey = this.f$0.backStackMap.containsKey(Integer.valueOf(destination.impl.f12id));
                                break;
                        }
                        return Boolean.valueOf(!containsKey);
                    }
                }, 0));
                while (takeWhileSequence$iterator$12.hasNext()) {
                    linkedHashMap.put(Integer.valueOf(((NavDestination) takeWhileSequence$iterator$12.next()).impl.f12id), (String) zzcaVar.zza);
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
                String backStackEntryId = navBackStackEntry.f10id;
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
    */
    public final void setGraph$navigation_runtime_release(NavGraph navGraph, Bundle bundle) {
        String str;
        Intent intent;
        int[] intArray;
        ArrayList arrayList;
        Bundle bundle2;
        int[] iArr;
        int length;
        int i;
        String str2;
        boolean z;
        NavDestination navDestination;
        NavGraph navGraph2;
        int i2;
        Bundle bundle3;
        NavDestination navDestination2;
        NavGraph navGraph3;
        int[] iArr2;
        NavBackStackEntry navBackStackEntry;
        NavDestination navDestination3;
        NavGraph navGraph4;
        NavDestination.DeepLinkMatch matchDeepLinkComprehensive;
        zzca zzcaVar = navGraph.impl;
        ArrayDeque arrayDeque = this.backQueue;
        if (!arrayDeque.isEmpty() && getHostLifecycleState$navigation_runtime_release() == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException("You cannot set a new graph on a NavController with entries on the back stack after the NavController has been destroyed. Please ensure that your NavHost has the same lifetime as your NavController.");
        } else if (!Intrinsics.areEqual(this._graph, navGraph)) {
            NavGraph navGraph5 = this._graph;
            LinkedHashMap linkedHashMap = this.navigatorState;
            NavDestination navDestination4 = null;
            boolean z2 = true;
            if (navGraph5 != null) {
                ArrayList arrayList2 = new ArrayList(this.backStackMap.keySet());
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    Integer num = (Integer) obj;
                    Intrinsics.checkNotNull(num);
                    int intValue = num.intValue();
                    for (NavController.NavControllerNavigatorState navControllerNavigatorState : linkedHashMap.values()) {
                        navControllerNavigatorState.isNavigating = z2;
                    }
                    NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
                    navOptionsBuilder.restoreState = z2;
                    boolean z3 = navOptionsBuilder.launchSingleTop;
                    boolean z4 = navOptionsBuilder.restoreState;
                    int i4 = navOptionsBuilder.popUpToId;
                    boolean z5 = navOptionsBuilder.saveState;
                    NavOptions.Builder builder = navOptionsBuilder.builder;
                    boolean restoreStateInternal = restoreStateInternal(intValue, null, new NavOptions(z3, z4, i4, false, z5, builder.enterAnim, builder.exitAnim, -1, -1));
                    for (NavController.NavControllerNavigatorState navControllerNavigatorState2 : linkedHashMap.values()) {
                        navControllerNavigatorState2.isNavigating = false;
                    }
                    if (restoreStateInternal) {
                        popBackStackInternal$navigation_runtime_release(intValue, true, false);
                    }
                    z2 = true;
                }
                popBackStackInternal$navigation_runtime_release(((NavDestination) navGraph5).impl.f12id, true, false);
            }
            this._graph = navGraph;
            NavController navController = this.navController;
            NavControllerImpl navControllerImpl = navController.impl;
            NavContext context = navController.navContext;
            Bundle bundle4 = this.navigatorStateToRestore;
            NavigatorProvider navigatorProvider = this._navigatorProvider;
            if (bundle4 != null && bundle4.containsKey("android-support-nav:controller:navigatorState:names")) {
                ArrayList<String> stringArrayList = bundle4.getStringArrayList("android-support-nav:controller:navigatorState:names");
                if (stringArrayList != null) {
                    int size2 = stringArrayList.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        String str3 = stringArrayList.get(i5);
                        i5++;
                        String str4 = str3;
                        Navigator navigator = navigatorProvider.getNavigator(str4);
                        if (bundle4.containsKey(str4)) {
                            Bundle bundle5 = bundle4.getBundle(str4);
                            if (bundle5 != null) {
                                navigator.onRestoreState(bundle5);
                            } else {
                                Navigation.keyOrValueNotFoundError(str4);
                                throw null;
                            }
                        }
                    }
                } else {
                    Navigation.keyOrValueNotFoundError("android-support-nav:controller:navigatorState:names");
                    throw null;
                }
            }
            Bundle[] bundleArr = this.backStackToRestore;
            String str5 = " cannot be found from the current destination ";
            if (bundleArr != null) {
                int length2 = bundleArr.length;
                int i6 = 0;
                while (i6 < length2) {
                    Bundle state = bundleArr[i6];
                    Intrinsics.checkNotNullParameter(state, "state");
                    state.setClassLoader(NavBackStackEntryState.class.getClassLoader());
                    String string = state.getString("nav-entry-state:id");
                    if (string != null) {
                        int i7 = Navigation.m650getIntimpl(state, "nav-entry-state:destination-id");
                        int i8 = i6;
                        Bundle bundle6 = state.getBundle("nav-entry-state:args");
                        if (bundle6 != null) {
                            Bundle bundle7 = state.getBundle("nav-entry-state:saved-state");
                            if (bundle7 != null) {
                                int i9 = length2;
                                NavDestination findDestination$navigation_runtime_release = findDestination$navigation_runtime_release(i7, navDestination4);
                                if (findDestination$navigation_runtime_release != null) {
                                    Lifecycle.State hostLifecycleState = getHostLifecycleState$navigation_runtime_release();
                                    NavControllerViewModel navControllerViewModel = this.viewModel;
                                    NavDestination navDestination5 = navDestination4;
                                    Intrinsics.checkNotNullParameter(context, "context");
                                    Intrinsics.checkNotNullParameter(hostLifecycleState, "hostLifecycleState");
                                    bundle6.setClassLoader(context.context.getClassLoader());
                                    String str6 = str5;
                                    NavBackStackEntry navBackStackEntry2 = new NavBackStackEntry(context, findDestination$navigation_runtime_release, bundle6, hostLifecycleState, navControllerViewModel, string, bundle7);
                                    Navigator navigator2 = navigatorProvider.getNavigator(findDestination$navigation_runtime_release.navigatorName);
                                    Object obj2 = linkedHashMap.get(navigator2);
                                    if (obj2 == null) {
                                        obj2 = new NavController.NavControllerNavigatorState(navController, navigator2);
                                        linkedHashMap.put(navigator2, obj2);
                                    }
                                    arrayDeque.addLast(navBackStackEntry2);
                                    ((NavController.NavControllerNavigatorState) obj2).addInternal(navBackStackEntry2);
                                    NavGraph navGraph6 = navBackStackEntry2.destination.parent;
                                    if (navGraph6 != null) {
                                        linkChildToParent$navigation_runtime_release(navBackStackEntry2, getBackStackEntry$navigation_runtime_release(((NavDestination) navGraph6).impl.f12id));
                                    }
                                    i6 = i8 + 1;
                                    str5 = str6;
                                    length2 = i9;
                                    navDestination4 = navDestination5;
                                } else {
                                    int i10 = NavDestination.$r8$clinit;
                                    StringBuilder m = ViewModelProvider.Factory.CC.m594m("Restoring the Navigation back stack failed: destination ", Navigation.getDisplayName(context, i7), str5);
                                    m.append(getCurrentDestination$navigation_runtime_release());
                                    throw new IllegalStateException(m.toString());
                                }
                            } else {
                                ?? r18 = navDestination4;
                                Navigation.keyOrValueNotFoundError("nav-entry-state:saved-state");
                                throw r18;
                            }
                        } else {
                            ?? r182 = navDestination4;
                            Navigation.keyOrValueNotFoundError("nav-entry-state:args");
                            throw r182;
                        }
                    } else {
                        ?? r183 = navDestination4;
                        Navigation.keyOrValueNotFoundError("nav-entry-state:id");
                        throw r183;
                    }
                }
                ?? r184 = navDestination4;
                str = str5;
                this.updateOnBackPressedCallbackEnabledCallback.invoke();
                this.backStackToRestore = r184;
            } else {
                str = str5;
            }
            Collection values = MapsKt__MapsKt.toMap(navigatorProvider._navigators).values();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : values) {
                if (!((Navigator) obj3).isAttached) {
                    arrayList3.add(obj3);
                }
            }
            int size3 = arrayList3.size();
            int i11 = 0;
            while (i11 < size3) {
                Object obj4 = arrayList3.get(i11);
                i11++;
                Navigator navigator3 = (Navigator) obj4;
                Object obj5 = linkedHashMap.get(navigator3);
                if (obj5 == null) {
                    Intrinsics.checkNotNullParameter(navigator3, "navigator");
                    obj5 = new NavController.NavControllerNavigatorState(navController, navigator3);
                    linkedHashMap.put(navigator3, obj5);
                }
                navigator3.onAttach((NavController.NavControllerNavigatorState) obj5);
            }
            if (this._graph == null || !arrayDeque.isEmpty()) {
                dispatchOnDestinationChanged$navigation_runtime_release();
                return;
            }
            Activity activity = navController.activity;
            if (!(navController.deepLinkHandled || activity == null || (intent = activity.getIntent()) == null)) {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    try {
                        intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
                    } catch (Exception e) {
                        Log.e("NavController", "handleDeepLink() could not extract deepLink from " + intent, e);
                    }
                    if (extras == null) {
                        arrayList = extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
                    } else {
                        arrayList = null;
                    }
                    Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                    if (extras == null) {
                        bundle2 = extras.getBundle("android-support-nav:controller:deepLinkExtras");
                    } else {
                        bundle2 = null;
                    }
                    if (bundle2 != null) {
                        bundleOf.putAll(bundle2);
                    }
                    if (intArray != null || intArray.length == 0) {
                        navBackStackEntry = (NavBackStackEntry) navControllerImpl.backQueue.lastOrNull();
                        if (navBackStackEntry != null || (navDestination3 = navBackStackEntry.destination) == null) {
                            navDestination3 = navControllerImpl._graph;
                            Intrinsics.checkNotNull(navDestination3);
                        }
                        if (!(navDestination3 instanceof NavGraph)) {
                            navGraph4 = (NavGraph) navDestination3;
                        } else {
                            navGraph4 = null;
                        }
                        if (navGraph4 == null) {
                            navGraph4 = navDestination3.parent;
                            Intrinsics.checkNotNull(navGraph4);
                        }
                        iArr2 = intArray;
                        matchDeepLinkComprehensive = navGraph4.matchDeepLinkComprehensive(new MatcherMatchResult(intent.getData(), intent.getAction(), intent.getType(), 8), navGraph4);
                        if (matchDeepLinkComprehensive != null) {
                            NavDestination navDestination6 = matchDeepLinkComprehensive.destination;
                            ArrayDeque arrayDeque2 = new ArrayDeque();
                            NavGraph navGraph7 = navDestination6;
                            while (true) {
                                NavDestinationImpl navDestinationImpl = navGraph7.impl;
                                NavGraph navGraph8 = navGraph7.parent;
                                if (navGraph8 == null || navGraph8.impl.zzd != navDestinationImpl.f12id) {
                                    arrayDeque2.addFirst(navGraph7);
                                }
                                if (!Intrinsics.areEqual(navGraph8, null) && navGraph8 != null) {
                                    navGraph7 = navGraph8;
                                }
                            }
                            List<NavDestination> list = CollectionsKt.toList(arrayDeque2);
                            ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                            for (NavDestination navDestination7 : list) {
                                arrayList4.add(Integer.valueOf(navDestination7.impl.f12id));
                            }
                            int[] intArray2 = CollectionsKt.toIntArray(arrayList4);
                            Bundle addInDefaultArgs = navDestination6.addInDefaultArgs(matchDeepLinkComprehensive.matchingArgs);
                            if (addInDefaultArgs != null) {
                                bundleOf.putAll(addInDefaultArgs);
                            }
                            iArr = intArray2;
                            arrayList = null;
                            if (!(iArr == null || iArr.length == 0)) {
                                navControllerImpl.getClass();
                                NavGraph navGraph9 = navControllerImpl._graph;
                                length = iArr.length;
                                i = 0;
                                while (true) {
                                    if (i < length) {
                                        str2 = null;
                                        break;
                                    }
                                    int i12 = iArr[i];
                                    if (i == 0) {
                                        NavGraph navGraph10 = navControllerImpl._graph;
                                        Intrinsics.checkNotNull(navGraph10);
                                        if (((NavDestination) navGraph10).impl.f12id == i12) {
                                            navDestination2 = navControllerImpl._graph;
                                        } else {
                                            navDestination2 = null;
                                        }
                                    } else {
                                        Intrinsics.checkNotNull(navGraph9);
                                        navDestination2 = navGraph9.findNode(i12);
                                    }
                                    if (navDestination2 == null) {
                                        int i13 = NavDestination.$r8$clinit;
                                        str2 = Navigation.getDisplayName(navControllerImpl.navController.navContext, i12);
                                        break;
                                    }
                                    if (i != iArr.length - 1 && (navDestination2 instanceof NavGraph)) {
                                        while (true) {
                                            navGraph3 = (NavGraph) navDestination2;
                                            Intrinsics.checkNotNull(navGraph3);
                                            zzca zzcaVar2 = navGraph3.impl;
                                            if (!(navGraph3.findNode(zzcaVar2.zzd) instanceof NavGraph)) {
                                                break;
                                            }
                                            navDestination2 = navGraph3.findNode(zzcaVar2.zzd);
                                        }
                                        navGraph9 = navGraph3;
                                    }
                                    i++;
                                }
                                if (str2 == null) {
                                    String message = "Could not find destination " + str2 + " in the navigation graph, ignoring the deep link from " + intent;
                                    Intrinsics.checkNotNullParameter(message, "message");
                                    Log.i("NavController", message);
                                } else {
                                    bundleOf.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                                    int length3 = iArr.length;
                                    Bundle[] bundleArr2 = new Bundle[length3];
                                    for (int i14 = 0; i14 < length3; i14++) {
                                        Bundle bundleOf2 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                                        bundleOf2.putAll(bundleOf);
                                        if (!(arrayList == null || (bundle3 = (Bundle) arrayList.get(i14)) == null)) {
                                            bundleOf2.putAll(bundle3);
                                        }
                                        bundleArr2[i14] = bundleOf2;
                                    }
                                    int flags = intent.getFlags();
                                    int i15 = 268435456 & flags;
                                    if (i15 == 0 || (flags & 32768) != 0) {
                                        if (i15 != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            if (!navControllerImpl.backQueue.isEmpty()) {
                                                NavGraph navGraph11 = navControllerImpl._graph;
                                                Intrinsics.checkNotNull(navGraph11);
                                                i2 = 0;
                                                navControllerImpl.popBackStackInternal$navigation_runtime_release(((NavDestination) navGraph11).impl.f12id, true, false);
                                            } else {
                                                i2 = 0;
                                            }
                                            while (i2 < iArr.length) {
                                                int i16 = iArr[i2];
                                                int i17 = i2 + 1;
                                                Bundle bundle8 = bundleArr2[i2];
                                                NavDestination findDestination$navigation_runtime_release2 = navControllerImpl.findDestination$navigation_runtime_release(i16, null);
                                                if (findDestination$navigation_runtime_release2 != null) {
                                                    Navigator$$ExternalSyntheticLambda0 navigator$$ExternalSyntheticLambda0 = new Navigator$$ExternalSyntheticLambda0(findDestination$navigation_runtime_release2, 1, navController);
                                                    NavOptionsBuilder navOptionsBuilder2 = new NavOptionsBuilder();
                                                    navigator$$ExternalSyntheticLambda0.invoke(navOptionsBuilder2);
                                                    boolean z6 = navOptionsBuilder2.launchSingleTop;
                                                    boolean z7 = navOptionsBuilder2.restoreState;
                                                    int i18 = navOptionsBuilder2.popUpToId;
                                                    boolean z8 = navOptionsBuilder2.saveState;
                                                    NavOptions.Builder builder2 = navOptionsBuilder2.builder;
                                                    navControllerImpl.navigate$navigation_runtime_release(findDestination$navigation_runtime_release2, bundle8, new NavOptions(z6, z7, i18, false, z8, builder2.enterAnim, builder2.exitAnim, -1, -1));
                                                    i2 = i17;
                                                } else {
                                                    int i19 = NavDestination.$r8$clinit;
                                                    StringBuilder m2 = ViewModelProvider.Factory.CC.m594m("Deep Linking failed: destination ", Navigation.getDisplayName(context, i16), str);
                                                    m2.append(navControllerImpl.getCurrentDestination$navigation_runtime_release());
                                                    throw new IllegalStateException(m2.toString());
                                                }
                                            }
                                            navController.deepLinkHandled = true;
                                            return;
                                        }
                                        NavGraph navGraph12 = navControllerImpl._graph;
                                        int length4 = iArr.length;
                                        for (int i20 = 0; i20 < length4; i20++) {
                                            int i21 = iArr[i20];
                                            Bundle bundle9 = bundleArr2[i20];
                                            if (i20 == 0) {
                                                navDestination = navControllerImpl._graph;
                                            } else {
                                                Intrinsics.checkNotNull(navGraph12);
                                                navDestination = navGraph12.findNode(i21);
                                            }
                                            if (navDestination != null) {
                                                if (i20 == iArr.length - 1) {
                                                    NavGraph navGraph13 = navControllerImpl._graph;
                                                    Intrinsics.checkNotNull(navGraph13);
                                                    navControllerImpl.navigate$navigation_runtime_release(navDestination, bundle9, new NavOptions(false, false, ((NavDestination) navGraph13).impl.f12id, true, false, 0, 0, -1, -1));
                                                } else if (navDestination instanceof NavGraph) {
                                                    while (true) {
                                                        navGraph2 = (NavGraph) navDestination;
                                                        Intrinsics.checkNotNull(navGraph2);
                                                        zzca zzcaVar3 = navGraph2.impl;
                                                        if (!(navGraph2.findNode(zzcaVar3.zzd) instanceof NavGraph)) {
                                                            break;
                                                        }
                                                        navDestination = navGraph2.findNode(zzcaVar3.zzd);
                                                    }
                                                    navGraph12 = navGraph2;
                                                }
                                            } else {
                                                int i22 = NavDestination.$r8$clinit;
                                                throw new IllegalStateException("Deep Linking failed: destination " + Navigation.getDisplayName(context, i21) + " cannot be found in graph " + navGraph12);
                                            }
                                        }
                                        navController.deepLinkHandled = true;
                                        return;
                                    }
                                    intent.addFlags(32768);
                                    TaskStackBuilder taskStackBuilder = new TaskStackBuilder(navController.context);
                                    ComponentName component = intent.getComponent();
                                    if (component == null) {
                                        component = intent.resolveActivity(taskStackBuilder.mSourceContext.getPackageManager());
                                    }
                                    if (component != null) {
                                        taskStackBuilder.addParentStack(component);
                                    }
                                    taskStackBuilder.mIntents.add(intent);
                                    taskStackBuilder.startActivities();
                                    activity.finish();
                                    activity.overridePendingTransition(0, 0);
                                    return;
                                }
                            }
                        }
                    } else {
                        iArr2 = intArray;
                    }
                    iArr = iArr2;
                    if (iArr == null) {
                        navControllerImpl.getClass();
                        NavGraph navGraph92 = navControllerImpl._graph;
                        length = iArr.length;
                        i = 0;
                        while (true) {
                            if (i < length) {
                            }
                            i++;
                        }
                        if (str2 == null) {
                        }
                    }
                }
                intArray = null;
                if (extras == null) {
                }
                Bundle bundleOf3 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                if (extras == null) {
                }
                if (bundle2 != null) {
                }
                if (intArray != null) {
                }
                navBackStackEntry = (NavBackStackEntry) navControllerImpl.backQueue.lastOrNull();
                if (navBackStackEntry != null) {
                }
                navDestination3 = navControllerImpl._graph;
                Intrinsics.checkNotNull(navDestination3);
                if (!(navDestination3 instanceof NavGraph)) {
                }
                if (navGraph4 == null) {
                }
                iArr2 = intArray;
                matchDeepLinkComprehensive = navGraph4.matchDeepLinkComprehensive(new MatcherMatchResult(intent.getData(), intent.getAction(), intent.getType(), 8), navGraph4);
                if (matchDeepLinkComprehensive != null) {
                }
                iArr = iArr2;
                if (iArr == null) {
                }
            }
            NavGraph navGraph14 = this._graph;
            Intrinsics.checkNotNull(navGraph14);
            navigate$navigation_runtime_release(navGraph14, bundle, null);
        } else {
            int size4 = ((SparseArrayCompat) zzcaVar.zzb).size();
            for (int i23 = 0; i23 < size4; i23++) {
                NavDestination navDestination8 = (NavDestination) ((SparseArrayCompat) zzcaVar.zzb).valueAt(i23);
                NavGraph navGraph15 = this._graph;
                Intrinsics.checkNotNull(navGraph15);
                int keyAt = ((SparseArrayCompat) navGraph15.impl.zzb).keyAt(i23);
                NavGraph navGraph16 = this._graph;
                Intrinsics.checkNotNull(navGraph16);
                SparseArrayCompat sparseArrayCompat = (SparseArrayCompat) navGraph16.impl.zzb;
                if (sparseArrayCompat.garbage) {
                    ArraySetKt.access$gc(sparseArrayCompat);
                }
                int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.size, keyAt, sparseArrayCompat.keys);
                if (binarySearch >= 0) {
                    Object[] objArr = sparseArrayCompat.values;
                    Object obj6 = objArr[binarySearch];
                    objArr[binarySearch] = navDestination8;
                }
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) it.next();
                int i24 = NavDestination.$r8$clinit;
                NavDestination navDestination9 = navBackStackEntry3.destination;
                Intrinsics.checkNotNullParameter(navDestination9, "<this>");
                ReversedListReadOnly reversedListReadOnly = new ReversedListReadOnly(SequencesKt.toList(SequencesKt.generateSequence(navDestination9, new Navigation$$ExternalSyntheticLambda0(4))));
                NavDestination navDestination10 = this._graph;
                Intrinsics.checkNotNull(navDestination10);
                Iterator it2 = reversedListReadOnly.iterator();
                while (true) {
                    ListIterator listIterator = ((ReversedListReadOnly$listIterator$1) it2).delegateIterator;
                    if (listIterator.hasPrevious()) {
                        NavDestination navDestination11 = (NavDestination) listIterator.previous();
                        if (!Intrinsics.areEqual(navDestination11, this._graph) || !Intrinsics.areEqual(navDestination10, navGraph)) {
                            if (navDestination10 instanceof NavGraph) {
                                navDestination10 = ((NavGraph) navDestination10).findNode(navDestination11.impl.f12id);
                                Intrinsics.checkNotNull(navDestination10);
                            }
                        }
                    }
                }
                Intrinsics.checkNotNullParameter(navDestination10, "<set-?>");
                navBackStackEntry3.destination = navDestination10;
            }
        }
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
                if (navDestination3 != null && navDestination3.impl.f12id == navDestination2.impl.f12id) {
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
                    if (navDestination4 != null && navDestination4.impl.f12id == navDestination2.impl.f12id) {
                        CollectionsKt__MutableCollectionsKt.removeFirst(arrayList2);
                    }
                    CollectionsKt__MutableCollectionsKt.removeFirst(arrayList);
                    NavGraph navGraph = navDestination2.parent;
                    if (navGraph != null) {
                        arrayList.add(navGraph);
                    }
                } else if (arrayList2.isEmpty() || navDestination2.impl.f12id != ((NavDestination) CollectionsKt.first(arrayList2)).impl.f12id) {
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
