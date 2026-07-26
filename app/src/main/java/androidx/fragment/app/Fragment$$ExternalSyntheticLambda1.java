package androidx.fragment.app;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.navigation.Navigation;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.internal.SavedStateRegistryImpl;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;
/* loaded from: classes.dex */
public final /* synthetic */ class Fragment$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Fragment$$ExternalSyntheticLambda1(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        switch (this.$r8$classId) {
            case 0:
                Fragment fragment = (Fragment) this.f$0;
                FragmentViewLifecycleOwner fragmentViewLifecycleOwner = fragment.mViewLifecycleOwner;
                Bundle bundle2 = fragment.mSavedViewRegistryState;
                SavedStateRegistryImpl savedStateRegistryImpl = fragmentViewLifecycleOwner.mSavedStateRegistryController.impl;
                SavedStateRegistryOwner savedStateRegistryOwner = savedStateRegistryImpl.owner;
                if (!savedStateRegistryImpl.attached) {
                    savedStateRegistryImpl.performAttach();
                }
                if (((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state.compareTo(Lifecycle.State.STARTED) >= 0) {
                    throw new IllegalStateException(("performRestore cannot be called when owner is " + ((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state).toString());
                } else if (!savedStateRegistryImpl.isRestored) {
                    if (bundle2 == null || !bundle2.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
                        bundle = null;
                    } else {
                        bundle = bundle2.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                        if (bundle == null) {
                            Navigation.keyOrValueNotFoundError("androidx.lifecycle.BundlableSavedStateRegistry.key");
                            throw null;
                        }
                    }
                    savedStateRegistryImpl.restoredState = bundle;
                    savedStateRegistryImpl.isRestored = true;
                    fragment.mSavedViewRegistryState = null;
                    return;
                } else {
                    throw new IllegalStateException("SavedStateRegistry was already restored.");
                }
            case 1:
                Function0 function0 = (Function0) ((Ref$ObjectRef) this.f$0).element;
                if (function0 != null) {
                    function0.invoke();
                    return;
                }
                return;
            case 2:
                FragmentTransition.setViewVisibility((ArrayList) this.f$0, 4);
                return;
            case 3:
                DefaultSpecialEffectsController.TransitionEffect transitionEffect = (DefaultSpecialEffectsController.TransitionEffect) this.f$0;
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Transition for all operations has completed");
                }
                ArrayList arrayList = transitionEffect.transitionInfos;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((DefaultSpecialEffectsController.TransitionInfo) obj).operation.completeEffect(transitionEffect);
                }
                return;
            default:
                ArrayList arrayList2 = ((FragmentManager) this.f$0).mBackStackChangeListeners;
                int size2 = arrayList2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList2.get(i2);
                    i2++;
                    ((FragmentManager.OnBackStackChangedListener) obj2).onBackStackChangeCancelled();
                }
                return;
        }
    }
}
