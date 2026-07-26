package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import androidx.navigation.Navigation;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.transition.Transition;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* loaded from: classes.dex */
public final class SavedStateViewModelFactory implements ViewModelProvider.Factory {
    public final Application application;
    public final Bundle defaultArgs;
    public final ViewModelProvider.AndroidViewModelFactory factory;
    public final Lifecycle lifecycle;
    public final SavedStateRegistry savedStateRegistry;

    public SavedStateViewModelFactory() {
        this.factory = new ViewModelProvider.AndroidViewModelFactory(null);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras) {
        Constructor constructor;
        LinkedHashMap linkedHashMap = mutableCreationExtras.extras;
        String str = (String) linkedHashMap.get(ViewModelProvider.VIEW_MODEL_KEY);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        } else if (linkedHashMap.get(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY) != null && linkedHashMap.get(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY) != null) {
            Application application = (Application) linkedHashMap.get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY);
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (!isAssignableFrom || application == null) {
                constructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE);
            } else {
                constructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE);
            }
            if (constructor == null) {
                return this.factory.create(cls, mutableCreationExtras);
            }
            return (!isAssignableFrom || application == null) ? SavedStateViewModelFactory_androidKt.newInstance(cls, constructor, SavedStateHandleSupport.createSavedStateHandle(mutableCreationExtras)) : SavedStateViewModelFactory_androidKt.newInstance(cls, constructor, application, SavedStateHandleSupport.createSavedStateHandle(mutableCreationExtras));
        } else if (this.lifecycle != null) {
            return create(cls, str);
        } else {
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
    }

    public SavedStateViewModelFactory(Application application, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory;
        this.savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        this.lifecycle = savedStateRegistryOwner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        if (application != null) {
            if (ViewModelProvider.AndroidViewModelFactory._instance == null) {
                ViewModelProvider.AndroidViewModelFactory._instance = new ViewModelProvider.AndroidViewModelFactory(application);
            }
            androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory._instance;
            Intrinsics.checkNotNull(androidViewModelFactory);
        } else {
            androidViewModelFactory = new ViewModelProvider.AndroidViewModelFactory(null);
        }
        this.factory = androidViewModelFactory;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras) {
        return create(RangesKt.getJavaClass(classReference), mutableCreationExtras);
    }

    public final ViewModel create(Class cls, String str) {
        Constructor constructor;
        AutoCloseable autoCloseable;
        Application application;
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle != null) {
            boolean isAssignableFrom = AndroidViewModel.class.isAssignableFrom(cls);
            if (!isAssignableFrom || this.application == null) {
                constructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.VIEWMODEL_SIGNATURE);
            } else {
                constructor = SavedStateViewModelFactory_androidKt.findMatchingConstructor(cls, SavedStateViewModelFactory_androidKt.ANDROID_VIEWMODEL_SIGNATURE);
            }
            if (constructor != null) {
                SavedStateRegistry savedStateRegistry = this.savedStateRegistry;
                Intrinsics.checkNotNull(savedStateRegistry);
                SavedStateHandle createHandle = SavedStateHandleSupport.createHandle(savedStateRegistry.consumeRestoredStateForKey(str), this.defaultArgs);
                SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, createHandle);
                savedStateHandleController.attachToLifecycle(savedStateRegistry, lifecycle);
                Lifecycle.State state = ((LifecycleRegistry) lifecycle).state;
                if (state == Lifecycle.State.INITIALIZED || state.compareTo(Lifecycle.State.STARTED) >= 0) {
                    savedStateRegistry.runOnNextRecreation();
                } else {
                    lifecycle.addObserver(new DefaultLifecycleObserverAdapter(lifecycle, 1, savedStateRegistry));
                }
                ViewModel newInstance = (!isAssignableFrom || (application = this.application) == null) ? SavedStateViewModelFactory_androidKt.newInstance(cls, constructor, createHandle) : SavedStateViewModelFactory_androidKt.newInstance(cls, constructor, application, createHandle);
                newInstance.getClass();
                ViewModelImpl viewModelImpl = newInstance.impl;
                if (viewModelImpl == null) {
                    return newInstance;
                }
                if (viewModelImpl.isCleared) {
                    ViewModelImpl.closeWithRuntimeException(savedStateHandleController);
                    return newInstance;
                }
                synchronized (viewModelImpl.lock) {
                    autoCloseable = (AutoCloseable) viewModelImpl.keyToCloseables.put("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
                }
                ViewModelImpl.closeWithRuntimeException(autoCloseable);
                return newInstance;
            } else if (this.application != null) {
                return this.factory.create(cls);
            } else {
                if (Transition.C01101._instance == null) {
                    Transition.C01101._instance = new Transition.C01101(10);
                }
                Intrinsics.checkNotNull(Transition.C01101._instance);
                return Navigation.createViewModel(cls);
            }
        } else {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return create(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
