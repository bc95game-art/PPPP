package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.random.AbstractPlatformRandom;
import kotlin.random.Random;
/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {
    public final HashMap mRcToKey = new HashMap();
    public final HashMap mKeyToRc = new HashMap();
    public final HashMap mKeyToLifecycleContainers = new HashMap();
    public ArrayList mLaunchedKeys = new ArrayList();
    public final transient HashMap mKeyToCallback = new HashMap();
    public final HashMap mParsedPendingResults = new HashMap();
    public final Bundle mPendingResults = new Bundle();

    /* renamed from: androidx.activity.result.ActivityResultRegistry$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 extends ActivityResultLauncher {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ ActivityResultRegistry this$0;
        public final /* synthetic */ ActivityResultContract val$contract;
        public final /* synthetic */ String val$key;

        public /* synthetic */ AnonymousClass2(ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract activityResultContract, int i) {
            this.$r8$classId = i;
            this.this$0 = activityResultRegistry;
            this.val$key = str;
            this.val$contract = activityResultContract;
        }

        @Override // androidx.activity.result.ActivityResultLauncher
        public final void launch(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    ActivityResultRegistry activityResultRegistry = this.this$0;
                    HashMap hashMap = activityResultRegistry.mKeyToRc;
                    String str = this.val$key;
                    Integer num = (Integer) hashMap.get(str);
                    ActivityResultContract activityResultContract = this.val$contract;
                    if (num != null) {
                        activityResultRegistry.mLaunchedKeys.add(str);
                        try {
                            activityResultRegistry.onLaunch(num.intValue(), activityResultContract, obj);
                            return;
                        } catch (Exception e) {
                            activityResultRegistry.mLaunchedKeys.remove(str);
                            throw e;
                        }
                    } else {
                        throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    }
                default:
                    ActivityResultRegistry activityResultRegistry2 = this.this$0;
                    HashMap hashMap2 = activityResultRegistry2.mKeyToRc;
                    String str2 = this.val$key;
                    Integer num2 = (Integer) hashMap2.get(str2);
                    ActivityResultContract activityResultContract2 = this.val$contract;
                    if (num2 != null) {
                        activityResultRegistry2.mLaunchedKeys.add(str2);
                        try {
                            activityResultRegistry2.onLaunch(num2.intValue(), activityResultContract2, obj);
                            return;
                        } catch (Exception e2) {
                            activityResultRegistry2.mLaunchedKeys.remove(str2);
                            throw e2;
                        }
                    } else {
                        throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                    }
            }
        }

        public void unregister() {
            this.this$0.unregister(this.val$key);
        }
    }

    /* loaded from: classes.dex */
    public final class CallbackAndContract {
        public final ActivityResultCallback mCallback;
        public final ActivityResultContract mContract;

        public CallbackAndContract(ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
            this.mCallback = activityResultCallback;
            this.mContract = activityResultContract;
        }
    }

    /* loaded from: classes.dex */
    public final class LifecycleContainer {
        public final Lifecycle mLifecycle;
        public final ArrayList mObservers = new ArrayList();

        public LifecycleContainer(Lifecycle lifecycle) {
            this.mLifecycle = lifecycle;
        }
    }

    public final boolean dispatchResult(int i, int i2, Intent intent) {
        ActivityResultCallback activityResultCallback;
        String str = (String) this.mRcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        CallbackAndContract callbackAndContract = (CallbackAndContract) this.mKeyToCallback.get(str);
        if (callbackAndContract == null || (activityResultCallback = callbackAndContract.mCallback) == null || !this.mLaunchedKeys.contains(str)) {
            this.mParsedPendingResults.remove(str);
            this.mPendingResults.putParcelable(str, new ActivityResult(intent, i2));
            return true;
        }
        activityResultCallback.onActivityResult(callbackAndContract.mContract.parseResult(intent, i2));
        this.mLaunchedKeys.remove(str);
        return true;
    }

    public abstract void onLaunch(int i, ActivityResultContract activityResultContract, Object obj);

    public final AnonymousClass2 register(final String str, LifecycleOwner lifecycleOwner, final ActivityResultContract activityResultContract, final ActivityResultCallback activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleRegistry lifecycleRegistry = (LifecycleRegistry) lifecycle;
        if (lifecycleRegistry.state.compareTo(Lifecycle.State.STARTED) < 0) {
            registerKey(str);
            HashMap hashMap = this.mKeyToLifecycleContainers;
            LifecycleContainer lifecycleContainer = (LifecycleContainer) hashMap.get(str);
            if (lifecycleContainer == null) {
                lifecycleContainer = new LifecycleContainer(lifecycle);
            }
            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                    boolean equals = Lifecycle.Event.ON_START.equals(event);
                    String str2 = str;
                    ActivityResultRegistry activityResultRegistry = ActivityResultRegistry.this;
                    if (equals) {
                        HashMap hashMap2 = activityResultRegistry.mKeyToCallback;
                        Bundle bundle = activityResultRegistry.mPendingResults;
                        HashMap hashMap3 = activityResultRegistry.mParsedPendingResults;
                        ActivityResultContract activityResultContract2 = activityResultContract;
                        ActivityResultCallback activityResultCallback2 = activityResultCallback;
                        hashMap2.put(str2, new CallbackAndContract(activityResultContract2, activityResultCallback2));
                        if (hashMap3.containsKey(str2)) {
                            Object obj = hashMap3.get(str2);
                            hashMap3.remove(str2);
                            activityResultCallback2.onActivityResult(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str2);
                        if (activityResult != null) {
                            bundle.remove(str2);
                            activityResultCallback2.onActivityResult(activityResultContract2.parseResult(activityResult.mData, activityResult.mResultCode));
                        }
                    } else if (Lifecycle.Event.ON_STOP.equals(event)) {
                        activityResultRegistry.mKeyToCallback.remove(str2);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        activityResultRegistry.unregister(str2);
                    }
                }
            };
            lifecycleContainer.mLifecycle.addObserver(lifecycleEventObserver);
            lifecycleContainer.mObservers.add(lifecycleEventObserver);
            hashMap.put(str, lifecycleContainer);
            return new AnonymousClass2(this, str, activityResultContract, 0);
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycleRegistry.state + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final void registerKey(String str) {
        HashMap hashMap = this.mKeyToRc;
        if (((Integer) hashMap.get(str)) == null) {
            AbstractPlatformRandom abstractPlatformRandom = Random.defaultRandom;
            int nextInt = Random.defaultRandom.getImpl().nextInt(2147418112);
            while (true) {
                int i = nextInt + 65536;
                Integer valueOf = Integer.valueOf(i);
                HashMap hashMap2 = this.mRcToKey;
                if (hashMap2.containsKey(valueOf)) {
                    AbstractPlatformRandom abstractPlatformRandom2 = Random.defaultRandom;
                    nextInt = Random.defaultRandom.getImpl().nextInt(2147418112);
                } else {
                    hashMap2.put(Integer.valueOf(i), str);
                    hashMap.put(str, Integer.valueOf(i));
                    return;
                }
            }
        }
    }

    public final void unregister(String str) {
        Integer num;
        if (!this.mLaunchedKeys.contains(str) && (num = (Integer) this.mKeyToRc.remove(str)) != null) {
            this.mRcToKey.remove(num);
        }
        this.mKeyToCallback.remove(str);
        HashMap hashMap = this.mParsedPendingResults;
        if (hashMap.containsKey(str)) {
            StringBuilder m = ViewModelProvider.Factory.CC.m15m("Dropping pending result for request ", str, ": ");
            m.append(hashMap.get(str));
            Log.w("ActivityResultRegistry", m.toString());
            hashMap.remove(str);
        }
        Bundle bundle = this.mPendingResults;
        if (bundle.containsKey(str)) {
            StringBuilder m2 = ViewModelProvider.Factory.CC.m15m("Dropping pending result for request ", str, ": ");
            m2.append(bundle.getParcelable(str));
            Log.w("ActivityResultRegistry", m2.toString());
            bundle.remove(str);
        }
        HashMap hashMap2 = this.mKeyToLifecycleContainers;
        LifecycleContainer lifecycleContainer = (LifecycleContainer) hashMap2.get(str);
        if (lifecycleContainer != null) {
            ArrayList arrayList = lifecycleContainer.mObservers;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                lifecycleContainer.mLifecycle.removeObserver((LifecycleEventObserver) obj);
            }
            arrayList.clear();
            hashMap2.remove(str);
        }
    }

    public final AnonymousClass2 register(String str, ActivityResultContract activityResultContract, ActivityResultCallback activityResultCallback) {
        registerKey(str);
        this.mKeyToCallback.put(str, new CallbackAndContract(activityResultContract, activityResultCallback));
        HashMap hashMap = this.mParsedPendingResults;
        if (hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            hashMap.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        Bundle bundle = this.mPendingResults;
        ActivityResult activityResult = (ActivityResult) bundle.getParcelable(str);
        if (activityResult != null) {
            bundle.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.mData, activityResult.mResultCode));
        }
        return new AnonymousClass2(this, str, activityResultContract, 1);
    }
}
