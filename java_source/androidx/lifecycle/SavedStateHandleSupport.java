package androidx.lifecycle;

import android.os.Bundle;
import androidx.collection.internal.Lock;
import androidx.core.p002os.BundleKt;
import androidx.core.provider.FontRequest;
import androidx.emoji2.text.MetadataRepo;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.transition.Transition;
import androidx.transition.ViewUtilsApi21;
import java.util.Arrays;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.collections.EmptyMap;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
/* loaded from: classes.dex */
public abstract class SavedStateHandleSupport {
    public static final ViewUtilsApi21 SAVED_STATE_REGISTRY_OWNER_KEY = new Object();
    public static final Lock VIEW_MODEL_STORE_OWNER_KEY = new Object();
    public static final Transition.C01101 DEFAULT_ARGS_KEY = new Transition.C01101(9);

    public static final void attachHandleIfNeeded(ViewModel viewModel, SavedStateRegistry registry, Lifecycle lifecycle) {
        AutoCloseable autoCloseable;
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        ViewModelImpl viewModelImpl = viewModel.impl;
        if (viewModelImpl != null) {
            synchronized (viewModelImpl.lock) {
                autoCloseable = (AutoCloseable) viewModelImpl.keyToCloseables.get("androidx.lifecycle.savedstate.vm.tag");
            }
        } else {
            autoCloseable = null;
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) autoCloseable;
        if (savedStateHandleController != null && !savedStateHandleController.isAttached) {
            savedStateHandleController.attachToLifecycle(registry, lifecycle);
            Lifecycle.State state = ((LifecycleRegistry) lifecycle).state;
            if (state == Lifecycle.State.INITIALIZED || state.compareTo(Lifecycle.State.STARTED) >= 0) {
                registry.runOnNextRecreation();
            } else {
                lifecycle.addObserver(new DefaultLifecycleObserverAdapter(lifecycle, 1, registry));
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [androidx.lifecycle.SavedStateHandle, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6, types: [androidx.lifecycle.SavedStateHandle, java.lang.Object] */
    public static SavedStateHandle createHandle(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = bundle2;
        }
        if (bundle == null) {
            ?? obj = new Object();
            new LinkedHashMap();
            obj.impl = new FontRequest(EmptyMap.INSTANCE);
            return obj;
        }
        ClassLoader classLoader = SavedStateHandle.class.getClassLoader();
        Intrinsics.checkNotNull(classLoader);
        bundle.setClassLoader(classLoader);
        MapBuilder mapBuilder = new MapBuilder(bundle.size());
        for (String str : bundle.keySet()) {
            Intrinsics.checkNotNull(str);
            mapBuilder.put(str, bundle.get(str));
        }
        mapBuilder.checkIsMutable$kotlin_stdlib();
        mapBuilder.isReadOnly = true;
        if (mapBuilder.size <= 0) {
            mapBuilder = MapBuilder.Empty;
            Intrinsics.checkNotNull(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        }
        ?? obj2 = new Object();
        new LinkedHashMap();
        obj2.impl = new FontRequest(mapBuilder);
        return obj2;
    }

    public static final SavedStateHandle createSavedStateHandle(CreationExtras creationExtras) {
        SavedStateHandlesProvider savedStateHandlesProvider;
        Intrinsics.checkNotNullParameter(creationExtras, "<this>");
        SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) creationExtras.get(SAVED_STATE_REGISTRY_OWNER_KEY);
        if (savedStateRegistryOwner != null) {
            ViewModelStoreOwner viewModelStoreOwner = (ViewModelStoreOwner) creationExtras.get(VIEW_MODEL_STORE_OWNER_KEY);
            if (viewModelStoreOwner != null) {
                Bundle bundle = (Bundle) creationExtras.get(DEFAULT_ARGS_KEY);
                String str = (String) creationExtras.get(ViewModelProvider.VIEW_MODEL_KEY);
                if (str != null) {
                    SavedStateRegistry.SavedStateProvider savedStateProvider = savedStateRegistryOwner.getSavedStateRegistry().getSavedStateProvider();
                    Bundle bundle2 = null;
                    if (savedStateProvider instanceof SavedStateHandlesProvider) {
                        savedStateHandlesProvider = (SavedStateHandlesProvider) savedStateProvider;
                    } else {
                        savedStateHandlesProvider = null;
                    }
                    if (savedStateHandlesProvider != null) {
                        LinkedHashMap linkedHashMap = getSavedStateHandlesVM(viewModelStoreOwner).handles;
                        SavedStateHandle savedStateHandle = (SavedStateHandle) linkedHashMap.get(str);
                        if (savedStateHandle != null) {
                            return savedStateHandle;
                        }
                        savedStateHandlesProvider.performRestore();
                        Bundle bundle3 = savedStateHandlesProvider.restoredState;
                        if (bundle3 != null && bundle3.containsKey(str)) {
                            Bundle bundle4 = bundle3.getBundle(str);
                            if (bundle4 == null) {
                                bundle4 = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
                            }
                            bundle3.remove(str);
                            if (bundle3.isEmpty()) {
                                savedStateHandlesProvider.restoredState = null;
                            }
                            bundle2 = bundle4;
                        }
                        SavedStateHandle createHandle = createHandle(bundle2, bundle);
                        linkedHashMap.put(str, createHandle);
                        return createHandle;
                    }
                    throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final void enableSavedStateHandles(SavedStateRegistryOwner savedStateRegistryOwner) {
        Lifecycle.State state = ((LifecycleRegistry) savedStateRegistryOwner.getLifecycle()).state;
        if (state != Lifecycle.State.INITIALIZED && state != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.");
        } else if (savedStateRegistryOwner.getSavedStateRegistry().getSavedStateProvider() == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(savedStateRegistryOwner.getSavedStateRegistry(), (ViewModelStoreOwner) savedStateRegistryOwner);
            savedStateRegistryOwner.getSavedStateRegistry().registerSavedStateProvider("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            savedStateRegistryOwner.getLifecycle().addObserver(new SavedStateHandleAttacher(0, savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesVM getSavedStateHandlesVM(ViewModelStoreOwner viewModelStoreOwner) {
        CreationExtras extras;
        Transition.C01101 factory = new Transition.C01101(8);
        if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            extras = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras();
        } else {
            extras = CreationExtras.Empty.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(extras, "extras");
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStoreOwner.getViewModelStore(), factory, extras);
        return (SavedStateHandlesVM) ((MetadataRepo) viewModelProvider.impl).getViewModel$lifecycle_viewmodel_release(Reflection.getOrCreateKotlinClass(SavedStateHandlesVM.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }
}
