package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.widget.Toolbar$Api33Impl$$ExternalSyntheticLambda0;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {
    public boolean backInvokedCallbackRegistered;
    public final Runnable fallbackOnBackPressed;
    public boolean hasEnabledCallbacks;
    public OnBackPressedCallback inProgressCallback;
    public OnBackInvokedDispatcher invokedDispatcher;
    public final OnBackInvokedCallback onBackInvokedCallback;
    public final ArrayDeque onBackPressedCallbacks = new ArrayDeque();

    /* renamed from: androidx.activity.OnBackPressedDispatcher$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends Lambda implements Function1 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ OnBackPressedDispatcher this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(OnBackPressedDispatcher onBackPressedDispatcher, int i) {
            super(1);
            this.$r8$classId = i;
            this.this$0 = onBackPressedDispatcher;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Object obj2;
            Object obj3;
            switch (this.$r8$classId) {
                case 0:
                    BackEventCompat backEvent = (BackEventCompat) obj;
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    OnBackPressedDispatcher onBackPressedDispatcher = this.this$0;
                    ArrayDeque arrayDeque = onBackPressedDispatcher.onBackPressedCallbacks;
                    arrayDeque.getClass();
                    ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size);
                    while (true) {
                        if (listIterator.hasPrevious()) {
                            obj2 = listIterator.previous();
                            if (((OnBackPressedCallback) obj2).isEnabled) {
                            }
                        } else {
                            obj2 = null;
                        }
                    }
                    OnBackPressedCallback onBackPressedCallback = (OnBackPressedCallback) obj2;
                    onBackPressedDispatcher.inProgressCallback = onBackPressedCallback;
                    if (onBackPressedCallback != null) {
                        onBackPressedCallback.handleOnBackStarted(backEvent);
                    }
                    return Unit.INSTANCE;
                default:
                    BackEventCompat backEvent2 = (BackEventCompat) obj;
                    Intrinsics.checkNotNullParameter(backEvent2, "backEvent");
                    OnBackPressedDispatcher onBackPressedDispatcher2 = this.this$0;
                    OnBackPressedCallback onBackPressedCallback2 = onBackPressedDispatcher2.inProgressCallback;
                    if (onBackPressedCallback2 == null) {
                        ArrayDeque arrayDeque2 = onBackPressedDispatcher2.onBackPressedCallbacks;
                        arrayDeque2.getClass();
                        ListIterator listIterator2 = arrayDeque2.listIterator(arrayDeque2.size);
                        while (true) {
                            if (listIterator2.hasPrevious()) {
                                obj3 = listIterator2.previous();
                                if (((OnBackPressedCallback) obj3).isEnabled) {
                                }
                            } else {
                                obj3 = null;
                            }
                        }
                        onBackPressedCallback2 = (OnBackPressedCallback) obj3;
                    }
                    if (onBackPressedCallback2 != null) {
                        onBackPressedCallback2.handleOnBackProgressed(backEvent2);
                    }
                    return Unit.INSTANCE;
            }
        }
    }

    /* renamed from: androidx.activity.OnBackPressedDispatcher$3  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass3 extends Lambda implements Function0 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass3(int i, Object obj) {
            super(0);
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            ?? r3;
            switch (this.$r8$classId) {
                case 0:
                    ((OnBackPressedDispatcher) this.this$0).onBackPressed();
                    return Unit.INSTANCE;
                case 1:
                    OnBackPressedDispatcher onBackPressedDispatcher = (OnBackPressedDispatcher) this.this$0;
                    OnBackPressedCallback onBackPressedCallback = onBackPressedDispatcher.inProgressCallback;
                    if (onBackPressedCallback == null) {
                        ArrayDeque arrayDeque = onBackPressedDispatcher.onBackPressedCallbacks;
                        ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size());
                        while (true) {
                            if (listIterator.hasPrevious()) {
                                r3 = listIterator.previous();
                                if (((OnBackPressedCallback) r3).isEnabled) {
                                }
                            } else {
                                r3 = 0;
                            }
                        }
                        onBackPressedCallback = r3;
                    }
                    onBackPressedDispatcher.inProgressCallback = null;
                    if (onBackPressedCallback != null) {
                        onBackPressedCallback.handleOnBackCancelled();
                    }
                    return Unit.INSTANCE;
                case 2:
                    ((OnBackPressedDispatcher) this.this$0).onBackPressed();
                    return Unit.INSTANCE;
                default:
                    return this.this$0;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class Api33Impl {
        public static final Api33Impl INSTANCE = new Object();

        public final OnBackInvokedCallback createOnBackInvokedCallback(Function0 onBackInvoked) {
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            return new Toolbar$Api33Impl$$ExternalSyntheticLambda0(1, onBackInvoked);
        }

        public final void registerOnBackInvokedCallback(Object dispatcher, int i, Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) callback);
        }

        public final void unregisterOnBackInvokedCallback(Object dispatcher, Object callback) {
            Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
            Intrinsics.checkNotNullParameter(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    /* loaded from: classes.dex */
    public final class Api34Impl {
        public static final Api34Impl INSTANCE = new Object();

        public final OnBackInvokedCallback createOnBackAnimationCallback(final Function1 onBackStarted, final Function1 onBackProgressed, final Function0 onBackInvoked, final Function0 onBackCancelled) {
            Intrinsics.checkNotNullParameter(onBackStarted, "onBackStarted");
            Intrinsics.checkNotNullParameter(onBackProgressed, "onBackProgressed");
            Intrinsics.checkNotNullParameter(onBackInvoked, "onBackInvoked");
            Intrinsics.checkNotNullParameter(onBackCancelled, "onBackCancelled");
            return new OnBackAnimationCallback() { // from class: androidx.activity.OnBackPressedDispatcher$Api34Impl$createOnBackAnimationCallback$1
                public final void onBackCancelled() {
                    onBackCancelled.invoke();
                }

                public final void onBackInvoked() {
                    onBackInvoked.invoke();
                }

                public final void onBackProgressed(BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    onBackProgressed.invoke(new BackEventCompat(backEvent));
                }

                public final void onBackStarted(BackEvent backEvent) {
                    Intrinsics.checkNotNullParameter(backEvent, "backEvent");
                    Function1.this.invoke(new BackEventCompat(backEvent));
                }
            };
        }
    }

    /* loaded from: classes.dex */
    public final class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {
        public OnBackPressedCancellable currentCancellable;
        public final Lifecycle lifecycle;
        public final OnBackPressedCallback onBackPressedCallback;
        public final /* synthetic */ OnBackPressedDispatcher this$0;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, FragmentManager.AnonymousClass1 onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.lifecycle = lifecycle;
            this.onBackPressedCallback = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public final void cancel() {
            this.lifecycle.removeObserver(this);
            this.onBackPressedCallback.cancellables.remove(this);
            OnBackPressedCancellable onBackPressedCancellable = this.currentCancellable;
            if (onBackPressedCancellable != null) {
                onBackPressedCancellable.cancel();
            }
            this.currentCancellable = null;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
                Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
                OnBackPressedDispatcher onBackPressedDispatcher = this.this$0;
                onBackPressedDispatcher.onBackPressedCallbacks.addLast(onBackPressedCallback);
                OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(onBackPressedDispatcher, onBackPressedCallback);
                onBackPressedCallback.cancellables.add(onBackPressedCancellable);
                onBackPressedDispatcher.updateEnabledCallbacks();
                onBackPressedCallback.enabledChangedCallback = new OnBackPressedDispatcher$addCallback$1(1, onBackPressedDispatcher);
                this.currentCancellable = onBackPressedCancellable;
            } else if (event == Lifecycle.Event.ON_STOP) {
                OnBackPressedCancellable onBackPressedCancellable2 = this.currentCancellable;
                if (onBackPressedCancellable2 != null) {
                    onBackPressedCancellable2.cancel();
                }
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                cancel();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class OnBackPressedCancellable implements Cancellable {
        public final OnBackPressedCallback onBackPressedCallback;
        public final /* synthetic */ OnBackPressedDispatcher this$0;

        public OnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, OnBackPressedCallback onBackPressedCallback) {
            Intrinsics.checkNotNullParameter(onBackPressedCallback, "onBackPressedCallback");
            this.this$0 = onBackPressedDispatcher;
            this.onBackPressedCallback = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public final void cancel() {
            OnBackPressedDispatcher onBackPressedDispatcher = this.this$0;
            ArrayDeque arrayDeque = onBackPressedDispatcher.onBackPressedCallbacks;
            OnBackPressedCallback onBackPressedCallback = this.onBackPressedCallback;
            arrayDeque.remove(onBackPressedCallback);
            if (Intrinsics.areEqual(onBackPressedDispatcher.inProgressCallback, onBackPressedCallback)) {
                onBackPressedCallback.handleOnBackCancelled();
                onBackPressedDispatcher.inProgressCallback = null;
            }
            onBackPressedCallback.cancellables.remove(this);
            OnBackPressedDispatcher$addCallback$1 onBackPressedDispatcher$addCallback$1 = onBackPressedCallback.enabledChangedCallback;
            if (onBackPressedDispatcher$addCallback$1 != null) {
                onBackPressedDispatcher$addCallback$1.invoke();
            }
            onBackPressedCallback.enabledChangedCallback = null;
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        OnBackInvokedCallback onBackInvokedCallback;
        this.fallbackOnBackPressed = runnable;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                onBackInvokedCallback = Api34Impl.INSTANCE.createOnBackAnimationCallback(new AnonymousClass1(this, 0), new AnonymousClass1(this, 1), new AnonymousClass3(0, this), new AnonymousClass3(1, this));
            } else {
                onBackInvokedCallback = Api33Impl.INSTANCE.createOnBackInvokedCallback(new AnonymousClass3(2, this));
            }
            this.onBackInvokedCallback = onBackInvokedCallback;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void onBackPressed() {
        ?? r2;
        OnBackPressedCallback onBackPressedCallback = this.inProgressCallback;
        if (onBackPressedCallback == null) {
            ArrayDeque arrayDeque = this.onBackPressedCallbacks;
            arrayDeque.getClass();
            ListIterator listIterator = arrayDeque.listIterator(arrayDeque.size);
            while (true) {
                if (!listIterator.hasPrevious()) {
                    r2 = 0;
                    break;
                }
                r2 = listIterator.previous();
                if (((OnBackPressedCallback) r2).isEnabled) {
                    break;
                }
            }
            onBackPressedCallback = r2;
        }
        this.inProgressCallback = null;
        if (onBackPressedCallback != null) {
            onBackPressedCallback.handleOnBackPressed();
        } else {
            this.fallbackOnBackPressed.run();
        }
    }

    public final void updateBackInvokedCallbackState(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.invokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback = this.onBackInvokedCallback;
        if (onBackInvokedDispatcher != null && onBackInvokedCallback != null) {
            Api33Impl api33Impl = Api33Impl.INSTANCE;
            if (z && !this.backInvokedCallbackRegistered) {
                api33Impl.registerOnBackInvokedCallback(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.backInvokedCallbackRegistered = true;
            } else if (!z && this.backInvokedCallbackRegistered) {
                api33Impl.unregisterOnBackInvokedCallback(onBackInvokedDispatcher, onBackInvokedCallback);
                this.backInvokedCallbackRegistered = false;
            }
        }
    }

    public final void updateEnabledCallbacks() {
        boolean z = this.hasEnabledCallbacks;
        boolean z2 = false;
        ArrayDeque arrayDeque = this.onBackPressedCallbacks;
        if (arrayDeque == null || !arrayDeque.isEmpty()) {
            Iterator it = arrayDeque.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((OnBackPressedCallback) it.next()).isEnabled) {
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.hasEnabledCallbacks = z2;
        if (z2 != z && Build.VERSION.SDK_INT >= 33) {
            updateBackInvokedCallbackState(z2);
        }
    }
}
