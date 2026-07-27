package androidx.lifecycle;

import android.os.Bundle;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda1;
import androidx.activity.ComponentActivity$$ExternalSyntheticLambda2;
import androidx.core.p002os.BundleKt;
import androidx.navigation.Navigation;
import androidx.savedstate.SavedStateRegistry;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {
    public boolean restored;
    public Bundle restoredState;
    public final SavedStateRegistry savedStateRegistry;
    public final SynchronizedLazyImpl viewModel$delegate;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "savedStateRegistry");
        this.savedStateRegistry = savedStateRegistry;
        this.viewModel$delegate = new SynchronizedLazyImpl(new ComponentActivity$$ExternalSyntheticLambda1(1, viewModelStoreOwner));
    }

    public final SavedStateHandlesVM getViewModel() {
        return (SavedStateHandlesVM) this.viewModel$delegate.getValue();
    }

    public final void performRestore() {
        if (!this.restored) {
            Bundle consumeRestoredStateForKey = this.savedStateRegistry.consumeRestoredStateForKey("androidx.lifecycle.internal.SavedStateHandlesProvider");
            Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
            Bundle bundle = this.restoredState;
            if (bundle != null) {
                bundleOf.putAll(bundle);
            }
            if (consumeRestoredStateForKey != null) {
                bundleOf.putAll(consumeRestoredStateForKey);
            }
            this.restoredState = bundleOf;
            this.restored = true;
            getViewModel();
        }
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(new Pair[0], 0));
        Bundle bundle = this.restoredState;
        if (bundle != null) {
            bundleOf.putAll(bundle);
        }
        for (Map.Entry entry : getViewModel().handles.entrySet()) {
            String str = (String) entry.getKey();
            Bundle saveState = ((ComponentActivity$$ExternalSyntheticLambda2) ((SavedStateHandle) entry.getValue()).impl.mCertificates).saveState();
            if (!saveState.isEmpty()) {
                Navigation.m654putSavedStateimpl(bundleOf, str, saveState);
            }
        }
        this.restored = false;
        return bundleOf;
    }
}
