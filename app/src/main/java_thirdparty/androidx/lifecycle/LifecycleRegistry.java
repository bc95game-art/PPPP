package androidx.lifecycle;

import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
/* loaded from: classes.dex */
public final class LifecycleRegistry extends Lifecycle {
    public final StateFlowImpl _currentStateFlow;
    public int addingObserverCounter;
    public boolean handlingEvent;
    public final WeakReference lifecycleOwner;
    public boolean newEventOccurred;
    public Lifecycle.State state;
    public final boolean enforceMainThread = true;
    public FastSafeIterableMap observerMap = new FastSafeIterableMap();
    public final ArrayList parentStates = new ArrayList();

    /* loaded from: classes.dex */
    public final class ObserverWithState {
        public LifecycleEventObserver lifecycleObserver;
        public Lifecycle.State state;

        public final void dispatchEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State targetState = event.getTargetState();
            Lifecycle.State state1 = this.state;
            Intrinsics.checkNotNullParameter(state1, "state1");
            if (targetState.compareTo(state1) < 0) {
                state1 = targetState;
            }
            this.state = state1;
            this.lifecycleObserver.onStateChanged(lifecycleOwner, event);
            this.state = targetState;
        }
    }

    public LifecycleRegistry(LifecycleOwner lifecycleOwner) {
        new AtomicReference(null);
        Lifecycle.State state = Lifecycle.State.INITIALIZED;
        this.state = state;
        this.lifecycleOwner = new WeakReference(lifecycleOwner);
        this._currentStateFlow = new StateFlowImpl(state);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object, androidx.lifecycle.LifecycleRegistry$ObserverWithState] */
    @Override // androidx.lifecycle.Lifecycle
    public final void addObserver(LifecycleObserver observer) {
        LifecycleEventObserver lifecycleEventObserver;
        Object obj;
        LifecycleOwner lifecycleOwner;
        Lifecycle.Event event;
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state = this.state;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ?? obj2 = new Object();
        HashMap hashMap = Lifecycling.callbackCache;
        boolean z = observer instanceof LifecycleEventObserver;
        boolean z2 = observer instanceof EmojiCompatInitializer.AnonymousClass1;
        boolean z3 = false;
        if (z && z2) {
            lifecycleEventObserver = new DefaultLifecycleObserverAdapter((EmojiCompatInitializer.AnonymousClass1) observer, (LifecycleEventObserver) observer);
        } else if (z2) {
            lifecycleEventObserver = new DefaultLifecycleObserverAdapter((EmojiCompatInitializer.AnonymousClass1) observer, (LifecycleEventObserver) null);
        } else if (z) {
            lifecycleEventObserver = (LifecycleEventObserver) observer;
        } else {
            Class<?> cls = observer.getClass();
            if (Lifecycling.getObserverConstructorType(cls) == 2) {
                Object obj3 = Lifecycling.classToAdapters.get(cls);
                Intrinsics.checkNotNull(obj3);
                List list = (List) obj3;
                if (list.size() != 1) {
                    int size = list.size();
                    GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
                    if (size <= 0) {
                        lifecycleEventObserver = new SavedStateHandleAttacher(1, generatedAdapterArr);
                    } else {
                        Lifecycling.createGeneratedAdapter((Constructor) list.get(0), observer);
                        throw null;
                    }
                } else {
                    Lifecycling.createGeneratedAdapter((Constructor) list.get(0), observer);
                    throw null;
                }
            } else {
                lifecycleEventObserver = new DefaultLifecycleObserverAdapter(observer);
            }
        }
        obj2.lifecycleObserver = lifecycleEventObserver;
        obj2.state = state2;
        FastSafeIterableMap fastSafeIterableMap = this.observerMap;
        SafeIterableMap.Entry entry = fastSafeIterableMap.get(observer);
        if (entry != null) {
            obj = entry.mValue;
        } else {
            HashMap hashMap2 = fastSafeIterableMap.mHashMap;
            SafeIterableMap.Entry entry2 = new SafeIterableMap.Entry(observer, obj2);
            fastSafeIterableMap.mSize++;
            SafeIterableMap.Entry entry3 = fastSafeIterableMap.mEnd;
            if (entry3 == null) {
                fastSafeIterableMap.mStart = entry2;
                fastSafeIterableMap.mEnd = entry2;
            } else {
                entry3.mNext = entry2;
                entry2.mPrevious = entry3;
                fastSafeIterableMap.mEnd = entry2;
            }
            hashMap2.put(observer, entry2);
            obj = null;
        }
        if (((ObserverWithState) obj) == null && (lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.get()) != null) {
            if (this.addingObserverCounter != 0 || this.handlingEvent) {
                z3 = true;
            }
            Lifecycle.State calculateTargetState = calculateTargetState(observer);
            this.addingObserverCounter++;
            while (obj2.state.compareTo(calculateTargetState) < 0 && this.observerMap.mHashMap.containsKey(observer)) {
                Lifecycle.State state3 = obj2.state;
                ArrayList arrayList = this.parentStates;
                arrayList.add(state3);
                Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                Lifecycle.State state4 = obj2.state;
                companion.getClass();
                Intrinsics.checkNotNullParameter(state4, "state");
                int ordinal = state4.ordinal();
                if (ordinal == 1) {
                    event = Lifecycle.Event.ON_CREATE;
                } else if (ordinal == 2) {
                    event = Lifecycle.Event.ON_START;
                } else if (ordinal != 3) {
                    event = null;
                } else {
                    event = Lifecycle.Event.ON_RESUME;
                }
                if (event != null) {
                    obj2.dispatchEvent(lifecycleOwner, event);
                    arrayList.remove(arrayList.size() - 1);
                    calculateTargetState = calculateTargetState(observer);
                } else {
                    throw new IllegalStateException("no event up from " + obj2.state);
                }
            }
            if (!z3) {
                sync();
            }
            this.addingObserverCounter--;
        }
    }

    public final Lifecycle.State calculateTargetState(LifecycleObserver lifecycleObserver) {
        SafeIterableMap.Entry entry;
        Lifecycle.State state;
        HashMap hashMap = this.observerMap.mHashMap;
        Lifecycle.State state2 = null;
        if (hashMap.containsKey(lifecycleObserver)) {
            entry = ((SafeIterableMap.Entry) hashMap.get(lifecycleObserver)).mPrevious;
        } else {
            entry = null;
        }
        if (entry != null) {
            state = ((ObserverWithState) entry.mValue).state;
        } else {
            state = null;
        }
        ArrayList arrayList = this.parentStates;
        if (!arrayList.isEmpty()) {
            state2 = (Lifecycle.State) arrayList.get(arrayList.size() - 1);
        }
        Lifecycle.State state1 = this.state;
        Intrinsics.checkNotNullParameter(state1, "state1");
        if (state == null || state.compareTo(state1) >= 0) {
            state = state1;
        }
        if (state2 == null || state2.compareTo(state) >= 0) {
            return state;
        }
        return state2;
    }

    public final void enforceMainThreadIfNeeded(String str) {
        if (this.enforceMainThread) {
            ArchTaskExecutor.getInstance().mDelegate.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(ViewModelProvider.Factory.CC.m("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void handleLifecycleEvent(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    public final void moveToState(Lifecycle.State next) {
        if (this.state != next) {
            LifecycleOwner lifecycleOwner = (LifecycleOwner) this.lifecycleOwner.get();
            Lifecycle.State current = this.state;
            Intrinsics.checkNotNullParameter(current, "current");
            Intrinsics.checkNotNullParameter(next, "next");
            Lifecycle.State state = Lifecycle.State.INITIALIZED;
            Lifecycle.State state2 = Lifecycle.State.DESTROYED;
            if (current == state && next == state2) {
                throw new IllegalStateException(("State must be at least '" + Lifecycle.State.CREATED + "' to be moved to '" + next + "' in component " + lifecycleOwner).toString());
            } else if (current != state2 || current == next) {
                this.state = next;
                if (this.handlingEvent || this.addingObserverCounter != 0) {
                    this.newEventOccurred = true;
                    return;
                }
                this.handlingEvent = true;
                sync();
                this.handlingEvent = false;
                if (this.state == state2) {
                    this.observerMap = new FastSafeIterableMap();
                }
            } else {
                throw new IllegalStateException(("State is '" + state2 + "' and cannot be moved to `" + next + "` in component " + lifecycleOwner).toString());
            }
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void removeObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(observer);
    }

    public final void setCurrentState(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
        r12.newEventOccurred = false;
        r12._currentStateFlow.setValue(r12.state);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void sync() {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.LifecycleRegistry.sync():void");
    }
}
