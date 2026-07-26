package androidx.lifecycle;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.emoji2.text.ConcurrencyHelpers$Handler28Impl;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;
import com.google.android.gms.common.api.internal.zacq;
import java.util.HashMap;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final Object defaultLifecycleObserver;
    public final Object lifecycleEventObserver;

    /* loaded from: classes.dex */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ DefaultLifecycleObserverAdapter(Object obj, int i, Object obj2) {
        this.$r8$classId = i;
        this.defaultLifecycleObserver = obj;
        this.lifecycleEventObserver = obj2;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Handler handler;
        int i = this.$r8$classId;
        Object obj = this.lifecycleEventObserver;
        Object obj2 = this.defaultLifecycleObserver;
        switch (i) {
            case 0:
                EmojiCompatInitializer.AnonymousClass1 r2 = (EmojiCompatInitializer.AnonymousClass1) obj2;
                switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
                    case 1:
                        r2.getClass();
                        break;
                    case 2:
                        r2.getClass();
                        break;
                    case 3:
                        EmojiCompatInitializer emojiCompatInitializer = EmojiCompatInitializer.this;
                        if (Build.VERSION.SDK_INT >= 28) {
                            handler = ConcurrencyHelpers$Handler28Impl.createAsync(Looper.getMainLooper());
                        } else {
                            handler = new Handler(Looper.getMainLooper());
                        }
                        handler.postDelayed(new zacq(), 500L);
                        r2.val$lifecycle.removeObserver(r2);
                        break;
                    case 4:
                        r2.getClass();
                        break;
                    case 5:
                        r2.getClass();
                        break;
                    case 6:
                        r2.getClass();
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                    default:
                        throw new RuntimeException();
                }
                LifecycleEventObserver lifecycleEventObserver = (LifecycleEventObserver) obj;
                if (lifecycleEventObserver != null) {
                    lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
                    return;
                }
                return;
            case 1:
                if (event == Lifecycle.Event.ON_START) {
                    ((Lifecycle) obj2).removeObserver(this);
                    ((SavedStateRegistry) obj).runOnNextRecreation();
                    return;
                }
                return;
            case 2:
                HashMap hashMap = ((ClassesInfoCache.CallbackInfo) obj).mEventToHandlers;
                ClassesInfoCache.CallbackInfo.invokeMethodsForEvent((List) hashMap.get(event), lifecycleOwner, event, obj2);
                ClassesInfoCache.CallbackInfo.invokeMethodsForEvent((List) hashMap.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj2);
                return;
            case 3:
                FragmentViewHolder fragmentViewHolder = (FragmentViewHolder) obj2;
                FragmentStateAdapter fragmentStateAdapter = (FragmentStateAdapter) obj;
                if (!fragmentStateAdapter.shouldDelayFragmentTransactions()) {
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    if (((FrameLayout) fragmentViewHolder.itemView).isAttachedToWindow()) {
                        fragmentStateAdapter.placeFragmentInViewHolder(fragmentViewHolder);
                        return;
                    }
                    return;
                }
                return;
            default:
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ((Handler) obj2).removeCallbacks((FragmentStateAdapter.AnonymousClass3) obj);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                    return;
                }
                return;
        }
    }

    public DefaultLifecycleObserverAdapter(EmojiCompatInitializer.AnonymousClass1 defaultLifecycleObserver, LifecycleEventObserver lifecycleEventObserver) {
        this.$r8$classId = 0;
        Intrinsics.checkNotNullParameter(defaultLifecycleObserver, "defaultLifecycleObserver");
        this.defaultLifecycleObserver = defaultLifecycleObserver;
        this.lifecycleEventObserver = lifecycleEventObserver;
    }

    public DefaultLifecycleObserverAdapter(LifecycleObserver lifecycleObserver) {
        this.$r8$classId = 2;
        this.defaultLifecycleObserver = lifecycleObserver;
        ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
        Class<?> cls = lifecycleObserver.getClass();
        ClassesInfoCache.CallbackInfo callbackInfo = (ClassesInfoCache.CallbackInfo) classesInfoCache.mCallbackMap.get(cls);
        this.lifecycleEventObserver = callbackInfo == null ? classesInfoCache.createInfo(cls, null) : callbackInfo;
    }

    public DefaultLifecycleObserverAdapter(FragmentStateAdapter fragmentStateAdapter, FragmentViewHolder fragmentViewHolder) {
        this.$r8$classId = 3;
        this.lifecycleEventObserver = fragmentStateAdapter;
        this.defaultLifecycleObserver = fragmentViewHolder;
    }
}
